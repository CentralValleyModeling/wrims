package evaluators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;


import wresl.ConvertWreslLexer;
import wresl.ConvertWreslParser;

public class FileParser {
	
	private static CharStream stream;	
	public String scope;
//	public String format;
	public String kind;
	public String units;
	public String expression;

//	public ArrayList<String> caseName;
//	public ArrayList<String> caseCondition;
//	public ArrayList<String> caseExpression;
	
	public FileParser(){
		scope="undefined";
//		format="undefined";
		kind="undefined";
		units="undefined";
		expression="undefined";


	}

	public static ConvertWreslParser parseFile(String inputFilePath) throws RecognitionException, IOException {
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
		    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		return parser;
		
	}

	public static Dataset processFileIntoDataset(String inputFilePath, String scope) throws RecognitionException, IOException {
		
		ConvertWreslParser parser = parseFile(inputFilePath);
		
		Map<String, Dataset> fileDataMap   = new HashMap<String, Dataset>();
		Map<String, Dataset> modelAdhocMap = new HashMap<String, Dataset>();
		
		Dataset out = new Dataset();
		out = Tools.convertStructToDataset(parser.F);
		
		if (scope == "local"){
			out =Tools.convertDatasetToLocal(out);
		}	
		else if (scope == "global"){ /* Do nothing */ }
		else { ErrMsg.print("Wrong scope: "+scope+ " for file: ", inputFilePath);}
		
		
		fileDataMap.put(inputFilePath, out);
		
		if ( ! parser.F.model_list.isEmpty()){
			ErrMsg.print("Model exists in this file.", inputFilePath);
		}	
		
		return out;
	}

	public static Map<String,Dataset> processNestedFileIntoDatasetMap(String inputFilePath, String scope) throws RecognitionException, IOException {
		
		Dataset mainData = processFileIntoDataset(inputFilePath, scope);
		
		Map<String,Dataset> out = new HashMap<String, Dataset>();
		out.put(inputFilePath, mainData);
		
		for (String file : mainData.incFileList){
			
			String subscope;
			if (scope == "local") {subscope = "local";} // main file scope overrides subfile scope
			else {subscope = mainData.incFileMap.get(file).scope;}
			
			Dataset each = processFileIntoDataset(file,subscope);
			out.put(file, each);
		}
		
		return out;		
	}
	
	public static Map<String,Dataset> processFileListIntoDatasetMap(Dataset obj) throws RecognitionException, IOException {
		
		ArrayList<String> inputFilePathList =  obj.incFileList;
		
		Map<String,Dataset> out = new HashMap<String, Dataset>() ;
		
		for (String inputFilePath : inputFilePathList) {
			
			Map<String,Dataset> each = new HashMap<String, Dataset>();
			String scope = obj.incFileMap.get(inputFilePath).scope;
			each = processNestedFileIntoDatasetMap(inputFilePath, scope);
			
			out.putAll(each);
		}
		
		return out;
	}	

	public static PairMap processFileIntoPair(String inputFilePath, String scope) throws RecognitionException, IOException {
		
		ConvertWreslParser parser = parseFile(inputFilePath);
		
		Map<String, Dataset> fileDataMap   = new HashMap<String, Dataset>();
		Map<String, Dataset> modelAdhocMap = new HashMap<String, Dataset>();
		
		Dataset dataset = new Dataset();
		dataset = Tools.convertStructToDataset(parser.F);
		
		if (scope == "local"){
			dataset =Tools.convertDatasetToLocal(dataset);
		}	
		else if (scope == "global"){}
		else { System.out.println(" error in processFile scope!!");}
		
		
		fileDataMap.put(inputFilePath, dataset);
		
		if ( ! parser.F.model_list.isEmpty()){
			
			modelAdhocMap.putAll( Tools.convertStructMapToDatasetMap(parser.modelMap) );
		}	
		
		PairMap pairOut = new PairMap(fileDataMap, modelAdhocMap);
		return pairOut;
	}

	public static PairMap processNestedFileIntoPair(String inputFilePath, String scope) throws RecognitionException, IOException {
				
		PairMap mainPair = processFileIntoPair(inputFilePath, scope);
		PairMap out = new PairMap().add(processFileIntoPair(inputFilePath, scope));
		
		for (String file : mainPair.fileDataMap.get(inputFilePath).incFileList){
			
			String subscope;
			if (scope == "local") {subscope = "local";}
			else {subscope = mainPair.fileDataMap.get(inputFilePath).incFileMap.get(file).scope;}
			
			PairMap each = processFileIntoPair(file,subscope);
			out.add(each);
		}
		
		return out;		
	}
	
	public static Map<String,PairMap> processFileListIntoMapOfPair(Dataset obj) throws RecognitionException, IOException {
		
		ArrayList<String> inputFilePathList =  obj.incFileList;
		
		Map<String,PairMap> out = new HashMap<String, PairMap>() ;
		
		for (String inputFilePath : inputFilePathList) {
			
			PairMap pair = new PairMap();
			String scope = obj.incFileMap.get(inputFilePath).scope;
			pair = processNestedFileIntoPair(inputFilePath, scope);
			
			out.put(inputFilePath, pair);

		}
		
		return out;
	}	
}
	

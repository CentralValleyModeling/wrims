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
	
	public static PairMap processFile(String inputFilePath, String scope) throws RecognitionException, IOException {
		
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

	public static PairMap processNestedFile(String inputFilePath, String scope) throws RecognitionException, IOException {
				
		PairMap mainPair = processFile(inputFilePath, scope);
		PairMap out = new PairMap().add(processFile(inputFilePath, scope));
		
		for (String file : mainPair.fileDataMap.get(inputFilePath).incFileList){
			
			String subscope;
			if (scope == "local") {subscope = "local";}
			else {subscope = mainPair.fileDataMap.get(inputFilePath).incFileMap.get(file).scope;}
			
			PairMap each = processFile(file,subscope);
			out.add(each);
		}
		
		return out;
		
		
	}
	
	public static Map<String,PairMap> processFileListIntoMap(Dataset obj) throws RecognitionException, IOException {
		
		ArrayList<String> inputFilePathList =  obj.incFileList;
		
		Map<String,PairMap> out = new HashMap<String, PairMap>() ;
		
		for (String inputFilePath : inputFilePathList) {
			
			PairMap pair = new PairMap();
			String scope = obj.incFileMap.get(inputFilePath).scope;
			pair = processNestedFile(inputFilePath, scope);
			
			out.put(inputFilePath, pair);

		}
		
		return out;
	}	
}
	

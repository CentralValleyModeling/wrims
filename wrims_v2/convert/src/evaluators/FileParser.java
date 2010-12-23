package evaluators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
	
	public static PairMap processMainFile(String inputFilePath) throws RecognitionException, IOException {
		
		Map<String, Dataset> fileDataMap   = new HashMap<String, Dataset>();
		Map<String, Dataset> modelAdhocMap = new HashMap<String, Dataset>();
		
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
		
		Dataset dataset = new Dataset();
		dataset = Tools.convertStructToDataset(parser.F);
		fileDataMap.put(inputFilePath, dataset);
		
		if ( ! parser.F.model_list.isEmpty()){
			
			modelAdhocMap.putAll( Tools.convertStructMapToDatasetMap(parser.modelMap) );
		}	
		
		PairMap pairOut = new PairMap(fileDataMap, modelAdhocMap);
		return pairOut;
	}
	
	public static PairMap processFileList(Dataset obj) throws RecognitionException, IOException {
		
		Map<String, Dataset> fileDataMap   = new HashMap<String, Dataset>();
		Map<String, Dataset> modelAdhocMap = new HashMap<String, Dataset>();
		
		ArrayList<String> inputFilePathList =  obj.incFileList;
		
		for (String inputFilePath : inputFilePathList) {

			try {
				stream = new ANTLRFileStream(inputFilePath, "UTF8");
			} catch (Exception e) {
				e.printStackTrace();
			}

			ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
			parser.currentFilePath = inputFilePath;
			parser.evaluator();

			Dataset dataset = new Dataset();
			dataset = Tools.convertStructToDataset(parser.F);
			
			if (obj.incFileList_local.contains(inputFilePath)){
				dataset =Tools.convertDatasetToLocal(dataset);
			}			
		
			fileDataMap.put(inputFilePath, dataset);
			
			if ( ! parser.F.model_list.isEmpty()){
				
				modelAdhocMap.putAll( Tools.convertStructMapToDatasetMap(parser.modelMap) );
			
			}			
		}
		PairMap outPair = new PairMap(fileDataMap, modelAdhocMap);
		return outPair;
	}
}
	

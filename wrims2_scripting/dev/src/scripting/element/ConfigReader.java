package scripting.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.testng.Assert;
import org.testng.annotations.Test;

import scripting.grammar.ConfigSimpleLexer;
import scripting.grammar.ConfigSimpleParser;



public class ConfigReader {
	
	private static CharStream stream;	


	public ConfigReader(){

	}
	
	public static ArrayList<String> getConfigKeyList(){
		
		ArrayList<String> out = new ArrayList<String>();
		

		out.add("MainFile");
		out.add("Solver");   
		out.add("InitFile");
		out.add("InitFPart");
		out.add("SvarFile");
		out.add("SvarAPart");
		out.add("SvarFPart");
		out.add("DvarFile");                   
		out.add("GroundWaterDir");
		out.add("TimeStep");
		out.add("StartYear"); 
		out.add("StartMonth");
		out.add("StartDay");
		out.add("EndYear");
		out.add("EndMonth");
		out.add("EndDay");
		out.add("ShowWreslLog");
		
		return out;
		
		
	}
	//@Test( groups = { "config" } )
	public static Map<String, String> parseFile(String inputFilePath) throws RecognitionException  {		

		//String inputFilePath = "D:\\cvwrsm\\trunk\\wrims2_scripting\\studies\\callite_svn47\\CONV\\Run\\CONV.config";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         //e.printStackTrace();
	         System.out.println("Config file not found! "+ inputFilePath);
	         
	        }
		    
		ConfigSimpleLexer lexer = new ConfigSimpleLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);		

		ConfigSimpleParser parser = new ConfigSimpleParser(tokenStream);
		

		parser.configFile();
		
		//System.out.println(parser.cMap);
		
		Map<String, String> configMap = new HashMap<String, String>();

		//Assert.assertEquals(0, 1);
		
//		for (String k : parser.cMap.keySet()) {
//			
//			configMap.put(k.toLowerCase(), parser.cMap.get(k));			
//		
//		}
		
		configMap = parser.cMap;
		
		return configMap;
		

	}	


}
	

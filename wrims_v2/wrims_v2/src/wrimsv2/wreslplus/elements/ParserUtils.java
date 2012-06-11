package wrimsv2.wreslplus.elements;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.grammar.WreslPlusLexer;
import wrimsv2.wreslplus.grammar.WreslPlusParser;

public class ParserUtils {
	

	
	private ParserUtils(){}


	public static WreslPlusParser initParser(String inputFilePath) throws RecognitionException  {		

		// inputFilePath should be checked and converted to CanonicalPath before this method
		
		CharStream stream;
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         //e.printStackTrace();
	         LogUtils.errMsg("File not found: "+ inputFilePath);
	         LogUtils.closeLogFile();
	         return null;
	        }
		    
		WreslPlusLexer lexer = new WreslPlusLexer(stream);
		
		TokenStream tokenStream = new CommonTokenStream(lexer);		
		
		WreslPlusParser parser = new WreslPlusParser(tokenStream);
		
		parser.currentAbsolutePath = new File(inputFilePath).getAbsolutePath(); 
		parser.currentAbsoluteParent = new File(inputFilePath).getAbsoluteFile().getParent();
		parser.pathRelativeToRunDir = ResourceUtils.getRelativePath(parser.currentAbsolutePath, GlobalData.runDir, "\\");
		
		LogUtils.importantMsg("Parsing file: "+parser.currentAbsolutePath);
		
		return parser;
		
	}


	public static StudyTemp parseWreslMain(String inputFilePath) {
		
		
		WreslPlusParser parser = null;
		
		try {
			parser = initParser(inputFilePath);
			parser.wreslMain();
		}
		catch (RecognitionException e) {
	
			e.printStackTrace();
		}
		
		parser.styObj.absPath = parser.currentAbsolutePath;
		parser.styObj.relativePath = parser.pathRelativeToRunDir;
		parser.styObj.runDir = parser.currentAbsoluteParent;
		
		return parser.styObj;
		
	}


	public static ModelTemp parseWreslFile(String inputFilePath) {
		
		
		WreslPlusParser parser = null;
		
		try {
			parser = initParser(inputFilePath);
			parser.wreslFile();
		}
		catch (RecognitionException e) {
	
			e.printStackTrace();
		}
		
		return parser.mObj;
		
	}


	public static void parseAllIncFile(ArrayList<String> relativePathList , StudyTemp st) {
	
			for (String relativePath: relativePathList){
				
				//ModelTemp fm = null;
				
				if (!st.fileModelNameMap.keySet().contains(relativePath)){
	
					String absPath = Tools.checkPath(new File(st.runDir, relativePath).getAbsolutePath());
					ModelTemp fm = parseWreslFile(absPath);
					
					ErrorCheck.checkVarRedefined(fm);	
	
					ToLowerCase.convert(fm);		
					Procedures.processIncFilePath(fm);
					Procedures.processSvIncFileList(fm);
					Procedures.processT_svList(fm);
					Procedures.processDependants(fm);
					
					// TODO: allow multiple models in a file
					String modelName = fm.id.toLowerCase();
					//System.out.println("err: modelName: "+fm.id);
					ArrayList<String> modelNameList = new ArrayList<String>();
					modelNameList.add(modelName);
					
					st.fileModelNameMap.put(relativePath, modelNameList);
					
					st.fileModelDataTable.put(relativePath, modelName, fm);
					
					// parse all included files within files
					parseAllIncFile(fm.incFileRelativePathList, st);
					
				} 				
				
			}
			
		}


//	public static void parseAllIncFile(Map<String,IncFileTemp> incfmap , StudyTemp st) {
//	
//		for (String f: incfmap.keySet()){
//			
//			String relativePath = incfmap.get(f).pathRelativeToRunDir;
//			
//			if (!st.fileModelNameMap.keySet().contains(relativePath)){
//	
//				ModelTemp fm = parseWreslFile(incfmap.get(f).absPath);
//				
//				ErrorCheck.checkVarRedefined(fm);	
//				ToLowerCase.convert(fm);		
//				
//				Procedures.processIncFilePath(fm);	
//				Procedures.processDependants(fm);
//				
//				
//				// TODO: allow multiple models in a file
//				String modelName = fm.id.toLowerCase();
//				ArrayList<String> modelNameList = new ArrayList<String>();
//				modelNameList.add(modelName);
//				
//				st.fileModelNameMap.put(relativePath, modelNameList);
//				
//				st.fileModelDataTable.put(relativePath, modelName, fm);
//				
//				// parse all included files within files
//				parseAllIncFile(fm.incFileMap, st);
//				
//			}
//		}
//		
//	}


	public static void setRunDir(String runDir){
		
		GlobalData.runDir = Tools.checkPath(runDir);;
	}



}
	

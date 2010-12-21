package test.convertWresl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wresl.ConvertWreslLexer;
import wresl.ConvertWreslParser;

import org.testng.annotations.*;
import org.testng.Assert;

import evaluators.Dataset;
import evaluators.FileParser;
import evaluators.PairMap;
import evaluators.Struct;
import evaluators.Svar;
import evaluators.Dvar;
import evaluators.Tools;
import evaluators.WriteCSV;



//import evaluators.Demo;

public class TestConvertWreslToTable {

	public String inputFilePath;
	public String outputFilePath;
	public PrintWriter outFile;
	public BufferedWriter outputFile;


	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelOneLevel_case1() throws RecognitionException, IOException {
 
		PairMap pair;
		
		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelOneLevel_case1.wresl";

		pair = FileParser.processFile(mainFilePath); 
		
		/// process included files in this parsed file
		pair.add(FileParser.processFileList(pair.fileDataMap.get(mainFilePath).incFileList)); 
						
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		for ( String model : pair.modelAdhocMap.keySet()){
			
			/// process included files in this model
			pair.add(FileParser.processFileList(pair.modelAdhocMap.get(model).incFileList)); 
			
			System.out.println( "include models in main file: processModel="+ model );
			Dataset model_data_complete = new Dataset();			
			
			model_data_complete.add(pair.modelAdhocMap.get(model));
			for (String includedFile : pair.modelAdhocMap.get(model).incFileList){
				
				model_data_complete.add(pair.fileDataMap.get(includedFile));	

			}
			model_data_complete_map.put(model, model_data_complete);		
		}		
		
		String outFolder ="test-csv\\TestConvertWreslToTable_processModelOneLevel_case1\\" ;
		String expectedFolder ="src\\test\\expected\\TestConvertWreslToTable_processModelOneLevel_case1\\" ;
		
		Tools.deleteDir(outFolder);
		
		System.out.println( "in complete map: "+ model_data_complete_map.keySet() );
		WriteCSV.dataset(model_data_complete_map.get("advanced"),mainFilePath,outFolder);	    
				
		Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);
		Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);
		
		Assert.assertEquals(actual,expected);
	}	

	@Test(groups = { "WRESL_to_Table"  })
	public void processModelOneLevel_case2() throws RecognitionException, IOException {
 
		PairMap pair;
		
		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelOneLevel_case2.wresl";

		pair = FileParser.processFile(mainFilePath); 
		
		/// process included files in this parsed file
		pair.add(FileParser.processFileList(pair.fileDataMap.get(mainFilePath).incFileList)); 
						
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		for ( String model : pair.modelAdhocMap.keySet()){
			
			/// process included files in this model
			pair.add(FileParser.processFileList(pair.modelAdhocMap.get(model).incFileList)); 
			
			System.out.println( "include models in main file: processModel="+ model );
			Dataset model_data_complete = new Dataset();			
			
			model_data_complete.add(pair.modelAdhocMap.get(model));
			for (String includedFile : pair.modelAdhocMap.get(model).incFileList){
				
				model_data_complete.add(pair.fileDataMap.get(includedFile));	

			}
			model_data_complete_map.put(model, model_data_complete);		
		}		
		
		String outFolder ="test-csv\\TestConvertWreslToTable_processModelOneLevel_case2\\" ;
		String expectedFolder ="src\\test\\expected\\TestConvertWreslToTable_processModelOneLevel_case2\\" ;
		
		Tools.deleteDir(outFolder);
		
		System.out.println( "in complete map: "+ model_data_complete_map.keySet() );
		WriteCSV.dataset(model_data_complete_map.get("advanced"),mainFilePath,outFolder);	    
				
		Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);
		Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);
		
		Assert.assertEquals(actual,expected);
	}	
	
	
	@Test(groups = { "WRESL_to_Table"  })
	public void processModelTwoLevel_case1() throws RecognitionException, IOException {
 
		PairMap pair;
		
		String mainFilePath = "src\\test\\TestConvertWreslToTable_processModelTwoLevel_case1.wresl";

		pair = FileParser.processFile(mainFilePath); 

		System.out.println( " include files in test: twoLevel="+ pair.fileDataMap.keySet() );		
		System.out.println( "include models in test: twoLevel="+ pair.modelAdhocMap.keySet() );
		
		/// process included files in this parsed file
		pair.add(FileParser.processFileList(pair.fileDataMap.get(mainFilePath).incFileList)); 
						
		Map<String, Dataset> model_data_complete_map =  new HashMap<String, Dataset>();
		
		for ( String model : pair.modelAdhocMap.keySet()){
			
			/// process included files in this model
			pair.add(FileParser.processFileList(pair.modelAdhocMap.get(model).incFileList)); 
			
			System.out.println( "include models in main file: processModel="+ model );
			Dataset model_data_complete = new Dataset();			
			
			model_data_complete.add(pair.modelAdhocMap.get(model));
			for (String includedFile : pair.modelAdhocMap.get(model).incFileList){
				
				model_data_complete.add(pair.fileDataMap.get(includedFile));	

			}
			model_data_complete_map.put(model, model_data_complete);		
		}		
		
		String outFolder ="test-csv\\TestConvertWreslToTable_processModelTwoLevel_case1\\" ;
		String expectedFolder ="src\\test\\expected\\TestConvertWreslToTable_processModelTwoLevel_case1\\" ;
		
		Tools.deleteDir(outFolder);
		
		System.out.println( "in complete map: "+ model_data_complete_map.keySet() );
		WriteCSV.dataset(model_data_complete_map.get("advanced"),mainFilePath,outFolder);	    
				
		Map<String, String> actual = Tools.readFilesFromDirAsMap(outFolder);
		Map<String, String> expected = Tools.readFilesFromDirAsMap(expectedFolder);
		
		Assert.assertEquals(actual,expected);
	}	
	
	
	
}

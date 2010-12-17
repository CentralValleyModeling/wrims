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
import java.util.Set;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wresl.ConvertWreslLexer;
import wresl.ConvertWreslParser;

import org.testng.annotations.*;
import org.testng.Assert;

import evaluators.Alias;
import evaluators.Dataset;
import evaluators.Dvar;
import evaluators.FileParser;
import evaluators.Goal;
import evaluators.IncludeFile;
import evaluators.Struct;
import evaluators.Svar;
import evaluators.Tools;
import evaluators.WriteCSV;


public class TestConvertWresl {

	public String inputFilePath;
	private static CharStream stream;	
	
	@Test(groups = { "WRESL_elements" })
	public void sample()
	{
		Assert.assertEquals(1,1);
        //System.out.println("@Test(groups = { "WRESL_elements" }) sample: 1==1");
	}

	@Test(groups = { "WRESL_elements" })
	public void sequence() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestConvertWresl_sequence.wresl";
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Map<Integer, String>  expected = new HashMap<Integer, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected.put(1, "SJRBASE" );
		expected.put(2, "SJR_WQ1");
		
		Assert.assertEquals(parser.F.model_order_map, expected);
	}	

	@Test(groups = { "WRESL_elements" })
	public void includeFile() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_includeFile.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    Struct expected_struct = new Struct();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
				
		
		Map<String,IncludeFile>  incFileMap = new HashMap<String,IncludeFile>(); 

		IncludeFile incFile;
		
		incFile = new IncludeFile();
		incFile.scope = "local";
		incFileMap.put("..\\..\\common\\System\\System_Sac.wresl", incFile);

		incFile = new IncludeFile();
		incFile.scope = "global";
		incFileMap.put("..\\..\\common\\System\\SystemTables_Sac\\constraints-seepage_cycle7.wresl", incFile);

		expected_struct.incFileMap.putAll(incFileMap);
							
		ArrayList<String> actual_keys = new ArrayList<String>();
		ArrayList<String> expected_keys = new ArrayList<String>();
		
		expected_keys.addAll(expected_struct.incFileMap.keySet());
		actual_keys.addAll(parser.F.incFileMap.keySet());
		
		Collections.sort(expected_keys);
		Collections.sort(actual_keys);
		
		Assert.assertEquals(actual_keys, expected_keys);

//		System.out.println("expected_keys:"+ expected_keys);
//		System.out.println("actual_keys:"+ actual_keys);
		
		for (String k : expected_keys) {
				
				Assert.assertEquals(parser.F.incFileMap.get(k).equalEva(), expected_struct.incFileMap.get(k).equalEva());
			
		}
		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void modelList() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelList.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    
	    ArrayList<String>  expected_model_list = new ArrayList<String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		

		expected_model_list.add("one");
		expected_model_list.add("TWO");
		expected_model_list.add("Three");		
		

		Assert.assertEquals(parser.F.model_list, expected_model_list);
		//Assert.assertEquals(parser.F.file_include_file, expected_file_include_file);
	}
	
	@Test(groups = { "WRESL_elements" })
	public void modelIncludeFile() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelIncludeFile.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct = new Struct();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		

		Map<String,IncludeFile>  incFileMap = new HashMap<String,IncludeFile>(); 

		IncludeFile incFile;
		
		incFile = new IncludeFile();
		incFile.scope = "local";
		incFileMap.put("..\\..\\common\\System\\System_Sac.wresl", incFile);

		incFile = new IncludeFile();
		incFile.scope = "global";
		incFileMap.put("..\\..\\common\\System\\SystemTables_Sac\\constraints-seepage_cycle7.wresl", incFile);

		expected_struct.incFileMap.putAll(incFileMap);
		
		expected_modelMap.put("CVCWHEELING",expected_struct);
					
		ArrayList<String> actual_keys = new ArrayList<String>();
		ArrayList<String> expected_keys = new ArrayList<String>();
		
		expected_keys.addAll(expected_modelMap.keySet());
		actual_keys.addAll(parser.modelMap.keySet());
		
		Collections.sort(expected_keys);
		Collections.sort(actual_keys);
		
		Assert.assertEquals(actual_keys, expected_keys);

//		System.out.println("expected_keys:"+ expected_keys);
//		System.out.println("actual_keys:"+ actual_keys);
		
		for (String k : expected_keys) {

//			System.out.println("actual_keySet:  "+parser.modelMap.get(k).incFileMap.keySet());
//			System.out.println("expected_keySet:  "+expected_modelMap.get(k).incFileMap.keySet());
			
			for (String f : expected_modelMap.get(k).incFileMap.keySet()){
				
				//System.out.println("actual:  "+parser.modelMap.get(k).incFileMap.get(f).equalEva());
			    //System.out.println("expected:"+expected_modelMap.get(k).incFileMap.get(f).equalEva());
				Assert.assertEquals(parser.modelMap.get(k).incFileMap.get(f).equalEva(), expected_modelMap.get(k).incFileMap.get(f).equalEva());
			}
		}	
	
	}
			
	
	@Test(groups = { "WRESL_elements" })
	public void modelVarAdhoc() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelVarAdhoc.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct = new Struct();

	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
	    
		Goal gl = new Goal();
		gl.scope = "local";
		gl.caseName.add("default");
		gl.caseCondition.add("always");
		gl.caseExpression.add("C607>500");
		expected_struct.gMap.put("force_c607",gl);

		Alias as = new Alias();
		as.scope = "global";
		as.units = "CFS";
		as.expression = "D419_swp[monthlyweighted5]";
		expected_struct.asMap.put("D419_swpC6",as);
		
		expected_modelMap.put("CVCWHEELING",expected_struct);
		
		for ( String model : expected_modelMap.keySet() ) {
			
			for ( String key : expected_modelMap.get(model).gMap.keySet() ){
				
				//System.out.println("expected: "+key+":::"+expected_modelMap.get(model).gMap.get(key).equalEva() );
				//System.out.println("actual:   "+key+":::"+parser.modelMap.get(model).gMap.get(key).equalEva() );				
				Assert.assertEquals(parser.modelMap.get(model).gMap.get(key).equalEva(), expected_modelMap.get(model).gMap.get(key).equalEva());
			}

			for ( String key : expected_modelMap.get(model).asMap.keySet() ){
			
				//System.out.println("expected: "+key+":::"+expected_modelMap.get(model).asMap.get(key).equalEva() );
				//System.out.println("actual:   "+key+":::"+parser.modelMap.get(model).asMap.get(key).equalEva() );
				Assert.assertEquals(parser.modelMap.get(model).asMap.get(key).equalEva(), expected_modelMap.get(model).asMap.get(key).equalEva());
			}
		}
	}	

	@Test(groups = { "WRESL_elements" })
	public void modelBasic() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelBasic.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct1 = new Struct();
	    Struct expected_struct2 = new Struct();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		IncludeFile incF;
		
		incF = new IncludeFile();
		incF.scope = "local";
		expected_struct1.incFileMap.put("..\\..\\common\\System\\System_Sac.wresl", incF);
		
		incF = new IncludeFile();
		incF.scope = "global";
		expected_struct1.incFileMap.put("..\\..\\common\\System\\SystemTables_Sac\\constraints-seepage_cycle7.wresl", incF);		
		
		Goal gl = new Goal();
		gl.scope = "local";
		gl.caseName.add("default");
		gl.caseCondition.add("always");
		gl.caseExpression.add("C607>500");
		expected_struct1.gMap.put("force_c607",gl);

		Alias as = new Alias();
		as.scope = "global";
		as.units = "CFS";
		as.expression = "D419_swp[monthlyweighted5]";
		expected_struct1.asMap.put("D419_swpC6",as);
		
		expected_modelMap.put("CVCWHEELING",expected_struct1);
		
		
		gl = new Goal();
		gl.scope = "local";
		gl.caseName.add("default");
		gl.caseCondition.add("always");
		gl.caseExpression.add("C607>500");
		expected_struct2.gMap.put("test_goal",gl);
		
		expected_modelMap.put("model2",expected_struct2);
		
		for ( String model : expected_modelMap.keySet() ) {

			for ( String key : expected_modelMap.get(model).incFileMap.keySet() ){
				
//				System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).incFileMap.get(key).equalEva() );
//				System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).incFileMap.get(key).equalEva() );				
				Assert.assertEquals(parser.modelMap.get(model).incFileMap.get(key).equalEva(), expected_modelMap.get(model).incFileMap.get(key).equalEva());
			}
			
			for ( String key : expected_modelMap.get(model).gMap.keySet() ){
				
//				System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).gMap.get(key).equalEva() );
//				System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).gMap.get(key).equalEva() );				
				Assert.assertEquals(parser.modelMap.get(model).gMap.get(key).equalEva(), expected_modelMap.get(model).gMap.get(key).equalEva());
			}

			for ( String key : expected_modelMap.get(model).asMap.keySet() ){
			
//				System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).asMap.get(key).equalEva() );
//				System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).asMap.get(key).equalEva() );
				Assert.assertEquals(parser.modelMap.get(model).asMap.get(key).equalEva(), expected_modelMap.get(model).asMap.get(key).equalEva());
			}			

		}		
	}			

	@Test(groups = { "WRESL_elements" })
	public void modelSvarCase() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelSvarCase.wresl";
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

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct = new Struct();
		
		Svar sv = new Svar();
		sv.scope = "global";

		sv.caseName.add("Febfore");
		sv.caseCondition.add("month==FEB");
		sv.caseExpression.add("select FEB from sacramento_runoff_forecast where wateryear=wateryear");
		
		sv.caseName.add("JuntoJan");
		sv.caseCondition.add("always");
		sv.caseExpression.add("0");
	
		expected_struct.svMap.put("frcst_sac",sv);
		
		expected_modelMap.put("svcase",expected_struct);	
		
		for ( String model : expected_modelMap.keySet() ) {

			for ( String key : expected_modelMap.get(model).svMap.keySet() ){
				
				//System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).svMap.get(key).equalEva() );
				//System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).svMap.get(key).equalEva() );				
				Assert.assertEquals(parser.modelMap.get(model).svMap.get(key).equalEva(), expected_modelMap.get(model).svMap.get(key).equalEva());
			}		
		}		
	}		

	@Test(groups = { "WRESL_elements" })
	public void modelReadFromFile() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_modelReadFromFile.wresl";
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

	    Map<String, Struct> expected_modelMap = new HashMap<String, Struct>();
	    Struct expected_struct1 = new Struct();
		
		IncludeFile incF;
		
		incF = new IncludeFile();
		incF.scope = "local";
		expected_struct1.incFileMap.put("..\\..\\common\\System\\System_Sac.wresl", incF);
			
		Goal gl = new Goal();
		gl.scope = "local";
		gl.caseName.add("default");
		gl.caseCondition.add("always");
		gl.caseExpression.add("C607>500");
		expected_struct1.gMap.put("force_c607",gl);

		Alias as = new Alias();
		as.scope = "global";
		as.units = "CFS";
		as.expression = "D419_swp[monthlyweighted5]";
		expected_struct1.asMap.put("D419_swpC6",as);
		
		expected_modelMap.put("CVCWHEELING",expected_struct1);
				
		ArrayList<String> modelInFile =  parser.F.model_list; 
		ArrayList<String> expected_models = new ArrayList<String>();
		expected_models.addAll(expected_modelMap.keySet());
		
		Collections.sort(modelInFile);
		Collections.sort(expected_models);
		
		Assert.assertEquals(modelInFile, expected_models);
		
		for ( String model : expected_modelMap.keySet() ) {

			for ( String key : expected_modelMap.get(model).incFileMap.keySet() ){
				
				//System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).incFileMap.get(key).equalEva() );
				//System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).incFileMap.get(key).equalEva() );				
				Assert.assertEquals(parser.modelMap.get(model).incFileMap.get(key).equalEva(), expected_modelMap.get(model).incFileMap.get(key).equalEva());
			}
			
			for ( String key : expected_modelMap.get(model).gMap.keySet() ){
				
//				System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).gMap.get(key).equalEva() );
//				System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).gMap.get(key).equalEva() );				
				Assert.assertEquals(parser.modelMap.get(model).gMap.get(key).equalEva(), expected_modelMap.get(model).gMap.get(key).equalEva());
			}

			for ( String key : expected_modelMap.get(model).asMap.keySet() ){
			
//				System.out.println("expected: "+model+"="+key+":::"+expected_modelMap.get(model).asMap.get(key).equalEva() );
//				System.out.println("actual:   "+model+"="+key+":::"+parser.modelMap.get(model).asMap.get(key).equalEva() );
				Assert.assertEquals(parser.modelMap.get(model).asMap.get(key).equalEva(), expected_modelMap.get(model).asMap.get(key).equalEva());
			}			
		}		
	}		

	@Test(groups = { "WRESL_elements" })
	public void modelAdvanced_readStructFromIncludeFile() throws RecognitionException, IOException {
		

		Dataset dataset_each_file; 


		ArrayList<String> file_list = new ArrayList<String>();
		ArrayList<String> model_list = new ArrayList<String>();

			
		Map<String, ArrayList<String>> file_model_map = new HashMap<String, ArrayList<String>> ();
		
		Map<String, Dataset> file_data_map = new HashMap<String, Dataset>(); 
		
		Map<String, Dataset> model_data_map = new HashMap<String, Dataset>() ;
		Map<String, Dataset> model_data_map_complete = new HashMap<String, Dataset>(); 
		
		
		
		String mainFilePath = "src\\test\\TestConvertWresl_modelAdvanced_readStructFromIncludeFile.wresl";
		
		ConvertWreslParser parser = FileParser.parseFile(mainFilePath); 


		dataset_each_file = new Dataset();
		dataset_each_file.addStruct(parser.F);

		
		file_data_map.put(mainFilePath, dataset_each_file);
		file_list.add(mainFilePath);
		
		if ( ! file_data_map.get(mainFilePath).model_list.isEmpty()){
		model_data_map.putAll( Tools.convertStructMapToDataMap(parser.modelMap) );
		model_list.addAll(file_data_map.get(mainFilePath).model_list);
		}
		
		file_model_map.put(mainFilePath, model_list);
		
		System.out.println( file_data_map.get(mainFilePath).model_list );
		
		
		/// collect complete data for each model
		for ( String model : file_data_map.get(mainFilePath).model_list ) {

			System.out.println(model_data_map.get(model).incFileList );
			System.out.println(model_data_map.get(model).incFileMap.keySet() );
			
	
			/// for each include file in the model
			Dataset dataset_each_model = new Dataset();
			/// add initial data
			dataset_each_model.add(model_data_map.get(model));
			
			for ( String filePath : model_data_map.get(model).incFileList ) {
				
				/// new container for each include file
				dataset_each_file = new Dataset();
				System.out.println("TTT:   "+model+"="+filePath+":::"+model_data_map.get(model).incFileMap.get(filePath).equalEva() );				
				
				parser = FileParser.parseFile(filePath); 
				dataset_each_file.addStruct(parser.F);				
				dataset_each_model.addStruct(parser.F);
				
				file_data_map.put(filePath, dataset_each_file);
				file_list.add(filePath);
			}
			
			/// put detailed data 
			System.out.println("what's the model: "+model );
			model_data_map_complete.put(model, dataset_each_model);
		}

		System.out.println("what's in the model: "+model_data_map_complete.get("advanced").svList );
		
		String outFolder ="test-csv\\" ;
				
//		outputFilePath ="test-csv\\sv.csv";
//		outFile = Tools.openFile(outputFilePath);
//		outFile.print(WriteCSV.svar_header+"\n");
		
		WriteCSV.dataset(model_data_map_complete.get("advanced"),mainFilePath,outFolder);
	    
				
		
		Assert.assertEquals(1,2);
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void svarConst() throws RecognitionException, IOException {
		
		inputFilePath ="src\\test\\TestConvertWresl_svarConst.wresl";
		
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

		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
	
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add(".29"); 
		/// add 1st key
		expected_svMap.put("minflow_C_Orovl", sv);
		svList.add("minflow_C_Orovl");
		
		for (String k : expected_svMap.keySet()) {
			
				//System.out.println(k+":::"+parser.F.svMap.get(k).equalEva());				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}			
	}	

	@Test(groups = { "WRESL_elements" })
	public void svarSum() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_svarSum.wresl";
		
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
	
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add("sum(i=0; SEP-month; 1) max(I_Orovl(i); dummy)*cfs_taf(i)"); 
		/// add 1st key
		expected_svMap.put("OroInfEst", sv);
		svList.add("OroInfEst");
		
		for (String k : expected_svMap.keySet()) {
			
			//System.out.println(k+":::"+parser.F.svMap.get(k).equalEva());				
			Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}			
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void svarExpression() throws RecognitionException, IOException {
		
		inputFilePath = "src\\test\\TestConvertWresl_svarExpression.wresl";
		
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
	
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add("(A_Orovl_forward-A_Orovl_back)/(100*max(0.01; S_Orovl(-1)))"); 
		/// add 1st key
		expected_svMap.put("coefev_Orovl", sv);
		svList.add("coefev_Orovl");

		/// 2nd sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add("min(max(a; b); 2.5)"); 
		/// add 2nd key
		expected_svMap.put("min_test", sv);
		svList.add("min_test");
		
		for (String k : expected_svMap.keySet()) {
			
				//System.out.println(k+":::"+parser.F.svMap.get(k).equalEva());				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}			

	}
	
	@Test(groups = { "WRESL_elements" })
	public void dvarStd() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarStd.wresl";
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
				
	    Map<String, Dvar> expected_dvMap = new HashMap<String, Dvar>(); 
	    Dvar dv;
		
		dv = new Dvar();
		dv.scope = "global";
		dv.kind = "FLOW-CHANNEL";
		dv.units = "CFS";
		dv.lowerBound="0";
		dv.upperBound="unbounded";
		
		expected_dvMap.put("C_Tracy",dv);

		dv = new Dvar();
		dv.scope = "global";
		dv.kind = "FLOW-CHANNEL";
		dv.units = "TAF";
		dv.lowerBound="0";
		dv.upperBound="unbounded";
		
		expected_dvMap.put("C_Banks",dv);
		
		for (String key : expected_dvMap.keySet()){
			
			//System.out.println("expected:  "+key+"::"+expected_dvMap.get(key).equalEva());
			//System.out.println("actual  :  "+key+"::"+parser.F.dvMap.get(key).equalEva());
			Assert.assertEquals(parser.F.dvMap.get(key).equalEva(), expected_dvMap.get(key).equalEva());		
		}
	}	

	@Test(groups = { "WRESL_elements" })
	public void alias() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_alias.wresl";
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

	    Map<String, Alias> expected_asMap = new HashMap<String, Alias>(); 
	    Alias as;
		
		as = new Alias();
		as.scope = "global";
		as.kind = "flow-channel";
		as.units = "CFS";
		as.expression = "C_SacFea+D_SacFea";
		
		expected_asMap.put("QsacFth",as);

		as = new Alias();
		as.scope = "local";
		as.units = "CFS";
		as.expression = "D419_swp[monthlyweighted5]";
		
		expected_asMap.put("D419_swpC6",as);
		
		for (String key : expected_asMap.keySet()){
			
			//System.out.println("expected:  "+key+"::"+expected_asMap.get(key).equalEva());
			//System.out.println("actual  :  "+key+"::"+parser.F.asMap.get(key).equalEva());
			Assert.assertEquals(parser.F.asMap.get(key).equalEva(), expected_asMap.get(key).equalEva());		
		}
	}	



	@Test(groups = { "WRESL_elements" })
	public void defineLocal() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_defineLocal.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }
	    //String[] array;
	    //ArrayList<String> list;
	    Map<String, ArrayList<String>>  expected_dvar_alias = new HashMap<String, ArrayList<String>>();
	    Map<String, String>  expected_svar_expression = new HashMap<String, String> ();
	    Map<String, String> expected_svar_scope = new HashMap<String, String>();
	    Map<String, String> expected_dvar_scope = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected_dvar_alias.put("D419_swpC6", new ArrayList<String>(Arrays.asList(new String[]{null,"CFS","D419_swp[monthlyweighted5]"})));
		expected_svar_expression.put("minflow_C", "60");
		
		expected_dvar_scope.put("D419_swpC6", "global");
		expected_svar_scope.put("minflow_C", "local");
		
		//Assert.assertEquals(1, 2);
		Assert.assertEquals(parser.F.svar_scope, expected_svar_scope);
		Assert.assertEquals(parser.F.dvar_scope, expected_dvar_scope);
		
		Assert.assertEquals(parser.F.dvar_alias, expected_dvar_alias);
		Assert.assertEquals(parser.F.svar_expression, expected_svar_expression);
		
		
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void dvarNonStd() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_dvarNonStd.wresl";
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

	    Map<String, Dvar> expected_dvMap = new HashMap<String, Dvar>(); 
	    Dvar dv;
		
		dv = new Dvar();
		dv.scope = "global";
		dv.kind = "FLOW-CHANNEL";
		dv.units = "CFS";
		dv.lowerBound="unbounded";
		dv.upperBound="unbounded";
		
		expected_dvMap.put("C_SLCVP",dv);

		dv = new Dvar();
		dv.scope = "local";
		dv.kind = "FLOW-CHANNEL";
		dv.units = "CFS";
		dv.lowerBound="0";
		dv.upperBound="6150*taf_cfs";
		
		expected_dvMap.put("C_SacFea",dv);
		
		for (String key : expected_dvMap.keySet()){
			
			//System.out.println("expected:  "+key+"::"+expected_dvMap.get(key).equalEva());
			//System.out.println("actual  :  "+key+"::"+parser.F.dvMap.get(key).equalEva());
			Assert.assertEquals(parser.F.dvMap.get(key).equalEva(), expected_dvMap.get(key).equalEva());		
		}
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarDSS() throws RecognitionException, IOException {
		inputFilePath = "src\\test\\TestConvertWresl_svarDSS.wresl";
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
		
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		sv.format = "timeseries";
		sv.kind = "EVAPORATION-RATE";
		sv.units = "IN";
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add("timeseries"); 
		/// add 1st key
		expected_svMap.put("evap_S_Orovl", sv);
		svList.add("evap_S_Orovl");
		
		ArrayList<String> allKeys = new ArrayList<String>();
		allKeys.addAll(expected_svMap.keySet());
		allKeys.addAll(parser.F.svMap.keySet());
		
		for (String k : allKeys) {
			
				//System.out.println(expected_svMap.get(k));
				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}
	}	
	
	@Test(groups = { "WRESL_elements" })
	public void svarTable() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarTable.wresl";
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
	
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		sv.format = "lookup_table";
		/// 1st case
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add("select target from feather_fish_203 where month=NOV"); 
		/// add 1st key
		expected_svMap.put("nov_trigger_cfs", sv);
		svList.add("nov_trigger_cfs");
		
		for (String k : expected_svMap.keySet()) {
			
				//System.out.println(k+":::"+parser.F.svMap.get(k).equalEva());				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}			
	}	

	@Test(groups = { "WRESL_elements" })
	public void svarTableFull() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarTableFull.wresl";
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
	
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		sv.format = "lookup_table";
		/// 1st case
		sv.caseName.add("default");
		sv.caseCondition.add("always");
		sv.caseExpression.add("select area from res_info given storage=1000*S_Orovl(-1) use linear where res_num=6"); 
		/// add 1st key
		expected_svMap.put("A_Orovl_last", sv);
		svList.add("A_Orovl_last");
		
		for (String k : expected_svMap.keySet()) {
			
				//System.out.println(k+":::"+parser.F.svMap.get(k).equalEva());				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}	
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarTableMultipleWhere() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarTableMultipleWhere.wresl";
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, ArrayList<String>>  expected = new HashMap<String, ArrayList<String>>();
	    Map<String, String>  expected_scope = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();
		
		expected_scope.put("S_TrntyLevel4","global");
		expected.put("S_TrntyLevel4", new ArrayList<String>(Arrays.asList(new String[]{
			"select","target","from","res_level","given",null,"use",null,"where","res_num=1","level=4","month=month" })));
		        //     "target"       ,"res_level"        ,null      ,null        ,"res_num=1","level=4","month=month",null 
		
		Assert.assertEquals(parser.F.svar_table, expected);
		Assert.assertEquals(parser.F.svar_scope, expected_scope);		
	}		

	@Test(groups = { "WRESL_elements" })
	public void svarCaseNew() throws RecognitionException, IOException {
		inputFilePath ="src\\test\\TestConvertWresl_svarCaseNew.wresl";
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
		
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("Febfore");
		sv.caseCondition.add("month==FEB");
		sv.caseExpression.add("select FEB from sacramento_runoff_forecast where wateryear=wateryear"); 
		/// 2nd case
		sv.caseName.add("JuntoJan");
		sv.caseCondition.add("always");
		sv.caseExpression.add("0"); 
		/// add 1st key
		expected_svMap.put("frcst_sac", sv);
		svList.add("frcst_sac");
		
		/// 2nd sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("MAR_SEP");
		sv.caseCondition.add("month>=MAR .and. month<=SEP");
		sv.caseExpression.add("sum(i=-(month-MAY); SEP-month) I_Folsm(i)*cfs_taf(i)+I300(i)*cfs_taf(i)"); 
		/// 2nd case
		sv.caseName.add("other");
		sv.caseCondition.add("always");
		sv.caseExpression.add("0.0"); 
		/// add 2nd key
		expected_svMap.put("AmerFrcstInflow", sv);
		svList.add("AmerFrcstInflow");
		
		ArrayList<String> allKeys = new ArrayList<String>();
		allKeys.addAll(expected_svMap.keySet());
		allKeys.addAll(parser.F.svMap.keySet());		

		for (String k : allKeys) {
	
				//System.out.println(expected_svMap.get(k));				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}			
	}	

	@Test(groups = { "WRESL_elements" })
	public void svarCaseMultipleAnds() throws RecognitionException, IOException {
	
		inputFilePath = "src\\test\\TestConvertWresl_svarCaseMultipleAnds.wresl";	
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
		
		Svar sv;
		ArrayList<String> svList =  new ArrayList<String>();
		Map<String, Svar> expected_svMap = new HashMap<String, Svar>();
		
		/// 1st sv
		sv = new Svar();
		sv.scope = "global";
		/// 1st case
		sv.caseName.add("JanFebCMin");
		sv.caseCondition.add("month>=JAN .and. month<=FEB .and. sri_ytp==5 .and. C_Nimbus_fmp_mif(-1)<800.");
		sv.caseExpression.add("max(250.; min(1750.; (0.85*C_Nimbus_fmp_mif(-1))))"); 
		/// add 1st key
		expected_svMap.put("minflowFMPAmer", sv);
		svList.add("minflowFMPAmer");		
		
		ArrayList<String> allKeys = new ArrayList<String>();
		allKeys.addAll(expected_svMap.keySet());
		allKeys.addAll(parser.F.svMap.keySet());		

		for (String k : expected_svMap.keySet()) {	
				//System.out.println(k+":::"+expected_svMap.get(k).equalEva());				
				Assert.assertEquals(parser.F.svMap.get(k).equalEva(), expected_svMap.get(k).equalEva());
		}	
	}			

	@Test(groups = { "WRESL_elements" })
	public void goalSimple() throws RecognitionException, IOException {
	
		inputFilePath = "src\\test\\TestConvertWresl_goalSimple.wresl";	
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Goal> expected_gMap = new HashMap<String, Goal>(); 
	    Goal g;
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		g = new Goal();
		g.scope = "global";
		g.caseName.add("default");
		g.caseCondition.add("always");
		g.caseExpression.add("C5_WTS=C5_WTS_Stg1+C5_WTS_Stg2");
		expected_gMap.put("split_C5_WTS", g);
		
		g = new Goal();
		g.scope = "global";
		g.caseName.add("default");
		g.caseCondition.add("always");
		g.caseExpression.add("C5_WTS=C5_WTS_Stg1");
		expected_gMap.put("C_SLCVP", g);
		
		g = new Goal();
		g.scope = "global";
		g.caseName.add("default");
		g.caseCondition.add("always");
		g.caseExpression.add("b=c");
		expected_gMap.put("a1", g);

		g = new Goal();
		g.scope = "local";
		g.caseName.add("default");
		g.caseCondition.add("always");
		g.caseExpression.add("b>c");
		expected_gMap.put("a2", g);

		g = new Goal();
		g.scope = "global";
		g.caseName.add("default");
		g.caseCondition.add("always");
		g.caseExpression.add("b<c");
		expected_gMap.put("a3", g);
				
		
		ArrayList<String> actual_keys = new ArrayList<String>();
		ArrayList<String> expected_keys = new ArrayList<String>();
		
		expected_keys.addAll(expected_gMap.keySet());
		actual_keys.addAll(parser.F.gMap.keySet());
		
		Collections.sort(expected_keys);
		Collections.sort(actual_keys);
		Assert.assertEquals(actual_keys, expected_keys);

		for (String k : expected_keys) {
				//System.out.println("expected:"+ expected_gMap.get(k).equalEva());
				//System.out.println("actual:  "+parser.F.gMap.get(k).equalEva());
				Assert.assertEquals(parser.F.gMap.get(k).equalEva(), expected_gMap.get(k).equalEva());
		}	
	}			

	@Test(groups = { "WRESL_elements" })
	public void goalNoCase() throws RecognitionException, IOException {
	
		inputFilePath = "src\\test\\TestConvertWresl_goalNoCase.wresl";	
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Goal> expected_gMap = new HashMap<String, Goal>(); 
	    Goal g;
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		g = new Goal();
		g.scope = "global";
		g.lhs = "C3_MIF";
		g.caseName.add("default");
		g.caseCondition.add("always");
		g.caseExpression.add("minflow_C3b2");
		g.case_lhs_gt_rhs.add("constrain");
		g.case_lhs_lt_rhs.add("700.0");
		expected_gMap.put("b2action1Whi_1", g);				
		
		ArrayList<String> actual_keys = new ArrayList<String>();
		ArrayList<String> expected_keys = new ArrayList<String>();
		
		expected_keys.addAll(expected_gMap.keySet());
		actual_keys.addAll(parser.F.gMap.keySet());
		
		Collections.sort(expected_keys);
		Collections.sort(actual_keys);

		//System.out.println("...."+expected_keys);
		Assert.assertEquals(actual_keys, expected_keys);

		for (String k : expected_keys) {
				//System.out.println("expected:"+ k+":::"+expected_gMap.get(k).equalEva());
				//System.out.println("actual:  "+ k+":::"+parser.F.gMap.get(k).equalEva());
				Assert.assertEquals(parser.F.gMap.get(k).equalEva(), expected_gMap.get(k).equalEva());
		}	
	}			

	@Test(groups = { "WRESL_elements" })
	public void goalCase() throws RecognitionException, IOException {
	
		inputFilePath = "src\\test\\TestConvertWresl_goalCase.wresl";	
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, Goal> expected_gMap = new HashMap<String, Goal>(); 
	    Goal g;
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		parser.currentFilePath = inputFilePath; parser.evaluator();

		g = new Goal();
		
		g.scope = "global";
		g.lhs   = "C3_MIF";
		g.caseName.add("Action1WhiOn");
		g.caseCondition.add("int(B2Action1WhiOn)==1");
		g.caseExpression.add("minflow_C3b2");
		g.case_lhs_gt_rhs.add("constrain");
		g.case_lhs_lt_rhs.add("700.");
		
		g.caseName.add("Action1WhiOff");
		g.caseCondition.add("int(B2Action1WhiOn)==0");
		g.caseExpression.add("clear_min");
		g.case_lhs_gt_rhs.add("constrain");
		g.case_lhs_lt_rhs.add("0");		
		
		expected_gMap.put("b2action1Whi_1", g);				
		
		ArrayList<String> actual_keys = new ArrayList<String>();
		ArrayList<String> expected_keys = new ArrayList<String>();
		
		expected_keys.addAll(expected_gMap.keySet());
		actual_keys.addAll(parser.F.gMap.keySet());
		
		Collections.sort(expected_keys);
		Collections.sort(actual_keys);
		Assert.assertEquals(actual_keys, expected_keys);

		for (String k : expected_keys) {
				//System.out.println("expected:"+ expected_gMap.get(k).equalEva());
				//System.out.println("actual:  "+parser.F.gMap.get(k).equalEva());
				Assert.assertEquals(parser.F.gMap.get(k).equalEva(), expected_gMap.get(k).equalEva());
		}	
	}		
	
	@Test(groups = { "WRESL_elements" })
	public void minMaxInlines() throws RecognitionException, IOException {
		
		inputFilePath =  "src\\test\\TestConvertWresl_minMaxInlines.wresl";
		
		try {
			stream = new ANTLRFileStream(inputFilePath, "UTF8");
			}
	    catch(Exception e) {
	         e.printStackTrace();
	        }

	    Map<String, String>  expected = new HashMap<String, String>();
	    
		ConvertWreslLexer lexer = new ConvertWreslLexer(stream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		ConvertWreslParser parser = new ConvertWreslParser(tokenStream);
		
		parser.currentFilePath = inputFilePath; parser.evaluator();

		expected.put("a", "min(1000.+0.5*max(S_Orovl(prevSep)-1000.; 0.); S_OrovlLevel5)");
		
		Assert.assertEquals(parser.F.svar_expression, expected);	
	}	
}

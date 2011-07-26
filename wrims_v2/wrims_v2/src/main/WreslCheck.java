
package main;

import java.io.File;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;

import wrimsv2.commondata.wresldata.StudyDataSet;
import wrimsv2.components.Versions;
import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslparser.elements.StudyConfig;
import wrimsv2.wreslparser.elements.StudyParser;
import wrimsv2.wreslparser.elements.TempData;
import wrimsv2.wreslparser.elements.WriteCSV;

public class WreslCheck {
		
	private static String inputFilePath;
	private static String logFileName;	
	private static String csvFolderPath;
		

	public static void main(String[] args) throws RecognitionException, IOException {

		Versions vers = new Versions();
		int svn_version = vers.getSVN();
		
		if ( svn_version < 1 ){		
		
			System.out.println("Jar corrupted. ");
		
		} else if ( args.length>1 || args.length<1 ){
			
			//System.out.println("Usage 1:  java -jar WreslCheck.jar \"path to main wresl file\" ");
			System.out.println("Usage:  java -cp WreslCheck.jar main.WreslCheck \"path to main wresl file\" ");
			
		} else if (args[0].equalsIgnoreCase("version")) {
			
			System.out.println("Wresl Study Check Tool ( svn: "+svn_version+" )");
			
		} else {
			
			parseWresl(args[0]);
			
		}
	}

	public static String parseWresl(String mainWreslFile) {
		
		String errMessage="";
		String m = mainWreslFile;
		File validatedAbsFile = null;

		if (m.length()<7){
			errMessage = "This is not a Wresl file.";
			System.out.println(errMessage);
			return errMessage;
		}
		
		String extension = m.substring(m.length() - 5);
		
		if (!extension.equalsIgnoreCase("wresl")){
			errMessage = "This is not a Wresl file.";
			System.out.println(errMessage);
			return errMessage;
		}
		
		try {
			validatedAbsFile = new File(mainWreslFile).getAbsoluteFile();
			if(!validatedAbsFile.exists()){
				errMessage = "File not found.";
				System.out.println(errMessage);
				return errMessage;
			}
			String absFilePath = validatedAbsFile.getCanonicalPath().toLowerCase();
		}
		catch (Exception e){
			e.printStackTrace();
			errMessage = e.getMessage();
			return errMessage;
		}
		
		

		try {
			parseWresl(validatedAbsFile, false);
		}
		catch (Exception e) {
			errMessage = e.getMessage();
			e.printStackTrace();
			return errMessage;
		}

		return errMessage;	
	}
	
	private static void parseWresl(File ValidatedAbsFile, boolean filePathCheck) throws RecognitionException, IOException {
						
				
				//inputFilePath = "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\examples\\CALSIM30_051711_BO\\CONV\\Run\\mainCONV_30.wresl";
				
				//ValidatedAbsFile = new File(inputFilePath).getAbsoluteFile();
				String absFilePath = ValidatedAbsFile.getCanonicalPath().toLowerCase();
				
				File parentFolder = ValidatedAbsFile.getParentFile();
				String absParentFolder = parentFolder.getCanonicalPath().toLowerCase();
				
				inputFilePath = absFilePath;
				csvFolderPath = absParentFolder+"\\=WreslCheck_csv=";
				logFileName = "=WreslCheck=.log";
				
				//System.out.println("absParentFolder: "+absParentFolder);
				
				
			try {				
				/// temporary dataset, don't use this because the structure will be changed soon. 
				LogUtils.setLogFile(absParentFolder,logFileName);
				
				Versions vers = new Versions();
				int svn_version = vers.getSVN();
			    LogUtils.importantMsg("============================================");
				LogUtils.importantMsg("Wresl Study Check Tool ( svn: "+svn_version+" )");
			    LogUtils.importantMsg("============================================");
				
				TempData td = new TempData();
				StudyConfig sc = StudyParser.processMainFileIntoStudyConfig(absFilePath);
				td.model_dataset_map=StudyParser.parseModels(sc,td);
				LogUtils.closeLogFile();
				
				
				/// write to StudyDataSet
				StudyDataSet sd = StudyParser.writeWreslData(sc, td); 
						
				/// write full study data to csv files
				WriteCSV.study(sd, csvFolderPath ) ;
				
			}
			catch (Exception e){
				e.printStackTrace();	
			}
			
		}
		
	
	
}

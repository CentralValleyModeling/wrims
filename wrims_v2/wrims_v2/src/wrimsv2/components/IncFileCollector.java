package wrimsv2.components;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.apache.commons.io.FileUtils;

import wrimsv2.wreslparser.elements.LogUtils;
import wrimsv2.wreslplus.elements.IncFileSimple;
import wrimsv2.wreslplus.elements.ResourceUtils;
import wrimsv2.wreslplus.grammar.IncFileFinderLexer;
import wrimsv2.wreslplus.grammar.IncFileFinderParser;

public class IncFileCollector {
	
	public static LinkedHashSet<String> incFileList_all;
	private static ArrayList<IncFileSimple> tempList ;
	private static String baseDir; // this is the parent of run folder, e.g., baseDir="d:\study" if main wresl is d:\study\run\main.wresl
	private static String mainFilePath;
	private static String logFileName = "=FileCollector=.log";
	
	public IncFileCollector(String[] args){
		
		// args[0] is main wresl file absolute path
		// args[1] is optional. If specified, this is the target folder where all the include files will be copied into.
					
		initialize(args);
		collect();
		
		// if the target folder (second argument) is specified, 
		// then the inc files will be copy to the target folder.
		if (args.length >1 ) {
			String targetDir = args[1];
			copyAllWreslFilesTo(targetDir);
		}
	}
	
	public static void initialize(String[] args){
		
		mainFilePath = args[0];	
		
		try {
			LogUtils.setLogFile(new File(mainFilePath).getParentFile().getCanonicalPath(), logFileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		baseDir= new File(mainFilePath).getParentFile().getParent();
		
		incFileList_all = new LinkedHashSet<String>();
		incFileList_all.add(mainFilePath);
		
	}
	
	public static void collect() {
		
		// call initialize() before using collect()
		
		ArrayList<IncFileSimple> ifs_array = new ArrayList<IncFileSimple>();
		ifs_array.add(new IncFileSimple(mainFilePath));

		searchIncFiles(ifs_array);
		
		for (String s: incFileList_all){
			System.out.println(s);
		}
		
	}
		
	public static void searchIncFiles(ArrayList<IncFileSimple> ifs_array){
		
		for (IncFileSimple ifs : ifs_array) {
		
			tempList = parseWresl(ifs);
			
			for (IncFileSimple fs: tempList){
				incFileList_all.add(fs.absPath);
			}
			
			if (tempList.size()>0) {	
			
				searchIncFiles(tempList);
			
			} 
		}
	}
	
	public static ArrayList<IncFileSimple> parseWresl(IncFileSimple ifs) {
		
		IncFileFinderParser parser = null;
		
		LogUtils.importantMsg("Parsing file: "+ifs.absPath);
			
		try {
			parser= initParser(ifs);
			if (parser !=null){
				parser.wreslFile();
			} else {
				System.exit(1);
			}
			return parser.incFileSimpleList;
			
		}
		catch (RecognitionException e) {
	
			e.printStackTrace();
		}		
		
		return null;
	}
	
	public static IncFileFinderParser initParser(IncFileSimple ifs) throws RecognitionException  {		
		
		CharStream stream;
		
		try {
			stream = new ANTLRFileStream(ifs.absPath, "UTF8");
		} catch (IOException e) {
			LogUtils.errMsgLocation(ifs.fromWresl, ifs.line, "File not found: "+ifs.absPath);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		    
		IncFileFinderLexer lexer = new IncFileFinderLexer(stream);
		
		TokenStream tokenStream = new CommonTokenStream(lexer);		
		
		IncFileFinderParser parser = new IncFileFinderParser(tokenStream);
				
		try {
			parser.currentAbsolutePath = new File(ifs.absPath).getCanonicalPath().toLowerCase();
			parser.currentAbsoluteParent = new File(ifs.absPath).getCanonicalFile().getParent().toLowerCase();
			//String pathRelativeToRunDir = ResourceUtils.getRelativePath(parser.currentAbsoluteParent, GlobalData.runDir, File.separator);			
			
			lexer.currentAbsolutePath = parser.currentAbsolutePath;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return parser;
		
	}
	
	private static void copyAllWreslFilesTo(String targetDir) {	
		
		File targetDirF = new File(targetDir);
		
		try {
			LogUtils.importantMsg("Wresl files will be copied to: "+ targetDirF.getCanonicalPath());
		} catch (IOException e1) {
			targetDirF.mkdirs();
		}
		
		for (String s: incFileList_all){
			
			String relativePath = ResourceUtils.getRelativePath(s, baseDir, File.separator);
			
			try {
				File targetPath = new File(targetDir,relativePath);
				FileUtils.copyFile(new File(s), targetPath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public static void main(String[] args){
		
		args = new String[2];
		
		new IncFileCollector(args);
		
	}

}
parser grammar FileIncludeParser;

options {
  language = Java;
  tokenVocab = FileIncludeLexer;
}

@header {
  package wresl;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.Arrays;
  import evaluators.Struct;
  import evaluators.Tools;  
}


@members {

	public Struct F = new Struct();	
	//public ArrayList<Model> modelList = new ArrayList<Model>();

	/// temp variables 
 	public ArrayList<String> fileList;
	
	/// temp variables 
 	private ArrayList<String> list;

	/// error message
	public String currentFilePath;
	public ArrayList<String> outputErrorMessage = new ArrayList<String>();
	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		String msg = super.getErrorMessage(e, tokenNames);
			msg = msg+" in file \""+currentFilePath+"\"";
			if (msg!=null){outputErrorMessage.add(msg);}
			return msg;
			}
}

evaluator 
	:	 includes EOF  ;

includes
	:  .* include*   ;

include
	:   INCLUDE filePath .* ; 

filePath
	:	 PATH  ;



grammar ConfigSimple;
//import CommonLexer;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header {
  package scripting.grammar;
  import java.util.Map;
  import java.util.LinkedHashMap;
}
@lexer::header {
  package scripting.grammar;
}

@members {
      //public CommonTree commonTree;
      public Map<String, String> cMap = new LinkedHashMap<String, String>();
      public Map<String, ArrayList<String>> transferMap = new LinkedHashMap<String, ArrayList<String>>();
      //public ArrayList<String> varList = new ArrayList<String>();
      public ArrayList<String> t = new ArrayList<String>();
}


dssTransfer : ENDLINE* 'Begin' 'DssTransfer' ENDLINE+ 

			( c=transferItem  
				{ 
				
				  //varList.add($c.key);
				  	
				  if (transferMap.containsKey($c.key)){
					transferMap.get($c.key).add($c.val);
				  } else {
				    t = new ArrayList<String>();
				    t.add($c.val);
				    transferMap.put($c.key, t);
				  } 
				} 
				)+  
			'End' 'DssTransfer' //{ System.out.println( cMap); }
			
			; 
			
transferItem returns[String key, String val ]
	: 

    k=ID  v=pair     ENDLINE+
   { $key=$k.text.toUpperCase(); $val=$v.text;  }
   //{ System.out.println($k.text); System.out.println($v.text); }
   ;

pair : ID('-'|ID)*  '/' ID('-'|ID)* ; 
   
configFile : ENDLINE* 'Begin' 'Config' ENDLINE+ 
			( c=configItem  { cMap.put($c.key, $c.val); } )+  
			'End' 'Config' //{ System.out.println( cMap); }
			
			;


configItem returns[String key, String val ]
	: 

    k=configKey  v=anything     ENDLINE+
   { $key=$k.text; $val=$v.text;  }
   //{ System.out.println($k.text); System.out.println($v.text); }
   ;



//anything: .+;

anything:  INT? ( ID | '.' | '-' | '\"' | '\\' )* ;

//solverName : ID ;
//fileName:  ID '.' ID ;
//dssPartID : INT? ( ID | '-' )* ;
//timeStepValue : INT? ID ;
//
//
//path_literal : '\"'  .+ '\"' ;
//
//dirPath : upperDir* normalDir* ID   '\\'? ;
//filePath : upperDir* normalDir* fileName ?  ;
//
//upperDir : '..\\' ;
//normalDir : ID  '\\' ;

configKey
	: 
 'MainFile'
|'Solver'   
|'InitFile'
|'InitFPart'
|'SvarFile' 
|'SvarAPart'
|'SvarFPart'
|'DvarFile'                    
|'TimeStep'
|'StartYear' 
|'StartMonth'
|'NumberOfSteps'
|'StopYear'
|'StopMonth' 
|'GroundwaterDir'
|'ShowWreslLog'
|'SendAliasToDvar'
|'PrefixInitToDvarFile'
;

SL_COMMENT : '#' ~('\r'|'\n')*  {$channel=HIDDEN;} ;

REAL :   Digit+ '.' Digit* ;

INT :   Digit+ ;


ID : Letter ( Letter | Digit | '_' )*;


fragment Letter : 'a'..'z' | 'A'..'Z';

fragment Digit : '0'..'9';

WS : (' ' | '\t' ) {$channel=HIDDEN;};



ENDLINE : ( '\n' | '\r' ) ;

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
  import java.util.HashMap;
}
@lexer::header {
  package scripting.grammar;
}

@members {
      //public CommonTree commonTree;
      public Map<String, String> cMap = new HashMap<String, String>();
}



configFile : ENDLINE? 'Begin' 'Config' ENDLINE 
			( c=configItem  { cMap.put($c.key, $c.val); } )+  
			'End' 'Config' //{ System.out.println( cMap); }
			;


configItem returns[String key, String val ]
	: 

    k=key v=anything     ENDLINE
   { $key=$k.text; $val=$v.text;  }
   //{ System.out.println($k.text); System.out.println($v.text); }
   ;

anything: .+;

solverName : ID ;
fileName:  ID '.' ID ;
dssPartID : INT? ( ID | '-' )* ;
timeStepValue : INT? ID ;


path_literal : '\"'  .+ '\"' ;

dirPath : upperDir* normalDir* ID   '\\'? ;
filePath : upperDir* normalDir* fileName ?  ;

upperDir : '..\\' ;
normalDir : ID  '\\' ;

key
	: 
	 'MainFile'
|'Solver'   
|'InitFile'
|'InitFPart'
|'SvarFile' 
|'SvarAPart'
|'SvarFPart'
|'DvarFile'                    
|'GroundWaterDir'
|'TimeStep'
|'StartYear' 
|'StartMonth'
|'StartDay'
|'EndYear'
|'EndMonth' 
|'EndDay'
|'ShowWreslLog'
;

REAL :   Digit+ '.' Digit* ;

INT :   Digit+ ;



//ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
ID : Letter ( Letter | Digit | '_' )*;


fragment Letter : 'a'..'z' | 'A'..'Z';

fragment Digit : '0'..'9';

WS : (' ' | '\t' ) {$channel=HIDDEN;};

SL_COMMENT : '#' ~('\r'|'\n')*  {$channel=HIDDEN;} ;

ENDLINE : ( '\n' | '\r' )+ ;

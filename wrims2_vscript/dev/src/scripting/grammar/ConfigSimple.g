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
  import java.util.LinkedHashMap;
  import java.util.Arrays;
  import java.util.HashSet;
  import java.util.Set;
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

      public Map<String , String> reservedKeyMap; // this is input from caller
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
   
configFile : 
      ENDLINE* 
      Begin Config ENDLINE+ 
			( c=configItem  { cMap.put($c.key, $c.val); } )+  
			End Config  //{ System.out.println( cMap); }
			
			;


configItem returns[String key, String val ]
	: 

    k=configKey         { $key=reservedKeyMap.get($k.text.toLowerCase()); } 
                        //{ System.out.print("key: "+$key);System.out.print("\t");} 
    ( v1=integer        { $val=$v1.text;} //System.out.println($v1.text);}  
    | v2=complex        { $val=$v2.text;} //System.out.println($v2.text);} 
    //| v3=complex   { $val=$v3.text; }
    ) 
    ENDLINE+
   
   //{ System.out.println($k.text); System.out.println($v.text); }
   ;

integer : INT ;
complex : INT?  ( ID | '.' | '-' | '\"' | '\\' )+ ;


//anything: .+;
//anything:  INT? ( ID | '.' | '-' | '\"' | '\\' )*  


configKey : ke=ID 
{ 
    
    if (!reservedKeyMap.keySet().contains( $ke.text.toLowerCase() ) ) 
    { throw new RuntimeException("Error! "+$ke.text + " is not a recognized keyword in the config file!" ); } 
}
;


SL_COMMENT : '#' ~('\r'|'\n')*  {$channel=HIDDEN;} ;


INT : Digit+ ;

Begin  : 'Begin'  ;
End    : 'End'    ;
Config : 'Config' ;

ID : Letter ( Letter | Digit | '_' )*;

//Others: ~('\r'|'\n'|'\t'|' '|'/')+ ;


fragment Letter : 'a'..'z' | 'A'..'Z';

fragment Digit : '0'..'9';



WS : (' ' | '\t' ) {$channel=HIDDEN;};



ENDLINE : ( '\n' | '\r' ) ;

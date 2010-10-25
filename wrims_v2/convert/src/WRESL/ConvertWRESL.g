grammar ConvertWRESL;

options {
  language = Java;
}

@header {
  package WRESL;
  import java.util.Map;
  import java.util.HashMap;
}

@lexer::header {
  package WRESL;
}

@members {
  public Map<String, String>  goals = new HashMap<String, String>();

  public Map<String, String>   error_var_redefined = new HashMap<String, String> ();
  public Map<String, String>   var_all = new HashMap<String, String> ();
  public Map<String, String>  var_constants = new HashMap<String, String>();
  public Map<String, ArrayList<String>>   dvar_nonstd = new HashMap<String, ArrayList<String>>();  
  public Map<String, ArrayList<String>>  dvar_std = new HashMap<String, ArrayList<String>>(); 
  public Map<String, ArrayList<String>>  svar_table = new HashMap<String, ArrayList<String>>(); 
  //public Map<String, String[]>  dvar_std = new HashMap<String, String[]>(); 
  private ArrayList<String> list;
  //private boolean blnExists = hMap.containsKey("3");
  

  public String strip(String s) {
    return s.substring(1, s.length()-1);
    }
  
  
}

evaluator //returns [Map<String, String> map1]
	:	modules EOF //{ $map1 = constants; }
	;

modules
	:	module*
	;

module
	:   goal_simple
	|   define
	;

define //returns [Map<String, String> map]
	:	DEFINE (constant|dvar_std|dvar_nonstd|svar_table)  
	;


goal_simple
	: GOAL i=IDENT  '{' v=relationStatement '}'  {		
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "goal_simple");
				}
				else {
				goals.put($i.text, $v.text);
				var_all.put($i.text, "goal_simple");
				}
		}
	;

goal_lhs
	: 'lhs' IDENT
	;

constant //returns [Map<String, String> map]
	:	i=IDENT '{' 'value' v=number '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "const");
				}
				else {
				var_constants.put($i.text, $v.text);
				var_all.put($i.text, "const");
				}
		}
	;


dvar_std
	:	i=IDENT '{' 'std' kind units'}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "dvar_std");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				dvar_std.put($i.text, list);
				var_all.put($i.text, "dvar_std");
				}
		}
	;
	
dvar_nonstd
	:	i=IDENT '{' lower upper kind units'}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "dvar_nonstd");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				list.add($lower.str);
				list.add($upper.str);
				dvar_nonstd.put($i.text, list);
				var_all.put($i.text, "dvar_nonstd");
				}
		} 
	;

svar_table
	:	i=IDENT '{' t=tableSQL '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_table");
				}
				else {
				svar_table.put($i.text, $t.list);
				var_all.put($i.text, "svar_table");
				}
		}
	;

tableSQL returns[ArrayList<String> list]
	: 'select' i1=IDENT 'from' i2=IDENT 'where' i3=relationStatement {       
				list = new ArrayList<String>();
				list.add($i1.text);
				list.add($i2.text);
				list.add($i3.text);
		}
	;
 



lower returns[String str]
	: 'lower' e=expression {$str =$e.str; }
	;

upper returns[String str]
	: 'upper' e=expression {$str =$e.str; }
	;
	
kind returns [String str]
	: 'kind'  s=QUOTE_STRING_with_MINUS  { $str =strip($s.text); } 
	;

units returns [String str]
	: 'units' CFS {$str = "CFS";}
	| 'units' TAF {$str = "TAF";}
	;
///////////////////
/// basic rules ///
///////////////////
term
	:	i=IDENT 
	|	'(' e=expression ')' 
	|	i=INTEGER 
	|   i=FLOAT 
	;
	
unary
	:	('+' | '-')* term
	;

mult
	:	unary (('*' | '/' | 'mod') unary)*
	;
	
add 
	:	mult (('+' | '-') mult)*
	;

expression returns [String str]
	:	i=add {$str = $i.text; }
	;

relation
	: '='
	| '<'
	| '>'
	;	

relationStatement
	:	expression relation expression 
	;

number
	: INTEGER
	| FLOAT
	;

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;


fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';


INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER 
	  | INTEGER '.' 
	  ;

GOAL :'goal';
DEFINE :'define';
TAF :'\''  'TAF'  '\'';
CFS :'\''  'CFS' '\'';
QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};

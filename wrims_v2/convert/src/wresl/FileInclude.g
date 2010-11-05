grammar FileInclude;

options {
  language = Java;
}

@header {
  package wresl;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.Arrays;
}

@lexer::header {
  package wresl;
}

@members {
  public Map<String, String>   error_var_redefined = new HashMap<String, String> ();
  public Map<String, String>   var_all             = new HashMap<String, String> ();
  public Map<String, String>   svar_expression     = new HashMap<String, String>();
  public Map<String, String>   goal_simple = new HashMap<String, String>();
      
  public Map<String, ArrayList<String>>  dvar_nonstd = new HashMap<String, ArrayList<String>>();  
  public Map<String, ArrayList<String>>  dvar_std    = new HashMap<String, ArrayList<String>>(); 
  public Map<String, ArrayList<String>>  svar_table  = new HashMap<String, ArrayList<String>>(); 
  public Map<String, ArrayList<String>>  svar_dss    = new HashMap<String, ArrayList<String>>(); 
  
	/// svar_cases
	public    Map<String, ArrayList<String>>   svar_cases  = new HashMap<String,ArrayList<String>> (); 
	public    Map<String, ArrayList<String>>   svar_conditions  = new HashMap<String,ArrayList<String>> (); 
	public    Map<String, Map<String, ArrayList<String>>> svar_map_case_content = new HashMap<String, Map<String, ArrayList<String>>>();
  
  private ArrayList<String> list;

  public String strip(String s) {
    return s.substring(1, s.length()-1);
    }
  private static String[] keys = {"define","goal"};
  private static String[] mons = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
  public static List<String> r_keys = Arrays.asList(keys); 
  public static List<String> r_mons = Arrays.asList(mons); 
  public static ArrayList<String> reserved_words = new ArrayList<String>() {{ addAll(r_keys); addAll(r_mons); }}; 

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
	:	modules EOF  ;

modules
	:	module*  ;

module
	:   goal_simple   ;

goal_simple
	: 'goal' i=IDENT  '{' v=assignmentStatement '}'  {		
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "goal_simple");
				}
				else {
				goal_simple.put($i.text, $v.text);
				var_all.put($i.text, "goal_simple");
				}
		}
	;

///////////////////
/// basic rules ///
///////////////////

term
	:	IDENT 
	|	'(' e=expression ')' 
	|	number
	;
	
unary
	:	('-')? term ;

mult
	:	unary (('*' | '/' | 'mod') unary)* ;
	
add 
	:	mult (('+' | '-') mult)* ;

expression returns [String str]
	:	i=add {$str = $i.text; }
	;

assignmentStatement
	: expression '=' expression ;

number
	: INTEGER | FLOAT ;


MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER  | INTEGER '.' ;


///basics///
QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};

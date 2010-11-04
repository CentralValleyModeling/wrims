grammar ConvertWresl;

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
}

evaluator 
	:	modules EOF  ;

modules
	:	module*  ;

module
	:   goal_simple  |  define  ;

define //returns [Map<String, String> map]
	:	DEFINE 
	(	svar_expression
	|	dvar_std
	|	dvar_nonstd
	|	svar_table
	|	svar_dss
	|	svar_cases)  
	;

goal_simple
	: GOAL i=IDENT  '{' v=assignmentStatement '}'  {		
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

goal_lhs
	: 'lhs' IDENT
	;

svar_expression //returns [Map<String, String> map]
	:	i=IDENT '{' v=valueStatement '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_expression");
				}
				else {
				svar_expression.put($i.text, $v.str);
				var_all.put($i.text, "svar_expression");
				}
		}
	;

svar_table
	:	i=IDENT '{' t=sqlStatement '}' { 
				
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

svar_cases
	//@init { $list = new ArrayList<String>(); }
	:  i=IDENT '{' c=caseStatements '}' { 

				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_cases");
				}
				else {
				//list = new ArrayList<String>();
				//list.add($c.text);
				svar_cases.put($i.text, $c.caseNames);
				svar_conditions.put($i.text, $c.conditions);
				svar_map_case_content.put($i.text, $c.caseContent);
				var_all.put($i.text, "svar_cases");
				}
		} 	
	;
	
caseStatements returns[ArrayList<String> caseNames, 
					   ArrayList<String> conditions, 
					   Map<String, ArrayList<String>> caseContent ]
					   
@init { $caseNames = new ArrayList<String>(); 
        $conditions = new ArrayList<String>();
        $caseContent = new HashMap<String, ArrayList<String>>(); }
        
	:  ( c=caseStatement  {
			$caseNames.add($c.caseNameStr);
			$conditions.add($c.conditionStr);			
			$caseContent.put($c.caseNameStr, $c.contentList);			         
			
			} )+
	;	

caseStatement returns[String caseNameStr, String conditionStr, ArrayList<String> contentList]
@init { $contentList = new ArrayList<String>();} 
	:  'case' i=IDENT '{' c=conditionStatement ( s=sqlStatement | v=valueStatement) '}'  {
			
			$caseNameStr = $i.text;
			$conditionStr = $c.str;
			if ($v.str==null|$v.str==""){$contentList.add("sql");$contentList.addAll($s.list);}
			else                        {$contentList.add("value");$contentList.add($v.str);}
			
			}
	;	


svar_dss
	:	i=IDENT '{' 'timeseries' kind units'}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "svar_dss");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				svar_dss.put($i.text, list);
				var_all.put($i.text, "svar_dss");
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
	:	i=IDENT '{' c=lower_or_upper kind units '}' { 
				
				if (var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				error_var_redefined.put($i.text, "dvar_nonstd");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				list.addAll($c.list);
				dvar_nonstd.put($i.text, list);
				var_all.put($i.text, "dvar_nonstd");
				}
		} 
	;

lower_or_upper returns[ArrayList<String> list]
	:	lower upper? {       
				$list = new ArrayList<String>();
				$list.add($lower.str);
				if ($upper.str==null) {
				$list.add("unbounded");
				}
				else {
				$list.add($upper.str);
				}		
	    }
	|	upper {       
				$list = new ArrayList<String>();
				$list.add("0");
				$list.add($upper.str);
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
	| 'units' ACRES {$str = "ACRES";}
	| 'units' IN {$str = "IN";}
	;

/// sub rules ///




conditionStatement returns[String str]
	: 'condition' 
	( s=logicalRelationStatement {$str = $s.text;}
	| ALWAYS {$str = "always";} )
	;

valueStatement returns[String str]
	: 'value' e=expression {$str = $e.text;}
	;

/// SQL related ///

sqlStatement returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }
	: 'select' i1=all_ident 'from' i2=IDENT 
	  ('given' i3=assignmentStatement)? ('use' i4=IDENT)? 
	  where_items?	  
	  {       
				$list.add($i1.text);
				$list.add($i2.text);
				$list.add($i3.text);
				$list.add($i4.text);
				if ($where_items.list != null) {$list.addAll($where_items.list);}
		}
	;

where_items returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }

	:	 WHERE  (r1=assignmentStatement{$list.add($r1.text);} )
	        (',' r=assignmentStatement {$list.add($r.text);}  )*
	;

///////////////////////////
/// Intrinsic functions ///
///////////////////////////

max_func
	: MAX '(' expression ',' expression ')' ;

min_func
	: MIN '(' expression ',' expression ')' ;

inline_func 
	: IDENT '(' '-' INTEGER ')' ;

///////////////////
/// basic rules ///
///////////////////

term
	:	IDENT | reserved_vars| reserved_consts
	|	'(' e=expression ')' 
	|	number
	|   inline_func  |   max_func  |  min_func	
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

relation_group
	: EQUALS | LE | GE | '<' | '>' ;

assignmentStatement
	: expression '=' expression ;

relationStatement
	:	expression relation_group expression  ;

logicalRelationStatement
	:   relationStatement ((AND|OR) relationStatement)? ;

number
	: INTEGER | FLOAT ;

reserved_vars
	: WATERYEAR | MONTH ;

reserved_consts
	: MON_CONST ;

all_ident
	: reserved_vars | reserved_consts | IDENT ;

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER  | INTEGER '.' ;

/// INLINE_FUNC //
MAX : 'max' ;
MIN : 'min' ;
WHERE : 'where' ;

/// comparison ///
EQUALS : '==';
LE : '<=';
GE : '>=';

/// logical ///
AND : '.and.';
OR  : '.or.';

/// reserved keywords //
GOAL :'goal';
DEFINE :'define';
ALWAYS :'always';
CONDITION : 'condition';

/// reserved vars ///
WATERYEAR : 'wateryear';
MONTH : 'month';

/// reserved constants ///
MON_CONST : 'JAN'|'FEB'|'MAR'|'APR'|'MAY'|'JUN'|'JUL'|'AUG'|'SEP'|'OCT'|'NOV'|'DEC';

///units///
TAF :'\''  'TAF'  '\'';
CFS :'\''  'CFS' '\'';
ACRES :'\''  'ACRES' '\'';
IN :'\''  'IN' '\'';

///basics///
QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};

grammar ParseTable;

options {
  language = Java;
}

@header {
  package Parser;
  import java.util.Map;
  import java.util.HashMap;
}

@lexer::header {
  package Parser;
}

@members {

  public Map<String, String>   error_var_redefined = new HashMap<String, String> ();
  public Map<String, String>   var_all = new HashMap<String, String> ();
  public Map<String, String>   var_constants = new HashMap<String, String>();
  public Map<String, ArrayList<String>>   dvar_nonstd = new HashMap<String, ArrayList<String>>();  
  public Map<String, ArrayList<String>>  dvar_std = new HashMap<String, ArrayList<String>>(); 
  public Map<String, ArrayList<String>>  svar_table = new HashMap<String, ArrayList<String>>(); 
  public Map<String, String>   goal_simple = new HashMap<String, String>();
  
  private ArrayList<String> list;

  public String strip(String s) {
    return s.substring(1, s.length()-1);
    }
  
  
}

evaluator //returns [Map<String, String> map1]
	:	modules //{ $map1 = constants; }
	;

modules
	:	nodeTable
	|	arctable
	|	reservoirtable
	|	dvartable
	|	svartable
	|	constrainttable
	|	weighttable
	;
	
nodeTable
	:	headline_nodetable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_nodeline*
	;
	
arctable
	:	headline_arctable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_arcline*
	;	

reservoirtable
	:	headline_reservoirtable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_reservoirline*
	;

dvartable
	:	headline_dvartable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_dvarline*
	;

svartable
	:	headline_svartable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_svarline*
	;
	
constrainttable
	:	headline_constrainttable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_constraintline*
	;

weighttable
	:	headline_weighttable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_weightline*
	;
	
headline_nodetable
	:	'name'  ',' 'include' ',' 'x-coordinate' ',' 'y-coordinate' ',' 'type' ',' 'filter'{
		}
	;

headline_arctable
	:	'name' ',' 'include' ',' 'expression' ',' 'units' ',' 'lowerbound' ',' 'upperbound' ',' 'startnode' ',' 'endnode' ',' 'type' ',' 'filter'{
		}
	;
	
headline_reservoirtable
	:	'name' ',' 'zone' ',' 'include' ',' 'upbound' ',' 'units' ',' 'filter'{
		}
	;
	
headline_dvartable
	:	'name' ',' 'include' ',' 'Lowerbound' ',' 'upperbound' ',' 'integer' ',' 'uits' ',' 'filter' {
		}
	;
	
headline_svartable
	:	'name' ',' 'case' ',' 'include' ',' 'writetodss' ',' 'condition' ',' 'expression' ',' 'filter' {
		}
	;

headline_constrainttable
	:	'name' ',' 'case' ',' 'include' ',' 'condition' ',' 'expression' ',' 'lhs>rhs' ',' 'rhs>lhs' ',' 'filter'{
		}
	;
		
headline_weighttable
	:	'name' ',' 'weight'{
		}
	;

content_nodeline
	:	content_node (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;

content_arcline
	:	content_arc (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;

content_reservoirline
	:	content_reservoir (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;
	
content_dvarline
	:	content_dvar (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;
	
content_svarline
	:	content_svar (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;
	
content_constraintline
	:	content_constraint (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;
	
content_weightline
	:	content_weight (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;
	
content_node
	:	i1=IDENT ',' yn ',' i2=number ',' i3=number ',' i4=IDENT ','  (filter|'#'){
			System.out.println("Good!");
	}
	;

content_arc
	:	i1=IDENT ',' yn ',' (tableExprssion|'#') ',' units ',' (lowerbound|'#') ',' (upperbound|'#') ',' 
		((i2=IDENT ',' i3=IDENT)|('#' ',' i3=IDENT)|(i2=IDENT ',' '#')) ',' i4=IDENT ',' (filter|'#'){
			System.out.println($i4.text);
		}  
	;

content_reservoir
	:	i1=IDENT ',' i2=(IDENT|'#') ',' yn ',' i3=(tableExprssion|'#') ',' i4=(units|'#') ',' (filter|'#'){
			System.out.println("Good!");
		}
	;
	
content_dvar
	:	WS
	;
	
content_svar
	:	WS
	;
	
content_constraint
	:	WS
	;
	
content_weight
	:	WS
	;
	
///////////////////
/// basic rules ///
///////////////////

tableExprssion
	:	number|tableSQL|timeseries|max_func|min_func;

max_func
	: 'max' '(' expression ',' expression ')'
	;

min_func
	: 'min' '(' expression ',' expression ')'
	;

filter	:	(IDENT|IDENT1|IDENT2) ((BACKSLASH|'-') (IDENT|IDENT1|IDENT2))* ;
	
timeseries returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC {
				list = new ArrayList<String>();
				list.add($i1.text);	
		}
	;
	
partC	:	partCIdent|(number* partCIdent)|number;

partCIdent
	:	 IDENT ('-' IDENT)*;

tableSQL returns[ArrayList<String> list]
	: 'select' i1=IDENT 'from' i2=IDENT 
	  ('given' i3=relationStatement)? ('use' i4=IDENT)? 
	  'where' i5=relationStatementSeries 
	  {       
				list = new ArrayList<String>();
				list.add($i1.text);
				list.add($i2.text);
				list.add($i3.text);
				list.add($i4.text);
				list.add($i5.text);


		}
	;

relationStatementSeries
	:	relationStatement ('&' relationStatement)*
	;

upperbound:	number|'1.e38'|(number '*taf_cfs');

lowerbound:	number|'-1.e38'|(number '*taf_cfs');

units 	:	CFS|TAF;

yn
	:	'y'
	|	'n'
	;
	
term
	:	i=IDENT 
	|	'(' e=expression ')' 
	|	i=INTEGER 
	|       i=FLOAT 
	|   	max_func
	|   	min_func
	;
	
unary
	:	('+'|'-')* term
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
fragment SYMBOLSET: ';'|'.'|'|'|'_'|'-'|'+';

BACKSLASH : '\\';	 	 

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER 
	  | INTEGER '.' 
	  ;

GOAL :'goal';
DEFINE :'define';
TAF : 'taf' ;
CFS : 'cfs' ;
QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;
IDENT1 : DIGIT (LETTER | DIGIT | SYMBOLS )*; 
IDENT2 : SYMBOLS (LETTER | DIGIT | SYMBOLS )*; 

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};



	

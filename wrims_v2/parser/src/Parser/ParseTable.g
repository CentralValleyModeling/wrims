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
	:	filetable
	|	nodetable
	|	arctable
	|	reservoirtable
	|	dvartable
	|	svartable
	|	constrainttable
	|	weighttable
	;


filetable
	:	headline_filetable ('\n'|'\r'|COMMENT*|MULTILINE_COMMENT*) content_fileline*
	;
	
headline_filetable
	:	'include' ',' 'file'{
		}
	;

content_fileline
	:	content_file (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|MULTILINE_COMMENT*|EOF)
	;
	
content_file
	:	i1=directory ',' i2=IDENT {
			System.out.println($i1.text);
		}
	;
		
nodetable
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
	:	'name'  ',' 'include' ',' 'x-coordinate' ',' 'y-coordinate' ',' 'type' {
		}
	;

headline_arctable
	:	'name' ',' 'include' ',' 'expression' ',' 'units' ',' 'lowerbound' ',' 'upperbound' ',' 'startnode' ',' 'endnode' ',' 'type' {
		}
	;
	
headline_reservoirtable
	:	'name' ',' 'zone' ',' 'include' ',' 'upbound' ',' 'units'{
		}
	;
	
headline_dvartable
	:	'name' ',' 'include' ',' 'lowerbound' ',' 'upperbound' ',' 'integer' ',' 'units' {
		}
	;
	
headline_svartable
	:	'name' ',' 'include' ',' 'writetodss' ',' 'case' ',' 'caseinclude' ',' 'condition' ',' 'expression' {
		}
	;

headline_constrainttable
	:	'name' ',' 'include' ',' 'case' ',' 'caseinclude' ',' 'condition' ',' 'expression' ',' 'lhs>rhs' ',' 'rhs>lhs' {
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
	:	i1=IDENT ',' i2=IDENT ',' i3=allnumber ',' i4=allnumber ',' i5=IDENT {
			System.out.println("Good!");
	}
	;

content_arc
	:	i1=IDENT ',' i2=IDENT ',' (tableExpression|'#') ',' units ',' (lowerbound|'#') ',' (upperbound|'#') ',' 
		((i3=IDENT ',' i4=IDENT)|('#' ',' i4=IDENT)|(i3=IDENT ',' '#')) ',' i5=IDENT {
			System.out.println($i4.text);
		}  
	;

content_reservoir
	:	i1=IDENT ',' i2=(IDENT|'#') ',' i3=IDENT ',' i4=(tableExpression|'#') ',' i5=(units|'#') {
			System.out.println("Good!");
		}
	;
	
content_dvar
	:	i1=IDENT ',' i2=IDENT ',' lowerbound ',' upperbound ',' i3=IDENT ',' i4=units
	;
	
content_svar
	:	i1=IDENT ',' i2=(IDENT|'#') ',' i3=(IDENT|'#') ',' i4=IDENT ',' i5=(IDENT|'#') ',' i6=(relationStatement|'always') ',' i7=tableExpression
	;
	
content_constraint
	:	i1=IDENT ',' i2=(IDENT|'#') ',' i3=IDENT ',' i4=IDENT ',' i5=(relationStatement|'always') ',' i6=relationStatement ',' i7=(number|'#') ',' i8=(number|'#') 
	;
	
content_weight
	:	IDENT ',' weight 
	;
	

///////////////////
/// basic rules ///
///////////////////

weight	:	allnumber|(allnumber '*taf_cfs');

directory
	:	(';'|'.'|'|'|'_'|'-'|'+'|'/'|BACKSLASH|IDENT|IDENT1)+
	;
	
text	:	LETTER (LETTER | DIGIT )*;
	
tableExpression
	:	expression|tableSQL|timeseriesWithUnits|timeseries;

max_func
	: MAX '(' expression ',' expression ')'
	;

min_func
	: MIN '(' expression ',' expression ')'
	;

timeseriesWithUnits returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC 'units' '=' i2=IDENT{
				list = new ArrayList<String>();
				list.add($i1.text);	
				list.add($i2.text);
		}
	;

timeseries returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC{
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
	  where_items	  
	  {       
				list = new ArrayList<String>();
				list.add($i1.text);
				list.add($i2.text);
				list.add($i3.text);
				list.add($i4.text);
				list.addAll($where_items.list);
		}
	;

where_items returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }

	:	 WHERE  (r1=relationStatement{list.add($r1.text);} )
	        ('&' r=relationStatement {list.add($r.text);}  )*
	;


upperbound:	expression;

lowerbound:	expression;

units 	:	CFS|TAF;

term
	:	i=IDENT 
	|	'(' e=expression ')' 
	|	i=INTEGER 
	|       i=FLOAT 
	|   	max_func
	|   	min_func
	;
	
unary
	:	('-')? term;
	
allnumber
	:	('-')? number;

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

BACKSLASH : '\\';	 	 

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER 
	  | INTEGER '.' 
	  ;


TAF : 'taf' ;
CFS : 'cfs' ;
MAX : 'max';
MIN : 'min';
WHERE : 'where';

QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;
IDENT1 : DIGIT (LETTER | DIGIT | SYMBOLS )*; 

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};


	

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

  public ArrayList<String>   error_var_redefined = new ArrayList<String> ();
  public ArrayList<String>   error_grammer = new ArrayList<String> ();
  public Map<String, ArrayList<String>>   node = new HashMap<String, ArrayList<String>>();
  public Map<String, ArrayList<String>>   dvar = new HashMap<String, ArrayList<String>>();
  public Map<String, ArrayList<ArrayList<String>>>   svar = new HashMap<String, ArrayList<ArrayList<String>>>();
  public ArrayList<String>   outputSvar = new ArrayList<String>();
  public Map<String, String> weight = new HashMap<String, String>();
  public ArrayList<String>   file = new ArrayList<String>();
  public Map<String, ArrayList<ArrayList<String>>>   constraint = new HashMap<String, ArrayList<ArrayList<String>>>();
  
  private String svType= "NULL"; 
  private String preSV ="";
  private String preCondition = "always";
  private int n_always=0;
  private boolean redefineSV=false;
  private boolean includeSV=false;
  private String writeToDss="y"; 
  
  private ArrayList<ArrayList<String>> svlist;

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
	:	headline_filetable ('\n'|'\r'|COMMENT*) content_fileline*
	;
	
headline_filetable
	:	'file' ',' 'include'{
		}
	;

content_fileline
	:	content_file (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_file
	:	i1=directory ',' i2=IDENT {
	     if ($i2.text.equals("y")){
	         if (file.contains($i1.text)) {
	             error_var_redefined.add("file table: "+ $i1.text+" redfined");
	         }else{
	           file.add($i1.text);
	         }	         
	     }else if (!($i2.text.equals("n"))){
	         error_grammer.add("file table: "+$i1.text+" include field should be y or n");
	     }
		}
	;
		
nodetable
	:	headline_nodetable ('\n'|'\r'|COMMENT*) content_nodeline*
	;
	
arctable
	:	headline_arctable ('\n'|'\r'|COMMENT*) content_arcline*
	;	

reservoirtable
	:	headline_reservoirtable ('\n'|'\r'|COMMENT*) content_reservoirline*
	;

dvartable
	:	headline_dvartable ('\n'|'\r'|COMMENT*) content_dvarline*
	;

svartable
	:	headline_svartable ('\n'|'\r'|COMMENT*) content_svarline*
	;
	
constrainttable
	:	headline_constrainttable ('\n'|'\r'|COMMENT*) content_constraintline*
	;

weighttable
	:	headline_weighttable ('\n'|'\r'|COMMENT*) content_weightline*
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
	:	'name' ',' 'include' ',' 'lowerbound' ',' 'upperbound' ',' 'integer' ',' 'units' ',' 'type'{
		}
	;
	
headline_svartable
	:	'name' ',' 'include' ',' 'type' ',' 'writetodss' ',' 'case' ',' 'caseinclude' ',' 'condition' ',' 'expression' {
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
	:	content_node (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;

content_arcline
	:	content_arc (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;

content_reservoirline
	:	content_reservoir (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_dvarline
	:	content_dvar (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_svarline
	:	content_svar (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_constraintline
	:	content_constraint (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_weightline
	:	content_weight (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_node
	:	i1=IDENT ',' i2=IDENT ',' i3=allnumber ',' i4=allnumber ',' i5=IDENT {
			if (node.containsKey($i1.text)){
        error_var_redefined.add("node table: "+ $i1.text+"redfined");
      }else{
        if ($i5.text.equals("normal") | $i5.text.equals("reservoir")){
          if ($i2.text.equals("y")){
            ArrayList<String> list = new ArrayList<String>();
            list.add($i3.text);
            list.add($i4.text);
            list.add($i5.text);
            node.put($i1.text, list);
          }else if (!($i2.text.equals("n"))){
            error_grammer.add("node table: "+ $i1.text+" include field should be y or n");
          }
        }else{
          error_grammer.add("node table: "+$i1.text+"type field should be normal or reservoir");
        }
      }
	}
	;

content_arc
	:	i1=IDENT ',' i2=IDENT ',' ((i3=tableExpression)|'#') ',' units ',' ((i4=lowerbound)|'#') ',' ((i5=upperbound)|'#') ',' 
		((i6=IDENT ',' i7=IDENT)|(i6='#' ',' i7=IDENT)|(i6=IDENT ',' i7='#')) ',' partC {
		}  
	;

content_reservoir
	:	i1=IDENT ',' i2=(IDENT|'#') ',' i3=IDENT ',' i4=(tableExpression|'#') ',' i5=(units|'#') {
			System.out.println("Good!");
		}
	;
	
content_dvar
	:	i1=IDENT ',' i2=IDENT ',' lowerbound ',' upperbound ',' i3=IDENT ',' i4=units ',' partC{
	}
	;
	
content_svar
	:	i1=IDENT ',' i2=(IDENT|'#') ',' ((i3=partC)|'#') ',' i4=(IDENT|'#') ',' i5=IDENT ',' i6=(IDENT|'#') ',' i7=conditionStatement ',' i8=tableExpression{
		   }
	;
	
content_constraint
	:	i1=IDENT ',' i2=(IDENT|'#') ',' i3=IDENT ',' i4=IDENT ',' i5=conditionStatement ',' i6=relationStatement ',' i7=(number|'#') ',' i8=(number|'#'){
	    
	} 
	;
	
content_weight
	:	IDENT ',' weight{
	   if (weight.containsKey($IDENT.text)){
        error_var_redefined.add("weight table: "+ $IDENT.text+" redfined");
     }else{
        weight.put($IDENT.text, $weight.text);
     }
	} 
	;
	

///////////////////
/// basic rules ///
///////////////////

weight	:	allnumber|(allnumber '*taf_cfs');

directory
	:	(';'|'.'|'|'|'_'|'-'|'+'|'/'|BACKSLASH|IDENT|INTEGER)+
	;
	
text	:	LETTER (LETTER | DIGIT )*;
	
tableExpression returns [ArrayList<String> list]
  @init { $list = new ArrayList<String>(); }
	:	((i1=expression)|(i1=tableSQL)|(i1=timeseriesWithUnits)|(i1=timeseries)){
	   list =$i1.list;
	}
	;

max_func
	: MAX '(' expression ',' expression ')'
	;

min_func
	: MIN '(' expression ',' expression ')'
	;

timeseriesWithUnits returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC 'units' '=' i2=IDENT{
				list = new ArrayList<String>();
				list.add("TIMESERIESWITHUNITS");
				list.add($i1.text);	
				list.add($i2.text);
		}
	;

timeseries returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC{
				list = new ArrayList<String>();
				list.add("TIMESERIES");
				list.add($i1.text);	
		}
	;
	
partC	:	partCIdent|(number partCIdent)|number;

partCIdent
	:	 IDENT ('-' IDENT)*;

tableSQL returns[ArrayList<String> list]
	: 'select' i1=IDENT 'from' i2=IDENT 
	  ('given' i3=relationStatement)? ('use' i4=IDENT)? 
	  where_items	  
	  {       
				list = new ArrayList<String>();
				list.add("TABLE");
				list.add($i1.text);
				list.add($i2.text);
				if ($i3.text !=null){
				  list.add($i3.text);
				}else{
				  list.add("");
				}
				if ($i4.text !=null){
				  list.add($i4.text);
				}else{
				  list.add("");
				}				
				list.addAll($where_items.list);
		}
	;

where_items returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }

	:	 WHERE  (r1=relationStatement{list.add($r1.text);} )
	        ('&' r=relationStatement {
	           if ($r.text !=null) {list.add($r.text);}}  )*
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

expression returns [ArrayList<String> list]
	:	i=add {
	         list = new ArrayList<String>(); 
	         list.add("EXPRESSION");
	         list.add($i.text); 
	  }
	;

relation
	: '='
	| '<'
	| '>'
	;	

conditionStatement
	:	relationStatement|'always'
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


	

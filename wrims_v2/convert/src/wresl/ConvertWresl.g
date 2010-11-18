grammar ConvertWresl;

options {
  language = Java;
}

@header {
  package wresl;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.Arrays;
  import evaluators.Struct;
  import evaluators.Model;
  import evaluators.Tools;
}

@lexer::header {
  package wresl;
}

@members {

	public Struct F = new Struct();	
	public ArrayList<Model> modelList = new ArrayList<Model>();
	
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
	:	pattern* EOF  ;

pattern
	:   model | includeFile | sequence |  goal  | define ;

model
	:    MODEL IDENT '{' ( goal_simple | define ) '}'
	;

includeFile
	:	INCLUDE
	;

sequence
	:   SEQUENCE IDENT '{' MODEL m=IDENT ORDER i=INTEGER'}'{
				F.sequenceOrder($i.text, $m.text );
		}
	;

define 
	:	DEFINE 
	(	svar_expression
	|	dvar_std   | dvar_nonstd | dvar_alias
	|	svar_table | svar_dss    | svar_cases | svar_sum )  
	;

goal : goal_simple | goal_noCase | goal_case ;

goal_simple
	:	GOAL i=IDENT  '{' v=constraintStatement '}'  {F.goalSimple($i.text, $v.text);}
	;

goal_noCase
	:   GOAL i=IDENT  '{' 'lhs' l=IDENT  r=goalStatement '}'
	;

goal_case
	:   GOAL i=IDENT  '{' 'lhs' h=IDENT  c=caseStatements '}'{ 

				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "goal_cases");
				}
				else {
				//list = new ArrayList<String>();
				//list.add($c.text);
				F.goal_cases.put($i.text, $c.caseNames);
				F.goal_lhs.put($i.text, $h.text);
				F.goal_conditions.put($i.text, $c.conditions);
				F.goal_map_case_content.put($i.text, $c.caseContent);
				F.var_all.put($i.text, "goal_cases");
				}
	     }
	; 

goalStatement returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }
	: 'rhs' i=IDENT  v1=lhs_vs_rhs v2=lhs_vs_rhs {       
				$list.add("rhs"); $list.add($i.text);
				$list.addAll($v1.list); $list.addAll($v2.list);
	  }
	;

lhs_vs_rhs returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }
	: 'lhs'  
	( '>' {$list.add("l>r");}  |  '<' {$list.add("l<r");} )  
	  'rhs' 
	( CONSTRAIN {$list.add("constrain");$list.add(null);}
	| PENALTY i=number {$list.add("penalty");$list.add($i.text);}
	) ;

	

svar_expression 
	:	i=IDENT '{' v=valueStatement '}' { 
			F.svarExpression($i.text, $v.str);
		}
	;

svar_sum 
	:	i=IDENT '{' t=sumStatement '}' { 
				
				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "svar_sum");
				}
				else {
				F.svar_sum.put($i.text, $t.list);
				F.var_all.put($i.text, "svar_sum");
				}
		}
	;

svar_table
	:	i=IDENT '{' t=sqlStatement '}' { 
				
				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "svar_table");
				}
				else {
				F.svar_table.put($i.text, $t.list);
				F.var_all.put($i.text, "svar_table");
				}
		}
	;

svar_cases
	//@init { $list = new ArrayList<String>(); }
	:  i=IDENT '{' c=caseStatements '}' { 

				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "svar_cases");
				}
				else {
				//list = new ArrayList<String>();
				//list.add($c.text);
				F.svar_cases.put($i.text, $c.caseNames);
				F.svar_conditions.put($i.text, $c.conditions);
				F.svar_map_case_content.put($i.text, $c.caseContent);
				F.var_all.put($i.text, "svar_cases");
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
	:  'case' i=IDENT '{' c=conditionStatement 
	( s=sqlStatement   {$contentList.add("sql");$contentList.addAll($s.list);}
	| v=valueStatement {$contentList.add("value");$contentList.add($v.str);}
	| u=sumStatement   {$contentList.add("sum");$contentList.addAll($u.list);}
	| g=goalStatement  {$contentList.add("goal");$contentList.addAll($g.list);}
	) '}' {			
			$caseNameStr = $i.text;
			$conditionStr = $c.str;
			//if ($v.str !=null && $v.str!="")      {$contentList.add("value");$contentList.add($v.str);}
			//if ($s.list !=null && ! $s.list.isEmpty() ) {$contentList.add("sql");$contentList.addAll($s.list);}
	}
	;	


svar_dss
	:	i=IDENT '{' 'timeseries' kind units'}' { 
				
				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "svar_dss");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				F.svar_dss.put($i.text, list);
				F.var_all.put($i.text, "svar_dss");
				}
		} 
	;

dvar_std
	:	i=IDENT '{' 'std' kind units'}' { 
				
				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "dvar_std");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				F.dvar_std.put($i.text, list);
				F.var_all.put($i.text, "dvar_std");
				}
		}
	;

dvar_alias
	:	i=IDENT '{' alias kind? units'}' { 
				
				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "dvar_alias");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				list.add($alias.str);
				F.dvar_alias.put($i.text, list);
				F.var_all.put($i.text, "dvar_alias");
				}
		}
	;
	
dvar_nonstd 
	:	i=IDENT '{' c=lower_or_upper kind units '}' { 
				
				if (F.var_all.containsKey($i.text)){
				//System.out.println("error... variable redefined: " + $i.text);
				F.error_var_redefined.put($i.text, "dvar_nonstd");
				}
				else {
				list = new ArrayList<String>();
				list.add($kind.str);
				list.add($units.str);
				list.addAll($c.list);
				F.dvar_nonstd.put($i.text, list);
				F.var_all.put($i.text, "dvar_nonstd");
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

alias returns [String str]
	: 'alias'  e=expression  { $str = $e.text; }
	;
	
kind returns [String str]
	: 'kind'  s=QUOTE_STRING_with_MINUS  { $str =Tools.strip($s.text); } 
	;

units returns [String str]
	: 'units' CFS {$str = "CFS";}
	| 'units' TAF {$str = "TAF";} 
	| 'units' ACRES {$str = "ACRES";}
	| 'units' IN {$str = "IN";}
	| 'units' NONE {$str = "NONE";}
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
	  ('given' i3=assignStatement)? ('use' i4=IDENT)? 
	  i5=where_items?	{       
				$list.add("select");$list.add($i1.text);
				$list.add("from");$list.add($i2.text);
				$list.add("given");$list.add($i3.text);
				$list.add("use");$list.add($i4.text);
				$list.add("where"); if ($i5.list!=null) {$list.addAll($i5.list);};				
	  }
	;

where_items returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }
	:	 WHERE  (r1=assignStatement{$list.add($r1.text);} )
	        (',' r=assignStatement {$list.add($r.text);}  )*
	;

///////////////////////////
/// Intrinsic functions ///
///////////////////////////

max_func
	: MAX '(' expression (',' expression)+ ')' ;

min_func
	: MIN '(' expression (',' expression)+ ')' ;

other_func
	: INT  '(' expression ')';	

inline_func 
	: IDENT '(' ( ('-' INTEGER) | PREV_MON | 'i' ) ')' ;

sumStatement returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }
	: s=sum_func e=expression
		{$list.add($s.text);$list.add($e.text);}
	;

sum_func
	: SUM 
	s=( '(' 'i=' expression_sum ',' expression_sum (',' INTEGER )? ')' ) 
	;

/////////////////////////////
/// sum rules in sum_func ///
/////////////////////////////
term_sum : reserved_vars | reserved_consts | INTEGER | '(' expression_sum ')' 	;
unary_sum :	('-')? term_sum ;
add_sum  :	unary_sum(('+' | '-') unary_sum)* ;
expression_sum : add_sum ;


///////////////////
/// basic rules ///
///////////////////

term
	:	( var_previous_cycle | IDENT | reserved_vars | reserved_consts)
	|	'(' expression ')' 
	|	number
	|   inline_func  |   max_func  |  min_func	| other_func
	;
	
unary :	('-')? term ;

mult :	unary (('*' | '/' | 'mod') unary)* ;
	
add  :	mult (('+' | '-') mult)* ;

expression returns [String str]
	:	i=add {$str = $i.text; }
	;

relation_group_1  :  LE | GE   ;

relation_group_2  :  '<' | '>'  ;

assignStatement  :   expression '=' expression ;

constraintStatement : expression ('='|relation_group_2) expression ;

relationStatement
	:	expression (EQUALS|relation_group_1|relation_group_2) expression  ;

logicalRelationStatement
	:   relationStatement ((AND|OR) relationStatement)* ;

number : INTEGER | FLOAT ;

reserved_vars : WATERYEAR | MONTH ;

reserved_funcs :  PREV_MON ;

reserved_consts : MON_CONST ;

reserved_keys : GOAL | DEFINE ;

all_ident  : reserved_vars | reserved_consts | IDENT ;

var_previous_cycle : IDENT '[' IDENT ']';
 
MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER  | INTEGER '.' ;

/// intrinsic functions //
INT : 'int'  ;
REAL: 'real' ;
MOD : 'mod'  ;
MAX : 'max'  ;
MIN : 'min'  ;
SUM : 'sum'  ;
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
SEQUENCE  : 'sequence' | 'SEQUENCE';
MODEL     : 'model' | 'MODEL' | 'Model';
ORDER     : 'order';
INCLUDE   : 'include' | 'INCLUDE' | 'Include';
/// reserved vars ///
WATERYEAR : 'wateryear';
MONTH : 'month';

/// goal keywords ///
CONSTRAIN : 'constrain' | 'never' ;
PENALTY   : 'penalty' ;

/// reserved constants ///
MON_CONST : 'JAN'|'FEB'|'MAR'|'APR'|'MAY'|'JUN'|'JUL'|'AUG'|'SEP'|'OCT'|'NOV'|'DEC';

/// reserved functions ///
fragment MON_VAR: 'Jan'|'Feb'|'Mar'|'Apr'|'May'|'Jun'|'Jul'|'Aug'|'Sep'|'Oct'|'Nov'|'Dec'; 
PREV_MON : 'prev' ( MON_VAR | MON_CONST ); // need to force single format


///units///
TAF :'\''    ('TAF'  |'taf')     '\'';
CFS :'\''    ('CFS'  |'cfs')     '\'';
ACRES :'\''  ('ACRES'|'acres') '\'';
IN :'\''  ('IN'|'in') '\'';
NONE :'\''  'NONE' '\'';

///basics///
QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
//VAR_PREVIOUS_CYCLE : IDENT '[' IDENT ']';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};

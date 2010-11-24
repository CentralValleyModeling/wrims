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
 	private ArrayList<String> list;  	private ArrayList<String> list2;
 	private String scope;

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
	:	pattern * EOF  ;

pattern
	:   model 
	|   include
	|	sequence 
	| 	goal 
	| 	define ;

model 
	:    MODEL i=IDENT {F.modelInitial($i.text);} '{' 
	     c=(  include )*
	     '}' 
	;

include
	@init { scope = "global"; }
	:   INCLUDE ( LOCAL  {scope="local";} )? p=includeFilePath {
//			if (modelName!=""){
//	             F.modelBasic(modelName, $p.path, scope);
//	             }
//	        else if (thisFile!=""){
	             F.includeFile($p.path, scope);
//	             }
//	        else { System.out.println("error include rule: " +  $p.path); }	        
	   
	    }  
	; 

includeFilePath returns[String path]
	:	 f=FILE_PATH  {$path=Tools.strip($f.text);}
	;

sequence
	:   SEQUENCE IDENT '{' MODEL m=IDENT ORDER i=INTEGER'}'{
				F.sequenceOrder($i.text, $m.text );
		}
	;


goal	
	@init { scope = "global";}
	: GOAL ( LOCAL {scope="local";} )?  id=IDENT 
	( goal_simple[$id.text, scope] 
	| goal_noCase[$id.text, scope] 
	| goal_case  [$id.text, scope] ) 
	;

goal_simple[String id, String sc] 
	:	 '{' v=constraintStatement '}'  {F.goalSimple($id, $sc, $v.text);}
	;

goal_noCase[String id, String sc]
	:   '{' 'lhs' h=IDENT  r=goalStatement '}' {F.goalNoCase($id, $sc, $h.text, $r.list);}
	;

goal_case[String id, String sc] 
	:   '{' 'lhs' h=IDENT  c=caseStatements '}'{ 
				F.goalCase($id, $sc, $h.text, $c.caseNames, $c.conditions, $c.caseContent);
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

/// define ///
define
	@init { scope = "global"; } 
	:	DEFINE ( LOCAL {scope="local";} )? id=IDENT 
	(	svar_expression[$id.text, scope]
	|	dvar_std[$id.text, scope]   | dvar_nonstd[$id.text, scope] | dvar_alias[$id.text, scope]
	|	svar_table[$id.text, scope] | svar_dss[$id.text, scope]   | svar_cases[$id.text, scope]
	|   svar_sum[$id.text, scope] )  
	;

svar_expression[String id, String sc]
	:	'{' v=valueStatement '}' { 
			F.svarExpression($id, $sc, $v.str);   };

svar_sum [String id, String sc]
	:	 '{' t=sumStatement '}' { 				
			F.svarSum($id, $sc, $t.list);     };

svar_table[String id, String sc]
	:	'{' t=sqlStatement '}' { 
			F.svarTable($id, $sc, $t.list);    };

svar_cases[String id, String sc]
	:   '{' c=caseStatements '}' { 
            F.svarCase($id, $sc, $c.caseNames, $c.conditions, $c.caseContent);  };
	
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


svar_dss[String id, String sc]
	:  '{' 'timeseries' kind units'}' { 				
		F.svarDSS($id, $sc, $kind.str, $units.str);  };

dvar_std[String id, String sc]
	:	'{' 'std' kind units'}' { 
		F.dvarStd($id, $sc, $kind.str, $units.str);  };

dvar_alias[String id, String sc]
	:	'{' alias kind? units'}' { 
		F.dvarAlias($id, $sc, $kind.str, $units.str, $alias.str);  };
	
dvar_nonstd [String id, String sc]
	:	'{' c=lower_or_upper kind units '}' { 
		F.dvarNonStd($id, $sc, $kind.str, $units.str, $c.list);  };

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

/// include file path ///
FILE_PATH :  '\'' (DIR_ELEMENT | DIR_UP)+   WRESL_FILE  '\''  ;
fragment WRESL_EXT :   '.wresl' | '.WRESL' ;
fragment WRESL_FILE :  (LETTER | DIGIT | SYMBOLS |'-'  )+ WRESL_EXT ;
fragment DIR_ELEMENT : (LETTER | DIGIT | SYMBOLS | '-' )+  '\\' ;
fragment DIR_UP :                                   ('..') '\\' ;


/// reserved keywords ///
GOAL :'goal';
DEFINE :'define';
ALWAYS :'always';
CONDITION : 'condition';
SEQUENCE  : 'sequence' | 'SEQUENCE';
MODEL     : 'model' | 'MODEL' | 'Model';
ORDER     : 'order';
INCLUDE   : 'include' | 'INCLUDE' | 'Include';
LOCAL     : '[' 'local' ']';

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

//IGNORE : . {$channel = HIDDEN;};

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
  import evaluators.Svar; 
  import evaluators.Goal;    
}

@lexer::header {
  package wresl;
}

@members {

    public String inModel = "n";

	public Struct F = new Struct();	

	//public ArrayList<Struct> modelList = new ArrayList<Struct>();
	public Map<String, Struct> modelMap = new HashMap<String, Struct>();
	
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
scope { Struct M ; }
@init { inModel = "y"; }
@after{ modelMap.put($i.text, $model::M);  inModel = "n"; }
	:    MODEL i=IDENT  {  F.modelList($i.text);$model::M = new Struct(); } '{' 
	     c=(  include | goal | define )*
	     '}' {
	           //  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$: " + $model::M.include_file_scope); 
	         }
	     
	;

include
	@init { scope = "global"; }
	:   INCLUDE ( LOCAL  {scope="local";} )? p=includeFilePath {
	             if(inModel=="n") { F.includeFile($p.path, scope);}
	             else             { $model::M.includeFile($p.path, scope);}
	             
	              
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
	:	 '{' v=constraintStatement '}'  {
	
		         if(inModel=="n") { F.goalSimple($id, $sc, $v.text);}
	             else             { $model::M.goalSimple($id, $sc, $v.text);}
		}
	;

goal_noCase[String id, String sc]
	:   '{' 'lhs' h=IDENT  r=goalStatement '}' {F.goalNoCase($id, $sc, $h.text, $r.list, $r.rhs, $r.lhs_gt_rhs, $r.lhs_lt_rhs);}
	;

goal_case[String id, String sc] 
	:   '{' 'lhs' lhs=IDENT  g=goalCaseStatements '}'{
				$g.gl.scope = $sc;
				$g.gl.lhs = $lhs.text;
				F.goalCase($id, $sc, $lhs.text, $g.gl);
	     }
	; 

goalCaseStatements returns[Goal gl]					   
	@init { $gl = new Goal(); }    
	:  ( c=goalCaseStatement  {
			/// clearer data structure		
			$gl.caseName.add($c.caseName);
			$gl.caseCondition.add($c.condition);
			$gl.caseExpression.add($c.rhs);
			$gl.case_lhs_gt_rhs.add($c.lhs_gt_rhs);
			$gl.case_lhs_lt_rhs.add($c.lhs_lt_rhs);
			
			} )+ 
	;	

goalCaseStatement returns[String caseName, String condition, String rhs, String expression, String lhs_gt_rhs, String lhs_lt_rhs]
	:  'case' i=IDENT '{' c=conditionStatement g=goalStatement  '}' {			
			$caseName = $i.text;
			$condition = $c.str;
			$rhs = $g.rhs; $lhs_gt_rhs = $g.lhs_gt_rhs; $lhs_lt_rhs = $g.lhs_lt_rhs;
	};	

goalStatement returns[ArrayList<String> list, String rhs, String lhs_gt_rhs, String lhs_lt_rhs]
	@init { $list = new ArrayList<String>(); }
	: 'rhs' i=IDENT  v1=lhs_vs_rhs v2=lhs_vs_rhs {       
				$list.add("rhs"); $list.add($i.text);
				$list.addAll($v1.list); $list.addAll($v2.list);
				
				///clearer data structure
				$rhs=$i.text;
				if ($v1.lhs_gt_rhs!=null){$lhs_gt_rhs=$v1.lhs_gt_rhs;$lhs_lt_rhs=$v2.lhs_lt_rhs;}
				else                     {$lhs_gt_rhs=$v2.lhs_gt_rhs;$lhs_lt_rhs=$v1.lhs_lt_rhs;}			
	};

lhs_vs_rhs returns[ArrayList<String> list, String lhs_gt_rhs, String lhs_lt_rhs]
	@init { $list = new ArrayList<String>(); String scenario="";}
	: 'lhs'  
	( '>' {$list.add("l>r"); scenario = "l>r";}  |  '<' {$list.add("l<r"); scenario = "l<r";} )  
	  'rhs' 
	( CONSTRAIN 
		{$list.add("constrain");$list.add(null);  
		 if (scenario == "l>r"){$lhs_gt_rhs="constrain";}
		 else if (scenario == "l<r"){$lhs_lt_rhs="constrain";}
		 }
	| PENALTY i=number {$list.add("penalty");$list.add($i.text);
		 if (scenario == "l>r"){$lhs_gt_rhs=$i.text;}
		 else if (scenario == "l<r"){$lhs_lt_rhs=$i.text;}
		}
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
			F.svarSum($id, $sc, $t.list, $t.str);     };

svar_table[String id, String sc]
	:	'{' t=sqlStatement '}' { 
			F.svarTable($id, $sc, $t.list, $t.str);    };

svar_cases[String id, String sc]
	:   '{' c=caseStatements '}' { 
            F.svarCase($id, $sc,  $c.sv,  $c.caseNames, $c.conditions, $c.expressions, $c.caseContent);  };
	
caseStatements returns[ArrayList<String> caseNames, 
					   ArrayList<String> conditions, 
					   ArrayList<String> expressions, 
					   Map<String, ArrayList<String>> caseContent,
					   Svar sv ]
					   
@init { $caseNames = new ArrayList<String>(); 
        $conditions = new ArrayList<String>();
        $expressions = new ArrayList<String>();
        $caseContent = new HashMap<String, ArrayList<String>>();
        $sv = new Svar(); 
         }
        
	:  ( c=caseStatement  {
			$caseNames.add($c.caseNameStr);
			$conditions.add($c.conditionStr);	
			$expressions.add($c.expressionStr);			
			$caseContent.put($c.caseNameStr, $c.contentList);		         
			
			/// clearer data structure		
			$sv.caseName.add($c.caseNameStr);
			$sv.caseCondition.add($c.conditionStr);
			$sv.caseExpression.add($c.expressionStr);			
			
			} )+ 
	;	

caseStatement returns[String caseNameStr, String conditionStr, String expressionStr, ArrayList<String> contentList]
@init { $contentList = new ArrayList<String>();	} 
	:  'case' i=IDENT '{' c=conditionStatement 
	( s=sqlStatement   {$contentList.add("sql");$contentList.addAll($s.list);  $expressionStr=$s.str;}
	| v=valueStatement {$contentList.add("value");$contentList.add($v.str);    $expressionStr=$v.str;}
	| u=sumStatement   {$contentList.add("sum");$contentList.addAll($u.list);  $expressionStr=$u.str;}
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
		F.dvarNonStd($id, $sc, $kind.str, $units.str, $c.list, $c.lowerBound, $c.upperBound);  };

lower_or_upper returns[ArrayList<String> list, String lowerBound, String upperBound]
	:	lower upper? {       
				$list = new ArrayList<String>();
				$list.add($lower.str); $lowerBound=$lower.str;
				if ($upper.str==null) {
				$list.add("unbounded");$upperBound="unbounded";
				}
				else {
				$list.add($upper.str);$upperBound=$upper.str;
				}		
	    }
	|	upper {       
				$list = new ArrayList<String>();
				$list.add("0");$lowerBound="0";
				$list.add($upper.str);$upperBound=$upper.str;
		}		
	;
 
lower returns[String str]
	: 'lower' e=expression {$str =$e.text; }
	;

upper returns[String str]
	: 'upper' e=expression {$str =$e.text; }
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
	( s=logicalRelationStatement {$str = $s.str;}
	| ALWAYS {$str = "always";} )
	;

valueStatement returns[String str]
	: 'value' e=expression {$str = $e.text;}
	;

/// SQL related ///

sqlStatement returns[ArrayList<String> list, String str]
	@init { $list = new ArrayList<String>(); }
	:  'select' i1=all_ident 
	   'from' i2=IDENT {$str ="select "+$i1.text+" from "+$i2.text;} 
	  ('given' i3=assignStatement {$str=$str+" given "+$i3.text;})? 
	  ('use' i4=IDENT {$str=$str+" use "+$i4.text;})? 
	  (i5=where_items {$str=$str+" where "+$i5.str;})?	{       
				$list.add("select");
				$list.add($i1.text);
				$list.add("from");
				$list.add($i2.text);
				$list.add("given");
				$list.add($i3.text);
				$list.add("use");
				$list.add($i4.text);
				
				if ($i5.list!=null) {$list.add("where"); $list.addAll($i5.list);}
				//else{$list.add(null);};				
	  }
	;

where_items returns[ArrayList<String> list, String str]
	@init { $list = new ArrayList<String>(); }
	:	 WHERE  (r1=assignStatement{$list.add($r1.text);$str=$r1.text;} )
	        (',' r=assignStatement {$list.add($r.text);$str=$str+"; "+$r.text;}  )*
	        //{ if ($list.size()>1) {$str = "(" + $str + ")";}}
	        //{$list.add(null);}
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

sumStatement returns[ArrayList<String> list, String str]
	@init { $list = new ArrayList<String>(); }
	: s=sum_func e=expression{
		$list.add($s.text.replace(",","; "));$list.add($e.text);
		$str = $s.text.replace(",","; ") + " " + $e.text;
		}
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

mult :	unary (('*' | '/' | 'mod') unary)* 
	 ;
	
add :	mult  (	( '+' | '-' ) mult )* 
	;

expression returns [String text]
	:	i=add {$text = $i.text.replace(",","; ");}
	;

relation_group_1  :  LE | GE   ;

relation_group_2  :  '<' | '>'  ;

assignStatement  :   expression '=' expression ;

constraintStatement
	: expression ('=' | r=relation_group_2 ) expression 
	;

relationStatement 
	:	expression 
	    ( EQUALS  | r1=relation_group_1 | r2=relation_group_2  ) 
	    expression 
	;

logicalRelationStatement returns[String str]
	@init { String w=""; }  
	:   r1=relationStatement {$str = $r1.text;} 
		(  ( AND { w=" .and. "; } | OR { w=" .or. "; } ) 
		   r=relationStatement {$str = $str + w + $r.text; } 
		)* 
	;

number : INTEGER | FLOAT ;

reserved_vars : WATERYEAR | MONTH ;

reserved_funcs :  PREV_MON ;

reserved_consts : MON_CONST ;

reserved_keys : GOAL | DEFINE ;

all_ident  : reserved_vars | reserved_consts | IDENT ;

var_previous_cycle : IDENT '[' IDENT ']';
 
equals : EQUALS; 
 
MULTILINE_COMMENT : '/*' .* '*/' {skip();}; //{$channel = HIDDEN;};

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
NONE :'\''  ('NONE'|'none') '\'';

///basics///

QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
//VAR_PREVIOUS_CYCLE : IDENT '[' IDENT ']';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {skip();}; //{$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {skip();}; //{$channel = HIDDEN;};

//IGNORE : . {$channel = HIDDEN;};

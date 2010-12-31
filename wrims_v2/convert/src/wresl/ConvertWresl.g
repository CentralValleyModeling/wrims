grammar ConvertWresl;

options {
  language = Java;
}

@header {
  package wresl;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.Arrays;
  import evaluators.Dataset;
  import evaluators.Struct;
  import evaluators.Tools;
  import evaluators.Svar; 
  import evaluators.Goal; 
  import evaluators.IncludeFile;    
}

@lexer::header {
  package wresl;
}

@lexer::members {
List tokens = new ArrayList();
public void emit(Token token) {
        state.token = token;
    	tokens.add(token);
}
public Token nextToken() {
    	super.nextToken();
        if ( tokens.size()==0 ) {
            return Token.EOF_TOKEN;
        }
        return (Token)tokens.remove(0);
}
}


@members {

    public String inModel = "n";

	public String currentAbsolutePath;
	public String currentAbsoluteParent;
	public String currentFileScope;
	public Struct F = new Struct();	
	public Map<String, Struct> modelMap = new HashMap<String, Struct>();

	public Dataset dataset = new Dataset();	
	public Map<String, Dataset> modelDataMap = new HashMap<String, Dataset>();
	
	/// temp variables 
 	private ArrayList<String> list;  	private ArrayList<String> list2;
 	private String scope; 

	/// error message
	public ArrayList<String> outputErrorMessage = new ArrayList<String>();
	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		String msg = super.getErrorMessage(e, tokenNames);
			msg = msg+" in file: "+currentAbsolutePath;
			if (msg!=null){outputErrorMessage.add(msg);}
			return msg;
			}
}



evaluator 
@init { F.currentAbsolutePath=currentAbsolutePath;
		F.currentAbsoluteParent=currentAbsoluteParent; }
	:	pattern *  EOF  ;



pattern
	:   model 
	|   include
	|	sequence 
	| 	goal 
	| 	define ;

model 
scope { Struct M }
@init { inModel = "y"; }
@after{ modelMap.put($i.text, $model::M);  inModel = "n"; }
	:    MODEL i=ident  
			{   F.modelList($i.text); 
				$model::M = new Struct(); 
				$model::M.currentAbsolutePath=currentAbsolutePath;
				$model::M.currentAbsoluteParent=currentAbsoluteParent;} 
		 '{' c=(  include | goal | define )*  '}' 
		 	{
	           //  System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$: " + $model::M.include_file_scope)
	     	}    
	;

include 
	@init { scope = "global"; }
	:   INCLUDE ( LOCAL  {scope="local";} )? p=includeFilePath {
	
			        if(inModel=="n") {         F.includeFile($p.path, scope);}
	             	else             { $model::M.includeFile($p.path, scope);}
	}; 

includeFilePath returns[String path]
	:	 f=FILE_PATH  {$path=Tools.strip($f.text);}
	;

sequence
	:   SEQUENCE s=ident '{' MODEL m=ident ORDER i=INTEGER'}'{
				F.sequenceOrder($s.text, $i.text, $m.text );
		}
	;


goal	
	@init { scope = "global";}
	: GOAL ( LOCAL {scope="local";} )?  id=ident 
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
	:   '{' LHS h=ident  r=goalStatement '}' {
		if(inModel=="n") {         F.goalNoCase($id, $sc, $h.text, $r.rhs, $r.lhs_gt_rhs, $r.lhs_lt_rhs);}
	    else             { $model::M.goalNoCase($id, $sc, $h.text, $r.rhs, $r.lhs_gt_rhs, $r.lhs_lt_rhs);}
		}
	;

goal_case[String id, String sc] 
	:   '{' LHS lhs=ident  g=goalCaseStatements '}'{
			 //$g.gl.scope = $sc;
			 //$g.gl.lhs = $lhs.text;
			 if(inModel=="n") {  F.goalCase($id, $sc, $lhs.text, $g.gl);}
	   		 else             { $model::M.goalCase($id, $sc, $lhs.text, $g.gl);}
				
	     }
	; 

goalCaseStatements returns[Goal gl]					   
	@init { $gl = new Goal(); }    
	:  ( c=goalCaseStatement  {
			/// clearer data structure		
			$gl.caseName.add($c.caseName);
			$gl.caseCondition.add($c.condition);
			$gl.caseExpression.add($c.rhs);
			if ($c.lhs_gt_rhs!=null) $gl.case_lhs_gt_rhs.add($c.lhs_gt_rhs);
			else					 $gl.case_lhs_gt_rhs.add("constrain");
			if ($c.lhs_lt_rhs!=null) $gl.case_lhs_lt_rhs.add($c.lhs_lt_rhs);
			else					 $gl.case_lhs_lt_rhs.add("constrain");
			
			} )+ 
	;	

goalCaseStatement returns[String caseName, String condition, String rhs, String expression, String lhs_gt_rhs, String lhs_lt_rhs]
	:  CASE i=all_ident '{' c=conditionStatement g=goalStatement  '}' {			
			$caseName = $i.text;
			$condition = $c.str;
			$rhs = $g.rhs; $lhs_gt_rhs = $g.lhs_gt_rhs; $lhs_lt_rhs = $g.lhs_lt_rhs;
	};	

goalStatement returns[String rhs, String lhs_gt_rhs, String lhs_lt_rhs]
	//@init { $list = new ArrayList<String>(); }
	: RHS i=expression  (v1=lhs_vs_rhs (v2=lhs_vs_rhs)? )? {       
				
				///clearer data structure
				$rhs=$i.text;
				if ($v1.scenario == "l>r"){$lhs_gt_rhs=$v1.lhs_gt_rhs;}
				if ($v1.scenario == "l<r"){$lhs_lt_rhs=$v1.lhs_lt_rhs;}
				if ($v2.scenario == "l>r"){$lhs_gt_rhs=$v2.lhs_gt_rhs;}
				if ($v2.scenario == "l<r"){$lhs_lt_rhs=$v2.lhs_lt_rhs;}
				
				//if ($v1.lhs_gt_rhs!=null){$lhs_gt_rhs=$v1.lhs_gt_rhs;$lhs_lt_rhs=$v2.lhs_lt_rhs;}
				//else                     {$lhs_gt_rhs=$v2.lhs_gt_rhs;$lhs_lt_rhs=$v1.lhs_lt_rhs;}			
	};

lhs_vs_rhs returns[ArrayList<String> list, String lhs_gt_rhs, String lhs_lt_rhs, String scenario]
	@init { $list = new ArrayList<String>(); $scenario="";}
	: LHS  
	( '>' {$list.add("l>r"); $scenario = "l>r";}  |  '<' {$list.add("l<r"); $scenario = "l<r";} )  
	  RHS 
	( CONSTRAIN 
		{$list.add("constrain");$list.add(null);  
		 if ($scenario == "l>r"){$lhs_gt_rhs="constrain";}
		 else if ($scenario == "l<r"){$lhs_lt_rhs="constrain";}
		 }
	| PENALTY i=expression {$list.add("penalty");$list.add($i.text);
		 if ($scenario == "l>r"){$lhs_gt_rhs=$i.text;}
		 else if ($scenario == "l<r"){$lhs_lt_rhs=$i.text;}
		}
	) ;

/// define ///
define
	@init { scope = "global"; } 
	:	DEFINE ( LOCAL {scope="local";} )? id=ident 
	(	svar_expression[$id.text, scope]
	|	dvar_std[$id.text, scope]   | dvar_nonstd[$id.text, scope] | dvar_alias[$id.text, scope]
	|	svar_table[$id.text, scope] | svar_dss[$id.text, scope]   | svar_cases[$id.text, scope]
	|   svar_sum[$id.text, scope] 
	|   external[$id.text, scope] 
	)  
	;

external[String id, String sc]
	:	'{' EXTERNAL e=external_type '}' { 
				 if(inModel=="n") {         F.external($id, $sc, $e.text);   }
	             else             { $model::M.external($id, $sc, $e.text);   }			   
			
	};
	
external_type : F90 | DLL;	

svar_expression[String id, String sc]
	:	'{' v=valueStatement '}' {  
			     if(inModel=="n") {         F.svarExpression($id, $sc, $v.str);}
	             else             { $model::M.svarExpression($id, $sc, $v.str);}			
			};

svar_sum [String id, String sc]
	:	 '{' t=sumStatement '}' { 				  
				 if(inModel=="n") {         F.svarSum($id, $sc, $t.list, $t.str);  }
	             else             { $model::M.svarSum($id, $sc, $t.list, $t.str);  }		
	 };

svar_table[String id, String sc]
	:	'{' t=sqlStatement '}' { 
				 if(inModel=="n") {         F.svarTable($id, $sc, $t.list, $t.str);   }
	             else             { $model::M.svarTable($id, $sc, $t.list, $t.str);   }			   
			
	};

svar_cases[String id, String sc]
	:   '{' c=caseStatements '}' {   
            if(inModel=="n") {         F.svarCase($id, $sc,  $c.sv,  $c.caseNames, $c.conditions, $c.expressions, $c.caseContent);}
	        else             { $model::M.svarCase($id, $sc,  $c.sv,  $c.caseNames, $c.conditions, $c.expressions, $c.caseContent);}	        
    };
	
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
	:  CASE i=all_ident '{' c=conditionStatement 
	( s=sqlStatement   {$contentList.add("sql");$contentList.addAll($s.list);  $expressionStr=$s.str;}
	| v=valueStatement {$contentList.add("value");$contentList.add($v.str);    $expressionStr=$v.str;}
	| u=sumStatement   {$contentList.add("sum");$contentList.addAll($u.list);  $expressionStr=$u.str;}
//	| g=goalStatement  {$contentList.add("goal");$contentList.addAll($g.list);}
	) '}' {			
			$caseNameStr = $i.text;
			$conditionStr = $c.str;
			
	}
	;	


svar_dss[String id, String sc]
	:  '{' 'timeseries' kind units convertToUnits? '}' { 				
			if(inModel=="n") {         F.svarDSS($id, $sc, $kind.str, $units.str, $convertToUnits.str);}
	        else             { $model::M.svarDSS($id, $sc, $kind.str, $units.str, $convertToUnits.str);}		
		};

dvar_std[String id, String sc]
	:	'{' n=INTEGER_WORD? STD kind units'}' { 
			if(inModel=="n") {         F.dvarStd($id, $sc, $n.text, $kind.str, $units.str); }
	        else             { $model::M.dvarStd($id, $sc, $n.text, $kind.str, $units.str); }	
		};

dvar_alias[String id, String sc]
	:	'{' alias kind? units?'}' { 
			     if(inModel=="n") {         F.alias($id, $sc, $kind.str, $units.str, $alias.str);}
	             else             { $model::M.alias($id, $sc, $kind.str, $units.str, $alias.str);}
	};
	
dvar_nonstd [String id, String sc]
	:	'{' c=lower_or_upper kind units '}' {  
			if(inModel=="n") {         F.dvarNonStd($id, $sc, $kind.str, $units.str, $c.list, $c.lowerBound, $c.upperBound);}
	        else             { $model::M.dvarNonStd($id, $sc, $kind.str, $units.str, $c.list, $c.lowerBound, $c.upperBound);}
		};

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
	: ALIAS  e=expression  { $str = $e.text; }
	;
	
kind returns [String str]
	: KIND  s=QUOTE_STRING { $str =Tools.strip($s.text); } 
	;
units returns [String str]
	: UNITS  s=QUOTE_STRING   {$str =Tools.strip($s.text).toUpperCase();}
	;
//units_obsolete returns [String str]
//	: UNITS CFS {$str = "CFS";}
//	| UNITS TAF {$str = "TAF";} 
//	| UNITS ACRES {$str = "ACRES";}
//	| UNITS IN {$str = "IN";}
//	| UNITS PERCENT {$str = "PERCENT";}
//	| UNITS MG_L {$str = "mg/L";}
//	| UNITS UMHOS_CM {$str = "UMHOS/CM";} 
//	| UNITS NONE {$str = "NONE";}
//	;

convertToUnits returns [String str]
	: CONVERT s=QUOTE_STRING   {$str =Tools.strip($s.text).toUpperCase();}
	;
/// sub rules ///


conditionStatement returns[String str]
	: 'condition' 
	( s=logicalRelationStatement {$str = $s.str.replace(",","; ");}
	| ALWAYS {$str = "always";} )
	;

valueStatement returns[String str]
	: ('value'|'VALUE') e=expression {$str = $e.text;}
	;

/// SQL related ///

sqlStatement returns[ArrayList<String> list, String str]
	@init { $list = new ArrayList<String>(); }
	:  'select' i1=all_ident 
	   'from' i2=ident {$str ="select "+$i1.text+" from "+$i2.text;} 
	  ('given' i3=assignStatement {$str=$str+" given "+$i3.text;})? 
	  ('use' i4=ident {$str=$str+" use "+$i4.text;})? 
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

/// function types ///
logical_funcs : range_func;

///////////////////////////
/// Intrinsic functions ///
///////////////////////////



range_func
	: RANGE '(' MONTH ',' MONTH_CONST ',' MONTH_CONST ')' ;

max_func
	: MAX '(' expression (',' expression)+ ')' ;

min_func
	: MIN '(' expression (',' expression)+ ')' ;

other_func
	: ( INT | TAF_CFS | CFS_TAF ) '(' expression ')'
	;	

/// warning!!! inline function is masked by external function
inline_func 
	: ident '(' ( ('-' INTEGER) | PREV_MON | 'i' ) ')' ;

external_func 
	: ident '('  expression (',' expression )*  ')' ;

sumStatement returns[ArrayList<String> list, String str]
	@init { $list = new ArrayList<String>(); }
	: s=sum_func e=expression{
		$list.add($s.text.replace(",","; "));$list.add($e.text);
		$str = $s.text.replace(",","; ") + " " + $e.text;
		}
	;

sum_func
	: SUM 
	s=( '(' 'i=' expression_sum ',' expression_sum (',' '-'? INTEGER )? ')' ) 
	;

/////////////////////////////
/// sum rules in sum_func ///
/////////////////////////////
term_sum : reserved_vars | reserved_consts | prev_mon_func | INTEGER | '(' expression_sum ')' 	;
unary_sum :	('-')? term_sum ;
add_sum  :	unary_sum(('+' | '-') unary_sum)* ;
expression_sum : add_sum ;




///////////////////
/// basic rules ///
///////////////////



term
	:  ( ident | 'i' )	// weird!! ident doesn't include 'i' ??
	|  ( var_previous_cycle |  reserved_vars | reserved_consts)
	|	'(' expression ')' 
	|	number
	|    max_func  |  min_func |  other_func | external_func | prev_mon_func
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

logicalStatement : relationStatement | logical_funcs ;

logicalRelationStatement returns[String str]
	@init { String w=""; }  
	:   r1=logicalStatement {$str = $r1.text;} 
		(  ( AND { w=" .and. "; } | OR { w=" .or. "; } ) 
		   r=logicalStatement {$str = $str + w + $r.text; } 
		)* 
	;

number : INTEGER | FLOAT ;

reserved_vars : WATERYEAR | MONTH ;

prev_mon_func :  PREV_MON ;

reserved_consts : MONTH_CONST | TAF_CFS | CFS_TAF ;

reserved_keys : GOAL | DEFINE ;

all_ident  : reserved_vars | reserved_consts | ident ;

var_previous_cycle : ident '[' ident ']';
 
equals : EQUALS; 

ident : IDENT_TOKEN;



COMMENT : '!' .* ('\n'|'\r') {skip();}; //{$channel = HIDDEN;}; 
MULTILINE_COMMENT : '/*' .* '*/' {skip();}; //{$channel = HIDDEN;};

/// logical ///
AND : '.and.' | '.AND.';
OR  : '.or.'  | '.OR.';

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';

INTEGER : DIGIT+ ;
FLOAT : (INTEGER? '.' INTEGER)  |  (INTEGER '.') ;

/// intrinsic functions //
RANGE : 'range' ;
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



/// include file path ///
FILE_PATH :  '\''   DIR_SPLIT? (DIR_ELEMENT | DIR_UP)*   WRESL_FILE  '\''  ;
fragment WRESL_EXT :   '.wresl' | '.WRESL' ;
fragment WRESL_FILE :  (LETTER | DIGIT | SYMBOLS |'-'  )+ WRESL_EXT ;
fragment DIR_ELEMENT : (LETTER | DIGIT | SYMBOLS | '-' )+  '\\' ;
fragment DIR_UP :                                   ('..') '\\' ;
fragment DIR_SPLIT : '\\' ;

/// reserved keywords ///
CASE : 'case' | 'Case' | 'CASE' ;
LHS: 'lhs' | 'LHS' ;
RHS: 'rhs' | 'RHS' ;
EXTERNAL : 'EXTERNAL' | 'external' ;
F90 : 'f90';
DLL :  IDENT_TOKEN ('.dll' | '.DLL' );
INTEGER_WORD: 'integer' | 'INTEGER' ;
STD : 'std' | 'STD' ;
UNITS : 'units' | 'UNITS' ;
CONVERT : 'convert' | 'CONVERT' ;
ALIAS : 'alias' | 'ALIAS';
KIND : 'kind' | 'KIND';
GOAL : 'goal' | 'GOAL';
DEFINE :'define';
ALWAYS :'always';
CONDITION : 'condition';
SEQUENCE  : 'sequence' | 'SEQUENCE';
MODEL     : 'model' | 'MODEL' | 'Model';
ORDER     : 'order';
INCLUDE   : 'include' | 'INCLUDE' | 'Include';
LOCAL     : '[' ( 'local'| 'LOCAL') ']';

/// reserved vars ///
WATERYEAR : 'wateryear';
MONTH : 'month';

/// goal keywords ///
CONSTRAIN : 'constrain' | 'never' ;
PENALTY   : 'penalty' | 'PENALTY';

/// reserved constants ///
TAF_CFS : 'taf_cfs' | 'TAF_CFS';
CFS_TAF : 'cfs_taf' | 'CFS_TAF';
fragment MONTH_CONST_UPPER : 'JAN'|'FEB'|'MAR'|'APR'|'MAY'|'JUN'|'JUL'|'AUG'|'SEP'|'OCT'|'NOV'|'DEC';
fragment MONTH_CONST_LOWER : 'jan'|'feb'|'mar'|'apr'|'may'|'jun'|'jul'|'aug'|'sep'|'oct'|'nov'|'dec';
fragment MONTH_CAP: 'Jan'|'Feb'|'Mar'|'Apr'|'May'|'Jun'|'Jul'|'Aug'|'Sep'|'Oct'|'Nov'|'Dec'; 

MONTH_CONST : MONTH_CONST_UPPER | MONTH_CONST_LOWER | MONTH_CAP ;

/// reserved functions ///
PREV_MON : ('prev'|'Prev') MONTH_CONST; // need to force single format



///units///
//TAF :   '\''  ('TAF'  |'taf'  )  '\'';
//CFS :   '\''  ('CFS'  |'cfs'  )  '\'';
//ACRES : '\''  ('ACRES'|'acres')  '\'';
//IN :    '\''  ('IN'   |'in'   )  '\'';
//NONE :  '\''  ('NONE' |'none' )  '\'';
//MG_L :  '\''   'mg/L'            '\'';
//PERCENT :  '\''  ( 'percent' | 'PERCENT' )  '\'';
//UMHOS_CM :  '\''  ('UMHOS/CM' | 'umhos/cm')  '\'';

///basics///

QUOTE_STRING : '\'' IDENT_TOKEN ( '-' | '/' | IDENT_TOKEN )* '\'';


IDENT_FOLLOWED_BY_LOGICAL 
	: i=IDENT_TOKEN {$i.setType(IDENT_TOKEN); emit($i);}
	( a=AND { $a.setType(AND); emit($a);}
	| a=OR  { $a.setType(OR); emit($a);}
	);

IDENT_TOKEN : LETTER (LETTER | DIGIT | SYMBOLS )*;





WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {skip();}; //{$channel = HIDDEN;};

COMMENT_LAST_LINE : '!' (~('\n' | '\r'))* {skip();};

//IGNORE : . {$channel = HIDDEN;};

grammar WreslPlus;
//import CommonLexer;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@header {
  package wrimsv2.wreslplus.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
  import java.util.HashMap;
  import java.util.Set;
  import java.util.LinkedHashSet;
  import wrimsv2.wreslplus.elements.Tools;
  import wrimsv2.wreslplus.elements.TimeseriesTemp;
  import wrimsv2.wreslplus.elements.ExternalTemp;
  import wrimsv2.wreslplus.elements.DvarTemp;
  import wrimsv2.wreslplus.elements.SvarTemp;
  import wrimsv2.wreslplus.elements.ModelTemp;
  import wrimsv2.wreslplus.elements.SequenceTemp;
  import wrimsv2.wreslplus.elements.StudyTemp;
  import wrimsv2.commondata.wresldata.Param;
}
@lexer::header {
  package wrimsv2.wreslplus.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
}

@members {
	public CommonTree commonTree;
	public String currentAbsolutePath;
  	public String currentAbsoluteParent;
  	public StudyTemp styObj;
  	public Set<String> dependants;
 	
  		/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg("[parser] "+ hdr + " " + msg);
    }
}

@lexer::members {
	
	/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg("[lexer] "+ hdr + " " + msg);
    }
}
wreslPlusMain : study config* template* sequence+ model+;

wreslMain
@init{ styObj = new StudyTemp(); }
	: 
	( seq=sequence { styObj.seqList.add($seq.id); styObj.seqMap.put($seq.id,$seq.seqObj);  }    )+ 
	( m=model      { styObj.modelList.add($m.id); styObj.modelMap.put($m.id, $m.modelObj);  }    )+ 
	;

study : 'study' ID '{' include_config* include_template* include_sequence+  '}' ;

include_config :   'include' 'config' ( ID | include_file )  ;
include_template : 'include' 'template' ( ID | include_file )  ;
include_sequence : 'include' SEQUENCE ID  ;

config :  CONFIG ID '{' param* '}' ;

template : TEMPLATE ID '{' ( template_svar | template_dvar | template_dvar_array )*  '}' ;

//label : LABEL ID ;

template_dvar : '*dvar' varID '{' dvar_trunk '}' ;

template_dvar_array : '*dvar' dimension varID '{' dvar_trunk '}' ;

template_svar : '*svar' varID  svar_trunk ;

sequence returns[String id, SequenceTemp seqObj]
@init{ $seqObj = new SequenceTemp(); }
	: SEQUENCE i=ID {$id=$i.text; $seqObj.id=$i.text;} 
		'{' MODEL m=ID ORDER o=INT '}' 
		{$seqObj.model=$m.text; $seqObj.order=$o.text; $seqObj.condition="always";} 
	;


param : PARAM ID '{' ( param_simple | param_case+ )  '}' ;

param_simple : typeNumber? param_number ;

param_case: CASE logical_main '{'  typeNumber?  param_number    '}' ;

param_number : VALUE number;

//param_table : table ;


//package_: 'package'  packageName;
//packageName: ( ID '.' )*  ID ;

//wreslplus : model ;

model_standalone : model ;

model returns[String id, ModelTemp modelObj]

scope { ModelTemp model_;} 
@init{ $model::model_ = new ModelTemp(); }
	   
: MODEL i=modelName {$id=$i.text;} 
	   '{' 
	   ( include_model
	   | include_file 
	   | ts=timeseries {$model::model_.itemList.add($ts.id); $model::model_.tsList.add($ts.id); $model::model_.tsMap.put($ts.id, $ts.tsObj); }
	   | sv=svar_g     {$model::model_.itemList.add($sv.id); $model::model_.svList.add($sv.id); $model::model_.svMap.put($sv.id, $sv.svObj); } 
	   | dv=dvar_group {$model::model_.itemList.add($dv.id); $model::model_.dvList.add($dv.id); $model::model_.dvMap.put($dv.id, $dv.dvarObj); } 
	   | ex=ex_g       {$model::model_.itemList.add($ex.id); $model::model_.exList.add($ex.id); $model::model_.exMap.put($ex.id, $ex.exObj); }
	   | alias 
	   | goal_group 
	   | network 
	   | operation )+
	   '}' 
	   {$modelObj =$model::model_;}
	   ;

modelName: ID;

operation: 'operation' operationName '{' operationCase+ '}'; 

operationCase: CASE logical_main '{' ( include_model | timeseries | svar_g | dvar_group | goal_group )+  '}';

operationName: ID;

include_model returns[String id] : INCLUDE  i=ID  ('as' includeNameAs )? {$id=$i.text;} ;

include_file: INCLUDE  string_literal  ('as' includeNameAs )?  ;



//upperDir : '..\\' ;
//
//normalDir : ID  '\\' ;
//
//wreslFile :  ID ( ID | '-' )* '.' ID ;

includeNameAs: ID ;


/// goal

goalLabel : ID ;

goal_group : GOAL goal ;

goal : goalLabel '{' ( goal_simple | goal_hs  )'}' ;

goal_timeArray : dimension goal ;

goal_simple : expr_constraint ;

goal_hs :         lhs ( goal_hs_nocase | goal_hs_case+ ) ;

goal_hs_nocase :  rhs ( lhs_gt_rhs | lhs_lt_rhs )+ ;

goal_hs_case : CASE ID '{' CONDITION logical_main rhs ( lhs_gt_rhs | lhs_lt_rhs )+ '}' ;



lhs : 'lhs' expr_add ;
rhs : 'rhs' expr_add ;
lhs_gt_rhs : 'lhs' '>' 'rhs' ( penalty | constrain ) ;
lhs_lt_rhs : 'lhs' '<' 'rhs' ( penalty | constrain ) ;
penalty : 'penalty' number ;
constrain : 'constrain' ;

/// alias

alias : ( ALIAS varID '{' VALUE  expr_add  aliasKind?  aliasUnits? '}' )
 		|
 		( DEFINE varID '{' ALIAS  expr_add  aliasKind?  aliasUnits?  '}' )
 		;

aliasUnits: UNITS string_literal ;
aliasKind:  KIND string_literal ;

/// svar

svar_g returns[String id, SvarTemp svObj]
scope { SvarTemp sv_;
        String id_; 
      } 
@init{ $svar_g::sv_ = new SvarTemp(); 
       $svar_g::sv_.fromWresl = this.currentAbsolutePath; 
       dependants = new LinkedHashSet<String>();
       
	 }
@after{ $id = $svar_g::sv_.id; $svObj=$svar_g::sv_; $svObj.dependants= dependants;}	 
	: ( SVAR | DEFINE LOCAL? ) ( svar | svar_array | svar_timeArray ) ;


svarID : i=ID  {$svar_g::sv_.id =$i.text;} ;

svar: svarID '{' svar_trunk '}' ;

svar_array: dimension svar;

svar_timeArray: dimension_time svar ;

/// svar trunk

svar_trunk 
	: typeNumber? ( svar_noCase | svar_case+ ) ( svarKind svarUnits )?  ;

svarUnits: UNITS string_literal ;
svarKind:  KIND string_literal ;

svar_noCase
	@after {$svar_g::sv_.caseName.add(Param.defaultCaseName); $svar_g::sv_.caseCondition.add(Param.always);}
	: svar_value | svar_sum | svar_table 
	;

svar_case
	@after {$svar_g::sv_.caseName.add($ci.text); $svar_g::sv_.caseCondition.add($cc.text);}
	: CASE ci=ID '{' CONDITION cc=logical_main ( svar_value | svar_sum | svar_table )  '}' ;

svar_value 
	: VALUE e=expr_add
	{ $svar_g::sv_.caseExpression.add($e.text); };

svar_sum
	: h=sum_header c=sum_content
	{ $svar_g::sv_.caseExpression.add($h.text+" "+$c.text); };

sum_header 
	: SUM '(' 'i' '=' e1=expr_add ',' e2=expr_add (',' integer)?  ')' 
	;

sum_content 
	: e=expr_add ;

svar_table 
	: t1=svar_table_1 { $svar_g::sv_.caseExpression.add($t1.text); 
	  //System.out.println($svar_g::sv_.caseExpression);
	  } 
	| svar_table_2 ;

svar_table_1 
	: SELECT ID FROM ID (GIVEN expr_assign USE ID)? (WHERE expr_assign (',' expr_assign)* )?
    ;

svar_table_2
	: 'table' '(' ')' ;


// common rules

dimension : '[' ( INT | ID ) ']' ;

dimension_time : '(' ( INT | ID ) ')' ;

typeNumber: 'integer' | 'real' | 'binary' ;

//value : 'value' expr_add;

//sum: 'sum' '(' 'i' '=' INT ',' expr_add ',' INT  ')' '(' expr_add  ')';

//table : 'select' ID 'from' ID 'where' expr_assign (',' expr_assign)* ;

// end common rules



//timeseries: 'timeseries' ID '{' 'kind' '\'' .+ '\'' 'units' '\'' id_with_dash '\'' '}';
timeseries returns[String id, TimeseriesTemp tsObj]
scope { TimeseriesTemp ts_;
        String id_; 
      } 
@init{ $timeseries::ts_ = new TimeseriesTemp(); 
       $timeseries::ts_.fromWresl = this.currentAbsolutePath; 
	 }
@after{ $id = $timeseries::ts_.id; 
        $tsObj = $timeseries::ts_; 
	 }
	: timeseries_new | timeseries_old ;

timeseries_new : TIMESERIES tsID      '{' (NAME      bpart_id)? tsKind tsUnits convert? '}' ;
timeseries_old : DEFINE LOCAL? tsID   '{' TIMESERIES bpart_id? tsKind tsUnits convert? '}' ;
			
tsID : i=ID {$timeseries::ts_.id=$i.text;} ;			
tsUnits: UNITS s=string_literal {$timeseries::ts_.units=Tools.strip($s.text);} ;
tsKind:  KIND s=string_literal {$timeseries::ts_.kind=Tools.strip($s.text);} ;			
bpart_id : s=string_literal {$timeseries::ts_.dssBPart=Tools.strip($s.text);};
convert : CONVERT s=string_literal {$timeseries::ts_.convertToUnits=Tools.strip($s.text);};

/// network
network : 'network' ID '{' inlet* outlet* connection+ '}';

inlet: 'inlet' ID ;
outlet: 'outlet' ID ;

connection:    inflow? branch outflow?   ;

inflow :   '*>>' ;

outflow :  '>>*' ;

flow:  ( '~>>' | '>>' ) ;

branch : branch_start ( branch_trunk branch_end )?;

branch_start:     element ( ',' element)*   ;

branch_trunk:     flow ( element flow )*   ;

branch_end:       element ( ',' element)*   ;

branch_i : elements flow ( element flow )* elements ;

elements : element ( ',' element)* ;

element : ( ID '.' )?  ID ;



//branch:     ( id_with_port arrow_type )+ id_with_port   ;
//
//id_with_port:  inlet_port?   id  outlet_port?  ; 
//
//id_with_inlet : inlet_port?  id ;
//
//id_with_outlet :  id outlet_port? ;
//
//inlet_port : '(' ID ':)' ;
//outlet_port : '(:' ID ')' ;


/// external

ex_g returns[String id, ExternalTemp exObj]
scope { ExternalTemp ex_;
        String id_; 
      } 
@init{ $ex_g::ex_ = new ExternalTemp(); 
       $ex_g::ex_.fromWresl = this.currentAbsolutePath; 
	 }
@after{ $id = $ex_g::ex_.id; 
        $exObj = $ex_g::ex_; 
	 }
	 : ex_old | ex_new ;

ex_id : i=ID {$ex_g::ex_.id=$i.text;} ;
ex_fileName : ID '.' ID ;

ex_old : DEFINE ex_id '{' EXTERNAL f=ex_fileName {$ex_g::ex_.fileName=$f.text;} '}' ;

ex_new : EXTERNAL ex_id '{' ( ex_fortran | ex_java ) '}' ;

ex_fortran : 'language' 'fortran' '{' fortran_var+  fortran_return '}' ;

fortran_var : 'var' ID '{' 'type' 'intent' '}' ;
fortran_return : 'return' ;

ex_java : 'language' 'java' ;


/// dvar

dvar_group returns[String id, DvarTemp dvarObj]
scope { DvarTemp dvar_;
        String id_; 
      } 
@init{ $dvar_group::dvar_ = new DvarTemp(); 
       $dvar_group::dvar_.fromWresl = this.currentAbsolutePath; 
	 }
	: ( dvar_group_new | dvar_group_old ) 
	  { $id= $dvar_group::id_; $dvarObj= $dvar_group::dvar_; }
	;

dvarID : i=ID { $dvar_group::dvar_.id=$i.text; $dvar_group::id_=$i.text; };

dvar_group_old: DEFINE LOCAL? dvar ;
dvar_group_new: DVAR    dvar ;

dvar: (dvarArray|dvarTimeArray)? dvarID '{' dvar_trunk '}'  ;

dvarArray :     '[' d=( INT | ID ) ']'  {$dvar_group::dvar_.arraySize=$d.text; };
dvarTimeArray : '(' d=( INT | ID ) ')'  {$dvar_group::dvar_.timeArraySize=$d.text; };

//dvar_array : dimension dvarID '{' dvar_trunk '}'  ;
//
//dvar_timeArray:  dimension_time dvarID '{' dvar_trunk  '}'  ;
 
dvar_trunk 
	: 
	( dvarIsInteger? ( std | lower_upper ) dvKindUnits )
	| ('<' ID '>') ;

//dvar_array_trunk : ( index_assign? '{' dvar_trunk '}' )+ ;
//dvar_timeArray_trunk : ( timeIndex_assign? '{' dvar_trunk '}' )+ ;

dvarIsInteger : INTEGER {$dvar_group::dvar_.isInteger=true; $dvar_group::dvar_.upperBound="1";$dvar_group::dvar_.lowerBound="0";} ;
index_assign : '[' INT (':' INT)? ']' ;
timeIndex_assign : '(' INT (':' INT)? ')' ;

lower_upper : lower upper? | upper lower? ;
upper: UPPER ( e=expr_limited {$dvar_group::dvar_.upperBound=$e.text;} | UNBOUNDED {$dvar_group::dvar_.upperBound=Param.upper_unbounded;}) ;
lower: LOWER ( e=expr_limited {$dvar_group::dvar_.lowerBound=$e.text;} | UNBOUNDED {$dvar_group::dvar_.lowerBound=Param.lower_unbounded;}) ;

expr_limited: expr_add ; //number ( ('*' | '/') unitFunc )? ;

std: STD ;

dvKindUnits : dvKind dvUnits | dvUnits dvKind ;
dvKind:  KIND s=string_literal  {$dvar_group::dvar_.kind=$s.text;};
dvUnits: UNITS s=string_literal {$dvar_group::dvar_.units=$s.text;};






string_literal 
	: '\'' .+ '\''  ;




//================ begin logical ==============//

logical_main: logical_or | ALWAYS ;

logical_or
    :   logical_and       
        (   OR   logical_and  )*    
    ;

logical_and
    :   logical_atom       
        (   AND    logical_atom  )*    
    ;

logical_atom
    :    ( logical_relation ) => logical_relation
    |    ( logical_or_p ) => logical_or_p
    |    logical_relation_p     
    ;

logical_or_p : '(' logical_or ')' ;

logical_relation_p
	:  '(' logical_relation ')'
	;

logical_relation
	:  expr_add  relation_token  expr_add
	;

//================ end logical ==============//

relation_token: '>' | '<' | '>=' | '<=' | '==' | '!=' ;

expr_constraint
	:  expr_add  ( relation_token | '=' )  expr_add
	;

expr_relation
	:  expr_add  relation_token  expr_add
	;

expr_assign
@init{ Set<String> backup = new LinkedHashSet<String>(dependants);}
    :   expr_add {dependants = backup;} '='  expr_add  
    ;

//================ begin expr_add ==============//
expr_add
    :   expr_mult  ( ( '+' | '-' )  expr_mult   )*
    ;

expr_mult 
    :    expr_unary  ( ( '*' | '/' )  expr_unary   )*
    ; 

expr_unary: '-'? expr_term ;

expr_term 
    :   atom
    |   '(' expr_add ')'    
    ;
//================ end expr_add ==============//

atom
    :  number_p
    |  reservedID
    |  v=varID {dependants.add($v.text);} 
    | 'i' 
    | '$m'
    |  externalFunc
    |  intrinsicFunc
    |  varFunc
    |  preCycleVar
    ;

preCycleVar
	:  ID '@[' ID ']'  
	;

externalFunc
	:  'extern:(' ID '(' expr_add ')' ')'
	;
intrinsicFunc
	: mathFunc 
	| multiInputFunc
	| unitFunc
	| tableFunc
	; 
	
tableFunc : 'table' '(' tableName ',' columnNumber ',' rowNumber ')' ;

tableName : ID ;
columnNumber : INT ;
rowNumber : INT ;
	
varFunc
	: v=varID '(' ( expr_add ) ')' 
	{dependants.add($v.text);
	 //System.out.println(dependants);
	 }
	;

varID : ID ;

	
number : integer | real ;
number_p : integer_p | real_p ;

integer :	integer_p|integer_n ;
real   :	real_p|real_n ;

integer_p : INT ;
integer_n : '-' INT ;
real_p : REAL ;
real_n : '-' REAL ;


id_domain : ( ID '.' )?  ID ;

	
mathFunc 
  :  LOG '(' expr_add ')' 
  |	 INT_word '(' expr_add ')' 
  |  MOD '(' expr_add ',' expr_add ')' 
  ;
  
unitFunc
  : ( CFS_TAF | TAF_CFS ) ('(' expr_add ')')? ;  
  
multiInputFunc
  : ( MIN | MAX ) '(' expr_add ( ',' expr_add )* ')' ;
//
//// reserved ID
//DaysIn: 'daysin';
//Int: 'int';
//Real: 'real';

reservedID :  MONTH | MonthID ;


AND : '&&' | '.and.' ;
OR  : '||' | '.or.' ;

MONTH :   'month' ;
MonthID : 'jan'|'feb'|'mar'|'apr'|'may'|'jun'|'jul'|'aug'|'sep'|'oct'|'nov'|'dec';        


REAL :   ( Digit+ '.' Digit* ) | ( '.' Digit+ )  ;
INT :   Digit+ ;

MODEL :     'model' | 'MODEL' ;
SEQUENCE :  'sequence' | 'SEQUENCE' ;

ORDER :     'order' | 'ORDER' ;
INCLUDE :   'include' | 'INCLUDE' ;
CASE :      'case' | 'CASE' ;
CONDITION : 'condition' | 'CONDITION' ;
GOAL :      'goal' | 'GOAL' ;
VALUE :     'value' | 'VALUE' ;

CONFIG : 'config' ;
LABEL : 'label' ;
NAME : 'name' ;
PARAM : 'param' ;

// deprecated keyword
DEFINE : 'define' | 'DEFINE' ;
LOCAL : '[local]' | '[LOCAL]' ; 
/////////////////////////////// 

STD : 'std' | 'STD';
DVAR : 'dvar' ;
SVAR : 'svar' ;
ALIAS : 'alias' | 'ALIAS' ;
TIMESERIES : 'timeseries' ;
TEMPLATE : 'template' ;


SUM : 'sum' | 'SUM' ;
KIND : 'kind' | 'KIND' ;
UNITS : 'units' | 'UNITS' ;
CONVERT : 'convert' | 'CONVERT' ;
UPPER : 'upper' | 'UPPER' ;
LOWER : 'lower' | 'LOWER' ;

UNBOUNDED : 'unbounded'|'UNBOUNDED' ;

ALWAYS: 'always'|'ALWAYS' ;
INTEGER : 'integer'|'INTEGER';

EXTERNAL : 'external' | 'EXTERNAL' ;

SELECT : 'select' ;
FROM   : 'from' ;
WHERE  : 'where' ;
GIVEN  : 'given' ;
USE    : 'use' ;

// intrinsic function
INT_word : 'int'|'INT';
LOG : 'log' ;
MAX : 'max' ;
MIN : 'min' ;
MOD : 'mod' ;
CFS_TAF : 'cfs_taf' ;
TAF_CFS : 'taf_cfs' ;


//ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
ID : Letter ( Letter | Digit | '_' )*;


fragment Letter : 'a'..'z' | 'A'..'Z';

fragment Digit : '0'..'9';

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

ML_COMMENT : '/*' .* '*/' {$channel = HIDDEN;}; //{skip();}; 

SL_COMMENT : '#' ~('\r'|'\n')*  '\r'? '\n' {$channel=HIDDEN;} ;

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
  import wrimsv2.wreslplus.elements.DvarTemp;
}
@lexer::header {
  package wrimsv2.wreslplus.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
}

@members {
	public CommonTree commonTree;
	public String currentAbsolutePath;
  	public String currentAbsoluteParent;
  	public ArrayList<String> modelList;
  	public ArrayList<String> modelConditionList;
  	public Map<String, ArrayList<String>> modelItemMap = new HashMap<String, ArrayList<String>>();
  	public Map<String, ArrayList<String>> modelItemTypeMap = new HashMap<String, ArrayList<String>>();
  	
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
wreslMain : sequence+ model+;

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

sequence : SEQUENCE ID '{' MODEL ID ORDER INT '}' ;


param : PARAM ID '{' ( param_simple | param_case+ )  '}' ;

param_simple : typeNumber? ( param_number | param_table );

param_case: CASE logical_main '{'  typeNumber? ( param_number | param_table )    '}' ;

param_number : VALUE number;

param_table : table ;


//package_: 'package'  packageName;
//packageName: ( ID '.' )*  ID ;

//wreslplus : model ;

model
scope { ArrayList<String> itemList; 
        ArrayList<String> itemTypeList; 
      } 
@init{ $model::itemList = new ArrayList<String>();
	   $model::itemTypeList = new ArrayList<String>(); }
	   
: MODEL id=modelName '{' 
	   ( include_model
	   | include_file 
	   | timeseries 
	   | sv=svar_group //{$model::itemList.add($sv.id); $model::itemTypeList.add("svar"); }  
	   | dv=dvar_group {$model::itemList.add($dv.id); $model::itemTypeList.add("dvar"); } 
	   | alias 
	   | goal_group 
	   | network 
	   | operation )+
	   '}' 
	   {modelItemMap.put($id.text,$model::itemList );}
	   ;

modelName: ID;

operation: 'operation' operationName '{' operationCase+ '}'; 

operationCase: CASE logical_main '{' ( include_model | timeseries | svar_group | dvar_group | goal_group )+  '}';

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

alias : ( ALIAS varID '{' VALUE  expr_add  kind?  units? '}' )
 		|
 		( DEFINE varID '{' ALIAS  expr_add  kind?  units? '}' )
 		;



/// svar

svar_group: ( SVAR | DEFINE ) ( svar | svar_array | svar_timeArray ) ;

svar: varID '{' svar_trunk '}' ;

svar_array: dimension svar;

svar_timeArray: dimension_time svar ;

/// svar trunk

svar_trunk : typeNumber? ( svar_value | svar_sum | svar_table | svar_case+ ) ( kind units )?  ;

//svar_simple : svar_value | svar_sum | svar_table ;

svar_case: CASE ID '{' CONDITION logical_main ( svar_value | svar_sum | svar_table )  '}' ;

svar_value : value ;

svar_sum: sum ;

svar_table : table ;

// common rules

dimension : '[' ( INT | ID ) ']' ;

dimension_time : '(' ( INT | ID ) ')' ;

typeNumber: 'integer' | 'real' | 'binary' ;

value : 'value' expr_add;

sum: 'sum' '(' 'i' '=' INT ',' expr_add ',' INT  ')' '(' expr_add  ')';

table : 'select' ID 'from' ID 'where' expr_assign (',' expr_assign)* ;

// end common rules



//timeseries: 'timeseries' ID '{' 'kind' '\'' .+ '\'' 'units' '\'' id_with_dash '\'' '}';
timeseries: ( TIMESERIES ID '{' bpart? kind units convert? '}' )
			| ( DEFINE ID '{' TIMESERIES bpart_id? kind units convert? '}' )
			;
bpart : 'bpart' '\'' ID '\'';
bpart_id : '\'' ID '\'';

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



/// dvar

dvar_group returns[String id, DvarTemp dvar]
scope { String id_; DvarTemp dvar_;} 
@init{ $dvar_group::id_=null; $dvar_group::dvar_ = new DvarTemp(); }
	: (dvar_group_new | dvar_group_old) {$id=$dvar_group::id_;}
	;

dvarID : i=ID { $dvar_group::id_ = $i.text; };

dvar_group_old: DEFINE  dvar ;
dvar_group_new: DVAR    dvar ;

dvar: (dimension|dimension_time)? dvarID '{' dvar_trunk '}'  ;

//dvar_array : dimension dvarID '{' dvar_trunk '}'  ;
//
//dvar_timeArray:  dimension_time dvarID '{' dvar_trunk  '}'  ;
 
dvar_trunk : ( typeNumber? ( std | ( upper | lower )+ )  ( kind units ) )
		   | ('<' ID '>') ;

//dvar_array_trunk : ( index_assign? '{' dvar_trunk '}' )+ ;
//dvar_timeArray_trunk : ( timeIndex_assign? '{' dvar_trunk '}' )+ ;

index_assign : '[' INT (':' INT)? ']' ;
timeIndex_assign : '(' INT (':' INT)? ')' ;

upper: 'upper' ( expr_limited | 'unbounded' ) ;
lower: 'lower' ( expr_limited | 'unbounded' ) ;

expr_limited: number ( ('*' | '/') unitFunc )? ;

std: 'std';
units: 'units' string_literal ;

kind:  'kind' string_literal ;
convert : 'convert' string_literal ;


string_literal: '\'' .+ '\'' ;




//================ begin logical ==============//

logical_main: logical_or | ALWAYS ;

logical_or
    :   logical_and       
        (   '|'   logical_and  )*    
    ;

logical_and
    :   logical_atom       
        (   '&'    logical_atom  )*    
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
    :   expr_add  '='  expr_add  
    ;

//================ begin simple expr_add ==============//


expr_add 
    :   expr_mult
        (  ( '+' | '-' )  expr_mult   )*
    ;

expr_mult 
    :    expr_atom  ( ( '*' | '/' )  expr_atom   )*
    ; 

expr_atom 
    :   atom
    |   '(' expr_add ')'    
    ;

//================ end simple expr_add ==============//

atom
    :  number
    |  reservedID | 'i' | varID | '$m'
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
	; 
varFunc
	: varID  '(' ( expr_add ) ')' 
	;

varID : ID ;
	
number : integer | real ;
integer :	'-'?  INT ;
real   :	'-'? REAL ;

id_domain : ( ID '.' )?  ID ;

	
mathFunc 
  : ( 'log' | 'exp' ) '(' expr_add ')' ;
  
unitFunc
  : ( 'cfs_taf' | 'taf_cfs' ) ('(' expr_add ')')? ;  
  
multiInputFunc
  : ( 'min' | 'max' ) '(' expr_add ( ',' expr_add )* ')' ;
//
//// reserved ID
//DaysIn: 'daysin';
//Int: 'int';
//Real: 'real';

reservedID :  MONTH | MonthID ;

MONTH :   'month' ;
MonthID : 'jan'|'feb'|'mar'|'apr'|'may'|'jun'|'jul'|'aug'|'sep'|'oct'|'nov'|'dec';        

REAL :   Digit+ '.' Digit* ;

INT :   Digit+ ;

MODEL : 'model' ;
SEQUENCE : 'sequence' ;

ORDER : 'order' ;
INCLUDE : 'include' ;
CONFIG : 'config' ;
LABEL : 'label' ;
CASE : 'case' ;
CONDITION : 'condition' ;
GOAL : 'goal' ;
PARAM : 'param' ;
VALUE : 'value' ;

DEFINE : 'define' ;
DVAR : 'dvar' ;
SVAR : 'svar' ;
ALIAS : 'alias' ;
TIMESERIES : 'timeseries' ;
TEMPLATE : 'template' ;

ALWAYS: 'always' ;
INTEGER : 'integer' ;

//ID  :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
ID : Letter ( Letter | Digit | '_' )*;


fragment Letter : 'a'..'z' | 'A'..'Z';

fragment Digit : '0'..'9';

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

ML_COMMENT : '/*' .* '*/' {$channel = HIDDEN;}; //{skip();}; 

SL_COMMENT : '#' ~('\r'|'\n')*  '\r'? '\n' {$channel=HIDDEN;} ;

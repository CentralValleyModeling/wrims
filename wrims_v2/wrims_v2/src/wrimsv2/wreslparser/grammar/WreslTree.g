
grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
	NEW_LINE; Op; Separator; Slack_Surplus; Sign; Constrain; Free; Simple; One; Two;
	Weight_table; Assignment; External;
	Local; Global; Scope;
	Value; Case ; Dependants; VarInCycle;
	Alias; Expression;
	Dvar; Dvar_std; Dvar_nonStd; Dvar_std; Dvar_nonStd_local; Dvar_integer;
	Svar_case; Svar_dss; Svar_const; Svar_sum; Sum_hdr; B_part;
	Svar_table; Select; From; Where_content; Where_item_number; Given; Use;
	Goal_simple; Goal_no_case; Goal_case ; Lhs_gt_rhs; Lhs_lt_rhs; Never; Penalty;
	Lhs; Rhs; Weight;
	Constraint_content;
	Model;
	Sequence;
	Condition;
	Order;
	Kind; Units;
	Lower='Lower'; Upper='Upper';
	Std='Std'; Unbounded='Unbounded';	
	Exp='Exp';
	Include;
	//Or='.Or.'; And='.And.'; Not='.Not.';
	Always;
	LimitType;
}
@header {
  package wrimsv2.wreslparser.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
  import wrimsv2.wreslparser.elements.Tools; 
  import wrimsv2.commondata.wresldata.Param;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Arrays;
}
@lexer::header {
  package wrimsv2.wreslparser.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
  
}
@members {
	
    public ArrayList<String> model_in_sequence = new ArrayList<String>();
    public ArrayList<String> model_list = new ArrayList<String>();
    
    public CommonTree commonTree;
  	public String currentAbsolutePath;
  	public String currentAbsoluteParent;
  		public boolean sometest(String name) {
		
			return true;
			}
  	
	/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg(hdr + " " + msg);
    }	
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
	
	/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg(hdr + " " + msg);
    }
}
evaluator:	
	(    pattern+ 
	|  ( sequence+ model+ ) 
	) 
	    EOF!
	;

	
pattern
	: dvar | svar | goal | includeFile | alias | weight_table | external | integer
	;

integer
	: integer_std | integer_nonStd
	;

// this is actually a binary
integer_std
	: DEFINE ( '[' sc=LOCAL? ']' )? i=IDENT '{' INTEGER_WORD STD KIND k=STRING UNITS u=STRING '}'
		->  ^(Dvar_integer  Scope[$sc.text] $i Kind[$k.text] Units[$u.text]) 
	;

integer_nonStd
	: DEFINE ( '[' sc=LOCAL? ']' )? i=IDENT '{' INTEGER_WORD lower_and_or_upper KIND k=STRING UNITS u=STRING '}'
		->  ^(Dvar_integer  Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text]) 
	;

external : DEFINE ( '[' sc=LOCAL? ']' )? i=IDENT '{' EXTERNAL (e=DLL|e=F90) '}'
-> ^(External Scope[$sc.text] $i Expression[$e.text]   )
;

	
weight_table
	: OBJECTIVE ( '[' sc=LOCAL? ']' )? IDENT '=' '{'  w+=weightItem+ '}'
	-> ^(Weight_table Scope[$sc.text] $w+  ) 
	;	

weightItem
	: '['  IDENT ',' e=expression ']' (',')? 
	   -> ^(IDENT Expression[$e.text])
	;
		
model
@init { String id = null;}
	: MODEL i=IDENT '{' (pattern )+  '}' 
	   {id = $i.text.toLowerCase();  
	    model_list.add(id);}
	-> {model_in_sequence.contains(id)}?  ^(Model IDENT[id]  (pattern )+  ) 
	->   // ignore
	;
sequence
@init { String id = null;} 
	: SEQUENCE s=IDENT '{' MODEL m=IDENT ( c=condition)? ORDER INTEGER '}' 
	  {id = $m.text.toLowerCase();
	  	model_in_sequence.add(id);}
	->  ^(Sequence $s Model IDENT[id] Order INTEGER Condition[$c.text] )	 
	;
	
condition returns[String text, String dependants]
	: CONDITION 
	( e=logical_expr {$text = $e.text; $dependants = $e.dependants;}
	| ALWAYS   {$text = Param.always; }
	)
	;	

includeFile
	:	 INCLUDE ( '[' sc=LOCAL? ']' )? FILE_PATH 
	->   ^(Include Scope[$sc.text] FILE_PATH)
	;
	
alias : DEFINE ( '[' sc=LOCAL? ']' )? i=IDENT '{' ALIAS e=expression (KIND k=STRING)? (UNITS u=STRING)? '}'
	->  ^(Alias Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants])
	;	

goal
scope { String goalName; String caseName; int caseNumber;} 
@init{ $goal::caseNumber = 0; }
	: GOAL! (goal_simple | goal_case_or_nocase  )	
	;

goal_simple
	:  ( '[' sc=LOCAL? ']' )? i=IDENT '{' v=constraint_statement '}'	
->  ^(Goal_simple Scope[$sc.text] $i Dependants[$v.dependants] Constraint_content[Tools.replace_ignoreChar($v.text)] )  		
	;

goal_case_or_nocase 
	:  ( '[' s=LOCAL? ']' )? i=IDENT { $goal::goalName = $i.text;  } 
	'{' LHS l=expression 
	( 
	  ( goal_no_case_content[$l.text, $l.dependants] ->  ^( Goal_no_case Scope[$s.text] $i goal_no_case_content )  ) 	
    | ( goal_case_content[$l.text, $l.dependants]+   ->  ^( Goal_case    Scope[$s.text] $i goal_case_content+ )   )
    ) '}' 
	;

goal_case_content[String l, String d] 
	: CASE i=IDENT { $goal::caseName = $i.text;  $goal::caseNumber++; } 
	'{' c=condition RHS r=expression (s=sub_content[$l,$r.text])? '}'
	-> {s!=null}? ^( Case $i Condition[$c.text] Dependants[$d+" "+$r.dependants] $s )
	->            ^( Case $i Condition[$c.text] Dependants[$d+" "+$r.dependants] Simple Lhs[$l] Op["="] Rhs[$r.text] )
	;

goal_no_case_content[String l, String d] 
@init{ $goal::caseName = "default";   $goal::caseNumber=1;}
	: RHS r=expression (s=sub_content[$l,$r.text])?
       -> {s!=null}? Dependants[$d+" "+$r.dependants]  $s 
       ->            Dependants[$d+" "+$r.dependants]  Simple Lhs[$l] Op["="] Rhs[$r.text] 
       ;
	
sub_content[String l, String r] 
	: ( a=lhs_gt_rhs[$l,$r] ( b=lhs_lt_rhs[$l,$r])? 
		-> {b==null}? One[$a.type] $a
		->            Two[$a.type+$b.type] $a $b
		) 
		
	| ( c=lhs_lt_rhs[$l,$r] ( d=lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d )? 
		-> {d==null}? One[$c.type] $c
		->            Two[$c.type+$d.type] $c $d	
		) 
	; 
	
lhs_gt_rhs[String l, String r] returns[String type] 

	: 
LHS '>' RHS 
	( ( CONSTRAIN  { $type = "c"; } -> Constrain Lhs[$l] Op["<"] Rhs[$r] )
	| ( p=penalty { 
					if ($p.isZero){ $type = "f";   }
					else 		  { $type = "p";   }
				  }							 
		-> {$p.isZero}? Free Lhs[$l] Op[">"] Rhs[$r]  
		-> 	  		    Penalty Lhs[$l] Op["="] Rhs[$r] Sign["-"] Kind["surplus"] Slack_Surplus["u_"+$goal::goalName+"_"+Integer.toString($goal::caseNumber)] Weight["-"+$p.w] 
		//-> 	  		    Penalty Lhs[$l] Op["="] Rhs[$r] Sign["-"] Kind["surplus"] Slack_Surplus["surplus_"+$goal::goalName+"_"+$goal::caseName] Weight["-"+$p.w] 
		)
	);

lhs_lt_rhs[String l, String r]  returns[String type] 
	: 
LHS '<' RHS 
	( ( CONSTRAIN  { $type = "c"; } -> Constrain Lhs[$l] Op[">"] Rhs[$r])
	| ( p=penalty { 
					if ($p.isZero){ $type = "f";   }
					else 		  { $type = "p";   }
				  }
		-> {$p.isZero}? Free Lhs[$l] Op["<"] Rhs[$r] 
		->              Penalty Lhs[$l] Op["="] Rhs[$r] Sign["+"] Kind["slack"] Slack_Surplus["l_"+$goal::goalName+"_"+Integer.toString($goal::caseNumber)]  Weight["-"+$p.w]
		//->              Penalty Lhs[$l] Op["="] Rhs[$r] Sign["+"] Kind["slack"] Slack_Surplus["slack_"+$goal::goalName+"_"+$goal::caseName]  Weight["-"+$p.w]		
		)
	);

penalty returns[String w, boolean isZero]
	: PENALTY n=expression 
		{	$w=$n.text; 
			$isZero = false;
			
			try { 
				double p = Double.parseDouble($w); 
				if ( p == 0 ) $isZero = true;
			}
			catch (Exception e) { }
		} ;

svar : DEFINE! (svar_dss | svar_expr | svar_sum | svar_table | svar_case ) ;
		
dvar : DEFINE! (dvar_std | dvar_nonStd ) ;	

svar_case : ( '[' sc=LOCAL? ']' )? i=IDENT '{' case_content+ '}'
->  ^(Svar_case Scope[$sc.text] $i  case_content+ )  ;


case_content : CASE i=IDENT '{' c=condition ( table_content 
	-> ^(Case $i Condition[$c.text] Dependants[$c.dependants] table_content  )

	| value_content 
	-> ^(Case $i Condition[$c.text] Dependants[$c.dependants] value_content  )
	
	| sum_content
	-> ^(Case $i Condition[$c.text] Dependants[$c.dependants] sum_content  )
	
) '}' 
;

value_content : VALUE e=expression -> Value[$e.text] Dependants[$e.dependants] ;

svar_table :
	( '[' sc=LOCAL? ']' )? i=IDENT '{' table_content '}'
->  ^(Svar_table Scope[$sc.text] $i table_content )  	
	;

table_content : SELECT s=IDENT FROM f=IDENT 
				(GIVEN g=assignment USE u=IDENT)? 
				(WHERE w=where_items)? 
				
->  ^( SELECT $s FROM $f (GIVEN $g Dependants[$g.dependants]  USE $u)? (WHERE $w Dependants[$w.dependants])? )
;

where_items returns[String dependants]
	: ai=assignment (',' a=assignment {$dependants =$dependants + " " + $a.dependants; } )*
	 {$dependants =$dependants + " " + $ai.dependants; }
	;

svar_expr : 
	( '[' sc=LOCAL ']' )? IDENT '{' VALUE  e=expression'}'	
	->  ^(Svar_const Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle])  
	;	

svar_sum : ( '[' sc=LOCAL ']' )? IDENT '{' sum_content '}' 
	->  ^(Svar_sum  Scope[$sc.text] IDENT sum_content )  
	;

sum_content :SUM hdr=sum_header e=expression 
-> ^( Sum_hdr[$hdr.text] Expression[$e.text] Dependants[$e.dependants])
;

sum_header
	: ( '(' 'i=' expression ',' expression (',' '-'? INTEGER )? ')' ) 
	;

svar_dss : 
	( '[' sc=LOCAL ']' )? IDENT '{' TIMESERIES b=STRING? KIND k=STRING UNITS u=STRING (CONVERT c=STRING)? '}'
	-> ^(Svar_dss  Scope[$sc.text]  IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text]) 
	;		
	
dvar_std :
	( '[' sc=LOCAL ']' )? IDENT '{' STD KIND k=STRING UNITS u=STRING '}' 	
	->  ^(Dvar_std  Scope[$sc.text] IDENT Kind $k Units $u) 
	;	

dvar_nonStd :
	( '[' sc=LOCAL ']' )? IDENT '{' lower_and_or_upper KIND k=STRING UNITS u=STRING '}' 
	->  ^(Dvar_nonStd Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u) 
	;	

lower_and_or_upper : lower_upper
				   | upper_lower ;
				   
lower_upper : lower (u=upper)?
				-> {u==null}? lower Upper LimitType[Param.upper_unbounded]
				->            lower $u
				 ;
upper_lower : upper (l=lower)? 
                -> {l==null}? Lower LimitType["0"] upper
                ->            $l upper
   				 ;				   

lower: LOWER ( UNBOUNDED -> Lower LimitType[Param.lower_unbounded] | e=expression -> Lower LimitType[$e.tree.toStringTree().replaceAll("\\s+", "")] ) ;
upper: UPPER ( UNBOUNDED -> Upper LimitType[Param.upper_unbounded] | e=expression -> Upper LimitType[$e.tree.toStringTree().replaceAll("\\s+", "")] ) ;


/// IDENT =, <, > ///


constraint_statement returns[String text, String dependants]
	: c=constraint_statement_preprocessed
	 
	 {  $text = Tools.replace_ignoreChar($c.text); 
	    $text = Tools.replace_seperator($text); 
	    $dependants = $c.dependants;
	 };	

constraint_statement_preprocessed returns[String dependants]
	: c=expression ( '<' | '>' | '='  ) d=expression
	{ $dependants = $c.dependants + " " + $d.dependants;}
	
	;


assignment returns[String dependants] 
	:  t=term_simple  '=' e=expression { $dependants = $e.dependants;}  
	-> Assignment[$t.text+"="+$e.text]
	;
	
lt_or_gt :              term_simple ( '<'  | '>'  ) expression ;
le_or_ge :              term_simple ( '<=' | '>=' ) expression ;
equal_statement :       term_simple '==' expression ;

/// Expression ///
number : INTEGER | FLOAT ;

term_simple : ident | number | function  ;

ident: IDENT ;

term :	      i=ident {$expression::SV.add($i.text.toLowerCase());} 
	 |         number 
	 |        function 
	 |       '(' e=expression ')' {$expression::SV.addAll($e.members);} 
	 ;
	
unary :	('+'! | negation)? term 	;

negation :	'-' -> NEGATION["-"]	;

mult :	unary (('*' | '/' ) unary)* 	;
	
add :	mult (('+' | '-') mult)*	;

logical_expr returns[Set<String> members, String dependants] 
scope { Set<String> SV; } 
@init { $logical_expr::SV = new HashSet<String>(); String dependants = null; } 
	:  c_unary ( bin c_unary )* 	
	
	{  
	   //$logical_expr::SV.removeAll(reservedSet);
	   $members = $logical_expr::SV;
       for (String s : $logical_expr::SV) {
       
	   	$dependants = $dependants +" "+s;
	   }	   
	};
	
expression returns[String text, Set<String> members, String dependants, Set<String> setVarInCycle, String strVarInCycle] 
scope { Set<String> SV; Set<String> varInCycle } 
@init { $expression::SV = new HashSet<String>(); 
		$expression::varInCycle = new HashSet<String>(); 
		String dependants = null;
		String strVarInCycle = null; } 
	:
	add 
	{  $text = Tools.replace_ignoreChar($add.text); 
	   $text = Tools.replace_seperator($text);
	   
	   //$expression::SV.removeAll(reservedSet);
	   $members = $expression::SV;
       for (String s : $expression::SV) {
       
	   	$dependants = $dependants +" "+s;
	   }
	   
	   $setVarInCycle = $expression::varInCycle;
	   for (String s : $expression::varInCycle) {
       
	   	$strVarInCycle = $strVarInCycle +" "+s;
	   }    
	};	
	
c_term
	: ( expression relation expression ) => e1=expression relation e2=expression 
		{$logical_expr::SV.addAll($e1.members); $logical_expr::SV.addAll($e2.members);} 
	| function_logical
	| ( '(' logical_expr ')' ) => '(' e=logical_expr ')' {$logical_expr::SV.addAll($e.members);} 
	;	

c_unary :	(c_negation)? c_term  	;

c_negation :	NOT -> NOT[".NOT."]	;

 
	
relation : '>' | '<' | '>=' | '<=' | '==' | '/=' ;	

bin : OR -> OR[".OR."] | AND -> AND[".AND."] ;	
	
/// End Expression /// 	

/// Intrinsic functions ///

//range_func
//	: RANGE '(' MONTH ',' MONTH_CONST ',' MONTH_CONST ')' ;

function : external_func | max_func | min_func | int_func | var_model ;
function_logical : range_func ;

var_model 
	: varName=IDENT '[' cycleName = IDENT ']' 
	  {  $expression::varInCycle.add($varName.text+'['+$cycleName.text+']' );} ; //{ $expression::DV.add($i.text.toLowerCase());} ;	

external_func // this could be timeseries function
	: i=IDENT {$expression::SV.add($i.text);} '('  ie=expression (',' e=expression  {$expression::SV.addAll($e.members);}  )*  ')' 
	  {  $expression::SV.addAll($ie.members);}  // $expression::EX.add($i.text.toLowerCase()); 
	     
	;

range_func : RANGE '(' IDENT ',' IDENT ',' IDENT ')' ;

max_func
	: MAX '(' ie=expression (',' e=expression  
				{
					$expression::SV.addAll($e.members);
					$expression::varInCycle.addAll($e.setVarInCycle);
				}  
				 
			)+ ')' 
	        	
	        	{
	        		$expression::SV.addAll($ie.members);
	        		$expression::varInCycle.addAll($ie.setVarInCycle);
	        	}
	;

min_func
	: MIN '(' ie=expression (',' e=expression  
				{
					$expression::SV.addAll($e.members);
					$expression::varInCycle.addAll($e.setVarInCycle);
				}
				    
			)+ ')' 
	        	
	        	{	
	        		$expression::SV.addAll($ie.members);
	        		$expression::varInCycle.addAll($ie.setVarInCycle);
	        	}	
	;

int_func 
	: INT '(' e=expression ')' 
	{
		$expression::SV.addAll($e.members);
		$expression::varInCycle.addAll($e.setVarInCycle);
	} 
	;
	
/// End Intrinsic functions ///	

COMMENT : '!' .* ('\n'|'\r') {skip();}; //{$channel = HIDDEN;}; 
MULTILINE_COMMENT : '/*' .* '*/' {skip();}; //{$channel = HIDDEN;};

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;
FLOAT : (INTEGER? '.' INTEGER)  |  (INTEGER '.') ;


/// logical ///
AND : '.and.' | '.AND.' ;
OR  : '.or.'  | '.OR.'  ;
NOT : '.not.' | '.NOT.' ;

/// reserved keywords ///
PENALTY : 'penalty' | 'PENALTY' ;
CONSTRAIN : 'constrain' | 'CONSTRAIN' ;
INT : 'int' | 'INT' | 'Int' ;
SUM :  'sum' | 'SUM' | 'Sum' ;
RANGE : 'range' | 'RANGE' | 'Range' ;
MAX :   'max' | 'MAX' | 'Max' ;
MIN :   'min' | 'MIN' | 'Min' ;
VALUE : 'value' | 'VALUE' | 'Value' ;
LOCAL : 'local'| 'LOCAL' | 'Local' ;
OBJECTIVE: 'objective' | 'Objective' | 'OBJECTIVE';
TIMESERIES: 'timeseries' | 'TIMESERIES';
SELECT :  'select' | 'Select' | 'SELECT' ;
FROM:     'from' | 'From' | 'FROM' ;
WHERE : 'where' | 'Where' | 'WHERE';
GIVEN:    'given' | 'Given' | 'GIVEN' ;
USE:      'use' | 'Use' | 'USE' ;
CASE : 'case' | 'Case' | 'CASE' ;
LHS: 'lhs' | 'LHS' ;
RHS: 'rhs' | 'RHS' ;
EXTERNAL : 'EXTERNAL' | 'external' | 'External' ;
F90 : 'f90' | 'F90' ;
DLL :  IDENT ('.dll' | '.DLL' );
INTEGER_WORD: 'integer' | 'INTEGER' | 'Integer' ;
STD : 'std' | 'STD' ;
UNITS : 'units' | 'UNITS' | 'Units' ;
CONVERT : 'convert' | 'CONVERT' | 'Convert';
ALIAS : 'alias' | 'ALIAS';
KIND : 'kind' | 'KIND';
GOAL : 'goal' | 'GOAL' | 'Goal';
DEFINE :'define' | 'Define' | 'DEFINE';
ALWAYS :'always';
CONDITION : 'condition' | 'CONDITION' | 'Condition' ;
SEQUENCE  : 'sequence' | 'SEQUENCE';
MODEL     : 'model' | 'MODEL' | 'Model';
ORDER     : 'order' | 'ORDER';
INCLUDE   : 'include' | 'INCLUDE' | 'Include';
LOWER     : 'lower' | 'LOWER' | 'Lower' ;
UPPER     : 'upper' | 'UPPER' | 'Upper' ;
UNBOUNDED : 'unbounded' | 'Unbounded' | 'UNBOUNDED';

/// include file path ///
FILE_PATH :  '\''   DIR_SPLIT? (DIR_ELEMENT | DIR_UP)*   WRESL_FILE  '\''  ;
fragment WRESL_EXT :   '.wresl' | '.WRESL' ;
fragment WRESL_FILE :  (LETTER | DIGIT | '_' |'-'  )+ WRESL_EXT ;
fragment DIR_ELEMENT : (LETTER | DIGIT | '_' | '-' )+  '\\' ;
fragment DIR_UP :                                   ('..') '\\' ;
fragment DIR_SPLIT : '\\' ;


STRING : '\''  IDENT( '-' | '/' | IDENT )*  '\'';

IDENT_FOLLOWED_BY_LOGICAL 
	: i=IDENT{$i.setType(IDENT); emit($i);}
	( a=AND { $a.setType(AND); emit($a);}
	| a=OR  { $a.setType(OR); emit($a);}
	| a=NOT { $a.setType(NOT); emit($a);}
	);

INTEGER_FOLLOWED_BY_LOGICAL 
	: i=INTEGER{$i.setType(INTEGER); emit($i);}
	( a=AND { $a.setType(AND); emit($a);}
	| a=OR  { $a.setType(OR); emit($a);}
	| a=NOT { $a.setType(NOT); emit($a);}
	);
	
IDENT : LETTER (LETTER | DIGIT | '_')*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

COMMENT_LAST_LINE : '!' (~('\n' | '\r'))* {skip();};
//IGNORE : . {skip();};

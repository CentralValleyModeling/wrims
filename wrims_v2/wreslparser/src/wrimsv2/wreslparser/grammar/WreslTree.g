
grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
	NEW_LINE; Op; Separator;
	Local; Global; Scope;
	Value; Case ;
	Dvar; Dvar_std; Dvar_nonStd; Dvar_std; Dvar_nonStd_local;
	Svar_dss; Svar_const; Svar_sum; Sum_hdr; B_part;
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
	|    test2 
	) 
	    EOF!
	;

test:  INTEGER  'test' ;	
test2:  test ;	
	
pattern
	: dvar | svar | goal | includeFile  
	;
	
model
	: MODEL IDENT '{' (pattern )+  '}' 
	   {model_list.add($IDENT.text);}
	-> {model_in_sequence.contains($IDENT.text)}?  ^(Model IDENT  (pattern )+  ) 
	->   // ignore
	;
sequence 
	: SEQUENCE s=IDENT '{' MODEL m=IDENT ( c=condition)? ORDER INTEGER '}' 
	  {model_in_sequence.add($m.text);}
	-> {c!=null}? ^(Sequence $s Model $m Order INTEGER condition )	 
	->            ^(Sequence $s Model $m Order INTEGER Condition[Param.always] ) 
	;
	
condition
	: CONDITION logical 
	-> Condition[$logical.text]
	;	

includeFile
	:	 INCLUDE ( '[' sc=LOCAL? ']' )? FILE_PATH 
	->   ^(Include Scope[$sc.text] FILE_PATH)
	;

goal : GOAL! (goal_simple | goal_case_or_nocase  );

goal_simple
	:  ( '[' sc=LOCAL? ']' )? i=IDENT '{' v=constraint_statement '}'	
->  ^(Goal_simple Scope[$sc.text] $i Constraint_content[Tools.replace_ignoreChar($v.text)] )  		
	;

goal_case_or_nocase 
	:  ( '[' s=LOCAL? ']' )? i=IDENT '{' LHS l=expression 
	( 
	  ( goal_no_case_content[$l.text] ->  ^( Goal_no_case Scope[$s.text] $i goal_no_case_content )  ) 	
    | ( goal_case_content[$l.text]+   ->  ^( Goal_case    Scope[$s.text] $i goal_case_content+ )   )
    ) '}' 
	;

goal_case_content[String l] : 
	CASE i=IDENT '{' condition RHS r=expression sub_content[$l,$r.text] '}'
	-> ^( Case $i condition sub_content )
	;

goal_no_case_content[String l] : RHS r=expression sub_content[$l,$r.text]
       -> sub_content ;
	
sub_content[String l, String r] 
	: ( lhs_gt_rhs[$l,$r] lhs_lt_rhs[$l,$r]? ) 
	| ( lhs_lt_rhs[$l,$r] lhs_gt_rhs[$l,$r]? ) 
	; 
	
lhs_gt_rhs[String l, String r] 
	: 
LHS '>' RHS 
	( ( CONSTRAIN -> Lhs[$l] Op[">"] Rhs[$r]         Separator[""] Weight[""] )
	| ( p=penalty -> Lhs[$l] Op["-"] Rhs["("+$r+")"] Separator[":"] Weight["-"+$p.w] )
	);

lhs_lt_rhs[String l, String r] 
	: 
LHS '<' RHS 
	( ( CONSTRAIN -> Lhs[$l] Op["<"] Rhs[$r]         Separator[""] Weight[""] )
	| ( p=penalty -> Lhs[$r] Op["-"] Rhs["("+$l+")"] Separator[":"] Weight["-"+$p.w] )
	);

penalty returns[String w]: PENALTY n=number {$w=$n.text;} ;

svar : DEFINE! (svar_dss | svar_expr | svar_sum | svar_table) ;
		
dvar : DEFINE! (dvar_std | dvar_nonStd ) ;	

svar_table :
	( '[' sc=LOCAL? ']' )? i=IDENT '{' SELECT s=IDENT FROM f=IDENT (GIVEN g=assignment)? (USE u=IDENT)? WHERE w=where_items '}'
->  ^(Svar_table Scope[$sc.text] $i Select[$s.text] From[$f.text] Given[$g.text] Use[$u.text] Where_item_number[$w.n] Where_content[Tools.replace_ignoreChar($w.text)] )  	
	;

where_items returns[String n]
@init{ int number = 1; } 
	: assignment (',' assignment {number++;}  )*
	  {$n = Integer.toString(number);} 
	;

svar_expr : 
	( '[' sc=LOCAL ']' )? IDENT '{' VALUE  e=expression'}'	
	->  ^(Svar_const Scope[$sc.text] IDENT Value[$e.text] )  
	;	

svar_sum : ( '[' sc=LOCAL ']' )? IDENT '{' SUM hdr=sum_header e=expression'}' 
	->  ^(Svar_sum  Scope[$sc.text] IDENT Sum_hdr[Tools.replace_ignoreChar($hdr.text)] Value[$e.text] )  
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
				   
lower_upper : lower (upper -> lower upper)?
					-> lower Upper LimitType["Std"]
				 ;
upper_lower : upper (lower -> lower upper)? 
                   -> Lower LimitType["Std"] upper
   				 ;				   

lower: LOWER ( UNBOUNDED -> Lower LimitType["Unbounded"] | e=expression -> Lower LimitType[$e.tree.toStringTree()] ) ;
upper: UPPER ( UNBOUNDED -> Upper LimitType["Unbounded"] | e=expression -> Upper LimitType[$e.tree.toStringTree()] ) ;


/// IDENT =, <, > ///


constraint_statement : expression ( '<' | '>' | '='  ) expression  ;

assignment  :           term_simple  '=' expression ;
lt_or_gt :              term_simple ( '<'  | '>'  ) expression ;
le_or_ge :              term_simple ( '<=' | '>=' ) expression ;
equal_statement :       term_simple '==' expression ;

/// Expression ///
number : INTEGER | FLOAT ;

term_simple : IDENT | number | function  ;
term :	      IDENT | number | function  |  '(' expression ')' ;
	
unary :	('+'! | negation)? term 	;

negation :	'-' -> NEGATION	;

mult :	unary (('*' | '/' ) unary)* 	;
	
add :	mult (('+' | '-') mult)*	;
	
expression returns[String text]: 
	add 
	{  $text = Tools.replace_ignoreChar($add.text);  };	
	
c_term
	: ( expression relation expression ) => expression relation expression
	| ( '(' logical ')' ) => '(' logical ')' 
	;	

c_unary :	(c_negation)? c_term  	;

c_negation :	NOT -> NOT[".NOT."]	;

logical :  c_unary ( bin c_unary )* ;  
	
relation : '>' | '<' | '>=' | '<=' | '==' | '/=' ;	

bin : OR -> OR[".OR."] | AND -> AND[".AND."] ;	
	
/// End Expression /// 	

/// Intrinsic functions ///

//range_func
//	: RANGE '(' MONTH ',' MONTH_CONST ',' MONTH_CONST ')' ;

function : external_func | max_func | min_func | int_func ;

external_func 
	: IDENT '('  expression (',' expression )*  ')' ;

max_func
	: MAX '(' expression (',' expression)+ ')' ;

min_func
	: MIN '(' expression (',' expression)+ ')' ;

int_func : INT '(' expression ')' ;
	
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
EXTERNAL : 'EXTERNAL' | 'external' ;
F90 : 'f90';
DLL :  IDENT ('.dll' | '.DLL' );
INTEGER_WORD: 'integer' | 'INTEGER' ;
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


grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
	NEW_LINE;
	Dvar; Dvar_std; Dvar_nonStd; Dvar_std_local; Dvar_nonStd_local;
	Model;
	Sequence;
	Condition;
	Order;
	Kind; Units;
	Lower; Upper;
	Std; Unbounded;	
	Exp;
	Include;
	Or; And;
	Always;
}

@header {
  package wresl;
  import components.LogUtils; 
}

@lexer::header {
  package wresl;
    import components.LogUtils;    
}



@members {

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
}

evaluator
	:	( pattern |  sequence | model )* EOF!
	;
	
pattern
	: dvar | includeFile
	;
	
model
	: MODEL IDENT '{' (pattern )+  '}' 
	-> {sometest($IDENT.text)}?  ^(Model IDENT  (pattern )+  ) 
	->             
	;
sequence @init{boolean condition_exist=false;}
	: SEQUENCE IDENT '{' MODEL IDENT ( c=condition {condition_exist = true;})? ORDER INTEGER '}' 
	-> {condition_exist}? ^(Sequence IDENT Model IDENT Order INTEGER Condition $c )	 
	->                    ^(Sequence IDENT Model IDENT Order INTEGER Condition Always ) 
	;
	
condition
	: CONDITION e=expression_comparison_logical
	-> CONDITION["{ "+$e.text+" }"] // $e.text is the text before e's rule rewriting
	;	

includeFile
	:	 INCLUDE FILE_PATH -> ^(Include FILE_PATH)
	;
		
dvar : DEFINE! (dvar_std | dvar_std_local | dvar_nonStd | dvar_nonStd_local) ;	

	
dvar_std :
	IDENT '{' STD KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> ^(Dvar_std IDENT Kind $k Units $u) ;	

dvar_std_local :
	LOCAL IDENT  '{' STD KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> ^(Dvar_std_local IDENT Kind $k Units $u) ;

dvar_nonStd :
	IDENT '{' lower_and_or_upper KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> ^(Dvar_nonStd IDENT lower_and_or_upper Kind $k Units $u) ;

dvar_nonStd_local :
	LOCAL IDENT '{' lower_and_or_upper KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> ^(Dvar_nonStd_local IDENT lower_and_or_upper Kind $k Units $u) ;

lower_and_or_upper : lower_upper
				   | upper_lower ;
				   
lower_upper : lower (upper -> lower upper)?
					-> lower Upper Std
				 ;
upper_lower : upper (lower -> lower upper)? 
                   -> Lower Std upper
   				 ;				   

lower: LOWER ( UNBOUNDED -> Lower Unbounded | expression -> Lower expression) ;
upper: UPPER ( UNBOUNDED -> Upper Unbounded | expression -> Upper expression) ;

quote_string: 	QUOTE_STRING ;
//ident: IDENT_TOKEN ;

term
	:	IDENT
	|	'(' expression ')'-> expression
	|	INTEGER
	;
	
unary
	:	('+' | negation)? term -> negation? term	;

negation
	:	'-' -> NEGATION	;

mult
	:	unary (('*'^ | '/'^ ) unary)* 	;
	
expression
	:	mult (('+'^ | '-'^) mult)*	;
	
expression_comparison
	: expression '=='^ expression ;	

expression_comparison_logical
	: expression_comparison OR expression_comparison
	-> ^(Or expression_comparison expression_comparison)
	;	
	
	
COMMENT : '!' .* ('\n'|'\r') {skip();}; //{$channel = HIDDEN;}; 
MULTILINE_COMMENT : '/*' .* '*/' {skip();}; //{$channel = HIDDEN;};

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;

/// logical ///
AND : '.and.' | '.AND.';
OR  : '.or.'  | '.OR.';

/// reserved keywords ///
LOCAL : '[local]'| '[LOCAL]';
OBJECTIVE: 'objective' | 'Objective' | 'OBJECTIVE';
TIMESERIES: 'timeseries';
SELECT :  'select' | 'SELECT' ;
FROM:     'from' | 'FROM' ;
WHERE : 'where' | 'WHERE';
GIVEN:    'given' | 'GIVEN' ;
USE:      'use' | 'USE' ;
CASE : 'case' | 'Case' | 'CASE' ;
LHS: 'lhs' | 'LHS' ;
RHS: 'rhs' | 'RHS' ;
EXTERNAL : 'EXTERNAL' | 'external' ;
F90 : 'f90';
DLL :  IDENT ('.dll' | '.DLL' );
INTEGER_WORD: 'integer' | 'INTEGER' ;
STD : 'std' | 'STD' ;
UNITS : 'units' | 'UNITS' | 'Units' ;
CONVERT : 'convert' | 'CONVERT' ;
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


QUOTE_STRING : '\''  IDENT( '-' | '/' | IDENT )*  '\'';

IDENT_FOLLOWED_BY_LOGICAL 
	: i=IDENT{$i.setType(IDENT); emit($i);}
	( a=AND { $a.setType(AND); emit($a);}
	| a=OR  { $a.setType(OR); emit($a);}
	);

IDENT : LETTER (LETTER | DIGIT | '_')+;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

COMMENT_LAST_LINE : '!' (~('\n' | '\r'))* {skip();};
//IGNORE : . {skip();};

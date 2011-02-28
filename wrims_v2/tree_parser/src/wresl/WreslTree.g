
grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
	NEW_LINE;
	Dvar_std;
	Dvar_std_local;
	Model;
	Kind;
	Units;
	
	
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
	:	( pattern |  sequence | model | sandbox )* EOF!
	;
	
sandbox: IDENT AND IDENT ;
pattern
	: dvar
	;
	
model
	: MODEL IDENT '{' (pattern )+  '}' 
	-> {sometest($IDENT.text)}?  Model IDENT pattern+
	->             
	;
sequence
	: SEQUENCE IDENT '{' MODEL IDENT ORDER INTEGER '}' ;

	
dvar : dvar_std | dvar_std_local ;	
	
dvar_std :
	'define' IDENT '{' STD KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> Dvar_std IDENT Kind $k Units $u ;

dvar_std_local :
	'define' IDENT LOCAL  '{' STD KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> Dvar_std_local IDENT Kind $k Units $u ;

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
CONDITION : 'condition' | 'CONDITION';
SEQUENCE  : 'sequence' | 'SEQUENCE';
MODEL     : 'model' | 'MODEL' | 'Model';
ORDER     : 'order' | 'ORDER';
INCLUDE   : 'include' | 'INCLUDE' | 'Include';




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

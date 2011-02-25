
grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
	NEW_LINE;
	DVAR_STD;
}

@header {
  package wresl;
}

@lexer::header {
  package wresl;
}

@members {

  public String currentAbsolutePath;
  	public String currentAbsoluteParent;
  	}

evaluator
	:	pattern EOF!
	;

pattern
	: expression
	| dvar*
	;
	
dvar : dvar_std ;	
	
dvar_std :
	'define' IDENT '{' STD KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
	-> DVAR_STD IDENT KIND $k UNITS $u ;

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


/// reserved keywords ///
LOCAL_TOKEN : 'local'| 'LOCAL';
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
ORDER     : 'order';
INCLUDE   : 'include' | 'INCLUDE' | 'Include';


fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;

QUOTE_STRING : '\''  IDENT( '-' | '/' | IDENT )*  '\'';
IDENT : LETTER (LETTER | DIGIT | '_')+;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

COMMENT_LAST_LINE : '!' (~('\n' | '\r'))* {skip();};


grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
}

@header {
  package wresl;
}

@lexer::header {
  package wresl;
}

evaluator
	:	pattern EOF!
	;

pattern
	: expression
	| define
	;
	
define
	: 'define' IDENT
	;	

term
	:	IDENT
	|	'(' expression ')'-> expression
	|	INTEGER
	;
	
unary
	:	('+' | negation)? term -> negation? term
	;

negation
	:	'-' -> NEGATION
	;

mult
	:	unary (('*'^ | '/'^ ) unary)* 
	;
	
expression
	:	mult (('+'^ | '-'^) mult)*
	;


fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;
IDENT : LETTER (LETTER | DIGIT | '_')*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

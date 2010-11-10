lexer grammar FileIncludeLexer;

options { filter = true;}

@lexer::header {
  package wresl;
}

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};


INCLUDE: 'include' | 'Include' | 'INCLUDE'  ;


fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_' | '-' ;
fragment IDENT : (LETTER | DIGIT | SYMBOLS )+ ;

fragment WRESL : '.wresl' | '.WRESL' ;

PATH : '\'' IDENT  ('\\' IDENT )* WRESL  '\'';

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};


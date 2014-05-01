
grammar CplexLp;
@header {
package gwreader.grammar;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
}

prog: maximize subjectTo bounds End;

maximize : Maximize expr ;
subjectTo: SubjectTo ( ID ':' expr_constraint)+ ;
bounds   : Bounds expr_bound+;


expr_bound : ('-'? number '<=')? ID '<=' '-'? number | ('-'? number '<=') ID
           ;

expr_constraint : expr ('<='|'>='|'=') expr ;

expr: ('-'|'+') expr
    |   expr ('*'|'/') expr
    |   expr ('+'|'-') expr
    |   '(' expr ')'
    |   ID
    |   INT
    |   FLOAT
    |   Inf
    | term
    ;

term : number ID ;

number :  
        ( INT | FLOAT | Inf )
       ;

INT :   Digit+  ;

FLOAT:  Digit+ '.' Digit* ExponentPart?
    |   Digit+ ExponentPart
    |   '.' Digit+
    ;


fragment
ExponentPart
    :   'E' [+-]? Digit+
    ;

fragment
Digit:  '0'..'9' ; 

STRING
    :   '"' ( ~[\\"] )*? '"'
    |   '\'' ( ~[\\'] )*? '\''
    ;

// Keywords
Maximize : 'Maximize' ;             
SubjectTo : 'Subject To' ;
Bounds : 'Bounds' ;
End : 'End' ;

Inf : 'inf' ;

ID  :   Letter (Letter|Digit|'_'|'.')*
    ;

fragment Letter  : [a-zA-Z] ;


WS  :  [ \t\r\n]+ -> skip
    ;


LINE_COMMENT
    :   '\\' ~[\r\n]* -> skip
    ;
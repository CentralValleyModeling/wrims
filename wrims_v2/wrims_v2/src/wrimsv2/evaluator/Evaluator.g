grammar Evaluator;

options {
  language = Java;
}

@header {
  package wrimsv2.evaluator;
    
  import org.antlr.runtime.ANTLRFileStream;
  import org.antlr.runtime.CharStream;
  import org.antlr.runtime.CommonTokenStream;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.TokenStream;
  
  import wrimsv2.components.Error;
  import wrimsv2.components.Evaluation;
  import wrimsv2.components.EvalExpression;
  import wrimsv2.components.EvalConstraint;
}

@lexer::header {
  package wrimsv2.evaluator;
}

@members {
  public static EvalConstraint evalConstraint;
  
  @Override
  public void reportError(RecognitionException e) {
       Error.error_evaluation.add(getErrorMessage(e, tokenNames));
  }
}

evaluator returns [String result]
	:	expressionInput |
	goalInput|
	conditionInput 
	;

///////////////////
/// input rules ///
///////////////////

expressionInput: 'v:' expressionCollection;
goalInput: 'g:' constraintStatement {evalConstraint = $constraintStatement.ec;};
conditionInput: 'c:' conditionStatement;

///////////////////
/// basic rules ///
///////////////////
lhsrhs: weight|CONSTRAIN;

weight	:	(allnumber|(allnumber '*' TAFCFS)) (('+' allnumber)|('-' allnumber))?;

units: IDENT|(IDENT '/' IDENT);

fileName
  : (':'|';'|'.'|'|'|SYMBOLS|'-'|'+'|BACKSLASH|IDENT|IDENT1|IDENT2|INTEGER|FLOAT|usedKeywords)+{
  }
  ;
  
externalFile
  : (';'|'.'|'|'|SYMBOLS|'-'|'+'|INTEGER|FLOAT|IDENT|usedKeywords)+
  ;
	
text	:	LETTER (LETTER | DIGIT )*;
	
expressionCollection returns [EvalExpression ee]
	:	((expression{
	   ee=$expression.ee;
	})|(tableSQL)|(timeseriesWithUnits)|(timeseries)|(function)|(i1=sumExpression))
	;

func : 
  max_func|
  min_func|
  int_func|
  abs_func|
  log_func|
  log10_func|
  pow_func;

max_func 
	: MAX '(' (e1=expression)(';' (e2=expression))+ ')'
	;

min_func 
	: MIN '(' (e1=expression)(';' (e2=expression))+ ')'
	;
	
int_func 
  : INT '(' (e1=expression) ')'
  ;
  
abs_func 
  : ABS '(' (e1=expression) ')'
  ;

log_func 
  : LOG '(' (e1=expression) ')'
  ;

log10_func 
  : LOG10 '(' (e1=expression) ')'
  ;
  
pow_func 
  : POW '(' (e1=expression) (';' (e2=expression)) ')'
  ;
  
range_func
  : RANGE '(' MONTH ';' MONTH_CONST ';' MONTH_CONST ')' ;

timeseriesWithUnits 
	: 'timeseries' 'kind' '=' i1=partC 'units' '=' i2=IDENT
	;

timeseries 
	: 'timeseries' 
	;
	

	
partC: 	(IDENT|IDENT1|usedKeywords) ('-' (IDENT|IDENT1|usedKeywords))*;
  
usedKeywords: I|YEAR|MONTH|MONTH_CONST|PASTMONTH|RANGE|TAFCFS|DAYSIN|SUM|MAX|MIN|INT|ABS|LOG|LOG10|POW|MOD|WHERE|CONSTRAIN|ALWAYS
|NAME|DVAR|CYCLE|FILE|CONDITION|INCLUDE|LOWERBOUND|UPPERBOUND|INTEGERTYPE|UNITS|CONVERTUNITS|TYPE|OUTPUT
|CASE|ORDER|EXPRESSION|LHSGTRHS|LHSLTRHS|WEIGHT|FUNCTION|FROM_WRESL_FILE;

tableSQL 
	: 'select' ((i1=IDENT)|(u1=usedKeywords)) 'from' i2=IDENT 
	  ('given' i3=assignStatement)? ('use' i4=IDENT)? 
	  (where_items)?	  
	;

where_items 
	:	 WHERE  (r1=whereStatement)
	        (';' r=whereStatement)*
	;


upperbound:	IDENT|allnumber|(allnumber '*' TAFCFS);

lowerbound:	IDENT|allnumber|(allnumber '*' TAFCFS);

sumExpression 
  : SUM '(' I '=' e1=expression_sum ';' e2=expression_sum (';' (s='-')? INTEGER )? ')' e3=expression
  ;

term_sum: (MONTH|MONTH_CONST|PASTMONTH|I|INTEGER|'(' expression_sum ')');

unary_sum : ('-')? term_sum ;
add_sum  :  unary_sum(('+' | '-') unary_sum)* ;
expression_sum: add_sum ;

term returns [EvalExpression ee]
	:	(knownTS
	| (IDENT {ee=Evaluation.term_IDENT($IDENT.text);})
	| (SVAR{ee=Evaluation.term_SVAR($SVAR.text);}) 
	|	('(' (e=expression) ')' {ee=$e.ee;})
	|	(INTEGER {ee=Evaluation.term_INTEGER($INTEGER.text);}) 
	| (FLOAT {ee=Evaluation.term_FLOAT($FLOAT.text);}) 
	| func
	| tafcfs_term
	| YEAR
	| MONTH
	| MONTH_CONST
	| DAYSIN)
	;
	
tafcfs_term: TAFCFS|(TAFCFS'(' ('-')? INTEGER ')');
	
knownTS  
  : pastMonthTS|preMonthTS|pastCycleDV
  ;
  
pastMonthTS  
  : ((i1=IDENT)|TAFCFS) '(' ((p=PASTMONTH)|(i=I)|(pm=(MONTH_CONST '-' MONTH (('+'|'-') INTEGER)? ))|(mp=(MONTH '-' MONTH_CONST (('+'|'-') INTEGER)?))) ')'
  ;
  
preMonthTS 
  : IDENT '(' (s='-')? INTEGER ')'  
  ;
  
pastCycleDV 
  : i1=IDENT '[' i2=IDENT ']'
  ; 

function 
  : ((i1=noArgFunction)|(i2=argFunction))
  ;

noArgFunction 
  : IDENT '(' ')' 
  ;  

argFunction  
  : IDENT arguments 
  ;  
  
arguments 
  : (oneArgument|multiArguments);

oneArgument 
    :'(' ((IDENT|knownTS)) ')'
    ;


multiArguments  
  : '(' (e1=expression) (';' (e2=expression))+ ')' 
  ;
  	
unary returns [EvalExpression ee] 
	:	(s='-')? term{ee=Evaluation.unary($s.text, $term.ee);
	};
	
allnumber returns [String result]@init{result="";} 
	:	('-' {result="-";})? number{result=result+$number.result;};

mult returns [EvalExpression ee]  
	:	(u1=unary {ee=$u1.ee;}) (((s1='*')| (s2='/')| MOD) (u2=unary){
	   if ($s1.text !=null){
	     ee=Evaluation.mult(ee, $u2.ee);
	   }else if ($s2.text !=null){
	     ee=Evaluation.divide(ee, $u2.ee);
	   }else if ($MOD.text !=null){
	     ee=Evaluation.mod(ee, $u2.ee);
	   }   
  })*
	;
	
add  returns [EvalExpression ee]
	:	(m1=mult {ee=$m1.ee;}) (((s1='+') |(s2='-')) (m2=mult){
     if ($s2.text ==null){
       ee=Evaluation.add(ee, $m2.ee);
     }else{
       ee=Evaluation.minus(ee, $m2.ee);
     }
	})*
	;

expression returns [EvalExpression ee]  
	:	i=add {ee=$add.ee;} 
	;

relation
	: '=='
	| '<'
	| '>'
	| '>='
	| '<='
	;	

conditionStatement 
	:	((i1=relationStatementSeries)|ALWAYS)
	;

whereStatement 
  : ((i=IDENT)|(u=usedKeywords)) '=' expression
  ;
	
relationStatementSeries  
  : ((r1=relationStatement)|(r2=range_func)) 
    (('.and.'|'.or.') (r3=relationStatement)|(r4=range_func) )* ;

relationStatement  
	:	(e1=expression) relation (e2=expression)
	;

constraintStatement returns [EvalConstraint ec]
  : e1=expression ((s='=')|(s='>')|(s='<')) e2=expression{ec=Evaluation.constraintStatement($e1.ee, $e2.ee, $s.text);}
  ;

assignStatement returns [String result]  
  : IDENT '=' expression 
  ;

number returns [String result]
	: INTEGER {result=$INTEGER.text;}
	| FLOAT {result=$FLOAT.text;}
	;

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';	

BACKSLASH : '\\';	 	 

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER 
	  | INTEGER '.' 
	  ;

I: 'i';
YEAR: 'wateryear';
MONTH: 'month';
MONTH_CONST: 'jan'|'feb'|'mar'|'apr'|'may'|'jun'|'jul'|'aug'|'sep'|'oct'|'nov'|'dec';
PASTMONTH: 'prevjan'|'prevfeb'|'prevmar'|'prevapr'|'prevmay'|'prevjun'|'prevjul'|'prevaug'|'prevsep'|'prevoct'|'prevnov'|'prevdec';
RANGE: 'range';

TAFCFS: 'taf_cfs'|'cfs_taf'|'cfs_af';
DAYSIN: 'daysin';

SUM: 'sum';
MAX : 'max';
MIN : 'min';
INT : 'int';
ABS: 'abs';
LOG: 'log';
LOG10: 'log10';
POW: 'pow';
MOD: 'mod';
WHERE : 'where';

CONSTRAIN: 'constrain';
ALWAYS: 'always';

NAME: 'name';
DVAR: 'dvar';
CYCLE: 'cycle';
FILE: 'file';
CONDITION: 'condition';
INCLUDE: 'include';
LOWERBOUND: 'lower_bound';
UPPERBOUND: 'upper_bound';
INTEGERTYPE: 'integer';
UNITS: 'units';
CONVERTUNITS: 'convert_to_units';
TYPE: 'type';
OUTPUT: 'output';
CASE: 'case';
ORDER: 'order';
EXPRESSION: 'expression';
LHSGTRHS: 'lhs_gt_rhs';
LHSLTRHS: 'lhs_lt_rhs';
WEIGHT: 'weight';
FUNCTION: 'function';
FROM_WRESL_FILE: 'from_wresl_file';

SVAR: '{' IDENT '}';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;
IDENT1 : DIGIT (LETTER | DIGIT | SYMBOLS )*;
IDENT2 : SYMBOLS (LETTER | DIGIT | SYMBOLS )*; 

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};


	

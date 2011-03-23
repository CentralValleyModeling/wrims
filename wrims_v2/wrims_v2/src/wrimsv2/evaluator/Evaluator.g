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
}

@lexer::header {
  package wrimsv2.evaluator;
}

@members {
  public static IntDouble evalValue;
  public static EvalConstraint evalConstraint;
  public static boolean evalCondition;
  
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

expressionInput: 'v:' expressionCollection{evalValue=Evaluation.expressionInput($expressionCollection.ee);};
goalInput: 'g:' constraintStatement {evalConstraint = $constraintStatement.ec;};
conditionInput: 'c:' conditionStatement {evalCondition=$conditionStatement.result;};

///////////////////
/// basic rules ///
///////////////////
lhsrhs: expression|CONSTRAIN;

//weight	:	(allnumber|(allnumber '*' TAFCFS)) (('+' allnumber)|('-' allnumber))?;

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
	:	((expression{ee=$expression.ee;})
	|(tableSQL)
	|(timeseriesWithUnits)
	|((timeseries){ee=$timeseries.ee;})
	|(sumExpression))
	;

func returns[EvalExpression ee]: 
  (max_func{ee=$max_func.ee;})|
  (min_func{ee=$min_func.ee;})|
  (int_func{ee=$int_func.ee;})|
  (abs_func{ee=$abs_func.ee;})|
  (log_func{ee=$log_func.ee;})|
  (log10_func{ee=$log10_func.ee;})|
  (pow_func{ee=$pow_func.ee;});

max_func returns[EvalExpression ee] 
	: MAX '(' (e1=expression)(';' (e2=expression))+ ')'{
	   ee=Evaluation.max($e1.ee, $e2.ee);
	}
	;

min_func returns[EvalExpression ee]
	: MIN '(' (e1=expression)(';' (e2=expression))+ ')'{
	   ee=Evaluation.min($e1.ee, $e2.ee);
	}
	;
	
int_func returns[EvalExpression ee]
  : INT '(' (e=expression) ')'{
     ee=Evaluation.intFunc($e.ee);
  }
  ;
  
abs_func returns[EvalExpression ee]
  : ABS '(' (e=expression) ')'{
     ee=Evaluation.abs($e.ee);
  }
  ;

log_func returns[EvalExpression ee]
  : LOG '(' (e=expression) ')'{
     ee=Evaluation.log($e.ee);
  }
  ;

log10_func returns[EvalExpression ee]
  : LOG10 '(' (e=expression) ')'{
    ee=Evaluation.log10($e.ee);
  }
  ;
  
pow_func returns[EvalExpression ee]
  : POW '(' (e1=expression) (';' (e2=expression)) ')'{
     ee=Evaluation.pow($e1.ee, $e2.ee);
  }
  ;
  
range_func returns [boolean result]
  : RANGE '(' MONTH ';' m1=MONTH_CONST ';' m2=MONTH_CONST ')' {Evaluation.range($m1.text, $m2.text);};

timeseriesWithUnits 
	: 'timeseries' 'kind' '=' partC 'units' '=' IDENT 
	;

timeseries returns [EvalExpression ee]
	: 'timeseries' {ee=Evaluation.timeseries();}
	;
	

	
partC: 	(IDENT|IDENT1|usedKeywords) ('-' (IDENT|IDENT1|usedKeywords))*;
  
usedKeywords: YEAR|MONTH|MONTH_CONST|PASTMONTH|RANGE|TAFCFS|DAYSIN|SUM|MAX|MIN|INT|ABS|LOG|LOG10|POW|MOD|WHERE|CONSTRAIN|ALWAYS
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

//sumExpression 
//  : SUM '(' I '=' e1=expression_sum ';' e2=expression_sum (';' (s='-')? INTEGER )? ')' e3=expression
//  ;
//term_sum: (MONTH|MONTH_CONST|PASTMONTH|I|INTEGER|'(' expression_sum ')');

//unary_sum : ('-')? term_sum ;
//add_sum  :  unary_sum(('+' | '-') unary_sum)* ;
//expression_sum: add_sum ;

//sumExpression was redesign. If not work, switch back to the original design above

sumExpression 
  : SUM '(' IDENT{Evaluation.sumExpression_IDENT($IDENT.text);} '=' e1=expression ';' e2=expression (';' (s='-')? INTEGER )? ')' e3=expression{String text=$e3.text; System.out.println(text);}
  ;

term returns [EvalExpression ee]
	:	((knownTS{ee=Evaluation.term_knownTS($knownTS.result);})
	| (IDENT {ee=Evaluation.term_IDENT($IDENT.text);})
	| (SVAR{ee=Evaluation.term_SVAR($SVAR.text);}) 
	|	('(' (e=expression) ')' {ee=$e.ee;})
	|	(INTEGER {ee=Evaluation.term_INTEGER($INTEGER.text);}) 
	| (FLOAT {ee=Evaluation.term_FLOAT($FLOAT.text);}) 
	| func{ee=$func.ee;}
	| tafcfs_term{ee=$tafcfs_term.ee;}
	| YEAR
	| MONTH
	| MONTH_CONST
	| DAYSIN{ee=Evaluation.daysIn();})
	;
	
tafcfs_term returns [EvalExpression ee]: TAFCFS ('(' expression ')')? {
    ee=Evaluation.tafcfs_term($TAFCFS.text, $expression.ee);
};
	
knownTS returns [IntDouble result]  
  : (f=function{result=$f.result;})|(p=pastCycleDV {result=$p.result;}) 
  ;
  
//pastMonthTS  
//  : ((i1=IDENT)|TAFCFS) '(' ((p=PASTMONTH)|(i=I)|(pm=(MONTH_CONST '-' MONTH (('+'|'-') INTEGER)? ))|(mp=(MONTH '-' MONTH_CONST (('+'|'-') INTEGER)?))) ')'
//  ;
  
//preMonthTS 
//  : IDENT '(' (s='-')? INTEGER ')'  
//  ;
  
pastCycleDV returns [IntDouble result]
  : i1=IDENT '[' i2=IDENT ']'{result=Evaluation.pastCycleDV($i1.text,$i2.text);}
  ; 

function returns [IntDouble result]
  : (n=noArgFunction{result=$n.result;})|(a=argFunction{result=$a.result;})
  ;

noArgFunction returns [IntDouble result]
  : IDENT '(' ')' {result=Evaluation.noArgFunction($IDENT.text);};

argFunction returns [IntDouble result] @init{ArrayList<EvalExpression> eeArray = new ArrayList<EvalExpression>();}
  : IDENT '(' (e1=expression {eeArray.add($e1.ee);}) (';' (e2=expression{eeArray.add($e2.ee);}))* ')'{result=Evaluation.argFunction($IDENT.text,eeArray);};
  	
unary returns [EvalExpression ee] 
	:	(s='-')? term{ee=Evaluation.unary($s.text, $term.ee);
	};
	
allnumber 
	:	('-')? number;

mult returns [EvalExpression ee]  
	:	(u1=unary {ee=$u1.ee;}) (s=('*'| '/'| MOD) (u2=unary){
	   if ($s.text.equals("*")){
	     ee=Evaluation.mult(ee, $u2.ee);
	   }else if ($s.text.equals("/")){
	     ee=Evaluation.divide(ee, $u2.ee);
	   }else{
	     ee=Evaluation.mod(ee, $u2.ee);
	   }   
  })*
	;
	
add  returns [EvalExpression ee]
	:	(m1=mult {ee=$m1.ee;}) ((s=('+'|'-')) (m2=mult){
     if ($s.text.equals("+")){
       ee=Evaluation.add(ee, $m2.ee);
     }else{
       ee=Evaluation.substract(ee, $m2.ee);
     }
	})*
	;

expression returns [EvalExpression ee]  
	:	i=add {$ee=$add.ee;} 
	;

relation
	: '=='
	| '<'
	| '>'
	| '>='
	| '<='
	;	

conditionStatement returns [boolean result]
	:	((r=relationStatementSeries{result=$r.result;})|ALWAYS{result=true;})
	;

whereStatement 
  : ((i=IDENT)|(u=usedKeywords)) '=' expression
  ;
	
relationStatementSeries returns [boolean result] 
  : r1=relationRangeStatement {result=$r1.result;} 
    (((s='.and.')|(s='.or.')) r2=relationRangeStatement {result=Evaluation.relationStatementSeries(result, $r2.result, $s.text);})* ;

relationRangeStatement returns [boolean result]
  : (r1=relationStatement{result=$r1.result;})|(r2=range_func{result=$r2.result;}){
  }
  ;

relationStatement returns [boolean result] 
	:	(e1=expression) relation (e2=expression){result=Evaluation.relationStatement($e1.ee, $e2.ee, $relation.text);}
	;

constraintStatement returns [EvalConstraint ec]
  : e1=expression ((s='=')|(s='>')|(s='<')) e2=expression{ec=Evaluation.constraintStatement($e1.ee, $e2.ee, $s.text);}
  ;

assignStatement returns [String result]  
  : IDENT '=' expression {result=Evaluation.assignStatement($IDENT.text,$expression.ee);} 
  ;

number
	: INTEGER 
	| FLOAT
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

//I: 'i';
YEAR: 'wateryear';
MONTH: 'month';
MONTH_CONST: 'jan'|'feb'|'mar'|'apr'|'may'|'jun'|'jul'|'aug'|'sep'|'oct'|'nov'|'dec';
PASTMONTH: 'prevjan'|'prevfeb'|'prevmar'|'prevapr'|'prevmay'|'prevjun'|'prevjul'|'prevaug'|'prevsep'|'prevoct'|'prevnov'|'prevdec';
RANGE: 'range';

TAFCFS: 'taf_cfs'|'cfs_taf'|'cfs_af'|'af_cfs';
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


	

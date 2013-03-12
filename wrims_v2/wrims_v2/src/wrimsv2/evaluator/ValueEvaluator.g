grammar ValueEvaluator;

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
  
  import java.util.HashMap;
  import wrimsv2.components.Error;
  import wrimsv2.components.IntDouble;
}

@lexer::header {
  package wrimsv2.evaluator;
}

@members {
  public static IntDouble evalValue;
  public static boolean evalCondition;
  
  @Override
  public void reportError(RecognitionException e) {
       Error.addEvaluationError(getErrorMessage(e, tokenNames));
  }
}

evaluator returns [String result]
	:	expressionInput |
		conditionInput 
	;

///////////////////
/// input rules ///
///////////////////

expressionInput: 'v:' expressionCollection{evalValue=$expressionCollection.id;};
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
	
expressionCollection returns [IntDouble id]
	:(expression{id=$expression.id;})
	|(tableSQL){id=$tableSQL.id;}
	|(timeseriesWithUnits)
	|((timeseries){id=$timeseries.id;})
	| sumExpression {id=$sumExpression.id;}
	|(UPPERUNBOUNDED{id=new IntDouble(1e38,true);})
	|(LOWERUNBOUNDED{id=new IntDouble(-1e38,true);})
	;

func returns[IntDouble id]: 
  (max_func{id=$max_func.id;})|
  (min_func{id=$min_func.id;})|
  (int_func{id=$int_func.id;})|
  (real_func{id=$real_func.id;})|
  (abs_func{id=$abs_func.id;})|
  (exp_func{id=$exp_func.id;})|
  (log_func{id=$log_func.id;})|
  (log10_func{id=$log10_func.id;})|
  (pow_func{id=$pow_func.id;})|
  (mod_func{id=$mod_func.id;});

mod_func returns[IntDouble id]
  : MOD '(' (e1=expression) (';' (e2=expression)) ')'{
     id=ValueEvaluation.mod($e1.id, $e2.id);
  }
  ;

max_func returns[IntDouble id] 
	: MAX '(' (e1=expression){id=$e1.id;}(';' (e2=expression{
     id=ValueEvaluation.max(id, $e2.id);
  }))+ ')'
	;

min_func returns[IntDouble id]
	: MIN '(' (e1=expression){id=$e1.id;}(';' (e2=expression{
     id=ValueEvaluation.min(id, $e2.id);
  }))+ ')'
	;
	
int_func returns[IntDouble id]
  : INT '(' (e=expression) ')'{
     id=ValueEvaluation.intFunc($e.id);
  }
  ;
  
real_func returns[IntDouble id]
  : REAL '(' (e=expression) ')'{
    id=ValueEvaluation.realFunc($e.id);
  }
  ;
  
abs_func returns[IntDouble id]
  : ABS '(' (e=expression) ')'{
     id=ValueEvaluation.abs($e.id);
  }
  ;

exp_func returns[IntDouble id]
  : EXP '(' (e=expression) ')'{
     id=ValueEvaluation.exp($e.id);
  }
  ;
  
log_func returns[IntDouble id]
  : LOG '(' (e=expression) ')'{
     id=ValueEvaluation.log($e.id);
  }
  ;

log10_func returns[IntDouble id]
  : LOG10 '(' (e=expression) ')'{
    id=ValueEvaluation.log10($e.id);
  }
  ;
  
pow_func returns[IntDouble id]
  : POW '(' (e1=expression) (';' (e2=expression)) ')'{
     id=ValueEvaluation.pow($e1.id, $e2.id);
  }
  ;
  
range_func returns [boolean result]
  : RANGE '(' MONTH ';' m1=MONTH_CONST ';' m2=MONTH_CONST ')' {result=ValueEvaluation.range($m1.text, $m2.text);};

timeseriesWithUnits 
	: 'timeseries' 'kind' '=' partC 'units' '=' IDENT 
	;

timeseries returns [IntDouble id]
	: 'timeseries' {id=ValueEvaluation.timeseries();}
	;
	

	
partC: 	(IDENT|IDENT1|usedKeywords) ('-' (IDENT|IDENT1|usedKeywords))*;
  
usedKeywords: YEAR|MONTH|MONTH_CONST|DAY|PASTMONTH|RANGE|TAFCFS|DAYSIN|SUM|MAX|MIN|INT|REAL|ABS|EXP|LOG|LOG10|POW|MOD|SELECT|FROM|GIVEN|USE|WHERE
|CONSTRAIN|ALWAYS|NAME|DVAR|CYCLE|FILE|CONDITION|INCLUDE|LOWERBOUND|UPPERBOUND|INTEGERTYPE|UNITS|CONVERTUNITS|TYPE|OUTPUT
|CASE|ORDER|EXPRESSION|LHSGTRHS|LHSLTRHS|WEIGHT|FUNCTION|FROM_WRESL_FILE|UPPERUNBOUNDED|LOWERUNBOUNDED|AND|OR|NOT;

tableSQL returns [IntDouble id] @init{String table=null; String select=null; String use=null; HashMap<String, Number> given=null; HashMap<String, Number> where=null;}
	: SELECT ((i1=IDENT{select=$i1.text;})|(u1=usedKeywords{select=$u1.text;})) FROM i2=IDENT{table=$i2.text;} 
	  (GIVEN a=assignStatement{given=new HashMap<String, Number>(); given.put($a.assignIdent, $a.value);})? (USE i3=IDENT{use=$i3.text;})? 
	  (where_items{where=$where_items.where;})? {id=ValueEvaluation.tableSQL(table, select, where, given, use);}	  
	;

where_items returns [HashMap<String, Number> where]
	:	 WHERE  (r1=whereStatement{where=new HashMap<String, Number>(); where.put($r1.whereIdent, $r1.value);})
	        (';' r=whereStatement{where.put($r.whereIdent, $r.value);})*
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

sumExpression returns [IntDouble id] @init{String s="";}
  : SUM '(' IDENT{ValueEvaluation.sumExpression_IDENT($IDENT.text);} '=' e1=expression ';' e2=expression (';' (('-'{s=s+"-";})? INTEGER {s=s+$INTEGER.text;}))? (')'{ValueEvaluation.initSumExpression($e1.id, $e2.id, s);})  e3=expression{id=ValueEvaluation.sumExpression($e3.id, $e3.text);}
  ;

term returns [IntDouble id]
	:	(IDENT {id=ValueEvaluation.term_IDENT($IDENT.text);})
	| (FLOAT {id=ValueEvaluation.term_FLOAT($FLOAT.text);}) 
	| ('(' (e=expression) ')' {id=$e.id;})
	| ((knownTS{id=ValueEvaluation.term_knownTS($knownTS.result);}) 
	| func{id=$func.id;}
	| (INTEGER {id=ValueEvaluation.term_INTEGER($INTEGER.text);})
	| tafcfs_term{id=$tafcfs_term.id;}
	| YEAR{id=ValueEvaluation.term_YEAR();}
	| MONTH{id=ValueEvaluation.term_MONTH();}
	| DAY {id=ValueEvaluation.term_DAY();}
	| MONTH_CONST{id=ValueEvaluation.term_MONTH_CONST($MONTH_CONST.text);}
	| PASTMONTH{id=ValueEvaluation.term_PASTMONTH($PASTMONTH.text);}
	| DAYSIN{id=ValueEvaluation.daysIn();})
	| (SVAR{id=ValueEvaluation.term_SVAR($SVAR.text.replace("{","").replace("}",""));})
	| ARRAY_ITERATOR{id=ValueEvaluation.term_ARRAY_ITERATOR();} 
	| '(' sumExpression ')' {id=$sumExpression.id;}
	;
	
tafcfs_term returns [IntDouble id]: TAFCFS ('(' expression ')')? {
    id=ValueEvaluation.tafcfs_term($TAFCFS.text, $expression.id);
};
	
knownTS returns [IntDouble result]  
  : (f=function{result=$f.result;})|(p=pastCycleValue {result=$p.result;}) 
  ;
  
pastCycleValue returns [IntDouble result]
  : (p1=pastCycleNoTimeArray{return $p1.result;})|(p2=pastCycleTimeArray{return $p2.result;})|(p3=pastCycleIndexNoTimeArray{return $p3.result;})
  ;

pastCycleNoTimeArray returns [IntDouble result]
  : i1=IDENT '[' i2=IDENT ']'{result=ValueEvaluation.pastCycleNoTimeArray($i1.text,$i2.text);}
  ; 
  
pastCycleTimeArray returns [IntDouble result]
  : i1=IDENT '[' i2=IDENT ']' '(' e1=expression ')' {result=ValueEvaluation.pastCycleTimeArray($i1.text,$i2.text, $e1.id);}
  ; 
  
pastCycleIndexNoTimeArray returns [IntDouble result]
  : i1=IDENT '[' ('-' index=INTEGER) ']'{result=ValueEvaluation.pastCycleNoTimeArray($i1.text, -Integer.parseInt($index.text));}
  ; 

function returns [IntDouble result]
  : (n=noArgFunction{result=$n.result;})|(a=argFunction{result=$a.result;})
  ;

noArgFunction returns [IntDouble result]
  : IDENT '(' ')' {result=ValueEvaluation.noArgFunction($IDENT.text);};

argFunction returns [IntDouble result] @init{ArrayList<IntDouble> idArray = new ArrayList<IntDouble>();}
  : IDENT '(' (e1=expression {idArray.add($e1.id);}) (';' (e2=expression{idArray.add($e2.id);}))* ')'{result=ValueEvaluation.argFunction($IDENT.text,idArray);};
  	
unary returns [IntDouble id] 
	:	(s=('+'|'-'))? term{id=ValueEvaluation.unary($s.text, $term.id);
	};
	
allnumber 
	:	('-')? number;

mult returns [IntDouble id]  
	:	(u1=unary {id=$u1.id;}) (s=('*'| '/') (u2=unary){
	   if ($s.text.equals("*")){
	     id=ValueEvaluation.mult(id, $u2.id);
	   }else{
	     id=ValueEvaluation.divide(id, $u2.id);
	   }
  })*
	;
	
add  returns [IntDouble id]
	:	(m1=mult {id=$m1.id;}) ((s=('+'|'-')) (m2=mult){
     if ($s.text.equals("+")){
       id=ValueEvaluation.add(id, $m2.id);
     }else{
       id=ValueEvaluation.substract(id, $m2.id);
     }
	})*
	;

expression returns [IntDouble id]  
	:	i=add {$id=$add.id;} 
	;

relation
	: '=='
	| '<'
	| '>'
	| '>='
	| '<='
	;	

whereStatement returns [String whereIdent, Number value]
  : ((i=IDENT{$whereIdent=$i.text;})|(u=usedKeywords{$whereIdent=$u.text;})) '=' expression{$value=ValueEvaluation.assignWhereStatement($expression.id);} 
  ;

conditionStatement returns [boolean result]
	:	((r=relationUnary{result=$r.result;})|ALWAYS{result=true;})
	;

relationUnary returns [boolean result]
  : (n=NOT)? r=relationStatementSeries{
      if ($n==null){
        return $r.result;
      }else{
        if ($r.result){
          return false;
        }else{
          return true;
        }
      }
  }
  ; 
	
relationStatementSeries returns [boolean result] 
  : r1=relationRangeStatement {result=$r1.result;} 
    (((s=AND)|(s=OR)) r2=relationRangeStatement {result=ValueEvaluation.relationStatementSeries(result, $r2.result, $s.text);})* ;

relationRangeStatement returns [boolean result]
  : (r1=relationStatement{result=$r1.result;})|(r2=range_func{result=$r2.result;})
  ;

relationStatement returns [boolean result] 
	: (	( expression relation expression) => e1=expression relation e2=expression {result=ValueEvaluation.relationStatement($e1.id, $e2.id, $relation.text);} )
	| ( ( '('relationUnary')'  ) => '('r2=relationUnary')' {result=$r2.result;} )
	;

assignStatement returns [String assignIdent, Number value]  
  : IDENT '=' expression {$assignIdent=$IDENT.text; $value=ValueEvaluation.assignWhereStatement($expression.id);} 
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
DAY: 'day';
MONTH_CONST: 'jan'|'feb'|'mar'|'apr'|'may'|'jun'|'jul'|'aug'|'sep'|'oct'|'nov'|'dec';
PASTMONTH: 'prevjan'|'prevfeb'|'prevmar'|'prevapr'|'prevmay'|'prevjun'|'prevjul'|'prevaug'|'prevsep'|'prevoct'|'prevnov'|'prevdec';
RANGE: 'range';

TAFCFS: 'taf_cfs'|'cfs_taf'|'cfs_af'|'af_cfs';
DAYSIN: 'daysin'|'daysinmonth';

ARRAY_ITERATOR : '$m' ;

AND: '.and.';
OR: '.or.';
NOT: '.not.';

SUM: 'sum';
MAX : 'max';
MIN : 'min';
INT : 'int';
REAL: 'real';
ABS: 'abs';
EXP: 'exp';
LOG: 'log';
LOG10: 'log10';
POW: 'pow';
MOD: 'mod';

SELECT: 'select';
FROM: 'from';
GIVEN: 'given';
USE: 'use';
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
UPPERUNBOUNDED: 'upper_unbounded';
LOWERUNBOUNDED: 'lower_unbounded';

SVAR: '{' IDENT '}';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;
IDENT1 : DIGIT (LETTER | DIGIT | SYMBOLS )*;
IDENT2 : SYMBOLS (LETTER | DIGIT | SYMBOLS )*; 

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};


	

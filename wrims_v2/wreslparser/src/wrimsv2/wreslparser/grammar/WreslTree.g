
grammar WreslTree;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}
tokens {
	NEGATION;
	NEW_LINE;
	Local; Global;
	Value;
	Dvar; Dvar_std; Dvar_nonStd; Dvar_std; Dvar_nonStd_local;
	Svar_dss; Svar_const; Svar_sum; Sum_hdr; B_part;
	Svar_table; Select; From; Where_content; Where_item_number; Given; Use;
	Goal_simple;
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
	->             
	;
sequence 
	: SEQUENCE s=IDENT '{' MODEL m=IDENT ( c=condition)? ORDER INTEGER '}' 
	  {model_in_sequence.add($m.text);}
	-> {c!=null}? ^(Sequence $s Model $m Order INTEGER Condition condition )	 
	->            ^(Sequence $s Model $m Order INTEGER Condition CONDITION[Param.always] ) 
	;
	
condition
	: CONDITION logical 
	-> CONDITION[$logical.text]
	;	

includeFile
	:	 INCLUDE s=LOCAL? FILE_PATH 
	-> {s!=null}? ^(Include Local  FILE_PATH)
	->            ^(Include Global FILE_PATH)
	;

goal : goal_simple ;

goal_simple
	:  GOAL s=LOCAL? i=IDENT '{' v=constraint_content '}'
	{  System.out.println("#####"+$v.text); }
-> {s!=null}? ^(Goal_simple Local  $i Constraint_content[Tools.replace_ignoreChar($v.text)] ) 	
->            ^(Goal_simple Global $i Constraint_content[Tools.replace_ignoreChar($v.text)] )  	
	
	;


svar : DEFINE! (svar_dss | svar_expr | svar_sum | svar_table) ;
		
dvar : DEFINE! (dvar_std | dvar_nonStd ) ;	

svar_table :
	s=LOCAL? i=IDENT '{' SELECT s=IDENT FROM f=IDENT (GIVEN g=assignment)? (USE u=IDENT)? WHERE w=where_items '}'
-> {s!=null}? ^(Svar_table Local  $i Select[$s.text] From[$f.text] Given[$g.text] Use[$u.text] Where_item_number[$w.n] Where_content[Tools.replace_ignoreChar($w.text)] ) 	
->            ^(Svar_table Global $i Select[$s.text] From[$f.text] Given[$g.text] Use[$u.text] Where_item_number[$w.n] Where_content[Tools.replace_ignoreChar($w.text)] )  	
	;

where_items returns[String n]
@init{ int number = 1; } 
	: assignment (',' assignment {number++;}  )*
	  {$n = Integer.toString(number);} 
	;


svar_expr : 
	s=LOCAL? IDENT '{' VALUE  e=expression'}'
	-> {s!=null}? ^(Svar_const  Local  IDENT Value[$e.text] ) 	
	->            ^(Svar_const  Global IDENT Value[$e.text] )  
	;	

svar_sum : s=LOCAL? IDENT '{' SUM hdr=sum_header e=expression'}' 
	-> {s!=null}? ^(Svar_sum  Local  IDENT Sum_hdr[Tools.replace_ignoreChar($hdr.text)] Value[$e.text] ) 	
	->            ^(Svar_sum  Global IDENT Sum_hdr[Tools.replace_ignoreChar($hdr.text)] Value[$e.text] )  
	;

sum_header
	: ( '(' 'i=' expression ',' expression (',' '-'? INTEGER )? ')' ) 
	
	;

svar_dss : 
	s=LOCAL? IDENT '{' TIMESERIES b=STRING? KIND k=STRING UNITS u=STRING (CONVERT c=STRING)? '}'
	-> {s!=null}? ^(Svar_dss  Local  IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text]) 	
	->            ^(Svar_dss  Global IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text])  
	;		
	
dvar_std :
	s=LOCAL? IDENT '{' STD KIND k=STRING UNITS u=STRING '}' 
	-> {s!=null}? ^(Dvar_std  Local  IDENT Kind $k Units $u) 	
	->            ^(Dvar_std  Global IDENT Kind $k Units $u) 
	;	

dvar_nonStd :
	s=LOCAL? IDENT '{' lower_and_or_upper KIND k=STRING UNITS u=STRING '}' 
	-> {s!=null}? ^(Dvar_nonStd Local  IDENT lower_and_or_upper Kind $k Units $u) 
	->            ^(Dvar_nonStd Global IDENT lower_and_or_upper Kind $k Units $u) 
	;	

//dvar_nonStd :
//	IDENT '{' lower_and_or_upper KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
//	-> ^(Dvar_nonStd IDENT lower_and_or_upper Kind $k Units $u) ;
//
//dvar_nonStd_local :
//	LOCAL IDENT '{' lower_and_or_upper KIND k=QUOTE_STRING UNITS u=QUOTE_STRING '}' 
//	-> ^(Dvar_nonStd_local IDENT lower_and_or_upper Kind $k Units $u) ;

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

constraint_content : assignment | less_or_greater_than ;
assignment  :   IDENT '=' expression ;
less_or_greater_than :  IDENT ( '<' | '>' ) expression ;

/// Expression ///
number : INTEGER | FLOAT ;

term
	:	IDENT
	|	'(' expression ')'
	|  number
	|  max_func  |  min_func | external_func 
	;
	
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

external_func 
	: IDENT '('  expression (',' expression )*  ')' ;

max_func
	: MAX '(' expression (',' expression)+ ')' ;

min_func
	: MIN '(' expression (',' expression)+ ')' ;
	
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
SUM :  'sum' | 'SUM' | 'Sum' ;
MAX :   'max' | 'MAX' | 'Max' ;
MIN :   'min' | 'MIN' | 'Min' ;
VALUE : 'value' | 'VALUE' | 'Value' ;
LOCAL : '[local]'| '[LOCAL]' | '[Local]' ;
OBJECTIVE: 'objective' | 'Objective' | 'OBJECTIVE';
TIMESERIES: 'timeseries' | 'TIMESERIES';
SELECT :  'select' | 'SELECT' ;
FROM:     'from' | 'FROM' ;
WHERE : 'where' | 'WHERE';
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

IDENT : LETTER (LETTER | DIGIT | '_')*;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};

COMMENT_LAST_LINE : '!' (~('\n' | '\r'))* {skip();};
//IGNORE : . {skip();};

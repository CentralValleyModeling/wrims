
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
	Dvar; Dvar_std; Dvar_nonStd; Dvar_std; Dvar_nonStd_local;
	Svar_dss; B_part;
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
	: dvar | svar | includeFile 
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
	->            ^(Sequence $s Model $m Order INTEGER Condition CONDITION["Always"] ) 
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

svar : DEFINE! (svar_dss ) ;
		
dvar : DEFINE! (dvar_std | dvar_nonStd ) ;	

svar_dss : 
	s=LOCAL? IDENT '{' TIMESERIES b=STRING? KIND k=STRING UNITS u=STRING '}'
	-> {s!=null}? ^(Svar_dss  Local  IDENT  Kind $k Units $u) 	
	->            ^(Svar_dss  Global IDENT  Kind $k Units $u) 
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


/// Expression ///
term
	:	IDENT
	|	'(' expression ')'
	|	INTEGER
	;
	
unary :	('+'! | negation)? term 	;

negation :	'-' -> NEGATION	;

mult :	unary (('*' | '/' ) unary)* 	;
	
expression :	mult (('+' | '-') mult)*	;
	
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


COMMENT : '!' .* ('\n'|'\r') {skip();}; //{$channel = HIDDEN;}; 
MULTILINE_COMMENT : '/*' .* '*/' {skip();}; //{$channel = HIDDEN;};

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;

/// logical ///
AND : '.and.' | '.AND.' ;
OR  : '.or.'  | '.OR.'  ;
NOT : '.not.' | '.NOT.' ;

/// reserved keywords ///
LOCAL : '[local]'| '[LOCAL]' ;
OBJECTIVE: 'objective' | 'Objective' | 'OBJECTIVE';
TIMESERIES: 'timeseries' | 'TIMESERIES';
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

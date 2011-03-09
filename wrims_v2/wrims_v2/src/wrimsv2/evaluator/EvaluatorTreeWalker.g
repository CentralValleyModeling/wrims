tree grammar EvaluatorTreeWalker;

options {
  language = Java;
  tokenVocab = EvaluatorTree;
  ASTLabelType = CommonTree;
}

@header {
  package wrimsv2.evaluator;
  import java.util.Map;
  import java.util.HashMap; 
}

@members {

  public int result;
  public CommonTree commonTree;
  public String currentAbsolutePath;
  public String currentAbsoluteParent;
  private Map<String, Integer> variables = new HashMap<String, Integer>();

  	
  		/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
    }
}

evaluator returns [int result]
@init { }

	:	( e=expression {$result =$e.result; } ) 
	     EOF
	;

	
	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;


lower : Lower (Std |Unbounded | expression ) ;
upper : Upper (Std |Unbounded | expression ) ;

		
condition 
	: Condition ( CONDITION | Always ) 
	;	

//sequence
//	:   SEQUENCE s=ident '{' MODEL m=ident c=conditionStatement? ORDER i=INTEGER'}'{
//				F.sequenceOrder($s.text, $i.text, $m.text, $c.str );
//		}
//	;	
	
	
expression returns [int result]
	:	^('+' op1=expression op2=expression) { result = op1 + op2; }
	|	^('-' op1=expression op2=expression) { result = op1 - op2; }
	|	^('*' op1=expression op2=expression) { result = op1 * op2; }
	|	^('/' op1=expression op2=expression) { result = op1 / op2; }
	|	^(NEGATION e=expression)  { result = -e; }
	|	IDENT //{ result = variables.get($IDENT.text); }
	|	INTEGER { result = Integer.parseInt($INTEGER.text); }
	;


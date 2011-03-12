tree grammar EvaluatorTreeWalker;

options {
  language = Java;
  tokenVocab = EvaluatorTree;
  ASTLabelType = CommonTree;
}

@header {
  package grammar;
  import java.util.Map;
  import java.util.HashMap;
  import elements.Tools;
  import elements.LogUtils; 
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
        LogUtils.errMsg(hdr + " " + msg);
    }
}

evaluator returns [int result]

	:	( e=expression {$result =$e.result; } ) 
	     EOF
	;

	
	

	
	
expression returns [int result]
	:	^('+' op1=expression op2=expression) { result = op1 + op2; }
	|	^('-' op1=expression op2=expression) { result = op1 - op2; }
	|	^('*' op1=expression op2=expression) { result = op1 * op2; }
	|	^('/' op1=expression op2=expression) { result = op1 / op2; }
	|	^(NEGATION e=expression)  { result = -e; }
	|	IDENT //{ result = variables.get($IDENT.text); }
	|	INTEGER { result = Integer.parseInt($INTEGER.text); }
	;


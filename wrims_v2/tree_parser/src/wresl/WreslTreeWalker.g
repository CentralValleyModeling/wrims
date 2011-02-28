tree grammar WreslTreeWalker;

options {
  language = Java;
  tokenVocab = WreslTree;
  ASTLabelType = CommonTree;
}

@header {
  package wresl;
  import java.util.Map;
  import java.util.HashMap;
  import components.Struct;
  import components.Tools;
  import components.LogUtils; 
}

@members {

  public int result;
  public CommonTree commonTree;
  public String currentAbsolutePath;
  	public String currentAbsoluteParent;
  private Map<String, Integer> variables = new HashMap<String, Integer>();
  
  	public Struct F = new Struct();	
  	
  		/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg(hdr + " " + msg);
    }
}

evaluator returns [int result]
@init { F.currentAbsolutePath=currentAbsolutePath;
		F.currentAbsoluteParent=currentAbsoluteParent; }



	:	( pattern |  sequence | model )* EOF
	;

	
pattern
	: dvar
	;


	
	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;

dvar : Dvar_std i=IDENT Kind k=QUOTE_STRING Units u=QUOTE_STRING
	{ 	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$: " +$i.text); 
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$: " +Tools.strip($k.text)); 
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$: " +Tools.strip($u.text)); 
    	F.dvarStd($i.text, "local", "", Tools.strip($k.text), Tools.strip($u.text));
	}

	;

model
	: MODEL IDENT '{' (pattern )+  '}' 
	;	
	
sequence
	: SEQUENCE IDENT '{' MODEL IDENT ORDER INTEGER '}' ;	
	
expression returns [int result]
	:	^('+' op1=expression op2=expression) { result = op1 + op2; }
	|	^('-' op1=expression op2=expression) { result = op1 - op2; }
	|	^('*' op1=expression op2=expression) { result = op1 * op2; }
	|	^('/' op1=expression op2=expression) { result = op1 / op2; }
	|	^(NEGATION e=expression)  { result = -e; }
	|	IDENT { result = variables.get($IDENT.text); }
	|	INTEGER { result = Integer.parseInt($INTEGER.text); }
	;


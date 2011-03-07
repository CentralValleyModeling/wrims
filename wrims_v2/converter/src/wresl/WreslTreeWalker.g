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
  import components_tree.StructTree;
  import components_tree.Tools;
  import components_tree.LogUtils; 
}

@members {

  public int result;
  public CommonTree commonTree;
  public String currentAbsolutePath;
  	public String currentAbsoluteParent;
  private Map<String, Integer> variables = new HashMap<String, Integer>();
  
  	public StructTree F = new StructTree();	
  	
  		/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg(hdr + " " + msg);
    }
}

evaluator
@init { F.currentAbsolutePath=currentAbsolutePath;
		F.currentAbsoluteParent=currentAbsoluteParent; }

	:	( pattern |  sequence | model |test2 )+
	     EOF
	;
test:  INTEGER 'test' ;	
test2:  t=test {  System.out.println("yyyyyyyyyyyyy"+$t.text  ); };		
pattern
	: dvar | includeFile
	;

includeFile
	:	 ^(Include p=INCLUDE) {F.includeFile($p.text, "");}
	;
	
	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;

dvar : dvar_std | dvar_nonStd   ;

dvar_std  
	@after{ F.dvarStd($i.text, $s.text, "", Tools.strip($k.text), Tools.strip($u.text)); }
	:
       ^(Dvar_std s=Global i=IDENT Kind k=STRING Units u=STRING)
	|  ^(Dvar_std s=Local  i=IDENT Kind k=STRING Units u=STRING)
	;
	
dvar_nonStd : 
	   ^(Dvar_nonStd (sc=Global|sc=Local) i=IDENT Lower lr=RangeType Upper ur=RangeType Kind k=STRING Units u=STRING)
	   { System.out.println("zzzzlrzzzzzzz"+$lr.text);
	     System.out.println("zzzzurzzzzzzz"+$ur.text);

	   }
	   //{F.dvarNonStd($i.text, $sc.text, $k.text, $u.text,  $lb.text, $ub.text);}
	;



model
	: ^(Model IDENT  (pattern )+ ) 
	;	
	
sequence
	: ^(Sequence s=IDENT Model m=IDENT Order i=INTEGER condition ) 

	;
		
condition 
	: Condition ( logical | Always ) 
	;	

//sequence
//	:   SEQUENCE s=ident '{' MODEL m=ident c=conditionStatement? ORDER i=INTEGER'}'{
//				F.sequenceOrder($s.text, $i.text, $m.text, $c.str );
//		}
//	;	
	
	
/// Expression ///
term
	:	IDENT
	|	'(' expression ')'
	|	INTEGER
	;
	
unary :	NEGATION? term 	;

mult :	unary (('*' | '/' ) unary)* 	;
	
expression :	mult (('+' | '-') mult)*	;
	
c_term
	: ( expression relation expression ) => expression relation expression
	| ( '(' logical ')' ) => '(' logical ')' 
	;	

c_unary :	Not? c_term  	;

logical :  c_unary ( bin c_unary )* ;  
	
relation : '>' | '<' | '>=' | '<=' | '==' | '/=' ;	

bin : Or | And ;	
	
/// End Expression /// 


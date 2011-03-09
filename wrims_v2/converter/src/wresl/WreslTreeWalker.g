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

  
  	public StructTree F = new StructTree();	
  	public Map<String, StructTree> modelMap = new HashMap<String, StructTree>();
  	
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
	:	
	(       pattern[F]+ 
	|     ( sequence | model )+ 
	|       test2 
	)
	     EOF
	;
test:  INTEGER 'test' ;	
test2:  t=test {  System.out.println("yyyyyyyyyyyyy"+$t.text  ); };		

pattern[StructTree struct]

	: dvar[$struct] | includeFile[$struct]
	;

sequence 
	:  ^(Sequence s=IDENT Model m=IDENT Order i=INTEGER Condition c=CONDITION ) 
		{
			F.sequenceOrder($s.text, $i.text, $m.text, $c.text);
			
			StructTree M = new StructTree();
			M.currentAbsolutePath=currentAbsolutePath;
			M.currentAbsoluteParent=currentAbsoluteParent;
			modelMap.put($m.text, M);
		}


	;

model
	: ^(Model i=IDENT  			
				{   F.modelList($i.text); } 
				
				(pattern[modelMap.get($i.text)] )+ ) 
	;	

includeFile[StructTree struct]
	:	 ^(Include (s=Global|s=Local) f=FILE_PATH) {struct.includeFile(Tools.strip($f.text), $s.text);}
	;
	
	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;

dvar[StructTree struct] : dvar_std[$struct] | dvar_nonStd[$struct]   ;

dvar_std[StructTree struct]  :
       ^(Dvar_std (s=Global|s=Local) i=IDENT Kind k=STRING Units u=STRING)
       { struct.dvarStd($i.text, $s.text, "", Tools.strip($k.text), Tools.strip($u.text)); }
	;
	
dvar_nonStd[StructTree struct] : 
	   ^(Dvar_nonStd (sc=Global|sc=Local) i=IDENT Lower lr=LimitType Upper ur=LimitType Kind k=STRING Units u=STRING)
	   { System.out.println("zzzzlrzzzzzzz"+$lr.text);
	     System.out.println("zzzzurzzzzzzz"+$ur.text);

	   }
	   //{F.dvarNonStd($i.text, $sc.text, $k.text, $u.text,  $lb.text, $ub.text);}
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

c_unary :	NOT? c_term  	;

logical :  c_unary ( bin c_unary )* ;  
	
relation : '>' | '<' | '>=' | '<=' | '==' | '/=' ;	

bin : OR | AND ;	
	
/// End Expression /// 


tree grammar WreslTreeWalker;

options {
  language = Java;
  tokenVocab = WreslTree;
  ASTLabelType = CommonTree;
}

@header {
  package wrimsv2.wreslparser.grammar;
  import java.util.Map;
  import java.util.HashMap;
  import wrimsv2.wreslparser.elements.StructTree;
  import wrimsv2.wreslparser.elements.SimulationDataSet;
  import wrimsv2.wreslparser.elements.Tools;
  import wrimsv2.wreslparser.elements.LogUtils; 
}

@members {

  public int result;
  public CommonTree commonTree;
  public String currentAbsolutePath;
  public String currentAbsoluteParent;

  
  	public StructTree F = new StructTree();	
  	public SimulationDataSet mainDataSet = new SimulationDataSet();
  	public SimulationDataSet S;
  	  	
  	public Map<String, SimulationDataSet> modelDataMap = new HashMap<String, SimulationDataSet>();  	
  		/// error message	
    public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        LogUtils.errMsg(hdr + " " + msg);
    }
}

evaluator
@init { 
		F.S = mainDataSet;
		F.S.currentAbsolutePath = currentAbsolutePath;
		F.S.currentAbsoluteParent = currentAbsoluteParent;
	  }
	:	
	(       pattern+ 
	|     ( sequence+  model+ ) 
	|       test2 
	)
	     EOF
	;
test:  INTEGER 'test' ;	
test2:  t=test {  System.out.println("yyyyyyyyyyyyy"+$t.text  ); };		

pattern

	: dvar | includeFile
	;

sequence 
	:  ^(Sequence s=IDENT Model m=IDENT Order i=INTEGER Condition c=CONDITION ) 
		{
			F.sequenceOrder($s.text, $i.text, $m.text, $c.text);
			
			SimulationDataSet M = new SimulationDataSet();
			M.currentAbsolutePath=currentAbsolutePath;
			M.currentAbsoluteParent=currentAbsoluteParent;
			modelDataMap.put($m.text, M);
		}


	;

model
@after{ F.S = mainDataSet; }
	: ^(Model i=IDENT  			
				{   
					F.S = mainDataSet; F.modelList($i.text); 
					
				    F.S = modelDataMap.get($i.text);
				} 
				
				(pattern )+ ) 
	;	

includeFile
	:	 ^(Include (s=Global|s=Local) f=FILE_PATH) {F.includeFile(Tools.strip($f.text), $s.text);}
	;
	
	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;

dvar : dvar_std | dvar_nonStd   ;

dvar_std  :
       ^(Dvar_std (s=Global|s=Local) i=IDENT Kind k=STRING Units u=STRING)
       { F.dvarStd($i.text, $s.text, "", Tools.strip($k.text), Tools.strip($u.text)); }
	;
	
dvar_nonStd : 
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


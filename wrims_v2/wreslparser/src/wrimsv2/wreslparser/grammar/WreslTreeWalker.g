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
  import wrimsv2.commondata.wresldata.Param;
}

@members {

  public int result;
  public CommonTree commonTree;
  public String currentAbsolutePath;
  public String currentAbsoluteParent;

  
  	public StructTree F = new StructTree();	
  	public SimulationDataSet thisFileDataSet = new SimulationDataSet();
  	private SimulationDataSet S;
  	  	
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
		F.S = thisFileDataSet;
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
	: dvar | svar | goal | includeFile 
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
@after{ F.S = thisFileDataSet; }
	: ^(Model i=IDENT  			
				{   
					F.S = thisFileDataSet; F.modelList($i.text); 
					
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
goal : goal_simple | goal_no_case  ;

dvar : dvar_std | dvar_nonStd    ;

svar : svar_dss | svar_expr | svar_sum | svar_table;

goal_simple 
	:  ^(Goal_simple (sc=Global|sc=Local) i=IDENT v=Constraint_content ) 
		{ F.goalSimple($i.text, $sc.text, $v.text+"; ");} 
	;

goal_no_case
	:  ^( Goal_no_case i=IDENT  c1=content  c2=content?  )  
		{ if (c2!=null) { F.goalSimple($i.text, "Global", $c1.str+"; "+$c2.str); }
			else	{ F.goalSimple($i.text, "Global", $c1.str); }		  				
		} 
;

content returns[String str]
	: 
		 l=Lhs o=Op r=Rhs s=Separator w=Weight
		 { $str = $l.text + $o.text + $r.text + $s.text + $w.text;  } 


;


svar_table :
	^( Svar_table (sc=Global|sc=Local) i=IDENT s=Select f=From g=Given u=Use wi=Where_item_number wc=Where_content   ) 
	 {  
	 	//System.out.println("@@@@@@@@@@@@@"+$g.text);
	 	String sqlStr = "SELECT "+$s.text+" FROM "+$f.text+" GIVEN "+$g.text+" USE "+$u.text+" WHERE "+ Tools.replace_seperator($wc.text);
	 	F.svarTable($i.text, $sc.text, sqlStr); } 
	;

svar_sum : 
		^(Svar_sum (sc=Global|sc=Local) i=IDENT hdr=Sum_hdr v=Value )
	   { F.svarSum($i.text, $sc.text, 
	     Tools.replace_seperator($hdr.text), 
	     Tools.replace_seperator($v.text) ); }
	;

svar_expr : 
	   ^(Svar_const (sc=Global|sc=Local) i=IDENT v=Value )
	   { F.svarExpression($i.text, $sc.text, Tools.replace_seperator($v.text) ); }
	;

svar_dss :
       ^(Svar_dss (sc=Global|sc=Local) i=IDENT b=B_part Kind k=STRING Units u=STRING c=CONVERT )
       { F.svarDSS($i.text, $sc.text, Tools.strip($b.text), Tools.strip($k.text), Tools.strip($u.text),  Tools.strip($c.text)); }
	;

dvar_std  :
       ^(Dvar_std (sc=Global|sc=Local) i=IDENT Kind k=STRING Units u=STRING)
       { F.dvarStd($i.text, $sc.text, null, Tools.strip($k.text), Tools.strip($u.text)); }
	;
	
dvar_nonStd : 
	   ^(Dvar_nonStd (sc=Global|sc=Local) i=IDENT Lower lowerbound=LimitType Upper upperbound=LimitType Kind k=STRING Units u=STRING)
	   {F.dvarNonStd($i.text, $sc.text, $k.text, $u.text,  $lowerbound.text, $upperbound.text);}

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


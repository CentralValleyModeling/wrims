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
  import wrimsv2.commondata.wresldata.Goal;
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
	:  ^(Sequence s=IDENT Model m=IDENT Order i=INTEGER c=Condition ) 
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
	:	 ^(Include sc=Scope f=FILE_PATH) {F.includeFile(Tools.strip($f.text), $sc.text);}
	;
	
	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;
goal : goal_simple | goal_nocase | goal_case ;

dvar : dvar_std | dvar_nonStd    ;

svar : svar_dss | svar_expr | svar_sum | svar_table;

goal_simple 
	:  ^(Goal_simple sc=Scope i=IDENT v=Constraint_content ) 
		{ F.goalSimple($i.text, $sc.text, $v.text+"| ");} 
	;

goal_nocase
	:  ^( Goal_no_case sc=Scope i=IDENT  c=goal_contents  )  
		{ 
			 F.goalSimple($i.text, $sc.text, $c.str);	  				
		} 
;

goal_case
	@init { Goal gl = new Goal(); }   
	:  ^( Goal_case sc=Scope i=IDENT  
		( ^( Case n=IDENT c=Condition e=goal_contents 
			{	
				gl.caseName.add($n.text);
				gl.caseCondition.add( Tools.add_space_between_logical( $c.text ) );
				gl.caseExpression.add($e.str);
			} 
		) )+  
		)  
		{ 
			 F.goalCase($i.text, $sc.text, gl);	  				
		} 
;

goal_contents returns[String str] : c1=goal_content c2=goal_content? 
		{ 
		  if (c2!=null) { $str = $c1.str+"| "+$c2.str; }
		  else	        { $str = $c1.str; }		  				
		} 
		;

goal_content returns[String str]
	: 
		 l=Lhs o=Op r=Rhs s=Separator w=Weight
		 { $str = $l.text + $o.text + $r.text + $s.text + $w.text;  } 
	;


svar_table :
	^( Svar_table sc=Scope i=IDENT s=Select f=From g=Given u=Use wi=Where_item_number wc=Where_content   ) 
	 {  
	 	String sqlStr = "SELECT "+$s.text+" FROM "+$f.text+" GIVEN "+$g.text+" USE "+$u.text+" WHERE "+ Tools.replace_seperator($wc.text);
	 	F.svarTable($i.text, $sc.text, sqlStr); } 
	;

svar_sum : 
		^(Svar_sum sc=Scope i=IDENT hdr=Sum_hdr v=Value )
	   { F.svarSum($i.text, $sc.text, 
	     Tools.replace_seperator($hdr.text), 
	     Tools.replace_seperator($v.text) ); }
	;

svar_expr : 
	   ^(Svar_const sc=Scope i=IDENT v=Value )
	   { F.svarExpression($i.text, $sc.text, Tools.replace_seperator($v.text) ); }
	;

svar_dss :
       ^(Svar_dss sc=Scope i=IDENT b=B_part Kind k=STRING Units u=STRING c=CONVERT )
       { F.svarDSS($i.text, $sc.text, Tools.strip($b.text), Tools.strip($k.text), Tools.strip($u.text),  Tools.strip($c.text)); }
	;

dvar_std  :
       ^(Dvar_std sc=Scope i=IDENT Kind k=STRING Units u=STRING)
       { F.dvarStd($i.text, $sc.text, null, Tools.strip($k.text), Tools.strip($u.text)); }
	;
	
dvar_nonStd : 
	   ^(Dvar_nonStd sc=Scope i=IDENT Lower lowerbound=LimitType Upper upperbound=LimitType Kind k=STRING Units u=STRING)
	   {F.dvarNonStd($i.text, $sc.text, $k.text, $u.text,  $lowerbound.text, $upperbound.text);}
	;
			
	
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


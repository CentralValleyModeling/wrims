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
  import wrimsv2.commondata.wresldata.Svar;
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
	)
	     EOF
	;

pattern
	: dvar | svar | goal | includeFile | alias | weight_table | external | integer
	;

integer
	: integer_std | integer_nonStd
	; 

integer_std
	:  ^(Dvar_integer sc=Scope i=IDENT k=Kind u=Units )
	    {F.dvarStd($i.text, $sc.text, "integer", Tools.strip($k.text), Tools.strip($u.text)); }
	; 
	
integer_nonStd
	:  ^(Dvar_integer sc=Scope i=IDENT Lower lowerbound=LimitType Upper upperbound=LimitType k=Kind u=Units )
	    {F.dvarNonStd($i.text, $sc.text, "integer", Tools.strip($k.text), Tools.strip($u.text),  $lowerbound.text, $upperbound.text); }
	; 	

external 
	:  ^(External sc=Scope i=IDENT e=Expression )
		{F.external($i.text, $sc.text, $e.text);}
	;

sequence 
	:  ^(Sequence s=IDENT Model m=IDENT Order i=INTEGER c=Condition ) 
		{
			F.sequenceOrder($s.text, $i.text, $m.text, $c.text);
			
			SimulationDataSet M = new SimulationDataSet();
			M.currentAbsolutePath=currentAbsolutePath;
			M.currentAbsoluteParent=currentAbsoluteParent;
			modelDataMap.put($m.text.toLowerCase(), M);
		}


	;

model
@after{ F.S = thisFileDataSet; }
	: ^(Model i=IDENT  			
				{   
					F.S = thisFileDataSet; F.modelList($i.text.toLowerCase()); 
					
				    F.S = modelDataMap.get($i.text.toLowerCase());
				} 
				
				(pattern )+ ) 
	;	

includeFile
	:	 ^(Include sc=Scope f=FILE_PATH) {F.includeFile(Tools.strip($f.text), $sc.text);}
	;
	
weight_table
	:  ^(Weight_table sc=Scope ( ^(i=IDENT e=Expression    
	{ F.mergeWeightTable($i.text, $e.text, $sc.text); }
	) )+  ) 
	;	

	
//assignment
//	:	^(':=' IDENT e=expression)
//			{ variables.put($IDENT.text, e); }
//	;
goal 
scope { String scop ;} 
@init { $goal::scop = null; } 
: goal_simple | goal_nocase | goal_case ;

dvar : dvar_std | dvar_nonStd    ;

svar : svar_dss | svar_expr | svar_sum | svar_table | svar_case;

svar_case 	
@init { Svar sv = new Svar(); String dependants=null;}  
	: ^(Svar_case sc=Scope i=IDENT  ( c=case_content 
	{	
				sv.caseName.add($c.name.toLowerCase());
				sv.caseCondition.add( Tools.add_space_between_logical( $c.condition.toLowerCase() ) );
				sv.caseExpression.add($c.expression.toLowerCase());
				dependants = dependants + " " + $c.dependants;
			}
	
	)+ 
	) 
			 {F.svarCase($i.text, $sc.text, sv, dependants);}
;


case_content returns[String name, String condition, String expression, String dependants]  
@init{ String expr = null;} :
^(Case i=IDENT c=Condition d=Dependants
 
 ( t=table_content {expr =$t.text;}  // todo: add dependants
 | v=Value  vd=Dependants {expr =$v.text; }
 | sum=sum_content {expr =$sum.hdr+" "+$sum.expr; } 
 ) )
 
{ $name = $i.text; $condition =$c.text; $expression = expr; 
  $dependants = $d.text + " " + $t.dependants + " " + $vd.text + " " + $sum.dependants; 

}


;


//table_content returns[String text] :  
//^( s=Select f=From (g=Given u=Use)? wc=Where_content )
//{ $text = "SELECT "+$s.text+" FROM "+$f.text+" GIVEN "+$g.text+" USE "+$u.text+
//   " WHERE "+ Tools.replace_ignoreChar(Tools.replace_seperator($wc.text)); }
//;

table_content returns[String text, String dependants] 
	: 
 ^( SELECT s=IDENT FROM f=IDENT   {$text = "select "+$s.text+" from "+$f.text; }
  (GIVEN g=Assignment d=Dependants  USE u=IDENT {$text = $text+" given "+$g.text+" use "+$u.text; } )? 
  (WHERE w=where_items wd=Dependants            {$text = $text+" where "+ Tools.replace_ignoreChar(Tools.replace_seperator($w.text)); } )?
  )
  {$dependants = $d.text +" " + $wd.text;}
	;

where_items returns[String text]
	: a=Assignment {$text = $a.text;} (',' b=Assignment {$text = $text+","+$b.text;})*
	;


alias  :
       ^(Alias sc=Scope i=IDENT e=Expression k=Kind u=Units d=Dependants)
       { F.alias($i.text, $sc.text, Tools.strip($k.text), Tools.strip($u.text), $e.text, $d.text  ); }
	;


goal_simple 
	:  ^(Goal_simple sc=Scope i=IDENT d=Dependants v=Constraint_content ) 
		{ F.goalSimple($i.text, $sc.text, $v.text, $d.text);} 
	;

goal_nocase
	:  ^( Goal_no_case sc=Scope i=IDENT  d=Dependants c=goal_contents  )  
		{ 
			 F.goalSimple($i.text, $sc.text, $c.str, $d.text);	  				
		} 
;

goal_case
	@init { Goal gl = new Goal(); }   
	:  ^( Goal_case sc=Scope {$goal::scop = $sc.text;} i=IDENT  
		( ^( Case n=IDENT c=Condition d=Dependants e=goal_contents 
			{	
				gl.caseName.add($n.text.toLowerCase());
				gl.caseCondition.add( Tools.add_space_between_logical( $c.text.toLowerCase() ) );
				gl.caseExpression.add($e.str.toLowerCase());
				if (d != null) {
					String dependants = $d.text.toLowerCase();
					gl.expressionDependants.addAll(Tools.convertStrToSet(dependants));
				}
			} 
		) )+  
		)  
		{ 
			 F.goalCase($i.text, $sc.text, gl);	  				
		} 
;

goal_contents returns[String str] 
		: ( g=goal_contents_process_2 |g=goal_contents_process_1 | g=goal_content_simple )
			
			{$str = $g.str;}
		;

goal_contents_process_1 returns[String str] : t=One c1=goal_content 
		{ 
				// c -> =
				// f -> f
				// p -> =
		  
		  		if ( $t.text.equals("c") ) { 
		  		
		   			$str = $c1.lhs + "=" + $c1.rhs ; 
		  		
		  		} else if ( $t.text.equals("f") ) { 
		  		
		   			$str = $c1.str ;  
		   			
		   		} else {  
		   		
		   			$str = $c1.lhs + $c1.ss + "=" + $c1.rhs ;  
		   		
		   		}		  				
			
	}
		;

goal_contents_process_2 returns[String str] : t=Two c1=goal_content c2=goal_content
		{ 
		      // p: penalty f: free c: constrain
		      // pp -> =
		      // pc or cp -> =
		      // pf or fp  -> f
		      // fc or cf  -> f (same as c)		      
		      // cc -> =  (simple string)
		      // ff -> error

		   
		  		if ( $t.text.equals("pp") ) { 
		  				
		  			$str = $c1.lhs + $c1.ss + $c2.ss + "=" + $c1.rhs ;
		  			 
		  		} else if  ( $t.text.equals("pc") ) {
		  		
		  			$str = $c1.lhs + $c1.ss + "=" + $c1.rhs ; 
		  			
		  		} else if  ( $t.text.equals("cp") ) {
		  		
		  			$str = $c2.lhs + $c2.ss + "=" + $c2.rhs; 	

		  		} else if  ( $t.text.equals("pf") ) {
		  		
		  			$str = $c1.lhs + $c1.ss + $c2.op + $c1.rhs ; 			
		  		
		  		} else if ( $t.text.equals("fp"))  {
		  		
		  			$str = $c2.lhs + $c2.ss + $c1.op + $c2.rhs; 
		  		
		  		} else if ( $t.text.equals("fc"))  {  
		  		
		  			$str = $c1.lhs + $c1.op + $c1.rhs ;
		  			
		  		} else if ( $t.text.equals("cf"))  {  
		  		
		  			$str = $c1.lhs + $c2.op + $c1.rhs ;
		  					  		
		  			
		  		} else if ( $t.text.equals("cc"))  {  
		  		
		  			$str = $c1.lhs+"="+$c1.rhs ;
		  			
		  		} else  {  // ff
		  		
		  			$str = " 1 > 0 ";  // do something
		  		}
		  

			
	}
		;

goal_content returns[boolean hasDvar, String str, String ss, String weight, String lhs, String rhs, String type, String op]
@init{$hasDvar=false; String kind=null; $type="constrain";}
	: 
		 ( Constrain | Free | Penalty )   l=Lhs o=Op r=Rhs   ( Sign  Kind  s=Slack_Surplus  w=Weight  )? 
		 
		 {  $str = $l.text + $o.text + $r.text; 
		 
		    if (s!=null) { 

		    	F.dvarStd($s.text, $goal::scop, null, $Kind.text, "");  
		    	F.mergeWeightTable($s.text, $w.text, $goal::scop);
		 		$hasDvar = true; $ss = $Sign.text + $s.text; $weight = $w.text; }
		 	//} else {
		 	
		 	 	$lhs = $l.text; $rhs = $r.text; $op = $o.text;
		 	//}
		 } 
	;

goal_content_simple returns[String str]
	: 
		  Simple  l=Lhs o=Op r=Rhs  
		 {  $str = $l.text + $o.text + $r.text; } 
	;

svar_table :
	^( Svar_table sc=Scope i=IDENT t=table_content ) 
	 { F.svarTable($i.text, $sc.text, $t.text, $t.dependants); } 
	;

svar_sum : 
		^(Svar_sum sc=Scope i=IDENT sum=sum_content )
	   { F.svarSum($i.text, $sc.text, $sum.hdr, $sum.expr, $sum.dependants ); }
	;
	
sum_content returns[String hdr, String expr, String dependants]: 
^(h=Sum_hdr e=Expression d=Dependants) 
	{ 
		$hdr="SUM"+Tools.replace_ignoreChar( Tools.replace_seperator($h.text)); 
    	$expr = $e.text;
    	$dependants = $d.text;
    }
;	

svar_expr : 
	   ^(Svar_const sc=Scope i=IDENT v=Expression d=Dependants)
	   { F.svarExpression($i.text, $sc.text, Tools.replace_seperator($v.text), $d.text ); }
	;

svar_dss :
       ^(Svar_dss sc=Scope i=IDENT b=B_part Kind k=STRING Units u=STRING c=CONVERT )
       { F.timeseriesDss($i.text, $sc.text, Tools.strip($b.text), Tools.strip($k.text), Tools.strip($u.text),  Tools.strip($c.text)); }
	;

dvar_std  :
       ^(Dvar_std sc=Scope i=IDENT Kind k=STRING Units u=STRING)
       { F.dvarStd($i.text, $sc.text, null, Tools.strip($k.text), Tools.strip($u.text)); }
	;
	
dvar_nonStd : 
	   ^(Dvar_nonStd sc=Scope i=IDENT Lower lowerbound=LimitType Upper upperbound=LimitType Kind k=STRING Units u=STRING)
	   {F.dvarNonStd($i.text, $sc.text, null, Tools.strip($k.text), Tools.strip($u.text),  $lowerbound.text, $upperbound.text);}
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


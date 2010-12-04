grammar ParseTable;

options {
  language = Java;
}

@header {
  package Parser;
  import java.util.Map;
  import java.util.HashMap;
  import java.util.Iterator;
  import java.util.Arrays;
  import java.io.File;
  import java.io.FileInputStream;
  import java.io.BufferedInputStream;
    
  import org.antlr.runtime.ANTLRFileStream;
  import org.antlr.runtime.CharStream;
  import org.antlr.runtime.CommonTokenStream;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.TokenStream;
}

@lexer::header {
  package Parser;
}

@members {

  public static ArrayList<String>   error_var_redefined = new ArrayList<String> ();
  public static ArrayList<String>   error_grammer = new ArrayList<String> ();
  public static Map<String, ArrayList<String>>   cycle = new HashMap<String, ArrayList<String>>();
  public static Map<String, ArrayList<String>>   node = new HashMap<String, ArrayList<String>>();
  public static Map<String, ArrayList<String>>   dvar = new HashMap<String, ArrayList<String>>();
  public static Map<String, ArrayList<ArrayList<String>>>   svar = new HashMap<String, ArrayList<ArrayList<String>>>();
  public static ArrayList<String>   outputSvar = new ArrayList<String>();
  public static Map<String, String> weight = new HashMap<String, String>();
  public static ArrayList<String>   file = new ArrayList<String>();
  public static Map<String, ArrayList<ArrayList<String>>>   constraint = new HashMap<String, ArrayList<ArrayList<String>>>();
  public static Map<String, ArrayList<ArrayList<String>>>   lgr = new HashMap<String, ArrayList<ArrayList<String>>>();
  public static Map<String, ArrayList<ArrayList<String>>>   rgl = new HashMap<String, ArrayList<ArrayList<String>>>();

  public static Map<String, ArrayList<String>>   nodeGlobal = new HashMap<String, ArrayList<String>>();
  public static Map<String, ArrayList<String>>   dvarGlobal = new HashMap<String, ArrayList<String>>();
  public static Map<String, ArrayList<ArrayList<String>>>   svarGlobal = new HashMap<String, ArrayList<ArrayList<String>>>();
  public static ArrayList<String>   outputSvarGlobal = new ArrayList<String>();
  public static Map<String, String> weightGlobal = new HashMap<String, String>();
  public static ArrayList<String>   fileGlobal = new ArrayList<String>();
  public static Map<String, ArrayList<ArrayList<String>>>   constraintGlobal = new HashMap<String, ArrayList<ArrayList<String>>>();
  public static Map<String, ArrayList<ArrayList<String>>>   lgrGlobal = new HashMap<String, ArrayList<ArrayList<String>>>();
  public static Map<String, ArrayList<ArrayList<String>>>   rglGlobal = new HashMap<String, ArrayList<ArrayList<String>>>();
  
  private static String currentFile="";
  private static String currentCycle="";
  private static ArrayList<String> fileAnchestry=new ArrayList<String>();
  
  private static boolean testDefine=false;
  private final ArrayList<String> reserveToken=new ArrayList<String>(Arrays.asList("month", "wateryear","jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"));
  private final ArrayList<String> pastMonth=new ArrayList<String>(Arrays.asList("prejan","prefeb","premar","preapr","premay","prejun","prejul","preaug","presep","preoct","prenov","predec")); 
  
  private String svType= "NULL"; 
  private String svUnits = "NULL"; 
  private String preSV ="";
  private String preCondition = "always";
  private int n_always=0;
  private boolean redefineSV=false;
  private boolean includeSV=false;
  private String writeToDss="y"; 
  
  private String preConstraint="";
  private boolean redefineConstraint=false;
  private boolean includeConstraint=false;
  private boolean constraintOnly=false;
  
  private String preReservoir="";
  private boolean includeReservoir=false;
  private int ilevel=1;
  private String reservoirUnits="taf";
  
  private ArrayList<ArrayList<String>> svlist;
  
  private static CharStream stream;

  public String strip(String s) {
    return s.substring(1, s.length()-1);
    }
  
  public String equalConstraint(String relationStatement){
    String[] expressions = relationStatement.split("[<=>]");
    return expressions[0]+"="+expressions[1]; 
  }
  
  public String smallerConstraint(String relationStatement){
    String[] expressions = relationStatement.split("[<=>]");
    return expressions[0]+"<"+expressions[1]; 
  }
  
  public String largerConstraint(String relationStatement){
    String[] expressions = relationStatement.split("[<=>]");
    return expressions[0]+">"+expressions[1]; 
  }
  
  public String lMinusR(String relationStatement){
    String[] expressions = relationStatement.split("[<=>]");
    return expressions[0]+"-("+expressions[1]+")"; 
  }  
  
  public String rMinusL(String relationStatement){
    String[] expressions = relationStatement.split("[<=>]");
    return expressions[1]+"-("+expressions[0]+")"; 
  }
  
  public void dvTestDefineSV(){
    Iterator iterator=dvar.keySet().iterator();
    while(iterator.hasNext()){ 
      String dvarName=(String)iterator.next();
      ArrayList<String> dvarList=dvar.get(dvarName);
      String lowerBound=dvarList.get(0);
      String upperBound=dvarList.get(1);
      try{        
        Integer.parseInt(lowerBound);    
      } catch(NumberFormatException nfe0) {        
        try {
          Float.parseFloat(lowerBound);
        }catch (NumberFormatException nfe1) { 
          try {
            Double.parseDouble(lowerBound);
          }catch (NumberFormatException nfe2) {
            if (!svar.containsKey(lowerBound)){
              error_grammer.add(lowerBound+" as the lower bound of decision variable "+dvarName+" is not defined before used");
            }
          }
        }   
      }
      try{        
        Integer.parseInt(upperBound);    
      } catch(NumberFormatException nfe3) {        
        try {
          Float.parseFloat(upperBound);
        }catch (NumberFormatException nfe4) { 
          try {
            Double.parseDouble(upperBound);
          }catch (NumberFormatException nfe5) {
            if (!svar.containsKey(upperBound)){
              error_grammer.add(upperBound+" as the upper bound of decision variable "+dvarName+" is not defined before used");
            }
          }
        }   
      }
    }
  }
  
  public void nodeConstraint(){
    Iterator iterator=node.keySet().iterator();
    while(iterator.hasNext()){        
       String nodeName=(String)iterator.next();
       ArrayList<String> nodeList=node.get(nodeName);
       if (nodeList.get(2).equals("normal")){
          String leftHandSide="0";
          for (int i=5; i<=nodeList.size()-1; i++){
            leftHandSide=leftHandSide+nodeList.get(i);
          }
          String rightHandSide=nodeList.get(3)+"-"+nodeList.get(4);
          String normalConstraint=leftHandSide+"="+rightHandSide;
          ArrayList<String> list=new ArrayList<String>();
          list.add("always");
          list.add(normalConstraint);
          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>(); 
          constraintList.add(list);
          String constraintName="continuity"+nodeName;
          if (constraint.containsKey(constraintName)){
            error_var_redefined.add(currentFile+": "+ constraintName+" is an automatic generated name and is redefined");
          }               
          constraint.put(constraintName, constraintList);
       }else if (nodeList.get(2).equals("reservoir")){
          String leftHandSide="0";
          for (int i=5; i<=nodeList.size()-1; i++){
            leftHandSide=leftHandSide+nodeList.get(i);
          }
          String rightHandSide=nodeName+"-"+nodeName+"(-1)+"+nodeList.get(3)+"-"+nodeList.get(4);
          String reservoirConstraint=leftHandSide+"="+rightHandSide;
          ArrayList<String> list=new ArrayList<String>();
          list.add("always");
          list.add(reservoirConstraint);
          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>(); 
          constraintList.add(list);
          String constraintName="continuity"+nodeName;
          if (constraint.containsKey(constraintName)){
            error_var_redefined.add(currentFile+": "+ constraintName+" is an automatic generated name and is redefined");
          }               
          constraint.put(constraintName, constraintList);                    
       }    
    }
  }
  
  public void setGlobal(){
        nodeGlobal = node;
        dvarGlobal = dvar;
        svarGlobal = svar;
        outputSvarGlobal = outputSvar;
        weightGlobal = weight;
        fileGlobal = file;
        constraintGlobal = constraint;
        lgrGlobal = lgr;
        rglGlobal = rgl;
  }
  
  public void initialCycle(){
        node = nodeGlobal;
        dvar = dvarGlobal;
        svar = svarGlobal;
        outputSvar = outputSvarGlobal;
        weight = weightGlobal;
        file = fileGlobal;
        constraint = constraintGlobal;
        lgr = lgrGlobal;
        rgl = rglGlobal;        
  }
}

evaluator //returns [Map<String, String> map1]
	:	modules //{ $map1 = constants; }
	;

modules
	:	cycletable
	| filetable
	|	dvartable
	|	svartable
	|	constrainttable
	|	weighttable
	;


cycletable
  : headline_cycletable ('\n'|'\r'|COMMENT*) content_globalline content_cycleline*
  ;

filetable
	:	headline_filetable ('\n'|'\r'|COMMENT*) content_fileline*
	;
		
nodetable
	:	headline_nodetable ('\n'|'\r'|COMMENT*) content_nodeline*
	;
	
arctable
	:	headline_arctable ('\n'|'\r'|COMMENT*) content_arcline*
	;	

reservoirtable
	:	headline_reservoirtable ('\n'|'\r'|COMMENT*) content_reservoirline*
	;

dvartable
	:	headline_dvartable ('\n'|'\r'|COMMENT*) content_dvarline*
	;

svartable
	:	headline_svartable ('\n'|'\r'|COMMENT*) content_svarline*
	;
	
constrainttable
	:	headline_constrainttable ('\n'|'\r'|COMMENT*) content_constraintline*
	;

weighttable
	:	headline_weighttable ('\n'|'\r'|COMMENT*) content_weightline*
	;

headline_cycletable
  : 'cycle' ',' 'file' ',' 'condition'{
    }
  ;

headline_filetable
  : 'file' ',' 'include'{
    }
  ;
	
headline_nodetable
	:	'name'  ',' 'include' ',' 'x-coordinate' ',' 'y-coordinate' ',' 'type' ',' 'positive_error' ',' 'negative_error' {
		}
	;

headline_arctable
	:	'name' ',' 'include' ',' 'expression' ',' 'units' ',' 'lowerbound' ',' 'upperbound' ',' 'startnode' ',' 'endnode' ',' 'type' {
		}
	;
	
headline_reservoirtable
	:	'name' ',' 'include' ',' 'zone' ',' 'zoneinclude' ',' 'upbound' ',' 'weight' ',' 'units'{
		}
	;
	
headline_dvartable
	:	'name' ',' 'include' ',' 'lowerbound' ',' 'upperbound' ',' 'integer' ',' 'units' ',' 'type'{
		}
	;
	
headline_svartable
	:	'name' ',' 'include' ',' 'type' ',' 'units' ',' 'writetodss' ',' 'case' ',' 'caseinclude' ',' 'condition' ',' 'expression' {
		}
	;

headline_constrainttable
	:	'name' ',' 'include' ',' 'case' ',' 'caseinclude' ',' 'condition' ',' 'expression' ',' 'lhs>rhs' ',' 'lhs<rhs' {
		}
	;
		
headline_weighttable
	:	'name' ',' 'weight'{
		}
	;

content_globalline
  : content_global (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
  ;

content_cycleline
  : content_cycle (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
  ;

content_fileline
  : content_file (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
  ;

content_nodeline
	:	content_node (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;

content_arcline
	:	content_arc (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;

content_reservoirline
	:	content_reservoir (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_dvarline
	:	content_dvar (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_svarline
	:	content_svar (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_constraintline
	:	content_constraint (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;
	
content_weightline
	:	content_weight (('\n' EOF)|('\r' EOF)|'\n'|'\r'|COMMENT*|EOF)
	;

content_global
  : i1=IDENT ',' i2=directory ',' i3=conditionStatement{
      if ($i1.text.equals("global")){
        node = new HashMap<String, ArrayList<String>>();
        dvar = new HashMap<String, ArrayList<String>>();
        svar = new HashMap<String, ArrayList<ArrayList<String>>>();
        outputSvar = new ArrayList<String>();
        weight = new HashMap<String, String>();
        file = new ArrayList<String>();
        constraint = new HashMap<String, ArrayList<ArrayList<String>>>();
        lgr = new HashMap<String, ArrayList<ArrayList<String>>>();
        rgl = new HashMap<String, ArrayList<ArrayList<String>>>();
      
        if (cycle.containsKey($i1.text)){
          error_var_redefined.add("main file: cycle"+ $i1.text+" redefined");
        }else{
          ArrayList<String> list = new ArrayList<String>();
          list.add($i3.text);
          list.add($i2.text);
          cycle.put($i1.text, list);
        
          byte[] buffer = new byte[(int) new File($i2.text).length()];
          BufferedInputStream f = null;
          try {
              f = new BufferedInputStream(new FileInputStream($i2.text));
              f.read(buffer);
              f.close();
          } catch (Exception e) { 
              e.printStackTrace();
          }
             
          String fileString=new String(buffer);
          fileString=fileString.toLowerCase();
             
          try {
            stream=new ANTLRStringStream(fileString);
          }
          catch(Exception e) {
            e.printStackTrace();
          }
          
          fileAnchestry.add("main file");   
          currentFile=$i2.text;
          ParseTableLexer lexer = new ParseTableLexer(stream);
          TokenStream tokenStream = new CommonTokenStream(lexer);
          ParseTableParser parser = new ParseTableParser(tokenStream);
          parser.evaluator();
          currentFile=fileAnchestry.get(fileAnchestry.size()-1);
          fileAnchestry.remove(fileAnchestry.size()-1);
          
          setGlobal();
        }           
      }else{
        error_grammer.add("main file: cycle name "+$i1.text+" is wrong. The first line cycle name should be global");
      }      
  }
  ;

content_cycle
  : i1=IDENT ',' i2=directory ',' i3=conditionStatement{
      node = new HashMap<String, ArrayList<String>>();
      dvar = new HashMap<String, ArrayList<String>>();
      svar = new HashMap<String, ArrayList<ArrayList<String>>>();
      outputSvar = new ArrayList<String>();
      weight = new HashMap<String, String>();
      file = new ArrayList<String>();
      constraint = new HashMap<String, ArrayList<ArrayList<String>>>();
      lgr = new HashMap<String, ArrayList<ArrayList<String>>>();
      rgl = new HashMap<String, ArrayList<ArrayList<String>>>();
      
      initialCycle();
      
      if (cycle.containsKey($i1.text)){
        error_var_redefined.add("main file: cycle"+ $i1.text+" redefined");
      }else{
        ArrayList<String> list = new ArrayList<String>();
        list.add($i3.text);
        list.add($i2.text);
        cycle.put($i1.text, list);
        currentCycle=$i1.text;
        
        byte[] buffer = new byte[(int) new File($i2.text).length()];
        BufferedInputStream f = null;
        try {
            f = new BufferedInputStream(new FileInputStream($i2.text));
            f.read(buffer);
            f.close();
        } catch (Exception e) { 
            e.printStackTrace();
        }
             
        String fileString=new String(buffer);
        fileString=fileString.toLowerCase();
             
        try {
           stream=new ANTLRStringStream(fileString);
        }
        catch(Exception e) {
           e.printStackTrace();
        }
        
        fileAnchestry.add("main file");
        currentFile=$i2.text;     
        ParseTableLexer lexer = new ParseTableLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        ParseTableParser parser = new ParseTableParser(tokenStream);
        parser.evaluator();
        currentFile=fileAnchestry.get(fileAnchestry.size()-1);
        fileAnchestry.remove(fileAnchestry.size()-1);
        
        //nodeConstraint();
        dvTestDefineSV();
      }   
  }
  ;

content_file
  : i1=directory ',' i2=IDENT {
       if ($i2.text.equals("y")){
           if (file.contains($i1.text)) {
               error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
           }else{
             file.add($i1.text); 
             byte[] buffer = new byte[(int) new File($i1.text).length()];
             BufferedInputStream f = null;
             try {
                f = new BufferedInputStream(new FileInputStream($i1.text));
                f.read(buffer);
                f.close();
             } catch (Exception e) { 
                e.printStackTrace();
             }
             
             String fileString=new String(buffer);
             fileString=fileString.toLowerCase();
             
             try {
                stream=new ANTLRStringStream(fileString);
             }
             catch(Exception e) {
                e.printStackTrace();
             }
             
             fileAnchestry.add(currentFile);
             currentFile=$i1.text;
             ParseTableLexer lexer = new ParseTableLexer(stream);
             TokenStream tokenStream = new CommonTokenStream(lexer);
             ParseTableParser parser = new ParseTableParser(tokenStream);
             parser.evaluator();
             currentFile=fileAnchestry.get(fileAnchestry.size()-1);
             fileAnchestry.remove(fileAnchestry.size()-1);
           }           
       }else if (!($i2.text.equals("n"))){
           error_grammer.add(currentFile+": "+$i1.text+" include field should be y or n");
       }
    }
  ;
	
content_node
	:	i1=IDENT ',' i2=IDENT ',' i3=allnumber ',' i4=allnumber ',' i5=IDENT ',' ((i6=allnumber)|'#') ',' ((i7=allnumber)|'#'){
			if (node.containsKey($i1.text)){
        error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
      }else{
        if ($i5.text.equals("normal") | $i5.text.equals("reservoir")){
          if ($i2.text.equals("y")){
            ArrayList<String> list = new ArrayList<String>();
            list.add($i3.text);
            list.add($i4.text);
            list.add($i5.text);
            if ($i6.text ==null){
              list.add("0");
            }else{
              String errPos="errpos_"+$i1.text;
              list.add(errPos);
              ArrayList<String> dvList=new ArrayList<String>();
              dvList.add("0");
              dvList.add("1.e38");
              dvList.add("n");
              dvList.add("cfs");
              dvList.add("error-term");
              dvar.put(errPos, dvList);             
              weight.put(errPos, $i6.text);
            }
            if ($i7.text ==null){
              list.add("0");
            }else{
              String errNeg="errneg_"+$i1.text;
              list.add(errNeg);
              ArrayList<String> dvList=new ArrayList<String>();
              dvList.add("0");
              dvList.add("1.e38");
              dvList.add("n");
              dvList.add("cfs");
              dvList.add("error-term");
              dvar.put(errNeg, dvList);
              weight.put(errNeg, $i7.text);              
            }
            
            node.put($i1.text, list);
          }else if (!($i2.text.equals("n"))){
            error_grammer.add(currentFile+": "+ $i1.text+" include field should be y or n");
          }
        }else{
          error_grammer.add(currentFile+": "+$i1.text+"type field should be normal or reservoir");
        }
      }
	}
	;

content_arc
	:	i1=IDENT ',' i2=IDENT ',' ((i3=tableExpression)|'#') ',' i9=IDENT ',' ((i4=lowerbound)|'#') ',' ((i5=upperbound)|'#') ',' 
		((i6=IDENT ',' i7=IDENT)|(i6='#' ',' i7=IDENT)|(i6=IDENT ',' i7='#')) ',' partC {
			if ($i2.text.equals("y")){
	       	if ($i3.list == null){
	       	   if (dvar.containsKey($i1.text) || svar.containsKey($i1.text)){
                error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
             }else{
                if (($i4.text==null)|($i5.text ==null)){
                    error_grammer.add(currentFile+": "+$i1.text+" when expression field is #, bound field can't be #");
                }else{
                    ArrayList<String> list=new ArrayList<String>();
                    if ($i4.text.equals("ul")){
                      list.add("-1.e38");
                    }else{
                      list.add($i4.text);
                    }
            
                    if ($i5.text.equals("ul")){
                      list.add("1.e38");
                    }else{
                      list.add($i5.text);
                    }
            
                    list.add("n");
            
                    list.add($i9.text);
                    list.add($partC.text);
                    dvar.put($i1.text,list);
                    
                    if ($i6.text !=null){
                      if (!node.containsKey($i6.text)){
                        error_grammer.add(currentFile+": "+$i1.text+" starting node "+$i6.text+" is not defined in node table");
                      }else{
                        list=new ArrayList<String>();
                        list=node.get($i6.text);
                        list.add("-"+$i1.text);
                      }
                    }
                    if ($i7.text !=null){
                      if (!node.containsKey($i7.text)){
                        error_grammer.add(currentFile+": "+$i1.text+" starting node "+$i7.text+" is not defined in node table");
                      }else{
                        list=new ArrayList<String>();
                        list=node.get($i7.text);
                        list.add("+"+$i1.text);
                      }
                    }
                }
             }
	       	}else{
	       	   if (dvar.containsKey($i1.text)||svar.containsKey($i1.text)){
                error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
             }else{
                ArrayList<String> list=new ArrayList<String>();
                list.add($partC.text);
                list.add($i9.text);
                list.add("always");
                list.addAll($i3.list);
                svlist=new ArrayList<ArrayList<String>>();
                svlist.add(list);
                svar.put($i1.text,svlist);
                
                if ($i6.text !=null){
                  if (!node.containsKey($i6.text)){
                     error_grammer.add(currentFile+": "+$i1.text+" starting node "+$i6.text+" is not defined in node table");
                  }else{
                     list=new ArrayList<String>();
                     list=node.get($i6.text);
                     list.add("-"+$i1.text);
                  }
                }
                if ($i7.text !=null){
                  if (!node.containsKey($i7.text)){
                     error_grammer.add(currentFile+": "+$i1.text+" starting node "+$i7.text+" is not defined in node table");
                  }else{
                     list=new ArrayList<String>();
                     list=node.get($i7.text);
                     list.add("+"+$i1.text);
                  }
                }
             }
	       	}	   
			}else if (!($i2.text.equals("n"))){
			   error_grammer.add(currentFile+": "+$i1.text+" include field should be y or n");
			}
		}  
	;

content_reservoir
	:	i1=IDENT ',' ((i2=IDENT)|'#') ',' i3=IDENT ',' i4=IDENT ',' i5=tableExpression ',' ((i6=weight)|'#') ',' ((i7=IDENT)|'#') {
            if ($i1.text.equals(preReservoir)){
                if ($i2.text !=null){
                   error_grammer.add(currentFile+": " + $i1.text+ " the include field must be # after the first line");
                }else{                                                       
                   if ($i4.text.equals("y") && includeReservoir){
                      String levelName=$i1.text+"level"+Integer.toString(ilevel);
                      String zoneName=$i1.text+"_"+Integer.toString(ilevel);
                      if (svar.containsKey(levelName)){
                        error_var_redefined.add(currentFile+": "+ levelName+" is an automatic generated name and is redefined");
                      }
                      if (dvar.containsKey(zoneName)){
                        error_var_redefined.add(currentFile+": "+ zoneName+" is an automatic generated name and is redefined");
                      }                   
                      svlist=new ArrayList<ArrayList<String>>();
                      ArrayList<String> list=new ArrayList<String>();
                      list.add("reservoir-level");
                      list.add(reservoirUnits);
                      list.add("always");
                      list.addAll($i5.list);
                      svlist.add(list);
                      svar.put(levelName, svlist);
                      outputSvar.add(levelName);
                      
                      list=new ArrayList<String>();
                      list.add("0");
                      list.add("1.e38");
                      list.add("n");
                      list.add(reservoirUnits);
                      list.add("storage-zone");
                      dvar.put(zoneName, list);                      
                      
                      if (ilevel==1){
                        String goalName = "storage_"+$i1.text;
                        if (constraint.containsKey(goalName)){
                          error_var_redefined.add(currentFile+": "+ goalName+" is an automatic generated name and is redefined");
                        }
                        list=new ArrayList<String>();
                        list.add("always");
                        list.add($i1.text+"="+zoneName);
                        ArrayList<ArrayList<String>> constraintList=new ArrayList<ArrayList<String>>();
                        constraintList.add(list);
                        constraint.put(goalName, constraintList);
                      
                        goalName = $i1.text+"_zone1";
                        if (constraint.containsKey(goalName)){
                          error_var_redefined.add(currentFile+": "+ goalName+" is an automatic generated name and is redefined");
                        }
                        list=new ArrayList<String>();
                        list.add("always");
                        list.add(zoneName+"<"+levelName);
                        constraintList=new ArrayList<ArrayList<String>>();
                        constraintList.add(list);
                        constraint.put(goalName, constraintList);
                      }else{
                        String goalName = "storage_"+$i1.text;
                        ArrayList<ArrayList<String>> constraintList=constraint.get(goalName);
                        list=new ArrayList<String>();
                        list=constraintList.get(0);
                        String newConstraint =list.get(1)+"+"+zoneName;
                        list.set(1, newConstraint);
                        
                        goalName = $i1.text+"_zone"+ilevel;
                        String preLevelName=$i1.text+"level"+Integer.toString(ilevel-1);
                        if (constraint.containsKey(goalName)){
                          error_var_redefined.add(currentFile+": "+ goalName+" is an automatic generated name and is redefined");
                        }
                        list=new ArrayList<String>();
                        list.add("always");
                        list.add(zoneName+"<"+levelName+"-"+preLevelName);
                        constraintList=new ArrayList<ArrayList<String>>();
                        constraintList.add(list);
                        constraint.put(goalName, constraintList);
                      }
                      
                      if ($i6.text!=null){
                        if (weight.containsKey(zoneName)){
                          error_var_redefined.add(currentFile+": "+ zoneName+" is an automatic generated name and is redefined");
                        }
                        weight.put(zoneName, $i6.text);
                      }
                      ilevel=ilevel+1;
                   }else if (!($i4.text.equals("n"))){
                      error_grammer.add(currentFile+": " + $i1.text+ " the zoneinclude field must be y or n");
                   }
                }
            }else{
                ilevel=1;
                if ($i2.text==null){
                   error_grammer.add(currentFile+": " + $i1.text+ " the include field in the first line must be y or n");
                   includeReservoir=false;
                }else if ($i2.text.equals("n")){
                   includeReservoir=false;
                }else if ($i2.text.equals("y")){
                   includeReservoir=true;
                   if (dvar.containsKey($i1.text)){
                      error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
                   }
                   if ($i7.text==null){
                      error_grammer.add(currentFile+": " + $i1.text+ " the units field cannot be #");
                      reservoirUnits="taf";
                   }else{
                      reservoirUnits=$i7.text;
                   }
                   
                   ArrayList<String> list=new ArrayList<String>();
                   list.add("0");
                   list.add("1.e38");
                   list.add("n");
                   list.add(reservoirUnits);
                   list.add("storage");
                   dvar.put($i1.text, list);
                   
                   list=new ArrayList<String>();
                   
                                      
                   if ($i4.text.equals("y")){
                      String levelName=$i1.text+"level"+Integer.toString(ilevel);
                      String zoneName=$i1.text+"_"+Integer.toString(ilevel);
                      if (svar.containsKey(levelName)){
                        error_var_redefined.add(currentFile+": "+ levelName+" is an automatic generated name and is redefined");
                      }
                      if (dvar.containsKey(zoneName)){
                        error_var_redefined.add(currentFile+": "+ zoneName+" is an automatic generated name and is redefined");
                      }                   
                      svlist=new ArrayList<ArrayList<String>>();
                      list=new ArrayList<String>();
                      list.add("reservoir-level");
                      list.add(reservoirUnits);
                      list.add("always");
                      list.addAll($i5.list);
                      svlist.add(list);
                      svar.put(levelName, svlist);
                      outputSvar.add(levelName);
                      
                      list=new ArrayList<String>();
                      list.add("0");
                      list.add("1.e38");
                      list.add("n");
                      list.add(reservoirUnits);
                      list.add("storage-zone");
                      dvar.put(zoneName, list);                      
                      
                      String goalName = "storage_"+$i1.text;
                      if (constraint.containsKey(goalName)){
                        error_var_redefined.add(currentFile+": "+ goalName+" is an automatic generated name and is redefined");
                      }
                      list=new ArrayList<String>();
                      list.add("always");
                      list.add($i1.text+"="+zoneName);
                      ArrayList<ArrayList<String>> constraintList=new ArrayList<ArrayList<String>>();
                      constraintList.add(list);
                      constraint.put(goalName, constraintList);
                      
                      goalName = $i1.text+"_zone1";
                      if (constraint.containsKey(goalName)){
                        error_var_redefined.add(currentFile+": "+ goalName+" is an automatic generated name and is redefined");
                      }
                      list=new ArrayList<String>();
                      list.add("always");
                      list.add(zoneName+"<"+levelName);
                      constraintList=new ArrayList<ArrayList<String>>();
                      constraintList.add(list);
                      constraint.put(goalName, constraintList);
                      
                      if ($i6.text!=null){
                        if (weight.containsKey(zoneName)){
                          error_var_redefined.add(currentFile+": "+ zoneName+" is an automatic generated name and is redefined");
                        }
                        weight.put(zoneName, $i6.text);
                      }
                      ilevel=ilevel+1;
                   }else if (!($i4.text.equals("n"))){
                      error_grammer.add(currentFile+": " + $i1.text+ " the zoneinclude field must be y or n");
                   }
                }else{
                   error_grammer.add(currentFile+": " + $i1.text+ " the include field must be y or n");
                   includeReservoir=false;
                }
            }
            preReservoir=$i1.text;
       }
	;
	
content_dvar
	:	i1=IDENT ',' i2=IDENT ',' lowerbound ',' upperbound ',' i3=IDENT ',' i4=IDENT ',' partC{
	   if ($i2.text.equals("y")){
	       if (dvar.containsKey($i1.text)){
            error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
         }else{
            ArrayList<String> list=new ArrayList<String>();
            if ($lowerbound.text.equals("ul")){
              list.add("-1.e38");
            }else{
              list.add($lowerbound.text);
            }
            
            if ($upperbound.text.equals("ul")){
              list.add("1.e38");
            }else{
              list.add($upperbound.text);
            }
            
            if ($i3.text.equals("y")|$i3.text.equals("n")){
              list.add($i3.text);
            }else{
              error_grammer.add(currentFile+": "+$i1.text+" integer field should be y or n");
            }
            
            list.add($i4.text);
            list.add($partC.text);
            dvar.put($i1.text,list);
         }
	   }else if (!($i2.text.equals("n"))){
	       error_grammer.add(currentFile+": "+$i1.text+" include field should be y or n");
	   }
	}
	;
	
content_svar
	:	i1=IDENT ',' i2=(IDENT|'#') ',' ((i3=partC)|'#') ',' ((i9=IDENT)|'#') ',' ((i4=IDENT)|'#') ',' i5=IDENT ',' i6=(IDENT|'#') ',' i7=conditionStatement ',' i8=tableExpression{
     				if ($i1.text.equals(preSV)){
			        	if ($i3.text!=null){
			        	  error_grammer.add(currentFile+": "+$i1.text+" type field at this line should be #");
			        	}
			        	if (!redefineSV){
			        	   if ($i7.text.equals("always")){
            				  n_always=n_always+1;
			        		    if (n_always>1){
		              				error_grammer.add(currentFile+": "+$i1.text+" has more than 1 always condition");
            				  }
            				  if (includeSV && !($i6.text.equals("y"))){
              					  error_grammer.add(currentFile+": "+$i1.text+" includecase field should be y when the conditon is always");
            				  }
          			   }
          			   if (includeSV && $i6.text.equals("y")){
            				  ArrayList<String> list=new ArrayList<String>();
            				  list.add(svType);
            				  list.add(svUnits);
            				  list.add($i7.text);
            				  list.addAll($i8.list);
            				  svlist=svar.get($i1.text);
            				  svlist.add(list);
          			   }
          			}
        		}else{
          			if ($i3.text==null){
          			   svType="NULL";
          			}else{
          			   svType=$i3.text;
          			}
          			if ($i9.text==null){
                   svUnits="cfs";
                }else{
                   svUnits=$i9.text;
                }
          			if (svar.containsKey($i1.text)){
                    error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
                    redefineSV=true;
                }else{
                    redefineSV=false;
          				  n_always=0;
				            svlist=new ArrayList<ArrayList<String>>();
          				  if ($i4.text.equals("y")){
            					writeToDss=$i4.text;
            					outputSvar.add($i1.text);
            				}else if ($i4.text.equals("n")){
            				  writeToDss=$i4.text;
          				  }else{
            					error_grammer.add(currentFile+": "+$i1.text+" writetodss field should be y or n");
            					writeToDss="y";
          				  }
          				
          				  if (!(preCondition.equals("always"))){
            					error_grammer.add(currentFile+": "+preSV+" the last case should be always");
          				  }
          				  if ($i2.text.equals("y")){
            					includeSV=true;
						          if ($i7.text.equals("always")){
							            if (!($i6.text.equals("y"))){
						                error_grammer.add(currentFile+": "+$i1.text+" includecase field should be y when the conditon is always");
              						}
						          }
          				  }else if ($i2.text.equals("n")){
            					includeSV=false;
          				  }else{
            					error_grammer.add(currentFile+": "+$i1.text+" include field should be y or n");
          				  }
          				  if ($i7.text.equals("always")){
            					n_always=n_always+1;
          				  }
          				  if (includeSV && $i6.text.equals("y")){
            					ArrayList<String> list=new ArrayList<String>();
            					list.add(svType);
            					list.add(svUnits);
            					list.add($i7.text);
            					list.addAll($i8.list);
            					svlist.add(list);
            					svar.put($i1.text, svlist);
          				  }
          			}
          	}
     			  preCondition=$i7.text;
     			  preSV=$i1.text;
		   }
	;
	
content_constraint
	:	i1=IDENT ',' i2=(IDENT|'#') ',' i3=IDENT ',' i4=(IDENT|'#') ',' i5=conditionStatement ',' i6=relationStatement ',' ((i7=lhsrhs)|'#') ',' ((i8=lhsrhs)|'#'){
            if ($i1.text.equals(preConstraint)){
                if (!redefineConstraint){
                   if ($i5.text.equals("always")){
                      n_always=n_always+1;
                      if (n_always>1){
                          error_grammer.add(currentFile+": "+$i1.text+" has more than 1 always condition");
                      }
                      if (includeConstraint && !($i4.text.equals("y"))){
                          error_grammer.add(currentFile+": "+$i1.text+" includecase field should be y when the conditon is always");
                      }
                   }
                   if (includeConstraint && $i4.text.equals("y")){
                      if (constraintOnly){
                        if (($i7.text==null) && ($i8.text==null)){
                          ArrayList<ArrayList<String>> constraintList = constraint.get($i1.text);
                          ArrayList<String> list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add($i6.text);
                          constraintList.add(list);
                        }else{
                          error_grammer.add(currentFile+": "+$i1.text+" lhs>rhs and rhs>lhs fields can only be both # or neither");
                        }
                      }else{
                        if ($i7.text.equals("constrain") && $i8.text.equals("constrain")){
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = constraint.get($i1.text);
                          list.add($i5.text);
                          list.add(equalConstraint($i6.text));
                          constraintList.add(list);
                          
                          ArrayList<ArrayList<String>> lgrList = lgr.get($i1.text);
                          list= new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          lgrList.add(list);
                          
                          ArrayList<ArrayList<String>> rglList = rgl.get($i1.text);
                          list= new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          rglList.add(list);
                        }else if ($i7.text.equals("constrain") && !($i8.text.equals("constrain"))){
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = constraint.get($i1.text);
                          list.add($i5.text);
                          list.add(smallerConstraint($i6.text));
                          constraintList.add(list);
                          
                          ArrayList<ArrayList<String>> lgrList = lgr.get($i1.text);
                          list=new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          lgrList.add(list);
                          
                          ArrayList<ArrayList<String>> rglList = rgl.get($i1.text);
                          list=new ArrayList<String>();                          
                          list.add($i5.text);
                          list.add(rMinusL($i6.text));
                          list.add($i8.text);
                          rglList.add(list);                     
                        } else if (!($i7.text.equals("constrain")) && $i8.text.equals("constrain")){
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = constraint.get($i1.text);
                          list.add($i5.text);
                          list.add(largerConstraint($i6.text));
                          constraintList.add(list);
                          
                          ArrayList<ArrayList<String>> lgrList = lgr.get($i1.text);
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add(lMinusR($i6.text));
                          list.add($i7.text);
                          lgrList.add(list);
                          
                          ArrayList<ArrayList<String>> rglList = rgl.get($i1.text);
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          rglList.add(list);                      
                        } else{
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = constraint.get($i1.text);
                          list.add($i5.text);
                          list.add("0=0");
                          constraintList.add(list);
                          
                          ArrayList<ArrayList<String>> lgrList = lgr.get($i1.text);
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add(lMinusR($i6.text));
                          list.add($i7.text);
                          lgrList.add(list);
                          
                          ArrayList<ArrayList<String>> rglList = rgl.get($i1.text);
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add(rMinusL($i6.text));
                          list.add($i8.text);
                          rglList.add(list);
                        }                       
                      }
                   }
                }
            }else{
                if (constraint.containsKey($i1.text)){
                    error_var_redefined.add(currentFile+": "+ $i1.text+" redefined");
                    redefineConstraint=true;
                }else{
                    redefineConstraint=false;
                    constraintOnly=false;
                    n_always=0;
                  
                    if (!(preCondition.equals("always"))){
                      error_grammer.add(currentFile+": "+preConstraint+" the last case should be always");
                    }
                    if ($i2.text.equals("y")){
                      includeConstraint=true;
                      if ($i5.text.equals("always")){
                          if (!($i4.text.equals("y"))){
                            error_grammer.add(currentFile+": "+$i1.text+" includecase field should be y when the conditon is always");
                          }
                      }
                    }else if ($i2.text.equals("n")){
                      includeConstraint=false;
                    }else{
                      error_grammer.add(currentFile+": "+$i1.text+" include field should be y or n");
                    }
                    if ($i5.text.equals("always")){
                      n_always=n_always+1;
                    }
                    if (includeConstraint && $i4.text.equals("y")){
                      if (($i7.text==null) || ($i8.text==null)){
                        constraintOnly=true;
                        if (($i7.text==null) && ($i8.text==null)){
                          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>();
                          ArrayList<String> list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add($i6.text);
                          constraintList.add(list);
                          constraint.put($i1.text, constraintList);
                        }else{
                          error_grammer.add(currentFile+": "+$i1.text+" lhs>rhs and rhs>lhs fields can only be both # or neither");
                        }
                      }else{
                        if ($i7.text.equals("constrain") && $i8.text.equals("constrain")){
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>();
                          list.add($i5.text);
                          list.add(equalConstraint($i6.text));
                          constraintList.add(list);
                          constraint.put($i1.text, constraintList);
                          
                          ArrayList<ArrayList<String>> lgrList = new ArrayList<ArrayList<String>>();
                          list= new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          lgrList.add(list);
                          lgr.put($i1.text, lgrList);
                          
                          ArrayList<ArrayList<String>> rglList = new ArrayList<ArrayList<String>>();
                          list= new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          rglList.add(list);
                          rgl.put($i1.text, rglList); 
                        }else if ($i7.text.equals("constrain") && !($i8.text.equals("constrain"))){
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>();
                          list.add($i5.text);
                          list.add(smallerConstraint($i6.text));
                          constraintList.add(list);
                          constraint.put($i1.text, constraintList);
                          
                          ArrayList<ArrayList<String>> lgrList = new ArrayList<ArrayList<String>>();
                          list=new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          lgrList.add(list);
                          lgr.put($i1.text, lgrList);
                          
                          ArrayList<ArrayList<String>> rglList = new ArrayList<ArrayList<String>>();
                          list=new ArrayList<String>();                          
                          list.add($i5.text);
                          list.add(rMinusL($i6.text));
                          list.add($i8.text);
                          rglList.add(list);
                          rgl.put($i1.text, rglList);                       
                        } else if (!($i7.text.equals("constrain")) && $i8.text.equals("constrain")){
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>();
                          list.add($i5.text);
                          list.add(largerConstraint($i6.text));
                          constraintList.add(list);
                          constraint.put($i1.text, constraintList);
                          
                          ArrayList<ArrayList<String>> lgrList = new ArrayList<ArrayList<String>>();
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add(lMinusR($i6.text));
                          list.add($i7.text);
                          lgrList.add(list);
                          lgr.put($i1.text, lgrList);
                          
                          ArrayList<ArrayList<String>> rglList = new ArrayList<ArrayList<String>>();
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add("0");
                          list.add("0");
                          rglList.add(list);
                          rgl.put($i1.text, rglList);                       
                        } else{
                          ArrayList<String> list = new ArrayList<String>();
                          ArrayList<ArrayList<String>> constraintList = new ArrayList<ArrayList<String>>();
                          list.add($i5.text);
                          list.add("0=0");
                          constraintList.add(list);
                          constraint.put($i1.text, constraintList);
                          
                          ArrayList<ArrayList<String>> lgrList = new ArrayList<ArrayList<String>>();
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add(lMinusR($i6.text));
                          list.add($i7.text);
                          lgrList.add(list);
                          lgr.put($i1.text, lgrList);
                          
                          ArrayList<ArrayList<String>> rglList = new ArrayList<ArrayList<String>>();
                          list = new ArrayList<String>();
                          list.add($i5.text);
                          list.add(rMinusL($i6.text));
                          list.add($i8.text);
                          rglList.add(list);
                          rgl.put($i1.text, rglList);
                        }                       
                      }
                    }
                }
            }
            preCondition=$i5.text;
            preConstraint=$i1.text;	       
	} 
	;
	
content_weight
	:	IDENT ',' weight{
	   if (weight.containsKey($IDENT.text)){
        error_var_redefined.add(currentFile+": "+ $IDENT.text+" redefined");
     }else{
        weight.put($IDENT.text, $weight.text);
     }
	} 
	;
	

///////////////////
/// basic rules ///
///////////////////
lhsrhs: weight|'constrain';

weight	:	allnumber|(allnumber '*taf_cfs');

directory
	:	(';'|'.'|'|'|'_'|'-'|'+'|'/'|BACKSLASH|IDENT|INTEGER)+
	;
	
text	:	LETTER (LETTER | DIGIT )*;
	
tableExpression returns [ArrayList<String> list]
  @init { $list = new ArrayList<String>(); testDefine=true;}
	:	((i1=expression)|(i1=tableSQL)|(i1=timeseriesWithUnits)|(i1=timeseries)){
	   list =$i1.list;
	   testDefine=false;
	}
	;

max_func
	: MAX '(' expression ',' expression ')'
	;

min_func
	: MIN '(' expression ',' expression ')'
	;

timeseriesWithUnits returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC 'units' '=' i2=IDENT{
				list = new ArrayList<String>();
				list.add("TIMESERIESWITHUNITS");
				list.add($i1.text);	
				list.add($i2.text);
		}
	;

timeseries returns[ArrayList<String> list]
	: 'timeseries' 'kind' '=' i1=partC{
				list = new ArrayList<String>();
				list.add("TIMESERIES");
				list.add($i1.text);	
		}
	;
	
partC	
  :	partCIdent1|partCIdent2;
  
partCIdent1
	:	 IDENT ('-' (IDENT|IDENT1))*;
	
partCIdent2
  :  IDENT1 ('-' (IDENT|IDENT1))*;

tableSQL returns[ArrayList<String> list]
	: 'select' i1=IDENT 'from' i2=IDENT 
	  ('given' i3=relationStatement)? ('use' i4=IDENT)? 
	  where_items	  
	  {       
				list = new ArrayList<String>();
				list.add("TABLE");
				list.add($i1.text);
				list.add($i2.text);
				if ($i3.text !=null){
				  list.add($i3.text);
				}else{
				  list.add("");
				}
				if ($i4.text !=null){
				  list.add($i4.text);
				}else{
				  list.add("");
				}				
				list.addAll($where_items.list);
		}
	;

where_items returns[ArrayList<String> list]
	@init { $list = new ArrayList<String>(); }

	:	 WHERE  (r1=whereStatement{list.add($r1.text);} )
	        ('&' r=whereStatement {
	           if ($r.text !=null) {list.add($r.text);}}  )*
	;


upperbound:	IDENT|allnumber;

lowerbound:	IDENT|allnumber;

term
	:	(knownDV
	| (i1=IDENT) 
	|	'(' e=expression ')' 
	|	i=INTEGER 
	|       i=FLOAT 
	|   	max_func
	|   	min_func)
	{
    if ($i1!=null && testDefine && !svar.containsKey($i1.text) && !reserveToken.contains($i1.text)){
      error_grammer.add(currentFile+": "+$i1.text+" is not defined before used");
    }
	}
	;
	
knownDV
  : pastMonthDV|preMonthDV|pastCycleDV
  ;
  
pastMonthDV  
  : i1=IDENT '(' i2=IDENT ')'{
    if (testDefine && !dvar.containsKey($i1.text)){
      error_grammer.add(currentFile+": decision variable "+$i1.text+" is not defined before used");
    }
    if (testDefine && $i2 !=null){
      if (!pastMonth.contains($i2.text)){
        error_grammer.add(currentFile+": "+$i2.text+" in decision variable "+$i1.text+" is wrong");
      }
    }
  }
  ;
  
preMonthDV
  : IDENT '(-' INTEGER ')'{
    if (testDefine && !dvar.containsKey($IDENT.text)){
      error_grammer.add(currentFile+": decision variable "+$IDENT.text+" is not defined before used");
    }
  }
  ;
  
pastCycleDV
  : i1=IDENT '[' i2=IDENT ']'{
    if (testDefine){
      if (!dvar.containsKey($i1.text)){
        error_grammer.add(currentFile+": "+$i1.text+" decision variable is not defined before used");
      }  
      if (!cycle.containsKey($i2.text)){
        error_grammer.add(currentFile+": cycle name "+$i2.text+" is not defined before used");
      }else{
        if (currentCycle.equals($i2.text)){
          error_grammer.add(currentFile+": cycle name "+$i2.text+" should be previous cycle");
        }
      }
    } 
  }
  ; 
	
unary
	:	('-')? term;
	
allnumber
	:	('-')? number;

mult
	:	unary (('*' | '/' | 'mod') unary)*
	;
	
add 
	:	mult (('+' | '-') mult)*
	;

expression returns [ArrayList<String> list]
	:	i=add {
	         list = new ArrayList<String>(); 
	         list.add("EXPRESSION");
	         list.add($i.text); 
	  }
	;

relation
	: '='
	| '<'
	| '>'
	;	

conditionStatement
	:	relationStatementSeries|'always'
	;

whereStatement
  : IDENT '=' expression
  ;
	
relationStatementSeries
  : relationStatement (('&&'|'||') relationStatement)* ;

relationStatement @init { testDefine=true;}
	:	expression relation expression{
	 testDefine=false;
	}
	;

number
	: INTEGER
	| FLOAT
	;

MULTILINE_COMMENT : '/*' .* '*/' {$channel = HIDDEN;} ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
fragment SYMBOLS : '_';	

BACKSLASH : '\\';	 	 

INTEGER : DIGIT+ ;
FLOAT : INTEGER? '.' INTEGER 
	  | INTEGER '.' 
	  ;


MAX : 'max';
MIN : 'min';
WHERE : 'where';

QUOTE_STRING_with_MINUS : '\'' IDENT ( '-' | IDENT )+ '\'';
IDENT : LETTER (LETTER | DIGIT | SYMBOLS )*;
IDENT1 : DIGIT (LETTER | DIGIT | SYMBOLS )*; 

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};
COMMENT : '!' .* ('\n'|'\r') {$channel = HIDDEN;};


	

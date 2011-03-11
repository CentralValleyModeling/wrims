package wrimsv2.tools;

import java.util.ArrayList;
import java.util.Stack;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import wrimsv2.components.Dvar;
import wrimsv2.components.Svar;


public class SVSort {
	private Map<String, Svar> svarMap=new HashMap<String, Svar>();
	private Map<String, String> stringMap = new HashMap<String, String>();
	private Map<String, ArrayList<String>> varMap = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> finalList = new ArrayList<String>();
	private Stack<String> buildStack = new Stack<String>();
	private boolean justDeleted = false;	
	
	public void getSvarMap(Map<String, Svar> svarMap){
		this.svarMap=svarMap;
	}

	public void process(){
		preprocess();
		extractHash();
		sortHash();
	}
	
	public void preprocess(){
		ArrayList<String> svarNameArray=new ArrayList<String>();

		Set svarSet=svarMap.keySet();
		Iterator iterator=svarSet.iterator();
		
		int j = 0;

        while(iterator.hasNext()){
          String svarName=(String)iterator.next();
          Svar currSvar= svarMap.get(svarName);

          ArrayList<ArrayList<String>> currCE=currSvar.getCaseExpression();
          String svarString="";

          for (int i=0; i<currCE.size(); i++){
        	  svarString=svarString+currSvar.getCaseCondition().get(i)+currCE.get(i);
    	  }
    	  stringMap.put(svarName,svarString);
    	  System.out.println(svarString);
          j++;
        }
        
	}
	
	public void extractHash(){
		Set stringMapSet=stringMap.keySet();
		Iterator iterator=stringMapSet.iterator();
		
		while(iterator.hasNext()){
            String svarName=(String)iterator.next(); 
            String currString= stringMap.get(svarName);
            ArrayList<String> tempString = new ArrayList<String>();
            
			while (currString.indexOf("{")>=0) {
				tempString.add(currString.substring(currString.indexOf("{")+1, currString.indexOf("}")));
				currString = currString.substring(currString.indexOf("}")+1);
			}
			varMap.put(svarName, tempString);
		}

	}
	public void sortHash(){
		Set stringMapSet=varMap.keySet();
		Iterator stringMapIterator=stringMapSet.iterator();
		while(stringMapIterator.hasNext()){
			justDeleted=false;
			String svarName=(String)stringMapIterator.next(); //start
			for (int j=0; j<finalList.size();j++){
				String onListString = finalList.get(j);
				if (svarName.equals(finalList.get(j))) justDeleted = true;
			}			
            if (varMap.get(svarName).isEmpty()&&!justDeleted){
            	justDeleted=false;
            	finalList.add(svarName);
            }
            else if (varMap.get(svarName).isEmpty()&&justDeleted);
            else {
            	for(int temp=0; temp<buildStack.size(); temp++){
            		if (buildStack.get(temp).equals(svarName))
            			System.out.println("Error: Circular Reference Error! " + svarName);
            			return;
            	}
               	if(!varMap.containsKey(svarName)){
        			System.out.println("Error: Keys Do Not Exist Inside Map!" + svarName);
        			return;  
               	}
            	buildStack.push(svarName);   
            }
            
            
            while (!buildStack.isEmpty()){
            	String currStackString = buildStack.peek();
            	if (varMap.get(currStackString).isEmpty()){
            		buildStack.pop();
            		finalList.add(currStackString);
            		justDeleted=true;
            	}
            	else {
            		String firstVarMapString = varMap.get(currStackString).get(0);             		
	              	for (int i=0; i<finalList.size(); i++){
	              		String onList = finalList.get(i);
	            		if (firstVarMapString.equals(onList)){
	            			justDeleted=true;  
	            			varMap.get(currStackString).remove(0);
	            			break;
	            		}
	            	}
            	}
            	if (!justDeleted) {
                   	for(int temp=0; temp<buildStack.size(); temp++){
                		if (buildStack.get(temp).equals(varMap.get(currStackString).get(0))){
                			System.out.println("Error: Circular Reference Error!" + svarName + " and " + varMap.get(currStackString).get(0));
                			return;  
                		}
                   	}
                   	if(!varMap.containsKey(varMap.get(currStackString).get(0))){
            			System.out.println("Error: Keys Do Not Exist Inside Map!" + svarName + " and " + varMap.get(currStackString).get(0));
            			return;  
                   	}
            		buildStack.push(varMap.get(currStackString).get(0));       
            	}
               	
            	justDeleted=false;
            }
		}

		System.out.println(varMap);
		System.out.println("the first var a is: " + finalList);
	}
}

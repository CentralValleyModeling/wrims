package test.test_sort;

import components.Svar; 
import sort.SVSort;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.*;
import org.testng.Assert;

public class TestSort{
	private Map<String, Svar> svarMap=new HashMap<String, Svar>();
	
	@Test
	public void sample()
	{
		Assert.assertEquals(1,1);
        System.out.println("@Test sample: 1==1");
	}
	
	@Test
	public TestSort(){
		Svar svar1=new Svar();
		ArrayList<String> caseCondition1 = new ArrayList<String>();
		
		caseCondition1.add("{c}>0");
		caseCondition1.add("{c}<0");		
		svar1.setCaseCondition(caseCondition1);
		
		ArrayList<ArrayList<String>> caseExpression1 = new ArrayList<ArrayList<String>>();
		ArrayList<String> caseExpression1_1=new ArrayList<String>();
		caseExpression1_1.add("EXPRESSION");
		caseExpression1_1.add("{b}+{e}+{f}");
		caseExpression1.add(caseExpression1_1);
		ArrayList<String> caseExpression1_2=new ArrayList<String>();
		caseExpression1_2.add("EXPRESSION");
		caseExpression1_2.add("{c}+{e}+{e}");
		caseExpression1.add(caseExpression1_2);	
		svar1.setCaseExpression(caseExpression1);
		svarMap.put("a", svar1);
		
		
		//conditions "b" when D%2=0 or 1
		Svar svar2=new Svar();
		ArrayList<String> caseCondition2 = new ArrayList<String>();
		caseCondition2.add("always");
		svar2.setCaseCondition(caseCondition2);
		ArrayList<ArrayList<String>> caseExpression2 = new ArrayList<ArrayList<String>>();
		ArrayList<String> caseExpression2_1 = new ArrayList<String>();
		caseExpression2_1.add("EXPRESSION");
		caseExpression2_1.add("6*{f}");
		caseExpression2.add(caseExpression2_1);
		svar2.setCaseExpression(caseExpression2);
		svarMap.put("b", svar2);
		
		//conditions "e" 
		Svar svar3=new Svar();
		ArrayList<String> caseCondition3 = new ArrayList<String>();
		caseCondition3.add("{b}=6");
		caseCondition3.add("{b}!=6");
		svar3.setCaseCondition(caseCondition3);
		ArrayList<ArrayList<String>> caseExpression3 = new ArrayList<ArrayList<String>>();
		ArrayList<String> caseExpression3_1 = new ArrayList<String>();
		caseExpression3_1.add("EXPRESSION");
		caseExpression3_1.add("{c}+{d}");
		caseExpression3.add(caseExpression3_1);
		ArrayList<String> caseExpression3_2 = new ArrayList<String>();
		caseExpression3_2.add("EXPRESSION");
		caseExpression3_2.add("{f}+{d}");
		caseExpression3.add(caseExpression3_2);
		svar3.setCaseExpression(caseExpression3);
		svarMap.put("e", svar3);
		
		//conditions "c" 
		Svar svar4=new Svar();
		ArrayList<String> caseCondition4 = new ArrayList<String>();
		caseCondition4.add("always");
		svar4.setCaseCondition(caseCondition4);
		ArrayList<ArrayList<String>> caseExpression4 = new ArrayList<ArrayList<String>>();
		ArrayList<String> caseExpression4_1 = new ArrayList<String>();
		caseExpression4_1.add("EXPRESSION");
		caseExpression4_1.add("5*{d}");
		caseExpression4.add(caseExpression4_1);
		svar4.setCaseExpression(caseExpression4);
		svarMap.put("c", svar4);
	
		//conditions "d" 
		Svar svar5=new Svar();
		ArrayList<String> caseCondition5 = new ArrayList<String>();
		caseCondition5.add("always");
		svar5.setCaseCondition(caseCondition5);
		ArrayList<ArrayList<String>> caseExpression5 = new ArrayList<ArrayList<String>>();
		ArrayList<String> caseExpression5_1 = new ArrayList<String>();
		caseExpression5_1.add("EXPRESSION");
		caseExpression5_1.add("{g}");
		caseExpression5.add(caseExpression5_1);
		svar5.setCaseExpression(caseExpression5);
		svarMap.put("d", svar5);
		
		//conditions "f" 
		Svar svar6=new Svar();
		ArrayList<String> caseCondition6 = new ArrayList<String>();
		caseCondition6.add("b=10");
		caseCondition6.add("b!=10");
		svar6.setCaseCondition(caseCondition6);
		ArrayList<ArrayList<String>> caseExpression6 = new ArrayList<ArrayList<String>>();
		ArrayList<String> caseExpression6_1 = new ArrayList<String>();
		caseExpression6_1.add("EXPRESSION");
		caseExpression6_1.add("{c}-{d}");
		caseExpression6.add(caseExpression6_1);
		ArrayList<String> caseExpression6_2 = new ArrayList<String>();
		caseExpression6_2.add("EXPRESSION");
		caseExpression6_2.add("{c}+{d}");
		caseExpression6.add(caseExpression6_2);
		svar6.setCaseExpression(caseExpression6);
		svarMap.put("f", svar6);
		
		Svar a=svarMap.get("b");
		ArrayList<String> aCC=a.getCaseCondition();
		ArrayList<ArrayList<String>> aCE=a.getCaseExpression();/*
		for (int i=0; i<aCC.size(); i++){
			System.out.println(aCC.get(i));
			System.out.println(aCE.get(i));
		}
		*/
		SVSort sVsort=new SVSort();
		sVsort.getSvarMap(svarMap);
		sVsort.process();
	}

}
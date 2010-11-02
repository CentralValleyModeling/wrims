package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import WRESL.ConvertWRESLLexer;
import WRESL.ConvertWRESLParser;

import org.testng.annotations.*;
import org.testng.Assert;


public class SandBox {	

	@Test(groups = { "sandbox" })
	public void ArrayList2d()
	{ 
		ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();

		// add 2nd dimension
		for ( int i = 0; i < 3; i++ )
		    myList.add(new ArrayList<String>());

		// add some contents
		myList.get(0).add("a");myList.get(0).add("b");myList.get(0).add("c");
		myList.get(1).add("1");myList.get(1).add("2");myList.get(1).add("3");
		
		//System.out.println(myList);
	}
	
	@Test(groups = { "sandbox" })	
	public void MapOfMap()
	{ 
		ArrayList<ArrayList<String>> list2d ;
		Map<String, Map<String, ArrayList<ArrayList<String>>>>  map_of_map    = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>> (); 
	    Map<String, ArrayList<ArrayList<String>>>   map_of_2d_list     = new HashMap<String, ArrayList<ArrayList<String>>>  (); 
	    ArrayList<String> list ;

	    list2d = new ArrayList<ArrayList<String>>();
		for ( int i = 0; i < 3; i++ )
		    list2d.add(new ArrayList<String>());
	    
	    list = new ArrayList<String>();
	    list.addAll(Arrays.asList(new String[]{"v1","v2","v3","v4"}));
	    list2d.get(0).addAll(list);
	    map_of_2d_list.put("subkey1", list2d);
		
	    list = new ArrayList<String>();
	    list.addAll(Arrays.asList(new String[]{"v5","v6","v7","v8"}));
	    list2d.get(1).addAll(list);
	    map_of_2d_list.put("subkey2", list2d);
				
		map_of_map.put("key1", map_of_2d_list);
	    
		System.out.println(map_of_map);
	}	

	@Test(groups = { "sandbox" })	
	public void MapOf2dList()
	{ 
	    Map<String, Map<String, ArrayList<String>>>  map_of_map    = new HashMap<String, Map<String, ArrayList<String>>> (); 
	    Map<String, ArrayList<String>>   map_array     = new HashMap<String,ArrayList<String>> (); 
	    ArrayList<String> list ;

	    list = new ArrayList<String>();
	    list.addAll(Arrays.asList(new String[]{"v1","v2","v3","v4"}));
		map_array.put("subkey1", list);
		
	    list = new ArrayList<String>();
	    list.addAll(Arrays.asList(new String[]{"v5","v6","v7","v8"}));
		map_array.put("subkey2", list);
				
		map_of_map.put("key1", map_array);
	    
		//System.out.println(map_of_map);
	}		
	
	
}

package test.convertWresl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.*;


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
	

	@Test(groups = { "sandbox" })	
	public void MapConectingMap()
	{ 

	    Map<String, ArrayList<String>>   svar_case_list  = new HashMap<String,ArrayList<String>> (); 
	    Map<String, ArrayList<ArrayList<String>>>   map_cases; 
	    Map<String, Map<String, ArrayList<ArrayList<String>>>> svar_case_statements = new HashMap<String,Map<String, ArrayList<ArrayList<String>>>>(); 
	    
	    ArrayList<String> list_case_names;
	    ArrayList<ArrayList<String>> list_case_2d;

		// new svar
	    map_cases  = new HashMap<String,ArrayList<ArrayList<String>>>(); 
	    list_case_names = new ArrayList<String>();
	    
	    // new case
	    list_case_2d = new ArrayList<ArrayList<String>>();
		list_case_2d.add(new ArrayList<String>());list_case_2d.add(new ArrayList<String>());

		list_case_names.add("Febfore");
		list_case_2d.get(0).add("sql");
		list_case_2d.get(1).addAll(Arrays.asList(new String[]{"month == FEB","FEB","sacramento_runoff_forecast",null,null,"wateryear=wateryear",null,null}));
		map_cases.put("Febfore", list_case_2d);
		
		// new case
	    list_case_2d = new ArrayList<ArrayList<String>>();
		list_case_2d.add(new ArrayList<String>());list_case_2d.add(new ArrayList<String>());

		list_case_names.add("JuntoJan");
		list_case_2d.get(0).add("value");
		list_case_2d.get(1).addAll(Arrays.asList(new String[]{"always","0"}));
		map_cases.put("JuntoJan", list_case_2d);

		// conclude 1st svar
		svar_case_list.put("frcst_sac", list_case_names);
		svar_case_statements.put("frcst_sac", map_cases);

	    
		// print
		System.out.println("----------");
		for (String svarName : svar_case_list.keySet()) {
			//System.out.println(key+"::"+map_cases.get(key));			
			for (String caseName : svar_case_list.get(svarName)) {

				System.out.println(svarName+"::"+caseName+"::"+svar_case_statements.get(svarName).get(caseName));
			}
		}
		System.out.println("----------");	
		
		
		}

	}		
	
	


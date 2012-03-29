package wrimsv2.wreslplus.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.HashBasedTable;

public class StudyTemp implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String runDir = null;
	public String absPath = null;
	public String relativePath = null;
	
	public ArrayList<String> seqList;
	public Map<String, SequenceTemp> seqMap;
	public ArrayList<String> modelList_effective;  //processed		
	public ArrayList<String> modelList;		
	public Map<String, ModelTemp> modelMap;
	public Map<String, ArrayList<String>> fileModelNameMap;  
	public HashBasedTable<String,String,ModelTemp> fileModelDataTable; // <file,modelName,model>
	public Map<String, HashSet<String>>kidMap; // processed
	//public HashBasedTable<String,String,HashSet<String>>kidssMap; // processed <file,modelName,model>
	public HashSet<String> noKid; // processed
	public Map<String, HashSet<String>>AOMap; // all offspring map. processed
	public ArrayList<HashSet<String>>fileGroupOrder; // processed after kidMap and AOMap
	public String objectiveType="obj";
	
	public StudyTemp(){
		
		modelList = new ArrayList<String>();
		modelList_effective = new ArrayList<String>();
		modelMap = new HashMap<String, ModelTemp>();	
		seqList = new ArrayList<String>();
		seqMap = new HashMap<String, SequenceTemp>();	
		fileModelNameMap = new LinkedHashMap<String, ArrayList<String>>();
		fileModelDataTable = HashBasedTable.create();

		kidMap = new HashMap<String, HashSet<String>>();
		//kidssMap = HashBasedTable.create();
		noKid = new HashSet<String>();
		AOMap = new HashMap<String, HashSet<String>>();
		fileGroupOrder = new ArrayList<HashSet<String>>();

	}
	
}

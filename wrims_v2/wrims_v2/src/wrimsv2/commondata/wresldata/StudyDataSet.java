package wrimsv2.commondata.wresldata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StudyDataSet {
	
	
	private String absMainFilePath;
	
	private ArrayList<String> modelList = new ArrayList<String>();
	private ArrayList<String> modelConditionList = new ArrayList<String>();
	
	///  < modelName, modelDataSet > 		
	private Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();
	
	
	public String getAbsMainFilePath() {
		return absMainFilePath;
	}

	public void setAbsMainFilePath(String absMainFilePath) {
		this.absMainFilePath = absMainFilePath;
	}

	public ArrayList<String> getModelList() {
		return modelList;
	}

	public void setModelList(ArrayList<String> modelList) {
		this.modelList = modelList;
	}

	public ArrayList<String> getModelConditionList() {
		return modelConditionList;
	}

	public void setModelConditionList(ArrayList<String> modelConditionList) {
		this.modelConditionList = modelConditionList;
	}

	public Map<String, ModelDataSet> getModelDataSetMap() {
		return modelDataSetMap;
	}

	public void setModelDataSetMap(Map<String, ModelDataSet> modelDataSetMap) {
		this.modelDataSetMap = modelDataSetMap;
	}

}

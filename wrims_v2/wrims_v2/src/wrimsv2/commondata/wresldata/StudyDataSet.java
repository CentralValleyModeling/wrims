package wrimsv2.commondata.wresldata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import wrimsv2.evaluator.ValueEvaluatorParser;


public class StudyDataSet {
	
	
	private String absMainFilePath;
	
	private ArrayList<String> modelList = new ArrayList<String>();
	private ArrayList<String> modelConditionList = new ArrayList<String>();
	private ArrayList<ValueEvaluatorParser> modelConditionParsers=new ArrayList<ValueEvaluatorParser>();
	
	///  < timeseries name, timeseries object > 
	private Map<String, Timeseries> timeseriesMap = new HashMap<String, Timeseries>();
	
	///  < modelName, modelDataSet > 		
	private Map<String, ModelDataSet> modelDataSetMap = new HashMap<String, ModelDataSet>();

	public Map<String, Timeseries> getTimeseriesMap() {
		return new HashMap<String, Timeseries>(timeseriesMap);
	}

	public void setTimeseriesMap(Map<String, Timeseries> timeseriesMap) {
		this.timeseriesMap = timeseriesMap;
	}
	
	public String getAbsMainFilePath() {
		return new String(absMainFilePath);
	}

	public void setAbsMainFilePath(String absMainFilePath) {
		this.absMainFilePath = absMainFilePath;
	}

	public ArrayList<String> getModelList() {
		return new ArrayList<String>(modelList);
	}

	public void setModelList(ArrayList<String> modelList) {
		this.modelList = modelList;
	}

	public ArrayList<String> getModelConditionList() {
		return new ArrayList<String>(modelConditionList);
	}

	public void setModelConditionList(ArrayList<String> modelConditionList) {
		this.modelConditionList = modelConditionList;
	}
	
	public ArrayList<ValueEvaluatorParser> getModelConditionParsers() {
		return modelConditionParsers;
	}
	
	public void setModelConditionParsers(ArrayList<ValueEvaluatorParser> modelConditionParsers) {
		this.modelConditionParsers=modelConditionParsers;
	}

	public Map<String, ModelDataSet> getModelDataSetMap() {
		return new HashMap<String, ModelDataSet>(modelDataSetMap);
	}

	public void setModelDataSetMap(Map<String, ModelDataSet> modelDataSetMap) {
		this.modelDataSetMap = modelDataSetMap;
	}

}

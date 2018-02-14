package wrimsv2.evaluator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import wrimsv2.components.ControlData;

public class CsvOperation {
	
	private String slackPrefix="slack__";
	private String surplusPrefix="surplus__";
	
	public void ouputCSV(String csvLocalPath, int scenarioIndex){
		try {
			System.out.println("Writing data to CSV file...");
			
			File csvFile= new File(csvLocalPath);
			csvFile.getParentFile().mkdirs();
			FileWriter fw = new FileWriter(csvFile);
			BufferedWriter bw = new BufferedWriter(fw, 8192);
			String line="id,Timestep,Units,Date_Time,Variable,Kind,Value\n";
			bw.write(line);
			Set<String> keys = DataTimeSeries.dvAliasTS.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()){
				String name=it.next();
				String nameLow=name.toLowerCase();
				if (!nameLow.startsWith(slackPrefix) && !nameLow.startsWith(surplusPrefix)){
					DssDataSetFixLength dds = DataTimeSeries.dvAliasTS.get(name);
					String timestep=dds.getTimeStep().toUpperCase();
					Date date = dds.getStartTime();
					String unitsName=formUnitsName(dds.getUnits());
					String variableName=formVariableName(name);
					String kindName=formKindName(dds.getKind());
					double[] data = dds.getData();
					if (timestep.equals("1DAY")){
						if (!ControlData.isSimOutput) date=backOneDay(date);
						for (int i=0; i<data.length; i++){
							double value = data[i];
							if (value != -901.0 && value !=-902.0){
								line = scenarioIndex+",1DAY,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+ value +"\n";
								bw.write(line);
							}else{
								if (ControlData.isSimOutput){
									line = scenarioIndex+",1DAY,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+ value +"\n";
									bw.write(line);
								}
							}
							date=addOneDay(date);
						}
					}else{
						if (!ControlData.isSimOutput) date=backOneMonth(date);
						for (int i=0; i<data.length; i++){
							double value = data[i];
							if (value != -901.0 && value !=-902.0){
								line = scenarioIndex+",1MON,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+ value +"\n";
								bw.write(line);
							}else{
								if (ControlData.isSimOutput){
									line = scenarioIndex+",1MON,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+ value +"\n";
									bw.write(line);
								}
							}
							date=addOneMonth(date);
						}
					}
				}
			}
			Set<String> svKeys = DataTimeSeries.svTS.keySet();
			it = svKeys.iterator();
			while (it.hasNext()){
				String name=it.next();
				String nameLow=name.toLowerCase();
				if (!nameLow.startsWith(slackPrefix) && !nameLow.startsWith(surplusPrefix)){
					DssDataSet dds = DataTimeSeries.svTS.get(name);
					String timestep=dds.getTimeStep().toUpperCase();
					String units=dds.getUnits();
					String unitsName=formUnitsName(units);
					String convertToUnits = dds.getConvertToUnits();
					Date date = dds.getStartTime();
					String variableName=formVariableName(name);
					String kindName=formKindName(dds.getKind());
					ArrayList<Double> data = dds.getData();
					if (timestep.equals("1DAY")){
						date=backOneDay(date);
						for (int i=0; i<data.size(); i++){
							double value = data.get(i);
							if (value != -901.0 && value !=-902.0){
								line = scenarioIndex+",1DAY,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+ convertValue(value, units, convertToUnits, date, timestep) +"\n";
								bw.write(line);
							}
							date=addOneDay(date);
						}
					}else{
						date=backOneMonth(date);
						for (int i=0; i<data.size(); i++){
							double value = data.get(i);
							if (value != -901.0 && value !=-902.0){
								line = scenarioIndex+",1MON,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+convertValue(value, units, convertToUnits, date, timestep)+"\n";
								bw.write(line);
							}
							date=addOneMonth(date);
						}
					}
				}
			}
			keys = DataTimeSeries.dvAliasInit.keySet();
			it = keys.iterator();
			while (it.hasNext()){
				String name=it.next();
				if (ControlData.isSimOutput || svKeys.contains(name)){
					String nameLow=name.toLowerCase();
					if (!nameLow.startsWith(slackPrefix) && !nameLow.startsWith(surplusPrefix)){
						DssDataSet dds = DataTimeSeries.dvAliasInit.get(name);
						String timestep=dds.getTimeStep().toUpperCase();
						Date date = dds.getStartTime();
						String units=dds.getUnits();
						String unitsName=formUnitsName(units);
						String convertToUnits=dds.getConvertToUnits();
						String variableName=formVariableName(name);
						String kindName=formKindName(dds.getKind());
						ArrayList<Double> data = dds.getData();
						if (timestep.equals("1DAY")){
							date=backOneDay(date);
							for (int i=0; i<data.size(); i++){
								double value = data.get(i);
								if (value != -901.0 && value !=-902.0){
									line = scenarioIndex+",1DAY,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+convertValue(value, units, convertToUnits, date, timestep)+"\n";
									bw.write(line);
								}
								date=addOneDay(date);
							}
						}else{
							date=backOneMonth(date);
							for (int i=0; i<data.size(); i++){
								double value = data.get(i);
								if (value != -901.0 && value !=-902.0){
									line = scenarioIndex+",1MON,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+convertValue(value, units, convertToUnits, date, timestep)+"\n";
									bw.write(line);
								}
								date=addOneMonth(date);
							}
						}
					}
				}
			}
			if (ControlData.isSimOutput){
				keys = DataTimeSeries.svInit.keySet();
				it = keys.iterator();
				while (it.hasNext()){
					String name=it.next();
					String nameLow=name.toLowerCase();
					if (!nameLow.startsWith(slackPrefix) && !nameLow.startsWith(surplusPrefix)){
						DssDataSet dds = DataTimeSeries.svInit.get(name);
						String timestep=dds.getTimeStep().toUpperCase();
						Date date = dds.getStartTime();
						String units=dds.getUnits();
						String unitsName=formUnitsName(units);
						String convertToUnits=dds.getConvertToUnits();
						String variableName=formVariableName(name);
						String kindName=formKindName(dds.getKind());
						ArrayList<Double> data = dds.getData();
						if (timestep.equals("1DAY")){
							date=backOneDay(date);
							for (int i=0; i<data.size(); i++){
								double value = data.get(i);
								if (value != -901.0 && value !=-902.0){
									line = scenarioIndex+",1DAY,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+convertValue(value, units, convertToUnits, date, timestep)+"\n";
									bw.write(line);
								}
								date=addOneDay(date);
							}
						}else{
							date=backOneMonth(date);
							for (int i=0; i<data.size(); i++){
								double value = data.get(i);
								if (value != -901.0 && value !=-902.0){
									line = scenarioIndex+",1MON,"+unitsName+","+formDateData(date)+","+variableName+","+kindName+","+convertValue(value, units, convertToUnits, date, timestep)+"\n";
									bw.write(line);
								}
								date=addOneMonth(date);
							}
						}
					}
				}
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Wrote data to CSV file");
	}
	
	public double convertValue(double value, String units, String convertToUnits, Date date, String timestep){
		if (units.equalsIgnoreCase("cfs") && convertToUnits.equalsIgnoreCase("taf")){
			return value*factorTafToCfs(date, timestep);
		}else if (units.equalsIgnoreCase("taf") && convertToUnits.equalsIgnoreCase("cfs")){
			return value*factorCfsToTaf(date, timestep);
		}else{
			return value;
		}
	}
	
	public double factorTafToCfs(Date date, String timestep){
		if (timestep.equals("1MON")){
			int year=date.getYear()+1900;
			int month=date.getMonth()+1;
			int daysInMonth=TimeOperation.numberOfDays(month, year);
			return 504.1666667 / daysInMonth;
		}else{
			return 504.1666667;
		}
	}
	
	public double factorCfsToTaf(Date date, String timestep){
		if (timestep.equals("1MON")){
			int year=date.getYear()+1900;
			int month=date.getMonth()+1;
			int daysInMonth=TimeOperation.numberOfDays(month, year);
			return daysInMonth / 504.1666667;
		}else{
			return 1 / 504.1666667;
		}
	}
	
	public String formUnitsName(String units){
		String newUnits=units.replaceAll("/", "_").replaceAll("-", "_");
		return newUnits;
	}
	
	public String formVariableName(String name){
		String variableName = DssOperation.getTSName(name).replaceAll("-", "_");
		return variableName;
	}
	
	public String formKindName(String name){
		String kindName = name.replaceAll("-", "_");
		return kindName;
	}
	
	public String formDateData(Date date){
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day = date.getDate();
		return year+"-"+TimeOperation.monthNameNumeric(month)+"-"+TimeOperation.dayName(day)+" 00:00:00";
	}
	
	public Date addOneMonth(Date date){
		int month=date.getMonth()+1;
		int year=date.getYear();
		if (month>11){
			month=month-12;
			year=year+1;
		}
		int day=TimeOperation.numberOfDays(month+1, year+1900);
		Date newDate = new Date(year, month, day);
		return newDate;
	}
	
	public Date addOneDay(Date date){
		long newTime=date.getTime()+1 * 24 * 60 * 60 * 1000l;
		Date newDate = new Date (newTime);
		return newDate;
	}
	
	public Date backOneMonth(Date date){
		int month=date.getMonth()-1;
		int year=date.getYear();
		if (month<0){
			month=month+12;
			year=year-1;
		}
		int day=TimeOperation.numberOfDays(month+1, year+1900);
		Date newDate = new Date(year, month, day);
		return newDate;
	}
	
	public Date backOneDay(Date date){
		long newTime=date.getTime()-1 * 24 * 60 * 60 * 1000l;
		Date newDate = new Date (newTime);
		return newDate;
	}
}

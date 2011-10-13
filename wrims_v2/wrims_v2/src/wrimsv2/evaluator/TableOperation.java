package wrimsv2.evaluator;

import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.components.Error;
import wrimsv2.components.IntDouble;

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TableOperation {
	public static boolean retrieveLookUpData (String name){
		String tableFullPath=FilePaths.mainDirectory+"lookup\\"+name+".table";
		try{
			    FileInputStream fstream = new FileInputStream(tableFullPath);
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
			    
			    String strLine;
			    boolean isComment =true;
			    boolean isEnd=false;
			    int line=0;
			    strLine="";
			    
			    while (!isEnd && isComment){
			    	strLine=br.readLine();
			    	strLine=removeLeadingTailingSpace(strLine);
			    	line=line+1;
			    	if (strLine==null){
			    		isEnd=true;
			    	}else{
			    		if (!strLine.startsWith("!")) isComment=false;
			    	}
			    }	
			    if (strLine==null){
			    	Error.addEvaluationError("No data exists in the table "+name);
			    	in.close();
			    	return false;
			    }
			    
			    if (strLine.contains("!")) strLine=removeComment(strLine);
			    strLine=removeLeadingTailingSpace(strLine);
			    if (!(strLine.toLowerCase().equals(name))){
			    	Error.addEvaluationError("The first line after comments in the table "+name+" should be table file name "+name+".table");
			    }
			    
			    if ((strLine=br.readLine())==null){
			    	Error.addEvaluationError("No data exists in the table "+name);
			    	in.close();
			    	return false;
			    }
			    line=line+1;
			    LookUpTable lut=new LookUpTable();
			    if (strLine.contains("!")) strLine=removeComment(strLine);
		    	strLine=removeLeadingTailingSpace(strLine);
			    String[] fieldNames=strLine.toLowerCase().split("\\s+");
			    int fieldSize=fieldNames.length;
			    for (int i=0; i<fieldSize; i++){
			    	if (!isFieldNameRight(fieldNames[i])){
			    		Error.addEvaluationError("The No. " +(i+1)+" field name in the table "+name+" line"+line+" has a wrong format");
				    	in.close();
				    	return false;
			    	}
			    	lut.getField().put(fieldNames[i], i);
			    }
			    
			    while ((strLine=br.readLine())!=null){
			    	line=line+1;
			    	if (strLine.contains("!")) strLine=removeComment(strLine);
			    	strLine=removeLeadingTailingSpace(strLine);
			    	String[] values=strLine.split("\\s+");
			    	if (values.length!=fieldSize){
			    		if (values[0].equals("") && lut.getData().size()>0) {
			    			TableSeries.tableSeries.put(name,lut);
			    			in.close();
			    			return true;
			    		}
				    	Error.addEvaluationError("The number of data in the table "+name+" line "+line+" doesn't agree with the number of the field");
				    	in.close();
				    	return false;
			    	}
			    	
			    	Number[] dataLine=new Number[fieldSize];
			    	for (int i=0; i<fieldSize; i++){
			    		try{        
			    			dataLine[i]=Double.parseDouble(values[i]);
			    		} catch(NumberFormatException nfe1) {        
			    	        Error.addEvaluationError("The No. " +(i+1)+" data in the table "+name+" line"+line+" is not numeric");
						    in.close();
						    return false;
			    		}   
			    	}
			    	lut.getData().add(dataLine);
			    }

			    if (lut.getData().size()<1){
			    	Error.addEvaluationError("No data exists in the table "+name);
			    	in.close();
			    	return false;
			    }else{
			    	TableSeries.tableSeries.put(name,lut);
			    }
			    
			    in.close();
		 }catch (Exception e){
			    Error.addEvaluationError(e.getMessage());
		 }
		 return true;
	}
	
	public static String removeComment(String text){
		int index=text.indexOf("!");
		return text.substring(0,index);
	}
	
	public static String removeLeadingTailingSpace(String text){
	    text=text.replaceAll("^\\s+", "");
	    text=text.replaceAll("\\s+$", "");
	    return text;
	}
	
	public static boolean isFieldNameRight(String fieldName){
		if (Character.isDigit(fieldName.charAt(0))){
			return false;
		}
		Pattern alphaNumberic = Pattern.compile("[A-Za-z0-9_]+");
		Matcher m = alphaNumberic.matcher(fieldName);
		return m.matches();	
	}
	
	public static IntDouble findData(String table, String select, HashMap<String, Number> where, HashMap<String, Number> given, String use){
		if (!TableSeries.tableSeries.containsKey(table)){
			if (!retrieveLookUpData(table)){
				return new IntDouble(1.0,false);
			}
		}
		
		LookUpTable lut=TableSeries.tableSeries.get(table);
		ArrayList<Number[]> data=lut.getData();
		HashMap<String, Integer> field= lut.getField();
		int fieldSize=field.size();
		
		int selectIndex;
		if (field.containsKey(select)){
			selectIndex=field.get(select);
		}else{
			Error.addEvaluationError(select+" in the select statement is not a field name in Table "+table);
			return new IntDouble(1.0,false);
		}
		
		Set whereSet=where.keySet();
		Iterator iterator=whereSet.iterator();
		int whereSize=where.size();
		int[] whereIndex=new int[whereSize];
		Number[] whereValue=new Number[whereSize];
		int k=0;		
		while(iterator.hasNext()){
			String whereName=(String)iterator.next();
			if (field.containsKey(whereName)){
				whereIndex[k]=field.get(whereName);
			}else{
				Error.addEvaluationError(whereName+" in the where statement is not a field name in Table "+table);
				return new IntDouble(1.0,false);
			}
			whereValue[k]=(Number)where.get(whereName);
			k=k+1;
		}
			
		boolean whereTrue;
		if (whereSize==0){
			whereTrue=true;
		}else{
			whereTrue=false;
		}
		
		Number[] values=new Number[fieldSize];
		Number[] pastValues=new Number[fieldSize];
		int i=-1;
		while (i<data.size()-1 && !whereTrue){
			i++;
			values=data.get(i);
			pastValues=values;
			boolean eachWhereTrue=true;
			k=-1;
			while (k<whereSize-1 && eachWhereTrue){
				k++;
				if (values[whereIndex[k]].doubleValue()!=whereValue[k].doubleValue()){
					eachWhereTrue=false;
				}
			}
			if (eachWhereTrue) whereTrue=true;
		}
		
		if (!whereTrue){
			Error.addEvaluationError("Under those where statements, data could not be found in Table "+table);
			for (String key: where.keySet()){
				Error.addEvaluationError(key+": "+where.get(key));
			}
			Error.addEvaluationError("ControlData.currMonth: "+ControlData.currMonth);
			return new IntDouble(1.0,false);
		}
		
		Number value=values[selectIndex];
		if (given==null){
			String valueString=value.toString();
			return generateIntDouble(valueString);
		}
		

		int givenIndex;
		Set givenSet=given.keySet();
		iterator=givenSet.iterator();
		String givenName=(String)iterator.next();
		String valueString;
		if (field.containsKey(givenName)){
			givenIndex=field.get(givenName);
		}else{
			Error.addEvaluationError(givenName+" in the given statement is not a field name in Table "+table);
			return new IntDouble(1.0,false);
		}
		Number givenValue=(Number)given.get(givenName);
		
		if (givenValue.doubleValue()==values[givenIndex].doubleValue()){
			valueString=value.toString();
			return generateIntDouble(valueString);
		}
		
		boolean givenTrue=false;
		while (i<data.size()-1 && !givenTrue){
			i++;
			Number[] newValues=data.get(i);
			boolean eachWhereTrue=true;
			k=-1;
			while (k<whereSize-1 && eachWhereTrue){
				k++;
				if (newValues[whereIndex[k]].doubleValue()!=whereValue[k].doubleValue()){
					eachWhereTrue=false;
				}
			}
			if (!eachWhereTrue) {
				whereTrue=false;
			}else{	
				if (givenValue.doubleValue()==newValues[givenIndex].doubleValue()){
					Number newValue=newValues[selectIndex];
					valueString=newValue.toString();
					return generateIntDouble(valueString);
				}
				if ((givenValue.doubleValue()-newValues[givenIndex].doubleValue())*(givenValue.doubleValue()-values[givenIndex].doubleValue())<0){  
					if (use.equals("maximum")){
						if (newValues[givenIndex].doubleValue()>values[givenIndex].doubleValue()){
							valueString=newValues[selectIndex].toString();
						}else{
							valueString=values[selectIndex].toString();
						}
					}else if (use.equals("minimum")){
						if (newValues[givenIndex].doubleValue()<values[givenIndex].doubleValue()){
							valueString=newValues[selectIndex].toString();
						}else{
							valueString=values[selectIndex].toString();
						}
					}else if (use.equals("linear")){
						value=((givenValue.doubleValue()-values[givenIndex].doubleValue())/(newValues[givenIndex].doubleValue()-values[givenIndex].doubleValue())
							*(newValues[selectIndex].doubleValue()-values[selectIndex].doubleValue())+values[selectIndex].doubleValue());
						return new IntDouble(value, false);
					}else{
						Error.addEvaluationError("Use statement can only be maximum, minimum, or linear in Table"+table);
						return new IntDouble(1.0,false);
					}
					return generateIntDouble(valueString);
				}
				pastValues=values;
				values=newValues;
			}
		}
		
		if ((givenValue.doubleValue()>pastValues[givenIndex].doubleValue()) && (givenValue.doubleValue()>values[givenIndex].doubleValue())){
			if (pastValues[givenIndex].doubleValue()<values[givenIndex].doubleValue()){
				value=(givenValue.doubleValue()-values[givenIndex].doubleValue())/(values[givenIndex].doubleValue()-pastValues[givenIndex].doubleValue())
				*(values[selectIndex].doubleValue()-pastValues[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}else if (pastValues[givenIndex].doubleValue()>values[givenIndex].doubleValue()){
				value=(givenValue.doubleValue()-pastValues[givenIndex].doubleValue())/(pastValues[givenIndex].doubleValue()-values[givenIndex].doubleValue())
				*(pastValues[selectIndex].doubleValue()-values[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}
		}else if((givenValue.doubleValue()<pastValues[givenIndex].doubleValue()) && (givenValue.doubleValue()<values[givenIndex].doubleValue())){
			if (pastValues[givenIndex].doubleValue()>values[givenIndex].doubleValue()){
				value=(givenValue.doubleValue()-values[givenIndex].doubleValue())/(values[givenIndex].doubleValue()-pastValues[givenIndex].doubleValue())
				*(values[selectIndex].doubleValue()-pastValues[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}else if (pastValues[givenIndex].doubleValue()<values[givenIndex].doubleValue()){
				value=(givenValue.doubleValue()-pastValues[givenIndex].doubleValue())/(pastValues[givenIndex].doubleValue()-values[givenIndex].doubleValue())
				*(pastValues[selectIndex].doubleValue()-values[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}
		}
		
		if (values[givenIndex].doubleValue()>=pastValues[givenIndex].doubleValue() && givenValue.doubleValue()>values[givenIndex].doubleValue() && use.equals("minimum")){
			return new IntDouble(values[selectIndex],false);
		}
		
		if (values[givenIndex].doubleValue()<=pastValues[givenIndex].doubleValue() && givenValue.doubleValue()<values[givenIndex].doubleValue() && use.equals("maximum")){
			return new IntDouble(values[selectIndex],false);
		}
		
		Error.addEvaluationError("Data not found in Table "+table);
		return new IntDouble(1.0,false);
	}
	
	public static IntDouble findData(String table, String select, HashMap<String, Number> given, String use){
		if (!TableSeries.tableSeries.containsKey(table)){
			if (!retrieveLookUpData(table)){
				return new IntDouble(1.0,false);
			}
		}
		
		LookUpTable lut=TableSeries.tableSeries.get(table);
		ArrayList<Number[]> data=lut.getData();
		HashMap<String, Integer> field= lut.getField();
		int fieldSize=field.size();
		
		int selectIndex;
		if (field.containsKey(select)){
			selectIndex=field.get(select);
		}else{
			Error.addEvaluationError(select+" in the select statement is not a field name in Table "+table);
			return new IntDouble(1.0,false);
		}
				
		if (given==null){
			Error.addEvaluationError("select data from table needs either where statement or given statement.");
			return new IntDouble(1.0,false);
		}
		
		Number[] values=new Number[fieldSize];
		Number[] pastValues=new Number[fieldSize];

		int givenIndex;
		Set givenSet=given.keySet();
		Iterator iterator=givenSet.iterator();
		String givenName=(String)iterator.next();
		String valueString;
		
		if (field.containsKey(givenName)){
			givenIndex=field.get(givenName);
		}else{
			Error.addEvaluationError(givenName+" in the given statement is not a field name in Table "+table);
			return new IntDouble(1.0,false);
		}
		Number givenValue=(Number)given.get(givenName);
		
		values=data.get(0);	
		pastValues=values;
		if (givenValue.doubleValue()==values[givenIndex].doubleValue()){
			valueString=values[selectIndex].toString();
			return generateIntDouble(valueString);
		}
		
		int i=-1;
		boolean givenTrue=false;
		while (i<data.size()-1 && !givenTrue){
			i++;
			Number[] newValues=data.get(i);	
			if (givenValue.doubleValue()==newValues[givenIndex].doubleValue()){
				Number newValue=newValues[selectIndex];
				valueString=newValue.toString();
				return generateIntDouble(valueString);
			}
			if ((givenValue.doubleValue()-newValues[givenIndex].doubleValue())*(givenValue.doubleValue()-values[givenIndex].doubleValue())<0){  
				if (use.equals("maximum")){
					if (newValues[givenIndex].doubleValue()>values[givenIndex].doubleValue()){
						valueString=newValues[selectIndex].toString();
					}else{
						valueString=values[selectIndex].toString();
					}
				}else if (use.equals("minimum")){
					if (newValues[givenIndex].doubleValue()<values[givenIndex].doubleValue()){
						valueString=newValues[selectIndex].toString();
					}else{
						valueString=values[selectIndex].toString();
					}
				}else if (use.equals("linear")){
					double value=((givenValue.doubleValue()-values[givenIndex].doubleValue())/(newValues[givenIndex].doubleValue()-values[givenIndex].doubleValue())
							*(newValues[selectIndex].doubleValue()-values[selectIndex].doubleValue())+values[selectIndex].doubleValue());
					return new IntDouble(value, false);
				}else{
					Error.addEvaluationError("Use statement can only be maximum, minimum, or linear in Table"+table);
					return new IntDouble(1.0,false);
				}
				return generateIntDouble(valueString);
			}
			pastValues=values;
			values=newValues;
		}
		
		if (givenValue.doubleValue()>pastValues[givenIndex].doubleValue() && givenValue.doubleValue()>values[givenIndex].doubleValue() && use.equals("linear")){
			if (pastValues[givenIndex].doubleValue()<values[givenIndex].doubleValue()){
				double value=(givenValue.doubleValue()-values[givenIndex].doubleValue())/(values[givenIndex].doubleValue()-pastValues[givenIndex].doubleValue())
				*(values[selectIndex].doubleValue()-pastValues[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}else if (pastValues[givenIndex].doubleValue()>values[givenIndex].doubleValue()){
				double value=(givenValue.doubleValue()-pastValues[givenIndex].doubleValue())/(pastValues[givenIndex].doubleValue()-values[givenIndex].doubleValue())
				*(pastValues[selectIndex].doubleValue()-values[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}
		}else if(givenValue.doubleValue()<pastValues[givenIndex].doubleValue() && givenValue.doubleValue()<values[givenIndex].doubleValue() && use.equals("linear")){
			if (pastValues[givenIndex].doubleValue()>values[givenIndex].doubleValue()){
				double value=(givenValue.doubleValue()-values[givenIndex].doubleValue())/(values[givenIndex].doubleValue()-pastValues[givenIndex].doubleValue())
				*(values[selectIndex].doubleValue()-pastValues[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}else if (pastValues[givenIndex].doubleValue()<values[givenIndex].doubleValue()){
				double value=(givenValue.doubleValue()-pastValues[givenIndex].doubleValue())/(pastValues[givenIndex].doubleValue()-values[givenIndex].doubleValue())
				*(pastValues[selectIndex].doubleValue()-values[selectIndex].doubleValue())+values[selectIndex].doubleValue();
				return new IntDouble(value,false);
			}
		}
		
		if (values[givenIndex].doubleValue()>=pastValues[givenIndex].doubleValue() && givenValue.doubleValue()>values[givenIndex].doubleValue() && use.equals("minimum")){
			return new IntDouble(values[selectIndex],false);
		}
		
		if (values[givenIndex].doubleValue()<=pastValues[givenIndex].doubleValue() && givenValue.doubleValue()<values[givenIndex].doubleValue() && use.equals("maximum")){
			return new IntDouble(values[selectIndex],false);
		}
		
		Error.addEvaluationError("Data not found in Table "+table);
		return new IntDouble(1.0,false);
	}
	
	public static IntDouble generateIntDouble(String valueString){    
		double doubleValue=Double.parseDouble(valueString);
		return new IntDouble(doubleValue, false);
	}
}

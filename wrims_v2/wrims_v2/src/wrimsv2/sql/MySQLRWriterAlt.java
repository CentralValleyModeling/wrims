package wrimsv2.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import wrimsv2.components.ControlData;
import wrimsv2.components.FilePaths;
import wrimsv2.evaluator.DataTimeSeries;
import wrimsv2.evaluator.DssDataSetFixLength;
import wrimsv2.evaluator.DssOperation;
import wrimsv2.evaluator.TimeOperation;

public class MySQLRWriterAlt {
	
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";       
	private String database="callite";                                  //input
	private String DB_URL = "jdbc:mysql://localhost:3306/"+database;    //input
	private String tableName = "DCR2017";                               //input
	
	private String USER = "root";                                       //input
	private String PASS = "BDOisNo1";                                   //input
	
	private Connection conn = null;
	private Statement stmt = null;
	
	private String scenarioName=FilePaths.sqlScenarioName;
	
	public MySQLRWriterAlt(){   
		connectToDataBase();
		createTable();
		deleteOldData();
		writeData();
	}
			
	public void connectToDataBase(){	
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTable(){
		System.out.println("Creating table in given database...");
		try {
			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS "+tableName + " (Scenario VarChar(40), Part_A VarChar(20), Part_F VarChar(30), Timestep VarChar(8), Units VarChar(20), Date DATE, Variable VarChar(80), Value Double)";
			stmt.executeUpdate(sql);
			System.out.println("Created tables in given database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOldData(){
		try {
			System.out.println("Deleting old data in table...");
			Statement statement = conn.createStatement();
			String sql="DELETE FROM "+tableName+" WHERE SCENARIO='"+scenarioName+"' AND PART_A='"+ControlData.partA+"' AND PART_F='"+ControlData.svDvPartF+"'";
			stmt.executeUpdate(sql);
			System.out.println("Deleted old data in table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(){
		try {
			System.out.println("Writing output in table...");
			Statement statement = conn.createStatement();
			Set<String> keys = DataTimeSeries.dvAliasTS.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()){
				String name=it.next();
				DssDataSetFixLength ts = DataTimeSeries.dvAliasTS.get(name);
				String timestep=ts.getTimeStep().toUpperCase();
				if (timestep.equals("1DAY")){
					String sql="INSERT into "+tableName+" VALUES ";
					Date date = ts.getStartTime();
					double[] data = ts.getData();
					for (int i=0; i<data.length; i++){
						sql=sql +"('"+scenarioName+"', '"+ControlData.partA+"', '"+ControlData.svDvPartF+"', '1DAY', '"+formUnitsName(ts)+"', '"+formDateData(date)+"', '"+formVariableName(name)+"', "+data[i]+"), ";
						date=addOneDay(date);
					}
					if (sql.endsWith(", ")){
						sql=sql.substring(0, sql.lastIndexOf(","));
					}
					stmt.executeUpdate(sql);
				}else{
					String sql="INSERT into "+tableName+" VALUES ";
					Date date = ts.getStartTime();
					double[] data = ts.getData();
					for (int i=0; i<data.length; i++){
						sql=sql +"('"+scenarioName+"', '"+ControlData.partA+"', '"+ControlData.svDvPartF+"', '1MON', '"+formUnitsName(ts)+"', '"+formDateData(date)+"', '"+formVariableName(name)+"', "+data[i]+"), ";
						date=addOneMonth(date);
					}
					if (sql.endsWith(", ")){
						sql=sql.substring(0, sql.lastIndexOf(","));
					}
					stmt.executeUpdate(sql);
				}
			}
			System.out.println("Wrote output in table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String formUnitsName(DssDataSetFixLength ts){
		String units=ts.getUnits().replaceAll("/", "_").replaceAll("-", "_");
		return units;
	}
	
	public String formVariableName(String name){
		String variableName = DssOperation.getTSName(name).replaceAll("-", "_");
		return variableName;
	}
	
	public String formDateData(Date date){
		int year=date.getYear()+1900;
		int month=date.getMonth()+1;
		int day = date.getDate();
		return year+"-"+TimeOperation.monthNameNumeric(month)+"-"+TimeOperation.dayName(day);
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
}

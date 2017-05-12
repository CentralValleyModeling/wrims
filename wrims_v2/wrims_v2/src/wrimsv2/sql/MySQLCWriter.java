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

public class MySQLCWriter {
	
	private String JDBC_DRIVER = "com.mysql.jdbc.Driver";       
	private String database="callite";                                  //input
	private String DB_URL = "jdbc:mysql://localhost:3306/"+database;    //input

	private String USER = "hxie";                                       //input
	private String PASS = "BDOisNo1";                                   //input
	
	private Connection conn = null;
	private Statement stmt = null;
	
	private ArrayList<String> monthlyEntries;
	private ArrayList<String> dailyEntries;
	
	private String monthlyTableName=FilePaths.sqlTableName+"_"+ControlData.partA+"_"+ControlData.svDvPartF+"_M";
	private String dailyTableName=FilePaths.sqlTableName+"_"+ControlData.partA+"_"+ControlData.svDvPartF+"_D";
	
	private int col_limit=750;
	
	public MySQLCWriter(){   
		connectToDataBase();
		deleteTablesIfExist();
		createTable();
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
		   
	public void deleteTablesIfExist(){
		try {
			System.out.println("Deleting old table...");
			stmt = conn.createStatement();
			String sql="DROP TABLE IF EXISTS "+monthlyTableName;
			stmt.executeUpdate(sql);
			sql="DROP TABLE IF EXISTS "+dailyTableName;
			stmt.executeUpdate(sql);
			System.out.println("Deleted old table");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTable(){
		System.out.println("Creating table in given database...");
		try {
			monthlyEntries=new ArrayList<String>();
			dailyEntries=new ArrayList<String>();
			stmt = conn.createStatement();
			String sqlMonthly = "CREATE TABLE " + monthlyTableName + " (Date DATE, ";
			String sqlDaily = "CREATE TABLE " + dailyTableName + " (Date DATE, ";
			Set<String> keys = DataTimeSeries.dvAliasTS.keySet();
			Iterator<String> it = keys.iterator();
			if (it.hasNext()){
				String name=it.next();
				name=it.next();
				DssDataSetFixLength ts = DataTimeSeries.dvAliasTS.get(name);
				String timestep=ts.getTimeStep().toUpperCase();
				if (timestep.equals("1DAY")){
					sqlDaily=sqlDaily+formPathName(ts, name, timestep)+"$"+formUnitsName(ts)+" Double";
					dailyEntries.add(name);
				}else{
					sqlMonthly=sqlMonthly+formPathName(ts, name, timestep)+"$"+formUnitsName(ts)+" Double";
					monthlyEntries.add(name);
				}
				int kd=1;
				int km=1;
				while (it.hasNext()){
					name=it.next();
					ts = DataTimeSeries.dvAliasTS.get(name);
					timestep=ts.getTimeStep().toUpperCase();
					if (timestep.equals("1DAY") && kd<col_limit){
						sqlDaily=sqlDaily+", "+formPathName(ts, name, timestep)+"$"+formUnitsName(ts)+" DOUBLE";
						dailyEntries.add(name);
						kd++;
					}else if (km<col_limit){
						sqlMonthly=sqlMonthly+", "+formPathName(ts, name, timestep)+"$"+formUnitsName(ts)+" DOUBLE";
						monthlyEntries.add(name);
						km++;
					}
				}
				sqlMonthly=sqlMonthly+")";
				sqlDaily=sqlDaily+")";
				if (monthlyEntries.size()>0) stmt.executeUpdate(sqlMonthly);
				if (dailyEntries.size()>0)stmt.executeUpdate(sqlDaily);
				System.out.println("Created tables in given database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(){
		System.out.println("Writing output in table...");
		writeMonthlyData();
		writeDailyData();
		System.out.println("Wrote output in table");
	}
	
	public void writeMonthlyData(){
		if (monthlyEntries.size()>0){
			try {
				String name = monthlyEntries.get(0);
				DssDataSetFixLength ts = DataTimeSeries.dvAliasTS.get(name);
				Date date = ts.getStartTime();
				double[] data = ts.getData();
				for (int i=0; i<data.length; i++){
					Statement statement;
					statement = conn.createStatement();
					String sql="INSERT INTO " + monthlyTableName +" VALUES (";
					sql=sql+"'"+formDateData(date)+"', ";
					sql=sql+data[i];
					for (int j=1; j<monthlyEntries.size(); j++){
						name=monthlyEntries.get(j);
						ts = DataTimeSeries.dvAliasTS.get(name);
						data=ts.getData();
						sql=sql+", "+data[i];
					}
					sql=sql+")";
					statement.executeUpdate(sql);
					date=addOneMonth(date);				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void writeDailyData(){
		if (dailyEntries.size()>0){
			try {
				String name = dailyEntries.get(0);
				DssDataSetFixLength ts = DataTimeSeries.dvAliasTS.get(name);
				Date date = ts.getStartTime();
				double[] data = ts.getData();
				for (int i=0; i<data.length; i++){
					Statement statement;
					statement = conn.createStatement();
					String sql="INSERT INTO " + dailyTableName + " VALUES (";
					sql=sql+"'"+formDateData(date)+"', ";
					sql=sql+data[i];
					for (int j=1; j<monthlyEntries.size(); j++){
						name=dailyEntries.get(j);
						ts = DataTimeSeries.dvAliasTS.get(name);
						data=ts.getData();
						sql=sql+", "+data[i];
					}
					sql=sql+")";
					statement.executeUpdate(sql);
					date=addOneDay(date);				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String formUnitsName(DssDataSetFixLength ts){
		String units=ts.getUnits().replaceAll("/", "_").replaceAll("-", "_");
		return units;
	}
	
	public String formPathName(DssDataSetFixLength ts, String name, String timestep){
		String pathName = DssOperation.getTSName(name).replaceAll("-", "_")+"$"+ts.getKind().replaceAll("-", "_");
		//String pathName = DssOperation.getTSName(name);
		return pathName;
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

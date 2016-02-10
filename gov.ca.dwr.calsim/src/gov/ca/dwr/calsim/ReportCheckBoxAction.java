package gov.ca.dwr.calsim;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.hecdssvue.components.DataOps;
import gov.ca.dwr.hecdssvue.views.DSSMonthlyView;
import gov.ca.dwr.hecdssvue.views.DSSPlotView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.hecmath.TimeSeriesMath;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JCheckBox;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPValue;
import wrimsv2_plugin.debugger.view.WPPGoalView;
import wrimsv2_plugin.tools.DataProcess;

public class ReportCheckBoxAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JCheckBox c=(JCheckBox)e.getSource();
		String cn=c.getName();
		
		if (c.isSelected()){
			if (!CalSimPluginCore.selectedCheckBox.contains(cn)){
				CalSimPluginCore.selectedCheckBox.add(cn);
			}
		}else{
			if (CalSimPluginCore.selectedCheckBox.contains(cn)){
				CalSimPluginCore.selectedCheckBox.remove(cn);
			}
		}
		
		retrieveTsData();
	}

	private void retrieveTsData() {
		Vector<DataContainer> dataVector_paths=new Vector<DataContainer>();
		for (int i=0; i<CalSimPluginCore.selectedCheckBox.size(); i++){
			String cn=CalSimPluginCore.selectedCheckBox.get(i);
			if (cn.startsWith("ckbp")){
				String id=cn.replaceFirst("ckbp", "");
				boolean isBase=true;
				Vector<DataContainer> dataVector_path1=new Vector<DataContainer>();
				Vector<DataContainer> dataVector_path2=new Vector<DataContainer>();
				for (int j=0; j<4; j++){
					if (DebugCorePlugin.selectedStudies[j]){
						//Vector<CondensedReference> ccDv = DebugCorePlugin.dvDss[j].getCondensedCatalog();
						//Vector<CondensedReference> ccSv = DebugCorePlugin.svDss[j].getCondensedCatalog();
						String[][] lookups=new String[0][0];
						if (DebugCorePlugin.studyTypes[j]==0){
							lookups=CalSimPluginCore.CalLiteLookups;
						}else if (DebugCorePlugin.studyTypes[j]==1){
							lookups=CalSimPluginCore.CalSim3Lookups;
						}else if (DebugCorePlugin.studyTypes[j]==2){
							lookups=CalSimPluginCore.CalSim2Lookups;
						}
						for (int k=0; k<lookups.length; k++){
							if (lookups[k][0].equals(id)){								
								String location = "";
								String[] partBCs=lookups[k][1].toUpperCase().split("\\+");
								int size=partBCs.length;
								if (size==1){
									int step=0;
									if (partBCs[0].endsWith(")") && partBCs[0].contains("(")){
										int bi=partBCs[0].indexOf("(");
										int ei=partBCs[0].length()-1;
										String stepStr=partBCs[0].substring(bi+1, ei);
										step=Integer.parseInt(stepStr);
										partBCs[0]=partBCs[0].substring(0, bi);
									}
									String[] parts=partBCs[0].split("/");
									String partB=parts[0];
									String partC=parts[1];
								
									TimeSeriesContainer dataVector_file = retrieveTsDataByPathName(partB, partC, j, isBase, step);
									if (dataVector_file !=null) {
										if (PluginCore.mode.equals(PluginCore.diff) &&  !isBase){
											dataVector_file=DataOps.diff(dataVector_file, (TimeSeriesContainer)dataVector_path1.get(0));
										}
										dataVector_file.location=partB;
										dataVector_path1.add(dataVector_file);
									}
								}else if (size>1){
									TimeSeriesContainer combined_dataVector_file=null;
									for (int n=0; n<size; n++){
										int step=0;
										if (partBCs[n].endsWith(")") && partBCs[n].contains("(")){
											int bi=partBCs[n].indexOf("(");
											int ei=partBCs[n].length()-1;
											String stepStr=partBCs[n].substring(bi+1, ei);
											step=Integer.parseInt(stepStr);
											partBCs[n]=partBCs[n].substring(0, bi);
										}
										String[] parts=partBCs[n].split("/");
										String partB=parts[0];
										String partC=parts[1];
									
										TimeSeriesContainer dataVector_file = retrieveTsDataByPathName(partB, partC, j, isBase, step);
										combined_dataVector_file=combineData(dataVector_file, combined_dataVector_file);
										if (n==0) {
											location=partB;
										}else{
											location=location+"+"+partB;
										}
									}
									if (combined_dataVector_file !=null) {
										if (PluginCore.mode.equals(PluginCore.diff) &&  !isBase){
											combined_dataVector_file=DataOps.diff(combined_dataVector_file, (TimeSeriesContainer)dataVector_path1.get(0));
										}
										combined_dataVector_file.location=location;
										dataVector_path1.add(combined_dataVector_file);
									}
								}
								
								String secondaryName = lookups[k][2].toUpperCase();
								if (!secondaryName.equals("")){
									location = "";
									partBCs=secondaryName.split("\\+");
									size=partBCs.length;
									if (size==1){
										int step=0;
										if (partBCs[0].endsWith(")") && partBCs[0].contains("(")){
											int bi=partBCs[0].indexOf("(");
											int ei=partBCs[0].length()-1;
											String stepStr=partBCs[0].substring(bi+1, ei);
											step=Integer.parseInt(stepStr);
											partBCs[0]=partBCs[0].substring(0, bi);
										}
										String[] parts=partBCs[0].split("/");
										String partB=parts[0];
										String partC=parts[1];
								
										TimeSeriesContainer dataVector_file = retrieveTsDataByPathName(partB, partC, j, isBase, step);
										if (dataVector_file !=null) {
											if (PluginCore.mode.equals(PluginCore.diff) &&  !isBase){
												dataVector_file=DataOps.diff(dataVector_file, (TimeSeriesContainer)dataVector_path1.get(0));
											}
											dataVector_file.location=partB;
											dataVector_path2.add(dataVector_file);
										}
									}else if (size>1){
										TimeSeriesContainer combined_dataVector_file=null;
										for (int n=0; n<size; n++){
											int step=0;
											if (partBCs[n].endsWith(")") && partBCs[n].contains("(")){
												int bi=partBCs[n].indexOf("(");
												int ei=partBCs[n].length()-1;
												String stepStr=partBCs[n].substring(bi+1, ei);
												step=Integer.parseInt(stepStr);
												partBCs[n]=partBCs[n].substring(0, bi);
											}
											String[] parts=partBCs[n].split("/");
											String partB=parts[0];
											String partC=parts[1];
									
											TimeSeriesContainer dataVector_file = retrieveTsDataByPathName(partB, partC, j, isBase, step);
											combined_dataVector_file=combineData(dataVector_file, combined_dataVector_file);
											if (n==0) {
												location=partB;
											}else{
												location=location+"+"+partB;
											}
										}
										if (combined_dataVector_file !=null) {
											if (PluginCore.mode.equals(PluginCore.diff) &&  !isBase){
												combined_dataVector_file=DataOps.diff(combined_dataVector_file, (TimeSeriesContainer)dataVector_path1.get(0));
											}
											combined_dataVector_file.location=location;
											dataVector_path2.add(combined_dataVector_file);
										}
									}
								}
							}
						}
						isBase=false;
					}	
				}
				if (PluginCore.mode.equals(PluginCore.diff)){
					if	(dataVector_path1.size()>0) dataVector_path1.remove(0);
					if	(dataVector_path2.size()>0) dataVector_path2.remove(0);
				}
				if	(dataVector_path1.size()>0) dataVector_paths.addAll(dataVector_path1);
				if	(dataVector_path2.size()>0) dataVector_paths.addAll(dataVector_path2);
			}		
		}
		showData(dataVector_paths);
		
	}

	private TimeSeriesContainer combineData(TimeSeriesContainer dataVector_file, TimeSeriesContainer combined_dataVector_file){
		if (dataVector_file==null){
			return combined_dataVector_file;
		}else{
			try {
				if (combined_dataVector_file==null){
					return dataVector_file;
				}else{
					HecMath hm0=HecMath.createInstance(dataVector_file);
					HecMath hm1=HecMath.createInstance(combined_dataVector_file);
					hm1=hm1.add(hm0);
					return (TimeSeriesContainer)hm1.getData();
				}
			} catch (HecMathException e) {
				WPPException.handleException(e);
				return combined_dataVector_file;
			}
		}
	}
	
	private void showData(final Vector<DataContainer> dataVector_paths){
		try {
			final IWorkbench workbench=PlatformUI.getWorkbench();
			workbench.getDisplay().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
					DSSTableView dssTableView = (DSSTableView) workBenchPage.findView(DSSTableView.ID);
					dssTableView.showSelected(dataVector_paths);
					DSSMonthlyView dssMonthlyView = (DSSMonthlyView) workBenchPage.findView(DSSMonthlyView.ID);
					dssMonthlyView.showSelected(dataVector_paths);
					DSSPlotView dssPlotView = (DSSPlotView) workBenchPage.findView(DSSPlotView.ID);
					dssPlotView.showSelected(dataVector_paths);
					
				}
			});
		} catch (Exception e) {
			WPPException.handleException(e);
		}
	}
	
	private TimeSeriesContainer retrieveTsDataByPathName(String partB, String partC, int j, boolean isBase, int step){
		
		boolean found=false;
		Iterator<CondensedReference> it = PluginCore.condensedCatalog.iterator();
		while (it.hasNext() && !found) {
			CondensedReference next = it.next();
			String pathName = next.getNominalPathname();
			String[] parts = pathName.split("/");
			if (parts[2].equals(partB) && parts[3].equals(partC)){
				found = true;
				String pathname=getPathname(parts);
				TimeSeriesContainer dataVector_file = getData(pathname, j, isBase);
				if (step != 0){
					TimeSeriesMath tm;
					try {
						tm = new TimeSeriesMath(dataVector_file);
						int interval=dataVector_file.interval;
						HecMath newTm;
						if (interval==1440){
							newTm = tm.shiftInTime(step+"DAY");
						}else{
							newTm = tm.shiftInTime(step+"MON");
						}
						dataVector_file=(TimeSeriesContainer) newTm.getData();
					} catch (HecMathException e) {
						WPPException.handleException(e);
					}
				}
				return dataVector_file;
			}
		}
		
		return null;
	}
	
	public String getPathname(String[] parts) {
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		for (int i = 1; i < parts.length; i++) {
			if (i == 4) {
				sb.append(parts[i].split("-")[0].trim()).append("/");
			} else {
				sb.append(parts[i]).append("/");
			}
		}
		return sb.toString();
	}
	
	public TimeSeriesContainer getData(String pathname, int j, boolean isBase) {
//		DataContainer dataVector_file = new DataContainer();
		TimeSeriesContainer dataVector_file = new TimeSeriesContainer();
		
		boolean found=false;
		int dv_flag=0;
		
		while(dv_flag<2 && !found){
        
			switch(dv_flag){
				case 0:
					try{
						//dataVector_file = dssArray.get(i).get(pathname, true);
						if (PluginCore.tw.equals("All")){	
							dataVector_file = DataOps.getMonthlyData((TimeSeriesContainer)DebugCorePlugin.dvDss[j].get(pathname, true), PluginCore.months);
						}else{
							String startTime=PluginCore.tw.substring(0, 13);
							String endTime=PluginCore.tw.substring(15, 28);
							dataVector_file = DataOps.getMonthlyData((TimeSeriesContainer)DebugCorePlugin.dvDss[j].get(pathname, startTime, endTime), PluginCore.months);
						}
					} catch (Exception ex) {
						dataVector_file = null;
					}
					if (dataVector_file !=null) {
						found=true;
					}
//					dataVector_file.units//TODO
					break;
				case 1:
//					if (dataVector_file.numberValues == 0){
//					if (dataVector_path.get((i-1)/2).numberValues == 0){
//					if (dataVector_file.fullName==""){//TODO:prev null
					if ((dataVector_file==null)||(dataVector_file.fullName=="")){//TODO
//					if (dataVector_file==null){//TODO
//					if (dataVector_path.get((i-1)/2).equals(null)){
						try{
//							dataVector_file = dssArray.get(i).get(pathname, true);
							if (PluginCore.tw.equals("All")){  
								dataVector_file = DataOps.getMonthlyData((TimeSeriesContainer)DebugCorePlugin.svDss[j].get(pathname, true), PluginCore.months);
							}else{ 
								String startTime=PluginCore.tw.substring(0, 13);
								String endTime=PluginCore.tw.substring(15, 28);
								dataVector_file = DataOps.getMonthlyData((TimeSeriesContainer)DebugCorePlugin.svDss[j].get(pathname, startTime, endTime), PluginCore.months);
							}
						} catch (Exception ex) {
							dataVector_file = null;
						}
					}
					break;
				}
			dv_flag=dv_flag+1;
		}
		
		return dataVector_file;
     }
}

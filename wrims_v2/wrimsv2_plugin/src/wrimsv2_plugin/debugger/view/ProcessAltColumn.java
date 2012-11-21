package wrimsv2_plugin.debugger.view;

import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.io.DataContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.TimeOperation;
import wrimsv2_plugin.tools.VariableProperty;

public class ProcessAltColumn {
	
	public static void AdjustAltColumnNames(TableViewer viewer, int flag){
		Table table=viewer.getTable();
		removeAltColumns(table);
		addAltColumnNames(table, flag);
		table.setRedraw(true);
	}
	
	public static void removeAltColumns(Table table){
		int colSize=table.getColumnCount();
		for (int i=colSize-1; i>=0; i--){
			TableColumn tc = table.getColumn(i);
			String cn=tc.getText();
			if (cn.equals("Alt1") || cn.equals("Alt2") || cn.equals("Alt3") || cn.equals("Alt4")){
				tc.dispose();
			}
		}
	}
	
	public static void addAltColumnNames(Table table, int flag){	
		Map<Integer, Integer> altColumnIndex = new HashMap<Integer, Integer>();
		switch (flag){
			case 0:
				altColumnIndex=DebugCorePlugin.variableAltColIndex;
				break;
			case 1:
				altColumnIndex=DebugCorePlugin.watchAltColIndex;
				break;
		}
		
		for (int i=0; i<4; i++){
			if (DebugCorePlugin.selectedStudies[i]){
				altColumnIndex.put(table.getColumnCount(), i);
				TableColumn tc=new TableColumn(table, SWT.NORMAL);
				tc.setText("Alt"+(i+1));
				tc.pack();
			}
		}
	}
	
	public static String addAltColumnData(String vn, int flag, int index){
		Map<String, VariableProperty> vp=new HashMap<String, VariableProperty>();
		Map<Integer, Integer> altColIndex=new HashMap<Integer, Integer>();
		switch (flag){
			case 0:
				vp=DebugCorePlugin.variableProperty;
				altColIndex=DebugCorePlugin.variableAltColIndex;
				break;
			case 1:
				vp=DebugCorePlugin.watchProperty;
				altColIndex=DebugCorePlugin.watchAltColIndex;
				break;
		}
		String aPart = DebugCorePlugin.aPart;
		String svFPart = DebugCorePlugin.svFPart;
		HecDss[] dvDss = DebugCorePlugin.dvDss;
		HecDss[] svDss = DebugCorePlugin.svDss;
		
		if (vp.containsKey(vn)){
			VariableProperty property=vp.get(vn);
			String timestep=property.getPartE();
			String pn="/"+aPart.toUpperCase()+"/"+vn.toUpperCase()+"/"+property.getPartC().toUpperCase()+"/*/"+timestep+"/"+svFPart.toUpperCase()+"/";
			String tw=TimeOperation.createTimewindow(DebugCorePlugin.suspendedYear, DebugCorePlugin.suspendedMonth, DebugCorePlugin.suspendedDay, timestep);
			int i=altColIndex.get(index);
			try {
				HecDss dss = dvDss[i];
				if (dss.recordExists(pn)){
					HecMath hm = dss.read(pn, tw);
					DataContainer dc = hm.getData();
					double value = dc.yOrdinate;
					return String.valueOf(value);
				}else{
					dss=svDss[i];
					if (dss.recordExists(pn)){	
						HecMath hm = dss.read(pn, tw);
						DataContainer dc = hm.getData();
						double value = dc.yOrdinate;
						return String.valueOf(value);
					}else{
						return "";
					}
				}
			} catch (HecMathException e) {
				WPPException.handleException(e);
				return "";
			}
		}else{
			return "";
		}
	}
}

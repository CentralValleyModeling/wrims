package wrimsv2_plugin.debugger.view;

import java.util.ArrayList;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;

public class ProcessAltColumn {
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
	
	public static void AdjustAltColumnNames(TableViewer viewer){
		Table table=viewer.getTable();
		removeAltColumns(table);
		for (int i=0; i<4; i++){
			if (DebugCorePlugin.selectedStudies[i]){
				TableColumn tc=new TableColumn(table, SWT.NORMAL);
				tc.setText("Alt"+(i+1));
				tc.pack();
			}
		}
		table.setRedraw(true);
	}
	
	public static void AddAltColumns(Table table){
		
	}
}

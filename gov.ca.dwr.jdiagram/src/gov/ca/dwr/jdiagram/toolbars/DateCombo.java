package gov.ca.dwr.jdiagram.toolbars;

import gov.ca.dwr.jdiagram.SchematicPluginCore;
import gov.ca.dwr.jdiagram.views.SchematicBase;
import gov.ca.dwr.jdiagram.views.SchematicView;

import java.awt.geom.Rectangle2D;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import com.mindfusion.diagramming.DiagramView;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.tools.TimeOperation;

public class DateCombo extends
    WorkbenchWindowControlContribution {
	
	SchematicBase schematicView;
	private Combo dateList;
	
	public DateCombo(SchematicBase schematicBase) {
		this.schematicView=schematicBase;
	}

	@Override
	protected Control createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout glContainer = new GridLayout(1, false);
		glContainer.marginTop = 0;
		glContainer.marginHeight = 0;
		glContainer.marginWidth = 0;
		glContainer.marginBottom = 0;
		container.setLayout(glContainer);
		GridData glReader = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		glReader.widthHint = 140;
		glReader.heightHint = 15; 
		dateList = new Combo(container, SWT.BORDER | SWT.READ_ONLY
            | SWT.DROP_DOWN);
		dateList.setLayoutData(glReader);
		setDateCombo(10, 1921, 9, 2009);
		dateList.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				SchematicPluginCore.selIndex=dateList.getSelectionIndex();
				SchematicPluginCore.selDate=dateList.getText();
				if (!DebugCorePlugin.isDebugging){
					schematicView.refreshValues(0, true);					
				}else{
					if (DebugCorePlugin.target !=null){
						schematicView.refreshValues(1, true);
					}
				}
			}
			
		});
		return container;
	}
	
	public void setDateCombo(int startMonth, int startYear, int endMonth, int endYear){
		dateList.removeAll();
		for (int i=0; i<SchematicPluginCore._twSelections.length; i++){
			dateList.add(SchematicPluginCore._twSelections[i]);
		}
		int j=startMonth;
		for (int i=startYear; i<=endYear; i++){
			while (j<=12){
				dateList.add(TimeOperation.getMonthText(j)+" "+i);
				if (j>=endMonth && i>=endYear){
					i=endYear+1;
					j=13;
				}
				j=j+1;
			}
			j=1;
		}
	}
	
	public Combo getDateList(){
		return dateList;
	}
}

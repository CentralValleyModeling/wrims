package wrimsv2_plugin.debugger.dialog;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.menuitem.EnableMenus;
import wrimsv2_plugin.debugger.toolbaritem.HandlePauseResumeButton;
import wrimsv2_plugin.debugger.view.WPPVarDetailView;

public class WPPReSimDialog extends PopupDialog {
	Combo year;
	Combo month;
	Combo day;
	Combo cycle;
	
	
	public WPPReSimDialog(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		super(parent, shellStyle, takeFocusOnOpen, persistSize, persistLocation,
				showDialogMenu, showPersistActions, titleText, infoText);
		// TODO Auto-generated constructor stub
	}

	public void open(int i){
		create();
		getShell().setSize(450, 280);
		open();
	}

	@Override
	 protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		RowLayout layout=new RowLayout(SWT.VERTICAL);
		dialogArea.setLayout(layout);
		
		Composite line1=new Composite(dialogArea, SWT.NONE);
		layout=new RowLayout(SWT.HORIZONTAL);
		layout.justify=true;
		layout.pack=true;
		line1.setLayout(layout);
		Label label1=new Label(line1, SWT.NONE);
		label1.setText("Re-simulate from:");
		
		Composite line2=new Composite(dialogArea, SWT.NONE);
		line2.setLayout(layout);
		final Button but1=new Button(line2, SWT.RADIO);
		but1.setText("1st cycle of year");
		year=new Combo(line2, SWT.BORDER);
		int suspendedYear=DebugCorePlugin.suspendedYear;
		fillCombo(year, DebugCorePlugin.startYear, suspendedYear);
		year.setText(String.valueOf(suspendedYear));
		Label label3=new Label(line2, SWT.NONE);
		label3.setText("month");
		month=new Combo(line2, SWT.BORDER);
		int suspendedMonth=DebugCorePlugin.suspendedMonth;
		fillCombo(month, 1, 12);
		month.setText(String.valueOf(suspendedMonth));
		Label label4=new Label(line2, SWT.NONE);
		label4.setText("day");
		day=new Combo(line2,SWT.BORDER);
		int suspendedDay=DebugCorePlugin.suspendedDay;
		fillCombo(day, 1, 31);
		day.setText(String.valueOf(suspendedDay));
		
		Composite line3=new Composite(dialogArea, SWT.NONE);
		line3.setLayout(layout);
		final Button but2=new Button(line3, SWT.RADIO);
		but2.setText("Cycle");
		cycle=new Combo(line3, SWT.BORDER);
		int suspendedCycle=DebugCorePlugin.suspendedCycle;
		fillCombo(cycle, 1, suspendedCycle);
		cycle.setText(String.valueOf(suspendedCycle));
		Label label2=new Label(line3, SWT.NONE);
		label2.setText("of current step");
		
		final Button but3=new Button(dialogArea, SWT.CHECK);
		but3.setText("Re-compile wresl code");
		
		final Button but4=new Button(dialogArea, SWT.CHECK);
		but4.setText("Re-read data from SV file");
		
		final Button but5=new Button(dialogArea, SWT.CHECK);
		but5.setText("Re-load lookup table");
		
		Composite line7=new Composite(dialogArea, SWT.NONE);
		line7.setLayout(layout);
		Button ok = new Button(line7, SWT.PUSH);
		ok.setText("OK");
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				if (but1.getSelection()){
					try {
						String compile;
						if (but3.getSelection()){
							compile="recompile";
						}else{
							compile="notrecompile";
						}
						String loadSV;
						if (but4.getSelection()){
							loadSV="loadsv";
						}else{
							loadSV="notloadsv";
						}
						String loadTable;
						if (but5.getSelection()){
							loadTable="loadtable";
						}else{
							loadTable="notloadtable";
						}
						DebugCorePlugin.target.resimDate(compile+":"+loadSV+":"+year.getText()+":"+month.getText()+":"+day.getText()+":"+loadTable);
						enableRunMenu();
					} catch (DebugException e) {
						WPPException.handleException(e);
					}
				}else if (but2.getSelection()){
					try {
						String loadSV;
						if (but4.getSelection()){
							loadSV="loadsv";
						}else{
							loadSV="notloadsv";
						}
						String loadTable;
						if (but5.getSelection()){
							loadTable="loadtable";
						}else{
							loadTable="notloadtable";
						}
						DebugCorePlugin.target.resimCycle(loadSV+":"+cycle.getText()+":"+loadTable);
						enableRunMenu();
					} catch (DebugException e) {
						WPPException.handleException(e);
					}
				}
				close();
			}
		});
		
		Button cancel = new Button(line7, SWT.PUSH);
		cancel.setText("Cancel");
		cancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				close();
			}
		});
		
		but1.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent e) {
				but2.setSelection(false);
				but3.setEnabled(true);
			}
			
		});
		
		but2.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseUp(MouseEvent e) {
				but1.setSelection(false);
				but3.setSelection(false);
				but3.setEnabled(false);
			}
			
		});
		
		dialogArea.getShell().setDefaultButton(ok);
		return dialogArea;
	 }
	
	public void fillCombo(Combo combo, int start, int end){
		combo.removeAll();
		for (int i=start; i<=end; i++){
			combo.add(String.valueOf(i));
		}
	}
	
	
	public void enableRunMenu(){
		HashMap<String, Boolean> enableMap=new HashMap<String, Boolean>();
		enableMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, true);
		enableMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, true);
		enableMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, true);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMap);
		HandlePauseResumeButton.procPauseResumeToolbarItem(1);
	}
}

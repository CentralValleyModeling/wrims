package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.internal.provisional.action.ToolBarContributionItem2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import wrimsv2_plugin.debugger.exception.WPPException;

public class DebugSet extends WorkbenchWindowControlContribution{
	private Combo comboYear;
	private Combo comboMonth;
	private Combo comboDay;
	private Combo comboCycle;
	
	@Override
    protected Control createControl(Composite parent) {
       
		CoolBar coolbar=new CoolBar(parent, SWT.HORIZONTAL|SWT.FLAT);

		createComboYear(coolbar);
		CoolItem itemYear = new CoolItem(coolbar, SWT.None); 
		itemYear.setControl(comboYear);
		Point pt=comboYear.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemYear.setSize(itemYear.computeSize(pt.x, pt.y));
		itemYear.setSize(100,10);
				
		createComboMonth(coolbar);
		CoolItem itemMonth = new CoolItem(coolbar, SWT.NONE);	
		itemMonth.setControl(comboMonth);
		pt=comboMonth.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemMonth.setSize(itemMonth.computeSize(pt.x, pt.y));
		itemMonth.setSize(100,10);
		
		createComboDay(coolbar);
		CoolItem itemDay = new CoolItem(coolbar, SWT.NONE);	
		itemDay.setControl(comboDay);
		pt=comboDay.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemDay.setSize(itemDay.computeSize(pt.x, pt.y));
		itemDay.setSize(100,10);
		
		createComboCycle(coolbar);
		CoolItem itemCycle = new CoolItem(coolbar, SWT.NONE);	
		itemCycle.setControl(comboCycle);
		pt=comboCycle.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		//itemCycle.setSize(itemCycle.computeSize(pt.x, pt.y));
		itemCycle.setSize(100,10);
		
		//coolbar.setSize(200, 10);
        return coolbar;
	}

	public void createComboCycle(Composite parent){
		comboCycle = new Combo(parent, SWT.DROP_DOWN);
		for (int i=1; i<=99; i++){
			comboCycle.add(String.valueOf(i));
		}
     
		//comboCycle.setSize(40, 10);
		comboCycle.select(0);
		comboCycle.setToolTipText("Go To Cycle:");
	}
	
	public void createComboYear(Composite parent){
        comboYear = new Combo(parent, SWT.DROP_DOWN);
        for (int i=1921; i<=2006; i++){
        	comboYear.add(String.valueOf(i));
        }
        
        //comboYear.setSize(70, 10);
        comboYear.select(0);
        comboYear.setToolTipText("Go To Year:");
	}
	
	public void createComboMonth(Composite parent){
        comboMonth = new Combo(parent, SWT.DROP_DOWN);
        for (int i=1; i<=12; i++){
        	comboMonth.add(String.valueOf(i));
        }
        
        //comboMonth.setSize(40, 10);
        comboMonth.select(0);
        comboMonth.setToolTipText("Go To Month:");
        
		comboMonth.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						try {
							 comboDay.setText("11");
						} catch (Exception e) {
							WPPException.handleException(e);
						}
					}
				});
			}
          });

	}
	
	public void createComboDay(Composite parent){
        comboDay = new Combo(parent, SWT.DROP_DOWN);
        
        for (int i=1; i<=31; i++){
        	comboDay.add(String.valueOf(i));
        }
        comboDay.select(30);
        //comboDay.setSize(40, 10);
        comboDay.setToolTipText("Go To Day:");
	}

}

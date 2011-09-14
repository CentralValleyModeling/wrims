package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPVariableView;

public class DebugMonthMenu extends WorkbenchWindowControlContribution{

	@Override
    protected Control createControl(Composite parent) {
        Combo combo = new Combo(parent, SWT.DROP_DOWN);
        for (int i=1; i<=12; i++){
        	combo.add(String.valueOf(i));
        }
        
        combo.setSize(10, 10);
        combo.select(0);
        combo.setToolTipText("Go To Month:");
        
		combo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						try {
							
						} catch (Exception e) {
							WPPException.handleException(e);
						}
					}
				});
			}
          });


        return combo;

	}

}

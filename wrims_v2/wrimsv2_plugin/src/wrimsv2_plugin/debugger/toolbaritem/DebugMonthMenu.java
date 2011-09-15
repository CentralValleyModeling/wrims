package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.internal.provisional.action.IToolBarContributionItem;
import org.eclipse.jface.internal.provisional.action.ToolBarContributionItem2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.internal.menus.DynamicToolBarContributionItem;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.WPPVariableView;

public class DebugMonthMenu extends WorkbenchWindowControlContribution{

	@Override
    protected Control createControl(final Composite parent) {
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
							 IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
							 //MenuManager menuManager = ((WorkbenchWindow)window).getMenuManager();

							 ICoolBarManager coolBarManager = null;
							 coolBarManager = ((WorkbenchWindow)window).getCoolBarManager2();

							 //Menu menu = menuManager.getMenu();

							 String toolbarId = "wpp.toolbar";
							 IContributionItem toolbar = coolBarManager.find(toolbarId);
							 IToolBarManager toolbarManager=((ToolBarContributionItem2)toolbar).getToolBarManager();
							 IContributionItem dayMenu=toolbarManager.find("wpp.debugdaymenu");
							 //((DynamicToolBarContributionItem)dayMenu).createControl(parent);
							 //((DebugDayMenu)dayMenu).resetValue();

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

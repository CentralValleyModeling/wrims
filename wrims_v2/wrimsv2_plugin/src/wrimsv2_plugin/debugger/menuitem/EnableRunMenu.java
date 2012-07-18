package wrimsv2_plugin.debugger.menuitem;

import java.util.HashMap;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.SubContributionItem;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.ActionSetContributionItem;
import org.eclipse.ui.internal.ActionSetMenuManager;
import org.eclipse.ui.internal.PluginActionContributionItem;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.internal.WorkbenchWindow;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;

public class EnableRunMenu {
	public EnableRunMenu(final HashMap<String, Boolean> enableMap){
		Display.getDefault().syncExec(new Runnable() {
			public void run() { 
				IWorkbenchWindow window = Workbench.getInstance().getActiveWorkbenchWindow();
				MenuManager menuManager = ((WorkbenchWindow)window).getMenuManager();
				Menu menu = menuManager.getMenu();
				for(MenuItem item : menu.getItems()){ 
					if (item.getText().equals("&Run")){
						SubContributionItem subContribution = (SubContributionItem)item.getData();
						IContributionItem subItems = subContribution.getInnerItem();
						ActionSetMenuManager aSubItems = (ActionSetMenuManager)subItems;
						for (IContributionItem subItem:aSubItems.getItems()){
							if (enableMap.containsKey(subItem.getId())){
								ActionSetContributionItem aSubItem = (ActionSetContributionItem)subItem;
								IContributionItem inSubItem = aSubItem.getInnerItem();	
								PluginActionContributionItem pACI=(PluginActionContributionItem)inSubItem;
								pACI.getAction().setEnabled(enableMap.get(aSubItem.getId()));
							}
						}
					}
				}
			}
		});
	}
}

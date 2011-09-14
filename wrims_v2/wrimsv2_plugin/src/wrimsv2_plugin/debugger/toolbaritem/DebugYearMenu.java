package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class DebugYearMenu extends WorkbenchWindowControlContribution{

	@Override
    protected Control createControl(Composite parent) {
        Combo combo = new Combo(parent, SWT.DROP_DOWN);
        for (int i=1921; i<=2006; i++){
        	combo.add(String.valueOf(i));
        }
        
        combo.setSize(10, 10);
        combo.select(0);
        combo.setToolTipText("Go To Year:");

        return combo;

	}

}

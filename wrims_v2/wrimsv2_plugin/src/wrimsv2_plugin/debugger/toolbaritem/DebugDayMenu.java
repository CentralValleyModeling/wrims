package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class DebugDayMenu extends WorkbenchWindowControlContribution{

	@Override
    protected Control createControl(Composite parent) {
        Combo combo = new Combo(parent, SWT.DROP_DOWN);
        
        for (int i=1; i<=31; i++){
        	combo.add(String.valueOf(i));
        }
        combo.select(30);
        combo.setSize(10, 10);
        combo.setToolTipText("Go To Day:");

        return combo;

	}

}

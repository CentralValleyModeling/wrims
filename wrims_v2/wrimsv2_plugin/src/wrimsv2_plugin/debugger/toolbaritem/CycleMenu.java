package wrimsv2_plugin.debugger.toolbaritem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

public class CycleMenu extends WorkbenchWindowControlContribution{

	@Override
    protected Control createControl(Composite parent) {
        Combo combo = new Combo(parent, SWT.DROP_DOWN);
        
        parent.setSize(combo.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        return combo;

	}

}

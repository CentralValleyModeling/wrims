package gov.ca.dwr.jdiagram.toolbars;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;

import wrimsv2_plugin.tools.TimeOperation;

public class DateCombo extends
    WorkbenchWindowControlContribution {
	
	private Combo mReader;
	public static String[] _twSelections = { "All", "OCT1921 - SEP2009","OCT1921 - SEP2003",
		"OCT1928 - SEP1934","OCT1986 - SEP1992","OCT1975 - SEP1977",
		"OCT1976 - SEP1977","OCT1994 - SEP2003","OCT2000 - SEP2009"};
	
	public DateCombo() {

	}

	@Override
	protected Control createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout glContainer = new GridLayout(1, false);
		glContainer.marginTop = 1;
		glContainer.marginHeight = 0;
		glContainer.marginWidth = 0;
		container.setLayout(glContainer);
		GridData glReader = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		glReader.widthHint = 140;
		mReader = new Combo(container, SWT.BORDER | SWT.READ_ONLY
            | SWT.DROP_DOWN);
		mReader.setLayoutData(glReader);
		setTime(10, 1921, 9, 2009);
		return container;
	}
	
	public void setTime(int startMonth, int startYear, int endMonth, int endYear){
		mReader.removeAll();
		for (int i=0; i<9; i++){
			mReader.add(_twSelections[i]);
		}
		int j=startMonth;
		for (int i=startYear; i<=endYear; i++){
			while (j<=12){
				mReader.add(TimeOperation.getMonthText(j)+" "+i);
				if (j>=endMonth && i>=endYear){
					i=endYear+1;
					j=13;
				}
				j=j+1;
			}
			j=1;
		}
	}
}

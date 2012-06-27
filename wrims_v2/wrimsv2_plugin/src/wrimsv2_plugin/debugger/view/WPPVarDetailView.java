package wrimsv2_plugin.debugger.view;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class WPPVarDetailView extends ViewPart implements ISelectionListener{

	private Group choice;
	private Group detail;
	
	private Button tsButton;
	private Button futButton;
	private Button cycleButton;
	
	private Text name;
	private Table table;
	
	
	@Override
	public void createPartControl(Composite parent) {
		
		RowLayout rLayout = new RowLayout(SWT.HORIZONTAL);
		parent.setLayout(rLayout);
		choice = new Group(parent, SWT.NONE);
        detail = new Group(parent, SWT.NONE);
        
        GridLayout gLayout = new GridLayout();
        gLayout.numColumns=1;
        choice.setLayout(gLayout);
        tsButton = new Button(choice, SWT.RADIO);
        tsButton.setText("Timeseries");
        futButton = new Button(choice, SWT.RADIO);
        futButton.setText("Future");
        cycleButton = new Button(choice, SWT.RADIO);
        cycleButton.setText("Cycle");
      
        FillLayout fLayout = new FillLayout(SWT.VERTICAL);
        detail.setLayout(fLayout);
        detail.setText("Detail");
        name=new Text(detail, 0);
        name.setText("X");
        table=new Table (detail, SWT.SINGLE);
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
	}

	public void updateDetail(){
		
	}
}

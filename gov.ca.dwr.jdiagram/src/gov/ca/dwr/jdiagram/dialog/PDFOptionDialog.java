package gov.ca.dwr.jdiagram.dialog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import gov.ca.dwr.jdiagram.SchematicPluginCore;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Text;

import com.mindfusion.pdf.PageSizesEnum;

public class PDFOptionDialog extends Dialog {
	
	private Combo pageSize;
	private String[] pageSizeNames={"Schematic Size",
			"A0",                 
			"A1", 		    
			"A10", 		    
			"A2", 		    
			"A3", 		    
			"A4", 		    
			"A5", 		    
			"A6", 		    
			"A7", 		    
			"A8", 		    
			"A9", 		    
			"ArchA", 		    
			"ArchB", 		    
			"ArchC", 		    
			"ArchD", 		    
			"ArchE", 		    
			"B0", 		    
			"B1", 		    
			"B2", 		    
			"B3", 		    
			"B4", 		    
			"B5", 		    
			"Flsa", 		    
			"HalfLetter", 	    
			"Ledger", 		    
			"Legal", 		    
			"Letter", 		    
			"Letter11x17", 	    
			"Note"};
	private Map<String, PageSizesEnum> pageSizeMap = new HashMap<String, PageSizesEnum>(){{
		put("Schematic Size", PageSizesEnum.DiagramSize);
		put("A0", PageSizesEnum.A0);               
		put("A1", PageSizesEnum.A1);
		put("A10", PageSizesEnum.A10);
		put("A2", PageSizesEnum.A2);
		put("A3", PageSizesEnum.A3);
		put("A4", PageSizesEnum.A4);
		put("A5", PageSizesEnum.A5);
		put("A6", PageSizesEnum.A6);
		put("A7", PageSizesEnum.A7);
		put("A8", PageSizesEnum.A8);
		put("A9", PageSizesEnum.A9);
		put("ArchA", PageSizesEnum.ArchA);
		put("ArchB", PageSizesEnum.ArchB);
		put("ArchC", PageSizesEnum.ArchC);
		put("ArchD", PageSizesEnum.ArchD);
		put("ArchE", PageSizesEnum.ArchE);
		put("B0", PageSizesEnum.B0);
		put("B1", PageSizesEnum.B1);
		put("B2", PageSizesEnum.B2);
		put("B3", PageSizesEnum.B3);
		put("B4", PageSizesEnum.B4);
		put("B5", PageSizesEnum.B5);
		put("Flsa", PageSizesEnum.Flsa);
		put("HalfLetter", PageSizesEnum.HalfLetter);
		put("Ledger", PageSizesEnum.Ledger);
		put("Legal", PageSizesEnum.Legal);
		put("Letter", PageSizesEnum.Letter);
		put("Letter11x17", PageSizesEnum.Letter11x17);
		put("Note", PageSizesEnum.Note);
	}};
	
	public PDFOptionDialog(Shell parent) {
		super(parent);
	}

	public void openDialog(){
		create();
		open();
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite dialogArea = (Composite) super.createDialogArea(parent);
		dialogArea.setLayout(new GridLayout(2, false));
		Label label = new Label(dialogArea, SWT.NULL);
		label.setText("Page Size:");
		
		pageSize=new Combo(dialogArea, SWT.BORDER);
		for (int i=0; i<pageSizeNames.length; i++){
			pageSize.add(pageSizeNames[i]);
		}
		pageSize.select(0);
		pageSize.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER));
		dialogArea.pack();
		return dialogArea;
	}
	
	@Override
	protected void okPressed() {
		SchematicPluginCore.pageSize=pageSizeMap.get(pageSize.getText());
		super.okPressed();
	}

}

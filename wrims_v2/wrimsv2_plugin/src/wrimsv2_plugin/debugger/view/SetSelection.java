package wrimsv2_plugin.debugger.view;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Table;

import wrimsv2_plugin.debugger.model.WPPValue;

public class SetSelection {
	public SetSelection(IStructuredSelection oldSelection, TableViewer viewer, Table table){
		boolean hasOldSelection=false;
    	int i=0;
    	if (oldSelection.isEmpty()){
    		table.setTopIndex(0);
    	}else{
    		String oldVarString = ((WPPValue)(oldSelection.getFirstElement())).getVariableString();
    		Object element;
    		while (!hasOldSelection && (element=viewer.getElementAt(i))!=null ){
    			if (oldVarString.equals(((WPPValue)element).getVariableString())) hasOldSelection=true;
    			i=i+1;
    		}
    		if (hasOldSelection){
    			table.setTopIndex(i-1);
    		}else{
    			table.setTopIndex(0);
    		}
    	}
	}
}

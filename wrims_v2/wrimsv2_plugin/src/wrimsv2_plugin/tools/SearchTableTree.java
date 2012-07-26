package wrimsv2_plugin.tools;

import java.util.Stack;

import org.eclipse.debug.core.DebugException;
import org.eclipse.swt.custom.TableTreeItem;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.model.WPPValue;

public class SearchTableTree {
	public static int search(TableTreeItem[] tableTreeItems, int bi, int ei, String text, boolean exact, boolean includeValue){
		int foundIndex=-1;
		Stack indexStack=new Stack();
		int i=bi;
		while (i<ei && foundIndex==-1){
			TableTreeItem item = tableTreeItems[i];
			String itemString=item.getText();
			try {
				String valueString=((WPPValue)(item.getData())).getValueString();
				if (exact){
					if (includeValue){
						if (itemString.equals(text) || valueString.equals(text)){
							foundIndex=i;
						}
					}else{
						if (itemString.equals(text)){
							foundIndex=i;
						}
					}
				}else{
					if (includeValue){
						if (itemString.contains(text) || valueString.contains(text)){
							foundIndex=i;
						}
					}else{
						if (itemString.contains(text)){
							foundIndex=i;
						}
					}
				}
			} catch (DebugException e) {
				WPPException.handleException(e);
			}
			i=i+1;
		}
		return foundIndex;
	}
}

package wrimsv2_plugin.tools;

import java.util.Stack;

import org.eclipse.swt.custom.TableTreeItem;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;

public class SearchTableTree {
	public static int search(TableTreeItem[] tableTreeItems, int bi, int ei, String text, boolean exact){
		int foundIndex=-1;
		Stack indexStack=new Stack();
		for (int i=bi; i<ei; i++){
			String item=tableTreeItems[i].getText();
			if (exact){
				if (item.equals(text)){
					foundIndex=i;
				}
			}else{
				if (item.contains(text)){
					foundIndex=i;
				}
			}
		}
		return foundIndex;
	}
}

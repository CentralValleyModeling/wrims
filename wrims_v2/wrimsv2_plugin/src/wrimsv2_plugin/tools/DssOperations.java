package wrimsv2_plugin.tools;

import java.util.Vector;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

public class DssOperations {
	public static String matchPathName(Vector v, String partB, String partC, String partE){
		String pn=null;
		int i=0;
		int size=v.size();
		String partBString="/"+partB.toUpperCase()+"/";
		String partCString="/"+partC.toUpperCase()+"/";
		String partEString="/"+partE+"/";
		while (pn == null && i<size){
			String pnv=v.get(i).toString();
			if (pnv.contains(partBString) && pnv.contains(partCString) && pnv.contains(partEString) ){
				pn=pnv;
			}
			i++;
		}
		return pn;
	}
	
	public static String matchPathName(Vector v, String partABC, String partEF){
		String pn=null;
		int i=0;
		int size=v.size();
		partABC=partABC.toUpperCase();
		partEF=partEF.toUpperCase();
		while (pn == null && i<size){
			String pnv=v.get(i).toString();
			if (pnv.startsWith(partABC) && pnv.endsWith(partEF) ){
				pn=pnv;
			}
			i++;
		}
		return pn;
	}
	
	public static synchronized boolean isDssInOperation(){
		if (DebugCorePlugin.isDssInOp){
			return true;
		}else{
			setIsDssInOp(true);
			return false;
		}
	}
	
	public static synchronized void setIsDssInOp(boolean isDssInOp){
		DebugCorePlugin.isDssInOp=isDssInOp;
	}
	
	public static void waitForDSSOp(){
		try {
			while(isDssInOperation()){
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			WPPException.handleException(e);
		}
	}
}

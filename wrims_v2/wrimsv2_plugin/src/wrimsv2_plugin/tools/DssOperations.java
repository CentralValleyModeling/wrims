package wrimsv2_plugin.tools;

import java.util.Vector;

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
		while (pn == null && i<size){
			String pnv=v.get(i).toString();
			if (pnv.startsWith(partABC.toUpperCase()) && pnv.endsWith(partEF.toUpperCase()) ){
				pn=pnv;
			}
			i++;
		}
		return pn;
	}
}

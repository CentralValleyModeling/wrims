package wrimsv2.external;

import java.util.*;

public class ExternalFunctionTable{

	public static Hashtable<String,ExternalFunction> externalFunctionsHashtable = new Hashtable<String,ExternalFunction> ();
	public static Hashtable<String,String> externalFunctionReturnType = new Hashtable<String,String> ();
	
	public ExternalFunctionTable(){
		FunctionAnnEC functionAnnEC=new FunctionAnnEC();
		FunctionAnn_X2 functionAnn_X2 = new FunctionAnn_X2();
		FunctionGet_Req_DO functionGet_Req_DO = new FunctionGet_Req_DO();
		FunctionGetFinalMrdo functionGetFinalMrdo = new FunctionGetFinalMrdo();
		FunctionAnnLineGen functionAnnLineGen = new FunctionAnnLineGen();
		externalFunctionsHashtable.put("annec", functionAnnEC);
		externalFunctionReturnType.put("annec", "double");
		externalFunctionsHashtable.put("ann_x2", functionAnn_X2);
		externalFunctionReturnType.put("ann_x2", "double");
		externalFunctionsHashtable.put("annlinegen", functionAnnLineGen);
		externalFunctionReturnType.put("annlinegen", "double");
		externalFunctionsHashtable.put("get_req_do", functionGet_Req_DO);
		externalFunctionReturnType.put("get_req_do", "double");
		externalFunctionsHashtable.put("getfinalmrdo", functionGetFinalMrdo);
		externalFunctionReturnType.put("getfinalmrdo", "double");
	}
}
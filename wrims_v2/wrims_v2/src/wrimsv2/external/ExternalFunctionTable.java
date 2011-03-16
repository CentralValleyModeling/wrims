package wrimsv2.external;

import java.util.*;

public class ExternalFunctionTable{

	public static Hashtable<String,ExternalFunction> externalFunctionsHashtable = new Hashtable<String,ExternalFunction> ();

	public ExternalFunctionTable(){
		FunctionAnnEC functionAnnEC=new FunctionAnnEC();
		FunctionAnn_X2 functionAnn_X2 = new FunctionAnn_X2();
		FunctionGet_Req_DO functionGet_Req_DO = new FunctionGet_Req_DO();
		FunctionGetFinalMrdo functionGetFinalMrdo = new FunctionGetFinalMrdo();
		FunctionAnnLineGen functionAnnLineGen = new FunctionAnnLineGen();
		externalFunctionsHashtable.put("annec", functionAnnEC);
		externalFunctionsHashtable.put("ann_x2", functionAnn_X2);
		externalFunctionsHashtable.put("annlinegen", functionAnnLineGen);
		externalFunctionsHashtable.put("get_req_do", functionGet_Req_DO);
		externalFunctionsHashtable.put("getfinalmrdo", functionGetFinalMrdo);
	}
}
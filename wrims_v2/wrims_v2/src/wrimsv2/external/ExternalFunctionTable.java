package wrimsv2.external;

import java.util.*;

public class ExternalFunctionTable{

	public static Hashtable<String,ExternalFunction> externalFunctionsHashtable = new Hashtable<String,ExternalFunction> ();

	public ExternalFunctionTable(){
		FunctionAnnEC functionAnnEC=new FunctionAnnEC();
		externalFunctionsHashtable.put("annec", functionAnnEC);
	}
}
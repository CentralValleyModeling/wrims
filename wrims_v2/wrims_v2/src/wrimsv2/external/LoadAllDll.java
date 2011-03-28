package wrimsv2.external;


public class LoadAllDll {
	public LoadAllDll(){
		new ExternalFunctionTable();
		new LoadDll("Ann7inp_CA.dll");
		new LoadDll("InterfaceToAnn.dll");
	}
}

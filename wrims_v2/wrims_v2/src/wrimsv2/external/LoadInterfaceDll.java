package wrimsv2.external;

public class LoadInterfaceDll {
	public LoadInterfaceDll(String dllName){
		System.load(System.getenv("WRIMS_v2_path")+dllName);
	}
}

package wrimsv2.commondata.wresldata;


public class External {
	
	public String scope;
	public String type;
	public String fromWresl;

	
	public External(){
		scope=Parameters.undefined;
		type=Parameters.undefined;
		fromWresl=Parameters.undefined;

	}
	
	public String equalEva(){
		
		String s = "|";		
		String temp = scope+s+type;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((External) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((External) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
}
	

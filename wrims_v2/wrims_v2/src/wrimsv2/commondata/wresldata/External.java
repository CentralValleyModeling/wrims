package wrimsv2.commondata.wresldata;

import java.io.Serializable;


public class External implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public String scope;
	public String type;
	public String fromWresl;

	
	public External(){
		scope=Param.undefined;
		type=Param.undefined;
		fromWresl=Param.undefined;

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
	

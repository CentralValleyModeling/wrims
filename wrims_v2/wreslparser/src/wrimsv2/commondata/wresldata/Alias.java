package wrimsv2.commondata.wresldata;


public class Alias {
	
	public String scope;
	public String kind;
	public String units;
	public String expression;
	public String fromWresl;

	public Alias(){
		scope=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		expression=Param.undefined;
		fromWresl=Param.undefined;

	}
	
	public String equalEva(){
		
		String s = "|";		
		String temp = scope+s+kind+s+units+s+expression;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Alias) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Alias) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
}
	

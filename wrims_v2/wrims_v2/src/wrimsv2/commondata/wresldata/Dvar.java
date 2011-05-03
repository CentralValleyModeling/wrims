package wrimsv2.commondata.wresldata;


public class Dvar {
	
	public String scope;
	public String integer;
	public String format;
	public String kind;
	public String units;
	public String lowerBound;
	public String upperBound;
	public String fromWresl;
	public Number value;
	public Number upperBoundValue;
	public Number lowerBoundValue;
	
	public Dvar(){
		scope=Param.undefined;
		integer=Param.no;
		format=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		lowerBound=Param.undefined;
		upperBound=Param.undefined;
		fromWresl=Param.undefined;
	}
	
	public String equalEva(){
		
		String s = "|";
		String temp = scope+s+integer+s+format+s+kind+s+units+lowerBound+upperBound;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Dvar) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Dvar) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
	
	public void setValue(Number value){
		this.value=value;
	}
	
	public Number getValue(){
		return value;
	}
}
	

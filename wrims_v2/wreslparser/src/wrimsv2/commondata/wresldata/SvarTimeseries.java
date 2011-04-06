package wrimsv2.commondata.wresldata;


public class SvarTimeseries {
	
	public String scope;
	public String dssBPart;
	public String format;
	public String kind;
	public String units;
	public String convertToUnits;
	public String fromWresl;
	
	public SvarTimeseries(){
		scope=Param.undefined;
		dssBPart=Param.undefined;
		format=Param.undefined;
		kind=Param.undefined;
		units=Param.undefined;
		convertToUnits =Param.undefined;
		fromWresl = Param.undefined;
	}
	
	public String equalEva(){
		
		String s = "|";
				
		
		String temp = scope+s+dssBPart+format+s+kind+s+units+s+convertToUnits+s;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((SvarTimeseries) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((SvarTimeseries) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
}
	

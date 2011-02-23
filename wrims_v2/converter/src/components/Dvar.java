package components;

public class Dvar {
	
	public String scope;
	public String integer;
	public String format;
	public String kind;
	public String units;
	public String lowerBound;
	public String upperBound;
	public String fromWresl;
	
	public Dvar(){
		scope=Parameters.undefined;
		integer="N";
		format=Parameters.undefined;
		kind=Parameters.undefined;
		units=Parameters.undefined;
		lowerBound=Parameters.undefined;
		upperBound=Parameters.undefined;
		fromWresl=Parameters.undefined;
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
}
	

package components_tree;

public class Alias {
	
	public String scope;
	public String kind;
	public String units;
	public String expression;
	public String fromWresl;

	public Alias(){
		scope=Parameters.undefined;
		kind=Parameters.undefined;
		units=Parameters.undefined;
		expression=Parameters.undefined;
		fromWresl=Parameters.undefined;

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
	

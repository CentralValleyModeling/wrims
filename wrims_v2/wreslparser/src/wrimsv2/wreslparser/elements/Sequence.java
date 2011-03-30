package wrimsv2.wreslparser.elements;

import wrimsv2.commondata.wresldata.Parameters;

public class Sequence {

	public String sequenceName;
	public String modelName;
	public String condition;
	public String fromWresl;
	
	public Sequence(){
		sequenceName=Parameters.undefined;
		modelName=Parameters.undefined;
		condition=Parameters.always;
		fromWresl = Parameters.undefined;
	}
	
	public String equalEva(){
		
		String s = "|";
		
		
		String temp = sequenceName+s+modelName+s+condition;
		
		return temp;
	}

	@Override
	public boolean equals(Object obj)
	{

		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}

		else if (((Sequence) obj).equalEva() == null) {
			return false;
		}

		else if (this.equalEva() == ((Sequence) obj).equalEva()) {
			return true;
		}

		else {
			return false;
		}
	}
}
	

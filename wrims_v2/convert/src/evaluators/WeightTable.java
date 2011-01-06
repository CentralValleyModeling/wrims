package evaluators;

import java.util.HashMap;
import java.util.Map;

public class WeightTable {
	

	public String fromWresl;
	public Map<String,String> table;
	
	public WeightTable(){
		table = new HashMap<String,String>();
		fromWresl = Parameters.undefined;
	}
	
	
	
	
//	public String equalEva(){
//		
//		String s = "|";
//		String temp = varName+s+integer+s+format+s+kind+s+units+lowerBound+upperBound;
//		              //+caseNameStr+caseConditionStr+s+caseExpressionStr;
//		
//		return temp;
//	}

//	@Override
//	public boolean equals(Object obj)
//	{
//
//		if ((obj == null) || (obj.getClass() != this.getClass())) {
//			return false;
//		}
//
//		else if (((WeightTable) obj).equalEva() == null) {
//			return false;
//		}
//
//		else if (this.equalEva() == ((WeightTable) obj).equalEva()) {
//			return true;
//		}
//
//		else {
//			return false;
//		}
//	}
}
	

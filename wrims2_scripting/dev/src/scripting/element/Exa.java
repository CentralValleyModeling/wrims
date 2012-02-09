package scripting.element;

import java.util.HashMap;
import java.util.Map;

public class Exa {

	
	public Exa(){
		
	}
	
	public int add(int a, int b){
		
		return a+b;
	}
	
	public Map<String, String> gg() {
		
		Map<String, String> out = new HashMap<String, String>();
		
		
		out.put("a", "awhat");
		out.put("b", "bwhat");
		
		
		return out;
		
		
	}
	
}

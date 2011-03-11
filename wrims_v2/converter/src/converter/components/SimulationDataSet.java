package converter.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import converter.components.Svar;

public class SimulationDataSet implements Serializable{
	 
	private static final long serialVersionUID = 1L;

	public ArrayList<String> svList = new ArrayList<String>();
	public Map<String, Svar> svMap = new HashMap<String, Svar>();

	 
}
	

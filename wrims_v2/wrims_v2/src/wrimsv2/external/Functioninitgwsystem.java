package wrimsv2.external;

import java.util.*;

public class Functioninitgwsystem extends ExternalFunction{
	private final boolean DEBUG = false;


	public Functioninitgwsystem(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param3 = stack.pop();
		//Object param2 = stack.pop();
		//Object param1 = stack.pop();

		//cast params to correct types:
		int iWRIMS1Run = ((Number) param3).intValue();
		//int Month = ((Number) param2).intValue();
		//int WaterYear = ((Number) param1).intValue();

		//float result = initgwsystem(WaterYear, Month, iWRIMS1Run);
		float result = initgwsystem(iWRIMS1Run);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	//public native float initgwsystem(int WaterYear, int Month, int iWRIMS1Run);
	public native float initgwsystem(int iWRIMS1Run);
}

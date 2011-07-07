package wrimsv2.external;

import java.util.*;

public class FunctionInitGWSystem extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionInitGWSystem(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param3 = stack.pop();
		Object param2 = stack.pop();
		Object param1 = stack.pop();

		//cast params to correct types:
		int iWRIMS1Run = ((Number) param3).intValue();
		int Month = ((Number) param2).intValue();
		int WaterYear = ((Number) param1).intValue();

		float result = InitGWSystem(WaterYear, Month, iWRIMS1Run);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float InitGWSystem(int WaterYear, int Month, int iWRIMS1Run);
}

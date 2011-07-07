package wrimsv2.external;

import java.util.*;

public class FunctionGetPercentPumpShort extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionGetPercentPumpShort(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param1 = stack.pop();

		//cast params to correct types:
		int iDummy = ((Number) param1).intValue();

		float result = GetPercentPumpShort(iDummy);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float GetPercentPumpShort(int iDummy);
}

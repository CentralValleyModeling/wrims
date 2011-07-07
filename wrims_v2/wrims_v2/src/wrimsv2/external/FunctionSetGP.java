package wrimsv2.external;

import java.util.*;

public class FunctionSetGP extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionSetGP(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param2 = stack.pop();
		Object param1 = stack.pop();

		//cast params to correct types:
		int WBAIndex = ((Number) param2).intValue();
		float Value = ((Number) param1).floatValue();

		float result = SetGP(Value, WBAIndex);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float SetGP(float Value, int WBAIndex);
}

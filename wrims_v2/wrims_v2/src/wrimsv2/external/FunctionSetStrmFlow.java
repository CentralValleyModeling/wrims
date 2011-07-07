package wrimsv2.external;

import java.util.*;

public class FunctionSetStrmFlow extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionSetStrmFlow(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param2 = stack.pop();
		Object param1 = stack.pop();

		//cast params to correct types:
		int StrmNodeIndex = ((Number) param2).intValue();
		float Value = ((Number) param1).floatValue();

		float result = SetStrmFlow(Value, StrmNodeIndex);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float SetStrmFlow(float Value, int StrmNodeIndex);
}

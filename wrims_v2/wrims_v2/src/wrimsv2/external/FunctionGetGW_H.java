package wrimsv2.external;

import java.util.*;

public class FunctionGetGW_H extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionGetGW_H(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param2 = stack.pop();
		Object param1 = stack.pop();

		//cast params to correct types:
		int Layer = ((Number) param2).intValue();
		int indxGW = ((Number) param1).intValue();

		float result = GetGW_H(indxGW, Layer);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float GetGW_H(int indxGW, int Layer);
}

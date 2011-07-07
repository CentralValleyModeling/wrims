package wrimsv2.external;

import java.util.*;

public class FunctionGetStrm_H extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionGetStrm_H(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param1 = stack.pop();

		//cast params to correct types:
		int indxStrm = ((Number) param1).intValue();

		float result = GetStrm_H(indxStrm);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float GetStrm_H(int indxStrm);
}

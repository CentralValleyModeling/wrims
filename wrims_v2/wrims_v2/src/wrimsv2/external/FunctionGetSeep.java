package wrimsv2.external;

import java.util.*;

public class FunctionGetSeep extends ExternalFunction{
	private final boolean DEBUG = false;


	public FunctionGetSeep(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param1 = stack.pop();

		//cast params to correct types:
		int indxStrm = ((Number) param1).intValue();

		float result = GetSeep(indxStrm);

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float GetSeep(int indxStrm);
}

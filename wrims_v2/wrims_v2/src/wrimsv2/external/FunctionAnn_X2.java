package wrimsv2.external;

import java.util.*;

public class FunctionAnn_X2 extends ExternalFunction{
	private final boolean DEBUG = false;
	
	public FunctionAnn_X2(){
		
	}

	public void execute(Stack stack) {
		
		float X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4,  
	     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4;       
	    int mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay,EndDay;
		
		//values in reverse order:
		if (stack.size()==20){
			Object param20 = stack.pop();
			Object param19 = stack.pop();
			Object param18 = stack.pop();
			Object param17 = stack.pop();
			Object param16 = stack.pop();
			Object param15 = stack.pop();
			Object param14 = stack.pop();
			Object param13 = stack.pop();
			Object param12 = stack.pop();
			Object param11 = stack.pop();
			Object param10 = stack.pop();
			Object param9 = stack.pop();
			Object param8 = stack.pop();
			Object param7 = stack.pop();
			Object param6 = stack.pop();
			Object param5 = stack.pop();
			Object param4 = stack.pop();
			Object param3 = stack.pop();
			Object param2 = stack.pop();
			Object param1 = stack.pop();

			//cast params to correct types:
			EndDay =((Number) param20).intValue();
			BeginDay=((Number) param19).intValue();
			currYear = ((Number) param18).intValue();
			currMonth = ((Number) param17).intValue();
			ave_type = ((Number) param16).intValue();
			mon4 = ((Number) param15).intValue();
			mon3 = ((Number) param14).intValue();
			mon2 = ((Number) param13).intValue();
			mon1 = ((Number) param12).intValue();
			mon0 = ((Number) param11).intValue();
			DO_prv4 = ((Number) param10).floatValue();
			DO_prv3 = ((Number) param9).floatValue();
			DO_prv2 = ((Number) param8).floatValue();
			DO_prv1 = ((Number) param7).floatValue();
			DO_prv0 = ((Number) param6).floatValue();
			X2_prv4 = ((Number) param5).floatValue();
			X2_prv3 = ((Number) param4).floatValue();
			X2_prv2 = ((Number) param3).floatValue();
			X2_prv1 = ((Number) param2).floatValue();
			X2_prv0 = ((Number) param1).floatValue();
		}else{
			Object param18 = stack.pop();
			Object param17 = stack.pop();
			Object param16 = stack.pop();
			Object param15 = stack.pop();
			Object param14 = stack.pop();
			Object param13 = stack.pop();
			Object param12 = stack.pop();
			Object param11 = stack.pop();
			Object param10 = stack.pop();
			Object param9 = stack.pop();
			Object param8 = stack.pop();
			Object param7 = stack.pop();
			Object param6 = stack.pop();
			Object param5 = stack.pop();
			Object param4 = stack.pop();
			Object param3 = stack.pop();
			Object param2 = stack.pop();
			Object param1 = stack.pop();

			//cast params to correct types:
			EndDay =28;
			BeginDay=1;
			currYear = ((Number) param18).intValue();
			currMonth = ((Number) param17).intValue();
			ave_type = ((Number) param16).intValue();
			mon4 = ((Number) param15).intValue();
			mon3 = ((Number) param14).intValue();
			mon2 = ((Number) param13).intValue();
			mon1 = ((Number) param12).intValue();
			mon0 = ((Number) param11).intValue();
			DO_prv4 = ((Number) param10).floatValue();
			DO_prv3 = ((Number) param9).floatValue();
			DO_prv2 = ((Number) param8).floatValue();
			DO_prv1 = ((Number) param7).floatValue();
			DO_prv0 = ((Number) param6).floatValue();
			X2_prv4 = ((Number) param5).floatValue();
			X2_prv3 = ((Number) param4).floatValue();
			X2_prv2 = ((Number) param3).floatValue();
			X2_prv1 = ((Number) param2).floatValue();
			X2_prv0 = ((Number) param1).floatValue();			
		}
		
		float result = Ann_X2(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4,  
			     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4,        
			     mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay,EndDay);

		if (DEBUG) {
			System.out.println("*************Ann_X2**************");
			System.out.println("X2_prv0 = " + X2_prv0);
			System.out.println("X2_prv1 = " + X2_prv1);
			System.out.println("X2_prv2 = " + X2_prv2);
			System.out.println("X2_prv3 = " + X2_prv3);
			System.out.println("X2_prv4 = " + X2_prv0);
			System.out.println("DO_prv0 = " + DO_prv0);
			System.out.println("DO_prv1 = " + DO_prv1);
			System.out.println("DO_prv2 = " + DO_prv2);
			System.out.println("DO_prv3 = " + DO_prv3);
			System.out.println("DO_prv4 = " + DO_prv4);
			System.out.println("mon0 = " + mon0);
			System.out.println("mon1 = " + mon1);
			System.out.println("mon2 = " + mon2);
			System.out.println("mon3 = " + mon3);
			System.out.println("mon4 = " + mon4);
			System.out.println("ave_type = " + ave_type);
			System.out.println("currMonth = " + currMonth);
			System.out.println("currYear = " + currYear);
			System.out.println("BeginDay = " + BeginDay );
			System.out.println("EndDay = " + EndDay);
			System.out.println("result = " + result);
		}

		// push the result on the Stack
		stack.push(new Float(result));
	}

	public native float Ann_X2(float X2_prv0, float X2_prv1, 
		float X2_prv2, float X2_prv3, float X2_prv4, float DO_prv0, 
		float DO_prv1, float DO_prv2, float DO_prv3, float DO_prv4,
		int mon0, int mon1, int mon2, int mon3, int mon4,
		int ave_type, int currMonth, int currYear, int BeginDay, int EndDay);
}

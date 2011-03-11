package test.test_evaluator;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;

import converter.components.ReadSerialObj;
import converter.components.SimulationDataSet;



public class GetIlpData {
	
	
	public static void main(String[] args) throws RecognitionException, IOException {


		
		SimulationDataSet obj_in = ReadSerialObj.readObj("test_ilp_svar_only.ilp");;
		
		System.out.println("=== reading ILP Svar Map ===");
		
		
		String sv1 = obj_in.svList.get(0);
		System.out.println("The first Svar: " + sv1);
		System.out.println("The Expression in the first case: " + obj_in.svMap.get(sv1).caseExpression.get(0));		
		
		
		
		
		
		

	}

}

package wrimsv2.external;

import java.io.File;
import java.util.*;

import calsim.surrogate.SurrogateMonth;
import calsim.surrogate.examples.EmmatonExampleTensorFlowANN;

public class Functionemmatonsurrogateec extends ExternalFunction{
	private final boolean DEBUG = false;


	public Functionemmatonsurrogateec(){

	}

	public void execute(Stack stack) {

		//values in reverse order:
		Object param8 = stack.pop();
		Object param7 = stack.pop();
		Object param6 = stack.pop();
		Object param5 = stack.pop();
		Object param4 = stack.pop();
		Object param3 = stack.pop();
		Object param2 = stack.pop();
		Object param1 = stack.pop();

		//cast params to correct types:
		int month = ((Number) param8).intValue();
		int year = ((Number) param7).intValue();
		Number[] smscg_Arr = (Number[])param6;
		int size_smscg=smscg_Arr.length;
		double[] smscg=new double[size_smscg];
		for (int i=0; i<size_smscg; i++){
			smscg[i]=smscg_Arr[i].doubleValue();
		}
		Number[] sjr_Arr = (Number[])param5;
		int size_sjr=sjr_Arr.length;
		double[] sjr=new double[size_sjr];
		for (int i=0; i<size_sjr; i++){
			sjr[i]=sjr_Arr[i].doubleValue();
		}
		Number[] net_dcd_Arr = (Number[])param4;
		int size_net_dcd=net_dcd_Arr.length;
		double[] net_dcd=new double[size_net_dcd];
		for (int i=0; i<size_net_dcd; i++){
			net_dcd[i]=net_dcd_Arr[i].doubleValue();
		}
		Number[] dcc_Arr = (Number[])param3;
		int size_dcc=dcc_Arr.length;
		double[] dcc=new double[size_dcc];
		for (int i=0; i<size_dcc; i++){
			dcc[i]=dcc_Arr[i].doubleValue();
		}
		Number[] exp_Arr = (Number[])param2;
		int size_exp=exp_Arr.length;
		double[] exp=new double[size_exp];
		for (int i=0; i<size_exp; i++){
			exp[i]=exp_Arr[i].doubleValue();
		}
		Number[] sac_Arr = (Number[])param1;
		int size_sac=sac_Arr.length;
		double[] sac=new double[size_sac];
		for (int i=0; i<size_sac; i++){
			sac[i]=sac_Arr[i].doubleValue();
		}

		double result = emmatonsurrogateec(sac, exp, dcc, net_dcd, sjr, smscg, year, month);

		// push the result on the Stack
		stack.push(result);

	}

	public double emmatonsurrogateec(double[] sac, double[] exp, double[] dcc, double[] net_dcd, double[] sjr, double[] smscg, int year, int month){
		SurrogateMonth surrogateMonth = EmmatonExampleTensorFlowANN.emmatonSurrogateMonth(externalDir+"ann_calsim-main"+File.separator+"emmaton");

		double[][] sac1 = { sac };
		double[][] exp1 = { exp };

		double[][] dcc1 = { dcc };
		double[][] net_dcd1 = { net_dcd };
		double[][] sjr1 = { sjr };
		double[][] tide = { { 6.560, 6.184, 5.508, 5.083, 6.913 } };
		double[][] smscg1 = { smscg };

		ArrayList<double[][]> floatInput = new ArrayList<double[][]>();
		floatInput.add(sac1);
		floatInput.add(exp1);
		floatInput.add(dcc1);
		floatInput.add(net_dcd1);
		floatInput.add(sjr1);
		floatInput.add(tide);
		floatInput.add(smscg1);

		double[][] out = surrogateMonth.annMonth(floatInput, year, month);
		return out[0][0];
	}
}

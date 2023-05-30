package wrimsv2.tf;

import java.io.File;
import java.util.Iterator;

import org.tensorflow.Graph;
import org.tensorflow.Operation;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Session.Runner;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;



public class TF {

	public static void main(String[] args) throws Exception {

	    SavedModelBundle model = SavedModelBundle.load("Z:\\TensorFlow\\model", "serve");
        Iterator<Operation> ops = model.graph().operations();
        while (ops.hasNext()){
        	Operation op = ops.next();
        	System.out.println(op.name());
        }
	    Session s = model.session();
        Tensor data = Tensor.create(new float[] {0.7228964f, 1.05657969f, 1.32106489f, 0.75237382f, 0.86339624f,
        		-0.21546655f, -0.17141414f, -0.38003647f, -0.65384933f, -0.77411415f,
        		-0.89288707f, -0.69964324f, -0.77795826f, -0.7921897f, -0.81271535f,
        		0.f        ,  0.f        ,  0.f        ,  1.f        ,  0.f        ,
        		0.f        ,  0.f        ,  0.f        ,  0.f        ,  1.f        ,
        		0.f        ,  0.f        ,  0.f        ,  0.f        ,  0.f        ,
        		0.f        ,  0.f       });
        Runner runner = s.runner().feed("dense/kernel/Read/ReadVariableOp", data);
        Tensor result = runner.fetch("total_1/Read/ReadVariableOp").run().get(0);
        System.out.println("results: "+result.floatValue());
        
        model.close();	
		
		/*
		// load the model
		String simpleMlp = "Z:\\TensorFlow\\anntf.h5";
		MultiLayerNetwork model = KerasModelImport.
		                    importKerasSequentialModelAndWeights(simpleMlp);
		// make a random sample
		int inputs = 10;
		INDArray features = Nd4j.zeros(inputs);
		for (int i=0; i<inputs; i++) 
		    features.putScalar(new int[] {i}, Math.random() < 0.5 ? 0 : 1);
		// get the prediction
		double prediction = model.output(features).getDouble(0);
		*/
    }

}

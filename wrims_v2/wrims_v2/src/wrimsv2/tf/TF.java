package wrimsv2.tf;

import java.io.File;

import org.tensorflow.Graph;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;



public class TF {

	public static void main(String[] args) throws Exception {

	    SavedModelBundle model = SavedModelBundle.load("Z:\\TensorFlow\\model", "serve");

        Session s = model.session();
        Tensor data = Tensor.create(new double[] {2.0, 3.0, 4.0});
        Tensor result = s.runner().feed("data", data).fetch("prediction").run().get(0);
        System.out.println("results: "+result);
        
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

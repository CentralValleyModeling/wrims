package wrimsv2.tf;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Session.Runner;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;

public class TF {

    public static void main(String[] args) throws Exception {

        System.out.println("TensorFlow version: " + TensorFlow.version());

        SavedModelBundle model = SavedModelBundle.load("D:\\TensorFlow\\ANN_Models1\\calsim_delta_outflow_estimator", "serve");
        Session s = model.session();
        float[][] rawdata = new float[][] { { -0.317928304f,	0.053429297f,	0.291882696f,	0.16009989f,	0.347007481f,	
        	-0.575868808f,	0.159116005f,	0.132040745f,	0.11235005f,	0.470868431f,	
        	-0.69574763f,	0.165035588f,	-0.492836345f,	-0.485022216f,	-0.454307444f,	
        	1.f,	0.f,	0.f,	0.f,	0.f,	
        	0.f,	0.f,	0.f,	0.f,	0.f,
        	0.f,	0.f,	1.f,	0.f,	0.f,	0.f,	0.f} };
           
        
        Tensor<Float> input = Tensor.create(rawdata, Float.class);
        long[] sx = input.shape();
        System.out.println("input shape: " + sx[0] + " " + sx[1]);
        // Tensor.create([null,32], FloatBuffer.wrap(null))
        Runner runner = s.runner().feed("serving_default_input_preprocessed_input:0", input);
        Tensor result = runner.fetch("StatefulPartitionedCall:0").run().get(0);
        float[][] out = new float[1][1];
        result.copyTo(out);
        System.out.println("results: " + out[0][0]);
        model.close();
    }

}
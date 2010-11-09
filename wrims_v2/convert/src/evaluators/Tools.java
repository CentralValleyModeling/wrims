package evaluators;


public class Tools {
	  public static String strip(String s) {
		    return s.substring(1, s.length()-1);
		    }
//	private final Evaluator op1;
//	private final Evaluator op2;
//	public DivideEvaluator(Evaluator op1, Evaluator op2) {
//		this.op1 = op1;
//		this.op2 = op2;
//	}
//	@Override public int evaluate() {
//		return op1.evaluate() / op2.evaluate();
//	}
//	public String toTreeString(String indent) {
//		return '\n' + indent + "Divide" +
//			op1.toTreeString(indent + "  ") +
//			op2.toTreeString(indent + "  ");
//	}
}

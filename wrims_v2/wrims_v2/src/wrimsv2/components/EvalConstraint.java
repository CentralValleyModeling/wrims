package wrimsv2.components;

public class EvalConstraint {
	private EvalExpression evalExpression=new EvalExpression();
	private String sign;
	
	public void setEvalExpression(EvalExpression ee){
		evalExpression=ee;
	}
	
	public void setSign(String sign){
		this.sign=sign;
	}
	
	public EvalExpression getEvalExpression(){
		return evalExpression;
	}
	
	public String getSign(){
		return sign;
	}
}

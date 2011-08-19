package wrimsv2.commondata.wresldata;


abstract class Var {
	
	public String fromWresl=Param.undefined;
	public boolean needVarFromEarlierCycle;
	public boolean usedInLaterCycle;

}
	

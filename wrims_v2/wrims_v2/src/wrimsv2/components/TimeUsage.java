package wrimsv2.components;

public class TimeUsage {

	public TimeUsage(){
		System.out.println("Parse Time Usage: "+ControlData.t_parse/60000+"min "+Math.round((ControlData.t_parse/60000.0-ControlData.t_parse/60000)*60)+"sec");
		System.out.println("Read Timeseries Time Usage: "+ControlData.t_readTs/60000+"min "+Math.round((ControlData.t_readTs/60000.0-ControlData.t_readTs/60000)*60)+"sec");
		System.out.println("Process Timesereis Time Usage: "+ControlData.t_ts/60000+"min "+Math.round((ControlData.t_ts/60000.0-ControlData.t_ts/60000)*60)+"sec");
		System.out.println("Process Svar Time Usage: "+ControlData.t_svar/60000+"min "+Math.round((ControlData.t_svar/60000.0-ControlData.t_svar/60000)*60)+"sec");
		System.out.println("Process Dvar Time Usage: "+ControlData.t_dvar/60000+"min "+Math.round((ControlData.t_dvar/60000.0-ControlData.t_dvar/60000)*60)+"sec");
		System.out.println("Process Constraint Time Usage: "+ControlData.t_goal/60000+"min "+Math.round((ControlData.t_goal/60000.0-ControlData.t_goal/60000)*60)+"sec");
		System.out.println("Process Weight Time Usage: "+ControlData.t_wt/60000+"min "+Math.round((ControlData.t_wt/60000.0-ControlData.t_wt/60000)*60)+"sec");
		System.out.println("Process Weight Surplus Slack Time Usage: "+ControlData.t_wtss/60000+"min "+Math.round((ControlData.t_wtss/60000.0-ControlData.t_wtss/60000)*60)+"sec");
		System.out.println("Cbc Time Usage: "+ControlData.t_cbc/60000+"min "+Math.round((ControlData.t_cbc/60000.0-ControlData.t_cbc/60000)*60)+"sec");
		System.out.println("XA Time Usage: "+ControlData.t_xa/60000+"min "+Math.round((ControlData.t_xa/60000.0-ControlData.t_xa/60000)*60)+"sec");
		System.out.println("Process Alias Time Usage: "+ControlData.t_as/60000+"min "+Math.round((ControlData.t_as/60000.0-ControlData.t_as/60000)*60)+"sec");
		System.out.println("Write Dss Time Usage: "+ControlData.t_writeDss/60000+"min "+Math.round((ControlData.t_writeDss/60000.0-ControlData.t_writeDss/60000)*60)+"sec");
		System.out.println("ANN Time Usage: "+ControlData.t_ann/60000+"min "+Math.round((ControlData.t_ann/60000.0-ControlData.t_ann/60000)*60)+"sec");
		System.out.println("CAM Time Usage: "+ControlData.t_cam/60000+"min "+Math.round((ControlData.t_cam/60000.0-ControlData.t_cam/60000)*60)+"sec");
	}
	
}

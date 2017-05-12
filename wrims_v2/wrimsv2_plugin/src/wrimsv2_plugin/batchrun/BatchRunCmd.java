package wrimsv2_plugin.batchrun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.List;

import wrimsv2_plugin.debugger.exception.WPPException;

public class BatchRunCmd {

	private ArrayList<String> launchPathList=new ArrayList<String>();
	private ArrayList<String> launchNameList=new ArrayList<String>();
	private Map<String, LaunchConfigInfo> configMap = new HashMap<String, LaunchConfigInfo>();
	private Map<String, BatchRunProcess> brpMap = new HashMap<String, BatchRunProcess>();
	
	private boolean isSequential=true;
	private String fn="";
	
	public BatchRunCmd(String[] args){
		processArgs(args);
		procBatchRunFileNames();
		startAllBatchRun();
	}

	public void procBatchRunFileNames(){
		
		File file = new File(fn);
		FileInputStream fs;
		try {
			fs = new FileInputStream(file.getAbsolutePath());
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		    LineNumberReader reader = new LineNumberReader(br);
		    String lfp;
		    while((lfp = br.readLine())!=null){
		    	if (!lfp.equals("") && !launchPathList.contains(lfp)){
		    		LaunchConfigInfo config = new LaunchConfigInfo(lfp);
		    		BatchRunProcess brp=new BatchRunProcess();
		    		int index1=lfp.lastIndexOf("\\");
		    		int index2=lfp.lastIndexOf(".");
		    		String lfn=lfp.substring(index1+1, index2);
		    		launchPathList.add(lfp);
		    		launchNameList.add(lfn);
		    		configMap.put(lfp, config);
		    		brpMap.put(lfp, brp);
		    	}
		    }
		} catch (FileNotFoundException e) {
			WPPException.handleException(e);
		} catch (IOException e) {
			WPPException.handleException(e);
		}		
	}
	
	public void startAllBatchRun(){
		if (isSequential){
			sequentialRun();
		}else{
			parallelRun();
		}
	}
	
	protected void sequentialRun(){
		
		Runnable runnable = new Runnable(){
			
			public void run(){
				try {
					for (int i=0; i<launchPathList.size(); i++){
						String lfp=launchPathList.get(i);
						if (configMap.containsKey(lfp) && brpMap.containsKey(lfp)){
							LaunchConfigInfo config = configMap.get(lfp);
							BatchRunProcess brp = brpMap.get(lfp);
							brp.launch(config, lfp);									
						}
					}
				} catch (CoreException e) {
					WPPException.handleException(e);
				}
			}
		};
		
		new Thread(runnable).start();
	}
	
	protected void parallelRun(){
		for (int i=0; i<launchPathList.size(); i++){
			final String lfp=launchPathList.get(i);
			if (configMap.containsKey(lfp) && brpMap.containsKey(lfp)){
				final LaunchConfigInfo config = configMap.get(lfp);
				final BatchRunProcess brp = brpMap.get(lfp);
				
				Runnable runnable = new Runnable(){
					
					public void run(){
						try {
							brp.launch(config, lfp);
						} catch (CoreException e) {
							WPPException.handleException(e);
						}
					}
				};
				
				new Thread(runnable).start();
			}
		}
	}
	
	public void processArgs(String[] args){
		if (args.length==1){
			fn=args[0];
		}else{
			if(args[0].equalsIgnoreCase("-p") || args[0].equalsIgnoreCase(("-parallel"))) {
				isSequential=false;
			}
			fn=args[1];
		}
	}
	
	public static void main(String[] args){
		new BatchRunCmd(args);
	}
}


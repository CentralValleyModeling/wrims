package test;

import java.io.IOException;

public class Runner extends Thread {
	private ContactDebugger cd;
	
	public Runner(ContactDebugger cd){
		this.cd=cd;
	}
	
	@Override
	public void run() {
		for (cd.i=0; cd.i<=10000; cd.i++){
			if (cd.i==cd.pauseIndex){
				try {
					cd.sendRequest(Integer.toString(cd.i));
				} catch (IOException e) {
					e.printStackTrace();
				}
				this.suspend();
			}
		}
	}

}

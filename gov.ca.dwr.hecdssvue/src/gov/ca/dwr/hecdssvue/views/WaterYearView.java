package gov.ca.dwr.hecdssvue.views;

import gov.ca.dwr.hecdssvue.DssPluginCore;
import gov.ca.dwr.hecdssvue.components.ShowSelected;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;

public class WaterYearView extends ViewPart {

	private HashMap<Integer, ArrayList<Integer>> sacIndex= new HashMap<Integer, ArrayList<Integer>>();
	private HashMap<Integer, ArrayList<Integer>> sjrIndex= new HashMap<Integer, ArrayList<Integer>>();
	private HashMap<Integer, ArrayList<Integer>> shastaIndex= new HashMap<Integer, ArrayList<Integer>>();
	private HashMap<Integer, ArrayList<Integer>> featherIndex= new HashMap<Integer, ArrayList<Integer>>();
	
	private Button[][] index= new Button[4][5];
	
	private Composite area;
	
	public static final String ID = "gov.ca.dwr.hecdssvue.views.WaterYearView";
	
	@Override
	public void createPartControl(Composite parent) {
		initialWaterYearMap();
		area = new Composite(parent, SWT.NONE);
		area.setLayout(new GridLayout(40, true));
		
		Label sac=new Label(area, SWT.NONE);
		sac.setText("SacR Index (40-30-30)");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 10;//TODO
		sac.setLayoutData(gd);
		
		Label sjr=new Label(area, SWT.NONE);
		sjr.setText("SJR Index (60-20-20)");
		sjr.setLayoutData(gd);
		
		Label shasta=new Label(area, SWT.NONE);
		shasta.setText("Shasta Index");
		shasta.setLayoutData(gd);
		
		Label feather=new Label(area, SWT.NONE);
		feather.setText("Feather Index");
		feather.setLayoutData(gd);
		
		index[0][0] = new Button(area, SWT.CHECK);
		index[0][0].setText("Wet (W 1)");
		index[0][0].setLayoutData(gd);
		
		index[1][0] = new Button(area, SWT.CHECK);
		index[1][0].setText("Wet (W 1)");
		index[1][0].setLayoutData(gd);
		
		index[2][0] = new Button(area, SWT.CHECK);
		index[2][0].setText("Normal (1)");
		index[2][0].setLayoutData(gd);
		
		index[3][0] = new Button(area, SWT.CHECK);
		index[3][0].setText("0");
		index[3][0].setLayoutData(gd);
		
		index[0][1] = new Button(area, SWT.CHECK);
		index[0][1].setText("Above Normal (AN 2)");
		index[0][1].setLayoutData(gd);
		
		index[1][1] = new Button(area, SWT.CHECK);
		index[1][1].setText("Above Normal (AN 2)");
		index[1][1].setLayoutData(gd);
		
		index[2][1] = new Button(area, SWT.CHECK);
		index[2][1].setText("Below Normal (2)");
		index[2][1].setLayoutData(gd);
		
		index[3][1] = new Button(area, SWT.CHECK);
		index[3][1].setText("1");
		index[3][1].setLayoutData(gd);
		
		index[0][2] = new Button(area, SWT.CHECK);
		index[0][2].setText("Below Normal (BN 3)");
		index[0][2].setLayoutData(gd);
		
		index[1][2] = new Button(area, SWT.CHECK);
		index[1][2].setText("Below Normal (BN 3)");
		index[1][2].setLayoutData(gd);
		
		index[2][2] = new Button(area, SWT.CHECK);
		index[2][2].setText("Dry (3)");
		index[2][2].setLayoutData(gd);
		
		Label blank1=new Label(area, SWT.NONE);
		blank1.setText("");
		blank1.setLayoutData(gd);
		
		index[0][3] = new Button(area, SWT.CHECK);
		index[0][3].setText("Dry (D 4)");
		index[0][3].setLayoutData(gd);
		
		index[1][3] = new Button(area, SWT.CHECK);
		index[1][3].setText("Dry (D 4)");
		index[1][3].setLayoutData(gd);
		
		index[2][3] = new Button(area, SWT.CHECK);
		index[2][3].setText("Critial (4)");
		index[2][3].setLayoutData(gd);
		
		Label blank2=new Label(area, SWT.NONE);
		blank2.setText("");
		blank2.setLayoutData(gd);
		
		index[0][4] = new Button(area, SWT.CHECK);
		index[0][4].setText("Critical (C 5)");
		index[0][4].setLayoutData(gd);
		
		index[1][4] = new Button(area, SWT.CHECK);
		index[1][4].setText("Critical (C 5)");
		index[1][4].setLayoutData(gd);
		
		Label blank3=new Label(area, SWT.NONE);
		blank3.setText("");
		blank3.setLayoutData(gd);
		
		Button clearAll=new Button(area, SWT.PUSH);
		clearAll.setText("Clear All");
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 4;//TODO
		clearAll.setLayoutData(gd1);
		clearAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i=0; i<5; i++){
					index[0][i].setSelection(false);
				}
				for (int i=0; i<5; i++){
					index[1][i].setSelection(false);
				}
				for (int i=0; i<4; i++){
					index[2][i].setSelection(false);
				}
				for (int i=0; i<2; i++){
					index[3][i].setSelection(false);
				}
				DssPluginCore.isAllWaterYear=true;
			}
		});
		
		for (int i=0; i<5; i++){
			index[0][i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					wateryearFilter();
				}
			});
			
			index[1][i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					wateryearFilter();
				}
			});
		}
		
		for (int i=0; i<4; i++){
			index[2][i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					wateryearFilter();
				}
			});
		}
		
		for (int i=0; i<2; i++){
			index[3][i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					wateryearFilter();
				}
			});
		}
	}
	
	public void wateryearFilter(){
		boolean isFirstSet=true;
		DssPluginCore.isAllWaterYear=true;
		ArrayList<Integer> selectedWaterYear=new ArrayList<Integer>();
		for (int i=0; i<5; i++){
			if (index[0][i].getSelection()){
				DssPluginCore.isAllWaterYear=false;
				selectedWaterYear.addAll(sacIndex.get(i+1));
				isFirstSet=false;
			}
		}
		for (int i=0; i<5; i++){
			if (index[1][i].getSelection()){
				DssPluginCore.isAllWaterYear=false;
				if (isFirstSet){
					selectedWaterYear.addAll(sjrIndex.get(i+1));
					isFirstSet=false;
				}else{
					selectedWaterYear.retainAll(sjrIndex.get(i+1));
				}
			}
		}
		for (int i=0; i<4; i++){
			if (index[2][i].getSelection()){
				DssPluginCore.isAllWaterYear=false;
				if (isFirstSet){
					selectedWaterYear.addAll(shastaIndex.get(i+1));
					isFirstSet=false;
				}else{
					selectedWaterYear.retainAll(shastaIndex.get(i+1));
				}
			}
		}
		for (int i=0; i<2; i++){
			if (index[3][i].getSelection()){
				DssPluginCore.isAllWaterYear=false;
				if (isFirstSet){
					selectedWaterYear.addAll(featherIndex.get(i));
					isFirstSet=false;
				}else{
					selectedWaterYear.retainAll(featherIndex.get(i+1));
				}
			}
		}
		
		DssPluginCore.filterWaterYear=new HashSet<Integer>(selectedWaterYear);
		
		ShowSelected.showSelected();
	}
	
	public void initialWaterYearMap(){
		int[][] lookups=readInLookups("wytypes.table");
		for (int i=0; i<lookups.length; i++){
			int wateryear=lookups[i][0];
			
			int saci=lookups[i][1];
			if (sacIndex.containsKey(saci)){
				sacIndex.get(saci).add(wateryear);
			}else{
				ArrayList<Integer> sacArray=new ArrayList<Integer>();
				sacArray.add(wateryear);
				sacIndex.put(saci, sacArray);
			}
			
			int sjri=lookups[i][2];
			if (sjrIndex.containsKey(sjri)){
				sjrIndex.get(sjri).add(wateryear);
			}else{
				ArrayList<Integer> sjrArray=new ArrayList<Integer>();
				sjrArray.add(wateryear);
				sjrIndex.put(sjri, sjrArray);
			}
			
			int shastai=lookups[i][3];
			if (shastaIndex.containsKey(shastai)){
				shastaIndex.get(shastai).add(wateryear);
			}else{
				ArrayList<Integer> shastaArray=new ArrayList<Integer>();
				shastaArray.add(wateryear);
				shastaIndex.put(shastai, shastaArray);
			}
			
			int featheri=lookups[i][5];
			if (featherIndex.containsKey(featheri)){
				featherIndex.get(featheri).add(wateryear);
			}else{
				ArrayList<Integer> featherArray=new ArrayList<Integer>();
				featherArray.add(wateryear);
				featherIndex.put(featheri, featherArray);
			}
		}
		
	}
	
	private int[][] readInLookups(String fn) {

		// Open input file
		int lookups[][]=new int[0][0];
		
		Scanner input;
		try {
			input = new Scanner(new FileReader(DebugCorePlugin.dataDir+"\\"+fn));
		} catch (FileNotFoundException e) {
			WPPException.handleException(e);
			return lookups;
		}

		Vector<String> allLookups = new Vector<String>();

		int lineCount = 0;
		input.nextLine(); // Skip first two line
		input.nextLine(); // Skip first two line
		while (input.hasNextLine()) {
			String line = input.nextLine();
			allLookups.add(line);
			lineCount++;
		}
		input.close();
		lookups = new int[lineCount][6];
		for (int i = 0; i < lineCount; i++) {
			String[] parts = allLookups.get(i).split("[\t]+");
			for (int j = 0; j < 6; j++) {
				if (parts[j].equals("null"))
					parts[j] = "";
				lookups[i][j] = Integer.parseInt(parts[j]);
			}
		}

		return lookups;
	}

	@Override
	public void setFocus() {
		area.setFocus();		
	}

}

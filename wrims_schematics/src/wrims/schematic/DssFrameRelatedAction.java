package wrims.schematic;

import com.nwoods.jgo.*;

import java.awt.Container;
import java.util.*;
import javax.swing.*;
import wrims.dss.DssViewer;

/**
 * Define a schematic-fired Action that communicates with the DSS Viewer directly (for popupup menus).
 * @author Clay Booher
 */
public abstract class DssFrameRelatedAction extends SchematicRelatedAction {

	public final int STORAGE = 0;

	public final int INFLOWS = 1;

	public final int OUTFLOWS = 2;

	public final int EVAP = 3;

	public final int AREA = 4;

	public final int SPILL = 5;

	public final int FLOW = 6;

	public final static String STORAGE_STRING = "Storage (EOP)";

	public final static String INFLOWS_STRING = "Inflows";

	public final static String OUTFLOWS_STRING = "Outflows";

	public final static String EVAP_STRING = "Evaporation";

	public final static String AREA_STRING = "Surface Area";

	public final static String SPILL_STRING = "Non-recoverable Spill";

	public final static String FLOW_STRING = "Flow";

	public final static String STORAGE_ABBREV = "S";

	public final static String EVAP_ABBREV = "E";

	public final static String AREA_ABBREV = "A";

	public final static String SPILL_ABBREV = "F";

	private Hashtable _typeHashtable;

	private Hashtable _abbrevHashtable;

	public DssFrameRelatedAction(String name, Container app) {
		super(name, app);
		createHashtables();
	}

	public DssFrameRelatedAction(String name, Icon icon, Container app) {
		super(name, icon, app);
		createHashtables();
		createAbbrevHashtable();
	}

	private void createHashtables() {
		createTypeHashtable();
		createAbbrevHashtable();
	}

	private void createTypeHashtable() {
		_typeHashtable = new Hashtable(9);
		_typeHashtable.put(STORAGE_STRING, new Integer(STORAGE));
		_typeHashtable.put(INFLOWS_STRING, new Integer(INFLOWS));
		_typeHashtable.put(OUTFLOWS_STRING, new Integer(OUTFLOWS));
		_typeHashtable.put(EVAP_STRING, new Integer(EVAP));
		_typeHashtable.put(AREA_STRING, new Integer(AREA));
		_typeHashtable.put(SPILL_STRING, new Integer(SPILL));
		_typeHashtable.put(FLOW_STRING, new Integer(FLOW));
	}

	private void createAbbrevHashtable() {
		_abbrevHashtable = new Hashtable(4);
		_abbrevHashtable.put(new Integer(STORAGE), STORAGE_ABBREV);
		_abbrevHashtable.put(new Integer(EVAP), EVAP_ABBREV);
		_abbrevHashtable.put(new Integer(AREA), AREA_ABBREV);
		_abbrevHashtable.put(new Integer(SPILL), SPILL_ABBREV);
//
	}

	public boolean canAct() {
		return getApp() != null && getApp() instanceof MainFrame
			&& ((MainFrame)getApp())._DssFrame != null;
	}

	boolean actionPerfomedHelper(String outputTypeText, String variableTypeText) {
		if (outputTypeText == null || variableTypeText == null
				|| outputTypeText.trim().length() == 0 || variableTypeText.trim().length() == 0)
			return false;
//		System.out.println("outputTypeText = " + outputTypeText);
//		System.out.println("variableTypeText = " + variableTypeText);
		if (DssViewer.getOutputType(outputTypeText) == null
				|| _typeHashtable.get(variableTypeText) == null)
			return false;
		int outputType = (Integer)DssViewer.getOutputType(outputTypeText);
		int variableType = (Integer)_typeHashtable.get(variableTypeText);
		boolean isExceedence = false;
		boolean isAnnualTotal = false;
		if (outputType == DssViewer.EXCEEDENCE) {
			isAnnualTotal = false;
			isExceedence = true;
		} else if (outputType == DssViewer.ANNUAL_TOTAL) {
			isExceedence = false;
			isAnnualTotal = true;
		} else if (outputType == DssViewer.ANNUAL_TOTAL_EXCEEDENCE) {
			isExceedence = true;
			isAnnualTotal = true;
		}

		if (variableType == INFLOWS || variableType == OUTFLOWS) {
			Vector selectedObjects = ((MainFrame)getApp()).getCurrentView()
				.createSelectionVector(((((MainFrame)getApp()).getCurrentView()
					.getSelection())));
			if (selectedObjects.size() > 0) {
				Vector<String> names = new Vector<String>();
				Enumeration selectedEnum = selectedObjects.elements();
				while (selectedEnum.hasMoreElements()) {
					Object object = selectedEnum.nextElement();
					if (object instanceof NetworkNode) {
						JGoListPosition position = ((MainFrame)getApp())
							.getCurrentView().getDoc().getFirstObjectPos();
						while (position != null) {
							JGoObject obj = ((MainFrame)getApp()).getCurrentView()
								.getDoc().getObjectAtPos(position);
							//CB TO DO: either eliminate Link class and change all CalSim III links to arcs with no label OR
							//          do the above except change labelless arcs to arcs with a bordered label and eliminate
							//          variable types of NetworkNodes (by combining two arcs into one with the name of the
							//          former node in common as the label of the one arc.
							//  Until the above is done, the below code (and code elsewhere) will be a mess.
							if (obj instanceof Arc) {
								if (variableType == INFLOWS && ((Arc)obj).getToNode() == object) {
									if (((Arc)obj).getText().trim().equals("")) { //CalSim III type
										names.add(((Arc)obj).getFromNode().getText());
									} else   //CalSim II type
										names.add(((Arc)obj).getText());
								} else if (variableType == OUTFLOWS
										&& ((Arc)obj).getFromNode() == object) {
									if (((Arc)obj).getText().trim().equals("")) { //CalSim III type
										names.add(((Arc)obj).getToNode().getText());
									} else   //CalSim II type
										names.add(((Arc)obj).getText());
								}
							} else if (obj instanceof Link) {
								if (variableType == INFLOWS && ((Link)obj).getToNode() == object) {
									if (((Link)obj).getFromNode() instanceof NetworkNode)
										names.add(((NetworkNode)((Link)obj).getFromNode()).getText());
								} else if (variableType == OUTFLOWS) {
										if (((Link)obj).getFromNode() == object
												|| (((Link)obj).getFromNode() instanceof NetworkNode
														&& ((NetworkNode)((Link)obj).getFromNode())
														.getText().substring(2,
														((NetworkNode)((Link)obj).getFromNode())
														.getText().length()).equalsIgnoreCase(
														((NetworkNode)object).getText())))
											if (((Link)obj).getToNode() instanceof NetworkNode)
												names.add(((NetworkNode)((Link)obj).getToNode())
													.getText());
								}
							}
							position = ((MainFrame)getApp()).getCurrentView()
								.getDoc().getNextObjectPos(position);
						}
					}
				}
				if (names.size() > 0) {
					((MainFrame)getApp())._DssFrame.getFP()
						.retrieve(outputType, isExceedence, isAnnualTotal, names);
				} else
					JOptionPane.showMessageDialog(((MainFrame)getApp())._DssFrame,
						"No variables in dss files that match any of the selected items",
						"Match Not Found", JOptionPane.WARNING_MESSAGE);
			}
			return true;
		} else if (variableType == STORAGE || (variableType >= EVAP && variableType <= SPILL)) {
			Vector<JGoObject> selectedObjects = ((MainFrame)getApp()).getCurrentView()
				.createSelectionVector(((((MainFrame)getApp()).getCurrentView().getSelection())));
			if (selectedObjects.size() > 0) {
				Vector<String> objectNames = new Vector<String>();
				Enumeration<JGoObject> selectedEnum = selectedObjects.elements();
				while (selectedEnum.hasMoreElements()) {
					Object object = selectedEnum.nextElement();
					if (object instanceof NetworkNode  //TODO CB mentioned here AGAIN - need to get replace int for type delineation with class
							&& (((NetworkNode)object).getType() == NetworkNode.RESERVOIR
								|| ((NetworkNode)object).getType() == NetworkNode.RRESERVOIR
								|| ((NetworkNode)object).getType() == NetworkNode.LRESERVOIR
								|| ((NetworkNode)object).getType() == NetworkNode.URESERVOIR
								|| ((NetworkNode)object).getType() == NetworkNode.RESERVOIR_NOTUSED
								|| ((NetworkNode)object).getType() == NetworkNode.RRESERVOIR_NOTUSED
								|| ((NetworkNode)object).getType() == NetworkNode.LRESERVOIR_NOTUSED
								|| ((NetworkNode)object).getType() == NetworkNode.URESERVOIR_NOTUSED)){
//						System.out.println((String)_abbrevHashtable.get(variableType) + "_"
//								+ ((NetworkNode)object).getText().toUpperCase());
						objectNames.add((String)_abbrevHashtable.get(variableType) + "_"
							+ ((NetworkNode)object).getText().toUpperCase());
					} else if (((NetworkNode)object).getType() == NetworkNode.VARIABLE) { // && ((NetworkNode)object).getText().startsWith("S_")) { //CB decided to allow
						objectNames.add(((NetworkNode)object).getText().toUpperCase());
					}
				}
				((MainFrame)getApp())._DssFrame.getFP()
					.retrieve(outputType, isExceedence, isAnnualTotal, objectNames);
			}
			return true;
		} else if (variableType == FLOW) {
			Vector selectedObjects = ((MainFrame)getApp()).getCurrentView()
				.createSelectionVector(((((MainFrame)getApp()).getCurrentView().getSelection())));
			if (selectedObjects.size() > 0) {
				Vector objectNames = new Vector();
				Enumeration selectedEnum = selectedObjects.elements();
				while (selectedEnum.hasMoreElements()) {
					Object object = selectedEnum.nextElement();
					if (object instanceof Arc) { // CB need to add Link for CalSim III!?
						objectNames.add(((Arc)object).getText());
					} else if (object instanceof NetworkNode && ((NetworkNode)object).getType() == NetworkNode.VARIABLE) { //CB Tom has CalSim III type arc names as NetworkNode objects, so...
						objectNames.add(((NetworkNode)object).getText());
					}
				}
				((MainFrame)getApp())._DssFrame.getFP()
					.retrieve(outputType, isExceedence, isAnnualTotal, objectNames);
			}
		} else {
			// ?????????????????????????????????????????
		}
		return false;
	}

	private class NameNumberPair {
		String _name;
		Integer _number;

		public NameNumberPair(String name, Integer number) {
			_name = name;
			_number = number;
		}

		Object getName() {
			return _name;
		}

		Object getNumber() {
			return _number;
		}

		Object get(Object other) {
			if (other instanceof String) {
				if (((String)other).equals(_name))
					return _number;
				else return null;
			} else if (other instanceof Integer) {
				if (((Integer)other) == _number)
					return _name;
				else return null;
			} else return null;
		}
	}
}

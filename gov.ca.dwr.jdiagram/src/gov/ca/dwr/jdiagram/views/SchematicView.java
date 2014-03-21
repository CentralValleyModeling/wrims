package gov.ca.dwr.jdiagram.views;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.jdiagram.Activator;
import gov.ca.dwr.jdiagram.SchematicPluginCore;
import gov.ca.dwr.jdiagram.toolbars.DateCombo;
import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDss;
import hec.heclib.util.HecTime;
import hec.hecmath.DSSFile;
import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.tools.TimeOperation;

import com.mindfusion.diagramming.Align;
import com.mindfusion.diagramming.AttachToNode;
import com.mindfusion.diagramming.Behavior;
import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramAdapter;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.diagramming.DiagramLink;
import com.mindfusion.diagramming.DiagramLinkList;
import com.mindfusion.diagramming.DiagramNode;
import com.mindfusion.diagramming.DiagramNodeList;
import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.Group;
import com.mindfusion.diagramming.LinkEvent;
import com.mindfusion.diagramming.NodeEvent;
import com.mindfusion.diagramming.Overview;
import com.mindfusion.diagramming.ShapeNode;
import com.mindfusion.diagramming.TextFormat;

/**
 * This view represents the schematic drawing
 */

public class SchematicView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.jdiagram.views.SchematicView";

	private DiagramView diagramView;

	private Composite swingContainer;

	private Diagram diagram;

	private Action zoomInAction;

	private Action zoomOutAction;

	private Action openSchematicAction;

	private float _zoomFactor = 100;

	private Action zoomNormalAction;

	private DiagramSelectionProvider selectionProvider;

	private Rectangle2D.Float lastVisibleRect;

	private DateCombo dateCombo;
	
	private static final Object VALUE_TEXT = "__VT__";
	
	private static int precision = 0;
	
	private static double FACTOR = 1000. * 43560 / (24 * 60 * 60);
	
	private int index_lastnode = 0;

	/**
	 * The constructor.
	 */
	public SchematicView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	@SuppressWarnings("serial")
	public void createPartControl(Composite parent) {
		System.setProperty("sun.awt.noerasebackground", "true");
		swingContainer = new Composite(parent, SWT.BACKGROUND | SWT.EMBEDDED);
		Frame frame = SWT_AWT.new_Frame(swingContainer);
		Panel panel = new Panel(new BorderLayout()) {
			public void update(java.awt.Graphics g) {
				/* Do not erase the background */
				paint(g);
			}
		};
		frame.add(panel);
		JRootPane root = new JRootPane();
		panel.add(root);
		java.awt.Container contentPane = root.getContentPane();
		//JLayeredPane layeredPane = new JLayeredPane();
		//contentPane.add(layeredPane);
		diagramView = new DiagramView(diagram = new Diagram());
		diagramView.setAllowInplaceEdit(false);
		diagramView.setBehavior(Behavior.Pan);
		getSite().setSelectionProvider(
				selectionProvider = new DiagramSelectionProvider());
		diagram.addDiagramListener(new DiagramAdapter() {
			private Timer refreshTimer = new Timer();
			private TimerTask refreshTask;
			private int delay = 50;
			
			
			@Override
			public void linkClicked(LinkEvent e) {
				selectionProvider.setSelection(new DiagramItemSelection(e
						.getLink()));
			}

			@Override
			public void linkDoubleClicked(LinkEvent e) {
			}

			@Override
			public void nodeClicked(NodeEvent e) {
				selectionProvider.setSelection(new DiagramItemSelection(e
						.getNode()));
			}

			@Override
			public void nodeDoubleClicked(NodeEvent e) {
			}

			@Override
			public void viewportChanged() {
				refreshTimer.cancel();
				refreshTimer = new Timer();
				refreshTask = new TimerTask() {

					@Override
					public void run() {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								try {
									// diagramView.suspendRepaint();
									// overview.suspendRepaint();
									if (!DebugCorePlugin.isDebugging){
										refreshValues(0, false);					
									}else{
										if (DebugCorePlugin.target !=null){
											refreshValues(0, false);
										}
									}
								} finally {
									// diagramView.resumeRepaint();
									// overview.resumeRepaint();
								}

							}
						});
					}

				};
				refreshTimer.schedule(refreshTask, delay);
			}

		});
		contentPane.add(new JScrollPane(diagramView));
		Overview overview = new Overview();
		overview.setDiagramView(diagramView);
		//layeredPane.add(overview,1);
		IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		/*
		if (activePage != null) {
			IViewPart sview = activePage.findView(SchematicOverview.ID);
			if (sview != null) {
				SchematicOverview overview = (SchematicOverview) sview;
				overview.setDiagramView(diagramView);
			}
		}
		*/
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(swingContainer, "gov.ca.dwr.calsim.jdiagram.viewer");
		makeActions();
		contributeToActionBars();
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(openSchematicAction);
		manager.add(zoomInAction);
		manager.add(zoomOutAction);
		manager.add(zoomNormalAction);
		dateCombo=new DateCombo(this);
		manager.add(dateCombo);
	}

	@SuppressWarnings("deprecation")
	private void makeActions() {
		openSchematicAction = new Action("Open", PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OPEN_MARKER)) {
			public void run() {
				FileDialog dialog = new FileDialog(swingContainer.getShell(),
						SWT.OPEN);
				dialog.setFilterExtensions(new String[] { "*.xml", "*.cht" });
				String file = dialog.open();
				if (file == null) {
					return;
				}
				try {
					diagramView.suspendRepaint();
					if (file.endsWith(".xml")) {
						diagram.loadFromXml(file);
					} else {
						diagram.loadFrom(file);
					}
					Rectangle2D rect = diagram.getBounds();
					diagramView.zoomToFit(rect);
					diagramView.resumeRepaint();
					collectAllSchematicVariables();
					loadAllSchematicVariableData();
				} catch (Exception ex) {
					Status status = new Status(IStatus.ERROR,
							Activator.PLUGIN_ID, "Error Opening Schematic", ex);
					StatusManager.getManager()
							.handle(status, StatusManager.LOG);
				}
			}
		};
		zoomNormalAction = new Action("Zoom 100",
				Activator.getImageDescriptor("ZoomNormal24.gif")) {

			public void run() {
				_zoomFactor = 100;
				diagramView.setZoomFactor(_zoomFactor);
			};
		};
		zoomInAction = new Action("Zoom In",
				Activator.getImageDescriptor("ZoomIn24.gif")) {

			public void run() {
				//_zoomFactor *= 2;
				//diagramView.setZoomFactor(_zoomFactor);
				Rectangle2D.Float rect = diagramView.deviceToDoc(diagramView.getVisibleRect());
				rect.setRect(rect.x+rect.width/4, rect.y+rect.height/4, rect.width/2, rect.height/2);
				diagramView.zoomToFit(rect);
			};
		};
		zoomOutAction = new Action("Zoom Out",
				Activator.getImageDescriptor("ZoomOut24.gif")) {

			public void run() {
				//_zoomFactor /= 2;
				Rectangle2D.Float rect = diagramView.deviceToDoc(diagramView.getVisibleRect());
				rect.setRect(rect.x-rect.width/2, rect.y-rect.height/2, rect.width*2, rect.height*2);
				diagramView.zoomToFit(rect);
			};
		};
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		swingContainer.setFocus();
	}

	public Diagram getDiagram() {
		return diagram;
	}

	public DiagramView getDiagramView() {
		return diagramView;
	}

	/**
	 * Selection wrapper for DiagramItem
	 * 
	 * @author psandhu
	 * 
	 */
	public static final class DiagramItemSelection implements
			IStructuredSelection, IAdaptable {

		private DiagramItem item;

		public DiagramItemSelection(DiagramItem item) {
			this.item = item;
		}

		public DiagramItem getItem() {
			return item;
		}

		public void setItem(DiagramItem item) {
			this.item = item;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Object getAdapter(Class adapter) {
			if (adapter == IPropertySource.class) {
				return new DiagramItemPropertySource(item);
			}
			return null;
		}

		@Override
		public Object getFirstElement() {
			return new DiagramItemPropertySource(item);
		}

		@SuppressWarnings("rawtypes")
		@Override
		public Iterator iterator() {
			return Collections.singleton(getFirstElement()).iterator();
		}

		@Override
		public int size() {
			return 1;
		}

		@Override
		public Object[] toArray() {
			return new Object[] { getFirstElement() };
		}

		@SuppressWarnings("rawtypes")
		@Override
		public List toList() {
			return Collections.singletonList(getFirstElement());
		}

	}

	public static final class DiagramItemPropertySource implements
			IPropertySource {
		public static final String LABEL = "label";
		public static final String INCOMING = "incoming";
		public static final String OUTGOING = "outgoing";
		private DiagramItem item;

		public DiagramItemPropertySource(DiagramItem item) {
			this.item = item;
		}

		@Override
		public Object getEditableValue() {
			return null;
		}

		@Override
		public IPropertyDescriptor[] getPropertyDescriptors() {
			PropertyDescriptor labelDescriptor = new PropertyDescriptor(LABEL,
					"label");
			PropertyDescriptor incomingDescriptor = new PropertyDescriptor(
					INCOMING, "incoming");
			PropertyDescriptor outgoingDescriptor = new PropertyDescriptor(
					OUTGOING, "outgoing");
			return new IPropertyDescriptor[] { labelDescriptor,
					incomingDescriptor, outgoingDescriptor };
		}

		@Override
		public Object getPropertyValue(Object id) {
			if (id.equals(LABEL)) {
				if (item instanceof ShapeNode) {
					return ((ShapeNode) item).getPlainText();
				} else if (item instanceof DiagramLink) {
					return ((DiagramLink) item).getText();
				}
				return "";
			} else if (id.equals(INCOMING) || id.equals(OUTGOING)){
				if (item instanceof DiagramNode){
					DiagramNode node = (DiagramNode) item;
					if (id.equals(INCOMING)){
						return getIncomingNodes(node);
					} else {
						return getOutgoingNodes(node);
					}
				}
			}
			return "";
		}

		private Object getIncomingNodes(DiagramNode node) {
			DiagramLinkList incomingLinks = node.getIncomingLinks();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < incomingLinks.size(); i++) {
				DiagramLink diagramLink = incomingLinks.get(i);
				if (i>0){
					buf.append(", ");
				}
				buf.append(diagramLink.getOrigin().getTextToEdit());
			}
			return buf.toString();
		}
		
		private Object getOutgoingNodes(DiagramNode node) {
			DiagramLinkList outgoingLinks = node.getOutgoingLinks();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < outgoingLinks.size(); i++) {
				DiagramLink diagramLink = outgoingLinks.get(i);
				if (i>0){
					buf.append(", ");
				}
				buf.append(diagramLink.getDestination().getTextToEdit());
			}
			return buf.toString();
		}

		@Override
		public boolean isPropertySet(Object id) {
			if (id.equals(LABEL)) {
				return true;
			}
			return false;
		}

		@Override
		public void resetPropertyValue(Object id) {
		}

		@Override
		public void setPropertyValue(Object id, Object value) {
		}

	}

	public void refreshValues(final int index, boolean force) {		
		synchronized (diagramView) {
			final Rectangle2D.Float visibleRect = diagramView.deviceToDoc(diagramView
					.getVisibleRect());
			if (!force && lastVisibleRect==null) {
				return;
			}
			if (lastVisibleRect == null) {
				lastVisibleRect = visibleRect;
			}
			clearValueBoxes(lastVisibleRect);
			lastVisibleRect = visibleRect;
			
			final String selDate = SchematicPluginCore.selDate;
			new Thread(new Runnable() {
				public void run() {
					updateValues(index, selDate, visibleRect);
				}
			}).start();
		}
	}
	
	public void updateValues(int index, String date, Rectangle2D.Float visibleRect){
		Hashtable<String, String>[] values = null;
		Hashtable<String, Object> visibleNodes = getVisibleNodes(visibleRect);
		
		final Hashtable<String, Object> names = new Hashtable<String, Object>();
		for (String v : visibleNodes.keySet()) {
			names.put(v, v);
		}
		if (index==0){
			values = retrieveUndebug(date, names);
		}else{
			values = retrieveDebug(date, names);
		}
		setValues(index, visibleNodes, values);
	}
	
	public Hashtable<String, String>[] retrieveUndebug(String date, Hashtable<String, Object> names){
		String[] tws = SchematicPluginCore._twSelections;
		for (int i=0; i<tws.length; i++){
			if (date.equals(tws[i])){
				if (PluginCore.units.equals(PluginCore.cfs)){
					if (PluginCore.longTermAverageDataCFS[i]==null) {
						calculateLongTermAverage(i, date, tws, true);
					}
					return retrieveLongTermAverage(i, names, true);
				}else{
					if (PluginCore.longTermAverageDataTAF[i]==null) {
						calculateLongTermAverage(i, date, tws, false);
					}
					return retrieveLongTermAverage(i, names, false);
				}
			}
		}
		
		int size=names.size();
		Hashtable<String, String>[] results = new Hashtable[4];

		for (int i = 0; i < 4; ++i) {
			results[i] = new Hashtable<String, String>();
		}

		int baseIndex=5;
		
		for (int j = 1; j < 4; j++) {
			int k=j-1;
			if (DebugCorePlugin.selectedStudies[k]){
				if (baseIndex>j){
					baseIndex=j;
				}

				Enumeration<String> variableEnum = names.keys();
				while (variableEnum.hasMoreElements()) {
					String name = variableEnum.nextElement();
					ArrayList<String[]> pathParts = new ArrayList<String[]>();
					CondensedReference found = null;
					boolean isStorage=false;
					String value = "";			
					if (PluginCore.allSchematicVariableData[k].containsKey(name)){
						try {
							HecMath dataSet = PluginCore.allSchematicVariableData[k].get(name);
							if (PluginCore.allStorageNames.contains(name)) isStorage=true;
							TimeSeriesContainer tsc = (TimeSeriesContainer)dataSet.getData();
							if (tsc !=null) {
								boolean isTAFSelected = (PluginCore.units.equalsIgnoreCase("taf") ? true
										: false);
								tsc = unitsConversion(isStorage, tsc, isTAFSelected, k, name);
								HecTime hecStartTime = new HecTime();
								hecStartTime.set(tsc.startTime);
								HecTime ht = new HecTime();
							
								ht.setDate(date);
								int valueIndex = (ht.year() - hecStartTime.year())
											* 12 + (ht.month() - hecStartTime.month());
								if (valueIndex < 0 || valueIndex > tsc.values.length - 1) {
										value = "N/A";
								} else {
									Double value_temp=tsc.values[valueIndex];
									if (Math.abs(value_temp)>100000000) {//empty value
										value="N/A";
									} else {
										value = tsc.values[valueIndex] + " "
												+ tsc.units;
									}
								}
															
								if (PluginCore.mode.equals(PluginCore.diff)) {
									if (j > baseIndex) {
										if (results[baseIndex] == null || results[baseIndex].get(name) == null){
											results[j].put(name,"N/A");
											continue;
										}
										String[] baseFields = results[baseIndex].get(name)
											.split("\\s");
										String[] altFields = value.split("\\s");
										try {
											double baseVal = Double.parseDouble(baseFields[0]);
											double altVal = Double.parseDouble(altFields[0]);
											results[j].put(name, (altVal - baseVal) + " " + baseFields[1]);
										} catch (NumberFormatException nfe) {
											results[j].put(name,"N/A");
										}
									}else {
										results[j].put(name, value);
									}
								} else {
									results[j].put(name, value);
								}
							}else{
								results[j].put(name, value);
							}
						} catch (Exception e) {
							//WPPException.handleException(e);
							results[j].put(name, value);
						}
					}
				}
			}
		}
		return results;
	}
	
	public void calculateLongTermAverage(int pi, String date, String[] tws, boolean isCFS){

		int size = tws.length;
		
		Hashtable<String, Double> _longTermTafToCfsConversionFactors = new Hashtable<String, Double>();

		ArrayList<HashMap<String, Double>> termAverage= new ArrayList<HashMap<String, Double>>();
		if (isCFS){
			PluginCore.longTermAverageDataCFS[pi]=termAverage;
		}else{
			PluginCore.longTermAverageDataTAF[pi]=termAverage;
		}
		
		int index = 0;
		int month = -1;
		int year = -1;

		HecTime startDate = new HecTime();
		HecTime endDate = new HecTime();
		
		String[] split = date.split(" - ");
		startDate.setDate(split[0]); 
		startDate.setTime("0100");

		endDate.setDate(split[1]); 
		endDate.setTime("2400");
		month = endDate.month() + 1;
		year = endDate.year();
		if (month == 13) {
			year = startDate.year() + 1;
		}
		String monthName = TimeOperation.getMonthText(month);
		endDate.setDate(monthName + year);
		endDate.add(-1440);
		
		HecTime ht = new HecTime();
		HecTime hecStartTime = new HecTime();
		HecTime hecEndTime = new HecTime();

		for (int i=0; i<3; i++){
			HashMap<String, Double> altAverage = new HashMap<String, Double>();
			termAverage.add(altAverage);
			
			HashMap<String, HecMath> altSchematicVariableData = PluginCore.allSchematicVariableData[i];
			Set<String> keys=altSchematicVariableData.keySet();
			Iterator<String> it = keys.iterator();
			while (it.hasNext()){
				String name=it.next();
				HecMath dataSet=altSchematicVariableData.get(name);
				boolean isStorage=false;
				try {
					TimeSeriesContainer tsc = (TimeSeriesContainer)dataSet.getData();
					if (PluginCore.allStorageNames.contains(name)) isStorage=true;
					boolean isTAFSelected = (PluginCore.units.equalsIgnoreCase("taf") ? true
							: false);
					tsc=unitsConversion(isStorage, tsc, isTAFSelected, i, name);
					ht.set(startDate);
					hecStartTime.set(tsc.startTime);
					hecEndTime.set(tsc.endTime);
					int count=0;
					double sum=0.0;
					boolean inRange=false;
					while (ht.compareTimes(hecEndTime)<=0 && ht.compareTimes(endDate)<=0){
						if (ht.compareTimes(hecStartTime) >= 0){
							int valueIndex = (ht.year() - hecStartTime
								.year())
								* 12
								+ (ht.month() - hecStartTime
										.month());
							sum += tsc.values[valueIndex];
							count++;
							inRange=true;
						}
						month = -1;
						if (ht.day() > 1) {
							month = ht.month() + 2;
							if (month >= 13) {
								year = ht.year() + 1;
							} else {
								year = ht.year();
							}
							ht.setDate(TimeOperation.getMonthText(month)+
									+ year);
						} else {
							month = ht.month() + 1;
							if (month == 13) {
								year = ht.year() + 1;
							} else {
								year = ht.year();
							}
							ht.setDate(TimeOperation.getMonthText(month)+
									+ year);
						}
						ht.add(-1440); // 86400 advanced ht from October 31,
						// 1921 at 2400 to December 30, 1921
						// at 2400.
					}
					if (inRange) {
						altAverage.put(name, sum/count);
					}
				} catch (HecMathException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	
	public Hashtable<String, String>[] retrieveLongTermAverage(int index, Hashtable<String, Object> names, boolean isCFS){
		
		int size=names.size();
		Hashtable<String, String>[] results = new Hashtable[4];

		for (int i = 0; i < 4; ++i) {
			results[i] = new Hashtable<String, String>();
		}

		int baseIndex=5;
		
		ArrayList<HashMap<String, Double>> termAverage;
		if (isCFS){
			termAverage=PluginCore.longTermAverageDataCFS[index];
		}else{
			termAverage=PluginCore.longTermAverageDataTAF[index];
		}
		
		for (int j = 1; j < 4; j++) {
			int k=j-1;
			if (DebugCorePlugin.selectedStudies[k]){
				if (baseIndex>j){
					baseIndex=j;
				}
				Enumeration<String> variableEnum = names.keys();
				while (variableEnum.hasMoreElements()) {
					String name = variableEnum.nextElement();
					ArrayList<String[]> pathParts = new ArrayList<String[]>();
					CondensedReference found = null;
					boolean isStorage=false;
					if (PluginCore.allStorageNames.contains(name)) isStorage=true;
					String value = "";			
					HashMap<String, Double> altAverage = termAverage.get(k);
					if (altAverage.containsKey(name)){
						double data = altAverage.get(name);
						boolean isTAFSelected = (PluginCore.units.equalsIgnoreCase("taf") ? true
								: false);
						String units;
						if (isCFS){
							units=PluginCore.allSchematicVariableUnitsCFS[k].get(name);
						}else{
							units=PluginCore.allSchematicVariableUnitsTAF[k].get(name);
						}
						if (data>100000000) {
							value="N/A";
						} else {
							value = data + " " + units;
						}
						if (PluginCore.mode.equals(PluginCore.diff)) {
							if (j > baseIndex) {
								if (results[baseIndex] == null || results[baseIndex].get(name) == null){
									results[j].put(name,"N/A");
									continue;
								}
								String[] baseFields = results[baseIndex].get(name)
										.split("\\s");
								String[] altFields = value.split("\\s");
								try {
									double baseVal = Double.parseDouble(baseFields[0]);
									double altVal = Double.parseDouble(altFields[0]);
									results[j].put(name, (altVal - baseVal) + " " + baseFields[1]);
								} catch (NumberFormatException nfe) {
									results[j].put(name,"N/A");
								}
							}else {
								results[j].put(name, value);
							}
						}else {
							results[j].put(name, value);
						}
					}else{
						value="";
						results[j].put(name, value);
					}	
				}	
			}
		}
		return results;
	}
	
	public Hashtable<String, String>[] retrieveDebug(String date, Hashtable<String, Object> names){
		int size=names.size();
		Hashtable<String, String>[] results = new Hashtable[4];

		for (int i = 0; i < 4; ++i) {
			results[i] = new Hashtable<String, String>();
		}

		int baseIndex=5;
		
		Enumeration<String> variableEnum = names.keys();
		for (int j = 1; j < 4; ++j) {
			int k=j-1;
			if (DebugCorePlugin.selectedStudies[k]){
				if (baseIndex>j){
					baseIndex=j;
				}

				while (variableEnum.hasMoreElements()) {
					String name = variableEnum.nextElement();
					ArrayList<String[]> pathParts = new ArrayList<String[]>();
					boolean isStorage=false;
					String value = "";			
					if (PluginCore.allSchematicVariableData[k].containsKey(name)){
						try {
							HecMath dataSet = PluginCore.allSchematicVariableData[k].get(name);
							if (dataSet !=null) {
								if (PluginCore.allStorageNames.contains(name)) isStorage=true;
								TimeSeriesContainer tsc=(TimeSeriesContainer)dataSet.getData();
								boolean isTAFSelected = (PluginCore.units.equalsIgnoreCase("taf") ? true
										: false);
								tsc = unitsConversion(isStorage, tsc, isTAFSelected, k, name);
								HecTime hecStartTime = new HecTime();
								hecStartTime.set(tsc.startTime);
								HecTime ht = new HecTime();
							
								ht.setDate(date);
								int valueIndex = (ht.year() - hecStartTime.year())
											* 12 + (ht.month() - hecStartTime.month());
								if (valueIndex < 0 || valueIndex > tsc.values.length - 1) {
										value = "N/A";
								} else {
									Double value_temp=tsc.values[valueIndex];
									if (Math.abs(value_temp)>100000000) {//empty value
										value="N/A";
									} else {
										value = tsc.values[valueIndex] + " "
												+ tsc.units;
									}
								}
															
								if (PluginCore.mode.equals(PluginCore.diff)) {
									if (j > baseIndex) {
										if (results[baseIndex] == null || results[baseIndex].get(name) == null){
											results[j].put(name,"N/A");
											continue;
										}
										String[] baseFields = results[baseIndex].get(name)
											.split("\\s");
										String[] altFields = value.split("\\s");
										try {
											double baseVal = Double.parseDouble(baseFields[0]);
											double altVal = Double.parseDouble(altFields[0]);
											results[j].put(name, (altVal - baseVal) + " " + baseFields[1]);
										} catch (NumberFormatException nfe) {
											results[j].put(name,"N/A");
										}
									}else {
										results[j].put(name, value);
									}
								} else {
									results[j].put(name, value);
								}
							}else{
								results[j].put(name, value);
							}
						} catch (Exception e) {
							WPPException.handleException(e);
						}
						
					}
				}
			}
		}
		return results;
	}
	
	public void setValues(int index, Hashtable<String, Object> visibleNodes, Hashtable<String, String>[] values){
		try {
			diagramView.suspendRepaint();
			synchronized (diagramView) {
				for (int studyId = 0; studyId < values.length; studyId++) {
					Hashtable<String, String> valuesInStudy = values[studyId];
					for (String name : valuesInStudy.keySet()) {
						Object object = visibleNodes.get(name);
						if (object == null) {
							continue;
						}
						String value = valuesInStudy.get(name);
						value = truncateAfterDecimal(value, precision,
								true);
						if (object instanceof ShapeNode) {
							ShapeNode shapeNode = (ShapeNode) object;
							Group subordinateGroup = shapeNode
									.getSubordinateGroup();
							DiagramNode diagramNode = null;
							if (subordinateGroup != null) {
								DiagramNodeList attachedNodes = subordinateGroup
										.getAttachedNodes();
								if (studyId > attachedNodes.size() - 1) {
									diagramNode = createTextNodeWithIntermediates(
											studyId, attachedNodes.size(),
											shapeNode);
								} else {
									diagramNode = attachedNodes.get(studyId);
								}
							} else {
								diagramNode = createTextNodeWithIntermediates(
										studyId, 0, shapeNode);
//								diagramNode = createTextNode(studyId, shapeNode);
							}
							if (diagramNode != null) {
								diagramNode.setEditedText(value);
								if (PluginCore.mode.equals(PluginCore.diff) && studyId > 0) {
									((ShapeNode) diagramNode)
											.setTextColor(Color.red);
								} else {
									((ShapeNode) diagramNode)
									.setTextColor(Color.black);
								}
								((ShapeNode) diagramNode)
										.setToolTip(getToolTip(index, studyId, PluginCore.mode.equals(PluginCore.diff)));
							}
						}
					}
				}
			}
		} finally {
			diagramView.resumeRepaint();
		}
	}
	
	public 	void clearValueBoxes(Float visibleRect) {
		if (visibleRect == null) {
			return;
		}
		Hashtable<String, Object> visibleNodes = getVisibleNodes(visibleRect);
		DiagramNodeList nodes = diagram.getNodes();
		for (Object o : visibleNodes.values()) {
			if (o instanceof ShapeNode) {
				ShapeNode shapeNode = (ShapeNode) o;
				Object id = shapeNode.getId();
				if (id != null && id.equals(VALUE_TEXT)) {
					shapeNode.setText("");
					// nodes.remove(shapeNode);
				}
			}
		}
	}

	public Hashtable<String, Object> getVisibleNodes(
			Rectangle2D.Float visibleRect) {
		Hashtable<String, Object> variables = new Hashtable<String, Object>();
		Iterable<ShapeNode> items = diagram.items(ShapeNode.class);
		for (ShapeNode item : items) {
			if (!item.getBounds().intersects(visibleRect))
				continue;
			if (item.getTransparent()) {// ignore transparent text nodes
				continue;
			}
			variables.put(((ShapeNode) item).getTextToEdit(), item);
		}
		return variables;

	}
	
	private ShapeNode createTextNodeWithIntermediates(int studyId,
			int startingWithId, ShapeNode shapeNode) {
		ShapeNode textNode = null;
		for (int id = startingWithId; id <= studyId; id++){
			textNode = createTextNode(id, shapeNode);
		}
		return textNode;
	}
	
	private ShapeNode createTextNode(int studyId, ShapeNode shapeNode) {
		Float r = shapeNode.getBounds();
		Rectangle2D.Float r2 = null;
		TextFormat tf = null;
		int attachPos = AttachToNode.BottomLeft;
		switch (studyId) {
		case 1:
			attachPos = AttachToNode.BottomRight;
			r2 = new Rectangle2D.Float(r.x + r.width / 2, r.y + r.height / 2,
					r.width / 2, r.height / 2);
			tf = new TextFormat(Align.Far, Align.Far);
			break;
		case 2:
			attachPos = AttachToNode.TopLeft;
			r2 = new Rectangle2D.Float(r.x, r.y, r.width / 2, r.height / 2);
			tf = new TextFormat(Align.Near, Align.Near);
			break;
		case 3:
			attachPos = AttachToNode.TopRight;
			r2 = new Rectangle2D.Float(r.x + r.width / 2, r.y, r.width / 2,
					r.height / 2);
			tf = new TextFormat(Align.Far, Align.Near);
			break;
		default:
			attachPos = AttachToNode.BottomLeft;
			r2 = new Rectangle2D.Float(r.x, r.y + r.height / 2, r.width / 2,
					r.height / 2);
			tf = new TextFormat(Align.Near, Align.Far);
			break;
		}

		ShapeNode transparentTextNode = diagram.getFactory()
				.createShapeNode(r2);
		transparentTextNode.setId(VALUE_TEXT);
		transparentTextNode.setTransparent(true);
		transparentTextNode.setLocked(true);
		transparentTextNode.setFont(shapeNode.getFont());
		transparentTextNode.setPen(shapeNode.getPen());
		transparentTextNode.setBrush(shapeNode.getBrush());
		transparentTextNode.setTextFormat(tf);
		transparentTextNode.attachTo(shapeNode, attachPos);
		return transparentTextNode;
	}
	
	private String truncateAfterDecimal(String value, int i,
			boolean displayUnits) {
		if (value == null) {
			return null;
		}
		String[] fields = value.split("\\s");
		if (fields.length < 2) {
			return value;
		}
		return String.format("%." + i + "f %s", Double.parseDouble(fields[0]),
				displayUnits ? fields[1] : "");
	}
	
	public static String getToolTip(int index, int studyId, boolean isDiff) {
		if (index==0){
			switch (studyId) {
			case 0:
				return "";
			case 1:
				return "Alt 1";
			case 2:
				return isDiff ? "Alt 2 - Alt 1" : "Alt 2";
			case 3:
				return isDiff ? "Alt 3 - Alt 2" : "Alt 3";
			}
			return "";
		}else{	
			switch (studyId) {
			case 0:
				return "Debug";
			case 1:
				return isDiff ? "Alt 1 - Debug" : "Alt 1";
			case 2:
				return isDiff ? "Alt 2 - Debug" : "Alt 2";
			case 3:
				return isDiff ? "Alt 3 - Bebug" : "Alt 3";
			}
			return "";
		}
	}
	
	public TimeSeriesContainer unitsConversion(boolean isStorage, TimeSeriesContainer dataSet, boolean force, int index, String name) {

		if ((PluginCore.units.equals("TAF") || force || isStorage)
				&& dataSet.units.equals("CFS")) {
			// CB dataSet = adjustMonthlyData(dataSet, 1.9834631 / 1000.);
			dataSet = adjustMonthlyData(dataSet, true); // CB added constant IV FACTOR
			// so do not need to pass a
			// factor
			dataSet.units="TAF";
			PluginCore.allSchematicVariableUnitsTAF[index].put(name, "TAF");

		} else if (PluginCore.units.equals("CFS") && dataSet.units.equals("TAF")
				&& !force && !isStorage) { // CB added section
			dataSet = adjustMonthlyData(dataSet, false); // CB added constant IV
			// FACTOR so do not
			// need to pass a
			// factor
			dataSet.units="CFS";
			PluginCore.allSchematicVariableUnitsCFS[index].put(name, "CFS");
		}
		return dataSet;
	}
	
	public TimeSeriesContainer adjustMonthlyData(TimeSeriesContainer tsc, boolean isCFStoTAF) { // CB added
		// the
		// boolean
		// and
		// made
		// a
		// constant
		// IV
		// factor
		HecTime ht = null;
		try {
			double[] nvalues = new double[tsc.values.length];
			int[] times = tsc.times;
			int ndays = 0;
			ht = new HecTime();
			for (int i = 0; i < times.length; i++) {
				ht.set(times[i]);
				// FIX: subtract 1 min
				ht.add(-1);
				ndays = ht.day();
				/*
				 * HecTime BUG: sometimes ht.day() returns a day later than *
				 * should???? I wasted a lot of time on this!!
				 * 
				 * returns ht.day() == 1, ht.hour() == 0 AS OPPOSED TO ht.day()
				 * == 28,30,31 (depending on month), ht.hour() == 24
				 */

				// if (DEBUG) System.out.println(ht.year()+" "+ht.month()+
				// " "+ht.day()+ht.hour()+" "+ht.minute()+" "+ht.second()+" "+times[i]+"
				// "+values[i]);
				// CB nvalues[i] = tsc.values[i] * ndays * factor;
				if (isCFStoTAF) {
					nvalues[i] = tsc.values[i] * ndays / FACTOR;
				} else {
					nvalues[i] = tsc.values[i] / ndays * FACTOR;
				}
			}
			tsc.values = nvalues;
		} catch (Exception e) {
			System.out.println("Exception adjustMonthlyData: " + e);
		}
		return tsc;
	}
	
	public void collectAllSchematicVariables(){
		Hashtable<String, Object> allNodes = getVisibleNodes(diagram.getBounds());
		
		PluginCore.allSchematicVariableNames = new ArrayList<String>();
		for (String v : allNodes.keySet()) {
			PluginCore.allSchematicVariableNames.add(v);
		}
	}
	
	public void loadAllSchematicVariableData(){
		PluginCore.allSchematicVariableUnitsCFS=new HashMap[3];
		PluginCore.allSchematicVariableUnitsTAF=new HashMap[3];
		PluginCore.longTermAverageDataCFS=new ArrayList[8];
		PluginCore.longTermAverageDataTAF=new ArrayList[8];
		PluginCore.allSchematicVariableData = new HashMap[3];
		for (int kk=0; kk<3; kk++){
			HashMap<String, HecMath> data= new HashMap<String, HecMath>();
			PluginCore.allSchematicVariableData[kk]=data;
			HashMap<String, String> cfsUnitsMap = new HashMap<String, String>();
			PluginCore.allSchematicVariableUnitsCFS[kk]=cfsUnitsMap;
			HashMap<String, String> tafUnitsMap = new HashMap<String, String>();
			PluginCore.allSchematicVariableUnitsTAF[kk]=tafUnitsMap;
			
			if (DebugCorePlugin.selectedStudies[kk]){
				if (DebugCorePlugin.dvDss[kk] !=null){
					DebugCorePlugin.dvDss[kk].setTimeWindow(DebugCorePlugin.timeWindow);
				}
				if (DebugCorePlugin.svDss[kk] !=null){
					DebugCorePlugin.svDss[kk].setTimeWindow(DebugCorePlugin.timeWindow);
				}
			}		
		}
		
		int size = PluginCore.allSchematicVariableNames.size();
		for (int j=0; j<size; j++) {
			String name = PluginCore.allSchematicVariableNames.get(j);
			if (PluginCore.allPathName.containsKey(name)){
				String pathName = PluginCore.allPathName.get(name);
				for (int i=0; i<3; i++){
					if (DebugCorePlugin.selectedStudies[i]){
						HecMath dataSet=null;
						HecDss dvFile = DebugCorePlugin.dvDss[i];
						HecDss svFile = DebugCorePlugin.svDss[i];
						if (dvFile != null){
							try {
								dataSet = dvFile.read(pathName);
								if (dataSet ==null){
									readFromSV(svFile, pathName, name, i);
									continue;
								}else{
									PluginCore.allSchematicVariableData[i].put(name, dataSet);
									PluginCore.allSchematicVariableUnitsCFS[i].put(name, dataSet.getUnits());
									PluginCore.allSchematicVariableUnitsTAF[i].put(name, dataSet.getUnits());
									continue;
								}
							} catch (Exception e) {
								readFromSV(svFile, pathName, name, i);
							}
						}else{
							readFromSV(svFile, pathName, name, i);
						}
					}
				}
			}
		}
	}
	
	public void readFromSV(HecDss svFile, String pathName, String name, int i){
		try {
			HecMath dataSet = svFile.read(pathName);
			if (dataSet !=null){
				PluginCore.allSchematicVariableData[i].put(name, dataSet);
				PluginCore.allSchematicVariableUnitsCFS[i].put(name, dataSet.getUnits());
				PluginCore.allSchematicVariableUnitsTAF[i].put(name, dataSet.getUnits());
			}
		} catch (Exception e) {
		}
	}
	
	public boolean findInView(String text) {
		if (diagram == null || text == null) {
			return false;
		}
		text = text.toLowerCase();
		DiagramNodeList nodes = diagram.getNodes();
		int n_node=nodes.size();
//		for (DiagramNode n : nodes) {	
//			String nodeText = n.getTextToEdit();
		for (int i_node = 1; i_node <= n_node; i_node++){
			int index_currentnode = (i_node + index_lastnode) % n_node;
			DiagramNode n = nodes.get(index_currentnode);
			String nodeText = n.getTextToEdit();
			if (nodeText != null && nodeText.toLowerCase().contains(text)) {
				diagramView.bringIntoView(n);
				index_lastnode = index_currentnode;
				return true;
			}
		}
		return false;
	}
}
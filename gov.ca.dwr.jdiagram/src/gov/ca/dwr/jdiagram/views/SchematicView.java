package gov.ca.dwr.jdiagram.views;

import gov.ca.dwr.jdiagram.Activator;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
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

import com.mindfusion.diagramming.Behavior;
import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramAdapter;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.diagramming.DiagramLink;
import com.mindfusion.diagramming.DiagramLinkList;
import com.mindfusion.diagramming.DiagramNode;
import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.LinkEvent;
import com.mindfusion.diagramming.NodeEvent;
import com.mindfusion.diagramming.Overview;
import com.mindfusion.diagramming.ShapeNode;

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
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane);
		diagramView = new DiagramView(diagram = new Diagram());
		diagramView.setAllowInplaceEdit(false);
		diagramView.setBehavior(Behavior.DoNothing);
		getSite().setSelectionProvider(
				selectionProvider = new DiagramSelectionProvider());
		diagram.addDiagramListener(new DiagramAdapter() {

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

		});
		layeredPane.add(new JScrollPane(diagramView));
		Overview overview = new Overview();
		overview.setDiagramView(diagramView);
		layeredPane.add(overview,1);
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
					if (file.endsWith(".xml")) {
						diagram.loadFromXml(file);
					} else {
						diagram.loadFrom(file);
					}
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
}
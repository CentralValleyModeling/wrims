package gov.ca.dwr.hecdssvue.views;

import gov.ca.dwr.hecdssvue.PluginCore;
import gov.ca.dwr.hecdssvue.panel.MonthlyTablePanel;
import gov.ca.dwr.hecdssvue.panel.OpsPanel;
import hec.gfx2d.G2dMouseAdapter;
import hec.gfx2d.G2dObject;
import hec.gfx2d.G2dPanel;
import hec.gfx2d.G2dZoomAdapter;
import hec.gfx2d.PairedDataSet;
import hec.gfx2d.TimeSeriesDataSet;
import hec.gfx2d.Viewport;
import hec.hecmath.DSSFile;
import hec.hecmath.HecMath;
import hec.io.DataContainer;
import hec.io.PairedDataContainer;
import hec.io.TimeSeriesContainer;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.swt.widgets.Composite;

/**
 * Displays a plot in a view based on selection on DSS Catalog View
 * 
 * @author psandhu
 * 
 */
public class DSSMonthlyView extends AbstractDSSView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.hecdssvue.views.DSSOpsView";
	private MonthlyTablePanel monthly;

	/**
	 * The constructor.
	 */
	public DSSMonthlyView() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	/**
	 * Show plot for selected 
	 */
	public void showSelected(final Vector<DataContainer> dataVector) {
		loadMonthlyTable(PluginCore.annualType, dataVector);
		monthly.getTable().setupModel();
		monthly.showTable();
		contentPane.invalidate();
		contentPane.doLayout();
		contentPane.repaint();
	}
	
	public void createPartControl(Composite parent){
		super.createPartControl(parent);
		monthly = new MonthlyTablePanel();
		contentPane.add(monthly);
	}

	public void loadMonthlyTable(int annualType, Vector<DataContainer> dataVector) {

		int firstPossibleMonth;
		
		if (annualType == PluginCore.WATERYEAR) {
			firstPossibleMonth = 0;
		} else if (annualType == PluginCore.CALENDAR_YEAR) {
			firstPossibleMonth = 3;
		} else if (annualType == PluginCore.FEDERAL_CONTRACT_YEAR) {
			firstPossibleMonth = 5;
		} else {
			return;
		}
		
		monthly.setData(dataVector, firstPossibleMonth);
	}
	
}
package gov.ca.dwr.hecdssvue.views;

import hec.gfx2d.G2dObject;
import hec.gfx2d.G2dPanel;
import hec.gfx2d.PairedDataSet;
import hec.gfx2d.TimeSeriesDataSet;
import hec.io.DataContainer;
import hec.io.PairedDataContainer;
import hec.io.TimeSeriesContainer;

import java.util.Iterator;
import java.util.Vector;

/**
 * Displays a plot in a view based on selection on DSS Catalog View
 * 
 * @author psandhu
 * 
 */
public class DSSPlotView extends AbstractDSSView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.hecdssvue.views.DSSPlotView";
	G2dPanel plot;

	/**
	 * The constructor.
	 */
	public DSSPlotView() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	/**
	 * Show plot for selected 
	 */
	public void showSelected(Vector<DataContainer> dataVector) {
		if (plot != null) {
			//plot.clearPanel();
		}
		if (plot == null) {
			plot = new G2dPanel();
			//plot.setPaintEnabled(false);
			//plot.setDebugGraphicsOptions(DebugGraphics.FLASH_OPTION);
			contentPane.add(plot);
		}
		G2dObject g2dObj = null;
		Vector g2dataVector = new Vector();
		for (Iterator iterator = dataVector.iterator(); iterator.hasNext();) {
			DataContainer data = (DataContainer) iterator.next();
			if (data instanceof TimeSeriesContainer) {
				TimeSeriesDataSet ts = new TimeSeriesDataSet(
						(TimeSeriesContainer) data);
				if (((TimeSeriesContainer) data).timeZoneID != null) {
					ts.setGmtOffset(((TimeSeriesContainer) data).timeZoneRawOffset
							/ (1000 * 60 * 60));
				}
				g2dObj = ts;
			} else if (data instanceof PairedDataContainer) {
				PairedDataSet pd = new PairedDataSet((PairedDataContainer) data);
				g2dObj = pd;
			}
			if (g2dObj == null) {
				return;
			}
			g2dataVector.add(g2dObj);

		}
		plot.buildComponents(g2dataVector, false, true);
	}
}
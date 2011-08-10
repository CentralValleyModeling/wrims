package gov.ca.dwr.hecdssvue.views;

import hec.dataTable.HecDataTable;
import hec.io.DataContainer;

import java.util.Vector;

import javax.swing.JScrollPane;

/**
 * Displays a table view of data based on selection on DSSCatalogView
 * <p>
 */

public class DSSTableView extends AbstractDSSView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "gov.ca.dwr.hecdssvue.views.DSSTableView";
	JScrollPane pane;
	HecDataTable table;

	/**
	 * The constructor.
	 */
	public DSSTableView() {
	}

	@Override
	/**
	 * Show plot for selected 
	 */
	protected void showSelected(Vector<DataContainer> dataVector) {
		if (dataVector != null && dataVector.size() > 0) {
			contentPane.removeAll();
			table = new HecDataTable(contentPane);
			table.setDateTimeAsTwoColumns(false);
			table.setData(dataVector, true, 0);
			contentPane.add(new JScrollPane(table));
			contentPane.invalidate();
			contentPane.doLayout();
			contentPane.repaint();
		}
	}

}
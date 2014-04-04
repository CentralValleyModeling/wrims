package gov.ca.dwr.hecdssvue.components;

import java.awt.GridBagLayout;

import rma.util.PlugInLoader;
import hec.dssgui.ListSelection;

public class CatalogListSelection extends ListSelection {

	public CatalogListSelection() {
		_mode = FULL_FUNCTION;
		setup(true);
	}

	protected void setup(boolean useTabbedPane)
	{
		String debug = System.getProperty("debug", "false");
		if (!debug.equalsIgnoreCase("false"))
			ListSelection.debug = true;
		setupParameters();
		_useTabbedPane = useTabbedPane;
		build();
		loadPlugins(this);
	}
	
	protected void build()
	{
		GridBagLayout gridBagLayout;
		gridBagLayout = new GridBagLayout();
		getContentPane().setLayout(gridBagLayout);

		buildToolBar();
		buildFilenamePanel();
		if (miScripts != null) {
			buildScriptButtons();
		}

		if (_titleName.length() == 0)
			setTitle(_programName);
	}
	
	private void loadPlugins(ListSelection selection)
	{
		// System.out.println("DssVue test mode only!!!");
		// plugins.Fix1MinPlugin x = new plugins.Fix1MinPlugin();
		// hec.dssgui.plugins.metaData.DssMetaDataPlugin x = new
		// hec.dssgui.plugins.metaData.DssMetaDataPlugin();
		// hec.dssgui.plugins.Excel x = new hec.dssgui.plugins.Excel();
		// hec.dssgui.plugins.TideMeans x = new hec.dssgui.plugins.TideMeans();
		// hec.dssgui.plugins.Peaks x = new hec.dssgui.plugins.Peaks();
		//hec.dssgui.plugins.Test x = new hec.dssgui.plugins.Test();
		 //hec.dssgui.plugins.usgs.UsgsControlPlugin y = new hec.dssgui.plugins.usgs.UsgsControlPlugin();
		// hec.dssgui.plugins.cdec.CdecControlPlugin x = new
		// hec.dssgui.plugins.cdec.CdecControlPlugin();
		 //hec.dssgui.plugins.NcdcImportPlugin y = new hec.dssgui.plugins.NcdcImportPlugin();
		 //hec.dssgui.plugins.DssutlImportPlugin x = new
		 //hec.dssgui.plugins.DssutlImportPlugin();
		 //hec.dssgui.plugins.WaterML x = new hec.dssgui.plugins.WaterML();
		 //hec.dssgui.plugins.riverGages.RiverGagesControlPlugin x = new hec.dssgui.plugins.riverGages.RiverGagesControlPlugin();
		 //Object j[] = new Object[1]; j[0] = selection; x.main(j);
		 //hec.dssgui.plugins.ImportWizardPlugin x = new
		//	 hec.dssgui.plugins.ImportWizardPlugin();
		 //Object j[] = new Object[1]; j[0] = selection; x.main(j);
		 //Object j1[] = new Object[1]; j1[0] = selection; y.main(j);
		 /***********************************************************************
		  * Object j[] = new Object[1]; j[0] = selection; x.main(j); /*
		 * hec.dssgui.plugins.Excel y = new hec.dssgui.plugins.Excel(); Object
		 * k[] = new Object[1]; k[0] = selection; y.main(k); /* /
		 * hec.dssgui.plugins.chart.ChartPlugin y = new
		 * hec.dssgui.plugins.chart.ChartPlugin(); Object k[] = new Object[1];
		 * k[0] = selection; y.main(k); /
		 **********************************************************************/

		PlugInLoader.loadPlugIns("HecDssVuePlugin", new Object[] {selection});
		addPluginMenus();
	}
	
}

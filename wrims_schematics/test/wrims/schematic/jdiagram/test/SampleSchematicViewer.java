package wrims.schematic.jdiagram.test;

import hec.gfx2d.G2dDialog;
import hec.heclib.dss.HecDss;
import hec.io.DataContainer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JToolBar;

import wrims.schematic.element.Element;
import wrims.schematic.jdiagram.ElementTask;
import wrims.schematic.jdiagram.SchematicViewer;

public class SampleSchematicViewer {
	public static void main(String[] args) {
		final SchematicViewer view = new SchematicViewer();
		try {
			view
					.load("resources/wrims/schematic/CS3_NetworkSchematic_20110824.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}

		view.setClickTask(new ElementTask() {

			@Override
			public void run(Element el) {
				ArrayList<Element> list = new ArrayList<Element>(Arrays
						.asList(el));
				showPlotForAll(list);
			}

			private void showPlotForAll(ArrayList<Element> list) {
				G2dDialog dialog = new G2dDialog();
				for (Element el : list) {
					DataContainer dataContainer = getData(el.getName());
					if (dataContainer != null) {
						dialog.addData(dataContainer);
					}
				}
				dialog.showPlot();
			}

			private DataContainer getData(String name) {
				DataContainer dataContainer = null;
				try {
					String dssFileName = "d:/calsim3/VERSION42_081811_DV.dss";
					dataContainer = getDataForBPart(dssFileName, name);
					if (dataContainer == null) {
						dataContainer = getDataForBPart(
								"d:/calsim3/CalSim30_06_SV.dss", name);
					}
				} catch (Exception ex) {

				}
				return dataContainer;
			}

			private DataContainer getDataForBPart(String dssFileName,
					String name) throws Exception {
				HecDss dss = HecDss.open(dssFileName, true);
				try {
					Vector catalogedPathnames = dss.getCatalogedPathnames("B="
							+ name);
					if (catalogedPathnames == null
							|| catalogedPathnames.size() == 0) {
						return null;
					}
					String pathname = (String) catalogedPathnames.get(0);
					return dss.get(pathname, true);
				} finally {
					dss.close();

				}
			}
		});

		JToolBar bar = new JToolBar();
		bar.add(view.getZoomInAction());
		bar.add(view.getZoomOutAction());

		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = fr.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(BorderLayout.PAGE_START, bar);
		contentPane.add(view);
		fr.pack();
		fr.setSize(800, 600);
		fr.setVisible(true);
	}
}

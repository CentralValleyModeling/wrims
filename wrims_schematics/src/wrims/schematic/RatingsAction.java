package wrims.schematic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//
// depending on the current context.
/**
 * Define an Action that knows about ...
 * @author Clay Booher
 */
public class RatingsAction extends ContainerRelatedAction {
	
	public RatingsAction(Container app) {
		super("Ratings", app);
	}

	public RatingsAction(Icon icon, Container app) {
		super("Ratings", icon, app);
	}

	public SchematicView getView() {
		if (getApp() != null && getApp() instanceof Schematic) {
			return ((Schematic)getApp()).getCurrentView();
		} else return null;
	}

	public Plotter getPlotter() {
		if (getApp() != null && getApp() instanceof Schematic) {
			return ((Schematic)getApp()).getPlotter();
		} else return null;
	}

	public boolean canAct() {
		return getApp() != null && getApp() instanceof Schematic
			&& ((Schematic)getApp())._DssFrame != null;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (canAct()) {
			if (((Schematic)getApp())._DssFrame.getFP().filterByBpart
					(getPlotter().parseSelection(((((Schematic)getApp()).getCurrentView()
							.getSelection()))))) {
				String outputType = "";
				String variableType = "";
				if (e.getSource() instanceof JMenuItem) {
					outputType = ((JMenuItem)e.getSource()).getText();
					if (((JMenuItem)e.getSource()).getParent() instanceof JPopupMenu) {
						Component invoker = ((JPopupMenu)((JMenuItem)e.getSource())
							.getParent()).getInvoker();
						if (invoker instanceof JMenu)
							variableType = ((JMenu)invoker).getText();
					}
				}
//				actionPerfomedHelper(outputType, variableType);  //CB in progress?
			} else { //CB added else block
				JOptionPane.showMessageDialog(((Schematic)getApp())._DssFrame,
					"No variables in dss files that match any of the selected items",
					"Match Not Found", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}

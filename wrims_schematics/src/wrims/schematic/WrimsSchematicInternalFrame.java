package wrims.schematic;

import javax.swing.JInternalFrame;

/**
 * @author Clay Booher
 */
public class WrimsSchematicInternalFrame extends JInternalFrame {

	SchematicView _view;

	public WrimsSchematicInternalFrame(SchematicView view) {
		super(view.getName(),  true, true, true);
//		System.out.println(view.getName());
		_view = view;
	}

	public WrimsSchematicInternalFrame(SchematicView view, boolean resizable, boolean closable,
			boolean maximizable) {
		super(view.getName(), resizable, closable, maximizable);
	}

	SchematicView getView() {
		return _view;
	}
}

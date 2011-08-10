package gov.ca.dwr.jdiagram;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {
	public static String PLUGIN_ID = "gov.ca.dwr.jdiagram";
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/**
	 * Returns an image descriptor for images in the plug-in path.
	 * 
	 * @param path
	 *        the path
	 * @return the axisImage descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + path); //$NON-NLS-1$
	}

}

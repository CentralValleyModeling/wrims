package gov.ca.dwr.wresl.xtext.editor.ui.texthover;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

public class WreslEObjectHoverProvider extends DefaultEObjectHoverProvider {
	@Override
	protected String getFirstLine(EObject o) {
		if (o instanceof DVar) {
			return ((DVar)o).toString();
		}
		return super.getFirstLine(o);
	}

}

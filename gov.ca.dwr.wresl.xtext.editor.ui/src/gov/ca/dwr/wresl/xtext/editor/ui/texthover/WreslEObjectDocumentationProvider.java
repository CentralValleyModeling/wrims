package gov.ca.dwr.wresl.xtext.editor.ui.texthover;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

public class WreslEObjectDocumentationProvider implements
		IEObjectDocumentationProvider {
	
	public String getDocumentation(EObject o) {
		if (o instanceof DVar) {
			return "This is a dvar";
		}
		return null;
	}


}

package gov.ca.dwr.wresl.xtext.editor.ui.texthover;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DefineImpl;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalImpl;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.IdentImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

public class WreslEObjectDocumentationProvider implements
		IEObjectDocumentationProvider {
	
	public String getDocumentation(EObject o) {
		if (o instanceof DefineImpl){
			String name=((DefineImpl) o).getName();
			return "value : ";
		}else if (o instanceof GoalImpl){
			String name=((GoalImpl) o).getName();
			return "goal : ";
		}else if (o instanceof IdentImpl){
			return "value : ";
		}else{
			return null;
		}
	}


}

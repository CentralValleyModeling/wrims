/*
 * generated by Xtext
 */
package gov.ca.dwr.wresl.xtext.editor.ui.labeling;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ConstDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IfIncItems;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Initial;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVar;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SvarDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see
 * http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class WreslEditorLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public WreslEditorLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:

	String text(WreslEvaluator e) {
		return "Wresl";
	}

	String image(WreslEvaluator e) {
		return "outline_wresl.gif";
	}
	
	String text(Initial e){
		return "initial";
	}
	
	String image(Initial e){
		return "outline_sequence.gif";
	}
	
	String text(Sequence e){
		return e.getName();
	}
	
	String image(Sequence e){
		return "outline_sequence.gif";
	}
	
	String text(Model e){
		return e.getName();
	}
	
	String image(Model e){
		return "outline_model.gif";
	}

	String text(Goal e) {
		return e.getName();
	}

	String image(Goal e) {
		return "outline_goal.gif";
	}
	
	String text(SvarDef e) {
		return e.getName();
	}

	String image(SvarDef e) {
		EObject definition = e.getDefinition();
		if (definition instanceof SVar) {
			if (definition instanceof SVarDSS) {
				return "outline_svar_timeseries.gif";
			} else {
				return "outline_svar.gif";
			}
		}
		return "outline_define.gif";
	}

	String text(ConstDef e) {
		return e.getName();
	}

	String image(ConstDef e) {
		return "outline_svar.gif";	
	}
	
	String text(ExternalDef e) {
		return e.getName();
	}

	String image(ExternalDef e) {
		return "outline_define.gif";  //To Do: Change to external function icon	
	}
	
	String text(Alias e) {
		return e.getName();
	}

	String image(Alias e) {
		return "outline_alias.gif";
	}

	String text(IncludeFile e) {
		return e.getFile();
	}

	String image(IncludeFile e){
		return "outline_include.gif";
	}
}

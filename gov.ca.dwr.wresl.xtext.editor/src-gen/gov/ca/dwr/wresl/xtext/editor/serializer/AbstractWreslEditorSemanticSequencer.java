package gov.ca.dwr.wresl.xtext.editor.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import gov.ca.dwr.wresl.xtext.editor.services.WreslEditorGrammarAccess;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.AbsFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Add;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Condition;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ConditionalTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ConstDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarNonStd;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarStd;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Declaration;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.DvarDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ElseIfTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ElseTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.External;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalSimple;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Ident;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IfTerm;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Initial;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.IntFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsGtRhs;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsLtRhs;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LogFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.LogicalExpression;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Lower;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.MaxFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.MinFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ModFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Multiply;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Penalty;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.PowFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarCase;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarExpression;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarSum;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarTable;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SvarDef;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Term;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.TimeArraySize;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Upper;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ValueContent;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WhereItems;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.lowerUpper;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.upperLower;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractWreslEditorSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private WreslEditorGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == WreslEditorPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case WreslEditorPackage.ABS_FUNCTION:
				if(context == grammarAccess.getAbsFunctionRule() ||
				   context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_AbsFunction(context, (AbsFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ADD:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule() ||
				   context == grammarAccess.getVarModelStepRule()) {
					sequence_Add(context, (Add) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ALIAS:
				if(context == grammarAccess.getAliasRule() ||
				   context == grammarAccess.getDecisionVariableRule() ||
				   context == grammarAccess.getPatternRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_Alias(context, (Alias) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ASSIGNMENT:
				if(context == grammarAccess.getAssignmentRule()) {
					sequence_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CASE_CONTENT:
				if(context == grammarAccess.getCaseContentRule()) {
					sequence_CaseContent(context, (CaseContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONDITION:
				if(context == grammarAccess.getConditionRule()) {
					sequence_Condition(context, (Condition) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONDITIONAL_TERM:
				if(context == grammarAccess.getConditionalTermRule() ||
				   context == grammarAccess.getConditionalUnaryRule()) {
					sequence_ConditionalTerm(context, (ConditionalTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONST_DEF:
				if(context == grammarAccess.getConstDefRule() ||
				   context == grammarAccess.getPatternRule() ||
				   context == grammarAccess.getStateVariableRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_ConstDef(context, (ConstDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.CONSTRAINT:
				if(context == grammarAccess.getConstraintRule()) {
					sequence_Constraint(context, (Constraint) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_INTEGER_STD:
				if(context == grammarAccess.getDVarIntegerRule() ||
				   context == grammarAccess.getDVarIntegerStdRule()) {
					sequence_DVarIntegerStd(context, (DVarIntegerStd) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_NON_STD:
				if(context == grammarAccess.getDVarRule() ||
				   context == grammarAccess.getDVarNonStdRule()) {
					sequence_DVarNonStd(context, (DVarNonStd) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_STD:
				if(context == grammarAccess.getDVarRule() ||
				   context == grammarAccess.getDVarStdRule()) {
					sequence_DVarStd(context, (DVarStd) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DECLARATION:
				if(context == grammarAccess.getDeclarationRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Declaration(context, (Declaration) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.DVAR_DEF:
				if(context == grammarAccess.getDecisionVariableRule() ||
				   context == grammarAccess.getDvarDefRule() ||
				   context == grammarAccess.getPatternRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_DvarDef(context, (DvarDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ELSE_IF_TERM:
				if(context == grammarAccess.getElseIfTermRule()) {
					sequence_ElseIfTerm(context, (ElseIfTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.ELSE_TERM:
				if(context == grammarAccess.getElseTermRule()) {
					sequence_ElseTerm(context, (ElseTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.EXTERNAL:
				if(context == grammarAccess.getExternalRule()) {
					sequence_External(context, (External) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.EXTERNAL_DEF:
				if(context == grammarAccess.getExternalDefRule() ||
				   context == grammarAccess.getPatternRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_ExternalDef(context, (ExternalDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.EXTERNAL_FUNCTION:
				if(context == grammarAccess.getExternalFunctionRule() ||
				   context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_ExternalFunction(context, (ExternalFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL:
				if(context == grammarAccess.getGoalRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Goal(context, (Goal) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_CASE:
				if(context == grammarAccess.getGoalCaseRule()) {
					sequence_GoalCase(context, (GoalCase) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_CASE_CONTENT:
				if(context == grammarAccess.getGoalCaseContentRule()) {
					sequence_GoalCaseContent(context, (GoalCaseContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_NO_CASE_CONTENT:
				if(context == grammarAccess.getGoalNoCaseContentRule()) {
					sequence_GoalNoCaseContent(context, (GoalNoCaseContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.GOAL_SIMPLE:
				if(context == grammarAccess.getGoalSimpleRule()) {
					sequence_GoalSimple(context, (GoalSimple) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.IDENT:
				if(context == grammarAccess.getIdentRule()) {
					sequence_Ident(context, (Ident) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.IF_TERM:
				if(context == grammarAccess.getIfIncItemsRule()) {
					sequence_IfIncItems_IfTerm(context, (IfTerm) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getIfTermRule()) {
					sequence_IfTerm(context, (IfTerm) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.INCLUDE_FILE:
				if(context == grammarAccess.getIncludeFileRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_IncludeFile(context, (IncludeFile) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.INITIAL:
				if(context == grammarAccess.getInitialRule()) {
					sequence_Initial(context, (Initial) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.INT_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getIntFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_IntFunction(context, (IntFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LHS_GT_RHS:
				if(context == grammarAccess.getLhsGtRhsRule()) {
					sequence_LhsGtRhs(context, (LhsGtRhs) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LHS_LT_RHS:
				if(context == grammarAccess.getLhsLtRhsRule()) {
					sequence_LhsLtRhs(context, (LhsLtRhs) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOG_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getLogFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_LogFunction(context, (LogFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOGICAL_EXPRESSION:
				if(context == grammarAccess.getConditionalTermRule() ||
				   context == grammarAccess.getConditionalUnaryRule() ||
				   context == grammarAccess.getLogicalExpressionRule()) {
					sequence_LogicalExpression(context, (LogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOWER:
				if(context == grammarAccess.getLowerRule()) {
					sequence_Lower(context, (Lower) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MAX_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getMaxFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_MaxFunction(context, (MaxFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MIN_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getMinFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_MinFunction(context, (MinFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MOD_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getModFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_ModFunction(context, (ModFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.MULTIPLY:
				if(context == grammarAccess.getMultiplyRule()) {
					sequence_Multiply(context, (Multiply) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.OBJECTIVE:
				if(context == grammarAccess.getObjectiveRule() ||
				   context == grammarAccess.getPatternRule()) {
					sequence_Objective(context, (Objective) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.PENALTY:
				if(context == grammarAccess.getPenaltyRule()) {
					sequence_Penalty(context, (Penalty) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.POW_FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getPowFunctionRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_PowFunction(context, (PowFunction) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_CASE:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarCaseRule()) {
					sequence_SVarCase(context, (SVarCase) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_DSS:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarDSSRule()) {
					sequence_SVarDSS(context, (SVarDSS) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_EXPRESSION:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarExpressionRule()) {
					sequence_SVarExpression(context, (SVarExpression) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_SUM:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarSumRule()) {
					sequence_SVarSum(context, (SVarSum) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_TABLE:
				if(context == grammarAccess.getSVarRule() ||
				   context == grammarAccess.getSVarTableRule()) {
					sequence_SVarTable(context, (SVarTable) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SEQUENCE:
				if(context == grammarAccess.getSequenceRule()) {
					sequence_Sequence(context, (Sequence) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SUB_CONTENT:
				if(context == grammarAccess.getSubContentRule()) {
					sequence_SubContent(context, (SubContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SUM_CONTENT:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getSumContentRule() ||
				   context == grammarAccess.getTermSimpleRule()) {
					sequence_SumContent(context, (SumContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SUM_HEADER:
				if(context == grammarAccess.getSumHeaderRule()) {
					sequence_SumHeader(context, (SumHeader) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.SVAR_DEF:
				if(context == grammarAccess.getPatternRule() ||
				   context == grammarAccess.getStateVariableRule() ||
				   context == grammarAccess.getSvarDefRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_SvarDef(context, (SvarDef) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.TABLE_CONTENT:
				if(context == grammarAccess.getTableContentRule()) {
					sequence_TableContent(context, (TableContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.TERM:
				if(context == grammarAccess.getTermRule() ||
				   context == grammarAccess.getUnaryRule()) {
					sequence_Term(context, (Term) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.TIME_ARRAY_SIZE:
				if(context == grammarAccess.getTimeArraySizeRule()) {
					sequence_TimeArraySize(context, (TimeArraySize) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.UPPER:
				if(context == grammarAccess.getUpperRule()) {
					sequence_Upper(context, (Upper) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.VALUE_CONTENT:
				if(context == grammarAccess.getValueContentRule()) {
					sequence_ValueContent(context, (ValueContent) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.WEIGHT_ITEM:
				if(context == grammarAccess.getWeightItemRule()) {
					sequence_WeightItem(context, (WeightItem) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.WHERE_ITEMS:
				if(context == grammarAccess.getWhereItemsRule()) {
					sequence_WhereItems(context, (WhereItems) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.WRESL_EVALUATOR:
				if(context == grammarAccess.getWreslEvaluatorRule()) {
					sequence_WreslEvaluator(context, (WreslEvaluator) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.LOWER_UPPER:
				if(context == grammarAccess.getDVarIntegerRule() ||
				   context == grammarAccess.getDVarIntegerNonStdRule()) {
					sequence_DVarIntegerNonStd_lowerUpper(context, (lowerUpper) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getLowerAndOrUpperRule() ||
				   context == grammarAccess.getLowerUpperRule()) {
					sequence_lowerUpper(context, (lowerUpper) semanticObject); 
					return; 
				}
				else break;
			case WreslEditorPackage.UPPER_LOWER:
				if(context == grammarAccess.getDVarIntegerRule() ||
				   context == grammarAccess.getDVarIntegerNonStdRule()) {
					sequence_DVarIntegerNonStd_upperLower(context, (upperLower) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getLowerAndOrUpperRule() ||
				   context == grammarAccess.getUpperLowerRule()) {
					sequence_upperLower(context, (upperLower) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     e=Expression
	 */
	protected void sequence_AbsFunction(EObject context, AbsFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.ABS_FUNCTION__E) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.ABS_FUNCTION__E));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAbsFunctionAccess().getEExpressionParserRuleCall_2_0(), semanticObject.getE());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (m1=Multiply m2+=Multiply*)
	 */
	protected void sequence_Add(EObject context, Add semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ta=TimeArraySize? 
	 *         (local?='local' | local?='LOCAL')? 
	 *         ref=[Declaration|ID] 
	 *         expression=Expression 
	 *         kind=STRING? 
	 *         units=STRING?
	 *     )
	 */
	protected void sequence_Alias(EObject context, Alias semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (term=TermSimple expression=Expression)
	 */
	protected void sequence_Assignment(EObject context, Assignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__TERM));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.ASSIGNMENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentAccess().getTermTermSimpleParserRuleCall_0_0(), semanticObject.getTerm());
		feeder.accept(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((caseName=ID | caseName=SpecialIdent) condition=Condition (content=TableContent | content=ValueContent | content=SumContent))
	 */
	protected void sequence_CaseContent(EObject context, CaseContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Condition}
	 */
	protected void sequence_Condition(EObject context, Condition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2=Expression)
	 */
	protected void sequence_ConditionalTerm(EObject context, ConditionalTerm semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E1));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.CONDITIONAL_TERM__E2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConditionalTermAccess().getE1ExpressionParserRuleCall_0_0_0(), semanticObject.getE1());
		feeder.accept(grammarAccess.getConditionalTermAccess().getE2ExpressionParserRuleCall_0_2_0(), semanticObject.getE2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? ref=[Declaration|ID] definition=Number)
	 */
	protected void sequence_ConstDef(EObject context, ConstDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=Expression (operator='<' | operator='>' | operator='=') rhs=Expression)
	 */
	protected void sequence_Constraint(EObject context, Constraint semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lower=Lower upper=Upper? kind=STRING units=STRING)
	 */
	protected void sequence_DVarIntegerNonStd_lowerUpper(EObject context, lowerUpper semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (upper=Upper lower=Lower? kind=STRING units=STRING)
	 */
	protected void sequence_DVarIntegerNonStd_upperLower(EObject context, upperLower semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kind=STRING units=STRING)
	 */
	protected void sequence_DVarIntegerStd(EObject context, DVarIntegerStd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__KIND));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__UNITS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR_INTEGER_STD__UNITS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDVarIntegerStdAccess().getKindSTRINGTerminalRuleCall_3_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDVarIntegerStdAccess().getUnitsSTRINGTerminalRuleCall_5_0(), semanticObject.getUnits());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (lowerUpper=LowerAndOrUpper kind=STRING units=STRING)
	 */
	protected void sequence_DVarNonStd(EObject context, DVarNonStd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__KIND));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR_NON_STD__LOWER_UPPER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR_NON_STD__LOWER_UPPER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDVarNonStdAccess().getLowerUpperLowerAndOrUpperParserRuleCall_0_0(), semanticObject.getLowerUpper());
		feeder.accept(grammarAccess.getDVarNonStdAccess().getKindSTRINGTerminalRuleCall_2_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDVarNonStdAccess().getUnitsSTRINGTerminalRuleCall_4_0(), semanticObject.getUnits());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kind=STRING units=STRING)
	 */
	protected void sequence_DVarStd(EObject context, DVarStd semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__KIND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__KIND));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DVAR__UNITS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDVarStdAccess().getKindSTRINGTerminalRuleCall_2_0(), semanticObject.getKind());
		feeder.accept(grammarAccess.getDVarStdAccess().getUnitsSTRINGTerminalRuleCall_4_0(), semanticObject.getUnits());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Declaration(EObject context, Declaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.DECLARATION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.DECLARATION__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDeclarationAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ta=TimeArraySize? (local?='local' | local?='LOCAL')? ref=[Declaration|ID] (definition=DVar | definition=DVarInteger)) | 
	 *         (ta=TimeArraySize? (local?='local' | local?='LOCAL')? ref=[Declaration|ID] (definition=DVar | definition=DVarInteger))
	 *     )
	 */
	protected void sequence_DvarDef(EObject context, DvarDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logical+=LogicalExpression pattern+=Pattern+)+
	 */
	protected void sequence_ElseIfTerm(EObject context, ElseIfTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pattern+=Pattern+
	 */
	protected void sequence_ElseTerm(EObject context, ElseTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? ref=[Declaration|ID] definition=External)
	 */
	protected void sequence_ExternalDef(EObject context, ExternalDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[Declaration|ID]? e1=Expression e2+=Expression*)
	 */
	protected void sequence_ExternalFunction(EObject context, ExternalFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {External}
	 */
	protected void sequence_External(EObject context, External semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((caseName=ID | caseName=SpecialIdent) condition=Condition rhs=Expression subContent=SubContent?)
	 */
	protected void sequence_GoalCaseContent(EObject context, GoalCaseContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lhs=Expression (content=GoalNoCaseContent | caseContent+=GoalCaseContent+))
	 */
	protected void sequence_GoalCase(EObject context, GoalCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rhs=Expression subContent=SubContent?)
	 */
	protected void sequence_GoalNoCaseContent(EObject context, GoalNoCaseContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     constraint=Constraint
	 */
	protected void sequence_GoalSimple(EObject context, GoalSimple semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.GOAL_SIMPLE__CONSTRAINT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.GOAL_SIMPLE__CONSTRAINT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGoalSimpleAccess().getConstraintConstraintParserRuleCall_0(), semanticObject.getConstraint());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ta=TimeArraySize? (local?='local' | local?='LOCAL')? name=ID (definition=GoalSimple | definition=GoalCase))
	 */
	protected void sequence_Goal(EObject context, Goal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Ident(EObject context, Ident semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.IDENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.IDENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIdentAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (logical=LogicalExpression pattern+=Pattern+ elseifterm=ElseIfTerm? elseterm=ElseTerm?)
	 */
	protected void sequence_IfIncItems_IfTerm(EObject context, IfTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (logical=LogicalExpression pattern+=Pattern+)
	 */
	protected void sequence_IfTerm(EObject context, IfTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? file=STRING)
	 */
	protected void sequence_IncludeFile(EObject context, IncludeFile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     pattern+=Pattern+
	 */
	protected void sequence_Initial(EObject context, Initial semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     e=Expression
	 */
	protected void sequence_IntFunction(EObject context, IntFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.INT_FUNCTION__E) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.INT_FUNCTION__E));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntFunctionAccess().getEExpressionParserRuleCall_2_0(), semanticObject.getE());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {LhsGtRhs}
	 */
	protected void sequence_LhsGtRhs(EObject context, LhsGtRhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {LhsLtRhs}
	 */
	protected void sequence_LhsLtRhs(EObject context, LhsLtRhs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     e=Expression
	 */
	protected void sequence_LogFunction(EObject context, LogFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.LOG_FUNCTION__E) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.LOG_FUNCTION__E));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLogFunctionAccess().getEExpressionParserRuleCall_2_0(), semanticObject.getE());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (c1=ConditionalUnary c2+=ConditionalUnary*)
	 */
	protected void sequence_LogicalExpression(EObject context, LogicalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Lower}
	 */
	protected void sequence_Lower(EObject context, Lower semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2+=Expression*)
	 */
	protected void sequence_MaxFunction(EObject context, MaxFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2+=Expression*)
	 */
	protected void sequence_MinFunction(EObject context, MinFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2=Expression)
	 */
	protected void sequence_ModFunction(EObject context, ModFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.MOD_FUNCTION__E1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.MOD_FUNCTION__E1));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.MOD_FUNCTION__E2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.MOD_FUNCTION__E2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModFunctionAccess().getE1ExpressionParserRuleCall_2_0(), semanticObject.getE1());
		feeder.accept(grammarAccess.getModFunctionAccess().getE2ExpressionParserRuleCall_4_0(), semanticObject.getE2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (pattern+=Pattern | ifincitems+=IfIncItems)+)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (u1=Unary u2+=Unary*)
	 */
	protected void sequence_Multiply(EObject context, Multiply semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((local?='local' | local?='LOCAL')? name=ID weights+=WeightItem+)
	 */
	protected void sequence_Objective(EObject context, Objective semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_Penalty(EObject context, Penalty semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.PENALTY__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.PENALTY__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPenaltyAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (e1=Expression e2=Expression)
	 */
	protected void sequence_PowFunction(EObject context, PowFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.POW_FUNCTION__E1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.POW_FUNCTION__E1));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.POW_FUNCTION__E2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.POW_FUNCTION__E2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPowFunctionAccess().getE1ExpressionParserRuleCall_2_0(), semanticObject.getE1());
		feeder.accept(grammarAccess.getPowFunctionAccess().getE2ExpressionParserRuleCall_4_0(), semanticObject.getE2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     caseContent+=CaseContent+
	 */
	protected void sequence_SVarCase(EObject context, SVarCase semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (bPart=STRING? kind=STRING units=STRING convert=STRING?)
	 */
	protected void sequence_SVarDSS(EObject context, SVarDSS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_SVarExpression(EObject context, SVarExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SVAR_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SVAR_EXPRESSION__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSVarExpressionAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     sumContent=SumContent
	 */
	protected void sequence_SVarSum(EObject context, SVarSum semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SVAR_SUM__SUM_CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SVAR_SUM__SUM_CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSVarSumAccess().getSumContentSumContentParserRuleCall_0(), semanticObject.getSumContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     tableContent=TableContent
	 */
	protected void sequence_SVarTable(EObject context, SVarTable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SVAR_TABLE__TABLE_CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SVAR_TABLE__TABLE_CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSVarTableAccess().getTableContentTableContentParserRuleCall_0(), semanticObject.getTableContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID model=[Model|ID] condition=Condition? order=INT?)
	 */
	protected void sequence_Sequence(EObject context, Sequence semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((gt=LhsGtRhs lt=LhsLtRhs?) | (lt=LhsLtRhs gt=LhsGtRhs?))
	 */
	protected void sequence_SubContent(EObject context, SubContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (header=SumHeader expression=Expression)
	 */
	protected void sequence_SumContent(EObject context, SumContent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__HEADER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__HEADER));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_CONTENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSumContentAccess().getHeaderSumHeaderParserRuleCall_1_0(), semanticObject.getHeader());
		feeder.accept(grammarAccess.getSumContentAccess().getExpressionExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=Expression expression2=Expression)
	 */
	protected void sequence_SumHeader(EObject context, SumHeader semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION1));
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.SUM_HEADER__EXPRESSION2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSumHeaderAccess().getExpression1ExpressionParserRuleCall_2_0(), semanticObject.getExpression1());
		feeder.accept(grammarAccess.getSumHeaderAccess().getExpression2ExpressionParserRuleCall_4_0(), semanticObject.getExpression2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (ta=TimeArraySize? (local?='local' | local?='LOCAL')? ref=[Declaration|ID] definition=SVar) | 
	 *         (ta=TimeArraySize? (local?='local' | local?='LOCAL')? ref=[Declaration|ID] definition=SVar)
	 *     )
	 */
	protected void sequence_SvarDef(EObject context, SvarDef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((tableName=ID | tableName=SpecialIdent) (from=ID | from=SpecialIdent) (given=Assignment use=ID)? where=WhereItems?)
	 */
	protected void sequence_TableContent(EObject context, TableContent semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[Declaration|ID] | n=Number | f=Function | e=Expression | s=SpecialIdent)
	 */
	protected void sequence_Term(EObject context, Term semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=[Declaration|ID]
	 */
	protected void sequence_TimeArraySize(EObject context, TimeArraySize semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.TIME_ARRAY_SIZE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.TIME_ARRAY_SIZE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTimeArraySizeAccess().getNameDeclarationIDTerminalRuleCall_1_0_1(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {Upper}
	 */
	protected void sequence_Upper(EObject context, Upper semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_ValueContent(EObject context, ValueContent semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, WreslEditorPackage.Literals.VALUE_CONTENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, WreslEditorPackage.Literals.VALUE_CONTENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getValueContentAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ref=[Declaration|ID] ta=TimeArraySize? expression=Expression)
	 */
	protected void sequence_WeightItem(EObject context, WeightItem semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (assignment+=Assignment assignment+=Assignment*)
	 */
	protected void sequence_WhereItems(EObject context, WhereItems semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((pattern+=Pattern | ifincitem+=IfIncItems)+ | (initial=Initial? sequence+=Sequence+ model+=Model+))
	 */
	protected void sequence_WreslEvaluator(EObject context, WreslEvaluator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lower=Lower upper=Upper?)
	 */
	protected void sequence_lowerUpper(EObject context, lowerUpper semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (upper=Upper lower=Lower?)
	 */
	protected void sequence_upperLower(EObject context, upperLower semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}

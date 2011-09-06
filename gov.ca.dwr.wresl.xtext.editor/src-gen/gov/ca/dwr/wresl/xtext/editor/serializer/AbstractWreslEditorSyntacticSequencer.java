package gov.ca.dwr.wresl.xtext.editor.serializer;

import com.google.inject.Inject;
import gov.ca.dwr.wresl.xtext.editor.services.WreslEditorGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractWreslEditorSyntacticSequencer extends AbstractSyntacticSequencer {

	protected WreslEditorGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0;
	protected AbstractElementAlias match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0;
	protected AbstractElementAlias match_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0;
	protected AbstractElementAlias match_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0;
	protected AbstractElementAlias match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0;
	protected AbstractElementAlias match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0;
	protected AbstractElementAlias match_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0;
	protected AbstractElementAlias match_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0;
	protected AbstractElementAlias match_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0;
	protected AbstractElementAlias match_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0;
	protected AbstractElementAlias match_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0;
	protected AbstractElementAlias match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0;
	protected AbstractElementAlias match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0;
	protected AbstractElementAlias match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0;
	protected AbstractElementAlias match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0;
	protected AbstractElementAlias match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0;
	protected AbstractElementAlias match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0;
	protected AbstractElementAlias match_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0;
	protected AbstractElementAlias match_Model_MODELKeyword_0_1_or_ModelKeyword_0_0;
	protected AbstractElementAlias match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0;
	protected AbstractElementAlias match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0;
	protected AbstractElementAlias match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0;
	protected AbstractElementAlias match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0;
	protected AbstractElementAlias match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0;
	protected AbstractElementAlias match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0;
	protected AbstractElementAlias match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0;
	protected AbstractElementAlias match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0;
	protected AbstractElementAlias match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q;
	protected AbstractElementAlias match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0;
	protected AbstractElementAlias match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0;
	protected AbstractElementAlias match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0;
	protected AbstractElementAlias match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0;
	protected AbstractElementAlias match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (WreslEditorGrammarAccess) access;
		match_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getALIASKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getAliasKeyword_4_0()));
		match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getDEFINEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getDefineKeyword_0_0()));
		match_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getKINDKeyword_6_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getKindKeyword_6_0_0()));
		match_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getUNITSKeyword_7_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getUnitsKeyword_7_0_0()));
		match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getCaseContentAccess().getCASEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getCaseContentAccess().getCaseKeyword_0_0()));
		match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConditionAccess().getCONDITIONKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getConditionAccess().getConditionKeyword_0_0()));
		match_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getKINDKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getKindKeyword_2_0()));
		match_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getUnitsKeyword_4_0()));
		match_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getUnitsKeyword_4_0()));
		match_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getKINDKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getKindKeyword_1_0()));
		match_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getUNITSKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getUnitsKeyword_3_0()));
		match_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getUNITSKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getUnitsKeyword_3_0()));
		match_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDefineAccess().getDEFINEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getDefineAccess().getDefineKeyword_0_0()));
		match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getEXTERNALKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getExternalKeyword_0_0()));
		match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getCASEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getCaseKeyword_0_0()));
		match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getRHSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getRhsKeyword_4_0()));
		match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseAccess().getLhsKeyword_0_0()));
		match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalNoCaseContentAccess().getRHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalNoCaseContentAccess().getRhsKeyword_0_0()));
		match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalAccess().getGOALKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getGoalKeyword_0_0()));
		match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getIncludeFileAccess().getINCLUDEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getIncludeFileAccess().getIncludeKeyword_0_0()));
		match_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getLhsKeyword_0_0()));
		match_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getLhsKeyword_0_0()));
		match_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLowerAccess().getLOWERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getLowerAccess().getLowerKeyword_0_0()));
		match_Model_MODELKeyword_0_1_or_ModelKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getModelAccess().getMODELKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getModelAccess().getModelKeyword_0_0()));
		match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getObjectiveAccess().getOBJECTIVEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getObjectiveAccess().getObjectiveKeyword_0_0()));
		match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPenaltyAccess().getPENALTYKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getPenaltyAccess().getPenaltyKeyword_0_0()));
		match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getCONVERTKeyword_6_0_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getConvertKeyword_6_0_0()));
		match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getKINDKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getKindKeyword_2_0()));
		match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getTIMESERIESKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getTimeseriesKeyword_0_0()));
		match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getUnitsKeyword_4_0()));
		match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarExpressionAccess().getVALUEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSVarExpressionAccess().getValueKeyword_0_0()));
		match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getMODELKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getModelKeyword_3_0()));
		match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getSequenceKeyword_0_0()));
		match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getSumHeaderAccess().getCommaKeyword_5_0()), new TokenAlias(true, false, grammarAccess.getSumHeaderAccess().getHyphenMinusKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getSumHeaderAccess().getINTTerminalRuleCall_5_2()));
		match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getFROMKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getFromKeyword_2_0()));
		match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getSELECTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getSelectKeyword_0_0()));
		match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getUSEKeyword_4_2_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getUseKeyword_4_2_0()));
		match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getUpperAccess().getUPPERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getUpperAccess().getUpperKeyword_0_0()));
		match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getValueContentAccess().getVALUEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getValueContentAccess().getValueKeyword_0_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getALWAYSRule())
			return getALWAYSToken(ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getORDERRule())
			return getORDERToken(ruleCall, node);
		return "";
	}
	
	protected String getALWAYSToken(RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "always";
	}
	protected String getINTToken(RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getORDERToken(RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "order";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0.equals(transition.getAmbiguousSyntax()))
			emit_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0(semanticObject, transition, fromNode, toNode);
		else if(match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0.equals(transition.getAmbiguousSyntax()))
			emit_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0(semanticObject, transition, fromNode, toNode);
		else if(match_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0.equals(transition.getAmbiguousSyntax()))
			emit_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(semanticObject, transition, fromNode, toNode);
		else if(match_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0.equals(transition.getAmbiguousSyntax()))
			emit_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(semanticObject, transition, fromNode, toNode);
		else if(match_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0.equals(transition.getAmbiguousSyntax()))
			emit_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0(semanticObject, transition, fromNode, toNode);
		else if(match_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0.equals(transition.getAmbiguousSyntax()))
			emit_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(semanticObject, transition, fromNode, toNode);
		else if(match_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0.equals(transition.getAmbiguousSyntax()))
			emit_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(semanticObject, transition, fromNode, toNode);
		else if(match_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0.equals(transition.getAmbiguousSyntax()))
			emit_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0(semanticObject, transition, fromNode, toNode);
		else if(match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Model_MODELKeyword_0_1_or_ModelKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Model_MODELKeyword_0_1_or_ModelKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0.equals(transition.getAmbiguousSyntax()))
			emit_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0.equals(transition.getAmbiguousSyntax()))
			emit_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0(semanticObject, transition, fromNode, toNode);
		else if(match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0.equals(transition.getAmbiguousSyntax()))
			emit_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0(semanticObject, transition, fromNode, toNode);
		else if(match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0.equals(transition.getAmbiguousSyntax()))
			emit_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0(semanticObject, transition, fromNode, toNode);
		else if(match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q.equals(transition.getAmbiguousSyntax()))
			emit_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q(semanticObject, transition, fromNode, toNode);
		else if(match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0.equals(transition.getAmbiguousSyntax()))
			emit_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0(semanticObject, transition, fromNode, toNode);
		else if(match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0.equals(transition.getAmbiguousSyntax()))
			emit_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0(semanticObject, transition, fromNode, toNode);
		else if(match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else if(match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0.equals(transition.getAmbiguousSyntax()))
			emit_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     'alias' | 'ALIAS'
	 */
	protected void emit_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'define' | 'DEFINE'
	 */
	protected void emit_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'kind' | 'KIND'
	 */
	protected void emit_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'case' | 'CASE'
	 */
	protected void emit_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'condition' | 'CONDITION'
	 */
	protected void emit_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'UNITS' | 'units'
	 */
	protected void emit_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'define' | 'DEFINE'
	 */
	protected void emit_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'EXTERNAL' | 'external'
	 */
	protected void emit_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'case' | 'CASE'
	 */
	protected void emit_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'RHS' | 'rhs'
	 */
	protected void emit_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'LHS' | 'lhs'
	 */
	protected void emit_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'rhs' | 'RHS'
	 */
	protected void emit_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'goal' | 'GOAL'
	 */
	protected void emit_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'include' | 'INCLUDE'
	 */
	protected void emit_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'lhs' | 'LHS'
	 */
	protected void emit_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'LHS' | 'lhs'
	 */
	protected void emit_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'LOWER' | 'lower'
	 */
	protected void emit_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'model' | 'MODEL'
	 */
	protected void emit_Model_MODELKeyword_0_1_or_ModelKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'objective' | 'OBJECTIVE'
	 */
	protected void emit_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'penalty' | 'PENALTY'
	 */
	protected void emit_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'CONVERT' | 'convert'
	 */
	protected void emit_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'timeseries' | 'TIMESERIES'
	 */
	protected void emit_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'value' | 'VALUE'
	 */
	protected void emit_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'MODEL' | 'model'
	 */
	protected void emit_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'SEQUENCE' | 'sequence'
	 */
	protected void emit_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     (',' '-'? INT)?
	 */
	protected void emit_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'FROM' | 'from'
	 */
	protected void emit_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'SELECT' | 'select'
	 */
	protected void emit_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'use' | 'USE'
	 */
	protected void emit_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'upper' | 'UPPER'
	 */
	protected void emit_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     'value' | 'VALUE'
	 */
	protected void emit_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}

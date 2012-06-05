package gov.ca.dwr.wresl.xtext.editor.serializer;

import com.google.inject.Inject;
import gov.ca.dwr.wresl.xtext.editor.services.WreslEditorGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractWreslEditorSyntacticSequencer extends AbstractSyntacticSequencer {

	protected WreslEditorGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0;
	protected AbstractElementAlias match_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0;
	protected AbstractElementAlias match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0;
	protected AbstractElementAlias match_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0;
	protected AbstractElementAlias match_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0;
	protected AbstractElementAlias match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0;
	protected AbstractElementAlias match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0;
	protected AbstractElementAlias match_ConditionalUnary_ConditionalNegationParserRuleCall_0_q;
	protected AbstractElementAlias match_DVarIntegerNonStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0;
	protected AbstractElementAlias match_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0;
	protected AbstractElementAlias match_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_DVarIntegerStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0;
	protected AbstractElementAlias match_DVarIntegerStd_KINDKeyword_2_1_or_KindKeyword_2_0;
	protected AbstractElementAlias match_DVarIntegerStd_STDKeyword_1_1_or_StdKeyword_1_0;
	protected AbstractElementAlias match_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0;
	protected AbstractElementAlias match_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0;
	protected AbstractElementAlias match_DVarStd_KINDKeyword_1_1_or_KindKeyword_1_0;
	protected AbstractElementAlias match_DVarStd_STDKeyword_0_1_or_StdKeyword_0_0;
	protected AbstractElementAlias match_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0;
	protected AbstractElementAlias match_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0;
	protected AbstractElementAlias match_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0;
	protected AbstractElementAlias match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0;
	protected AbstractElementAlias match_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1;
	protected AbstractElementAlias match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0;
	protected AbstractElementAlias match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0;
	protected AbstractElementAlias match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0;
	protected AbstractElementAlias match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0;
	protected AbstractElementAlias match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0;
	protected AbstractElementAlias match_LhsGtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0;
	protected AbstractElementAlias match_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_LhsGtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0;
	protected AbstractElementAlias match_LhsLtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0;
	protected AbstractElementAlias match_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_LhsLtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0;
	protected AbstractElementAlias match_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0;
	protected AbstractElementAlias match_Lower_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0;
	protected AbstractElementAlias match_Model_MODELKeyword_0_1_or_ModelKeyword_0_0;
	protected AbstractElementAlias match_Multiply_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1;
	protected AbstractElementAlias match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0;
	protected AbstractElementAlias match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0;
	protected AbstractElementAlias match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0;
	protected AbstractElementAlias match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0;
	protected AbstractElementAlias match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0;
	protected AbstractElementAlias match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0;
	protected AbstractElementAlias match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0;
	protected AbstractElementAlias match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0;
	protected AbstractElementAlias match_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0;
	protected AbstractElementAlias match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q;
	protected AbstractElementAlias match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0;
	protected AbstractElementAlias match_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0;
	protected AbstractElementAlias match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0;
	protected AbstractElementAlias match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0;
	protected AbstractElementAlias match_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0;
	protected AbstractElementAlias match_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1;
	protected AbstractElementAlias match_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q;
	protected AbstractElementAlias match_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0;
	protected AbstractElementAlias match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0;
	protected AbstractElementAlias match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0;
	protected AbstractElementAlias match_WeightItem_CommaKeyword_5_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (WreslEditorGrammarAccess) access;
		match_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAddAccess().getHyphenMinusKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getAddAccess().getPlusSignKeyword_1_0_0()));
		match_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getALIASKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getAliasKeyword_4_0()));
		match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getDEFINEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getDefineKeyword_0_0()));
		match_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getKINDKeyword_6_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getKindKeyword_6_0_0()));
		match_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getUNITSKeyword_7_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getUnitsKeyword_7_0_0()));
		match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getCaseContentAccess().getCASEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getCaseContentAccess().getCaseKeyword_0_0()));
		match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConditionAccess().getCONDITIONKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getConditionAccess().getConditionKeyword_0_0()));
		match_ConditionalUnary_ConditionalNegationParserRuleCall_0_q = new TokenAlias(true, false, grammarAccess.getConditionalUnaryAccess().getConditionalNegationParserRuleCall_0());
		match_DVarIntegerNonStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getINTEGERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getIntegerKeyword_0_0()));
		match_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getKINDKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getKindKeyword_2_0()));
		match_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerNonStdAccess().getUnitsKeyword_4_0()));
		match_DVarIntegerStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getINTEGERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getIntegerKeyword_0_0()));
		match_DVarIntegerStd_KINDKeyword_2_1_or_KindKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getKINDKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getKindKeyword_2_0()));
		match_DVarIntegerStd_STDKeyword_1_1_or_StdKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getSTDKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getStdKeyword_1_0()));
		match_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getDVarIntegerStdAccess().getUnitsKeyword_4_0()));
		match_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getKINDKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getKindKeyword_1_0()));
		match_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getUNITSKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getDVarNonStdAccess().getUnitsKeyword_3_0()));
		match_DVarStd_KINDKeyword_1_1_or_KindKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getKINDKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getKindKeyword_1_0()));
		match_DVarStd_STDKeyword_0_1_or_StdKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getSTDKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getStdKeyword_0_0()));
		match_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getUNITSKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getDVarStdAccess().getUnitsKeyword_3_0()));
		match_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDefineAccess().getDEFINEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getDefineAccess().getDefineKeyword_0_0()));
		match_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getDLLKeyword_1_0_1_1()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getDllKeyword_1_0_1_0()));
		match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getEXTERNALKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getExternalKeyword_0_0()));
		match_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_0()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_1()));
		match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getCASEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getCaseKeyword_0_0()));
		match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getRHSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getRhsKeyword_4_0()));
		match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseAccess().getLhsKeyword_0_0()));
		match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalNoCaseContentAccess().getRHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalNoCaseContentAccess().getRhsKeyword_0_0()));
		match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalAccess().getGOALKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getGoalKeyword_0_0()));
		match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getIncludeFileAccess().getINCLUDEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getIncludeFileAccess().getIncludeKeyword_0_0()));
		match_LhsGtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getCONSTRAINKeyword_3_0_1_1()), new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getConstrainKeyword_3_0_1_0()));
		match_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getLhsKeyword_0_0()));
		match_LhsGtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getRHSKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getLhsGtRhsAccess().getRhsKeyword_2_0()));
		match_LhsLtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getCONSTRAINKeyword_3_0_1_1()), new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getConstrainKeyword_3_0_1_0()));
		match_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getLhsKeyword_0_0()));
		match_LhsLtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getRHSKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getLhsLtRhsAccess().getRhsKeyword_2_0()));
		match_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLowerAccess().getLOWERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getLowerAccess().getLowerKeyword_0_0()));
		match_Lower_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLowerAccess().getUNBOUNDEDKeyword_1_0_1_1()), new TokenAlias(false, false, grammarAccess.getLowerAccess().getUnboundedKeyword_1_0_1_0()));
		match_Model_MODELKeyword_0_1_or_ModelKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getModelAccess().getMODELKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getModelAccess().getModelKeyword_0_0()));
		match_Multiply_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getMultiplyAccess().getAsteriskKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getMultiplyAccess().getSolidusKeyword_1_0_1()));
		match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getObjectiveAccess().getOBJECTIVEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getObjectiveAccess().getObjectiveKeyword_0_0()));
		match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPenaltyAccess().getPENALTYKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getPenaltyAccess().getPenaltyKeyword_0_0()));
		match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getCONVERTKeyword_6_0_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getConvertKeyword_6_0_0()));
		match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getKINDKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getKindKeyword_2_0()));
		match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getTIMESERIESKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getTimeseriesKeyword_0_0()));
		match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getUnitsKeyword_4_0()));
		match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarExpressionAccess().getVALUEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSVarExpressionAccess().getValueKeyword_0_0()));
		match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getMODELKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getModelKeyword_3_0()));
		match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getSequenceKeyword_0_0()));
		match_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSumContentAccess().getSUMKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSumContentAccess().getSumKeyword_0_0()));
		match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q = new GroupAlias(true, false, new TokenAlias(false, false, grammarAccess.getSumHeaderAccess().getCommaKeyword_5_0()), new TokenAlias(true, false, grammarAccess.getSumHeaderAccess().getHyphenMinusKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getSumHeaderAccess().getINTTerminalRuleCall_5_2()));
		match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getFROMKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getFromKeyword_2_0()));
		match_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getGIVENKeyword_4_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getGivenKeyword_4_0_0()));
		match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getSELECTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getSelectKeyword_0_0()));
		match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getUSEKeyword_4_2_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getUseKeyword_4_2_0()));
		match_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getWHEREKeyword_5_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getWhereKeyword_5_0_0()));
		match_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTermSimpleAccess().getIDTerminalRuleCall_0()), new TokenAlias(false, false, grammarAccess.getTermSimpleAccess().getNumberParserRuleCall_1()));
		match_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q = new AlternativeAlias(true, false, new TokenAlias(false, false, grammarAccess.getUnaryAccess().getNegationParserRuleCall_0_1()), new TokenAlias(false, false, grammarAccess.getUnaryAccess().getPlusSignKeyword_0_0()));
		match_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getUpperAccess().getUNBOUNDEDKeyword_1_0_1_1()), new TokenAlias(false, false, grammarAccess.getUpperAccess().getUnboundedKeyword_1_0_1_0()));
		match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getUpperAccess().getUPPERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getUpperAccess().getUpperKeyword_0_0()));
		match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getValueContentAccess().getVALUEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getValueContentAccess().getValueKeyword_0_0()));
		match_WeightItem_CommaKeyword_5_q = new TokenAlias(true, false, grammarAccess.getWeightItemAccess().getCommaKeyword_5());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getALWAYSRule())
			return getALWAYSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getBinaryOpRule())
			return getBinaryOpToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getConditionalNegationRule())
			return getConditionalNegationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLogicalFunctionRule())
			return getLogicalFunctionToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMAXRule())
			return getMAXToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMINRule())
			return getMINToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNegationRule())
			return getNegationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNumberRule())
			return getNumberToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getORDERRule())
			return getORDERToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRelationRule())
			return getRelationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getVarModelRule())
			return getVarModelToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getALWAYSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "always";
	}
	protected String getBinaryOpToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".or.";
	}
	protected String getConditionalNegationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".not.";
	}
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getLogicalFunctionToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "range(,,)";
	}
	protected String getMAXToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "max";
	}
	protected String getMINToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "min";
	}
	protected String getNegationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-";
	}
	protected String getNumberToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getORDERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "order";
	}
	protected String getRelationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ">";
	}
	protected String getVarModelToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0.equals(syntax))
				emit_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0.equals(syntax))
				emit_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0.equals(syntax))
				emit_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0.equals(syntax))
				emit_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0.equals(syntax))
				emit_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0.equals(syntax))
				emit_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0.equals(syntax))
				emit_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConditionalUnary_ConditionalNegationParserRuleCall_0_q.equals(syntax))
				emit_ConditionalUnary_ConditionalNegationParserRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerNonStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0.equals(syntax))
				emit_DVarIntegerNonStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0.equals(syntax))
				emit_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0.equals(syntax))
				emit_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0.equals(syntax))
				emit_DVarIntegerStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerStd_KINDKeyword_2_1_or_KindKeyword_2_0.equals(syntax))
				emit_DVarIntegerStd_KINDKeyword_2_1_or_KindKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerStd_STDKeyword_1_1_or_StdKeyword_1_0.equals(syntax))
				emit_DVarIntegerStd_STDKeyword_1_1_or_StdKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0.equals(syntax))
				emit_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0.equals(syntax))
				emit_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0.equals(syntax))
				emit_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarStd_KINDKeyword_1_1_or_KindKeyword_1_0.equals(syntax))
				emit_DVarStd_KINDKeyword_1_1_or_KindKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarStd_STDKeyword_0_1_or_StdKeyword_0_0.equals(syntax))
				emit_DVarStd_STDKeyword_0_1_or_StdKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0.equals(syntax))
				emit_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0.equals(syntax))
				emit_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0.equals(syntax))
				emit_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0.equals(syntax))
				emit_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1.equals(syntax))
				emit_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0.equals(syntax))
				emit_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0.equals(syntax))
				emit_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0.equals(syntax))
				emit_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0.equals(syntax))
				emit_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0.equals(syntax))
				emit_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0.equals(syntax))
				emit_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LhsGtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0.equals(syntax))
				emit_LhsGtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0.equals(syntax))
				emit_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LhsGtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0.equals(syntax))
				emit_LhsGtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LhsLtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0.equals(syntax))
				emit_LhsLtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0.equals(syntax))
				emit_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LhsLtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0.equals(syntax))
				emit_LhsLtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0.equals(syntax))
				emit_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Lower_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0.equals(syntax))
				emit_Lower_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Model_MODELKeyword_0_1_or_ModelKeyword_0_0.equals(syntax))
				emit_Model_MODELKeyword_0_1_or_ModelKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Multiply_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1.equals(syntax))
				emit_Multiply_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0.equals(syntax))
				emit_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0.equals(syntax))
				emit_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0.equals(syntax))
				emit_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0.equals(syntax))
				emit_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0.equals(syntax))
				emit_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0.equals(syntax))
				emit_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0.equals(syntax))
				emit_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0.equals(syntax))
				emit_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0.equals(syntax))
				emit_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0.equals(syntax))
				emit_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q.equals(syntax))
				emit_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0.equals(syntax))
				emit_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0.equals(syntax))
				emit_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0.equals(syntax))
				emit_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0.equals(syntax))
				emit_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0.equals(syntax))
				emit_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1.equals(syntax))
				emit_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q.equals(syntax))
				emit_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0.equals(syntax))
				emit_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0.equals(syntax))
				emit_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0.equals(syntax))
				emit_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_WeightItem_CommaKeyword_5_q.equals(syntax))
				emit_WeightItem_CommaKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '-' | '+'
	 */
	protected void emit_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'alias' | 'ALIAS'
	 */
	protected void emit_Alias_ALIASKeyword_4_1_or_AliasKeyword_4_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'define' | 'DEFINE'
	 */
	protected void emit_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'kind' | 'KIND'
	 */
	protected void emit_Alias_KINDKeyword_6_0_1_or_KindKeyword_6_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_Alias_UNITSKeyword_7_0_1_or_UnitsKeyword_7_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'CASE' | 'case'
	 */
	protected void emit_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'CONDITION' | 'condition'
	 */
	protected void emit_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ConditionalNegation?
	 */
	protected void emit_ConditionalUnary_ConditionalNegationParserRuleCall_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'INTEGER' | 'integer'
	 */
	protected void emit_DVarIntegerNonStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_DVarIntegerNonStd_KINDKeyword_2_1_or_KindKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_DVarIntegerNonStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'integer' | 'INTEGER'
	 */
	protected void emit_DVarIntegerStd_INTEGERKeyword_0_1_or_IntegerKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_DVarIntegerStd_KINDKeyword_2_1_or_KindKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'std' | 'STD'
	 */
	protected void emit_DVarIntegerStd_STDKeyword_1_1_or_StdKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_DVarIntegerStd_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'kind' | 'KIND'
	 */
	protected void emit_DVarNonStd_KINDKeyword_1_1_or_KindKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'UNITS' | 'units'
	 */
	protected void emit_DVarNonStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_DVarStd_KINDKeyword_1_1_or_KindKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'STD' | 'std'
	 */
	protected void emit_DVarStd_STDKeyword_0_1_or_StdKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'UNITS' | 'units'
	 */
	protected void emit_DVarStd_UNITSKeyword_3_1_or_UnitsKeyword_3_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'DEFINE' | 'define'
	 */
	protected void emit_Define_DEFINEKeyword_0_1_or_DefineKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '.dll' | '.DLL'
	 */
	protected void emit_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'external' | 'EXTERNAL'
	 */
	protected void emit_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'F90' | 'f90'
	 */
	protected void emit_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'case' | 'CASE'
	 */
	protected void emit_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'RHS' | 'rhs'
	 */
	protected void emit_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'lhs' | 'LHS'
	 */
	protected void emit_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'RHS' | 'rhs'
	 */
	protected void emit_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'GOAL' | 'goal'
	 */
	protected void emit_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'INCLUDE' | 'include'
	 */
	protected void emit_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'CONSTRAIN' | 'constrain'
	 */
	protected void emit_LhsGtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'LHS' | 'lhs'
	 */
	protected void emit_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'rhs' | 'RHS'
	 */
	protected void emit_LhsGtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'CONSTRAIN' | 'constrain'
	 */
	protected void emit_LhsLtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'LHS' | 'lhs'
	 */
	protected void emit_LhsLtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'RHS' | 'rhs'
	 */
	protected void emit_LhsLtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'LOWER' | 'lower'
	 */
	protected void emit_Lower_LOWERKeyword_0_1_or_LowerKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'UNBOUNDED' | 'unbounded'
	 */
	protected void emit_Lower_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'model' | 'MODEL'
	 */
	protected void emit_Model_MODELKeyword_0_1_or_ModelKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '*' | '/'
	 */
	protected void emit_Multiply_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'objective' | 'OBJECTIVE'
	 */
	protected void emit_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'PENALTY' | 'penalty'
	 */
	protected void emit_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'CONVERT' | 'convert'
	 */
	protected void emit_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'timeseries' | 'TIMESERIES'
	 */
	protected void emit_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'UNITS' | 'units'
	 */
	protected void emit_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'value' | 'VALUE'
	 */
	protected void emit_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'model' | 'MODEL'
	 */
	protected void emit_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'sequence' | 'SEQUENCE'
	 */
	protected void emit_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'sum' | 'SUM'
	 */
	protected void emit_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (',' '-'? INT)?
	 */
	protected void emit_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'from' | 'FROM'
	 */
	protected void emit_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'given' | 'GIVEN'
	 */
	protected void emit_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'SELECT' | 'select'
	 */
	protected void emit_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'USE' | 'use'
	 */
	protected void emit_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'where' | 'WHERE'
	 */
	protected void emit_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ID | Number
	 */
	protected void emit_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (Negation | '+')?
	 */
	protected void emit_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'unbounded' | 'UNBOUNDED'
	 */
	protected void emit_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'upper' | 'UPPER'
	 */
	protected void emit_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'VALUE' | 'value'
	 */
	protected void emit_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_WeightItem_CommaKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

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

@SuppressWarnings("all")
public abstract class AbstractWreslEditorSyntacticSequencer extends AbstractSyntacticSequencer {

	protected WreslEditorGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0;
	protected AbstractElementAlias match_Alias_ALIASKeyword_5_1_or_AliasKeyword_5_0;
	protected AbstractElementAlias match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0;
	protected AbstractElementAlias match_Alias_KINDKeyword_7_0_1_or_KindKeyword_7_0_0;
	protected AbstractElementAlias match_Alias_UNITSKeyword_8_0_1_or_UnitsKeyword_8_0_0;
	protected AbstractElementAlias match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0;
	protected AbstractElementAlias match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0;
	protected AbstractElementAlias match_ConditionalUnary_ConditionalNegationParserRuleCall_0_q;
	protected AbstractElementAlias match_ConstDef_CONSTKeyword_0_1_or_ConstKeyword_0_0_or_ConstKeyword_0_2;
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
	protected AbstractElementAlias match_DvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0;
	protected AbstractElementAlias match_DvarDef_DVARKeyword_1_0_1_or_DvarKeyword_1_0_0_or_DvarKeyword_1_0_2;
	protected AbstractElementAlias match_ExternalDef_DEFINEKeyword_0_1_or_DefineKeyword_0_0;
	protected AbstractElementAlias match_ExternalFunction_MonthParserRuleCall_0_2_or_TafCfsParserRuleCall_0_1;
	protected AbstractElementAlias match_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0;
	protected AbstractElementAlias match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0;
	protected AbstractElementAlias match_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1;
	protected AbstractElementAlias match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0;
	protected AbstractElementAlias match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0;
	protected AbstractElementAlias match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0;
	protected AbstractElementAlias match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0;
	protected AbstractElementAlias match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0;
	protected AbstractElementAlias match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0;
	protected AbstractElementAlias match_Initial_INITIALKeyword_0_2_or_InitialKeyword_0_0_or_InitialKeyword_0_1;
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
	protected AbstractElementAlias match_Objective_EqualsSignKeyword_3_q;
	protected AbstractElementAlias match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0;
	protected AbstractElementAlias match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0;
	protected AbstractElementAlias match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0;
	protected AbstractElementAlias match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0;
	protected AbstractElementAlias match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0;
	protected AbstractElementAlias match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0;
	protected AbstractElementAlias match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0;
	protected AbstractElementAlias match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0;
	protected AbstractElementAlias match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0;
	protected AbstractElementAlias match_Sequence___TimeStepParserRuleCall_7_0_TimeStepValueParserRuleCall_7_1__q;
	protected AbstractElementAlias match_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0;
	protected AbstractElementAlias match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q;
	protected AbstractElementAlias match_SvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0;
	protected AbstractElementAlias match_SvarDef_SVARKeyword_1_0_1_or_SvarKeyword_1_0_0_or_SvarKeyword_1_0_2;
	protected AbstractElementAlias match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0;
	protected AbstractElementAlias match_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0;
	protected AbstractElementAlias match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0;
	protected AbstractElementAlias match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0;
	protected AbstractElementAlias match_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0;
	protected AbstractElementAlias match_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1_or_SpecialIdentParserRuleCall_3;
	protected AbstractElementAlias match_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q;
	protected AbstractElementAlias match_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0;
	protected AbstractElementAlias match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0;
	protected AbstractElementAlias match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0;
	protected AbstractElementAlias match_WeightItem_CommaKeyword_6_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (WreslEditorGrammarAccess) access;
		match_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAddAccess().getHyphenMinusKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getAddAccess().getPlusSignKeyword_1_0_0()));
		match_Alias_ALIASKeyword_5_1_or_AliasKeyword_5_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getALIASKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getAliasKeyword_5_0()));
		match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getDEFINEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getDefineKeyword_0_0()));
		match_Alias_KINDKeyword_7_0_1_or_KindKeyword_7_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getKINDKeyword_7_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getKindKeyword_7_0_0()));
		match_Alias_UNITSKeyword_8_0_1_or_UnitsKeyword_8_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAliasAccess().getUNITSKeyword_8_0_1()), new TokenAlias(false, false, grammarAccess.getAliasAccess().getUnitsKeyword_8_0_0()));
		match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getCaseContentAccess().getCASEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getCaseContentAccess().getCaseKeyword_0_0()));
		match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConditionAccess().getCONDITIONKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getConditionAccess().getConditionKeyword_0_0()));
		match_ConditionalUnary_ConditionalNegationParserRuleCall_0_q = new TokenAlias(false, true, grammarAccess.getConditionalUnaryAccess().getConditionalNegationParserRuleCall_0());
		match_ConstDef_CONSTKeyword_0_1_or_ConstKeyword_0_0_or_ConstKeyword_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getConstDefAccess().getCONSTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getConstDefAccess().getConstKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getConstDefAccess().getConstKeyword_0_2()));
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
		match_DvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDvarDefAccess().getDEFINEKeyword_0_0_1()), new TokenAlias(false, false, grammarAccess.getDvarDefAccess().getDefineKeyword_0_0_0()));
		match_DvarDef_DVARKeyword_1_0_1_or_DvarKeyword_1_0_0_or_DvarKeyword_1_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDvarDefAccess().getDVARKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getDvarDefAccess().getDvarKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getDvarDefAccess().getDvarKeyword_1_0_2()));
		match_ExternalDef_DEFINEKeyword_0_1_or_DefineKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalDefAccess().getDEFINEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getExternalDefAccess().getDefineKeyword_0_0()));
		match_ExternalFunction_MonthParserRuleCall_0_2_or_TafCfsParserRuleCall_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalFunctionAccess().getMonthParserRuleCall_0_2()), new TokenAlias(false, false, grammarAccess.getExternalFunctionAccess().getTafCfsParserRuleCall_0_1()));
		match_External_DLLKeyword_1_0_1_1_or_DllKeyword_1_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getDLLKeyword_1_0_1_1()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getDllKeyword_1_0_1_0()));
		match_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getEXTERNALKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getExternalKeyword_0_0()));
		match_External_F90Keyword_1_1_1_0_or_F90Keyword_1_1_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_0()), new TokenAlias(false, false, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_1()));
		match_GoalCaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getCASEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getCaseKeyword_0_0()));
		match_GoalCaseContent_RHSKeyword_4_1_or_RhsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getRHSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseContentAccess().getRhsKeyword_4_0()));
		match_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalCaseAccess().getLHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalCaseAccess().getLhsKeyword_0_0()));
		match_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalNoCaseContentAccess().getRHSKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalNoCaseContentAccess().getRhsKeyword_0_0()));
		match_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getGoalAccess().getGOALKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getGoalAccess().getGoalKeyword_0_0()));
		match_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getIncludeFileAccess().getINCLUDEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getIncludeFileAccess().getIncludeKeyword_0_0()));
		match_Initial_INITIALKeyword_0_2_or_InitialKeyword_0_0_or_InitialKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getInitialAccess().getINITIALKeyword_0_2()), new TokenAlias(false, false, grammarAccess.getInitialAccess().getInitialKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getInitialAccess().getInitialKeyword_0_1()));
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
		match_Objective_EqualsSignKeyword_3_q = new TokenAlias(false, true, grammarAccess.getObjectiveAccess().getEqualsSignKeyword_3());
		match_Objective_OBJECTIVEKeyword_0_1_or_ObjectiveKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getObjectiveAccess().getOBJECTIVEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getObjectiveAccess().getObjectiveKeyword_0_0()));
		match_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getPenaltyAccess().getPENALTYKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getPenaltyAccess().getPenaltyKeyword_0_0()));
		match_SVarDSS_CONVERTKeyword_6_0_1_or_ConvertKeyword_6_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getCONVERTKeyword_6_0_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getConvertKeyword_6_0_0()));
		match_SVarDSS_KINDKeyword_2_1_or_KindKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getKINDKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getKindKeyword_2_0()));
		match_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getTIMESERIESKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getTimeseriesKeyword_0_0()));
		match_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getUNITSKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getSVarDSSAccess().getUnitsKeyword_4_0()));
		match_SVarExpression_VALUEKeyword_0_1_or_ValueKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSVarExpressionAccess().getVALUEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSVarExpressionAccess().getValueKeyword_0_0()));
		match_Sequence_MODELKeyword_3_1_or_ModelKeyword_3_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getMODELKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getModelKeyword_3_0()));
		match_Sequence_SEQUENCEKeyword_0_1_or_SequenceKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getSequenceKeyword_0_0()));
		match_Sequence___TimeStepParserRuleCall_7_0_TimeStepValueParserRuleCall_7_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSequenceAccess().getTimeStepParserRuleCall_7_0()), new TokenAlias(false, false, grammarAccess.getSequenceAccess().getTimeStepValueParserRuleCall_7_1()));
		match_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSumContentAccess().getSUMKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getSumContentAccess().getSumKeyword_0_0()));
		match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSumHeaderAccess().getCommaKeyword_5_0()), new TokenAlias(false, true, grammarAccess.getSumHeaderAccess().getHyphenMinusKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getSumHeaderAccess().getINTTerminalRuleCall_5_2()));
		match_SvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSvarDefAccess().getDEFINEKeyword_0_0_1()), new TokenAlias(false, false, grammarAccess.getSvarDefAccess().getDefineKeyword_0_0_0()));
		match_SvarDef_SVARKeyword_1_0_1_or_SvarKeyword_1_0_0_or_SvarKeyword_1_0_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getSvarDefAccess().getSVARKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getSvarDefAccess().getSvarKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getSvarDefAccess().getSvarKeyword_1_0_2()));
		match_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getFROMKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getFromKeyword_2_0()));
		match_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getGIVENKeyword_4_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getGivenKeyword_4_0_0()));
		match_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getSELECTKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getSelectKeyword_0_0()));
		match_TableContent_USEKeyword_4_2_1_or_UseKeyword_4_2_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getUSEKeyword_4_2_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getUseKeyword_4_2_0()));
		match_TableContent_WHEREKeyword_5_0_1_or_WhereKeyword_5_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTableContentAccess().getWHEREKeyword_5_0_1()), new TokenAlias(false, false, grammarAccess.getTableContentAccess().getWhereKeyword_5_0_0()));
		match_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1_or_SpecialIdentParserRuleCall_3 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getTermSimpleAccess().getIDTerminalRuleCall_0()), new TokenAlias(false, false, grammarAccess.getTermSimpleAccess().getNumberParserRuleCall_1()), new TokenAlias(false, false, grammarAccess.getTermSimpleAccess().getSpecialIdentParserRuleCall_3()));
		match_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getUnaryAccess().getNegationParserRuleCall_0_1()), new TokenAlias(false, false, grammarAccess.getUnaryAccess().getPlusSignKeyword_0_0()));
		match_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getUpperAccess().getUNBOUNDEDKeyword_1_0_1_1()), new TokenAlias(false, false, grammarAccess.getUpperAccess().getUnboundedKeyword_1_0_1_0()));
		match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getUpperAccess().getUPPERKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getUpperAccess().getUpperKeyword_0_0()));
		match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getValueContentAccess().getVALUEKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getValueContentAccess().getValueKeyword_0_0()));
		match_WeightItem_CommaKeyword_6_q = new TokenAlias(false, true, grammarAccess.getWeightItemAccess().getCommaKeyword_6());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getABSRule())
			return getABSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getALWAYSRule())
			return getALWAYSToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getBinaryOpRule())
			return getBinaryOpToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getConditionalNegationRule())
			return getConditionalNegationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getElseRule())
			return getElseToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getElseIfRule())
			return getElseIfToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTFUNCRule())
			return getINTFUNCToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIfRule())
			return getIfToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIncludeModelRule())
			return getIncludeModelToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLOGRule())
			return getLOGToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getLogicalFunctionRule())
			return getLogicalFunctionToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMAXRule())
			return getMAXToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMINRule())
			return getMINToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMODRule())
			return getMODToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMonthRule())
			return getMonthToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMultiStepRule())
			return getMultiStepToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNegationRule())
			return getNegationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNumberRule())
			return getNumberToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getORDERRule())
			return getORDERToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getPOWRule())
			return getPOWToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRelationRule())
			return getRelationToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSpecialIdentRule())
			return getSpecialIdentToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getTafCfsRule())
			return getTafCfsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getTimeStepRule())
			return getTimeStepToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getTimeStepValueRule())
			return getTimeStepValueToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ABS:
	 * 	'abs' | 'ABS';
	 */
	protected String getABSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "abs";
	}
	
	/**
	 * terminal ALWAYS:
	 * 	"always";
	 */
	protected String getALWAYSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "always";
	}
	
	/**
	 * BinaryOp:
	 * 	OR | AND;
	 */
	protected String getBinaryOpToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".or.";
	}
	
	/**
	 * ConditionalNegation:
	 * 	NOT;
	 */
	protected String getConditionalNegationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".not.";
	}
	
	/**
	 * terminal Else : 'Else' | 'ELSE' | 'else' ;
	 */
	protected String getElseToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "Else";
	}
	
	/**
	 * terminal ElseIf : 'Elseif' | 'ELSEIF' | 'elseif' | 'ElseIf' ;
	 */
	protected String getElseIfToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "Elseif";
	}
	
	/**
	 * terminal ID: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal INT returns ecore::EInt: ('0'..'9')+;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal INTFUNC:
	 * 	'int' | 'INT';
	 */
	protected String getINTFUNCToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "int";
	}
	
	/**
	 * terminal If : 'If' | 'IF' | 'if' ;
	 */
	protected String getIfToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "If";
	}
	
	/**
	 * IncludeModel:
	 * 	("include" | "INCLUDE") ('model' | 'MODEL') ID;
	 */
	protected String getIncludeModelToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "includemodel";
	}
	
	/**
	 * terminal LOG:
	 * 	'log' | 'LOG' | 'log10' | 'LOG10';
	 */
	protected String getLOGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "log";
	}
	
	/**
	 * LogicalFunction:
	 * 	RangeFunction;
	 */
	protected String getLogicalFunctionToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "range(,,)";
	}
	
	/**
	 * terminal MAX:
	 * 	'max' | 'MAX';
	 */
	protected String getMAXToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "max";
	}
	
	/**
	 * terminal MIN:
	 * 	'min' | 'MIN';
	 */
	protected String getMINToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "min";
	}
	
	/**
	 * terminal MOD:
	 * 	'mod' | 'MOD';
	 */
	protected String getMODToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "mod";
	}
	
	/**
	 * Month: 'month';
	 */
	protected String getMonthToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "month";
	}
	
	/**
	 * MultiStep: '$m';
	 */
	protected String getMultiStepToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "$m";
	}
	
	/**
	 * Negation:
	 * 	'-';
	 */
	protected String getNegationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "-";
	}
	
	/**
	 * Number:
	 * 	INT | FLOAT;
	 */
	protected String getNumberToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal ORDER:
	 * 	"order";
	 */
	protected String getORDERToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "order";
	}
	
	/**
	 * terminal POW:
	 * 	'pow' | 'POW';
	 */
	protected String getPOWToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "pow";
	}
	
	/**
	 * Relation:
	 * 	'>' | '<' | '>=' | '<=' | '==' | '/=';
	 */
	protected String getRelationToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ">";
	}
	
	/**
	 * SpecialIdent: TafCfs|DaysIn|WaterYear|Month|CalendarMonth|PrevMonth|I;
	 */
	protected String getSpecialIdentToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "af_cfs";
	}
	
	/**
	 * TafCfs: AF_CFS|CF_SAF|CFS_TAF|TAF_CFS;
	 */
	protected String getTafCfsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "af_cfs";
	}
	
	/**
	 * TimeStep: 'timestep';
	 */
	protected String getTimeStepToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "timestep";
	}
	
	/**
	 * TimeStepValue: '1MON'|'1DAY';
	 */
	protected String getTimeStepValueToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "1MON";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0.equals(syntax))
				emit_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_ALIASKeyword_5_1_or_AliasKeyword_5_0.equals(syntax))
				emit_Alias_ALIASKeyword_5_1_or_AliasKeyword_5_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0.equals(syntax))
				emit_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_KINDKeyword_7_0_1_or_KindKeyword_7_0_0.equals(syntax))
				emit_Alias_KINDKeyword_7_0_1_or_KindKeyword_7_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Alias_UNITSKeyword_8_0_1_or_UnitsKeyword_8_0_0.equals(syntax))
				emit_Alias_UNITSKeyword_8_0_1_or_UnitsKeyword_8_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0.equals(syntax))
				emit_CaseContent_CASEKeyword_0_1_or_CaseKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0.equals(syntax))
				emit_Condition_CONDITIONKeyword_0_1_or_ConditionKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConditionalUnary_ConditionalNegationParserRuleCall_0_q.equals(syntax))
				emit_ConditionalUnary_ConditionalNegationParserRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ConstDef_CONSTKeyword_0_1_or_ConstKeyword_0_0_or_ConstKeyword_0_2.equals(syntax))
				emit_ConstDef_CONSTKeyword_0_1_or_ConstKeyword_0_0_or_ConstKeyword_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
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
			else if(match_DvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0.equals(syntax))
				emit_DvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DvarDef_DVARKeyword_1_0_1_or_DvarKeyword_1_0_0_or_DvarKeyword_1_0_2.equals(syntax))
				emit_DvarDef_DVARKeyword_1_0_1_or_DvarKeyword_1_0_0_or_DvarKeyword_1_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExternalDef_DEFINEKeyword_0_1_or_DefineKeyword_0_0.equals(syntax))
				emit_ExternalDef_DEFINEKeyword_0_1_or_DefineKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExternalFunction_MonthParserRuleCall_0_2_or_TafCfsParserRuleCall_0_1.equals(syntax))
				emit_ExternalFunction_MonthParserRuleCall_0_2_or_TafCfsParserRuleCall_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
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
			else if(match_Initial_INITIALKeyword_0_2_or_InitialKeyword_0_0_or_InitialKeyword_0_1.equals(syntax))
				emit_Initial_INITIALKeyword_0_2_or_InitialKeyword_0_0_or_InitialKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
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
			else if(match_Objective_EqualsSignKeyword_3_q.equals(syntax))
				emit_Objective_EqualsSignKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
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
			else if(match_Sequence___TimeStepParserRuleCall_7_0_TimeStepValueParserRuleCall_7_1__q.equals(syntax))
				emit_Sequence___TimeStepParserRuleCall_7_0_TimeStepValueParserRuleCall_7_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0.equals(syntax))
				emit_SumContent_SUMKeyword_0_1_or_SumKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q.equals(syntax))
				emit_SumHeader___CommaKeyword_5_0_HyphenMinusKeyword_5_1_q_INTTerminalRuleCall_5_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0.equals(syntax))
				emit_SvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SvarDef_SVARKeyword_1_0_1_or_SvarKeyword_1_0_0_or_SvarKeyword_1_0_2.equals(syntax))
				emit_SvarDef_SVARKeyword_1_0_1_or_SvarKeyword_1_0_0_or_SvarKeyword_1_0_2(semanticObject, getLastNavigableState(), syntaxNodes);
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
			else if(match_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1_or_SpecialIdentParserRuleCall_3.equals(syntax))
				emit_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1_or_SpecialIdentParserRuleCall_3(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q.equals(syntax))
				emit_Unary___NegationParserRuleCall_0_1_or_PlusSignKeyword_0_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0.equals(syntax))
				emit_Upper_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0.equals(syntax))
				emit_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0.equals(syntax))
				emit_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_WeightItem_CommaKeyword_6_q.equals(syntax))
				emit_WeightItem_CommaKeyword_6_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '+' | '-'
	 */
	protected void emit_Add_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'alias' | 'ALIAS'
	 */
	protected void emit_Alias_ALIASKeyword_5_1_or_AliasKeyword_5_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'DEFINE' | 'define'
	 */
	protected void emit_Alias_DEFINEKeyword_0_1_or_DefineKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'KIND' | 'kind'
	 */
	protected void emit_Alias_KINDKeyword_7_0_1_or_KindKeyword_7_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_Alias_UNITSKeyword_8_0_1_or_UnitsKeyword_8_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'condition' | 'CONDITION'
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
	 *     'CONST' | 'Const' | 'const'
	 */
	protected void emit_ConstDef_CONSTKeyword_0_1_or_ConstKeyword_0_0_or_ConstKeyword_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'kind' | 'KIND'
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
	 *     'INTEGER' | 'integer'
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
	 *     'define' | 'DEFINE'
	 */
	protected void emit_DvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'Dvar' | 'DVAR' | 'dvar'
	 */
	protected void emit_DvarDef_DVARKeyword_1_0_1_or_DvarKeyword_1_0_0_or_DvarKeyword_1_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'define' | 'DEFINE'
	 */
	protected void emit_ExternalDef_DEFINEKeyword_0_1_or_DefineKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     Month | TafCfs
	 */
	protected void emit_ExternalFunction_MonthParserRuleCall_0_2_or_TafCfsParserRuleCall_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'EXTERNAL' | 'external'
	 */
	protected void emit_External_EXTERNALKeyword_0_1_or_ExternalKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'f90' | 'F90'
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
	 *     'LHS' | 'lhs'
	 */
	protected void emit_GoalCase_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'rhs' | 'RHS'
	 */
	protected void emit_GoalNoCaseContent_RHSKeyword_0_1_or_RhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'goal' | 'GOAL'
	 */
	protected void emit_Goal_GOALKeyword_0_1_or_GoalKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'include' | 'INCLUDE'
	 */
	protected void emit_IncludeFile_INCLUDEKeyword_0_1_or_IncludeKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'INITIAL' | 'Initial' | 'initial'
	 */
	protected void emit_Initial_INITIALKeyword_0_2_or_InitialKeyword_0_0_or_InitialKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'lhs' | 'LHS'
	 */
	protected void emit_LhsGtRhs_LHSKeyword_0_1_or_LhsKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'RHS' | 'rhs'
	 */
	protected void emit_LhsGtRhs_RHSKeyword_2_1_or_RhsKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'constrain' | 'CONSTRAIN'
	 */
	protected void emit_LhsLtRhs_CONSTRAINKeyword_3_0_1_1_or_ConstrainKeyword_3_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'lhs' | 'LHS'
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
	 *     'unbounded' | 'UNBOUNDED'
	 */
	protected void emit_Lower_UNBOUNDEDKeyword_1_0_1_1_or_UnboundedKeyword_1_0_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'MODEL' | 'model'
	 */
	protected void emit_Model_MODELKeyword_0_1_or_ModelKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '/' | '*'
	 */
	protected void emit_Multiply_AsteriskKeyword_1_0_0_or_SolidusKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '='?
	 */
	protected void emit_Objective_EqualsSignKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'penalty' | 'PENALTY'
	 */
	protected void emit_Penalty_PENALTYKeyword_0_1_or_PenaltyKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'convert' | 'CONVERT'
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
	 *     'TIMESERIES' | 'timeseries'
	 */
	protected void emit_SVarDSS_TIMESERIESKeyword_0_1_or_TimeseriesKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'units' | 'UNITS'
	 */
	protected void emit_SVarDSS_UNITSKeyword_4_1_or_UnitsKeyword_4_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'VALUE' | 'value'
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
	 *     (TimeStep TimeStepValue)?
	 */
	protected void emit_Sequence___TimeStepParserRuleCall_7_0_TimeStepValueParserRuleCall_7_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'define' | 'DEFINE'
	 */
	protected void emit_SvarDef_DEFINEKeyword_0_0_1_or_DefineKeyword_0_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'SVAR' | 'svar' | 'Svar'
	 */
	protected void emit_SvarDef_SVARKeyword_1_0_1_or_SvarKeyword_1_0_0_or_SvarKeyword_1_0_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'FROM' | 'from'
	 */
	protected void emit_TableContent_FROMKeyword_2_1_or_FromKeyword_2_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'GIVEN' | 'given'
	 */
	protected void emit_TableContent_GIVENKeyword_4_0_1_or_GivenKeyword_4_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'select' | 'SELECT'
	 */
	protected void emit_TableContent_SELECTKeyword_0_1_or_SelectKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'use' | 'USE'
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
	 *     ID | SpecialIdent | Number
	 */
	protected void emit_TermSimple_IDTerminalRuleCall_0_or_NumberParserRuleCall_1_or_SpecialIdentParserRuleCall_3(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     'UPPER' | 'upper'
	 */
	protected void emit_Upper_UPPERKeyword_0_1_or_UpperKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'value' | 'VALUE'
	 */
	protected void emit_ValueContent_VALUEKeyword_0_1_or_ValueKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_WeightItem_CommaKeyword_6_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

/**
 * <copyright>
 * </copyright>
 *

 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WreslEditorFactoryImpl extends EFactoryImpl implements WreslEditorFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WreslEditorFactory init()
  {
    try
    {
      WreslEditorFactory theWreslEditorFactory = (WreslEditorFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ca.gov/dwr/wresl/xtext/editor/WreslEditor"); 
      if (theWreslEditorFactory != null)
      {
        return theWreslEditorFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new WreslEditorFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WreslEditorFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case WreslEditorPackage.WRESL_EVALUATOR: return createWreslEvaluator();
      case WreslEditorPackage.PATTERN: return createPattern();
      case WreslEditorPackage.OBJECTIVE: return createObjective();
      case WreslEditorPackage.WEIGHT_ITEM: return createWeightItem();
      case WreslEditorPackage.DEFINE: return createDefine();
      case WreslEditorPackage.EXTERNAL: return createExternal();
      case WreslEditorPackage.ALIAS: return createAlias();
      case WreslEditorPackage.DVAR: return createDVar();
      case WreslEditorPackage.DVAR_NON_STD: return createDVarNonStd();
      case WreslEditorPackage.DVAR_STD: return createDVarStd();
      case WreslEditorPackage.DVAR_INTEGER: return createDVarInteger();
      case WreslEditorPackage.DVAR_INTEGER_STD: return createDVarIntegerStd();
      case WreslEditorPackage.DVAR_INTEGER_NON_STD: return createDVarIntegerNonStd();
      case WreslEditorPackage.SVAR: return createSVar();
      case WreslEditorPackage.SVAR_DSS: return createSVarDSS();
      case WreslEditorPackage.SVAR_EXPRESSION: return createSVarExpression();
      case WreslEditorPackage.SVAR_SUM: return createSVarSum();
      case WreslEditorPackage.SVAR_TABLE: return createSVarTable();
      case WreslEditorPackage.SVAR_CASE: return createSVarCase();
      case WreslEditorPackage.CASE_CONTENT: return createCaseContent();
      case WreslEditorPackage.SUM_CONTENT: return createSumContent();
      case WreslEditorPackage.SUM_HEADER: return createSumHeader();
      case WreslEditorPackage.VALUE_CONTENT: return createValueContent();
      case WreslEditorPackage.TABLE_CONTENT: return createTableContent();
      case WreslEditorPackage.WHERE_ITEMS: return createWhereItems();
      case WreslEditorPackage.ASSIGNMENT: return createAssignment();
      case WreslEditorPackage.LOWER_AND_OR_UPPER: return createLowerAndOrUpper();
      case WreslEditorPackage.UPPER_LOWER: return createupperLower();
      case WreslEditorPackage.LOWER_UPPER: return createlowerUpper();
      case WreslEditorPackage.UPPER: return createUpper();
      case WreslEditorPackage.LOWER: return createLower();
      case WreslEditorPackage.GOAL: return createGoal();
      case WreslEditorPackage.GOAL_CASE: return createGoalCase();
      case WreslEditorPackage.GOAL_CASE_CONTENT: return createGoalCaseContent();
      case WreslEditorPackage.GOAL_NO_CASE_CONTENT: return createGoalNoCaseContent();
      case WreslEditorPackage.SUB_CONTENT: return createSubContent();
      case WreslEditorPackage.LHS_GT_RHS: return createLhsGtRhs();
      case WreslEditorPackage.LHS_LT_RHS: return createLhsLtRhs();
      case WreslEditorPackage.PENALTY: return createPenalty();
      case WreslEditorPackage.GOAL_SIMPLE: return createGoalSimple();
      case WreslEditorPackage.CONSTRAINT: return createConstraint();
      case WreslEditorPackage.MODEL: return createModel();
      case WreslEditorPackage.SEQUENCE: return createSequence();
      case WreslEditorPackage.CONDITION: return createCondition();
      case WreslEditorPackage.INCLUDE_FILE: return createIncludeFile();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WreslEvaluator createWreslEvaluator()
  {
    WreslEvaluatorImpl wreslEvaluator = new WreslEvaluatorImpl();
    return wreslEvaluator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern createPattern()
  {
    PatternImpl pattern = new PatternImpl();
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Objective createObjective()
  {
    ObjectiveImpl objective = new ObjectiveImpl();
    return objective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeightItem createWeightItem()
  {
    WeightItemImpl weightItem = new WeightItemImpl();
    return weightItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Define createDefine()
  {
    DefineImpl define = new DefineImpl();
    return define;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public External createExternal()
  {
    ExternalImpl external = new ExternalImpl();
    return external;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Alias createAlias()
  {
    AliasImpl alias = new AliasImpl();
    return alias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DVar createDVar()
  {
    DVarImpl dVar = new DVarImpl();
    return dVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DVarNonStd createDVarNonStd()
  {
    DVarNonStdImpl dVarNonStd = new DVarNonStdImpl();
    return dVarNonStd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DVarStd createDVarStd()
  {
    DVarStdImpl dVarStd = new DVarStdImpl();
    return dVarStd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DVarInteger createDVarInteger()
  {
    DVarIntegerImpl dVarInteger = new DVarIntegerImpl();
    return dVarInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DVarIntegerStd createDVarIntegerStd()
  {
    DVarIntegerStdImpl dVarIntegerStd = new DVarIntegerStdImpl();
    return dVarIntegerStd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DVarIntegerNonStd createDVarIntegerNonStd()
  {
    DVarIntegerNonStdImpl dVarIntegerNonStd = new DVarIntegerNonStdImpl();
    return dVarIntegerNonStd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SVar createSVar()
  {
    SVarImpl sVar = new SVarImpl();
    return sVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SVarDSS createSVarDSS()
  {
    SVarDSSImpl sVarDSS = new SVarDSSImpl();
    return sVarDSS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SVarExpression createSVarExpression()
  {
    SVarExpressionImpl sVarExpression = new SVarExpressionImpl();
    return sVarExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SVarSum createSVarSum()
  {
    SVarSumImpl sVarSum = new SVarSumImpl();
    return sVarSum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SVarTable createSVarTable()
  {
    SVarTableImpl sVarTable = new SVarTableImpl();
    return sVarTable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SVarCase createSVarCase()
  {
    SVarCaseImpl sVarCase = new SVarCaseImpl();
    return sVarCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CaseContent createCaseContent()
  {
    CaseContentImpl caseContent = new CaseContentImpl();
    return caseContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SumContent createSumContent()
  {
    SumContentImpl sumContent = new SumContentImpl();
    return sumContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SumHeader createSumHeader()
  {
    SumHeaderImpl sumHeader = new SumHeaderImpl();
    return sumHeader;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueContent createValueContent()
  {
    ValueContentImpl valueContent = new ValueContentImpl();
    return valueContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TableContent createTableContent()
  {
    TableContentImpl tableContent = new TableContentImpl();
    return tableContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhereItems createWhereItems()
  {
    WhereItemsImpl whereItems = new WhereItemsImpl();
    return whereItems;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LowerAndOrUpper createLowerAndOrUpper()
  {
    LowerAndOrUpperImpl lowerAndOrUpper = new LowerAndOrUpperImpl();
    return lowerAndOrUpper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public upperLower createupperLower()
  {
    upperLowerImpl upperLower = new upperLowerImpl();
    return upperLower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public lowerUpper createlowerUpper()
  {
    lowerUpperImpl lowerUpper = new lowerUpperImpl();
    return lowerUpper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Upper createUpper()
  {
    UpperImpl upper = new UpperImpl();
    return upper;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lower createLower()
  {
    LowerImpl lower = new LowerImpl();
    return lower;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Goal createGoal()
  {
    GoalImpl goal = new GoalImpl();
    return goal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GoalCase createGoalCase()
  {
    GoalCaseImpl goalCase = new GoalCaseImpl();
    return goalCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GoalCaseContent createGoalCaseContent()
  {
    GoalCaseContentImpl goalCaseContent = new GoalCaseContentImpl();
    return goalCaseContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GoalNoCaseContent createGoalNoCaseContent()
  {
    GoalNoCaseContentImpl goalNoCaseContent = new GoalNoCaseContentImpl();
    return goalNoCaseContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubContent createSubContent()
  {
    SubContentImpl subContent = new SubContentImpl();
    return subContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LhsGtRhs createLhsGtRhs()
  {
    LhsGtRhsImpl lhsGtRhs = new LhsGtRhsImpl();
    return lhsGtRhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LhsLtRhs createLhsLtRhs()
  {
    LhsLtRhsImpl lhsLtRhs = new LhsLtRhsImpl();
    return lhsLtRhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Penalty createPenalty()
  {
    PenaltyImpl penalty = new PenaltyImpl();
    return penalty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GoalSimple createGoalSimple()
  {
    GoalSimpleImpl goalSimple = new GoalSimpleImpl();
    return goalSimple;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence createSequence()
  {
    SequenceImpl sequence = new SequenceImpl();
    return sequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Condition createCondition()
  {
    ConditionImpl condition = new ConditionImpl();
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeFile createIncludeFile()
  {
    IncludeFileImpl includeFile = new IncludeFileImpl();
    return includeFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WreslEditorPackage getWreslEditorPackage()
  {
    return (WreslEditorPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static WreslEditorPackage getPackage()
  {
    return WreslEditorPackage.eINSTANCE;
  }

} //WreslEditorFactoryImpl

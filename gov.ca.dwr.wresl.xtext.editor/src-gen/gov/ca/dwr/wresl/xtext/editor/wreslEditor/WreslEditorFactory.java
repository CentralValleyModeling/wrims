/**
 * <copyright>
 * </copyright>
 *

 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage
 * @generated
 */
public interface WreslEditorFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  WreslEditorFactory eINSTANCE = gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Wresl Evaluator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Wresl Evaluator</em>'.
   * @generated
   */
  WreslEvaluator createWreslEvaluator();

  /**
   * Returns a new object of class '<em>Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pattern</em>'.
   * @generated
   */
  Pattern createPattern();

  /**
   * Returns a new object of class '<em>Objective</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Objective</em>'.
   * @generated
   */
  Objective createObjective();

  /**
   * Returns a new object of class '<em>Weight Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Weight Item</em>'.
   * @generated
   */
  WeightItem createWeightItem();

  /**
   * Returns a new object of class '<em>Define</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Define</em>'.
   * @generated
   */
  Define createDefine();

  /**
   * Returns a new object of class '<em>Svar Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Svar Def</em>'.
   * @generated
   */
  SvarDef createSvarDef();

  /**
   * Returns a new object of class '<em>Dvar Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dvar Def</em>'.
   * @generated
   */
  DvarDef createDvarDef();

  /**
   * Returns a new object of class '<em>Const Def</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Const Def</em>'.
   * @generated
   */
  ConstDef createConstDef();

  /**
   * Returns a new object of class '<em>External</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External</em>'.
   * @generated
   */
  External createExternal();

  /**
   * Returns a new object of class '<em>Alias</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alias</em>'.
   * @generated
   */
  Alias createAlias();

  /**
   * Returns a new object of class '<em>DVar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DVar</em>'.
   * @generated
   */
  DVar createDVar();

  /**
   * Returns a new object of class '<em>DVar Non Std</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DVar Non Std</em>'.
   * @generated
   */
  DVarNonStd createDVarNonStd();

  /**
   * Returns a new object of class '<em>DVar Std</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DVar Std</em>'.
   * @generated
   */
  DVarStd createDVarStd();

  /**
   * Returns a new object of class '<em>DVar Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DVar Integer</em>'.
   * @generated
   */
  DVarInteger createDVarInteger();

  /**
   * Returns a new object of class '<em>DVar Integer Std</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DVar Integer Std</em>'.
   * @generated
   */
  DVarIntegerStd createDVarIntegerStd();

  /**
   * Returns a new object of class '<em>DVar Integer Non Std</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DVar Integer Non Std</em>'.
   * @generated
   */
  DVarIntegerNonStd createDVarIntegerNonStd();

  /**
   * Returns a new object of class '<em>SVar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SVar</em>'.
   * @generated
   */
  SVar createSVar();

  /**
   * Returns a new object of class '<em>SVar DSS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SVar DSS</em>'.
   * @generated
   */
  SVarDSS createSVarDSS();

  /**
   * Returns a new object of class '<em>SVar Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SVar Expression</em>'.
   * @generated
   */
  SVarExpression createSVarExpression();

  /**
   * Returns a new object of class '<em>SVar Sum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SVar Sum</em>'.
   * @generated
   */
  SVarSum createSVarSum();

  /**
   * Returns a new object of class '<em>SVar Table</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SVar Table</em>'.
   * @generated
   */
  SVarTable createSVarTable();

  /**
   * Returns a new object of class '<em>SVar Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>SVar Case</em>'.
   * @generated
   */
  SVarCase createSVarCase();

  /**
   * Returns a new object of class '<em>Case Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Case Content</em>'.
   * @generated
   */
  CaseContent createCaseContent();

  /**
   * Returns a new object of class '<em>Sum Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sum Content</em>'.
   * @generated
   */
  SumContent createSumContent();

  /**
   * Returns a new object of class '<em>Sum Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sum Header</em>'.
   * @generated
   */
  SumHeader createSumHeader();

  /**
   * Returns a new object of class '<em>Value Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Content</em>'.
   * @generated
   */
  ValueContent createValueContent();

  /**
   * Returns a new object of class '<em>Table Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Content</em>'.
   * @generated
   */
  TableContent createTableContent();

  /**
   * Returns a new object of class '<em>Where Items</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Where Items</em>'.
   * @generated
   */
  WhereItems createWhereItems();

  /**
   * Returns a new object of class '<em>Assignment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assignment</em>'.
   * @generated
   */
  Assignment createAssignment();

  /**
   * Returns a new object of class '<em>Term Simple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term Simple</em>'.
   * @generated
   */
  TermSimple createTermSimple();

  /**
   * Returns a new object of class '<em>Lower And Or Upper</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lower And Or Upper</em>'.
   * @generated
   */
  LowerAndOrUpper createLowerAndOrUpper();

  /**
   * Returns a new object of class '<em>upper Lower</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>upper Lower</em>'.
   * @generated
   */
  upperLower createupperLower();

  /**
   * Returns a new object of class '<em>lower Upper</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>lower Upper</em>'.
   * @generated
   */
  lowerUpper createlowerUpper();

  /**
   * Returns a new object of class '<em>Upper</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Upper</em>'.
   * @generated
   */
  Upper createUpper();

  /**
   * Returns a new object of class '<em>Lower</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lower</em>'.
   * @generated
   */
  Lower createLower();

  /**
   * Returns a new object of class '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal</em>'.
   * @generated
   */
  Goal createGoal();

  /**
   * Returns a new object of class '<em>Goal Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal Case</em>'.
   * @generated
   */
  GoalCase createGoalCase();

  /**
   * Returns a new object of class '<em>Goal Case Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal Case Content</em>'.
   * @generated
   */
  GoalCaseContent createGoalCaseContent();

  /**
   * Returns a new object of class '<em>Goal No Case Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal No Case Content</em>'.
   * @generated
   */
  GoalNoCaseContent createGoalNoCaseContent();

  /**
   * Returns a new object of class '<em>Sub Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Content</em>'.
   * @generated
   */
  SubContent createSubContent();

  /**
   * Returns a new object of class '<em>Lhs Gt Rhs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lhs Gt Rhs</em>'.
   * @generated
   */
  LhsGtRhs createLhsGtRhs();

  /**
   * Returns a new object of class '<em>Lhs Lt Rhs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lhs Lt Rhs</em>'.
   * @generated
   */
  LhsLtRhs createLhsLtRhs();

  /**
   * Returns a new object of class '<em>Penalty</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Penalty</em>'.
   * @generated
   */
  Penalty createPenalty();

  /**
   * Returns a new object of class '<em>Goal Simple</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Goal Simple</em>'.
   * @generated
   */
  GoalSimple createGoalSimple();

  /**
   * Returns a new object of class '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint</em>'.
   * @generated
   */
  Constraint createConstraint();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Initial</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Initial</em>'.
   * @generated
   */
  Initial createInitial();

  /**
   * Returns a new object of class '<em>Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence</em>'.
   * @generated
   */
  Sequence createSequence();

  /**
   * Returns a new object of class '<em>Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition</em>'.
   * @generated
   */
  Condition createCondition();

  /**
   * Returns a new object of class '<em>Logical Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Expression</em>'.
   * @generated
   */
  LogicalExpression createLogicalExpression();

  /**
   * Returns a new object of class '<em>Conditional Unary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Unary</em>'.
   * @generated
   */
  ConditionalUnary createConditionalUnary();

  /**
   * Returns a new object of class '<em>Conditional Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Term</em>'.
   * @generated
   */
  ConditionalTerm createConditionalTerm();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Add</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Add</em>'.
   * @generated
   */
  Add createAdd();

  /**
   * Returns a new object of class '<em>Multiply</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiply</em>'.
   * @generated
   */
  Multiply createMultiply();

  /**
   * Returns a new object of class '<em>Unary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary</em>'.
   * @generated
   */
  Unary createUnary();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>External Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Function</em>'.
   * @generated
   */
  ExternalFunction createExternalFunction();

  /**
   * Returns a new object of class '<em>Max Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Max Function</em>'.
   * @generated
   */
  MaxFunction createMaxFunction();

  /**
   * Returns a new object of class '<em>Min Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Min Function</em>'.
   * @generated
   */
  MinFunction createMinFunction();

  /**
   * Returns a new object of class '<em>Int Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int Function</em>'.
   * @generated
   */
  IntFunction createIntFunction();

  /**
   * Returns a new object of class '<em>Ident</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ident</em>'.
   * @generated
   */
  Ident createIdent();

  /**
   * Returns a new object of class '<em>Include File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include File</em>'.
   * @generated
   */
  IncludeFile createIncludeFile();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  WreslEditorPackage getWreslEditorPackage();

} //WreslEditorFactory

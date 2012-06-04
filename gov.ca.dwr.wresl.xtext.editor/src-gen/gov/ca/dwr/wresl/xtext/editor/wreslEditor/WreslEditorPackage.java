/**
 * <copyright>
 * </copyright>
 *

 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorFactory
 * @model kind="package"
 * @generated
 */
public interface WreslEditorPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "wreslEditor";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ca.gov/dwr/wresl/xtext/editor/WreslEditor";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "wreslEditor";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  WreslEditorPackage eINSTANCE = gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl.init();

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEvaluatorImpl <em>Wresl Evaluator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEvaluatorImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getWreslEvaluator()
   * @generated
   */
  int WRESL_EVALUATOR = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__PATTERN = 0;

  /**
   * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__SEQUENCE = 1;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR__MODEL = 2;

  /**
   * The number of structural features of the '<em>Wresl Evaluator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRESL_EVALUATOR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PatternImpl <em>Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PatternImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getPattern()
   * @generated
   */
  int PATTERN = 1;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN__LOCAL = 0;

  /**
   * The number of structural features of the '<em>Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ObjectiveImpl <em>Objective</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ObjectiveImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getObjective()
   * @generated
   */
  int OBJECTIVE = 2;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE__NAME = PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Weights</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE__WEIGHTS = PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Objective</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECTIVE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WeightItemImpl <em>Weight Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WeightItemImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getWeightItem()
   * @generated
   */
  int WEIGHT_ITEM = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM__NAME = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Weight Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEIGHT_ITEM_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DefineImpl <em>Define</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DefineImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDefine()
   * @generated
   */
  int DEFINE = 4;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE__NAME = PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE__DEFINITION = PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Define</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalImpl <em>External</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getExternal()
   * @generated
   */
  int EXTERNAL = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL__NAME = 0;

  /**
   * The number of structural features of the '<em>External</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl <em>Alias</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getAlias()
   * @generated
   */
  int ALIAS = 6;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__LOCAL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__NAME = 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__KIND = 3;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS__UNITS = 4;

  /**
   * The number of structural features of the '<em>Alias</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarImpl <em>DVar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVar()
   * @generated
   */
  int DVAR = 7;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR__KIND = 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR__UNITS = 1;

  /**
   * The number of structural features of the '<em>DVar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarNonStdImpl <em>DVar Non Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarNonStdImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarNonStd()
   * @generated
   */
  int DVAR_NON_STD = 8;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD__KIND = DVAR__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD__UNITS = DVAR__UNITS;

  /**
   * The feature id for the '<em><b>Lower Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD__LOWER_UPPER = DVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>DVar Non Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_NON_STD_FEATURE_COUNT = DVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarStdImpl <em>DVar Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarStdImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarStd()
   * @generated
   */
  int DVAR_STD = 9;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_STD__KIND = DVAR__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_STD__UNITS = DVAR__UNITS;

  /**
   * The number of structural features of the '<em>DVar Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_STD_FEATURE_COUNT = DVAR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl <em>DVar Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarInteger()
   * @generated
   */
  int DVAR_INTEGER = 10;

  /**
   * The number of structural features of the '<em>DVar Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerStdImpl <em>DVar Integer Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerStdImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarIntegerStd()
   * @generated
   */
  int DVAR_INTEGER_STD = 11;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_STD__KIND = DVAR_INTEGER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_STD__UNITS = DVAR_INTEGER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>DVar Integer Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_STD_FEATURE_COUNT = DVAR_INTEGER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerNonStdImpl <em>DVar Integer Non Std</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerNonStdImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarIntegerNonStd()
   * @generated
   */
  int DVAR_INTEGER_NON_STD = 12;

  /**
   * The number of structural features of the '<em>DVar Integer Non Std</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DVAR_INTEGER_NON_STD_FEATURE_COUNT = DVAR_INTEGER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarImpl <em>SVar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVar()
   * @generated
   */
  int SVAR = 13;

  /**
   * The number of structural features of the '<em>SVar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarDSSImpl <em>SVar DSS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarDSSImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarDSS()
   * @generated
   */
  int SVAR_DSS = 14;

  /**
   * The feature id for the '<em><b>BPart</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__BPART = SVAR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__KIND = SVAR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__UNITS = SVAR_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS__CONVERT = SVAR_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>SVar DSS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_DSS_FEATURE_COUNT = SVAR_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarExpressionImpl <em>SVar Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarExpressionImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarExpression()
   * @generated
   */
  int SVAR_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_EXPRESSION__EXPRESSION = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_EXPRESSION_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarSumImpl <em>SVar Sum</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarSumImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarSum()
   * @generated
   */
  int SVAR_SUM = 16;

  /**
   * The feature id for the '<em><b>Sum Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_SUM__SUM_CONTENT = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Sum</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_SUM_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarTableImpl <em>SVar Table</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarTableImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarTable()
   * @generated
   */
  int SVAR_TABLE = 17;

  /**
   * The feature id for the '<em><b>Table Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_TABLE__TABLE_CONTENT = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Table</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_TABLE_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarCaseImpl <em>SVar Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarCaseImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarCase()
   * @generated
   */
  int SVAR_CASE = 18;

  /**
   * The feature id for the '<em><b>Case Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_CASE__CASE_CONTENT = SVAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SVar Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SVAR_CASE_FEATURE_COUNT = SVAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.CaseContentImpl <em>Case Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.CaseContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getCaseContent()
   * @generated
   */
  int CASE_CONTENT = 19;

  /**
   * The feature id for the '<em><b>Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT__CASE_NAME = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT__CONTENT = 2;

  /**
   * The number of structural features of the '<em>Case Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CASE_CONTENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumContentImpl <em>Sum Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSumContent()
   * @generated
   */
  int SUM_CONTENT = 20;

  /**
   * The feature id for the '<em><b>Header</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_CONTENT__HEADER = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_CONTENT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Sum Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_CONTENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl <em>Sum Header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSumHeader()
   * @generated
   */
  int SUM_HEADER = 21;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_HEADER__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_HEADER__EXPRESSION2 = 1;

  /**
   * The number of structural features of the '<em>Sum Header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_HEADER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ValueContentImpl <em>Value Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ValueContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getValueContent()
   * @generated
   */
  int VALUE_CONTENT = 22;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONTENT__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Value Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_CONTENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.TableContentImpl <em>Table Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.TableContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getTableContent()
   * @generated
   */
  int TABLE_CONTENT = 23;

  /**
   * The feature id for the '<em><b>Table Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__TABLE_NAME = 0;

  /**
   * The feature id for the '<em><b>From</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__FROM = 1;

  /**
   * The feature id for the '<em><b>Given</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__GIVEN = 2;

  /**
   * The feature id for the '<em><b>Use</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__USE = 3;

  /**
   * The feature id for the '<em><b>Where</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT__WHERE = 4;

  /**
   * The number of structural features of the '<em>Table Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_CONTENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WhereItemsImpl <em>Where Items</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WhereItemsImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getWhereItems()
   * @generated
   */
  int WHERE_ITEMS = 24;

  /**
   * The feature id for the '<em><b>Assignment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHERE_ITEMS__ASSIGNMENT = 0;

  /**
   * The number of structural features of the '<em>Where Items</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHERE_ITEMS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AssignmentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 25;

  /**
   * The feature id for the '<em><b>Term</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__TERM = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerAndOrUpperImpl <em>Lower And Or Upper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerAndOrUpperImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLowerAndOrUpper()
   * @generated
   */
  int LOWER_AND_OR_UPPER = 26;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__KIND = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__UNITS = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__UPPER = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER__LOWER = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Lower And Or Upper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_AND_OR_UPPER_FEATURE_COUNT = DVAR_INTEGER_NON_STD_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.upperLowerImpl <em>upper Lower</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.upperLowerImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getupperLower()
   * @generated
   */
  int UPPER_LOWER = 27;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__KIND = LOWER_AND_OR_UPPER__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__UNITS = LOWER_AND_OR_UPPER__UNITS;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__UPPER = LOWER_AND_OR_UPPER__UPPER;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER__LOWER = LOWER_AND_OR_UPPER__LOWER;

  /**
   * The number of structural features of the '<em>upper Lower</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_LOWER_FEATURE_COUNT = LOWER_AND_OR_UPPER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.lowerUpperImpl <em>lower Upper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.lowerUpperImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getlowerUpper()
   * @generated
   */
  int LOWER_UPPER = 28;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__KIND = LOWER_AND_OR_UPPER__KIND;

  /**
   * The feature id for the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__UNITS = LOWER_AND_OR_UPPER__UNITS;

  /**
   * The feature id for the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__UPPER = LOWER_AND_OR_UPPER__UPPER;

  /**
   * The feature id for the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER__LOWER = LOWER_AND_OR_UPPER__LOWER;

  /**
   * The number of structural features of the '<em>lower Upper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_UPPER_FEATURE_COUNT = LOWER_AND_OR_UPPER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.UpperImpl <em>Upper</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.UpperImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getUpper()
   * @generated
   */
  int UPPER = 29;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Upper</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UPPER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerImpl <em>Lower</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLower()
   * @generated
   */
  int LOWER = 30;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Lower</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOWER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 31;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__NAME = PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DEFINITION = PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseImpl <em>Goal Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalCase()
   * @generated
   */
  int GOAL_CASE = 32;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE__LHS = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Case Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE__CASE_CONTENT = 2;

  /**
   * The number of structural features of the '<em>Goal Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseContentImpl <em>Goal Case Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalCaseContent()
   * @generated
   */
  int GOAL_CASE_CONTENT = 33;

  /**
   * The feature id for the '<em><b>Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__CASE_NAME = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__RHS = 2;

  /**
   * The feature id for the '<em><b>Sub Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT__SUB_CONTENT = 3;

  /**
   * The number of structural features of the '<em>Goal Case Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_CASE_CONTENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalNoCaseContentImpl <em>Goal No Case Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalNoCaseContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalNoCaseContent()
   * @generated
   */
  int GOAL_NO_CASE_CONTENT = 34;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_NO_CASE_CONTENT__RHS = 0;

  /**
   * The feature id for the '<em><b>Sub Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_NO_CASE_CONTENT__SUB_CONTENT = 1;

  /**
   * The number of structural features of the '<em>Goal No Case Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_NO_CASE_CONTENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SubContentImpl <em>Sub Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SubContentImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSubContent()
   * @generated
   */
  int SUB_CONTENT = 35;

  /**
   * The feature id for the '<em><b>Gt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CONTENT__GT = 0;

  /**
   * The feature id for the '<em><b>Lt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CONTENT__LT = 1;

  /**
   * The number of structural features of the '<em>Sub Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_CONTENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsGtRhsImpl <em>Lhs Gt Rhs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsGtRhsImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLhsGtRhs()
   * @generated
   */
  int LHS_GT_RHS = 36;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_GT_RHS__PENALTY = 0;

  /**
   * The number of structural features of the '<em>Lhs Gt Rhs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_GT_RHS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsLtRhsImpl <em>Lhs Lt Rhs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsLtRhsImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLhsLtRhs()
   * @generated
   */
  int LHS_LT_RHS = 37;

  /**
   * The feature id for the '<em><b>Penalty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_LT_RHS__PENALTY = 0;

  /**
   * The number of structural features of the '<em>Lhs Lt Rhs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LHS_LT_RHS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PenaltyImpl <em>Penalty</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PenaltyImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getPenalty()
   * @generated
   */
  int PENALTY = 38;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENALTY__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Penalty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PENALTY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalSimpleImpl <em>Goal Simple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalSimpleImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalSimple()
   * @generated
   */
  int GOAL_SIMPLE = 39;

  /**
   * The feature id for the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_SIMPLE__CONSTRAINT = 0;

  /**
   * The number of structural features of the '<em>Goal Simple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_SIMPLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConstraintImpl <em>Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConstraintImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getConstraint()
   * @generated
   */
  int CONSTRAINT = 40;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__LHS = 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__OPERATOR = 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__RHS = 2;

  /**
   * The number of structural features of the '<em>Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ModelImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getModel()
   * @generated
   */
  int MODEL = 41;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__PATTERN = 1;

  /**
   * The feature id for the '<em><b>Alias</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ALIAS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SequenceImpl <em>Sequence</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SequenceImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSequence()
   * @generated
   */
  int SEQUENCE = 42;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__MODEL = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__CONDITION = 2;

  /**
   * The feature id for the '<em><b>Order</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE__ORDER = 3;

  /**
   * The number of structural features of the '<em>Sequence</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEQUENCE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConditionImpl <em>Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConditionImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getCondition()
   * @generated
   */
  int CONDITION = 43;

  /**
   * The feature id for the '<em><b>Logical</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION__LOGICAL = 0;

  /**
   * The number of structural features of the '<em>Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.IncludeFileImpl <em>Include File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.IncludeFileImpl
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getIncludeFile()
   * @generated
   */
  int INCLUDE_FILE = 44;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FILE__LOCAL = PATTERN__LOCAL;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FILE__FILE = PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Include File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_FILE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator <em>Wresl Evaluator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wresl Evaluator</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator
   * @generated
   */
  EClass getWreslEvaluator();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator#getPattern()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Pattern();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator#getSequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sequence</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator#getSequence()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Sequence();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEvaluator#getModel()
   * @see #getWreslEvaluator()
   * @generated
   */
  EReference getWreslEvaluator_Model();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Pattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Pattern
   * @generated
   */
  EClass getPattern();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Pattern#isLocal <em>Local</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Pattern#isLocal()
   * @see #getPattern()
   * @generated
   */
  EAttribute getPattern_Local();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective <em>Objective</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Objective</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective
   * @generated
   */
  EClass getObjective();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective#getName()
   * @see #getObjective()
   * @generated
   */
  EAttribute getObjective_Name();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective#getWeights <em>Weights</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Weights</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Objective#getWeights()
   * @see #getObjective()
   * @generated
   */
  EReference getObjective_Weights();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem <em>Weight Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Weight Item</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem
   * @generated
   */
  EClass getWeightItem();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem#getName()
   * @see #getWeightItem()
   * @generated
   */
  EAttribute getWeightItem_Name();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WeightItem#getExpression()
   * @see #getWeightItem()
   * @generated
   */
  EAttribute getWeightItem_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define <em>Define</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Define</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define
   * @generated
   */
  EClass getDefine();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define#getName()
   * @see #getDefine()
   * @generated
   */
  EAttribute getDefine_Name();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Define#getDefinition()
   * @see #getDefine()
   * @generated
   */
  EReference getDefine_Definition();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.External <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.External
   * @generated
   */
  EClass getExternal();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.External#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.External#getName()
   * @see #getExternal()
   * @generated
   */
  EAttribute getExternal_Name();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alias</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias
   * @generated
   */
  EClass getAlias();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#isLocal <em>Local</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#isLocal()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Local();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getName()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Name();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getExpression()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Expression();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getKind()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Kind();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias#getUnits()
   * @see #getAlias()
   * @generated
   */
  EAttribute getAlias_Units();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar <em>DVar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar
   * @generated
   */
  EClass getDVar();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar#getKind()
   * @see #getDVar()
   * @generated
   */
  EAttribute getDVar_Kind();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVar#getUnits()
   * @see #getDVar()
   * @generated
   */
  EAttribute getDVar_Units();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarNonStd <em>DVar Non Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Non Std</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarNonStd
   * @generated
   */
  EClass getDVarNonStd();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarNonStd#getLowerUpper <em>Lower Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower Upper</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarNonStd#getLowerUpper()
   * @see #getDVarNonStd()
   * @generated
   */
  EReference getDVarNonStd_LowerUpper();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarStd <em>DVar Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Std</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarStd
   * @generated
   */
  EClass getDVarStd();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarInteger <em>DVar Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Integer</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarInteger
   * @generated
   */
  EClass getDVarInteger();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd <em>DVar Integer Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Integer Std</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd
   * @generated
   */
  EClass getDVarIntegerStd();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd#getKind()
   * @see #getDVarIntegerStd()
   * @generated
   */
  EAttribute getDVarIntegerStd_Kind();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerStd#getUnits()
   * @see #getDVarIntegerStd()
   * @generated
   */
  EAttribute getDVarIntegerStd_Units();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerNonStd <em>DVar Integer Non Std</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DVar Integer Non Std</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.DVarIntegerNonStd
   * @generated
   */
  EClass getDVarIntegerNonStd();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVar <em>SVar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVar
   * @generated
   */
  EClass getSVar();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS <em>SVar DSS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar DSS</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS
   * @generated
   */
  EClass getSVarDSS();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getBPart <em>BPart</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>BPart</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getBPart()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_BPart();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getKind()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_Kind();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getUnits()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_Units();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getConvert <em>Convert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Convert</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarDSS#getConvert()
   * @see #getSVarDSS()
   * @generated
   */
  EAttribute getSVarDSS_Convert();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarExpression <em>SVar Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarExpression
   * @generated
   */
  EClass getSVarExpression();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarExpression#getExpression()
   * @see #getSVarExpression()
   * @generated
   */
  EAttribute getSVarExpression_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarSum <em>SVar Sum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Sum</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarSum
   * @generated
   */
  EClass getSVarSum();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarSum#getSumContent <em>Sum Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sum Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarSum#getSumContent()
   * @see #getSVarSum()
   * @generated
   */
  EReference getSVarSum_SumContent();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarTable <em>SVar Table</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Table</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarTable
   * @generated
   */
  EClass getSVarTable();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarTable#getTableContent <em>Table Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Table Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarTable#getTableContent()
   * @see #getSVarTable()
   * @generated
   */
  EReference getSVarTable_TableContent();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarCase <em>SVar Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SVar Case</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarCase
   * @generated
   */
  EClass getSVarCase();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarCase#getCaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SVarCase#getCaseContent()
   * @see #getSVarCase()
   * @generated
   */
  EReference getSVarCase_CaseContent();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Case Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent
   * @generated
   */
  EClass getCaseContent();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent#getCaseName <em>Case Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Case Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent#getCaseName()
   * @see #getCaseContent()
   * @generated
   */
  EAttribute getCaseContent_CaseName();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent#getCondition()
   * @see #getCaseContent()
   * @generated
   */
  EReference getCaseContent_Condition();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.CaseContent#getContent()
   * @see #getCaseContent()
   * @generated
   */
  EReference getCaseContent_Content();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent <em>Sum Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sum Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent
   * @generated
   */
  EClass getSumContent();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent#getHeader <em>Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Header</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent#getHeader()
   * @see #getSumContent()
   * @generated
   */
  EReference getSumContent_Header();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumContent#getExpression()
   * @see #getSumContent()
   * @generated
   */
  EAttribute getSumContent_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader <em>Sum Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sum Header</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader
   * @generated
   */
  EClass getSumHeader();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression1</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader#getExpression1()
   * @see #getSumHeader()
   * @generated
   */
  EAttribute getSumHeader_Expression1();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader#getExpression2 <em>Expression2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression2</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader#getExpression2()
   * @see #getSumHeader()
   * @generated
   */
  EAttribute getSumHeader_Expression2();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ValueContent <em>Value Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.ValueContent
   * @generated
   */
  EClass getValueContent();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ValueContent#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.ValueContent#getExpression()
   * @see #getValueContent()
   * @generated
   */
  EAttribute getValueContent_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent <em>Table Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent
   * @generated
   */
  EClass getTableContent();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getTableName <em>Table Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Table Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getTableName()
   * @see #getTableContent()
   * @generated
   */
  EAttribute getTableContent_TableName();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getFrom <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>From</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getFrom()
   * @see #getTableContent()
   * @generated
   */
  EAttribute getTableContent_From();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getGiven <em>Given</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Given</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getGiven()
   * @see #getTableContent()
   * @generated
   */
  EReference getTableContent_Given();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getUse <em>Use</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getUse()
   * @see #getTableContent()
   * @generated
   */
  EAttribute getTableContent_Use();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getWhere <em>Where</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Where</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.TableContent#getWhere()
   * @see #getTableContent()
   * @generated
   */
  EReference getTableContent_Where();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WhereItems <em>Where Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Where Items</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WhereItems
   * @generated
   */
  EClass getWhereItems();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.WhereItems#getAssignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assignment</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WhereItems#getAssignment()
   * @see #getWhereItems()
   * @generated
   */
  EReference getWhereItems_Assignment();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment#getTerm <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Term</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment#getTerm()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Term();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Assignment#getExpression()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper <em>Lower And Or Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lower And Or Upper</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper
   * @generated
   */
  EClass getLowerAndOrUpper();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getKind()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EAttribute getLowerAndOrUpper_Kind();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getUnits <em>Units</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Units</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getUnits()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EAttribute getLowerAndOrUpper_Units();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getUpper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Upper</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getUpper()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EReference getLowerAndOrUpper_Upper();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getLower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lower</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LowerAndOrUpper#getLower()
   * @see #getLowerAndOrUpper()
   * @generated
   */
  EReference getLowerAndOrUpper_Lower();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.upperLower <em>upper Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>upper Lower</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.upperLower
   * @generated
   */
  EClass getupperLower();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.lowerUpper <em>lower Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>lower Upper</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.lowerUpper
   * @generated
   */
  EClass getlowerUpper();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Upper <em>Upper</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Upper</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Upper
   * @generated
   */
  EClass getUpper();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Upper#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Upper#getExpression()
   * @see #getUpper()
   * @generated
   */
  EAttribute getUpper_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Lower <em>Lower</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lower</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Lower
   * @generated
   */
  EClass getLower();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Lower#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Lower#getExpression()
   * @see #getLower()
   * @generated
   */
  EAttribute getLower_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal
   * @generated
   */
  EClass getGoal();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal#getName()
   * @see #getGoal()
   * @generated
   */
  EAttribute getGoal_Name();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Definition</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Goal#getDefinition()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_Definition();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase <em>Goal Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Case</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase
   * @generated
   */
  EClass getGoalCase();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase#getLhs()
   * @see #getGoalCase()
   * @generated
   */
  EAttribute getGoalCase_Lhs();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase#getContent()
   * @see #getGoalCase()
   * @generated
   */
  EReference getGoalCase_Content();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase#getCaseContent <em>Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Case Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCase#getCaseContent()
   * @see #getGoalCase()
   * @generated
   */
  EReference getGoalCase_CaseContent();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent <em>Goal Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Case Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent
   * @generated
   */
  EClass getGoalCaseContent();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getCaseName <em>Case Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Case Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getCaseName()
   * @see #getGoalCaseContent()
   * @generated
   */
  EAttribute getGoalCaseContent_CaseName();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getCondition()
   * @see #getGoalCaseContent()
   * @generated
   */
  EReference getGoalCaseContent_Condition();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getRhs()
   * @see #getGoalCaseContent()
   * @generated
   */
  EAttribute getGoalCaseContent_Rhs();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getSubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalCaseContent#getSubContent()
   * @see #getGoalCaseContent()
   * @generated
   */
  EReference getGoalCaseContent_SubContent();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent <em>Goal No Case Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal No Case Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent
   * @generated
   */
  EClass getGoalNoCaseContent();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent#getRhs()
   * @see #getGoalNoCaseContent()
   * @generated
   */
  EAttribute getGoalNoCaseContent_Rhs();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent#getSubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalNoCaseContent#getSubContent()
   * @see #getGoalNoCaseContent()
   * @generated
   */
  EReference getGoalNoCaseContent_SubContent();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent <em>Sub Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Content</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent
   * @generated
   */
  EClass getSubContent();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent#getGt <em>Gt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Gt</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent#getGt()
   * @see #getSubContent()
   * @generated
   */
  EReference getSubContent_Gt();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent#getLt <em>Lt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lt</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.SubContent#getLt()
   * @see #getSubContent()
   * @generated
   */
  EReference getSubContent_Lt();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsGtRhs <em>Lhs Gt Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lhs Gt Rhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsGtRhs
   * @generated
   */
  EClass getLhsGtRhs();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsGtRhs#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Penalty</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsGtRhs#getPenalty()
   * @see #getLhsGtRhs()
   * @generated
   */
  EReference getLhsGtRhs_Penalty();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsLtRhs <em>Lhs Lt Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lhs Lt Rhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsLtRhs
   * @generated
   */
  EClass getLhsLtRhs();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsLtRhs#getPenalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Penalty</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.LhsLtRhs#getPenalty()
   * @see #getLhsLtRhs()
   * @generated
   */
  EReference getLhsLtRhs_Penalty();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Penalty <em>Penalty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Penalty</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Penalty
   * @generated
   */
  EClass getPenalty();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Penalty#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Penalty#getExpression()
   * @see #getPenalty()
   * @generated
   */
  EAttribute getPenalty_Expression();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalSimple <em>Goal Simple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Simple</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalSimple
   * @generated
   */
  EClass getGoalSimple();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalSimple#getConstraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constraint</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.GoalSimple#getConstraint()
   * @see #getGoalSimple()
   * @generated
   */
  EReference getGoalSimple_Constraint();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint
   * @generated
   */
  EClass getConstraint();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint#getLhs()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Lhs();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint#getOperator()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Operator();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhs</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Constraint#getRhs()
   * @see #getConstraint()
   * @generated
   */
  EAttribute getConstraint_Rhs();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pattern</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model#getPattern()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Pattern();

  /**
   * Returns the meta object for the containment reference list '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Alias</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Model#getAlias()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Alias();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence <em>Sequence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sequence</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence
   * @generated
   */
  EClass getSequence();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getName()
   * @see #getSequence()
   * @generated
   */
  EAttribute getSequence_Name();

  /**
   * Returns the meta object for the reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Model</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getModel()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Model();

  /**
   * Returns the meta object for the containment reference '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getCondition()
   * @see #getSequence()
   * @generated
   */
  EReference getSequence_Condition();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getOrder <em>Order</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Order</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Sequence#getOrder()
   * @see #getSequence()
   * @generated
   */
  EAttribute getSequence_Order();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Condition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Condition
   * @generated
   */
  EClass getCondition();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Condition#getLogical <em>Logical</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Logical</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.Condition#getLogical()
   * @see #getCondition()
   * @generated
   */
  EAttribute getCondition_Logical();

  /**
   * Returns the meta object for class '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile <em>Include File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include File</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile
   * @generated
   */
  EClass getIncludeFile();

  /**
   * Returns the meta object for the attribute '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile#getFile()
   * @see #getIncludeFile()
   * @generated
   */
  EAttribute getIncludeFile_File();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  WreslEditorFactory getWreslEditorFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEvaluatorImpl <em>Wresl Evaluator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEvaluatorImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getWreslEvaluator()
     * @generated
     */
    EClass WRESL_EVALUATOR = eINSTANCE.getWreslEvaluator();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__PATTERN = eINSTANCE.getWreslEvaluator_Pattern();

    /**
     * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__SEQUENCE = eINSTANCE.getWreslEvaluator_Sequence();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRESL_EVALUATOR__MODEL = eINSTANCE.getWreslEvaluator_Model();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PatternImpl <em>Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PatternImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getPattern()
     * @generated
     */
    EClass PATTERN = eINSTANCE.getPattern();

    /**
     * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PATTERN__LOCAL = eINSTANCE.getPattern_Local();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ObjectiveImpl <em>Objective</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ObjectiveImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getObjective()
     * @generated
     */
    EClass OBJECTIVE = eINSTANCE.getObjective();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECTIVE__NAME = eINSTANCE.getObjective_Name();

    /**
     * The meta object literal for the '<em><b>Weights</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECTIVE__WEIGHTS = eINSTANCE.getObjective_Weights();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WeightItemImpl <em>Weight Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WeightItemImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getWeightItem()
     * @generated
     */
    EClass WEIGHT_ITEM = eINSTANCE.getWeightItem();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WEIGHT_ITEM__NAME = eINSTANCE.getWeightItem_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WEIGHT_ITEM__EXPRESSION = eINSTANCE.getWeightItem_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DefineImpl <em>Define</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DefineImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDefine()
     * @generated
     */
    EClass DEFINE = eINSTANCE.getDefine();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEFINE__NAME = eINSTANCE.getDefine_Name();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINE__DEFINITION = eINSTANCE.getDefine_Definition();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalImpl <em>External</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getExternal()
     * @generated
     */
    EClass EXTERNAL = eINSTANCE.getExternal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL__NAME = eINSTANCE.getExternal_Name();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl <em>Alias</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getAlias()
     * @generated
     */
    EClass ALIAS = eINSTANCE.getAlias();

    /**
     * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__LOCAL = eINSTANCE.getAlias_Local();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__NAME = eINSTANCE.getAlias_Name();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__EXPRESSION = eINSTANCE.getAlias_Expression();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__KIND = eINSTANCE.getAlias_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALIAS__UNITS = eINSTANCE.getAlias_Units();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarImpl <em>DVar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVar()
     * @generated
     */
    EClass DVAR = eINSTANCE.getDVar();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR__KIND = eINSTANCE.getDVar_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR__UNITS = eINSTANCE.getDVar_Units();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarNonStdImpl <em>DVar Non Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarNonStdImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarNonStd()
     * @generated
     */
    EClass DVAR_NON_STD = eINSTANCE.getDVarNonStd();

    /**
     * The meta object literal for the '<em><b>Lower Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DVAR_NON_STD__LOWER_UPPER = eINSTANCE.getDVarNonStd_LowerUpper();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarStdImpl <em>DVar Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarStdImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarStd()
     * @generated
     */
    EClass DVAR_STD = eINSTANCE.getDVarStd();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl <em>DVar Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarInteger()
     * @generated
     */
    EClass DVAR_INTEGER = eINSTANCE.getDVarInteger();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerStdImpl <em>DVar Integer Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerStdImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarIntegerStd()
     * @generated
     */
    EClass DVAR_INTEGER_STD = eINSTANCE.getDVarIntegerStd();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR_INTEGER_STD__KIND = eINSTANCE.getDVarIntegerStd_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DVAR_INTEGER_STD__UNITS = eINSTANCE.getDVarIntegerStd_Units();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerNonStdImpl <em>DVar Integer Non Std</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.DVarIntegerNonStdImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getDVarIntegerNonStd()
     * @generated
     */
    EClass DVAR_INTEGER_NON_STD = eINSTANCE.getDVarIntegerNonStd();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarImpl <em>SVar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVar()
     * @generated
     */
    EClass SVAR = eINSTANCE.getSVar();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarDSSImpl <em>SVar DSS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarDSSImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarDSS()
     * @generated
     */
    EClass SVAR_DSS = eINSTANCE.getSVarDSS();

    /**
     * The meta object literal for the '<em><b>BPart</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__BPART = eINSTANCE.getSVarDSS_BPart();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__KIND = eINSTANCE.getSVarDSS_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__UNITS = eINSTANCE.getSVarDSS_Units();

    /**
     * The meta object literal for the '<em><b>Convert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_DSS__CONVERT = eINSTANCE.getSVarDSS_Convert();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarExpressionImpl <em>SVar Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarExpressionImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarExpression()
     * @generated
     */
    EClass SVAR_EXPRESSION = eINSTANCE.getSVarExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SVAR_EXPRESSION__EXPRESSION = eINSTANCE.getSVarExpression_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarSumImpl <em>SVar Sum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarSumImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarSum()
     * @generated
     */
    EClass SVAR_SUM = eINSTANCE.getSVarSum();

    /**
     * The meta object literal for the '<em><b>Sum Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_SUM__SUM_CONTENT = eINSTANCE.getSVarSum_SumContent();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarTableImpl <em>SVar Table</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarTableImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarTable()
     * @generated
     */
    EClass SVAR_TABLE = eINSTANCE.getSVarTable();

    /**
     * The meta object literal for the '<em><b>Table Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_TABLE__TABLE_CONTENT = eINSTANCE.getSVarTable_TableContent();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarCaseImpl <em>SVar Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SVarCaseImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSVarCase()
     * @generated
     */
    EClass SVAR_CASE = eINSTANCE.getSVarCase();

    /**
     * The meta object literal for the '<em><b>Case Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SVAR_CASE__CASE_CONTENT = eINSTANCE.getSVarCase_CaseContent();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.CaseContentImpl <em>Case Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.CaseContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getCaseContent()
     * @generated
     */
    EClass CASE_CONTENT = eINSTANCE.getCaseContent();

    /**
     * The meta object literal for the '<em><b>Case Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CASE_CONTENT__CASE_NAME = eINSTANCE.getCaseContent_CaseName();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_CONTENT__CONDITION = eINSTANCE.getCaseContent_Condition();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CASE_CONTENT__CONTENT = eINSTANCE.getCaseContent_Content();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumContentImpl <em>Sum Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSumContent()
     * @generated
     */
    EClass SUM_CONTENT = eINSTANCE.getSumContent();

    /**
     * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUM_CONTENT__HEADER = eINSTANCE.getSumContent_Header();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUM_CONTENT__EXPRESSION = eINSTANCE.getSumContent_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl <em>Sum Header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSumHeader()
     * @generated
     */
    EClass SUM_HEADER = eINSTANCE.getSumHeader();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUM_HEADER__EXPRESSION1 = eINSTANCE.getSumHeader_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUM_HEADER__EXPRESSION2 = eINSTANCE.getSumHeader_Expression2();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ValueContentImpl <em>Value Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ValueContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getValueContent()
     * @generated
     */
    EClass VALUE_CONTENT = eINSTANCE.getValueContent();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE_CONTENT__EXPRESSION = eINSTANCE.getValueContent_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.TableContentImpl <em>Table Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.TableContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getTableContent()
     * @generated
     */
    EClass TABLE_CONTENT = eINSTANCE.getTableContent();

    /**
     * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_CONTENT__TABLE_NAME = eINSTANCE.getTableContent_TableName();

    /**
     * The meta object literal for the '<em><b>From</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_CONTENT__FROM = eINSTANCE.getTableContent_From();

    /**
     * The meta object literal for the '<em><b>Given</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_CONTENT__GIVEN = eINSTANCE.getTableContent_Given();

    /**
     * The meta object literal for the '<em><b>Use</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_CONTENT__USE = eINSTANCE.getTableContent_Use();

    /**
     * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_CONTENT__WHERE = eINSTANCE.getTableContent_Where();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WhereItemsImpl <em>Where Items</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WhereItemsImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getWhereItems()
     * @generated
     */
    EClass WHERE_ITEMS = eINSTANCE.getWhereItems();

    /**
     * The meta object literal for the '<em><b>Assignment</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHERE_ITEMS__ASSIGNMENT = eINSTANCE.getWhereItems_Assignment();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AssignmentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Term</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__TERM = eINSTANCE.getAssignment_Term();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__EXPRESSION = eINSTANCE.getAssignment_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerAndOrUpperImpl <em>Lower And Or Upper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerAndOrUpperImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLowerAndOrUpper()
     * @generated
     */
    EClass LOWER_AND_OR_UPPER = eINSTANCE.getLowerAndOrUpper();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOWER_AND_OR_UPPER__KIND = eINSTANCE.getLowerAndOrUpper_Kind();

    /**
     * The meta object literal for the '<em><b>Units</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOWER_AND_OR_UPPER__UNITS = eINSTANCE.getLowerAndOrUpper_Units();

    /**
     * The meta object literal for the '<em><b>Upper</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOWER_AND_OR_UPPER__UPPER = eINSTANCE.getLowerAndOrUpper_Upper();

    /**
     * The meta object literal for the '<em><b>Lower</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOWER_AND_OR_UPPER__LOWER = eINSTANCE.getLowerAndOrUpper_Lower();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.upperLowerImpl <em>upper Lower</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.upperLowerImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getupperLower()
     * @generated
     */
    EClass UPPER_LOWER = eINSTANCE.getupperLower();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.lowerUpperImpl <em>lower Upper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.lowerUpperImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getlowerUpper()
     * @generated
     */
    EClass LOWER_UPPER = eINSTANCE.getlowerUpper();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.UpperImpl <em>Upper</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.UpperImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getUpper()
     * @generated
     */
    EClass UPPER = eINSTANCE.getUpper();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UPPER__EXPRESSION = eINSTANCE.getUpper_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerImpl <em>Lower</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LowerImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLower()
     * @generated
     */
    EClass LOWER = eINSTANCE.getLower();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOWER__EXPRESSION = eINSTANCE.getLower_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalImpl <em>Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoal()
     * @generated
     */
    EClass GOAL = eINSTANCE.getGoal();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL__NAME = eINSTANCE.getGoal_Name();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__DEFINITION = eINSTANCE.getGoal_Definition();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseImpl <em>Goal Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalCase()
     * @generated
     */
    EClass GOAL_CASE = eINSTANCE.getGoalCase();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_CASE__LHS = eINSTANCE.getGoalCase_Lhs();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE__CONTENT = eINSTANCE.getGoalCase_Content();

    /**
     * The meta object literal for the '<em><b>Case Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE__CASE_CONTENT = eINSTANCE.getGoalCase_CaseContent();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseContentImpl <em>Goal Case Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalCaseContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalCaseContent()
     * @generated
     */
    EClass GOAL_CASE_CONTENT = eINSTANCE.getGoalCaseContent();

    /**
     * The meta object literal for the '<em><b>Case Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_CASE_CONTENT__CASE_NAME = eINSTANCE.getGoalCaseContent_CaseName();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE_CONTENT__CONDITION = eINSTANCE.getGoalCaseContent_Condition();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_CASE_CONTENT__RHS = eINSTANCE.getGoalCaseContent_Rhs();

    /**
     * The meta object literal for the '<em><b>Sub Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_CASE_CONTENT__SUB_CONTENT = eINSTANCE.getGoalCaseContent_SubContent();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalNoCaseContentImpl <em>Goal No Case Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalNoCaseContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalNoCaseContent()
     * @generated
     */
    EClass GOAL_NO_CASE_CONTENT = eINSTANCE.getGoalNoCaseContent();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_NO_CASE_CONTENT__RHS = eINSTANCE.getGoalNoCaseContent_Rhs();

    /**
     * The meta object literal for the '<em><b>Sub Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_NO_CASE_CONTENT__SUB_CONTENT = eINSTANCE.getGoalNoCaseContent_SubContent();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SubContentImpl <em>Sub Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SubContentImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSubContent()
     * @generated
     */
    EClass SUB_CONTENT = eINSTANCE.getSubContent();

    /**
     * The meta object literal for the '<em><b>Gt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_CONTENT__GT = eINSTANCE.getSubContent_Gt();

    /**
     * The meta object literal for the '<em><b>Lt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_CONTENT__LT = eINSTANCE.getSubContent_Lt();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsGtRhsImpl <em>Lhs Gt Rhs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsGtRhsImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLhsGtRhs()
     * @generated
     */
    EClass LHS_GT_RHS = eINSTANCE.getLhsGtRhs();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LHS_GT_RHS__PENALTY = eINSTANCE.getLhsGtRhs_Penalty();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsLtRhsImpl <em>Lhs Lt Rhs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.LhsLtRhsImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getLhsLtRhs()
     * @generated
     */
    EClass LHS_LT_RHS = eINSTANCE.getLhsLtRhs();

    /**
     * The meta object literal for the '<em><b>Penalty</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LHS_LT_RHS__PENALTY = eINSTANCE.getLhsLtRhs_Penalty();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PenaltyImpl <em>Penalty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.PenaltyImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getPenalty()
     * @generated
     */
    EClass PENALTY = eINSTANCE.getPenalty();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PENALTY__EXPRESSION = eINSTANCE.getPenalty_Expression();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalSimpleImpl <em>Goal Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.GoalSimpleImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getGoalSimple()
     * @generated
     */
    EClass GOAL_SIMPLE = eINSTANCE.getGoalSimple();

    /**
     * The meta object literal for the '<em><b>Constraint</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_SIMPLE__CONSTRAINT = eINSTANCE.getGoalSimple_Constraint();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConstraintImpl <em>Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConstraintImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getConstraint()
     * @generated
     */
    EClass CONSTRAINT = eINSTANCE.getConstraint();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__LHS = eINSTANCE.getConstraint_Lhs();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__OPERATOR = eINSTANCE.getConstraint_Operator();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT__RHS = eINSTANCE.getConstraint_Rhs();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ModelImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__PATTERN = eINSTANCE.getModel_Pattern();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ALIAS = eINSTANCE.getModel_Alias();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SequenceImpl <em>Sequence</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SequenceImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getSequence()
     * @generated
     */
    EClass SEQUENCE = eINSTANCE.getSequence();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEQUENCE__NAME = eINSTANCE.getSequence_Name();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__MODEL = eINSTANCE.getSequence_Model();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SEQUENCE__CONDITION = eINSTANCE.getSequence_Condition();

    /**
     * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SEQUENCE__ORDER = eINSTANCE.getSequence_Order();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConditionImpl <em>Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ConditionImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getCondition()
     * @generated
     */
    EClass CONDITION = eINSTANCE.getCondition();

    /**
     * The meta object literal for the '<em><b>Logical</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITION__LOGICAL = eINSTANCE.getCondition_Logical();

    /**
     * The meta object literal for the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.IncludeFileImpl <em>Include File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.IncludeFileImpl
     * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.WreslEditorPackageImpl#getIncludeFile()
     * @generated
     */
    EClass INCLUDE_FILE = eINSTANCE.getIncludeFile();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_FILE__FILE = eINSTANCE.getIncludeFile_File();

  }

} //WreslEditorPackage

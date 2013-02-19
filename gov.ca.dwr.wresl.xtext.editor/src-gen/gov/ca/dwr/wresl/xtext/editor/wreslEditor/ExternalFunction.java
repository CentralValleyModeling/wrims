/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction#getRef <em>Ref</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction#getE1 <em>E1</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction#getE2 <em>E2</em>}</li>
 * </ul>
 * </p>
 *
 * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getExternalFunction()
 * @model
 * @generated
 */
public interface ExternalFunction extends Function
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Declaration)
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getExternalFunction_Ref()
   * @model
   * @generated
   */
  Declaration getRef();

  /**
   * Sets the value of the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Declaration value);

  /**
   * Returns the value of the '<em><b>E1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E1</em>' containment reference.
   * @see #setE1(Expression)
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getExternalFunction_E1()
   * @model containment="true"
   * @generated
   */
  Expression getE1();

  /**
   * Sets the value of the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction#getE1 <em>E1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>E1</em>' containment reference.
   * @see #getE1()
   * @generated
   */
  void setE1(Expression value);

  /**
   * Returns the value of the '<em><b>E2</b></em>' containment reference list.
   * The list contents are of type {@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>E2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>E2</em>' containment reference list.
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getExternalFunction_E2()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getE2();

} // ExternalFunction

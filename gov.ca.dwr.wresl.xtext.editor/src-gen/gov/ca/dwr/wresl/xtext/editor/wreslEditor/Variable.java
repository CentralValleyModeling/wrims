/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Variable#isLocal <em>Local</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Variable#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Pattern
{
  /**
   * Returns the value of the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Local</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Local</em>' attribute.
   * @see #setLocal(boolean)
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getVariable_Local()
   * @model
   * @generated
   */
  boolean isLocal();

  /**
   * Sets the value of the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Variable#isLocal <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local</em>' attribute.
   * @see #isLocal()
   * @generated
   */
  void setLocal(boolean value);

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
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getVariable_Ref()
   * @model
   * @generated
   */
  Declaration getRef();

  /**
   * Sets the value of the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.Variable#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Declaration value);

} // Variable

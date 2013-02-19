/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile#isLocal <em>Local</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getIncludeFile()
 * @model
 * @generated
 */
public interface IncludeFile extends Pattern
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
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getIncludeFile_Local()
   * @model
   * @generated
   */
  boolean isLocal();

  /**
   * Sets the value of the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile#isLocal <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Local</em>' attribute.
   * @see #isLocal()
   * @generated
   */
  void setLocal(boolean value);

  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(String)
   * @see gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage#getIncludeFile_File()
   * @model
   * @generated
   */
  String getFile();

  /**
   * Sets the value of the '{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.IncludeFile#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(String value);

} // IncludeFile

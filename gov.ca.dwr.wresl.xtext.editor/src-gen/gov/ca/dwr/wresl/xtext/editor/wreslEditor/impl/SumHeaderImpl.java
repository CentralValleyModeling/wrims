/**
 * <copyright>
 * </copyright>
 *

 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.SumHeader;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sum Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.SumHeaderImpl#getExpression2 <em>Expression2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SumHeaderImpl extends MinimalEObjectImpl.Container implements SumHeader
{
  /**
   * The default value of the '{@link #getExpression1() <em>Expression1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected static final String EXPRESSION1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExpression1() <em>Expression1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression1()
   * @generated
   * @ordered
   */
  protected String expression1 = EXPRESSION1_EDEFAULT;

  /**
   * The default value of the '{@link #getExpression2() <em>Expression2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression2()
   * @generated
   * @ordered
   */
  protected static final String EXPRESSION2_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExpression2() <em>Expression2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression2()
   * @generated
   * @ordered
   */
  protected String expression2 = EXPRESSION2_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SumHeaderImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return WreslEditorPackage.Literals.SUM_HEADER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExpression1()
  {
    return expression1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression1(String newExpression1)
  {
    String oldExpression1 = expression1;
    expression1 = newExpression1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.SUM_HEADER__EXPRESSION1, oldExpression1, expression1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExpression2()
  {
    return expression2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression2(String newExpression2)
  {
    String oldExpression2 = expression2;
    expression2 = newExpression2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.SUM_HEADER__EXPRESSION2, oldExpression2, expression2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case WreslEditorPackage.SUM_HEADER__EXPRESSION1:
        return getExpression1();
      case WreslEditorPackage.SUM_HEADER__EXPRESSION2:
        return getExpression2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WreslEditorPackage.SUM_HEADER__EXPRESSION1:
        setExpression1((String)newValue);
        return;
      case WreslEditorPackage.SUM_HEADER__EXPRESSION2:
        setExpression2((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case WreslEditorPackage.SUM_HEADER__EXPRESSION1:
        setExpression1(EXPRESSION1_EDEFAULT);
        return;
      case WreslEditorPackage.SUM_HEADER__EXPRESSION2:
        setExpression2(EXPRESSION2_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case WreslEditorPackage.SUM_HEADER__EXPRESSION1:
        return EXPRESSION1_EDEFAULT == null ? expression1 != null : !EXPRESSION1_EDEFAULT.equals(expression1);
      case WreslEditorPackage.SUM_HEADER__EXPRESSION2:
        return EXPRESSION2_EDEFAULT == null ? expression2 != null : !EXPRESSION2_EDEFAULT.equals(expression2);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (expression1: ");
    result.append(expression1);
    result.append(", expression2: ");
    result.append(expression2);
    result.append(')');
    return result.toString();
  }

} //SumHeaderImpl

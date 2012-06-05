/**
 * <copyright>
 * </copyright>
 *

 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Alias;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Expression;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alias</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl#isLocal <em>Local</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl#getName <em>Name</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.AliasImpl#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AliasImpl extends MinimalEObjectImpl.Container implements Alias
{
  /**
   * The default value of the '{@link #isLocal() <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocal()
   * @generated
   * @ordered
   */
  protected static final boolean LOCAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLocal() <em>Local</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLocal()
   * @generated
   * @ordered
   */
  protected boolean local = LOCAL_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final String KIND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected String kind = KIND_EDEFAULT;

  /**
   * The default value of the '{@link #getUnits() <em>Units</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnits()
   * @generated
   * @ordered
   */
  protected static final String UNITS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUnits() <em>Units</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnits()
   * @generated
   * @ordered
   */
  protected String units = UNITS_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AliasImpl()
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
    return WreslEditorPackage.Literals.ALIAS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLocal()
  {
    return local;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLocal(boolean newLocal)
  {
    boolean oldLocal = local;
    local = newLocal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.ALIAS__LOCAL, oldLocal, local));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.ALIAS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WreslEditorPackage.ALIAS__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.ALIAS__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.ALIAS__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.ALIAS__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(String newKind)
  {
    String oldKind = kind;
    kind = newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.ALIAS__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUnits()
  {
    return units;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnits(String newUnits)
  {
    String oldUnits = units;
    units = newUnits;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.ALIAS__UNITS, oldUnits, units));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case WreslEditorPackage.ALIAS__EXPRESSION:
        return basicSetExpression(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case WreslEditorPackage.ALIAS__LOCAL:
        return isLocal();
      case WreslEditorPackage.ALIAS__NAME:
        return getName();
      case WreslEditorPackage.ALIAS__EXPRESSION:
        return getExpression();
      case WreslEditorPackage.ALIAS__KIND:
        return getKind();
      case WreslEditorPackage.ALIAS__UNITS:
        return getUnits();
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
      case WreslEditorPackage.ALIAS__LOCAL:
        setLocal((Boolean)newValue);
        return;
      case WreslEditorPackage.ALIAS__NAME:
        setName((String)newValue);
        return;
      case WreslEditorPackage.ALIAS__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case WreslEditorPackage.ALIAS__KIND:
        setKind((String)newValue);
        return;
      case WreslEditorPackage.ALIAS__UNITS:
        setUnits((String)newValue);
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
      case WreslEditorPackage.ALIAS__LOCAL:
        setLocal(LOCAL_EDEFAULT);
        return;
      case WreslEditorPackage.ALIAS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case WreslEditorPackage.ALIAS__EXPRESSION:
        setExpression((Expression)null);
        return;
      case WreslEditorPackage.ALIAS__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case WreslEditorPackage.ALIAS__UNITS:
        setUnits(UNITS_EDEFAULT);
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
      case WreslEditorPackage.ALIAS__LOCAL:
        return local != LOCAL_EDEFAULT;
      case WreslEditorPackage.ALIAS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case WreslEditorPackage.ALIAS__EXPRESSION:
        return expression != null;
      case WreslEditorPackage.ALIAS__KIND:
        return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
      case WreslEditorPackage.ALIAS__UNITS:
        return UNITS_EDEFAULT == null ? units != null : !UNITS_EDEFAULT.equals(units);
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
    result.append(" (local: ");
    result.append(local);
    result.append(", name: ");
    result.append(name);
    result.append(", kind: ");
    result.append(kind);
    result.append(", units: ");
    result.append(units);
    result.append(')');
    return result.toString();
  }

} //AliasImpl

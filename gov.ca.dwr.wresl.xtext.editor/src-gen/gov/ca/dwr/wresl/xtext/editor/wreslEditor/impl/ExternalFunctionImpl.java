/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl;

import gov.ca.dwr.wresl.xtext.editor.wreslEditor.Declaration;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.ExternalFunction;
import gov.ca.dwr.wresl.xtext.editor.wreslEditor.WreslEditorPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalFunctionImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalFunctionImpl#getE1 <em>E1</em>}</li>
 *   <li>{@link gov.ca.dwr.wresl.xtext.editor.wreslEditor.impl.ExternalFunctionImpl#getE2 <em>E2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalFunctionImpl extends FunctionImpl implements ExternalFunction
{
  /**
   * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRef()
   * @generated
   * @ordered
   */
  protected Declaration ref;

  /**
   * The cached value of the '{@link #getE1() <em>E1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE1()
   * @generated
   * @ordered
   */
  protected EObject e1;

  /**
   * The cached value of the '{@link #getE2() <em>E2</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getE2()
   * @generated
   * @ordered
   */
  protected EList<EObject> e2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalFunctionImpl()
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
    return WreslEditorPackage.Literals.EXTERNAL_FUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration getRef()
  {
    if (ref != null && ref.eIsProxy())
    {
      InternalEObject oldRef = (InternalEObject)ref;
      ref = (Declaration)eResolveProxy(oldRef);
      if (ref != oldRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, WreslEditorPackage.EXTERNAL_FUNCTION__REF, oldRef, ref));
      }
    }
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration basicGetRef()
  {
    return ref;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRef(Declaration newRef)
  {
    Declaration oldRef = ref;
    ref = newRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION__REF, oldRef, ref));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getE1()
  {
    return e1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetE1(EObject newE1, NotificationChain msgs)
  {
    EObject oldE1 = e1;
    e1 = newE1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION__E1, oldE1, newE1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setE1(EObject newE1)
  {
    if (newE1 != e1)
    {
      NotificationChain msgs = null;
      if (e1 != null)
        msgs = ((InternalEObject)e1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.EXTERNAL_FUNCTION__E1, null, msgs);
      if (newE1 != null)
        msgs = ((InternalEObject)newE1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WreslEditorPackage.EXTERNAL_FUNCTION__E1, null, msgs);
      msgs = basicSetE1(newE1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, WreslEditorPackage.EXTERNAL_FUNCTION__E1, newE1, newE1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getE2()
  {
    if (e2 == null)
    {
      e2 = new EObjectContainmentEList<EObject>(EObject.class, this, WreslEditorPackage.EXTERNAL_FUNCTION__E2);
    }
    return e2;
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
      case WreslEditorPackage.EXTERNAL_FUNCTION__E1:
        return basicSetE1(null, msgs);
      case WreslEditorPackage.EXTERNAL_FUNCTION__E2:
        return ((InternalEList<?>)getE2()).basicRemove(otherEnd, msgs);
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
      case WreslEditorPackage.EXTERNAL_FUNCTION__REF:
        if (resolve) return getRef();
        return basicGetRef();
      case WreslEditorPackage.EXTERNAL_FUNCTION__E1:
        return getE1();
      case WreslEditorPackage.EXTERNAL_FUNCTION__E2:
        return getE2();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case WreslEditorPackage.EXTERNAL_FUNCTION__REF:
        setRef((Declaration)newValue);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION__E1:
        setE1((EObject)newValue);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION__E2:
        getE2().clear();
        getE2().addAll((Collection<? extends EObject>)newValue);
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
      case WreslEditorPackage.EXTERNAL_FUNCTION__REF:
        setRef((Declaration)null);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION__E1:
        setE1((EObject)null);
        return;
      case WreslEditorPackage.EXTERNAL_FUNCTION__E2:
        getE2().clear();
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
      case WreslEditorPackage.EXTERNAL_FUNCTION__REF:
        return ref != null;
      case WreslEditorPackage.EXTERNAL_FUNCTION__E1:
        return e1 != null;
      case WreslEditorPackage.EXTERNAL_FUNCTION__E2:
        return e2 != null && !e2.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExternalFunctionImpl

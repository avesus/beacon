package com.bureaueye.beacon.model.purchaseinvoice.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.purchaseinvoice.dao.iface.PidtlDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BasePidtlDAO extends com.bureaueye.beacon.model.purchaseinvoice.dao._RootDAO {

	public BasePidtlDAO () {}
	
	public BasePidtlDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_PIDTLS_TOTAL_RESULTS = "findPidtlsTotalResults";
	public static final String QUERY_PIDTLS_INVOICEAMT_TOTAL = "pidtlsInvoiceamtTotal";
	public static final String QUERY_PIDTLS_INVOICESTATUS_COUNT = "pidtlsInvoicestatusCount";
	public static final String QUERY_PIDTLS_COUNT = "pidtlsCount";


	public static PidtlDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static PidtlDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.purchaseinvoice.dao.PidtlDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.purchaseinvoice.Pidtl.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.purchaseinvoice.Pidtl
	 */
	public com.bureaueye.beacon.model.purchaseinvoice.Pidtl cast (Object object) {
		return (com.bureaueye.beacon.model.purchaseinvoice.Pidtl) object;
	}

	public com.bureaueye.beacon.model.purchaseinvoice.Pidtl get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.purchaseinvoice.Pidtl) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.purchaseinvoice.Pidtl get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.purchaseinvoice.Pidtl) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.purchaseinvoice.Pidtl load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.purchaseinvoice.Pidtl) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.purchaseinvoice.Pidtl load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.purchaseinvoice.Pidtl) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.purchaseinvoice.Pidtl loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.purchaseinvoice.Pidtl obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.purchaseinvoice.Pidtl> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.purchaseinvoice.Pidtl> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.purchaseinvoice.Pidtl> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param pidtl a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl)
	{
		return (java.lang.Integer) super.save(pidtl);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param pidtl a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, Session s)
	{
		return (java.lang.Integer) save((Object) pidtl, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param pidtl a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl)
	{
		saveOrUpdate((Object) pidtl);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param pidtl a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, Session s)
	{
		saveOrUpdate((Object) pidtl, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param pidtl a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl) 
	{
		update((Object) pidtl);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param pidtl a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, Session s)
	{
		update((Object) pidtl, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param pidtl the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl)
	{
		delete((Object) pidtl);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param pidtl the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, Session s)
	{
		delete((Object) pidtl, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, Session s)
	{
		refresh((Object) pidtl, s);
	}


}
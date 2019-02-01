package com.bureaueye.beacon.model.mandr.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.mandr.dao.iface.MandrdtlDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseMandrdtlDAO extends com.bureaueye.beacon.model.mandr.dao._RootDAO {

	public BaseMandrdtlDAO () {}
	
	public BaseMandrdtlDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_MANDRDTLS_TOTAL_RESULTS = "findMandrdtlsTotalResults";
	public static final String QUERY_MANDRDTLS_TOTALS = "mandrdtlsTotals";
	public static final String QUERY_MANDRDTLS_TOTALS_GROUPBY_RESPONSIBILITYCODE = "mandrdtlsTotalsGroupbyResponsibilitycode";


	public static MandrdtlDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static MandrdtlDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.mandr.dao.MandrdtlDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.mandr.Mandrdtl.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.mandr.Mandrdtl
	 */
	public com.bureaueye.beacon.model.mandr.Mandrdtl cast (Object object) {
		return (com.bureaueye.beacon.model.mandr.Mandrdtl) object;
	}

	public com.bureaueye.beacon.model.mandr.Mandrdtl get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.mandr.Mandrdtl) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.mandr.Mandrdtl get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.mandr.Mandrdtl) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.mandr.Mandrdtl load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.mandr.Mandrdtl) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.mandr.Mandrdtl load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.mandr.Mandrdtl) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.mandr.Mandrdtl loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.mandr.Mandrdtl obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.mandr.Mandrdtl> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.mandr.Mandrdtl> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.mandr.Mandrdtl> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param mandrdtl a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl)
	{
		return (java.lang.Integer) super.save(mandrdtl);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param mandrdtl a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl, Session s)
	{
		return (java.lang.Integer) save((Object) mandrdtl, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param mandrdtl a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl)
	{
		saveOrUpdate((Object) mandrdtl);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param mandrdtl a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl, Session s)
	{
		saveOrUpdate((Object) mandrdtl, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param mandrdtl a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl) 
	{
		update((Object) mandrdtl);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param mandrdtl a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl, Session s)
	{
		update((Object) mandrdtl, s);
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
	 * @param mandrdtl the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl)
	{
		delete((Object) mandrdtl);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param mandrdtl the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl, Session s)
	{
		delete((Object) mandrdtl, s);
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
	public void refresh (com.bureaueye.beacon.model.mandr.Mandrdtl mandrdtl, Session s)
	{
		refresh((Object) mandrdtl, s);
	}


}
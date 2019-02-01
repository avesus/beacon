package com.bureaueye.beacon.model.standard.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.standard.dao.iface.CcyDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseCcyDAO extends com.bureaueye.beacon.model.standard.dao._RootDAO {

	public BaseCcyDAO () {}
	
	public BaseCcyDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_CCY_TOTAL_RESULTS = "findCcyTotalResults";
	public static final String QUERY_FIND_CCY_BY_CCYNAME = "findCcyByCcyname";


	public static CcyDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static CcyDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.standard.dao.CcyDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.standard.Ccy.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.standard.Ccy
	 */
	public com.bureaueye.beacon.model.standard.Ccy cast (Object object) {
		return (com.bureaueye.beacon.model.standard.Ccy) object;
	}

	public com.bureaueye.beacon.model.standard.Ccy get(java.lang.String key)
	{
		return (com.bureaueye.beacon.model.standard.Ccy) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.standard.Ccy get(java.lang.String key, Session s)
	{
		return (com.bureaueye.beacon.model.standard.Ccy) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.standard.Ccy load(java.lang.String key)
	{
		return (com.bureaueye.beacon.model.standard.Ccy) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.standard.Ccy load(java.lang.String key, Session s)
	{
		return (com.bureaueye.beacon.model.standard.Ccy) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.standard.Ccy loadInitialize(java.lang.String key, Session s) 
	{ 
		com.bureaueye.beacon.model.standard.Ccy obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Ccy> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Ccy> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Ccy> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param ccy a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(com.bureaueye.beacon.model.standard.Ccy ccy)
	{
		return (java.lang.String) super.save(ccy);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param ccy a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.String save(com.bureaueye.beacon.model.standard.Ccy ccy, Session s)
	{
		return (java.lang.String) save((Object) ccy, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param ccy a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Ccy ccy)
	{
		saveOrUpdate((Object) ccy);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param ccy a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Ccy ccy, Session s)
	{
		saveOrUpdate((Object) ccy, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param ccy a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.standard.Ccy ccy) 
	{
		update((Object) ccy);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param ccy a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.standard.Ccy ccy, Session s)
	{
		update((Object) ccy, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.String id)
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
	public void delete(java.lang.String id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param ccy the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.standard.Ccy ccy)
	{
		delete((Object) ccy);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param ccy the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.standard.Ccy ccy, Session s)
	{
		delete((Object) ccy, s);
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
	public void refresh (com.bureaueye.beacon.model.standard.Ccy ccy, Session s)
	{
		refresh((Object) ccy, s);
	}


}
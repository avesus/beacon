package com.bureaueye.beacon.model.account.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.account.dao.iface.TdmMigrationLogWrkDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseTdmMigrationLogWrkDAO extends com.bureaueye.beacon.model.account.dao._RootDAO {

	public BaseTdmMigrationLogWrkDAO () {}
	
	public BaseTdmMigrationLogWrkDAO (Session session) {
		super(session);
	}

	// query name references


	public static TdmMigrationLogWrkDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static TdmMigrationLogWrkDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.account.dao.TdmMigrationLogWrkDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.account.TdmMigrationLogWrk.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.account.TdmMigrationLogWrk
	 */
	public com.bureaueye.beacon.model.account.TdmMigrationLogWrk cast (Object object) {
		return (com.bureaueye.beacon.model.account.TdmMigrationLogWrk) object;
	}

	public com.bureaueye.beacon.model.account.TdmMigrationLogWrk get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.account.TdmMigrationLogWrk) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.account.TdmMigrationLogWrk get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.account.TdmMigrationLogWrk) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.account.TdmMigrationLogWrk load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.account.TdmMigrationLogWrk) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.account.TdmMigrationLogWrk load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.account.TdmMigrationLogWrk) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.account.TdmMigrationLogWrk loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.account.TdmMigrationLogWrk obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.account.TdmMigrationLogWrk> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.account.TdmMigrationLogWrk> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.account.TdmMigrationLogWrk> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param tdmMigrationLogWrk a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk)
	{
		return (java.lang.Integer) super.save(tdmMigrationLogWrk);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param tdmMigrationLogWrk a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk, Session s)
	{
		return (java.lang.Integer) save((Object) tdmMigrationLogWrk, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param tdmMigrationLogWrk a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk)
	{
		saveOrUpdate((Object) tdmMigrationLogWrk);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param tdmMigrationLogWrk a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk, Session s)
	{
		saveOrUpdate((Object) tdmMigrationLogWrk, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param tdmMigrationLogWrk a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk) 
	{
		update((Object) tdmMigrationLogWrk);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param tdmMigrationLogWrk a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk, Session s)
	{
		update((Object) tdmMigrationLogWrk, s);
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
	 * @param tdmMigrationLogWrk the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk)
	{
		delete((Object) tdmMigrationLogWrk);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param tdmMigrationLogWrk the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk, Session s)
	{
		delete((Object) tdmMigrationLogWrk, s);
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
	public void refresh (com.bureaueye.beacon.model.account.TdmMigrationLogWrk tdmMigrationLogWrk, Session s)
	{
		refresh((Object) tdmMigrationLogWrk, s);
	}


}
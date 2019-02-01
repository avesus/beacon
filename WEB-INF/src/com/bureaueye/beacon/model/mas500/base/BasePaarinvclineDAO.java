package com.bureaueye.beacon.model.mas500.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.mas500.dao.iface.PaarinvclineDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BasePaarinvclineDAO extends com.bureaueye.beacon.model.mas500.dao._RootDAO {

	public BasePaarinvclineDAO () {}
	
	public BasePaarinvclineDAO (Session session) {
		super(session);
	}

	// query name references


	public static PaarinvclineDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static PaarinvclineDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.mas500.dao.PaarinvclineDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.mas500.Paarinvcline.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.mas500.Paarinvcline
	 */
	public com.bureaueye.beacon.model.mas500.Paarinvcline cast (Object object) {
		return (com.bureaueye.beacon.model.mas500.Paarinvcline) object;
	}

	public com.bureaueye.beacon.model.mas500.Paarinvcline get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.mas500.Paarinvcline) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.mas500.Paarinvcline get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.mas500.Paarinvcline) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.mas500.Paarinvcline load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.mas500.Paarinvcline) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.mas500.Paarinvcline load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.mas500.Paarinvcline) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.mas500.Paarinvcline loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.mas500.Paarinvcline obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.mas500.Paarinvcline> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.mas500.Paarinvcline> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.mas500.Paarinvcline> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param paarinvcline a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline)
	{
		return (java.lang.Integer) super.save(paarinvcline);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param paarinvcline a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline, Session s)
	{
		return (java.lang.Integer) save((Object) paarinvcline, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param paarinvcline a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline)
	{
		saveOrUpdate((Object) paarinvcline);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param paarinvcline a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline, Session s)
	{
		saveOrUpdate((Object) paarinvcline, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param paarinvcline a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline) 
	{
		update((Object) paarinvcline);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param paarinvcline a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline, Session s)
	{
		update((Object) paarinvcline, s);
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
	 * @param paarinvcline the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline)
	{
		delete((Object) paarinvcline);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param paarinvcline the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline, Session s)
	{
		delete((Object) paarinvcline, s);
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
	public void refresh (com.bureaueye.beacon.model.mas500.Paarinvcline paarinvcline, Session s)
	{
		refresh((Object) paarinvcline, s);
	}


}
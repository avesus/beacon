package com.bureaueye.beacon.model.standard.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.standard.dao.iface.CustomertoconsigneeDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseCustomertoconsigneeDAO extends com.bureaueye.beacon.model.standard.dao._RootDAO {

	public BaseCustomertoconsigneeDAO () {}
	
	public BaseCustomertoconsigneeDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_CUSTOMERTOCONSIGNEE_TOTAL_RESULTS = "findCustomertoconsigneeTotalResults";


	public static CustomertoconsigneeDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static CustomertoconsigneeDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.standard.dao.CustomertoconsigneeDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.standard.Customertoconsignee.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.standard.Customertoconsignee
	 */
	public com.bureaueye.beacon.model.standard.Customertoconsignee cast (Object object) {
		return (com.bureaueye.beacon.model.standard.Customertoconsignee) object;
	}

	public com.bureaueye.beacon.model.standard.Customertoconsignee get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.standard.Customertoconsignee) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.standard.Customertoconsignee get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.standard.Customertoconsignee) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.standard.Customertoconsignee load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.standard.Customertoconsignee) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.standard.Customertoconsignee load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.standard.Customertoconsignee) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.standard.Customertoconsignee loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.standard.Customertoconsignee obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Customertoconsignee> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Customertoconsignee> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Customertoconsignee> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param customertoconsignee a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee)
	{
		return (java.lang.Integer) super.save(customertoconsignee);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param customertoconsignee a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee, Session s)
	{
		return (java.lang.Integer) save((Object) customertoconsignee, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param customertoconsignee a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee)
	{
		saveOrUpdate((Object) customertoconsignee);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param customertoconsignee a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee, Session s)
	{
		saveOrUpdate((Object) customertoconsignee, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param customertoconsignee a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee) 
	{
		update((Object) customertoconsignee);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param customertoconsignee a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee, Session s)
	{
		update((Object) customertoconsignee, s);
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
	 * @param customertoconsignee the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee)
	{
		delete((Object) customertoconsignee);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param customertoconsignee the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee, Session s)
	{
		delete((Object) customertoconsignee, s);
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
	public void refresh (com.bureaueye.beacon.model.standard.Customertoconsignee customertoconsignee, Session s)
	{
		refresh((Object) customertoconsignee, s);
	}


}
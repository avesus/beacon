package com.bureaueye.beacon.model.standard.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.standard.dao.iface.UsergroupDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseUsergroupDAO extends com.bureaueye.beacon.model.standard.dao._RootDAO {

	public BaseUsergroupDAO () {}
	
	public BaseUsergroupDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_USERGROUPS_TOTAL_RESULTS = "findUsergroupsTotalResults";


	public static UsergroupDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static UsergroupDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.standard.dao.UsergroupDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.standard.Usergroup.class;
	}

    public Order getDefaultOrder () {
		return Order.asc("Name");
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.standard.Usergroup
	 */
	public com.bureaueye.beacon.model.standard.Usergroup cast (Object object) {
		return (com.bureaueye.beacon.model.standard.Usergroup) object;
	}

	public com.bureaueye.beacon.model.standard.Usergroup get(java.lang.String key)
	{
		return (com.bureaueye.beacon.model.standard.Usergroup) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.standard.Usergroup get(java.lang.String key, Session s)
	{
		return (com.bureaueye.beacon.model.standard.Usergroup) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.standard.Usergroup load(java.lang.String key)
	{
		return (com.bureaueye.beacon.model.standard.Usergroup) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.standard.Usergroup load(java.lang.String key, Session s)
	{
		return (com.bureaueye.beacon.model.standard.Usergroup) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.standard.Usergroup loadInitialize(java.lang.String key, Session s) 
	{ 
		com.bureaueye.beacon.model.standard.Usergroup obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Usergroup> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Usergroup> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.standard.Usergroup> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param usergroup a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.String save(com.bureaueye.beacon.model.standard.Usergroup usergroup)
	{
		return (java.lang.String) super.save(usergroup);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param usergroup a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.String save(com.bureaueye.beacon.model.standard.Usergroup usergroup, Session s)
	{
		return (java.lang.String) save((Object) usergroup, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param usergroup a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Usergroup usergroup)
	{
		saveOrUpdate((Object) usergroup);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param usergroup a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Usergroup usergroup, Session s)
	{
		saveOrUpdate((Object) usergroup, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param usergroup a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.standard.Usergroup usergroup) 
	{
		update((Object) usergroup);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param usergroup a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.standard.Usergroup usergroup, Session s)
	{
		update((Object) usergroup, s);
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
	 * @param usergroup the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.standard.Usergroup usergroup)
	{
		delete((Object) usergroup);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param usergroup the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.standard.Usergroup usergroup, Session s)
	{
		delete((Object) usergroup, s);
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
	public void refresh (com.bureaueye.beacon.model.standard.Usergroup usergroup, Session s)
	{
		refresh((Object) usergroup, s);
	}


}
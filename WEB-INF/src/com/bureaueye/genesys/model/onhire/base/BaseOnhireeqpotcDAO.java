package com.bureaueye.genesys.model.onhire.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.genesys.model.onhire.dao.iface.OnhireeqpotcDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseOnhireeqpotcDAO extends com.bureaueye.genesys.model.onhire.dao._RootDAO {

	public BaseOnhireeqpotcDAO () {}
	
	public BaseOnhireeqpotcDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_ONHIREEQPOTCS_TOTAL_RESULTS = "findOnhireeqpotcsTotalResults";


	public static OnhireeqpotcDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static OnhireeqpotcDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.genesys.model.onhire.dao.OnhireeqpotcDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.genesys.model.onhire.Onhireeqpotc.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.genesys.model.onhire.Onhireeqpotc
	 */
	public com.bureaueye.genesys.model.onhire.Onhireeqpotc cast (Object object) {
		return (com.bureaueye.genesys.model.onhire.Onhireeqpotc) object;
	}

	public com.bureaueye.genesys.model.onhire.Onhireeqpotc get(java.lang.Integer key)
	{
		return (com.bureaueye.genesys.model.onhire.Onhireeqpotc) get(getReferenceClass(), key);
	}

	public com.bureaueye.genesys.model.onhire.Onhireeqpotc get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.genesys.model.onhire.Onhireeqpotc) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.genesys.model.onhire.Onhireeqpotc load(java.lang.Integer key)
	{
		return (com.bureaueye.genesys.model.onhire.Onhireeqpotc) load(getReferenceClass(), key);
	}

	public com.bureaueye.genesys.model.onhire.Onhireeqpotc load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.genesys.model.onhire.Onhireeqpotc) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.genesys.model.onhire.Onhireeqpotc loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.genesys.model.onhire.Onhireeqpotc obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.genesys.model.onhire.Onhireeqpotc> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.genesys.model.onhire.Onhireeqpotc> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.genesys.model.onhire.Onhireeqpotc> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param onhireeqpotc a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc)
	{
		return (java.lang.Integer) super.save(onhireeqpotc);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param onhireeqpotc a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc, Session s)
	{
		return (java.lang.Integer) save((Object) onhireeqpotc, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param onhireeqpotc a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc)
	{
		saveOrUpdate((Object) onhireeqpotc);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param onhireeqpotc a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc, Session s)
	{
		saveOrUpdate((Object) onhireeqpotc, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param onhireeqpotc a transient instance containing updated state
	 */
	public void update(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc) 
	{
		update((Object) onhireeqpotc);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param onhireeqpotc a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc, Session s)
	{
		update((Object) onhireeqpotc, s);
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
	 * @param onhireeqpotc the instance to be removed
	 */
	public void delete(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc)
	{
		delete((Object) onhireeqpotc);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param onhireeqpotc the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc, Session s)
	{
		delete((Object) onhireeqpotc, s);
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
	public void refresh (com.bureaueye.genesys.model.onhire.Onhireeqpotc onhireeqpotc, Session s)
	{
		refresh((Object) onhireeqpotc, s);
	}


}
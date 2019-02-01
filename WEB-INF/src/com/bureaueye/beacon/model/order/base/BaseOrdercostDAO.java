package com.bureaueye.beacon.model.order.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.order.dao.iface.OrdercostDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseOrdercostDAO extends com.bureaueye.beacon.model.order.dao._RootDAO {

	public BaseOrdercostDAO () {}
	
	public BaseOrdercostDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_ORDERMOVCOSTS_TOTAL_RESULTS = "findOrdermovcostsTotalResults";
	public static final String QUERY_FIND_ORDERCOSTS_TOTAL_RESULTS = "findOrdercostsTotalResults";


	public static OrdercostDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static OrdercostDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.order.dao.OrdercostDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.order.Ordercost.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.order.Ordercost
	 */
	public com.bureaueye.beacon.model.order.Ordercost cast (Object object) {
		return (com.bureaueye.beacon.model.order.Ordercost) object;
	}

	public com.bureaueye.beacon.model.order.Ordercost get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.order.Ordercost) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.order.Ordercost get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.order.Ordercost) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.order.Ordercost load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.order.Ordercost) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.order.Ordercost load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.order.Ordercost) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.order.Ordercost loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.order.Ordercost obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.order.Ordercost> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.order.Ordercost> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.order.Ordercost> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param ordercost a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.order.Ordercost ordercost)
	{
		return (java.lang.Integer) super.save(ordercost);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param ordercost a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.order.Ordercost ordercost, Session s)
	{
		return (java.lang.Integer) save((Object) ordercost, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param ordercost a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.order.Ordercost ordercost)
	{
		saveOrUpdate((Object) ordercost);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param ordercost a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.order.Ordercost ordercost, Session s)
	{
		saveOrUpdate((Object) ordercost, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param ordercost a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.order.Ordercost ordercost) 
	{
		update((Object) ordercost);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param ordercost a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.order.Ordercost ordercost, Session s)
	{
		update((Object) ordercost, s);
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
	 * @param ordercost the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.order.Ordercost ordercost)
	{
		delete((Object) ordercost);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param ordercost the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.order.Ordercost ordercost, Session s)
	{
		delete((Object) ordercost, s);
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
	public void refresh (com.bureaueye.beacon.model.order.Ordercost ordercost, Session s)
	{
		refresh((Object) ordercost, s);
	}


}
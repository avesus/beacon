package com.bureaueye.beacon.model.quotation.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacon.model.quotation.dao.iface.QuonoteDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseQuonoteDAO extends com.bureaueye.beacon.model.quotation.dao._RootDAO {

	public BaseQuonoteDAO () {}
	
	public BaseQuonoteDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_QUONOTES_TOTAL_RESULTS = "findQuonotesTotalResults";


	public static QuonoteDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static QuonoteDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacon.model.quotation.dao.QuonoteDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacon.model.quotation.Quonote.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacon.model.quotation.Quonote
	 */
	public com.bureaueye.beacon.model.quotation.Quonote cast (Object object) {
		return (com.bureaueye.beacon.model.quotation.Quonote) object;
	}

	public com.bureaueye.beacon.model.quotation.Quonote get(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.quotation.Quonote) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.quotation.Quonote get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.quotation.Quonote) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.quotation.Quonote load(java.lang.Integer key)
	{
		return (com.bureaueye.beacon.model.quotation.Quonote) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacon.model.quotation.Quonote load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacon.model.quotation.Quonote) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacon.model.quotation.Quonote loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacon.model.quotation.Quonote obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.quotation.Quonote> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacon.model.quotation.Quonote> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacon.model.quotation.Quonote> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param quonote a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.quotation.Quonote quonote)
	{
		return (java.lang.Integer) super.save(quonote);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param quonote a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.quotation.Quonote quonote, Session s)
	{
		return (java.lang.Integer) save((Object) quonote, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param quonote a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.quotation.Quonote quonote)
	{
		saveOrUpdate((Object) quonote);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param quonote a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.quotation.Quonote quonote, Session s)
	{
		saveOrUpdate((Object) quonote, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param quonote a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.quotation.Quonote quonote) 
	{
		update((Object) quonote);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param quonote a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacon.model.quotation.Quonote quonote, Session s)
	{
		update((Object) quonote, s);
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
	 * @param quonote the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.quotation.Quonote quonote)
	{
		delete((Object) quonote);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param quonote the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacon.model.quotation.Quonote quonote, Session s)
	{
		delete((Object) quonote, s);
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
	public void refresh (com.bureaueye.beacon.model.quotation.Quonote quonote, Session s)
	{
		refresh((Object) quonote, s);
	}


}
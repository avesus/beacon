package com.bureaueye.beacondms.model.dms.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.beacondms.model.dms.dao.iface.XdocumentDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseXdocumentDAO extends com.bureaueye.beacondms.model.dms.dao._RootDAO {

	public BaseXdocumentDAO () {}
	
	public BaseXdocumentDAO (Session session) {
		super(session);
	}

	// query name references


	public static XdocumentDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static XdocumentDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.beacondms.model.dms.dao.XdocumentDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.beacondms.model.dms.Xdocument.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.beacondms.model.dms.Xdocument
	 */
	public com.bureaueye.beacondms.model.dms.Xdocument cast (Object object) {
		return (com.bureaueye.beacondms.model.dms.Xdocument) object;
	}

	public com.bureaueye.beacondms.model.dms.Xdocument get(java.lang.Integer key)
	{
		return (com.bureaueye.beacondms.model.dms.Xdocument) get(getReferenceClass(), key);
	}

	public com.bureaueye.beacondms.model.dms.Xdocument get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacondms.model.dms.Xdocument) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacondms.model.dms.Xdocument load(java.lang.Integer key)
	{
		return (com.bureaueye.beacondms.model.dms.Xdocument) load(getReferenceClass(), key);
	}

	public com.bureaueye.beacondms.model.dms.Xdocument load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.beacondms.model.dms.Xdocument) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.beacondms.model.dms.Xdocument loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.beacondms.model.dms.Xdocument obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacondms.model.dms.Xdocument> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.beacondms.model.dms.Xdocument> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.beacondms.model.dms.Xdocument> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param xdocument a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacondms.model.dms.Xdocument xdocument)
	{
		return (java.lang.Integer) super.save(xdocument);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param xdocument a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacondms.model.dms.Xdocument xdocument, Session s)
	{
		return (java.lang.Integer) save((Object) xdocument, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param xdocument a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacondms.model.dms.Xdocument xdocument)
	{
		saveOrUpdate((Object) xdocument);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param xdocument a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.beacondms.model.dms.Xdocument xdocument, Session s)
	{
		saveOrUpdate((Object) xdocument, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param xdocument a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacondms.model.dms.Xdocument xdocument) 
	{
		update((Object) xdocument);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param xdocument a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.beacondms.model.dms.Xdocument xdocument, Session s)
	{
		update((Object) xdocument, s);
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
	 * @param xdocument the instance to be removed
	 */
	public void delete(com.bureaueye.beacondms.model.dms.Xdocument xdocument)
	{
		delete((Object) xdocument);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param xdocument the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.beacondms.model.dms.Xdocument xdocument, Session s)
	{
		delete((Object) xdocument, s);
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
	public void refresh (com.bureaueye.beacondms.model.dms.Xdocument xdocument, Session s)
	{
		refresh((Object) xdocument, s);
	}


}
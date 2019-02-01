package com.bureaueye.genesys.model.finance.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.bureaueye.genesys.model.finance.dao.iface.FinancehdrDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseFinancehdrDAO extends com.bureaueye.genesys.model.finance.dao._RootDAO {

	public BaseFinancehdrDAO () {}
	
	public BaseFinancehdrDAO (Session session) {
		super(session);
	}

	// query name references
	public static final String QUERY_FIND_FINANCEHDRS_TOTAL_RESULTS_NOT_MANUAL = "findFinancehdrsTotalResultsNotManual";
	public static final String QUERY_FIND_FINANCEHDRS_TOTAL_RESULTS_BY_DOCKEY = "findFinancehdrsTotalResultsByDockey";
	public static final String QUERY_FIND_FINANCEHDRS_TOTAL_RESULTS_MANUAL = "findFinancehdrsTotalResultsManual";
	public static final String QUERY_FIND_FINANCEHDRS_TOTAL_RESULTS_BY_FINANCEHDR_ID = "findFinancehdrsTotalResultsByFinancehdrId";


	public static FinancehdrDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static FinancehdrDAO getInstance () {
		if (null == instance) instance = new com.bureaueye.genesys.model.finance.dao.FinancehdrDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.bureaueye.genesys.model.finance.Financehdr.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.bureaueye.genesys.model.finance.Financehdr
	 */
	public com.bureaueye.genesys.model.finance.Financehdr cast (Object object) {
		return (com.bureaueye.genesys.model.finance.Financehdr) object;
	}

	public com.bureaueye.genesys.model.finance.Financehdr get(java.lang.Integer key)
	{
		return (com.bureaueye.genesys.model.finance.Financehdr) get(getReferenceClass(), key);
	}

	public com.bureaueye.genesys.model.finance.Financehdr get(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.genesys.model.finance.Financehdr) get(getReferenceClass(), key, s);
	}

	public com.bureaueye.genesys.model.finance.Financehdr load(java.lang.Integer key)
	{
		return (com.bureaueye.genesys.model.finance.Financehdr) load(getReferenceClass(), key);
	}

	public com.bureaueye.genesys.model.finance.Financehdr load(java.lang.Integer key, Session s)
	{
		return (com.bureaueye.genesys.model.finance.Financehdr) load(getReferenceClass(), key, s);
	}

	public com.bureaueye.genesys.model.finance.Financehdr loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.bureaueye.genesys.model.finance.Financehdr obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.genesys.model.finance.Financehdr> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.bureaueye.genesys.model.finance.Financehdr> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.bureaueye.genesys.model.finance.Financehdr> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param financehdr a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.genesys.model.finance.Financehdr financehdr)
	{
		return (java.lang.Integer) super.save(financehdr);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param financehdr a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.genesys.model.finance.Financehdr financehdr, Session s)
	{
		return (java.lang.Integer) save((Object) financehdr, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param financehdr a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.genesys.model.finance.Financehdr financehdr)
	{
		saveOrUpdate((Object) financehdr);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param financehdr a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.bureaueye.genesys.model.finance.Financehdr financehdr, Session s)
	{
		saveOrUpdate((Object) financehdr, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param financehdr a transient instance containing updated state
	 */
	public void update(com.bureaueye.genesys.model.finance.Financehdr financehdr) 
	{
		update((Object) financehdr);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param financehdr a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.bureaueye.genesys.model.finance.Financehdr financehdr, Session s)
	{
		update((Object) financehdr, s);
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
	 * @param financehdr the instance to be removed
	 */
	public void delete(com.bureaueye.genesys.model.finance.Financehdr financehdr)
	{
		delete((Object) financehdr);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param financehdr the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.bureaueye.genesys.model.finance.Financehdr financehdr, Session s)
	{
		delete((Object) financehdr, s);
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
	public void refresh (com.bureaueye.genesys.model.finance.Financehdr financehdr, Session s)
	{
		refresh((Object) financehdr, s);
	}


}
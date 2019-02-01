package com.bureaueye.beacon.model.mas500.dao.iface;

import java.io.Serializable;

public interface PaaplineDAO {
	public com.bureaueye.beacon.model.mas500.Paapline get(java.lang.Integer key);

	public com.bureaueye.beacon.model.mas500.Paapline load(java.lang.Integer key);

	public java.util.List<com.bureaueye.beacon.model.mas500.Paapline> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param paapline a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.bureaueye.beacon.model.mas500.Paapline paapline);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param paapline a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.mas500.Paapline paapline);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param paapline a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.mas500.Paapline paapline);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param paapline the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.mas500.Paapline paapline);


}
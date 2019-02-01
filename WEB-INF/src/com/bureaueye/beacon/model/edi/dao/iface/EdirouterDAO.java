package com.bureaueye.beacon.model.edi.dao.iface;

import java.io.Serializable;

public interface EdirouterDAO {
	public com.bureaueye.beacon.model.edi.Edirouter get(com.bureaueye.beacon.model.edi.EdirouterPK key);

	public com.bureaueye.beacon.model.edi.Edirouter load(com.bureaueye.beacon.model.edi.EdirouterPK key);

	public java.util.List<com.bureaueye.beacon.model.edi.Edirouter> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param edirouter a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public com.bureaueye.beacon.model.edi.EdirouterPK save(com.bureaueye.beacon.model.edi.Edirouter edirouter);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param edirouter a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.edi.Edirouter edirouter);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param edirouter a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.edi.Edirouter edirouter);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(com.bureaueye.beacon.model.edi.EdirouterPK id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param edirouter the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.edi.Edirouter edirouter);


}
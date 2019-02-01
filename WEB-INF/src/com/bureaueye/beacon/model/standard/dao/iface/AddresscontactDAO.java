package com.bureaueye.beacon.model.standard.dao.iface;

import java.io.Serializable;

public interface AddresscontactDAO {
	public com.bureaueye.beacon.model.standard.Addresscontact get(com.bureaueye.beacon.model.standard.AddresscontactPK key);

	public com.bureaueye.beacon.model.standard.Addresscontact load(com.bureaueye.beacon.model.standard.AddresscontactPK key);

	public java.util.List<com.bureaueye.beacon.model.standard.Addresscontact> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param addresscontact a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public com.bureaueye.beacon.model.standard.AddresscontactPK save(com.bureaueye.beacon.model.standard.Addresscontact addresscontact);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param addresscontact a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.bureaueye.beacon.model.standard.Addresscontact addresscontact);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param addresscontact a transient instance containing updated state
	 */
	public void update(com.bureaueye.beacon.model.standard.Addresscontact addresscontact);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(com.bureaueye.beacon.model.standard.AddresscontactPK id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param addresscontact the instance to be removed
	 */
	public void delete(com.bureaueye.beacon.model.standard.Addresscontact addresscontact);


}
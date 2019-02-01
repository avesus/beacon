package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseAddresscontactDAO;


public class AddresscontactDAO extends BaseAddresscontactDAO implements com.bureaueye.beacon.model.standard.dao.iface.AddresscontactDAO {

	public AddresscontactDAO () {}
	
	public AddresscontactDAO (Session session) {
		super(session);
	}


}
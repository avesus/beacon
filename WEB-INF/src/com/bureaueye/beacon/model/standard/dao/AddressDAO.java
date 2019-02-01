package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseAddressDAO;


public class AddressDAO extends BaseAddressDAO implements com.bureaueye.beacon.model.standard.dao.iface.AddressDAO {

	public AddressDAO () {}
	
	public AddressDAO (Session session) {
		super(session);
	}


}
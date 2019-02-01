package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseVendortariffhdrDAO;


public class VendortariffhdrDAO extends BaseVendortariffhdrDAO implements com.bureaueye.beacon.model.standard.dao.iface.VendortariffhdrDAO {

	public VendortariffhdrDAO () {}
	
	public VendortariffhdrDAO (Session session) {
		super(session);
	}


}
package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseVendortariffdtlDAO;


public class VendortariffdtlDAO extends BaseVendortariffdtlDAO implements com.bureaueye.beacon.model.standard.dao.iface.VendortariffdtlDAO {

	public VendortariffdtlDAO () {}
	
	public VendortariffdtlDAO (Session session) {
		super(session);
	}


}
package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseVendortarifflumpsumDAO;


public class VendortarifflumpsumDAO extends BaseVendortarifflumpsumDAO implements com.bureaueye.beacon.model.standard.dao.iface.VendortarifflumpsumDAO {

	public VendortarifflumpsumDAO () {}
	
	public VendortarifflumpsumDAO (Session session) {
		super(session);
	}


}
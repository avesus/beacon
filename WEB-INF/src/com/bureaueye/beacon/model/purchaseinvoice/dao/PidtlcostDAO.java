package com.bureaueye.beacon.model.purchaseinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseinvoice.base.BasePidtlcostDAO;


public class PidtlcostDAO extends BasePidtlcostDAO implements com.bureaueye.beacon.model.purchaseinvoice.dao.iface.PidtlcostDAO {

	public PidtlcostDAO () {}
	
	public PidtlcostDAO (Session session) {
		super(session);
	}


}
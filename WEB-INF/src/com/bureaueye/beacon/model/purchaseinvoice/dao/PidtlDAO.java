package com.bureaueye.beacon.model.purchaseinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseinvoice.base.BasePidtlDAO;


public class PidtlDAO extends BasePidtlDAO implements com.bureaueye.beacon.model.purchaseinvoice.dao.iface.PidtlDAO {

	public PidtlDAO () {}
	
	public PidtlDAO (Session session) {
		super(session);
	}


}
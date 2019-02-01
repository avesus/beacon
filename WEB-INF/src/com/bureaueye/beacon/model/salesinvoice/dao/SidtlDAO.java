package com.bureaueye.beacon.model.salesinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.salesinvoice.base.BaseSidtlDAO;


public class SidtlDAO extends BaseSidtlDAO implements com.bureaueye.beacon.model.salesinvoice.dao.iface.SidtlDAO {

	public SidtlDAO () {}
	
	public SidtlDAO (Session session) {
		super(session);
	}


}
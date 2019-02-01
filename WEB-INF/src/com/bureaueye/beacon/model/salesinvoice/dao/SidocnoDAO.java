package com.bureaueye.beacon.model.salesinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.salesinvoice.base.BaseSidocnoDAO;


public class SidocnoDAO extends BaseSidocnoDAO implements com.bureaueye.beacon.model.salesinvoice.dao.iface.SidocnoDAO {

	public SidocnoDAO () {}
	
	public SidocnoDAO (Session session) {
		super(session);
	}


}
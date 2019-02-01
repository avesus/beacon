package com.bureaueye.beacon.model.purchaseinvoice.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseinvoice.base.BasePidtlrcvdDAO;


public class PidtlrcvdDAO extends BasePidtlrcvdDAO implements com.bureaueye.beacon.model.purchaseinvoice.dao.iface.PidtlrcvdDAO {

	public PidtlrcvdDAO () {}
	
	public PidtlrcvdDAO (Session session) {
		super(session);
	}


}
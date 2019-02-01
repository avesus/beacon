package com.bureaueye.beacon.model.purchaseorder.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseorder.base.BasePodtlDAO;


public class PodtlDAO extends BasePodtlDAO implements com.bureaueye.beacon.model.purchaseorder.dao.iface.PodtlDAO {

	public PodtlDAO () {}
	
	public PodtlDAO (Session session) {
		super(session);
	}


}
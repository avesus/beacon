package com.bureaueye.beacon.model.purchaseorder.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.purchaseorder.base.BasePodtlrcvdDAO;


public class PodtlrcvdDAO extends BasePodtlrcvdDAO implements com.bureaueye.beacon.model.purchaseorder.dao.iface.PodtlrcvdDAO {

	public PodtlrcvdDAO () {}
	
	public PodtlrcvdDAO (Session session) {
		super(session);
	}


}
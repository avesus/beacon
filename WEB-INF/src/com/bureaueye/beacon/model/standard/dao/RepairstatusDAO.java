package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseRepairstatusDAO;


public class RepairstatusDAO extends BaseRepairstatusDAO implements com.bureaueye.beacon.model.standard.dao.iface.RepairstatusDAO {

	public RepairstatusDAO () {}
	
	public RepairstatusDAO (Session session) {
		super(session);
	}


}
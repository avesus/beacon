package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseVesselDAO;


public class VesselDAO extends BaseVesselDAO implements com.bureaueye.beacon.model.standard.dao.iface.VesselDAO {

	public VesselDAO () {}
	
	public VesselDAO (Session session) {
		super(session);
	}


}
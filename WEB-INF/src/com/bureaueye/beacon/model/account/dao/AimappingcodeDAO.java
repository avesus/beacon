package com.bureaueye.beacon.model.account.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.account.base.BaseAimappingcodeDAO;


public class AimappingcodeDAO extends BaseAimappingcodeDAO implements com.bureaueye.beacon.model.account.dao.iface.AimappingcodeDAO {

	public AimappingcodeDAO () {}
	
	public AimappingcodeDAO (Session session) {
		super(session);
	}


}
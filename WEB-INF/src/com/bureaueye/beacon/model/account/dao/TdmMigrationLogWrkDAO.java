package com.bureaueye.beacon.model.account.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.account.base.BaseTdmMigrationLogWrkDAO;


public class TdmMigrationLogWrkDAO extends BaseTdmMigrationLogWrkDAO implements com.bureaueye.beacon.model.account.dao.iface.TdmMigrationLogWrkDAO {

	public TdmMigrationLogWrkDAO () {}
	
	public TdmMigrationLogWrkDAO (Session session) {
		super(session);
	}


}
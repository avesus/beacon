package com.bureaueye.genesys.model.contract.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.contract.base.BaseContractagentDAO;


public class ContractagentDAO extends BaseContractagentDAO implements com.bureaueye.genesys.model.contract.dao.iface.ContractagentDAO {

	public ContractagentDAO () {}
	
	public ContractagentDAO (Session session) {
		super(session);
	}


}
package com.bureaueye.genesys.model.contract.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.contract.base.BaseContracteqpDAO;


public class ContracteqpDAO extends BaseContracteqpDAO implements com.bureaueye.genesys.model.contract.dao.iface.ContracteqpDAO {

	public ContracteqpDAO () {}
	
	public ContracteqpDAO (Session session) {
		super(session);
	}


}
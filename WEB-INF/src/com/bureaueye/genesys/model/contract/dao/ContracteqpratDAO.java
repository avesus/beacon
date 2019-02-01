package com.bureaueye.genesys.model.contract.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.contract.base.BaseContracteqpratDAO;


public class ContracteqpratDAO extends BaseContracteqpratDAO implements com.bureaueye.genesys.model.contract.dao.iface.ContracteqpratDAO {

	public ContracteqpratDAO () {}
	
	public ContracteqpratDAO (Session session) {
		super(session);
	}


}
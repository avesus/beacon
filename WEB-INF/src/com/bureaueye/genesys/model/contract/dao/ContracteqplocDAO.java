package com.bureaueye.genesys.model.contract.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.contract.base.BaseContracteqplocDAO;


public class ContracteqplocDAO extends BaseContracteqplocDAO implements com.bureaueye.genesys.model.contract.dao.iface.ContracteqplocDAO {

	public ContracteqplocDAO () {}
	
	public ContracteqplocDAO (Session session) {
		super(session);
	}


}
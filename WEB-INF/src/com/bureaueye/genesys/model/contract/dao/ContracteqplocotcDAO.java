package com.bureaueye.genesys.model.contract.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.contract.base.BaseContracteqplocotcDAO;


public class ContracteqplocotcDAO extends BaseContracteqplocotcDAO implements com.bureaueye.genesys.model.contract.dao.iface.ContracteqplocotcDAO {

	public ContracteqplocotcDAO () {}
	
	public ContracteqplocotcDAO (Session session) {
		super(session);
	}


}
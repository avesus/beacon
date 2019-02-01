package com.bureaueye.genesys.model.contract.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.contract.base.BaseContractDAO;


public class ContractDAO extends BaseContractDAO implements com.bureaueye.genesys.model.contract.dao.iface.ContractDAO {

	public ContractDAO () {}
	
	public ContractDAO (Session session) {
		super(session);
	}


}
package com.bureaueye.genesys.model.finance.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.finance.base.BaseFinancehdrDAO;


public class FinancehdrDAO extends BaseFinancehdrDAO implements com.bureaueye.genesys.model.finance.dao.iface.FinancehdrDAO {

	public FinancehdrDAO () {}
	
	public FinancehdrDAO (Session session) {
		super(session);
	}


}
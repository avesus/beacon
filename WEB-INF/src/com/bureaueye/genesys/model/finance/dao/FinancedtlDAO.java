package com.bureaueye.genesys.model.finance.dao;

import org.hibernate.Session;

import com.bureaueye.genesys.model.finance.base.BaseFinancedtlDAO;


public class FinancedtlDAO extends BaseFinancedtlDAO implements com.bureaueye.genesys.model.finance.dao.iface.FinancedtlDAO {

	public FinancedtlDAO () {}
	
	public FinancedtlDAO (Session session) {
		super(session);
	}


}
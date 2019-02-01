package com.bureaueye.beacon.model.standard.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.standard.base.BaseTaxcodeDAO;


public class TaxcodeDAO extends BaseTaxcodeDAO implements com.bureaueye.beacon.model.standard.dao.iface.TaxcodeDAO {

	public TaxcodeDAO () {}
	
	public TaxcodeDAO (Session session) {
		super(session);
	}


}
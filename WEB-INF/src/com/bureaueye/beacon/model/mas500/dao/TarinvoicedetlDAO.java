package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTarinvoicedetlDAO;


public class TarinvoicedetlDAO extends BaseTarinvoicedetlDAO implements com.bureaueye.beacon.model.mas500.dao.iface.TarinvoicedetlDAO {

	public TarinvoicedetlDAO () {}
	
	public TarinvoicedetlDAO (Session session) {
		super(session);
	}


}
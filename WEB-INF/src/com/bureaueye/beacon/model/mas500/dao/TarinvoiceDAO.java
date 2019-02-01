package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTarinvoiceDAO;


public class TarinvoiceDAO extends BaseTarinvoiceDAO implements com.bureaueye.beacon.model.mas500.dao.iface.TarinvoiceDAO {

	public TarinvoiceDAO () {}
	
	public TarinvoiceDAO (Session session) {
		super(session);
	}


}
package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTapvoucherDAO;


public class TapvoucherDAO extends BaseTapvoucherDAO implements com.bureaueye.beacon.model.mas500.dao.iface.TapvoucherDAO {

	public TapvoucherDAO () {}
	
	public TapvoucherDAO (Session session) {
		super(session);
	}


}
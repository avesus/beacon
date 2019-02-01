package com.bureaueye.beacon.model.mas500.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.mas500.base.BaseTapvoucherdetlDAO;


public class TapvoucherdetlDAO extends BaseTapvoucherdetlDAO implements com.bureaueye.beacon.model.mas500.dao.iface.TapvoucherdetlDAO {

	public TapvoucherdetlDAO () {}
	
	public TapvoucherdetlDAO (Session session) {
		super(session);
	}


}
package com.bureaueye.beacon.model.print.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.print.base.BasePrinthdrDAO;


public class PrinthdrDAO extends BasePrinthdrDAO implements com.bureaueye.beacon.model.print.dao.iface.PrinthdrDAO {

	public PrinthdrDAO () {}
	
	public PrinthdrDAO (Session session) {
		super(session);
	}


}
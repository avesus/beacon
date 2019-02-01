package com.bureaueye.beacon.model.print.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.print.base.BasePrintdtlDAO;


public class PrintdtlDAO extends BasePrintdtlDAO implements com.bureaueye.beacon.model.print.dao.iface.PrintdtlDAO {

	public PrintdtlDAO () {}
	
	public PrintdtlDAO (Session session) {
		super(session);
	}


}
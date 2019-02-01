package com.bureaueye.beacondms.model.dms.dao;

import org.hibernate.Session;

import com.bureaueye.beacondms.model.dms.base.BaseXdocumentDAO;


public class XdocumentDAO extends BaseXdocumentDAO implements com.bureaueye.beacondms.model.dms.dao.iface.XdocumentDAO {

	public XdocumentDAO () {}
	
	public XdocumentDAO (Session session) {
		super(session);
	}


}
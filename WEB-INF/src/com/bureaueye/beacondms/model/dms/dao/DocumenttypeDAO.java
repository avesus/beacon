package com.bureaueye.beacondms.model.dms.dao;

import org.hibernate.Session;

import com.bureaueye.beacondms.model.dms.base.BaseDocumenttypeDAO;


public class DocumenttypeDAO extends BaseDocumenttypeDAO implements com.bureaueye.beacondms.model.dms.dao.iface.DocumenttypeDAO {

	public DocumenttypeDAO () {}
	
	public DocumenttypeDAO (Session session) {
		super(session);
	}


}
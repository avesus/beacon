package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdioutbounderrorDAO;


public class EdioutbounderrorDAO extends BaseEdioutbounderrorDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdioutbounderrorDAO {

	public EdioutbounderrorDAO () {}
	
	public EdioutbounderrorDAO (Session session) {
		super(session);
	}


}
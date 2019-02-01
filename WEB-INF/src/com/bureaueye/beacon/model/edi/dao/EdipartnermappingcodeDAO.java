package com.bureaueye.beacon.model.edi.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.edi.base.BaseEdipartnermappingcodeDAO;


public class EdipartnermappingcodeDAO extends BaseEdipartnermappingcodeDAO implements com.bureaueye.beacon.model.edi.dao.iface.EdipartnermappingcodeDAO {

	public EdipartnermappingcodeDAO () {}
	
	public EdipartnermappingcodeDAO (Session session) {
		super(session);
	}


}
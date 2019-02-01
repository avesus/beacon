package com.bureaueye.beacon.model.job.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.job.base.BaseJobhdrDAO;


public class JobhdrDAO extends BaseJobhdrDAO implements com.bureaueye.beacon.model.job.dao.iface.JobhdrDAO {

	public JobhdrDAO () {}
	
	public JobhdrDAO (Session session) {
		super(session);
	}


}
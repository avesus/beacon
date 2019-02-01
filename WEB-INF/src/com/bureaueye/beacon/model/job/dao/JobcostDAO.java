package com.bureaueye.beacon.model.job.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.job.base.BaseJobcostDAO;


public class JobcostDAO extends BaseJobcostDAO implements com.bureaueye.beacon.model.job.dao.iface.JobcostDAO {

	public JobcostDAO () {}
	
	public JobcostDAO (Session session) {
		super(session);
	}


}
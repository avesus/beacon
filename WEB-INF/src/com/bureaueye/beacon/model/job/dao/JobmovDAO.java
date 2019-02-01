package com.bureaueye.beacon.model.job.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.job.base.BaseJobmovDAO;


public class JobmovDAO extends BaseJobmovDAO implements com.bureaueye.beacon.model.job.dao.iface.JobmovDAO {

	public JobmovDAO () {}
	
	public JobmovDAO (Session session) {
		super(session);
	}


}
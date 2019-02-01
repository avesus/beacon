package com.bureaueye.beacon.model.report.dao;

import org.hibernate.Session;

import com.bureaueye.beacon.model.report.base.BaseReportusageDAO;


public class ReportusageDAO extends BaseReportusageDAO implements com.bureaueye.beacon.model.report.dao.iface.ReportusageDAO {

	public ReportusageDAO () {}
	
	public ReportusageDAO (Session session) {
		super(session);
	}


}
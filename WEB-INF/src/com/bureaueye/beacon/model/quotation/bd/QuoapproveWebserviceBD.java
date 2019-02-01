package com.bureaueye.beacon.model.quotation.bd;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.quotation.Quoapprove;

import com.bureaueye.beacon.model.standard.User;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-04-01 BESL-201404-0001 RAVEMAX & WEBSERVICE
 * 
 */
public final class QuoapproveWebserviceBD extends BaseBD {

	// constructors
	public QuoapproveWebserviceBD() {
	}

	public QuoapproveWebserviceBD(SessionFactory _factory) {
		super(_factory);
	}

	public QuoapproveWebserviceBD(SessionFactory _factory1,
			SessionFactory _factory2) {
		super(_factory1, _factory2);
	}

	public QuoapproveWebserviceBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Quoapprove.class.getName();

	@Override
	public Object read(Object key) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrUpdate(Object dto, User user)
			throws ApplicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object dto, User user) throws ApplicationException {
		// TODO Auto-generated method stub

	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	@SuppressWarnings("rawtypes")
	public List findQuoapproves(ListForm listForm) throws ApplicationException {

		List queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			String queryString = "";
			queryString = "select new com.bureaueye.beacon.form.quotation.WorkflowWebserviceLineItem(quoapprove, quohdr)"
					+ " from"
					+ " com.bureaueye.beacon.model.quotation.Quoapprove quoapprove,"
					+ " com.bureaueye.beacon.model.quotation.Quohdr quohdr"
					+ " where"
					+ "     quoapprove.QuohdrId = quohdr.Id"
					+ " and quoapprove.Approveflag = '"
					+ listForm.getSearchString3()
					+ "'"
					+ " and (quoapprove.Userid = '"
					+ listForm.getSearchString1()
					+ "' or quoapprove.Usergroupid = '"
					+ listForm.getSearchString2()
					+ "') "
					+ " and quoapprove.Priority LIKE '%"
					+ listForm.getSearchString4()
					+ "%'"
					+ " order by "
					+ listForm.getOrderBy() + " " + listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResult;
	}

	@SuppressWarnings("rawtypes")
	public List findQuoapproveNotifications(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			String queryString = "";
			queryString = "select new com.bureaueye.beacon.form.quotation.WorkflowWebserviceLineItem(quoapprove, quohdr)"
					+ " from"
					+ " com.bureaueye.beacon.model.quotation.Quoapprove quoapprove,"
					+ " com.bureaueye.beacon.model.quotation.Quohdr quohdr"
					+ " where"
					+ "     quoapprove.QuohdrId = quohdr.Id"
					+ " and quoapprove.Approveflag = '"
					+ listForm.getSearchString3()
					+ "'"
					+ " and (quoapprove.Userid = '"
					+ listForm.getSearchString1()
					+ "' or quoapprove.Usergroupid = '"
					+ listForm.getSearchString2()
					+ "') "
					+ " and quoapprove.Createtimestamp > '"
					+ listForm.getSearchString4()
					+ "'"
					+ " order by "
					+ listForm.getOrderBy() + " " + listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResult;
	}

}

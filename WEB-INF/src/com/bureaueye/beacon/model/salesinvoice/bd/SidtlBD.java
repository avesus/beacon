package com.bureaueye.beacon.model.salesinvoice.bd;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.dao.SidtlDAO;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-01 WSI-201312-0001 BEACON LAKER (WSI LINER) - Sales Report
 * 
 */
public final class SidtlBD extends BaseBD {

	// constructors
	public SidtlBD() {
	}

	public SidtlBD(SessionFactory _factory) {
		super(_factory);
	}

	public SidtlBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Sidtl.class.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Sidtl read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Sidtl dao = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dao = (Sidtl) session.get(Sidtl.class, (Integer) key);

		} catch (HibernateException e) {
			// Any other error should result in a SystemException
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		return dao;

	}

	public void createOrUpdate(Object dao, User user)
	throws ApplicationException {

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

		try {
			Sidtl _dao = (Sidtl) dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getSidtlId()) != null) {
				session.update(_dao);
				new SystemlogBD(this.getSessionFactoryClusterMap())
				.createSystemlog(_dao, user, "update");
			} else {
				Calendar c = Calendar.getInstance();
				_dao.setCreatedate(c.getTime());
				_dao.setCreatetime(com.bureaueye.beacon.util.Util.toTime(c));
				_dao.setCreateuserid(user.getUserid());
				session.save(_dao);
			}

			tx.commit();
		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

	}

	public void delete(Object dao, User user) throws ApplicationException {

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}

		try {
			Sidtl _dao = (Sidtl) dao;

			Transaction tx = session.beginTransaction();
			session.delete(_dao);
			tx.commit();

			new SystemlogBD(this.getSessionFactoryClusterMap())
			.createSystemlog(_dao, user, "delete");
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	public List<SidtlDTO> findSidtlsById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {

		List<Sidtl> queryResult = null;
		List<SidtlDTO> queryResultDTO = new LinkedList<SidtlDTO>();

		if (order == null || order.equals("")) {
			return null;
		}

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			queryResult = session.createCriteria(Sidtl.class)
			.add(Expression.eq("SihdrId", new Integer(id)))
			.addOrder(Order.asc(order)).setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Sidtl dao = (Sidtl) it.next();
				SidtlDTO dto = new SidtlDTO(dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(dto);
			}

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryResultDTO;
	}

	public int findSidtlsTotalResults(String id) throws ApplicationException {

		int queryTotal = 0;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
			.getNamedQuery(SidtlDAO.QUERY_FIND_SIDTLS_TOTAL_RESULTS);
			q.setParameter("id", new Integer(id));
			queryTotal = ((Long) q.uniqueResult()).intValue();

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryTotal;
	}

	public BigDecimal sidtlsChgamtTotal(String id) throws ApplicationException {

		BigDecimal queryTotal = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session.getNamedQuery(SidtlDAO.QUERY_SIDTLS_CHGAMT_TOTAL);
			q.setParameter("id", new Integer(id));
			queryTotal = ((BigDecimal) q.uniqueResult());

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryTotal;
	}

	public BigDecimal sidtlsTaxamtTotal(String id) throws ApplicationException {

		BigDecimal queryTotal = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session.getNamedQuery(SidtlDAO.QUERY_SIDTLS_TAXAMT_TOTAL);
			q.setParameter("id", new Integer(id));
			queryTotal = ((BigDecimal) q.uniqueResult());

		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		// close Session
		try {
			session.close();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		return queryTotal;
	}

	public List<Sidtl> findSidtlsByOrderchargeId(Integer id)
	throws ApplicationException {

		List<Sidtl> queryResult = new LinkedList<Sidtl>();

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
			.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			Query q = session
			.createQuery("from Sidtl sidtl where sidtl.OrderchargeId = :OrderchargeId");
			q.setParameter("OrderchargeId", id);
			queryResult = q.list();

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

	public List findSidtlsByOrdhdrIdForAccountsreceivable(String id,
			int gotoPage, int maxResults, String order)
	throws ApplicationException {

		List queryResult = null;

		if (order == null || order.equals("")) {
			return null;
		}

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
			queryString = "select new com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO("
				+ "sidtl.Invoiceamt,sidtl.Txt1,"
				+ "sidtl.Chargekey,sidtl.SidtlId,sihdr.SihdrId,"
				+ "sihdr.Customeraddrkey,sihdr.Invoiceccykey,"
				+ "sihdr.Invoiceno,orderhdr.Ccykey,orderhdr.Orderno"
				+ ") "
				+ " from "
				+ "com.bureaueye.beacon.model.salesinvoice.Sihdr sihdr, "
				+ "com.bureaueye.beacon.model.salesinvoice.Sidtl sidtl, "
				+ "com.bureaueye.beacon.model.standard.Address address, "
				+ "com.bureaueye.beacon.model.order.Orderhdr orderhdr "
				+ " where "
				+ "     sidtl.OrderhdrId = "
				+ id
				+ " and sihdr.SihdrId = sidtl.SihdrId "
				+ " and sihdr.Customeraddrkey = address.Addrkey "
				+ " and sidtl.OrderhdrId = orderhdr.Id "
				+ " order by "
				+ order;
			queryResult = session.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults).list();

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

	
	//sWSI-201311-0001
	public List findSidtlsForWSILSalesreport(ListForm listForm)
	throws ApplicationException {

		List queryResult = null;
		DateFormatter dateFormatter = new DateFormatter();

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
			queryString = "select new com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO("
				+ "sidtl.Invoiceamt,sidtl.Txt1,"
				+ "sidtl.Chargekey,sidtl.SidtlId," 
				+ "sihdr.SihdrId, sihdr.Customeraddrkey," 
				+ "sihdr.Invoiceccykey, sihdr.Invoiceno,"
				+ "sihdr.Adddata3, sihdr.Adddata4,"
				+ "sidtl.Adddata2, sidtl.Adddata6, sidtl.Adddata3, "
				+ "sidtl.Adddata4, sihdr.Companykey, sihdr.Printdate"					
				+ ") "
				+ " from "
				+ "com.bureaueye.beacon.model.salesinvoice.Sihdr sihdr, "
				+ "com.bureaueye.beacon.model.salesinvoice.Sidtl sidtl "
				+ " where "
				+ " 	sihdr.SihdrId = sidtl.SihdrId "
				+ " and sihdr.Printdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and sihdr.Createuserid = 'WSIL1'"//only process LINER COMMISSION INVOICES				
				;

			//representative selection
			if (!listForm.getSearchString1().equals("")) {
				queryString = queryString+" and sidtl.Adddata2 = '"+listForm.getSearchString1()+"' ";
			}
			//service selection
			if (!listForm.getSearchString2().equals("")) {
				queryString = queryString+" and sihdr.Adddata4 = '"+listForm.getSearchString2()+"' ";
			}
			//commission type selection
			if (!listForm.getSearchString3().equals("")) {
				queryString = queryString+" and sidtl.Adddata3 = '"+listForm.getSearchString3()+"' ";
			}			
	
			
			queryString = queryString 
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			
			queryResult = session
			.createQuery(queryString)
			.list();

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
	//eWSI-201301-0001

	
}

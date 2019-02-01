package com.bureaueye.beacon.model.salesinvoice.bd;

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

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.dao.SihdrDAO;
import com.bureaueye.beacon.model.salesinvoice.dto.SihdrDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-11 WSI-201311-0002 BEACON LAKER (WSI LINER) - Sales Invoice
 * Template
 * 
 * NT 2014-06-09 201400026 - Add 'Order No' Descending Sort Order to Order list
 * - Add 'Doc Id' Descending Sort Order to Sales Invoice List
 * 
 */
public final class SihdrBD extends BaseBD {

	// constructors
	public SihdrBD() {
	}

	public SihdrBD(SessionFactory _factory) {
		super(_factory);
	}

	public SihdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Sihdr.class.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Sihdr read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Sihdr dao = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dao = (Sihdr) session.get(Sihdr.class, (Integer) key);

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
			Sihdr _dao = (Sihdr) dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getSihdrId()) != null) {
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
			Sihdr _dao = (Sihdr) dao;

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

	@SuppressWarnings("rawtypes")
	public void deleteAll(Integer id, User user) throws ApplicationException {

		if (id == null) {
			return;
		}
		Sihdr dto = null;

		try {
			// _BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {
				List set = getSidtls(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new SidtlBD().delete((Sidtl) it.next(), user);
				}
				delete(dto, user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	public Sihdr findSihdrByInvoiceno(String key) throws ApplicationException {

		Sihdr queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			queryResult = (Sihdr) session.createCriteria(Sihdr.class)
					.add(Expression.eq("Invoiceno", key)).setMaxResults(1)
					.uniqueResult();

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
	public List findSihdrsForSearch(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<SihdrDTO> queryResultDTO = new LinkedList<SihdrDTO>();
		DateFormatter dateFormatter = new DateFormatter();

		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
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
			queryString = "select sihdr" + " from Sihdr sihdr" + " where "
					+ "     sihdr.Companykey = '"
					+ listForm.getSearchString19()
					+ "'"
					+ " AND sihdr.Customeraddrkey LIKE '"
					+ listForm.getSearchString3()
					+ "'"
					+ " and sihdr.Createdate between '"
					+ dateFormatter.format(listForm.getSearchDate1())
					+ "' and '"
					+ dateFormatter.format(listForm.getSearchDate2())
					+ "'"
					+ " and sihdr.Departmentkey LIKE '"
					+ searchString5
					+ "'"
					+ " and sihdr.Activitykey LIKE '"+ searchString6+ "'";

			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();		
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}

			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Sihdr dao = (Sihdr) it.next();
				SihdrDTO dto = new SihdrDTO(dao,
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

	@SuppressWarnings("rawtypes")
	public List findSihdrsForSearchByInvoiceno(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<SihdrDTO> queryResultDTO = new LinkedList<SihdrDTO>();

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
			queryString = "select sihdr" + " from Sihdr sihdr" + " where"
					+ " sihdr.Invoiceno = '" + listForm.getSearchString1()+ "'";

			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();		
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}

			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Sihdr _dao = (Sihdr) it.next();
				SihdrDTO _dto = new SihdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

	@SuppressWarnings("rawtypes")
	public List findSihdrsForSearchBySihdrId(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<SihdrDTO> queryResultDTO = new LinkedList<SihdrDTO>();

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
			queryString = "select sihdr" + " from Sihdr sihdr" + " where"
					+ " sihdr.SihdrId = '" + listForm.getSearchString2() + "'";
			
			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();		
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}
			
			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Sihdr _dao = (Sihdr) it.next();
				SihdrDTO _dto = new SihdrDTO(_dao,
						this.getSessionFactoryClusterMap());
				queryResultDTO.add(_dto);
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

	public int findSihdrsTotalResults(ListForm listForm)
			throws ApplicationException {

		int queryTotal = 0;

		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
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

			Query q = session
					.getNamedQuery(SihdrDAO.QUERY_FIND_SIHDRS_TOTAL_RESULTS);
			q.setParameter("id1", listForm.getSearchString3());
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id2", searchString4);
			q.setParameter("id3", searchString5);
			q.setParameter("id4", searchString6);
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

	public int findSihdrsTotalResultsByInvoiceno(ListForm listForm)
			throws ApplicationException {

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
					.getNamedQuery(SihdrDAO.QUERY_FIND_SIHDRS_TOTAL_RESULTS_BY_INVOICENO);
			q.setParameter("id1", listForm.getSearchString1());
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

	public int findSihdrsTotalResultsBySihdrId(ListForm listForm)
			throws ApplicationException {

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
					.getNamedQuery(SihdrDAO.QUERY_FIND_SIHDRS_TOTAL_RESULTS_BY_SIHDR_ID);
			q.setParameter("id1", new Integer(listForm.getSearchString2()));
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

	@SuppressWarnings("rawtypes")
	public List getSidtls(Integer id) throws ApplicationException {

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

			Query q = session
					.createQuery("from Sidtl sidtl where sidtl.SihdrId = :SihdrId order by sidtl.SidtlId");
			q.setParameter("SihdrId", id);
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

	public int sihdrsCountByPrintedflagCreatedateCreateuserid(ListForm listForm)
			throws ApplicationException {

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
					.getNamedQuery(SihdrDAO.QUERY_SIHDRS_COUNT_BY_PRINTEDFLAG_CREATEDATE_CREATEUSERID);
			q.setParameter("id1", new Boolean(listForm.getSearchString1()));
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id2", listForm.getSearchString2());
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

	@SuppressWarnings({ "unused", "rawtypes" })
	public List findSihdrsForDashboard(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;
		List<SihdrDTO> queryResultDTO = new LinkedList<SihdrDTO>();
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
			queryString = "select sihdr" + " from Sihdr sihdr" + " where "
					+ "     sihdr.Printedflag = '"
					+ listForm.getSearchString2() + "'"
					+ " AND sihdr.Createuserid LIKE '"
					+ listForm.getSearchString1() + "'"

					+ " order by " + listForm.getOrderBy() + " "
					+ listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString)
					.setMaxResults(listForm.getMaxResults()).list();

			// iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Sihdr dao = (Sihdr) it.next();
				SihdrDTO dto = new SihdrDTO(dao,
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

}

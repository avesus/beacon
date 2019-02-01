package com.bureaueye.beacon.model.quotation.bd;

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
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.quotation.Quoprod;
import com.bureaueye.beacon.model.quotation.dao.QuoprodDAO;
import com.bureaueye.beacon.model.quotation.dto.QuoprodDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

public final class QuoprodBD extends BaseBD {

	// constructors
	public QuoprodBD() {
	}

	public QuoprodBD(SessionFactory _factory) {
		super(_factory);
	}

	public QuoprodBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);
	}

	public QuoprodBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Quoprod.class.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Quoprod read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Quoprod dto = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dto = (Quoprod) session.get(Quoprod.class, (Integer) key);

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

		return dto;

	}

	public void createOrUpdate(Object dto, User user)
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
			Quoprod _dto = (Quoprod) dto;

			Transaction tx = session.beginTransaction();

			if (read(_dto.getQuoprodId()) != null) {
				session.update(_dto);
				new SystemlogBD(this.getSessionFactoryClusterMap())
						.createSystemlog(_dto, user, "update");
			} else {
				Calendar c = Calendar.getInstance();
				_dto.setCreatedate(c.getTime());
				_dto.setCreatetime(com.bureaueye.beacon.util.Util.toTime(c));
				_dto.setCreateuserid(user.getUserid());
				session.save(_dto);
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

	public void delete(Object dto, User user) throws ApplicationException {

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}

		try {
			Quoprod _dto = (Quoprod) dto;

			Transaction tx = session.beginTransaction();
			session.delete(_dto);
			tx.commit();

			new SystemlogBD(this.getSessionFactoryClusterMap())
					.createSystemlog(_dto, user, "delete");
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
	public List findQuoprodsById(String id, int gotoPage, int maxResults,
			String order) throws ApplicationException {

		List queryResult = null;
		List<QuoprodDTO> queryResultDTO = new LinkedList<QuoprodDTO>();

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

			queryResult = session.createCriteria(Quoprod.class)
					.add(Expression.eq("QuohdrId", new Integer(id)))
					.addOrder(Order.asc(order))
					.setFirstResult(gotoPage * maxResults)
					.setMaxResults(maxResults).list();

			// TODO: iterate results to set many-to-one mappings
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quoprod _dao = (Quoprod) it.next();
				QuoprodDTO _dto = new QuoprodDTO(_dao,
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

	public int findQuoprodsTotalResults(String id) throws ApplicationException {

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
					.getNamedQuery(QuoprodDAO.QUERY_FIND_QUOPRODS_TOTAL_RESULTS);
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

	public Quoprod findFirstQuoprodByQuohdrId(Integer id)
			throws ApplicationException {

		Quoprod queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			queryResult = (Quoprod) session.createCriteria(Quoprod.class)
					.add(Expression.eq("QuohdrId", id))
					.setMaxResults(1).uniqueResult();

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

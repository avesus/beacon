package com.bureaueye.beacon.model.standard.bd;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Vendortariffavg;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-01 BESL-201402-0001 QUOTE MOVE AND COST TEMPLATE WORK
 * 
 */
public final class VendortariffavgBD extends BaseBD {

	// constructors
	public VendortariffavgBD() {
	}

	public VendortariffavgBD(SessionFactory _factory) {
		super(_factory);
	}

	public VendortariffavgBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Vendortariffavg.class
			.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Vendortariffavg read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Vendortariffavg dao = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dao = (Vendortariffavg) session.get(Vendortariffavg.class,
					(Integer) key);

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
			Vendortariffavg _dao = (Vendortariffavg) dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getVendortariffavgId()) != null) {
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
			Vendortariffavg _dao = (Vendortariffavg) dao;

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

	public void deleteAll(String id, User user) throws ApplicationException {

		if (id == null) {
			return;
		}
		Vendortariffavg dto = null;

		try {
			dto = read(id);
			if (dto != null) {
				delete(dto, user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}

	// -----------------------------------------------
	// FIND METHODS
	// -----------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Vendortariffavg> findVendortariffavgsBySearch(ListForm listForm)
			throws ApplicationException {

		List<Vendortariffavg> queryResult = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}

		try {

			DateFormatter dateFormatter = new DateFormatter();
			String queryString = "";
			queryString = "select vendortariffavg"
					+ " from Vendortariffavg vendortariffavg"
					+ " where" + " vendortariffavg.Createdate between '"
					+ dateFormatter.format(listForm.getSearchDate1())
					+ "' and '"
					+ dateFormatter.format(listForm.getSearchDate2()) + "'"
					+ " order by " + listForm.getOrderBy() + " "
					+ listForm.getOrderByDesc();

			queryResult = session.createQuery(queryString).list();

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

	public Vendortariffavg findLastVendortariffavgByCreatedate() 
	throws ApplicationException {
		
		Vendortariffavg queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Vendortariffavg)session
			.createCriteria(Vendortariffavg.class)
			.addOrder(Order.desc("Createdate"))
			.setMaxResults(1).uniqueResult();	
			
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		} 
		
		// close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}
		
		return queryResult;
	}	
	
	
	

	public Vendortariffavg findVendortariffAvgForUnitrate(
			String costkey,
			String fromlocationkey, String tolocationkey,
			String producthazardous, Integer units,
			Date date) throws ApplicationException {

		Vendortariffavg queryResult = null;
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
			queryString = "select vendortariffavg"
					+ " from Vendortariffavg vendortariffavg "
					+ " where"
					+ "    vendortariffavg.Costtype = 'UNITRATE'"
					+ " and vendortariffavg.Costkey = '"		+ costkey		+ "'"
					+ " and vendortariffavg.Fromlocationkey = '"		+ fromlocationkey		+ "'"
					+ " and vendortariffavg.Tolocationkey = '"		+ tolocationkey		+ "'"
					+ " and vendortariffavg.Fromvalue <= "+units
					+ " and vendortariffavg.Tovalue >= "+units			
					+ " and vendortariffavg.Validfrom <= '"		+ dateFormatter.format(date)		+ "'";
					
			// add extra search critera
			if (producthazardous != null && !producthazardous.equals(""))
				queryString = queryString
						+ " and vendortariffavg.Producthazardous = '"
						+ producthazardous + "'";
			
			queryString = queryString + " order by vendortariffavg.Createdate Desc";

			System.out.println("queryString - "+queryString);
			queryResult = (Vendortariffavg)session.createQuery(queryString).setMaxResults(1).uniqueResult();	

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




	public Vendortariffavg findVendortariffAvgForLumpsum(
			String costkey,
			String fromlocationkey, String tolocationkey,
			String producthazardous, 
			Date date) throws ApplicationException {

		Vendortariffavg queryResult = null;
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
			queryString = "select vendortariffavg"
					+ " from com.bureaueye.beacon.model.standard.Vendortariffavg vendortariffavg "
					+ " where"
					+ "     vendortariffavg.Costtype = 'LUMPSUM'"
					+ " and vendortariffavg.Costkey = '"		+ costkey		+ "'"
					+ " and vendortariffavg.Fromlocationkey = '"		+ fromlocationkey		+ "'"
					+ " and vendortariffavg.Tolocationkey = '"		+ tolocationkey		+ "'"
					+ " and vendortariffavg.Validfrom <= '"		+ dateFormatter.format(date)		+ "'";
			
					// add extra search critera
					if (producthazardous != null && !producthazardous.equals(""))
						queryString = queryString
								+ " and vendortariffavg.Producthazardous = '"
								+ producthazardous + "'";
					
					queryString = queryString + " order by vendortariffavg.Createdate Desc";

			queryResult = (Vendortariffavg)session.createQuery(queryString).setMaxResults(1).uniqueResult();

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

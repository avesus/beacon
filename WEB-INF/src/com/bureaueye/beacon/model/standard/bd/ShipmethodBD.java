package com.bureaueye.beacon.model.standard.bd;

import java.util.Calendar;
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
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Shipmethod;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

public final class ShipmethodBD extends BaseBD {

	// constructors
	public ShipmethodBD() {
	}

	public ShipmethodBD(SessionFactory _factory) {
		super(_factory);
	}

	public ShipmethodBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);
	}

	private static final String DEFAULT_CLASS_NAME = Shipmethod.class.getName();

	// -----------------------------------------------
	// CRUD METHODS
	// -----------------------------------------------
	public Shipmethod read(Object key) throws ApplicationException {

		if (key == null)
			return null;

		Shipmethod dto = null;

		// get Session
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME)
					.openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		try {

			dto = (Shipmethod) session.get(Shipmethod.class, (String) key);

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
			Shipmethod _dto = (Shipmethod) dto;

			Transaction tx = session.beginTransaction();

			if (read(_dto.getShipmethodId()) != null) {
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
			Shipmethod _dto = (Shipmethod) dto;

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
	public List findShipmethodsByShipmethod(ListForm listForm)
			throws ApplicationException {

		List queryResult = null;

		//
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}

		if (listForm.getOrderBy() == null || listForm.getOrderBy().equals("")) {
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

			queryResult = session.createCriteria(Shipmethod.class)
					.add(Expression.like("ShipMethod", searchString1))
					.addOrder(Order.asc(listForm.getOrderBy())).list();

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

	public List findShipmethods() throws ApplicationException {

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
					.createQuery("from Shipmethod shipmethod order by shipmethod.ShipMethod");
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

}

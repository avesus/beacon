package com.bureaueye.beacon.model.order.bd;

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

import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.order.Ordernotecust;
import com.bureaueye.beacon.model.order.dao.OrdernoteDAO;
import com.bureaueye.beacon.model.order.dao.OrdernotecustDAO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



/**
 * 
 * Amendments
 * ----------
 * 												
 */
public final class OrdernotecustBD extends BaseBD {


	// constructors
	public OrdernotecustBD() {
	}
	public OrdernotecustBD(SessionFactory _factory) {
		super(_factory);		
	}
	public OrdernotecustBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public OrdernotecustBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}


	private static final String DEFAULT_CLASS_NAME = Ordernotecust.class.getName();	


	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Ordernotecust read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		Ordernotecust dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {

			dao = (Ordernotecust)session.get(Ordernotecust.class, (Integer)key);

		} catch (HibernateException e) {
			// Any other error should result in a SystemException
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}


		// close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);
		}

		return dao;

	}


	public void createOrUpdate(Object dao, User user)
	throws ApplicationException {

		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);			
		}


		try {
			Ordernotecust _dao=(Ordernotecust)dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getOrdernotecustId()) != null) {
				session.update(_dao);
				new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dao, user, "update");
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

		//		close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);
		}

	}


	public void delete(Object dao, User user) throws ApplicationException {

		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);			
		}

		try {
			Ordernotecust _dao=(Ordernotecust)dao;

			Transaction tx = session.beginTransaction();
			session.delete(_dao);
			tx.commit();		

			new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dao, user, "delete");
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		} 


		//		close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}




	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------	
	public List findOrdernotecustsById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order,
			String order2							
	) throws ApplicationException {

		List queryResult = null;

		if (order == null || order.equals("")) {
			return null;
		}
		if (order2 == null) {
			order2 = "";
		}

		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			if (order.equals("Createdate")) {
				queryResult = session.createCriteria(
						Ordernotecust.class).add(
								Expression.eq("OrderhdrId", new Integer(id)))
								.addOrder(Order.desc(order))
								.addOrder(Order.desc(order2))						
								.setMaxResults(maxResults).list();
			} else {			
				if (order2.equals("")) {
					queryResult = session.createCriteria(
							Ordernotecust.class).add(
									Expression.eq("OrderhdrId", new Integer(id)))
									.addOrder(Order.asc(order))					
									.setMaxResults(maxResults).list();
				} else {
					queryResult = session.createCriteria(
							Ordernotecust.class).add(
									Expression.eq("OrderhdrId", new Integer(id)))
									.addOrder(Order.asc(order))
									.addOrder(Order.desc(order2))					
									.setMaxResults(maxResults).list();

				}
			}
		} catch (HibernateException e) {		
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		} 	

		//		close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}		

		return queryResult;
	}	


	public int findOrdernotecustsTotalResults(String id)
	throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(OrdernotecustDAO.QUERY_FIND_ORDERNOTECUSTS_TOTAL_RESULTS);
			q.setParameter("id", new Integer(id));			
			queryTotal=((Long)q.uniqueResult()).intValue();
			
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
		
		return queryTotal;
	}
	

	
	

}

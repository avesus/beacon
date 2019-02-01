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
import com.bureaueye.beacon.model.order.Orderfile;
import com.bureaueye.beacon.model.order.dao.OrderfileDAO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;





public final class OrderfileBD extends BaseBD {
	
	
	// constructors
	public OrderfileBD() {
	}
	public OrderfileBD(SessionFactory _factory) {
		super(_factory);		
	}
	public OrderfileBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public OrderfileBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Orderfile.class.getName();	
    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Orderfile read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Orderfile dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Orderfile)session.get(Orderfile.class, (Integer)key);
			
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
		
		return dto;
		
	}
	
	
	public void createOrUpdate(Object dto, User user)
	throws ApplicationException {
		
		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);			
		}
		
		
		try {
			Orderfile _dto=(Orderfile)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getOrderfileId()) != null) {
				session.update(_dto);
				new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dto, user, "update");
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
		
		//		close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);
		}
		
	}
	
	
	public void delete(Object dto, User user) throws ApplicationException {
		
		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);			
		}
		
		try {
			Orderfile _dto=(Orderfile)dto;
			
			Transaction tx = session.beginTransaction();
			session.delete(_dto);
			tx.commit();		
			
			new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dto, user, "delete");
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
	@SuppressWarnings("unchecked")
	public List<Orderfile> findOrderfilesById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order,
			String order2							
	) throws ApplicationException {
		List<Orderfile> queryResult = null;
		
		if (order == null || order.equals("")) {
			return null;
		}
		if (order2 == null) {
			order2 = "";
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			if (order.equals("Createdate")) {
				queryResult = session.createCriteria(Orderfile.class).add(
						Expression.eq("OrderhdrId", new Integer(id)))
						.addOrder(Order.desc(order))
						.addOrder(Order.desc(order2))						
						.setMaxResults(maxResults).list();
			} else {			
				if (order2.equals("")) {
					queryResult = session.createCriteria(Orderfile.class).add(
							Expression.eq("OrderhdrId", new Integer(id)))
							.addOrder(Order.asc(order))					
							.setMaxResults(maxResults).list();
				} else {
					queryResult = session.createCriteria(Orderfile.class).add(
							Expression.eq("OrderhdrId", new Integer(id)))
							.addOrder(Order.asc(order))
							.addOrder(Order.desc(order2))					
							.setMaxResults(maxResults).list();
					
				}
			}
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
	
	
	public int findOrderfilesTotalResults(String id)
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
			
			Query q = session.getNamedQuery(OrderfileDAO.QUERY_FIND_ORDERFILES_TOTAL_RESULTS);
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

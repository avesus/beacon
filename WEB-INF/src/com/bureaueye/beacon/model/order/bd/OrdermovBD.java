/*
 * $Id: OrdermovBD.java  2007-12-03 ntankard $ 
 */
package com.bureaueye.beacon.model.order.bd;

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
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.order.dao.OrdermovDAO;
import com.bureaueye.beacon.model.order.dto.OrdermovDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



public final class OrdermovBD extends BaseBD {
	
	
	// constructors
	public OrdermovBD() {
	}
	public OrdermovBD(SessionFactory _factory) {
		super(_factory);		
	}
	public OrdermovBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public OrdermovBD(
			SessionFactory _factory1, 
			SessionFactory _factory2,
			SessionFactory _factory3
			) {
		super(_factory1, _factory2, _factory3);		
	}
	public OrdermovBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Ordermov.class.getName();		
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Ordermov read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Ordermov dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Ordermov)session.get(Ordermov.class, (Integer)key);
			
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
			Ordermov _dto=(Ordermov)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getOrdermovId()) != null) {
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
			Ordermov _dto=(Ordermov)dto;
			
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
	
	
	public void deleteAll(Integer id, User user)
	throws ApplicationException {
		
		if (id == null) {return;}
		Ordermov dto = null;
		
		try {
			dto = read(id);
			if (dto != null) {
				List set = getOrdercosts(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new OrdercostBD().delete((Ordercost)it.next(), user);
				}
				delete(dto,user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}
	
	
	
	
	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------	
	public List findOrdermovsById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order,
			String order2
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrdermovDTO> queryResultDTO = new LinkedList<OrdermovDTO>();
		
		if (order == null || order.equals("")) {
			return null;
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Ordermov.class)
			.add(Expression.eq("OrderhdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.addOrder(Order.asc(order2))							
			.setMaxResults(maxResults)
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Ordermov dao=(Ordermov)it.next();
				OrdermovDTO dto=new OrdermovDTO(dao, this.getSessionFactoryClusterMap()); 
				queryResultDTO.add(dto);
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
		
		return queryResultDTO;
	}		
	
	
	public int findOrdermovsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(OrdermovDAO.QUERY_FIND_ORDERMOVS_TOTAL_RESULTS);
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
	
	
	public Ordermov findOrdermovByOrderhdrIdSectionkey(
			String orderhdrid,
			String sectionkey
	) throws ApplicationException {
		
		Ordermov queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Ordermov)session
			.createCriteria(Ordermov.class)
			.add(Expression.eq("OrderhdrId",  new Integer(orderhdrid)))
			.add(Expression.eq("Sectionkey", sectionkey))
			.addOrder(Order.asc("Fromdayno"))
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
	
	
	public List getOrdercosts(Integer id)
	throws ApplicationException {			
		
		List queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session
			.createQuery("from Ordercost ordercost where ordercost.OrdermovId = :OrdermovId");
			q.setParameter("OrdermovId", id);			
			queryResult=q.list();
			
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
	
	
}

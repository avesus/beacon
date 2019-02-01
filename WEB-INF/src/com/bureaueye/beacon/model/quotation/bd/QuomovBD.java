/*
 * $Id: QuomovBD.java  2007-12-03 ntankard $ 
 */
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
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.dao.QuomovDAO;
import com.bureaueye.beacon.model.quotation.dto.QuomovDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



public final class QuomovBD extends BaseBD {
	
	
	// constructors
	public QuomovBD() {
	}
	public QuomovBD(SessionFactory _factory) {
		super(_factory);		
	}
	public QuomovBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public QuomovBD(
			SessionFactory _factory1, 
			SessionFactory _factory2,
			SessionFactory _factory3
			) {
		super(_factory1, _factory2, _factory3);		
	}
	public QuomovBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Quomov.class.getName();	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Quomov read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Quomov dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Quomov)session.get(Quomov.class, (Integer)key);
			
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
			Quomov _dto=(Quomov)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getQuomovId()) != null) {
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
			Quomov _dto=(Quomov)dto;
			
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
		Quomov dto = null;
		
		try {
			dto = read(id);
			if (dto != null) {
				List set = getQuocosts(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuocostBD().delete((Quocost)it.next(), user);
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
	public List findQuomovsById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {
		
		List queryResult = null;
		List<QuomovDTO> queryResultDTO = new LinkedList<QuomovDTO>();

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
			.createCriteria(Quomov.class)
			.add(Expression.eq("QuohdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quomov _dao=(Quomov)it.next();
				QuomovDTO _dto=new QuomovDTO(_dao, this.getSessionFactoryClusterMap()); 
				queryResultDTO.add(_dto);
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
	
	
	public int findQuomovsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(QuomovDAO.QUERY_FIND_QUOMOVS_TOTAL_RESULTS);
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
	
	
	public Quomov findQuomovByQuohdrIdSectionkey(
			String quohdrid,
			String sectionkey
	) throws ApplicationException {
		
		Quomov queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Quomov)session
			.createCriteria(Quomov.class)
			.add(Expression.eq("QuohdrId",  new Integer(quohdrid)))
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
	
	
	public Quomov findLastQuomovByQuohdrId(
			String quohdrid
	) throws ApplicationException {
		
		Quomov queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Quomov)session
			.createCriteria(Quomov.class)
			.add(Expression.eq("QuohdrId", new Integer(quohdrid)))
			.addOrder(Order.desc("Seqno"))
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
		
	
	public List getQuocosts(Integer id)
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
			.createQuery("from Quocost quocost where quocost.QuomovId = :QuomovId");
			q.setParameter("QuomovId", id);			
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

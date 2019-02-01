/*
 * $Id: OffhireeqpotcDB.java 2007-04-07 ntankard $ 
 */
package com.bureaueye.genesys.model.offhire.bd;

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
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;
import com.bureaueye.genesys.model.offhire.Offhireeqpotc;
import com.bureaueye.genesys.model.offhire.dao.OffhireeqpotcDAO;
import com.bureaueye.genesys.model.offhire.dto.OffhireeqpotcDTO;





public final class OffhireeqpotcBD extends BaseBD {
	
	
	// constructors
	public OffhireeqpotcBD() {
	}
	public OffhireeqpotcBD(SessionFactory _factory) {
		super(_factory);		
	}	
	public OffhireeqpotcBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}
	public OffhireeqpotcBD(SessionFactory _factory1, SessionFactory _factory2, SessionFactory _factory3) {
		super(_factory1, _factory2, _factory3);		
	}	
	public OffhireeqpotcBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
	private static final String DEFAULT_CLASS_NAME = Offhireeqpotc.class.getName();	
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Offhireeqpotc read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Offhireeqpotc dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Offhireeqpotc)session.get(Offhireeqpotc.class, (Integer)key);
			
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
			Offhireeqpotc _dto=(Offhireeqpotc)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getOffhireeqpotcId()) != null) {
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
			Offhireeqpotc _dto=(Offhireeqpotc)dto;
			
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
	public List findOffhireeqpotcsById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {
		
		List queryResult = null;	
		List<OffhireeqpotcDTO> queryResultDTO = new LinkedList<OffhireeqpotcDTO>();
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			queryResult = session
			.createCriteria(Offhireeqpotc.class)
			.add(Expression.eq("OffhireeqpId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Offhireeqpotc _dao=(Offhireeqpotc)it.next();
				OffhireeqpotcDTO _dto=new OffhireeqpotcDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public int findOffhireeqpotcsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(OffhireeqpotcDAO.QUERY_FIND_OFFHIREEQPOTCS_TOTAL_RESULTS);	
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

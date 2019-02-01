
package com.bureaueye.beacon.model.mas500.bd;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.mas500.Paapline;








/**
 *
 * Amendments
 * ----------
 *	
 *	NT	2010-08-18		ITT-201008-0001		Job Actual Vs Estimate Report
 *								
 */
public final class PaaplineBD {
	
	
	// constructors
	public PaaplineBD() {
	}
	public PaaplineBD(SessionFactory _factory) {
		setSessionFactory1(_factory);			
	}	
	
	
	private SessionFactory _sessionFactory1;
	
	public SessionFactory getSessionFactory1 () {
		return _sessionFactory1;
	}
	public void setSessionFactory1 (SessionFactory _factory) {
		this._sessionFactory1 = _factory;
	}
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Paapline read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Paapline dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactory1().openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Paapline)session.get(Paapline.class, (Integer)key);
			
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
	
	
	
	
	
	
	
	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------
	public List findPaaplinesByIntJobLineKey(
			Integer intJobLineKey						
	) throws ApplicationException {
		
		List queryResult = null;

		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactory1().openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Paapline.class)
			.add(Expression.eq("IntJobLineKey", intJobLineKey))
			.addOrder(Order.asc("VoucherLineKey"))
			.list();		
			
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
	
	
	public List findPaaplinesByIntJobKey(
			Integer intJobKey						
	) throws ApplicationException {
		
		List queryResult = null;

		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactory1().openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Paapline.class)
			.add(Expression.eq("IntJobKey", intJobKey))
			.addOrder(Order.asc("VoucherLineKey"))
			.list();		
			
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

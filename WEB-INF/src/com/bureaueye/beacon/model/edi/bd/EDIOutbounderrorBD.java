/*
 * $Id: EDIOutboundDB.java 164858 2005-09-09 ntankard $ 
 */
package com.bureaueye.beacon.model.edi.bd;

import java.util.Calendar;
import java.util.Map;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;


import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.edi.Edioutbound;
import com.bureaueye.beacon.model.edi.Edioutbounderror;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;






/**
 */
public final class EDIOutbounderrorBD extends BaseBD {
	
	
	// constructors
	public EDIOutbounderrorBD() {
	}
	public EDIOutbounderrorBD(SessionFactory _factory) {
		super(_factory);		
	}
	public EDIOutbounderrorBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}		
	public EDIOutbounderrorBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Edioutbounderror.class.getName();	
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Edioutbound read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Edioutbound dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Edioutbound)session.get(Edioutbound.class, (Integer)key);
			
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
			Edioutbound _dto=(Edioutbound)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getEdioutboundId()) != null) {
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
			Edioutbound _dto=(Edioutbound)dto;
			
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
	public Edioutbounderror findEDIOutbounderrorByDockey(String dockey) 
	throws ApplicationException {
		
		Edioutbounderror queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Edioutbounderror)session
			.createCriteria(Edioutbounderror.class)
			.add( Expression.eq("Dockey", dockey) )
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
	
	
	
}

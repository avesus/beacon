package com.bureaueye.beacon.model.standard.bd;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Userlistform;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;




/**
 * Amendments
 * ----------
 * 												
 */
public final class UserlistformBD extends BaseBD {
	
	
	// constructors
	public UserlistformBD() {
	}
	public UserlistformBD(SessionFactory _factory) {
		super(_factory);		
	}
	public UserlistformBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}		
	public UserlistformBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Userlistform.class.getName();	
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Userlistform read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Userlistform dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Userlistform)session.get(Userlistform.class, (Integer)key);
			
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
			Userlistform _dto=(Userlistform)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getUserlistformId()) != null) {
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
			Userlistform _dto=(Userlistform)dto;
			
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
	public List findUserlistformsByUserid(
			String userid
	)
	throws ApplicationException {
		
		List queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Userlistform.class)
			.add(Expression.eq("Userid", userid))			
			.addOrder(Order.desc("Listform"))
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
		
	
	public Userlistform findUserlistformByKey1(
			String userid,
			String listform
			) 
	throws ApplicationException {
		
		Userlistform queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Userlistform)session
			.createCriteria(Userlistform.class)
			.add( Expression.eq("Userid", userid) )
			.add( Expression.eq("Listform", listform) )
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
	
		
	public List findUserlistformsBySearch(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}	
		
		try {
			
			queryResult = session.createCriteria(Userlistform.class)
			.add(Expression.like("Userid", listForm.getId()))						
			.addOrder(Order.asc(listForm.getOrderBy()))
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

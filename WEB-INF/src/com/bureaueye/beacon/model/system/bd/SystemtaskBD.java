package com.bureaueye.beacon.model.system.bd;


import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

import com.bureaueye.beacon.model.bd.BaseBD;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.Systemtask;






public final class SystemtaskBD extends BaseBD {
		
		

	// constructors
	public SystemtaskBD() {
	}
	public SystemtaskBD(SessionFactory _factory) {
		super(_factory);		
	}
	public SystemtaskBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
    private static final String DEFAULT_CLASS_NAME = Systemtask.class.getName();

    
    
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	@Override
	public Systemtask read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Systemtask dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Systemtask)session.get(Systemtask.class, (Integer)key);
			
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
	
	
	@Override
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
			Systemtask _dto=(Systemtask)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getSystemtaskId()) != null) {
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
	
	
	@Override
	public void delete(Object dto, User user) throws ApplicationException {
		
		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);			
		}
		
		try {
			Systemtask _dto=(Systemtask)dto;
			
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
	public Systemtask findSystemtaskByTaskid(String id) 
	throws ApplicationException {
		
		List dtos = null;
		Systemtask dto = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {			
			
			dtos = session.createCriteria(Systemtask.class)
						.add(Restrictions.eq("Taskid", id))
						.list();
			if (dtos.size() >= 1) {
				dto = (Systemtask)dtos.iterator().next();
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
		
		return dto;
	}
	
	
	public List findSystemtaskByNextRunDateTime(long currentTimeInMillis) 
	throws ApplicationException {
		
		List dtos = null;

		
		// get Session 
		Session session = null;
		try {
			session = getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {			
		
			String queryString = "";
			queryString = 
				"select systemtask from com.bureaueye.beacon.model.system.Systemtask systemtask"
				+ " where"
				+ " systemtask.Nextrun <= "+currentTimeInMillis;
			dtos = session.createQuery(queryString).list();
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
		
		return dtos;
	}
	
	
	
	public List findSystemtasksBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		
		//			
		String searchString1=listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1="%";
		}	
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {			
			
			String queryString = "";
			queryString = 
				"select systemtask"+
				" from com.bureaueye.beacon.model.system.Systemtask systemtask"
				+ " where"			
				+ " systemtask.Taskid LIKE '"+searchString1+"'"			
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			
			queryResult = session
			.createQuery(queryString)
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

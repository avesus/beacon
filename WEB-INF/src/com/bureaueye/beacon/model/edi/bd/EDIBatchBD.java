/*
 * $Id: EDIBatchDB.java 2005-12-03 ntankard $ 
 */
package com.bureaueye.beacon.model.edi.bd;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.edi.Edibatch;
import com.bureaueye.beacon.model.edi.dao.EdibatchDAO;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;






/**
 */
public final class EDIBatchBD extends BaseBD {
	
	
	// constructors
	public EDIBatchBD() {
	}
	public EDIBatchBD(SessionFactory _factory) {
		super(_factory);		
	}
	public EDIBatchBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}		
	public EDIBatchBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Edibatch.class.getName();	
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Edibatch read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Edibatch dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Edibatch)session.get(Edibatch.class, (Integer)key);
			
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
			Edibatch _dto=(Edibatch)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getEdibatchId()) != null) {
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
			Edibatch _dto=(Edibatch)dto;
			
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
	public List findEDIBatchsBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		
		//			
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}		
		//			
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {
			DateFormatter dateFormatter = new DateFormatter();				
			
			String queryString = "";
			queryString = 
				"select edibatch"+
				" from com.bureaueye.beacon.model.edi.Edibatch edibatch"
				+ " where"			
				+ " edibatch.Createdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			
			queryResult = session
			.createQuery(queryString)
			//.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			//.setMaxResults(listForm.getMaxResults())
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
	
	
	
	
	public int findEDIBatchsTotalResults(ListForm listForm) throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
				
		try {
			
			Query q = session.getNamedQuery(EdibatchDAO.QUERY_FIND_E_D_I_BATCHS_TOTAL_RESULTS);
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			
			queryTotal=((Long)q.uniqueResult()).intValue();
			
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}
		
		return queryTotal;
		
	}
	
	
	
}

/*
 * $Id: EDIOutboundDB.java 2007-12-03 ntankard $ 
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
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;

import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.edi.Edioutbound;
import com.bureaueye.beacon.model.edi.dao.EdioutboundDAO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;







/**
 */
public final class EDIOutboundBD extends BaseBD {
	
	
	// constructors
	public EDIOutboundBD() {
	}
	public EDIOutboundBD(SessionFactory _factory) {
		super(_factory);		
	}
	public EDIOutboundBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}		
	public EDIOutboundBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Edioutbound.class.getName();	
	
	
	
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
	public List findEDIOutboundsBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		
		//			
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		//			
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
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
				"select edioutbound"+
				" from com.bureaueye.beacon.model.edi.Edioutbound edioutbound"
				+ " where"
				+ " edioutbound.EdioutboundId LIKE '"+searchString3+"'"				
				+ " and edioutbound.Doctype LIKE '"+searchString1+"'"
				+ " and edioutbound.Ediid LIKE '"+listForm.getSearchString2()+"'"
				+ " and edioutbound.Createdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and edioutbound.Edistatus LIKE '"+listForm.getSearchString9()+"'"				
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
	
	
	
	
	public int findEDIOutboundsTotalResults(ListForm listForm) throws ApplicationException {
		
		int queryTotal=0;
		
		//			
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {
			
			Query q = session.getNamedQuery(EdioutboundDAO.QUERY_FIND_E_D_I_OUTBOUNDS_TOTAL_RESULTS);
			q.setParameter("id1", listForm.getSearchString1());
			q.setParameter("id2", listForm.getSearchString2());
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id3", listForm.getSearchString9());
			
			queryTotal=((Long)q.uniqueResult()).intValue();
			
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}
		
		return queryTotal;
		
	}	
	
	
	
	
	
	public List findEDIoutboundsByEDIstatusCreatedate(
			String status,
			java.util.Date fromdate,
			java.util.Date todate
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
			.createCriteria(Edioutbound.class)
			.add(Expression.eq("Edistatus", status))
			.add(Expression.ge("Createdate", fromdate))
			.add(Expression.le("Createdate", todate))				
			.addOrder(Order.desc("EDIOUTBOUND_ID"))
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
	
	
	
	
	public Edioutbound findEDIOutboundByDockey(String dockey) 
	throws ApplicationException {
		
		Edioutbound queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Edioutbound)session
			.createCriteria(Edioutbound.class)
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
	
	
	
	
	
	public List findEDIoutboundsByEDIstatus(
			String status
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
			.createCriteria(Edioutbound.class)
			.add(Expression.eq("Edistatus", status))
			.addOrder(Order.asc("Createdate"))
			.addOrder(Order.asc("Createtime"))
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

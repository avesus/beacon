package com.bureaueye.beacon.model.salesinvoice.bd;



import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.salesinvoice.Sidocno;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

 
/**
 * 
 * Amendments ----------
 * 
 * NT	2013-12-12	WSI-201312-0002	BEACON LAKER (WSI CINICINNATI AGENCY) - Generate Vessel Manifest Sales Invoices
 * 
 */
public final class SidocnoBD extends BaseBD {
	
	
	// constructors
	public SidocnoBD() {
	}
	public SidocnoBD(SessionFactory _factory) {
		super(_factory);		
	}
	public SidocnoBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Sidocno.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Sidocno read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Sidocno dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Sidocno)session.get(Sidocno.class, (Integer)key);
			
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
	
	
	public void createOrUpdate(Object dao, User user)
	throws ApplicationException {
		
		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);			
		}
		
		
		try {
			Sidocno _dao=(Sidocno)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getSidocnoId()) != null) {
				session.update(_dao);
				new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dao, user, "update");
			} else {
				Calendar c = Calendar.getInstance();
				_dao.setCreatedate(c.getTime());
				_dao.setCreatetime(com.bureaueye.beacon.util.Util.toTime(c));
				_dao.setCreateuserid(user.getUserid());
				session.save(_dao);
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
	
	
	public void delete(Object dao, User user) throws ApplicationException {
		
		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);			
		}
		
		try {
			Sidocno _dao=(Sidocno)dao;
			
			Transaction tx = session.beginTransaction();
			session.delete(_dao);
			tx.commit();		
			
			new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dao, user, "delete");
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
	public Sidocno findSidocnoByKey1(
			String doctype,
			String companykey,
			int businessyear
	) throws ApplicationException {
		
		Sidocno queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Sidocno)session
			.createCriteria(Sidocno.class)
			.add( Expression.eq("Doctype", doctype) )
			.add( Expression.eq("Companykey", companykey) )
			.add( Expression.eq("Businessyear", new Integer(businessyear)) )
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
	
	
	
	public List findSidocnosBySearch(
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
				"select sidocno"+
				" from com.bureaueye.beacon.model.salesinvoice.Sidocno sidocno"
				+ " where"			
				+ " Doctype LIKE '"+searchString1+"'"
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
	
	
	//sWSI-201311-0002
	//new get findSidocno to find sidocno records by company, department and/or activity	
	public Sidocno findSidocnoByKey2(
			String doctype,
			String companykey,
			String departmentkey,
			String activitykey,			
			int businessyear
	) throws ApplicationException {
		
		Sidocno queryResult = null;
		
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
				"select sidocno"+
				" from com.bureaueye.beacon.model.salesinvoice.Sidocno sidocno"
				+ " where"			
				+ " Doctype = '"+doctype+"' ";
			if (!companykey.equals("")) queryString = queryString + " AND companykey = '"+companykey+"' ";
			if (!departmentkey.equals("")) queryString = queryString + " AND departmentkey = '"+departmentkey+"' ";
			if (!activitykey.equals("")) queryString = queryString + " AND activitykey = '"+activitykey+"' ";
			if (businessyear!=0) queryString = queryString + " AND businessyear = "+businessyear+" ";
			
			queryResult = (Sidocno)session
			.createQuery(queryString)
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
	
	

	
	
	
	//-----------------------------------------------
	// BUSINESS METHODS
	//-----------------------------------------------
	public int getNextDocno(
			String doctype,
			String companykey,
			int businessyear,
			User user
	) throws ApplicationException {
		
		int nextdocno = 0;
		Sidocno sidocno = null;
		try {
			sidocno = findSidocnoByKey1(doctype, companykey, businessyear);
		} catch (ApplicationException ae) {	
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		//if no record found use zero year
		if (sidocno == null) {	
			try {
				sidocno = findSidocnoByKey1(doctype, companykey, 0);
			} catch (ApplicationException ae) {	
				throw new ApplicationException(ApplicationException.LIST_FAILED);			
			}			
		}
		if (sidocno != null) {
			// increment docno
			nextdocno = sidocno.getDocnocount().intValue()+1;
			sidocno.setDocnocount(new Integer(nextdocno));
			// update docno
			createOrUpdate(sidocno, user);
		}
		return nextdocno;
	}

	
	//sWSI-201311-0002	
	//get next docno to generate a docno with prefix, format and suffix stored
	//in the sidocno table instead of using the SystemResources.properties file
	//this allows us to set prefix, format and suffix per docno record and not only by system parameter
	public String getNextDocno2(
			String doctype,
			String companykey,
			String departmentkey,
			String activitykey,
			int businessyear,
			User user
	) throws ApplicationException {
		
		int nextDocnocount = 0;
		String nextDocno = "";		
		Sidocno sidocno = null;
		try {
			sidocno = findSidocnoByKey2(doctype, companykey, departmentkey, activitykey, businessyear);
		} catch (ApplicationException ae) {	
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		//if no record found use zero year
		if (sidocno == null) {	
			try {
				sidocno = findSidocnoByKey2(doctype, companykey, departmentkey, activitykey, 0);
			} catch (ApplicationException ae) {	
				throw new ApplicationException(ApplicationException.LIST_FAILED);			
			}			
		}
		
		if (sidocno != null) {
			// increment docno
			nextDocnocount = sidocno.getDocnocount().intValue()+1;
			sidocno.setDocnocount(new Integer(nextDocnocount));
			// update docno
			createOrUpdate(sidocno, user);
	
			//generate nextdocno String
			DecimalFormat df = new DecimalFormat(sidocno.getDocnoformat());
			nextDocno=sidocno.getDocnoprefix()+df.format(nextDocnocount)+sidocno.getDocnosuffix();
			log.info(
					"["+this.getClass().getName()+"] "+
					new java.util.Date()+" "+
					"nextDocnocount["+nextDocnocount+"]: "+
					"nextDocno["+nextDocno+"]: "+
					"doctype["+doctype+"]: "+					
					"company["+companykey+"]: "+
					"department["+departmentkey+"]: "+
					"activity["+activitykey+"]: "+
					"businessyear["+businessyear+"]: "+					
					"userid["+user.getUserid()+"]"
					);				
		}		
		
		
		return nextDocno;
		
	}
	
	
	
}


package com.bureaueye.beacon.model.standard.bd;



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
import com.bureaueye.beacon.model.standard.Docno;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;







/**
*
* Amendments
* ----------
*
* NT	2009-03-23		ITT-200904-0001		Add Quotno Auto Generation
* 											
*
*/
public final class DocnoBD extends BaseBD {
	
	
	// constructors
	public DocnoBD() {
	}
	public DocnoBD(SessionFactory _factory) {
		super(_factory);		
	}
	public DocnoBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Docno.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Docno read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Docno dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Docno)session.get(Docno.class, (Integer)key);
			
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
			Docno _dao=(Docno)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getDocnoId()) != null) {
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
			Docno _dao=(Docno)dao;
			
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
	public Docno findDocnoByKey1(
			String doctype,
			String companykey,
			int businessyear
	) throws ApplicationException {
		
		Docno queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Docno)session
			.createCriteria(Docno.class)
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
	
	
	public List findDocnosBySearch(
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
				"select docno"+
				" from com.bureaueye.beacon.model.standard.Docno docno"
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
		Docno docno = null;
		try {
			docno = findDocnoByKey1(doctype, companykey, businessyear);
		} catch (ApplicationException ae) {	
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		try {
			docno = findDocnoByKey1(doctype, companykey, businessyear);
		} catch (ApplicationException ae) {	
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}	
		//if no record found use zero year
		if (docno == null) {
			try {
				docno = findDocnoByKey1(doctype, companykey, 0);
			} catch (ApplicationException ae) {	
				throw new ApplicationException(ApplicationException.LIST_FAILED);			
			}				
		}
		if (docno != null) {
			// increment docno
			nextdocno = docno.getDocnocount().intValue()+1;
			docno.setDocnocount(new Integer(nextdocno));
			// update docno
			createOrUpdate(docno, user);
		}
		return nextdocno;
	}
	

	public int resetNextDocno(
			String doctype,
			String companykey,
			int businessyear,
			User user
	) throws ApplicationException {
		
		int nextdocno = 0;
		Docno docno = null;
		try {
			docno = findDocnoByKey1(doctype, companykey, businessyear);
		} catch (ApplicationException ae) {	
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}	
		if (docno != null) {
			// increment docno
			nextdocno = docno.getDocnocount().intValue()-1;
			docno.setDocnocount(new Integer(nextdocno));
			// update docno
			createOrUpdate(docno, user);
		}
		return nextdocno;
	}
	
	
}

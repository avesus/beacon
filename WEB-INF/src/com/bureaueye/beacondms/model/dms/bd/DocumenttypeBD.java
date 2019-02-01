package com.bureaueye.beacondms.model.dms.bd;


import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacondms.model.dms.Documenttype;

import com.bureaueye.beacon.model.standard.User;





public final class DocumenttypeBD extends BaseBD {
	
	
	// constructors
	public DocumenttypeBD() {
	}
	public DocumenttypeBD(SessionFactory _factory) {
		super(_factory);		
	}
	public DocumenttypeBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Documenttype.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Documenttype read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Documenttype dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {			
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
	
		try {				
			dao = (Documenttype)session.get(Documenttype.class, (Integer)key);		
		} catch (ObjectNotFoundException e) {
			// Any other error should result in a SystemException
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
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
			Documenttype _dto=(Documenttype)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getDocumenttypeId()) != null) {
				session.update(_dto);
				//new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dto, user, "update");
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
			Documenttype _dto=(Documenttype)dto;
			
			Transaction tx = session.beginTransaction();
			session.delete(_dto);
			tx.commit();		
			
			//new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dto, user, "delete");
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
	public Documenttype findDocumenttypeByDoctype(String id) 
	throws ApplicationException {
		
		List<Documenttype> daos = null;
		Documenttype queryResult = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {			
			
			daos = session.createCriteria(Documenttype.class)
						.add(Restrictions.eq("Doctype", id))
						.list();
			if (daos.size() >= 1) {
				queryResult = (Documenttype)daos.iterator().next();
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
		
		return queryResult;
	}
	
	
	public List<Documenttype> findDocumenttypesBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Documenttype> queryResult = null;
		
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
				"select documenttype"+
				" from com.bureaueye.beacondms.model.dms.Documenttype documenttype"
				+ " where"			
				+ " documenttype.Doctype LIKE '"+searchString1+"'"			
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
		

	public List<Documenttype> findDocumenttypes() throws ApplicationException {		
		
		List<Documenttype> queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.createQuery("from Documenttype documenttype order by documenttype.Doctype");
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
	
	
	public List<Documenttype> findDocumenttypesByCategorycode(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Documenttype> queryResult = null;
		
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
				"select documenttype"+
				" from com.bureaueye.beacondms.model.dms.Documenttype documenttype"
				+ " where"			
				+ " documenttype.Categorycode = '"+searchString1+"'"			
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

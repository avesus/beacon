package com.bureaueye.beacon.model.standard.bd;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Testtype;
import com.bureaueye.beacon.model.standard.User;


public final class TesttypeBD extends BaseBD {

	
	SessionFactory _factory;
	
	// constructors
	public TesttypeBD() {
	}
	public TesttypeBD(SessionFactory _factory) {
		this.setSessionFactory1(_factory);		
	}
	public TesttypeBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	

    private static final String DEFAULT_CLASS_NAME = Testtype.class.getName();

    
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Testtype read(Object key)
	throws ApplicationException {
		return null;
	}
	
	
	public void createOrUpdate(Object dto, User user)
	throws ApplicationException {
	}
	
	
	public void delete(Object dto, User user) throws ApplicationException {
	}
	
	
	
	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------		
	public List findTesttypes() throws ApplicationException {		
		
		List queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {

			Query q = session.createQuery("from Testtype testtype");

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
	

}

package com.bureaueye.beacon.model.standard.bd;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Fittyp;
import com.bureaueye.beacon.model.standard.User;


public final class FittypBD  extends BaseBD{

	
	SessionFactory _factory;
	
	// constructors
	public FittypBD() {
	}
	public FittypBD(SessionFactory _factory) {
		this.setSessionFactory1(_factory);		
	}
	public FittypBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	

    private static final String DEFAULT_CLASS_NAME = Fittyp.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Fittyp read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Fittyp dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Fittyp)session.get(Fittyp.class, (String)key);
			
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
	}
	
	
	public void delete(Object dto, User user) throws ApplicationException {
	}
	
	
	
	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------		
	public List findFittyps() throws ApplicationException {		
		
		List queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {

			Query q = session.createQuery("from Fittyp fittyp order by fittyp.Fitgrpkey, fittyp.Fittypkey");

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

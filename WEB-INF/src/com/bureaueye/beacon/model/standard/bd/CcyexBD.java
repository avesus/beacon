package com.bureaueye.beacon.model.standard.bd;


import java.util.Calendar;
import java.util.List;
import java.util.Map;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Ccyex;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;




public final class CcyexBD extends BaseBD {
	
	
	// constructors
	public CcyexBD() {
	}
	public CcyexBD(SessionFactory _factory) {
		super(_factory);		
	}
	public CcyexBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Ccyex.class.getName();

    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Ccyex read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Ccyex dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Ccyex)session.get(Ccyex.class, (Integer)key);
			
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
			Ccyex _dto=(Ccyex)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getCcyexId()) != null) {
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
			Ccyex _dto=(Ccyex)dto;
			
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
	public List findCcyexsBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;

		//			
		String searchString1=listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1="%";
		}	
		//			
		String searchString2=listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2="%";
		}	
		
		if (listForm.getOrderBy() == null || listForm.getOrderBy().equals("")) {
			return null;
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
				"select ccyex"+
				" from com.bureaueye.beacon.model.standard.Ccyex ccyex"
				+ " where"
				+ " ccyex.Fromccykey LIKE '"+searchString1+"'"				
				+ " and ccyex.Toccykey LIKE '"+searchString2+"'"
				+ " and ccyex.Exdate between '"+dateFormatter.format(listForm.getSearchDate1())+"'"
				+ " and '"+dateFormatter.format(listForm.getSearchDate2())+"'"				
				+ " order by "+listForm.getOrderBy();					
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
		

	public double getExrate(ListForm value) {
		
		/**/
		ListForm listForm = value;
		Ccyex ccyex = null;
	   	double exrate = 1;
		
		try {
			ccyex = findCcyexForExrate(listForm);
			if ( ccyex != null ) {
				//amount = amount.multiply(ccyex.getExrate());
           		exrate = ccyex.getExrate().doubleValue();          		
			}
			else {
				// swap ccy
				String searchString1 = listForm.getSearchString1();
				listForm.setSearchString1(listForm.getSearchString2());
				listForm.setSearchString2(searchString1);
				ccyex = findCcyexForExrate(listForm);
				if ( ccyex != null ) {
					//amount = amount * (1 / ccyex.getExrate());
           			exrate = 1 / ccyex.getExrate().doubleValue();           			
				}
			}
		}
		catch (ApplicationException ae) {  			
			return 1;
		}     

		return exrate;
	}
	
	

	public Ccyex findCcyexForExrate(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult=null;
		Ccyex dto = null;
		
		//			
		String searchString1 = listForm.getSearchString1();	
		String searchString2 = listForm.getSearchString2();		
		
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
				"select ccyex"+
				" from com.bureaueye.beacon.model.standard.Ccyex ccyex"
				+ " where"
				+ " ccyex.Fromccykey = '"+searchString1+"'"				
				+ " and ccyex.Toccykey = '"+searchString2+"'"
				+ " and ccyex.Exdate <= '"+dateFormatter.format(listForm.getSearchDate1())+"'"				
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		
			
			queryResult = session
							.createQuery(queryString)
							.list();			
			if (queryResult.size() > 0) dto = (Ccyex)queryResult.iterator().next();	
			
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
	
	
	
	
}

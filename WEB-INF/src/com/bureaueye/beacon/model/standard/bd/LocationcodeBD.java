package com.bureaueye.beacon.model.standard.bd;

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
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Locationcode;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dao.LocationcodeDAO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

public final class LocationcodeBD extends BaseBD {
	
	
	// constructors
	public LocationcodeBD() {
	}
	public LocationcodeBD(SessionFactory _factory) {
		super(_factory);		
	}
	public LocationcodeBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Locationcode.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Locationcode read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Locationcode dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Locationcode)session.get(Locationcode.class, (String)key);
			
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
			Locationcode _dto=(Locationcode)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getLocationcode()) != null) {
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
			Locationcode _dto=(Locationcode)dto;
			
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
	public List findLocationcodesByCountrykey(String key)
	throws ApplicationException {		
		
		List queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session
			.getNamedQuery(LocationcodeDAO.QUERY_FIND_LOCATIONCODES_BY_COUNTRYKEY);
			q.setParameter("key", key);			
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
	
	
	public List findLocationcodesSearch(String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14, int gotoPage,
			int maxResults, String order, String headerInfo1)
			throws ApplicationException {
		
		List queryResult = null;
		
		// 
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}

		// 
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}

		// 
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}

		if (order == null || order.equals("")) {
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
			
			queryResult = session
			.createCriteria(Locationcode.class)
			.add(Expression.like("Countrykey", searchString1))
			.add(Expression.like("Ldesc", searchString2))
			.add(Expression.like("Locationcode", searchString3))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
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


	public int findLocationcodesTotalResults(String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14, String headerInfo1)
			throws ApplicationException {
		
		int queryTotal=0;
		
		// 
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}

		// 
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}

		// 
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
						
			queryTotal= session
			.createCriteria(Locationcode.class)
			.add(Expression.like("Countrykey", searchString1))
			.add(Expression.like("Ldesc", searchString2))
			.add(Expression.like("Locationcode", searchString3))
			.list()
			.size();			
			
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
		
		return queryTotal;
	}
	

	
	
}

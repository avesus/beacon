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
import com.bureaueye.beacon.model.standard.Addresscontact;
import com.bureaueye.beacon.model.standard.AddresscontactPK;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dao.AddresscontactDAO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

public final class AddresscontactBD extends BaseBD {
	
	
	// constructors
	public AddresscontactBD() {
	}
	public AddresscontactBD(SessionFactory _factory) {
		super(_factory);		
	}
	public AddresscontactBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Addresscontact.class.getName();
    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Addresscontact read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Addresscontact dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Addresscontact)session.get(Addresscontact.class, (AddresscontactPK)key);
			
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
			Addresscontact _dto=(Addresscontact)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getId()) != null) {
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
			Addresscontact _dto=(Addresscontact)dto;
			
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
	public List findAddresscontactsByAddrkey(String addrkey, int gotoPage,
			int maxResults, String order) throws ApplicationException {
		
		List addresscontacts = null;
		
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
			
			
			addresscontacts = session.createCriteria(Addresscontact.class)
			.add(Expression.eq("id.Addrkey", addrkey))
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
		
		return addresscontacts;
	}
	
	public int findAddresscontactsTotalResults(String addrkey)
	throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {
			
			Query q = session.getNamedQuery(AddresscontactDAO.QUERY_FIND_ADDRESSCONTACTS_TOTAL_RESULTS);
			q.setParameter("addrkey", addrkey);
			
			queryTotal=((Long)q.uniqueResult()).intValue();
			
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
	
	
	
	public List findAddresscontactsSearch(String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14, int gotoPage,
			int maxResults, String order, String headerInfo1)
	throws ApplicationException {
		
		
		List queryResult=null;
		
		// Name
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		// Shortname
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}
		
		// Addr1
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		
		// Addr2
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		
		// Addr3
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		
		// Addr4
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}
		
		// Postalcode
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
		}
		
		// City
		if (searchString8 == null || searchString8.equals("")) {
			searchString8 = "%";
		}
		
		// State
		if (searchString9 == null || searchString9.equals("")) {
			searchString9 = "%";
		}
		
		// Country
		if (searchString10 == null || searchString10.equals("")) {
			searchString10 = "%";
		}
		
		// Telno1
		if (searchString11 == null || searchString11.equals("")) {
			searchString11 = "%";
		}
		
		// Faxno1
		if (searchString12 == null || searchString12.equals("")) {
			searchString12 = "%";
		}
		
		// Emailno
		if (searchString13 == null || searchString13.equals("")) {
			searchString13 = "%";
		}
		
		// Ccykey
		if (searchString14 == null || searchString14.equals("")) {
			searchString14 = "%";
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
			
			
			queryResult=session.createCriteria(Addresscontact.class)
			.add(Expression.like("Name", searchString1))
			.add(Expression.like("Email", searchString13))
			.addOrder(Order.asc(order)).setFirstResult(
					gotoPage * maxResults).setMaxResults(maxResults)
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
	
	
	
	public int findAddresscontactsSearchTotalResults(String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14, String headerInfo1)
	throws ApplicationException {
		
		int queryTotal=0;
		
		// Name
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		// Shortname
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}
		
		// Addr1
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		
		// Addr2
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		
		// Addr3
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		
		// Addr4
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}
		
		// Postalcode
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
		}
		
		// City
		if (searchString8 == null || searchString8.equals("")) {
			searchString8 = "%";
		}
		
		// State
		if (searchString9 == null || searchString9.equals("")) {
			searchString9 = "%";
		}
		
		// Country
		if (searchString10 == null || searchString10.equals("")) {
			searchString10 = "%";
		}
		
		// Telno1
		if (searchString11 == null || searchString11.equals("")) {
			searchString11 = "%";
		}
		
		// Faxno1
		if (searchString12 == null || searchString12.equals("")) {
			searchString12 = "%";
		}
		
		// Emailno
		if (searchString13 == null || searchString13.equals("")) {
			searchString13 = "%";
		}
		
		// Ccykey
		if (searchString14 == null || searchString14.equals("")) {
			searchString14 = "%";
		}
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {
			
			queryTotal=session.createCriteria(Addresscontact.class)
			.add(Expression.like("Name", searchString1))
			.add(Expression.like("Address1", searchString3))
			.add(Expression.like("Address2", searchString4))
			.add(Expression.like("Address3", searchString5))
			.add(Expression.like("PostalCode", searchString7))
			.add(Expression.like("City", searchString8))
			.add(Expression.like("State", searchString9))
			.add(Expression.like("Country", searchString10))
			.add(Expression.like("Phone", searchString11))
			.add(Expression.like("Fax", searchString12))
			.add(Expression.like("Email", searchString13))
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

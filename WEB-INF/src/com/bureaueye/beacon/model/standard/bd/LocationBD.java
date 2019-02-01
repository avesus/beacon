package com.bureaueye.beacon.model.standard.bd;


import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dto.LocationDTO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

public final class LocationBD extends BaseBD {
	
	
	// constructors
	public LocationBD() {
	}
	public LocationBD(SessionFactory _factory) {
		super(_factory);		
	}
	public LocationBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Location.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Location read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Location dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Location)session.get(Location.class, (String)key);
			
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
			Location _dto=(Location)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getLocationkey()) != null) {
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
			Location _dto=(Location)dto;
			
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
	public List findLocationsByType(String type, String order)
	throws ApplicationException {
		
		List queryResult = null;
		List<LocationDTO> queryResultDTO = new LinkedList<LocationDTO>();
		
		//if (type == null || type.equals("")) {
		//	type = "%";
		//}
		
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
			
			queryResult= session
			.createCriteria(Location.class)
//			.add(Expression.like("Typekey", type))
			.addOrder(Order.asc(order)).list();
			
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
		
		// iterate results to initialise DTO list 
		// change required to use Typekey List		
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Location _dao=(Location)it.next();
			LocationDTO _dto=new LocationDTO(_dao, this.getSessionFactoryClusterMap());
			if (type == null || type.equals("")) {
				queryResultDTO.add(_dto);				
			} else {
				if (_dto.getLocationTypelist().contains(type)) queryResultDTO.add(_dto);// include selected type
			}			
		}
		
		return queryResultDTO;
	}
	
	
	public List findLocationsByNameType(
			String searchString1,
			String searchString2, 
			int gotoPage, 
			int maxResults, 
			String order
			)
	throws ApplicationException {
		
		List queryResult = null;
		List<LocationDTO> queryResultDTO = new LinkedList<LocationDTO>();
		
		if (searchString1 == null) {
			searchString1 = "";
		}
		if (searchString2 == null) {
			searchString2 = "";
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
			.createCriteria(Location.class)
			.add(Expression.like("LocationName", searchString1))
			.addOrder(Order.asc(order))
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
		
		// iterate results to initialise DTO list 
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Location _dao=(Location)it.next();
			LocationDTO _dto=new LocationDTO(_dao, this.getSessionFactoryClusterMap()); 
			if (searchString2.equals("")) {
				queryResultDTO.add(_dto);				
			} else {
				if (_dto.getLocationTypelist().contains(searchString2)) queryResultDTO.add(_dto);// include selected type
			}
			
		}
		
		return queryResultDTO;
	}
	

	// find using passed list of LocationDTO objects
	public List findLocationlistByType(
			List list,
			String typelist,
			String order
			)
	throws ApplicationException {
		
		List<LocationDTO> queryResultDTO = new LinkedList<LocationDTO>();
		
		// change required to use Typekey List
		for (Iterator it = list.iterator(); it.hasNext();) {
			LocationDTO _dto=(LocationDTO)it.next();
			StringTokenizer st = new StringTokenizer(typelist, "|");			
			// many types selection with type list
			search:
			while (st.hasMoreTokens()) {
				if (_dto.getLocationTypelist().contains(st.nextToken())) {
					queryResultDTO.add(_dto);
					break search;// break from this loop and continue main
				}
			}
		}
		
		return queryResultDTO;
	}
	

	public List findLocationsAll(String order)
	throws ApplicationException {
		
		List queryResult = null;
		List<LocationDTO> queryResultDTO = new LinkedList<LocationDTO>();
		
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
			
			queryResult= session
			.createCriteria(Location.class)
			.addOrder(Order.asc(order)).list();
			
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
		
		// iterate results to initialise DTO list 
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Location _dao=(Location)it.next();
			LocationDTO _dto=new LocationDTO(_dao, this.getSessionFactoryClusterMap()); 
			queryResultDTO.add(_dto);
		}
		
		return queryResultDTO;
	}
	

	
	public List findLocationsForSearch(
			String searchString1,
			String searchString2, 
			String searchString3, 
			String searchString4,
			String searchString5, 
			String searchString6, 
			String searchString7,
			String searchString8, 
			String searchString9, 
			String searchString10,
			String searchString11, 
			String searchString12,
			String searchString13, 
			String searchString14,
			String g1codekey,
			String g2codekey,
			String g3codekey,
			String g4codekey,				
			String order, 
			String headerInfo1
			)
	throws ApplicationException {
		
		List queryResult=null;
		List<LocationDTO> queryResultDTO = new LinkedList<LocationDTO>();
		
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
		
		// Locationkey
		if (searchString14 == null || searchString14.equals("")) {
			searchString14 = "%";
		}

		
		// g-codes
		if (g1codekey == null || g1codekey.equals("")) {
			g1codekey = "%";
		}
		if (g2codekey == null || g2codekey.equals("")) {
			g2codekey = "%";
		}
		if (g3codekey == null || g3codekey.equals("")) {
			g3codekey = "%";
		}
		if (g4codekey == null || g4codekey.equals("")) {
			g4codekey = "%";
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
			
			queryResult= session
			.createCriteria(Location.class)
			.add(Expression.like("LocationName", searchString1))
			//.add(Expression.like("Shortname", searchString2))
			.add(Expression.like("Address1", searchString3))
			.add(Expression.like("Address2", searchString4))
			.add(Expression.like("Address3", searchString5))
			//.add(Expression.like("Addr4", searchString6))
			.add(Expression.like("PostalCode", searchString7))
			.add(Expression.like("City", searchString8))
			.add(Expression.like("State", searchString9))
			.add(Expression.like("Country", searchString10))
			.add(Expression.like("G1codekey", g1codekey))
			.add(Expression.like("G2codekey", g2codekey))
			.add(Expression.like("G3codekey", g3codekey))
			.add(Expression.like("G4codekey", g4codekey))			
			//.add(Expression.like("Phone", searchString11))
			//.add(Expression.like("Fax", searchString12))
			.addOrder(Order.asc(order)).list();
			
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

		// iterate results to initialise DTO list 
		// change required to use Typekey List
		for (Iterator it = queryResult.iterator(); it.hasNext();) {
			Location _dao=(Location)it.next();
			LocationDTO _dto=new LocationDTO(_dao, this.getSessionFactoryClusterMap()); 
			StringTokenizer st = new StringTokenizer(headerInfo1, "|");			
			// many types selection with type list
			search:
			while (st.hasMoreTokens()) {
				if (_dto.getLocationTypelist().contains(st.nextToken())) {
					queryResultDTO.add(_dto);
					break search;// break from this loop and continue main
				}
			}

		}
		
		return queryResultDTO;
		
	}

	

	
	
	
}

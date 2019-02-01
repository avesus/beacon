package com.bureaueye.beacon.model.dsactivity.bd;




import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;

import com.bureaueye.beacon.model.dsactivity.Dsingate;
import com.bureaueye.beacon.model.dsactivity.dto.DsingateDTO;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



/**
 */
public final class DsingateBD extends BaseBD {
	
	
	// constructors
	public DsingateBD() {
	}
	public DsingateBD(SessionFactory _factory) {
		super(_factory);		
	}
	public DsingateBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Dsingate.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Dsingate read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Dsingate dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Dsingate)session.get(Dsingate.class, (Integer)key);
			
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
			Dsingate _dao=(Dsingate)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getDsingateId()) != null) {
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
			Dsingate _dao=(Dsingate)dao;
			
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
	public List<DsingateDTO> findDsingatesForSearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Dsingate> queryResult = null;
		List<DsingateDTO> queryResultDTO = new LinkedList<DsingateDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
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
				"select dsingate"+
				" from Dsingate dsingate"
				+ " where "			
				+ "     dsingate.Depotlocationkey LIKE '"+listForm.getSearchString4()+"'"					
				+ " AND dsingate.Customeraddrkey LIKE '"+listForm.getSearchString3()+"'"
				+ " AND dsingate.Indate between '"+dateFormatter.format(listForm.getSearchDate1())+"' AND '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Dsingate _dao=(Dsingate)it.next();
				DsingateDTO _dto=new DsingateDTO(_dao, this.getSessionFactoryClusterMap()); 
				queryResultDTO.add(_dto);
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
		
		return queryResultDTO;
	}		
	

	public Dsingate findDsingateByEirinEirinver(String key1, Integer key2) 
	throws ApplicationException {
		
		Dsingate queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Dsingate)session
			.createCriteria(Dsingate.class)
			.add( Expression.eq("Eirin", key1) )
			.add( Expression.eq("Eirinver", key2) )
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
	

	public List findDsingatesForSearchByEirin(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<DsingateDTO> queryResultDTO = new LinkedList<DsingateDTO>();		
		
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
				"select dsingate"+
				" from Dsingate dsingate"
				+ " where"			
				+ " dsingate.Eirin = '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Dsingate _dao=(Dsingate)it.next();
				DsingateDTO _dto=new DsingateDTO(_dao, this.getSessionFactoryClusterMap()); 
				queryResultDTO.add(_dto);
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
		
		return queryResultDTO;
	}		
	
	
	
}

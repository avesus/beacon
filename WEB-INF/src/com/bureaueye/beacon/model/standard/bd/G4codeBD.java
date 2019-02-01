
package com.bureaueye.beacon.model.standard.bd;



import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.G4code;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;








/**
 *
 * Amendments
 * ----------
 * 											
 *
 */
public final class G4codeBD extends BaseBD {


	// constructors
	public G4codeBD() {
	}
	public G4codeBD(SessionFactory _factory) {
		super(_factory);		
	}
	public G4codeBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	


	private static final String DEFAULT_CLASS_NAME = G4code.class.getName();


	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public G4code read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		G4code dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {

			dao = (G4code)session.get(G4code.class, (Integer)key);

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
			G4code _dao=(G4code)dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getG4codeId()) != null) {
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
			G4code _dao=(G4code)dao;

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
	public List<G4code> findG4codes() throws ApplicationException {	
		
		List<G4code> queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.createQuery("from G4code g4code");
			
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
	
	
	public List<G4code> findG4codesBySearch(
			ListForm listForm						
	) throws ApplicationException {
		
		List<G4code> queryResult = null;
		
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}

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
			
			queryResult = session.createCriteria(G4code.class)
			.add(Restrictions.like("G1codekey", searchString1))
			.add(Restrictions.like("G2codekey", searchString2))	
			.add(Restrictions.like("G3codekey", searchString3))
			.add(Restrictions.like("G4codekey", searchString4))	
			.addOrder(Order.asc(listForm.getOrderBy()))
			.setMaxResults(listForm.getMaxResults())
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
	
	

	public G4code findG4codeByG1codekeyG2codekeyG3codekeyG4codekey(String key1, String key2, String key3, String key4) 
	throws ApplicationException
	{
		
		G4code queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (G4code)session
			.createCriteria(G4code.class)
			.add( Restrictions.eq("G1codekey", key1) )
			.add( Restrictions.eq("G2codekey", key2) )
			.add( Restrictions.eq("G3codekey", key3) )
			.add( Restrictions.eq("G4codekey", key4) )
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




}

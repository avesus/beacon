
package com.bureaueye.beacon.model.standard.bd;



import java.util.Calendar;
import java.util.Iterator;
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
import com.bureaueye.beacon.model.standard.G3code;
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
public final class G3codeBD extends BaseBD {


	// constructors
	public G3codeBD() {
	}
	public G3codeBD(SessionFactory _factory) {
		super(_factory);		
	}
	public G3codeBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	


	private static final String DEFAULT_CLASS_NAME = G3code.class.getName();


	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public G3code read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		G3code dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {

			dao = (G3code)session.get(G3code.class, (Integer)key);

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
			G3code _dao=(G3code)dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getG3codeId()) != null) {
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
			G3code _dao=(G3code)dao;

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


	public void deleteAll(Integer id, User user)
	throws ApplicationException {
		
		if (id == null) {return;}
		G3code dao = null;
		
		try {
			dao = read(id);
			if (dao != null) {
				List set = getG4codes(dao.getG3codekey());
				for (Iterator it = set.iterator(); it.hasNext();) {
					new G4codeBD().delete(it.next(), user);
				}
				delete(dao, user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}




	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------
	public List<G3code> findG3codes() throws ApplicationException {	
		
		List<G3code> queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.createQuery("from G3code g3code");
			
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
	
	
	public List<G3code> findG3codesBySearch(
			ListForm listForm						
	) throws ApplicationException {
		
		List<G3code> queryResult = null;
		
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
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		
		try {
			
			queryResult = session.createCriteria(G3code.class)
			.add(Restrictions.like("G1codekey", searchString1))
			.add(Restrictions.like("G2codekey", searchString2))	
			.add(Restrictions.like("G3codekey", searchString3))						
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
	
	

	public G3code findG3codeByG1codekeyG2codekeyG3codekey(String key1, String key2, String key3) 
	throws ApplicationException
	{
		
		G3code queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (G3code)session
			.createCriteria(G3code.class)
			.add( Restrictions.eq("G1codekey", key1) )
			.add( Restrictions.eq("G2codekey", key2) )
			.add( Restrictions.eq("G3codekey", key3) )
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
	

	
	
	public List<G4code> getG4codes(String key)
	throws ApplicationException {		
		
		List<G4code> queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session
			.createQuery(
			"from G4code g4code where g4code.G3codekey = :Key");
			q.setParameter("Key", key);
			
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
	
	

	
	
	
	//-----------------------------------------------
	// BUSINESS METHODS
	//-----------------------------------------------




}

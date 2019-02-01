package com.bureaueye.beacon.model.account.bd;




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
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.bd.BaseBD;


import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



/**
 */
public final class AioutBD extends BaseBD {


	// constructors
	public AioutBD() {
	}
	public AioutBD(SessionFactory _factory) {
		super(_factory);		
	}
	public AioutBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	


	private static final String DEFAULT_CLASS_NAME = Aiout.class.getName();


	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Aiout read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		Aiout dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {

			dao = (Aiout)session.get(Aiout.class, (Integer)key);

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
			Aiout _dao=(Aiout)dao;

			Transaction tx = session.beginTransaction();

			if (read(_dao.getAioutId()) != null) {
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
			Aiout _dao=(Aiout)dao;

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
	public Aiout findAIOutByDockey(String dockey) 
	throws ApplicationException {
		Aiout dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {
			dao = (Aiout)session.createCriteria(Aiout.class)
			.add( Expression.eq("Dockey", dockey) )
			.setMaxResults(1).uniqueResult();			
		} catch (HibernateException ae) {			
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}	

		// close Session 	
		try {
			session.close();
		}	
		catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		}


		return dao;
	}


	public List findAIOutsByCompanykeyDoctypeAIstatus(
			String companykey,
			String doctype,
			String aistatus
	)
	throws ApplicationException {

		List daos = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}


		try {

			daos = session
			.createCriteria(Aiout.class)	
			.add(Expression.eq("Companykey", companykey))
			.add(Expression.eq("Doctype", doctype))			
			.add(Expression.eq("Aistatus", aistatus))
			.addOrder(Order.asc("Createdate"))
			.addOrder(Order.asc("Createtime"))
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

		return daos;
	}


	public List findAIOutsBySearch(
			ListForm listForm	
	) throws ApplicationException {

		List daos = null;


		//			
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}

		//			
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}

		//			
		String searchString3 = listForm.getSearchString3();



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
				"select aiout"+
				" from com.bureaueye.beacon.model.account.Aiout aiout"
				+ " where"		
				+ "     aiout.Doctype LIKE '"+searchString1+"'"
				+ " and aiout.Dockey LIKE '"+searchString2+"'"			
				+ " and aiout.Createdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and aiout.Aistatus LIKE '"+listForm.getSearchString9()+"'";

			if (searchString3 != null && !searchString3.equals("")) {
				queryString=queryString+" and aiout.AibatchId = '"+searchString3+"'";
			}

			queryString=queryString+" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		

			daos = session
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

		return daos;
	}


	public List findAIOutsByAIstatusCreatedate(
			String status,
			java.util.Date fromdate,
			java.util.Date todate
	)
	throws ApplicationException {

		List daos = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}


		try {

			//_BaseRootDAO.initialize();
			daos =session
			.createCriteria(Aiout.class)
			.add(Expression.eq("Aistatus", status))
			.add(Expression.ge("Createdate", fromdate))
			.add(Expression.le("Createdate", todate))				
			.addOrder(Order.desc("AIOUT_ID"))
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

		return daos;
	}



}

package com.bureaueye.beacondms.model.dms.bd;


import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacondms.form.dms.ListTrackForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.Xdocumentversion;

import com.bureaueye.beacon.model.standard.User;




public final class XdocumentBD extends BaseBD {


	// constructors
	public XdocumentBD() {
	}
	public XdocumentBD(SessionFactory _factory) {
		super(_factory);		
	}
	public XdocumentBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	


	private static final String DEFAULT_CLASS_NAME = Xdocument.class.getName();


	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	@Override
	public Xdocument read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		Xdocument dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {			
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {				
			dao = (Xdocument)session.get(Xdocument.class, (Integer)key);		
		} catch (ObjectNotFoundException e) {
			// Any other error should result in a SystemException
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
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


	@Override
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
			Xdocument _dto=(Xdocument)dto;

			Transaction tx = session.beginTransaction();

			if (read(_dto.getXdocumentId()) != null) {
				session.update(_dto);
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


	@Override
	public void delete(Object dto, User user) throws ApplicationException {

		//		get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);			
		}

		try {
			Xdocument _dto=(Xdocument)dto;

			Transaction tx = session.beginTransaction();
			session.delete(_dto);
			tx.commit();		

			//new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dto, user, "delete");
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
		Xdocument dto = null;
		
		try {
			dto = read(id);
			if (dto != null) {				
				for (Iterator it = getXdocumentversions(dto.getDockey()).iterator(); it.hasNext();) {
					new XdocumentversionBD().delete((Xdocumentversion)it.next(), user);
				}				
				delete(dto,user);
			}
		} catch (ApplicationException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}
	

	



	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------
	public List findXdocumentsByDoctypeDocid(String type, String id)
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
			.createQuery(
					"from Xdocument xdocument where xdocument.Doctype = :type and xdocument.Docid = :id");
			q.setParameter("type", type);
			q.setParameter("id", id);

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


	public List findXdocumentsByDocid(ListForm listForm)
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

			String queryString = "";
			queryString = 
				"select xdocument"+
				" from com.bureaueye.beacondms.model.dms.Xdocument xdocument"
				+ " where"
				+ "     xdocument.Docid LIKE '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = 
				session.createQuery(queryString)
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


	public Xdocument findFirstXdocumentByDoctype(String doctype)
	throws ApplicationException {		

		Xdocument queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			queryResult = (Xdocument)session
			.createCriteria(Xdocument.class)
			.add( Expression.eq("Doctype", doctype) )
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


	public Xdocument findFirstXdocument()
	throws ApplicationException {		

		Xdocument queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			queryResult = (Xdocument)session
			.createCriteria(Xdocument.class)
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


	public List findXdocumentsWhereXmldocumentNotNull()
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
			.createQuery(
					"from Xdocument xdocument where xmldocument is not null");

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


	public List<Xdocument> findXdocumentsBySearch(
			ListTrackForm listForm	
	) throws ApplicationException {

		List<Xdocument> queryResult = null;

		//doc id			
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		//doc type	
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}		
		//category
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		//sub-category
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}		
		//company id
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}	
		//create user id			
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}	
		//description
		String searchString7 = listForm.getSearchString7();
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
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
				"select xdocument"+
				" from com.bureaueye.beacondms.model.dms.Xdocument xdocument"
				+ " where"
				+ "     xdocument.Docid LIKE '"+searchString1+"'"
				+ " and xdocument.Doctype LIKE '"+searchString2+"'"
				+ " and xdocument.Categorycode LIKE '"+searchString3+"'"
				+ " and xdocument.Subcategorycode LIKE '"+searchString4+"'"
				+ " and xdocument.Companykey LIKE '"+searchString5+"'"
				+ " and xdocument.Createuserid LIKE '"+searchString6+"'"
				+ " and xdocument.Description LIKE '"+searchString7+"'"
				+ " and xdocument.Createdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = 
				session.createQuery(queryString)
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


	public List<Xdocument> findXdocumentsByDocid(
			ListTrackForm listForm	
	) throws ApplicationException {

		List<Xdocument> queryResult = null;

		//doc id			
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "";
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
				"select xdocument"+
				" from com.bureaueye.beacondms.model.dms.Xdocument xdocument"
				+ " where"
				+ "     xdocument.Docid = '"+searchString1+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = 
				session.createQuery(queryString)
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


	public Xdocument findXdocumentByDockey(String key)
	throws ApplicationException {		

		Xdocument queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			queryResult = (Xdocument)session
			.createCriteria(Xdocument.class)
			.add( Expression.eq("Dockey", key) )
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


	public List getXdocumentversions(String key)
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
			.createQuery("from Xdocumentversion xdocumentversion where xdocumentversion.Dockey = :Dockey");
			q.setParameter("Dockey", key);			
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

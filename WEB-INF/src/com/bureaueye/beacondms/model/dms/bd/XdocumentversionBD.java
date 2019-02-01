package com.bureaueye.beacondms.model.dms.bd;



import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.Xdocumentversion;

import com.bureaueye.beacon.model.standard.User;




public final class XdocumentversionBD extends BaseBD {


	// constructors
	public XdocumentversionBD() {
	}
	public XdocumentversionBD(SessionFactory _factory) {
		super(_factory);		
	}
	public XdocumentversionBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	


	private static final String DEFAULT_CLASS_NAME = Xdocumentversion.class.getName();


	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Xdocumentversion read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		Xdocumentversion dao = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {			
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {				
			dao = (Xdocumentversion)session.get(Xdocumentversion.class, (Integer)key);		
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


	public void createOrUpdate(Object dto, User user)
	throws ApplicationException {
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
			Xdocumentversion _dto=(Xdocumentversion)dto;

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





	public Xdocumentversion createXdocumentversion(Object obj, User user, String action, String versiondescription)
	throws ApplicationException {

		
		Xdocumentversion version = new Xdocumentversion();	
		Xdocument xdocument=(Xdocument)obj;
		
		//init version no
		int versionno = 1;
		try {
			Xdocumentversion lastXdocumentversion=this.findLastXdocumentversionByDockey(xdocument.getDockey());
			versionno=lastXdocumentversion.getVersionno();
			versionno++;
		} catch (Exception e) {	
		}

		//init version description
		if (versionno==1) versiondescription="<Original Version>";
		
		
		Calendar c = Calendar.getInstance();
		version.setVersiondate(c.getTime());
		version.setVersiontime(com.bureaueye.beacon.util.Util.toTime(c));
		version.setVersionuserid(user.getUserid());			
		version.setVersionno(versionno);				
		version.setVersiondescription(versiondescription);	
		
		
		//check xdocument version process required
		String xdocumentversion = "no";
		try {
			PropertyResourceBundle props = 
				(PropertyResourceBundle) ResourceBundle.getBundle("com.bureaueye.beacon.SystemResources");
			xdocumentversion=props.getString ("xdocumentversion");
		} catch (Exception e) {}			
		if (xdocumentversion.equals("no")) return version;	
		
		
		
		//TODO: check new version required if current and new documents are different
		try {
					
		} catch (Exception e) {			
		}
		
	
		
		try {


			// get Session 
			Session session = null;
			try {
				session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
			} catch (HibernateException e) {
				throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);			
			}

			
			

			//init id
			version.setDockey(xdocument.getDockey());

			
			//init create variables
			version.setCreatedate(xdocument.getCreatedate());
			version.setCreatetime(xdocument.getCreatetime());
			version.setCreateuserid(xdocument.getCreateuserid());


			//init version variables
			version.setContenttype(xdocument.getContenttype());
			version.setFilebin(xdocument.getFilebin());
			version.setFilename(xdocument.getFilename());
			version.setFilesize(xdocument.getFilesize());				
			

			try {
				Transaction tx = session.beginTransaction();

				session.save(version);

				tx.commit();			
			} catch (HibernateException e) {	
				throw new ApplicationException(
						ApplicationException.ROW_NOT_CREATED_UPDATED);
			}



			// close Session 	
			try {
				session.close();
			}	
			catch (HibernateException e) {
				throw new ApplicationException(ApplicationException.ROW_NOT_CREATED_UPDATED);
			}


		} catch (HibernateException e) {
			throw new ApplicationException(
					ApplicationException.ROW_NOT_CREATED_UPDATED);
		}


		return version;

	}






	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------
	public List<Xdocumentversion> findXdocumentversionsByDockey(String key)
	throws ApplicationException {		

		List<Xdocumentversion> queryResult=null;

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
					"from Xdocumentversion xdocumentversion where xdocumentversion.Dockey = :key");
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


	public Xdocumentversion findLastXdocumentversionByDockey(String key)
	throws ApplicationException {		

		Xdocumentversion queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			queryResult = (Xdocumentversion)session
			.createCriteria(Xdocumentversion.class)
			.add( Expression.eq("Dockey", key) )
			.addOrder(Order.desc("XdocumentversionId"))			
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




}

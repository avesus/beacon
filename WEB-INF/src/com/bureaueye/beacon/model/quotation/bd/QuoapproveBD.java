package com.bureaueye.beacon.model.quotation.bd;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.quotation.Quoapprove;

import com.bureaueye.beacon.model.quotation.dao.QuoapproveDAO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;




/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-05		200900015		Add Quote Number to Workflow search criteria
 * 
 * NT	2009-09-02		200900032		Add Approve Flag to Workflow search criteria
 *
 * NT	2010-02-23		201000012		Add check to not allow creation of duplicate userid/usergroupid approval requests
 * 												
 */
public final class QuoapproveBD extends BaseBD {
	
	
	// constructors
	public QuoapproveBD() {
	}
	public QuoapproveBD(SessionFactory _factory) {
		super(_factory);		
	}
	public QuoapproveBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public QuoapproveBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Quoapprove.class.getName();	
    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Quoapprove read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Quoapprove dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Quoapprove)session.get(Quoapprove.class, (Integer)key);
			
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
			Quoapprove _dto=(Quoapprove)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getQuoapproveId()) != null) {
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
			Quoapprove _dto=(Quoapprove)dto;
			
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
	public List findQuoapprovesBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		DateFormatter dateFormatter = new DateFormatter();

		
		//s200900015
		// quote number
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		//e200900015
		
		
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
				"select new com.bureaueye.beacon.form.quotation.WorkflowLineItem(quoapprove, quohdr)"
				+ " from"
				+ " com.bureaueye.beacon.model.quotation.Quoapprove quoapprove,"				
				+ " com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"			
				+ " quoapprove.QuohdrId = quohdr.Id"		
				+ " and quoapprove.Userid LIKE '"+listForm.getSearchString1()+"'"
				+ " and quoapprove.Usergroupid LIKE '"+listForm.getSearchString2()+"'"
				+ " and quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and (quoapprove.Approvedate between '"+dateFormatter.format(listForm.getSearchDate3())+"' and '"+dateFormatter.format(listForm.getSearchDate4())+"'"
				+ "      or quoapprove.Approvedate is Null)"
				+ " and quohdr.Quotno LIKE '"+searchString3+"'"//200900015
				+ " and quoapprove.Approveflag = '"+listForm.getSearchString4()+"'"//200900032				
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
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
		
	
	public int findQuoapprovesTotalResults(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;

		
		//s200900015
		// quote number
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		//e200900015
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuoapproveDAO.QUERY_FIND_QUOAPPROVES_TOTAL_RESULTS);	
			q.setParameter("id1", listForm.getSearchString1());
			q.setParameter("id2", listForm.getSearchString2());			
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());			
			q.setParameter("date3", listForm.getSearchDate3());
			q.setParameter("date4", listForm.getSearchDate4());
			q.setParameter("id3", searchString3);
			q.setParameter("id4", listForm.getSearchString4());//200900032
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
	
	
	public int quoapprovesCountByCreatedateUserid(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuoapproveDAO.QUERY_QUOAPPROVES_COUNT_BY_CREATEDATE_USERID);
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id2", listForm.getSearchString2());	
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
		

	//201000012
	public Quoapprove findQuoapproveByUseridUsergroupid(
			String quohdrid,
			String userid, 
			String usergroupid
	)
	throws ApplicationException {
		
		Quoapprove queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Quoapprove)session
			.createCriteria(Quoapprove.class)
			.add(Expression.eq("QuohdrId", new Integer(quohdrid)))
			.add(Expression.eq("Userid", userid))
			.add(Expression.eq("Usergroupid", usergroupid))							
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
	


	
	public List findQuoapprovesForDashboard(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		DateFormatter dateFormatter = new DateFormatter();
			
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
				"select new com.bureaueye.beacon.form.quotation.WorkflowLineItem(quoapprove, quohdr)"
				+ " from"
				+ " com.bureaueye.beacon.model.quotation.Quoapprove quoapprove,"				
				+ " com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"			
				+ "     quoapprove.QuohdrId = quohdr.Id"		
				+ " and quoapprove.Approveflag = '"+listForm.getSearchString2()+"'"					
				+ " and quoapprove.Userid LIKE '"+listForm.getSearchString1()+"'"		
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
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
		

	
	
	
}

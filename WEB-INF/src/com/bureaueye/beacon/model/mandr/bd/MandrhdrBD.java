package com.bureaueye.beacon.model.mandr.bd;



import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
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

import com.bureaueye.beacon.model.mandr.Mandrdtl;
import com.bureaueye.beacon.model.mandr.Mandrhdr;
import com.bureaueye.beacon.model.mandr.dto.MandrhdrDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



/**
 */
public final class MandrhdrBD extends BaseBD {
	
	
	// constructors
	public MandrhdrBD() {
	}
	public MandrhdrBD(SessionFactory _factory) {
		super(_factory);		
	}
	public MandrhdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Mandrhdr.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Mandrhdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Mandrhdr dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Mandrhdr)session.get(Mandrhdr.class, (Integer)key);
			
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
			Mandrhdr _dao=(Mandrhdr)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getMandrhdrId()) != null) {
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
			Mandrhdr _dao=(Mandrhdr)dao;
			
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
		Mandrhdr dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {
				List set = getMandrdtls(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new MandrdtlBD().delete((Mandrdtl)it.next(), user);
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
	public Mandrhdr findMandrhdrByMandrno(String key) 
	throws ApplicationException {
		
		Mandrhdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Mandrhdr)session
			.createCriteria(Mandrhdr.class)
			.add( Expression.eq("Mandrno", key) )
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
	
	
	public List findMandrhdrsForSearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<MandrhdrDTO> queryResultDTO = new LinkedList<MandrhdrDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		String searchString2 = listForm.getSearchString2();
		//if (searchString2 == null || searchString2.equals("")) {
		//	searchString2 = "%";
		//}
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
		}
		String searchString7 = listForm.getSearchString7();
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
		}
		String searchString8 = listForm.getSearchString8();
		if (searchString8 == null || searchString8.equals("")) {
			searchString8 = "%";
		}		
		String searchString9 = listForm.getSearchString9();
		String searchString10 = listForm.getSearchString10();
		if (searchString10 == null || searchString10.equals("")) {
			searchString10 = "%";
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
				"select mandrhdr"+
				" from Mandrhdr mandrhdr"
				+ " where "			
				+ "     mandrhdr.Mandrno LIKE '"+searchString1+"'"				
				+ " and mandrhdr.Estimateref LIKE '"+searchString3+"'"
				+ " and mandrhdr.Unitkey LIKE '"+searchString4+"'"
				+ " and mandrhdr.Moveref LIKE '"+searchString5+"'"				
				+ " and mandrhdr.Originalestimatedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and mandrhdr.Companykey LIKE '"+searchString6+"'"
				+ " and mandrhdr.Departmentkey LIKE '"+searchString7+"'"
				+ " and mandrhdr.Activitykey LIKE '"+searchString8+"'"
				+ " and mandrhdr.Mandrstatus LIKE '"+searchString10+"'";
			
			if (searchString2.equals("CURRENT")) {
				queryString = queryString + " and mandrhdr.Lastversionflag = 'Y'";
			}
			queryString	= queryString+" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Mandrhdr _dao=(Mandrhdr)it.next();
				MandrhdrDTO _dto=new MandrhdrDTO(_dao, this.getSessionFactoryClusterMap());
				// check unit movement status
				if (searchString9 != null && !searchString9.equals("")) {
					if (!_dto.getUnit().getMovests().equals(searchString9)) {
						continue;
					}
				}
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
	
	
	public List getMandrdtls(Integer id)
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
			.createQuery("from Mandrdtl mandrdtl where mandrdtl.MandrhdrId = :MandrhdrId order by mandrdtl.MandrdtlId");
			q.setParameter("MandrhdrId", id);			
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
	

	
	public Mandrhdr findLastMandrhdrByMandrno(String mandrno) 
	throws ApplicationException {	
		
		Mandrhdr queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session
			.createQuery("from Mandrhdr mandrhdr where mandrhdr.Mandrno = :Mandrno order by mandrhdr.Mandrno, mandrhdr.Versionno desc");
			q.setParameter("Mandrno", mandrno);			
			queryResult=(Mandrhdr) (q.setMaxResults(1).uniqueResult());
			
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

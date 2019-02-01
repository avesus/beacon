/*
 * $Id: OnhireBD.java 2007-04-07 ntankard $ 
 */
package com.bureaueye.genesys.model.onhire.bd;

import java.util.Arrays;
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
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;
import com.bureaueye.genesys.model.onhire.Onhire;
import com.bureaueye.genesys.model.onhire.Onhireeqp;
import com.bureaueye.genesys.model.onhire.dao.OnhireDAO;
import com.bureaueye.genesys.model.onhire.dto.OnhireDTO;
import com.bureaueye.genesys.model.onhire.dto.UnitSearchDTO;





/**
 */
public final class OnhireBD extends BaseBD {
	
	
	// constructors
	public OnhireBD() {
	}
	public OnhireBD(SessionFactory _factory) {
		super(_factory);		
	}
	public OnhireBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public OnhireBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
	private static final String DEFAULT_CLASS_NAME = Onhire.class.getName();		
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Onhire read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Onhire dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Onhire)session.get(Onhire.class, (Integer)key);
			
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
			Onhire _dto=(Onhire)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getOnhireId()) != null) {
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
			Onhire _dto=(Onhire)dto;
			
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
	
	
	public void deleteAll(Integer id, User user)
	throws ApplicationException {
		
		if (id == null) {return;}
		Onhire dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {				
				for (Iterator it = getOnhireeqps(id).iterator(); it.hasNext();) {
					new OnhireeqpBD().delete((Onhireeqp)it.next(), user);
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
	public Onhire findOnhireByOnhireno(String key) 
	throws ApplicationException {
		
		Onhire queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Onhire)session.createCriteria(Onhire.class)
			.add( Expression.eq("Onhireno", key) )
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
	
	
	public List findOnhiresForSearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OnhireDTO> queryResultDTO = new LinkedList<OnhireDTO>();				
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
				"select onhire"+
				" from Onhire onhire"
				+ " where "			
				+ " onhire.Lesseeaddrkey LIKE '"+listForm.getSearchString3()+"'"
				+ " and onhire.Locationkey LIKE '"+listForm.getSearchString4()+"'"				
				+ " and onhire.Submitteddate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and onhire.Submittedby LIKE '"+listForm.getSearchString5()+"'"		
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Onhire _dao=(Onhire)it.next();
				OnhireDTO _dto=new OnhireDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findOnhiresForSearchByOnhireno(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OnhireDTO> queryResultDTO = new LinkedList<OnhireDTO>();				
		
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
				"select onhire "+
				" from Onhire onhire"
				+ " where"			
				+ " onhire.Onhireno = '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Onhire _dao=(Onhire)it.next();
				OnhireDTO _dto=new OnhireDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findOnhiresForSearchByContractno(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OnhireDTO> queryResultDTO = new LinkedList<OnhireDTO>();				
		
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
				"select onhire"+
				" from Onhire onhire"
				+ " where"			
				+ " onhire.Contractno = '"+listForm.getSearchString2()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Onhire _dao=(Onhire)it.next();
				OnhireDTO _dto=new OnhireDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public int findOnhiresTotalResults(
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
			
			Query q = session.getNamedQuery(OnhireDAO.QUERY_FIND_ONHIRES_TOTAL_RESULTS);	
			q.setParameter("id1", listForm.getSearchString3());	//lessee
			q.setParameter("id2", listForm.getSearchString4());	//location
			q.setParameter("date1", listForm.getSearchDate1());	//submitteddate from
			q.setParameter("date2", listForm.getSearchDate2());	//submitteddate to
			q.setParameter("id3", listForm.getSearchString5());	//submittedby					
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
	
	
	public int findOnhiresTotalResultsByOnhireno(
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
			
			Query q = session.getNamedQuery(OnhireDAO.QUERY_FIND_ONHIRES_TOTAL_RESULTS_BY_ONHIRENO);	
			q.setParameter("id1", listForm.getSearchString1());	//onhireno				
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
	
	
	public int findOnhiresTotalResultsByContractno(
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
			
			Query q = session.getNamedQuery(OnhireDAO.QUERY_FIND_ONHIRES_TOTAL_RESULTS_BY_CONTRACTNO);	
			q.setParameter("id1", listForm.getSearchString2());	//contractno				
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
	
	
	public List getOnhireeqps(Integer id)
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
			.createQuery("from Onhireeqp onhireeqp where onhireeqp.OnhireId = :OnhireId");
			q.setParameter("OnhireId", id);			
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
	
	
	
	
	
	//--------------------------------------------------
	// Unit Search for Onhire process in GENESYS System
	//--------------------------------------------------
	public List unitOnhireSearch(
			String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14,
			int gotoPage, 
			int maxResults, 
			String order,
			String headerInfo1,				//movests
			String headerInfo3,				//deleted
			String headerInfo4,				//Xinactive
			String headerInfo5				//oprsysblockalloc
	) throws ApplicationException {
		
		List queryResult = null;
		List<UnitSearchDTO> queryResultDTO = new LinkedList<UnitSearchDTO>();	
		
		//unitkey
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		//foodgrade
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "N";
		}
		
		
		// equipment parameters
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
		}
		if (searchString8 == null || searchString8.equals("")) {
			searchString8 = "%";
		}
		if (searchString9 == null || searchString9.equals("")) {
			searchString9 = "%";
		}
		if (searchString10 == null || searchString10.equals("")) {
			searchString10 = "%";
		}
		if (searchString11 == null || searchString11.equals("")) {
			searchString11 = "%";
		}
		
		
		if (order == null || order.equals("")) {
			order = "Unitkey";
		}
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Unit.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			queryResult = session
			.createCriteria(Unit.class)
			.add(Expression.in("Movests", Arrays.asList(headerInfo1.split(","))))
			//.add(Expression.sql("this.Deleted = '"+headerInfo3+"'"))
			//.add(Expression.sql("this.Xinactive = '"+headerInfo4+"'"))
			.add(Expression.sql("Oprsysblockalloc = '"+headerInfo5+"'"))
			//.add(Expression.sql("Foodgrad = '"+searchString6+"'"))
			.add(Expression.eq("Movelocationkey", searchString3))				
			.add(Expression.like("Unitkey", searchString1))		
			.add(Expression.like("Eqpkeyp1", searchString7))
			.add(Expression.like("Eqpkeyp2", searchString8))
			.add(Expression.like("Eqpkeyp3", searchString9))
			.add(Expression.like("Eqpkeyp4", searchString10))
			.add(Expression.like("Eqpkeyp5", searchString11))			
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();
		
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {					
				Unit _dao=(Unit)it.next();
				UnitSearchDTO _dto=new UnitSearchDTO(_dao, this.getSessionFactoryClusterMap()); 
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

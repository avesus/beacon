/*
 * $Id: FinancehdrBD.java 2007-04-20 ntankard $ 
 */
package com.bureaueye.genesys.model.finance.bd;



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

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.Financedtl;
import com.bureaueye.genesys.model.finance.bd.FinancedtlBD;
import com.bureaueye.genesys.model.finance.dao.FinancehdrDAO;
import com.bureaueye.genesys.model.finance.dto.FinancehdrDTO;




/**
 */
public final class FinancehdrBD extends BaseBD {
	
	
	// constructors
	public FinancehdrBD() {
	}
	public FinancehdrBD(SessionFactory _factory) {
		super(_factory);		
	}
	public FinancehdrBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public FinancehdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
	private static final String DEFAULT_CLASS_NAME = Financehdr.class.getName();		
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Financehdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Financehdr dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Financehdr)session.get(Financehdr.class, (Integer)key);
			
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
			Financehdr _dto=(Financehdr)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getFinancehdrId()) != null) {
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
			Financehdr _dto=(Financehdr)dto;
			
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
		Financehdr dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {				
				for (Iterator it = getFinancedtls(id).iterator(); it.hasNext();) {
					new FinancedtlBD().delete((Financedtl)it.next(), user);
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
	public Financehdr findFinancehdrByDockey(String key) 
	throws ApplicationException {
		
		Financehdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Financehdr)session.createCriteria(Financehdr.class)
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
	

	public Financehdr findLastFinancehdrByDocdate() 
	throws ApplicationException {	
		
		Financehdr queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session
			.createQuery("from Financehdr financehdr order by financehdr.Docdate desc");	
			queryResult=(Financehdr) (q.setMaxResults(1).uniqueResult());
			
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
	

	public List findFinancehdrsByDocdateNotManual(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<FinancehdrDTO> queryResultDTO = new LinkedList<FinancehdrDTO>();				
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
				"select financehdr"+
				" from Financehdr financehdr"
				+ " where"			
				+ "     financehdr.Docdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and financehdr.Manualflag = 'N'"				
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		
			queryResult = session.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Financehdr _dao=(Financehdr)it.next();
				FinancehdrDTO _dto=new FinancehdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List getFinancedtls(Integer id)
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
			.createQuery("from Financedtl financedtl where financedtl.FinancehdrId = :FinancehdrId");
			q.setParameter("FinancehdrId", id);			
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
	
	
	public List findFinancehdrsForSearchManual(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<FinancehdrDTO> queryResultDTO = new LinkedList<FinancehdrDTO>();		
		DateFormatter dateFormatter = new DateFormatter();
		
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
				"select financehdr"+
				" from Financehdr financehdr"
				+ " where "			
				+ " financehdr.Lesseeaddrkey LIKE '"+listForm.getSearchString3()+"'"
				+ " and financehdr.Createdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and financehdr.Companykey LIKE '"+searchString4+"'"
				+ " and financehdr.Departmentkey LIKE '"+searchString5+"'"
				+ " and financehdr.Activitykey LIKE '"+searchString6+"'"
				+ " and financehdr.Manualflag = 'Y'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			//.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Financehdr _dao=(Financehdr)it.next();
				FinancehdrDTO _dto=new FinancehdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findFinancehdrsForSearchByDockey(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<FinancehdrDTO> queryResultDTO = new LinkedList<FinancehdrDTO>();		
		
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
				"select financehdr"+
				" from Financehdr financehdr"
				+ " where"			
				+ " financehdr.Dockey = '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			//.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Financehdr _dao=(Financehdr)it.next();
				FinancehdrDTO _dto=new FinancehdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findFinancehdrsForSearchByFinancehdrId(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<FinancehdrDTO> queryResultDTO = new LinkedList<FinancehdrDTO>();		
		
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
				"select financehdr"+
				" from Financehdr financehdr"
				+ " where"			
				+ " financehdr.FinancehdrId = '"+listForm.getSearchString2()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			//.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Financehdr _dao=(Financehdr)it.next();
				FinancehdrDTO _dto=new FinancehdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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

package com.bureaueye.beacon.model.quotation.bd;

import java.math.BigDecimal;
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
import com.bureaueye.beacon.form.quotation.ListQuosummaryForm;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.dao.QuocostDAO;
import com.bureaueye.beacon.model.quotation.dto.QuocostDTO;
import com.bureaueye.beacon.model.quotation.dto.QuosummaryCostDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;


/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-08		ITT-200906-0002		Quotation List Report
 * 												
 *
 */
public final class QuocostBD extends BaseBD {
	
	
	// constructors
	public QuocostBD() {
	}
	public QuocostBD(SessionFactory _factory) {
		super(_factory);		
	}
	public QuocostBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public QuocostBD(
			SessionFactory _factory1, 
			SessionFactory _factory2,
			SessionFactory _factory3
			) {
		super(_factory1, _factory2, _factory3);		
	}	
	public QuocostBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Quocost.class.getName();
    
    
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Quocost read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Quocost dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Quocost)session.get(Quocost.class, (Integer)key);
			
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
			Quocost _dto=(Quocost)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getQuocostId()) != null) {
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
			Quocost _dto=(Quocost)dto;
			
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
	public List findQuocostsById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {
		
		List queryResult = null;
		List<QuocostDTO> queryResultDTO = new LinkedList<QuocostDTO>();
		
		if (order == null || order.equals("")) {
			return null;
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Quocost.class)
			.add(Expression.eq("QuohdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quocost _dao=(Quocost)it.next();
				QuocostDTO _dto=new QuocostDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public List findQuohdrcostsByQuohdrId(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {
		
		List queryResult = null;
		List<QuocostDTO> queryResultDTO = new LinkedList<QuocostDTO>();
		
		if (order == null || order.equals("")) {
			return null;
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Quocost.class)
			.add(Expression.eq("QuohdrId", new Integer(id)))
			.add(Expression.eq("QuomovId", new Integer(0)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quocost _dao=(Quocost)it.next();
				QuocostDTO _dto=new QuocostDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public int findQuocostsTotalResults(String id)
	throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuocostDAO.QUERY_FIND_QUOCOSTS_TOTAL_RESULTS);
			q.setParameter("id", new Integer(id));			
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
	

	public int findQuohdrcostsTotalResults(String id)
	throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuocostDAO.QUERY_FIND_QUOHDRCOSTS_TOTAL_RESULTS);
			q.setParameter("id", new Integer(id));
			q.setParameter("id2", new Integer(0));	
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
	

	public List findQuocostsForSummary(
			ListQuosummaryForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuosummaryCostDTO> queryResultDTO = new LinkedList<QuosummaryCostDTO>();
		
		if (listForm.getOrderBy() == null) {
			return null;
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
				"select quocost"
				+ " from"
				+ " com.bureaueye.beacon.model.quotation.Quocost quocost"			
				+ " where"
				+ " quocost.QuohdrId = "+listForm.getId()								
				+ " order by "+listForm.getOrderBy();
			queryResult = session
			.createQuery(queryString)
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quocost _dao=(Quocost)it.next();
				QuosummaryCostDTO _dto=new QuosummaryCostDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	
	
	
	//-----------------------------------------------
	// FIND MOVEMENT/COST METHODS
	//-----------------------------------------------	
	public List findQuomovcostsById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {
		
		List queryResult = null;
		List<QuocostDTO> queryResultDTO = new LinkedList<QuocostDTO>();
		
		if (order == null || order.equals("")) {
			return null;
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Quocost.class)
			.add(Expression.eq("QuomovId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();
	
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quocost _dao=(Quocost)it.next();
				QuocostDTO _dto=new QuocostDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public int findQuomovcostsTotalResults(String id)
	throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuocostDAO.QUERY_FIND_QUOMOVCOSTS_TOTAL_RESULTS);
			q.setParameter("id", new Integer(id));			
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
		
	
	public List findQuomovcostsForSummary(
			ListQuosummaryForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuosummaryCostDTO> queryResultDTO = new LinkedList<QuosummaryCostDTO>();
		
		if (listForm.getOrderBy() == null) {
			return null;
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
				"select quocost"
				+ " from"
				+ " com.bureaueye.beacon.model.quotation.Quocost quocost,"
				+ " com.bureaueye.beacon.model.quotation.Quomov quomov"				
				+ " where"
				+ " quomov.QuohdrId = "+listForm.getId()				
				+ " and quomov.QuomovId = quocost.QuomovId"					
				+ " order by "+listForm.getOrderBy();
			queryResult = session
			.createQuery(queryString)
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quocost _dao=(Quocost)it.next();
				QuosummaryCostDTO _dto=new QuosummaryCostDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findQuohdrcostsForSummary(
			ListQuosummaryForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuosummaryCostDTO> queryResultDTO = new LinkedList<QuosummaryCostDTO>();
		
		if (listForm.getOrderBy() == null) {
			return null;
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
				"select quocost"
				+ " from"
				+ " com.bureaueye.beacon.model.quotation.Quocost quocost"				
				+ " where"
				+ " quocost.QuohdrId = "+listForm.getId()				
				+ " and quocost.QuomovId = 0"					
				+ " order by "+listForm.getOrderBy();
			queryResult = session
			.createQuery(queryString)
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quocost _dao=(Quocost)it.next();
				QuosummaryCostDTO _dto=new QuosummaryCostDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

//	sITT-200906-0002
	public BigDecimal quocostsCstamtbaseTotal(String id)
	throws ApplicationException {
		
		BigDecimal queryTotal=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuocostDAO.QUERY_QUOCOSTS_CSTAMTBASE_TOTAL);
			q.setParameter("id1", new Integer(id));			
			queryTotal=((BigDecimal)q.uniqueResult());
			
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
//eITT-200906-0002
	
	
}

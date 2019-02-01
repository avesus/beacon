/*
 * $Id: FinancedtlDB.java 2007-04-20 ntankard $ 
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
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;
import com.bureaueye.genesys.model.finance.Financedtl;
import com.bureaueye.genesys.model.finance.dao.FinancedtlDAO;
import com.bureaueye.genesys.model.finance.dto.FinancedtlDTO;






/**
 */
public final class FinancedtlBD extends BaseBD {
	
	
	// constructors
	public FinancedtlBD() {
	}
	public FinancedtlBD(SessionFactory _factory) {
		super(_factory);		
	}	
	public FinancedtlBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}
	public FinancedtlBD(SessionFactory _factory1, SessionFactory _factory2, SessionFactory _factory3) {
		super(_factory1, _factory2, _factory3);		
	}	
	public FinancedtlBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
	private static final String DEFAULT_CLASS_NAME = Financedtl.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Financedtl read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Financedtl dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Financedtl)session.get(Financedtl.class, (Integer)key);
			
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
			Financedtl _dto=(Financedtl)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getFinancedtlId()) != null) {
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
			Financedtl _dto=(Financedtl)dto;
			
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
	public List findFinancedtlsById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order
	) throws ApplicationException {
		
		List queryResult = null;	
		List<FinancedtlDTO> queryResultDTO = new LinkedList<FinancedtlDTO>();
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			queryResult = session
			.createCriteria(Financedtl.class)
			.add(Expression.eq("FinancehdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Financedtl _dao=(Financedtl)it.next();
				FinancedtlDTO _dto=new FinancedtlDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public int findFinancedtlsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(FinancedtlDAO.QUERY_FIND_FINANCEDTLS_TOTAL_RESULTS);	
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
	
		
	public Object[] financedtlsAmountTotals(String id)
	throws ApplicationException {
		
		Object[] queryTotals=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(FinancedtlDAO.QUERY_FINANCEDTLS_AMOUNT_TOTALS);
			q.setParameter("id", new Integer(id));			

			for (Iterator it = q.iterate(); it.hasNext();) {
				queryTotals = (Object[]) it.next();
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
		
		return queryTotals;
	}
	

	public Object[] financedtlsAmountTotalsByUnitId(String doctype, String unitid)
	throws ApplicationException {
		
		Object[] queryTotals=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(FinancedtlDAO.QUERY_FINANCEDTLS_AMOUNT_TOTALS_BY_UNIT_ID);
			q.setParameter("id1", doctype);	
			q.setParameter("id2", new Integer(unitid));			

			for (Iterator it = q.iterate(); it.hasNext();) {
				queryTotals = (Object[]) it.next();
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
		
		return queryTotals;
	}
	

	public List findFinancedtlsByUnitId(
			String unitid
			) throws ApplicationException {
		
		List queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Financedtl.class)
			.add(Expression.eq("UnitId", new Integer(unitid)))
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

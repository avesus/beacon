package com.bureaueye.beacon.model.purchaseorder.bd;


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


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.purchaseorder.Podtlrcvd;
import com.bureaueye.beacon.model.purchaseorder.dao.PodtlrcvdDAO;
import com.bureaueye.beacon.model.purchaseorder.dto.PodtlrcvdDTO;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;







public final class PodtlrcvdBD extends BaseBD {
	
	
	// constructors
	public PodtlrcvdBD() {
	}
	public PodtlrcvdBD(SessionFactory _factory) {
		super(_factory);		
	}
	public PodtlrcvdBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Podtlrcvd.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Podtlrcvd read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Podtlrcvd dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Podtlrcvd)session.get(Podtlrcvd.class, (Integer)key);
			
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
			Podtlrcvd _dao=(Podtlrcvd)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getPodtlrcvdId()) != null) {
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
			Podtlrcvd _dao=(Podtlrcvd)dao;
			
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
	public List findPodtlrcvdsById(String id, int gotoPage, int maxResults, String order) 
	throws ApplicationException {
			
			List queryResult = null;
			List<PodtlrcvdDTO> queryResultDTO = new LinkedList<PodtlrcvdDTO>();		
			
			
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
						"select podtlrcvd"+
						" from Podtlrcvd podtlrcvd"
						+ " where"			
						+ " podtlrcvd.PodtlId = '"+id+"'"
						+ " order by "+order;			
				queryResult = session
				.createQuery(queryString)
				.setFirstResult(gotoPage * maxResults)
				.setMaxResults(maxResults)
				.list();
				
				// TODO: iterate results to set many-to-one mappings 
				for (Iterator it = queryResult.iterator(); it.hasNext();) {
					Podtlrcvd _dao=(Podtlrcvd)it.next();
					PodtlrcvdDTO _dto=new PodtlrcvdDTO(_dao, this.getSessionFactoryClusterMap()); 
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
		
	
	public int findPodtlrcvdsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(PodtlrcvdDAO.QUERY_FIND_PODTLRCVDS_TOTAL_RESULTS);			
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
	

	public int sumPodtlrcvdsByPodtlId(String id)
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
			
			Query q = session.getNamedQuery(PodtlrcvdDAO.QUERY_SUM_PODTLRCVDS_BY_PODTL_ID);			
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

	
	public List findPodtlrcvdsByPodtlId(Integer id)
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
			.createQuery("from Podtlrcvd podtlrcvd where podtlrcvd.PodtlId = :PodtlId");
			q.setParameter("PodtlId", id);			
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

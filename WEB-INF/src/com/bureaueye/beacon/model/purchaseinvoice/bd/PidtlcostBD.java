package com.bureaueye.beacon.model.purchaseinvoice.bd;


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
import com.bureaueye.beacon.model.bd.BaseBD;



import com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost;
import com.bureaueye.beacon.model.purchaseinvoice.dao.PidtlcostDAO;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlcostDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;







public final class PidtlcostBD extends BaseBD {
	
	
	// constructors
	public PidtlcostBD() {
	}
	public PidtlcostBD(SessionFactory _factory) {
		super(_factory);		
	}
	public PidtlcostBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Pidtlcost.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Pidtlcost read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Pidtlcost dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Pidtlcost)session.get(Pidtlcost.class, (Integer)key);
			
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
			Pidtlcost _dao=(Pidtlcost)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getPidtlcostId()) != null) {
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
			Pidtlcost _dao=(Pidtlcost)dao;
			
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
	public List<PidtlcostDTO> findPidtlcostsById(
			String id,
			int gotoPage, 
			int maxResults, 
			String order) 
	throws ApplicationException {
		

		List queryResult = null;
		List<PidtlcostDTO> queryResultDTO = new LinkedList<PidtlcostDTO>();				
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
			.createCriteria(Pidtlcost.class)
			.add(Expression.eq("PidtlId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setMaxResults(maxResults)
			.list();	
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Pidtlcost dao=(Pidtlcost)it.next();
				PidtlcostDTO dto=new PidtlcostDTO(dao, this.getSessionFactoryClusterMap()); 
				queryResultDTO.add(dto);
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


	public List findPidtlcostsByPidtlId(Integer id)
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
			.createQuery("from Pidtlcost pidtlcost where pidtlcost.PidtlId = :PidtlId");
			q.setParameter("PidtlId", id);			
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
	

	public List<Pidtlcost> findPidtlcostsByJobcostId(Integer id) 
	throws ApplicationException {
			
			List<Pidtlcost> queryResult = new LinkedList<Pidtlcost>();	
						
			// get Session 
			Session session = null;
			try {
				session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
			} catch (HibernateException e) {
				throw new ApplicationException(ApplicationException.LIST_FAILED);			
			}
			
			try {
				
				Query q = session
				.createQuery("from Pidtlcost pidtlcost where pidtlcost.JobcostId = :JobcostId");
				q.setParameter("JobcostId", id);			
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
		
	
	public BigDecimal pidtlcostsCstamtallocTotal(String id)
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
			
			Query q = session.getNamedQuery(PidtlcostDAO.QUERY_PIDTLCOSTS_CSTAMTALLOC_TOTAL);
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

	
	public BigDecimal pidtlcostsCstamtallocSumByVendorJobCostCcy(
			String vendor,
			Integer job,
			String cost,
			String ccy
			)
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

			Query q = session.getNamedQuery(PidtlcostDAO.QUERY_PIDTLCOSTS_CSTAMTALLOC_SUM_BY_VENDOR_JOB_COST_CCY);
			q.setParameter("id1", vendor);
			q.setParameter("id2", job);	
			q.setParameter("id3", cost);	
			q.setParameter("id4", ccy);	
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


	public BigDecimal pidtlcostsCstamtallocSumByJobcostid(
			Integer id
			)
	throws ApplicationException {

		BigDecimal queryTotal=new BigDecimal(0.0);

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			Query q = session.getNamedQuery(PidtlcostDAO.QUERY_PIDTLCOSTS_CSTAMTALLOC_SUM_BY_JOBCOSTID);
			q.setParameter("id", id);	
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

	
	public List findPidtlcostsByJobhdrIdForAccountspayable(		
			String id,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		
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

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlcostDTO("+
					"pidtlcost.Cstamtalloc,pidtlcost.Txt1,pidtlcost.Cstamttotal," +
					"pidtlcost.Costkey,pidtlcost.PidtlcostId,pidtlcost.PidtlId,"+
					"pihdr.Vendoraddrkey,pihdr.Ccykey,pihdr.Pino,pihdr.Vendorref,"+
					"pidtl.Jobno,orderhdr.Ccykey,orderhdr.Orderno" +
					") "+					
				" from " +
				"com.bureaueye.beacon.model.purchaseinvoice.Pihdr pihdr, " +
				"com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, " +
				"com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost pidtlcost, "+
				"com.bureaueye.beacon.model.standard.Address address, "+
				"com.bureaueye.beacon.model.job.Jobhdr jobhdr, "+					
				"com.bureaueye.beacon.model.order.Orderhdr orderhdr "+					
				" where "+ 
				"     pidtl.JobhdrId = "+id+
				" and pihdr.PihdrId = pidtl.PihdrId "+				
				" and pidtl.PidtlId = pidtlcost.PidtlId "+
				" and pihdr.Vendoraddrkey = address.Addrkey "+
				" and pidtl.JobhdrId = jobhdr.JobhdrId "+					
				" and jobhdr.OrderhdrId = orderhdr.Id "+					
				" order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
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
	
	
	public BigDecimal pidtlcostsCstamtallocSumByPihdrid(
			String id
			)
		throws ApplicationException {

		BigDecimal queryResult = null;

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
				"select sum(pidtlcost.Cstamtalloc) "+
				" from "+
				"com.bureaueye.beacon.model.purchaseinvoice.Pidtl pidtl, " +
				"com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost pidtlcost "+
				" where "+ 
				"     pidtl.PihdrId = "+id+				
				" and pidtl.PidtlId = pidtlcost.PidtlId ";				

			queryResult = (BigDecimal)session.createQuery(queryString).uniqueResult();

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

package com.bureaueye.beacon.model.job.bd;

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
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.dao.JobhdrDAO;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;
import com.bureaueye.beacon.model.standard.dto.UnitProducthistoryDTO;



public final class JobhdrBD extends BaseBD {
	
	
	// constructors
	public JobhdrBD() {
	}
	public JobhdrBD(SessionFactory _factory) {
		super(_factory);		
	}	
	public JobhdrBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}
	public JobhdrBD(SessionFactory _factory1, SessionFactory _factory2, SessionFactory _factory3) {
		super(_factory1, _factory2, _factory3);		
	}	
	public JobhdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
	private static final String DEFAULT_CLASS_NAME = Jobhdr.class.getName();		
	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Jobhdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Jobhdr dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Jobhdr)session.get(Jobhdr.class, (Integer)key);
			
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
			Jobhdr _dto=(Jobhdr)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getJobhdrId()) != null) {
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
			Jobhdr _dto=(Jobhdr)dto;
			
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
		Jobhdr dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {				
				for (Iterator it = getJobmovs(id).iterator(); it.hasNext();) {
					new JobmovBD().delete((Jobmov)it.next(), user);
				}
				for (Iterator it = getJobcosts(id).iterator(); it.hasNext();) {
					new JobcostBD().delete((Jobcost)it.next(), user);
				}				
				delete(dto, user);
			}
		} catch (ApplicationException e) {		
			throw new ApplicationException(ApplicationException.ROW_NOT_DELETED);
		}
	}
	
	
	
	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------
	public List<JobhdrDTO> findJobhdrsById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {
		
		List queryResult = null;
		List<JobhdrDTO> queryResultDTO = new LinkedList<JobhdrDTO>();	
		
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
			.createCriteria(Jobhdr.class)
			.add(Expression.eq("OrderhdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobhdr _dao=(Jobhdr)it.next();
				JobhdrDTO _dto=new JobhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public int findJobhdrsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(JobhdrDAO.QUERY_FIND_JOBHDRS_TOTAL_RESULTS);
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
	
	
	public List findJobhdrsByUnitId(ListForm listForm) throws ApplicationException {
		
		List queryResult = null;
		List<UnitProducthistoryDTO> queryResultDTO = new LinkedList<UnitProducthistoryDTO>();
		
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
				"select new com.bureaueye.beacon.model.standard.dto.UnitProducthistoryDTO(jobhdr, orderhdr)"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.order.Orderhdr orderhdr"+		
				" where"+					
				" jobhdr.OrderhdrId = orderhdr.Id and"+	
				" jobhdr.UnitId = '"+listForm.getId()+"'"+				
				" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.list();
			
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				UnitProducthistoryDTO _dto=(UnitProducthistoryDTO)it.next();
				_dto.setCustomer(
						new AddressBD(this.getSessionFactoryClusterMap()).read(_dto.getCustomeraddrkey())
				); 
				_dto.setProduct(
						new ProductBD(this.getSessionFactoryClusterMap()).read(_dto.getProductkey())
				);
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
		
		return queryResult;
	}	
	
	
	public List getJobmovs(Integer id)
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
			.createQuery("from Jobmov jobmov where jobmov.JobhdrId = :JobhdrId");
			q.setParameter("JobhdrId", id);			
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
	
	
	public List getJobcosts(Integer id)
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
			.createQuery("from Jobcost jobcost where jobcost.JobhdrId = :JobhdrId");
			q.setParameter("JobhdrId", id);			
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
	
	
	public Jobhdr findJobhdrByJobno(String jobno) 
	throws ApplicationException
	{
		
		Jobhdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Jobhdr)session
			.createCriteria(Jobhdr.class)
			.add( Expression.eq("Jobno", jobno) )
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
	

	public Jobhdr findFirstJobhdrByOrdhdrId(String ordhdrId) 
	throws ApplicationException {
		
		Jobhdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Jobhdr)session
			.createCriteria(Jobhdr.class)
			.add(Expression.eq("OrderhdrId", new Integer(ordhdrId)))
			.addOrder(Order.desc("Unitkey"))
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

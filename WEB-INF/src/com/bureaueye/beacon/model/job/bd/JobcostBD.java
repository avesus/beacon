package com.bureaueye.beacon.model.job.bd;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.bean.report.ReportRow;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.dao.JobcostDAO;
import com.bureaueye.beacon.model.job.dto.JobcostDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;





public final class JobcostBD extends BaseBD {


	// constructors
	public JobcostBD() {
	}
	public JobcostBD(SessionFactory _factory) {
		super(_factory);		
	}	
	public JobcostBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}
	public JobcostBD(SessionFactory _factory1, SessionFactory _factory2, SessionFactory _factory3) {
		super(_factory1, _factory2, _factory3);		
	}	
	public JobcostBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}


	private static final String DEFAULT_CLASS_NAME = Jobcost.class.getName();	



	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Jobcost read(Object key)
	throws ApplicationException {

		if (key == null) return null;

		Jobcost dto = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}


		try {

			dto = (Jobcost)session.get(Jobcost.class, (Integer)key);

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
			Jobcost _dto=(Jobcost)dto;

			Transaction tx = session.beginTransaction();

			if (read(_dto.getJobcostId()) != null) {
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
			Jobcost _dto=(Jobcost)dto;

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
	public List findJobcostsById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {

		List queryResult = null;
		List<JobcostDTO> queryResultDTO = new LinkedList<JobcostDTO>();

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
			.createCriteria(Jobcost.class)
			.add(Expression.eq("JobmovId", new Integer(id)))
			.addOrder(Order.asc(order))
			//.setFirstResult(gotoPage * maxResults)
			//.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost dao=(Jobcost)it.next();
				JobcostDTO dto=new JobcostDTO(dao, this.getSessionFactoryClusterMap()); 
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


	public int findJobcostsTotalResults(String id)
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

			Query q = session.getNamedQuery(JobcostDAO.QUERY_FIND_JOBCOSTS_TOTAL_RESULTS);
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


	public List findJobhdrcostsById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {

		List queryResult = null;
		List<JobcostDTO> queryResultDTO = new LinkedList<JobcostDTO>();

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
			.createCriteria(Jobcost.class)
			.add(Expression.eq("JobhdrId", new Integer(id)))
			.add(Expression.eq("JobmovId", new Integer(0)))
			.addOrder(Order.asc(order))
			//.setFirstResult(gotoPage * maxResults)
			//.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost _dao=(Jobcost)it.next();
				JobcostDTO _dto=new JobcostDTO(_dao, this.getSessionFactoryClusterMap()); 
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


	public int findJobhdrcostsTotalResults(String id)
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

			Query q = session.getNamedQuery(JobcostDAO.QUERY_FIND_JOBHDRCOSTS_TOTAL_RESULTS);
			q.setParameter("id1", new Integer(id));
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


	public List findJobcostsByJobhdrIdForSummary(		
			String jobhdrId,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		List<OrdersummaryJobcostDTO> queryResultDTO = new LinkedList<OrdersummaryJobcostDTO>();

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
				"select jobcost"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.job.Jobcost jobcost"
				+ " where jobhdr.JobhdrId = jobcost.JobhdrId"				
				+ " and jobhdr.JobhdrId = "+jobhdrId				
				+ " order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost _dao=(Jobcost)it.next();
				OrdersummaryJobcostDTO _dto=
					new OrdersummaryJobcostDTO(_dao, this.getSessionFactoryClusterMap());
				Jobhdr _jobhdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(_dao.getJobhdrId());
				_dto.setUnitkey(_jobhdr.getUnitkey());
				_dto.setMovref(_jobhdr.getMovref());
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


	public List findJobhdrcostsByJobhdrIdForSummary(		
			String jobhdrId,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		List<OrdersummaryJobcostDTO> queryResultDTO = new LinkedList<OrdersummaryJobcostDTO>();

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
				"select jobcost"+
				" from " +
				" com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				" com.bureaueye.beacon.model.job.Jobcost jobcost"
				+ " where " +
				" jobhdr.JobhdrId = jobcost.JobhdrId"				
				+ " and jobhdr.JobhdrId = "+jobhdrId
				+ " and jobcost.JobmovId = 0"
				+ " order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost dao=(Jobcost)it.next();
				OrdersummaryJobcostDTO dto=
					new OrdersummaryJobcostDTO(dao, this.getSessionFactoryClusterMap());
				Jobhdr jobhdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(dao.getJobhdrId());
				dto.setUnitkey(jobhdr.getUnitkey());
				dto.setMovref(jobhdr.getMovref());
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


	public List findJobmovcostsByJobhdrIdForSummary(		
			String jobhdrId,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		List<OrdersummaryJobcostDTO> queryResultDTO = new LinkedList<OrdersummaryJobcostDTO>();

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
				"select jobcost"+
				" from " +
				"com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"com.bureaueye.beacon.model.job.Jobmov jobmov, " +
				"com.bureaueye.beacon.model.job.Jobcost jobcost "+
				" where "+ 
				"     jobhdr.JobhdrId = "+jobhdrId+
				" and jobhdr.JobhdrId = jobmov.JobhdrId "+				
				" and jobmov.JobmovId = jobcost.JobmovId "+					
				" order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost dao=(Jobcost)it.next();
				OrdersummaryJobcostDTO dto=
					new OrdersummaryJobcostDTO(dao, this.getSessionFactoryClusterMap());
				Jobhdr _jobhdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(dao.getJobhdrId());
				dto.setUnitkey(_jobhdr.getUnitkey());
				dto.setMovref(_jobhdr.getMovref());
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


	/***removed beacause GROUP BY did not work for SQL SERVER!!!***
	public List findJobcostsByVendoraddrkeyCcykey(
			String id,
			String id2,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		List<OrdersummaryJobcostDTO> queryResultDTO = new LinkedList<OrdersummaryJobcostDTO>();

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
				"select jobcost"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.job.Jobcost jobcost"
				+ " where jobhdr.JobhdrId = jobcost.JobhdrId"				
				+ " and jobcost.Vendoraddrkey = '"+id+"'"
				+ " and jobcost.Ccykey = '"+id2+"'"				
				+ " group by "+order;
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(maxResults)
			.list();

			//init bd
			OrderhdrBD orderhdrbd= new OrderhdrBD(this.getSessionFactoryClusterMap());
			JobhdrBD jobhdrbd= new JobhdrBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost dao=(Jobcost)it.next();
				OrdersummaryJobcostDTO dto=
					new OrdersummaryJobcostDTO(dao, this.getSessionFactoryClusterMap());
				Jobhdr jobhdr = jobhdrbd.read(dao.getJobhdrId());
				dto.setUnitkey(jobhdr.getUnitkey());
				dto.setJobno(jobhdr.getJobno());
				dto.setMovref(jobhdr.getMovref());
				Orderhdr orderhdr = orderhdrbd.read(jobhdr.getOrderhdrId());
				//ONLY PROCESS NOT COMPLETED ORDERS
				if (!orderhdr.isCompleteflag()) {
					dto.setOrderno(orderhdr.getOrderno());
					queryResultDTO.add(dto);
				}
			}			
			//clear bd
			orderhdrbd=null;
			jobhdrbd=null;

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
	 ***/
	public List findJobcostsByVendoraddrkeyCcykey(
			String id,
			String id2,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		List<com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO> queryResultDTO = 
			new LinkedList<com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO>();

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
				"select " +
				" new com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO " +
				"   (jobhdr.JobhdrId) "+
				" from  com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"		com.bureaueye.beacon.model.job.Jobcost jobcost "+
				" where jobhdr.JobhdrId = jobcost.JobhdrId"+				
				" and jobcost.Vendoraddrkey = '"+id+"'"+
				" and jobcost.Ccykey = '"+id2+"'"+				
				" group by "+order;						
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(maxResults)
			.list();

			//init bd
			OrderhdrBD orderhdrbd= new OrderhdrBD(this.getSessionFactoryClusterMap());
			JobhdrBD jobhdrbd= new JobhdrBD(this.getSessionFactoryClusterMap());			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO dto=(com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO)it.next();
				Jobhdr jobhdr = jobhdrbd.read(dto.getJobhdrId());
				dto.setUnitkey(jobhdr.getUnitkey());
				dto.setJobno(jobhdr.getJobno());
				dto.setMovref(jobhdr.getMovref());
				dto.setOrderhdrId(jobhdr.getOrderhdrId());					
				Orderhdr orderhdr = orderhdrbd.read(dto.getOrderhdrId());
				//ONLY PROCESS NOT COMPLETED ORDERS
				if (!orderhdr.isCompleteflag()) {
					dto.setOrderno(orderhdr.getOrderno());
					queryResultDTO.add(dto);
				}
			}			
			//clear bd
			orderhdrbd=null;
			jobhdrbd=null;			

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


	public List findJobcostsByJobhdrIdVendoraddrkeyCcykey(
			ListForm listForm) throws ApplicationException {

		List queryResult = null;
		List<JobcostDTO> queryResultDTO = new LinkedList<JobcostDTO>();

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
				"select jobcost"+
				" from com.bureaueye.beacon.model.job.Jobcost jobcost"
				+ " where "	
				+ "     jobcost.JobhdrId = '"+listForm.getSearchString1()+"'"				
				+ " and jobcost.Vendoraddrkey = '"+listForm.getSearchString2()+"'"
				+ " and jobcost.Ccykey = '"+listForm.getSearchString3()+"'"				
				+ " order by "+listForm.getOrderBy();
			queryResult = session
			.createQuery(queryString)
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost dao=(Jobcost)it.next();
				JobcostDTO dto=
					new JobcostDTO(dao, this.getSessionFactoryClusterMap());
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


	public List jobcostsCstamtTotalByJobhdrIdVendoraddrkeyCcykey(
			ListForm listForm
	)
	throws ApplicationException {

		List queryResult = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			Query q = session.getNamedQuery(JobcostDAO.QUERY_JOBCOSTS_CSTAMT_TOTAL_BY_JOBHDR_ID_VENDORADDRKEY_CCYKEY);
			q.setParameter("id1", listForm.getSearchString1());
			q.setParameter("id2", listForm.getSearchString2());
			q.setParameter("id3", listForm.getSearchString3());
			queryResult = q.list();

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


	public BigDecimal jobcostsCstamtbaseTotal(String id)
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

			Query q = session.getNamedQuery(JobcostDAO.QUERY_JOBCOSTS_CSTAMTBASE_TOTAL);
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


	public List findJobmovcostsByJobhdrIdForDisbursement(		
			String jobhdrId,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {

		List queryResult = null;
		List<OrdersummaryJobcostDTO> queryResultDTO = new LinkedList<OrdersummaryJobcostDTO>();

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
				"select jobcost "+
				" from " +
				"com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"com.bureaueye.beacon.model.job.Jobmov jobmov, " +
				"com.bureaueye.beacon.model.job.Jobcost jobcost, "+
				"com.bureaueye.beacon.model.standard.Address address "+
				" where "+ 
				"     jobhdr.JobhdrId = "+jobhdrId+
				" and jobhdr.JobhdrId = jobmov.JobhdrId "+				
				" and jobmov.JobmovId = jobcost.JobmovId "+
				" and jobcost.Vendoraddrkey = address.Addrkey "+	
				" order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobcost dao=(Jobcost)it.next();
				OrdersummaryJobcostDTO dto=
					new OrdersummaryJobcostDTO(dao, this.getSessionFactoryClusterMap());
				Jobhdr jobhdr = new JobhdrBD(this.getSessionFactoryClusterMap()).read(dao.getJobhdrId());
				dto.setUnitkey(jobhdr.getUnitkey());
				dto.setMovref(jobhdr.getMovref());
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



	/***removed beacause GROUP BY did not work for SQL SERVER!!!***
public List<ReportRow> reportJobActualEstimate(
			ListForm listForm
	) throws ApplicationException {

		List queryResult = null;
		List<ReportRow> queryResultDTO = new LinkedList<ReportRow>();

		//init bd
		PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			//build query
			String queryString = "";			
			SQLQuery query = null;
			queryString = 
				"select {jobcost.*}, {jobhdr.*}, {orderhdr.*}, sum(jobcost.Cstamt) "+
				"from Jobcost jobcost " +
				"inner join Jobhdr jobhdr on jobcost.Jobhdr_Id = jobhdr.Jobhdr_Id " +
				"inner join Orderhdr orderhdr on jobhdr.Orderhdr_Id = orderhdr.Orderhdr_Id " +
				" where " +
				" orderhdr.Companykey = :company " +
				" AND " +
				" orderhdr.Orderdate between :fromdate and :todate ";

			// order no
			if (!listForm.getSearchString1().equals("")) {
				queryString=queryString+" AND orderhdr.Orderno = '"+listForm.getSearchString1()+"' ";
			}
			// job no
			if (!listForm.getSearchString14().equals("")) {
				queryString=queryString+" AND jobhdr.Jobno = '"+listForm.getSearchString14()+"' ";
			}
			// vendor
			if (!listForm.getSearchString2().equals("")) {
				queryString=queryString+" AND jobcost.Vendoraddrkey = '"+listForm.getSearchString2()+"' ";
			}
			// cost
			if (!listForm.getSearchString4().equals("")) {
				queryString=queryString+" AND jobcost.Costkey= '"+listForm.getSearchString4()+"' ";
			}

			queryString=queryString+
				"group by jobcost.Vendoraddrkey, jobhdr.Jobhdr_Id, jobcost.Costkey, jobcost.Ccykey"
				;


			//generate query
			query = session.createSQLQuery(queryString);
			query.addEntity("jobcost", Jobcost.class);			
			query.addEntity("jobhdr", Jobhdr.class);
			query.addEntity("orderhdr", Orderhdr.class);
			query.setString("company", listForm.getSearchString19());					
			query.setDate("fromdate", listForm.getSearchDate1());
			query.setDate("todate", listForm.getSearchDate2());					
			query.setMaxResults(listForm.getMaxResults());

			//execute query
			queryResult=query.list();



			// iterate results 			
			Iterator it = queryResult.iterator();
			while ( it.hasNext() ) {
				Object[] obj = (Object[]) it.next();
				Jobcost jobcost = (Jobcost) obj[0];
				Jobhdr jobhdr = (Jobhdr) obj[1];
				Orderhdr orderhdr = (Orderhdr) obj[2];

				//retrieve estimate sum total
				BigDecimal estimateAmount = new BigDecimal(0);
				try {
					estimateAmount=	jobcostsCstamtSumByVendorJobCostCcy(
						jobcost.getVendoraddrkey(),
						jobhdr.getJobhdrId(),
						jobcost.getCostkey(),
						jobcost.getCcykey()
						);
				} catch (Exception e) {
				}
				if (estimateAmount==null) estimateAmount=new BigDecimal(0);
				//retrieve actual sum total
				BigDecimal actualAmount =  new BigDecimal(0);
				try {
					actualAmount =  pidtlcostbd.pidtlcostsCstamtallocSumByVendorJobCostCcy(
						jobcost.getVendoraddrkey(),
						jobhdr.getJobhdrId(),
						jobcost.getCostkey(),
						jobcost.getCcykey()
						);
				} catch (Exception e) {
				}					
				if (actualAmount==null) actualAmount=new BigDecimal(0);

				BigDecimal difAmount =  new BigDecimal(0);
				difAmount=estimateAmount.subtract(actualAmount);

				//retrieve vendor name
				String vendorName="";
				try {
					Address addressdao = addressbd.read(jobcost.getVendoraddrkey());
					vendorName=addressdao.getName();
				} catch (Exception e) {
				}

				//generate report row
				ReportRow dto = new ReportRow();
				dto.setCell1(vendorName);
				dto.setCell2(jobhdr.getJobno());
				dto.setCell3(orderhdr.getOrderno());
				dto.setCell4(jobcost.getCostkey());
				dto.setCell5(jobcost.getCcykey());
				dto.setCell31(orderhdr.getOrderdate());				
				dto.setCell41(estimateAmount);
				dto.setCell42(actualAmount);
				dto.setCell43(difAmount);

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

		//clear bd
		pidtlcostbd=null;
		addressbd=null;

		return queryResultDTO;
	}
	 ***/
	public List<ReportRow> reportJobActualEstimate(
			ListForm listForm
	) throws ApplicationException {

		List queryResult = null;
		List<ReportRow> queryResultDTO = new LinkedList<ReportRow>();
		DateFormatter dateFormatter = new DateFormatter();


		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			//build query
			String queryString = "";			
			SQLQuery query = null;
			queryString = 
				"select  "+
				" new com.bureaueye.beacon.model.job.dto.JobcostCstamtSumDTO " +
				"   (jobcost.Vendoraddrkey, jobhdr.JobhdrId, jobcost.Costkey, jobcost.Ccykey, sum(jobcost.Cstamt)) "+				
				" from " +
				"com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"com.bureaueye.beacon.model.order.Orderhdr orderhdr, " +
				"com.bureaueye.beacon.model.job.Jobcost jobcost "+
				" where "+ 
				"     jobhdr.JobhdrId = jobcost.JobhdrId "+
				" AND orderhdr.Id = jobhdr.OrderhdrId "+				
				" AND "+
				" orderhdr.Companykey = '" +listForm.getSearchString19()+"' "+
				" AND " +
				" orderhdr.Orderdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"					
				;

			// order no
			if (!listForm.getSearchString1().equals("")) {
				queryString=queryString+" AND orderhdr.Orderno = '"+listForm.getSearchString1()+"' ";
			}
			// job no
			if (!listForm.getSearchString14().equals("")) {
				queryString=queryString+" AND jobhdr.Jobno = '"+listForm.getSearchString14()+"' ";
			}
			// vendor
			if (!listForm.getSearchString2().equals("")) {
				queryString=queryString+" AND jobcost.Vendoraddrkey = '"+listForm.getSearchString2()+"' ";
			}
			// cost
			if (!listForm.getSearchString4().equals("")) {
				queryString=queryString+" AND jobcost.Costkey= '"+listForm.getSearchString4()+"' ";
			}

			queryString=queryString+
			"group by jobcost.Vendoraddrkey, jobhdr.JobhdrId, jobcost.Costkey, jobcost.Ccykey"
			;


			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();



			//init bd
			PidtlcostBD pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());
			AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
			JobhdrBD jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
			OrderhdrBD orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());

			// iterate results 			
			Iterator it = queryResult.iterator();
			while ( it.hasNext() ) {
				com.bureaueye.beacon.model.job.dto.JobcostCstamtSumDTO obj = 
					(com.bureaueye.beacon.model.job.dto.JobcostCstamtSumDTO) it.next();

				//retrieve estimate sum total
				BigDecimal estimateAmount = new BigDecimal(0);
				try {
					estimateAmount=	jobcostsCstamtSumByVendorJobCostCcy(
							obj.getVendoraddrkey(),
							obj.getJobhdrId(),
							obj.getCostkey(),
							obj.getCcykey()
					);
				} catch (Exception e) {					
				}
				if (estimateAmount==null) estimateAmount=new BigDecimal(0);
				//retrieve actual sum total
				BigDecimal actualAmount =  new BigDecimal(0);
				try {
					actualAmount =  pidtlcostbd.pidtlcostsCstamtallocSumByVendorJobCostCcy(
							obj.getVendoraddrkey(),
							obj.getJobhdrId(),
							obj.getCostkey(),
							obj.getCcykey()
					);
				} catch (Exception e) {
				}					
				if (actualAmount==null) actualAmount=new BigDecimal(0);

				BigDecimal difAmount =  new BigDecimal(0);
				difAmount=estimateAmount.subtract(actualAmount);

				//retrieve vendor name
				String vendorName="";
				try {
					Address addressdao = addressbd.read(obj.getVendoraddrkey());
					vendorName=addressdao.getName();
				} catch (Exception e) {
				}

				//retrieve job header
				Jobhdr jobhdrdao = null;
				try {
					System.out.println("jobhdrbd.read JobhdrId-"+obj.getJobhdrId());
					jobhdrdao=	jobhdrbd.read(obj.getJobhdrId());
				} catch (Exception e) {
				}

				//retrieve order header
				Orderhdr orderhdrdao = null;
				try {
					orderhdrdao=	orderhdrbd.read(jobhdrdao.getOrderhdrId());
				} catch (Exception e) {
				}

				try {
					//generate report row
					ReportRow dto = new ReportRow();
					dto.setCell1(vendorName);
					dto.setCell2(jobhdrdao.getJobno());
					dto.setCell3(orderhdrdao.getOrderno());
					dto.setCell4(obj.getCostkey());
					dto.setCell5(obj.getCcykey());
					dto.setCell31(orderhdrdao.getOrderdate());				
					dto.setCell41(estimateAmount);
					dto.setCell42(actualAmount);
					dto.setCell43(difAmount);

					queryResultDTO.add(dto);
				} catch (Exception e) {	
				}
			}


			//clear bd
			pidtlcostbd=null;
			addressbd=null;
			orderhdrbd=null;
			jobhdrbd=null;

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


	public BigDecimal jobcostsCstamtSumByVendorJobCostCcy(
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

			Query q = session.getNamedQuery(JobcostDAO.QUERY_JOBCOSTS_CSTAMT_SUM_BY_VENDOR_JOB_COST_CCY);
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


	public Jobcost findJobcostByCostlinkkey(String linkkey) 
	throws ApplicationException {

		Jobcost queryResult = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			queryResult = (Jobcost)session
			.createCriteria(Jobcost.class)
			.add(Expression.eq("OqlinkKey", new Integer(linkkey)))
			.addOrder(Order.desc("Costkey"))
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

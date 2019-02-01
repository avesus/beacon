package com.bureaueye.beacon.model.order.bd;

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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;

import com.bureaueye.beacon.model.order.Ordercharge;
import com.bureaueye.beacon.model.order.dao.OrderchargeDAO;
import com.bureaueye.beacon.model.order.dto.OrderchargeDTO;
import com.bureaueye.beacon.model.order.dto.OrderhdrchargeDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryChargeDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;




public final class OrderchargeBD extends BaseBD {
	
	
	// constructors
	public OrderchargeBD() {
	}
	public OrderchargeBD(SessionFactory _factory) {
		super(_factory);		
	}
	public OrderchargeBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public OrderchargeBD(
			SessionFactory _factory1, 
			SessionFactory _factory2,
			SessionFactory _factory3) {
		super(_factory1, _factory2, _factory3);		
	}
	public OrderchargeBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Ordercharge.class.getName();	
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Ordercharge read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Ordercharge dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Ordercharge)session.get(Ordercharge.class, (Integer)key);
			
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
			Ordercharge _dto=(Ordercharge)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getOrderchargeId()) != null) {
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
			Ordercharge _dto=(Ordercharge)dto;
			
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
	public List<OrderchargeDTO> findOrderchargesById(String id, int gotoPage,
			int maxResults, String order) throws ApplicationException {
		
		List queryResult = null;
		List<OrderchargeDTO> queryResultDTO = new LinkedList<OrderchargeDTO>();
		
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
			.createCriteria(Ordercharge.class)
			.add(Expression.eq("OrderhdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Ordercharge _dao=(Ordercharge)it.next();
				OrderchargeDTO _dto=new OrderchargeDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findOrderchargesBySihdrId(Integer id) throws ApplicationException {
		
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
			.createCriteria(Ordercharge.class)
			.add(Expression.eq("SihdrId", new Integer(id)))
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
	
	
	public int findOrderchargesTotalResults(String id) throws ApplicationException {
		
		int queryTotal=0;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(OrderchargeDAO.QUERY_FIND_ORDERCHARGES_TOTAL_RESULTS);
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
	
	
	public List findOrderchargesByOrderhdrIdForSummary(			
			String orderhdrId,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {
		
		List queryResult = null;
		List<OrdersummaryChargeDTO> queryResultDTO = new LinkedList<OrdersummaryChargeDTO>();
		
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
				"select ordercharge"+
				" from com.bureaueye.beacon.model.order.Ordercharge ordercharge"
				+ " where "				
				+ " ordercharge.OrderhdrId = "+orderhdrId				
				+ " order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Ordercharge _dao=(Ordercharge)it.next();
				OrdersummaryChargeDTO _dto=new OrdersummaryChargeDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List findOrderchargesByInvoicestatus(		
			ListForm listForm
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrchargeDTO> queryResultDTO = new LinkedList<OrderhdrchargeDTO>();
		DateFormatter dateFormatter = new DateFormatter();
		
		String searchString2 = listForm.getSearchString2();
		
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		
		// order no
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
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
				"Select new com.bureaueye.beacon.model.order.dto.OrderhdrchargeDTO(orderhdr, ordercharge)"
				+ " from com.bureaueye.beacon.model.order.Orderhdr orderhdr,"
				+ "      com.bureaueye.beacon.model.order.Ordercharge ordercharge"
				+ " where orderhdr.Id = ordercharge.OrderhdrId"		
				+ " and orderhdr.Companykey = '"+searchString2+"'"				
				+ " and ordercharge.Invoicestatus LIKE '"+listForm.getSearchString1()+"'"
				+ " and ordercharge.Customeraddrkey LIKE '"+listForm.getSearchString6()+"'"				
				+ " and orderhdr.Orderno LIKE '"+searchString5+"'"				
				+ " and orderhdr.Departmentkey LIKE '"+searchString3+"'"
				+ " and orderhdr.Activitykey LIKE '"+searchString4+"'"				
				+ " and orderhdr.Orderdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			ChargeBD _chargeBD = new ChargeBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				OrderhdrchargeDTO _dto=(OrderhdrchargeDTO)it.next();
				_dto.setCustomer(
						_addressBD.read(_dto.getCustomeraddrkey())
						);
				_dto.setCharge(
						_chargeBD.read(_dto.getChargekey())
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
	
	
	public List<Ordercharge> findOrderchargesByOrderhdrIdInvoicestatus(
			String orderhdrId, String invoicestatus
	) throws ApplicationException {
		
		List<Ordercharge> queryResult = null;
		
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
				"Select ordercharge"
				+ " from com.bureaueye.beacon.model.order.Ordercharge ordercharge"
				+ " where "
				+ "     ordercharge.OrderhdrId = "+orderhdrId
				+ " and ordercharge.Invoicestatus = '"+invoicestatus+"'";						
			queryResult = session.createQuery(queryString).list();					
			
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
	

	public int orderchargesCountByInvoicestatusOrderdateOrderbyuserid(
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
			
			Query q = session.getNamedQuery(OrderchargeDAO.QUERY_ORDERCHARGES_COUNT_BY_INVOICESTATUS_ORDERDATE_ORDERBYUSERID);
			q.setParameter("id1", listForm.getSearchString1());
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
		

	public BigDecimal orderchargesChgamtbaseTotal(String id)
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
			
			Query q = session.getNamedQuery(OrderchargeDAO.QUERY_ORDERCHARGES_CHGAMTBASE_TOTAL);
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
	

	
	public List findOrderchargesForDashboard(		
			ListForm listForm
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrchargeDTO> queryResultDTO = new LinkedList<OrderhdrchargeDTO>();
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
				"Select new com.bureaueye.beacon.model.order.dto.OrderhdrchargeDTO(orderhdr, ordercharge)"
				+ " from com.bureaueye.beacon.model.order.Orderhdr orderhdr,"
				+ "      com.bureaueye.beacon.model.order.Ordercharge ordercharge"
				+ " where orderhdr.Id = ordercharge.OrderhdrId"
				+ " and ordercharge.Invoicestatus = '"+listForm.getSearchString2()+"'"				
				+ " and orderhdr.Orderbyuserid LIKE '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			ChargeBD _chargeBD = new ChargeBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				OrderhdrchargeDTO _dto=(OrderhdrchargeDTO)it.next();
				_dto.setCustomer(
						_addressBD.read(_dto.getCustomeraddrkey())
						);
				_dto.setCharge(
						_chargeBD.read(_dto.getChargekey())
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
	

	
	
	
}

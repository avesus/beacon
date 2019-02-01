/*
 * $Id: OrderhdrBD.java  2007-12-03 ntankard $ 
 */
package com.bureaueye.beacon.model.order.bd;

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
import com.bureaueye.beacon.model.order.Ordercost;
import com.bureaueye.beacon.model.order.Orderfile;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Ordermov;
import com.bureaueye.beacon.model.order.Ordernote;
import com.bureaueye.beacon.model.order.Ordernotecust;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.dao.OrderhdrDAO;
import com.bureaueye.beacon.model.order.dto.OrderchargeDTO;
import com.bureaueye.beacon.model.order.dto.OrderhdrDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;




/**
 */
public final class OrderhdrBD  extends BaseBD {
	
	
	// constructors
	public OrderhdrBD() {
	}
	public OrderhdrBD(SessionFactory _factory) {
		super(_factory);		
	}
	public OrderhdrBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public OrderhdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Orderhdr.class.getName();		
    
    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Orderhdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Orderhdr dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Orderhdr)session.get(Orderhdr.class, (Integer)key);
			
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
			Orderhdr _dto=(Orderhdr)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getId()) != null) {
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
			Orderhdr _dto=(Orderhdr)dto;
			
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
	
	
	@SuppressWarnings("rawtypes")
	public void deleteAll(Integer id, User user)
	throws ApplicationException {
		
		if (id == null) {return;}
		Orderhdr dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {				
				for (Iterator it = getOrdermovs(id).iterator(); it.hasNext();) {
					new OrdermovBD().delete((Ordermov)it.next(), user);
				}
				for (Iterator it = getOrdercostsAll(id).iterator(); it.hasNext();) {
					new OrdercostBD().delete((Ordercost)it.next(), user);
				}
				for (Iterator it = getOrdernotecusts(id).iterator(); it.hasNext();) {
					new OrdernotecustBD().delete((Ordernotecust)it.next(), user);
				}				
				for (Iterator it = getOrdernotes(id).iterator(); it.hasNext();) {
					new OrdernoteBD().delete((Ordernote)it.next(), user);
				}	
				for (Iterator it = getOrdercharges(id).iterator(); it.hasNext();) {
					new OrderchargeBD().delete((Ordercharge)it.next(), user);
				}	
				for (Iterator it = getOrderprods(id).iterator(); it.hasNext();) {
					new OrderprodBD().delete((Orderprod)it.next(), user);
				}	
				for (Iterator it = getOrderfiles(id).iterator(); it.hasNext();) {
					new OrderfileBD().delete((Orderfile)it.next(), user);
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
	@SuppressWarnings("rawtypes")
	public List findOrderhdrsByOrderno(String orderno, String order)
	throws ApplicationException {
		
		List queryResult = null;
		
		if (orderno == null || orderno.equals("")) {
			orderno = "%";
		}	
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
			.createCriteria(Orderhdr.class)
			.add(Expression.like("Orderno", orderno))
			.addOrder(Order.asc(order))
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
	
	
	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrDTO> queryResultDTO = new LinkedList<OrderhdrDTO>();				
		DateFormatter dateFormatter = new DateFormatter();
		
		// 
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where"	
				+ "     orderhdr.Companykey = '"+listForm.getSearchString19()+"'"
				+ " and orderhdr.Orderdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"							
				+ " AND orderhdr.Orderno LIKE '"+searchString1+"'"
				+ " and orderhdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and orderhdr.Ldglocationkey1 LIKE '"+listForm.getSearchString10()+"'"
				+ " and orderhdr.Ldglocationkey2 LIKE '"+listForm.getSearchString11()+"'"
				+ " and orderhdr.Dchlocationkey2 LIKE '"+listForm.getSearchString12()+"'"
				+ " and orderhdr.Dchlocationkey1 LIKE '"+listForm.getSearchString13()+"'"
				+ " and orderhdr.Invoicestatus LIKE '"+listForm.getSearchString3()+"'"
				+ " and orderhdr.Completeflag LIKE '"+listForm.getSearchString30()+"'"					
				;
							
			
			//loading g-codes
			if (!listForm.getSearchString20().equals("")) queryString=queryString+" AND orderhdr.Ldgg1key2 = '"+listForm.getSearchString20()+"'";
			if (!listForm.getSearchString21().equals("")) queryString=queryString+" AND orderhdr.Ldgg2key2 = '"+listForm.getSearchString21()+"'";
			if (!listForm.getSearchString22().equals("")) queryString=queryString+" AND orderhdr.Ldgg3key2 = '"+listForm.getSearchString22()+"'";
			if (!listForm.getSearchString23().equals("")) queryString=queryString+" AND orderhdr.Ldgg4key2 = '"+listForm.getSearchString23()+"'";
			
			//discharge g-codes
			if (!listForm.getSearchString24().equals("")) queryString=queryString+" AND orderhdr.Dchg1key2 = '"+listForm.getSearchString24()+"'";
			if (!listForm.getSearchString25().equals("")) queryString=queryString+" AND orderhdr.Dchg2key2 = '"+listForm.getSearchString25()+"'";
			if (!listForm.getSearchString26().equals("")) queryString=queryString+" AND orderhdr.Dchg3key2 = '"+listForm.getSearchString26()+"'";
			if (!listForm.getSearchString27().equals("")) queryString=queryString+" AND orderhdr.Dchg4key2 = '"+listForm.getSearchString27()+"'";

			//ship vendor
			if (!listForm.getSearchString28().equals("")) queryString=queryString+" AND orderhdr.Shipvendoraddrkey = '"+listForm.getSearchString28()+"'";
			//ship vessel
			if (!listForm.getSearchString29().equals("")) queryString=queryString+" AND orderhdr.Shipvessel = '"+listForm.getSearchString29()+"'";


			
			queryString=queryString+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}
			
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao=(Orderhdr)it.next();
				OrderhdrDTO _dto=new OrderhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearchForSummaryReport(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrDTO> queryResultDTO = new LinkedList<OrderhdrDTO>();				
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where"	
				+ "     orderhdr.Companykey = '"+listForm.getSearchString19()+"'"
				+ " AND orderhdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and orderhdr.Orderdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"					
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao=(Orderhdr)it.next();
				OrderhdrDTO _dto=new OrderhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearchForCashSettlementReport(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;			
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where"	
				+ "     orderhdr.Companykey = '"+listForm.getSearchString7()+"'"
				+ " AND orderhdr.Ldgfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'";

			//ordernumber - from / to
			if (!listForm.getSearchString5().equals("")) queryString=queryString+" AND orderhdr.Orderno LIKE '"+listForm.getSearchString5()+"'";
			
			//customer number / reference
			if (!listForm.getSearchString2().equals("")) queryString=queryString+" AND orderhdr.Customeraddrkey = '"+listForm.getSearchString2()+"'";
			if (!listForm.getSearchString4().equals("")) queryString=queryString+" AND orderhdr.Customerref = '"+listForm.getSearchString4()+"'";

			//department / activity
			if (!listForm.getSearchString8().equals("")) queryString=queryString+" AND orderhdr.Departmentkey = '"+listForm.getSearchString8()+"'";
			if (!listForm.getSearchString9().equals("")) queryString=queryString+" AND orderhdr.Activitykey = '"+listForm.getSearchString9()+"'";
			
			//loading g-codes
			if (!listForm.getSearchString20().equals("")) queryString=queryString+" AND orderhdr.Ldgg1key2 = '"+listForm.getSearchString20()+"'";
			if (!listForm.getSearchString21().equals("")) queryString=queryString+" AND orderhdr.Ldgg2key2 = '"+listForm.getSearchString21()+"'";
			if (!listForm.getSearchString22().equals("")) queryString=queryString+" AND orderhdr.Ldgg3key2 = '"+listForm.getSearchString22()+"'";
			if (!listForm.getSearchString23().equals("")) queryString=queryString+" AND orderhdr.Ldgg3key2 = '"+listForm.getSearchString23()+"'";
			
			//discharge g-codes
			if (!listForm.getSearchString24().equals("")) queryString=queryString+" AND orderhdr.Dchg1key2 = '"+listForm.getSearchString24()+"'";
			if (!listForm.getSearchString25().equals("")) queryString=queryString+" AND orderhdr.Dchg2key2 = '"+listForm.getSearchString25()+"'";
			if (!listForm.getSearchString26().equals("")) queryString=queryString+" AND orderhdr.Dchg3key2 = '"+listForm.getSearchString26()+"'";
			if (!listForm.getSearchString27().equals("")) queryString=queryString+" AND orderhdr.Dchg4key2 = '"+listForm.getSearchString27()+"'";		
			
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
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
	

	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearchByOrderno(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrDTO> queryResultDTO = new LinkedList<OrderhdrDTO>();	

	
		
		
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where"			
				+ " orderhdr.Orderno = '"+listForm.getSearchString1()+"'";
			
			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();		
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}
			
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao=(Orderhdr)it.next();
				OrderhdrDTO _dto=new OrderhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	@SuppressWarnings("rawtypes")
	public List findOrderhdrsBySearchByConsignmentno(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrDTO> queryResultDTO = new LinkedList<OrderhdrDTO>();	

		
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where"			
				+ " orderhdr.Consignmentno = '"+listForm.getSearchString14()+"'";
			
			queryString = queryString + " order by " + listForm.getOrderBy()
					+ " " + listForm.getOrderByDesc();		
			
			// 201400026
			if (!listForm.getOrderBy2().equals("")) {
				queryString=queryString+ ", "+ listForm.getOrderBy2() + " " + listForm.getOrderBy2Desc();
			}
			
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao=(Orderhdr)it.next();
				OrderhdrDTO _dto=new OrderhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public Orderhdr findOrderhdrByOrderno(String orderno) 
	throws ApplicationException
	{
		
		Orderhdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Orderhdr)session
			.createCriteria(Orderhdr.class)
			.add( Expression.eq("Orderno", orderno) )
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
	
	
	public int findOrderhdrsTotalResults(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
		//  no
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(OrderhdrDAO.QUERY_FIND_ORDERHDRS_TOTAL_RESULTS);
			q.setParameter("id1", searchString1);
			q.setParameter("id2", listForm.getSearchString2());
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id3", listForm.getSearchString9());
			q.setParameter("id4", listForm.getSearchString10());	
			q.setParameter("id5", listForm.getSearchString11());	
			q.setParameter("id6", listForm.getSearchString12());	
			q.setParameter("id7", listForm.getSearchString13());				
			q.setParameter("id8", listForm.getSearchString3());			
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
	
	
	public int findOrderhdrsTotalResultsByOrderno(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
		//  no
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(OrderhdrDAO.QUERY_FIND_ORDERHDRS_TOTAL_RESULTS_BY_ORDERNO);
			q.setParameter("id1", searchString1);
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
	
	
	@SuppressWarnings("rawtypes")
	public List findOrderhdrsByOrderCustomerDate(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrDTO> queryResultDTO = new LinkedList<OrderhdrDTO>();				
		DateFormatter dateFormatter = new DateFormatter();
		
//		no
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where "			
				+ "     orderhdr.Orderno LIKE '"+searchString1+"'"
				+ " and orderhdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and orderhdr.Orderdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"			
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao=(Orderhdr)it.next();
				OrderhdrDTO _dto=new OrderhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	@SuppressWarnings("rawtypes")
	public List findOrderhdrsByQuotno(
			String quotno	
	) throws ApplicationException {
		
		List queryResult = null;
		List<OrderhdrDTO> queryResultDTO = new LinkedList<OrderhdrDTO>();		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Orderhdr.class)
			.add(Expression.eq("Quotno", quotno))
			.list();

			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Orderhdr _dao=(Orderhdr)it.next();
				OrderhdrDTO _dto=new OrderhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	@SuppressWarnings("rawtypes")
	public List getOrdermovs(Integer id)
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
			.createQuery("from Ordermov ordermov where ordermov.OrderhdrId = :OrderhdrId order by estfromdate, esttodate");
			q.setParameter("OrderhdrId", id);			
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
	
	
	@SuppressWarnings("rawtypes")
	public List getOrdercosts(Integer id)
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
			.createQuery("from Ordercost ordercost where ordercost.OrderhdrId = :OrderhdrId and ordercost.OrdermovId = 0");
			q.setParameter("OrderhdrId", id);			
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
	

	@SuppressWarnings("rawtypes")
	public List getOrdercostsAll(Integer id)
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
			.createQuery("from Ordercost ordercost where ordercost.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	

	@SuppressWarnings("rawtypes")
	public List getOrdercharges(Integer id)
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
			.createQuery("from Ordercharge ordercharge where ordercharge.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	
	
	@SuppressWarnings("rawtypes")
	public List getOrderprods(Integer id)
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
			.createQuery("from Orderprod orderprod where orderprod.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	
	
	@SuppressWarnings("rawtypes")
	public List getOrdernotes(Integer id)
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
			.createQuery("from Ordernote ordernote where ordernote.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	

	@SuppressWarnings("rawtypes")
	public List getOrdernotecusts(Integer id)
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
			.createQuery("from Ordernotecust ordernotecust where ordernotecust.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	

	@SuppressWarnings("rawtypes")
	public List getOrderfiles(Integer id)
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
			.createQuery("from Orderfile orderfile where orderfile.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	
	
	@SuppressWarnings("rawtypes")
	public List getJobhdrs(Integer id)
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
			.createQuery("from Jobhdr jobhdr where jobhdr.OrderhdrId = :OrderhdrId");
			q.setParameter("OrderhdrId", id);			
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
	
	
	@SuppressWarnings("rawtypes")
	public List findOrderhdrsByKey1(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		DateFormatter dateFormatter = new DateFormatter();
		
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "";
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
				"select orderhdr "+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where "			
				+ " orderhdr.Systemloguserid = '"+searchString1+"' and"
				+ " orderhdr.Orderdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"			
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
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
	

	public int orderhdrsCountByInvoicestatusOrderdateOrderbyuserid(
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
			
			Query q = session.getNamedQuery(OrderhdrDAO.QUERY_ORDERHDRS_COUNT_BY_INVOICESTATUS_ORDERDATE_ORDERBYUSERID);
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
		

	public String getOrderhdrInvoicestatus(
			String orderhdrId
	) throws ApplicationException {
		
		String invoicestatus = com.bureaueye.beacon.bean.Constants.NOT_INVOICED_STATUS;
		List<Ordercharge> query1 = null;
		List<OrderchargeDTO> query2 = null;		
		
		try {
			OrderchargeBD orderchargebd = new OrderchargeBD(this.getSessionFactoryClusterMap());
			
			//retrieve printed charges for order
			query1=orderchargebd.findOrderchargesByOrderhdrIdInvoicestatus(orderhdrId,com.bureaueye.beacon.bean.Constants.PRINTED_STATUS);
			
			//retrieve all charges for order
			query2=orderchargebd.findOrderchargesById(
												orderhdrId, 
												0,
												com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT, 
												"Chargekey"
												);

			if (query1!=null && query2!=null) {
				if (query1.size()>=1) invoicestatus = com.bureaueye.beacon.bean.Constants.PART_INVOICED_STATUS;
				if (query1.size()==query2.size()) invoicestatus = com.bureaueye.beacon.bean.Constants.FULLY_INVOICED_STATUS;
			}
			
		} catch (HibernateException e) {		
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		} 
		
		
		return invoicestatus;
	}
	
	
	public int getOrderjobscount(
			String id						
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
			
			Query q = session.createQuery("select count(*) from Jobhdr jobhdr where jobhdr.OrderhdrId = :id1");
			q.setParameter("id1", new Integer(id));
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
	
	
	public int getOrderconsignmentscount(
			String id						
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
			
			Query q = session.createQuery("select count(*) from Orderhdr orderhdr where orderhdr.Consignmentno = :id1");
			q.setParameter("id1", id);
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

	
	@SuppressWarnings("unchecked")
	public List<Orderhdr> findOrderconsignments(
			String id	
	) throws ApplicationException {
		
		List<Orderhdr> queryResult = null;
		
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
				"select orderhdr"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr"
				+ " where"			
				+ " orderhdr.Consignmentno = '"+id+"'"
				;		
			queryResult = session
			.createQuery(queryString)
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
	

	
	public int countOrdersByCustomeraddrkey(
			String id						
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
			
			Query q = session.createQuery("select count(*) from Orderhdr orderhdr where orderhdr.Customeraddrkey = :id1");
			q.setParameter("id1", id);
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
	

	public int countOrdersByLdglocationkey2(
			String id						
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
			
			Query q = session.createQuery("select count(*) from Orderhdr orderhdr where orderhdr.Ldglocationkey2 = :id1");
			q.setParameter("id1", id);
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
	

	
	
}

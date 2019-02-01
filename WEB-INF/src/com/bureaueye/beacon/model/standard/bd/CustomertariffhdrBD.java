package com.bureaueye.beacon.model.standard.bd;

import java.util.Calendar;
import java.util.Date;
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
import com.bureaueye.beacon.form.standard.ListCustomertariffhdrForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Customertariffdtl;
import com.bureaueye.beacon.model.standard.Customertariffhdr;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dao.CustomertariffhdrDAO;
import com.bureaueye.beacon.model.standard.dto.CustomertariffSearchLineItem;
import com.bureaueye.beacon.model.standard.dto.CustomertariffhdrDTO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;


/**
*
* Amendments
* ----------
*
*	NT	2009-10-20		200900049			Add 'ActiveExpired' Search Criteria
*											(changes not marked)
*
*/
public final class CustomertariffhdrBD extends BaseBD {
	
	
	// constructors
	public CustomertariffhdrBD() {
	}
	public CustomertariffhdrBD(SessionFactory _factory) {
		super(_factory);		
	}
	public CustomertariffhdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	

    private static final String DEFAULT_CLASS_NAME = Customertariffhdr.class.getName();

    
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Customertariffhdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Customertariffhdr dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Customertariffhdr)session.get(Customertariffhdr.class, (String)key);
			
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
			Customertariffhdr _dao=(Customertariffhdr)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getCusttarfhdrId()) != null) {
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
			Customertariffhdr _dao=(Customertariffhdr)dao;
			
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
	public List<CustomertariffhdrDTO> findCustomertariffhdrsForSearch(
			ListCustomertariffhdrForm listForm
	) throws ApplicationException {
		
		List queryResult = null;
		List<CustomertariffhdrDTO> queryResultDTO = new LinkedList<CustomertariffhdrDTO>();
		
		String customeraddrkey = listForm.getSearchString1();
		if (customeraddrkey == null || customeraddrkey.equals("")) {
			customeraddrkey = "%";
		}
		String chargekey = listForm.getSearchString2();
		if (chargekey == null || chargekey.equals("")) {
			chargekey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
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
				"select customertariffhdr"+
				" from Customertariffhdr customertariffhdr"
				+ " where "			
				+ " customertariffhdr.CusttarfhdrId LIKE '"+custtarfhdrid+"'"
				+ " and customertariffhdr.Customeraddrkey LIKE '"+customeraddrkey+"'"
				+ " and customertariffhdr.Chargekey LIKE '"+chargekey+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Customertariffhdr _dao=(Customertariffhdr)it.next();
				CustomertariffhdrDTO _dto=new CustomertariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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

	
	public List<CustomertariffhdrDTO> findCustomertariffhdrsForSearchActive(
			ListCustomertariffhdrForm listForm
	) throws ApplicationException {
		
		List queryResult = null;
		List<CustomertariffhdrDTO> queryResultDTO = new LinkedList<CustomertariffhdrDTO>();
		DateFormatter dateFormatter = new DateFormatter();
		
		String customeraddrkey = listForm.getSearchString1();
		if (customeraddrkey == null || customeraddrkey.equals("")) {
			customeraddrkey = "%";
		}
		String chargekey = listForm.getSearchString2();
		if (chargekey == null || chargekey.equals("")) {
			chargekey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
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
				"select customertariffhdr"+
				" from Customertariffhdr customertariffhdr"
				+ " where "			
				+ " customertariffhdr.CusttarfhdrId LIKE '"+custtarfhdrid+"'"
				+ " and customertariffhdr.Customeraddrkey LIKE '"+customeraddrkey+"'"
				+ " and customertariffhdr.Chargekey LIKE '"+chargekey+"'"
				+ " and customertariffhdr.Validto >= '"+dateFormatter.format(listForm.getSearchDate1())+"'"					
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Customertariffhdr _dao=(Customertariffhdr)it.next();
				CustomertariffhdrDTO _dto=new CustomertariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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


	public List<CustomertariffhdrDTO> findCustomertariffhdrsForSearchExpired(
			ListCustomertariffhdrForm listForm
	) throws ApplicationException {
		
		List queryResult = null;
		List<CustomertariffhdrDTO> queryResultDTO = new LinkedList<CustomertariffhdrDTO>();
		DateFormatter dateFormatter = new DateFormatter();
		
		String customeraddrkey = listForm.getSearchString1();
		if (customeraddrkey == null || customeraddrkey.equals("")) {
			customeraddrkey = "%";
		}
		String chargekey = listForm.getSearchString2();
		if (chargekey == null || chargekey.equals("")) {
			chargekey = "%";
		}
		String custtarfhdrid = listForm.getSearchString3();
		if (custtarfhdrid == null || custtarfhdrid.equals("")) {
			custtarfhdrid = "%";
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
				"select customertariffhdr"+
				" from Customertariffhdr customertariffhdr"
				+ " where "			
				+ " customertariffhdr.CusttarfhdrId LIKE '"+custtarfhdrid+"'"
				+ " and customertariffhdr.Customeraddrkey LIKE '"+customeraddrkey+"'"
				+ " and customertariffhdr.Chargekey LIKE '"+chargekey+"'"
				+ " and customertariffhdr.Validto < '"+dateFormatter.format(listForm.getSearchDate1())+"'"					
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Customertariffhdr _dao=(Customertariffhdr)it.next();
				CustomertariffhdrDTO _dto=new CustomertariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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


	public List findCustomertariffhdrsByAddrkey(
			String addrkey
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
			.createCriteria(Customertariffhdr.class)
			.add(Expression.eq("Customeraddrkey", addrkey))
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
	
	
	public List customertariffSearch(
			String customeraddrkey,
			String chargekey,
			String fromlocationkey,
			String fromlocationkey2,
			String tolocationkey2,
			String tolocationkey,
			String productkey,
			String ccykey, 	
			String unittype,
			String units,
			int gotoPage, 
			int maxResults, 
			String order
	) throws ApplicationException {
		
		List queryResult = null;
		List<CustomertariffhdrDTO> queryResultDTO = new LinkedList<CustomertariffhdrDTO>();
		List<CustomertariffSearchLineItem> lineitems = new LinkedList<CustomertariffSearchLineItem>();
		
		if (customeraddrkey == null || customeraddrkey.equals("")) {
			customeraddrkey = "%";
		}
		
		if (chargekey == null || chargekey.equals("")) {
			chargekey = "%";
		}
		
		if (fromlocationkey == null || fromlocationkey.equals("")) {
			fromlocationkey = "%";
		}
		
		if (fromlocationkey2 == null || fromlocationkey2.equals("")) {
			fromlocationkey2 = "%";
		}
		
		if (tolocationkey == null || tolocationkey.equals("")) {
			tolocationkey = "%";
		}
		
		if (tolocationkey2 == null || tolocationkey2.equals("")) {
			tolocationkey2 = "%";
		}
		
		if (productkey == null || productkey.equals("")) {
			productkey = "%";
		}
		
		if (ccykey == null || ccykey.equals("")) {
			ccykey = "%";
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
			.createCriteria(Customertariffhdr.class)
			.add(Expression.like("Customeraddrkey", customeraddrkey))											
			.add(Expression.like("Chargekey", chargekey))
			.add(Expression.like("Fromlocationkey", fromlocationkey))
			.add(Expression.like("Fromlocationkey2", fromlocationkey2))
			.add(Expression.like("Tolocationkey2", tolocationkey2))
			.add(Expression.like("Tolocationkey", tolocationkey))
			.add(Expression.like("Productkey", productkey))
			.add(Expression.like("Ccykey", ccykey))
			.add(Expression.ge("Validto", new Date()))						
			.addOrder(Order.asc(order))
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Customertariffhdr _dao=(Customertariffhdr)it.next();
				CustomertariffhdrDTO _dto=new CustomertariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
		
		try {
			if (queryResultDTO != null) {
				for(Iterator it = queryResultDTO.iterator(); it.hasNext();) {
					CustomertariffhdrDTO hdr = (CustomertariffhdrDTO)it.next();	
					Customertariffdtl dtl = null;
					// find tariff detail if rate type
					if (unittype.equals("UNIT") || unittype.equals("DISTANCE")) {
						dtl = new CustomertariffdtlBD(this.getSessionFactoryClusterMap()).findCustomertariffdtlByKey1(
								hdr.getCusttarfhdrId(),
								units
						);
						//try {
						//	if (dtl != null) dtl.setLumpsum(new BigDecimal(units).multiply(dtl.getUnitrate()));
						//} catch (Exception e) {}
					} 
					//else {
					//dtl = new CustomertariffdtlBD().findCustomertariffdtlById(hdr.getCusttarfhdrId());
					//if (dtl != null) dtl.setUnitrate(new BigDecimal(1));
					//}
					
					CustomertariffSearchLineItem lineitem = new CustomertariffSearchLineItem(hdr, dtl, unittype, units);
					lineitems.add(lineitem);	
				}			
			}
		} catch (ApplicationException ae) {			
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}		
		
		return lineitems;	
		
	}		
	

	public List findCustomertariffhdrsForDashboard(
			ListForm listForm
	) throws ApplicationException {
		
		List queryResult = null;
		List<CustomertariffhdrDTO> queryResultDTO = new LinkedList<CustomertariffhdrDTO>();
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
				"select customertariffhdr"+
				" from Customertariffhdr customertariffhdr"
				+ " where "			
				+ " customertariffhdr.Createuserid LIKE '"+listForm.getSearchString1()+"'"
				+ " and customertariffhdr.Validto >= '"+dateFormatter.format(listForm.getSearchDate1())+"'"
				+ " and customertariffhdr.Validto <= '"+dateFormatter.format(listForm.getSearchDate2())+"'"				
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Customertariffhdr _dao=(Customertariffhdr)it.next();
				CustomertariffhdrDTO _dto=new CustomertariffhdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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

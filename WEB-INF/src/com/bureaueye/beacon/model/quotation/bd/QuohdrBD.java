package com.bureaueye.beacon.model.quotation.bd;

 
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
import com.bureaueye.beacon.model.quotation.Quoapprove;
import com.bureaueye.beacon.model.quotation.Quocharge;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.Quonote;
import com.bureaueye.beacon.model.quotation.Quonotecust;
import com.bureaueye.beacon.model.quotation.Quoprod;
import com.bureaueye.beacon.model.quotation.dao.QuohdrDAO;
import com.bureaueye.beacon.model.quotation.dto.QuohdrDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

 
/**
 *
 * Amendments
 * ----------
 *
 * NT	2009-05-31		ITT-200905-0003		Add Logistic Location details to Quohdr List
 *
 * NT	2009-12-10		200900058			Use Quotno to find Order headers
 *
 * NT	2010-10-28		201000045			Add Max Results No Limit Option
 *
 * NT	2011-03-01		ITT-201103-0001		Quotation Customer Notes 
 *
 */


public final class QuohdrBD extends BaseBD {
	
	
	// constructors
	public QuohdrBD() {
	}
	public QuohdrBD(SessionFactory _factory) {
		super(_factory);		
	}
	public QuohdrBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}
	public QuohdrBD(
			SessionFactory _factory1, 
			SessionFactory _factory2,
			SessionFactory _factory3
			) {
		super(_factory1, _factory2, _factory3);		
	}	
	public QuohdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Quohdr.class.getName();
    
    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Quohdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Quohdr dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Quohdr)session.get(Quohdr.class, (Integer)key);
			
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
			Quohdr _dto=(Quohdr)dto;
			
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
			Quohdr _dto=(Quohdr)dto;
			
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
		Quohdr dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {
				List set = getQuomovs(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuomovBD().delete((Quomov)it.next(), user);
				}
				set = getQuocostsAll(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuocostBD().delete((Quocost)it.next(), user);
				}
				set = getQuonotes(id);				
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuonoteBD().delete((Quonote)it.next(), user);
				}	
				
				//sITT-201103-0001
				set = getQuonotecusts(id);				
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuonotecustBD().delete((Quonotecust)it.next(), user);
				}
				//eITT-201103-0001
				
				set = getQuocharges(id);				
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuochargeBD().delete((Quocharge)it.next(), user);
				}	
				set = getQuoprods(id);				
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuoprodBD().delete((Quoprod)it.next(), user);
				}
				set = getQuoapproves(id);				
				for (Iterator it = set.iterator(); it.hasNext();) {
					new QuoapproveBD().delete((Quoapprove)it.next(), user);
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
	public List findQuohdrsByQuotno(String quotno, String order)
	throws ApplicationException {
		
		List queryResult = null;
		
		if (quotno == null || quotno.equals("")) {
			quotno = "%";
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
			.createCriteria(Quohdr.class)
			.add(Expression.like("Quotno", quotno))
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
	

	public Quohdr findQuohdrByQuotnoQuotestatus(
			String quotno, 
			String status
	)
	throws ApplicationException {
		
		Quohdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Quohdr)session
			.createCriteria(Quohdr.class)
			.add(Expression.eq("Quotno", quotno))
			.add(Expression.eq("Quotestatus", status))							
			.addOrder(Order.desc("Quotedate"))
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
	
		
	@SuppressWarnings("unchecked")
	public List<QuohdrDTO> findQuohdrsBySearchExpired(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Quohdr> queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
		DateFormatter dateFormatter = new DateFormatter();
		
		// 
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}		
		// customer name
		String searchString14 = listForm.getSearchString14();
		if (searchString14 == null || searchString14.equals("")) {
			searchString14="%";
		}

		//loading gcodes
		String searchString20 = listForm.getSearchString20();
		if (searchString20 == null || searchString20.equals("")) {
			searchString20 = "%";
		}	
		String searchString21 = listForm.getSearchString21();
		if (searchString21 == null || searchString21.equals("")) {
			searchString21 = "%";
		}	
		String searchString22 = listForm.getSearchString22();
		if (searchString22 == null || searchString22.equals("")) {
			searchString22 = "%";
		}	
		String searchString23 = listForm.getSearchString23();
		if (searchString23 == null || searchString23.equals("")) {
			searchString23 = "%";
		}	
		//discharge gcodes
		String searchString24 = listForm.getSearchString24();
		if (searchString24== null || searchString24.equals("")) {
			searchString24 = "%";
		}	
		String searchString25 = listForm.getSearchString25();
		if (searchString25 == null || searchString25.equals("")) {
			searchString25 = "%";
		}	
		String searchString26 = listForm.getSearchString26();
		if (searchString26 == null || searchString26.equals("")) {
			searchString26 = "%";
		}	
		String searchString27 = listForm.getSearchString27();
		if (searchString27 == null || searchString27.equals("")) {
			searchString27 = "%";
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"	
				+ "     quohdr.Companykey = '"+listForm.getSearchString19()+"'"				
				+ " AND quohdr.Quotno LIKE '"+searchString1+"'"
				+ " and quohdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and quohdr.Quotestatus LIKE '"+listForm.getSearchString9()+"'"
				+ " and quohdr.Ldglocationkey1 LIKE '"+listForm.getSearchString10()+"'"
				+ " and quohdr.Ldglocationkey2 LIKE '"+listForm.getSearchString11()+"'"
				+ " and quohdr.Dchlocationkey2 LIKE '"+listForm.getSearchString12()+"'"
				+ " and quohdr.Dchlocationkey1 LIKE '"+listForm.getSearchString13()+"'"
				+ " and quohdr.Customername LIKE '"+searchString14+"'"	
				+ " and quohdr.Expirydate < '"+dateFormatter.format(listForm.getSearchDate3())+"'"
				+ " and quohdr.Ldgg1key2 LIKE '"+searchString20+"'"
				+ " and quohdr.Ldgg2key2 LIKE '"+searchString21+"'"
				+ " and quohdr.Ldgg3key2 LIKE '"+searchString22+"'"
				+ " and quohdr.Ldgg4key2 LIKE '"+searchString23+"'"
				+ " and quohdr.Dchg1key2 LIKE '"+searchString24+"'"
				+ " and quohdr.Dchg2key2 LIKE '"+searchString25+"'"
				+ " and quohdr.Dchg3key2 LIKE '"+searchString26+"'"
				+ " and quohdr.Dchg4key2 LIKE '"+searchString27+"'"				
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator<Quohdr> it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	@SuppressWarnings("unchecked")
	public List<QuohdrDTO> findQuohdrsBySearchActive(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Quohdr> queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
		DateFormatter dateFormatter = new DateFormatter();
		
		// 
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}		
		// customer name
		String searchString14 = listForm.getSearchString14();
		if (searchString14 == null || searchString14.equals("")) {
			searchString14="%";
		}
		

		
		//loading gcodes
		String searchString20 = listForm.getSearchString20();
		if (searchString20 == null || searchString20.equals("")) {
			searchString20 = "%";
		}	
		String searchString21 = listForm.getSearchString21();
		if (searchString21 == null || searchString21.equals("")) {
			searchString21 = "%";
		}	
		String searchString22 = listForm.getSearchString22();
		if (searchString22 == null || searchString22.equals("")) {
			searchString22 = "%";
		}	
		String searchString23 = listForm.getSearchString23();
		if (searchString23 == null || searchString23.equals("")) {
			searchString23 = "%";
		}	
		//discharge gcodes
		String searchString24 = listForm.getSearchString24();
		if (searchString24== null || searchString24.equals("")) {
			searchString24 = "%";
		}	
		String searchString25 = listForm.getSearchString25();
		if (searchString25 == null || searchString25.equals("")) {
			searchString25 = "%";
		}	
		String searchString26 = listForm.getSearchString26();
		if (searchString26 == null || searchString26.equals("")) {
			searchString26 = "%";
		}	
		String searchString27 = listForm.getSearchString27();
		if (searchString27 == null || searchString27.equals("")) {
			searchString27 = "%";
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"	
				+ "     quohdr.Companykey = '"+listForm.getSearchString19()+"'"
				+ " AND quohdr.Quotno LIKE '"+searchString1+"'"
				+ " and quohdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and quohdr.Quotestatus LIKE '"+listForm.getSearchString9()+"'"
				+ " and quohdr.Ldglocationkey1 LIKE '"+listForm.getSearchString10()+"'"
				+ " and quohdr.Ldglocationkey2 LIKE '"+listForm.getSearchString11()+"'"
				+ " and quohdr.Dchlocationkey2 LIKE '"+listForm.getSearchString12()+"'"
				+ " and quohdr.Dchlocationkey1 LIKE '"+listForm.getSearchString13()+"'"				
				+ " and quohdr.Customername LIKE '"+searchString14+"'"	
				+ " and quohdr.Expirydate >= '"+dateFormatter.format(listForm.getSearchDate3())+"'"
				+ " and quohdr.Ldgg1key2 LIKE '"+searchString20+"'"
				+ " and quohdr.Ldgg2key2 LIKE '"+searchString21+"'"
				+ " and quohdr.Ldgg3key2 LIKE '"+searchString22+"'"
				+ " and quohdr.Ldgg4key2 LIKE '"+searchString23+"'"
				+ " and quohdr.Dchg1key2 LIKE '"+searchString24+"'"
				+ " and quohdr.Dchg2key2 LIKE '"+searchString25+"'"
				+ " and quohdr.Dchg3key2 LIKE '"+searchString26+"'"
				+ " and quohdr.Dchg4key2 LIKE '"+searchString27+"'"	
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
		
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator<Quohdr> it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	@SuppressWarnings("unchecked")
	public List<QuohdrDTO> findQuohdrsBySearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Quohdr> queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
		DateFormatter dateFormatter = new DateFormatter();
		
		// 
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}		
		// customer name
		String searchString14 = listForm.getSearchString14();
		if (searchString14 == null || searchString14.equals("")) {
			searchString14="%";
		}

		//loading gcodes
		String searchString20 = listForm.getSearchString20();
		if (searchString20 == null || searchString20.equals("")) {
			searchString20 = "%";
		}	
		String searchString21 = listForm.getSearchString21();
		if (searchString21 == null || searchString21.equals("")) {
			searchString21 = "%";
		}	
		String searchString22 = listForm.getSearchString22();
		if (searchString22 == null || searchString22.equals("")) {
			searchString22 = "%";
		}	
		String searchString23 = listForm.getSearchString23();
		if (searchString23 == null || searchString23.equals("")) {
			searchString23 = "%";
		}	
		//discharge gcodes
		String searchString24 = listForm.getSearchString24();
		if (searchString24== null || searchString24.equals("")) {
			searchString24 = "%";
		}	
		String searchString25 = listForm.getSearchString25();
		if (searchString25 == null || searchString25.equals("")) {
			searchString25 = "%";
		}	
		String searchString26 = listForm.getSearchString26();
		if (searchString26 == null || searchString26.equals("")) {
			searchString26 = "%";
		}	
		String searchString27 = listForm.getSearchString27();
		if (searchString27 == null || searchString27.equals("")) {
			searchString27 = "%";
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"
				+ "     quohdr.Companykey = '"+listForm.getSearchString19()+"'"
				+ " AND quohdr.Quotno LIKE '"+searchString1+"'"
				+ " and quohdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and quohdr.Quotestatus LIKE '"+listForm.getSearchString9()+"'"
				+ " and quohdr.Ldglocationkey1 LIKE '"+listForm.getSearchString10()+"'"
				+ " and quohdr.Ldglocationkey2 LIKE '"+listForm.getSearchString11()+"'"
				+ " and quohdr.Dchlocationkey2 LIKE '"+listForm.getSearchString12()+"'"
				+ " and quohdr.Dchlocationkey1 LIKE '"+listForm.getSearchString13()+"'"
				+ " and quohdr.Customername LIKE '"+searchString14+"'"	
				+ " and quohdr.Ldgg1key2 LIKE '"+searchString20+"'"
				+ " and quohdr.Ldgg2key2 LIKE '"+searchString21+"'"
				+ " and quohdr.Ldgg3key2 LIKE '"+searchString22+"'"
				+ " and quohdr.Ldgg4key2 LIKE '"+searchString23+"'"
				+ " and quohdr.Dchg1key2 LIKE '"+searchString24+"'"
				+ " and quohdr.Dchg2key2 LIKE '"+searchString25+"'"
				+ " and quohdr.Dchg3key2 LIKE '"+searchString26+"'"
				+ " and quohdr.Dchg4key2 LIKE '"+searchString27+"'"					
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator<Quohdr> it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public List findQuohdrsBySearchByQuotno(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();	


		
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"			
				+ " quohdr.Quotno = '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public int findQuohdrsTotalResultsExpired(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
		//  no
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		// customer name
		String searchString14 = listForm.getSearchString14();
		if (searchString14 == null || searchString14.equals("")) {
			searchString14="%";
		}


		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuohdrDAO.QUERY_FIND_QUOHDRS_TOTAL_RESULTS_EXPIRED);
			q.setParameter("id1", searchString1);
			q.setParameter("id2", listForm.getSearchString2());
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id3", listForm.getSearchString9());
			q.setParameter("id4", listForm.getSearchString10());	
			q.setParameter("id5", listForm.getSearchString11());	
			q.setParameter("id6", listForm.getSearchString12());	
			q.setParameter("id7", listForm.getSearchString13());
			q.setParameter("id8", searchString14);
			q.setParameter("date3", listForm.getSearchDate3());	
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
		

	public int findQuohdrsTotalResults(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
		//  no
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		// customer name
		String searchString14 = listForm.getSearchString14();
		if (searchString14 == null || searchString14.equals("")) {
			searchString14="%";
		}


		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuohdrDAO.QUERY_FIND_QUOHDRS_TOTAL_RESULTS);
			q.setParameter("id1", searchString1);
			q.setParameter("id2", listForm.getSearchString2());
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id3", listForm.getSearchString9());
			q.setParameter("id4", listForm.getSearchString10());	
			q.setParameter("id5", listForm.getSearchString11());	
			q.setParameter("id6", listForm.getSearchString12());	
			q.setParameter("id7", listForm.getSearchString13());
			q.setParameter("id8", searchString14);
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
		

	public int findQuohdrsTotalResultsActive(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
		//  no
		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}
		// customer name
		String searchString14 = listForm.getSearchString14();
		if (searchString14 == null || searchString14.equals("")) {
			searchString14="%";
		}


		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session.getNamedQuery(QuohdrDAO.QUERY_FIND_QUOHDRS_TOTAL_RESULTS_ACTIVE);
			q.setParameter("id1", searchString1);
			q.setParameter("id2", listForm.getSearchString2());
			q.setParameter("date1", listForm.getSearchDate1());
			q.setParameter("date2", listForm.getSearchDate2());
			q.setParameter("id3", listForm.getSearchString9());
			q.setParameter("id4", listForm.getSearchString10());	
			q.setParameter("id5", listForm.getSearchString11());	
			q.setParameter("id6", listForm.getSearchString12());	
			q.setParameter("id7", listForm.getSearchString13());
			q.setParameter("id8", searchString14);
			q.setParameter("date3", listForm.getSearchDate3());	
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
		

	public int findQuohdrsTotalResultsByQuotno(
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
			
			Query q = session.getNamedQuery(QuohdrDAO.QUERY_FIND_QUOHDRS_TOTAL_RESULTS_BY_QUOTNO);
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
	

	
	
	public List findQuohdrsByExpirydate(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"			
				+ " quohdr.Expirydate <= '"+dateFormatter.format(listForm.getSearchDate1())+"'"		
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		
			queryResult = session
			.createQuery(queryString)
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public List findQuohdrsByQuoteCustomerDate(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"			
				+ "     quohdr.Quotno LIKE '"+searchString1+"'"
				+ " and quohdr.Customeraddrkey LIKE '"+listForm.getSearchString2()+"'"
				+ " and quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"			
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public List findQuohdrsByQuotedateQuotestatus(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"			
				+ "     quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"
				+ " and quohdr.Quotestatus = '"+listForm.getSearchString2()+"'"					
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults())
			.setMaxResults(listForm.getMaxResults())
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
		
	public List getQuomovs(Integer id)
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
			.createQuery("from Quomov quomov where quomov.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	
	
	public List getQuocosts(Integer id)
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
			.createQuery("from Quocost quocost where quocost.QuohdrId = :QuohdrId and quocost.QuomovId = 0");
			q.setParameter("QuohdrId", id);			
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
	

	public List getQuocostsAll(Integer id)
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
			.createQuery("from Quocost quocost where quocost.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	

	public List getQuocharges(Integer id)
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
			.createQuery("from Quocharge quocharge where quocharge.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	
	
	public List getQuoprods(Integer id)
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
			.createQuery("from Quoprod quoprod where quoprod.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	
	
	public List getQuonotes(Integer id)
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
			.createQuery("from Quonote quonote where quonote.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	

	//sITT-201103-0001
	public List getQuonotecusts(Integer id)
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
			.createQuery("from Quonotecust quonotecust where quonotecust.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	//eITT-201103-0001
	

	public List getQuohdrs(Integer id)
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
			.createQuery("from Quohdr quohdr where quohdr.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	

	public List getOrderhdrs(Integer id)
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
			.createQuery("from Orderhdr orderhdr where orderhdr.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	
		
	public List getQuoapproves(Integer id)
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
			.createQuery("from Quoapprove quoapprove where quoapprove.QuohdrId = :QuohdrId");
			q.setParameter("QuohdrId", id);			
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
	
	
	public Quohdr findQuohdrByQuotno(String quotno) 
	throws ApplicationException
	{
		
		Quohdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Quohdr)session
			.createCriteria(Quohdr.class)
			.add( Expression.eq("Quotno", quotno) )
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
	
	
	public List findQuohdrsByKey1(
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
				"select quohdr "+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where "			
				+ " quohdr.Systemloguserid = '"+searchString1+"' and"
				+ " quohdr.Quotedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"			
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
	
	
	public int quohdrsCountByQuotestatusQuotedateQuotebyuserid(
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
			
			Query q = session.getNamedQuery(QuohdrDAO.QUERY_QUOHDRS_COUNT_BY_QUOTESTATUS_QUOTEDATE_QUOTEBYUSERID);
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
		

	//200900058
	public List getOrderhdrsByQuotno(String quotno)
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
			.createQuery("from Orderhdr orderhdr where orderhdr.Quotno = :Quotno");
			q.setParameter("Quotno", quotno);			
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
	

	

	public List<QuohdrDTO> findQuohdrsForDashboard(
			ListForm listForm	
	) throws ApplicationException {
		
		List<Quohdr> queryResult = null;
		List<QuohdrDTO> queryResultDTO = new LinkedList<QuohdrDTO>();		
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
				"select quohdr"+
				" from com.bureaueye.beacon.model.quotation.Quohdr quohdr"
				+ " where"
				+ "     quohdr.Expirydate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"					
				+ " AND quohdr.Quotebyuserid LIKE '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
		
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();

			//iterate results to set many-to-one mappings 
			for (Iterator<Quohdr> it = queryResult.iterator(); it.hasNext();) {
				Quohdr _dao=(Quohdr)it.next();
				QuohdrDTO _dto=new QuohdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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

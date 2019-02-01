package com.bureaueye.beacon.model.standard.bd;

import java.util.Arrays;
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
import org.hibernate.criterion.Order;






import org.hibernate.criterion.Expression;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dao.UnitDAO;
import com.bureaueye.beacon.model.standard.dto.UnitDTO;
import com.bureaueye.beacon.model.standard.dto.UnitSearchDTO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;

public final class UnitBD extends BaseBD {
	
	
	// constructors
	public UnitBD() {
	}
	public UnitBD(SessionFactory _factory) {
		super(_factory);		
	}
	public UnitBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Unit.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Unit read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Unit dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Unit)session.get(Unit.class, (Integer)key);
			
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
			Unit _dto=(Unit)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getUnitId()) != null) {
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
			Unit _dto=(Unit)dto;
			
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
	public Unit findUnitByUnitkey(String unitkey) 
	throws ApplicationException
	{
		
		Unit queryResult = null;
		
		if (unitkey == null) {return null;}
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Unit)session
			.createCriteria(Unit.class)
			.add( Expression.eq("Unitkey", unitkey) )
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
	
	
	public List unitJobSearch(
			String searchString1,
			String searchString2, String searchString3, String searchString4,
			String searchString5, String searchString6, String searchString7,
			String searchString8, String searchString9, String searchString10,
			String searchString11, String searchString12,
			String searchString13, String searchString14,
			int gotoPage, 
			int maxResults, 
			String order,
			String headerInfo1,
			String headerInfo3,
			String headerInfo4,
			String headerInfo5
	) throws ApplicationException {
		
		List queryResult = null;
		List<UnitSearchDTO> queryResultDTO = new LinkedList<UnitSearchDTO>();
		
		// 
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}		
		// 
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "N";
		}				
		// equipment parameters
		if (searchString7 == null || searchString7.equals("")) {
			searchString7 = "%";
		}
		if (searchString8 == null || searchString8.equals("")) {
			searchString8 = "%";
		}
		if (searchString9 == null || searchString9.equals("")) {
			searchString9 = "%";
		}
		if (searchString10 == null || searchString10.equals("")) {
			searchString10 = "%";
		}
		if (searchString11 == null || searchString11.equals("")) {
			searchString11 = "%";
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
			.createCriteria(Unit.class)
			.add(Expression.in("Invsts", Arrays.asList(headerInfo1.split(","))))
			//.add(Expression.sql("this.Deleted = '"+headerInfo3+"'"))
			//.add(Expression.sql("this.Xinactive = '"+headerInfo4+"'"))
			.add(Expression.sql("Oprsysblockalloc = '"+headerInfo5+"'"))
			//.add(Expression.sql("Foodgrad = '"+searchString6+"'"))	
			.add(Expression.like("Unitkey", searchString1))
			.add(Expression.like("Eqpkeyp1", searchString7))
			.add(Expression.like("Eqpkeyp2", searchString8))
			.add(Expression.like("Eqpkeyp3", searchString9))
			.add(Expression.like("Eqpkeyp4", searchString10))
			.add(Expression.like("Eqpkeyp5", searchString11))			
			.addOrder(Order.asc(order))
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
		
		try {
			if (queryResult != null) {
				for(Iterator it = queryResult.iterator(); it.hasNext();) {
					Unit dao = (Unit)it.next();	
					
					// TODO: get unit test details
					
					
					// TODO: check location search
					//Location location = new LocationBD().read(hdr.getMoveaddrkey());
					if (dao.getJobmovlocationkey() != null) {
						if (!searchString3.equals("") && !searchString3.equals(dao.getJobmovlocationkey())) continue;
						if (!searchString4.equals("") && !searchString4.equals(dao.getJobmovlocationkey())) continue;
						if (!searchString5.equals("") && !searchString5.equals(dao.getJobmovlocationkey())) continue;
					}
					
					// TODO: init line item dto
					UnitSearchDTO lineitem = new UnitSearchDTO(dao);
					queryResultDTO.add(lineitem);
					
				}
				
			}
			//} catch (ApplicationException ae) {			
		} catch (Exception ae) {					
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}		
		
		return queryResultDTO;		
		
	}		
	
	
	public int findUnitsTotalResults(
			ListForm listForm						
	) throws ApplicationException {
		
		int queryTotal=0;
		
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
			
			Query q = session.getNamedQuery(UnitDAO.QUERY_FIND_UNITS_TOTAL_RESULTS);
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
	
	
	public List findUnitsBySearch(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		List<UnitDTO> queryResultDTO = new LinkedList<UnitDTO>();
		
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
			
			queryResult = session
			.createCriteria(Unit.class)
			.add(Expression.like("Unitkey", searchString1))						
			.addOrder(Order.asc(listForm.getOrderBy()))
			.setMaxResults(listForm.getMaxResults())
			.list();

			for(Iterator it = queryResult.iterator(); it.hasNext();) {
					Unit dao = (Unit)it.next();	
					// TODO: init line item dto
					UnitDTO lineitem = new UnitDTO(dao, this.getSessionFactoryClusterMap());
					queryResultDTO.add(lineitem);					
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
	
	
	public List findUnitsByMovests(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		
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
			
			queryResult = session
			.createCriteria(Unit.class)
			.add(Expression.like("Movests", searchString1))						
			.addOrder(Order.asc(listForm.getOrderBy()))
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
	
	
	public List findUnitsByInvsts(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		
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
			
			queryResult = session
			.createCriteria(Unit.class)
			.add(Expression.like("Invsts", searchString1))						
			.addOrder(Order.asc(listForm.getOrderBy()))
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
	
	
	public List findUnitsByKey1(
			ListForm listForm
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
			.createCriteria(Unit.class)
			.add(Expression.sql("Xinactive = '"+listForm.getSearchString2()+"'"))	
			.add(Expression.like("Unitkey", listForm.getSearchString1()))
			.addOrder(Order.asc(listForm.getOrderBy()))
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
	
	
	public List findUnitsByKey2(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		List<UnitSearchDTO> queryResultDTO = new LinkedList<UnitSearchDTO>();		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Unit.class)
			.add(Expression.eq("Movests", listForm.getSearchString1()))
			.add(Expression.like("Moveaddrkey", listForm.getSearchString2()))
			.addOrder(Order.asc(listForm.getOrderBy()))
			.list();

			for(Iterator it = queryResult.iterator(); it.hasNext();) {
				Unit dao = (Unit)it.next();	
				// init line item dto
				UnitSearchDTO dto = new UnitSearchDTO(dao, this.getSessionFactoryClusterMap());
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
	
	
	public List findUnitsByKey3(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		List<UnitSearchDTO> queryResultDTO = new LinkedList<UnitSearchDTO>();		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Unit.class)
			.add(Expression.eq("Movests", listForm.getSearchString1()))
			.add(Expression.like("Movelocationkey", listForm.getSearchString3()))
			.add(Expression.like("Eqpkeyp1", listForm.getSearchString4()))
			.add(Expression.like("Eqpkeyp2", listForm.getSearchString5()))
			.addOrder(Order.asc(listForm.getOrderBy()))
			.list();

			for(Iterator it = queryResult.iterator(); it.hasNext();) {
				Unit dao = (Unit)it.next();	
				// init line item dto
				UnitSearchDTO dto = new UnitSearchDTO(dao, this.getSessionFactoryClusterMap());
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
	

	
	
	
	
	//--------------------------------------------------
	// new for Units created by Purchase Order System
	//--------------------------------------------------
	public List findUnitsByPodtlrcvdId(Integer id)
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
			.createQuery("from Unit unit where unit.PodtlrcvdId = :PodtlrcvdId");
			q.setParameter("PodtlrcvdId", id);			
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
	
	
	public int countUnitsByPodtlrcvdId(String id)
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
			
			Query q = session.getNamedQuery(UnitDAO.QUERY_COUNT_UNITS_BY_PODTLRCVD_ID);
			q.setParameter("id", id);			
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

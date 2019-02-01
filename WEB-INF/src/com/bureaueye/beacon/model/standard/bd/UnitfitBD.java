package com.bureaueye.beacon.model.standard.bd;

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
import com.bureaueye.beacon.model.standard.Unitfit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.dao.UnitfitDAO;
import com.bureaueye.beacon.model.standard.dto.UnitSearchDTO;
import com.bureaueye.beacon.model.standard.dto.UnitUnitfitDTO;
import com.bureaueye.beacon.model.standard.dto.UnitfitDTO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;






public final class UnitfitBD extends BaseBD {
	
	
	// constructors
	public UnitfitBD() {
	}
	public UnitfitBD(SessionFactory _factory) {
		super(_factory);		
	}
	public UnitfitBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	

    private static final String DEFAULT_CLASS_NAME = Unitfit.class.getName();

    
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Unitfit read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Unitfit dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Unitfit)session.get(Unitfit.class, (Integer)key);
			
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
			Unitfit _dto=(Unitfit)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getUnitfitId()) != null) {
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
			Unitfit _dto=(Unitfit)dto;
			
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
	public List findUnitfitsById(
			String id, 
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {
		
		List queryResult = null;
		List<UnitfitDTO> queryResultDTO = new LinkedList<UnitfitDTO>();		
		
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
			.createCriteria(Unitfit.class)
			.add(Expression.eq("UnitId", new Integer(id)))
			.addOrder(Order.asc(order))
			.setMaxResults(maxResults)
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Unitfit _dao=(Unitfit)it.next();
				UnitfitDTO _dto=new UnitfitDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
		
	public int findUnitfitsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(UnitfitDAO.QUERY_FIND_UNITFITS_TOTAL_RESULTS);
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
	
		
	public List findUnitfitsByKey1(
			ListForm listForm						
	) throws ApplicationException {
		
		List queryResult = null;
		List<UnitSearchDTO> queryResultDTO = new LinkedList<UnitSearchDTO>();

		String searchString9=listForm.getSearchString9();
		if (searchString9 == null || searchString9.equals("")) {
			searchString9="%";
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
				"SELECT new com.bureaueye.beacon.model.standard.dto.UnitUnitfitDTO(unit, unitfit)"+
				" from com.bureaueye.beacon.model.standard.Unitfit unitfit, com.bureaueye.beacon.model.standard.Unit unit"+
				"	WHERE"+
				"		unitfit.UnitId=unit.UnitId"+
				"	and	unitfit.Fitgrpkey like '"+listForm.getSearchString7()+"'"+
				"	and	unitfit.Fittypkey like '"+listForm.getSearchString8()+"'"+
				"	and	unitfit.Fitcoddes like '"+searchString9+"'"+
				"	and unit.Movelocationkey like '"+listForm.getSearchString6()+"'"+
				" order by unit.Unitkey, unitfit.Fitgrpkey, unitfit.Fittypkey";
			queryResult = session.createQuery(queryString).list();

			for(Iterator it = queryResult.iterator(); it.hasNext();) {
				UnitUnitfitDTO dao = (UnitUnitfitDTO)it.next();	
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
	
	
	
	
	
}

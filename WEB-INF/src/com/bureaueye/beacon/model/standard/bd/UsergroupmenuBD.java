package com.bureaueye.beacon.model.standard.bd;

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
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Usergroupmenu;
import com.bureaueye.beacon.model.standard.dao.UsergroupmenuDAO;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;


public final class UsergroupmenuBD extends BaseBD {


	// constructors
	public UsergroupmenuBD() {
	}
	public UsergroupmenuBD(SessionFactory _factory) {
		super(_factory);		
	}
	public UsergroupmenuBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
    private static final String DEFAULT_CLASS_NAME = Usergroupmenu.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Usergroupmenu read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Usergroupmenu dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Usergroupmenu)session.get(Usergroupmenu.class, (Integer)key);
			
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
			Usergroupmenu _dto=(Usergroupmenu)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getUsergroupmenuId()) != null) {
				session.update(_dto);
				new SystemlogBD(this.getSessionFactoryClusterMap()).createSystemlog(_dto, user, "update");
			} else {
/*				Calendar c = Calendar.getInstance();
				_dto.setCreatedate(c.getTime());
				_dto.setCreatetime(com.bureaueye.beacon.util.Util.toTime(c));
				_dto.setCreateuserid(user.getUserid());*/
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
			Usergroupmenu _dto=(Usergroupmenu)dto;
			
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
	public List findUsergroupmenus() throws ApplicationException {
		
		List queryResult=null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {

			Query q = session.createQuery("from Usergroupmenu usergroupmenu");

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
	
	
	public List findUsergroupmenusBySearch(
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

			queryResult = session.createCriteria(Usergroupmenu.class)
			.add(Expression.like("Usergroupid", listForm.getId()))						
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
		
	
	
	
	public int findUsergroupmenusTotalResults(String id)
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
			
	Query q = session.getNamedQuery(UsergroupmenuDAO.QUERY_FIND_USERGROUPMENUS_TOTAL_RESULTS);
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

	
	public List findUsergroupmenusById(String id) throws ApplicationException {

		List queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}	
		
		try {

			queryResult = session.createCriteria(Usergroupmenu.class)
			.add(Expression.eq("Usergroupid", id))						
			.addOrder(Order.asc("Sequence"))
			.addOrder(Order.asc("Menuid"))
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
		
	
	


	
	
	
}

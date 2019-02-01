package com.bureaueye.beacon.model.purchaseinvoice.bd;




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

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtl;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PihdrDTO;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PihdrdtlDTO;

import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



/**
 */
public final class PihdrBD extends BaseBD {
	
	
	// constructors
	public PihdrBD() {
	}
	public PihdrBD(SessionFactory _factory) {
		super(_factory);		
	}
	public PihdrBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}	
	
	
	private static final String DEFAULT_CLASS_NAME = Pihdr.class.getName();
	
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Pihdr read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Pihdr dao = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dao = (Pihdr)session.get(Pihdr.class, (Integer)key);
			
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
			Pihdr _dao=(Pihdr)dao;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dao.getPihdrId()) != null) {
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
			Pihdr _dao=(Pihdr)dao;
			
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
	
	
	public void deleteAll(Integer id, User user)
	throws ApplicationException {
		
		if (id == null) {return;}
		Pihdr dto = null;
		
		try {
			dto = read(id);
			if (dto != null) {
				List set = getPidtls(id);
				for (Iterator it = set.iterator(); it.hasNext();) {
					Pidtl pidtl = (Pidtl)it.next();
					new PidtlBD().deleteAll(pidtl.getPidtlId(), user);
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
	public List findPihdrsForSearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<PihdrDTO> queryResultDTO = new LinkedList<PihdrDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
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
				"select pihdr"+
				" from Pihdr pihdr"
				+ " where "	
				+ "     pihdr.Companykey = '"+listForm.getSearchString19()+"'"
				+ " AND pihdr.Vendoraddrkey LIKE '"+listForm.getSearchString3()+"'"			
				+ " and pihdr.Invoicedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"		
				+ " and pihdr.Invoicestatus LIKE '"+listForm.getSearchString4()+"'"	
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Pihdr _dao=(Pihdr)it.next();
				PihdrDTO _dto=new PihdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public List getPidtls(Integer id)
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
			.createQuery("from Pidtl pidtl where pidtl.PihdrId = :PihdrId");
			q.setParameter("PihdrId", id);			
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
	

	public Pihdr findPihdrByPino(String key) 
	throws ApplicationException {
		
		Pihdr queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Pihdr)session
			.createCriteria(Pihdr.class)
			.add( Expression.eq("Pino", key) )
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
	

	public List findPihdrsForSearchByPino(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<PihdrDTO> queryResultDTO = new LinkedList<PihdrDTO>();		
		
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
				"select pihdr"+
				" from Pihdr pihdr"
				+ " where"			
				+ " pihdr.Pino = '"+listForm.getSearchString1()+"'"
				+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	
			queryResult = session
			.createQuery(queryString)
			.setMaxResults(listForm.getMaxResults())
			.list();
			
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Pihdr _dao=(Pihdr)it.next();
				PihdrDTO _dto=new PihdrDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public int countPihdrsByVendoraddrkey(
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
			
			Query q = session.createQuery("select count(*) from Pihdr pihdr where pihdr.Vendoraddrkey = :id1");
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
	

	
	

	public List findPihdrdtlsForSearchByPino(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<PihdrdtlDTO> queryResultDTO = new LinkedList<PihdrdtlDTO>();		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			String queryString = "";			
			SQLQuery query = null;
			queryString = 
						"select {pihdr.*}, {pidtl.*} from Pihdr pihdr " +
						"inner join Pidtl pidtl on pihdr.Pihdr_Id = pidtl.Pihdr_Id " +
						" where"+			
						" pihdr.Pino = '"+listForm.getSearchString1()+"'"+
						" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();		
						;

			query = session.createSQLQuery(queryString);
			query.addEntity("pihdr", Pihdr.class);
			query.addEntity("pidtl", Pidtl.class);			
			query.setMaxResults(listForm.getMaxResults());
			queryResult=query.list();

			// iterate results 			
			Iterator it = queryResult.iterator();
			while ( it.hasNext() ) {
				Object[] obj = (Object[]) it.next();
				Pihdr pihdr = (Pihdr) obj[0];
				Pidtl pidtl = (Pidtl) obj[1];

				PihdrdtlDTO _dto=new PihdrdtlDTO(pihdr, pidtl, this.getSessionFactoryClusterMap()); 
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
	

	public List findPihdrdtlsForSearch(
			ListForm listForm	
	) throws ApplicationException {
		
		List queryResult = null;
		List<PihdrdtlDTO> queryResultDTO = new LinkedList<PihdrdtlDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}
		String searchString5 = listForm.getSearchString5();
		if (searchString5 == null || searchString5.equals("")) {
			searchString5 = "%";
		}
		String searchString6 = listForm.getSearchString6();
		if (searchString6 == null || searchString6.equals("")) {
			searchString6 = "%";
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
			SQLQuery query = null;
			queryString = 
						"select {pihdr.*}, {pidtl.*} from Pihdr pihdr " +
						"inner join Pidtl pidtl on pihdr.Pihdr_Id = pidtl.Pihdr_Id " 
						+ " where "	
						+ "     pihdr.Companykey = '"+listForm.getSearchString19()+"'"
						+ " AND pihdr.Vendoraddrkey LIKE '"+listForm.getSearchString3()+"'"			
						+ " and pihdr.Invoicedate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'"		
						+ " and pihdr.Invoicestatus LIKE '"+listForm.getSearchString4()+"'"	
						+ " order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();	

			query = session.createSQLQuery(queryString);
			query.addEntity("pihdr", Pihdr.class);
			query.addEntity("pidtl", Pidtl.class);			
			query.setMaxResults(listForm.getMaxResults());
			queryResult=query.list();

			// iterate results 			
			Iterator it = queryResult.iterator();
			while ( it.hasNext() ) {
				Object[] obj = (Object[]) it.next();
				Pihdr pihdr = (Pihdr) obj[0];
				Pidtl pidtl = (Pidtl) obj[1];

				PihdrdtlDTO _dto=new PihdrdtlDTO(pihdr, pidtl, this.getSessionFactoryClusterMap()); 
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

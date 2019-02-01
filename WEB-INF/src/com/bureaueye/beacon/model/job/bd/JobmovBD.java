package com.bureaueye.beacon.model.job.bd;

import java.util.Calendar;
import java.util.Date;
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

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;

import com.bureaueye.beacon.model.job.dao.JobmovDAO;
import com.bureaueye.beacon.model.job.Jobcost;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.dto.JobhdrmovDTO;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;
import com.bureaueye.beacon.model.job.dto.JobmovDemurrageDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.system.bd.SystemlogBD;



public final class JobmovBD extends BaseBD {
	
	
	// constructors
	public JobmovBD() {
	}
	public JobmovBD(SessionFactory _factory) {
		super(_factory);		
	}	
	public JobmovBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}
	public JobmovBD(SessionFactory _factory1, SessionFactory _factory2, SessionFactory _factory3) {
		super(_factory1, _factory2, _factory3);		
	}	
	public JobmovBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}
	
	
    private static final String DEFAULT_CLASS_NAME = Jobmov.class.getName();
    
	
	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Jobmov read(Object key)
	throws ApplicationException {
		
		if (key == null) return null;
		
		Jobmov dto = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.ROW_NOT_READ);			
		}
		
		
		try {
			
			dto = (Jobmov)session.get(Jobmov.class, (Integer)key);
			
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
			Jobmov _dto=(Jobmov)dto;
			
			Transaction tx = session.beginTransaction();
			
			if (read(_dto.getJobmovId()) != null) {
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
			Jobmov _dto=(Jobmov)dto;
			
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
		Jobmov dto = null;
		
		try {
			//_BaseRootDAO.initialize();
			dto = read(id);
			if (dto != null) {				
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
	public List findJobmovsById(String id, int gotoPage,
			int maxResults, String order, String order2) throws ApplicationException {
		
		List queryResult = null;
		List<JobmovDTO> queryResultDTO = new LinkedList<JobmovDTO>();
		
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
			.createCriteria(Jobmov.class)
			.add(Expression.eq("JobhdrId", new Integer(id)))
			.addOrder(Order.asc(order))
			.addOrder(Order.asc(order2))
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobmov _dao=(Jobmov)it.next();
				JobmovDTO _dto=new JobmovDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	
	
	public int findJobmovsTotalResults(String id)
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
			
			Query q = session.getNamedQuery(JobmovDAO.QUERY_FIND_JOBMOVS_TOTAL_RESULTS);
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
	
	
	public Jobmov findLastActualJobmovById(String jobhdrId) 
	throws ApplicationException {
		
		Jobmov queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Jobmov)session
			.createCriteria(Jobmov.class)
			.add(Expression.eq("JobhdrId", new Integer(jobhdrId)))
			.addOrder(Order.desc("Actfromtimeinmillis"))
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
	
	
	public Jobmov findLastJobmovByUnitId(String unitId) 
	throws ApplicationException {
		
		Jobmov queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Jobmov)session
			.createCriteria(Jobmov.class)
			.add(Expression.eq("UnitId", new Integer(unitId)))
			.addOrder(Order.desc("Actfromtimeinmillis"))
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
	
		
	public Jobmov findLastActualJobmovByUnitId(Integer unitId) 
	throws ApplicationException {	
		
		Jobmov queryResult=null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			Query q = session
			.createQuery("from Jobmov jobmov where jobmov.UnitId = :UnitId and jobmov.Actfromdate is not null order by jobmov.Actfromtimeinmillis desc");
			q.setParameter("UnitId", unitId);			
			queryResult=(Jobmov) (q.setMaxResults(1).uniqueResult());
			
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
	
	
	public Jobmov findJobmovByJobhdrIdSectionkey(String jobhdrId, String sectionkey) 
	throws ApplicationException {
		
		Jobmov queryResult = null;
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = (Jobmov)session
			.createCriteria(Jobmov.class)
			.add(Expression.eq("JobhdrId", new Integer(jobhdrId)))
			.add(Expression.eq("Sectionkey", sectionkey))
			.addOrder(Order.desc("Actfromtimeinmillis"))
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
	

	public List findJobmovsByJobhdrIdSectionkey(String jobhdrId, String sectionkey) 
	throws ApplicationException {
		
		List queryResult = null;
		List<JobmovDTO> queryResultDTO = new LinkedList<JobmovDTO>();
		
		
		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
			
			queryResult = session
			.createCriteria(Jobmov.class)
			.add(Expression.eq("JobhdrId", new Integer(jobhdrId)))
			.add(Expression.eq("Sectionkey", sectionkey))			
			.addOrder(Order.asc("Totimeinmillis"))
			.addOrder(Order.asc("Fromtimeinmillis"))
			.list();

			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				Jobmov _dao=(Jobmov)it.next();
				JobmovDTO _dto=new JobmovDTO(_dao, this.getSessionFactoryClusterMap()); 
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
	

	public List findJobmovsByKey3(
			String jobmovId,			
			String orderhdrId,
			String sectionkey,
			String fromlocationkey,
			String tolocationkey,
			String vendoraddrkey,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {
		
		List queryResult = null;
		List<JobhdrmovDTO> queryResultDTO = new LinkedList<JobhdrmovDTO>();
		
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
				"select new com.bureaueye.beacon.model.job.dto.JobhdrmovDTO(jobhdr, jobmov) "+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.job.Jobmov jobmov"
				+ " where jobhdr.JobhdrId = jobmov.JobhdrId"				
				+ " and jobhdr.OrderhdrId = "+orderhdrId
				+ " and jobmov.JobmovId <> "+jobmovId
				+ " and jobmov.Sectionkey = '"+sectionkey+"'"
				+ " and jobmov.Fromlocationkey = '"+fromlocationkey+"'"
				+ " and jobmov.Tolocationkey = '"+tolocationkey+"'"
				+ " and jobmov.Vendoraddrkey = '"+vendoraddrkey+"'"					
				+ " order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)			
			.list();

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				JobhdrmovDTO _dto=(JobhdrmovDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
						); 
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
						);
				_dto.setFromlocation(
						_locationBD.read(_dto.getFromlocationkey())
						);
				_dto.setTolocation(
						_locationBD.read(_dto.getTolocationkey())
						);
				_dto.setSection(
						_sectionBD.read(_dto.getSectionkey())
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
		
		return queryResultDTO;
	}	
	
		
		
		
	
	public List findJobmovsByKey4(Integer unitid, Date date1, Date date2) 
	throws ApplicationException {
		
		List queryResult = null;
		List<JobhdrmovDTO> queryResultDTO = new LinkedList<JobhdrmovDTO>();		
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
				"select  new com.bureaueye.beacon.model.job.dto.JobhdrmovDTO(orderhdr, jobhdr, jobmov)"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr,"+
				"      com.bureaueye.beacon.model.job.Jobhdr jobhdr,"+
				"      com.bureaueye.beacon.model.job.Jobmov jobmov"+
				" where"+
				"      orderhdr.Id = jobhdr.OrderhdrId"+
				"  and jobhdr.JobhdrId = jobmov.JobhdrId"+
				"  and jobmov.UnitId = '"+unitid+"'"+
				"  and (" +
				"	    (jobmov.Fromdate >= '"+dateFormatter.format(date1)+"' and jobmov.Fromdate <= '"+dateFormatter.format(date2)+"')"+
				"    or (jobmov.Todate >= '"+dateFormatter.format(date1)+"' and jobmov.Todate <= '"+dateFormatter.format(date2)+"')"+
				"    or (jobmov.Fromdate <= '"+dateFormatter.format(date1)+"' and jobmov.Todate >= '"+dateFormatter.format(date2)+"')" +
				"		)"+				
				" order by totimeinmillis asc, fromtimeinmillis asc";
			queryResult = session
			.createQuery(queryString)
			.list();

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());;
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				JobhdrmovDTO _dto=(JobhdrmovDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
						); 
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
						);
				_dto.setFromlocation(
						_locationBD.read(_dto.getFromlocationkey())
						);
				_dto.setTolocation(
						_locationBD.read(_dto.getTolocationkey())
						);
				_dto.setSection(
						_sectionBD.read(_dto.getSectionkey())
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
		
		return queryResultDTO;
	}
	

	public JobmovDTO findLastJobmovByKey4(Integer unitid, Date date) 
	throws ApplicationException {
		
		Jobmov queryResult = null;
		JobmovDTO queryResultDTO = new JobmovDTO();		
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
				"select jobmov"+
				" from Jobmov jobmov"
				+ " where"			
				+ " jobmov.UnitId = '"+unitid+"'"
				+ " and jobmov.Estfromdate <= '"+dateFormatter.format(date)+"'"	
				+ " order by Estfromdate desc, Esttodate desc";	
			queryResult = (Jobmov)session
			.createQuery(queryString)
			.setMaxResults(1).uniqueResult();			
	
			// TODO: iterate results to set many-to-one mappings 
			queryResultDTO=new JobmovDTO(queryResult, this.getSessionFactoryClusterMap()); 
				
			
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
	
	
	public List findJobmovsByKey5(
			String jobmovId,			
			String orderhdrId,
			String mmulink,
			int gotoPage,
			int maxResults, 
			String order) throws ApplicationException {
		
		List queryResult = null;
		List<JobhdrmovDTO> queryResultDTO = new LinkedList<JobhdrmovDTO>();

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
				"select new com.bureaueye.beacon.model.job.dto.JobhdrmovDTO(jobhdr, jobmov) "+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.job.Jobmov jobmov"
				+ " where jobhdr.JobhdrId = jobmov.JobhdrId"
				+ " and jobmov.Mmulink = '"+mmulink+"'"
				+ " and jobmov.Mmulink <> ''"
				+ " and jobhdr.OrderhdrId = "+orderhdrId
				+ " and jobmov.JobmovId <> "+jobmovId			
				+ " order by "+order;
			queryResult = session
			.createQuery(queryString)
			.setFirstResult(gotoPage * maxResults)
			.setMaxResults(maxResults)
			.list();

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				JobhdrmovDTO _dto=(JobhdrmovDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
						); 
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
						);
				_dto.setFromlocation(
						_locationBD.read(_dto.getFromlocationkey())
						);
				_dto.setTolocation(
						_locationBD.read(_dto.getTolocationkey())
						);
				_dto.setSection(
						_sectionBD.read(_dto.getSectionkey())
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
		
		return queryResultDTO;
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
			.createQuery("from Jobcost jobcost where jobcost.JobmovId = :JobmovId");
			q.setParameter("JobmovId", id);			
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
	

	public List findJobmovsForDemurrage(
			ListForm listForm
			) throws ApplicationException {
		
		List queryResult = null;
		List<JobmovDemurrageDTO> queryResultDTO = new LinkedList<JobmovDemurrageDTO>();

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(DEFAULT_CLASS_NAME).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}
		
		try {
	
/*			<sql-query name="personsWith">
		    <return alias="person" class="eg.Person"/>
		    <return-join alias="address" property="person.mailingAddress"/>
		    SELECT person.NAME AS {person.name},
		           person.AGE AS {person.age},
		           person.SEX AS {person.sex},
		           adddress.STREET AS {address.street},
		           adddress.CITY AS {address.city},
		           adddress.STATE AS {address.state},
		           adddress.ZIP AS {address.zip}
		    FROM PERSON person
		    JOIN ADDRESS adddress
		        ON person.ID = address.PERSON_ID AND address.TYPE='MAILING'
		    WHERE person.NAME LIKE :namePattern
		</sql-query>*/
		    
			String queryString = "";			
			SQLQuery query = null;
			queryString = 
						"select {jobmov1.*}, {jobmov2.*}, {jobhdr.*}, {orderhdr.*} from Jobmov jobmov1 " +
						"inner join Jobhdr jobhdr on jobmov1.Jobhdr_Id = jobhdr.Jobhdr_Id " +
						"inner join Orderhdr orderhdr on jobhdr.Orderhdr_Id = orderhdr.Orderhdr_Id " +
						"left outer join Jobmov jobmov2 on " +
						"	jobmov2.Jobhdr_Id = jobmov1.Jobhdr_Id AND " +
						"	jobmov2.Sectionkey = :endsection AND " +
						"	jobmov2.Actfromdate IS NOT NULL " +
						" where " +
						"jobmov1.Dmrgfinishflag = :finishflag " +
						" AND " +
						"jobmov1.Sectionkey = :startsection " +
						" AND " +
						"((jobmov1.Acttodate IS NOT NULL AND " +
						"  jobmov1.Acttodate <= :billupto) OR " +
						" (jobmov1.Lastdmrgtodate IS NOT NULL AND " +
						"  jobmov1.Lastdmrgtodate <= :billupto)) " +						
						" AND " +
						"orderhdr.Dmrgbilltoaddrkey LIKE :billto"
						
						;

			query = session.createSQLQuery(queryString);
			query.addEntity("jobmov1", Jobmov.class);
			query.addEntity("jobmov2", Jobmov.class);			
			query.addEntity("jobhdr", Jobhdr.class);
			query.addEntity("orderhdr", Orderhdr.class);
			query.setString("startsection", listForm.getSearchString10());
			query.setString("endsection", listForm.getSearchString11());				
			query.setString("finishflag", listForm.getSearchString12());
			query.setDate("billupto", listForm.getSearchDate2());
			query.setString("billto", listForm.getSearchString6());
			query.setFirstResult(listForm.getGotoPage() * listForm.getMaxResults());
			query.setMaxResults(listForm.getMaxResults());
			queryResult=query.list();

			// iterate results 			
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			Iterator it = queryResult.iterator();
			while ( it.hasNext() ) {
				Object[] obj = (Object[]) it.next();
				Jobmov jobmov1 = (Jobmov) obj[0];
				Jobmov jobmov2 = (Jobmov) obj[1];
				Jobhdr jobhdr = (Jobhdr) obj[2];
				Orderhdr orderhdr = (Orderhdr) obj[3];
				
				JobmovDemurrageDTO dto=new JobmovDemurrageDTO(jobmov1,jobmov2,jobhdr,orderhdr);
				
				//set dmrg bill to address - if blank default to order customer
				String dmrgbilltoaddrkey="";
				try {
					dmrgbilltoaddrkey=dto.getDmrgbilltoaddrkey().trim();
					if (dmrgbilltoaddrkey.equals("")) dmrgbilltoaddrkey=orderhdr.getCustomeraddrkey();
				} catch (Exception e) {
				}
				Address dmrgbilltoaddress = _addressBD.read(dmrgbilltoaddrkey);
				if (dmrgbilltoaddress==null) dmrgbilltoaddress=new Address();				
				dto.setDmrgbilltoaddr(dmrgbilltoaddress);
				dto.setDmrgbilltoaddrkey(dmrgbilltoaddrkey);
				
				// set demurrage specific fields
				dto.setDemurragePrintEndDate(listForm.getSearchDate2());
				dto.setDemurrageFields();
				dto.setDemurrageFieldsForLastdmrgtodate();
				dto.setDemurragePrintDays();
				dto.setDemurrageAmounts();
				
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
	

	public List<JobhdrmovDTO> findJobmovsForMmuByOrderjobs(
			String jobhdrId,
			String jobmovId,			
			String orderhdrId,
			String section,
			String vendor,
			String fromlocation,
			String tolocation,
			String searchstring5,
			String searchstring6,
			String vessel,
			String voyage			
			) throws ApplicationException {
		
		List queryResult = null;
		List<JobhdrmovDTO> queryResultDTO = new LinkedList<JobhdrmovDTO>();

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
				"select new com.bureaueye.beacon.model.job.dto.JobhdrmovDTO(jobhdr, jobmov) "+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.job.Jobmov jobmov"
				+ " where jobhdr.JobhdrId = jobmov.JobhdrId"
				+ " and jobhdr.OrderhdrId = "+orderhdrId				
				+ " and jobmov.Sectionkey LIKE '%"+section+"'"				
				+ " and jobmov.Vendoraddrkey LIKE '%"+vendor+"'"
				+ " and jobmov.Fromlocationkey LIKE '%"+fromlocation+"'"
				+ " and jobmov.Tolocationkey LIKE '%"+tolocation+"'"				
				//+ " and jobmov.JobhdrId <> "+jobhdrId	
				+ " and jobmov.JobmovId <> "+jobmovId			
				+ " order by jobhdr.Unitkey";
			queryResult = session
			.createQuery(queryString)
			.list();

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				JobhdrmovDTO _dto=(JobhdrmovDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
						); 
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
						);
				_dto.setFromlocation(
						_locationBD.read(_dto.getFromlocationkey())
						);
				_dto.setTolocation(
						_locationBD.read(_dto.getTolocationkey())
						);
				_dto.setSection(
						_sectionBD.read(_dto.getSectionkey())
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
		
		return queryResultDTO;
	}	
	

	
	
	public List findJobmovsForDashboard(
			ListForm listForm
			) 
	throws ApplicationException {
		
		List queryResult = null;
		List<JobhdrmovDTO> queryResultDTO = new LinkedList<JobhdrmovDTO>();		
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
				"select  new com.bureaueye.beacon.model.job.dto.JobhdrmovDTO(orderhdr, jobhdr, jobmov)"+
				" from com.bureaueye.beacon.model.order.Orderhdr orderhdr,"+
				"      com.bureaueye.beacon.model.job.Jobhdr jobhdr,"+
				"      com.bureaueye.beacon.model.job.Jobmov jobmov"+
				" where"+
				"      orderhdr.Id = jobhdr.OrderhdrId"+
				"  and jobhdr.JobhdrId = jobmov.JobhdrId"+
				"  and orderhdr.Orderbyuserid LIKE '"+listForm.getSearchString1()+"'"+
				"  and (jobmov.Actfromtimeinmillis = 0 or jobmov.Acttotimeinmillis = 0)"+				
				"  and (" +
				"	    jobmov.Estfromdate <= '"+dateFormatter.format(listForm.getSearchDate2())+"' or "+
				"	    jobmov.Esttodate <= '"+dateFormatter.format(listForm.getSearchDate2())+"'"+
				"		)"+				
				" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc()+", "+
				"          "+listForm.getOrderBy2()+" "+listForm.getOrderBy2Desc();
			queryResult = session
			.createQuery(queryString)
			.list();

			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());;
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				JobhdrmovDTO _dto=(JobhdrmovDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
						); 
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
						);
				_dto.setFromlocation(
						_locationBD.read(_dto.getFromlocationkey())
						);
				_dto.setTolocation(
						_locationBD.read(_dto.getTolocationkey())
						);
				_dto.setSection(
						_sectionBD.read(_dto.getSectionkey())
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
		
		return queryResultDTO;
	}
	

	
	
	
	
}

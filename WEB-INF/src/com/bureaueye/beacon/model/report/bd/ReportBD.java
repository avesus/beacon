package com.bureaueye.beacon.model.report.bd;


import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.report.ReportForm;
import com.bureaueye.beacon.form.report.ReportLocationinventoryForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.model.bd.BaseBD;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobhdrmovDTO;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.report.dto.BookingsailingDTO;
import com.bureaueye.beacon.model.report.dto.FasttrackDTO;
import com.bureaueye.beacon.model.report.dto.UnitMoveDTO;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;






public final class ReportBD  extends BaseBD {


	// constructors
	public ReportBD() {
	}
	public ReportBD(SessionFactory _factory) {
		super(_factory);		
	}
	public ReportBD(SessionFactory _factory1, SessionFactory _factory2) {
		super(_factory1, _factory2);		
	}	
	public ReportBD(Map<String, SessionFactory> sfcm) {
		super(sfcm);		
	}





	//-----------------------------------------------
	// CRUD METHODS
	//-----------------------------------------------
	public Object read(Object key)
	throws ApplicationException {
		Object dto = null;

		return dto;		
	}

	public void createOrUpdate(Object dto, User user)
	throws ApplicationException {		
	}



	public void delete(Object dto, User user) throws ApplicationException {
	}




	//-----------------------------------------------
	// FIND METHODS
	//-----------------------------------------------	
	public List findUnitMovesByDuedate(
			ListForm listForm	
	) throws ApplicationException {

		List queryResult = null;
		List<UnitMoveDTO> queryResultDTO = new LinkedList<UnitMoveDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}	
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}


		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobhdr.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.report.dto.UnitMoveDTO(jobhdr, jobmov, orderhdr)"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"	   com.bureaueye.beacon.model.job.Jobmov jobmov, "+
				"      com.bureaueye.beacon.model.order.Orderhdr orderhdr"+
				" where"+
				" jobhdr.JobhdrId = jobmov.JobhdrId and"+
				" jobhdr.OrderhdrId = orderhdr.Id and"+
				" jobhdr.Unitkey like '"+searchString1+"' and"+
				" jobmov.Movref like '"+searchString2+"' and"+
				" orderhdr.Customeraddrkey like '"+searchString3+"' and"+	
				" ((jobmov.Estfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Esttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Actfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Acttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'))"+				
				" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc()+","+
				"          "+listForm.getOrderBy2()+" "+listForm.getOrderBy2Desc();
			queryResult = session
			.createQuery(queryString)
			.list();

			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				UnitMoveDTO _dto=(UnitMoveDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
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
				_dto.setCustomeraddr(
						_addressBD.read(_dto.getCustomeraddrkey())
				);
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
				);
				queryResultDTO.add(_dto);
			}

			_locationBD=null;
			_sectionBD=null;
			_productBD=null;
			_addressBD=null;

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


	public List findUnitMoves(
			ListForm listForm	
	) throws ApplicationException {

		List queryResult = null;
		List<UnitMoveDTO> queryResultDTO = new LinkedList<UnitMoveDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}	
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "";
		}		

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobhdr.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.report.dto.UnitMoveDTO(jobhdr, jobmov, orderhdr)"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"	   com.bureaueye.beacon.model.job.Jobmov jobmov, "+
				"      com.bureaueye.beacon.model.order.Orderhdr orderhdr"+
				" where"+
				" jobhdr.JobhdrId = jobmov.JobhdrId and"+
				" jobhdr.OrderhdrId = orderhdr.Id and"+
				" jobhdr.Unitkey like '"+searchString1+"' and"+
				" jobmov.Movref like '"+searchString2+"' and"+
				" orderhdr.Customeraddrkey like '"+searchString3+"' and"+
				" ((jobmov.Estfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Esttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Actfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Acttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'))"+				
				" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc()+","+
				"          "+listForm.getOrderBy2()+" "+listForm.getOrderBy2Desc();
			queryResult = session
			.createQuery(queryString)
			.list();

			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				UnitMoveDTO dto=(UnitMoveDTO)it.next();
				if (!searchString4.equals("")) {				
					//if section not found in list continue to next record
					if (!searchString4.contains(dto.getSectionkey())) continue;
				}
				dto.setProduct(
						_productBD.read(dto.getProductkey())
				); 
				dto.setFromlocation(
						_locationBD.read(dto.getFromlocationkey())
				);
				dto.setTolocation(
						_locationBD.read(dto.getTolocationkey())
				);
				dto.setSection(
						_sectionBD.read(dto.getSectionkey())
				);				
				dto.setCustomeraddr(
						_addressBD.read(dto.getCustomeraddrkey())
				);
				dto.setVendoraddr(
						_addressBD.read(dto.getVendoraddrkey())
				);
				queryResultDTO.add(dto);
			}

			_locationBD=null;
			_sectionBD=null;
			_productBD=null;
			_addressBD=null;

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




	public List findUnitMovesByTxt(
			ListForm listForm	
	) throws ApplicationException {

		List queryResult = null;
		List<UnitMoveDTO> queryResultDTO = new LinkedList<UnitMoveDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}	
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}
		String searchString4 = listForm.getSearchString4();
		if (searchString4 == null || searchString4.equals("")) {
			searchString4 = "%";
		}		

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobhdr.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.report.dto.UnitMoveDTO(jobhdr, jobmov, orderhdr)"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"	   com.bureaueye.beacon.model.job.Jobmov jobmov, "+
				"      com.bureaueye.beacon.model.order.Orderhdr orderhdr"+
				" where"+
				" jobhdr.JobhdrId = jobmov.JobhdrId and"+
				" jobhdr.OrderhdrId = orderhdr.Id and"+
				" jobmov.Movref like '"+searchString2+"' and"+
				" orderhdr.Customeraddrkey like '"+searchString3+"' and"+
				" ((jobmov.Estfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Esttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Actfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Acttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'))"+
				" and "+
				" (jobmov.Txt2 like '%"+searchString1+"%' or "+
				"  jobmov.Txt3 like '%"+searchString1+"%') "+
				" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc()+","+
				"          "+listForm.getOrderBy2()+" "+listForm.getOrderBy2Desc();
			queryResult = session
			.createQuery(queryString)
			.list();

			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			// iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				UnitMoveDTO dto=(UnitMoveDTO)it.next();

				dto.setProduct(
						_productBD.read(dto.getProductkey())
				); 
				dto.setFromlocation(
						_locationBD.read(dto.getFromlocationkey())
				);
				dto.setTolocation(
						_locationBD.read(dto.getTolocationkey())
				);
				dto.setSection(
						_sectionBD.read(dto.getSectionkey())
				);				
				dto.setCustomeraddr(
						_addressBD.read(dto.getCustomeraddrkey())
				);
				dto.setVendoraddr(
						_addressBD.read(dto.getVendoraddrkey())
				);
				queryResultDTO.add(dto);
			}

			_locationBD=null;
			_sectionBD=null;
			_productBD=null;
			_addressBD=null;

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








	public List groupUnitMoves(
			ListForm listForm	
	) throws ApplicationException {

		List queryResult = null;
		List<UnitMoveDTO> queryResultDTO = new LinkedList<UnitMoveDTO>();		
		DateFormatter dateFormatter = new DateFormatter();

		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}	
		String searchString3 = listForm.getSearchString3();
		if (searchString3 == null || searchString3.equals("")) {
			searchString3 = "%";
		}


		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobhdr.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.report.dto.UnitMoveDTO(jobhdr, jobmov, orderhdr)"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, " +
				"	   com.bureaueye.beacon.model.job.Jobmov jobmov, "+
				"      com.bureaueye.beacon.model.order.Orderhdr orderhdr"+
				" where"+
				" jobhdr.JobhdrId = jobmov.JobhdrId and"+
				" jobhdr.OrderhdrId = orderhdr.Id and"+
				" jobhdr.Unitkey like '"+searchString1+"' and"+
				" orderhdr.Customeraddrkey like '"+searchString3+"' and"+					
				" ((jobmov.Estfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Esttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Actfromdate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"') or"+
				"  (jobmov.Acttodate between '"+dateFormatter.format(listForm.getSearchDate1())+"' and '"+dateFormatter.format(listForm.getSearchDate2())+"'))"+				
				" group by "+listForm.getOrderBy();
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



	public List fasttrack(
			ListForm listForm
	) throws ApplicationException {

		List queryResult = null;
		List<FasttrackDTO> lineitems = new LinkedList<FasttrackDTO>();

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Unit.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			queryResult = session
			.createCriteria(Unit.class)	
			.add(Expression.like("Unitkey", listForm.getSearchString1()))
			//.add(Expression.sql("Xinactive = '"+listForm.getSearchString2()+"'"))		
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

		try {
			if (queryResult != null) {
				for(Iterator it = queryResult.iterator(); it.hasNext();) {
					Unit unit = (Unit)it.next();	
					JobmovDTO jobmovdto = null;
					try {
						// TODO: get unit's latest movement details prior or equal to selected date
						jobmovdto = new JobmovBD().findLastJobmovByKey4(
								unit.getUnitId(),
								listForm.getSearchDate1()
						);
					} catch (ApplicationException ae) {					
						throw new ApplicationException(ApplicationException.LIST_FAILED);			
					}

					FasttrackDTO lineitem = new FasttrackDTO(unit, jobmovdto);
					lineitems.add(lineitem);

				}

			}
		} catch (ApplicationException ae) {						
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}		

		return lineitems;		

	}			







	public List timetrack(
			Integer unitId, 
			Date startdate,
			Date enddate
	) throws ApplicationException {

		List queryResultDTO = new LinkedList();
		List<FasttrackDTO> lineitems = new LinkedList<FasttrackDTO>();

		try {
			queryResultDTO  = new JobmovBD().findJobmovsByKey4(
					unitId,
					startdate,
					enddate
			);				
		} catch (ApplicationException ae) {					
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}


		if (queryResultDTO.size() > 0) {
			for(Iterator it2 = queryResultDTO.iterator(); it2.hasNext();) {
				JobhdrmovDTO _jobhdrmovdto = (JobhdrmovDTO)it2.next();

				FasttrackDTO lineitem = new FasttrackDTO(_jobhdrmovdto);
				lineitems.add(lineitem);
			}
		}	


		return lineitems;
	}






	public List findUnitMovesByVesselVoyage(
			ListForm listForm	
	) throws ApplicationException {

		List queryResult = null;
		List<UnitMoveDTO> queryResultDTO = new LinkedList<UnitMoveDTO>();		

		String searchString1 = listForm.getSearchString1();
		if (searchString1 == null || searchString1.equals("")) {
			searchString1 = "%";
		}	
		String searchString2 = listForm.getSearchString2();
		if (searchString2 == null || searchString2.equals("")) {
			searchString2 = "%";
		}


		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobhdr.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.report.dto.UnitMoveDTO(jobhdr, jobmov)"+
				" from com.bureaueye.beacon.model.job.Jobhdr jobhdr, com.bureaueye.beacon.model.job.Jobmov jobmov"+
				" where"+
				" jobhdr.JobhdrId = jobmov.JobhdrId and"+				
				" jobmov.Vessel like '"+searchString1+"' and"+	
				" jobmov.Voyage like '"+searchString2+"'"+					
				" order by "+listForm.getOrderBy()+" "+listForm.getOrderByDesc();
			queryResult = session
			.createQuery(queryString)
			.list();

			LocationBD _locationBD = new LocationBD(this.getSessionFactoryClusterMap());
			SectionBD _sectionBD = new SectionBD(this.getSessionFactoryClusterMap());
			ProductBD _productBD = new ProductBD(this.getSessionFactoryClusterMap());
			AddressBD _addressBD = new AddressBD(this.getSessionFactoryClusterMap());
			UnitBD _unitBD = new UnitBD(this.getSessionFactoryClusterMap());
			// TODO: iterate results to set many-to-one mappings 
			for (Iterator it = queryResult.iterator(); it.hasNext();) {
				UnitMoveDTO _dto=(UnitMoveDTO)it.next();
				_dto.setProduct(
						_productBD.read(_dto.getProductkey())
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
				_dto.setVendoraddr(
						_addressBD.read(_dto.getVendoraddrkey())
				);	
				_dto.setUnit(
						_unitBD.read(new Integer(_dto.getUnitId()))
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




	public List groupUnitsByLocation(
			ReportLocationinventoryForm reportForm
	) throws ApplicationException {

		List dtos = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Unit.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select " +
				" new com.bureaueye.beacon.model.report.dto.LocationinventoryDTO " +
				"	(location.Country, location.LocationName, unit.Jobmovlocationkey) "+
				" from com.bureaueye.beacon.model.standard.Unit unit, " +
				"      com.bureaueye.beacon.model.standard.Location location"+				
				" where"+
				" unit.Jobmovlocationkey = location.Locationkey";		

			// new code to select status and location type
			if (reportForm.getSearchString1()!=null && !reportForm.getSearchString1().equals(""))
				queryString=queryString+" AND location.Country='"+reportForm.getSearchString1()+"'";			
			if (!reportForm.getSearchString11().equals("ALL")) 
				queryString=queryString+" AND unit.Invsts ='"+reportForm.getSearchString11()+"'";		
			if (reportForm.getSearchString3()!=null && !reportForm.getSearchString3().equals(""))
				queryString=queryString+
				" AND unit.Xinactive='"+reportForm.getSearchString3()+"'";

			queryString=queryString+" group by "+reportForm.getGroupBy();	

			dtos = session.createQuery(queryString).list();			

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

		return dtos;
	}


	public List groupUnitsByStatus(
			ReportLocationinventoryForm reportForm
	) throws ApplicationException {

		List dtos = null;

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Unit.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select " +
				" new com.bureaueye.beacon.model.report.dto.LocationinventoryDTO " +
				"	(unit.Invsts) "+
				" from com.bureaueye.beacon.model.standard.Unit unit, " +
				"      com.bureaueye.beacon.model.standard.Location location"+				
				" where"+
				" unit.Jobmovlocationkey = location.Locationkey";		

			// new code to select status and location type
			if (reportForm.getSearchString1()!=null && !reportForm.getSearchString1().equals(""))
				queryString=queryString+" AND location.Country='"+reportForm.getSearchString1()+"'";			
			if (!reportForm.getSearchString11().equals("ALL")) 
				queryString=queryString+" AND unit.Invsts ='"+reportForm.getSearchString11()+"'";			
			if (reportForm.getSearchString3()!=null && !reportForm.getSearchString3().equals(""))
				queryString=queryString+
				" AND unit.Xinactive='"+reportForm.getSearchString3()+"'";

			queryString=queryString+" group by "+reportForm.getGroupBy();

			dtos = session.createQuery(queryString).list();			

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


		return dtos;
	}


	public List countUnits(
			ReportLocationinventoryForm reportForm	
	) throws ApplicationException {

		List dtos = null;
		List dtos2 = new LinkedList();

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Unit.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {


			String queryString = "";
			queryString = 
				"select " +
				" new com.bureaueye.beacon.model.report.dto.LocationinventoryDTO(location.Country, location.LocationName, unit.Jobmovlocationkey, unit.Invsts, CONCAT('',count(*))) "+
				" from com.bureaueye.beacon.model.standard.Unit unit, " +
				"	   com.bureaueye.beacon.model.standard.Location location"+				
				" where"+
				" unit.Jobmovlocationkey = location.Locationkey";	

			// new code to select status and location type
			if (reportForm.getSearchString1()!=null && !reportForm.getSearchString1().equals(""))
				queryString=queryString+" AND location.Country='"+reportForm.getSearchString1()+"'";			
			if (!reportForm.getSearchString11().equals("ALL")) 
				queryString=queryString+" AND unit.Invsts ='"+reportForm.getSearchString11()+"'";

			if (reportForm.getSearchString3()!=null && !reportForm.getSearchString3().equals(""))
				queryString=queryString+
				" AND unit.Xinactive='"+reportForm.getSearchString3()+"'";

			queryString=queryString+" group by "+reportForm.getGroupBy();		

			dtos = session.createQuery(queryString).list();			

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


		return dtos;
	}


	public List getUnits(
			ReportLocationinventoryForm reportForm	
	) throws ApplicationException {

		List dtos = null;
		List dtos2 = new LinkedList();

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Unit.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {

			String queryString = "";
			queryString = 
				"select new com.bureaueye.beacon.model.report.dto.LocationinventoryDTO "+
				" (location.Country, location.LocationName, unit.Jobmovlocationkey, unit.Invsts, unit.Invsts, unit.Imokey, unit.Unitkey, CONCAT('',unit.Capusg), CONCAT('',unit.Tare), unit.Moveref) "+ 				
				" from com.bureaueye.beacon.model.standard.Unit unit, " +
				"      com.bureaueye.beacon.model.standard.Location location"+				
				" where"+
				" unit.Jobmovlocationkey = location.Locationkey";	

			if (reportForm.getSearchString3()!=null && !reportForm.getSearchString3().equals(""))
				queryString=queryString+
				" AND unit.Xinactive='"+reportForm.getSearchString3()+"'";

			if (reportForm.getSearchString5()!=null) { 

				// generate key fields
				StringTokenizer tokenizer = new StringTokenizer(reportForm.getSearchString5(),"|");
				String _key1 = "";
				String _key2 = "";
				String _key3 = "";
				try {_key1 = tokenizer.nextToken();} catch (Exception e) {}
				try {_key2 = tokenizer.nextToken();} catch (Exception e) {}

				if (reportForm.getSearchString4()!=null && reportForm.getSearchString4().equals("key1")) {
					queryString=queryString+
					" AND location.Country='"+_key1+"'";
				}	
				if (reportForm.getSearchString4()!=null && reportForm.getSearchString4().equals("key2")) {
					queryString=queryString+
					" AND location.Country='"+_key1+"'"+
					" AND unit.Jobmovlocationkey='"+_key2+"'";
				}
				if (reportForm.getSearchString4()!=null && reportForm.getSearchString4().equals("key3")) {
					try {_key3 = tokenizer.nextToken();} catch (Exception e) {}
					queryString=queryString+
					" AND location.Country='"+_key1+"'"+
					" AND unit.Jobmovlocationkey='"+_key2+"'"+
					" AND unit.Invsts='"+_key3+"'";	
				}
			}

			queryString=queryString+" order by "+
			reportForm.getOrderBy()+" "+
			reportForm.getOrderByDesc();		

			dtos = session.createQuery(queryString).list();			

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


		return dtos;
	}




	public List bookingsailingSummaryQuery(
			ReportForm reportForm
	) throws ApplicationException {

		List<BookingsailingDTO> queryResultDTO = new LinkedList<BookingsailingDTO>();

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobmov.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {
			String sql=
				"select new com.bureaueye.beacon.model.report.dto.BookingsailingDTO(" +
					reportForm.getHeaderInfo1()+//select					
					") "+					
				"from Orderhdr orderhdr, Jobhdr jobhdr, Jobmov jobmov, Location location, Systemcode department "+
				"where " +
					"jobhdr.OrderhdrId = orderhdr.Id AND "+
					"jobmov.JobhdrId = jobhdr.JobhdrId AND "+					
					"jobmov.Sectionkey = '"+reportForm.getHeaderInfo4()+"' AND "+
					"jobmov.Fromlocationkey = location.Locationkey AND "+
					"department.Id.Typekey = 'DEPARTMENT' AND department.Id.Codekey = orderhdr.Departmentkey "+					
					reportForm.getHeaderInfo2()+//where							
				reportForm.getHeaderInfo3()//group by
				;				
			Query q = session.createQuery(sql);		
			queryResultDTO=q.list();

		} catch (HibernateException e) {				
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		} catch (Exception e) {								
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



	public List bookingsailingDetailQuery(
			ReportForm reportForm
	) throws ApplicationException {

		List<BookingsailingDTO> queryResultDTO = new LinkedList<BookingsailingDTO>();

		// get Session 
		Session session = null;
		try {
			session = this.getSessionFactoryClusterByClass(Jobmov.class.getName()).openSession();
		} catch (HibernateException e) {
			throw new ApplicationException(ApplicationException.LIST_FAILED);			
		}

		try {
			String sql=
				"select new com.bureaueye.beacon.model.report.dto.BookingsailingDTO(" +
				"unit.Unitkey, "+
				"jobhdr.Jobno, "+
				"orderhdr.Orderno, "+				
				"customer.Name, " +
				"jobmov.Fromg1key, " +	
				"jobmov.Tog1key, " +
				"jobmov.Fromg2key, " +				
				"jobmov.Tog2key, " +
				"fromlocation.PortUnicon, " +					
				"tolocation.PortUnicon, " +
				"fromlocation.LocationName, " +				
				"tolocation.LocationName, " +			
				"jobmov.Estfromdate, " +
				"jobmov.Actfromdate, " +
				"orderhdr.Orderdate, " +
				"orderhdr.Id, " +
				"jobhdr.JobhdrId " +				
					") "+					
				"from Orderhdr orderhdr, " +
				"Location fromlocation, " +
				"Location tolocation, " +
				"Address customer," +
				"Unit unit, " +
				"Systemcode department, "+
				"Jobhdr jobhdr, "+
				"Jobmov jobmov "+				
				"where " +
					"jobhdr.OrderhdrId = orderhdr.Id AND "+
					"jobmov.JobhdrId = jobhdr.JobhdrId AND "+					
					"jobmov.Sectionkey = '"+reportForm.getHeaderInfo4()+"' and "+
					"jobmov.Fromlocationkey = fromlocation.Locationkey and "+
					"jobmov.Tolocationkey = tolocation.Locationkey and "+
					"jobmov.UnitId = unit.UnitId and "+					
					"orderhdr.Customeraddrkey = customer.Addrkey AND "+	
					"department.Id.Typekey = 'DEPARTMENT' AND department.Id.Codekey = orderhdr.Departmentkey "+					
					reportForm.getHeaderInfo2()+//where							
				" order by "+reportForm.getOrderBy()+" "+reportForm.getOrderByDesc()
				;				
			Query q = session.createQuery(sql);		
			queryResultDTO=q.list();

		} catch (HibernateException e) {				
			throw new ApplicationException(ApplicationException.LIST_FAILED);
		} catch (Exception e) {								
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

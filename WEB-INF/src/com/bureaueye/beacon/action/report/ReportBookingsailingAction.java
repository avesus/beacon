package com.bureaueye.beacon.action.report;




import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;



import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.LabelValue;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.report.ReportForm;
import com.bureaueye.beacon.formatter.DateFormatter;


import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.report.Reportusage;
import com.bureaueye.beacon.model.report.bd.ReportBD;
import com.bureaueye.beacon.model.report.bd.ReportusageBD;
import com.bureaueye.beacon.model.report.dto.BookingsailingDTO;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.system.bd.SystemXBD;
import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;
import com.bureaueye.beacon.util.Util;






/**
 *
 * Amendments
 * ----------
 *	
 *									
 */
public final class ReportBookingsailingAction extends BaseAction {



	private static MessageResources resources = MessageResources
	.getMessageResources(com.bureaueye.beacon.bean.Constants.APPLICATION_RESOURCES);


	private static HSSFWorkbook wb;



	private static String numberOfWeeks = "5";
	private static String numberOfMonths = "3";
	private static String countryFilter = "COUNTRY";
	private static String departmentFilter = "DEPARTMENT";
	private static String jobType = "0";




	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {



		ReportForm reportForm = (ReportForm) form;
		String _action = reportForm.getSearchString10();

		DecimalFormat _df = new DecimalFormat("00");
		DateFormatter _dateformatter = new DateFormatter();		



		// If the session has timed-out then take the user back to the login page
		HttpSession _session = request.getSession(false);
		if (
				(_session == null) || 
				(_session.getAttribute(Constants.USER_KEY) == null)
		) {
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
			" Session has timed out");
			return mapping.findForward("welcome");
		}

		User _user = (User)_session.getAttribute(Constants.USER_KEY);


		// if first time in for session then update report usage
		if (reportForm.getSearchString10().equals("init")) {
			// reset to first time in 
			_action=null;

			GregorianCalendar _datecal = new GregorianCalendar();
			_datecal.setTime(new Date());
			_datecal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);


			// if first time default country to display ALL
			if (reportForm.getSearchString1()==null) {
				reportForm.setSearchString1("ALL");
			}
			// if first time default department to display ALL
			if (reportForm.getSearchString2()==null) {
				reportForm.setSearchString2("ALL");
			}
			// if first time default to current year
			if (reportForm.getSearchString3()==null) {
				reportForm.setSearchString3(_datecal.get(Calendar.YEAR)+"");
			}
			// if first time default to current week
			if (reportForm.getSearchString4()==null) {
				reportForm.setSearchString4(_datecal.get(Calendar.WEEK_OF_YEAR)+"");
			}
			// if first time default number of weeks to display
			if (reportForm.getSearchString5()==null) {
				reportForm.setSearchString5(numberOfWeeks);
			}
			// if first time default job type
			if (reportForm.getSearchString6()==null) {
				reportForm.setSearchString6(jobType);
			}
			// if first time default number of months to display
			if (reportForm.getSearchString7()==null) {
				reportForm.setSearchString7(numberOfMonths);
			}
			// if first time default filter to DEPARTMENT
			if (reportForm.getSearchString8()==null) {
				reportForm.setSearchString8(departmentFilter);
			}
			reportForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);


			log.info(
					"["+this.getClass().getName()+"] "+
					new java.util.Date()+" "+
					"_datecal.getTime()["+_datecal.getTime()+"]: "+					
					"_datecal.get(Calendar.YEAR)["+_datecal.get(Calendar.YEAR)+"]: "+
					"_datecal.get(Calendar.WEEK_OF_YEAR)["+_datecal.get(Calendar.WEEK_OF_YEAR)+"]: "+
					"_datecal.getTimeZone()["+_datecal.getTimeZone().toString()+"]"
			);


		}


		//init bd
		SystemmappingcodeBD systemmappingcodebd=new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		SystemXBD systembd=new SystemXBD(this.getSessionFactoryClusterMap());
		ReportBD reportbd=new ReportBD(this.getSessionFactoryClusterMap());
		CcyexBD ccyexbd=new CcyexBD(this.getSessionFactoryClusterMap());
		OrderhdrBD orderhdrbd=new OrderhdrBD(this.getSessionFactoryClusterMap());
		OrderchargeBD orderchargebd=new OrderchargeBD(this.getSessionFactoryClusterMap());
		JobhdrBD jobhdrbd=new JobhdrBD(this.getSessionFactoryClusterMap());
		JobcostBD jobcostbd=new JobcostBD(this.getSessionFactoryClusterMap());		



		// retrieve section mapping for SHIP
		String shipSection = "";
		try{shipSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "SHIP").getCompanycode();}catch(Exception e){}
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" findSystemmappingcode: " +
				" shipSection="+shipSection		
		);
		reportForm.setHeaderInfo4(shipSection);

		// retrieve base ccy
		String baseCcy = "";
		try{baseCcy = systembd.findSystem().getCcykey();}catch(Exception e){}
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
				" Base Currency="+baseCcy		
		);
		reportForm.setHeaderInfo5(baseCcy);


		String securityLevel = _user.getSecuritylevel();


		// if first time in or button refreshed pressed
		if (
				request.getParameter("refreshButton.x") != null 
				|| _action==null
		) {
			_action = "refresh";
			reportForm.setSearchString10(_action);			
		}

		// set report date fields
		int _reportyear = 0;		
		try{_reportyear =  new Integer(reportForm.getSearchString3().trim()).intValue();} catch (NullPointerException npe){}			
		int _reportweek = 0; 
		try{_reportweek =  new Integer(reportForm.getSearchString4().trim()).intValue();} catch (NullPointerException npe){}		
		String _reportyearweek = _reportyear+_df.format(_reportweek);

		Date _reportdate = null;		
		GregorianCalendar _reportdatecal = new GregorianCalendar();		
		try {
			_reportdatecal.set(Calendar.YEAR, _reportyear);
			_reportdatecal.set(Calendar.WEEK_OF_YEAR, _reportweek);
			_reportdatecal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);				
			_reportdate = _reportdatecal.getTime();
		} catch (Exception e) {
		}


		log.info(
				"["+this.getClass().getName()+"] "+
				new java.util.Date()+" "+
				"_reportdate["+_reportdate+"]"					
		);


		// set country
		String _countryfilter = "";		
		try {_countryfilter = reportForm.getSearchString1().trim();} catch (NullPointerException npe) {}	
		// set department
		String _departmentfilter = "";		
		try {_departmentfilter = reportForm.getSearchString2().trim();} catch (NullPointerException npe) {}	
		// set number of weeks to display
		int _numberofweeks = 0; 	
		try{_numberofweeks = new Integer(reportForm.getSearchString5().trim()).intValue();} catch (NullPointerException npe){}				
		// set number of months to display
		int _numberofmonths = 0; 	
		try{_numberofmonths = new Integer(reportForm.getSearchString7().trim()).intValue();} catch (NullPointerException npe){}	
		// set number of months to display
		String _filter = ""; 	
		try{_filter = reportForm.getSearchString8().trim();} catch (NullPointerException npe){}





		try {  


			// process summary action
			if (_action.equals("refresh")) {


				// update report usage
				log.info("["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"report usage["+_user.getUserid()+"]"
				);			
				Reportusage reportusage = new Reportusage();
				reportusage.setActivitykey(_user.getActvid());
				reportusage.setCompanykey(_user.getCompid());
				reportusage.setDepartmentkey(_user.getDeptid());
				reportusage.setReportid(this.getClass().getName());
				reportusage.setUserid(_user.getUserid());
				reportusage.setSessionid(_session.getId());
				reportusage.setPriceid("050");
				reportusage.setReportquery(reportForm.toString());
				new ReportusageBD(this.getSessionFactoryClusterMap()).createOrUpdate(reportusage, _user);
				reportusage=null;




				// set base sql statement
				String _where1 = "";
				String _select = "";
				String _groupby = "";				
				if (_filter.equals(countryFilter)) { 	
					_select="jobmov.Fromg1key, CONCAT('',count(*))";					
					if (!_countryfilter.equals("ALL")) {
						_where1=" AND jobmov.Fromg1key = '"+_countryfilter+"' ";					
					}
					_groupby=" group by jobmov.Fromg1key";
				}
				if (_filter.equals(departmentFilter)) { 
					_select="department.Descr, CONCAT('',count(*))";					
					if (!_departmentfilter.equals("ALL")) {						
						_where1=" AND orderhdr.Departmentkey = '"+_departmentfilter+"' ";
					}
					_groupby=" group by orderhdr.Departmentkey";
				}				


				log.info(
						"["+this.getClass().getName()+"] "+
						new java.util.Date()+" "+
						"reportForm.toString["+reportForm.toString()+"]"
				);		



				Hashtable _ht = new Hashtable();
				TreeMap _rows = new TreeMap();
				List _columns = new LinkedList();
				List _totals = new LinkedList();



				// init calendars
				Calendar _vdatecal = Calendar.getInstance();				
				_vdatecal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

				Calendar _vdateWeekCal = Calendar.getInstance();
				_vdateWeekCal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				_vdateWeekCal.setTime(_reportdate);



				// output sums
				// process weeks============================================================>	
				for (int i = 0; i < _numberofweeks; i++) {

					// set year week
					_vdatecal.setTime(_reportdate);
					_vdatecal.add(Calendar.WEEK_OF_YEAR, -1*i);
					int _weekofyear = _vdatecal.get(Calendar.WEEK_OF_YEAR);					
					int _year = _vdatecal.get(Calendar.YEAR);
					if (_weekofyear==1) _year=_reportyear;
					String _yearweek = _year+_df.format(_weekofyear);


					// JOBS CREATED IN WEEK 
					String _where2=_where1+" AND (orderhdr.Orderdate between '"+_dateformatter.format(_vdatecal.getTime())+"' AND '"+_dateformatter.format(this.getWeekEndDate(_vdatecal.getTime()))+"') ";				

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					List queryResult=reportbd.bookingsailingSummaryQuery(reportForm);				

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"WEEK PROCESS: _yearweek["+_yearweek+"] "+
							"_vdatecal["+_vdatecal.getTime()+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"							
					);

					Iterator it = queryResult.iterator();
					while ( it.hasNext() ) {
						BookingsailingDTO obj = (BookingsailingDTO) it.next();									
						String _country = obj.getKey();
						String _sum = obj.getCount()+"";
						String _key = "WEEK|"+_year+"|"+_weekofyear+"|"+obj.getKey();
						try{_rows.put(_country,new LabelValue(_country.toUpperCase(),_country.toUpperCase()));}catch(Exception e){}	
						_ht.put(_key,new LabelValue(_where2,_sum));											
					} // 		

				} // weeks loop
				// week start date
				Date _weekStartdate = _vdatecal.getTime();



				// process months============================================================>		
				for (int i = 0; i < _numberofmonths; i++) {							

					// set year week
					_vdatecal.setTime(_reportdate);
					_vdatecal.add(Calendar.MONTH,i); 
					int _month = _vdatecal.get(Calendar.MONTH)+1;
					int _year = _vdatecal.get(Calendar.YEAR);


					// JOBS CREATED IN MONTH AND PROJECTED TO SAIL IN MONTH	
					String _where2=_where1+
					//" AND (orderhdr.Orderdate between '"+_dateformatter.format(_vdatecal.getTime())+"' and '"+_dateformatter.format(this.getWeekEndDate(_vdatecal.getTime()))+"') "+
					" AND " +
					"(YEAR(orderhdr.Orderdate) = '"+_year+"' AND "+
					" MONTH(orderhdr.Orderdate) = '"+_month+"')"+						
					" AND (" +
					"(YEAR(jobmov.Estfromdate) = '"+_year+"' AND "+
					" MONTH(jobmov.Estfromdate) = '"+_month+"' AND "+
					" jobmov.Actfromdate is null)"+
					" OR "+
					"(YEAR(jobmov.Actfromdate) = '"+_year+"' AND "+
					" MONTH(jobmov.Actfromdate) = '"+_month+"')"+	
					")";
					;

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					List queryResult=reportbd.bookingsailingSummaryQuery(reportForm);					

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"MONTH PROCESS[0]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"								
					);

					Iterator it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();									
						String _country = obj.getKey();
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|"+_country+"|0";			
						try{_rows.put(_country,new LabelValue(_country.toUpperCase(),_country.toUpperCase()));}catch(Exception e){}
						_ht.put(_key,new LabelValue(_where2,_sum));						
					} 				



					// ACTUALLY SAILED IN MONTH OUT OF THE PROJECTED					
					_where2=_where1+
					" AND YEAR(jobmov.Actfromdate) = '"+_year+"' AND "+
					"     MONTH(jobmov.Actfromdate) = '"+_month+"' ";	

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					queryResult=reportbd.bookingsailingSummaryQuery(reportForm);						

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"MONTH PROCESS[1]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"								
					);

					it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();								
						String _country = obj.getKey();
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|"+_country+"|1";								
						try{_rows.put(_country,new LabelValue(_country.toUpperCase(),_country.toUpperCase()));}catch(Exception e){}	
						_ht.put(_key,new LabelValue(_where2,_sum));							
					} //



					// PROJECTED TO SAIL IN MONTH
					_where2=_where1+
					" AND (" +
					"  	(YEAR(jobmov.Estfromdate) = '"+_year+"' AND "+
					" 	MONTH(jobmov.Estfromdate) = '"+_month+"' AND "+
					" 	jobmov.Actfromdate is null)"+	
					" 	OR "+
					"	(YEAR(jobmov.Actfromdate) = '"+_year+"' AND "+
					" 	MONTH(jobmov.Actfromdate) = '"+_month+"')"+	
					" )";

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					queryResult=reportbd.bookingsailingSummaryQuery(reportForm);						

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"MONTH PROCESS[2]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"							
					);	

					it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();									
						String _country = obj.getKey();
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|"+_country+"|2";
						try{_rows.put(_country,new LabelValue(_country.toUpperCase(),_country.toUpperCase()));}catch(Exception e){}	
						_ht.put(_key,new LabelValue(_where2,_sum));						
					} // 



					// ESTIMATED TO SAIL IN MONTH
					_where2=_where1+
					" AND (" +
					"  	YEAR(jobmov.Estfromdate) = '"+_year+"' AND "+
					" 	MONTH(jobmov.Estfromdate) = '"+_month+"' AND "+
					" 	jobmov.Actfromdate is null"+
					" )";

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					queryResult=reportbd.bookingsailingSummaryQuery(reportForm);						

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"MONTH PROCESS[3]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"							
					);	

					it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();									
						String _country = obj.getKey();
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|"+_country+"|3";
						try{_rows.put(_country,new LabelValue(_country.toUpperCase(),_country.toUpperCase()));}catch(Exception e){}	
						_ht.put(_key,new LabelValue(_where2,_sum));						
					} // 



				} // months loop





				// output totals for drill-down
				_select = "CONCAT('',count(*))";
				_groupby = "";

				// process weeks============================================================>	
				_vdatecal = Calendar.getInstance();				
				_vdatecal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				for (int i = 0; i < _numberofweeks; i++) {

					// set year week
					_vdatecal.setTime(_weekStartdate);
					_vdatecal.add(Calendar.WEEK_OF_YEAR, 1*i);

					int _weekofyear = _vdatecal.get(Calendar.WEEK_OF_YEAR);					
					int _year = _vdatecal.get(Calendar.YEAR);
					if (_weekofyear==1) _year=_reportyear;
					String _yearweek = _year+_df.format(_weekofyear);


					String _columnValue = " WEEK "+_df.format(_weekofyear)+" "+_year+" Bookings";
					String _columnKey = "WEEK|"+_year+"|"+_weekofyear;				
					// process if current
					if (
							_weekofyear==_reportweek && 
							_year==_reportyear
					) {
						_columnValue=_columnValue+" - Current";
					}

					_columns.add(new LabelValue(_columnKey,_columnValue));


					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"WEEK COLUMN LABEL PROCESS: "+
							"columnkey["+_columnKey+"]: "+
							"columnvalue["+_columnValue+"]: "+
							"numberofweeks["+_numberofweeks+"]: "+
							"i["+i+"] "
					);



					String _where2=_where1+
					" AND (orderhdr.Orderdate between '"+_dateformatter.format(_vdatecal.getTime())+"' AND '"+_dateformatter.format(this.getWeekEndDate(_vdatecal.getTime()))+"') ";				

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					List queryResult=reportbd.bookingsailingSummaryQuery(reportForm);				

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"TOTAL WEEK PROCESS: _yearweek["+_yearweek+"] "+
							"_vdatecal["+_vdatecal.getTime()+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"							
					);

					Iterator it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();								
						String _sum = obj.getCount()+"";
						String _key = "WEEK|"+_year+"|"+_weekofyear;
						_ht.put(_key,new LabelValue(_where2,_sum));											
					} 			

				} // weeks loop
				// week start date



				// process months============================================================>		
				for (int i = 0; i < _numberofmonths; i++) {							

					// set year week
					_vdatecal.setTime(_reportdate);
					_vdatecal.add(Calendar.MONTH,i); 
					int _month = _vdatecal.get(Calendar.MONTH)+1;
					int _year = _vdatecal.get(Calendar.YEAR);


					String _columnValue = Util.dateTextFormat3(_vdatecal.getTime());
					String _columnKey = "MONTH|"+_year+"|"+_month;					
					if (
							_vdatecal.get(Calendar.MONTH)==_reportdatecal.get(Calendar.MONTH) && 
							_vdatecal.get(Calendar.YEAR)==_reportdatecal.get(Calendar.YEAR)
					) {
						_columnValue=_columnValue+" - Current";
					}					
					_columns.add(new LabelValue(_columnKey,_columnValue));


					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"MONTH COLUMN LABEL PROCESS: "+
							"columnkey["+_columnKey+"] "+
							"columnvalue["+_columnValue+"] "+
							"numberofmonths["+_numberofmonths+"] "+
							"i["+i+"] "
					);



					// JOBS CREATED IN MONTH AND PROJECTED TO SAIL IN MONTH				
					String _where2=_where1+
					//" and (orderhdr.Orderdate between '"+_dateformatter.format(_vdatecal.getTime())+"' and '"+_dateformatter.format(this.getWeekEndDate(_vdatecal.getTime()))+"') "+
					" AND " +
					"(YEAR(orderhdr.Orderdate) = '"+_year+"' AND "+
					" MONTH(orderhdr.Orderdate) = '"+_month+"')"+					
					" AND (" +
					"(YEAR(jobmov.Estfromdate) = '"+_year+"' AND "+
					" MONTH(jobmov.Estfromdate) = '"+_month+"' AND "+
					" jobmov.Actfromdate is null)"+
					" OR "+
					"(YEAR(jobmov.Actfromdate) = '"+_year+"' AND "+
					" MONTH(jobmov.Actfromdate) = '"+_month+"')"+	
					")";
					;				

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					List queryResult=reportbd.bookingsailingSummaryQuery(reportForm);	

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"TOTAL MONTH PROCESS[0]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"								
					);

					Iterator it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();	
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|0";
						_ht.put(_key,new LabelValue(_where2,_sum));						
					} // 				



					// SAILED IN MONTH OUT OF PROJECTED			
					_where2=_where1+
					" AND YEAR(jobmov.Actfromdate) = '"+_year+"' AND "+
					"     MONTH(jobmov.Actfromdate) = '"+_month+"' ";	

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					queryResult=reportbd.bookingsailingSummaryQuery(reportForm);						

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"TOTAL MONTH PROCESS[1]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"								
					);

					it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();	
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|1";
						_ht.put(_key,new LabelValue(_where2,_sum));							
					} // 



					// PROJECTED TO SAIL IN MONTH
					_where2=_where1+
					" AND (" +
					"  	(YEAR(jobmov.Estfromdate) = '"+_year+"' AND "+
					" 	MONTH(jobmov.Estfromdate) = '"+_month+"' AND "+
					" 	jobmov.Actfromdate is null)"+	
					" 	OR "+
					"	(YEAR(jobmov.Actfromdate) = '"+_year+"' AND "+
					" 	MONTH(jobmov.Actfromdate) = '"+_month+"')"+	
					" )";

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					queryResult=reportbd.bookingsailingSummaryQuery(reportForm);						

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"TOTAL MONTH PROCESS[2]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"							
					);	

					it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();			
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|2";
						_ht.put(_key,new LabelValue(_where2,_sum));						
					} // 


					// ESTIMATED TO SAIL IN MONTH
					_where2=_where1+
					" AND (" +
					"  	YEAR(jobmov.Estfromdate) = '"+_year+"' AND "+
					" 	MONTH(jobmov.Estfromdate) = '"+_month+"' AND "+
					" 	jobmov.Actfromdate is null"	+
					")";

					reportForm.setHeaderInfo1(_select);
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3(_groupby);					
					queryResult=reportbd.bookingsailingSummaryQuery(reportForm);						

					log.info(
							"["+this.getClass().getName()+"] "+
							new java.util.Date()+" "+
							"TOTAL MONTH PROCESS[3]: "+
							"_year["+_year+"] "+
							"_month["+_month+"] "+
							"_select["+_select+"] "+
							"_where1["+_where1+"] "+
							"_where2["+_where2+"] "+
							"_groupby["+_groupby+"] "+
							"["+queryResult.size()+"]"							
					);	

					it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();			
						String _sum = obj.getCount()+"";
						String _key = "MONTH|"+_year+"|"+_month+"|3";
						_ht.put(_key,new LabelValue(_where2,_sum));	
					} // 



				} // months loop
				// output totals for drill-down	



				reportForm.setList(_columns);
				reportForm.setList2(_totals);
				reportForm.setTm2(_rows);				
				reportForm.setHt1(_ht);



				// default to summary view
				_action = "summary";
				reportForm.setSearchString10(_action);

			} //refresh






			// process detail view------------------------------------------------->
			// - check count value is not zero
			// - do not process if zero
			if (
					_action.equals("detail") && 
					!reportForm.getSearchString14().equals("0")
			) {



				// listform used for find exchange rates
				ListForm listForm = new ListForm();
				listForm.setOrderBy("Exdate");
				listForm.setOrderByDesc("Desc");


				List _details = new LinkedList();
				// set query statements


				String _where2 = "";
				try{_where2 = reportForm.getSearchString12();} catch (NullPointerException npe){}	

				String _detailKey = "";				
				try{_detailKey = reportForm.getSearchString11();} catch (NullPointerException npe){}				
				String key1 = "";
				String key2 = "";
				String key3 = "";
				String key4 = "";
				String key5 = "";				
				java.util.StringTokenizer _st = new java.util.StringTokenizer(_detailKey, "|");				
				try {
					key1 = _st.nextToken();
					key2 = _st.nextToken();
					key3 = _st.nextToken();
					key4 = _st.nextToken();
					key5 = _st.nextToken();					
				} catch (Exception e) {
				}


				try {

					//get report ROW where clause - g1code or department
					//check filter type and not totals drill-down
					if (_filter.equals(countryFilter) && !key5.equals("")) {
						_where2=_where2+" AND jobmov.Fromg1key = '"+key4+"' ";
					}
					if (_filter.equals(departmentFilter) && !key5.equals("")) {
						_where2=_where2+" AND department.Descr = '"+key4+"' ";
					}
					



					reportForm.setHeaderInfo1("");
					reportForm.setHeaderInfo2(_where2);
					reportForm.setHeaderInfo3("");					
					List queryResult=reportbd.bookingsailingDetailQuery(reportForm);					

					Iterator it = queryResult.iterator();
					while ( it.hasNext() ) {						
						BookingsailingDTO obj = (BookingsailingDTO) it.next();								

						obj.setNumberoftanks(1);

						//find order
						Orderhdr orderhdr = orderhdrbd.read(obj.getOrderhdrId());						
						if (orderhdr!=null) {
							//find number of units
							int numberOfUnits = 0;
							try{numberOfUnits = orderhdrbd.getOrderjobscount(obj.getOrderhdrId().toString());}catch(Exception e){}

							//init charges
							BigDecimal totalCharge= new BigDecimal(0.00);
							BigDecimal unitCharge = new BigDecimal(0.00);
							// retrieve cost total					
							try{totalCharge = orderchargebd.orderchargesChgamtbaseTotal(obj.getOrderhdrId().toString());}catch(Exception e){}
							unitCharge=totalCharge.divide(new BigDecimal(numberOfUnits));

							obj.setRevenue(unitCharge.floatValue());
							obj.setRateccykey(orderhdr.getCcykey());
						}

						//find job
						Jobhdr jobhdr = jobhdrbd.read(obj.getJobhdrId());						
						if (jobhdr!=null) {						
							//init total costs
							BigDecimal totalCost = new BigDecimal(0.00);	
							// retrieve cost total					
							try{totalCost = jobcostbd.jobcostsCstamtbaseTotal(obj.getJobhdrId().toString());} catch (Exception e) {}
							obj.setQuohdrcosttotal(totalCost.floatValue());
							obj.setQuohdrccykey(orderhdr.getCcykey());						
						}


						//calculate gross proift
						obj.setGrossprofit(obj.getRevenue()-obj.getQuohdrcosttotal());


						// calculate base currency totals
						// get currency exchange rate
						double ReportXrate = 1;
						listForm.setSearchString2(baseCcy);
						listForm.setSearchDate1(new Date());
						try {
							if (
									!obj.getRateccykey().equals(baseCcy) && 
									obj.getRevenue() != 0
							) {
								listForm.setSearchString1(obj.getRateccykey());
								ReportXrate = ccyexbd.getExrate(listForm);
							}
							obj.setRevenuebase(new Float(obj.getRevenue()*ReportXrate));
						} catch (Exception e) { 
						}						

						ReportXrate = 1;
						try {
							if (
									!obj.getQuohdrccykey().equals(baseCcy) && 
									obj.getGrossprofit() != 0
							) {
								listForm.setSearchString1(obj.getQuohdrccykey());
								ReportXrate = ccyexbd.getExrate(listForm);
							}
							obj.setGrossprofitbase(new Float(obj.getGrossprofit()*ReportXrate));
						} catch (Exception e) { 
						}



						_details.add(obj);											

					} //loop	

				} catch (Exception ae) {					
				}	

				reportForm.setLineItems(_details,0);	

				// default to detail view
				_action = "detail";
				reportForm.setSearchString10(_action);
			} // detail			



		}	
		catch (Exception e) {
			log.error(
					"["+this.getClass().getName()+"] "+	new java.util.Date()+" "+
					"Exception: "+e.getMessage()
			);
		}	  




		//clear bd
		systemmappingcodebd=null;
		systembd=null;
		reportbd=null;
		orderchargebd=null;
		orderhdrbd=null;
		ccyexbd=null;
		jobhdrbd=null;
		jobcostbd=null;



		// button summary export pressed
		if (
				request.getParameter("exportSummaryButton.x") != null 
		) {		
			// output to Excel spreadsheet
			response.setContentType("application/vnd.ms-excel");

			doSummaryToExcel(reportForm, securityLevel);
			// default to summary view
			_action = "summary";
			reportForm.setSearchString10(_action);
			// Write the output to a file
			wb.write(response.getOutputStream());

			return null;
		}
		// button detail export pressed
		if (
				request.getParameter("exportDetailButton.x") != null 
		) {		
			// output to Excel spreadsheet
			response.setContentType("application/vnd.ms-excel");

			doDetailToExcel(reportForm);
			// default to summary view
			_action = "detail";
			reportForm.setSearchString10(_action);
			// Write the output to a file
			wb.write(response.getOutputStream());

			return null;
		}





		// Initialise page forward
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to '"+_action+"' page: "
				+ mapping.findForward(_action).getPath());			
		return mapping.findForward(_action);

	}



	private Date getWeekEndDate(Date _date1) {
		Date _date2 = new Date();
		try {
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(_date1);
			cal2.add(Calendar.WEEK_OF_YEAR,1);
			cal2.add(Calendar.DATE,-1);
			_date2=cal2.getTime();
		} catch (Exception e) {
		}
		return _date2;
	}



	private void doDetailToExcel(ReportForm reportForm) {

		try {
			DecimalFormat _df = new DecimalFormat("0.00");			
			wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Detail Report");

			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

			// Create label column row 
			HSSFRow row = sheet.createRow((short)0);

			// Create a cell and put a value in it.
			row.createCell((short)0).setCellValue("Job Number");   
			row.createCell((short)1).setCellValue("Customer");   
			row.createCell((short)2).setCellValue("Port of Loading");			
			row.createCell((short)3).setCellValue("Port of Destination");   
			row.createCell((short)4).setCellValue("Number of Tanks");   
			row.createCell((short)5).setCellValue("Total Revenue");     
			row.createCell((short)6).setCellValue("Gross Profit");   


			int count = 1;
			//float revenueAverage = 0;//201000028
			//float grossprofitAverage = 0;//201000028
			float revenueBaseAverage = 0;//201000028
			float grossprofitBaseAverage = 0;//201000028
			int numberoftanksTotal = 0;
			float revenueTotal = 0;
			float grossprofitTotal = 0;
			float revenueBaseTotal = 0;//201000028
			float grossprofitBaseTotal = 0;//201000028
			int shipmentsCount = 0;       
			Iterator it = reportForm.getLineItems(0).iterator();
			while (it.hasNext()) {

				BookingsailingDTO _lineItem = (BookingsailingDTO) it.next(); 

				try {     

					if (_lineItem != null) {

						// Create label column row 
						HSSFRow row2 = sheet.createRow((short)count);

						// Create a cells			
						row2.createCell((short)0).setCellValue(_lineItem.getJobno());
						row2.createCell((short)1).setCellValue(_lineItem.getCustomer());  
						row2.createCell((short)2).setCellValue(_lineItem.getPolname());   
						row2.createCell((short)3).setCellValue(_lineItem.getPodname());   						     	     
						row2.createCell((short)4).setCellValue(_lineItem.getNumberoftanks());
						row2.createCell((short)5).setCellValue(_df.format(_lineItem.getRevenue())+" "+_lineItem.getRateccykey());
						row2.createCell((short)6).setCellValue(_df.format(_lineItem.getGrossprofit())+" "+_lineItem.getQuohdrccykey());//201000028

						numberoftanksTotal=numberoftanksTotal + _lineItem.getNumberoftanks();
						revenueTotal=revenueTotal + _lineItem.getRevenue();
						grossprofitTotal=grossprofitTotal + _lineItem.getGrossprofit();
						revenueBaseTotal=revenueBaseTotal + _lineItem.getRevenuebase();//201000028
						grossprofitBaseTotal=grossprofitBaseTotal + _lineItem.getGrossprofitbase();//201000028
						shipmentsCount=shipmentsCount + 1;     

						count++;

					} // _lineItem not null
				}
				catch (Exception e) {
				}

			} // list loop

			// total row

			// Create label column row 
			HSSFRow row3 = sheet.createRow((short)count);			
			// Create a cells			
			row3.createCell((short)0).setCellValue("Total (USD)");//201000028  						     	     
			row3.createCell((short)4).setCellValue(numberoftanksTotal);
			//row3.createCell((short)5).setCellValue(_df.format(revenueTotal));//201000028
			//row3.createCell((short)6).setCellValue(_df.format(grossprofitTotal));//201000028
			row3.createCell((short)5).setCellValue(_df.format(revenueBaseTotal));//201000028
			row3.createCell((short)6).setCellValue(_df.format(grossprofitBaseTotal));//201000028

			count++;

			//revenueAverage=revenueTotal / shipmentsCount;//200900028  
			//grossprofitAverage=grossprofitTotal / shipmentsCount;//200900028  
			//revenueAverage=revenueTotal / numberoftanksTotal;//200900022 
			//grossprofitAverage=grossprofitTotal / numberoftanksTotal;//200900022  
			revenueBaseAverage=revenueBaseTotal / numberoftanksTotal;//200900028  
			grossprofitBaseAverage=grossprofitBaseTotal / numberoftanksTotal;//200900028 

			// Create label column row 
			HSSFRow row4 = sheet.createRow((short)count);			
			// Create a cells			
			//row4.createCell((short)0).setCellValue("Average per Shipment");//200900022  
			row4.createCell((short)0).setCellValue("Average per Tank (USD)");//200900022   
			//row4.createCell((short)5).setCellValue(_df.format(revenueAverage));//201000028
			//row4.createCell((short)6).setCellValue(_df.format(grossprofitAverage));//201000028
			row4.createCell((short)5).setCellValue(_df.format(revenueBaseAverage));//201000028
			row4.createCell((short)6).setCellValue(_df.format(grossprofitBaseAverage));//201000028



		}
		catch (Exception e) {}

	} 


	private void doSummaryToExcel(ReportForm reportForm, String securityLevel) {

		try {

			wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Summary Report");

			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

			int _rowcount=0;
			int _colcell=0;

			// Create label column row 
			HSSFRow row = sheet.createRow((short)_rowcount);
			row.createCell((short)_colcell).setCellValue(" ");
			_colcell=_colcell+1;			



			//			get columns header list
			java.util.List _list1 = reportForm.getList();
			for (java.util.Iterator it1 = _list1.iterator(); it1.hasNext();) {
				com.bureaueye.beacon.bean.LabelValue _columnHeader = (com.bureaueye.beacon.bean.LabelValue)it1.next();

				row.createCell((short)_colcell).setCellValue(_columnHeader.getValue());
				_colcell=_colcell+1;
				java.util.StringTokenizer _st = new java.util.StringTokenizer(_columnHeader.getLabel(), "|");	
				String _period = "";
				try {_period = _st.nextToken();} catch (Exception e) {}

				//				special process for Current month
				if (_period.equals("MONTH") && _columnHeader.getValue().indexOf("Current")>0) {

					row.createCell((short)_colcell).setCellValue(_columnHeader.getValue()+" Sailed");
					_colcell=_colcell+1;				

					row.createCell((short)_colcell).setCellValue(_columnHeader.getValue()+" Projected");
					_colcell=_colcell+1;

				}//current month

			}//column header list loop

			_rowcount++;		

			java.util.Hashtable _ht1 = (java.util.Hashtable)reportForm.getHt1();
			//			get rows map
			java.util.TreeMap _tm2 = (java.util.TreeMap)reportForm.getTm2();
			for (java.util.Iterator it2 = _tm2.keySet().iterator(); it2.hasNext();) {
				java.lang.Object _tm2key = (java.lang.Object)it2.next();	
				com.bureaueye.beacon.bean.LabelValue _labelvalue2 =	(com.bureaueye.beacon.bean.LabelValue)_tm2.get(_tm2key);

				// Create new row 
				_colcell=0;				
				// Create label column row 
				HSSFRow row2 = sheet.createRow((short)_rowcount);

				row2.createCell((short)_colcell).setCellValue(_labelvalue2.getValue());
				_colcell=_colcell+1;


				//				get columns hashtable
				java.util.List _list2 = reportForm.getList();
				for (java.util.Iterator it3 = _list2.iterator(); it3.hasNext();) {
					com.bureaueye.beacon.bean.LabelValue _columnDetail = (com.bureaueye.beacon.bean.LabelValue)it3.next();
					String _key=_columnDetail.getLabel()+"|"+_tm2key;

					java.util.StringTokenizer _st = new java.util.StringTokenizer(_columnDetail.getLabel(), "|");	
					String _period = "";
					try {_period = _st.nextToken();} catch (Exception e) {}

					if (_period.equals("WEEK")) {		
						//						get sums hash table
						int _sum0=0;
						try{
							com.bureaueye.beacon.bean.LabelValue _labelvalue4 = (com.bureaueye.beacon.bean.LabelValue)_ht1.get(_key);
							java.lang.Float _sum1=new java.lang.Float(_labelvalue4.getValue());
							_sum0=_sum1.intValue();
						}catch(Exception e){}					

						row2.createCell((short)_colcell).setCellValue(_sum0);
						_colcell=_colcell+1;

					} // WEEK PROCESS

					if (_period.equals("MONTH")) {		

						int[] _sum0=new int[10]; 
						String[] _key2=new String[10];
						String[] _sql0=new String[10];
						//						loop 3 totals for each month
						for (int i = 0; i <= 2; i++) {

							_key2[i]=_key+"|"+i;
							//							get sums hash table
							try{
								com.bureaueye.beacon.bean.LabelValue _labelvalue5 = (com.bureaueye.beacon.bean.LabelValue)_ht1.get(_key2[i]);
								java.lang.Float _sum1=new java.lang.Float(_labelvalue5.getValue());
								_sum0[i]=_sum1.intValue();
								_sql0[i]=_labelvalue5.getLabel();
							}catch(Exception e){}

						} //loop 3 totals for each month

						int _dif = _sum0[2] - _sum0[1];
						row2.createCell((short)_colcell).setCellValue(_sum0[0]+" ("+_dif+")");
						_colcell=_colcell+1;


						//						special process for Current month
						if (_columnDetail.getValue().indexOf("Current")>0) {

							row2.createCell((short)_colcell).setCellValue(_sum0[1]);
							_colcell=_colcell+1;

							row2.createCell((short)_colcell).setCellValue(_sum0[2]);
							_colcell=_colcell+1;

						}// special process for current month

					} // MONTH PROCESS

				} // column loop

				_rowcount++;

			} // row loop


			_colcell=0;
			// Create label column row 
			HSSFRow row3 = sheet.createRow((short)_rowcount);

			row3.createCell((short)_colcell).setCellValue("Total");
			_colcell=_colcell+1;
			//			get columns total list
			java.util.List _list2 = reportForm.getList2();
			for (java.util.Iterator it2 = _list2.iterator(); it2.hasNext();) {
				com.bureaueye.beacon.bean.LabelValue _columnHeader = (com.bureaueye.beacon.bean.LabelValue)it2.next();				

				row3.createCell((short)_colcell).setCellValue(_columnHeader.getValue()+"");
				_colcell=_colcell+1;

			}//column list loop







		}
		catch (Exception e) {}

	} 



}

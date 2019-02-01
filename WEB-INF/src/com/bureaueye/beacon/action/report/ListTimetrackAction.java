package com.bureaueye.beacon.action.report;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.report.bd.ReportBD;
import com.bureaueye.beacon.model.report.dto.FasttrackDTO;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Unittest;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.standard.bd.UnittestBD;
import com.bureaueye.beacon.util.Util;


public final class ListTimetrackAction extends ListAction {
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Unitkey");
		}			
		listForm.setOrderByDesc("desc");
		
		// unitkey
		//if (listForm.getSearchString1() == null || listForm.getSearchString1().equals("")) {
		//	listForm.setSearchString1("%");
		//}
		// inactive 
		if (listForm.getSearchString2() == null || listForm.getSearchString2().equals("")) {
			listForm.setSearchString2("N");
		}
		// plus days
		//if (listForm.getMaxResults() == 0) {
		//listForm.setMaxResults(5);
		//}
		
		
		
	}
	
	public ActionMessages setLineItems(ListForm listForm)
	throws ApplicationException {
		
		
		if (listForm.getSearchString1()==null) {
			listForm.setSearchString1("%");
		}
		
		
		Calendar c = Calendar.getInstance();
		//  date 'from'
		if (listForm.getSearchDate1() == null) {
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {}					
		} else	c.setTime(listForm.getSearchDate1());
		
		//  increment by next/previous page		
		c.add(Calendar.DATE, (listForm.getGotoPage()*listForm.getMaxResults()));
		listForm.setSearchDate1(c.getTime());
		// reset gotopage
		listForm.setGotoPage(0);
		
		
		//  date 'to'		
		c.add(Calendar.DATE, new Integer(listForm.getMaxResults()).intValue()-1);
		try {
			listForm.setSearchDate2(c.getTime());
		} catch (Exception e) {}
		
		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" listForm.toString() = " + listForm.toString());
		
		List units = new LinkedList();
		List<FasttrackDTO> lineitems = new LinkedList<FasttrackDTO>();
		units = new UnitBD(this.getSessionFactoryClusterMap()).findUnitsByKey1(listForm);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" units.size() = " + units.size());
		
		
		// set selected start and end dates to maximum time in 
		// year, month, day, hour and minutes
		Calendar cal = Calendar.getInstance();
		Calendar starttime = Calendar.getInstance();
		Calendar endtime = Calendar.getInstance();
		cal.setTime(listForm.getSearchDate1());
		// set time to start of searchdate1 [00:00:00]
		starttime.set(
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH),
				00,
				00,
				00
		);
		//	set time to end of searchdate2 [23:59:00]
		cal.setTime(listForm.getSearchDate2());
		endtime.set(
				cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_MONTH),
				23,
				59,
				59
		);
		
		int colsTOT = 0;
		
		// retreive movements for each unit
		for(Iterator it = units.iterator(); it.hasNext();) {
			Unit unit = (Unit)it.next();
			List dtos = null;
			Unittest unittest = null;
			
			try {
				// TODO: get test details
				unittest = new UnittestBD(this.getSessionFactoryClusterMap()).getNextUnittestDue(unit.getUnitId());
			} catch (ApplicationException ae) {}
			
			try {
				// TODO: get 
				dtos = new ReportBD(this.getSessionFactoryClusterMap()).timetrack(
						unit.getUnitId(),
						listForm.getSearchDate1(),
						listForm.getSearchDate2()
				);
			} catch (ApplicationException ae) {}
			
			if (dtos.size() > 0) {				
				FasttrackDTO lineitem = null;
				Iterator it2 = dtos.iterator();
				boolean nextDTO = true; 
				int colsDTO = 0;
				int cols = 0;
				colsTOT = 0;
				Calendar fromtime = Calendar.getInstance();
				Calendar totime = Calendar.getInstance();
				Calendar processtime = Calendar.getInstance();
				processtime.setTime(starttime.getTime());
				
				while (true) {
					
					if (nextDTO) {
						
						fromtime.setTime(endtime.getTime());
						totime.setTime(endtime.getTime());
						
						// init from and to movement times
						if (it2.hasNext()) {
							lineitem = (FasttrackDTO)it2.next();

							cal.setTime(lineitem.getFromdate());								
							int hour = 00;
							int minute = 00;
							int second = 00;
							try{hour=new Integer(lineitem.getFromtime().substring(0,2)).intValue();}catch(Exception e){}
							try{minute=new Integer(lineitem.getFromtime().substring(3,2)).intValue();}catch(Exception e){}
							//if (hour == 00) {hour = 12;}
							
							fromtime.set(
									cal.get(Calendar.YEAR),
									cal.get(Calendar.MONTH),
									cal.get(Calendar.DAY_OF_MONTH),
									hour,
									minute,
									second
							);
							
							cal.setTime(lineitem.getTodate());						
							hour = 00;
							minute = 00;
							second = 00;
							try{hour=new Integer(lineitem.getTotime().substring(0,2)).intValue();}catch(Exception e){}
							try{minute=new Integer(lineitem.getTotime().substring(3,2)).intValue();}catch(Exception e){}							
							if (hour == 00) {
								hour = 23;
								minute = 59;
								second = 59;
							}
							totime.set(
									cal.get(Calendar.YEAR),
									cal.get(Calendar.MONTH),
									cal.get(Calendar.DAY_OF_MONTH),
									hour,
									minute,
									second
							);	
							
							
							// check days for movement before start time 
							if (fromtime.before(starttime)) lineitem.setPreviousflag("<");
							// check days for movement after end time 						
							if (totime.after(endtime)) lineitem.setNextflag(">");

							
							// set test information
							if (unittest != null) {
								lineitem.setTestduedate(unittest.getDuedate());
								lineitem.setTesttype(unittest.getTesttypekey());
								Calendar _90days = Calendar.getInstance();
								_90days.setTime(listForm.getSearchDate1());
								_90days.add(Calendar.DATE,90);
								Calendar _30days = Calendar.getInstance();
								_30days.setTime(listForm.getSearchDate1());
								_30days.add(Calendar.DATE,30);
								if (unittest.getDuedate().before(starttime.getTime())) lineitem.setTestflag("1");
								else
									if (unittest.getDuedate().before(_30days.getTime())) lineitem.setTestflag("2");
									else 
										if (unittest.getDuedate().before(_90days.getTime())) lineitem.setTestflag("3");
										else
											lineitem.setTestflag("");									
							}
							
						}
						
//						reset store values
						nextDTO=false;
						colsDTO = 0;
						cols = 0;
					}
					
					
					if (
							processtime.after(fromtime) 
							|| processtime.getTime().equals(fromtime.getTime())
					) {					
						colsDTO++;
						// store dummy movement cols and reset
						if (cols > 0) {
							FasttrackDTO lineitemdummy = new FasttrackDTO();
							try{BeanUtils.copyProperties(lineitemdummy, lineitem);}catch(Exception e){}
							lineitemdummy.setColspan(cols);
							lineitemdummy.setJobmovId("dummy");
							lineitems.add(lineitemdummy);
							cols=0;	
						}
					} else cols++;
					
					colsTOT++;

					
					// increment processtime by one hour
					processtime.add(Calendar.HOUR,1);
//					process time is after the latest movement estimate to time
//					read next record
					if (
							processtime.after(totime) 
							||	processtime.getTime().equals(totime.getTime()) 
							||	!endtime.after(processtime)
					) {
						// store DTO movement cols 
						if (colsDTO > 0) {
							lineitem.setColspan(colsDTO);
							lineitems.add(lineitem);
						}
						nextDTO=true;
					}
					
					if (!endtime.after(processtime)) break;
				} //end of loop
				
			} //movements found
			
		} // loop units
		
		// set header details to dates
		String dates = "";
		while (endtime.after(starttime)) {
			if (listForm.getMaxResults() <= 10) {
				if (dates.equals("")) dates = Util.dateTextFormat2(starttime.getTime());
				else dates = dates+"|"+Util.dateTextFormat2(starttime.getTime());
			}
			if (listForm.getMaxResults() > 10 && listForm.getMaxResults() <= 15) {
				if (dates.equals("")) dates = Util.dateTextFormat4(starttime.getTime());
				else dates = dates+"|"+Util.dateTextFormat4(starttime.getTime());
			}
			if (listForm.getMaxResults() >= 20) {
				if (dates.equals("")) dates = Util.dateTextFormat5(starttime.getTime());
				else dates = dates+"|"+Util.dateTextFormat5(starttime.getTime());
			}
			starttime.add(Calendar.DATE,1);
		}
		listForm.setHeaderInfo2(dates);
		listForm.setHeaderInfo1(new Integer(colsTOT).toString());		
		listForm.setLineItems(lineitems);
		
		return null;
	}
}

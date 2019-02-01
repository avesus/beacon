package com.bureaueye.beacon.action.report;





import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
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

import com.bureaueye.beacon.exception.ApplicationException;

import com.bureaueye.beacon.form.report.ReportLocationinventoryForm;
import com.bureaueye.beacon.model.report.bd.ReportBD;
import com.bureaueye.beacon.model.report.dto.LocationinventoryDTO;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.LocationBD;



/**
 *
 * Notes
 * ----------
 * ITT-200901-0002 Inventory Report Project
 *  										
 */


/**
 *
 * Amendments
 * ----------
 *									
 */
public final class ReportLocationinventoryAction extends BaseAction {
	
	
	private static HSSFWorkbook wb;
	
	private static MessageResources resources = MessageResources
	.getMessageResources(com.bureaueye.beacon.bean.Constants.APPLICATION_RESOURCES);
	
	
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		
		
		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		
		
		ReportLocationinventoryForm reportForm = (ReportLocationinventoryForm) form;
		String _action = reportForm.getSearchString10();
		
		// specail code to retrive multiple movement status selection
/*		String[] searchmovsts = new String[10];
		try {
			searchmovsts[0] = reportForm.getSearchString11();//request.getParameterValues("movsts");
			reportForm.setSearchArray1( searchmovsts );
			if (searchmovsts[0]!=null) reportForm.setSearchString11(searchmovsts[0]);
		} catch (Exception e) {}	*/	
		
		
		
		// if first time in for session then update report usage
		if (_action.equals("init")) {
			// reset to first time in and status
			_action=null;
		}
		
		
		
		
		// if first time in or button refreshed pressed
		if (
				request.getParameter("refreshButton.x") != null 
				|| _action==null
		) {
			_action = "refresh";
			reportForm.setSearchString10(_action);			
		}
		
		
		if (reportForm.getSearchString1()==null) {
			reportForm.setSearchString1("");
		}	
		// if first time default to active 
		if (reportForm.getSearchString2()==null) {
			reportForm.setSearchString2(com.bureaueye.beacon.bean.Constants.AVAILABLE_INVSTS);
		}		
		// if first time default to active 
		if (reportForm.getSearchString3()==null) {
			reportForm.setSearchString3("N");
		}
		// if first time default to ALL 
		if (reportForm.getSearchString11()==null) {
			reportForm.setSearchString11("ALL");
		}		
		// if first time default to resource message variable 
		if (reportForm.getGroupByX()==null) {
			reportForm.setGroupByX(resources.getMessage("reportlocationinventory.groupByX"));
		}
		// if first time default to resource message variable 
		if (reportForm.getGroupByY()==null) {
			reportForm.setGroupByY(resources.getMessage("reportlocationinventory.groupByY"));
		}
		// if first time default to resource message variable 
		if (reportForm.getGroupByHt()==null) {
			reportForm.setGroupByHt(resources.getMessage("reportlocationinventory.groupByHt"));
		}		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  action: "+_action);
		
		
		// process summary action
		if (_action.equals("refresh")) {
			
			
			
			
			// x-axis process - retrieve tank's current country location and location id to build x-axis labels
			List _dtosX = null;		
			List _listX = new LinkedList();	
			reportForm.setGroupBy("location.Country, location.LocationName, unit.Jobmovlocationkey");
			try {
				_dtosX = new ReportBD().groupUnitsByLocation(reportForm);
			} catch (ApplicationException ae) {}
			Iterator _itX = _dtosX.iterator();
			while (_itX.hasNext()) {
				LocationinventoryDTO _dto = (LocationinventoryDTO)_itX.next();
				String _key =
					_dto.getLocationcountry().toUpperCase() + "|" +
					_dto.getLocationid().toUpperCase();
				String _label = _key;
				try {
					Location _location = new LocationBD().read(_dto.getLocationid());
					String _locationcountry = _location.getCountry().toUpperCase();
					if (_locationcountry.equals("")) _locationcountry = "???"; 
					_label = _locationcountry+"|"+
					_location.getLocationName().toUpperCase()+" ["+_location.getLocationType().toUpperCase()+"]";	
				} catch (Exception e) {}
				_listX.add(new LabelValue(_label,_key));					
			}
			reportForm.setInventoryX(_listX);		
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Summary: _listX.size: "+_listX.size());
			
			
			// y-axis process - retrieve tank's current statuses to build y-axis labels 
			List _listY = new LinkedList();
			TreeMap _tmY = new TreeMap();
			List _dtosY = null;	
			String _tmYkey = "";
			String _tmYlabel = "";
			reportForm.setGroupBy("unit.Invsts");
			try {
				_dtosY = new ReportBD().groupUnitsByStatus(reportForm);
			} catch (ApplicationException ae) {}				
			Iterator _itY = _dtosY.iterator();
			while (_itY.hasNext()) {
				LocationinventoryDTO _dto = (LocationinventoryDTO)_itY.next();
				if (!_tmYkey.equals(_dto.getStatus())) {
					_tmYkey=_dto.getStatus();
					_tmYlabel=_dto.getStatus();
					_listY = new LinkedList();					
				}
				String _key = 
					_dto.getStatus().toUpperCase();
				String _label = _dto.getStatus().toUpperCase();				
				_listY.add(new LabelValue(_label,_key));				
				_tmY.put(_tmYlabel,_listY);
			}
			reportForm.setInventoryY(_listY);
			reportForm.setInventoryY1(_tmY);
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Summary: _listY.size: "+_listY.size());
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Summary: _tmY.size: "+_tmY.size());			
			
			
			
			// matrix process - count tanks by country, location and status
			Hashtable _ht = new Hashtable();	
			List _dtosXY = null;	
			reportForm.setGroupBy("location.Country, location.LocationName, unit.Jobmovlocationkey, unit.Invsts");
			try {
				_dtosXY = new ReportBD().countUnits(reportForm);
			} catch (ApplicationException ae) {}
			Iterator _itXY = _dtosXY.iterator();
			while (_itXY.hasNext()) {
				LocationinventoryDTO _dto = (LocationinventoryDTO)_itXY.next();				
				_ht.put(_dto.getKey(), _dto);
			}
			reportForm.setInventoryHt(_ht);	
			
			
			
	
			
			
			
			// default to summary view
			_action = "summary";
			reportForm.setSearchString10(_action);
		}
		
		
		// process detail view
		if (_action.equals("detail")) {
			List _list = new LinkedList();			
			try {
				
				_list = new ReportBD().getUnits(reportForm);
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" Detail: _list.size: "+_list.size());
				
			} catch (ApplicationException ae) {
			}	
			
			reportForm.setList(_list);	
		}
		
		
		
		
		// button summary export pressed
		if (
				request.getParameter("exportSummaryButton.x") != null 
		) {		
			// output to Excel spreadsheet
			response.setContentType("application/vnd.ms-excel");
			
			doSummaryToExcel(reportForm);
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
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  reportForm.toString(): "+reportForm.toString());
		
		
		
		// Initialise page forward
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to '"+_action+"' page: "
				+ mapping.findForward(_action).getPath());			
		return mapping.findForward(_action);
		
		//return findSuccess(mapping);
	}
	
	
	
	public void doDetailToExcel(ReportLocationinventoryForm reportForm) {
		
		try {
			
			wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Inventory Detail Report");
			
			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
			
			// Create label column row 
			HSSFRow row = sheet.createRow((short)0);
			
			// Create a cell and put a value in it.
			row.createCell((short)0).setCellValue("Unit Number");   
			row.createCell((short)1).setCellValue("Location");   
			row.createCell((short)2).setCellValue("Status");   
			row.createCell((short)3).setCellValue("IMO");       
			row.createCell((short)4).setCellValue("Capacity");   
			row.createCell((short)5).setCellValue("Tare Weight");   
			row.createCell((short)6).setCellValue("Active");
			
			int count = 1;
			Iterator it = reportForm.getList().iterator();
			while (it.hasNext()) {
				
				LocationinventoryDTO _lineItem = (LocationinventoryDTO) it.next(); 
				
				try {     
					
					if (_lineItem != null) {
						
						// Create label column row 
						HSSFRow row2 = sheet.createRow((short)count);
						
						// Create a cells			
						row2.createCell((short)0).setCellValue(_lineItem.getTanknumber());
						row2.createCell((short)1).setCellValue(_lineItem.getLocationname().toUpperCase());  
						row2.createCell((short)2).setCellValue(_lineItem.getStatus().toUpperCase());   
						row2.createCell((short)3).setCellValue(_lineItem.getImo().toUpperCase()); 
						 						     
						
						row2.createCell((short)4).setCellValue(_lineItem.getCapacity().toString()+" "+_lineItem.getCapacitytype());
						row2.createCell((short)5).setCellValue(_lineItem.getTareweight().toString()+" "+_lineItem.getTareweighttype());					
						
						String _flag = "NO";
						if (_lineItem.getActive().toString().equals("Y")) _flag = "YES";						
						row2.createCell((short)6).setCellValue(_flag); 
						

						
						
						count++;
						
					} // _lineItem not null
				}
				catch (Exception e) {}
				
				
			} // list loop
			
			
			
		}
		catch (Exception e) {}
		
	} 
	
	
	public void doSummaryToExcel(ReportLocationinventoryForm reportForm) {
		
		try {
			
			wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Inventory Summary Report");
			
			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
			
			// Create label column row 
			HSSFRow row = sheet.createRow((short)0);
			row.createCell((short)0).setCellValue(" ");
			row.createCell((short)1).setCellValue(" "); 
			
			int _colcount=1;
			int _colcell=2;
			boolean arrivedProcess=false;
			boolean shippedProcess=false;
			
			java.util.TreeMap _tmY = (java.util.TreeMap)reportForm.getInventoryY1();			
			for (java.util.Iterator it = _tmY.keySet().iterator(); it.hasNext();) {
				java.lang.Object _tmYkey = (java.lang.Object)it.next();	
				java.util.List _listY =	(java.util.List)_tmY.get(_tmYkey);	
				for (java.util.Iterator it2 = _listY.iterator(); it2.hasNext();) {
					com.bureaueye.beacon.bean.LabelValue _labelvalueY = (com.bureaueye.beacon.bean.LabelValue)it2.next();
					
					if (_labelvalueY != null) {
						
						if (_labelvalueY.getValue().equals(com.bureaueye.beacon.bean.Constants.ARRIVED_MOVSTS)) {
							arrivedProcess=true;
							continue;
						}
						if (_labelvalueY.getValue().equals(com.bureaueye.beacon.bean.Constants.SHIPPED_MOVSTS)) {
							shippedProcess=true;
							continue;
						}
						
						_colcount++;
						row.createCell((short)_colcell).setCellValue(_labelvalueY.getLabel());
						_colcell=_colcell+1;
						
					}
					
				}				
				
			} // 
			



						
			row.createCell((short)_colcell).setCellValue("TOTAL");		
			
			
			int count = 2;
			Iterator itX = reportForm.getInventoryX().iterator();
			while (itX.hasNext()) {
				
				try {
					
					LabelValue _labelvalueX = (LabelValue) itX.next(); 
					
					if (_labelvalueX != null) {
						
						// Create new row 
						HSSFRow row3 = sheet.createRow((short)count);
						
						
						StringTokenizer tokenizer = new StringTokenizer(_labelvalueX.getLabel(),"|");
						String _key1 = "";
						String _key2 = "";
						try {_key1 = tokenizer.nextToken();} catch (Exception e) {}
						try {_key2 = tokenizer.nextToken();} catch (Exception e) {}
						
						// Create a cells
						row3.createCell((short)0).setCellValue(_key1);
						row3.createCell((short)1).setCellValue(_key2);     
						
						count++;
						
						
						int _counttotal=0;
						_colcell=2;
						
						for (java.util.Iterator _ittmY = _tmY.keySet().iterator(); _ittmY.hasNext();) {
							java.lang.Object _tmYkey = (java.lang.Object)_ittmY.next();	
							java.util.List _listY =	(java.util.List)_tmY.get(_tmYkey);								
							
							for (java.util.Iterator _itlistY = _listY.iterator(); _itlistY.hasNext();) {
								com.bureaueye.beacon.bean.LabelValue _labelvalueY = (com.bureaueye.beacon.bean.LabelValue)_itlistY.next();	
								
								if (
										_labelvalueY != null
										&& !_labelvalueY.getValue().equals(com.bureaueye.beacon.bean.Constants.ARRIVED_MOVSTS)
										&& !_labelvalueY.getValue().equals(com.bureaueye.beacon.bean.Constants.SHIPPED_MOVSTS)
									) {
									
									String _keycol0=_labelvalueX.getValue()+"|"+_labelvalueY.getValue();		
									// get count value from inventory table
									com.bureaueye.beacon.model.report.dto.LocationinventoryDTO _dto0 =
										(com.bureaueye.beacon.model.report.dto.LocationinventoryDTO)reportForm.getInventoryHt().get(_keycol0);
									int _countcol0=0;
									try{_countcol0=_dto0.getCount().intValue();}catch(Exception e){}	
									_counttotal=_counttotal+_countcol0;	
									
									// Create a cells			
									row3.createCell((short)_colcell).setCellValue(_countcol0);
									_colcell++;							
									
								} // _labelvalueY not null								
								
							} // listY loop
							
						} //tmy loop							
					

						
						
						row3.createCell((short)_colcell).setCellValue(_counttotal);  
						
					} // _labelvalueX not null
					
				}
				catch (Exception e) {}
				
				
			} // X loop
			
			
			
		}
		catch (Exception e) {}
		
	} 
	
	
	
}

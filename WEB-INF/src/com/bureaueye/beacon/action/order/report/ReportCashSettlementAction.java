package com.bureaueye.beacon.action.order.report;




import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.report.ReportRow;


import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.formatter.CurrencyFormatter;



import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobhdrBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobcostDTO;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.order.dto.OrdersummaryChargeDTO;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.purchaseinvoice.Pidtlcost;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Charge;
import com.bureaueye.beacon.model.standard.Cost;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.system.bd.SystemmappingcodeBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;








/**
 *
 * Amendments
 * ----------
 *
 */

public final class ReportCashSettlementAction extends BaseAction {





	private static String baseCcy;



	private static OrderhdrBD orderhdrbd;
	private static OrderchargeBD orderchargebd;
	private static SidtlBD sidtlbd;
	private static OrderprodBD orderprodbd;
	private static JobhdrBD jobhdrbd;
	private static JobmovBD jobmovbd;
	private static JobcostBD jobcostbd;
	private static AddressBD addressbd;
	private static SystemcodeBD systemcodebd;
	private static SystemmappingcodeBD systemmappingcodebd;
	private static CostBD costbd;
	private static ChargeBD chargebd;
	private static UnitBD unitbd;	
	private static CcyexBD ccyexbd;
	private static PidtlcostBD pidtlcostbd;


	private static HSSFWorkbook wb;
	private static HSSFSheet sheet1;
	private static HSSFSheet sheet2;
	private static HSSFSheet sheet3;
	


	//output summary 
	Hashtable<String,String> tradelaneHt;
	Hashtable<String,String> customerHt;
	Hashtable<String,String> categoryHt;
	Hashtable<String,ReportRow> summaryHt;
	
	
	List details;


	public ReportCashSettlementAction() {

	}


	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();

		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" actionFormName = " + actionFormName + "\t Mapping = "
					+ mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+" remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}

		ListForm listForm = (ListForm) form;
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Populating form");



		//init business delegates
		orderhdrbd = new OrderhdrBD(this.getSessionFactoryClusterMap());
		orderchargebd = new OrderchargeBD(this.getSessionFactoryClusterMap());
		sidtlbd = new SidtlBD(this.getSessionFactoryClusterMap());
		orderprodbd = new OrderprodBD(this.getSessionFactoryClusterMap());
		jobhdrbd = new JobhdrBD(this.getSessionFactoryClusterMap());
		jobmovbd = new JobmovBD(this.getSessionFactoryClusterMap());
		jobcostbd = new JobcostBD(this.getSessionFactoryClusterMap());
		addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		systemcodebd = new SystemcodeBD(this.getSessionFactoryClusterMap());
		systemmappingcodebd = new SystemmappingcodeBD(this.getSessionFactoryClusterMap());
		costbd = new CostBD(this.getSessionFactoryClusterMap());
		chargebd = new ChargeBD(this.getSessionFactoryClusterMap());
		unitbd = new UnitBD(this.getSessionFactoryClusterMap());		
		ccyexbd = new CcyexBD(this.getSessionFactoryClusterMap());	
		pidtlcostbd = new PidtlcostBD(this.getSessionFactoryClusterMap());


		// set line items
		List<Orderhdr> orderhdrs = null;

		//check if output selected and first time in 
		if (listForm.getSearchString3() != null && !listForm.getSearchString3().equals("")) {
			listForm.setLineItems(	orderhdrbd.findOrderhdrsBySearchForCashSettlementReport(listForm));	
		}

		orderhdrs = listForm.getLineItems();




		log.debug(
				"["+this.getClass().getName()+"] "+new java.util.Date()+
				"  listForm.toString(): "+listForm.toString()
		);



		if (listForm.getSearchString3() != null && listForm.getSearchString3().equals("EXCEL")) {

			log.debug(
					"["+this.getClass().getName()+"] "+new java.util.Date()+
					"  orderhdrs size: "+orderhdrs.size()
			);

			// process list collection
			baseCcy=listForm.getSearchString6();
			details = new LinkedList<ReportRow>();
			Iterator it = orderhdrs.iterator();
			while (it.hasNext()) {
				//  
				Orderhdr lineItem = (Orderhdr) it.next();
				processOrderhdr(lineItem);
			}

			log.debug(
					"["+this.getClass().getName()+"] "+new java.util.Date()+
					"  details size: "+details.size()
			);



			try {	

				response.setContentType("application/vnd.ms-excel");

				wb = new HSSFWorkbook();
				sheet1 = wb.createSheet("Cash Settlement Detail");

				// 
				outputHeaderToEXCEL();   			


				if (details != null && details.size() > 0) {  


					//output summary 
					tradelaneHt = new Hashtable<String,String>();
					customerHt = new Hashtable<String,String>();
					categoryHt = new Hashtable<String,String>();
					summaryHt = new Hashtable<String,ReportRow>();
					

					// process list collection
					int row=1;		
					for (Iterator it99 = details.iterator(); it99.hasNext();) {
						ReportRow detail = (ReportRow) it99.next();

						// output to 
						outputDetailToEXCEL(detail, row);

						row++;
					} // end list loop				

	
				
				

				// output customer summary	
				sheet2 = wb.createSheet("Summary by Customer");
				outputSummaryHeaderToEXCEL(sheet2, "Customer"); 
				row=1;	
				for (Enumeration e = customerHt.elements(); e.hasMoreElements();) {
					String customer = (String)e.nextElement();
					
					// output to 
					outputSummaryDetailToEXCEL(sheet2, customer, row);
					
					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  customer summary: "+customer						
					);
					
					row++;
				} // end customer summary loop	
			
				

				// output tradelane summary
				sheet3 = wb.createSheet("Summary by Tradelane");
				outputSummaryHeaderToEXCEL(sheet3, "Tradelane");
				row=1;
				for (Enumeration e2 = tradelaneHt.elements(); e2.hasMoreElements();) {
					String tradelane = (String)e2.nextElement();
					
					// output to 
					outputSummaryDetailToEXCEL(sheet3, tradelane, row);
					
					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  tradelane summary: "+tradelane						
					);
					
					row++;
				} // end tradelane summary loop
				
				}
				
				
				// Write the output to a file
				wb.write(response.getOutputStream());

							
				return null; 

			}
			catch (Exception e) {
			}		
			finally {
				//clear variables
				orderhdrbd=null;
				orderchargebd=null;
				orderprodbd=null;
				jobhdrbd=null;
				jobmovbd=null;
				jobcostbd=null;
				addressbd=null;
				systemcodebd=null;
				systemmappingcodebd=null;
				costbd=null;
				chargebd=null;
				unitbd=null;
				ccyexbd=null;		 
				pidtlcostbd=null;
			}

		} // end of EXCEL check



		// default select fields
		setTotalResults(listForm);


		// default select fields
		setTotalResults(listForm,session);


		// Forward control to the edit user registration page
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}


	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// set default field values

		//set default max results
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);



		//loading gcodes
		if (listForm.getSearchString20() == null || listForm.getSearchString20().equals("")) {
			listForm.setSearchString20("");
		}	
		if (listForm.getSearchString21() == null || listForm.getSearchString21().equals("")) {
			listForm.setSearchString21("");
		}
		if (listForm.getSearchString22() == null || listForm.getSearchString22().equals("")) {
			listForm.setSearchString22("");
		}
		if (listForm.getSearchString23() == null || listForm.getSearchString23().equals("")) {
			listForm.setSearchString23("");
		}
		//discharge gcodes
		if (listForm.getSearchString24() == null || listForm.getSearchString24().equals("")) {
			listForm.setSearchString24("");
		}	
		if (listForm.getSearchString25() == null || listForm.getSearchString25().equals("")) {
			listForm.setSearchString25("");
		}
		if (listForm.getSearchString26() == null || listForm.getSearchString26().equals("")) {
			listForm.setSearchString26("");
		}
		if (listForm.getSearchString27() == null || listForm.getSearchString27().equals("")) {
			listForm.setSearchString27("");
		}


		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try{
			dateRangeDays = new Integer(
					new SystemcodeBD(
							this.getSessionFactoryClusterMap()
					).read(new SystemcodePK("DATERANGEDAYS","LISTDEFAULT")).getDescr()).intValue();
		}catch(Exception e){}		
		// date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE,-1*dateRangeDays);			
			// default 'from' date to today minus das range
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {				
			}					
		}
		// date 'to'		
		if (listForm.getSearchDate2() == null) {			
			// default 'to' date plus days range 
			c.add(Calendar.DATE,dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}								
		}


		// default to PDF to output
		if (listForm.getSearchString3() == null) {			
			listForm.setSearchString3("EXCEL");			
		}

	}


	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
		
		//default company
		User user = (User) session.getAttribute(Constants.USER_KEY);
		if (listForm.getSearchString7() == null || listForm.getSearchString7().equals("")) {
			listForm.setSearchString7(user.getCompanykey());
		}
		
	}
	
	
	public ActionMessages setLineItems(
			ListForm listForm
	) throws ApplicationException {

		return null;
	}





	public void outputHeaderToEXCEL() 
	{
		// Create label column row 
		HSSFRow row = sheet1.createRow((short)0);


		// Create a cell and put a value in it.
		row.createCell((short)0).setCellValue("Order Number");
		row.createCell((short)1).setCellValue("Job Number");
		row.createCell((short)2).setCellValue("Unit");
		row.createCell((short)3).setCellValue("Unit Manager");
		row.createCell((short)4).setCellValue("Customer");
		row.createCell((short)5).setCellValue("Product");
		row.createCell((short)6).setCellValue("Company");
		row.createCell((short)7).setCellValue("Department");
		row.createCell((short)8).setCellValue("Activity/Role");
		row.createCell((short)9).setCellValue("Trade Lane");
		row.createCell((short)10).setCellValue("Loading G1");
		row.createCell((short)11).setCellValue("Loading G2");
		row.createCell((short)12).setCellValue("Loading G3");
		row.createCell((short)13).setCellValue("Loading G4");
		row.createCell((short)14).setCellValue("Discharge G1");
		row.createCell((short)15).setCellValue("Discharge G2");
		row.createCell((short)16).setCellValue("Discharge G3");
		row.createCell((short)17).setCellValue("Discharge G4");
		row.createCell((short)18).setCellValue("Loading Date");
		row.createCell((short)19).setCellValue("Ship From Date");
		row.createCell((short)20).setCellValue("Ship To Date");
		row.createCell((short)21).setCellValue("Discharge Date");
		row.createCell((short)22).setCellValue("Return to Depot");
		row.createCell((short)23).setCellValue("Available at Depot"); 
		row.createCell((short)24).setCellValue("Base Ccy"); 
		row.createCell((short)25).setCellValue("Cost/Charge Ccy");
		row.createCell((short)26).setCellValue("Cost/Charge Code");
		row.createCell((short)27).setCellValue("Category"); 
		row.createCell((short)28).setCellValue("Cost/Charge"); 
		row.createCell((short)29).setCellValue("Estimate Cost"); 
		row.createCell((short)30).setCellValue("Estimate Cost Base"); 
		row.createCell((short)31).setCellValue("Actual Cost");
		row.createCell((short)32).setCellValue("Actual Cost Base");  
		row.createCell((short)33).setCellValue("Order Charge"); 
		row.createCell((short)34).setCellValue("Order Charge Base"); 
		row.createCell((short)35).setCellValue("Invoice Charge");
		row.createCell((short)36).setCellValue("Invoice Charge Base"); 



	}



	public void outputDetailToEXCEL(ReportRow detail, int count)
	{

		try {

			// Create label column row 
			HSSFRow row = sheet1.createRow((short)count);

			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));



			// Create a cell and put a value in it.
			row.createCell((short)0).setCellValue(detail.getCell1());
			row.createCell((short)1).setCellValue(detail.getCell21());
			row.createCell((short)2).setCellValue(detail.getCell22());
			row.createCell((short)3).setCellValue(detail.getCell23());
			row.createCell((short)4).setCellValue(detail.getCell26());
			row.createCell((short)5).setCellValue(detail.getCell24());
			row.createCell((short)6).setCellValue(detail.getCell5());
			row.createCell((short)7).setCellValue(detail.getCell4());
			row.createCell((short)8).setCellValue(detail.getCell3());
			row.createCell((short)9).setCellValue(detail.getCell27());
			row.createCell((short)10).setCellValue(detail.getCell6());
			row.createCell((short)11).setCellValue(detail.getCell7());
			row.createCell((short)12).setCellValue(detail.getCell8());
			row.createCell((short)13).setCellValue(detail.getCell9());
			row.createCell((short)14).setCellValue(detail.getCell10());
			row.createCell((short)15).setCellValue(detail.getCell11());
			row.createCell((short)16).setCellValue(detail.getCell12());
			row.createCell((short)17).setCellValue(detail.getCell13());

			HSSFCell dateCell = row.createCell((short)18);
			if (detail.getCell31() != null) {
				dateCell.setCellValue( detail.getCell31() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)18).setCellValue( "" );		        	
			}
			dateCell = row.createCell((short)19);
			if (detail.getCell32() != null) {
				dateCell.setCellValue( detail.getCell32() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)19).setCellValue( "" );		        	
			}
			dateCell = row.createCell((short)20);
			if (detail.getCell33() != null) {
				dateCell.setCellValue( detail.getCell33() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)20).setCellValue( "" );		        	
			}
			dateCell = row.createCell((short)21);
			if (detail.getCell34() != null) {
				dateCell.setCellValue( detail.getCell34() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)21).setCellValue( "" );		        	
			}
			dateCell = row.createCell((short)22);
			if (detail.getCell35() != null) {
				dateCell.setCellValue( detail.getCell35() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)22).setCellValue( "" );		        	
			}
			dateCell = row.createCell((short)23);
			if (detail.getCell36() != null) {
				dateCell.setCellValue( detail.getCell36() );
				dateCell.setCellStyle(dateCellStyle);
			}
			else {
				row.createCell((short)23).setCellValue( "" );		        	
			}


			row.createCell((short)24).setCellValue(detail.getCell14());
			row.createCell((short)25).setCellValue(detail.getCell15());
			row.createCell((short)27).setCellValue(detail.getCell16());
			row.createCell((short)26).setCellValue(detail.getCell17());
			row.createCell((short)28).setCellValue(detail.getCell18());


			//expenses
			try {
				row.createCell((short)29).setCellValue(new CurrencyFormatter().format(detail.getCell41()));					
			} catch (Exception e) {
				row.createCell((short)29).setCellValue("0.00");	
			}		
			try {
				row.createCell((short)30).setCellValue(new CurrencyFormatter().format(detail.getCell42()));					
			} catch (Exception e) {
				row.createCell((short)30).setCellValue("0.00");	
			}		
			try {
				row.createCell((short)31).setCellValue(new CurrencyFormatter().format(detail.getCell43()));					
			} catch (Exception e) {
				row.createCell((short)31).setCellValue("0.00");	
			}
			try {
				row.createCell((short)32).setCellValue(new CurrencyFormatter().format(detail.getCell44()));					
			} catch (Exception e) {
				row.createCell((short)32).setCellValue("0.00");	
			} 


			//revenue
			try {
				row.createCell((short)33).setCellValue(new CurrencyFormatter().format(detail.getCell45()));					
			} catch (Exception e) {
				row.createCell((short)33).setCellValue("0.00");	
			} 
			try {
				row.createCell((short)34).setCellValue(new CurrencyFormatter().format(detail.getCell46()));					
			} catch (Exception e) {
				row.createCell((short)34).setCellValue("0.00");	
			} 
			try {
				row.createCell((short)35).setCellValue(new CurrencyFormatter().format(detail.getCell47()));					
			} catch (Exception e) {
				row.createCell((short)35).setCellValue("0.00");	
			} 
			try {
				row.createCell((short)36).setCellValue(new CurrencyFormatter().format(detail.getCell48()));					
			} catch (Exception e) {
				row.createCell((short)36).setCellValue("0.00");	
			} 




			try {
				//generate summary record for tradelane
				
				//find record using key - tradelane|category
				String key = detail.getCell27()+"|"+detail.getCell16();			
						
				ReportRow rr =	(ReportRow)summaryHt.get(key);
				if (rr==null) rr = new ReportRow();
				rr.setCell1(key);
				
				try{rr.setCell41(rr.getCell41().add(detail.getCell42()));}
				catch(Exception e){rr.setCell41(rr.getCell41());}
				try{rr.setCell42(rr.getCell42().add(detail.getCell44()));}
				catch(Exception e){rr.setCell42(rr.getCell42());}
				try{rr.setCell43(rr.getCell43().add(detail.getCell46()));}
				catch(Exception e){rr.setCell43(rr.getCell43());}
				try{rr.setCell44(rr.getCell44().add(detail.getCell48()));}
				catch(Exception e){rr.setCell44(rr.getCell44());}
				
				summaryHt.put(key, rr);							
			} catch (Exception e) {				
			} 			

			//output summary record for customer
			try {
				//output summary record for customer
				//find record using key - customer|category
				String key = detail.getCell26()+"|"+detail.getCell16();	
				
				ReportRow rr =	(ReportRow)summaryHt.get(key);
				if (rr==null) rr = new ReportRow();
				rr.setCell1(key);
				
				try{rr.setCell41(rr.getCell41().add(detail.getCell42()));}
				catch(Exception e){rr.setCell41(rr.getCell41());}
				try{rr.setCell42(rr.getCell42().add(detail.getCell44()));}
				catch(Exception e){rr.setCell42(rr.getCell42());}
				try{rr.setCell43(rr.getCell43().add(detail.getCell46()));}
				catch(Exception e){rr.setCell43(rr.getCell43());}
				try{rr.setCell44(rr.getCell44().add(detail.getCell48()));}
				catch(Exception e){rr.setCell44(rr.getCell44());}
				
				summaryHt.put(key, rr);				
			} catch (Exception e) {
			} 			

			try {
				//generate tradelane list				
				String key = detail.getCell27();			
						
				String tradelane =	(String)tradelaneHt.get(key);
				if (tradelane==null) tradelane = key;
				
				tradelaneHt.put(key, tradelane);							
			} catch (Exception e) {				
			} 
			
			try {
				//generate customer list				
				String key = detail.getCell26();			
						
				String customer =	(String)customerHt.get(key);
				if (customer==null) customer = key;
				
				customerHt.put(key, customer);							
			} catch (Exception e) {				
			}
			
			try {
				//generate category list				
				String key = detail.getCell16();			
						
				String category =	(String)categoryHt.get(key);
				if (category==null) category = key;
				
				categoryHt.put(key, category);							
			} catch (Exception e) {				
			}
			
			

		} catch (Exception e) {				
		}



	}


	public void outputSummaryHeaderToEXCEL(HSSFSheet  sheet, String headerLabel) 
	{
		// Create label column row 
		HSSFRow row = sheet.createRow((short)0);


		// Create a cell and put a value in it.
		row.createCell((short)0).setCellValue(headerLabel);

		int column = 1;
		// output category	
		for (Enumeration e = categoryHt.elements(); e.hasMoreElements();) {
			String category = (String)e.nextElement();
			
			//rev or expense
			String revOrExp = "EXP";
			if (category.substring(0,1).equals("D")) revOrExp="REV";
			
			// Create a cell and put a value in it.
			row.createCell((short)column).setCellValue(category);

			if (revOrExp.equals("EXP")) row.createCell((short)column).setCellValue(category+" Estimate Cost");
			else row.createCell((short)column).setCellValue(category+" Charge Amount");
			column++;
			if (revOrExp.equals("EXP")) row.createCell((short)column).setCellValue(category+" Actual Cost");
			else row.createCell((short)column).setCellValue(category+" Invoice Amount");
			
			
			column++;
		} // end customer summary loop	
		
		

	}


	
	
	
	public void outputSummaryDetailToEXCEL(
			HSSFSheet  sheet, 
			String keyparam1, 
			int count
			)
	{

		try {

			// Create label column row 
			HSSFRow row = sheet.createRow((short)count);

			HSSFCellStyle dateCellStyle = wb.createCellStyle();
			dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));


			// Create a cell and put a value in it.
			row.createCell((short)0).setCellValue(keyparam1);

			
			int column = 1;
			// output category	
			for (Enumeration e = categoryHt.elements(); e.hasMoreElements();) {
				String category = (String)e.nextElement();
				
				//rev or expense
				String revOrExp = "EXP";
				if (category.substring(0,1).equals("D")) revOrExp="REV";
				
				
				String key = keyparam1+"|"+category;			
				
				ReportRow rr =	(ReportRow)summaryHt.get(key);
			
				if (rr!=null) {						
					if (revOrExp.equals("EXP")) row.createCell((short)column).setCellValue(rr.getCell41().toString());
					else row.createCell((short)column).setCellValue(rr.getCell43().toString());
					column++;
					if (revOrExp.equals("EXP")) row.createCell((short)column).setCellValue(rr.getCell42().toString());
					else row.createCell((short)column).setCellValue(rr.getCell44().toString());
				} else {
					row.createCell((short)column).setCellValue("0");	
					column++;
					row.createCell((short)column).setCellValue("0");
				}
								
				column++;
			} // end customer summary loop	
			

		} catch (Exception e) {				
		}

	}



	


	public void processOrderhdr(Orderhdr orderhdr) 
	{	

		try {


			// exrate lookup
			ListForm ccyexListForm = new ListForm();
			ccyexListForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			ccyexListForm.setGotoPage(0);
			ccyexListForm.setSearchDate1(new Date());
			ccyexListForm.setOrderBy("Exdate");
			ccyexListForm.setOrderByDesc("Desc");			
			ccyexListForm.setSearchString2(baseCcy);// to ccy


			// retrieve section mapping for PKUP, LOAD, DSCH & DELV
			String depoSection = "";
			String pkupSection = "";
			String loadSection = "";
			String shipSection = "";
			String dschSection = "";
			String delvSection = "";
			String rtdpSection = "";
			String avdpSection = "";
			try{depoSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DEPO").getCompanycode();}catch(Exception e){}
			try{pkupSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "PKUP").getCompanycode();}catch(Exception e){}
			try{loadSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "LOAD").getCompanycode();}catch(Exception e){}
			try{shipSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "SHIP").getCompanycode();}catch(Exception e){}
			try{dschSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DSCH").getCompanycode();}catch(Exception e){}
			try{delvSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "DELV").getCompanycode();}catch(Exception e){}
			try{rtdpSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "RTDP").getCompanycode();}catch(Exception e){}
			try{avdpSection = systemmappingcodebd.findSystemmappingcodeByCodetypeBeaconcode("SECTION", "AVDP").getCompanycode();}catch(Exception e){}


			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" findSystemmappingcode: " +
					" depoSection="+depoSection+
					" pkupSection="+pkupSection+
					" loadSection="+loadSection+
					" shipSection="+shipSection+
					" dschSection="+dschSection+
					" delvSection="+delvSection+
					" rtdpSection="+rtdpSection+
					" avdpSection="+avdpSection	
			);		



			String jobNumber = "";
			String unitKey = "";
			String unitManagerName = "UNKNOWN";
			/*Get the Depot Move*/
			java.util.Date ldgFromDate = null;
			/*Get the Ship move*/
			java.util.Date shipFromDate = null;
			java.util.Date shipToDate = null;
			/*Get the Discharge move*/
			java.util.Date dschToDate = null;	
			/*Get the Return to depot move*/
			java.util.Date rtdpToDate = null;
			/*Set Arrival from Consignee*/
			java.util.Date avdpToDate = null;
			/*Set mtyToShipper*/
			java.util.Date loadFromDate = null;


			/*set product*/
			Orderprod orderprod = null;
			String productCode = "UNKNOWN";
			try {
				orderprod=orderprodbd.findFirstOrderprodByOrderhdrId(orderhdr.getId());
				productCode=orderprod.getProductkey();
			} catch (Exception e){}

			/*Set Activity*/
			Systemcode systemcode = null;
			String activityDescr = "UNKNOWN";
			try {
				systemcode=systemcodebd.findSystemcodesByTypekeyCodekey("ACTIVITY", orderhdr.getActivitykey());
				activityDescr=systemcode.getDescr();
			} catch (Exception e){}			

			/*Customer Name*/
			Address address = null;
			String customerName = "";
			try {
				address=addressbd.read(orderhdr.getCustomeraddrkey());
				customerName=address.getName();
			} catch (Exception e){}					

			/*trade lane*/
			String tradeLane = orderhdr.getLdgg1key2()+ " -> " + orderhdr.getDchg1key2();

			//find jobs for order
			List jobhdrs = jobhdrbd.findJobhdrsById(orderhdr.getId().toString(), 0, Constants.MAX_RESULTS_NOLIMIT, "Unitkey");


			log.debug(
					"["+this.getClass().getName()+"] "+new java.util.Date()+
					"  jobhdrs size: "+jobhdrs.size()
			);

			//JOB HEADER LOOP=========================================================>

			// process list collection
			Iterator it = jobhdrs.iterator();
			int row = 1;
			while (it.hasNext()) {

				JobhdrDTO jobhdr = (JobhdrDTO) it.next();			

				jobNumber = jobhdr.getJobno();
				unitKey = jobhdr.getUnitkey();

				/*Tank Provider*/
				address = null;
				Unit unit = null;
				try {

					unit=unitbd.read(jobhdr.getUnitId());

					try {					
						address=addressbd.read(unit.getMgraddrkey());
						unitManagerName=address.getName();
					} catch (Exception e){}

				} catch (Exception e){}		


				// init standard sections
				Jobmov depoJobmov = null;
				Jobmov loadJobmov = null;
				Jobmov shipJobmov = null;
				Jobmov dschJobmov = null;
				Jobmov rtdpJobmov = null;
				Jobmov avdpJobmov = null;	
				// retrieve sections					
				try{depoJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(), depoSection);}catch(Exception e){}
				try{loadJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(), loadSection);}catch(Exception e){}
				try{shipJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(), shipSection);}catch(Exception e){}
				try{dschJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(), dschSection);}catch(Exception e){}
				try{rtdpJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(), rtdpSection);}catch(Exception e){}
				try{avdpJobmov = new JobmovBD(this.getSessionFactoryClusterMap()).findJobmovByJobhdrIdSectionkey(jobhdr.getJobhdrId().toString(), avdpSection);}catch(Exception e){}



				/*Get the Depot Move*/
				ldgFromDate = orderhdr.getLdgfromdate();
				boolean jobStarted=false;
				try {
					ldgFromDate = depoJobmov.getFromdate();
					if (depoJobmov.getActfromdate()!=null) jobStarted=true;
				} catch (Exception e){}

				/*Get the Ship move*/
				shipFromDate = null;
				shipToDate = null;
				try {
					shipFromDate = shipJobmov.getFromdate();
					shipToDate = shipJobmov.getTodate();
				} catch (Exception e){}

				/*Get the Discharge move*/
				dschToDate = null;
				try {
					dschToDate = dschJobmov.getTodate();
				} catch (Exception e){}			

				/*Get the Return to depot move*/
				rtdpToDate = null;
				try {
					rtdpToDate = rtdpJobmov.getTodate();
					if (rtdpJobmov.getActtodate()!=null) jobStarted=true;
				} catch (Exception e){}		

				/*Set Arrival from Consignee*/
				avdpToDate = null;
				try {
					avdpToDate = avdpJobmov.getActtodate();
				} catch (Exception e){}		

				/*Set mtyToShipper*/
				loadFromDate = null;
				try {
					loadFromDate = loadJobmov.getFromdate();
				} catch (Exception e){}	


				/*					ReportRow rr = new ReportRow();
				rr.setCell1(orderhdr.getOrderno());
				rr.setCell3(orderhdr.getActivitykey());
				rr.setCell4(orderhdr.getDepartmentkey());
				rr.setCell5(orderhdr.getCompanykey());
				rr.setCell6(orderhdr.getLdgg1key2());
				rr.setCell7(orderhdr.getLdgg2key2());
				rr.setCell8(orderhdr.getLdgg3key2());
				rr.setCell9(orderhdr.getLdgg4key2());
				rr.setCell10(orderhdr.getDchg1key2());
				rr.setCell11(orderhdr.getDchg2key2());
				rr.setCell12(orderhdr.getDchg3key2());
				rr.setCell13(orderhdr.getDchg4key2());		
				rr.setCell14(baseCcy);

				rr.setCell21(jobNumber);
				rr.setCell22(unitKey);
				rr.setCell23(unitManagerName);

				rr.setCell24(productCode);
				rr.setCell25(activityDescr);
				rr.setCell26(customerName);
				rr.setCell27(tradeLane);

				rr.setCell31(ldgFromDate);
				rr.setCell32(shipFromDate);				
				rr.setCell33(shipToDate);
				rr.setCell34(dschToDate);
				rr.setCell35(rtdpToDate);				
				rr.setCell36(avdpToDate);				
				rr.setCell37(loadFromDate);	*/


				try {

					//job header costs
					String categoryParam1="EXP";
					String categoryParam2="LDG";
					//default job costs to expense loading category
					List jobhdrcosts = jobcostbd.findJobhdrcostsByJobhdrIdForSummary(
							jobhdr.getJobhdrId().toString(),
							0,
							Constants.MAX_RESULTS_NOLIMIT,
							"jobcost.Costkey"
					);		

					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  jobhdrcosts size: "+jobhdrcosts.size()
					);


					Iterator it2 = jobhdrcosts.iterator();
					while (it2.hasNext()) {
						OrdersummaryJobcostDTO jobcost = (OrdersummaryJobcostDTO) it2.next();

						//init cost fields
						ReportRow rr = new ReportRow();
						rr.setCell1(orderhdr.getOrderno());
						rr.setCell3(orderhdr.getActivitykey());
						rr.setCell4(orderhdr.getDepartmentkey());
						rr.setCell5(orderhdr.getCompanykey());
						rr.setCell6(orderhdr.getLdgg1key2());
						rr.setCell7(orderhdr.getLdgg2key2());
						rr.setCell8(orderhdr.getLdgg3key2());
						rr.setCell9(orderhdr.getLdgg4key2());
						rr.setCell10(orderhdr.getDchg1key2());
						rr.setCell11(orderhdr.getDchg2key2());
						rr.setCell12(orderhdr.getDchg3key2());
						rr.setCell13(orderhdr.getDchg4key2());		
						rr.setCell14(baseCcy);

						rr.setCell21(jobNumber);
						rr.setCell22(unitKey);
						rr.setCell23(unitManagerName);

						rr.setCell24(productCode);
						rr.setCell25(activityDescr);
						rr.setCell26(customerName);
						rr.setCell27(tradeLane);
						rr.setCell18("COST");

						rr.setCell31(ldgFromDate);
						rr.setCell32(shipFromDate);				
						rr.setCell33(shipToDate);
						rr.setCell34(dschToDate);
						rr.setCell35(rtdpToDate);				
						rr.setCell36(avdpToDate);				
						rr.setCell37(loadFromDate);							
						rr.setCell15(jobcost.getCcykey());				
						rr.setCell17(jobcost.getCostkey().getCostkey());	

						//find expense category
						String category = getCategory(categoryParam1, categoryParam2, jobcost.getCostkey().getCostkey());
						//check cost is to be included in report
						if (category.equals("")) continue;

						rr.setCell16(category); 

						//init estimate cost
						rr.setCell41(jobcost.getCstamt()); 
						//find new exchange rate for ccy to base
						BigDecimal exRate = new BigDecimal(1);
						BigDecimal estimateCostBase = jobcost.getCstamt();
						if (!jobcost.getCcykey().equals(baseCcy)) {
							try {						
								ccyexListForm.setSearchString1(jobcost.getCcykey());//from ccy
								exRate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
								estimateCostBase = (jobcost.getCstamt().multiply(exRate));
							} catch (Exception ae) {}
						}
						rr.setCell42(estimateCostBase);

						log.debug(
								"["+this.getClass().getName()+"] "+new java.util.Date()+
								"  jobhdrcosts: "+
								"  costkey: "+jobcost.getCostkey().getCostkey()+
								"  category: "+category+
								"  estimateCost: "+jobcost.getCstamt()+
								"  estimateCostBase: "+estimateCostBase
						);

						//init actual costs
						//retrieve pi costs for job cost
						BigDecimal actualCost = new BigDecimal(0.0);
						BigDecimal actualCostBase = new BigDecimal(0.0);
						List pidtlcosts = pidtlcostbd.findPidtlcostsByJobcostId(jobcost.getJobcostId());

						log.debug(
								"["+this.getClass().getName()+"] "+new java.util.Date()+
								"  pidtlcosts size: "+pidtlcosts.size()
						);

						Iterator it4 = pidtlcosts.iterator();
						while (it4.hasNext()) {
							Pidtlcost pidtlcost = (Pidtlcost) it4.next();								
							actualCost=actualCost.add(pidtlcost.getCstamtalloc());
						}
						//init actual cost
						rr.setCell43(actualCost); 
						//find new exchange rate for ccy to base
						exRate = new BigDecimal(1);
						actualCostBase = actualCost;
						if (!jobcost.getCcykey().equals(baseCcy)) {
							try {						
								ccyexListForm.setSearchString1(jobcost.getCcykey());//from ccy
								exRate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
								actualCostBase = (actualCost.multiply(exRate));
							} catch (Exception ae) {}
						}											
						//init actual cost
						rr.setCell43(actualCost);
						//init actual cost to base
						rr.setCell44(actualCostBase);

						log.debug(
								"["+this.getClass().getName()+"] "+new java.util.Date()+
								"  jobhdrcosts: "+
								"  costkey: "+jobcost.getCostkey().getCostkey()+
								"  category: "+category+
								"  actualCost: "+actualCost+
								"  actualCostBase: "+actualCostBase
						);

						//create cost line
						details.add(rr);

					}

				} catch (Exception e) {
				}



				try {

					//job movement costs
					String categoryParam1="EXP";
					String categoryParam2="LDG";
					//retrieve movements for job
					List jobmovs = 
						jobmovbd.findJobmovsById(
								jobhdr.getJobhdrId().toString(), 
								0, 
								Constants.MAX_RESULTS_NOLIMIT, 
								"Totimeinmillis", 
								"Fromtimeinmillis"
						);

					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  jobmovs size: "+jobmovs.size()
					);

					Iterator it2 = jobmovs.iterator();
					while (it2.hasNext()) {
						JobmovDTO jobmov = (JobmovDTO) it2.next();

						//retreive costs for movement
						List jobmovcosts = 
							jobcostbd.findJobcostsById(
									jobmov.getJobmovId().toString(),	
									0, 
									Constants.MAX_RESULTS_NOLIMIT, 
									"Costkey"
							);	

						log.debug(
								"["+this.getClass().getName()+"] "+new java.util.Date()+
								"  jobmovcosts size: "+jobmovcosts.size()
						);

						Iterator it3 = jobmovcosts.iterator();
						while (it3.hasNext()) {
							JobcostDTO jobcost = (JobcostDTO) it3.next();	

							//init cost fields
							ReportRow rr = new ReportRow();
							rr.setCell1(orderhdr.getOrderno());
							rr.setCell3(orderhdr.getActivitykey());
							rr.setCell4(orderhdr.getDepartmentkey());
							rr.setCell5(orderhdr.getCompanykey());
							rr.setCell6(orderhdr.getLdgg1key2());
							rr.setCell7(orderhdr.getLdgg2key2());
							rr.setCell8(orderhdr.getLdgg3key2());
							rr.setCell9(orderhdr.getLdgg4key2());
							rr.setCell10(orderhdr.getDchg1key2());
							rr.setCell11(orderhdr.getDchg2key2());
							rr.setCell12(orderhdr.getDchg3key2());
							rr.setCell13(orderhdr.getDchg4key2());		
							rr.setCell14(baseCcy);

							rr.setCell21(jobNumber);
							rr.setCell22(unitKey);
							rr.setCell23(unitManagerName);

							rr.setCell24(productCode);
							rr.setCell25(activityDescr);
							rr.setCell26(customerName);
							rr.setCell27(tradeLane);
							rr.setCell18("COST");

							rr.setCell31(ldgFromDate);
							rr.setCell32(shipFromDate);				
							rr.setCell33(shipToDate);
							rr.setCell34(dschToDate);
							rr.setCell35(rtdpToDate);				
							rr.setCell36(avdpToDate);				
							rr.setCell37(loadFromDate);	
							rr.setCell15(jobcost.getCcykey());				
							rr.setCell17(jobcost.getCostkey().getCostkey());

							//find expense category
							String category = getCategory(categoryParam1, categoryParam2, jobcost.getCostkey().getCostkey());
							//check cost is to be included in report
							if (category.equals("")) continue;

							rr.setCell16(category); 

							//init estimate cost
							rr.setCell41(jobcost.getCstamt()); 
							//find new exchange rate for ccy to base
							BigDecimal exRate = new BigDecimal(1);
							BigDecimal estimateCostBase = jobcost.getCstamt();
							if (!jobcost.getCcykey().equals(baseCcy)) {
								try {						
									ccyexListForm.setSearchString1(jobcost.getCcykey());//from ccy
									exRate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
									estimateCostBase = (jobcost.getCstamt().multiply(exRate));
								} catch (Exception ae) {}
							}
							rr.setCell42(estimateCostBase);

							log.debug(
									"["+this.getClass().getName()+"] "+new java.util.Date()+
									"  jobmovcosts: "+
									"  costkey: "+rr.getCell17()+
									"  category: "+rr.getCell16()+
									"  estimateCost: "+rr.getCell41()+
									"  estimateCostBase: "+rr.getCell42()
							);

							//init actual costs
							//retrieve pi costs for job cost
							BigDecimal actualCost = new BigDecimal(0.0);
							BigDecimal actualCostBase = new BigDecimal(0.0);
							List pidtlcosts = pidtlcostbd.findPidtlcostsByJobcostId(jobcost.getJobcostId());

							log.debug(
									"["+this.getClass().getName()+"] "+new java.util.Date()+
									"  pidtlcosts size: "+pidtlcosts.size()
							);

							Iterator it4 = pidtlcosts.iterator();
							while (it4.hasNext()) {
								Pidtlcost pidtlcost = (Pidtlcost) it4.next();								
								actualCost=actualCost.add(pidtlcost.getCstamtalloc());
							} 
							//find new exchange rate for ccy to base
							exRate = new BigDecimal(1);
							actualCostBase = actualCost;
							if (!jobcost.getCcykey().equals(baseCcy)) {
								try {						
									ccyexListForm.setSearchString1(jobcost.getCcykey());//from ccy
									exRate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
									actualCostBase = (actualCost.multiply(exRate));
								} catch (Exception ae) {}
							}

							//init actual cost
							rr.setCell43(actualCost);
							//init actual cost to base
							rr.setCell44(actualCostBase);

							log.debug(
									"["+this.getClass().getName()+"] "+new java.util.Date()+
									"  jobmovcosts: "+
									"  costkey: "+rr.getCell17()+
									"  category: "+rr.getCell16()+
									"  actualCost: "+rr.getCell43()+
									"  actualCostBase: "+rr.getCell44()
							);

							//create cost line
							details.add(rr);

						}//end costs loop		

						//category changes to DISCHARGE after ship movement 
						if (jobmov.getSectionkey().equals(shipSection)) categoryParam2="DCH";

					}//end moves loop

				} catch (Exception e) {
				}









			}//end of JOB HEADER LOOP=========================================================<



			try {

				//order charges
				String categoryParam1="REV";
				String categoryParam2="LDG";

				// retrieve order charges	
				List ordercharges = orderchargebd.findOrderchargesByOrderhdrIdForSummary(
						orderhdr.getId().toString(),
						0,
						Constants.MAX_RESULTS_NOLIMIT,
						"Chargekey"
				);			

				log.debug(
						"["+this.getClass().getName()+"] "+new java.util.Date()+
						"  ordercharges size: "+ordercharges.size()
				);

				Iterator it2 = ordercharges.iterator();
				while (it2.hasNext()) {
					OrdersummaryChargeDTO ordercharge = (OrdersummaryChargeDTO) it2.next();	

					//init cost fields
					ReportRow rr = new ReportRow();
					rr.setCell1(orderhdr.getOrderno());
					rr.setCell3(orderhdr.getActivitykey());
					rr.setCell4(orderhdr.getDepartmentkey());
					rr.setCell5(orderhdr.getCompanykey());
					rr.setCell6(orderhdr.getLdgg1key2());
					rr.setCell7(orderhdr.getLdgg2key2());
					rr.setCell8(orderhdr.getLdgg3key2());
					rr.setCell9(orderhdr.getLdgg4key2());
					rr.setCell10(orderhdr.getDchg1key2());
					rr.setCell11(orderhdr.getDchg2key2());
					rr.setCell12(orderhdr.getDchg3key2());
					rr.setCell13(orderhdr.getDchg4key2());		
					rr.setCell14(baseCcy);

					rr.setCell21(jobNumber);
					rr.setCell22(unitKey);
					rr.setCell23(unitManagerName);

					rr.setCell24(productCode);
					rr.setCell25(activityDescr);
					rr.setCell26(customerName);
					rr.setCell27(tradeLane);
					rr.setCell18("CHARGE");

					rr.setCell31(ldgFromDate);
					rr.setCell32(shipFromDate);				
					rr.setCell33(shipToDate);
					rr.setCell34(dschToDate);
					rr.setCell35(rtdpToDate);				
					rr.setCell36(avdpToDate);				
					rr.setCell37(loadFromDate);	
					rr.setCell15(ordercharge.getCcykey());				
					rr.setCell17(ordercharge.getChargekey().getChargekey());

					//find reveune category
					String category = getCategory(categoryParam1, categoryParam2, ordercharge.getChargekey().getChargekey());
					//check charge is to be included in report
					if (category.equals("")) continue;

					rr.setCell16(category);


					//init charge
					rr.setCell45(ordercharge.getChgamt()); 
					//find new exchange rate for ccy to base
					BigDecimal exRate = new BigDecimal(1);
					BigDecimal chargeAmountBase = ordercharge.getChgamt();
					if (!ordercharge.getCcykey().equals(baseCcy)) {
						try {						
							ccyexListForm.setSearchString1(ordercharge.getCcykey());//from ccy
							exRate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
							chargeAmountBase = (ordercharge.getChgamt().multiply(exRate));
						} catch (Exception ae) {}
					}
					rr.setCell46(chargeAmountBase);

					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  ordercharges: "+
							"  chargekey: "+rr.getCell17()+
							"  category: "+rr.getCell16()+
							"  chargeAmount: "+rr.getCell45()+
							"  chargeAmountBase: "+rr.getCell46()
					);



					//init actual charges
					//retrieve si charges for order charge
					BigDecimal actualCharge = new BigDecimal(0.0);
					BigDecimal actualChargeBase = new BigDecimal(0.0);
					String invoiceCcyKey = "";
					List sidtls = sidtlbd.findSidtlsByOrderchargeId(ordercharge.getOrderchargeId());

					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  sidtls size: "+sidtls.size()
					);

					Iterator it3 = sidtls.iterator();
					while (it3.hasNext()) {
						Sidtl sidtl = (Sidtl) it3.next();								
						actualCharge=actualCharge.add(sidtl.getInvoiceamt());
						invoiceCcyKey=sidtl.getInvoiceccykey();
					} 
					//find new exchange rate for ccy to base
					exRate = new BigDecimal(1);
					actualChargeBase = actualCharge;
					if (!invoiceCcyKey.equals(baseCcy)) {
						try {						
							ccyexListForm.setSearchString1(invoiceCcyKey);//from ccy
							exRate = new BigDecimal(ccyexbd.getExrate(ccyexListForm));
							actualChargeBase = (actualCharge.multiply(exRate));
						} catch (Exception ae) {}
					}

					//init actual charge
					rr.setCell47(actualCharge);
					//init actual charge to base
					rr.setCell48(actualChargeBase);

					log.debug(
							"["+this.getClass().getName()+"] "+new java.util.Date()+
							"  ordercharges: "+
							"  chargekey: "+rr.getCell17()+
							"  category: "+rr.getCell16()+
							"  actualCharge: "+rr.getCell47()+
							"  actualChargeBase: "+rr.getCell48()
					);



					//create charge line
					details.add(rr);


				}

			} catch (Exception e) {				
			}



		} catch (Exception e) {
		}

	}





	public String getCategory(String param1, String param2, String key) 
	{	
		String category = "";
		//find in cost table
		if (param1.equals("EXP")) {
			try{
				Cost cost = costbd.read(key);
				if (param2.equals("LDG")) category = cost.getCashsettExpLdgCatg();
				if (param2.equals("DCH")) category = cost.getCashsettExpDchCatg();
			} catch (Exception e) {
			}			
		}
		//find in charge table
		if (param1.equals("REV")) {
			try{
				Charge charge = chargebd.read(key);
				if (param2.equals("LDG")) category = charge.getCashsettRevLdgCatg();
				if (param2.equals("DCH")) category = charge.getCashsettRevDchCatg();
			} catch (Exception e) {
			}			
		}

		return category;
	}




}

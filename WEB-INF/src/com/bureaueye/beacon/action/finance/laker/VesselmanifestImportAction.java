package com.bureaueye.beacon.action.finance.laker;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;

import com.bureaueye.beacon.form.finance.laker.VesselmanifestImportForm;
import com.bureaueye.beacon.model.salesinvoice.Sidtl;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-01 WSI-201312-0004 BEACON LAKER (WSI LINER) - Generate Vessel
 * Manifest Sales Invoices
 * 
 * NT 2014-02-28 201400007 Modify Spreadsheet Cell retrieval for BL Number
 * 
 * NT 2013-12-08 WSI-201311-0004B BEACON LAKER (WSI LINER) 
 * - Add Minimum commission calculation to Vessel Manifest Sales Invoices  
 * 
 */
public final class VesselmanifestImportAction extends BaseAction {

	ActionMessages appErrorMessages;
	ActionMessages appInformationMessages;
	ActionMessages appWarningMessages;

	PrintStream printStream;

	// init list to store parsed rows
	List<String[]> importList;

	String CCYKEY = "USD";
	String CUSTOMERADDRKEY = "UASC";
	String CHARGEKEY = "COMMISSION";
	String SYSTEM_USERID = "WSIL1";
	String CHARGETYPE = "LUMPSUM";

	/**
	 */
	// maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;

	@SuppressWarnings("rawtypes")
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_KEY);

		appErrorMessages = new ActionMessages();
		appInformationMessages = new ActionMessages();
		appWarningMessages = new ActionMessages();

		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " actionFormName = "
					+ actionFormName + "\t Mapping = " + mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}

		VesselmanifestImportForm importForm = (VesselmanifestImportForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		if (importForm.getButton() != null) {

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " button = "
					+ importForm.getButton());

			// IMPORT
			// PROCESS==========================================================>
			if (importForm.getButton().equals("IMPORT")) {

				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " importButton pressed");

				// Import Vessel Manifest Excel spreadsheet
				this.ImportVesselmanifest(importForm);

				// if no error messages generate sales invoice
				if (appErrorMessages.isEmpty()) {
					this.GenerateSalesInvoice(user);
				}

			}
			// IMPORT
			// PROCESS==========================================================<

		}

		if (appErrorMessages != null) {
			saveAppErrorMessages(request, appErrorMessages);
		}
		if (appInformationMessages != null) {
			saveAppInformationMessages(request, appInformationMessages);
		}
		if (appWarningMessages != null) {
			saveAppWarningMessages(request, appWarningMessages);
		}

		// Forward control to the edit user registration page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}

	public void ImportVesselmanifest(VesselmanifestImportForm importForm) {

		try {

			int rowCount = 0;

			InputStream is = importForm.getInfile().getInputStream();

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(is);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// init list to store parsed rows
			importList = new LinkedList<String[]>();
			// init array to store parsed cells
			String[] cellList = new String[100];

			Iterator<Row> rowIterator = sheet.rowIterator();
			Row row = rowIterator.next();
			row = rowIterator.next();
			int cellCount = 0;
			Iterator<Cell> cellIterator = row.cellIterator();

			/**
			 * //get COLUMN
			 * HEADERS-----------------------------------------------> //Iterate
			 * through each rows from first sheet Iterator<Row> rowIterator =
			 * sheet.rowIterator(); Row row = rowIterator.next(); int
			 * cellCount=0;
			 * 
			 * //For each row, iterate through each columns Iterator<Cell>
			 * cellIterator = row.cellIterator(); while(cellIterator.hasNext())
			 * { Cell cell = cellIterator.next();
			 * 
			 * try {
			 * cellList[cellCount]=cell.getStringCellValue().toUpperCase();
			 * 
			 * } catch (Exception e) { } cellCount++; }//cell loop
			 * 
			 * importList.add(cellList); //get COLUMN
			 * HEADERS-----------------------------------------------<
			 ***/

			// Iterate through each rows from first sheet
			while (rowIterator.hasNext()) {
				row = rowIterator.next();

				cellList = new String[100];
				cellCount = 0;

				// For each row, iterate through each columns
				cellIterator = row.cellIterator();

				// check first cell is not blank
				Cell cell = cellIterator.next();
				if (!getCellValueAsString(cell).equals("")) {

					// For each row, iterate through each columns
					cellIterator = row.cellIterator();// 201400007

					while (cellIterator.hasNext()) {
						cell = cellIterator.next();

						String strCellValue = getCellValueAsString(cell);
						cellList[cellCount] = "" + strCellValue;

						cellCount++;
					}// cell loop

					// CELL INDEX
					// ----- -----
					// BL Number 0
					// Booking Number 1
					// M/L Service 2
					// M/L Vessel 3
					// M/L Voyage 4
					// M/L Bound 5
					// Sailing Date 10
					// Load Port 15
					// Discharge Port 16
					// TEUS 29
					// Shipper Name 35
					// Freight 45
					// Shipper Code 69
					log.debug("[" + this.getClass().getName() + "] "
							+ new Date() + " ImportVesselmanifest - "
							+ " ROWCOUNT[" + rowCount + "]" + " CELLCOUNT["
							+ cellCount + "]" + " CELL0[" + cellList[0] + "]"
							+ " CELL1[" + cellList[1] + "]" + " CELL2["
							+ cellList[2] + "]" + " CELL3[" + cellList[3] + "]"
							+ " CELL4[" + cellList[4] + "]" + " CELL5["
							+ cellList[5] + "]" + " CELL10[" + cellList[10]
							+ "]" + " CELL15[" + cellList[15] + "]"
							+ " CELL16[" + cellList[16] + "]" + " CELL29["
							+ cellList[29] + "]" + " CELL35[" + cellList[35]
							+ "]" + " CELL45[" + cellList[45] + "]"
							+ " CELL69[" + cellList[69] + "]");

					rowCount++;
					importList.add(cellList);

				}// check first cell is not blank

			}// row loop

			is.close();

			if (rowCount > 0) {
				// Add a summary message of processed records
				appInformationMessages.add("messages.vesmanfimport",
						new ActionMessage("vesmanfimport.information.import",
								new Integer(rowCount).toString()));

			}

		} catch (IOException e) {
			// Add an error message
			appErrorMessages.add("errors.vesmanfimport", new ActionMessage(
					"vesmanfimport.error.import", e.getMessage()));
		} catch (Exception e) {
			// Add an error message
			appErrorMessages.add("errors.vesmanfimport", new ActionMessage(
					"vesmanfimport.error.import", e.getMessage()));
		}

	}

	public void GenerateSalesInvoice(User user) {

		try {

			// create default user
			User user2 = new User();
			BeanUtils.copyProperties(user2, user);
			user2.setUserid(SYSTEM_USERID);

			// init buisness delegates
			SihdrBD sihdrbd = new SihdrBD(this.getSessionFactoryClusterMap());
			SidtlBD sidtlbd = new SidtlBD(this.getSessionFactoryClusterMap());
			AddressBD addressbd = new AddressBD(
					this.getSessionFactoryClusterMap());
			SystemcodeBD systemcodebd = new SystemcodeBD(
					this.getSessionFactoryClusterMap());

			BigDecimal taxamt = new BigDecimal(0.0);
			BigDecimal invoiceamt = new BigDecimal(0.0);
			String taxcode = "";
			boolean processOnce = false;
			int lineCount = 0;

			// create dto for invoice header
			Sihdr sihdr = null;
			Sidtl sidtl = null;

			Iterator<String[]> importListIterator = importList.iterator();
			for (Iterator<String[]> it = importListIterator; it.hasNext();) {
				// get row
				String[] cellList = (String[]) importListIterator.next();
				lineCount++;

				// CELL INDEX
				// ----- -----
				// BL Number 0
				// Booking Number 1
				// M/L Service 2
				// M/L Vessel 3
				// M/L Voyage 4
				// M/L Bound 5
				// Sailing Date 10
				// Load Port 15
				// Discharge Port 16
				// TEUS 29
				// Shipper Name 35
				// Freight 45
				// Shipper Code 69
				String invoiceccykey = CCYKEY;
				String customeraddrkey = CUSTOMERADDRKEY;

				// store customer and invoice ccy if first row
				if (!processOnce) {
					// store fields
					processOnce = true;

					// init header fields
					sihdr = new Sihdr();
					sihdr.setManualflag(true);
					sihdr.setInvoicegroupref("");
					sihdr.setInvoiceref("");
					sihdr.setInvoiceno("");
					sihdr.setCompanykey(user2.getCompanykey());
					sihdr.setDepartmentkey(user2.getDepartmentkey());
					sihdr.setActivitykey(user2.getActivitykey());

					// get customer details------------------------->
					String paytermstext = "";
					try {
						Address customerAddress = addressbd
								.read(customeraddrkey);
						if (customerAddress != null) {
							customeraddrkey = customerAddress.getAddrkey();
							invoiceccykey = customerAddress.getCcykey();
							paytermstext = customerAddress.getPaytermstext();
						} else {
							// Add a summary message of processed records
							appWarningMessages
									.add("warnings.vesmanfimport",
											new ActionMessage(
													"vesmanfimport.warning.salesinvoicecreate2",
													customeraddrkey));
						}
					} catch (Exception e) {
					}
					// get shipper details-------------------------<

					sihdr.setInvoiceccykey(invoiceccykey);
					sihdr.setCustomeraddrkey(customeraddrkey);
					sihdr.setBatchId(0);
					sihdr.setTxt1("");
					sihdr.setTxt2("");
					sihdr.setCustomerref("");
					sihdr.setOrderno("");
					sihdr.setPaymentterm(paytermstext);

					sihdr.setInvoiceamt(new BigDecimal(0.0));
					sihdr.setTaxamt(new BigDecimal(0.0));
					sihdr.setTaxcode("");

					// additional data
					sihdr.setAdddata1(cellList[3]);// VESSEL
					sihdr.setAdddata2(cellList[4]);// VOYAGE
					sihdr.setAdddata3(cellList[5]);// BOUND
					sihdr.setAdddata4(cellList[2]);// SERVICE
					sihdr.setAdddata5(cellList[10]);// SAILING DATE
					sihdr.setAdddata6("");
					sihdr.setAdddata7("");
					sihdr.setAdddata8("");
					sihdr.setAdddata9("");
					sihdr.setAdddata10("");

					// update header
					sihdrbd.createOrUpdate(sihdr, user2);
				}

				// create dto for invoice detail
				sidtl = new Sidtl();
				sidtl.setSihdrId(sihdr.getSihdrId());

				// init detail fields
				sidtl.setInvoicegroupref("");
				sidtl.setInvoiceref("");
				sidtl.setCcykey(invoiceccykey);
				sidtl.setOrderno("");
				sidtl.setOrderhdrId(0);
				sidtl.setOrderchargeId(0);
				sidtl.setChargekey(CHARGEKEY);
				sidtl.setChargetype(CHARGETYPE);
				sidtl.setTxt1(CHARGEKEY);
				sidtl.setTxt2("");
				sidtl.setUname("");
				sidtl.setUnits(new BigDecimal(1.0));
				sidtl.setXratebase(new BigDecimal(1.0));
				sidtl.setXrateinv(new BigDecimal(1.0));
				sidtl.setInvoiceccykey(invoiceccykey);
				sidtl.setTaxamt(new BigDecimal(0.0));
				sidtl.setTaxcode("");

				// get shipper details------------------------->
				String accRep = "UNK";
				String commissionType = "";
				String shipperCode = "";

				try {
					shipperCode = cellList[69];
					Address shipperAddress = addressbd
							.findAddressByExtsysaddressid(shipperCode);
					if (shipperAddress != null) {
						accRep = shipperAddress.getAccRep();
						commissionType = shipperAddress.getCommissiontype().toUpperCase();
					} else {
						// Add a summary message of processed records
						appWarningMessages
								.add("warnings.vesmanfimport",
										new ActionMessage(
												"vesmanfimport.warning.salesinvoicecreate",
												shipperCode));
					}
				} catch (Exception e) {
				}
				// get shipper details-------------------------<

				// get commission rate------------------------->
				BigDecimal freightRate = new BigDecimal(1.0);
				try {
					freightRate = new BigDecimal(cellList[45]);
				} catch (Exception e) {
				}
				BigDecimal commissionRate = new BigDecimal(1.0);
				try {
					Systemcode systemcode = systemcodebd.read(new SystemcodePK(
							"COMMISSIONRATE", commissionType));
					if (systemcode != null) {
						commissionRate = new BigDecimal(systemcode.getDescr());
					}
				} catch (Exception e) {
				}
				// get commission rate-------------------------<

				log.info("[" + this.getClass().getName() + "] " + new Date()
						+ " GenerateSalesInvoice - " + " LINECOUNT["
						+ lineCount + "]" + " COMMISSIONRATE["
						+ commissionRate.toString() + "]" + " ACCREP[" + accRep
						+ "]" + " COMMISSIONTYPE[" + commissionType + "]"
						+ " TEUS[" + cellList[29] + "]" + " BL NUMBER["
						+ cellList[0] + "]" + " SHIPPER CODE[" + shipperCode
						+ "]" + " SHIPPER NAME[" + cellList[35] + "]"
						+ " LOAD PORT[" + cellList[15] + "]"
						+ " DISCHARGE PORT[" + cellList[16] + "]"
						+ " FREIGHTRATE[" + freightRate.toString() + "]"
						+ " 20FT[" + cellList[22]  + "]"
						+ " ALL40[" + cellList[28]  + "]"				
				);				

				sidtl.setRate(new BigDecimal(1.0));
				sidtl.setChgamt(new BigDecimal(1.0));
				sidtl.setInvoiceamt(new BigDecimal(1.0));
				try {
					BigDecimal chgAmt = freightRate.multiply(
							commissionRate.divide(new BigDecimal(100.0)))
							.setScale(2, RoundingMode.CEILING);
					sidtl.setRate(chgAmt);
					sidtl.setChgamt(chgAmt);
					sidtl.setInvoiceamt(chgAmt);
				} catch (Exception e) {
				}

				//sWSI-201311-0004B 
				// Add Minimum commission calculation 
				// NOTES FROM MALIN:"If the oceanfreight is less than $555 we get $25 per container as a minimum, 
				// containersize (20’s or 40’s) doesn’t matter. And as I said on 
				// the phone, this is only for the 4.5%, not 2%.  If ocean freight is less than $555 PER CONTAINER, not total!"
				if (commissionType.equals("E")) {
					BigDecimal freightRateLimit = new BigDecimal(1.0);					
					try {
						Systemcode systemcode = systemcodebd.read(new SystemcodePK(
								"COMMISSION_MINIMUM", "FREIGHT_RATE_LIMIT"));
						if (systemcode != null) {
							freightRateLimit = new BigDecimal(systemcode.getDescr());
						}
					} catch (Exception e) {
					}
					int numberof20ft = 0;
					try{numberof20ft = new Integer(cellList[22]).intValue();}catch(Exception e){}
					int numberofall40 = 0;
					try{numberofall40 = new Integer(cellList[28]).intValue();}catch(Exception e){}
					int numberofunits = numberof20ft+numberofall40;
					BigDecimal freightRatePerUnit =  	new BigDecimal(1.0);					
					try {
						freightRatePerUnit =freightRate.divide(new BigDecimal(numberofunits), 2, RoundingMode.HALF_UP);										
					} catch (Exception e) {
						log.error("[" + this.getClass().getName() + "] "
								+ new java.util.Date()
								+ " Minimum commission calculation - Exception: " + e.getMessage());
					}					
					if (freightRatePerUnit.doubleValue() < freightRateLimit.doubleValue()) {
						BigDecimal perTeuAmount = new BigDecimal(1.0);					
						try {
							Systemcode systemcode = systemcodebd.read(new SystemcodePK(
									"COMMISSION_MINIMUM", "PER_TEU_AMOUNT"));
							if (systemcode != null) {
								perTeuAmount = new BigDecimal(systemcode.getDescr());
							}
						} catch (Exception e) {
						}						
						try { 			
							double calcAmt = perTeuAmount.doubleValue() * numberofunits;
							BigDecimal chgAmt = new BigDecimal(calcAmt);							
							sidtl.setRate(chgAmt);
							sidtl.setChgamt(chgAmt);
							sidtl.setInvoiceamt(chgAmt);
							commissionRate=new BigDecimal(0.0);
						} catch (Exception e) {
						}						
						
					}
				}
				//eWSI-201311-0004B

				try {
					// additional data
					sidtl.setAdddata1(commissionRate + "");
					sidtl.setAdddata2(accRep);
					sidtl.setAdddata3(commissionType);
					sidtl.setAdddata4(cellList[29]);// TEUS

					try {
						// INIT BL NUMBER
						String blnumber = "";
						// always ignore the first four characters
						blnumber = cellList[0].substring(4);
						sidtl.setAdddata5(blnumber);// BL NUMBER
					} catch (Exception e) {
					}

					// sidtl.setAdddata5(cellList[0]);// BL NUMBER
					sidtl.setAdddata6(shipperCode);// SHIPPER CODE
					sidtl.setAdddata7(cellList[35]);// SHIPPER NAME
					sidtl.setAdddata8(cellList[15]);// LOAD PORT
					sidtl.setAdddata9(cellList[16]);// DISCHARGE PORT
					sidtl.setAdddata10(freightRate + "");
				} catch (Exception e) {
				}

				try {
					invoiceamt = invoiceamt.add(sidtl.getInvoiceamt());
				} catch (Exception e) {
				}

				// update details
				sidtlbd.createOrUpdate(sidtl, user2);

			} // lineitem iterator

			if (sihdr != null) {
				sihdr.setInvoiceamt(invoiceamt);
				sihdr.setTaxamt(taxamt);
				sihdr.setTaxcode(taxcode);
				// update header
				sihdrbd.createOrUpdate(sihdr, user2);

				// Add information message
				appInformationMessages.add("messages.salesinvoicebuild",
						new ActionMessage(
								"vesmanfimport.information.salesinvoicecreate",
								sihdr.getSihdrId(), lineCount));
			}

			// clear buisness delegates
			sihdrbd = null;
			sidtlbd = null;
			addressbd = null;
			systemcodebd = null;

		} catch (Exception e) {
			// Add an error message
			appErrorMessages.add("errors.vesmanfimport", new ActionMessage(
					"vesmanfimport.error.salesinvoicecreate", e.getMessage()));
		}

	}

	public static String getCellValueAsString(Cell cell) {
		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"dd/MM/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = new String(longValue.toString());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strCellValue = new String(new Boolean(
						cell.getBooleanCellValue()).toString());
				break;
			case Cell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;
			case Cell.CELL_TYPE_FORMULA:
				switch (cell.getCachedFormulaResultType()) {
				case Cell.CELL_TYPE_NUMERIC:
					Double value = cell.getNumericCellValue();
					Long longValue = value.longValue();
					strCellValue = new String(longValue.toString());
					break;
				case Cell.CELL_TYPE_STRING:
					strCellValue = cell.getRichStringCellValue().toString();
					break;
				}
				break;
			}
		}

		return strCellValue;
	}

	void println(String s) {
		System.out.println(s);
	}

	public void setStartprocesstime() {
		Calendar cal = Calendar.getInstance();
		this._startprocesstime = cal;
	}

	public Calendar getStartprocesstime() {
		return this._startprocesstime;
	}

	public boolean isBlocked() {
		Calendar _currenttime = Calendar.getInstance();
		Calendar _maxprocesstime = this._startprocesstime;
		_maxprocesstime.add(Calendar.MILLISECOND, MAX_PROCESS_TIME);

		log.debug("[" + this.getClass().getName() + "] " + new Date()
				+ " isblocked: " + _currenttime.after(_maxprocesstime)
				+ " currenttime: " + _currenttime.getTime()
				+ " maxprocesstime: " + _maxprocesstime.getTime());

		if (_currenttime.after(_maxprocesstime))
			return true;
		return false;
	}

}

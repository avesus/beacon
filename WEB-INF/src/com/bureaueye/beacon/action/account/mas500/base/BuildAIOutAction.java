package com.bureaueye.beacon.action.account.mas500.base;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.purchaseinvoice.Pihdr;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PihdrBD;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlDTO;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlcostDTO;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Vessel;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.VesselBD;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;





/**
 *
 * Amendments
 * ----------
 *
 * NT 2014-10-20 201400040 Modify AI Send process to -  
 * 	1.If AR ‘Tranamt’ is negative then change ‘TranTypeID’ to ‘CM’
 *	2.If AP ‘Invamt’ is negative then change ‘InvType’ to ‘DM’
 *
 */
public final class BuildAIOutAction
{


	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);


	/**
	 */
	//maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;



	// define business delegates		
	public static AioutBD aioutbd ;		
	public static CompanyBD companybd;
	public static AddressBD addressbd;
	public static LocationBD locationbd;
	public static OrderhdrBD orderhdrbd;
	public static VesselBD vesselbd;	
	public static SihdrBD sihdrbd;
	public static SidtlBD sidtlbd;	
	public static PihdrBD pihdrbd;
	public static PidtlBD pidtlbd;
	public static PidtlcostBD pidtlcostbd;


	public static String warningsPrefix="<warnings>";
	public static String warningsSuffix="</warnings>";
	public static String warningPrefix="<warning>";
	public static String warningSuffix="</warning>";
	public static String idPrefix="<id>";
	public static String idSuffix="</id>";
	public static String fieldPrefix="<field>";
	public static String fieldSuffix="</field>";
	public static String msgPrefix="<msg>";
	public static String msgSuffix="</msg>";


	public static String errorsPrefix="<errors>";
	public static String errorsSuffix="</errors>";
	public static String errorPrefix="<error>";
	public static String errorSuffix="</error>";
	public static String errornoPrefix="<errorno>";
	public static String errornoSuffix="</errorno>";
	public static String erroridPrefix="<errorid>";
	public static String erroridSuffix="</errorid>";
	public static String errorfieldPrefix="<errorfield>";
	public static String errorfieldSuffix="</errorfield>";
	public static String errormsgPrefix="<errormsg>";
	public static String errormsgSuffix="</errormsg>";

	public static String documentPrefix="<document>";
	public static String documentSuffix="</document>";
	public static String headerPrefix="<header>";
	public static String headerSuffix="</header>";
	public static String detailPrefix="<detail>";
	public static String detailSuffix="</detail>";		
	public static String recordnoPrefix="<recordno>";
	public static String recordnoSuffix="</recordno>";
	public static String namePrefix="<name>";
	public static String nameSuffix="</name>";
	public static String valuePrefix="<value>";
	public static String valueSuffix="</value>";




	public TreeMap<String,StringBuffer> build(
			Aiout aioutdao,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) 
	{ 	

		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" build: Run at: "+cal.getTime()
		);	



		// init business delegates		 		
		aioutbd = new AioutBD(sessionFactoryClusterMap);
		companybd = new CompanyBD(sessionFactoryClusterMap);
		addressbd = new AddressBD(sessionFactoryClusterMap);
		locationbd = new LocationBD(sessionFactoryClusterMap);
		orderhdrbd = new OrderhdrBD(sessionFactoryClusterMap);
		vesselbd = new VesselBD(sessionFactoryClusterMap);
		sihdrbd = new SihdrBD(sessionFactoryClusterMap);
		sidtlbd = new SidtlBD(sessionFactoryClusterMap);
		pihdrbd = new PihdrBD(sessionFactoryClusterMap);
		pidtlbd = new PidtlBD(sessionFactoryClusterMap);
		pidtlcostbd = new PidtlcostBD(sessionFactoryClusterMap);


		log.debug(
				"["+this.getClass().getName()+"] "+new Date()+
				" Build Document: "+aioutdao.getDockey()
		);
		TreeMap<String,StringBuffer> returnParams = new TreeMap<String,StringBuffer>();



		//Build Account Receivable Actuals 
		try {
			if (aioutdao.getDoctype().equals(com.bureaueye.beacon.bean.Constants.AR_ACTUAL)) {
				returnParams=buildAR_ACTUAL(aioutdao);
			}
		} catch (Exception e) {
			log.error(
					"["+this.getClass().getName()+"] "+new Date()+
					" Build Document: "+aioutdao.getDoctype()+
					" Dockey: "+aioutdao.getDockey()+					
					" Exception: "+e.getMessage()
			);			
		}



		//Build Account Payable Actuals 
		try {
			if (aioutdao.getDoctype().equals(com.bureaueye.beacon.bean.Constants.AP_ACTUAL)) {
				returnParams=buildAP_ACTUAL(aioutdao);
			}
		} catch (Exception e) {
			log.error(
					"["+this.getClass().getName()+"] "+new Date()+
					" Build Document: "+aioutdao.getDoctype()+
					" Dockey: "+aioutdao.getDockey()+					
					" Exception: "+e.getMessage()
			);			
		}



		// clear business delegates		 		
		aioutbd = null;
		companybd = null;
		addressbd = null;
		locationbd = null;
		orderhdrbd = null;
		vesselbd = null;
		sihdrbd = null;
		sidtlbd = null;
		pihdrbd = null;
		pidtlbd = null;
		pidtlcostbd = null;


		return returnParams;

	}


	void println(String s) { System.out.println(s); }


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
		_maxprocesstime.add(Calendar.MILLISECOND,MAX_PROCESS_TIME);

		log.info(
				"["+this.getClass().getName()+"] "+new Date()+
				" isblocked: "+_currenttime.after(_maxprocesstime)+
				" currenttime: "+_currenttime.getTime()+
				" maxprocesstime: "+_maxprocesstime.getTime()
		);

		if (_currenttime.after(_maxprocesstime)) return true;
		return false;
	}





	public static TreeMap<String,StringBuffer> buildAR_ACTUAL(Aiout aioutdao) throws Exception {


		TreeMap<String,StringBuffer> returnParams = new TreeMap<String,StringBuffer>();
		StringBuffer document = new StringBuffer("");
		StringBuffer errors = new StringBuffer("");
		StringBuffer warnings = new StringBuffer("");

		document.append(documentPrefix);

		int segmentCount=0;



		// retrieve sales invoice header
		Sihdr sihdrdao = null;
		try {						
			sihdrdao = sihdrbd.findSihdrByInvoiceno(aioutdao.getDockey());
		} catch(ApplicationException e) {				
		}

		// retrieve sales details
		List<SidtlDTO> sidtldaos = new LinkedList<SidtlDTO>();
		try {						
			sidtldaos = sidtlbd.findSidtlsById(
					sihdrdao.getSihdrId().toString(), 
					0, 
					com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT, 
					"Chargekey"
			);
		} catch (ApplicationException e) {
		}

		// retrieve company
		Company companydao = null;
		try {						
			companydao = companybd.read(aioutdao.getCompanykey());
		} catch(ApplicationException e) {			
		}
		
		// retrieve order header
		Orderhdr orderhdrdao = null;
		try {						
			orderhdrdao = orderhdrbd.findOrderhdrByOrderno(sihdrdao.getOrderno());
		} catch(ApplicationException e) {			
		}
		

		//HEADER VALIDATION----------------------------------------------------->
		if (sihdrdao==null) {
			errors.append(
					setError(
							"0001",
							"sihdr",
							"Sales Invoice Header not found for ["+aioutdao.getDockey()+"]"
					)
			);
		}

		// lookup company						
		String accSyscompid="";
		accSyscompid=companydao.getAccsyscompid();						
		if (accSyscompid.equals("")) {
			errors.append(
					setError(
							"0002",
							"company",
							"Company Mapping code Not Found for ["+companydao.getCompid()+"]"
					)
			);								
		}

		//check details found
		if (sidtldaos.size()==0) {
			errors.append(
					setError(
							"0003",
							"pidtlcost",
							"Sales Invoice Details Not Found for ["+aioutdao.getDockey()+"]"
					)
			);								
		}

		if (orderhdrdao==null) {
			errors.append(
					setError(
							"0004",
							"orderhdr",
							"Order Header not found for Invno ["+aioutdao.getDockey()+"] "+
							"Orderno ["+sihdrdao.getOrderno()+"]"
					)
			);
		}
		
		//check order no exists
		if (sihdrdao.getOrderno().equals("")) {
			errors.append(
					setWarning(
							"0005",
							"sihdr",
							"Order Number is blank for ["+aioutdao.getDockey()+"]"
					)
			);								
		}		
		//HEADER VALIDATION-----------------------------------------------------<







		//----------------------------------------------------------------------------------------------
		// 
		// HEADER PROCESS
		//
		//----------------------------------------------------------------------------------------------
		try {

			// lookup customer name
			String customerName = "";
			String accSysaddressid = "";
			try{
				Address address = new Address();				
				address = addressbd.read( sihdrdao.getCustomeraddrkey() );
				customerName = address.getName(); 
				accSysaddressid = address.getAccsysaddressid();
			} catch(Exception e){
				warnings.append(
						setWarning(
								"0010",
								"address",
								"Address not found for Code ["+sihdrdao.getCustomeraddrkey()+"]"
						)
				);				
			}

			// lookup location name
			String portName = "";
			try{
				Location location = new Location();				
				location = locationbd.read(orderhdrdao.getLdglocationkey2() );
				portName = location.getLocationName(); 
			} catch(Exception e){
				warnings.append(
						setWarning(
								"0011",
								"location",
								"Location not found for Code ["+orderhdrdao.getLdglocationkey2()+"]"
						)
				);				
			}

			// lookup vessel name
			String vesselName = "";
			try{
				Vessel vessel = new Vessel();				
				vessel = vesselbd.read(orderhdrdao.getShipvessel() );
				vesselName = vessel.getVesselname(); 
			} catch(Exception e){
				warnings.append(
						setWarning(
								"0012",
								"vessel",
								"Vessel not found for Code ["+orderhdrdao.getShipvessel()+"]"
						)
				);				
			}
			
			
			document.append(headerPrefix);		

			try {
				document.append(setHeader("CompanyId",accSyscompid));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("ContactName",customerName));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("BillToCustAddrId",accSysaddressid));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("CustPONo",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("DiscDate",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("DueDate",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("FOBID",accSyscompid));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("InvCurrID",sihdrdao.getInvoiceccykey()));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("InvCurrExchRate","1"));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("PmtTermsID",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("SalesPersonID",accSyscompid));	
				segmentCount++;
			} catch (Exception e) {
			}			

			try {
				document.append(setHeader("ShipToCustAddrID",""));	
				segmentCount++;
			} catch (Exception e) {
			}	

			try {
				document.append(setHeader("Tranamt",sihdrdao.getInvoiceamt().toString()));	
				segmentCount++;
			} catch (Exception e) {
			}	

			try {
				document.append(setHeader("TranCmnt",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader(
						"TranDate",
						com.bureaueye.beacon.util.Util.dateTextFormat6(sihdrdao.getPrintdate()))
				);	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("TranNo",sihdrdao.getInvoiceno()));	
				segmentCount++;
			} catch (Exception e) {
			}							

			
			//s201400040
/*			try {
				document.append(setHeader("TranTypeID", "IN"));
				segmentCount++;
			} catch (Exception e) {
			}*/
			try {
				String tranTypeId="IN";
				if (sihdrdao.getInvoiceamt().doubleValue()<0.0) tranTypeId="CM";
				document.append(setHeader("TranTypeID", tranTypeId));
				segmentCount++;
			} catch (Exception e) {
			}
			//e201400040

			
			try {
				document.append(setHeader("WSJobNo",sihdrdao.getOrderno()));	
				segmentCount++;
			} catch (Exception e) {
			}			

			try {
				document.append(setHeader("WSContainerID",vesselName));	
				segmentCount++;
			} catch (Exception e) {
			}	

			try {
				document.append(setHeader("WSBOL",portName));	
				segmentCount++;
			} catch (Exception e) {
			}			

		} catch (Exception e) {
		}												

		document.append(headerSuffix);






		//----------------------------------------------------------------------------------------------
		// 
		// DETAIL PROCESS
		//
		//----------------------------------------------------------------------------------------------
		double recordno=0.0;
		Iterator<SidtlDTO> it = sidtldaos.iterator();
		while (it.hasNext()) {

			SidtlDTO sidtldao = (SidtlDTO)it.next();									

			try {

				document.append(detailPrefix);	


				// initialise detail field values
				recordno++;

				try {
					document.append(setDetail(recordno,"CmntOnly",""));	
					segmentCount++;
				} catch (Exception e) {
				}		

				try {
					document.append(setDetail(recordno,"Description",sidtldao.getTxt1()));	
					segmentCount++;
				} catch (Exception e) {
				}	

				try {
					document.append(setDetail(recordno,"ExtAmt",sidtldao.getChgamt().toString()));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"ExtCmnt",""));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"ItemID",sidtldao.getChargekey().getAccsysitemid()));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"QtyShipped",sidtldao.getUnits().toString()));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"GLAcctNo",sidtldao.getChargekey().getIncacct()));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"LineNumber",recordno+""));	
					segmentCount++;
				} catch (Exception e) {
				}					

				try {
					document.append(setDetail(recordno,"TradeDiscAmt",""));	
					segmentCount++;
				} catch (Exception e) {
				}	

				try {
					document.append(setDetail(recordno,"UnitCost",""));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"UnitPrice",sidtldao.getRate().toString()));	
					segmentCount++;
				} catch (Exception e) {
				}


				document.append(detailSuffix);	

			} catch (Exception e) {
			}


		} //loop sidtl records 



		document.append(documentSuffix);




		if (!errors.toString().equals("")) {
			errors.insert(0,errorsPrefix);
			errors.append(errorsSuffix);
		}
		if (!warnings.toString().equals("")) {
			warnings.insert(0,warningsPrefix);
			warnings.append(warningsSuffix);
		}

		returnParams.put("1",document);
		returnParams.put("2",errors);
		returnParams.put("3",warnings);

		return returnParams;

	}



	public static TreeMap<String,StringBuffer> buildAP_ACTUAL(Aiout aioutdao) throws Exception {


		TreeMap<String,StringBuffer> returnParams = new TreeMap<String,StringBuffer>();
		StringBuffer document = new StringBuffer("");
		StringBuffer errors = new StringBuffer("");
		StringBuffer warnings = new StringBuffer("");

		document.append(documentPrefix);

		int segmentCount=0;



		// retrieve purchase invoice header
		Pihdr pihdrdao = null;
		try {						
			pihdrdao = pihdrbd.findPihdrByPino(aioutdao.getDockey());
		} catch(ApplicationException e) {			
		}

		// retrieve purchase invoice details
		List<PidtlDTO> pidtldaos = new LinkedList<PidtlDTO>();
		List<PidtlcostDTO> pidtlcostdaos = new LinkedList<PidtlcostDTO>();
		List<PidtlcostDTO> pidtlcostdaos2 = new LinkedList<PidtlcostDTO>();			
		try {				
			pidtldaos = pidtlbd.findPidtlsById(
									pihdrdao.getPihdrId().toString(),
									"JobhdrId"
									);	

			Iterator<PidtlDTO> it1 = pidtldaos.iterator();
			while (it1.hasNext()) {
				PidtlDTO pidtldao = (PidtlDTO)it1.next();

				pidtlcostdaos=pidtlcostbd.findPidtlcostsById(
												pidtldao.getPidtlId().toString(),
												0,
												com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT,
												"Costkey"
												);

				Iterator<PidtlcostDTO> it2 = pidtlcostdaos.iterator();
				while (it2.hasNext()) {
					PidtlcostDTO pidtlcostdao = (PidtlcostDTO)it2.next();
					pidtlcostdaos2.add(pidtlcostdao);
				}

			}

		} catch (ApplicationException e) {
		}

		// retrieve company
		Company companydao = null;
		try {						
			companydao = companybd.read(aioutdao.getCompanykey());
		} catch(ApplicationException e) {			
		}

		// retrieve order header
		Orderhdr orderhdrdao = null;
		try {						
			orderhdrdao = orderhdrbd.findOrderhdrByOrderno(pihdrdao.getOrderno());
		} catch(ApplicationException e) {			
		}


		//HEADER VALIDATION----------------------------------------------------->
		if (pihdrdao==null) {
			errors.append(
					setError(
							"0001",
							"pihdr",
							"Purchase Invoice Header not found for ["+aioutdao.getDockey()+"]"
					)
			);
		}

		// lookup company						
		String accSyscompid="";
		accSyscompid=companydao.getAccsyscompid();						
		if (accSyscompid.equals("")) {
			errors.append(
					setError(
							"0002",
							"company",
							"Company Mapping code Not Found for ["+companydao.getCompid()+"]"
					)
			);								
		}	

		//check details found
		if (pidtlcostdaos2.size()==0) {
			errors.append(
					setError(
							"0003",
							"pidtlcost",
							"Purchase Invoice Details Not Found for ["+aioutdao.getDockey()+"]"
					)
			);								
		}
		
		if (orderhdrdao==null) {
			errors.append(
					setError(
							"0004",
							"orderhdr",
							"Order Header not found for Invno ["+aioutdao.getDockey()+"] "+
							"Orderno ["+pihdrdao.getOrderno()+"]"
					)
			);
		}
		
		//check order no exists
		if (pihdrdao.getOrderno().equals("")) {
			errors.append(
					setWarning(
							"0005",
							"sihdr",
							"Order Number is blank for ["+aioutdao.getDockey()+"]"
					)
			);								
		}		
		//HEADER VALIDATION-----------------------------------------------------<







		//----------------------------------------------------------------------------------------------
		// 
		// HEADER PROCESS
		//
		//----------------------------------------------------------------------------------------------
		try {

			// lookup address
			String accSysaddressid = "";
			Address address = new Address();
			try{
				address = addressbd.read( pihdrdao.getVendoraddrkey() );
				accSysaddressid = address.getAccsysaddressid();
			} catch(Exception e){
				warnings.append(
						setWarning(
								"0010",
								"address",
								"Address not found for Code ["+pihdrdao.getVendoraddrkey()+"]"
						)
				);				
			}

			// lookup location name
			String portName = "";
			try{
				Location location = new Location();				
				location = locationbd.read(orderhdrdao.getLdglocationkey2() );
				portName = location.getLocationName(); 
			} catch(Exception e){
				warnings.append(
						setWarning(
								"0011",
								"location",
								"Location not found for Code ["+orderhdrdao.getLdglocationkey2()+"]"
						)
				);				
			}

			// lookup vessel name
			String vesselName = "";
			try{
				Vessel vessel = new Vessel();				
				vessel = vesselbd.read(orderhdrdao.getShipvessel() );
				vesselName = vessel.getVesselname(); 
			} catch(Exception e){
				warnings.append(
						setWarning(
								"0012",
								"vessel",
								"Vessel not found for Code ["+orderhdrdao.getShipvessel()+"]"
						)
				);				
			}
			
			
			document.append(headerPrefix);		

			try {
				document.append(setHeader("CompanyId",accSyscompid));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("InvoiceNo",pihdrdao.getVendorref()));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("CheckNo",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("Checkdate",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("Checkamt",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("DiscDate",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("DueDate",""));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("InvAmt",pihdrdao.getNetamt().toString()));	
				segmentCount++;
			} catch (Exception e) {
			}	

			try {
				document.append(setHeader("InvCurrID",pihdrdao.getCcykey()));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("InvCurrExchRate","1"));	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader(
						"InvDate",
						com.bureaueye.beacon.util.Util.dateTextFormat6(pihdrdao.getInvoicedate()))
				);	
				segmentCount++;
			} catch (Exception e) {
			}

			try {
				document.append(setHeader("InvHdrCmnt",""));	
				segmentCount++;
			} catch (Exception e) {
			}					

			
			//s201400040
/*			try {
				document.append(setHeader("InvType","IN"));	
				segmentCount++;
			} catch (Exception e) {
			}*/
			try {
				String invType="IN";
				if (pihdrdao.getNetamt().doubleValue()<0.0) invType="DM";
				document.append(setHeader("InvType", invType));
				segmentCount++;
			} catch (Exception e) {
			}
			//e201400040

			
			try {
				document.append(setHeader("VendID",accSysaddressid));	
				segmentCount++;
			} catch (Exception e) {
			}			

			try {
				document.append(setHeader("PmtTermsID",""));	
				segmentCount++;
			} catch (Exception e) {
			}				

			try {
				document.append(setHeader("WSJobNo",pihdrdao.getOrderno()));	
				segmentCount++;
			} catch (Exception e) {
			}			

			try {
				document.append(setHeader("WSContainerID",vesselName));	
				segmentCount++;
			} catch (Exception e) {
			}	

			try {
				document.append(setHeader("WSBOL",portName));	
				segmentCount++;
			} catch (Exception e) {
			}	
			
		} catch (Exception e) {
		}												

		document.append(headerSuffix);



		//----------------------------------------------------------------------------------------------
		// 
		// DETAIL PROCESS
		//
		//----------------------------------------------------------------------------------------------
		double recordno=0.0;
		Iterator<PidtlcostDTO> it = pidtlcostdaos2.iterator();
		while (it.hasNext()) {

			PidtlcostDTO pidtlcostdao = (PidtlcostDTO)it.next();									

			try {

				document.append(detailPrefix);	


				// initialise detail field values
				recordno++;

				try {
					document.append(setDetail(recordno,"LineNumber",recordno+""));	
					segmentCount++;
				} catch (Exception e) {
				}
				
				try {
					document.append(setDetail(recordno,"ItemID",pidtlcostdao.getCostkey().getAccsysitemid()));	
					segmentCount++;
				} catch (Exception e) {
				}	

				try {
					document.append(setDetail(recordno,"ItemDesc",pidtlcostdao.getTxt1()));	
					segmentCount++;
				} catch (Exception e) {
				}	

				try {
					document.append(setDetail(recordno,"ExtAmt",pidtlcostdao.getCstamtalloc().toString()));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"ExtCmnt",""));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"Qty","1"));	
					segmentCount++;
				} catch (Exception e) {
				}			

				try {
					document.append(setDetail(recordno,"UnitCost",pidtlcostdao.getCstamtalloc().toString()));	
					segmentCount++;
				} catch (Exception e) {
				}

				try {
					document.append(setDetail(recordno,"GLAcctNo",pidtlcostdao.getCostkey().getActlacct()));	
					segmentCount++;
				} catch (Exception e) {
				}		

				document.append(detailSuffix);	

			} catch (Exception e) {
			}


		} //loop sidtl records 


		document.append(documentSuffix);


		if (!errors.toString().equals("")) {
			errors.insert(0,errorsPrefix);
			errors.append(errorsSuffix);
		}
		if (!warnings.toString().equals("")) {
			warnings.insert(0,warningsPrefix);
			warnings.append(warningsSuffix);
		}

		returnParams.put("1",document);
		returnParams.put("2",errors);
		returnParams.put("3",warnings);

		return returnParams;

	}









	public static String setWarning(String id, String field, String msg) 
	{	
		String _warning ="";
		_warning = 
			warningPrefix+
			idPrefix+
			"<![CDATA["+id+"]]>"+
			idSuffix+
			fieldPrefix+
			"<![CDATA["+field+"]]>"+
			fieldSuffix+
			msgPrefix+
			"<![CDATA["+msg+"]]>"+
			msgSuffix+
			warningSuffix;

		return _warning; 	
	}



	public static String setError(String id, String field, String msg) 
	{	
		String _error ="";
		_error = 
			errorPrefix+
			idPrefix+
			"<![CDATA["+id+"]]>"+
			idSuffix+
			fieldPrefix+
			"<![CDATA["+field+"]]>"+
			fieldSuffix+
			msgPrefix+
			"<![CDATA["+msg+"]]>"+
			msgSuffix+
			errorSuffix;

		return _error; 	
	}







	public static String setHeader(String name, String value) 
	{	
		/*		String returnString = headerPrefix;
		returnString=returnString+namePrefix+"<![CDATA["+name+"]]>"+nameSuffix;
		returnString=returnString+valuePrefix+"<![CDATA["+value+"]]>"+valueSuffix;	
		returnString=returnString+headerSuffix;*/
		String returnString="<"+name+">"+"<![CDATA["+value+"]]>"+"</"+name+">";		
		return returnString; 	
	}


	public static String setDetail(double recordno, String name, String value) 
	{	
		/*		String returnString = detailPrefix;						
		returnString=returnString+recordnoPrefix+"<![CDATA["+recordno+"]]>"+recordnoSuffix;
		returnString=returnString+namePrefix+"<![CDATA["+name+"]]>"+nameSuffix;
		returnString=returnString+valuePrefix+"<![CDATA["+value+"]]>"+valueSuffix;
		returnString=returnString+detailSuffix;	*/	
		String returnString="<"+name+">"+"<![CDATA["+value+"]]>"+"</"+name+">";		
		return returnString; 	
	}









}

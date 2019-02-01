package com.bureaueye.genesys.action.finance;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.standard.Constants;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.salesinvoice.bd.SidocnoBD;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.contract.Contracteqp;
import com.bureaueye.genesys.model.contract.Contracteqploc;
import com.bureaueye.genesys.model.contract.bd.ContractBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;
import com.bureaueye.genesys.model.contract.bd.ContracteqplocBD;
import com.bureaueye.genesys.model.finance.Financedtl;
import com.bureaueye.genesys.model.finance.Financehdr;
import com.bureaueye.genesys.model.finance.bd.FinancedtlBD;
import com.bureaueye.genesys.model.finance.bd.FinancehdrBD;
import com.bureaueye.genesys.model.finance.dto.OnhireeqpBillingrunDTO;
import com.bureaueye.genesys.model.offhire.Offhireeqp;
import com.bureaueye.genesys.model.offhire.Offhireeqpotc;
import com.bureaueye.genesys.model.offhire.bd.OffhireeqpBD;
import com.bureaueye.genesys.model.onhire.Onhireeqp;
import com.bureaueye.genesys.model.onhire.Onhireeqpotc;
import com.bureaueye.genesys.model.onhire.bd.OnhireeqpBD;






public final class EditBillingrunAction extends BaseAction {

	private static Date[] _fromdayDate;
	private static Date[] _todayDate;
	private static float[] _rate;
	private static int _doclineno;


	private static Financedtl _findtl;
	private static Financehdr _finhdr;


	// business delagates
	private static OnhireeqpBD onhireeqpbd;
	private static OffhireeqpBD offhireeqpbd;
	private static FinancehdrBD financehdrbd;
	private static FinancedtlBD financedtlbd;
	private static ContracteqplocBD contracteqplocbd;
	private static ContracteqpBD contracteqpbd;
	private static ContractBD contractbd;

	private static User _user;



	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {

		HttpSession session = request.getSession(false);	
		ListForm listForm = (ListForm) form;
		_user = (User) session.getAttribute(Constants.USER_KEY);


		// process variables
		int _month = 0, _year = 0;
		String _companykey = "",_leasetypekey = "";	
		java.util.Date _calendarfromDate	= null;
		java.util.Date _calendartoDate	= null;
		java.util.Date _calendartoDateAdvance = null;		
		java.util.Date _billfromDate	= null;
		java.util.Date _billtoDate	= null;
		java.util.Date _billtoDateAdvance = null;
		java.util.Date _docdate	= null;
		Integer _contractId = null;

		_fromdayDate = new Date[5];
		_todayDate = new Date[5];
		_rate = new float[5];			
		_doclineno = 0;


		// business delagates
		onhireeqpbd = new OnhireeqpBD(this.getSessionFactoryClusterMap());
		offhireeqpbd = new OffhireeqpBD(this.getSessionFactoryClusterMap());
		financehdrbd = new FinancehdrBD(this.getSessionFactoryClusterMap());
		financedtlbd = new FinancedtlBD(this.getSessionFactoryClusterMap());
		contracteqplocbd = new ContracteqplocBD(this.getSessionFactoryClusterMap());
		contracteqpbd = new ContracteqpBD(this.getSessionFactoryClusterMap());
		contractbd = new ContractBD(this.getSessionFactoryClusterMap());


		// convert billing date period 
		// init calendar object
		Calendar calendar = Calendar.getInstance();
		// set calendar to start of month
		calendar.set(
				new Integer(listForm.getSearchDate2yyyy()).intValue(),
				new Integer(listForm.getSearchDate2mm()).intValue()-1,
				1
		);
		_docdate = calendar.getTime();			

		// set calendar to start of previous month
		calendar.set(
				new Integer(listForm.getSearchDate2yyyy()).intValue(),
				new Integer(listForm.getSearchDate2mm()).intValue()-2,
				1
		);
		_calendarfromDate = calendar.getTime();

		// set calendar to end of month
		// add 1 month to date
		calendar.add(Calendar.MONTH, 1);
		// subtract day from date to get last day of month
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		_calendartoDate = calendar.getTime();

		// set calendar to end of Next month for ADVANCE billing
		// add 1 month to date
		// set calendar to start of month
		calendar.set(
				new Integer(listForm.getSearchDate2yyyy()).intValue(),
				new Integer(listForm.getSearchDate2mm()).intValue(),
				1
		);
		// subtract day from date to get last day of month
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		_calendartoDateAdvance = calendar.getTime();


		//List onhireeqpbillList = (List) modelonhire.getOnhireEqpListForBilling();
		List _dtos = onhireeqpbd.findOnhireeqpsForBillingrun();
		Contract _contract = null;

		// process onhires
		Iterator i = _dtos.iterator();
		while (i.hasNext()) {

			OnhireeqpBillingrunDTO _dto = (OnhireeqpBillingrunDTO) i.next();
			_billtoDate = _calendartoDate;
			_billfromDate = _calendarfromDate;
			_billtoDateAdvance = _calendartoDateAdvance;

			// check for contractid break
			if (_contractId != _dto.getContractId()) {
				_contract = contractbd.read(_dto.getContractId());

				// save financial header 
				_finhdr = new Financehdr();

				_finhdr.setDocdate(_docdate);
				_finhdr.setDoctypekey("INV"); // invoice
				_finhdr.setCcykey(_dto.getBillccykey());

				_finhdr.setLesseeaddrkey(_dto.getLesseeaddrkey());

				_finhdr.setContractno(_dto.getContractno());

				_finhdr.setContractId(_dto.getContractId());
				_finhdr.setLeasetypekey(_dto.getLeasetypekey());
				_finhdr.setBilldate(new java.util.Date());
				_finhdr.setCompanykey(_dto.getCompanykey());
				_finhdr.setDepartmentkey(_dto.getDepartmentkey());
				_finhdr.setActivitykey(_dto.getActivitykey());	

				//init zero amounts
				_finhdr.setCashallocpayout(new BigDecimal(0.0));
				_finhdr.setNetamount(new BigDecimal(0.0));
				_finhdr.setGrossamount(new BigDecimal(0.0));
				_finhdr.setVatamount(new BigDecimal(0.0));
				_finhdr.setPayoutamount(new BigDecimal(0.0));
				_finhdr.setCashalloctotal(new BigDecimal(0.0));

				// update invoice no, print date
				Calendar c = Calendar.getInstance();
				_finhdr.setPrintdate(c.getTime());
				_finhdr.setPrinttime(com.bureaueye.beacon.util.Util.toTime(c));
				_finhdr.setPrintedflag(true);
				_finhdr.setManualflag(false);
				int nextdocno = 0;
				try {
					nextdocno = new SidocnoBD(this.getSessionFactoryClusterMap()).getNextDocno(
							"INV",
							_finhdr.getCompanykey(),
							c.get(Calendar.YEAR),
							_user
					);
				} catch (Exception e) {}
				_finhdr.setDockey(new Integer(nextdocno).toString());

				financehdrbd.createOrUpdate(_finhdr, _user);
				log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
						" create financehdr: "+_finhdr.getFinancehdrId()+
						" with dockey: "+_finhdr.getDockey());

				// store contractkey
				_contractId = _dto.getContractId();
				// reset doclineno field
				_doclineno = 0;
			}



			// set billing details
			_findtl = new Financedtl();
			_findtl.setFinancehdrId(_finhdr.getFinancehdrId());
			_findtl.setDockey(_finhdr.getDockey());
			_findtl.setUnitkey(_dto.getUnitkey());
			_findtl.setUnitId(_dto.getUnitId());
			_findtl.setEqpkey(_dto.getEqpkey());
			_findtl.setOnhireno(_dto.getOnhireno());
			_findtl.setOnhireId(_dto.getOnhireId());
			_findtl.setOnhireeqpId(_dto.getOnhireeqpId());			
			_findtl.setOnhiredate(_dto.getOnhiredate());
			_findtl.setContractno(_dto.getContractno());
			_findtl.setContractId(_dto.getContracteqpId());
			_findtl.setContracteqpId(_dto.getContracteqpId());
			_findtl.setContracteqplocId(_dto.getContracteqplocId());			
			_findtl.setLesseeaddrkey(_dto.getLesseeaddrkey());
			_findtl.setLocationkey(_dto.getLocationkey());				
			_findtl.setLeasetypekey(_dto.getLeasetypekey());
			_findtl.setCcykey(_dto.getBillccykey());
			_findtl.setTxt1("");
			_findtl.setTxt2("");

			//init zero amounts
			_findtl.setNetamount(new BigDecimal(0.0));
			_findtl.setGrossamount(new BigDecimal(0.0));
			_findtl.setVatamount(new BigDecimal(0.0));
			_findtl.setPaidtoinv(new BigDecimal(0.0));

			// initialise contract rates
			setContractBillingRates(_dto.getContracteqpId(), _dto.getBillstartdate());

			// get offhire eqp - if exists then unit has been offhired
			Offhireeqp _offhireeqp = null;
			_offhireeqp = offhireeqpbd.findOffhireeqpByKey2( 
					_findtl.getUnitId(),
					_findtl.getOnhireId(),
					"Y"
			);

			// has onhire been billed before
			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" billOnhireCharges: "+!_dto.isBillstart());

			if (!_dto.isBillstart()) {			
				// not billed before - bill onhire charges
				billOnhireCharges();
				// set bill start flag
				_dto.setBillstart(true);
				// initialise billing from date
				_billfromDate = _dto.getBillstartdate(); 					
			}	
			else {
				// check bill upto date is before bill start date
				if (_dto.getBilluptodate().before(_dto.getBillstartdate())) {
					// initialise billing from date with bill start date
					_billfromDate = _dto.getBillstartdate();
				}
				else {
					// initialise billing from date with 
					//  last bill upto date						
					_billfromDate = Util.dateDaysAdd(_dto.getBilluptodate(), 1);
				}
				log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
						" init _billfromDate: "+_billfromDate);					
			}

			// has unit been offhired
			if (_offhireeqp != null) {

				// set Id values 
				_findtl.setOffhireId(_offhireeqp.getOffhireId());
				_findtl.setOffhireeqpId(_offhireeqp.getOffhireeqpId());

				log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
						" billOffhireCharges: Offhiredate="+_offhireeqp.getOffhiredate()+" _billtodate="+_billtoDate);					
				// initialise billing end date
				if (_offhireeqp.getOffhiredate().before(_billtoDate)) { 
					_billtoDate = Util.dateDaysAdd(_offhireeqp.getOffhiredate(),0);
					// bill offhire charges
					billOffhireCharges();						
					// set billfinish
					_offhireeqp.setBillfinish(true);
					_dto.setBillfinish(true);
					_offhireeqp.setBillstopdate(_billtoDate);

					// store offhire details
					offhireeqpbd.createOrUpdate(_offhireeqp, _user);

					_findtl.setOffhiredate(_offhireeqp.getOffhiredate());						
				}

			}	

			// if unit has not been off-hired and contract ADVANCE billing
			// - bill upto end of the billing period
			if (_offhireeqp == null) {
				if (_contract.getBilltype().equals("ADVANCE")) _billtoDate=_billtoDateAdvance;
			}

			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" billRental: "+
					" billfromDate="+_billfromDate+
					" billtoDate="+_billtoDate+
					" billtype="+_contract.getBilltype()
			);	

			// set rental billing date
			Date _date = _billfromDate;
			float _total = 0;
			int _days = 0;

			// loop through dates
			while ( _date.before(_billtoDate) ||
					_date.equals(_billtoDate) ) {
				try {
					_total = _total + getContractBillingRate(_date);
					_days++;					
				}
				catch (Exception e) {
					log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
							" rental billing failed: "+e.getMessage());
				}
				// increment bill date
				_date = Util.dateDaysAdd(_date, 1);

				log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
						" increment billdate: _date="+_date);				
			}






			// set rental fields
			_findtl.setNetamount(new BigDecimal(_total));
			_findtl.setBillfromdate(_billfromDate);
			_findtl.setBilltodate(_billtoDate);
			_findtl.setDays(new Integer(_days));

			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" billRental: _days="+_days);	
			if (_findtl.getDays().intValue() > 0) {
				// create financial detail for rental
				billRental();						

				// update details
				// store onhire details
				_dto.setBilluptodate(_billtoDate);
				// find onhireeqp record
				Onhireeqp _onhireeqp = onhireeqpbd.read(_dto.getOnhireeqpId());
				if (_onhireeqp != null) {
					// init values
					_onhireeqp.setBillfinish(_dto.isBillfinish());
					_onhireeqp.setBilluptodate(_dto.getBilluptodate());
					_onhireeqp.setBillstart(_dto.isBillstart());
					// update record
					onhireeqpbd.createOrUpdate(_onhireeqp, _user);
				}
			}


			log.info("["+this.getClass().getName()+"] "+new java.util.Date()+
					" before update financehdr: "+_finhdr.getFinancehdrId());	

			// update financial header 
			try {
				financehdrbd.createOrUpdate(_finhdr, _user);
			}
			catch (Exception e) {
				log.error("["+this.getClass().getName()+"] "+new java.util.Date()+
						" update financehdr failed: "+e.getMessage());
			}

		} // loop onhireeqp records



		// clear business delagates for garbage collection
		onhireeqpbd = null;
		offhireeqpbd = null;
		financehdrbd = null;
		financedtlbd =  null;
		contracteqplocbd = null;
		contracteqpbd = null;	
		contractbd = null;


		// Forward control to the edit page
		log.info("["+this.getClass().getName()+"] "+new java.util.Date()+"  Forwarding to 'success' page");

		return findSuccess(mapping);

	}




	/**
	 */
	public static void billOffhireCharges() { 

		// init vars
		_findtl.setDays(new Integer(0));   											  
		_findtl.setDoctypekey("INV");		
		_findtl.setBillfromdate(null);
		_findtl.setBilltodate(null);

		Contracteqploc _contracteqploc = new Contracteqploc();

		try {
			_contracteqploc = contracteqplocbd.read(_findtl.getContracteqplocId());								
		} catch (Exception e) {}

		try {
			if (_contracteqploc != null && _contracteqploc.getHandchg().compareTo(new BigDecimal(0.0))==1) {
				_findtl.setNetamount(_contracteqploc.getHandchg());

				// TODO: getVatamount()
				//getVatamount();				

				//String rowid = Util.assignRowid();
				//_findtl.setRowid(Integer.parseInt(rowid));				
				_doclineno++;
				_findtl.setDoclineno(new Integer(_doclineno));
				_findtl.setSubtypekey("DOHD"); // handling charge  on contracteqploc				

				try {
					// reset key for new record
					_findtl.setFinancedtlId(null);

					// store record
					financedtlbd.createOrUpdate(_findtl, _user);

					// increment header total
					_finhdr.setNetamount( _finhdr.getNetamount().add(_findtl.getNetamount()) );	
				}
				catch (Exception e) {}				

			}
		}
		catch (Exception e) {}


		try {	
			// get otcs to bill
			List _otcs = null; 
			_otcs = offhireeqpbd.getOffhireeqpotcs(_findtl.getOffhireeqpId());

			if (_otcs != null) {
				// process otcs
				Iterator i = _otcs.iterator();
				while (i.hasNext()) {
					Offhireeqpotc _otc = (Offhireeqpotc) i.next();

					try {
						_findtl.setNetamount(_otc.getChargeamt());

						// TODO: getVatamount()
						// getVatamount();

						_doclineno++;
						_findtl.setDoclineno(new Integer(_doclineno));
						_findtl.setSubtypekey(_otc.getChargekey()); // otc on _otc


						try {
							// reset key for new record
							_findtl.setFinancedtlId(null);

							// store record
							financedtlbd.createOrUpdate(_findtl, _user);

							// increment header total
							_finhdr.setNetamount( _finhdr.getNetamount().add(_findtl.getNetamount()) );	
						}
						catch (Exception e) {}	

					}											
					catch (Exception e) {}
				} //loop
			}//if

		}
		catch (Exception e) {}													

	}//billOffhireCharges



	/**
	 */
	public static void billOnhireCharges() { 

		// init vars
		_findtl.setDays(new Integer(0));   											  
		_findtl.setDoctypekey("INV");		
		_findtl.setBillfromdate(null);
		_findtl.setBilltodate(null);

		Contracteqploc _contracteqploc = new Contracteqploc();

		try {
			_contracteqploc = contracteqplocbd.read(_findtl.getContracteqplocId());								
		} catch (Exception e) {}

		try {
			if (_contracteqploc != null && _contracteqploc.getHandchg().compareTo(new BigDecimal(0.0))==1) {
				_findtl.setNetamount(_contracteqploc.getHandchg());

				// TODO: getVatamount()
				//getVatamount();				

				_doclineno++;
				_findtl.setDoclineno(new Integer(_doclineno));
				_findtl.setSubtypekey("PUHD"); // handling charge  on contracteqploc				

				try {
					// reset key for new record
					_findtl.setFinancedtlId(null);

					// store record
					financedtlbd.createOrUpdate(_findtl, _user);

					// increment header total
					_finhdr.setNetamount( _finhdr.getNetamount().add(_findtl.getNetamount()) );	
				}
				catch (Exception e) {}				

			}
		}
		catch (Exception e) {}


		try {	
			// get otcs to bill
			List _otcs = null; 
			_otcs = onhireeqpbd.getOnhireeqpotcs(_findtl.getOnhireeqpId());

			if (_otcs != null) {
				// process otcs
				Iterator i = _otcs.iterator();
				while (i.hasNext()) {
					Onhireeqpotc _otc = (Onhireeqpotc) i.next();

					try {

						_findtl.setNetamount(_otc.getChargeamt());

						// TODO: getVatamount()
						// getVatamount();

						_doclineno++;
						_findtl.setDoclineno(new Integer(_doclineno));
						_findtl.setSubtypekey(_otc.getChargekey()); // otc on _otc


						try {
							// reset key for new record
							_findtl.setFinancedtlId(null);

							// store record
							financedtlbd.createOrUpdate(_findtl, _user);

							// increment header total
							_finhdr.setNetamount( _finhdr.getNetamount().add(_findtl.getNetamount()) );	
						}
						catch (Exception e) {}	

					}											
					catch (Exception e) {}
				} //loop
			}//if

		}
		catch (Exception e) {}									

	}//billOnhireCharges



	/**
	 */
	/*   	public static void billOnhireCharges() { 
	 _findtl.setDays(new Integer(0));   											  
	 _findtl.setDoctypekey("INV");		
	 _findtl.setSubtypekey("PUHD"); // handling charge  on contracteqploc
	 _findtl.setBillfromdate(null);
	 _findtl.setBilltodate(null);

	 ContractEqpLoc contracteqploc = new ContractEqpLoc();

	 try {
	 contracteqploc = modelcontract.getContractEqpLoc(
	 _findtl.getContractkey(),
	 _findtl.getEqpkey(),
	 _findtl.getLocationkey(),
	 "ONHIRE"
	 );								
	 }
	 catch (SQLException e) {		
	 }

	 try {
	 if (contracteqploc != null && contracteqploc.getHandchg() > 0) {
	 _findtl.setNetamount(contracteqploc.getHandchg());
	 //				getVatamount();				
	  String rowid = Util.assignRowid();
	  _findtl.setRowid(Integer.parseInt(rowid));				
	  doclineno++;
	  _findtl.setDoclineno(doclineno);
	  modelfinance.insertFinDtl( 
	  _findtl,
	  modellogon								
	  );
	  // increment header total
	   _finhdr.setNetamount( _finhdr.getNetamount()+_findtl.getNetamount() );	
	   }
	   }
	   catch (SQLException e) {		
	   }


	   try {	
	   // get onhires to bill
	    TreeMap contracteqplocotcs = 
	    (TreeMap) modelcontract.getContractEqpLocOtcs(
	    _findtl.getContractkey(),
	    _findtl.getEqpkey(),
	    _findtl.getLocationkey(),
	    "ONHIRE"												
	    );

	    // process otcs
	     Iterator i = contracteqplocotcs.values().iterator();
	     while (i.hasNext()) {
	     ContractEqpLocOtc celo = (ContractEqpLocOtc) i.next();

	     try {
	     _findtl.setNetamount(celo.getChargeamt());
	     //					getVatamount();
	      String rowid = Util.assignRowid();
	      _findtl.setRowid(Integer.parseInt(rowid));					
	      doclineno++;
	      _findtl.setDoclineno(doclineno);
	      _findtl.setSubtypekey(celo.getChargekey()); // otc on contracteqplocotc								
	      modelfinance.insertFinDtl( 
	      _findtl,
	      modellogon							
	      );
	      // increment header total
	       _finhdr.setNetamount( _finhdr.getNetamount()+_findtl.getNetamount() );	
	       }											
	       catch (SQLException e) {		
	       }
	       }

	       }
	       catch (SQLException e) {		
	       }													

	       }*/


	/**
	 */
	public static void billRental () {

		// init vars
		_findtl.setDoctypekey("INV");
		_findtl.setSubtypekey("RNPD");		
		_doclineno++;
		_findtl.setDoclineno(new Integer(_doclineno));

		try {
			// reset key for new record
			_findtl.setFinancedtlId(null);

			// store record
			financedtlbd.createOrUpdate(_findtl, _user);

			// increment header total
			_finhdr.setNetamount( _finhdr.getNetamount().add(_findtl.getNetamount()) );	
			// increment payout amount
			_finhdr.setPayoutamount( _finhdr.getPayoutamount().add(_findtl.getNetamount()) );
		}
		catch (Exception e) {}

	}


	/**
	 */
	public static float getContractBillingRate(
			Date _billdate
	) 
	throws Exception
	{
		if ( _fromdayDate[0] == null ) return _rate[0];

		if ( (_billdate.after(_fromdayDate[0]) &&
				_billdate.before(_todayDate[0])) ||
				_billdate.equals(_fromdayDate[0]) ||
				_billdate.equals(_todayDate[0]) ) 
			return _rate[0];
		if ( (_billdate.after(_fromdayDate[1]) &&
				_billdate.before(_todayDate[1])) ||
				_billdate.equals(_fromdayDate[1]) ||
				_billdate.equals(_todayDate[1]) ) 
			return _rate[1];
		if ( (_billdate.after(_fromdayDate[2]) &&
				_billdate.before(_todayDate[2])) ||
				_billdate.equals(_fromdayDate[2]) ||
				_billdate.equals(_todayDate[2]) ) 
			return _rate[2];
		if ( (_billdate.after(_fromdayDate[3]) &&
				_billdate.before(_todayDate[3])) ||
				_billdate.equals(_fromdayDate[3]) ||
				_billdate.equals(_todayDate[3]) ) 
			return _rate[3];

		return 0;		 		
	}


	/**
	 */
	public static void setContractBillingRates(
			Integer _contracteqpId,
			Date _billstartdate
	) {   											
		try {												
			Contracteqp _contracteqp = contracteqpbd.read(_contracteqpId);	
			_billstartdate = Util.dateDaysAdd(_billstartdate, -1);

			// clear variables
			_fromdayDate[0] = null;
			_todayDate[0] = null;
			_rate[0] = 0;
			_fromdayDate[1] = null;
			_todayDate[1] = null;
			_rate[1] = 0;
			_fromdayDate[2] = null;
			_todayDate[2] = null;
			_rate[2] = 0;
			_fromdayDate[3] = null;
			_todayDate[3] = null;
			_rate[3] = 0;
			_fromdayDate[4] = null;
			_todayDate[4] = null;
			_rate[4] = 0;

			if (_contracteqp.getRate1().floatValue() > 0.0) {
				_fromdayDate[0] = Util.dateDaysAdd(_billstartdate, _contracteqp.getFromday1().intValue());
				_todayDate[0] = Util.dateDaysAdd(_billstartdate, _contracteqp.getToday1().intValue());
				_rate[0] = _contracteqp.getRate1().floatValue();
				_fromdayDate[1] = Util.dateDaysAdd(_billstartdate, _contracteqp.getFromday2().intValue());
				_todayDate[1] = Util.dateDaysAdd(_billstartdate, _contracteqp.getToday2().intValue());
				_rate[1] = _contracteqp.getRate2().floatValue();			
				_fromdayDate[2] = Util.dateDaysAdd(_billstartdate, _contracteqp.getFromday3().intValue());
				_todayDate[2] = Util.dateDaysAdd(_billstartdate, _contracteqp.getToday3().intValue());
				_rate[2] = _contracteqp.getRate3().floatValue();
				_fromdayDate[3] = Util.dateDaysAdd(_billstartdate, _contracteqp.getFromday4().intValue());
				_todayDate[3] = Util.dateDaysAdd(_billstartdate, _contracteqp.getToday4().intValue());
				_rate[3] = _contracteqp.getRate4().floatValue();
				_fromdayDate[4] = Util.dateDaysAdd(_billstartdate, _contracteqp.getFromday5().intValue());
				_todayDate[4] = Util.dateDaysAdd(_billstartdate, _contracteqp.getToday5().intValue());
				_rate[4] = _contracteqp.getRate5().floatValue();			
			}
			else {				
				_rate[0] = _contracteqp.getFixdlyrat().floatValue();
			}	
		}
		catch (Exception e) {
			// clear variables
			_fromdayDate[0] = null;
			_todayDate[0] = null;
			_rate[0] = 0;
			_fromdayDate[1] = null;
			_todayDate[1] = null;
			_rate[1] = 0;
			_fromdayDate[2] = null;
			_todayDate[2] = null;
			_rate[2] = 0;
			_fromdayDate[3] = null;
			_todayDate[3] = null;
			_rate[3] = 0;
			_fromdayDate[4] = null;
			_todayDate[4] = null;
			_rate[4] = 0;		
		}

	}


}

package com.bureaueye.beacon.model.job.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;

import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.util.Util;

public class JobmovDemurrageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String errorflag = "";

	private String row;
	

	// primary key
	private java.lang.Integer _jobmovId1;
	private java.lang.Integer _jobmovId2;

	// key fields
	private String _jobhdrId;
	private String _orderhdrId;
	
	
	private Section _section1 = new Section();
	private Section _section2 = new Section();
	
	private Product _product = new Product();

	private Address _dmrgbilltoaddr = new Address();
	private String _dmrgbilltoaddrkey;
	
	private String _sectionkey1;
	private String _sectionkey2;
	
	private String _productkey;
	

	private java.lang.String _jobno;
	private java.lang.String _orderno;
	
	private java.lang.String _movref1;
	private java.lang.String _movref2;
	
	private java.lang.String _unit;

	private java.lang.String _ccykey;
	
	private Date _lastdmrgfrdate;
	private Date _lastdmrgtodate;
	private Integer _lastdmrgdays;

	
	private Date _fromdate;
	private String _fromtime;
	private java.lang.Long _fromtimeinmillis;	
	private Date _todate;	
	private String _totime;
	private java.lang.Long _totimeinmillis;
	

	
	private String FreeDays;
	private int FreeDaysInt;
	
	private BigDecimal DemRate1;
	private BigDecimal DemRate2;
	private BigDecimal DemRate3;
	private Long DemDays;   	    
	
	private BigDecimal DemAmount1;
	private BigDecimal DemAmount2;
	private BigDecimal DemAmount3;
	private BigDecimal DemAmountTotal;
	
	private int DemPeriod1Int;
	private String DemPeriod1;
	
	private java.util.Date DemPeriod1Date;
	
	private int DemPeriod2Int;
	private String DemPeriod2;
	
	private java.util.Date DemPeriod2Date;
	
	private java.util.Date DemStartDate;
	
	private java.util.Date DemEndDate;
	
  	  	
	private java.util.Date DemurragePrintStartDate;
	private int DemurragePrintStartDateday;
	private int DemurragePrintStartDatemonth;
	private int DemurragePrintStartDateyear;  	    
	
  	  	
	private java.util.Date DemurragePrintEndDate;
	private int DemurragePrintEndDateday;
	private int DemurragePrintEndDatemonth;
	private int DemurragePrintEndDateyear; 
	
	private Long DemurragePrintDays1;
	private Long DemurragePrintDays2;
	private Long DemurragePrintDays3;
	private Long DemurragePrintTotalDays;
	

	private boolean _dmrgfinishflag;	

	

	
	
	
	public JobmovDemurrageDTO (
			Jobmov jobmov1, 
			Jobmov jobmov2, 
			Jobhdr jobhdr,
			Orderhdr orderhdr
			) {
		if (jobmov1 != null) {
			this._sectionkey1 = jobmov1.getSectionkey();
			this._jobmovId1 = jobmov1.getJobmovId();
			this._movref1 = jobmov1.getMovref();
			this._fromdate = jobmov1.getActtodate();
			this._fromtime = jobmov1.getActtotime();		
			this._fromtimeinmillis = jobmov1.getActtotimeinmillis();
			this._lastdmrgfrdate = jobmov1.getLastdmrgfrdate();
			this._lastdmrgtodate = jobmov1.getLastdmrgtodate();
			this._lastdmrgdays = jobmov1.getLastdmrgdays();
		}

		if (jobmov2 != null) {
			this._sectionkey2 = jobmov2.getSectionkey();
			this._jobmovId2 = jobmov2.getJobmovId();
			this._movref2 = jobmov2.getMovref();
			this._todate = jobmov2.getActfromdate();
			this._totime = jobmov2.getActfromtime();			
			this._totimeinmillis = jobmov2.getActfromtimeinmillis();
		}
		
		if (jobhdr != null) {
			this._unit = jobhdr.getUnitkey();
			this._jobhdrId = jobhdr.getJobhdrId().toString();
			this._orderhdrId = jobhdr.getOrderhdrId().toString();
			this._jobno = jobhdr.getJobno();
			this._productkey = jobhdr.getProductkey();
		}		

		if (orderhdr != null) {
			this.FreeDays = "0";
			this.DemPeriod1 = "0";
			this.DemPeriod2 = "0";
			this.DemRate1 = new BigDecimal(0.0);
			this.DemRate2 = new BigDecimal(0.0);
			this.DemRate3 = new BigDecimal(0.0);

			this.DemDays = new Long(0);
			
			this.FreeDaysInt = 0;
			this.DemPeriod1Int = 0;
			this.DemPeriod2Int = 0;
			
			this.FreeDays = orderhdr.getDmrgfreedays().toString();
			this.DemPeriod1 = orderhdr.getDmrgdays1().toString();
			this.DemPeriod2 = orderhdr.getDmrgdays2().toString();
			this.DemRate1 = orderhdr.getDmrgdlyrate1();
			this.DemRate2 = orderhdr.getDmrgdlyrate2();
			this.DemRate3 = orderhdr.getDmrgdlyrate3();
			
			this.DemPeriod1Int = orderhdr.getDmrgdays1();
			this.DemPeriod2Int = orderhdr.getDmrgdays2();
			this.FreeDaysInt = orderhdr.getDmrgfreedays();
			
			this._ccykey = orderhdr.getCcykey();
			this._dmrgbilltoaddrkey = orderhdr.getDmrgbilltoaddrkey();
			this._orderno = orderhdr.getOrderno();
		}
	}
	
	

	
	
	

	public JobmovDemurrageDTO () {}
	
	
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	
	



	/**
     */
	public Date getLastdmrgtodate() {return _lastdmrgtodate;}
	public void setLastdmrgtodate (Date _lastdmrgtodate) {this._lastdmrgtodate = _lastdmrgtodate;}
	/**
     */
	public Date getLastdmrgfrdate() {return _lastdmrgfrdate;}
	public void setLastdmrgfrdate (Date _lastdmrgfrdate) {this._lastdmrgfrdate = _lastdmrgfrdate;}	

	/**
     */
	public boolean getDmrgfinishflag() {return _dmrgfinishflag;}
	public void setDmrgfinishflag(boolean _dmrgfinishflag) {this._dmrgfinishflag = _dmrgfinishflag;}	

	

	/**
	 * Return the value associated with the column: LASTDMRGDAYS
	 */
	public java.lang.Integer getLastdmrgdays () {
		return _lastdmrgdays;
	}

	/**
	 * Set the value related to the column: LASTDMRGDAYS
	 * @param lastdmrgdays the LASTDMRGDAYS value
	 */
	public void setLastdmrgdays (java.lang.Integer lastdmrgdays) {
		this._lastdmrgdays = lastdmrgdays;
	}
	
	/**
     */
	public Date getFromdate() {return _fromdate;}
	public void setFromdate (Date _fromdate) {this._fromdate = _fromdate;}	
	/**
     */
	public String getFromtime() {return _fromtime;}
	public void setFromtime (String _fromtime) {this._fromtime = _fromtime;}
	/**
     */
	public java.lang.Long getFromtimeinmillis() {return _fromtimeinmillis;}
	public void setFromtimeinmillis (java.lang.Long _fromtimeinmillis) {this._fromtimeinmillis = _fromtimeinmillis;}	
	
	/**
     */
	public Date getTodate() {return _todate;}
	public void setTodate (Date _todate) {this._todate = _todate;}	
	/**
     */
	public String getTotime() {return _totime;}
	public void setTotime (String _totime) {this._totime = _totime;}
	/**
     */
	public java.lang.Long getTotimeinmillis() {return _totimeinmillis;}
	public void setTotimeinmillis (java.lang.Long _totimeinmillis) {this._totimeinmillis = _fromtimeinmillis;}	

	
	

	
	/**
     */
	public java.lang.Integer getJobmovId1 () {
		return _jobmovId1;
	}
	/**
	 */
	public void setJobmovId1 (java.lang.Integer _jobmovId) {
		this._jobmovId1 = _jobmovId;
	}

	
	/**
     */
	public java.lang.Integer getJobmovId2 () {
		return _jobmovId2;
	}
	/**
	 */
	public void setJobmovId2 (java.lang.Integer _jobmovId) {
		this._jobmovId2 = _jobmovId;
	}
	
	
	/**
     */
	public String getOrderhdrId () {
		return _orderhdrId;
	}
	/**
	 */
	public void setOrderhdrId (String _orderhdrId) {
		this._orderhdrId = _orderhdrId;
	}
	

	/**
	 * 
	 */
	public Address getDmrgbilltoaddr () {return _dmrgbilltoaddr;}
	/**
	 */
	public void setDmrgbilltoaddr (Address _dmrgbilltoaddr) {this._dmrgbilltoaddr = _dmrgbilltoaddr;}
	
	/**
	 * 
	 */
	public String getDmrgbilltoaddrkey () {return _dmrgbilltoaddrkey;}
	/**
	 */
	public void setDmrgbilltoaddrkey (String _dmrgbilltoaddrkey) {this._dmrgbilltoaddrkey = _dmrgbilltoaddrkey;}
	

	/**
	 * 
	 */
	public Product getProduct() {return _product;}
	/**
	 */
	public void setProduct (Product _product) {this._product = _product;}
	




	/**
	 * Return the value associated with the column: sectionkey
	 */
	public Section getSection1 () {
		return _section1;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param _sectionkey the sectionkey value
	 */
	public void setSection1 (Section _section) {
		this._section1 = _section;
	}


	/**
	 * Return the value associated with the column: sectionkey
	 */
	public Section getSection2 () {
		return _section2;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param _sectionkey the sectionkey value
	 */
	public void setSection2 (Section _section) {
		this._section2 = _section;
	}
	
	



	/**
	 */
	public java.lang.String getOrderno () {
		return _orderno;
	}

/**
	 */
	public void setOrderno (java.lang.String _orderno) {
		this._orderno = _orderno;
	}


	/**
	 */
	public java.lang.String getJobno() {
		return _jobno;
	}

/**
	 */
	public void setJobno(java.lang.String _jobno) {
		this._jobno = _jobno;
	}
	
	

	/**
	 */
	public String getJobhdrId () {return _jobhdrId;}
	/**
	 */
	public void setJobhdrId (String _jobhdrId) {this._jobhdrId = _jobhdrId;}

	/**
	 */
	public java.lang.String getUnit () {return _unit;}
	/**
	 */
	public void setUnit (java.lang.String _unit) {this._unit = _unit;}


	/**
	 */
	public java.lang.String getCcykey () {return _ccykey;}
	/**
	 */
	public void setCcykey (java.lang.String _ccykey) {this._ccykey = _ccykey;}
	
	
	/**
	 */
	public java.lang.String getMovref1 () {return _movref1;}
	/**
	 */
	public void setMovref1 (java.lang.String _movref) {this._movref1 = _movref;}


	/**
	 */
	public java.lang.String getMovref2 () {return _movref2;}
	/**
	 */
	public void setMovref2 (java.lang.String _movref) {this._movref2 = _movref;}
	
	
	






	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey1 () {
		return _sectionkey1;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey1 (java.lang.String sectionkey) {
		this._sectionkey1 = sectionkey;
	}

	/**
	 * Return the value associated with the column: sectionkey
	 */
	public java.lang.String getSectionkey2 () {
		return _sectionkey2;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey2 (java.lang.String sectionkey) {
		this._sectionkey2 = sectionkey;
	}
	
	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public java.lang.String getProductkey () {
		return _productkey;
	}

	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (java.lang.String productkey) {
		this._productkey = productkey;
	}
	
	
	
	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}
	
	
	
	public String getFreeDays() { return FreeDays; }
	public String getDemPeriod1() { return DemPeriod1; }
	public String getDemPeriod2() { return DemPeriod2; }
	public int getFreeDaysInt() { return FreeDaysInt; }
	public int getDemPeriod1Int() { return DemPeriod1Int; }
	public int getDemPeriod2Int() { return DemPeriod2Int; }
	public BigDecimal getDemRate1() { return DemRate1; }
	public BigDecimal getDemRate2() { return DemRate2; }
	public BigDecimal getDemRate3() { return DemRate3; }

	public Long getDemDays() { return DemDays; }
	
	public java.util.Date getDemStartDate() { return DemStartDate; }
	public java.util.Date getDemEndDate() { return DemEndDate; }	
	public java.util.Date getDemPeriod1Date() { return DemPeriod1Date; }
	public java.util.Date getDemPeriod2Date() { return DemPeriod2Date; }
	
	public Long getDemurragePrintDays1() { return DemurragePrintDays1; }
	public Long getDemurragePrintDays2() { return DemurragePrintDays2; }
	public Long getDemurragePrintDays3() { return DemurragePrintDays3; }
	public Long getDemurragePrintTotalDays() { return DemurragePrintTotalDays; }
	
	public BigDecimal getDemAmountTotal() { return DemAmountTotal; }
	public BigDecimal getDemAmount1() { return DemAmount1; }
	public BigDecimal getDemAmount2() { return DemAmount2; }
	public BigDecimal getDemAmount3() { return DemAmount3; }
	
	
	
	public void setDemurragePrintStartDate(java.util.Date value) { this.DemurragePrintStartDate = value; }
	public java.util.Date getDemurragePrintStartDate() { return DemurragePrintStartDate; }

	public int getDemurragePrintStartDateDay() { return DemurragePrintStartDateday; }
	public void setDemurragePrintStartDateDay(int value) { this.DemurragePrintStartDateday = value; }
	public int getDemurragePrintStartDateMonth() { return DemurragePrintStartDatemonth; }
	public void setDemurragePrintStartDateMonth(int value) { this.DemurragePrintStartDatemonth = value; }
	public int getDemurragePrintStartDateYear() { return DemurragePrintStartDateyear; }
	public void setDemurragePrintStartDateYear(int value) { this.DemurragePrintStartDateyear = value; }   	  	
	

	
	
	public void setDemurragePrintEndDate(java.util.Date value) { this.DemurragePrintEndDate = value; }
	public java.util.Date getDemurragePrintEndDate() { return DemurragePrintEndDate; }

	public int getDemurragePrintEndDateDay() { return DemurragePrintEndDateday; }
	public void setDemurragePrintEndDateDay(int value) { this.DemurragePrintEndDateday = value; }
	public int getDemurragePrintEndDateMonth() { return DemurragePrintEndDatemonth; }
	public void setDemurragePrintEndDateMonth(int value) { this.DemurragePrintEndDatemonth = value; }
	public int getDemurragePrintEndDateYear() { return DemurragePrintEndDateyear; }
	public void setDemurragePrintEndDateYear(int value) { this.DemurragePrintEndDateyear = value; }   	  	
	

	
	
	
	
	
	public void setDemurrageFields(
	) { 		
		
		this.DemPeriod1Date = null;
		this.DemPeriod2Date = null;
		this.DemStartDate = null;
		this.DemEndDate = null;
		
		// init demurrage finish flag
		this._dmrgfinishflag = false;
		
//			set pod calendar	
			java.util.Calendar calendar = java.util.Calendar.getInstance();
			calendar.setTime(this.getFromdate());
			calendar.set(Calendar.HOUR,0);
			calendar.set(Calendar.MINUTE,0);
			calendar.set(Calendar.SECOND,0);
			
//			set demurrage begin calendar	(including free days)		
			calendar.add(Calendar.DATE, this.FreeDaysInt );
			this.DemStartDate = calendar.getTime();					

			
			
			// must subtract 1 to make sure start date not double counted
			// when doing the Period1 and Period2 Rate Day calculations
			calendar.add(Calendar.DATE, -1);
//			set next period calendar	(including period1 days)		
			calendar.add(Calendar.DATE, this.DemPeriod1Int );
			this.DemPeriod1Date = calendar.getTime();
			
//			set next period calendar	(including period2 days)					
			calendar.add(Calendar.DATE, this.DemPeriod2Int );
			this.DemPeriod2Date = calendar.getTime();			
			
			
//			check a valid DEPOT RETURN DATE exists
			java.util.Calendar calendar2 = java.util.Calendar.getInstance();							
			if (																
					this.getTodate() == null &&					
					this.getDemurragePrintEndDate() != null 						
			) {
//				if not default to PRINT END DATE
				calendar2.setTime(this.getDemurragePrintEndDate());
				this.DemEndDate = calendar2.getTime();					
			}
			else {
				// if the upto date has been actualised then
				// ignore the Print End Date and
				// set the Demurrage End Date to the actualised Date
				calendar2.setTime(this.getTodate());
				calendar2.set(Calendar.HOUR,0);
				calendar2.set(Calendar.MINUTE,0);
				calendar2.set(Calendar.SECOND,0);
				this.DemEndDate = calendar2.getTime();
				
				// set demurrage finish flag
				this._dmrgfinishflag = true;
			}
			
			
//			Get difference between dates begin and end date			
			long dateDifference = Util.dateDifference(this.DemStartDate,this.DemEndDate);
			if (dateDifference > 0) this.DemDays = new Long(dateDifference);			
		
	}		
	
	

	public void setDemurrageFieldsForLastdmrgtodate() { 
		
		// check a valid DEPOT RETURN DATE exists
		java.util.Calendar calendar = java.util.Calendar.getInstance();							
		if (																
				this.getLastdmrgtodate() != null 											
		) {
			calendar.setTime(this.getLastdmrgtodate());
			calendar.set(Calendar.HOUR,0);
			calendar.set(Calendar.MINUTE,0);
			calendar.set(Calendar.SECOND,0);

			// increment Demurrage Bill upto date by 1 day
			calendar.add(Calendar.DATE,1);
			// init Demurrage Start Date
			this.DemStartDate = calendar.getTime();
		}
		
//		Get difference between dates begin and end date
		long dateDifference = Util.dateDifference(this.DemStartDate,this.DemEndDate);
		if (dateDifference > 0) this.DemDays = new Long(dateDifference);
		
	}		

	
	
	
		
	
	
	
	// code is for the MONTHLY DEMURRAGE BILLING
	public void setDemurragePrintDays()  
	throws NullPointerException 
	{
		
		try {
			
			this.DemurragePrintDays1 = new Long(0);
			this.DemurragePrintDays2 = new Long(0);
			this.DemurragePrintDays3 = new Long(0);
			
			
			// init start and end dates
			//Calendar DemStartDateCalendar = Calendar.getInstance();
			//if (this.getDemurragePrintStartDate().after(this.getDemStartDate())) {
			//	DemStartDateCalendar.setTime(this.getDemurragePrintStartDate());
			//	this.DemStartDate=DemStartDateCalendar.getTime();
			//}
			Calendar DemEndDateCalendar = Calendar.getInstance();
			if (this.getDemurragePrintEndDate().before(this.getDemEndDate())) {
				DemEndDateCalendar.setTime(this.getDemurragePrintEndDate());
				this.DemEndDate=DemEndDateCalendar.getTime();
			}
		
			
			// init calendars
			Calendar vdateCalendar = Calendar.getInstance();
			vdateCalendar.setTime(this.DemStartDate);
			
			Date vdate = vdateCalendar.getTime();
			
			/*
			 compareTo returns value greater than 0 if first date is after another date,
			 returns value less than 0 if first date is before another date and returns
			 0 if both dates are equal.
			 int results = d1.compareTo(d2);
			 */			
			while (
					vdate.compareTo(this.DemEndDate) <= 0
			) {
				
				vdate = vdateCalendar.getTime();
				if (vdate.compareTo(this.DemEndDate) > 0) break;
				
				
				if (
						vdate.compareTo(this.DemStartDate) >= 0 &&
						vdate.compareTo(this.DemPeriod1Date) <= 0
				) {
					this.DemurragePrintDays1++;
					vdateCalendar.add(Calendar.DATE,1); 					
					continue;
				}					
				
				
				
				if (
						vdate.compareTo(this.DemPeriod1Date) > 0 &&
						vdate.compareTo(this.DemPeriod2Date) <= 0							
				) {
					this.DemurragePrintDays2++;				
					vdateCalendar.add(Calendar.DATE,1);					
					continue;
				}
				
				
				if (
						vdate.compareTo(this.DemPeriod2Date) > 0 &&
						vdate.compareTo(this.DemEndDate) <= 0							
				) {
					this.DemurragePrintDays3++;
					vdateCalendar.add(Calendar.DATE,1);  				
					continue;
				}
				
				
				vdateCalendar.add(Calendar.DATE,1);  
				
			} //loop
			
			
			this.DemurragePrintTotalDays = this.DemurragePrintDays1 +
			this.DemurragePrintDays2 + 
			this.DemurragePrintDays3;
			
			
		}
		catch (NullPointerException npe) { 			
			throw new NullPointerException("setDemurragePrintDays: NullPointerException: "+npe.getMessage());
		}
		
	}
	
	
	public void setDemurrageAmounts() 
	throws NullPointerException 
	{	
		
		try {
			
			float DemAmount = 0;
			float DemDays = 0;
			float DemRate = 0;
			float DemAmountTotal;
			DemDays = new Float(this.DemurragePrintDays1).floatValue();
			DemRate = this.DemRate1.floatValue();
			DemAmount =  (DemDays * DemRate);
			DemAmountTotal =  DemAmount;
			this.DemAmount1 = new BigDecimal(DemAmount);
			
			DemDays = new Float(this.DemurragePrintDays2).floatValue();
			DemRate = this.DemRate2.floatValue();
			DemAmount =  (DemDays * DemRate);
			DemAmountTotal =  DemAmount+DemAmountTotal;
			this.DemAmount2 = new BigDecimal(DemAmount);
			
			DemDays = new Float(this.DemurragePrintDays3).floatValue();
			DemRate = this.DemRate3.floatValue();
			DemAmount =  (DemDays * DemRate);
			DemAmountTotal =  DemAmount+DemAmountTotal;
			this.DemAmount3 = new BigDecimal(DemAmount);
			this.DemAmountTotal = new BigDecimal(DemAmountTotal);
			
		}
		catch (NullPointerException npe) {
			throw new NullPointerException("setDemurrageAmounts NullPointerException: "+npe.getMessage());
		}		
	}
	

	public String toStringDemurrageFields() { 
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" FreeDays: "+this.FreeDays);
		sb.append(" DemPeriod1: "+this.DemPeriod1);
		sb.append(" DemPeriod2: "+this.DemPeriod2);      
		sb.append(" DemRate1: "+this.DemRate1);
		sb.append(" DemRate2: "+this.DemRate2);
		sb.append(" DemRate3: "+this.DemRate3);
		sb.append(" DemDays: "+this.DemDays);         
		sb.append(" DemStartDate: "+this.DemStartDate);
		sb.append(" DemPeriod1Date: "+this.DemPeriod1Date);
		sb.append(" DemPeriod2Date: "+this.DemPeriod2Date);
		sb.append(" DemEndDate: "+this.DemEndDate);
		sb.append(" DemurragePrintStartDate: "+this.DemurragePrintStartDate);
		sb.append(" DemurragePrintEndDate: "+this.DemurragePrintEndDate);
		sb.append(" DemurragePrintDays1: "+this.DemurragePrintDays1);
		sb.append(" DemurragePrintDays2: "+this.DemurragePrintDays2);
		sb.append(" DemurragePrintDays3: "+this.DemurragePrintDays3);
		sb.append(" DemurragePrintTotalDays: "+this.DemurragePrintTotalDays);			
		sb.append(" Todate: "+this.getTodate());		
		sb.append(" Fromdate: "+this.getFromdate());
		sb.append(" Lastdmrgfrdate: "+this.getLastdmrgfrdate());
		sb.append(" Lastdmrgtodate: "+this.getLastdmrgtodate());
		
		return sb.toString();
		
	}	
	
	
	
}

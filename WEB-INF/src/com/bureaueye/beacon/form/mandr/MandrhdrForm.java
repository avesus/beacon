package com.bureaueye.beacon.form.mandr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;


public final class MandrhdrForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String copyVersionId = "";
    private String copyId = "";
    
	// primary key
	private java.lang.String _mandrhdrId;


	// fields
	private java.lang.String _materialamt = "0.0";
	private java.lang.String _laboramt = "0.0";
	private java.lang.String _totalamt = "0.0";
	private java.lang.String _laborhours = "0.0";
	
	private java.lang.String _mandrno;
	private java.lang.String _versionno;
	private java.lang.String _lastversionno;
	private java.lang.String _mandrtypekey;
	private java.lang.String _estimateref;
	
	private java.lang.String _companykey;
	private java.lang.String _departmentkey;
	private java.lang.String _activitykey;
	
	private java.lang.String _moveref;

	private java.lang.String _ccykey;
	private java.lang.String _dppccykey;
	
	private java.lang.String _laborrate = "0.0";
	private java.lang.String _dppamt = "0.0";
	
	private java.lang.String _unitkey;
	private java.lang.String _unitId;
	private java.lang.String _movests;
	
	private boolean _returntolessorflag;
	private boolean _lastversionflag;
	private boolean _cancelflag;
	
	private java.lang.String _canceldatedd;
	private java.lang.String _canceldatemm;
	private java.lang.String _canceldateyyyy;	
	
	private java.lang.String _cancelby;
	private java.lang.String _cancelreason;
	
	private boolean _reopenflag;
	
	private java.lang.String _reopendatedd;
	private java.lang.String _reopendatemm;
	private java.lang.String _reopendateyyyy;
	
	private java.lang.String _reopenby;
	private boolean _cleanflag;
	
	private java.lang.String _cleandatedd;
	private java.lang.String _cleandatemm;
	private java.lang.String _cleandateyyyy;
	
	private java.lang.String _cleanby;
	private java.lang.String _mandrstatus;
	
	private java.lang.String _approvedatedd;
	private java.lang.String _approvedatemm;
	private java.lang.String _approvedateyyyy;	
	
	private java.lang.String _estimatedatedd;
	private java.lang.String _estimatedatemm;
	private java.lang.String _estimatedateyyyy;		

	private java.lang.String _originalestimatedatedd;
	private java.lang.String _originalestimatedatemm;
	private java.lang.String _originalestimatedateyyyy;	
	
	private java.lang.String _repairdatedd;
	private java.lang.String _repairdatemm;
	private java.lang.String _repairdateyyyy;	

	private java.lang.String _indatedd;
	private java.lang.String _indatemm;
	private java.lang.String _indateyyyy;
	
	private java.lang.String _outdatedd;
	private java.lang.String _outdatemm;
	private java.lang.String _outdateyyyy;
	

	private java.util.Date _createdate;
	private java.lang.String _createtime;
	private java.lang.String _createuserid;
	
	private java.lang.String _lesseeaddrkey;
	private java.lang.String _customeraddrkey;
	private java.lang.String _depotlocationkey;
	private java.lang.String _vendoraddrkey;
	private java.lang.String _productkey;
	

	private java.lang.String _txt1;
	
	

	// lookup fields
	private java.lang.String _unitowner="";
	private java.lang.String _eqpkeyp1="";
	private java.lang.String _eqpkeyp2="";
	private java.lang.String _testtypekey="";
	private java.lang.String _testduedate="";
	
	
	// collections
	

	
    /**
     */
    public String getCopyId() {return (this.copyId);}
    public void setCopyId(String copyId) {this.copyId = copyId;}
    
    /**
     */
    public String getCopyVersionId() {return (this.copyVersionId);}
    public void setCopyVersionId(String copyVersionId) {this.copyVersionId = copyVersionId;}
     
	
	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	

	public java.lang.String getUnitowner_() { return _unitowner; }
	public void setUnitowner (java.lang.String _unitowner) { this._unitowner = _unitowner; }

	public java.lang.String getEqpkeyp1_() { return _eqpkeyp1; }
	public void setEqpkeyp1(java.lang.String _eqpkeyp1) { this._eqpkeyp1 = _eqpkeyp1; }
	
	public java.lang.String getEqpkeyp2_() { return _eqpkeyp2; }
	public void setEqpkeyp2(java.lang.String _eqpkeyp2) { this._eqpkeyp2 = _eqpkeyp2; }
	
	public java.lang.String getTesttypekey_() { return _testtypekey; }
	public void setTesttypekey(java.lang.String _testtypekey) { this._testtypekey = _testtypekey; }
	
	public java.lang.String getTestduedate_() { return _testduedate; }
	public void setTestduedate(java.lang.String _testduedate) { this._testduedate = _testduedate; }

	
	
	

	public java.lang.String getId () {
		return _mandrhdrId;
	}
	public void setId (java.lang.String _mandrhdrId) {
		this._mandrhdrId = _mandrhdrId;
	}


	public java.lang.String getTxt1 () {
		return _txt1;
	}
	public void setTxt1 (java.lang.String _txt1) {
		this._txt1 = _txt1;
	}
	
	

	
	public Date getCanceldate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getCanceldateyyyy()), Integer
						.parseInt(getCanceldatemm()) - 1, Integer
						.parseInt(getCanceldatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setCanceldate(Date canceldate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(canceldate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setCanceldateyyyy(c.get(Calendar.YEAR) + "");
		setCanceldatemm((month < 10 ? "0" : "") + month);
		setCanceldatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setCanceldateyyyy("0000");
			setCanceldatemm("00");
			setCanceldatedd("00");			
		}
	}
	public String getCanceldatedd () {return _canceldatedd;}
	public void setCanceldatedd (String _canceldatedd) {this._canceldatedd = _canceldatedd;}
	public String getCanceldatemm () {return _canceldatemm;}
	public void setCanceldatemm (String _canceldatemm) {this._canceldatemm = _canceldatemm;}
	public String getCanceldateyyyy () {return _canceldateyyyy;}
	public void setCanceldateyyyy (String _canceldateyyyy) {this._canceldateyyyy = _canceldateyyyy;}


	public Date getIndate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getIndateyyyy()), Integer
						.parseInt(getIndatemm()) - 1, Integer
						.parseInt(getIndatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setIndate(Date indate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(indate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setIndateyyyy(c.get(Calendar.YEAR) + "");
		setIndatemm((month < 10 ? "0" : "") + month);
		setIndatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setIndateyyyy("0000");
			setIndatemm("00");
			setIndatedd("00");			
		}
	}
	public String getIndatedd () {return _indatedd;}
	public void setIndatedd (String _indatedd) {this._indatedd = _indatedd;}
	public String getIndatemm () {return _indatemm;}
	public void setIndatemm (String _indatemm) {this._indatemm = _indatemm;}
	public String getIndateyyyy () {return _indateyyyy;}
	public void setIndateyyyy (String _indateyyyy) {this._indateyyyy = _indateyyyy;}
	

	
	public Date getOutdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getOutdateyyyy()), Integer
						.parseInt(getOutdatemm()) - 1, Integer
						.parseInt(getOutdatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setOutdate(Date outdate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(outdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setOutdateyyyy(c.get(Calendar.YEAR) + "");
		setOutdatemm((month < 10 ? "0" : "") + month);
		setOutdatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setOutdateyyyy("0000");
			setOutdatemm("00");
			setOutdatedd("00");			
		}
	}
	public String getOutdatedd () {return _outdatedd;}
	public void setOutdatedd (String _outdatedd) {this._outdatedd = _outdatedd;}
	public String getOutdatemm () {return _outdatemm;}
	public void setOutdatemm (String _outdatemm) {this._outdatemm = _outdatemm;}
	public String getOutdateyyyy () {return _outdateyyyy;}
	public void setOutdateyyyy (String _outdateyyyy) {this._outdateyyyy = _outdateyyyy;}
	

	
	public Date getRepairdate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getRepairdateyyyy()), Integer
						.parseInt(getRepairdatemm()) - 1, Integer
						.parseInt(getRepairdatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setRepairdate(Date repairdate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(repairdate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setRepairdateyyyy(c.get(Calendar.YEAR) + "");
		setRepairdatemm((month < 10 ? "0" : "") + month);
		setRepairdatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setRepairdateyyyy("0000");
			setRepairdatemm("00");
			setRepairdatedd("00");			
		}
	}
	public String getRepairdatedd () {return _repairdatedd;}
	public void setRepairdatedd (String _repairdatedd) {this._repairdatedd = _repairdatedd;}
	public String getRepairdatemm () {return _repairdatemm;}
	public void setRepairdatemm (String _repairdatemm) {this._repairdatemm = _repairdatemm;}
	public String getRepairdateyyyy () {return _repairdateyyyy;}
	public void setRepairdateyyyy (String _repairdateyyyy) {this._repairdateyyyy = _repairdateyyyy;}
	

	public Date getEstimatedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getEstimatedateyyyy()), Integer
						.parseInt(getEstimatedatemm()) - 1, Integer
						.parseInt(getEstimatedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setEstimatedate(Date estimatedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(estimatedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setEstimatedateyyyy(c.get(Calendar.YEAR) + "");
		setEstimatedatemm((month < 10 ? "0" : "") + month);
		setEstimatedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setEstimatedateyyyy("0000");
			setEstimatedatemm("00");
			setEstimatedatedd("00");			
		}
	}
	public String getEstimatedatedd () {return _estimatedatedd;}
	public void setEstimatedatedd (String _estimatedatedd) {this._estimatedatedd = _estimatedatedd;}
	public String getEstimatedatemm () {return _estimatedatemm;}
	public void setEstimatedatemm (String _estimatedatemm) {this._estimatedatemm = _estimatedatemm;}
	public String getEstimatedateyyyy () {return _estimatedateyyyy;}
	public void setEstimatedateyyyy (String _estimatedateyyyy) {this._estimatedateyyyy = _estimatedateyyyy;}


	
	public Date getOriginalestimatedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getOriginalestimatedateyyyy()), Integer
						.parseInt(getOriginalestimatedatemm()) - 1, Integer
						.parseInt(getOriginalestimatedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setOriginalestimatedate(Date originalestimatedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(originalestimatedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setOriginalestimatedateyyyy(c.get(Calendar.YEAR) + "");
		setOriginalestimatedatemm((month < 10 ? "0" : "") + month);
		setOriginalestimatedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setOriginalestimatedateyyyy("0000");
			setOriginalestimatedatemm("00");
			setOriginalestimatedatedd("00");			
		}
	}
	public String getOriginalestimatedatedd () {return _originalestimatedatedd;}
	public void setOriginalestimatedatedd (String _originalestimatedatedd) {this._originalestimatedatedd = _originalestimatedatedd;}
	public String getOriginalestimatedatemm () {return _originalestimatedatemm;}
	public void setOriginalestimatedatemm (String _originalestimatedatemm) {this._originalestimatedatemm = _originalestimatedatemm;}
	public String getOriginalestimatedateyyyy () {return _originalestimatedateyyyy;}
	public void setOriginalestimatedateyyyy (String _originalestimatedateyyyy) {this._originalestimatedateyyyy = _originalestimatedateyyyy;}

	
	
	
	public Date getApprovedate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getApprovedateyyyy()), Integer
						.parseInt(getApprovedatemm()) - 1, Integer
						.parseInt(getApprovedatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setApprovedate(Date approvedate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(approvedate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setApprovedateyyyy(c.get(Calendar.YEAR) + "");
		setApprovedatemm((month < 10 ? "0" : "") + month);
		setApprovedatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setApprovedateyyyy("0000");
			setApprovedatemm("00");
			setApprovedatedd("00");			
		}
	}
	public String getApprovedatedd () {return _approvedatedd;}
	public void setApprovedatedd (String _approvedatedd) {this._approvedatedd = _approvedatedd;}
	public String getApprovedatemm () {return _approvedatemm;}
	public void setApprovedatemm (String _approvedatemm) {this._approvedatemm = _approvedatemm;}
	public String getApprovedateyyyy () {return _approvedateyyyy;}
	public void setApprovedateyyyy (String _approvedateyyyy) {this._approvedateyyyy = _approvedateyyyy;}
	
	

	public Date getCleandate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getCleandateyyyy()), Integer
						.parseInt(getCleandatemm()) - 1, Integer
						.parseInt(getCleandatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setCleandate(Date cleandate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(cleandate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setCleandateyyyy(c.get(Calendar.YEAR) + "");
		setCleandatemm((month < 10 ? "0" : "") + month);
		setCleandatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setCleandateyyyy("0000");
			setCleandatemm("00");
			setCleandatedd("00");			
		}
	}
	public String getCleandatedd () {return _cleandatedd;}
	public void setCleandatedd (String _cleandatedd) {this._cleandatedd = _cleandatedd;}
	public String getCleandatemm () {return _cleandatemm;}
	public void setCleandatemm (String _cleandatemm) {this._cleandatemm = _cleandatemm;}
	public String getCleandateyyyy () {return _cleandateyyyy;}
	public void setCleandateyyyy (String _cleandateyyyy) {this._cleandateyyyy = _cleandateyyyy;}
	
	
	
	public Date getReopendate() {
		try {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getReopendateyyyy()), Integer
						.parseInt(getReopendatemm()) - 1, Integer
						.parseInt(getReopendatedd()));
		return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setReopendate(Date reopendate) {
		try {
		Calendar c = Calendar.getInstance();
		c.setTime(reopendate);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setReopendateyyyy(c.get(Calendar.YEAR) + "");
		setReopendatemm((month < 10 ? "0" : "") + month);
		setReopendatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setReopendateyyyy("0000");
			setReopendatemm("00");
			setReopendatedd("00");			
		}
	}
	public String getReopendatedd () {return _reopendatedd;}
	public void setReopendatedd (String _reopendatedd) {this._reopendatedd = _reopendatedd;}
	public String getReopendatemm () {return _reopendatemm;}
	public void setReopendatemm (String _reopendatemm) {this._reopendatemm = _reopendatemm;}
	public String getReopendateyyyy () {return _reopendateyyyy;}
	public void setReopendateyyyy (String _reopendateyyyy) {this._reopendateyyyy = _reopendateyyyy;}
	
	
	
	
	
	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate_ () {
		return _createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param _createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date _createdate) {
		this._createdate = _createdate;
	}
	

	
	

	public String getMaterialamt () {
		return _materialamt;
	}
	public void setMaterialamt (String _materialamt) {
		this._materialamt = _materialamt;
	}




	public String getLaboramt () {
		return _laboramt;
	}
	public void setLaboramt (String _laboramt) {
		this._laboramt = _laboramt;
	}


	/**
	 * Return the value associated with the column: laborhours
	 */
	public String getLaborhours () {
		return _laborhours;
	}

	/**
	 * Set the value related to the column: laborhours
	 * @param laborhours the laborhours value
	 */
	public void setLaborhours (String _laborhours) {
		this._laborhours = _laborhours;
	}
	
	
	/**
	 * Return the value associated with the column: totalamt
	 */
	public String getTotalamt () {
		return _totalamt;
	}

	/**
	 * Set the value related to the column: totalamt
	 * @param totalamt the totalamt value
	 */
	public void setTotalamt (String _totalamt) {
		this._totalamt = _totalamt;
	}



	/**
	 * Return the value associated with the column: mandrno
	 */
	public java.lang.String getMandrno () {
		return _mandrno;
	}

	/**
	 * Set the value related to the column: mandrno
	 * @param mandrno the mandrno value
	 */
	public void setMandrno (java.lang.String _mandrno) {
		this._mandrno = _mandrno;
	}



	/**
	 * Return the value associated with the column: versionno
	 */
	public java.lang.String getVersionno () {
		return _versionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param versionno the versionno value
	 */
	public void setVersionno (java.lang.String _versionno) {
		this._versionno = _versionno;
	}

	/**
	 * Return the value associated with the column: versionno
	 */
	public java.lang.String getLastversionno () {
		return _lastversionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param versionno the versionno value
	 */
	public void setLastversionno (java.lang.String _lastversionno) {
		this._lastversionno = _lastversionno;
	}
	

	/**
	 * Return the value associated with the column: mandrtypekey
	 */
	public java.lang.String getMandrtypekey () {
		return _mandrtypekey;
	}

	/**
	 * Set the value related to the column: mandrtypekey
	 * @param mandrtypekey the mandrtypekey value
	 */
	public void setMandrtypekey (java.lang.String _mandrtypekey) {
		this._mandrtypekey = _mandrtypekey;
	}



	/**
	 * Return the value associated with the column: estimateref
	 */
	public java.lang.String getEstimateref () {
		return _estimateref;
	}

	/**
	 * Set the value related to the column: estimateref
	 * @param estimateref the estimateref value
	 */
	public void setEstimateref (java.lang.String _estimateref) {
		this._estimateref = _estimateref;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String _companykey) {
		this._companykey = _companykey;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
	}



	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String _activitykey) {
		this._activitykey = _activitykey;
	}



	/**
	 * Return the value associated with the column: movref
	 */
	public java.lang.String getMoveref () {
		return _moveref;
	}

	/**
	 * Set the value related to the column: movref
	 * @param movref the movref value
	 */
	public void setMoveref (java.lang.String _moveref) {
		this._moveref = _moveref;
	}



	/**
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public java.lang.String getLesseeaddrkey () {
		return _lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (java.lang.String _lesseeaddrkey) {
		this._lesseeaddrkey = _lesseeaddrkey;
	}



	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return _customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String _customeraddrkey) {
		this._customeraddrkey = _customeraddrkey;
	}



	/**
	 * Return the value associated with the column: depotlocationkey
	 */
	public java.lang.String getDepotlocationkey () {
		return _depotlocationkey;
	}

	/**
	 * Set the value related to the column: depotlocationkey
	 * @param depotlocationkey the depotlocationkey value
	 */
	public void setDepotlocationkey (java.lang.String _depotlocationkey) {
		this._depotlocationkey = _depotlocationkey;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public java.lang.String getVendoraddrkey () {
		return _vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (java.lang.String _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: ccykey
	 */
	public java.lang.String getCcykey () {
		return _ccykey;
	}

	/**
	 * Set the value related to the column: ccykey
	 * @param ccykey the ccykey value
	 */
	public void setCcykey (java.lang.String _ccykey) {
		this._ccykey = _ccykey;
	}



	/**
	 * Return the value associated with the column: dppccykey
	 */
	public java.lang.String getDppccykey () {
		return _dppccykey;
	}

	/**
	 * Set the value related to the column: dppccykey
	 * @param dppccykey the dppccykey value
	 */
	public void setDppccykey (java.lang.String _dppccykey) {
		this._dppccykey = _dppccykey;
	}



	/**
	 * Return the value associated with the column: laborrate
	 */
	public String getLaborrate () {
		return _laborrate;
	}

	/**
	 * Set the value related to the column: laborrate
	 * @param laborrate the laborrate value
	 */
	public void setLaborrate (String _laborrate) {
		this._laborrate = _laborrate;
	}



	/**
	 * Return the value associated with the column: dppamt
	 */
	public String getDppamt () {
		return _dppamt;
	}

	/**
	 * Set the value related to the column: dppamt
	 * @param dppamt the dppamt value
	 */
	public void setDppamt (String _dppamt) {
		this._dppamt = _dppamt;
	}





	public java.lang.String getMovests_ () {
		return _movests;
	}
	public void setMovests(java.lang.String _movests) {
		this._movests= _movests;
	}
	
	

	/**
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return _unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String _unitkey) {
		this._unitkey = _unitkey;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public String getUnitId () {
		return _unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (String _unitId) {
		this._unitId = _unitId;
	}



	/**
	 * Return the value associated with the column: returntolessorflag
	 */
	public boolean isReturntolessorflag () {
		return _returntolessorflag;
	}

	/**
	 * Set the value related to the column: returntolessorflag
	 * @param returntolessorflag the returntolessorflag value
	 */
	public void setReturntolessorflag (boolean _returntolessorflag) {
		this._returntolessorflag = _returntolessorflag;
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
	public void setProductkey (java.lang.String _productkey) {
		this._productkey = _productkey;
	}



	/**
	 * Return the value associated with the column: cancelflag
	 */
	public boolean isCancelflag () {
		return _cancelflag;
	}

	/**
	 * Set the value related to the column: cancelflag
	 * @param cancelflag the cancelflag value
	 */
	public void setCancelflag (boolean _cancelflag) {
		this._cancelflag = _cancelflag;
	}






	/**
	 * Return the value associated with the column: cancelby
	 */
	public java.lang.String getCancelby () {
		return _cancelby;
	}

	/**
	 * Set the value related to the column: cancelby
	 * @param cancelby the cancelby value
	 */
	public void setCancelby (java.lang.String _cancelby) {
		this._cancelby = _cancelby;
	}



	/**
	 * Return the value associated with the column: cancelreason
	 */
	public java.lang.String getCancelreason () {
		return _cancelreason;
	}

	/**
	 * Set the value related to the column: cancelreason
	 * @param cancelreason the cancelreason value
	 */
	public void setCancelreason (java.lang.String _cancelreason) {
		this._cancelreason = _cancelreason;
	}



	/**
	 * Return the value associated with the column: reopenflag
	 */
	public boolean isReopenflag () {
		return _reopenflag;
	}

	/**
	 * Set the value related to the column: reopenflag
	 * @param reopenflag the reopenflag value
	 */
	public void setReopenflag (boolean _reopenflag) {
		this._reopenflag = _reopenflag;
	}







	/**
	 * Return the value associated with the column: reopenby
	 */
	public java.lang.String getReopenby () {
		return _reopenby;
	}

	/**
	 * Set the value related to the column: reopenby
	 * @param reopenby the reopenby value
	 */
	public void setReopenby (java.lang.String _reopenby) {
		this._reopenby = _reopenby;
	}



	/**
	 * Return the value associated with the column: cleanflag
	 */
	public boolean isCleanflag () {
		return _cleanflag;
	}

	/**
	 * Set the value related to the column: cleanflag
	 * @param cleanflag the cleanflag value
	 */
	public void setCleanflag (boolean _cleanflag) {
		this._cleanflag = _cleanflag;
	}





	/**
	 * Return the value associated with the column: cleanby
	 */
	public java.lang.String getCleanby () {
		return _cleanby;
	}

	/**
	 * Set the value related to the column: cleanby
	 * @param cleanby the cleanby value
	 */
	public void setCleanby (java.lang.String _cleanby) {
		this._cleanby = _cleanby;
	}



	/**
	 * Return the value associated with the column: mandrstatus
	 */
	public java.lang.String getMandrstatus () {
		return _mandrstatus;
	}

	/**
	 * Set the value related to the column: mandrstatus
	 * @param mandrstatus the mandrstatus value
	 */
	public void setMandrstatus (java.lang.String _mandrstatus) {
		this._mandrstatus = _mandrstatus;
	}






	/**
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return _createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String _createtime) {
		this._createtime = _createtime;
	}



	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return _createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String _createuserid) {
		this._createuserid = _createuserid;
	}


	/**
	 * Return the value associated with the column: lastversionflag
	 */
	public boolean isLastversionflag () {
		return _lastversionflag;
	}

	/**
	 * Set the value related to the column: lastversionflag
	 * @param lastversionflag the lastversionflag value
	 */
	public void setLastversionflag (boolean _lastversionflag) {
		this._lastversionflag = _lastversionflag;
	}
	
	
	

	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;		
		
		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	

		
        if ((_companykey == null) || (_companykey.length() < 1))
            errors.add("companykey",
                    new ActionMessage("error.company.required"));   
        

		addErrorIfBlank(errors, "mandrno", _mandrno, "error.mandrno.required"); 
		addErrorIfBlank(errors, "mandrtypekey", _mandrtypekey, "error.mandrtype.required"); 
		addErrorIfBlank(errors, "estimateref", _estimateref, "error.estimateref.required"); 
		
		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}

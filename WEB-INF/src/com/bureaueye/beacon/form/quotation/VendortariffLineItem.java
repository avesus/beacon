package com.bureaueye.beacon.form.quotation;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Cost;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;
import com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO;

/**
 * 
 * Amendments ----------
 * 
 * 
 */
@SuppressWarnings("serial")
public final class VendortariffLineItem extends ActionForm {

	/* [CONSTRUCTOR MARKER BEGIN] */
	public VendortariffLineItem(VendortariffhdrDTO hdr, Vendortariffdtl dtl,
			String unittype, String units) {

		this._vendtarfhdrId = hdr.getVendtarfhdrId();

		this._vendoraddrkey = hdr.getVendoraddrkey();

		this._fromlocationkey = hdr.getFromlocationkey();
		this._tolocationkey = hdr.getTolocationkey();
		this._tslocationkey = hdr.getTslocationkey();

		this._costkey = hdr.getCostkey();
		// try {
		// this._costdescr = cost.getDescr();
		// } catch (NullPointerException npe) {
		// this._costdescr = _costkey;
		// }

		this._ccykey = hdr.getCcykey();
		this._productkey = hdr.getProductkey();
		this._producthazardous = hdr.getProducthazardous();		
		this._validto = hdr.getValidto();
		this._validfrom = hdr.getValidfrom();
		this._unittype = hdr.getUnittype();
		this._note1 = hdr.getNote1();
		this._note2 = hdr.getNote2();

		// init detail fields
		this._vendtarfdtlId = new Integer(0);
		this._fromvalue = new Integer(0);
		this._tovalue = new Integer(0);
		this._unitrate = new BigDecimal(0.00);
		this._lumpsum = new BigDecimal(0.00);

		if (unittype.equals("LUMPSUM") || unittype.equals("PTOP")) {
			this._unitrate = new BigDecimal(hdr.getLumpsum());
			this._lumpsum = new BigDecimal(hdr.getLumpsum());
		}
		// if dtl exists then init values with tariff detail
		if (dtl != null) {
			this._vendtarfdtlId = dtl.getVendtarfdtlId();
			this._fromvalue = dtl.getFromvalue();
			this._tovalue = dtl.getTovalue();
			this._unitrate = dtl.getUnitrate();
			this._lumpsum = (new BigDecimal(units).multiply(this._unitrate));
		}

		this._returnParams = this._vendtarfhdrId + "|" + this._unitrate + "|"
				+ this._lumpsum + "|" + this._note1 + "|" + this._note2 + "|"
				+ this._vendoraddrkey.getAddrkey() + "|"
				+ this._costkey.getCostkey() + "|" + this._ccykey;
	}

	// --------------------------------------------------- Instance Variables

	// collections
	private int[] vtselectedObjects;

	/**
	 * The unique id.
	 */
	private String _id;

	// fields
	private String _vendtarfhdrId;
	private java.lang.Integer _vendtarfdtlId;

	private Address _vendoraddrkey;

	private Location _fromlocationkey;
	private Location _tolocationkey;
	private Location _tslocationkey;

	private String _productkey;
	private String _producthazardous;
	
	private java.lang.String _unittype;
	private java.lang.String _uname;

	private java.lang.String _txt1;
	private java.lang.String _txt2;

	private Date _validto;
	private Date _validfrom;

	private Cost _costkey;
	// private java.lang.String _costdescr;

	private java.math.BigDecimal _units;
	private java.lang.String _ccykey;
	private java.lang.String _baseccykey;

	private java.math.BigDecimal _unitrate;
	private java.math.BigDecimal _lumpsum;
	private java.math.BigDecimal _xratebase;
	private java.math.BigDecimal _unitratebase;
	private java.math.BigDecimal _unitrateavg;
	private java.math.BigDecimal _lumpsumavg;
	
	private Integer _fromvalue;
	private Integer _tovalue;

	private String _returnParams;
	private String _note1;
	private String _note2;

	private String row;

	// ----------------------------------------------------------- Properties

	/**
	 */
	public java.lang.String getRow() {
		return row;
	}

	/**
	 */
	public void setRow(java.lang.String row) {
		this.row = row;
	}

	/**
	 */
	public String getReturnParams() {
		return (this._returnParams);
	}

	/**
	 */
	public void setReturnParams(String _returnParams) {
		this._returnParams = _returnParams;
	}

	/**
	 */
	public String getProductkey() {
		return (this._productkey);
	}

	/**
	 */
	public void setProductkey(String _productkey) {
		this._productkey = _productkey;
	}

	
	/**
	 */
	public String getProducthazardous() {
		return (this._producthazardous);
	}

	public void setProducthazardous(String _producthazardous) {
		this._producthazardous = _producthazardous;
	}
	
	
	/**
	 */
	public String getId() {
		return (this._id);
	}

	/**
	 */
	public void setId(String _id) {
		this._id = _id;
	}

	/**
	 */
	public String getVendtarfhdrId() {
		return _vendtarfhdrId;
	}

	/**
	 */
	public void setVendtarfhdrId(String _vendtarfhdrId) {
		this._vendtarfhdrId = _vendtarfhdrId;
	}

	/**
	 */
	public java.lang.Integer getVendtarfdtlId() {
		return _vendtarfdtlId;
	}

	/**
	 */
	public void setVendtarfdtlId(java.lang.Integer _vendtarfdtlId) {
		this._vendtarfdtlId = _vendtarfdtlId;
	}

	/**
	 */
	public java.util.Date getValidfrom() {
		return _validfrom;
	}

	/**
	 */
	public void setValidfrom(java.util.Date _validfrom) {
		this._validfrom = _validfrom;
	}

	/**
	 */
	public java.util.Date getValidto() {
		return _validto;
	}

	/**
	 */
	public void setValidto(java.util.Date _validto) {
		this._validto = _validto;
	}

	/**
	 */
	public java.lang.Integer getFromvalue() {
		return _fromvalue;
	}

	/**
	 */
	public void setFromvalue(java.lang.Integer _fromvalue) {
		this._fromvalue = _fromvalue;
	}

	/**
	 */
	public java.lang.Integer getTovalue() {
		return _tovalue;
	}

	/**
	 */
	public void setTovalue(java.lang.Integer _tovalue) {
		this._tovalue = _tovalue;
	}

	/**
	 */
	public java.lang.String getUnittype() {
		return _unittype;
	}

	/**
	 */
	public void setUnittype(java.lang.String _unittype) {
		this._unittype = _unittype;
	}

	/**
	 */
	public java.lang.String getUname() {
		return _uname;
	}

	/**
	 */
	public void setUname(java.lang.String _uname) {
		this._uname = _uname;
	}

	/**
	 */
	public java.lang.String getTxt1() {
		return _txt1;
	}

	/**
	 */
	public void setTxt1(java.lang.String _txt1) {
		this._txt1 = _txt1;
	}

	/**
	 */
	public java.lang.String getNote1() {
		return _note1;
	}

	/**
	 */
	public void setNote1(java.lang.String _note1) {
		this._note1 = _note1;
	}

	/**
	 */
	public java.lang.String getNote2() {
		return _note2;
	}

	/**
	 */
	public void setNote2(java.lang.String _note2) {
		this._note2 = _note2;
	}

	/**
	 */
	public Address getVendoraddrkey() {
		return _vendoraddrkey;
	}

	/**
	 */
	public void setVendoraddrkey(Address _vendoraddrkey) {
		this._vendoraddrkey = _vendoraddrkey;
	}

	/**
	 */
	public Location getFromlocationkey() {
		return _fromlocationkey;
	}

	/**
	 */
	public void setFromlocationkey(Location _fromlocationkey) {
		this._fromlocationkey = _fromlocationkey;
	}

	/**
	 */
	public Location getTslocationkey() {
		return _tslocationkey;
	}

	/**
	 */
	public void setTslocationkey(Location _tslocationkey) {
		this._tslocationkey = _tslocationkey;
	}

	/**
	 */
	public Location getTolocationkey() {
		return _tolocationkey;
	}

	/**
	 */
	public void setTolocationkey(Location _tolocationkey) {
		this._tolocationkey = _tolocationkey;
	}

	/**
	 */
	public java.lang.String getTxt2() {
		return _txt2;
	}

	/**
	 */
	public void setTxt2(java.lang.String _txt2) {
		this._txt2 = _txt2;
	}

	/**
	 */
	public Cost getCostkey() {
		return _costkey;
	}

	/**
	 */
	public void setCostkey(Cost _costkey) {
		this._costkey = _costkey;
	}

	/**
	 */
	public java.math.BigDecimal getUnits() {
		return _units;
	}

	/**
	 */
	public void setUnits(java.math.BigDecimal _units) {
		this._units = _units;
	}

	/**
	 */
	public java.lang.String getCcykey() {
		return _ccykey;
	}

	/**
	 */
	public void setCcykey(java.lang.String _ccykey) {
		this._ccykey = _ccykey;
	}

	/**
	 */
	public java.lang.String getBaseccykey() {
		return _baseccykey;
	}

	/**
	 */
	public void setBaseccykey(java.lang.String _baseccykey) {
		this._baseccykey = _baseccykey;
	}

	/**
	 */
	public java.math.BigDecimal getUnitrate() {
		return _unitrate;
	}

	/**
	 */
	public void setUnitrate(java.math.BigDecimal _unitrate) {
		this._unitrate = _unitrate;
	}

	/**
	 */
	public java.math.BigDecimal getLumpsum() {
		return _lumpsum;
	}
	/**
	 */
	public void setLumpsum(java.math.BigDecimal _lumpsum) {
		this._lumpsum = _lumpsum;
	}

	/**
	 */
	public java.math.BigDecimal getUnitratebase() {
		return _unitratebase;
	}
	/**
	 */
	public void setUnitratebase(java.math.BigDecimal _amt) {
		this._unitratebase = _amt;
	}

	/**
	 */
	public java.math.BigDecimal getXratebase() {
		return _xratebase;
	}
	/**
	 */
	public void setXratebase(java.math.BigDecimal _xrate) {
		this._xratebase = _xrate;
	}

	
	
	/**
	 */
	public java.math.BigDecimal getUnitrateavg() {
		return _unitrateavg;
	}
	public void setUnitrateavg(java.math.BigDecimal _amt) {
		this._unitrateavg = _amt;
	}
	

	/**
	 */
	public java.math.BigDecimal getLumpsumavg() {
		return _lumpsumavg;
	}
	public void setLumpsumavg(java.math.BigDecimal _amt) {
		this._lumpsumavg = _amt;
	}
	
	
	
	public int[] getVtselectedObjects() {
		return vtselectedObjects;
	}
	public void setVtselectedObjects(int[] selectedObjects) {
		this.vtselectedObjects = selectedObjects;
	}

	// --------------------------------------------------------- Public Methods

	/**
	 * Reset all properties to their default values.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}

	/**
	 * Validate the properties that have been set from this HTTP request, and
	 * return an <code>ActionErrors</code> object that encapsulates any
	 * validation errors that have been found. If no errors are found, return
	 * <code>null</code> or an <code>ActionErrors</code> object with no recorded
	 * error messages.
	 * 
	 * @param mapping
	 *            The mapping used to select this instance
	 * @param request
	 *            The servlet request we are processing
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		return (errors);

	}

}

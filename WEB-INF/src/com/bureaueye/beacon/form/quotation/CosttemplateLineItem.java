package com.bureaueye.beacon.form.quotation;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Ccy;
import com.bureaueye.beacon.model.standard.Cost;



/**
*
* Amendments
* ----------
* 												
*
*/
public final class CosttemplateLineItem extends ActionForm {


	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	// --------------------------------------------------- Instance Variables

	// collections
	private java.util.List<VendortariffLineItem> vtlineitems;
	private java.lang.String vtselectedValue="";
	
	private int[] ctselectedObjects;
	
	
	// primary key
	private java.lang.String costtemplateId;

	// fields
	private Cost cost;
	private java.lang.String costtype;
	private Ccy ccy;
	private Address vendoraddr;
	private java.lang.String units = "0";	
	
	private String costkey;
	private String ccykey;
	private String vendoraddrkey;

	private boolean avgtariffcalcflag;
	private boolean tariffvarianceflag;
	
	private java.math.BigDecimal mintariffvariance;
	private float mintariffvariancecalc;	
	private java.math.BigDecimal maxtariffvariance;
	private float maxtariffvariancecalc;	
	private java.math.BigDecimal avgtariffratebase;
	private float avgtariffratebasecalc;
	
	private String row;

   
    
    // ----------------------------------------------------------- Properties

	/**
	 */
	public java.lang.String getRow () {
		return row;
	}
	/**
	 */
	public void setRow (java.lang.String row) {
		this.row = row;
	}
	
	
	/**
     */
	public java.lang.String getCosttemplateId () {
		return costtemplateId;
	}

	/**
	 */
	public void setCosttemplateId (java.lang.String costtemplateId) {
		this.costtemplateId = costtemplateId;
	}


	/**
	 */
	public java.lang.String getUnits () {
		return units;
	}
	/**
	 */
	public void setUnits (java.lang.String units) {
		this.units = units;
	}
	

	/**
	 */
	public Cost getCost () {
		return cost;
	}
	/**
	 */
	public void setCost (Cost cost) {
		this.cost = cost;
	}


	/**
	 */
	public java.lang.String getCostkey () {
		return costkey;
	}
	/**
	 */
	public void setCostkey (java.lang.String costkey) {
		this.costkey = costkey;
	}
	
	

	/**
	 */
	public java.lang.String getCosttype () {
		return costtype;
	}
	/**
	 */
	public void setCosttype (java.lang.String costtype) {
		this.costtype = costtype;
	}



	/**
	 */
	public java.lang.String getCcykey () {
		return ccykey;
	}
	/**
	 */
	public void setCcykey (java.lang.String ccykey) {
		this.ccykey = ccykey;
	}


	
	
	/**
	 */
	public Ccy getCcy () {
		return ccy;
	}
	/**
	 */
	public void setCcy (Ccy ccy) {
		this.ccy = ccy;
	}


	
	/**
	 */
	public boolean isTariffvarianceflag () {
		return tariffvarianceflag;
	}

	/**
	 */
	public void setTariffvarianceflag (boolean tariffvarianceflag) {
		this.tariffvarianceflag = tariffvarianceflag;
	}



	/**
	 */
	public java.math.BigDecimal getMintariffvariance () {
		return mintariffvariance;
	}
	/**
	 */
	public void setMintariffvariance (java.math.BigDecimal mintariffvariance) {
		this.mintariffvariance = mintariffvariance;
	}



	/**
	 */
	public java.math.BigDecimal getMaxtariffvariance () {
		return maxtariffvariance;
	}
	/**
	 */
	public void setMaxtariffvariance (java.math.BigDecimal maxtariffvariance) {
		this.maxtariffvariance = maxtariffvariance;
	}

	
	
	/**
	 */
	public boolean isAvgtariffcalcflag () {
		return avgtariffcalcflag;
	}
	/**
	 */
	public void setAvgtariffcalcflag (boolean avgtariffcalcflag) {
		this.avgtariffcalcflag = avgtariffcalcflag;
	}


	/**
	 */
	public java.math.BigDecimal getAvgtariffratebase () {
		return avgtariffratebase;
	}
	/**
	 */
	public void setAvgtariffratebase (java.math.BigDecimal avgtariffratebase) {
		this.avgtariffratebase = avgtariffratebase;
	}


	
	/**
	 */
	public float getAvgtariffratebasecalc () {
		return avgtariffratebasecalc;
	}
	/**
	 */
	public void setAvgtariffratebasecalc (float avgtariffratebasecalc) {
		this.avgtariffratebasecalc = avgtariffratebasecalc;
	}
	

	
	/**
	 */
	public float getMintariffvariancecalc () {
		return mintariffvariancecalc;
	}
	/**
	 */
	public void setMintariffvariancecalc (float mintariffvariancecalc) {
		this.mintariffvariancecalc = mintariffvariancecalc;
	}
	

	
	
	/**
	 */
	public float getMaxtariffvariancecalc () {
		return maxtariffvariancecalc;
	}
	/**
	 */
	public void setMaxtariffvariancecalc (float maxtariffvariancecalc) {
		this.maxtariffvariancecalc = maxtariffvariancecalc;
	}
	
	
	

	/**
	 */
	public Address getVendoraddr () {
		return vendoraddr;
	}
	/**
	 */
	public void setVendoraddr (Address vendoraddr) {
		this.vendoraddr = vendoraddr;
	}

	
	/**
	 */
	public java.lang.String getVendoraddrkey () {
		return vendoraddrkey;
	}
	/**
	 */
	public void setVendoraddrkey (java.lang.String vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}

	
	/**
	 */
	public java.lang.String getVtselectedValue () {
		return vtselectedValue;
	}
	public void setVtselectedValue (java.lang.String vtselectedValue) {
		this.vtselectedValue = vtselectedValue;
	}	


	public List<VendortariffLineItem> getVtlineitems() {
		return vtlineitems;
	}
	public void setVtlineitems(List<VendortariffLineItem> list1) {
		this.vtlineitems = list1;
	}
	
	public int[] getCtselectedObjects() {
		return ctselectedObjects;
	}
	public void setCtselectedObjects(int[] selectedObjects) {
		this.ctselectedObjects = selectedObjects;
	}
	
	


	
    // --------------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {      
    }


    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

	return (errors);

    }

    
	@Override
	public String toString() {
		return 
				 "id=" + costtemplateId 
				;
	}

}


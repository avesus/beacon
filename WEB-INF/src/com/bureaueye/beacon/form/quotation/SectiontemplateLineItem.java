package com.bureaueye.beacon.form.quotation;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Section;


/**
*
* Amendments
* ----------
* 												
*
*/
public final class SectiontemplateLineItem extends ActionForm {


	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	// --------------------------------------------------- Instance Variables

	// collections
	private java.util.List<CosttemplateLineItem> ctlineitems;
	private int[] stselectedObjects;
	
	
	// primary key
	private java.lang.String sectiontemplateId;

	// fields
	private Section section;
	private java.lang.String shipmethod;
	private java.lang.String seqno;
	private Location fromlocation;
	private Location tolocation;
	private Address vendoraddr;
	
	private String sectionkey;
	private String fromlocationkey;
	private String tolocationkey;
	private String vendoraddrkey;
	
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
	public java.lang.String getSectiontemplateId () {
		return sectiontemplateId;
	}

	/**
	 */
	public void setSectiontemplateId (java.lang.String sectiontemplateId) {
		this.sectiontemplateId = sectiontemplateId;
	}




	/**
	 */
	public Section getSection () {
		return section;
	}

	/**
	 */
	public void setSection (Section section) {
		this.section = section;
	}


	/**
	 */
	public java.lang.String getSectionkey () {
		return sectionkey;
	}
	/**
	 */
	public void setSectionkey (java.lang.String sectionkey) {
		this.sectionkey = sectionkey;
	}
	
	

	/**
	 */
	public java.lang.String getShipmethod () {
		return shipmethod;
	}

	/**
	 */
	public void setShipmethod (java.lang.String shipmethod) {
		this.shipmethod = shipmethod;
	}



	/**
	 */
	public java.lang.String getSeqno () {
		return seqno;
	}

	/**
	 */
	public void setSeqno (java.lang.String seqno) {
		this.seqno = seqno;
	}


	/**
	 */
	public java.lang.String getFromlocationkey () {
		return fromlocationkey;
	}
	/**
	 */
	public void setFromlocationkey (java.lang.String fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}



	/**
	 */
	public java.lang.String getTolocationkey () {
		return tolocationkey;
	}
	/**
	 */
	public void setTolocationkey (java.lang.String tolocationkey) {
		this.tolocationkey = tolocationkey;
	}
	
	
	/**
	 */
	public Location getFromlocation () {
		return fromlocation;
	}
	/**
	 */
	public void setFromlocation (Location fromlocation) {
		this.fromlocation = fromlocation;
	}



	/**
	 */
	public Location getTolocation () {
		return tolocation;
	}
	/**
	 */
	public void setTolocation (Location tolocation) {
		this.tolocation = tolocation;
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

	
	


	public List<CosttemplateLineItem> getCtlineitems() {
		return ctlineitems;
	}
	public void setCtlineitems(List<CosttemplateLineItem> list1) {
		this.ctlineitems = list1;
	}
	
	public int[] getStselectedObjects() {
		return stselectedObjects;
	}
	public void setStselectedObjects(int[] selectedObjects) {
		this.stselectedObjects = selectedObjects;
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
				 "id=" + sectiontemplateId 
				;
	}

}


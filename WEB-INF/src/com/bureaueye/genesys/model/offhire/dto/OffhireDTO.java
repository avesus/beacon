package com.bureaueye.genesys.model.offhire.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.genesys.model.offhire.Offhire;




public final class OffhireDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public OffhireDTO(Offhire dao) throws ApplicationException {
		initialize(dao);		
	}
	public OffhireDTO(Offhire dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Offhire dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setId(dao.getOffhireId().toString());
		this.setOffhireno(dao.getOffhireno());	
		
		this.setLesseeaddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getLesseeaddrkey()));
		this.setLocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getLocationkey()));
		
		this.setEqpkeyp1(dao.getEqpkeyp1());		
		this.setEqpkeyp2(dao.getEqpkeyp2());
		
		this.setCompanykey(dao.getCompanykey());
		this.setDepartmentkey(dao.getDepartmentkey());
		this.setActivitykey(dao.getActivitykey());		
		
		this.setCreatedate(dao.getCreatedate());
		this.setSubmitteddate(dao.getSubmitteddate());	
		this.setSubmittedby(dao.getSubmittedby());	
		
		
		this.setOffhireeqpsfound("false");		
		
	}
	

	
    /**
     * The unique id.
     */
    private String _id;
    
	private String _readonly = "false";


	// fields
	private java.lang.String _departmentkey;
	private java.lang.String _companykey;
	private java.lang.String _offhireno;
	private java.lang.String _activitykey;
	
	private java.lang.String _submittedby;

	private java.lang.String _eqpkeyp1;
	private java.lang.String _eqpkeyp2;
	
	private Date _createdate;
	private Date _submitteddate;
	
	// many to one
	private Address _lesseeaddrkey = new Address();
	private Location _locationkey = new Location();
	
	// extra
	private int _offhireeqpssize;
    private boolean checked;
    private String _offhireeqpsfound = "false";
    
    
 

    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    
    
	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	
	public int getOffhireeqpssize() {return _offhireeqpssize;}
	public void setOffhireeqpssize(int _offhireeqpssize) {this._offhireeqpssize = _offhireeqpssize;}


	public String getOffhireeqpsfound() {return _offhireeqpsfound;}
	public void setOffhireeqpsfound(String _offhireeqpsfound) {this._offhireeqpsfound = _offhireeqpsfound;}

	

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
    public Address getLesseeaddrkey() {
    	return (this._lesseeaddrkey);
    }
    /**
     */
    public void setLesseeaddrkey(Address _lesseeaddrkey) {
        this._lesseeaddrkey = _lesseeaddrkey;
    }

    /**
     */
    public Location getLocationkey() {
    	return (this._locationkey);
    }
    /**
     */
    public void setLocationkey(Location _locationkey) {
        this._locationkey = _locationkey;
    }    
    



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return _departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param _departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String _departmentkey) {
		this._departmentkey = _departmentkey;
	}




	/**
	 * Return the value associated with the column: eqpkeyp1
	 */
	public java.lang.String getEqpkeyp1 () {
		return _eqpkeyp1;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param _eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp1 (java.lang.String _eqpkeyp1) {
		this._eqpkeyp1 = _eqpkeyp1;
	}
	
	/**
	 * Return the value associated with the column: eqpkeyp2
	 */
	public java.lang.String getEqpkeyp2 () {
		return _eqpkeyp2;
	}

	/**
	 * Set the value related to the column: eqpkeyp1
	 * @param _eqpkeyp1 the eqpkeyp1 value
	 */
	public void setEqpkeyp2 (java.lang.String _eqpkeyp2) {
		this._eqpkeyp2 = _eqpkeyp2;
	}	



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return _companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param _companykey the companykey value
	 */
	public void setCompanykey (java.lang.String _companykey) {
		this._companykey = _companykey;
	}


	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return _createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param _createdate the createdate value
	 */
	public void setCreatedate (java.util.Date _createdate) {
		this._createdate = _createdate;
	}

	/**
	 * Return the value associated with the column: _submitteddate
	 */
	public java.util.Date getSubmitteddate () {
		return _submitteddate;
	}

	/**
	 * Set the value related to the column: submitteddate
	 * @param _submitteddate the submitteddate value
	 */
	public void setSubmitteddate (java.util.Date _submitteddate) {
		this._submitteddate = _submitteddate;
	}

	/**
	 * Return the value associated with the column: offhireno
	 */
	public java.lang.String getOffhireno () {
		return _offhireno;
	}

	/**
	 * Set the value related to the column: offhireno
	 * @param _offhireno the offhireno value
	 */
	public void setOffhireno (java.lang.String _offhireno) {
		this._offhireno = _offhireno;
	}




	/**
	 * Return the value associated with the column: submittedby
	 */
	public java.lang.String getSubmittedby () {
		return _submittedby;
	}

	/**
	 * Set the value related to the column: submittedby
	 * @param _submittedby the submittedby value
	 */
	public void setSubmittedby (java.lang.String _submittedby) {
		this._submittedby = _submittedby;
	}
	
	
	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return _activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param _activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String _activitykey) {
		this._activitykey = _activitykey;
	}

	
	
}

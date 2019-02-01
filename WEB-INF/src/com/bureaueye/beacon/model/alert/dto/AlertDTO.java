package com.bureaueye.beacon.model.alert.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.alert.Alert;
import com.bureaueye.beacon.model.dto.BaseDTO;




public class AlertDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;



	// constructors
	public AlertDTO() {		
	}
	public AlertDTO(Alert dao) throws ApplicationException {
		initialize(dao);		
	}

	public AlertDTO(Alert dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);		
		initialize(dao);		
	}







	protected void initialize (Alert dao) throws ApplicationException {
		this.alertId = dao.getAlertId();
		this.alertmodule= dao.getAlertmodule();
		this.alerttype= dao.getAlerttype();
		
		try {
			this.alertwhen= 
				"For "+
				dao.getRuleparam1()+" "+
				"start alert when the current date is "+
				dao.getRuleparam4()+" "+
				" the Planned Date"
			;
		} catch (Exception e) {
		}

		try {			
			this.alertwho="";
			if (dao.isMailflag()) this.alertwho=this.alertwho+" Email TO: "+dao.getMailto()+"\n";
			if (dao.isTextflag()) this.alertwho=this.alertwho+" Text TO: "+dao.getTextto()+"\n";	
			if (dao.isTaskflag()) this.alertwho=this.alertwho+" Task User: "+dao.getTaskuserid()+"\n";
		} catch (Exception e) {
		}

		try {
			this.alertwith= "Email Subject: "+dao.getMailsubject();
		} catch (Exception e) {
		}
		
	}




	// primary key
	private java.lang.Integer alertId;

	// fields
	private java.lang.String alerttype;
	private java.lang.String alertmodule;
	private java.lang.String alertwhen;
	private java.lang.String alertwho;
	private java.lang.String alertwith;


	/**
	 */
	public java.lang.Integer getAlertId () {
		return alertId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param alertId the new ID
	 */
	public void setAlertId (java.lang.Integer alertId) {
		this.alertId = alertId;
	}


	/**
	 * Return the value associated with the column: alerttype
	 */
	public java.lang.String getAlerttype () {
		return alerttype;
	}

	/**
	 * Set the value related to the column: alerttype
	 * @param alerttype the alerttype value
	 */
	public void setAlerttype (java.lang.String alerttype) {
		this.alerttype = alerttype;
	}



	/**
	 * Return the value associated with the column: alertmodule
	 */
	public java.lang.String getAlertmodule () {
		return alertmodule;
	}

	/**
	 * Set the value related to the column: alertmodule
	 * @param alertmodule the alertmodule value
	 */
	public void setAlertmodule (java.lang.String alertmodule) {
		this.alertmodule = alertmodule;
	}
	
	

	public java.lang.String getAlertwho () {	return alertwho;}
	public void setAlertwho(java.lang.String alertwho) {		this.alertwho= alertwho;	}
	
	public java.lang.String getAlertwhen () {	return alertwhen;}
	public void setAlertwhen(java.lang.String alertwhen) {		this.alertwhen= alertwhen;	}
	
	public java.lang.String getAlertwith () {	return alertwith;}
	public void setAlertwith(java.lang.String alertwith) {		this.alertwith= alertwith;	}
	
	

}

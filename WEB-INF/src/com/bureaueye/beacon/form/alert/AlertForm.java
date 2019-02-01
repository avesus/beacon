package com.bureaueye.beacon.form.alert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;




public final class AlertForm extends BaseForm {
	private static final long serialVersionUID = 1L;

	
	
	private String action;
	private String readonly = "false";

	
	
	// primary key
	private java.lang.String alertId;

	// fields
	private java.lang.String record1Id;
	private java.lang.String record2Id;
	private java.lang.String taskpriority;
	private java.lang.String alerttype;
	private java.lang.String alertmodule;
	private java.lang.String taskuserid;
	private java.lang.String taskusergroupid;

	private java.lang.String ruleparam1;
	private java.lang.String ruleparam2;
	private java.lang.String ruleparam3;
	private java.lang.String ruleparam4;
	private java.lang.String ruleparam5;
	private java.lang.String ruleparam6;
	private java.lang.String ruleparam7;
	private java.lang.String ruleparam8;
	private java.lang.String ruleparam9;
	private java.lang.String ruleparam10;

	private java.util.Date createdate;
	private java.lang.String createuserid;
	
	private java.lang.String mailmessage;
	private java.lang.String mailsubject;
	private java.lang.String mailto;
	private java.lang.String mailcc;
	private java.lang.String mailbcc;
	private java.lang.String mailfrom;
	
	private java.lang.String textmessage;
	private java.lang.String textto;

	private boolean mailflag;		
	private boolean textflag;
	private boolean taskflag;
	private boolean alertflag;
	
	private String validtodd;
	private String validtomm;
	private String validtoyyyy;
	
	
	//**IMPORTANT** FOR THE A SCREEN LIST TO WORK THE SCREEN *MUST* BE A SESSION SCOPE
	private java.util.List _jobmovs;
	
	
	

	public String getAction() {return action;}
	public void setAction(String action) {this.action = action;}

	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	
	public List getJobmovs() {
		return _jobmovs;
	}
	public void setJobmovs(List _jobmovs) {
		this._jobmovs = _jobmovs;
	}
	
	
	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ALERT_ID"
     */
	public java.lang.String getAlertId () {
		return alertId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param alertId the new ID
	 */
	public void setAlertId (java.lang.String alertId) {
		this.alertId = alertId;
	}





	/**
	 * Return the value associated with the column: RECORD1_ID
	 */
	public java.lang.String getRecord1Id () {
		return record1Id;
	}

	/**
	 * Set the value related to the column: RECORD1_ID
	 * @param record1Id the RECORD1_ID value
	 */
	public void setRecord1Id (java.lang.String record1Id) {
		this.record1Id = record1Id;
	}



	/**
	 * Return the value associated with the column: RECORD2_ID
	 */
	public java.lang.String getRecord2Id () {
		return record2Id;
	}

	/**
	 * Set the value related to the column: RECORD2_ID
	 * @param record2Id the RECORD2_ID value
	 */
	public void setRecord2Id (java.lang.String record2Id) {
		this.record2Id = record2Id;
	}


	
	
	public Date getValidto() {
		Calendar c = Calendar.getInstance();
		c
				.set(Integer.parseInt(getValidtoyyyy()), Integer
						.parseInt(getValidtomm()) - 1, Integer
						.parseInt(getValidtodd()));
		return c.getTime();
	}
	public void setValidto(Date validto) {
		Calendar c = Calendar.getInstance();
		c.setTime(validto);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setValidtoyyyy(c.get(Calendar.YEAR) + "");
		setValidtomm((month < 10 ? "0" : "") + month);
		setValidtodd((day < 10 ? "0" : "") + day);
	}
	public String getValidtodd() {
		return validtodd;
	}
	public void setValidtodd(String validtodd) {
		this.validtodd = validtodd;
	}
	public String getValidtomm() {
		return validtomm;
	}
	public void setValidtomm(String validtomm) {
		this.validtomm = validtomm;
	}
	public String getValidtoyyyy() {
		return validtoyyyy;
	}
	public void setValidtoyyyy(String validtoyyyy) {
		this.validtoyyyy = validtoyyyy;
	}	
	


	public java.lang.String getTaskpriority () {
		return taskpriority;
	}
	public void setTaskpriority (java.lang.String taskpriority) {
		this.taskpriority = taskpriority;
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



	/**
	 * Return the value associated with the column: mailmessage
	 */
	public java.lang.String getMailmessage () {
		return mailmessage;
	}

	/**
	 * Set the value related to the column: mailmessage
	 * @param mailmessage the mailmessage value
	 */
	public void setMailmessage (java.lang.String mailmessage) {
		this.mailmessage = mailmessage;
	}



	/**
	 * Return the value associated with the column: mailsubject
	 */
	public java.lang.String getMailsubject () {
		return mailsubject;
	}

	/**
	 * Set the value related to the column: mailsubject
	 * @param mailsubject the mailsubject value
	 */
	public void setMailsubject (java.lang.String mailsubject) {
		this.mailsubject = mailsubject;
	}




	public java.lang.String getTaskuserid () {
		return taskuserid;
	}
	public void setTaskuserid (java.lang.String taskuserid) {
		this.taskuserid = taskuserid;
	}




	public java.lang.String getTaskusergroupid () {
		return taskusergroupid;
	}
	public void setTaskusergroupid (java.lang.String taskusergroupid) {
		this.taskusergroupid = taskusergroupid;
	}




	public boolean isAlertflag () {
		return alertflag;
	}
	public void setAlertflag (boolean alertflag) {
		this.alertflag = alertflag;
	}


	/**
	 * Return the value associated with the column: mailflag
	 */
	public boolean isMailflag () {
		return mailflag;
	}

	/**
	 * Set the value related to the column: mailflag
	 * @param mailflag the mailflag value
	 */
	public void setMailflag (boolean mailflag) {
		this.mailflag = mailflag;
	}



	/**
	 * Return the value associated with the column: taskflag
	 */
	public boolean isTaskflag () {
		return taskflag;
	}

	/**
	 * Set the value related to the column: taskflag
	 * @param taskflag the taskflag value
	 */
	public void setTaskflag (boolean taskflag) {
		this.taskflag = taskflag;
	}
	
	
	/**
	 * Return the value associated with the column: ruleparam1
	 */
	public java.lang.String getRuleparam1 () {
		return ruleparam1;
	}

	/**
	 * Set the value related to the column: ruleparam1
	 * @param ruleparam1 the ruleparam1 value
	 */
	public void setRuleparam1 (java.lang.String ruleparam1) {
		this.ruleparam1 = ruleparam1;
	}



	/**
	 * Return the value associated with the column: ruleparam2
	 */
	public java.lang.String getRuleparam2 () {
		return ruleparam2;
	}

	/**
	 * Set the value related to the column: ruleparam2
	 * @param ruleparam2 the ruleparam2 value
	 */
	public void setRuleparam2 (java.lang.String ruleparam2) {
		this.ruleparam2 = ruleparam2;
	}



	/**
	 * Return the value associated with the column: ruleparam3
	 */
	public java.lang.String getRuleparam3 () {
		return ruleparam3;
	}

	/**
	 * Set the value related to the column: ruleparam3
	 * @param ruleparam3 the ruleparam3 value
	 */
	public void setRuleparam3 (java.lang.String ruleparam3) {
		this.ruleparam3 = ruleparam3;
	}



	/**
	 * Return the value associated with the column: ruleparam4
	 */
	public java.lang.String getRuleparam4 () {
		return ruleparam4;
	}

	/**
	 * Set the value related to the column: ruleparam4
	 * @param ruleparam4 the ruleparam4 value
	 */
	public void setRuleparam4 (java.lang.String ruleparam4) {
		this.ruleparam4 = ruleparam4;
	}



	/**
	 * Return the value associated with the column: ruleparam5
	 */
	public java.lang.String getRuleparam5 () {
		return ruleparam5;
	}

	/**
	 * Set the value related to the column: ruleparam5
	 * @param ruleparam5 the ruleparam5 value
	 */
	public void setRuleparam5 (java.lang.String ruleparam5) {
		this.ruleparam5 = ruleparam5;
	}



	/**
	 * Return the value associated with the column: ruleparam6
	 */
	public java.lang.String getRuleparam6 () {
		return ruleparam6;
	}

	/**
	 * Set the value related to the column: ruleparam6
	 * @param ruleparam6 the ruleparam6 value
	 */
	public void setRuleparam6 (java.lang.String ruleparam6) {
		this.ruleparam6 = ruleparam6;
	}



	/**
	 * Return the value associated with the column: ruleparam7
	 */
	public java.lang.String getRuleparam7 () {
		return ruleparam7;
	}

	/**
	 * Set the value related to the column: ruleparam7
	 * @param ruleparam7 the ruleparam7 value
	 */
	public void setRuleparam7 (java.lang.String ruleparam7) {
		this.ruleparam7 = ruleparam7;
	}



	/**
	 * Return the value associated with the column: ruleparam8
	 */
	public java.lang.String getRuleparam8 () {
		return ruleparam8;
	}

	/**
	 * Set the value related to the column: ruleparam8
	 * @param ruleparam8 the ruleparam8 value
	 */
	public void setRuleparam8 (java.lang.String ruleparam8) {
		this.ruleparam8 = ruleparam8;
	}



	/**
	 * Return the value associated with the column: ruleparam9
	 */
	public java.lang.String getRuleparam9 () {
		return ruleparam9;
	}

	/**
	 * Set the value related to the column: ruleparam9
	 * @param ruleparam9 the ruleparam9 value
	 */
	public void setRuleparam9 (java.lang.String ruleparam9) {
		this.ruleparam9 = ruleparam9;
	}



	/**
	 * Return the value associated with the column: ruleparam10
	 */
	public java.lang.String getRuleparam10 () {
		return ruleparam10;
	}

	/**
	 * Set the value related to the column: ruleparam10
	 * @param ruleparam10 the ruleparam10 value
	 */
	public void setRuleparam10 (java.lang.String ruleparam10) {
		this.ruleparam10 = ruleparam10;
	}





	/**
	 * Return the value associated with the column: createdate
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: createdate
	 * @param createdate the createdate value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}





	/**
	 * Return the value associated with the column: createuserid
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: createuserid
	 * @param createuserid the createuserid value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}

	
	
	/**
	 * Return the value associated with the column: mailto
	 */
	public java.lang.String getMailto () {
		return mailto;
	}

	/**
	 * Set the value related to the column: mailto
	 * @param mailto the mailto value
	 */
	public void setMailto (java.lang.String mailto) {
		this.mailto = mailto;
	}



	/**
	 * Return the value associated with the column: mailcc
	 */
	public java.lang.String getMailcc () {
		return mailcc;
	}

	/**
	 * Set the value related to the column: mailcc
	 * @param mailcc the mailcc value
	 */
	public void setMailcc (java.lang.String mailcc) {
		this.mailcc = mailcc;
	}



	/**
	 * Return the value associated with the column: mailbcc
	 */
	public java.lang.String getMailbcc () {
		return mailbcc;
	}

	/**
	 * Set the value related to the column: mailbcc
	 * @param mailbcc the mailbcc value
	 */
	public void setMailbcc (java.lang.String mailbcc) {
		this.mailbcc = mailbcc;
	}



	/**
	 * Return the value associated with the column: mailfrom
	 */
	public java.lang.String getMailfrom () {
		return mailfrom;
	}

	/**
	 * Set the value related to the column: mailfrom
	 * @param mailfrom the mailfrom value
	 */
	public void setMailfrom (java.lang.String mailfrom) {
		this.mailfrom = mailfrom;
	}
	
	
	/**
	 * Return the value associated with the column: textto
	 */
	public java.lang.String getTextto () {
		return textto;
	}

	/**
	 * Set the value related to the column: textto
	 * @param textto the textto value
	 */
	public void setTextto (java.lang.String textto) {
		this.textto = textto;
	}



	/**
	 * Return the value associated with the column: textflag
	 */
	public boolean isTextflag () {
		return textflag;
	}

	/**
	 * Set the value related to the column: textflag
	 * @param textflag the textflag value
	 */
	public void setTextflag (boolean textflag) {
		this.textflag = textflag;
	}



	/**
	 * Return the value associated with the column: textmessage
	 */
	public java.lang.String getTextmessage () {
		return textmessage;
	}

	/**
	 * Set the value related to the column: textmessage
	 * @param textmessage the textmessage value
	 */
	public void setTextmessage (java.lang.String textmessage) {
		this.textmessage = textmessage;
	}
	
	

	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (action == null || action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();
		
		
		
/*        if ((ruleparam5 == null) || (ruleparam5.length() < 1))
            errors.add("ruleparam5",
                    new ActionMessage("error.days.required"));   */     	

        
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								validtoyyyy+"-"+
    								validtomm+"-"+ 
    								validtodd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("validtodd", new ActionMessage("error.validto.required"));   
        
        
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
		keysToSkip.add("jobmovs");
		
		return keysToSkip;
	}
	
	
}

package com.bureaueye.beacon.form.system;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;



/**
 *
 * Amendments
 * ----------
 * 
 *	NT	2011-07-12		NTC-201107-0001			BASE CUSTOMER OVERVIEW EXTRACT 
 * 
 */
public final class SystemtaskForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";


	// primary key
	private java.lang.String systemtaskId;

	// fields
	private java.lang.String taskid;

	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;

	private java.lang.String runathour;
	private java.lang.String runatminute;

	private java.lang.String runatperiod1;
	private java.lang.String runatperiod2;
	private java.lang.String taskstatus;

	private java.lang.String taskclass;


	private java.lang.String nextruntime;	
	private java.util.Date nextrundate;
	private java.lang.String nextrun;


	private java.lang.String nextrundatedd;
	private java.lang.String nextrundatemm;
	private java.lang.String nextrundateyyyy;
	private java.lang.String nextruntimehh;
	private java.lang.String nextruntimemm;
	private java.lang.String nextruntimeinmillis;



	private java.lang.String lastruntime;	
	private java.util.Date lastrundate;
	private java.lang.String lastrun;



	public String getAction() {return _action;}
	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}



	/*	*//**
	 * Return the value associated with the column: nextrundate
	 *//*
	public java.util.Date getNextrundate_ () {
		return nextrundate;
	}

	  *//**
	  * Set the value related to the column: nextrundate
	  * @param nextrundate the nextrundate value
	  *//*
	public void setNextrundate (java.util.Date nextrundate) {
		this.nextrundate = nextrundate;
	}*/



	/*	*//**
	 * Return the value associated with the column: nextruntime
	 *//*
	public java.lang.String getNextruntime_ () {
		return nextruntime;
	}

	  *//**
	  * Set the value related to the column: nextruntime
	  * @param nextruntime the nextruntime value
	  *//*
	public void setNextruntime (java.lang.String nextruntime) {
		this.nextruntime = nextruntime;
	}*/




	/**
	 * Return the value associated with the column: nextrun
	 */
	public java.lang.String getNextrun () {
		return nextrun;
	}

	/**
	 * Set the value related to the column: nextrun
	 * @param nextrun the nextrun value
	 */
	public void setNextrun (java.lang.String nextrun) {
		this.nextrun = nextrun;
	}




	public Date getNextrundate() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(Integer.parseInt(getNextrundateyyyy()), Integer
					.parseInt(getNextrundatemm()) - 1, Integer
					.parseInt(getNextrundatedd()));
			return c.getTime();
		} catch(Exception e) { return null; }
	}
	public void setNextrundate(Date nextrundate) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(nextrundate);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
			setNextrundateyyyy(c.get(Calendar.YEAR) + "");
			setNextrundatemm((month < 10 ? "0" : "") + month);
			setNextrundatedd((day < 10 ? "0" : "") + day);
		} catch (Exception e) {
			setNextrundateyyyy("0000");
			setNextrundatemm("00");
			setNextrundatedd("00");			
		}
	}
	public String getNextrundatedd () {return nextrundatedd;}
	public void setNextrundatedd (String nextrundatedd) {this.nextrundatedd = nextrundatedd;}
	public String getNextrundatemm () {return nextrundatemm;}
	public void setNextrundatemm (String nextrundatemm) {this.nextrundatemm = nextrundatemm;}
	public String getNextrundateyyyy () {return nextrundateyyyy;}
	public void setNextrundateyyyy (String nextrundateyyyy) {this.nextrundateyyyy = nextrundateyyyy;}

	public String getNextruntime() {
		try {
			String time = getNextruntimehh()+":"+getNextruntimemm();
			return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setNextruntime(String nextruntime) {
		try {
			String hh = "00";
			try{hh = nextruntime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
			String mm = "00";
			try{mm = nextruntime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
			setNextruntimehh(hh);
			setNextruntimemm(mm);
		} catch (Exception e) {
			setNextruntimehh("00");
			setNextruntimemm("00");			
		}
	}
	public String getNextruntimehh () {return nextruntimehh;}
	public void setNextruntimehh (String nextruntimehh) {this.nextruntimehh = nextruntimehh;}
	public String getNextruntimemm () {return nextruntimemm;}
	public void setNextruntimemm (String nextruntimemm) {this.nextruntimemm = nextruntimemm;}

	public long getNextruntimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getNextrundateyyyy()), 
					Integer.parseInt(getNextrundatemm()) - 1, 
					Integer.parseInt(getNextrundatedd()),
					Integer.parseInt(getNextruntimehh()),
					Integer.parseInt(getNextruntimemm())
			);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setNextruntimeinmillis(String nextruntimeinmillis)	{
		this.nextruntimeinmillis = nextruntimeinmillis;	
	}






	/**
	 * Return the value associated with the column: lastruntime
	 */
	public java.lang.String getLastruntime_ () {
		return lastruntime;
	}

	/**
	 * Set the value related to the column: lastruntime
	 * @param lastruntime the lastruntime value
	 */
	public void setLastruntime (java.lang.String lastruntime) {
		this.lastruntime = lastruntime;
	}



	/**
	 * Return the value associated with the column: lastrun
	 */
	public java.lang.String getLastrun () {
		return lastrun;
	}

	/**
	 * Set the value related to the column: lastrun
	 * @param lastrun the lastrun value
	 */
	public void setLastrun (java.lang.String lastrun) {
		this.lastrun = lastrun;
	}

	/**
	 * Return the value associated with the column: lastrundate
	 */
	public java.util.Date getLastrundate_ () {
		return lastrundate;
	}

	/**
	 * Set the value related to the column: lastrundate
	 * @param lastrundate the lastrundate value
	 */
	public void setLastrundate (java.util.Date lastrundate) {
		this.lastrundate = lastrundate;
	}




	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="native"
	 *  column="SYSTEMTASK_ID"
	 */
	public java.lang.String getSystemtaskId () {
		return systemtaskId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param systemtaskId the new ID
	 */
	public void setSystemtaskId (java.lang.String systemtaskId) {
		this.systemtaskId = systemtaskId;
	}







	/**
	 * Return the value associated with the column: taskid
	 */
	public java.lang.String getTaskid () {
		return taskid;
	}

	/**
	 * Set the value related to the column: taskid
	 * @param taskid the taskid value
	 */
	public void setTaskid (java.lang.String taskid) {
		this.taskid = taskid;
	}



	/**
	 * Return the value associated with the column: departmentkey
	 */
	public java.lang.String getDepartmentkey () {
		return departmentkey;
	}

	/**
	 * Set the value related to the column: departmentkey
	 * @param departmentkey the departmentkey value
	 */
	public void setDepartmentkey (java.lang.String departmentkey) {
		this.departmentkey = departmentkey;
	}



	/**
	 * Return the value associated with the column: runathour
	 */
	public java.lang.String getRunathour () {
		return runathour;
	}

	/**
	 * Set the value related to the column: runathour
	 * @param runathour the runathour value
	 */
	public void setRunathour (java.lang.String runathour) {
		this.runathour = runathour;
	}



	/**
	 * Return the value associated with the column: companykey
	 */
	public java.lang.String getCompanykey () {
		return companykey;
	}

	/**
	 * Set the value related to the column: companykey
	 * @param companykey the companykey value
	 */
	public void setCompanykey (java.lang.String companykey) {
		this.companykey = companykey;
	}




	/**
	 * Return the value associated with the column: runatminute
	 */
	public java.lang.String getRunatminute () {
		return runatminute;
	}

	/**
	 * Set the value related to the column: runatminute
	 * @param runatminute the runatminute value
	 */
	public void setRunatminute (java.lang.String runatminute) {
		this.runatminute = runatminute;
	}





	/**
	 * Return the value associated with the column: runatperiod1
	 */
	public java.lang.String getRunatperiod1 () {
		return runatperiod1;
	}

	/**
	 * Set the value related to the column: runatperiod1
	 * @param runatperiod1 the runatperiod1 value
	 */
	public void setRunatperiod1 (java.lang.String runatperiod1) {
		this.runatperiod1 = runatperiod1;
	}





	/**
	 * Return the value associated with the column: runatperiod2
	 */
	public java.lang.String getRunatperiod2 () {
		return runatperiod2;
	}

	/**
	 * Set the value related to the column: runatperiod2
	 * @param runatperiod2 the runatperiod2 value
	 */
	public void setRunatperiod2 (java.lang.String runatperiod2) {
		this.runatperiod2 = runatperiod2;
	}



	/**
	 * Return the value associated with the column: taskstatus
	 */
	public java.lang.String getTaskstatus () {
		return taskstatus;
	}

	/**
	 * Set the value related to the column: taskstatus
	 * @param taskstatus the taskstatus value
	 */
	public void setTaskstatus (java.lang.String taskstatus) {
		this.taskstatus = taskstatus;
	}




	/**
	 * Return the value associated with the column: activitykey
	 */
	public java.lang.String getActivitykey () {
		return activitykey;
	}

	/**
	 * Set the value related to the column: activitykey
	 * @param activitykey the activitykey value
	 */
	public void setActivitykey (java.lang.String activitykey) {
		this.activitykey = activitykey;
	}







	/**
	 * Return the value associated with the column: taskclass
	 */
	public java.lang.String getTaskclass () {
		return taskclass;
	}

	/**
	 * Set the value related to the column: taskclass
	 * @param taskclass the taskclass value
	 */
	public void setTaskclass (java.lang.String taskclass) {
		this.taskclass = taskclass;
	}







	@Override
	public String toString () {
		return super.toString();
	}





	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();



		addErrorIfBlank(errors, "taskid", taskid, "error.taskid.required");  
		addErrorIfBlank(errors, "runatperiod1", runatperiod1, "error.runatperiod1.required");      
		addErrorIfBlank(errors, "taskclass", taskclass, "error.taskclass.required");      


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
	@Override
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();

		return keysToSkip;
	}


}

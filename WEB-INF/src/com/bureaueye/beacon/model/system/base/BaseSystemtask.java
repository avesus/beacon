package com.bureaueye.beacon.model.system.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the systemtask table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="systemtask"
 */

public abstract class BaseSystemtask  implements Serializable {

	public static String REF = "Systemtask";
	public static String PROP_RUNATMINUTE = "Runatminute";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_SYSTEMTASK_ID = "SystemtaskId";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_TASKCLASS = "Taskclass";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_STARTTIME = "Starttime";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_TASKPARAMETERS = "Taskparameters";
	public static String PROP_TASKID = "Taskid";
	public static String PROP_LASTRUN = "Lastrun";
	public static String PROP_ROWID = "Rowid";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_STARTRUN = "Startrun";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_NEXTRUNTIME = "Nextruntime";
	public static String PROP_STARTDATE = "Startdate";
	public static String PROP_NEXTRUN = "Nextrun";
	public static String PROP_NEXTRUNDATE = "Nextrundate";
	public static String PROP_TASKSTATUS = "Taskstatus";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_LASTRUNDATE = "Lastrundate";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_RUNATPERIOD1 = "Runatperiod1";
	public static String PROP_RUNATHOUR = "Runathour";
	public static String PROP_LASTRUNTIME = "Lastruntime";
	public static String PROP_RUNATPERIOD2 = "Runatperiod2";


	// constructors
	public BaseSystemtask () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSystemtask (java.lang.Integer systemtaskId) {
		this.setSystemtaskId(systemtaskId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer systemtaskId;

	// fields
	private java.util.Date startdate;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String nextruntime;
	private java.lang.String starttime;
	private java.lang.String taskid;
	private java.lang.String departmentkey;
	private java.lang.Integer runathour;
	private java.lang.String companykey;
	private java.lang.Long startrun;
	private java.lang.Integer runatminute;
	private java.lang.String systemlogtime;
	private java.util.Date createdate;
	private java.lang.String createuserid;
	private java.util.Date nextrundate;
	private java.lang.Long nextrun;
	private java.lang.String runatperiod1;
	private java.lang.String lastruntime;
	private java.lang.String runatperiod2;
	private java.lang.String taskstatus;
	private java.lang.Long lastrun;
	private java.lang.Integer rowid;
	private java.lang.String activitykey;
	private java.util.Date lastrundate;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String taskclass;
	private byte[] taskparameters;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="SYSTEMTASK_ID"
     */
	public java.lang.Integer getSystemtaskId () {
		return systemtaskId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param systemtaskId the new ID
	 */
	public void setSystemtaskId (java.lang.Integer systemtaskId) {
		this.systemtaskId = systemtaskId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: startdate
	 */
	public java.util.Date getStartdate () {
		return startdate;
	}

	/**
	 * Set the value related to the column: startdate
	 * @param startdate the startdate value
	 */
	public void setStartdate (java.util.Date startdate) {
		this.startdate = startdate;
	}



	/**
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
	}



	/**
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
	}



	/**
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
	}



	/**
	 * Return the value associated with the column: nextruntime
	 */
	public java.lang.String getNextruntime () {
		return nextruntime;
	}

	/**
	 * Set the value related to the column: nextruntime
	 * @param nextruntime the nextruntime value
	 */
	public void setNextruntime (java.lang.String nextruntime) {
		this.nextruntime = nextruntime;
	}



	/**
	 * Return the value associated with the column: starttime
	 */
	public java.lang.String getStarttime () {
		return starttime;
	}

	/**
	 * Set the value related to the column: starttime
	 * @param starttime the starttime value
	 */
	public void setStarttime (java.lang.String starttime) {
		this.starttime = starttime;
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
	public java.lang.Integer getRunathour () {
		return runathour;
	}

	/**
	 * Set the value related to the column: runathour
	 * @param runathour the runathour value
	 */
	public void setRunathour (java.lang.Integer runathour) {
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
	 * Return the value associated with the column: startrun
	 */
	public java.lang.Long getStartrun () {
		return startrun;
	}

	/**
	 * Set the value related to the column: startrun
	 * @param startrun the startrun value
	 */
	public void setStartrun (java.lang.Long startrun) {
		this.startrun = startrun;
	}



	/**
	 * Return the value associated with the column: runatminute
	 */
	public java.lang.Integer getRunatminute () {
		return runatminute;
	}

	/**
	 * Set the value related to the column: runatminute
	 * @param runatminute the runatminute value
	 */
	public void setRunatminute (java.lang.Integer runatminute) {
		this.runatminute = runatminute;
	}



	/**
	 * Return the value associated with the column: systemlogtime
	 */
	public java.lang.String getSystemlogtime () {
		return systemlogtime;
	}

	/**
	 * Set the value related to the column: systemlogtime
	 * @param systemlogtime the systemlogtime value
	 */
	public void setSystemlogtime (java.lang.String systemlogtime) {
		this.systemlogtime = systemlogtime;
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
	 * Return the value associated with the column: nextrundate
	 */
	public java.util.Date getNextrundate () {
		return nextrundate;
	}

	/**
	 * Set the value related to the column: nextrundate
	 * @param nextrundate the nextrundate value
	 */
	public void setNextrundate (java.util.Date nextrundate) {
		this.nextrundate = nextrundate;
	}



	/**
	 * Return the value associated with the column: nextrun
	 */
	public java.lang.Long getNextrun () {
		return nextrun;
	}

	/**
	 * Set the value related to the column: nextrun
	 * @param nextrun the nextrun value
	 */
	public void setNextrun (java.lang.Long nextrun) {
		this.nextrun = nextrun;
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
	 * Return the value associated with the column: lastruntime
	 */
	public java.lang.String getLastruntime () {
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
	 * Return the value associated with the column: lastrun
	 */
	public java.lang.Long getLastrun () {
		return lastrun;
	}

	/**
	 * Set the value related to the column: lastrun
	 * @param lastrun the lastrun value
	 */
	public void setLastrun (java.lang.Long lastrun) {
		this.lastrun = lastrun;
	}



	/**
	 * Return the value associated with the column: rowid
	 */
	public java.lang.Integer getRowid () {
		return rowid;
	}

	/**
	 * Set the value related to the column: rowid
	 * @param rowid the rowid value
	 */
	public void setRowid (java.lang.Integer rowid) {
		this.rowid = rowid;
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
	 * Return the value associated with the column: lastrundate
	 */
	public java.util.Date getLastrundate () {
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
	 * Return the value associated with the column: createtime
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: xlock
	 */
	public java.lang.String getXlock () {
		return xlock;
	}

	/**
	 * Set the value related to the column: xlock
	 * @param xlock the xlock value
	 */
	public void setXlock (java.lang.String xlock) {
		this.xlock = xlock;
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



	/**
	 * Return the value associated with the column: taskparameters
	 */
	public byte[] getTaskparameters () {
		return taskparameters;
	}

	/**
	 * Set the value related to the column: taskparameters
	 * @param taskparameters the taskparameters value
	 */
	public void setTaskparameters (byte[] taskparameters) {
		this.taskparameters = taskparameters;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.system.Systemtask)) return false;
		else {
			com.bureaueye.beacon.model.system.Systemtask systemtask = (com.bureaueye.beacon.model.system.Systemtask) obj;
			if (null == this.getSystemtaskId() || null == systemtask.getSystemtaskId()) return false;
			else return (this.getSystemtaskId().equals(systemtask.getSystemtaskId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getSystemtaskId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getSystemtaskId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
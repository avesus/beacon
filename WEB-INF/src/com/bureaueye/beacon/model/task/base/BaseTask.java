package com.bureaueye.beacon.model.task.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the task table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="task"
 */

public abstract class BaseTask  implements Serializable {

	public static String REF = "Task";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_ALERT_ID = "AlertId";
	public static String PROP_OWNERUSERID = "Owneruserid";
	public static String PROP_DUEDATE = "Duedate";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_STARTDATE = "Startdate";
	public static String PROP_COMPLETED = "Completed";
	public static String PROP_TASK_ID = "TaskId";
	public static String PROP_OWNERUSERGROUPID = "Ownerusergroupid";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_TASKMESSAGE = "Taskmessage";
	public static String PROP_TASKSUBJECT = "Tasksubject";
	public static String PROP_TASKSTATUS = "Taskstatus";
	public static String PROP_TASKPRIORITY = "Taskpriority";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseTask () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTask (java.lang.Integer taskId) {
		this.setTaskId(taskId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer taskId;

	// fields
	private java.lang.Integer alertId;
	private java.lang.String taskpriority;
	private java.lang.String taskstatus;
	private java.lang.String owneruserid;
	private java.lang.String ownerusergroupid;
	private java.lang.String taskmessage;
	private java.lang.String tasksubject;
	private java.util.Date startdate;
	private java.util.Date duedate;
	private java.lang.Integer completed;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String xlock;
	private java.lang.Byte xinactive;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="TASK_ID"
     */
	public java.lang.Integer getTaskId () {
		return taskId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param taskId the new ID
	 */
	public void setTaskId (java.lang.Integer taskId) {
		this.taskId = taskId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: ALERT_ID
	 */
	public java.lang.Integer getAlertId () {
		return alertId;
	}

	/**
	 * Set the value related to the column: ALERT_ID
	 * @param alertId the ALERT_ID value
	 */
	public void setAlertId (java.lang.Integer alertId) {
		this.alertId = alertId;
	}



	/**
	 * Return the value associated with the column: taskpriority
	 */
	public java.lang.String getTaskpriority () {
		return taskpriority;
	}

	/**
	 * Set the value related to the column: taskpriority
	 * @param taskpriority the taskpriority value
	 */
	public void setTaskpriority (java.lang.String taskpriority) {
		this.taskpriority = taskpriority;
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
	 * Return the value associated with the column: owneruserid
	 */
	public java.lang.String getOwneruserid () {
		return owneruserid;
	}

	/**
	 * Set the value related to the column: owneruserid
	 * @param owneruserid the owneruserid value
	 */
	public void setOwneruserid (java.lang.String owneruserid) {
		this.owneruserid = owneruserid;
	}



	/**
	 * Return the value associated with the column: ownerusergroupid
	 */
	public java.lang.String getOwnerusergroupid () {
		return ownerusergroupid;
	}

	/**
	 * Set the value related to the column: ownerusergroupid
	 * @param ownerusergroupid the ownerusergroupid value
	 */
	public void setOwnerusergroupid (java.lang.String ownerusergroupid) {
		this.ownerusergroupid = ownerusergroupid;
	}



	/**
	 * Return the value associated with the column: taskmessage
	 */
	public java.lang.String getTaskmessage () {
		return taskmessage;
	}

	/**
	 * Set the value related to the column: taskmessage
	 * @param taskmessage the taskmessage value
	 */
	public void setTaskmessage (java.lang.String taskmessage) {
		this.taskmessage = taskmessage;
	}



	/**
	 * Return the value associated with the column: tasksubject
	 */
	public java.lang.String getTasksubject () {
		return tasksubject;
	}

	/**
	 * Set the value related to the column: tasksubject
	 * @param tasksubject the tasksubject value
	 */
	public void setTasksubject (java.lang.String tasksubject) {
		this.tasksubject = tasksubject;
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
	 * Return the value associated with the column: duedate
	 */
	public java.util.Date getDuedate () {
		return duedate;
	}

	/**
	 * Set the value related to the column: duedate
	 * @param duedate the duedate value
	 */
	public void setDuedate (java.util.Date duedate) {
		this.duedate = duedate;
	}



	/**
	 * Return the value associated with the column: completed
	 */
	public java.lang.Integer getCompleted () {
		return completed;
	}

	/**
	 * Set the value related to the column: completed
	 * @param completed the completed value
	 */
	public void setCompleted (java.lang.Integer completed) {
		this.completed = completed;
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
	 * Return the value associated with the column: xinactive
	 */
	public java.lang.Byte getXinactive () {
		return xinactive;
	}

	/**
	 * Set the value related to the column: xinactive
	 * @param xinactive the xinactive value
	 */
	public void setXinactive (java.lang.Byte xinactive) {
		this.xinactive = xinactive;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.task.Task)) return false;
		else {
			com.bureaueye.beacon.model.task.Task task = (com.bureaueye.beacon.model.task.Task) obj;
			if (null == this.getTaskId() || null == task.getTaskId()) return false;
			else return (this.getTaskId().equals(task.getTaskId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getTaskId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getTaskId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
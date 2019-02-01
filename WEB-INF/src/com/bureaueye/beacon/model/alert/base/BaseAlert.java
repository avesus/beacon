package com.bureaueye.beacon.model.alert.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the alert table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="alert"
 */

public abstract class BaseAlert  implements Serializable {

	public static String REF = "Alert";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_TEXTFLAG = "Textflag";
	public static String PROP_RECORD2_ID = "Record2Id";
	public static String PROP_RECORD1_ID = "Record1Id";
	public static String PROP_ALERTMODULE = "Alertmodule";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_TASKUSERID = "Taskuserid";
	public static String PROP_TEXTMESSAGE = "Textmessage";
	public static String PROP_TEXTTO = "Textto";
	public static String PROP_MAILBCC = "Mailbcc";
	public static String PROP_MAILTO = "Mailto";
	public static String PROP_TASKPRIORITY = "Taskpriority";
	public static String PROP_MAILCC = "Mailcc";
	public static String PROP_MAILSUBJECT = "Mailsubject";
	public static String PROP_ALERTTYPE = "Alerttype";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_TASKUSERGROUPID = "Taskusergroupid";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_RULEPARAM9 = "Ruleparam9";
	public static String PROP_ALERT_ID = "AlertId";
	public static String PROP_XINACTIVE = "Xinactive";
	public static String PROP_RULEPARAM10 = "Ruleparam10";
	public static String PROP_ALERTFLAG = "Alertflag";
	public static String PROP_RULEPARAM5 = "Ruleparam5";
	public static String PROP_RULEPARAM6 = "Ruleparam6";
	public static String PROP_RULEPARAM7 = "Ruleparam7";
	public static String PROP_VALIDFROM = "Validfrom";
	public static String PROP_RULEPARAM8 = "Ruleparam8";
	public static String PROP_RULEPARAM1 = "Ruleparam1";
	public static String PROP_RULEPARAM2 = "Ruleparam2";
	public static String PROP_RULEPARAM3 = "Ruleparam3";
	public static String PROP_RULEPARAM4 = "Ruleparam4";
	public static String PROP_VALIDTO = "Validto";
	public static String PROP_MAILFLAG = "Mailflag";
	public static String PROP_MAILMESSAGE = "Mailmessage";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_MAILFROM = "Mailfrom";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_TASKFLAG = "Taskflag";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseAlert () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAlert (java.lang.Integer alertId) {
		this.setAlertId(alertId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer alertId;

	// fields
	private java.lang.Integer record1Id;
	private java.lang.Integer record2Id;
	private java.lang.String taskpriority;
	private java.lang.String alerttype;
	private java.lang.String alertmodule;
	private java.lang.String mailmessage;
	private java.lang.String mailsubject;
	private java.lang.String taskuserid;
	private java.lang.String taskusergroupid;
	private boolean alertflag;
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
	private java.lang.String mailto;
	private java.lang.String mailcc;
	private java.lang.String mailbcc;
	private java.lang.String mailfrom;
	private boolean mailflag;
	private boolean taskflag;
	private java.util.Date validfrom;
	private java.util.Date validto;
	private java.lang.String textto;
	private boolean textflag;
	private java.lang.String textmessage;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ALERT_ID"
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
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: RECORD1_ID
	 */
	public java.lang.Integer getRecord1Id () {
		return record1Id;
	}

	/**
	 * Set the value related to the column: RECORD1_ID
	 * @param record1Id the RECORD1_ID value
	 */
	public void setRecord1Id (java.lang.Integer record1Id) {
		this.record1Id = record1Id;
	}



	/**
	 * Return the value associated with the column: RECORD2_ID
	 */
	public java.lang.Integer getRecord2Id () {
		return record2Id;
	}

	/**
	 * Set the value related to the column: RECORD2_ID
	 * @param record2Id the RECORD2_ID value
	 */
	public void setRecord2Id (java.lang.Integer record2Id) {
		this.record2Id = record2Id;
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



	/**
	 * Return the value associated with the column: taskuserid
	 */
	public java.lang.String getTaskuserid () {
		return taskuserid;
	}

	/**
	 * Set the value related to the column: taskuserid
	 * @param taskuserid the taskuserid value
	 */
	public void setTaskuserid (java.lang.String taskuserid) {
		this.taskuserid = taskuserid;
	}



	/**
	 * Return the value associated with the column: taskusergroupid
	 */
	public java.lang.String getTaskusergroupid () {
		return taskusergroupid;
	}

	/**
	 * Set the value related to the column: taskusergroupid
	 * @param taskusergroupid the taskusergroupid value
	 */
	public void setTaskusergroupid (java.lang.String taskusergroupid) {
		this.taskusergroupid = taskusergroupid;
	}



	/**
	 * Return the value associated with the column: alertflag
	 */
	public boolean isAlertflag () {
		return alertflag;
	}

	/**
	 * Set the value related to the column: alertflag
	 * @param alertflag the alertflag value
	 */
	public void setAlertflag (boolean alertflag) {
		this.alertflag = alertflag;
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
	 * Return the value associated with the column: validfrom
	 */
	public java.util.Date getValidfrom () {
		return validfrom;
	}

	/**
	 * Set the value related to the column: validfrom
	 * @param validfrom the validfrom value
	 */
	public void setValidfrom (java.util.Date validfrom) {
		this.validfrom = validfrom;
	}



	/**
	 * Return the value associated with the column: validto
	 */
	public java.util.Date getValidto () {
		return validto;
	}

	/**
	 * Set the value related to the column: validto
	 * @param validto the validto value
	 */
	public void setValidto (java.util.Date validto) {
		this.validto = validto;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.alert.Alert)) return false;
		else {
			com.bureaueye.beacon.model.alert.Alert alert = (com.bureaueye.beacon.model.alert.Alert) obj;
			if (null == this.getAlertId() || null == alert.getAlertId()) return false;
			else return (this.getAlertId().equals(alert.getAlertId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getAlertId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getAlertId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
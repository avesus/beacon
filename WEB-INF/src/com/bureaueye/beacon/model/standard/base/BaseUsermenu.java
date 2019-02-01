package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the usermenu table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="usermenu"
 */

public abstract class BaseUsermenu  implements Serializable {

	public static String REF = "Usermenu";
	public static String PROP_USERMENU_ID = "UsermenuId";
	public static String PROP_USERID = "Userid";
	public static String PROP_PROGRAMTYPE = "Programtype";
	public static String PROP_PROGRAMID = "Programid";
	public static String PROP_MENUID = "Menuid";
	public static String PROP_DISABLEDFLAG = "Disabledflag";
	public static String PROP_PROGRAMBUTTONDISABLED = "Programbuttondisabled";
	public static String PROP_PROGRAMBUTTON = "Programbutton";
	public static String PROP_SEQUENCE = "Sequence";
	public static String PROP_DESKTOPFLAG = "desktopflag";


	// constructors
	public BaseUsermenu () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsermenu (java.lang.Integer usermenuId) {
		this.setUsermenuId(usermenuId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer usermenuId;

	// fields
	private java.lang.String userid;
	private java.lang.String programtype;
	private java.lang.String programid;
	private java.lang.String menuid;
	private java.lang.Integer sequence;
	private java.lang.String programbutton;
	private java.lang.String programbuttondisabled;
	private boolean disabledflag;
	private boolean desktopflag;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USERMENU_ID"
     */
	public java.lang.Integer getUsermenuId () {
		return usermenuId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param usermenuId the new ID
	 */
	public void setUsermenuId (java.lang.Integer usermenuId) {
		this.usermenuId = usermenuId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: programtype
	 */
	public java.lang.String getProgramtype () {
		return programtype;
	}

	/**
	 * Set the value related to the column: programtype
	 * @param programtype the programtype value
	 */
	public void setProgramtype (java.lang.String programtype) {
		this.programtype = programtype;
	}



	/**
	 * Return the value associated with the column: programid
	 */
	public java.lang.String getProgramid () {
		return programid;
	}

	/**
	 * Set the value related to the column: programid
	 * @param programid the programid value
	 */
	public void setProgramid (java.lang.String programid) {
		this.programid = programid;
	}



	/**
	 * Return the value associated with the column: menuid
	 */
	public java.lang.String getMenuid () {
		return menuid;
	}

	/**
	 * Set the value related to the column: menuid
	 * @param menuid the menuid value
	 */
	public void setMenuid (java.lang.String menuid) {
		this.menuid = menuid;
	}



	/**
	 * Return the value associated with the column: sequence
	 */
	public java.lang.Integer getSequence () {
		return sequence;
	}

	/**
	 * Set the value related to the column: sequence
	 * @param sequence the sequence value
	 */
	public void setSequence (java.lang.Integer sequence) {
		this.sequence = sequence;
	}



	/**
	 * Return the value associated with the column: programbutton
	 */
	public java.lang.String getProgrambutton () {
		return programbutton;
	}

	/**
	 * Set the value related to the column: programbutton
	 * @param programbutton the programbutton value
	 */
	public void setProgrambutton (java.lang.String programbutton) {
		this.programbutton = programbutton;
	}



	/**
	 * Return the value associated with the column: programbuttondisabled
	 */
	public java.lang.String getProgrambuttondisabled () {
		return programbuttondisabled;
	}

	/**
	 * Set the value related to the column: programbuttondisabled
	 * @param programbuttondisabled the programbuttondisabled value
	 */
	public void setProgrambuttondisabled (java.lang.String programbuttondisabled) {
		this.programbuttondisabled = programbuttondisabled;
	}



	/**
	 * Return the value associated with the column: disabledflag
	 */
	public boolean isDisabledflag () {
		return disabledflag;
	}

	/**
	 * Set the value related to the column: disabledflag
	 * @param disabledflag the disabledflag value
	 */
	public void setDisabledflag (boolean disabledflag) {
		this.disabledflag = disabledflag;
	}



	/**
	 * Return the value associated with the column: desktopflag
	 */
	public boolean isDesktopflag () {
		return desktopflag;
	}

	/**
	 * Set the value related to the column: desktopflag
	 * @param desktopflag the desktopflag value
	 */
	public void setDesktopflag (boolean desktopflag) {
		this.desktopflag = desktopflag;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Usermenu)) return false;
		else {
			com.bureaueye.beacon.model.standard.Usermenu usermenu = (com.bureaueye.beacon.model.standard.Usermenu) obj;
			if (null == this.getUsermenuId() || null == usermenu.getUsermenuId()) return false;
			else return (this.getUsermenuId().equals(usermenu.getUsermenuId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUsermenuId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUsermenuId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
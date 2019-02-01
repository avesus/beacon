package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the usergroupmenu table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="usergroupmenu"
 */

public abstract class BaseUsergroupmenu  implements Serializable {

	public static String REF = "Usergroupmenu";
	public static String PROP_PROGRAMTYPE = "Programtype";
	public static String PROP_PROGRAMID = "Programid";
	public static String PROP_MENUID = "Menuid";
	public static String PROP_USERGROUPMENU_ID = "UsergroupmenuId";
	public static String PROP_SEQUENCE = "Sequence";
	public static String PROP_USERGROUPID = "Usergroupid";


	// constructors
	public BaseUsergroupmenu () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsergroupmenu (java.lang.Integer usergroupmenuId) {
		this.setUsergroupmenuId(usergroupmenuId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer usergroupmenuId;

	// fields
	private java.lang.String usergroupid;
	private java.lang.String programtype;
	private java.lang.String programid;
	private java.lang.String menuid;
	private java.lang.Integer sequence;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USERGROUPMENU_ID"
     */
	public java.lang.Integer getUsergroupmenuId () {
		return usergroupmenuId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param usergroupmenuId the new ID
	 */
	public void setUsergroupmenuId (java.lang.Integer usergroupmenuId) {
		this.usergroupmenuId = usergroupmenuId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: usergroupid
	 */
	public java.lang.String getUsergroupid () {
		return usergroupid;
	}

	/**
	 * Set the value related to the column: usergroupid
	 * @param usergroupid the usergroupid value
	 */
	public void setUsergroupid (java.lang.String usergroupid) {
		this.usergroupid = usergroupid;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Usergroupmenu)) return false;
		else {
			com.bureaueye.beacon.model.standard.Usergroupmenu usergroupmenu = (com.bureaueye.beacon.model.standard.Usergroupmenu) obj;
			if (null == this.getUsergroupmenuId() || null == usergroupmenu.getUsergroupmenuId()) return false;
			else return (this.getUsergroupmenuId().equals(usergroupmenu.getUsergroupmenuId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUsergroupmenuId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUsergroupmenuId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
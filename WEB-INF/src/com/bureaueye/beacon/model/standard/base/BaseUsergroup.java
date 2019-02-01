package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the usergroup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="usergroup"
 */

public abstract class BaseUsergroup  implements Serializable {

	public static String REF = "Usergroup";
	public static String PROP_NAME = "Name";
	public static String PROP_EMAIL = "Email";
	public static String PROP_USERGROUPID = "Usergroupid";


	// constructors
	public BaseUsergroup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsergroup (java.lang.String usergroupid) {
		this.setUsergroupid(usergroupid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String usergroupid;

	// fields
	private java.lang.String email;
	private java.lang.String name;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="usergroupid"
     */
	public java.lang.String getUsergroupid () {
		return usergroupid;
	}

	/**
	 * Set the unique identifier of this class
	 * @param usergroupid the new ID
	 */
	public void setUsergroupid (java.lang.String usergroupid) {
		this.usergroupid = usergroupid;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Usergroup)) return false;
		else {
			com.bureaueye.beacon.model.standard.Usergroup usergroup = (com.bureaueye.beacon.model.standard.Usergroup) obj;
			if (null == this.getUsergroupid() || null == usergroup.getUsergroupid()) return false;
			else return (this.getUsergroupid().equals(usergroup.getUsergroupid()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUsergroupid()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUsergroupid().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
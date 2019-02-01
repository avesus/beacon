package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the unittest table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="unittest"
 */

public abstract class BaseUnittest  implements Serializable {

	public static String REF = "Unittest";
	public static String PROP_PERIOD = "Period";
	public static String PROP_DELETED = "Deleted";
	public static String PROP_MANDRKEY = "Mandrkey";
	public static String PROP_READING = "Reading";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_XRATE = "Xrate";
	public static String PROP_DUEDATE = "Duedate";
	public static String PROP_COMPLETED = "Completed";
	public static String PROP_TESTTYPEKEY = "Testtypekey";
	public static String PROP_DESCR = "Descr";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_TESTBY = "Testby";
	public static String PROP_MANDRLINKKEY = "Mandrlinkkey";
	public static String PROP_LASTTESTDATE = "Lasttestdate";
	public static String PROP_MAINTEST = "Maintest";
	public static String PROP_UNITKEY = "Unitkey";
	public static String PROP_COMPDATE = "Compdate";
	public static String PROP_UNITTEST_ID = "UnittestId";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_FREQUENCY = "Frequency";
	public static String PROP_UNIT_ID = "UnitId";
	public static String PROP_DEPOTADDRKEY = "Depotaddrkey";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseUnittest () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUnittest (java.lang.Integer unittestId) {
		this.setUnittestId(unittestId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer unittestId;

	// fields
	private boolean deleted;
	private java.lang.Integer mandrlinkkey;
	private java.lang.Integer period;
	private java.lang.Integer unitId;
	private java.lang.String testtypekey;
	private java.lang.String frequency;
	private java.lang.String createuserid;
	private java.util.Date lasttestdate;
	private java.lang.String mandrkey;
	private boolean completed;
	private boolean maintest;
	private java.lang.String testby;
	private java.lang.String descr;
	private java.math.BigDecimal reading;
	private java.util.Date compdate;
	private java.util.Date duedate;
	private java.util.Date createdate;
	private java.lang.String unitkey;
	private java.math.BigDecimal xrate;
	private java.lang.String createtime;
	private java.lang.String xlock;
	private java.lang.String depotaddrkey;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="UNITTEST_ID"
     */
	public java.lang.Integer getUnittestId () {
		return unittestId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param unittestId the new ID
	 */
	public void setUnittestId (java.lang.Integer unittestId) {
		this.unittestId = unittestId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: deleted
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: deleted
	 * @param deleted the deleted value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: mandrlinkkey
	 */
	public java.lang.Integer getMandrlinkkey () {
		return mandrlinkkey;
	}

	/**
	 * Set the value related to the column: mandrlinkkey
	 * @param mandrlinkkey the mandrlinkkey value
	 */
	public void setMandrlinkkey (java.lang.Integer mandrlinkkey) {
		this.mandrlinkkey = mandrlinkkey;
	}



	/**
	 * Return the value associated with the column: period
	 */
	public java.lang.Integer getPeriod () {
		return period;
	}

	/**
	 * Set the value related to the column: period
	 * @param period the period value
	 */
	public void setPeriod (java.lang.Integer period) {
		this.period = period;
	}



	/**
	 * Return the value associated with the column: UNIT_ID
	 */
	public java.lang.Integer getUnitId () {
		return unitId;
	}

	/**
	 * Set the value related to the column: UNIT_ID
	 * @param unitId the UNIT_ID value
	 */
	public void setUnitId (java.lang.Integer unitId) {
		this.unitId = unitId;
	}



	/**
	 * Return the value associated with the column: testtypekey
	 */
	public java.lang.String getTesttypekey () {
		return testtypekey;
	}

	/**
	 * Set the value related to the column: testtypekey
	 * @param testtypekey the testtypekey value
	 */
	public void setTesttypekey (java.lang.String testtypekey) {
		this.testtypekey = testtypekey;
	}



	/**
	 * Return the value associated with the column: frequency
	 */
	public java.lang.String getFrequency () {
		return frequency;
	}

	/**
	 * Set the value related to the column: frequency
	 * @param frequency the frequency value
	 */
	public void setFrequency (java.lang.String frequency) {
		this.frequency = frequency;
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
	 * Return the value associated with the column: lasttestdate
	 */
	public java.util.Date getLasttestdate () {
		return lasttestdate;
	}

	/**
	 * Set the value related to the column: lasttestdate
	 * @param lasttestdate the lasttestdate value
	 */
	public void setLasttestdate (java.util.Date lasttestdate) {
		this.lasttestdate = lasttestdate;
	}



	/**
	 * Return the value associated with the column: mandrkey
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: mandrkey
	 * @param mandrkey the mandrkey value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}



	/**
	 * Return the value associated with the column: completed
	 */
	public boolean isCompleted () {
		return completed;
	}

	/**
	 * Set the value related to the column: completed
	 * @param completed the completed value
	 */
	public void setCompleted (boolean completed) {
		this.completed = completed;
	}



	/**
	 * Return the value associated with the column: maintest
	 */
	public boolean isMaintest () {
		return maintest;
	}

	/**
	 * Set the value related to the column: maintest
	 * @param maintest the maintest value
	 */
	public void setMaintest (boolean maintest) {
		this.maintest = maintest;
	}



	/**
	 * Return the value associated with the column: testby
	 */
	public java.lang.String getTestby () {
		return testby;
	}

	/**
	 * Set the value related to the column: testby
	 * @param testby the testby value
	 */
	public void setTestby (java.lang.String testby) {
		this.testby = testby;
	}



	/**
	 * Return the value associated with the column: descr
	 */
	public java.lang.String getDescr () {
		return descr;
	}

	/**
	 * Set the value related to the column: descr
	 * @param descr the descr value
	 */
	public void setDescr (java.lang.String descr) {
		this.descr = descr;
	}



	/**
	 * Return the value associated with the column: reading
	 */
	public java.math.BigDecimal getReading () {
		return reading;
	}

	/**
	 * Set the value related to the column: reading
	 * @param reading the reading value
	 */
	public void setReading (java.math.BigDecimal reading) {
		this.reading = reading;
	}



	/**
	 * Return the value associated with the column: compdate
	 */
	public java.util.Date getCompdate () {
		return compdate;
	}

	/**
	 * Set the value related to the column: compdate
	 * @param compdate the compdate value
	 */
	public void setCompdate (java.util.Date compdate) {
		this.compdate = compdate;
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
	 * Return the value associated with the column: unitkey
	 */
	public java.lang.String getUnitkey () {
		return unitkey;
	}

	/**
	 * Set the value related to the column: unitkey
	 * @param unitkey the unitkey value
	 */
	public void setUnitkey (java.lang.String unitkey) {
		this.unitkey = unitkey;
	}



	/**
	 * Return the value associated with the column: xrate
	 */
	public java.math.BigDecimal getXrate () {
		return xrate;
	}

	/**
	 * Set the value related to the column: xrate
	 * @param xrate the xrate value
	 */
	public void setXrate (java.math.BigDecimal xrate) {
		this.xrate = xrate;
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
	 * Return the value associated with the column: depotaddrkey
	 */
	public java.lang.String getDepotaddrkey () {
		return depotaddrkey;
	}

	/**
	 * Set the value related to the column: depotaddrkey
	 * @param depotaddrkey the depotaddrkey value
	 */
	public void setDepotaddrkey (java.lang.String depotaddrkey) {
		this.depotaddrkey = depotaddrkey;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Unittest)) return false;
		else {
			com.bureaueye.beacon.model.standard.Unittest unittest = (com.bureaueye.beacon.model.standard.Unittest) obj;
			if (null == this.getUnittestId() || null == unittest.getUnittestId()) return false;
			else return (this.getUnittestId().equals(unittest.getUnittestId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUnittestId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUnittestId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
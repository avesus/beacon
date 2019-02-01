package com.bureaueye.beacon.model.job.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.job.Jobhdr;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;

public class JobmovDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;



	// constructors
	public JobmovDTO() {		
	}
	public JobmovDTO(Jobmov dao) throws ApplicationException {
		initialize(dao);		
	}
	public JobmovDTO(Jobhdr jobhdr, Jobmov jobmov) throws ApplicationException {
		initialize(jobmov);
		initialize(jobhdr);	
	}
	public JobmovDTO(Orderhdr orderhdr, Jobhdr jobhdr, Jobmov jobmov) throws ApplicationException {
		initialize(jobmov);
		initialize(jobhdr);
		initialize(orderhdr);		
	}	

	public JobmovDTO(Jobmov dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);		
		initialize(dao);		
	}
	public JobmovDTO(Jobhdr jobhdr, Jobmov jobmov, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);		
		initialize(jobmov);
		initialize(jobhdr);	
	}
	public JobmovDTO(Orderhdr orderhdr, Jobhdr jobhdr, Jobmov jobmov, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(jobmov);
		initialize(jobhdr);
		initialize(orderhdr);		
	}










	protected void initialize (Jobmov dao) throws ApplicationException {

		// populate data-transfer-object from data-access-object
		this.setFromlocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getFromlocationkey()));
		this.setTolocationkey(new LocationBD(this.getSessionFactoryClusterMap()).read(dao.getTolocationkey()));
		this.setVendoraddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getVendoraddrkey()));
		this.setSectionkey(new SectionBD(this.getSessionFactoryClusterMap()).read(dao.getSectionkey()));

		this.jobhdrId = dao.getJobhdrId();
		this.jobmovId = dao.getJobmovId();
		this.mmulink = dao.getMmulink();
		this.movref = dao.getMovref();
		this.txt = dao.getTxt();
		this.vessel = dao.getVessel();

		this.movests = dao.getMovests();
		this.invsts = dao.getInvsts();

		this.actfromdate = dao.getActfromdate();
		this.acttodate = dao.getActtodate();
		this.estfromdate = dao.getEstfromdate();
		this.esttodate = dao.getEsttodate();

		this.actfromtime = dao.getActfromtime();
		this.acttotime = dao.getActtotime();
		this.estfromtime = dao.getEstfromtime();
		this.esttotime = dao.getEsttotime();

		this.actfromtimeinmillis = dao.getActfromtimeinmillis();
		this.acttotimeinmillis = dao.getActtotimeinmillis();

		this.fromdate = dao.getFromdate();
		this.todate = dao.getTodate();
		this.fromtime = dao.getFromtime();
		this.totime = dao.getTotime();			
		this.fromtimeinmillis = dao.getFromtimeinmillis();
		this.totimeinmillis = dao.getTotimeinmillis();

	}


	protected void initialize (Jobhdr dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object		
		this.unitkey = dao.getUnitkey();
		this.jobhdrId = dao.getJobhdrId();
		this.orderhdrId = dao.getOrderhdrId();
		this.orderno = dao.getOrderno();
		this.setProductkey(new ProductBD(this.getSessionFactoryClusterMap()).read(dao.getProductkey()));		
	}


	protected void initialize (Orderhdr dao) {
		this.orderno = dao.getOrderno();		
	}




	// primary key
	private java.lang.Integer jobmovId;

	// fields

	private java.lang.Integer jobhdrId;
	private java.lang.Integer orderhdrId;
	private java.lang.String unitkey;

	private java.lang.String mmulink;
	private java.lang.String movref;
	private java.lang.Integer unitId;
	private boolean deleted;
	private java.util.Date lastdmrgfrdate;
	private java.lang.String departmentkey;
	private java.lang.Long acttotimeinmillis;
	private java.lang.String tog3key;
	private java.lang.String systemlogtime;
	private java.lang.String tog4key;
	private java.lang.Long estfromtimeinmillis;
	private java.lang.String tog1key;
	private java.lang.Long actfromtimeinmillis;
	private boolean dmrgfinishflag;
	private boolean dmrgfredayleft;
	private java.lang.String vessel;
	private java.lang.Long esttotimeinmillis;
	private java.lang.String vsbkcontact;
	private java.lang.String bookkey;
	private boolean stdCostsGenerated;
	private java.util.Date lastdmrgtodate;
	private java.lang.String fromg2key;
	private java.lang.String vsbkref;
	private java.lang.String txt;
	private java.util.Date acttodate;
	private java.lang.String fromg1key;
	private java.lang.String fromg4key;
	private java.lang.String trtype;
	private java.lang.String voyage;
	private java.util.Date estfromdate;
	private java.lang.String avlstat;
	private java.util.Date esttodate;
	private java.lang.String tog2key;
	private java.lang.Integer lastdmrgdays;
	private java.lang.String actfromtime;
	private java.lang.String preclearkey;
	private java.lang.String estfromtime;
	private java.lang.String companykey;
	private java.lang.Integer mandrlinkkey;
	private java.lang.String acttotime;
	private java.lang.String mfnum;
	private java.lang.String esttotime;
	private java.lang.String fromg3key;
	private java.lang.String execstatus;
	private boolean mandrflag;
	private java.lang.String mandrkey;
	private java.lang.Integer mileage;
	private java.util.Date actfromdate;
	private java.lang.String activitykey;
	private java.lang.String invsts;
	private java.lang.String movests;
	private java.lang.String noncnf;
	private java.lang.String orderno;
	private java.util.Date fromdate;
	private java.lang.Long fromtimeinmillis;
	private java.lang.String fromtime;
	private java.util.Date todate;
	private java.lang.Long totimeinmillis;
	private java.lang.String totime;
	private Address vendoraddrkey;
	private Location fromlocationkey;
	private Location tolocationkey;
	private Section sectionkey;
	private Product productkey;



	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="native"
	 *  column="JOBMOV_ID"
	 */
	public java.lang.Integer getJobmovId () {
		return jobmovId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param jobmovId the new ID
	 */
	public void setJobmovId (java.lang.Integer jobmovId) {
		this.jobmovId = jobmovId;
	}




	/**
	 * Return the value associated with the column: mmulink
	 */
	public java.lang.String getMmulink () {
		return mmulink;
	}

	/**
	 * Set the value related to the column: mmulink
	 * @param mmulink the mmulink value
	 */
	public void setMmulink (java.lang.String mmulink) {
		this.mmulink = mmulink;
	}



	/**
	 * Return the value associated with the column: MOVREF
	 */
	public java.lang.String getMovref () {
		return movref;
	}

	/**
	 * Set the value related to the column: MOVREF
	 * @param movref the MOVREF value
	 */
	public void setMovref (java.lang.String movref) {
		this.movref = movref;
	}




	/**
	 * Return the value associated with the column: JOBHDR_ID
	 */
	public java.lang.Integer getJobhdrId () {
		return jobhdrId;
	}

	/**
	 * Set the value related to the column: JOBHDR_ID
	 * @param jobhdrId the JOBHDR_ID value
	 */
	public void setJobhdrId (java.lang.Integer jobhdrId) {
		this.jobhdrId = jobhdrId;
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
	 * Return the value associated with the column: DELETED
	 */
	public boolean isDeleted () {
		return deleted;
	}

	/**
	 * Set the value related to the column: DELETED
	 * @param deleted the DELETED value
	 */
	public void setDeleted (boolean deleted) {
		this.deleted = deleted;
	}



	/**
	 * Return the value associated with the column: LASTDMRGFRDATE
	 */
	public java.util.Date getLastdmrgfrdate () {
		return lastdmrgfrdate;
	}

	/**
	 * Set the value related to the column: LASTDMRGFRDATE
	 * @param lastdmrgfrdate the LASTDMRGFRDATE value
	 */
	public void setLastdmrgfrdate (java.util.Date lastdmrgfrdate) {
		this.lastdmrgfrdate = lastdmrgfrdate;
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
	 * Return the value associated with the column: acttotimeinmillis
	 */
	public java.lang.Long getActtotimeinmillis () {
		return acttotimeinmillis;
	}

	/**
	 * Set the value related to the column: acttotimeinmillis
	 * @param acttotimeinmillis the acttotimeinmillis value
	 */
	public void setActtotimeinmillis (java.lang.Long acttotimeinmillis) {
		this.acttotimeinmillis = acttotimeinmillis;
	}



	/**
	 * Return the value associated with the column: tog3key
	 */
	public java.lang.String getTog3key () {
		return tog3key;
	}

	/**
	 * Set the value related to the column: tog3key
	 * @param tog3key the tog3key value
	 */
	public void setTog3key (java.lang.String tog3key) {
		this.tog3key = tog3key;
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
	 * Return the value associated with the column: tog4key
	 */
	public java.lang.String getTog4key () {
		return tog4key;
	}

	/**
	 * Set the value related to the column: tog4key
	 * @param tog4key the tog4key value
	 */
	public void setTog4key (java.lang.String tog4key) {
		this.tog4key = tog4key;
	}



	/**
	 * Return the value associated with the column: estfromtimeinmillis
	 */
	public java.lang.Long getEstfromtimeinmillis () {
		return estfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: estfromtimeinmillis
	 * @param estfromtimeinmillis the estfromtimeinmillis value
	 */
	public void setEstfromtimeinmillis (java.lang.Long estfromtimeinmillis) {
		this.estfromtimeinmillis = estfromtimeinmillis;
	}



	/**
	 * Return the value associated with the column: tog1key
	 */
	public java.lang.String getTog1key () {
		return tog1key;
	}

	/**
	 * Set the value related to the column: tog1key
	 * @param tog1key the tog1key value
	 */
	public void setTog1key (java.lang.String tog1key) {
		this.tog1key = tog1key;
	}



	/**
	 * Return the value associated with the column: actfromtimeinmillis
	 */
	public java.lang.Long getActfromtimeinmillis () {
		return actfromtimeinmillis;
	}

	/**
	 * Set the value related to the column: actfromtimeinmillis
	 * @param actfromtimeinmillis the actfromtimeinmillis value
	 */
	public void setActfromtimeinmillis (java.lang.Long actfromtimeinmillis) {
		this.actfromtimeinmillis = actfromtimeinmillis;
	}



	/**
	 * Return the value associated with the column: DMRGFINISHFLAG
	 */
	public boolean isDmrgfinishflag () {
		return dmrgfinishflag;
	}

	/**
	 * Set the value related to the column: DMRGFINISHFLAG
	 * @param dmrgfinishflag the DMRGFINISHFLAG value
	 */
	public void setDmrgfinishflag (boolean dmrgfinishflag) {
		this.dmrgfinishflag = dmrgfinishflag;
	}



	/**
	 * Return the value associated with the column: DMRGFREDAYLEFT
	 */
	public boolean isDmrgfredayleft () {
		return dmrgfredayleft;
	}

	/**
	 * Set the value related to the column: DMRGFREDAYLEFT
	 * @param dmrgfredayleft the DMRGFREDAYLEFT value
	 */
	public void setDmrgfredayleft (boolean dmrgfredayleft) {
		this.dmrgfredayleft = dmrgfredayleft;
	}



	/**
	 * Return the value associated with the column: VESSEL
	 */
	public java.lang.String getVessel () {
		return vessel;
	}

	/**
	 * Set the value related to the column: VESSEL
	 * @param vessel the VESSEL value
	 */
	public void setVessel (java.lang.String vessel) {
		this.vessel = vessel;
	}



	/**
	 * Return the value associated with the column: esttotimeinmillis
	 */
	public java.lang.Long getEsttotimeinmillis () {
		return esttotimeinmillis;
	}

	/**
	 * Set the value related to the column: esttotimeinmillis
	 * @param esttotimeinmillis the esttotimeinmillis value
	 */
	public void setEsttotimeinmillis (java.lang.Long esttotimeinmillis) {
		this.esttotimeinmillis = esttotimeinmillis;
	}



	/**
	 * Return the value associated with the column: VSBKCONTACT
	 */
	public java.lang.String getVsbkcontact () {
		return vsbkcontact;
	}

	/**
	 * Set the value related to the column: VSBKCONTACT
	 * @param vsbkcontact the VSBKCONTACT value
	 */
	public void setVsbkcontact (java.lang.String vsbkcontact) {
		this.vsbkcontact = vsbkcontact;
	}



	/**
	 * Return the value associated with the column: BOOKKEY
	 */
	public java.lang.String getBookkey () {
		return bookkey;
	}

	/**
	 * Set the value related to the column: BOOKKEY
	 * @param bookkey the BOOKKEY value
	 */
	public void setBookkey (java.lang.String bookkey) {
		this.bookkey = bookkey;
	}



	/**
	 * Return the value associated with the column: STD_COSTS_GENERATED
	 */
	public boolean isStdCostsGenerated () {
		return stdCostsGenerated;
	}

	/**
	 * Set the value related to the column: STD_COSTS_GENERATED
	 * @param stdCostsGenerated the STD_COSTS_GENERATED value
	 */
	public void setStdCostsGenerated (boolean stdCostsGenerated) {
		this.stdCostsGenerated = stdCostsGenerated;
	}



	/**
	 * Return the value associated with the column: LASTDMRGTODATE
	 */
	public java.util.Date getLastdmrgtodate () {
		return lastdmrgtodate;
	}

	/**
	 * Set the value related to the column: LASTDMRGTODATE
	 * @param lastdmrgtodate the LASTDMRGTODATE value
	 */
	public void setLastdmrgtodate (java.util.Date lastdmrgtodate) {
		this.lastdmrgtodate = lastdmrgtodate;
	}



	/**
	 * Return the value associated with the column: fromg2key
	 */
	public java.lang.String getFromg2key () {
		return fromg2key;
	}

	/**
	 * Set the value related to the column: fromg2key
	 * @param fromg2key the fromg2key value
	 */
	public void setFromg2key (java.lang.String fromg2key) {
		this.fromg2key = fromg2key;
	}



	/**
	 * Return the value associated with the column: VSBKREF
	 */
	public java.lang.String getVsbkref () {
		return vsbkref;
	}

	/**
	 * Set the value related to the column: VSBKREF
	 * @param vsbkref the VSBKREF value
	 */
	public void setVsbkref (java.lang.String vsbkref) {
		this.vsbkref = vsbkref;
	}



	/**
	 * Return the value associated with the column: TXT
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: TXT
	 * @param txt the TXT value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}



	/**
	 * Return the value associated with the column: acttodate
	 */
	public java.util.Date getActtodate () {
		return acttodate;
	}

	/**
	 * Set the value related to the column: acttodate
	 * @param acttodate the acttodate value
	 */
	public void setActtodate (java.util.Date acttodate) {
		this.acttodate = acttodate;
	}



	/**
	 * Return the value associated with the column: fromg1key
	 */
	public java.lang.String getFromg1key () {
		return fromg1key;
	}

	/**
	 * Set the value related to the column: fromg1key
	 * @param fromg1key the fromg1key value
	 */
	public void setFromg1key (java.lang.String fromg1key) {
		this.fromg1key = fromg1key;
	}






	/**
	 * Return the value associated with the column: fromg4key
	 */
	public java.lang.String getFromg4key () {
		return fromg4key;
	}

	/**
	 * Set the value related to the column: fromg4key
	 * @param fromg4key the fromg4key value
	 */
	public void setFromg4key (java.lang.String fromg4key) {
		this.fromg4key = fromg4key;
	}



	/**
	 * Return the value associated with the column: TRTYPE
	 */
	public java.lang.String getTrtype () {
		return trtype;
	}

	/**
	 * Set the value related to the column: TRTYPE
	 * @param trtype the TRTYPE value
	 */
	public void setTrtype (java.lang.String trtype) {
		this.trtype = trtype;
	}






	/**
	 * Return the value associated with the column: VOYAGE
	 */
	public java.lang.String getVoyage () {
		return voyage;
	}

	/**
	 * Set the value related to the column: VOYAGE
	 * @param voyage the VOYAGE value
	 */
	public void setVoyage (java.lang.String voyage) {
		this.voyage = voyage;
	}




	/**
	 * Return the value associated with the column: estfromdate
	 */
	public java.util.Date getEstfromdate () {
		return estfromdate;
	}

	/**
	 * Set the value related to the column: estfromdate
	 * @param estfromdate the estfromdate value
	 */
	public void setEstfromdate (java.util.Date estfromdate) {
		this.estfromdate = estfromdate;
	}



	/**
	 * Return the value associated with the column: AVLSTAT
	 */
	public java.lang.String getAvlstat () {
		return avlstat;
	}

	/**
	 * Set the value related to the column: AVLSTAT
	 * @param avlstat the AVLSTAT value
	 */
	public void setAvlstat (java.lang.String avlstat) {
		this.avlstat = avlstat;
	}



	/**
	 * Return the value associated with the column: esttodate
	 */
	public java.util.Date getEsttodate () {
		return esttodate;
	}

	/**
	 * Set the value related to the column: esttodate
	 * @param esttodate the esttodate value
	 */
	public void setEsttodate (java.util.Date esttodate) {
		this.esttodate = esttodate;
	}



	/**
	 * Return the value associated with the column: tog2key
	 */
	public java.lang.String getTog2key () {
		return tog2key;
	}

	/**
	 * Set the value related to the column: tog2key
	 * @param tog2key the tog2key value
	 */
	public void setTog2key (java.lang.String tog2key) {
		this.tog2key = tog2key;
	}



	/**
	 * Return the value associated with the column: LASTDMRGDAYS
	 */
	public java.lang.Integer getLastdmrgdays () {
		return lastdmrgdays;
	}

	/**
	 * Set the value related to the column: LASTDMRGDAYS
	 * @param lastdmrgdays the LASTDMRGDAYS value
	 */
	public void setLastdmrgdays (java.lang.Integer lastdmrgdays) {
		this.lastdmrgdays = lastdmrgdays;
	}



	/**
	 * Return the value associated with the column: actfromtime
	 */
	public java.lang.String getActfromtime () {
		return actfromtime;
	}

	/**
	 * Set the value related to the column: actfromtime
	 * @param actfromtime the actfromtime value
	 */
	public void setActfromtime (java.lang.String actfromtime) {
		this.actfromtime = actfromtime;
	}






	/**
	 * Return the value associated with the column: PRECLEARKEY
	 */
	public java.lang.String getPreclearkey () {
		return preclearkey;
	}

	/**
	 * Set the value related to the column: PRECLEARKEY
	 * @param preclearkey the PRECLEARKEY value
	 */
	public void setPreclearkey (java.lang.String preclearkey) {
		this.preclearkey = preclearkey;
	}



	/**
	 * Return the value associated with the column: estfromtime
	 */
	public java.lang.String getEstfromtime () {
		return estfromtime;
	}

	/**
	 * Set the value related to the column: estfromtime
	 * @param estfromtime the estfromtime value
	 */
	public void setEstfromtime (java.lang.String estfromtime) {
		this.estfromtime = estfromtime;
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
	 * Return the value associated with the column: MANDRLINKKEY
	 */
	public java.lang.Integer getMandrlinkkey () {
		return mandrlinkkey;
	}

	/**
	 * Set the value related to the column: MANDRLINKKEY
	 * @param mandrlinkkey the MANDRLINKKEY value
	 */
	public void setMandrlinkkey (java.lang.Integer mandrlinkkey) {
		this.mandrlinkkey = mandrlinkkey;
	}



	/**
	 * Return the value associated with the column: acttotime
	 */
	public java.lang.String getActtotime () {
		return acttotime;
	}

	/**
	 * Set the value related to the column: acttotime
	 * @param acttotime the acttotime value
	 */
	public void setActtotime (java.lang.String acttotime) {
		this.acttotime = acttotime;
	}



	/**
	 * Return the value associated with the column: MFNUM
	 */
	public java.lang.String getMfnum () {
		return mfnum;
	}

	/**
	 * Set the value related to the column: MFNUM
	 * @param mfnum the MFNUM value
	 */
	public void setMfnum (java.lang.String mfnum) {
		this.mfnum = mfnum;
	}



	/**
	 * Return the value associated with the column: esttotime
	 */
	public java.lang.String getEsttotime () {
		return esttotime;
	}

	/**
	 * Set the value related to the column: esttotime
	 * @param esttotime the esttotime value
	 */
	public void setEsttotime (java.lang.String esttotime) {
		this.esttotime = esttotime;
	}



	/**
	 * Return the value associated with the column: fromg3key
	 */
	public java.lang.String getFromg3key () {
		return fromg3key;
	}

	/**
	 * Set the value related to the column: fromg3key
	 * @param fromg3key the fromg3key value
	 */
	public void setFromg3key (java.lang.String fromg3key) {
		this.fromg3key = fromg3key;
	}



	/**
	 * Return the value associated with the column: EXECSTATUS
	 */
	public java.lang.String getExecstatus () {
		return execstatus;
	}

	/**
	 * Set the value related to the column: EXECSTATUS
	 * @param execstatus the EXECSTATUS value
	 */
	public void setExecstatus (java.lang.String execstatus) {
		this.execstatus = execstatus;
	}



	/**
	 * Return the value associated with the column: MANDRFLAG
	 */
	public boolean isMandrflag () {
		return mandrflag;
	}

	/**
	 * Set the value related to the column: MANDRFLAG
	 * @param mandrflag the MANDRFLAG value
	 */
	public void setMandrflag (boolean mandrflag) {
		this.mandrflag = mandrflag;
	}



	/**
	 * Return the value associated with the column: MANDRKEY
	 */
	public java.lang.String getMandrkey () {
		return mandrkey;
	}

	/**
	 * Set the value related to the column: MANDRKEY
	 * @param mandrkey the MANDRKEY value
	 */
	public void setMandrkey (java.lang.String mandrkey) {
		this.mandrkey = mandrkey;
	}



	/**
	 * Return the value associated with the column: MILEAGE
	 */
	public java.lang.Integer getMileage () {
		return mileage;
	}

	/**
	 * Set the value related to the column: MILEAGE
	 * @param mileage the MILEAGE value
	 */
	public void setMileage (java.lang.Integer mileage) {
		this.mileage = mileage;
	}





	/**
	 * Return the value associated with the column: actfromdate
	 */
	public java.util.Date getActfromdate () {
		return actfromdate;
	}

	/**
	 * Set the value related to the column: actfromdate
	 * @param actfromdate the actfromdate value
	 */
	public void setActfromdate (java.util.Date actfromdate) {
		this.actfromdate = actfromdate;
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
	 * Return the value associated with the column: INVSTS
	 */
	public java.lang.String getInvsts () {
		return invsts;
	}

	/**
	 * Set the value related to the column: INVSTS
	 * @param invsts the INVSTS value
	 */
	public void setInvsts (java.lang.String invsts) {
		this.invsts = invsts;
	}



	/**
	 * Return the value associated with the column: movests
	 */
	public java.lang.String getMovests () {
		return movests;
	}

	/**
	 * Set the value related to the column: movests
	 * @param movests the movests value
	 */
	public void setMovests (java.lang.String movests) {
		this.movests = movests;
	}



	/**
	 * Return the value associated with the column: NONCNF
	 */
	public java.lang.String getNoncnf () {
		return noncnf;
	}

	/**
	 * Set the value related to the column: NONCNF
	 * @param noncnf the NONCNF value
	 */
	public void setNoncnf (java.lang.String noncnf) {
		this.noncnf = noncnf;
	}



	/**
	 * Return the value associated with the column: ORDERNO
	 */
	public java.lang.String getOrderno () {
		return orderno;
	}

	/**
	 * Set the value related to the column: ORDERNO
	 * @param orderno the ORDERNO value
	 */
	public void setOrderno (java.lang.String orderno) {
		this.orderno = orderno;
	}



	/**
	 * Return the value associated with the column: fromdate
	 */
	public java.util.Date getFromdate () {
		return fromdate;
	}

	/**
	 * Set the value related to the column: fromdate
	 * @param fromdate the fromdate value
	 */
	public void setFromdate (java.util.Date fromdate) {
		this.fromdate = fromdate;
	}



	/**
	 * Return the value associated with the column: fromtimeinmillis
	 */
	public java.lang.Long getFromtimeinmillis () {
		return fromtimeinmillis;
	}

	/**
	 * Set the value related to the column: fromtimeinmillis
	 * @param fromtimeinmillis the fromtimeinmillis value
	 */
	public void setFromtimeinmillis (java.lang.Long fromtimeinmillis) {
		this.fromtimeinmillis = fromtimeinmillis;
	}



	/**
	 * Return the value associated with the column: fromtime
	 */
	public java.lang.String getFromtime () {
		return fromtime;
	}

	/**
	 * Set the value related to the column: fromtime
	 * @param fromtime the fromtime value
	 */
	public void setFromtime (java.lang.String fromtime) {
		this.fromtime = fromtime;
	}



	/**
	 * Return the value associated with the column: todate
	 */
	public java.util.Date getTodate () {
		return todate;
	}

	/**
	 * Set the value related to the column: todate
	 * @param todate the todate value
	 */
	public void setTodate (java.util.Date todate) {
		this.todate = todate;
	}



	/**
	 * Return the value associated with the column: totimeinmillis
	 */
	public java.lang.Long getTotimeinmillis () {
		return totimeinmillis;
	}

	/**
	 * Set the value related to the column: totimeinmillis
	 * @param totimeinmillis the totimeinmillis value
	 */
	public void setTotimeinmillis (java.lang.Long totimeinmillis) {
		this.totimeinmillis = totimeinmillis;
	}



	/**
	 * Return the value associated with the column: totime
	 */
	public java.lang.String getTotime () {
		return totime;
	}

	/**
	 * Set the value related to the column: totime
	 * @param totime the totime value
	 */
	public void setTotime (java.lang.String totime) {
		this.totime = totime;
	}



	/**
	 * Return the value associated with the column: vendoraddrkey
	 */
	public Address getVendoraddrkey () {
		return vendoraddrkey;
	}

	/**
	 * Set the value related to the column: vendoraddrkey
	 * @param vendoraddrkey the vendoraddrkey value
	 */
	public void setVendoraddrkey (Address vendoraddrkey) {
		this.vendoraddrkey = vendoraddrkey;
	}



	/**
	 * Return the value associated with the column: fromlocationkey
	 */
	public Location getFromlocationkey () {
		return fromlocationkey;
	}

	/**
	 * Set the value related to the column: fromlocationkey
	 * @param fromlocationkey the fromlocationkey value
	 */
	public void setFromlocationkey (Location fromlocationkey) {
		this.fromlocationkey = fromlocationkey;
	}



	/**
	 * Return the value associated with the column: tolocationkey
	 */
	public Location getTolocationkey () {
		return tolocationkey;
	}

	/**
	 * Set the value related to the column: tolocationkey
	 * @param tolocationkey the tolocationkey value
	 */
	public void setTolocationkey (Location tolocationkey) {
		this.tolocationkey = tolocationkey;
	}



	/**
	 * Return the value associated with the column: sectionkey
	 */
	public Section getSectionkey () {
		return sectionkey;
	}

	/**
	 * Set the value related to the column: sectionkey
	 * @param sectionkey the sectionkey value
	 */
	public void setSectionkey (Section sectionkey) {
		this.sectionkey = sectionkey;
	}





	/**
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}
	/**
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}


	/**
	 * 
	 */
	public Product getProductkey () {return productkey;}
	/**
	 */
	public void setProductkey (Product productkey) {this.productkey = productkey;}




	private String row;

	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}	


	private String errorflag;

	public String getErrorflag() {
		return errorflag;
	}
	public void setErrorflag(String errorflag) {
		this.errorflag = errorflag;
	}

	/**
	 */
	public java.lang.String getUnitkey () {return unitkey;}
	/**
	 */
	public void setUnitkey (java.lang.String unitkey) {this.unitkey = unitkey;}	



}

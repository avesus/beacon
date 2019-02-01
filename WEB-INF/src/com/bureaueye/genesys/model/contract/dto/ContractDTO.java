package com.bureaueye.genesys.model.contract.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.genesys.model.contract.Contract;
import com.bureaueye.genesys.model.contract.bd.ContracteqpBD;
import com.bureaueye.genesys.model.onhire.bd.OnhireBD;








public final class ContractDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public ContractDTO(Contract dao) throws ApplicationException {
		initialize(dao);		
	}
	public ContractDTO(Contract dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	protected void initialize (Contract dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setLesseeaddrkey(new AddressBD(this.getSessionFactoryClusterMap()).read(dao.getLesseeaddrkey()));

		this.setContractId(dao.getContractId());
		this.setContractno(dao.getContractno());
		
		this.billccykey= dao.getBillccykey();	
		
		this.companykey = dao.getCompanykey();
		this.departmentkey = dao.getDepartmentkey();	
		this.activitykey = dao.getActivitykey();

		this.leasetypekey = dao.getLeasetypekey();
		
		this.createdate = 	dao.getCreatedate();	
		this.contractdate = 	dao.getContractdate();	
		
		this.setContracteqpsfound("false");
		try {
			if (
				new ContracteqpBD(this.getSessionFactoryClusterMap())
					.findContracteqpsTotalResults(dao.getContractId().toString()) > 0
			) this.setContracteqpsfound("true");
		} catch (ApplicationException ae) {}	
		
		this.setReadonly("false");
		
		this.setContracteqpssize(0);
		
		this.setOnhiressize(0);
		try {
			ListForm listForm = new ListForm();
			listForm.setSearchString2(dao.getContractno());
			this.setOnhiressize(
					new OnhireBD(this.getSessionFactoryClusterMap())
						.findOnhiresTotalResultsByContractno(listForm)
					);
		} catch (Exception e) {}
		
		this.setChecked(false);	
	}
	
	
	
	// extra
	private int contracteqpssize;
	private int onhiressize;	
    private boolean checked;	
	private String readonly = "false";
    private String contracteqpsfound = "false";
	
	
	// primary key
	private java.lang.Integer contractId;

	// fields
	private Address lesseeaddrkey;
	private String contractno;

	// fields
	private java.lang.String comments;
	private java.lang.String billfreqtype;
	private java.lang.String billtype;
	private java.lang.String departmentkey;
	private java.util.Date periodenddate;
	private java.lang.String billccykey;
	private java.util.Date contractdate;
	private java.lang.String companykey;
	private java.lang.String notes;
	private java.lang.String submittedby;
	private java.util.Date submitteddate;
	private java.util.Date signeddate;
	private java.util.Date periodstartdate;
	private java.lang.String leasetypekey;
	private java.lang.String createuserid;
	private java.util.Date versiondate;
	private boolean billamend;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String activitykey;
	private java.lang.Integer versionno;
	private java.lang.Integer noticedays;
	private java.lang.Integer billfreqnum;
	private java.lang.String xlock;

	
	

    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}

	public int getOnhiressize() {return onhiressize;}
	public void setOnhiressize(int onhiressize) {this.onhiressize = onhiressize;}

	public int getContracteqpssize() {return contracteqpssize;}
	public void setContracteqpssize(int contracteqpssize) {this.contracteqpssize = contracteqpssize;}

	public String getContracteqpsfound() {return contracteqpsfound;}
	public void setContracteqpsfound(String contracteqpsfound) {this.contracteqpsfound = contracteqpsfound;}
	

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="CONTRACT_ID"
     */
	public java.lang.Integer getContractId () {
		return contractId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param contractId the new ID
	 */
	public void setContractId (java.lang.Integer contractId) {
		this.contractId = contractId;
	}
	
	/**
	 * Return the value associated with the column: comments
	 */
	public java.lang.String getComments () {
		return comments;
	}

	/**
	 * Set the value related to the column: comments
	 * @param comments the comments value
	 */
	public void setComments (java.lang.String comments) {
		this.comments = comments;
	}



	/**
	 * Return the value associated with the column: billfreqtype
	 */
	public java.lang.String getBillfreqtype () {
		return billfreqtype;
	}

	/**
	 * Set the value related to the column: billfreqtype
	 * @param billfreqtype the billfreqtype value
	 */
	public void setBillfreqtype (java.lang.String billfreqtype) {
		this.billfreqtype = billfreqtype;
	}








	/**
	 * Return the value associated with the column: billtype
	 */
	public java.lang.String getBilltype () {
		return billtype;
	}

	/**
	 * Set the value related to the column: billtype
	 * @param billtype the billtype value
	 */
	public void setBilltype (java.lang.String billtype) {
		this.billtype = billtype;
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
	 * Return the value associated with the column: periodenddate
	 */
	public java.util.Date getPeriodenddate () {
		return periodenddate;
	}

	/**
	 * Set the value related to the column: periodenddate
	 * @param periodenddate the periodenddate value
	 */
	public void setPeriodenddate (java.util.Date periodenddate) {
		this.periodenddate = periodenddate;
	}



	/**
	 * Return the value associated with the column: billccykey
	 */
	public java.lang.String getBillccykey () {
		return billccykey;
	}

	/**
	 * Set the value related to the column: billccykey
	 * @param billccykey the billccykey value
	 */
	public void setBillccykey (java.lang.String billccykey) {
		this.billccykey = billccykey;
	}







	/**
	 * Return the value associated with the column: contractdate
	 */
	public java.util.Date getContractdate () {
		return contractdate;
	}

	/**
	 * Set the value related to the column: contractdate
	 * @param contractdate the contractdate value
	 */
	public void setContractdate (java.util.Date contractdate) {
		this.contractdate = contractdate;
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
	 * Return the value associated with the column: notes
	 */
	public java.lang.String getNotes () {
		return notes;
	}

	/**
	 * Set the value related to the column: notes
	 * @param notes the notes value
	 */
	public void setNotes (java.lang.String notes) {
		this.notes = notes;
	}



	/**
	 * Return the value associated with the column: submittedby
	 */
	public java.lang.String getSubmittedby () {
		return submittedby;
	}

	/**
	 * Set the value related to the column: submittedby
	 * @param submittedby the submittedby value
	 */
	public void setSubmittedby (java.lang.String submittedby) {
		this.submittedby = submittedby;
	}



	/**
	 * Return the value associated with the column: submitteddate
	 */
	public java.util.Date getSubmitteddate () {
		return submitteddate;
	}

	/**
	 * Set the value related to the column: submitteddate
	 * @param submitteddate the submitteddate value
	 */
	public void setSubmitteddate (java.util.Date submitteddate) {
		this.submitteddate = submitteddate;
	}



	/**
	 * Return the value associated with the column: signeddate
	 */
	public java.util.Date getSigneddate () {
		return signeddate;
	}

	/**
	 * Set the value related to the column: signeddate
	 * @param signeddate the signeddate value
	 */
	public void setSigneddate (java.util.Date signeddate) {
		this.signeddate = signeddate;
	}



	/**
	 * Return the value associated with the column: periodstartdate
	 */
	public java.util.Date getPeriodstartdate () {
		return periodstartdate;
	}

	/**
	 * Set the value related to the column: periodstartdate
	 * @param periodstartdate the periodstartdate value
	 */
	public void setPeriodstartdate (java.util.Date periodstartdate) {
		this.periodstartdate = periodstartdate;
	}



	/**
	 * Return the value associated with the column: leasetypekey
	 */
	public java.lang.String getLeasetypekey () {
		return leasetypekey;
	}

	/**
	 * Set the value related to the column: leasetypekey
	 * @param leasetypekey the leasetypekey value
	 */
	public void setLeasetypekey (java.lang.String leasetypekey) {
		this.leasetypekey = leasetypekey;
	}



	/**
	 * Return the value associated with the column: CREATEUSERID
	 */
	public java.lang.String getCreateuserid () {
		return createuserid;
	}

	/**
	 * Set the value related to the column: CREATEUSERID
	 * @param createuserid the CREATEUSERID value
	 */
	public void setCreateuserid (java.lang.String createuserid) {
		this.createuserid = createuserid;
	}



	/**
	 * Return the value associated with the column: versiondate
	 */
	public java.util.Date getVersiondate () {
		return versiondate;
	}

	/**
	 * Set the value related to the column: versiondate
	 * @param versiondate the versiondate value
	 */
	public void setVersiondate (java.util.Date versiondate) {
		this.versiondate = versiondate;
	}



	/**
	 * Return the value associated with the column: billamend
	 */
	public boolean isBillamend () {
		return billamend;
	}

	/**
	 * Set the value related to the column: billamend
	 * @param billamend the billamend value
	 */
	public void setBillamend (boolean billamend) {
		this.billamend = billamend;
	}



	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: CREATETIME
	 */
	public java.lang.String getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: CREATETIME
	 * @param createtime the CREATETIME value
	 */
	public void setCreatetime (java.lang.String createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: contractno
	 */
	public java.lang.String getContractno () {
		return contractno;
	}

	/**
	 * Set the value related to the column: contractno
	 * @param contractno the contractno value
	 */
	public void setContractno (java.lang.String contractno) {
		this.contractno = contractno;
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
	 * Return the value associated with the column: versionno
	 */
	public java.lang.Integer getVersionno () {
		return versionno;
	}

	/**
	 * Set the value related to the column: versionno
	 * @param versionno the versionno value
	 */
	public void setVersionno (java.lang.Integer versionno) {
		this.versionno = versionno;
	}



	/**
	 * Return the value associated with the column: noticedays
	 */
	public java.lang.Integer getNoticedays () {
		return noticedays;
	}

	/**
	 * Set the value related to the column: noticedays
	 * @param noticedays the noticedays value
	 */
	public void setNoticedays (java.lang.Integer noticedays) {
		this.noticedays = noticedays;
	}



	/**
	 * Return the value associated with the column: billfreqnum
	 */
	public java.lang.Integer getBillfreqnum () {
		return billfreqnum;
	}

	/**
	 * Set the value related to the column: billfreqnum
	 * @param billfreqnum the billfreqnum value
	 */
	public void setBillfreqnum (java.lang.Integer billfreqnum) {
		this.billfreqnum = billfreqnum;
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
	 * Return the value associated with the column: lesseeaddrkey
	 */
	public Address getLesseeaddrkey () {
		return lesseeaddrkey;
	}

	/**
	 * Set the value related to the column: lesseeaddrkey
	 * @param lesseeaddrkey the lesseeaddrkey value
	 */
	public void setLesseeaddrkey (Address lesseeaddrkey) {
		this.lesseeaddrkey = lesseeaddrkey;
	}


}
package com.bureaueye.beacon.model.purchaseorder.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.purchaseorder.Podtlrcvd;






public final class PodtlrcvdDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	// constructors
	public PodtlrcvdDTO(Podtlrcvd dao) throws ApplicationException {
		initialize(dao);		
	}
	public PodtlrcvdDTO(Podtlrcvd dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	
	protected void initialize (Podtlrcvd dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object		
		this.shipmentno= dao.getShipmentno();
		this.rcvddate= dao.getRcvddate();
		this.qtyrcvd= dao.getQtyrcvd();
		this.txt1= dao.getTxt1();		
		
		this.qtygenerated = 0;

		this.setPodtlrcvdId(dao.getPodtlrcvdId());
		this.setPodtlId(dao.getPodtlId());
	}
	


	// primary key
	private java.lang.Integer podtlId;
    private java.lang.Integer podtlrcvdId;
    
    
	private String readonly = "false";


	// fields
	private java.lang.String shipmentno;
	private java.lang.String txt1;
	private Integer qtyrcvd;	
	private Date rcvddate;


	
	// extra
	private int qtygenerated;
    private boolean checked;



    public boolean isChecked() { return (this.checked); }
    public void setChecked(boolean b) {
        this.checked = b;
    }
    
    
    
	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}
	
	public int getQtygenerated() {return qtygenerated;}
	public void setQtygenerated(int qtygenerated) {this.qtygenerated = qtygenerated;}
	

	/**
     */
	public java.lang.Integer getPodtlrcvdId () {
		return (this.podtlrcvdId);
	}

	/**
	 */
	public void setPodtlrcvdId (java.lang.Integer podtlrcvdId) {
		this.podtlrcvdId = podtlrcvdId;
	}


    /**
     */
    public java.lang.Integer getPodtlId() {
    	return (this.podtlId);
    }
    
    /**
     */
    public void setPodtlId(java.lang.Integer podtlId) {this.podtlId = podtlId;}
    
    

    /**
     */
    public String getTxt1() {
    	return (this.txt1);
    }
    /**
     */
    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }
    
    
	/**
	 * Return the value associated with the column: qtyrcvd
	 */
	public Integer getQtyrcvd () {
		return qtyrcvd;
	}

	/**
	 * Set the value related to the column: qtyrcvd
	 * @param _qtyrcvd the qtyrcvd value
	 */
	public void setQtyrcvd (Integer qtyrcvd) {
		this.qtyrcvd = qtyrcvd;
	}



	/**
	 * Return the value associated with the column: _shipmentno
	 */
	public java.lang.String getShipmentno () {
		return shipmentno;
	}

	/**
	 * Set the value related to the column: __shipmentno
	 * @param ___shipmentno the _shipmentno value
	 */
	public void setShipmentno (java.lang.String shipmentno) {
		this.shipmentno = shipmentno;
	}











	/**
	 * Return the value associated with the column: rcvddate
	 */
	public java.util.Date getRcvddate () {
		return rcvddate;
	}

	/**
	 * Set the value related to the column: _rcvddate
	 * @param __rcvddate the _rcvddate value
	 */
	public void setRcvddate (java.util.Date rcvddate) {
		this.rcvddate = rcvddate;
	}






	
	
}

package com.bureaueye.beacon.form.dsactivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.form.BaseForm;
import com.bureaueye.beacon.formatter.DateFormatter;
import com.bureaueye.beacon.util.Util;



public final class DsingateForm extends BaseForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String _action;
	private String _readonly = "false";
    private String _copyId = "";
    
    
	// fields	
	private java.lang.String dsingateId;
	

	// fields	
	private java.lang.String createuserid;
	private java.util.Date createdate;	
	

	
	// fields
	private java.lang.String eirin;
	private java.lang.String eirinver = "0";
	
	private java.lang.String depotlocationkey;
	private java.lang.String customeraddrkey;
	
	private java.lang.String indatedd;
	private java.lang.String indatemm;
	private java.lang.String indateyyyy;	
	private java.lang.String intimehh;
	private java.lang.String intimemm;
	private java.lang.String intimeinmillis;
	
	
	private java.lang.String inspector;
	private java.lang.String con1;
	private java.lang.String cha1;
	
	private java.lang.String turnenddatedd;
	private java.lang.String turnenddatemm;
	private java.lang.String turnenddateyyyy;	
	private java.lang.String turnendtimehh;
	private java.lang.String turnendtimemm;
	private java.lang.String turnendtimeinmillis;
	
	
	private java.lang.String loadempty;
	private java.lang.String ixd;
	private java.lang.String mu;
	private java.lang.String consize;
	private java.lang.String contype;
	private java.lang.String conmatl;
	private java.lang.String concueir;
	private java.lang.String chasize;
	private java.lang.String chatype;
	private java.lang.String chacueir;
	
	private boolean chastack;
	
	private java.lang.String chaplate;
	
	private java.lang.String chaexpdtdd;
	private java.lang.String chaexpdtmm;
	private java.lang.String chaexpdtyyyy;		
	
	private java.lang.String chafhdtedd;
	private java.lang.String chafhdtemm;
	private java.lang.String chafhdteyyyy;		
	
	private java.lang.String chafhext;
	private java.lang.String chanewst;
	private java.lang.String chanewpt;
	private java.lang.String scac;
	private java.lang.String tractor;
	private java.lang.String shipseal;
	private java.lang.String custrem;
	private java.lang.String intrem;
	private java.lang.String cdxref;
	private java.lang.String cdxredel;
	private java.lang.String grade;
	private java.lang.String concond;
	private java.lang.String chacond;
	private java.lang.String gridloc;
	
	private boolean waiveinspfee;
	private boolean waiveliftfee;
	
	private java.util.Date updtdate;
	private java.lang.String updttime;
	
	private boolean shuttlemove;
	private java.lang.String shuttlfee = "0.0";	
	private java.lang.String shuttlecustomeraddrkey;
	
	private boolean droplot;
	private java.lang.String dropcustomeraddrkey;
	
	private boolean foreigntarget;
	
	private java.lang.String cha2;
	private java.lang.String chaeir2;
	private java.lang.String cha3;
	private java.lang.String chaeir3;
	private java.lang.String cha4;
	private java.lang.String chaeir4;
	private java.lang.String cha5;
	private java.lang.String chaeir5;
	private java.lang.String targeteq;
	private java.lang.String conmfg;
	
	private java.lang.String conmfgdtdd;
	private java.lang.String conmfgdtmm;
	private java.lang.String conmfgdtyyyy;	
	
	private java.lang.String chamfg;



	
	
	
	// collections
	

	
    /**
     */
    public String getCopyId() {return (this._copyId);}
    public void setCopyId(String _copyId) {this._copyId = _copyId;}
    
	
	public String getAction() {return _action;}

	public void setAction(String _action) {this._action = _action;}	

	public String getReadonly() {return _readonly;}
	public void setReadonly(String _readonly) {this._readonly = _readonly;}
	

	
	/**
     */
	public java.lang.String getDsingateId () {
		return dsingateId;
	}
	/**
	 */
	public void setDsingateId (java.lang.String dsingateId) {
		this.dsingateId = dsingateId;
	}




	/**
	 * Return the value associated with the column: EIRIN
	 */
	public java.lang.String getEirin () {
		return eirin;
	}

	/**
	 * Set the value related to the column: EIRIN
	 * @param eirin the EIRIN value
	 */
	public void setEirin (java.lang.String eirin) {
		this.eirin = eirin;
	}



	public java.lang.String getEirinver () {
		return eirinver;
	}
	public void setEirinver (java.lang.String eirinver) {
		this.eirinver = eirinver;
	}



	/**
	 * Return the value associated with the column: depotlocationkey
	 */
	public java.lang.String getDepotlocationkey () {
		return depotlocationkey;
	}

	/**
	 * Set the value related to the column: depotlocationkey
	 * @param depotlocationkey the depotlocationkey value
	 */
	public void setDepotlocationkey (java.lang.String depotlocationkey) {
		this.depotlocationkey = depotlocationkey;
	}





	/**
	 * Return the value associated with the column: customeraddrkey
	 */
	public java.lang.String getCustomeraddrkey () {
		return customeraddrkey;
	}

	/**
	 * Set the value related to the column: customeraddrkey
	 * @param customeraddrkey the customeraddrkey value
	 */
	public void setCustomeraddrkey (java.lang.String customeraddrkey) {
		this.customeraddrkey = customeraddrkey;
	}






	public String getIntime() {
		try {
		String time = getIntimehh()+":"+getIntimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setIntime(String intime) {
		try {
		String hh = "00";
		try{hh = intime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = intime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setIntimehh(hh);
		setIntimemm(mm);
		} catch (Exception e) {
			setIntimehh("00");
			setIntimemm("00");			
		}
	}
	public String getIntimehh () {return intimehh;}
	public void setIntimehh (String intimehh) {this.intimehh = intimehh;}
	public String getIntimemm () {return intimemm;}
	public void setIntimemm (String intimemm) {this.intimemm = intimemm;}
	
	public long getIntimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getIndateyyyy()), 
					Integer.parseInt(getIndatemm()) - 1, 
					Integer.parseInt(getIndatedd()),
					Integer.parseInt(getIntimehh()),
					Integer.parseInt(getIntimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setIntimeinmillis(String intimeinmillis)	{
		this.intimeinmillis = intimeinmillis;	
	}
	
	



	/**
	 * Return the value associated with the column: INSPECTOR
	 */
	public java.lang.String getInspector () {
		return inspector;
	}

	/**
	 * Set the value related to the column: INSPECTOR
	 * @param inspector the INSPECTOR value
	 */
	public void setInspector (java.lang.String inspector) {
		this.inspector = inspector;
	}



	/**
	 * Return the value associated with the column: con1
	 */
	public java.lang.String getCon1 () {
		return con1;
	}

	/**
	 * Set the value related to the column: con1
	 * @param con1 the con1 value
	 */
	public void setCon1 (java.lang.String con1) {
		this.con1 = con1;
	}



	/**
	 * Return the value associated with the column: cha1
	 */
	public java.lang.String getCha1 () {
		return cha1;
	}

	/**
	 * Set the value related to the column: cha1
	 * @param cha1 the cha1 value
	 */
	public void setCha1 (java.lang.String cha1) {
		this.cha1 = cha1;
	}






	public String getTurnendtime() {
		try {
		String time = getTurnendtimehh()+":"+getTurnendtimemm();
		return time;
		} catch(Exception e) { return "00:00"; }
	}
	public void setTurnendtime(String turnendtime) {
		try {
		String hh = "00";
		try{hh = turnendtime.substring(0,2);}catch(IndexOutOfBoundsException ioobe){}
		String mm = "00";
		try{mm = turnendtime.substring(3,5);}catch(IndexOutOfBoundsException ioobe){}
		setTurnendtimehh(hh);
		setTurnendtimemm(mm);
		} catch (Exception e) {
			setTurnendtimehh("00");
			setTurnendtimemm("00");			
		}
	}
	public String getTurnendtimehh () {return turnendtimehh;}
	public void setTurnendtimehh (String turnendtimehh) {this.turnendtimehh = turnendtimehh;}
	public String getTurnendtimemm () {return turnendtimemm;}
	public void setTurnendtimemm (String turnendtimemm) {this.turnendtimemm = turnendtimemm;}
	
	public long getTurnendtimeinmillis() {
		try {
			Calendar c = Calendar.getInstance();
			c.set(
					Integer.parseInt(getIndateyyyy()), 
					Integer.parseInt(getIndatemm()) - 1, 
					Integer.parseInt(getIndatedd()),
					Integer.parseInt(getTurnendtimehh()),
					Integer.parseInt(getTurnendtimemm())
					);
			return c.getTimeInMillis();
		} catch(Exception e) { return 0; }
	}
	public void setTurnendtimeinmillis(String turnendtimeinmillis)	{
		this.turnendtimeinmillis = turnendtimeinmillis;	
	}
	
	



	/**
	 * Return the value associated with the column: LOADEMPTY
	 */
	public java.lang.String getLoadempty () {
		return loadempty;
	}

	/**
	 * Set the value related to the column: LOADEMPTY
	 * @param loadempty the LOADEMPTY value
	 */
	public void setLoadempty (java.lang.String loadempty) {
		this.loadempty = loadempty;
	}



	/**
	 * Return the value associated with the column: IXD
	 */
	public java.lang.String getIxd () {
		return ixd;
	}

	/**
	 * Set the value related to the column: IXD
	 * @param ixd the IXD value
	 */
	public void setIxd (java.lang.String ixd) {
		this.ixd = ixd;
	}



	/**
	 * Return the value associated with the column: MU
	 */
	public java.lang.String getMu () {
		return mu;
	}

	/**
	 * Set the value related to the column: MU
	 * @param mu the MU value
	 */
	public void setMu (java.lang.String mu) {
		this.mu = mu;
	}



	/**
	 * Return the value associated with the column: CONSIZE
	 */
	public java.lang.String getConsize () {
		return consize;
	}

	/**
	 * Set the value related to the column: CONSIZE
	 * @param consize the CONSIZE value
	 */
	public void setConsize (java.lang.String consize) {
		this.consize = consize;
	}



	/**
	 * Return the value associated with the column: CONTYPE
	 */
	public java.lang.String getContype () {
		return contype;
	}

	/**
	 * Set the value related to the column: CONTYPE
	 * @param contype the CONTYPE value
	 */
	public void setContype (java.lang.String contype) {
		this.contype = contype;
	}



	/**
	 * Return the value associated with the column: CONMATL
	 */
	public java.lang.String getConmatl () {
		return conmatl;
	}

	/**
	 * Set the value related to the column: CONMATL
	 * @param conmatl the CONMATL value
	 */
	public void setConmatl (java.lang.String conmatl) {
		this.conmatl = conmatl;
	}



	/**
	 * Return the value associated with the column: CONCUEIR
	 */
	public java.lang.String getConcueir () {
		return concueir;
	}

	/**
	 * Set the value related to the column: CONCUEIR
	 * @param concueir the CONCUEIR value
	 */
	public void setConcueir (java.lang.String concueir) {
		this.concueir = concueir;
	}



	/**
	 * Return the value associated with the column: CHASIZE
	 */
	public java.lang.String getChasize () {
		return chasize;
	}

	/**
	 * Set the value related to the column: CHASIZE
	 * @param chasize the CHASIZE value
	 */
	public void setChasize (java.lang.String chasize) {
		this.chasize = chasize;
	}



	/**
	 * Return the value associated with the column: CHATYPE
	 */
	public java.lang.String getChatype () {
		return chatype;
	}

	/**
	 * Set the value related to the column: CHATYPE
	 * @param chatype the CHATYPE value
	 */
	public void setChatype (java.lang.String chatype) {
		this.chatype = chatype;
	}



	/**
	 * Return the value associated with the column: CHACUEIR
	 */
	public java.lang.String getChacueir () {
		return chacueir;
	}

	/**
	 * Set the value related to the column: CHACUEIR
	 * @param chacueir the CHACUEIR value
	 */
	public void setChacueir (java.lang.String chacueir) {
		this.chacueir = chacueir;
	}



	/**
	 * Return the value associated with the column: CHASTACK
	 */
	public boolean isChastack () {
		return chastack;
	}

	/**
	 * Set the value related to the column: CHASTACK
	 * @param chastack the CHASTACK value
	 */
	public void setChastack (boolean chastack) {
		this.chastack = chastack;
	}



	/**
	 * Return the value associated with the column: CHAPLATE
	 */
	public java.lang.String getChaplate () {
		return chaplate;
	}

	/**
	 * Set the value related to the column: CHAPLATE
	 * @param chaplate the CHAPLATE value
	 */
	public void setChaplate (java.lang.String chaplate) {
		this.chaplate = chaplate;
	}




	public Date getChaexpdt() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getChaexpdtyyyy()), Integer
						.parseInt(getChaexpdtmm()) - 1, Integer
						.parseInt(getChaexpdtdd()));
		return c.getTime();
	}
	public void setChaexpdt(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setChaexpdtyyyy(c.get(Calendar.YEAR) + "");
		setChaexpdtmm((month < 10 ? "0" : "") + month);
		setChaexpdtdd((day < 10 ? "0" : "") + day);
	}
	public String getChaexpdtdd () {return chaexpdtdd;}
	public void setChaexpdtdd (String chaexpdtdd) {this.chaexpdtdd = chaexpdtdd;}
	public String getChaexpdtmm () {return chaexpdtmm;}
	public void setChaexpdtmm (String chaexpdtmm) {this.chaexpdtmm = chaexpdtmm;}
	public String getChaexpdtyyyy () {return chaexpdtyyyy;}
	public void setChaexpdtyyyy (String chaexpdtyyyy) {this.chaexpdtyyyy = chaexpdtyyyy;}
	
	



	public Date getChafhdte() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getChafhdteyyyy()), Integer
						.parseInt(getChafhdtemm()) - 1, Integer
						.parseInt(getChafhdtedd()));
		return c.getTime();
	}
	public void setChafhdte(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setChafhdteyyyy(c.get(Calendar.YEAR) + "");
		setChafhdtemm((month < 10 ? "0" : "") + month);
		setChafhdtedd((day < 10 ? "0" : "") + day);
	}
	public String getChafhdtedd () {return chafhdtedd;}
	public void setChafhdtedd (String chafhdtedd) {this.chafhdtedd = chafhdtedd;}
	public String getChafhdtemm () {return chafhdtemm;}
	public void setChafhdtemm (String chafhdtemm) {this.chafhdtemm = chafhdtemm;}
	public String getChafhdteyyyy () {return chafhdteyyyy;}
	public void setChafhdteyyyy (String chafhdteyyyy) {this.chafhdteyyyy = chafhdteyyyy;}
	

	
	


	/**
	 * Return the value associated with the column: CHAFHEXT
	 */
	public java.lang.String getChafhext () {
		return chafhext;
	}

	/**
	 * Set the value related to the column: CHAFHEXT
	 * @param chafhext the CHAFHEXT value
	 */
	public void setChafhext (java.lang.String chafhext) {
		this.chafhext = chafhext;
	}



	/**
	 * Return the value associated with the column: CHANEWST
	 */
	public java.lang.String getChanewst () {
		return chanewst;
	}

	/**
	 * Set the value related to the column: CHANEWST
	 * @param chanewst the CHANEWST value
	 */
	public void setChanewst (java.lang.String chanewst) {
		this.chanewst = chanewst;
	}



	/**
	 * Return the value associated with the column: CHANEWPT
	 */
	public java.lang.String getChanewpt () {
		return chanewpt;
	}

	/**
	 * Set the value related to the column: CHANEWPT
	 * @param chanewpt the CHANEWPT value
	 */
	public void setChanewpt (java.lang.String chanewpt) {
		this.chanewpt = chanewpt;
	}



	/**
	 * Return the value associated with the column: scac
	 */
	public java.lang.String getScac () {
		return scac;
	}

	/**
	 * Set the value related to the column: scac
	 * @param scac the scac value
	 */
	public void setScac (java.lang.String scac) {
		this.scac = scac;
	}



	/**
	 * Return the value associated with the column: TRACTOR
	 */
	public java.lang.String getTractor () {
		return tractor;
	}

	/**
	 * Set the value related to the column: TRACTOR
	 * @param tractor the TRACTOR value
	 */
	public void setTractor (java.lang.String tractor) {
		this.tractor = tractor;
	}



	/**
	 * Return the value associated with the column: SHIPSEAL
	 */
	public java.lang.String getShipseal () {
		return shipseal;
	}

	/**
	 * Set the value related to the column: SHIPSEAL
	 * @param shipseal the SHIPSEAL value
	 */
	public void setShipseal (java.lang.String shipseal) {
		this.shipseal = shipseal;
	}



	/**
	 * Return the value associated with the column: CUSTREM
	 */
	public java.lang.String getCustrem () {
		return custrem;
	}

	/**
	 * Set the value related to the column: CUSTREM
	 * @param custrem the CUSTREM value
	 */
	public void setCustrem (java.lang.String custrem) {
		this.custrem = custrem;
	}



	/**
	 * Return the value associated with the column: INTREM
	 */
	public java.lang.String getIntrem () {
		return intrem;
	}

	/**
	 * Set the value related to the column: INTREM
	 * @param intrem the INTREM value
	 */
	public void setIntrem (java.lang.String intrem) {
		this.intrem = intrem;
	}



	/**
	 * Return the value associated with the column: CDXREF
	 */
	public java.lang.String getCdxref () {
		return cdxref;
	}

	/**
	 * Set the value related to the column: CDXREF
	 * @param cdxref the CDXREF value
	 */
	public void setCdxref (java.lang.String cdxref) {
		this.cdxref = cdxref;
	}



	/**
	 * Return the value associated with the column: CDXREDEL
	 */
	public java.lang.String getCdxredel () {
		return cdxredel;
	}

	/**
	 * Set the value related to the column: CDXREDEL
	 * @param cdxredel the CDXREDEL value
	 */
	public void setCdxredel (java.lang.String cdxredel) {
		this.cdxredel = cdxredel;
	}



	/**
	 * Return the value associated with the column: GRADE
	 */
	public java.lang.String getGrade () {
		return grade;
	}

	/**
	 * Set the value related to the column: GRADE
	 * @param grade the GRADE value
	 */
	public void setGrade (java.lang.String grade) {
		this.grade = grade;
	}



	/**
	 * Return the value associated with the column: CONCOND
	 */
	public java.lang.String getConcond () {
		return concond;
	}

	/**
	 * Set the value related to the column: CONCOND
	 * @param concond the CONCOND value
	 */
	public void setConcond (java.lang.String concond) {
		this.concond = concond;
	}



	/**
	 * Return the value associated with the column: CHACOND
	 */
	public java.lang.String getChacond () {
		return chacond;
	}

	/**
	 * Set the value related to the column: CHACOND
	 * @param chacond the CHACOND value
	 */
	public void setChacond (java.lang.String chacond) {
		this.chacond = chacond;
	}



	/**
	 * Return the value associated with the column: GRIDLOC
	 */
	public java.lang.String getGridloc () {
		return gridloc;
	}

	/**
	 * Set the value related to the column: GRIDLOC
	 * @param gridloc the GRIDLOC value
	 */
	public void setGridloc (java.lang.String gridloc) {
		this.gridloc = gridloc;
	}



	/**
	 * Return the value associated with the column: waiveinspfee
	 */
	public boolean isWaiveinspfee () {
		return waiveinspfee;
	}

	/**
	 * Set the value related to the column: waiveinspfee
	 * @param waiveinspfee the waiveinspfee value
	 */
	public void setWaiveinspfee (boolean waiveinspfee) {
		this.waiveinspfee = waiveinspfee;
	}



	/**
	 * Return the value associated with the column: waiveliftfee
	 */
	public boolean isWaiveliftfee () {
		return waiveliftfee;
	}

	/**
	 * Set the value related to the column: waiveliftfee
	 * @param waiveliftfee the waiveliftfee value
	 */
	public void setWaiveliftfee (boolean waiveliftfee) {
		this.waiveliftfee = waiveliftfee;
	}



	/**
	 * Return the value associated with the column: UPDTDATE
	 */
	public java.util.Date getUpdtdate () {
		return updtdate;
	}

	/**
	 * Set the value related to the column: UPDTDATE
	 * @param updtdate the UPDTDATE value
	 */
	public void setUpdtdate (java.util.Date updtdate) {
		this.updtdate = updtdate;
	}



	/**
	 * Return the value associated with the column: UPDTTIME
	 */
	public java.lang.String getUpdttime () {
		return updttime;
	}

	/**
	 * Set the value related to the column: UPDTTIME
	 * @param updttime the UPDTTIME value
	 */
	public void setUpdttime (java.lang.String updttime) {
		this.updttime = updttime;
	}



	/**
	 * Return the value associated with the column: shuttlemove
	 */
	public boolean isShuttlemove () {
		return shuttlemove;
	}

	/**
	 * Set the value related to the column: shuttlemove
	 * @param shuttlemove the shuttlemove value
	 */
	public void setShuttlemove (boolean shuttlemove) {
		this.shuttlemove = shuttlemove;
	}




	public String getShuttlfee () {
		return shuttlfee;
	}
	public void setShuttlfee (String shuttlfee) {
		this.shuttlfee = shuttlfee;
	}



	/**
	 * Return the value associated with the column: shuttlecustomeraddrkey
	 */
	public java.lang.String getShuttlecustomeraddrkey () {
		return shuttlecustomeraddrkey;
	}

	/**
	 * Set the value related to the column: shuttlecustomeraddrkey
	 * @param shuttlecustomeraddrkey the shuttlecustomeraddrkey value
	 */
	public void setShuttlecustomeraddrkey (java.lang.String shuttlecustomeraddrkey) {
		this.shuttlecustomeraddrkey = shuttlecustomeraddrkey;
	}



	/**
	 * Return the value associated with the column: droplot
	 */
	public boolean isDroplot () {
		return droplot;
	}

	/**
	 * Set the value related to the column: droplot
	 * @param droplot the droplot value
	 */
	public void setDroplot (boolean droplot) {
		this.droplot = droplot;
	}



	/**
	 * Return the value associated with the column: dropcustomeraddrkey
	 */
	public java.lang.String getDropcustomeraddrkey () {
		return dropcustomeraddrkey;
	}

	/**
	 * Set the value related to the column: dropcustomeraddrkey
	 * @param dropcustomeraddrkey the dropcustomeraddrkey value
	 */
	public void setDropcustomeraddrkey (java.lang.String dropcustomeraddrkey) {
		this.dropcustomeraddrkey = dropcustomeraddrkey;
	}



	/**
	 * Return the value associated with the column: foreigntarget
	 */
	public boolean isForeigntarget () {
		return foreigntarget;
	}

	/**
	 * Set the value related to the column: foreigntarget
	 * @param foreigntarget the foreigntarget value
	 */
	public void setForeigntarget (boolean foreigntarget) {
		this.foreigntarget = foreigntarget;
	}



	/**
	 * Return the value associated with the column: cha2
	 */
	public java.lang.String getCha2 () {
		return cha2;
	}

	/**
	 * Set the value related to the column: cha2
	 * @param cha2 the cha2 value
	 */
	public void setCha2 (java.lang.String cha2) {
		this.cha2 = cha2;
	}



	/**
	 * Return the value associated with the column: CHAEIR2
	 */
	public java.lang.String getChaeir2 () {
		return chaeir2;
	}

	/**
	 * Set the value related to the column: CHAEIR2
	 * @param chaeir2 the CHAEIR2 value
	 */
	public void setChaeir2 (java.lang.String chaeir2) {
		this.chaeir2 = chaeir2;
	}



	/**
	 * Return the value associated with the column: cha3
	 */
	public java.lang.String getCha3 () {
		return cha3;
	}

	/**
	 * Set the value related to the column: cha3
	 * @param cha3 the cha3 value
	 */
	public void setCha3 (java.lang.String cha3) {
		this.cha3 = cha3;
	}



	/**
	 * Return the value associated with the column: CHAEIR3
	 */
	public java.lang.String getChaeir3 () {
		return chaeir3;
	}

	/**
	 * Set the value related to the column: CHAEIR3
	 * @param chaeir3 the CHAEIR3 value
	 */
	public void setChaeir3 (java.lang.String chaeir3) {
		this.chaeir3 = chaeir3;
	}



	/**
	 * Return the value associated with the column: cha4
	 */
	public java.lang.String getCha4 () {
		return cha4;
	}

	/**
	 * Set the value related to the column: cha4
	 * @param cha4 the cha4 value
	 */
	public void setCha4 (java.lang.String cha4) {
		this.cha4 = cha4;
	}



	/**
	 * Return the value associated with the column: CHAEIR4
	 */
	public java.lang.String getChaeir4 () {
		return chaeir4;
	}

	/**
	 * Set the value related to the column: CHAEIR4
	 * @param chaeir4 the CHAEIR4 value
	 */
	public void setChaeir4 (java.lang.String chaeir4) {
		this.chaeir4 = chaeir4;
	}



	/**
	 * Return the value associated with the column: cha5
	 */
	public java.lang.String getCha5 () {
		return cha5;
	}

	/**
	 * Set the value related to the column: cha5
	 * @param cha5 the cha5 value
	 */
	public void setCha5 (java.lang.String cha5) {
		this.cha5 = cha5;
	}



	/**
	 * Return the value associated with the column: CHAEIR5
	 */
	public java.lang.String getChaeir5 () {
		return chaeir5;
	}

	/**
	 * Set the value related to the column: CHAEIR5
	 * @param chaeir5 the CHAEIR5 value
	 */
	public void setChaeir5 (java.lang.String chaeir5) {
		this.chaeir5 = chaeir5;
	}



	/**
	 * Return the value associated with the column: targeteq
	 */
	public java.lang.String getTargeteq () {
		return targeteq;
	}

	/**
	 * Set the value related to the column: targeteq
	 * @param targeteq the targeteq value
	 */
	public void setTargeteq (java.lang.String targeteq) {
		this.targeteq = targeteq;
	}



	/**
	 * Return the value associated with the column: CONMFG
	 */
	public java.lang.String getConmfg () {
		return conmfg;
	}

	/**
	 * Set the value related to the column: CONMFG
	 * @param conmfg the CONMFG value
	 */
	public void setConmfg (java.lang.String conmfg) {
		this.conmfg = conmfg;
	}




	public Date getConmfgdt() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getConmfgdtyyyy()), Integer
						.parseInt(getConmfgdtmm()) - 1, Integer
						.parseInt(getConmfgdtdd()));
		return c.getTime();
	}
	public void setConmfgdt(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setConmfgdtyyyy(c.get(Calendar.YEAR) + "");
		setConmfgdtmm((month < 10 ? "0" : "") + month);
		setConmfgdtdd((day < 10 ? "0" : "") + day);
	}
	public String getConmfgdtdd () {return conmfgdtdd;}
	public void setConmfgdtdd (String conmfgdtdd) {this.conmfgdtdd = conmfgdtdd;}
	public String getConmfgdtmm () {return conmfgdtmm;}
	public void setConmfgdtmm (String conmfgdtmm) {this.conmfgdtmm = conmfgdtmm;}
	public String getConmfgdtyyyy () {return conmfgdtyyyy;}
	public void setConmfgdtyyyy (String conmfgdtyyyy) {this.conmfgdtyyyy = conmfgdtyyyy;}
	
	


	/**
	 * Return the value associated with the column: CHAMFG
	 */
	public java.lang.String getChamfg () {
		return chamfg;
	}

	/**
	 * Set the value related to the column: CHAMFG
	 * @param chamfg the CHAMFG value
	 */
	public void setChamfg (java.lang.String chamfg) {
		this.chamfg = chamfg;
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
	
	

	public Date getIndate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getIndateyyyy()), Integer
						.parseInt(getIndatemm()) - 1, Integer
						.parseInt(getIndatedd()));
		return c.getTime();
	}
	public void setIndate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setIndateyyyy(c.get(Calendar.YEAR) + "");
		setIndatemm((month < 10 ? "0" : "") + month);
		setIndatedd((day < 10 ? "0" : "") + day);
	}
	public String getIndatedd () {return indatedd;}
	public void setIndatedd (String indatedd) {this.indatedd = indatedd;}
	public String getIndatemm () {return indatemm;}
	public void setIndatemm (String indatemm) {this.indatemm = indatemm;}
	public String getIndateyyyy () {return indateyyyy;}
	public void setIndateyyyy (String indateyyyy) {this.indateyyyy = indateyyyy;}

	

	public Date getTurnenddate() {
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(getTurnenddateyyyy()), Integer
						.parseInt(getTurnenddatemm()) - 1, Integer
						.parseInt(getTurnenddatedd()));
		return c.getTime();
	}
	public void setTurnenddate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setTurnenddateyyyy(c.get(Calendar.YEAR) + "");
		setTurnenddatemm((month < 10 ? "0" : "") + month);
		setTurnenddatedd((day < 10 ? "0" : "") + day);
	}
	public String getTurnenddatedd () {return turnenddatedd;}
	public void setTurnenddatedd (String turnenddatedd) {this.turnenddatedd = turnenddatedd;}
	public String getTurnenddatemm () {return turnenddatemm;}
	public void setTurnenddatemm (String turnenddatemm) {this.turnenddatemm = turnenddatemm;}
	public String getTurnenddateyyyy () {return turnenddateyyyy;}
	public void setTurnenddateyyyy (String turnenddateyyyy) {this.turnenddateyyyy = turnenddateyyyy;}
	
	
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
	}	


	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// do not vaildate if Delete Action
		if (_action == null || _action.equals("Delete"))
			return null;

		// Perform validator framework validations
		ActionErrors errors =
			super.validate(mapping, request);
		if (errors==null) errors = new ActionErrors();	


	       if ((eirin == null) || (eirin.length() < 1))
	            errors.add("eirin",
	                    new ActionMessage("error.eirin.required"));        	

			if (_action.equals("Create")) {
				if (Util.invalidChars(this.eirin)) errors.add("eirin", new ActionMessage("error.eirin.invalidchars"));
			}
      
         	      
		
        java.util.Date date = null;
    	DateFormatter dateFormatter = new DateFormatter();
        try {
    		date = (java.util.Date)dateFormatter.unformat(
    								indateyyyy+"-"+
    								indatemm+"-"+ 
    								indatedd
									);
        } catch (Exception e) {}	        	
        if (date == null) errors.add("invoicedatedd", new ActionMessage("error.indate.required"));        	

 

		addErrorIfBlank(errors, "customeraddrkey", customeraddrkey, "error.customer.required");	
		addErrorIfBlank(errors, "depotlocationkey", depotlocationkey, "error.depot.required");	
		
		
		return errors;

	}

	private void addErrorIfBlank(ActionErrors errors, String fieldName,
			String fieldValue, String message) {
		if (fieldValue == null || fieldValue.trim().equals("")) {
			errors.add(fieldName, new ActionMessage(message));
		}
	}

	
	/**
	 * Returns an array of keys, representing values that should not be
	 * populated for the current form instance. Subclasses that override
	 * this method to provide additional keys to be skipped should be
	 * sure to call <code>super</code>
	 *
	 * @return an array of keys to be skipped
	 */
	protected ArrayList keysToSkip() {
		ArrayList keysToSkip = super.keysToSkip();
		
		return keysToSkip;
	}
	
	
}

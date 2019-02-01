package com.bureaueye.beacon.bean.edi.edifact;

import java.util.Date;
import java.util.List;




/**
 * This class has been generated to store data which will 
 * be transmitted to the IFTSTA EDI messages
 *
 * @edi.class
 *  table="location"
 */
public interface EDIIftsta  {

	
	/**
     */
	public java.lang.String getMovementType () ;
	
	/**
     */
	public java.lang.String getTankSpecsId ();
	/**
	 */
	public void setTankSpecsId (java.lang.String _tankspecsid);

	
	/**
     */
	public List getUnits();
	/**
	 */
	public void setUnits (List _units);
	
	

	/**
     */
	public java.lang.String getShipperRef ();
	public void setShipperRef (java.lang.String _shipperref);
	
	/**
     */
	public java.lang.String getConsigneeRef ();
	public void setConsigneeRef (java.lang.String _consigneeref);
	
	/**
     */
	public java.lang.String getCustomerRef ();
	public void setCustomerRef(java.lang.String _customerref);
	
	/**
     */
	public java.lang.String getBrokerRef ();
	public void setBrokerRef (java.lang.String _brokerref);
	
	/**
     */
	public java.lang.String getFwdagentRef ();
	public void setFwdagentRef (java.lang.String _fwdagentref);


	
	
	/**
     */
	public java.lang.String getNumberOfTanks ();
	/**
	 */
	public void setNumberOfTanks (java.lang.String value);

	/**
     */
	public java.lang.String getShipMethod ();
	/**
	 */
	public void setShipMethod(java.lang.String value);
	
	/**
     */
	public java.lang.String getWeightPerTank ();
	/**
	 */
	public void setWeightPerTank (java.lang.String value);
	
	/**
     */
	public java.lang.String getVoyage1 ();
	/**
	 */
	public void setVoyage1 (java.lang.String value);

	/**
     */
	public java.lang.String getVoyage2 ();
	/**
	 */
	public void setVoyage2 (java.lang.String value);
	
	/**
     */
	public java.lang.String getVessel ();
	/**
	 */
	public void setVessel (java.lang.String value);
	
	/**
     */
	public java.lang.String getBookingNumber ();
	/**
	 */
	public void setBookingNumber (java.lang.String value);
	
	/**
     */
	public java.lang.String getPuPlantRelNumber ();
	/**
	 */
	public void setPuPlantRelNumber (java.lang.String value);
	
	
	/**
     */
	public java.lang.String getShipmentProcessId ();
	/**
	 */
	public void setShipmentProcessId (java.lang.String _shipmentprocessid);
	
	/**
     */
	public java.lang.String getTankNumber ();
	/**
	 */
	public void setTankNumber (java.lang.String _tanknumber);

	
	/**
     */
	public java.lang.String getLabelProperty ();
	/**
	 */
	public void setLabelProperty (java.lang.String _labelProperty);

	
	/**
     */
	public java.lang.String getConsigneeaddrkey ();
	/**
	 */
	public void setConsigneeaddrkey (java.lang.String _consigneeaddrkey) ;

	/**
     */
	public java.lang.String getCustomeraddrkey ();
	/**
	 */
	public void setCustomeraddrkey (java.lang.String _customeraddrkey);
	
	/**
     */
	public java.lang.String getForwardagentaddrkey ();
	/**
	 */
	public void setForwardagentaddrkey (java.lang.String _forwardagentaddrkey);

	/**
     */
	public java.lang.String getBrokeraddrkey ();
	/**
	 */
	public void setBrokeraddrkey (java.lang.String _brokeraddrkey);
	
	/**
     */
	public java.lang.String getShipperaddrkey ();
	/**
	 */
	public void setShipperaddrkey(java.lang.String _shipperaddrkey);
	

	// location fields
	/**
     */
	public java.lang.String getPortofloadingid ();
	/**
	 */
	public void setPortofloadingid(java.lang.String _portofloadingid);

	/**
     */
	public java.lang.String getPortofdestinationid ();
	/**
	 */
	public void setPortofdestinationid(java.lang.String _portofdestinationid);

	/**
     */
	public java.lang.String getPlantpickupid ();
	/**
	 */
	public void setPlantpickupid(java.lang.String _plantpickupid);

	/**
     */
	public java.lang.String getPlantdeliverid ();
	/**
	 */
	public void setPlantdeliverid(java.lang.String _plantdeliverid);

	/**
     */
	public java.lang.String getDepotleaveid ();
	/**
	 */
	public void setDepotleaveid(java.lang.String _depotleaveid);

	/**
     */
	public java.lang.String getDepotdeliverid ();
	/**
	 */
	public void setDepotdeliverid(java.lang.String _depotdeliverid);
	
	
	// carrier fields
	/**
     */
	public java.lang.String getShiplineId ();
	/**
	 */
	public void setShiplineId(java.lang.String _shiplineId);

	/**
     */
	public java.lang.String getTruckerexportid ();
	/**
	 */
	public void setTruckerexportid(java.lang.String _truckerexportid);

	/**
     */
	public java.lang.String getTruckerimportid ();
	/**
	 */
	public void setTruckerimportid(java.lang.String _truckerimportid);


	


	/**
     */
	public Date getDepotarrivedateActual ();
	/**
	 */
	public void setDepotarrivedateActual (Date _depotarrivedateActual);

	
	/**
     */
	public Date getDepotreturndateActual ();
	/**
	 */
	public void setDepotreturndateActual (Date _depotreturndateActual);
	
	/**
     */
	public Date getDestplantdateActual ();

	/**
	 */
	public void setDestplantdateActual (Date _destplantdateActual);
	
	/**
     */
	public Date getPoldateActual ();
	/**
	 */
	public void setPoldateActual (Date _poldateActual);

	/**
     */
	public Date getPuplantloadActual () ;
	/**
	 */
	public void setPuplantloadActual (Date _puplantloadActual);

	/**
     */
	public Date getPoddateActual ();
	/**
	 */
	public void setPoddateActual (Date _poddateActual);
	
	
	

	/**
     */
	public Date getDepotarrivedateEst ();
	/**
	 */
	public void setDepotarrivedateEst (Date _depotarrivedateEst);

	
	/**
     */
	public Date getDepotreturndateEst ();
	/**
	 */
	public void setDepotreturndateEst (Date _depotreturndateEst);
	
	/**
     */
	public Date getDestplantdateEst ();
	/**
	 */
	public void setDestplantdateEst (Date _destplantdateEst);
	
	/**
     */
	public Date getPoldateEst ();
	/**
	 */
	public void setPoldateEst (Date _poldateEst);

	/**
     */
	public Date getPuplantloadEst ();
	/**
	 */
	public void setPuplantloadEst (Date _puplantloadEst);

	/**
     */
	public Date getPoddateEst ();
	/**
	 */
	public void setPoddateEst (Date _poddateEst);
	
	
	
   	public String getCreatedate();
   	public void setCreatedate(String value);
   	public String getCreatetime();
   	public void setCreatetime(String value);


   	public String getXdate();
   	public void setXdate(String value);
   	public String getXtime() ;
   	public void setXtime(String value);

	public String getXuserid();
	public void setXuserid(String value);
	

	public String toString ();

	
	public StringBuffer toEDI ();
	
	
}
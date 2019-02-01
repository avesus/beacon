package com.bureaueye.beacon.model.order.dto;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.bd.ProductBD;





public final class OrderprodDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public OrderprodDTO(Orderprod dao) throws ApplicationException {
		initialize(dao);		
	}
	public OrderprodDTO(Orderprod dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}
	
	
	
	protected void initialize (Orderprod dao) throws ApplicationException {
		// populate data-transfer-object from data-access-object
		this.setProductkey(new ProductBD(this.getSessionFactoryClusterMap()).read(dao.getProductkey()));
		this.setVolume(dao.getVolume());
		this.setVolunit(dao.getVolunit());
		this.setWeight(dao.getWeight());
		this.setWghtunit(dao.getWghtunit());
		this.setComprt(dao.getComprt());
		this.setOrderprodId(dao.getOrderprodId());
		this.setOrderhdrId(dao.getOrderhdrId());
	}
	
	
	// primary key
	private java.lang.Integer orderprodId;
	
	// fields
	private java.lang.String surftemp;
	private boolean deleted;
	private java.lang.String volunit;
	private java.lang.String ldgtemp;
	private java.lang.String comprt;
	private java.math.BigDecimal volume;
	private java.lang.String tempunit;
	private java.lang.String wghtunit;
	private java.lang.String lqdtemp;
	private java.lang.Integer orderhdrId;
	private java.math.BigDecimal weight;
	private java.lang.String imo;
	private java.lang.String dchtemp;
	private java.lang.String productname;
	private java.lang.String unno;
	private Product productkey;
	
	
	
	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="native"
	 *  column="ORDERPROD_ID"
	 */
	public java.lang.Integer getOrderprodId () {
		return orderprodId;
	}
	
	/**
	 * Set the unique identifier of this class
	 * @param orderprodId the new ID
	 */
	public void setOrderprodId (java.lang.Integer orderprodId) {
		this.orderprodId = orderprodId;
	}
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: SURFTEMP
	 */
	public java.lang.String getSurftemp () {
		return surftemp;
	}
	
	/**
	 * Set the value related to the column: SURFTEMP
	 * @param surftemp the SURFTEMP value
	 */
	public void setSurftemp (java.lang.String surftemp) {
		this.surftemp = surftemp;
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
	 * Return the value associated with the column: VOLUNIT
	 */
	public java.lang.String getVolunit () {
		return volunit;
	}
	
	/**
	 * Set the value related to the column: VOLUNIT
	 * @param volunit the VOLUNIT value
	 */
	public void setVolunit (java.lang.String volunit) {
		this.volunit = volunit;
	}
	
	
	
	
	
	/**
	 * Return the value associated with the column: LDGTEMP
	 */
	public java.lang.String getLdgtemp () {
		return ldgtemp;
	}
	
	/**
	 * Set the value related to the column: LDGTEMP
	 * @param ldgtemp the LDGTEMP value
	 */
	public void setLdgtemp (java.lang.String ldgtemp) {
		this.ldgtemp = ldgtemp;
	}
	
	
	
	/**
	 * Return the value associated with the column: COMPRT
	 */
	public java.lang.String getComprt () {
		return comprt;
	}
	
	/**
	 * Set the value related to the column: COMPRT
	 * @param comprt the COMPRT value
	 */
	public void setComprt (java.lang.String comprt) {
		this.comprt = comprt;
	}
	
	
	
	/**
	 * Return the value associated with the column: VOLUME
	 */
	public java.math.BigDecimal getVolume () {
		return volume;
	}
	
	/**
	 * Set the value related to the column: VOLUME
	 * @param volume the VOLUME value
	 */
	public void setVolume (java.math.BigDecimal volume) {
		this.volume = volume;
	}
	
	
	
	/**
	 * Return the value associated with the column: TEMPUNIT
	 */
	public java.lang.String getTempunit () {
		return tempunit;
	}
	
	/**
	 * Set the value related to the column: TEMPUNIT
	 * @param tempunit the TEMPUNIT value
	 */
	public void setTempunit (java.lang.String tempunit) {
		this.tempunit = tempunit;
	}
	
	
	
	/**
	 * Return the value associated with the column: WGHTUNIT
	 */
	public java.lang.String getWghtunit () {
		return wghtunit;
	}
	
	/**
	 * Set the value related to the column: WGHTUNIT
	 * @param wghtunit the WGHTUNIT value
	 */
	public void setWghtunit (java.lang.String wghtunit) {
		this.wghtunit = wghtunit;
	}
	
	
	
	/**
	 * Return the value associated with the column: LQDTEMP
	 */
	public java.lang.String getLqdtemp () {
		return lqdtemp;
	}
	
	/**
	 * Set the value related to the column: LQDTEMP
	 * @param lqdtemp the LQDTEMP value
	 */
	public void setLqdtemp (java.lang.String lqdtemp) {
		this.lqdtemp = lqdtemp;
	}
	
	
	

	
	
	
	/**
	 * Return the value associated with the column: ORDERHDR_ID
	 */
	public java.lang.Integer getOrderhdrId () {
		return orderhdrId;
	}
	
	/**
	 * Set the value related to the column: ORDERHDR_ID
	 * @param orderhdrId the ORDERHDR_ID value
	 */
	public void setOrderhdrId (java.lang.Integer orderhdrId) {
		this.orderhdrId = orderhdrId;
	}
	
	
	
	/**
	 * Return the value associated with the column: WEIGHT
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}
	
	/**
	 * Set the value related to the column: WEIGHT
	 * @param weight the WEIGHT value
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}
	
	
	
	
	/**
	 * Return the value associated with the column: IMO
	 */
	public java.lang.String getImo () {
		return imo;
	}
	
	/**
	 * Set the value related to the column: IMO
	 * @param imo the IMO value
	 */
	public void setImo (java.lang.String imo) {
		this.imo = imo;
	}
	
	
	
	
	
	
	
	
	/**
	 * Return the value associated with the column: DCHTEMP
	 */
	public java.lang.String getDchtemp () {
		return dchtemp;
	}
	
	/**
	 * Set the value related to the column: DCHTEMP
	 * @param dchtemp the DCHTEMP value
	 */
	public void setDchtemp (java.lang.String dchtemp) {
		this.dchtemp = dchtemp;
	}
	
	
	
	/**
	 * Return the value associated with the column: productname
	 */
	public java.lang.String getProductname () {
		return productname;
	}
	
	/**
	 * Set the value related to the column: productname
	 * @param productname the productname value
	 */
	public void setProductname (java.lang.String productname) {
		this.productname = productname;
	}
	
	
	
	
	
	/**
	 * Return the value associated with the column: UNNO
	 */
	public java.lang.String getUnno () {
		return unno;
	}
	
	/**
	 * Set the value related to the column: UNNO
	 * @param unno the UNNO value
	 */
	public void setUnno (java.lang.String unno) {
		this.unno = unno;
	}
	
	
	
	/**
	 * Return the value associated with the column: productkey
	 */
	public Product getProductkey () {
		return productkey;
	}
	
	/**
	 * Set the value related to the column: productkey
	 * @param productkey the productkey value
	 */
	public void setProductkey (Product productkey) {
		this.productkey = productkey;
	}
	
	
	
	
	
	
}

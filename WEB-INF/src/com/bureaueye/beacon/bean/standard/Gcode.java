package com.bureaueye.beacon.bean.standard;

import java.util.Map;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;




/**
 */
public final class Gcode {


	// fields
	private java.lang.String g1codekey;
	private java.lang.String g2codekey;
	private java.lang.String g3codekey;
	private java.lang.String g4codekey;


	// constructors
	public Gcode (
			Map<String, SessionFactory> sfcm
			) {
		setSessionFactoryClusterMap(sfcm);	
		this.g1codekey = "";
		this.g2codekey = "";
		this.g3codekey = "";
		this.g4codekey = "";
	}

 
	public void initGcodesByLocation (
			String key	
	) {
		try {
			LocationBD bd = new LocationBD(this.getSessionFactoryClusterMap());
			com.bureaueye.beacon.model.standard.Location location = bd.read(key);
			this.g1codekey = location.getG1codekey();
			this.g2codekey = location.getG2codekey();
			this.g3codekey = location.getG3codekey();
			this.g4codekey = location.getG4codekey();
			location=null;
			bd=null;
		} catch (Exception e) {
		}
	}
	public void initGcodesByAddress (
			String key
	) {
		try {
			AddressBD bd = new AddressBD(this.getSessionFactoryClusterMap());
			com.bureaueye.beacon.model.standard.Address address = bd.read(key);		
			this.g1codekey = address.getG1codekey();
			this.g2codekey = address.getG2codekey();
			this.g3codekey = address.getG3codekey();
			this.g4codekey = address.getG4codekey();
			address=null;
			bd=null;
		} catch (Exception e) {
		}
	}


	
	protected static Map<String, SessionFactory> _sessionFactoryClusterMap;
	/**
	 * Set the session factory cluster to Map
	 */
	public void setSessionFactoryClusterMap (Map<String, SessionFactory> sfcm) {
		_sessionFactoryClusterMap = sfcm;
	}	
	/**
	 * get the session factory cluster Map
	 */
	public Map<String, SessionFactory> getSessionFactoryClusterMap () {
		return _sessionFactoryClusterMap;
	}
	
	
	/**
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}
	/**
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}


	/**
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}


	/**
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}
	/**
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}

	/**
	 */
	public java.lang.String getG4codekey () {
		return g4codekey;
	}
	/**
	 */
	public void setG4codekey (java.lang.String g4codekey) {
		this.g4codekey = g4codekey;
	}




	public String toString () {
		return super.toString();
	}

}
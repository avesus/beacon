package com.bureaueye.beacon.model.standard.dto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.SessionFactory;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.dto.BaseDTO;
import com.bureaueye.beacon.model.standard.Useraccess;


/**
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module 
 *
 */
public final class UseraccessDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	// constructors
	public UseraccessDTO(Useraccess dao) throws ApplicationException {
		initialize(dao);		
	}
	public UseraccessDTO(Useraccess dao, Map<String, SessionFactory> sfcm) throws ApplicationException {
		super(sfcm);
		initialize(dao);
	}

	
	protected void initialize (Useraccess dao) throws ApplicationException {

		this.setAccessid(dao.getAccessid());
		this.setTxt(dao.getTxt());
		this.setUseraccessId(dao.getUseraccessId());
		this.setUserid(dao.getUserid());
		
		//convert string list to list collection
		this.setGrantactionlist(dao.getGrantactionlist());	
		
	}
	
	
	
	
	// fields
	private String readonly = "false";
	
	
	
	
	// primary key
	private java.lang.Integer useraccessId;

	// fields
	private java.lang.String userid;
	private java.lang.String accessid;
	private java.lang.String txt;

	
	private List<String> grantactionlist;	


	public String getReadonly() {return readonly;}
	public void setReadonly(String readonly) {this.readonly = readonly;}


	/**
     */
	public java.lang.Integer getUseraccessId () {
		return useraccessId;
	}

	/**
	 */
	public void setUseraccessId (java.lang.Integer useraccessId) {
		this.useraccessId = useraccessId;
	}




	/**
	 * Return the value associated with the column: userid
	 */
	public java.lang.String getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: userid
	 * @param userid the userid value
	 */
	public void setUserid (java.lang.String userid) {
		this.userid = userid;
	}



	/**
	 * Return the value associated with the column: accessid
	 */
	public java.lang.String getAccessid () {
		return accessid;
	}

	/**
	 * Set the value related to the column: accessid
	 * @param accessid the accessid value
	 */
	public void setAccessid (java.lang.String accessid) {
		this.accessid = accessid;
	}





	/**
	 * Return the value associated with the column: txt
	 */
	public java.lang.String getTxt () {
		return txt;
	}

	/**
	 * Set the value related to the column: txt
	 * @param txt the txt value
	 */
	public void setTxt (java.lang.String txt) {
		this.txt = txt;
	}

	

	/**
	 */
	public List getGrantactionlist () {
		return grantactionlist;
	}

	/**
	 */
	public void setGrantactionlist(String _grantactionlist) {
		StringTokenizer st = new StringTokenizer(_grantactionlist, "\\|");
		grantactionlist = new LinkedList<String>();
		while (st.hasMoreTokens())
			grantactionlist.add(st.nextToken());	
	}







	
}

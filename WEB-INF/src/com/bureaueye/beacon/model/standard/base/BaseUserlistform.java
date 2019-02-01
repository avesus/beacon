package com.bureaueye.beacon.model.standard.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the userlistform table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="userlistform"
 */

public abstract class BaseUserlistform  implements Serializable {

	public static String REF = "Userlistform";
	public static String PROP_DEPARTMENTKEY = "Departmentkey";
	public static String PROP_USERID = "Userid";
	public static String PROP_G1CODEKEY = "G1codekey";
	public static String PROP_ACTIVITYKEY = "Activitykey";
	public static String PROP_SYSTEMLOGACTION = "Systemlogaction";
	public static String PROP_SEARCH_DATE4YYYY = "SearchDate4yyyy";
	public static String PROP_SYSTEMLOGDATE = "Systemlogdate";
	public static String PROP_SEARCH_DATE2YYYY = "SearchDate2yyyy";
	public static String PROP_LISTFORM = "Listform";
	public static String PROP_ORDER_BY3_DESC = "OrderBy3Desc";
	public static String PROP_CREATEUSERID = "Createuserid";
	public static String PROP_SEARCH_DATE3YYYY = "SearchDate3yyyy";
	public static String PROP_ORDER_BY = "OrderBy";
	public static String PROP_BREAD_CRUMB = "BreadCrumb";
	public static String PROP_ORDER_BY_DESC = "OrderByDesc";
	public static String PROP_G4CODEKEY = "G4codekey";
	public static String PROP_HEADER_INFO10 = "HeaderInfo10";
	public static String PROP_SYSTEMLOGUSERID = "Systemloguserid";
	public static String PROP_HEADER_INFO11 = "HeaderInfo11";
	public static String PROP_HEADER_INFO14 = "HeaderInfo14";
	public static String PROP_SEARCH_DATE1MM = "SearchDate1mm";
	public static String PROP_ORDER_BY2 = "OrderBy2";
	public static String PROP_HEADER_INFO15 = "HeaderInfo15";
	public static String PROP_COMPANYKEY = "Companykey";
	public static String PROP_ORDER_BY3 = "OrderBy3";
	public static String PROP_HEADER_INFO12 = "HeaderInfo12";
	public static String PROP_G2CODEKEY = "G2codekey";
	public static String PROP_G3CODEKEY = "G3codekey";
	public static String PROP_HEADER_INFO13 = "HeaderInfo13";
	public static String PROP_SEARCH_STRING24 = "SearchString24";
	public static String PROP_SEARCH_DATE2MM = "SearchDate2mm";
	public static String PROP_SEARCH_STRING23 = "SearchString23";
	public static String PROP_SEARCH_STRING22 = "SearchString22";
	public static String PROP_SYSTEMLOGTIME = "Systemlogtime";
	public static String PROP_SEARCH_STRING21 = "SearchString21";
	public static String PROP_SEARCH_STRING28 = "SearchString28";
	public static String PROP_SEARCH_STRING27 = "SearchString27";
	public static String PROP_SEARCH_STRING26 = "SearchString26";
	public static String PROP_SEARCH_STRING25 = "SearchString25";
	public static String PROP_SEARCH_STRING29 = "SearchString29";
	public static String PROP_SEARCH_STRING20 = "SearchString20";
	public static String PROP_SYSTEMLOGPROGRAM = "Systemlogprogram";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_SEARCH_STRING5 = "SearchString5";
	public static String PROP_SEARCH_STRING6 = "SearchString6";
	public static String PROP_SEARCH_DATE4MM = "SearchDate4mm";
	public static String PROP_SEARCH_STRING7 = "SearchString7";
	public static String PROP_SEARCH_STRING18 = "SearchString18";
	public static String PROP_SEARCH_STRING8 = "SearchString8";
	public static String PROP_SEARCH_STRING19 = "SearchString19";
	public static String PROP_SEARCH_DATE3MM = "SearchDate3mm";
	public static String PROP_SEARCH_STRING1 = "SearchString1";
	public static String PROP_SEARCH_STRING30 = "SearchString30";
	public static String PROP_SEARCH_STRING2 = "SearchString2";
	public static String PROP_SEARCH_STRING3 = "SearchString3";
	public static String PROP_SEARCH_STRING4 = "SearchString4";
	public static String PROP_SEARCH_STRING11 = "SearchString11";
	public static String PROP_SEARCH_DATE1DD = "SearchDate1dd";
	public static String PROP_SEARCH_STRING10 = "SearchString10";
	public static String PROP_SEARCH_STRING13 = "SearchString13";
	public static String PROP_SEARCH_STRING12 = "SearchString12";
	public static String PROP_SEARCH_STRING15 = "SearchString15";
	public static String PROP_SEARCH_STRING14 = "SearchString14";
	public static String PROP_HEADER_INFO2 = "HeaderInfo2";
	public static String PROP_SEARCH_STRING17 = "SearchString17";
	public static String PROP_SEARCH_DATE1YYYY = "SearchDate1yyyy";
	public static String PROP_HEADER_INFO1 = "HeaderInfo1";
	public static String PROP_SEARCH_STRING9 = "SearchString9";
	public static String PROP_SEARCH_STRING16 = "SearchString16";
	public static String PROP_HEADER_INFO4 = "HeaderInfo4";
	public static String PROP_HEADER_INFO3 = "HeaderInfo3";
	public static String PROP_SEARCH_DATE4DD = "SearchDate4dd";
	public static String PROP_HEADER_INFO6 = "HeaderInfo6";
	public static String PROP_HEADER_INFO5 = "HeaderInfo5";
	public static String PROP_SEARCH_DATE3DD = "SearchDate3dd";
	public static String PROP_HEADER_INFO8 = "HeaderInfo8";
	public static String PROP_ORDER_BY2_DESC = "OrderBy2Desc";
	public static String PROP_HEADER_INFO7 = "HeaderInfo7";
	public static String PROP_HEADER_INFO9 = "HeaderInfo9";
	public static String PROP_SEARCH_DATE2DD = "SearchDate2dd";
	public static String PROP_USERLISTFORM_ID = "UserlistformId";
	public static String PROP_MAX_RESULTS = "MaxResults";
	public static String PROP_XLOCK = "Xlock";
	public static String PROP_CREATETIME = "Createtime";


	// constructors
	public BaseUserlistform () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserlistform (java.lang.Integer userlistformId) {
		this.setUserlistformId(userlistformId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer userlistformId;

	// fields
	private java.lang.String userid;
	private java.lang.String listform;
	private java.lang.String headerInfo1;
	private java.lang.String headerInfo2;
	private java.lang.String headerInfo3;
	private java.lang.String headerInfo4;
	private java.lang.String headerInfo5;
	private java.lang.String headerInfo6;
	private java.lang.String headerInfo7;
	private java.lang.String headerInfo8;
	private java.lang.String headerInfo9;
	private java.lang.String headerInfo10;
	private java.lang.String headerInfo11;
	private java.lang.String headerInfo12;
	private java.lang.String headerInfo13;
	private java.lang.String headerInfo14;
	private java.lang.String headerInfo15;
	private java.lang.String searchString1;
	private java.lang.String searchString2;
	private java.lang.String searchString3;
	private java.lang.String searchString4;
	private java.lang.String searchString5;
	private java.lang.String searchString6;
	private java.lang.String searchString7;
	private java.lang.String searchString8;
	private java.lang.String searchString9;
	private java.lang.String searchString10;
	private java.lang.String searchString11;
	private java.lang.String searchString12;
	private java.lang.String searchString13;
	private java.lang.String searchString14;
	private java.lang.String searchString15;
	private java.lang.String searchString16;
	private java.lang.String searchString17;
	private java.lang.String searchString18;
	private java.lang.String searchString19;
	private java.lang.String searchString20;
	private java.lang.String searchString21;
	private java.lang.String searchString22;
	private java.lang.String searchString23;
	private java.lang.String searchString24;
	private java.lang.String searchString25;
	private java.lang.String searchString26;
	private java.lang.String searchString27;
	private java.lang.String searchString28;
	private java.lang.String searchString29;
	private java.lang.String searchString30;
	private java.lang.String g1codekey;
	private java.lang.String g2codekey;
	private java.lang.String g3codekey;
	private java.lang.String g4codekey;
	private java.lang.String orderBy;
	private java.lang.String orderByDesc;
	private java.lang.String orderBy2;
	private java.lang.String orderBy2Desc;
	private java.lang.String orderBy3;
	private java.lang.String orderBy3Desc;
	private java.lang.String searchDate1mm;
	private java.lang.String searchDate1dd;
	private java.lang.String searchDate1yyyy;
	private java.lang.String searchDate2mm;
	private java.lang.String searchDate2dd;
	private java.lang.String searchDate2yyyy;
	private java.lang.String breadCrumb;
	private java.lang.String searchDate3mm;
	private java.lang.String searchDate3dd;
	private java.lang.String searchDate3yyyy;
	private java.lang.String searchDate4mm;
	private java.lang.String searchDate4dd;
	private java.lang.String searchDate4yyyy;
	private java.lang.String companykey;
	private java.lang.String departmentkey;
	private java.lang.String activitykey;
	private java.lang.String systemloguserid;
	private java.util.Date systemlogdate;
	private java.lang.String systemlogtime;
	private java.lang.String systemlogprogram;
	private java.lang.String systemlogaction;
	private java.lang.String xlock;
	private java.util.Date createdate;
	private java.lang.String createtime;
	private java.lang.String createuserid;
	private java.lang.String maxResults;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="USERLISTFORM_ID"
     */
	public java.lang.Integer getUserlistformId () {
		return userlistformId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param userlistformId the new ID
	 */
	public void setUserlistformId (java.lang.Integer userlistformId) {
		this.userlistformId = userlistformId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: listform
	 */
	public java.lang.String getListform () {
		return listform;
	}

	/**
	 * Set the value related to the column: listform
	 * @param listform the listform value
	 */
	public void setListform (java.lang.String listform) {
		this.listform = listform;
	}



	/**
	 * Return the value associated with the column: headerInfo1
	 */
	public java.lang.String getHeaderInfo1 () {
		return headerInfo1;
	}

	/**
	 * Set the value related to the column: headerInfo1
	 * @param headerInfo1 the headerInfo1 value
	 */
	public void setHeaderInfo1 (java.lang.String headerInfo1) {
		this.headerInfo1 = headerInfo1;
	}



	/**
	 * Return the value associated with the column: headerInfo2
	 */
	public java.lang.String getHeaderInfo2 () {
		return headerInfo2;
	}

	/**
	 * Set the value related to the column: headerInfo2
	 * @param headerInfo2 the headerInfo2 value
	 */
	public void setHeaderInfo2 (java.lang.String headerInfo2) {
		this.headerInfo2 = headerInfo2;
	}



	/**
	 * Return the value associated with the column: headerInfo3
	 */
	public java.lang.String getHeaderInfo3 () {
		return headerInfo3;
	}

	/**
	 * Set the value related to the column: headerInfo3
	 * @param headerInfo3 the headerInfo3 value
	 */
	public void setHeaderInfo3 (java.lang.String headerInfo3) {
		this.headerInfo3 = headerInfo3;
	}



	/**
	 * Return the value associated with the column: headerInfo4
	 */
	public java.lang.String getHeaderInfo4 () {
		return headerInfo4;
	}

	/**
	 * Set the value related to the column: headerInfo4
	 * @param headerInfo4 the headerInfo4 value
	 */
	public void setHeaderInfo4 (java.lang.String headerInfo4) {
		this.headerInfo4 = headerInfo4;
	}



	/**
	 * Return the value associated with the column: headerInfo5
	 */
	public java.lang.String getHeaderInfo5 () {
		return headerInfo5;
	}

	/**
	 * Set the value related to the column: headerInfo5
	 * @param headerInfo5 the headerInfo5 value
	 */
	public void setHeaderInfo5 (java.lang.String headerInfo5) {
		this.headerInfo5 = headerInfo5;
	}



	/**
	 * Return the value associated with the column: headerInfo6
	 */
	public java.lang.String getHeaderInfo6 () {
		return headerInfo6;
	}

	/**
	 * Set the value related to the column: headerInfo6
	 * @param headerInfo6 the headerInfo6 value
	 */
	public void setHeaderInfo6 (java.lang.String headerInfo6) {
		this.headerInfo6 = headerInfo6;
	}



	/**
	 * Return the value associated with the column: headerInfo7
	 */
	public java.lang.String getHeaderInfo7 () {
		return headerInfo7;
	}

	/**
	 * Set the value related to the column: headerInfo7
	 * @param headerInfo7 the headerInfo7 value
	 */
	public void setHeaderInfo7 (java.lang.String headerInfo7) {
		this.headerInfo7 = headerInfo7;
	}



	/**
	 * Return the value associated with the column: headerInfo8
	 */
	public java.lang.String getHeaderInfo8 () {
		return headerInfo8;
	}

	/**
	 * Set the value related to the column: headerInfo8
	 * @param headerInfo8 the headerInfo8 value
	 */
	public void setHeaderInfo8 (java.lang.String headerInfo8) {
		this.headerInfo8 = headerInfo8;
	}



	/**
	 * Return the value associated with the column: headerInfo9
	 */
	public java.lang.String getHeaderInfo9 () {
		return headerInfo9;
	}

	/**
	 * Set the value related to the column: headerInfo9
	 * @param headerInfo9 the headerInfo9 value
	 */
	public void setHeaderInfo9 (java.lang.String headerInfo9) {
		this.headerInfo9 = headerInfo9;
	}



	/**
	 * Return the value associated with the column: headerInfo10
	 */
	public java.lang.String getHeaderInfo10 () {
		return headerInfo10;
	}

	/**
	 * Set the value related to the column: headerInfo10
	 * @param headerInfo10 the headerInfo10 value
	 */
	public void setHeaderInfo10 (java.lang.String headerInfo10) {
		this.headerInfo10 = headerInfo10;
	}



	/**
	 * Return the value associated with the column: headerInfo11
	 */
	public java.lang.String getHeaderInfo11 () {
		return headerInfo11;
	}

	/**
	 * Set the value related to the column: headerInfo11
	 * @param headerInfo11 the headerInfo11 value
	 */
	public void setHeaderInfo11 (java.lang.String headerInfo11) {
		this.headerInfo11 = headerInfo11;
	}



	/**
	 * Return the value associated with the column: headerInfo12
	 */
	public java.lang.String getHeaderInfo12 () {
		return headerInfo12;
	}

	/**
	 * Set the value related to the column: headerInfo12
	 * @param headerInfo12 the headerInfo12 value
	 */
	public void setHeaderInfo12 (java.lang.String headerInfo12) {
		this.headerInfo12 = headerInfo12;
	}



	/**
	 * Return the value associated with the column: headerInfo13
	 */
	public java.lang.String getHeaderInfo13 () {
		return headerInfo13;
	}

	/**
	 * Set the value related to the column: headerInfo13
	 * @param headerInfo13 the headerInfo13 value
	 */
	public void setHeaderInfo13 (java.lang.String headerInfo13) {
		this.headerInfo13 = headerInfo13;
	}



	/**
	 * Return the value associated with the column: headerInfo14
	 */
	public java.lang.String getHeaderInfo14 () {
		return headerInfo14;
	}

	/**
	 * Set the value related to the column: headerInfo14
	 * @param headerInfo14 the headerInfo14 value
	 */
	public void setHeaderInfo14 (java.lang.String headerInfo14) {
		this.headerInfo14 = headerInfo14;
	}



	/**
	 * Return the value associated with the column: headerInfo15
	 */
	public java.lang.String getHeaderInfo15 () {
		return headerInfo15;
	}

	/**
	 * Set the value related to the column: headerInfo15
	 * @param headerInfo15 the headerInfo15 value
	 */
	public void setHeaderInfo15 (java.lang.String headerInfo15) {
		this.headerInfo15 = headerInfo15;
	}



	/**
	 * Return the value associated with the column: searchString1
	 */
	public java.lang.String getSearchString1 () {
		return searchString1;
	}

	/**
	 * Set the value related to the column: searchString1
	 * @param searchString1 the searchString1 value
	 */
	public void setSearchString1 (java.lang.String searchString1) {
		this.searchString1 = searchString1;
	}



	/**
	 * Return the value associated with the column: searchString2
	 */
	public java.lang.String getSearchString2 () {
		return searchString2;
	}

	/**
	 * Set the value related to the column: searchString2
	 * @param searchString2 the searchString2 value
	 */
	public void setSearchString2 (java.lang.String searchString2) {
		this.searchString2 = searchString2;
	}



	/**
	 * Return the value associated with the column: searchString3
	 */
	public java.lang.String getSearchString3 () {
		return searchString3;
	}

	/**
	 * Set the value related to the column: searchString3
	 * @param searchString3 the searchString3 value
	 */
	public void setSearchString3 (java.lang.String searchString3) {
		this.searchString3 = searchString3;
	}



	/**
	 * Return the value associated with the column: searchString4
	 */
	public java.lang.String getSearchString4 () {
		return searchString4;
	}

	/**
	 * Set the value related to the column: searchString4
	 * @param searchString4 the searchString4 value
	 */
	public void setSearchString4 (java.lang.String searchString4) {
		this.searchString4 = searchString4;
	}



	/**
	 * Return the value associated with the column: searchString5
	 */
	public java.lang.String getSearchString5 () {
		return searchString5;
	}

	/**
	 * Set the value related to the column: searchString5
	 * @param searchString5 the searchString5 value
	 */
	public void setSearchString5 (java.lang.String searchString5) {
		this.searchString5 = searchString5;
	}



	/**
	 * Return the value associated with the column: searchString6
	 */
	public java.lang.String getSearchString6 () {
		return searchString6;
	}

	/**
	 * Set the value related to the column: searchString6
	 * @param searchString6 the searchString6 value
	 */
	public void setSearchString6 (java.lang.String searchString6) {
		this.searchString6 = searchString6;
	}



	/**
	 * Return the value associated with the column: searchString7
	 */
	public java.lang.String getSearchString7 () {
		return searchString7;
	}

	/**
	 * Set the value related to the column: searchString7
	 * @param searchString7 the searchString7 value
	 */
	public void setSearchString7 (java.lang.String searchString7) {
		this.searchString7 = searchString7;
	}



	/**
	 * Return the value associated with the column: searchString8
	 */
	public java.lang.String getSearchString8 () {
		return searchString8;
	}

	/**
	 * Set the value related to the column: searchString8
	 * @param searchString8 the searchString8 value
	 */
	public void setSearchString8 (java.lang.String searchString8) {
		this.searchString8 = searchString8;
	}



	/**
	 * Return the value associated with the column: searchString9
	 */
	public java.lang.String getSearchString9 () {
		return searchString9;
	}

	/**
	 * Set the value related to the column: searchString9
	 * @param searchString9 the searchString9 value
	 */
	public void setSearchString9 (java.lang.String searchString9) {
		this.searchString9 = searchString9;
	}



	/**
	 * Return the value associated with the column: searchString10
	 */
	public java.lang.String getSearchString10 () {
		return searchString10;
	}

	/**
	 * Set the value related to the column: searchString10
	 * @param searchString10 the searchString10 value
	 */
	public void setSearchString10 (java.lang.String searchString10) {
		this.searchString10 = searchString10;
	}



	/**
	 * Return the value associated with the column: searchString11
	 */
	public java.lang.String getSearchString11 () {
		return searchString11;
	}

	/**
	 * Set the value related to the column: searchString11
	 * @param searchString11 the searchString11 value
	 */
	public void setSearchString11 (java.lang.String searchString11) {
		this.searchString11 = searchString11;
	}



	/**
	 * Return the value associated with the column: searchString12
	 */
	public java.lang.String getSearchString12 () {
		return searchString12;
	}

	/**
	 * Set the value related to the column: searchString12
	 * @param searchString12 the searchString12 value
	 */
	public void setSearchString12 (java.lang.String searchString12) {
		this.searchString12 = searchString12;
	}



	/**
	 * Return the value associated with the column: searchString13
	 */
	public java.lang.String getSearchString13 () {
		return searchString13;
	}

	/**
	 * Set the value related to the column: searchString13
	 * @param searchString13 the searchString13 value
	 */
	public void setSearchString13 (java.lang.String searchString13) {
		this.searchString13 = searchString13;
	}



	/**
	 * Return the value associated with the column: searchString14
	 */
	public java.lang.String getSearchString14 () {
		return searchString14;
	}

	/**
	 * Set the value related to the column: searchString14
	 * @param searchString14 the searchString14 value
	 */
	public void setSearchString14 (java.lang.String searchString14) {
		this.searchString14 = searchString14;
	}



	/**
	 * Return the value associated with the column: searchString15
	 */
	public java.lang.String getSearchString15 () {
		return searchString15;
	}

	/**
	 * Set the value related to the column: searchString15
	 * @param searchString15 the searchString15 value
	 */
	public void setSearchString15 (java.lang.String searchString15) {
		this.searchString15 = searchString15;
	}



	/**
	 * Return the value associated with the column: searchString16
	 */
	public java.lang.String getSearchString16 () {
		return searchString16;
	}

	/**
	 * Set the value related to the column: searchString16
	 * @param searchString16 the searchString16 value
	 */
	public void setSearchString16 (java.lang.String searchString16) {
		this.searchString16 = searchString16;
	}



	/**
	 * Return the value associated with the column: searchString17
	 */
	public java.lang.String getSearchString17 () {
		return searchString17;
	}

	/**
	 * Set the value related to the column: searchString17
	 * @param searchString17 the searchString17 value
	 */
	public void setSearchString17 (java.lang.String searchString17) {
		this.searchString17 = searchString17;
	}



	/**
	 * Return the value associated with the column: searchString18
	 */
	public java.lang.String getSearchString18 () {
		return searchString18;
	}

	/**
	 * Set the value related to the column: searchString18
	 * @param searchString18 the searchString18 value
	 */
	public void setSearchString18 (java.lang.String searchString18) {
		this.searchString18 = searchString18;
	}



	/**
	 * Return the value associated with the column: searchString19
	 */
	public java.lang.String getSearchString19 () {
		return searchString19;
	}

	/**
	 * Set the value related to the column: searchString19
	 * @param searchString19 the searchString19 value
	 */
	public void setSearchString19 (java.lang.String searchString19) {
		this.searchString19 = searchString19;
	}



	/**
	 * Return the value associated with the column: searchString20
	 */
	public java.lang.String getSearchString20 () {
		return searchString20;
	}

	/**
	 * Set the value related to the column: searchString20
	 * @param searchString20 the searchString20 value
	 */
	public void setSearchString20 (java.lang.String searchString20) {
		this.searchString20 = searchString20;
	}



	/**
	 * Return the value associated with the column: searchString21
	 */
	public java.lang.String getSearchString21 () {
		return searchString21;
	}

	/**
	 * Set the value related to the column: searchString21
	 * @param searchString21 the searchString21 value
	 */
	public void setSearchString21 (java.lang.String searchString21) {
		this.searchString21 = searchString21;
	}



	/**
	 * Return the value associated with the column: searchString22
	 */
	public java.lang.String getSearchString22 () {
		return searchString22;
	}

	/**
	 * Set the value related to the column: searchString22
	 * @param searchString22 the searchString22 value
	 */
	public void setSearchString22 (java.lang.String searchString22) {
		this.searchString22 = searchString22;
	}



	/**
	 * Return the value associated with the column: searchString23
	 */
	public java.lang.String getSearchString23 () {
		return searchString23;
	}

	/**
	 * Set the value related to the column: searchString23
	 * @param searchString23 the searchString23 value
	 */
	public void setSearchString23 (java.lang.String searchString23) {
		this.searchString23 = searchString23;
	}



	/**
	 * Return the value associated with the column: searchString24
	 */
	public java.lang.String getSearchString24 () {
		return searchString24;
	}

	/**
	 * Set the value related to the column: searchString24
	 * @param searchString24 the searchString24 value
	 */
	public void setSearchString24 (java.lang.String searchString24) {
		this.searchString24 = searchString24;
	}



	/**
	 * Return the value associated with the column: searchString25
	 */
	public java.lang.String getSearchString25 () {
		return searchString25;
	}

	/**
	 * Set the value related to the column: searchString25
	 * @param searchString25 the searchString25 value
	 */
	public void setSearchString25 (java.lang.String searchString25) {
		this.searchString25 = searchString25;
	}



	/**
	 * Return the value associated with the column: searchString26
	 */
	public java.lang.String getSearchString26 () {
		return searchString26;
	}

	/**
	 * Set the value related to the column: searchString26
	 * @param searchString26 the searchString26 value
	 */
	public void setSearchString26 (java.lang.String searchString26) {
		this.searchString26 = searchString26;
	}



	/**
	 * Return the value associated with the column: searchString27
	 */
	public java.lang.String getSearchString27 () {
		return searchString27;
	}

	/**
	 * Set the value related to the column: searchString27
	 * @param searchString27 the searchString27 value
	 */
	public void setSearchString27 (java.lang.String searchString27) {
		this.searchString27 = searchString27;
	}



	/**
	 * Return the value associated with the column: searchString28
	 */
	public java.lang.String getSearchString28 () {
		return searchString28;
	}

	/**
	 * Set the value related to the column: searchString28
	 * @param searchString28 the searchString28 value
	 */
	public void setSearchString28 (java.lang.String searchString28) {
		this.searchString28 = searchString28;
	}



	/**
	 * Return the value associated with the column: searchString29
	 */
	public java.lang.String getSearchString29 () {
		return searchString29;
	}

	/**
	 * Set the value related to the column: searchString29
	 * @param searchString29 the searchString29 value
	 */
	public void setSearchString29 (java.lang.String searchString29) {
		this.searchString29 = searchString29;
	}



	/**
	 * Return the value associated with the column: searchString30
	 */
	public java.lang.String getSearchString30 () {
		return searchString30;
	}

	/**
	 * Set the value related to the column: searchString30
	 * @param searchString30 the searchString30 value
	 */
	public void setSearchString30 (java.lang.String searchString30) {
		this.searchString30 = searchString30;
	}



	/**
	 * Return the value associated with the column: g1codekey
	 */
	public java.lang.String getG1codekey () {
		return g1codekey;
	}

	/**
	 * Set the value related to the column: g1codekey
	 * @param g1codekey the g1codekey value
	 */
	public void setG1codekey (java.lang.String g1codekey) {
		this.g1codekey = g1codekey;
	}



	/**
	 * Return the value associated with the column: g2codekey
	 */
	public java.lang.String getG2codekey () {
		return g2codekey;
	}

	/**
	 * Set the value related to the column: g2codekey
	 * @param g2codekey the g2codekey value
	 */
	public void setG2codekey (java.lang.String g2codekey) {
		this.g2codekey = g2codekey;
	}



	/**
	 * Return the value associated with the column: g3codekey
	 */
	public java.lang.String getG3codekey () {
		return g3codekey;
	}

	/**
	 * Set the value related to the column: g3codekey
	 * @param g3codekey the g3codekey value
	 */
	public void setG3codekey (java.lang.String g3codekey) {
		this.g3codekey = g3codekey;
	}



	/**
	 * Return the value associated with the column: g4codekey
	 */
	public java.lang.String getG4codekey () {
		return g4codekey;
	}

	/**
	 * Set the value related to the column: g4codekey
	 * @param g4codekey the g4codekey value
	 */
	public void setG4codekey (java.lang.String g4codekey) {
		this.g4codekey = g4codekey;
	}



	/**
	 * Return the value associated with the column: orderBy
	 */
	public java.lang.String getOrderBy () {
		return orderBy;
	}

	/**
	 * Set the value related to the column: orderBy
	 * @param orderBy the orderBy value
	 */
	public void setOrderBy (java.lang.String orderBy) {
		this.orderBy = orderBy;
	}



	/**
	 * Return the value associated with the column: orderByDesc
	 */
	public java.lang.String getOrderByDesc () {
		return orderByDesc;
	}

	/**
	 * Set the value related to the column: orderByDesc
	 * @param orderByDesc the orderByDesc value
	 */
	public void setOrderByDesc (java.lang.String orderByDesc) {
		this.orderByDesc = orderByDesc;
	}



	/**
	 * Return the value associated with the column: orderBy2
	 */
	public java.lang.String getOrderBy2 () {
		return orderBy2;
	}

	/**
	 * Set the value related to the column: orderBy2
	 * @param orderBy2 the orderBy2 value
	 */
	public void setOrderBy2 (java.lang.String orderBy2) {
		this.orderBy2 = orderBy2;
	}



	/**
	 * Return the value associated with the column: orderBy2Desc
	 */
	public java.lang.String getOrderBy2Desc () {
		return orderBy2Desc;
	}

	/**
	 * Set the value related to the column: orderBy2Desc
	 * @param orderBy2Desc the orderBy2Desc value
	 */
	public void setOrderBy2Desc (java.lang.String orderBy2Desc) {
		this.orderBy2Desc = orderBy2Desc;
	}



	/**
	 * Return the value associated with the column: orderBy3
	 */
	public java.lang.String getOrderBy3 () {
		return orderBy3;
	}

	/**
	 * Set the value related to the column: orderBy3
	 * @param orderBy3 the orderBy3 value
	 */
	public void setOrderBy3 (java.lang.String orderBy3) {
		this.orderBy3 = orderBy3;
	}



	/**
	 * Return the value associated with the column: orderBy3Desc
	 */
	public java.lang.String getOrderBy3Desc () {
		return orderBy3Desc;
	}

	/**
	 * Set the value related to the column: orderBy3Desc
	 * @param orderBy3Desc the orderBy3Desc value
	 */
	public void setOrderBy3Desc (java.lang.String orderBy3Desc) {
		this.orderBy3Desc = orderBy3Desc;
	}



	/**
	 * Return the value associated with the column: searchDate1mm
	 */
	public java.lang.String getSearchDate1mm () {
		return searchDate1mm;
	}

	/**
	 * Set the value related to the column: searchDate1mm
	 * @param searchDate1mm the searchDate1mm value
	 */
	public void setSearchDate1mm (java.lang.String searchDate1mm) {
		this.searchDate1mm = searchDate1mm;
	}



	/**
	 * Return the value associated with the column: searchDate1dd
	 */
	public java.lang.String getSearchDate1dd () {
		return searchDate1dd;
	}

	/**
	 * Set the value related to the column: searchDate1dd
	 * @param searchDate1dd the searchDate1dd value
	 */
	public void setSearchDate1dd (java.lang.String searchDate1dd) {
		this.searchDate1dd = searchDate1dd;
	}



	/**
	 * Return the value associated with the column: searchDate1yyyy
	 */
	public java.lang.String getSearchDate1yyyy () {
		return searchDate1yyyy;
	}

	/**
	 * Set the value related to the column: searchDate1yyyy
	 * @param searchDate1yyyy the searchDate1yyyy value
	 */
	public void setSearchDate1yyyy (java.lang.String searchDate1yyyy) {
		this.searchDate1yyyy = searchDate1yyyy;
	}



	/**
	 * Return the value associated with the column: searchDate2mm
	 */
	public java.lang.String getSearchDate2mm () {
		return searchDate2mm;
	}

	/**
	 * Set the value related to the column: searchDate2mm
	 * @param searchDate2mm the searchDate2mm value
	 */
	public void setSearchDate2mm (java.lang.String searchDate2mm) {
		this.searchDate2mm = searchDate2mm;
	}



	/**
	 * Return the value associated with the column: searchDate2dd
	 */
	public java.lang.String getSearchDate2dd () {
		return searchDate2dd;
	}

	/**
	 * Set the value related to the column: searchDate2dd
	 * @param searchDate2dd the searchDate2dd value
	 */
	public void setSearchDate2dd (java.lang.String searchDate2dd) {
		this.searchDate2dd = searchDate2dd;
	}



	/**
	 * Return the value associated with the column: searchDate2yyyy
	 */
	public java.lang.String getSearchDate2yyyy () {
		return searchDate2yyyy;
	}

	/**
	 * Set the value related to the column: searchDate2yyyy
	 * @param searchDate2yyyy the searchDate2yyyy value
	 */
	public void setSearchDate2yyyy (java.lang.String searchDate2yyyy) {
		this.searchDate2yyyy = searchDate2yyyy;
	}



	/**
	 * Return the value associated with the column: breadCrumb
	 */
	public java.lang.String getBreadCrumb () {
		return breadCrumb;
	}

	/**
	 * Set the value related to the column: breadCrumb
	 * @param breadCrumb the breadCrumb value
	 */
	public void setBreadCrumb (java.lang.String breadCrumb) {
		this.breadCrumb = breadCrumb;
	}



	/**
	 * Return the value associated with the column: searchDate3mm
	 */
	public java.lang.String getSearchDate3mm () {
		return searchDate3mm;
	}

	/**
	 * Set the value related to the column: searchDate3mm
	 * @param searchDate3mm the searchDate3mm value
	 */
	public void setSearchDate3mm (java.lang.String searchDate3mm) {
		this.searchDate3mm = searchDate3mm;
	}



	/**
	 * Return the value associated with the column: searchDate3dd
	 */
	public java.lang.String getSearchDate3dd () {
		return searchDate3dd;
	}

	/**
	 * Set the value related to the column: searchDate3dd
	 * @param searchDate3dd the searchDate3dd value
	 */
	public void setSearchDate3dd (java.lang.String searchDate3dd) {
		this.searchDate3dd = searchDate3dd;
	}



	/**
	 * Return the value associated with the column: searchDate3yyyy
	 */
	public java.lang.String getSearchDate3yyyy () {
		return searchDate3yyyy;
	}

	/**
	 * Set the value related to the column: searchDate3yyyy
	 * @param searchDate3yyyy the searchDate3yyyy value
	 */
	public void setSearchDate3yyyy (java.lang.String searchDate3yyyy) {
		this.searchDate3yyyy = searchDate3yyyy;
	}



	/**
	 * Return the value associated with the column: searchDate4mm
	 */
	public java.lang.String getSearchDate4mm () {
		return searchDate4mm;
	}

	/**
	 * Set the value related to the column: searchDate4mm
	 * @param searchDate4mm the searchDate4mm value
	 */
	public void setSearchDate4mm (java.lang.String searchDate4mm) {
		this.searchDate4mm = searchDate4mm;
	}



	/**
	 * Return the value associated with the column: searchDate4dd
	 */
	public java.lang.String getSearchDate4dd () {
		return searchDate4dd;
	}

	/**
	 * Set the value related to the column: searchDate4dd
	 * @param searchDate4dd the searchDate4dd value
	 */
	public void setSearchDate4dd (java.lang.String searchDate4dd) {
		this.searchDate4dd = searchDate4dd;
	}



	/**
	 * Return the value associated with the column: searchDate4yyyy
	 */
	public java.lang.String getSearchDate4yyyy () {
		return searchDate4yyyy;
	}

	/**
	 * Set the value related to the column: searchDate4yyyy
	 * @param searchDate4yyyy the searchDate4yyyy value
	 */
	public void setSearchDate4yyyy (java.lang.String searchDate4yyyy) {
		this.searchDate4yyyy = searchDate4yyyy;
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
	 * Return the value associated with the column: systemloguserid
	 */
	public java.lang.String getSystemloguserid () {
		return systemloguserid;
	}

	/**
	 * Set the value related to the column: systemloguserid
	 * @param systemloguserid the systemloguserid value
	 */
	public void setSystemloguserid (java.lang.String systemloguserid) {
		this.systemloguserid = systemloguserid;
	}



	/**
	 * Return the value associated with the column: systemlogdate
	 */
	public java.util.Date getSystemlogdate () {
		return systemlogdate;
	}

	/**
	 * Set the value related to the column: systemlogdate
	 * @param systemlogdate the systemlogdate value
	 */
	public void setSystemlogdate (java.util.Date systemlogdate) {
		this.systemlogdate = systemlogdate;
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
	 * Return the value associated with the column: systemlogprogram
	 */
	public java.lang.String getSystemlogprogram () {
		return systemlogprogram;
	}

	/**
	 * Set the value related to the column: systemlogprogram
	 * @param systemlogprogram the systemlogprogram value
	 */
	public void setSystemlogprogram (java.lang.String systemlogprogram) {
		this.systemlogprogram = systemlogprogram;
	}



	/**
	 * Return the value associated with the column: systemlogaction
	 */
	public java.lang.String getSystemlogaction () {
		return systemlogaction;
	}

	/**
	 * Set the value related to the column: systemlogaction
	 * @param systemlogaction the systemlogaction value
	 */
	public void setSystemlogaction (java.lang.String systemlogaction) {
		this.systemlogaction = systemlogaction;
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
	 * Return the value associated with the column: maxResults
	 */
	public java.lang.String getMaxResults () {
		return maxResults;
	}

	/**
	 * Set the value related to the column: maxResults
	 * @param maxResults the maxResults value
	 */
	public void setMaxResults (java.lang.String maxResults) {
		this.maxResults = maxResults;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.bureaueye.beacon.model.standard.Userlistform)) return false;
		else {
			com.bureaueye.beacon.model.standard.Userlistform userlistform = (com.bureaueye.beacon.model.standard.Userlistform) obj;
			if (null == this.getUserlistformId() || null == userlistform.getUserlistformId()) return false;
			else return (this.getUserlistformId().equals(userlistform.getUserlistformId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getUserlistformId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getUserlistformId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}
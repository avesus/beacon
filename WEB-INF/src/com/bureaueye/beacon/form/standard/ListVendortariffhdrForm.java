package com.bureaueye.beacon.form.standard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO;

public class ListVendortariffhdrForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String action;

	private List list;

	private int[] selectedObjects;

	private String id;

	private Object header;

	
	private String searchString1;
	private String searchString2;
	private String searchString3;
	private String searchString4;
	private String searchString5;
	private String searchString6;
	private String searchString7;
	private String searchString8;
	private String searchString9;
	private String searchString10;
	private String searchString11;
	private String searchString12;
	private String searchString13;
	private String searchString14;
	private String searchString15;	
	private String searchString16;
	private String searchString17;
	private String searchString18;
	private String searchString19;
	private String searchString20;
	private String searchString21;
	private String searchString22;
	private String searchString23;
	private String searchString24;
	private String searchString25;	
	private String searchString26;
	private String searchString27;
	private String searchString28;
	private String searchString29;
	private String searchString30;
	
	
	private int maxResults = 0;
	private int totalResults;
	private String orderBy;
	private String orderByDesc;
	
	private String searchDate1mm;
	private String searchDate1dd;
	private String searchDate1yyyy;
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Object getHeader() {
		return header;
	}

	public void setHeader(Object header) {
		this.header = header;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSelectedObjects(int[] selectedObjects) {
		this.selectedObjects = selectedObjects;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int[] getSelectedObjects() {
		return selectedObjects;
	}

	public VendortariffhdrDTO getVendortariffhdrDTO(int i) {
		if (getList() == null) {
			setList(new ArrayList());
		}

		while (getList().size() <= i) {
			getList().add(new VendortariffhdrDTO());
		}

		return (VendortariffhdrDTO) getList().get(i);
	}

	
	
	public String getSearchString1() {		
		return searchString1;
	}

	public void setSearchString1(String searchString1) {	
		this.searchString1 = searchString1;
	}

	public String getSearchString2() {
		return searchString2;
	}

	public void setSearchString2(String searchString2) {
		this.searchString2 = searchString2;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderByDesc() {
		return orderByDesc;
	}

	public void setOrderByDesc(String orderByDesc) {
		this.orderByDesc = orderByDesc;
	}
	
	

	public String getSearchString3() {
		return searchString3;
	}

	public void setSearchString3(String searchString3) {
		this.searchString3 = searchString3;
	}

	public String getSearchString4() {
		return searchString4;
	}

	public void setSearchString4(String searchString4) {
		this.searchString4 = searchString4;
	}

	public String getSearchString5() {
		return searchString5;
	}

	public void setSearchString5(String searchString5) {
		this.searchString5 = searchString5;
	}

	public String getSearchString6() {
		return searchString6;
	}

	public void setSearchString6(String searchString6) {
		this.searchString6 = searchString6;
	}

	public String getSearchString7() {
		return searchString7;
	}

	public void setSearchString7(String searchString7) {
		this.searchString7 = searchString7;
	}

	public String getSearchString8() {
		return searchString8;
	}

	public void setSearchString8(String searchString8) {
		this.searchString8 = searchString8;
	}

	public String getSearchString9() {		return searchString9;	}
	public void setSearchString9(String searchString9) {		this.searchString9 = searchString9;	}
	

	
	public String getSearchString10() {	return searchString10;	}
	public void setSearchString10(String searchString10) {		this.searchString10 = searchString10;	}
	
	public String getSearchString11() {		return searchString11;}
	public void setSearchString11(String searchString11) {		this.searchString11 = searchString11;	}

	public String getSearchString12() {		return searchString12;	}
	public void setSearchString12(String searchString12) {	this.searchString12 = searchString12;	}

	public String getSearchString13() {	return searchString13;}
	public void setSearchString13(String searchString13) {	this.searchString13 = searchString13;}

	public String getSearchString14() {	return searchString14;}
	public void setSearchString14(String searchString14) {	this.searchString14 = searchString14;}

	public String getSearchString15() {	return searchString15; }
	public void setSearchString15(String searchString15) {	this.searchString15 = searchString15;}

	public String getSearchString16() {	return searchString16;	}
	public void setSearchString16(String searchString16) {		this.searchString16 = searchString16;	}
	
	public String getSearchString17() {		return searchString17;}
	public void setSearchString17(String searchString17) {		this.searchString17 = searchString17;	}

	public String getSearchString18() {		return searchString18;	}
	public void setSearchString18(String searchString18) {	this.searchString18 = searchString18;	}

	public String getSearchString19() {	return searchString19;}
	public void setSearchString19(String searchString19) {	this.searchString19 = searchString19;}


	public String getSearchString20() {	return searchString20;	}
	public void setSearchString20(String searchString20) {		this.searchString20 = searchString20;	}
	
	public String getSearchString21() {		return searchString21;}
	public void setSearchString21(String searchString21) {		this.searchString21 = searchString21;	}

	public String getSearchString22() {		return searchString22;	}
	public void setSearchString22(String searchString22) {	this.searchString22 = searchString22;	}

	public String getSearchString23() {	return searchString23;}
	public void setSearchString23(String searchString23) {	this.searchString23 = searchString23;}

	public String getSearchString24() {	return searchString24;}
	public void setSearchString24(String searchString24) {	this.searchString24 = searchString24;}

	public String getSearchString25() {	return searchString25; }
	public void setSearchString25(String searchString25) {	this.searchString25 = searchString25;}

	public String getSearchString26() {	return searchString26;	}
	public void setSearchString26(String searchString26) {		this.searchString26 = searchString26;	}
	
	public String getSearchString27() {		return searchString27;}
	public void setSearchString27(String searchString27) {		this.searchString27 = searchString27;	}

	public String getSearchString28() {		return searchString28;	}
	public void setSearchString28(String searchString28) {	this.searchString28 = searchString28;	}

	public String getSearchString29() {	return searchString29;}
	public void setSearchString29(String searchString29) {	this.searchString29 = searchString29;}
	
	public String getSearchString30() {	return searchString30;}
	public void setSearchString30(String searchString30) {	this.searchString30 = searchString30;}
	
	
	
	public Date getSearchDate1() {
		Calendar c = Calendar.getInstance();
		try {
			c.set(Integer.parseInt(getSearchDate1yyyy()), Integer
					.parseInt(getSearchDate1mm()) - 1, Integer
					.parseInt(getSearchDate1dd()));
		} catch (Exception e) {
			return null;
		}

		return c.getTime();
	}
	public void setSearchDate1(Date searchDate1) {
		Calendar c = Calendar.getInstance();
		c.setTime(searchDate1);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSearchDate1yyyy(c.get(Calendar.YEAR) + "");
		setSearchDate1mm((month < 10 ? "0" : "") + month);
		setSearchDate1dd((day < 10 ? "0" : "") + day);
	}

	public String getSearchDate1mm() {
		return searchDate1mm;
	}

	public void setSearchDate1mm(String searchDate1mm) {
		this.searchDate1mm = searchDate1mm;
	}

	public String getSearchDate1dd() {
		return searchDate1dd;
	}

	public void setSearchDate1dd(String searchDate1dd) {
		this.searchDate1dd = searchDate1dd;
	}

	public String getSearchDate1yyyy() {
		return searchDate1yyyy;
	}

	public void setSearchDate1yyyy(String searchDate1yyyy) {
		this.searchDate1yyyy = searchDate1yyyy;
	}
	
	
}

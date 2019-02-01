package com.bureaueye.beacondms.form.dms;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.bean.Breadcrumb;
import com.bureaueye.beacon.bean.Constants;

public class ListTrackForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List lineItems;

	private List lineItems2;	
	
	
	// multiple update
	private int[] _selectedObjects;
	private String _button;
	
	private String action;
	
	private String id;

	private String headerInfo1;

	private String headerInfo2;

	private String headerInfo3;

	private String headerInfo4;

	private String headerInfo5;

	private String headerInfo6;

	private String headerInfo7;

	private String headerInfo8;

	private String headerInfo9;

	private String headerInfo10;

	private String headerInfo11;

	private String headerInfo12;
	
	private String headerInfo13;
	
	private String headerInfo14;
	
	private String headerInfo15;
	
	
	
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

	private int maxResults;

	private int totalResults;

	private String orderBy;

	private String orderByDesc;

	private String orderBy2;

	private String orderBy2Desc;

	private String orderBy3;

	private String orderBy3Desc;

	private String searchDate1mm;

	private String searchDate1dd;

	private String searchDate1yyyy;

	private String searchDate2mm;

	private String searchDate2dd;

	private String searchDate2yyyy;


	private String breadCrumb;
	
	
	private String searchDate3mm;
	private String searchDate3dd;
	private String searchDate3yyyy;	
	private String searchDate4mm;
	private String searchDate4dd;
	private String searchDate4yyyy;	
	
	private int gotoPage;

	private boolean firstPage;

	private boolean lastPage;

	
	
	
	
	// mail fields
	private java.lang.String mailfrom;
	private java.lang.String mailcc;
	private java.lang.String mailto;
	private java.lang.String mailbcc;
	private java.lang.String mailsubject;
	private java.lang.String mailtext;
	
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {		
		this.id = id;
	}

	
	
	
	
	public String getAction() {return action;}
	public void setAction(String action) {this.action = action;}
	
	
	public int getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(int gotoPage) {
		this.gotoPage = gotoPage;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
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

	public List getLineItems() {
		return lineItems;
	}

	public void setLineItems(List lineItems) {
		this.lineItems = lineItems;
	}

	
	
	public List getLineItems2() {
		return lineItems2;
	}

	public void setLineItems2(List lineItems2) {
		this.lineItems2 = lineItems2;
	}
	
	
	
	public void setPreviousPage() {
		gotoPage--;
	}

	public void setNextPage() {
		gotoPage++;
	}

	public void setStartPage() {
		gotoPage = 0;
	}

	public void setEndPage() {
		gotoPage = (totalResults - 1) / maxResults;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		firstPage = false;
		lastPage = false;
		maxResults = Constants.MAX_RESULTS;
	}

	public String getHeaderInfo1() {
		return headerInfo1;
	}

	public void setHeaderInfo1(String headerInfo1) {
		this.headerInfo1 = headerInfo1;
	}

	public String getHeaderInfo2() {
		return headerInfo2;
	}

	public void setHeaderInfo2(String headerInfo2) {
		this.headerInfo2 = headerInfo2;
	}

	public String getHeaderInfo3() {
		return headerInfo3;
	}

	public void setHeaderInfo3(String headerInfo3) {
		this.headerInfo3 = headerInfo3;
	}

	public String getHeaderInfo4() {
		return headerInfo4;
	}

	public void setHeaderInfo4(String headerInfo4) {
		this.headerInfo4 = headerInfo4;
	}

	public String getHeaderInfo5() {
		return headerInfo5;
	}

	public void setHeaderInfo5(String headerInfo5) {
		this.headerInfo5 = headerInfo5;
	}

	public String getHeaderInfo6() {
		return headerInfo6;
	}

	public void setHeaderInfo6(String headerInfo6) {
		this.headerInfo6 = headerInfo6;
	}

	public String getHeaderInfo7() {
		return headerInfo7;
	}

	public void setHeaderInfo7(String headerInfo7) {
		this.headerInfo7 = headerInfo7;
	}

	public String getHeaderInfo8() {
		return headerInfo8;
	}

	public void setHeaderInfo8(String headerInfo8) {
		this.headerInfo8 = headerInfo8;
	}

	public String getHeaderInfo9() {
		return headerInfo9;
	}

	public void setHeaderInfo9(String headerInfo9) {
		this.headerInfo9 = headerInfo9;
	}

	public String getHeaderInfo10() {
		return headerInfo10;
	}

	public void setHeaderInfo10(String headerInfo10) {
		this.headerInfo10 = headerInfo10;
	}

	public String getHeaderInfo11() {
		return headerInfo11;
	}

	public void setHeaderInfo11(String headerInfo11) {
		this.headerInfo11 = headerInfo11;
	}

	
	public String getHeaderInfo12() {return headerInfo12;}
	public void setHeaderInfo12(String headerInfo12) {this.headerInfo12 = headerInfo12;}
	
	public String getHeaderInfo13() {return headerInfo13;}
	public void setHeaderInfo13(String headerInfo13) {this.headerInfo13 = headerInfo13;}
	
	public String getHeaderInfo14() {return headerInfo14;}
	public void setHeaderInfo14(String headerInfo14) {this.headerInfo14 = headerInfo14;}
	
	public String getHeaderInfo15() {return headerInfo15;}
	public void setHeaderInfo15(String headerInfo15) {this.headerInfo15 = headerInfo15;}
	
	
	
	
	
	public String getSearchString10() {
		return searchString10;
	}

	public void setSearchString10(String searchString10) {
		this.searchString10 = searchString10;
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

	public String getSearchString9() {
		return searchString9;
	}

	public void setSearchString9(String searchString9) {
		this.searchString9 = searchString9;
	}

	public String getSearchString11() {
		return searchString11;
	}

	public void setSearchString11(String searchString11) {
		this.searchString11 = searchString11;
	}

	public String getSearchString12() {
		return searchString12;
	}

	public void setSearchString12(String searchString12) {
		this.searchString12 = searchString12;
	}

	public String getSearchString13() {
		return searchString13;
	}

	public void setSearchString13(String searchString13) {
		this.searchString13 = searchString13;
	}

	public String getSearchString14() {
		return searchString14;
	}

	public void setSearchString14(String searchString14) {
		this.searchString14 = searchString14;
	}

	public String getSearchString15() {
		return searchString15;
	}

	public void setSearchString15(String searchString15) {
		this.searchString15 = searchString15;
	}

	public String getOrderBy2() {
		return orderBy2;
	}

	public void setOrderBy2(String orderBy2) {
		this.orderBy2 = orderBy2;
	}

	public String getOrderBy2Desc() {
		return orderBy2Desc;
	}

	public void setOrderBy2Desc(String orderBy2Desc) {
		this.orderBy2Desc = orderBy2Desc;
	}

	public String getOrderBy3() {
		return orderBy3;
	}

	public void setOrderBy3(String orderBy3) {
		this.orderBy3 = orderBy3;
	}

	public String getOrderBy3Desc() {
		return orderBy3Desc;
	}

	public void setOrderBy3Desc(String orderBy3Desc) {
		this.orderBy3Desc = orderBy3Desc;
	}

	public String getOrderByDesc() {
		return orderByDesc;
	}

	public void setOrderByDesc(String orderByDesc) {
		this.orderByDesc = orderByDesc;
	}

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

	public Date getSearchDate2() {
		Calendar c = Calendar.getInstance();
		try {
			c.set(Integer.parseInt(getSearchDate2yyyy()), Integer
					.parseInt(getSearchDate2mm()) - 1, Integer
					.parseInt(getSearchDate2dd()));
		} catch (Exception e) {
			return null;
		}
		return c.getTime();
	}

	public void setSearchDate2(Date searchDate2) {
		Calendar c = Calendar.getInstance();
		c.setTime(searchDate2);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSearchDate2yyyy(c.get(Calendar.YEAR) + "");
		setSearchDate2mm((month < 10 ? "0" : "") + month);
		setSearchDate2dd((day < 10 ? "0" : "") + day);
	}

	public String getSearchDate2mm() {
		return searchDate2mm;
	}

	public void setSearchDate2mm(String searchDate2mm) {
		this.searchDate2mm = searchDate2mm;
	}

	public String getSearchDate2dd() {
		return searchDate2dd;
	}

	public void setSearchDate2dd(String searchDate2dd) {
		this.searchDate2dd = searchDate2dd;
	}

	public String getSearchDate2yyyy() {
		return searchDate2yyyy;
	}

	public void setSearchDate2yyyy(String searchDate2yyyy) {
		this.searchDate2yyyy = searchDate2yyyy;
	}

	public Date getSearchDate3() {
		Calendar c = Calendar.getInstance();
		try {
		c.set(Integer.parseInt(getSearchDate3yyyy()), Integer
				.parseInt(getSearchDate3mm())-1, Integer.parseInt(getSearchDate3dd()));
		} catch (Exception e) {
			return null;
		}		
		return c.getTime();
	}
	public void setSearchDate3(Date searchDate3) {
		Calendar c = Calendar.getInstance();
		c.setTime(searchDate3);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSearchDate3yyyy(c.get(Calendar.YEAR) + "");
		setSearchDate3mm((month < 10 ? "0" : "") + month);
		setSearchDate3dd((day < 10 ? "0" : "") + day);
	}
	public String getSearchDate3mm() {return searchDate3mm;}
	public void setSearchDate3mm(String searchDate3mm) {this.searchDate3mm = searchDate3mm;}
	public String getSearchDate3dd() {return searchDate3dd;}
	public void setSearchDate3dd(String searchDate3dd) {this.searchDate3dd = searchDate3dd;}
	public String getSearchDate3yyyy() {return searchDate3yyyy;}
	public void setSearchDate3yyyy(String searchDate3yyyy) {this.searchDate3yyyy = searchDate3yyyy;}

	
	public Date getSearchDate4() {
		Calendar c = Calendar.getInstance();
		try {
		c.set(Integer.parseInt(getSearchDate4yyyy()), Integer
				.parseInt(getSearchDate4mm())-1, Integer.parseInt(getSearchDate4dd()));
		} catch (Exception e) {
			return null;
		}		
		return c.getTime();
	}
	public void setSearchDate4(Date searchDate4) {
		Calendar c = Calendar.getInstance();
		c.setTime(searchDate4);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		setSearchDate4yyyy(c.get(Calendar.YEAR) + "");
		setSearchDate4mm((month < 10 ? "0" : "") + month);
		setSearchDate4dd((day < 10 ? "0" : "") + day);
	}
	public String getSearchDate4mm() {return searchDate4mm;}
	public void setSearchDate4mm(String searchDate4mm) {this.searchDate4mm = searchDate4mm;}
	public String getSearchDate4dd() {return searchDate4dd;}
	public void setSearchDate4dd(String searchDate4dd) {this.searchDate4dd = searchDate4dd;}
	public String getSearchDate4yyyy() {return searchDate4yyyy;}
	public void setSearchDate4yyyy(String searchDate4yyyy) {this.searchDate4yyyy = searchDate4yyyy;}

	
	
	// breadcrumb
	public void setBreadX(String breadCrumb) {		
		this.breadCrumb = breadCrumb;	
	}	
	public Breadcrumb getBreadCrumb() {			
		StringTokenizer _stringTokenizer = new StringTokenizer(this.breadCrumb, "|");
		Breadcrumb _breadcrumb = new Breadcrumb();
		if (_stringTokenizer.countTokens()==3) _breadcrumb.setUrl(_stringTokenizer.nextToken());
		if (_stringTokenizer.countTokens()==3) _breadcrumb.setLabel(_stringTokenizer.nextToken());
		if (_stringTokenizer.countTokens()==3) _breadcrumb.setSequence(_stringTokenizer.nextToken());		
		return _breadcrumb;
	}
	



	
	

	// multiple update
	public int[] getSelectedObjects() {
		return _selectedObjects;
	}
	public void setSelectedObjects(int[] _selectedObjects) {
		this._selectedObjects = _selectedObjects;
	}
	
	public void setButton(String _button) {	this._button = _button;	}
	public String getButton() {return _button;}	

	

	
	

	public java.lang.String getMailtext() {
		return mailtext;
	}
	public void setMailtext(java.lang.String mailtext) {
		this.mailtext= mailtext;
	}
	

	public java.lang.String getMailsubject () {
		return mailsubject;
	}
	public void setMailsubject(java.lang.String mailsubject) {
		this.mailsubject= mailsubject;
	}
	
	

	public java.lang.String getMailfrom () {
		return mailfrom;
	}
	public void setMailfrom (java.lang.String mailfrom) {
		this.mailfrom = mailfrom;
	}

	
	public java.lang.String getMailto () {
		return mailto;
	}
	public void setMailto (java.lang.String mailto) {
		this.mailto = mailto;
	}
	

	public java.lang.String getMailcc () {
		return mailcc;
	}
	public void setMailcc (java.lang.String mailcc) {
		this.mailcc = mailcc;
	}



	public java.lang.String getMailbcc () {
		return mailbcc;
	}
	public void setMailbcc (java.lang.String mailbcc) {
		this.mailbcc = mailbcc;
	}


	

	
	
	
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		if ((searchString1 == null) || (searchString1.length() < 1))
			errors.add("searchString1", new ActionMessage(
					"error.searchString1.required"));

		return errors;

	}

	@Override
	public String toString() {
		return 
				 "id=" + id 
				+" searchString1=" + searchString1
				+" searchString2=" + searchString2
				+" searchString3=" + searchString3 
				+" searchString4=" + searchString4 
				+" searchString5=" + searchString5 
				+" searchString6=" + searchString6 
				+" searchString7=" + searchString7
				+" searchString8=" + searchString8
				+" searchString9=" + searchString9 
				+" searchString10=" + searchString10 
				+" searchString11=" + searchString11 
				+" searchString12=" + searchString12 
				+" searchString13=" + searchString13
				+" searchString14=" + searchString14
				+" searchString15=" + searchString15
				+" headerInfo1=" + headerInfo1
				+" headerInfo2=" + headerInfo2
				+" headerInfo3=" + headerInfo3 
				+" headerInfo4=" + headerInfo4 
				+" headerInfo5=" + headerInfo5 
				+" headerInfo6=" + headerInfo6 
				+" headerInfo7=" + headerInfo7
				+" headerInfo8=" + headerInfo8
				+" headerInfo9=" + headerInfo9 
				+" headerInfo10=" + headerInfo10 				
				+" searchDate1=" + searchDate1yyyy+"-"+searchDate1mm+"-"+searchDate1dd
				+" searchDate2=" + searchDate2yyyy+"-"+searchDate2mm+"-"+searchDate2dd				
				+" gotoPage=" + gotoPage
				+" firstPage=" + firstPage 
				+" lastPage=" + lastPage
				+" orderBy=" + orderBy 
				+" maxResults=" + maxResults
				+" totalResults=" + totalResults 
				+" lineItems.size="+ (lineItems == null ? 0 : lineItems.size())
				+" selectedObjects.length="+ (_selectedObjects == null ? 0 : _selectedObjects.length)
				+" button=" + _button+
				" mailto="+
				this.getMailto()+
				" mailfrom="+
				this.getMailfrom()+
				" mailcc="+
				this.getMailcc()+
				" mailbcc="+
				this.getMailbcc()+
				" mailtext="+
				this.getMailtext()+
				" mailsubject="+
				this.getMailsubject()
				;
	}

}

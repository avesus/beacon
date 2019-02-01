package com.bureaueye.beacon.form.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.job.dto.JobmovDTO;

public class ListOrdersummaryForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List[] lineItems;

	private BigDecimal[] totals;
	
	
	private String id;

    protected String[] headerInfo;
    
    
    private String displayContent1;
    private String displayContent2;
    private String displayContent3;
    private String displayContent4;
    private String displayContent5;
    
    

	// multiple update
	private java.util.List list;
	private int[] selectedObjects;
	private int[] selectedObjects2;
	private int[] selectedObjects3;
	private Object header;
	
	
	// private String action;
	private String btnsubmit;
	
	private String[] searchString;

	
	private String searchDate1mm;
	private String searchDate1dd;
	private String searchDate1yyyy;	
	private String searchDate2mm;
	private String searchDate2dd;
	private String searchDate2yyyy;	
	
	private int maxResults;

	private int totalResults;

	private String orderBy;
	private String orderByDesc;	
	private String orderBy2;
	private String orderBy2Desc;	
	private String orderBy3;	
	private String orderBy3Desc;	

	private int gotoPage;

	private boolean firstPage;

	private boolean lastPage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getBtnSubmit() {return btnsubmit;}
	public void setBtnSubmit(String btnsubmit) {this.btnsubmit = btnsubmit;}
	
	
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

	
	public String[] getSearchString() {
		return searchString;
	}	
	public String getSearchString(int index) {
		return searchString[index];
	}
	public void setSearchString(String searchString, int index) {
		this.searchString[index] = searchString;
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

	public String getOrderBy() { return orderBy; }
	public void setOrderBy(String orderBy) { this.orderBy = orderBy; }
	public String getOrderByDesc() { return orderByDesc; }
	public void setOrderByDesc(String orderByDesc) { this.orderByDesc = orderByDesc; }
	
	
	public String getOrderBy2() { return orderBy2; }
	public void setOrderBy2(String orderBy2) { this.orderBy2 = orderBy2; }
	public String getOrderBy3() { return orderBy3; }
	public void setOrderBy3(String orderBy3) { this.orderBy3 = orderBy3; }

	public List[] getLineItems() {
		return lineItems;
	}	
	public List getLineItems(int index) {
		return lineItems[index];
	}
	public void setLineItems(List lineItems, int index) {
		if (this.lineItems==null) this.lineItems = new List[5];
		this.lineItems[index] = lineItems;
	}

	
	public BigDecimal[] getTotals() {
		return totals;
	}	
	public BigDecimal getTotals(int index) {
		return totals[index];
	}
	public void setTotals(BigDecimal total, int index) {
		if (this.totals==null) this.totals = new BigDecimal[10];
		this.totals[index] = total;
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

	


	
	public Date getSearchDate1() {
		Calendar c = Calendar.getInstance();
		try {
		c.set(Integer.parseInt(getSearchDate1yyyy()), Integer
				.parseInt(getSearchDate1mm())-1, Integer.parseInt(getSearchDate1dd()));
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
	public String getSearchDate1mm() {return searchDate1mm;}
	public void setSearchDate1mm(String searchDate1mm) {this.searchDate1mm = searchDate1mm;}
	public String getSearchDate1dd() {return searchDate1dd;}
	public void setSearchDate1dd(String searchDate1dd) {this.searchDate1dd = searchDate1dd;}
	public String getSearchDate1yyyy() {return searchDate1yyyy;}
	public void setSearchDate1yyyy(String searchDate1yyyy) {this.searchDate1yyyy = searchDate1yyyy;}
	
	public Date getSearchDate2() {
		Calendar c = Calendar.getInstance();
		try {
		c.set(Integer.parseInt(getSearchDate2yyyy()), Integer
				.parseInt(getSearchDate2mm())-1, Integer.parseInt(getSearchDate2dd()));
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
	public String getSearchDate2mm() {return searchDate2mm;}
	public void setSearchDate2mm(String searchDate2mm) {this.searchDate2mm = searchDate2mm;}
	public String getSearchDate2dd() {return searchDate2dd;}
	public void setSearchDate2dd(String searchDate2dd) {this.searchDate2dd = searchDate2dd;}
	public String getSearchDate2yyyy() {return searchDate2yyyy;}
	public void setSearchDate2yyyy(String searchDate2yyyy) {this.searchDate2yyyy = searchDate2yyyy;}


	
    /**
     */
    public String getDisplayContent1() {return (this.displayContent1);}
    public void setDisplayContent1(String displayContent1) {
        this.displayContent1 = displayContent1;
    }
    
    public String getDisplayContent2() {return (this.displayContent2);}
    public void setDisplayContent2(String displayContent2) {
        this.displayContent2 = displayContent2;
    }
    
    public String getDisplayContent3() {return (this.displayContent3);}
    public void setDisplayContent3(String displayContent3) {
        this.displayContent3 = displayContent3;
    }
    
    public String getDisplayContent4() {return (this.displayContent4);}
    public void setDisplayContent4(String displayContent4) {
        this.displayContent4 = displayContent4;
    }

    public String getDisplayContent5() {return (this.displayContent5);}
    public void setDisplayContent5(String displayContent5) {
        this.displayContent5 = displayContent4;
    }
    
    
    
	
    /**
     */
    public String getHeaderInfo(int index) {
    	return (this.headerInfo[index]);
    }
    public void setHeaderInfo(String headerInfo, int index) {
        this.headerInfo[index] = headerInfo;
    }
	public String[] getHeaderInfo() {
		return headerInfo;
	}


	/**
	 * multiple update function
	 * 
	 */
	public Object getHeader() {
		return header;
	}

	public void setHeader(Object header) {
		this.header = header;
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
	public void setSelectedObjects(int[] selectedObjects) {
		this.selectedObjects = selectedObjects;
	}

	public int[] getSelectedObjects2() {
		return selectedObjects2;
	}
	public void setSelectedObjects2(int[] selectedObjects2) {
		this.selectedObjects2 = selectedObjects2;
	}

	public int[] getSelectedObjects3() {
		return selectedObjects3;
	}
	public void setSelectedObjects3(int[] selectedObjects3) {
		this.selectedObjects3 = selectedObjects3;
	}
	
	public JobmovDTO getJobmovDTO(int i) {
		if (getList() == null) {
			setList(new ArrayList());
		}
		while (getList().size() <= i) {
			getList().add(new JobmovDTO());
		}
		return (JobmovDTO) getList().get(i);
	}
	/**
	 * 
	 * 
	 */
	
	
    
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		firstPage = false;
		lastPage = false;
		maxResults = Constants.MAX_RESULTS;
		//lineItems = new List[5];
		searchString = new String[20];
		headerInfo = new String[20];		
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		return errors;

	}

	public String toString() {
		return "id: " + id;
//				+ " searchString1: " + searchString1
//				+ " searchString2: " + searchString2 + " gotoPage: " + gotoPage
//				+ " firstPage: " + firstPage + " lastPage: " + lastPage
//				+ " orderBy: " + orderBy + " maxResults: " + maxResults
//				+ " totalResults: " + totalResults + " lineItems.size: "
//				+ (lineItems == null ? 0 : lineItems.size());
	}

}

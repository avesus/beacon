/*
 * $Id: ListQuoapproveForm.java 2005-09-12 ntankard $ 
 *
 */


package com.bureaueye.beacon.form.quotation;


import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.model.quotation.Quoapprove;



/**
 * extends abstract class ListForm
 *
 */

public final class ListQuoapproveForm extends ActionForm  {



	private List lineItems;

	private String id;

    protected String headerInfo1;
    protected String headerInfo2;
    protected String headerInfo3;
    protected String headerInfo4;
    protected String headerInfo5;
    protected String headerInfo6;
    protected String headerInfo7;
    protected String headerInfo8;
    protected String headerInfo9;
    protected String headerInfo10;
    protected String headerInfo11;
    
	// private String action;

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

	public String getOrderBy() { return orderBy; }
	public void setOrderBy(String orderBy) { this.orderBy = orderBy; }
	public String getOrderByDesc() { return orderByDesc; }
	public void setOrderByDesc(String orderByDesc) { this.orderByDesc = orderByDesc; }
	
	
	public String getOrderBy2() { return orderBy2; }
	public void setOrderBy2(String orderBy2) { this.orderBy2 = orderBy2; }
	public String getOrderBy3() { return orderBy3; }
	public void setOrderBy3(String orderBy3) { this.orderBy3 = orderBy3; }

	public List getLineItems() {
		return lineItems;
	}	

    /**
     * Set the LineItems.
     *
     * @param LineItems The new LineItems
     */
    public void setLineItems(List list) 
    {
    	this.lineItems = new LinkedList();
    	if (list != null) {
    		Iterator iter = list.iterator();
    		while (iter.hasNext()) {
    			QuoapproveLineItem lineItem = 
    				new QuoapproveLineItem();
    			Quoapprove dto = (Quoapprove) iter.next();

    			try {
    				// init FORM with DAO values
    				PropertyUtils.copyProperties(lineItem, dto);
    				  				
    				lineItem.setId_(dto.getQuoapproveId().toString());
    				lineItem.setQuohdrId_(dto.getQuohdrId().toString());
    				
    				lineItem.setChecked(false);
    				lineItem.setDelete(false);
    				lineItem.setEmail(false);

    				this.lineItems.add(lineItem);
    				
    			} catch (InvocationTargetException e) {
    				Throwable t = e.getTargetException();
    				if (t == null)
    					t = e;
    				//throw new ServletException("QuohdrForm.populate", t);
    				
    			} catch (Throwable t) {
    				//throw new ServletException("QuohdrForm.populate", t);
    			}
    			
    		}
    	}
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

	
	public String getSearchString3() {return searchString3;}
	public void setSearchString3(String searchString3) {this.searchString3 = searchString3;}
	
	public String getSearchString4() {return searchString4;}
	public void setSearchString4(String searchString4) {this.searchString4 = searchString4;}
	
	public String getSearchString5() {return searchString5;}
	public void setSearchString5(String searchString5) {this.searchString5 = searchString5;}
	
	public String getSearchString6() {return searchString6;}
	public void setSearchString6(String searchString6) {this.searchString6 = searchString6;}

	public String getSearchString7() {return searchString7;}
	public void setSearchString7(String searchString7) {this.searchString7 = searchString7;}

	public String getSearchString8() {return searchString8;}
	public void setSearchString8(String searchString8) {this.searchString8 = searchString8;}
	
	public String getSearchString9() {return searchString9;}
	public void setSearchString9(String searchString9) {this.searchString9 = searchString9;}

	public String getSearchString10() {return searchString10;}
	public void setSearchString10(String searchString10) {this.searchString10 = searchString10;}

	public String getSearchString11() {return searchString11;}
	public void setSearchString11(String searchString11) {this.searchString11 = searchString11;}

	public String getSearchString12() {return searchString12;}
	public void setSearchString12(String searchString12) {this.searchString12 = searchString12;}

	public String getSearchString13() {return searchString13;}
	public void setSearchString13(String searchString13) {this.searchString13 = searchString13;}

	public String getSearchString14() {return searchString14;}
	public void setSearchString14(String searchString14) {this.searchString14 = searchString14;}

	public String getSearchString15() {return searchString15;}
	public void setSearchString15(String searchString15) {this.searchString15 = searchString15;}



	
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
    public String getHeaderInfo1() {
    	return (this.headerInfo1);
    }
    public void setHeaderInfo1(String headerInfo1) {
        this.headerInfo1 = headerInfo1;
    }

    public String getHeaderInfo2() {
    	return (this.headerInfo2);
    }
    public void setHeaderInfo2(String headerInfo2) {
        this.headerInfo2 = headerInfo2;
    }
    
    public String getHeaderInfo3() {
    	return (this.headerInfo3);
    }
    public void setHeaderInfo3(String headerInfo3) {
        this.headerInfo3 = headerInfo3;
    }    

    public String getHeaderInfo4() {
    	return (this.headerInfo4);
    }
    public void setHeaderInfo4(String headerInfo4) {
        this.headerInfo4 = headerInfo4;
    }

    public String getHeaderInfo5() {
    	return (this.headerInfo5);
    }
    public void setHeaderInfo5(String headerInfo5) {
        this.headerInfo5 = headerInfo5;
    }

    /**
     */
    public String getHeaderInfo6() {
    	return (this.headerInfo6);
    }
    public void setHeaderInfo6(String headerInfo6) {
        this.headerInfo6 = headerInfo6;
    }

    public String getHeaderInfo7() {
    	return (this.headerInfo7);
    }
    public void setHeaderInfo7(String headerInfo7) {
        this.headerInfo7 = headerInfo7;
    }
    
    public String getHeaderInfo8() {
    	return (this.headerInfo8);
    }
    public void setHeaderInfo8(String headerInfo8) {
        this.headerInfo8 = headerInfo8;
    }    

    public String getHeaderInfo9() {
    	return (this.headerInfo9);
    }
    public void setHeaderInfo9(String headerInfo9) {
        this.headerInfo9 = headerInfo9;
    }

    public String getHeaderInfo10() {
    	return (this.headerInfo10);
    }
    public void setHeaderInfo10(String headerInfo10) {
        this.headerInfo10 = headerInfo10;
    }
    
    public String getHeaderInfo11() {
    	return (this.headerInfo11);
    }
    public void setHeaderInfo11(String headerInfo11) {
        this.headerInfo11 = headerInfo11;
    }
    
    
    
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		firstPage = false;
		lastPage = false;
		maxResults = Constants.MAX_RESULTS;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		// Perform validator framework validations
		ActionErrors errors = new ActionErrors();

		if ((searchString1 == null) || (searchString1.length() < 1))
			errors.add("searchString1", new ActionMessage(
					"error.searchString1.required"));

		return errors;

	}

	public String toString() {
		return "id: " + id + " searchString1: " + searchString1
				+ " searchString2: " + searchString2 + " gotoPage: " + gotoPage
				+ " firstPage: " + firstPage + " lastPage: " + lastPage
				+ " orderBy: " + orderBy + " maxResults: " + maxResults
				+ " totalResults: " + totalResults + " lineItems.size: "
				+ (lineItems == null ? 0 : lineItems.size());
	}

}

package com.bureaueye.beacon.action.standard;

import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.ListAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;

import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.standard.bd.UnittestBD;
import com.bureaueye.beacon.util.Util;


public final class ListUnittestAction extends ListAction {
	
	public void setTotalResults(ListForm listForm) throws ApplicationException {
		
		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("Duedate");
		}
		listForm.setOrderByDesc("desc");
		
		listForm.setTotalResults(0);
		listForm.setMaxResults(Constants.MAX_RESULTS_NOLIMIT);	
		
	}
	
	public void setTotalResults(ListForm listForm, HttpSession session) throws ApplicationException {
	}
	
	public ActionMessages setLineItems(ListForm listForm) throws ApplicationException {
		
		// set header information
		Unit unit = new UnitBD(this.getSessionFactoryClusterMap()).read(new Integer(listForm.getId()));
		
		listForm.setHeaderInfo1(unit.getUnitkey());
		listForm.setHeaderInfo2(
				unit.getMfnum()
		);
		listForm.setHeaderInfo3(
				Util.dateTextFormat2(unit.getMfdate())
		);
		
		
		// set line items
		listForm.setLineItems(new UnittestBD(this.getSessionFactoryClusterMap())
				.findUnittestsById(listForm.getId(), listForm
						.getGotoPage(), listForm.getMaxResults(), listForm
						.getOrderBy()));
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" ListForm Parameters: "+listForm.toString()
		);
		
		return null;
	}
}

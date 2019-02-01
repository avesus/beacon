package com.bureaueye.beacon.action.standard;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Vendortariffavg;
import com.bureaueye.beacon.model.standard.Vendortariffdtl;
import com.bureaueye.beacon.model.standard.Vendortariffhdr;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffavgBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;
import com.bureaueye.beacon.model.standard.dto.VendortariffhdrDTO;
import com.bureaueye.beacon.model.system.SystemX;
import com.bureaueye.beacon.model.system.bd.SystemXBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-01 BESL-201402-0001 QUOTE MOVE AND COST TEMPLATE WORK
 * 
 */
public final class ListVendortariffavgAction extends BaseAction {

	ActionMessages appErrorMessages;
	ActionMessages appInformationMessages;

	// program variables
	private String baseccykey;

	/**
	 */
	// maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;

	@SuppressWarnings("rawtypes")
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		HttpSession session = request.getSession();

		appErrorMessages = new ActionMessages();
		appInformationMessages = new ActionMessages();

		// Remove all other ActionForms excepts the ones on the formsToSkip Set
		// Hopefully, this will keep HttpSession objects to a minimum
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListAction: isNew = " + session.isNew());

		String parameter = mapping.getParameter();
		if (parameter == null) {
			parameter = "";
		}
		List formsToSkip = Arrays.asList(parameter.split(","));
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListAction: formsToSkip = " + formsToSkip);
		for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
			String actionFormName = (String) e.nextElement();
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " actionFormName = "
					+ actionFormName + "\t Mapping = " + mapping.getName());

			if (actionFormName.endsWith("Form")
					&& !actionFormName.equals(mapping.getName())
					&& !formsToSkip.contains(actionFormName)) {
				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " remove = " + actionFormName);
				session.removeAttribute(actionFormName);
			}
		}

		// init bd
		SystemXBD systembd = new SystemXBD(this.getSessionFactoryClusterMap());

		ListForm listForm = (ListForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		if (listForm.getButton() != null) {

			log.info("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " button = "
					+ listForm.getButton());

			// BUILD
			// PROCESS==========================================================>
			if (listForm.getButton().equals("BUILD")) {

				// init base ccy
				baseccykey = "";
				SystemX system = null;
				try {
					system = systembd.findSystem();
				} catch (Exception e) {
				}
				if (system != null)
					baseccykey = system.getCcykey();

				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " buildButton pressed");

				// Build Lump Sum Vendor Tariff Averages
				this.BuildVendortariffLumpsumAverage();

				// Build Unit Rate Vendor Tariff Averages
				this.BuildVendortariffUnitrateAverage();

				// reset search dates to show generated rates
				Calendar c = Calendar.getInstance();
				listForm.setSearchDate1(c.getTime());
				listForm.setSearchDate2(c.getTime());

			}
			// BUILD
			// PROCESS==========================================================<

			// ROLLBACK
			// PROCESS==========================================================>
			if (listForm.getButton().equals("ROLLBACK")) {

				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " rollbackButton pressed");

				// Rollback Vendor Tariff Averages to previous
				this.RollbackVendortariffAverage();

			}
			// BUILD
			// PROCESS==========================================================<

		}

		// Calculate the total number of results before any buttons are
		// generated and default values
		setTotalResults(listForm);

		// Calculate the total number of results before any buttons are
		// generated and default values from SESSION
		setTotalResults(listForm, session);

		// reset select objects
		listForm.setSearchString15(null);
		listForm.setSelectedObjects(null);
		listForm.setButton("");

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " ListForm Parameters = " + listForm.toString());

		// populate list items
		ActionMessages messages = setLineItems(listForm);
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}

		if (appErrorMessages != null) {
			saveAppErrorMessages(request, appErrorMessages);
		}
		if (appInformationMessages != null) {
			saveAppInformationMessages(request, appInformationMessages);
		}

		// clear bd
		systembd = null;

		// Forward control to the edit user registration page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}

	public void setTotalResults(ListForm listForm, HttpSession session)
			throws ApplicationException {

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("VENDORTARIFFAVG_ID");
		}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("VENDORTARIFFAVG_ID"))
			listForm.setOrderByDesc("asc");

		// set default field values
		listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_NOLIMIT);

		Calendar c = Calendar.getInstance();
		// create date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE, -7);
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {
			}
		}
		// quote date 'to'
		if (listForm.getSearchDate2() == null) {
			// default 'to' date plus 7
			c.add(Calendar.DATE, 7);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}
		}

	}

	public void setTotalResults(ListForm listForm) throws ApplicationException {

	}

	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {

		VendortariffavgBD bd = new VendortariffavgBD(
				this.getSessionFactoryClusterMap());
		listForm.setLineItems(bd.findVendortariffavgsBySearch(listForm));
		bd = null;

		return null;
	}

	@SuppressWarnings({ "rawtypes" })
	public void BuildVendortariffLumpsumAverage() {

		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " BuildVendortariffLumpsumAverage: Run at: " + cal.getTime());

		// set user
		User user = new User();
		user.setUserid("BUILDVTAVG");

		// define business delegates
		VendortariffavgBD avgbd = null;
		VendortariffhdrBD hdrbd = null;

		try {

			// init business delegates
			avgbd = new VendortariffavgBD(this.getSessionFactoryClusterMap());
			hdrbd = new VendortariffhdrBD(this.getSessionFactoryClusterMap());

			// get records - not expired group by cost, from location, to
			// location, product hazardous
			List groupdtos = null;
			try {
				groupdtos = hdrbd
						.groupVendortariffsForLumpsumAverage(new Date());
			} catch (ApplicationException ae) {
				appErrorMessages.add(
						"errors.vendortariffavg",
						new ActionMessage("vendortariffavg.error.exception", ae
								.getMessage()));
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
						+ " Error Exception with problem [" + ae.getMessage()
						+ "]");
			}

			if (groupdtos != null && groupdtos.size() > 0) {

				log.info("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " find groupdtos: "
						+ " groupdtos[" + groupdtos.size() + "]");

				// Define ListIterator and define Start position
				int batchCount = 0;
				Iterator itLoop2 = groupdtos.iterator();
				while (itLoop2.hasNext()) {
					VendortariffhdrDTO dto = (VendortariffhdrDTO) itLoop2
							.next();

					log.info("[" + this.getClass().getName() + "] "
							+ new Date() + " Processing: " + dto.getCostkey2()
							+ "-" + dto.getFromlocationkey2() + "-"
							+ dto.getTolocationkey2() + "-"
							+ dto.getProducthazardous());

					try {

						BigDecimal recordcount = new BigDecimal(0.0);
						BigDecimal lumpsumbasetotal = new BigDecimal(0.0);

						// find vendor tariffs using grouping key
						List vendortariffs = hdrbd
								.findVendortariffsForLumpsumAverage(
										dto.getCostkey2(),
										dto.getFromlocationkey2(),
										dto.getTolocationkey2(),
										dto.getProducthazardous(), new Date());

						// loop lumpsum amounts to convert to base and total
						for (Iterator vtit = vendortariffs.iterator(); vtit
								.hasNext();) {
							Vendortariffhdr vtdao = (Vendortariffhdr) vtit
									.next();

							// init exchange rates
							BigDecimal lumpsumbase = vtdao.getLumpsum();
							BigDecimal exrate = new BigDecimal(1);
							// check base and tariff ccys are different
							if (!vtdao.getCcykey().equals(baseccykey)) {
								try {
									exrate = this.getExrate(vtdao.getCcykey(),
											baseccykey);
								} catch (Exception ae) {
								}
							}

							// init fields
							// calculate base amount and total
							try {
								lumpsumbase = lumpsumbase.multiply(exrate);
								lumpsumbasetotal = lumpsumbasetotal
										.add(lumpsumbase);
								recordcount = recordcount.add(new BigDecimal(
										1.0));
							} catch (Exception e) {
							}

						} // lump sum amounts loop

						// init fields
						Vendortariffavg vtadao = new Vendortariffavg();
						try {
							vtadao.setVendoraddrkey("");
							vtadao.setCostkey(dto.getCostkey2());
							vtadao.setFromlocationkey(dto.getFromlocationkey2());
							vtadao.setTolocationkey(dto.getTolocationkey2());
							vtadao.setProducthazardous(dto
									.getProducthazardous());
							vtadao.setVendoraddrkey("");
							vtadao.setVendoraddrkey("");
							vtadao.setCcykey(baseccykey);
							vtadao.setValidfrom(new Date());
							vtadao.setFromvalue(0);
							vtadao.setTovalue(0);
							vtadao.setProductkey("");
							vtadao.setNote1("");
							vtadao.setNote2("");
							vtadao.setCosttype("LUMPSUM");
							vtadao.setUnittype("");							
							vtadao.setUnitrate(new BigDecimal(0.0));

							// derive average
							BigDecimal lumpsumbaseavg = new BigDecimal(0.0);
							lumpsumbaseavg = lumpsumbasetotal.divide(
									recordcount).setScale(2,
									RoundingMode.CEILING);
							vtadao.setLumpsum(lumpsumbaseavg);

						} catch (Exception e) {
						}

						// update vendor tariff average record
						try {
							avgbd.createOrUpdate(vtadao, user);
							batchCount++;
						} catch (ApplicationException ae) {
						}

					} catch (Exception e) {
						// Add an error message if io error
						appErrorMessages.add(
								"errors.vendortariffavg",
								new ActionMessage(
										"vendortariffavg.error.exception", e
												.getMessage()));
						log.error("[" + this.getClass().getName() + "] "
								+ new java.util.Date()
								+ " Error Exception with problem ["
								+ e.getMessage() + "]");
					}

				} // LOOP

				// output message
				if (batchCount > 0) {
					// Add a summary message of generated records
					appInformationMessages.add(
							"messages.vendortariffavg",
							new ActionMessage(
									"vendortariffavg.information.build",
									"Lump Sum", new Integer(batchCount)
											.toString()));
				}

			} // check GROUPs

		} catch (Exception e) {
		}

		// clear business delegates
		avgbd = null;
		hdrbd = null;

	}

	@SuppressWarnings({ "rawtypes" })
	public void BuildVendortariffUnitrateAverage() {

		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " BuildVendortariffUnitrateAverage: Run at: " + cal.getTime());

		// set user
		User user = new User();
		user.setUserid("BUILDVTAVG");

		// define business delegates
		VendortariffavgBD avgbd = null;
		VendortariffhdrBD hdrbd = null;

		try {

			// init business delegates
			avgbd = new VendortariffavgBD(this.getSessionFactoryClusterMap());
			hdrbd = new VendortariffhdrBD(this.getSessionFactoryClusterMap());

			// get records - not expired group by cost, from location, to
			// location, product hazardous, from unit, to unit
			List groupdtos = null;
			try {
				groupdtos = hdrbd
						.groupVendortariffsForUnitrateAverage(new Date());
			} catch (ApplicationException ae) {
				appErrorMessages.add(
						"errors.vendortariffavg",
						new ActionMessage("vendortariffavg.error.exception", ae
								.getMessage()));
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
						+ " Error Exception with problem [" + ae.getMessage()
						+ "]");
			}

			if (groupdtos != null && groupdtos.size() > 0) {

				log.info("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " find groupdtos: "
						+ " groupdtos[" + groupdtos.size() + "]");

				// Define ListIterator and define Start position
				int batchCount = 0;
				Iterator itLoop2 = groupdtos.iterator();
				while (itLoop2.hasNext()) {
					VendortariffhdrDTO dto = (VendortariffhdrDTO) itLoop2
							.next();

					log.info("[" + this.getClass().getName() + "] "
							+ new Date() + " Processing: " + dto.getCostkey2()
							+ "-" + dto.getFromlocationkey2() + "-"
							+ dto.getTolocationkey2() + "-"
							+ dto.getProducthazardous() + "-" + dto.getCcykey()
							+ "-" + dto.getFromvalue() + "-" + dto.getTovalue());

					try {

						BigDecimal recordcount = new BigDecimal(0.0);
						BigDecimal unitratebasetotal = new BigDecimal(0.0);

						// find vendor tariffs using grouping key
						List vendortariffs = hdrbd
								.findVendortariffsForUnitrateAverage(
										dto.getCostkey2(),
										dto.getFromlocationkey2(),
										dto.getTolocationkey2(),
										dto.getProducthazardous(),
										dto.getFromvalue(), dto.getTovalue(),
										new Date());

						// loop lumpsum amounts to convert to base and total
						for (Iterator vtit = vendortariffs.iterator(); vtit
								.hasNext();) {
							Vendortariffdtl vtdao = (Vendortariffdtl) vtit
									.next();

							// init exchange rates
							BigDecimal unitratebase = vtdao.getUnitrate();
							BigDecimal exrate = new BigDecimal(1);
							// check base and tariff ccys are different
							if (!dto.getCcykey().equals(baseccykey)) {
								try {
									exrate = this.getExrate(dto.getCcykey(),
											baseccykey);
								} catch (Exception ae) {
								}
							}

							// init fields
							// calculate base amount and total
							try {
								unitratebase = unitratebase.multiply(exrate);
								unitratebasetotal = unitratebasetotal
										.add(unitratebase);
								recordcount = recordcount.add(new BigDecimal(
										1.0));
							} catch (Exception e) {
							}

						}

						// init fields
						Vendortariffavg vtadao = new Vendortariffavg();
						try {
							vtadao.setVendoraddrkey("");
							vtadao.setCostkey(dto.getCostkey2());
							vtadao.setFromlocationkey(dto.getFromlocationkey2());
							vtadao.setTolocationkey(dto.getTolocationkey2());
							vtadao.setProducthazardous(dto
									.getProducthazardous());
							vtadao.setVendoraddrkey("");
							vtadao.setVendoraddrkey("");
							vtadao.setCcykey(baseccykey);
							vtadao.setValidfrom(new Date());
							vtadao.setFromvalue(dto.getFromvalue());
							vtadao.setTovalue(dto.getTovalue());
							vtadao.setProductkey("");
							vtadao.setNote1("");
							vtadao.setNote2("");
							vtadao.setCosttype("UNITRATE");							
							vtadao.setUnittype("");
							vtadao.setLumpsum(new BigDecimal(0.0));

							// derive average
							BigDecimal unitratebaseavg = new BigDecimal(0.0);
							unitratebaseavg = unitratebasetotal.divide(
									recordcount).setScale(2,
									RoundingMode.CEILING);
							vtadao.setUnitrate(unitratebaseavg);

						} catch (Exception e) {
						}

						// update vendor tariff average record
						try {
							avgbd.createOrUpdate(vtadao, user);
							batchCount++;
						} catch (ApplicationException ae) {
						}

					} catch (Exception e) {
						appErrorMessages.add(
								"errors.vendortariffavg",
								new ActionMessage(
										"vendortariffavg.error.exception", e
												.getMessage()));
						log.error("[" + this.getClass().getName() + "] "
								+ new java.util.Date()
								+ " Error Exception with problem ["
								+ e.getMessage() + "]");
					}

				} // LOOP

				// output message
				if (batchCount > 0) {
					// Add a summary message of generated records
					appInformationMessages.add(
							"messages.vendortariffavg",
							new ActionMessage(
									"vendortariffavg.information.build",
									"Unit Rate", new Integer(batchCount)
											.toString()));
				}

			} // check GROUPs

		} catch (Exception e) {

		}

		// clear business delegates
		avgbd = null;
		hdrbd = null;

	}

	@SuppressWarnings("rawtypes")
	public void RollbackVendortariffAverage() {

		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " RollbackVendortariffAverage: Run at: " + cal.getTime());

		// set user
		User user = new User();
		user.setUserid("ROLLBACKVTAVG");

		// define business delegates
		VendortariffavgBD avgbd = null;
		
		try {

			ListForm listForm = new ListForm();
			
			// init business delegates
			avgbd = new VendortariffavgBD(this.getSessionFactoryClusterMap());

			// get last record
			Vendortariffavg dao1 = null;
			try {
				dao1 = avgbd.findLastVendortariffavgByCreatedate();
			} catch (ApplicationException ae) {
				appErrorMessages.add(
						"errors.vendortariffavg",
						new ActionMessage("vendortariffavg.error.exception", ae
								.getMessage()));
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
						+ " Error Exception with problem [" + ae.getMessage()
						+ "]");
			}

			if (dao1 != null) {

				log.info("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " find groupdtos: "
						+ " vta.createdate[" + dao1.getCreatedate() + "]");

				// get last record
				List daos = null;
				try {
					listForm.setSearchDate1(dao1.getCreatedate());
					listForm.setSearchDate2(dao1.getCreatedate());
					daos = avgbd.findVendortariffavgsBySearch(listForm);
				} catch (ApplicationException ae) {
					appErrorMessages.add(
							"errors.vendortariffavg",
							new ActionMessage(
									"vendortariffavg.error.exception", ae
											.getMessage()));
					log.error("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " Error Exception with problem ["
							+ ae.getMessage() + "]");
				}

				int batchCount = 0;

				try {

					// loop records to delete
					for (Iterator vtit = daos.iterator(); vtit.hasNext();) {
						Vendortariffavg dao2 = (Vendortariffavg) vtit.next();

						// delete vendor tariff average record
						try {
							avgbd.delete(dao2, user);
							batchCount++;
						} catch (ApplicationException ae) {
						}

					}

				} catch (Exception e) {
					appErrorMessages.add(
							"errors.vendortariffavg",
							new ActionMessage(
									"vendortariffavg.error.exception", e
											.getMessage()));
					log.error("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " Error Exception with problem ["
							+ e.getMessage() + "]");
				}

				// output message
				if (batchCount > 0) {
					// Add a summary message of generated records
					appInformationMessages.add(
							"messages.vendortariffavg",
							new ActionMessage(
									"vendortariffavg.information.rollback",
									new Integer(batchCount).toString()
									));
				}

			} // check GROUPs

		} catch (Exception e) {

		}

		// clear business delegates
		avgbd = null;

	}

	void println(String s) {
		System.out.println(s);
	}

	public void setStartprocesstime() {
		Calendar cal = Calendar.getInstance();
		this._startprocesstime = cal;
	}

	public Calendar getStartprocesstime() {
		return this._startprocesstime;
	}

	public boolean isBlocked() {
		Calendar _currenttime = Calendar.getInstance();
		Calendar _maxprocesstime = this._startprocesstime;
		_maxprocesstime.add(Calendar.MILLISECOND, MAX_PROCESS_TIME);

		log.info("[" + this.getClass().getName() + "] " + new Date()
				+ " isblocked: " + _currenttime.after(_maxprocesstime)
				+ " currenttime: " + _currenttime.getTime()
				+ " maxprocesstime: " + _maxprocesstime.getTime());

		if (_currenttime.after(_maxprocesstime))
			return true;
		return false;
	}

	public BigDecimal getExrate(String fromccy, String toccy) throws Exception {

		BigDecimal exrate = new BigDecimal(1.0);

		try {
			CcyexBD ccyexbd = new CcyexBD(this.getSessionFactoryClusterMap());
			// init business delegate fields for
			// exchange rate retrieval
			ListForm listForm = new ListForm();
			listForm.setMaxResults(Constants.MAX_TOTAL_RESULTS);
			listForm.setGotoPage(0);
			listForm.setSearchString1(fromccy);// fromccykey
			listForm.setSearchString2(toccy);// toccykey
			listForm.setSearchDate1(new Date());// exchange
			// date
			listForm.setOrderBy("Exdate");
			listForm.setOrderByDesc("Desc");

			exrate = new BigDecimal(ccyexbd.getExrate(listForm));

			log.info("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Check Exrate - " + " fromccy: "
					+ fromccy + " toccy: " + toccy + " exrate: " + exrate);
			ccyexbd = null;
		} catch (Exception ae) {
		}

		return exrate;
	}

}

package com.bureaueye.beacon.action.quotation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.form.quotation.CosttemplateLineItem;
import com.bureaueye.beacon.form.quotation.GenerateXtemplateForm;
import com.bureaueye.beacon.form.quotation.SectiontemplateLineItem;
import com.bureaueye.beacon.form.quotation.VendortariffLineItem;
import com.bureaueye.beacon.model.quotation.Quocost;
import com.bureaueye.beacon.model.quotation.Quohdr;
import com.bureaueye.beacon.model.quotation.Quomov;
import com.bureaueye.beacon.model.quotation.Quoprod;
import com.bureaueye.beacon.model.quotation.bd.QuocostBD;
import com.bureaueye.beacon.model.quotation.bd.QuohdrBD;
import com.bureaueye.beacon.model.quotation.bd.QuomovBD;
import com.bureaueye.beacon.model.quotation.bd.QuoprodBD;
import com.bureaueye.beacon.model.standard.Costtemplate;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Section;
import com.bureaueye.beacon.model.standard.Sectiontemplate;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Vendortariffavg;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CcyexBD;
import com.bureaueye.beacon.model.standard.bd.CosttemplateBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.standard.bd.SectiontemplateBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffavgBD;
import com.bureaueye.beacon.model.standard.bd.VendortariffhdrBD;
import com.bureaueye.beacon.model.system.SystemX;
import com.bureaueye.beacon.model.system.bd.SystemXBD;
import com.bureaueye.beacon.util.Util;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-01 BESL-201402-0001 QUOTE MOVE AND COST TEMPLATE WORK
 * 
 * NT 2014-02-01 BESL-201402-0001 REMOVE PRODUCTKEY FROM VENDOR TARIFF PROCESS
 * AND USE PRODUCT TYPE (HAZ/NON-HAZ) INSTEAD -IT DOESN'T SEEM TO BE USED AND IS
 * GETTING IN THE WAY
 * 
 */
public class GenerateXtemplate1Action extends BaseAction {

	// program variables
	private String baseccykey;
	private String GENERATE_ACTION="GENERATE";
	private String REFRESH_ACTION="REFRESH";	
	private String INIT_ACTION="INIT";	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession(false);
		GenerateXtemplateForm editForm = (GenerateXtemplateForm) form;
		String action = editForm.getAction();
		User user = (User) session.getAttribute(Constants.USER_KEY);
		ActionMessages messages = new ActionMessages();
		ActionMessages errors = new ActionMessages();

		// If action isn't supplied then invalidate the session
		/*
		 * if (action == null) {
		 * log.error("["+this.getClass().getName()+"] "+new
		 * java.util.Date()+" EditForm not supplied for EditAction");
		 * request.getSession().removeAttribute(Constants.USER_KEY); }
		 */

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Processing " + action + " action");

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " Form parameters: " + editForm.toString());

		// init bd
		QuohdrBD quohdrbd = new QuohdrBD(this.getSessionFactoryClusterMap());
		QuomovBD quomovbd = new QuomovBD(this.getSessionFactoryClusterMap());
		QuocostBD quocostbd = new QuocostBD(this.getSessionFactoryClusterMap());
		QuoprodBD quoprodbd = new QuoprodBD(this.getSessionFactoryClusterMap());
		SectiontemplateBD sectiontemplatebd = new SectiontemplateBD(
				this.getSessionFactoryClusterMap());
		CosttemplateBD costtemplatebd = new CosttemplateBD(
				this.getSessionFactoryClusterMap());
		SectionBD sectionbd = new SectionBD(this.getSessionFactoryClusterMap());
		LocationBD locationbd = new LocationBD(
				this.getSessionFactoryClusterMap());
		AddressBD addressbd = new AddressBD(this.getSessionFactoryClusterMap());
		ProductBD productbd = new ProductBD(this.getSessionFactoryClusterMap());
		SystemXBD systembd = new SystemXBD(this.getSessionFactoryClusterMap());

		// check task is scheduled
		baseccykey = "";
		SystemX system = null;
		try {
			system = systembd.findSystem();
		} catch (Exception e) {
		}
		if (system != null)
			baseccykey = system.getCcykey();

		// set header
		// information------------------------------------------------->
		Quohdr quohdr = null;
		try {
			quohdr = quohdrbd.read(new Integer(editForm.getId()));
			editForm.setHeaderInfo(quohdr.getQuotno(), 1);
			editForm.setHeaderInfo(Util.dateTextFormat2(quohdr.getQuotedate()),
					2);
			editForm.setHeaderInfo(
					Util.dateTextFormat2(quohdr.getExpirydate()), 3);
			editForm.setHeaderInfo(quohdr.getCustomerref(), 5);
			editForm.setHeaderInfo(addressbd.read(quohdr.getCustomeraddrkey())
					.getName(), 4);
			editForm.setHeaderInfo(quohdr.getQuotebyuserid(), 6);
			editForm.setHeaderInfo("", 7);
			try {
				editForm.setHeaderInfo(
						locationbd.read(quohdr.getLdglocationkey2())
								.getLocationName(), 7);
			} catch (Exception e) {
			}
			editForm.setHeaderInfo("", 8);
			try {
				editForm.setHeaderInfo(
						locationbd.read(quohdr.getDchlocationkey2())
								.getLocationName(), 8);
			} catch (Exception e) {
			}
			editForm.setHeaderInfo(quohdr.getCcykey(), 9);
			editForm.setHeaderInfo(quohdr.getShipmethod(), 10);

			// init product information
			editForm.setHeaderInfo("", 11);// product description
			editForm.setHeaderInfo("", 12);// product hazardous
			editForm.setHeaderInfo("", 13);// product weight
			editForm.setHeaderInfo("", 14);// product volume
			try {
				Quoprod quoprod = quoprodbd.findFirstQuoprodByQuohdrId(quohdr
						.getId());
				editForm.setHeaderInfo(
						quoprod.getWeight() + " " + quoprod.getWghtunit(), 13);
				editForm.setHeaderInfo(
						quoprod.getVolume() + " " + quoprod.getVolunit(), 14);
				if (quoprod != null) {
					Product product = productbd.read(quoprod.getProductkey());
					if (product != null) {
						editForm.setHeaderInfo(product.getLdesc(), 11);
						if (product.isHazardous())
							editForm.setHeaderInfo("YES", 12);
						if (!product.isHazardous())
							editForm.setHeaderInfo("NO", 12);
					}
				}
			} catch (Exception e) {
			}

		} catch (Exception e) {
		}
		// set header
		// information-------------------------------------------------<

		// submit
		// button----------------------------------------------------------->
		if (editForm.getBtnSubmit() != null) {

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " button = "
					+ editForm.getBtnSubmit());

			// GENERATE ACTION
			if (editForm.getBtnSubmit().equals(GENERATE_ACTION)) {

				// VALIDATE AND GET SCREEN
				// PARAMETERS---------------------------->
				List sectiontemplateLineitems = new ArrayList();
				for (Iterator stit = editForm.getList1().iterator(); stit
						.hasNext();) {
					// get lineitem
					SectiontemplateLineItem stlineitem = (SectiontemplateLineItem) stit
							.next();

					// get screen input parameters for row and update values
					stlineitem.setVendoraddrkey(request
							.getParameter("stVendoraddrkey"
									+ stlineitem.getRow()));
					stlineitem.setFromlocationkey(request
							.getParameter("stFromlocationkey"
									+ stlineitem.getRow()));
					stlineitem.setTolocationkey(request
							.getParameter("stTolocationkey"
									+ stlineitem.getRow()));

					if (stlineitem.getVendoraddrkey().equals("")) {
						errors.add(
								"vendoraddrkey",
								new ActionMessage(
										"generatextemplate.error.vendoraddrkey.required",
										stlineitem.getSeqno()));
					}
					if (stlineitem.getFromlocationkey().equals("")) {
						errors.add(
								"fromlocationkey",
								new ActionMessage(
										"generatextemplate.error.fromlocaionkey.required",
										stlineitem.getSeqno()));
					}
					if (stlineitem.getTolocationkey().equals("")) {
						errors.add(
								"tolocationkey",
								new ActionMessage(
										"generatextemplate.error.tolocationkey.required",
										stlineitem.getSeqno()));
					}

					List costtemplateLineitems = new ArrayList();
					for (Iterator ctit = stlineitem.getCtlineitems().iterator(); ctit
							.hasNext();) {
						// get lineitem
						CosttemplateLineItem ctlineitem = (CosttemplateLineItem) ctit
								.next();

						// get screen input parameters for row and update values
						ctlineitem.setVendoraddrkey(request
								.getParameter("ctVendoraddrkey"
										+ stlineitem.getRow() + "_"
										+ ctlineitem.getRow()));
						// default to section template vendor if blank
						if (ctlineitem.getVendoraddrkey().equals(""))
							ctlineitem.setVendoraddrkey(stlineitem
									.getVendoraddrkey());
						ctlineitem.setCcykey(request.getParameter("ctCcykey"
								+ stlineitem.getRow() + "_"
								+ ctlineitem.getRow()));
						// default to quote header currency if blank
						// if (ctlineitem.getCcykey().equals(""))
						// ctlineitem.setCcykey(quohdr.getCcykey());

						try {
							String ctUnits = request.getParameter("ctUnits"
									+ stlineitem.getRow() + "_"
									+ ctlineitem.getRow());
							if (!ctUnits.equals("null"))
								ctlineitem.setUnits(ctUnits);
						} catch (Exception e) {
						}

						List vendortariffLineitems = new ArrayList();
						VT_LOOP: for (Iterator vtit = ctlineitem
								.getVtlineitems().iterator(); vtit.hasNext();) {
							// get lineitem
							VendortariffLineItem vtlineitem = (VendortariffLineItem) vtit
									.next();
							String vtselectedValue = "";
							try {
								vtselectedValue = request
										.getParameter("vtSelectedObjects"
												+ stlineitem.getRow() + "_"
												+ ctlineitem.getRow());
								if (vtselectedValue.equals(vtlineitem.getId())) {
									ctlineitem
											.setVtselectedValue(vtselectedValue);
									vendortariffLineitems.add(vtlineitem);
									break VT_LOOP;
								}
							} catch (Exception e) {
							}
						}

						// only do this if no validation errors found
						if (errors.isEmpty()) {
							// init collection
							ctlineitem.setVtlineitems(vendortariffLineitems);
						}

						// store updated lineitem
						costtemplateLineitems.add(ctlineitem);
					}

					stlineitem.setCtlineitems(costtemplateLineitems);
					// store updated lineitem
					sectiontemplateLineitems.add(stlineitem);
				}

				// check no error or warning messages
				if (errors.isEmpty()) {

					// DELETE MOVEMENTS/COSTS---------------->
					try {
						// if order already has movements/costs then remove
						List<Quomov> quomovs = quohdrbd.getQuomovs(quohdr
								.getId());
						for (Iterator<Quomov> qmit = quomovs.iterator(); qmit
								.hasNext();) {
							// get quomov dto
							Quomov quomov = (Quomov) qmit.next();
							List<Quocost> quocosts = quomovbd
									.getQuocosts(quomov.getQuomovId());
							for (Iterator<Quocost> qcit = quocosts.iterator(); qcit
									.hasNext();) {
								// get quocost record
								Quocost quocost = (Quocost) qcit.next();
								quocostbd.delete(quocost, user);
							}
							quomovbd.delete(quomov, user);
						}
					} catch (Exception e) {
					}

					int count1 = 0;
					int count2 = 0;
					// CREATE MOVEMENTS/COSTS---------------->
					try {
						for (Iterator stit = editForm.getList1().iterator(); stit
								.hasNext();) {
							// get lineitem
							SectiontemplateLineItem stlineitem = (SectiontemplateLineItem) stit
									.next();
							Quomov quomov = new Quomov();
							try {
								quomov.setQuohdrId(quohdr.getId());
								quomov.setQuotno(quohdr.getQuotno());
								quomov.setSeqno(0);
								try {
									quomov.setSeqno(new Integer(stlineitem
											.getSeqno()));
								} catch (Exception e) {
								}
								quomov.setSectionkey(stlineitem.getSectionkey());
								quomov.setVendoraddrkey(stlineitem
										.getVendoraddrkey());
								quomov.setFromlocationkey(stlineitem
										.getFromlocationkey());
								quomov.setFromg1key("");
								quomov.setFromg2key("");
								quomov.setFromg3key("");
								quomov.setFromg4key("");
								quomov.setTolocationkey(stlineitem
										.getTolocationkey());
								quomov.setTog1key("");
								quomov.setTog2key("");
								quomov.setTog3key("");
								quomov.setTog4key("");
								quomov.setInitfromday(false);
								quomov.setInittoday(false);
								quomov.setFromdayno(0);
								quomov.setTodayno(0);

								// create movement
								quomovbd.createOrUpdate(quomov, user);
								count1++;
							} catch (Exception e) {
							}

							for (Iterator ctit = stlineitem.getCtlineitems()
									.iterator(); ctit.hasNext();) {
								// get lineitem
								CosttemplateLineItem ctlineitem = (CosttemplateLineItem) ctit
										.next();
								try {
									Quocost quocost = new Quocost();
									quocost.setQuohdrId(quomov.getQuohdrId());
									quocost.setQuomovId(quomov.getQuomovId());
									quocost.setCostkey(ctlineitem.getCostkey());
									// quocost.setVendoraddrkey(ctlineitem.getVendoraddrkey());
									// if
									// (quocost.getVendoraddrkey().equals(""))
									// quocost.setVendoraddrkey(stlineitem.getVendoraddrkey());
									quocost.setCosttype(ctlineitem
											.getCosttype());
									quocost.setCcykey(ctlineitem.getCcykey());
									// if (quocost.getCcykey().equals(""))
									// quocost.setCcykey(quohdr.getCcykey());

									quocost.setUnits(new BigDecimal(1.0));
									try {
										quocost.setUnits(new BigDecimal(
												ctlineitem.getUnits()));
									} catch (Exception e) {
									}
									quocost.setUnitname("");
									quocost.setTxt("");

									// get vendor tariff
									quocost.setRate(new BigDecimal(0.0));
									quocost.setVendtarfhdrId("");
									try {
										// get first vtlineitem
										VendortariffLineItem vtlineitem = (VendortariffLineItem) ctlineitem
												.getVtlineitems().iterator()
												.next();
										quocost.setRate(vtlineitem
												.getUnitrate());
										quocost.setVendtarfhdrId(vtlineitem
												.getVendtarfhdrId());
										quocost.setVendoraddrkey(vtlineitem
												.getVendoraddrkey()
												.getAddrkey());
										if (quocost.getCcykey().equals(""))
											quocost.setCcykey(vtlineitem
													.getCcykey());
										quocost.setXrate(new BigDecimal(1.0));
										try {
											quocost.setXrate(this.getExrate(
													quocost.getCcykey(),
													quohdr.getCcykey()));
										} catch (Exception ae) {
										}
									} catch (Exception e) {
									}

									// units*rate
									quocost.setCstamt(new BigDecimal(0.0));
									try {
										quocost.setCstamt(quocost.getRate()
												.multiply(quocost.getUnits()));
									} catch (Exception e) {
									}

									// create cost
									quocostbd.createOrUpdate(quocost, user);
									count2++;
								} catch (Exception e) {
								}
							}// for costs
						}// for sections

					} catch (Exception e) {
					}

					messages.add("generated", new ActionMessage(
							"generatextemplate.information.generated", count1,
							count2));
					editForm.setList1(null);

				}// no errors

			}

			// REFRESH ACTION
			if (editForm.getBtnSubmit().equals(REFRESH_ACTION)) {

				try {

					// get updated rows
					List sectiontemplateLineitems = new ArrayList();
					for (Iterator stit = editForm.getList1().iterator(); stit
							.hasNext();) {
						// get lineitem
						SectiontemplateLineItem stlineitem = (SectiontemplateLineItem) stit
								.next();

						// get screen input parameters for row and update values
						stlineitem.setVendoraddrkey(request
								.getParameter("stVendoraddrkey"
										+ stlineitem.getRow()));
						stlineitem.setFromlocationkey(request
								.getParameter("stFromlocationkey"
										+ stlineitem.getRow()));
						stlineitem.setTolocationkey(request
								.getParameter("stTolocationkey"
										+ stlineitem.getRow()));

						List costtemplateLineitems = new ArrayList();
						try {

							for (Iterator ctit = stlineitem.getCtlineitems()
									.iterator(); ctit.hasNext();) {
								// get lineitem
								CosttemplateLineItem ctlineitem = (CosttemplateLineItem) ctit
										.next();

								// get screen input parameters for row and
								// update values
								ctlineitem.setVendoraddrkey(request
										.getParameter("ctVendoraddrkey"
												+ stlineitem.getRow() + "_"
												+ ctlineitem.getRow()));
								ctlineitem.setCcykey(request
										.getParameter("ctCcykey"
												+ stlineitem.getRow() + "_"
												+ ctlineitem.getRow()));
								// default to section template vendor if blank
								if (ctlineitem.getVendoraddrkey().equals(""))
									ctlineitem.setVendoraddrkey(stlineitem
											.getVendoraddrkey());

								// ctlineitem.setUnits("0");
								// if
								// (ctlineitem.getCosttype().equals("LUMPSUM")
								// ||
								// ctlineitem.getCosttype().equals("LUMPSUM"))
								// ctlineitem.setUnits("1");
								try {
									String ctUnits = request
											.getParameter("ctUnits"
													+ stlineitem.getRow() + "_"
													+ ctlineitem.getRow());
									if (!ctUnits.equals("null"))
										ctlineitem.setUnits(ctUnits);
								} catch (Exception e) {
								}

								// set VENDOR TARIFFS list
								try {
									List vendortariffLineitems = this
											.setVtList(
													ctlineitem.getCostkey(), // costkey
													stlineitem
															.getFromlocationkey(), // fromlocationkey
													stlineitem
															.getTolocationkey(), // tolocationkey
													"", // producthazardous - WE ARE NOT USING THIS AT THE MOMENT TO RETRIEVE VTs
													ctlineitem.getCcykey(), // ccykey
													ctlineitem
															.getVendoraddrkey(), // vendoraddrkey
													ctlineitem.getCosttype(), // unittype
													ctlineitem.getUnits(), // units
													stlineitem
															.getSectiontemplateId(),
													ctlineitem
															.getCosttemplateId());

									// init collection
									ctlineitem
											.setVtlineitems(vendortariffLineitems);

									// default vt selected to first vtlineitem
									String vtselectedValue = "";
									try {
										VendortariffLineItem vtlineitem = (VendortariffLineItem) vendortariffLineitems
												.iterator().next();
										vtselectedValue = stlineitem
												.getSectiontemplateId()
												+ "|"
												+ ctlineitem
														.getCosttemplateId()
												+ "|"
												+ vtlineitem.getVendtarfhdrId();
										ctlineitem
												.setVtselectedValue(vtselectedValue);
									} catch (Exception e) {
									}
								} catch (Exception e) {
								}

								// store updated lineitem
								costtemplateLineitems.add(ctlineitem);
							}

						} catch (Exception e) {
							log.error("[" + this.getClass().getName() + "] "
									+ new java.util.Date()
									+ " set COSTS list: exception: "
									+ e.getMessage());
						}

						stlineitem.setCtlineitems(costtemplateLineitems);
						// store updated lineitem
						sectiontemplateLineitems.add(stlineitem);
					}

					editForm.setList1(sectiontemplateLineitems);
					// Reset the update boxes
					editForm.setSelectedObjects1(null);

				} catch (Exception e) {
					log.error("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " set SECTIONS list: exception: "
							+ e.getMessage());
				}

				editForm.setBtnSubmit(null);
				editForm.setAction("");

			}

		}
		// submit
		// button-----------------------------------------------------------<

		// INIT ACTION
		if (action.equals(INIT_ACTION)) {

			List sectiontemplateLineitems = new ArrayList();
			int strow = 1;
			try {

				// retrieve template for section by shipmethod
				List sectiontemplates = sectiontemplatebd
						.findSectiontemplatesById(quohdr.getShipmethod());
				// loop template records
				for (Iterator stit = sectiontemplates.iterator(); stit
						.hasNext();) {
					Sectiontemplate stdao = (Sectiontemplate) stit.next();
					SectiontemplateLineItem stlineitem = new SectiontemplateLineItem();

					// init location parameters
					String fromlocation = "";
					if (stdao.getFromlocationcode().equals("PICKUP"))
						fromlocation = quohdr.getLdglocationkey1();
					if (stdao.getFromlocationcode().equals("PORT_LOADING"))
						fromlocation = quohdr.getLdglocationkey2();
					if (stdao.getFromlocationcode().equals("PORT_DISCHARGE"))
						fromlocation = quohdr.getDchlocationkey2();
					if (stdao.getFromlocationcode().equals("DELIVERY"))
						fromlocation = quohdr.getDchlocationkey1();
					String tolocation = "";
					if (stdao.getTolocationcode().equals("PICKUP"))
						tolocation = quohdr.getLdglocationkey1();
					if (stdao.getTolocationcode().equals("PORT_LOADING"))
						tolocation = quohdr.getLdglocationkey2();
					if (stdao.getTolocationcode().equals("PORT_DISCHARGE"))
						tolocation = quohdr.getDchlocationkey2();
					if (stdao.getTolocationcode().equals("DELIVERY"))
						tolocation = quohdr.getDchlocationkey1();

					// init fields
					stlineitem.setSectiontemplateId(stdao
							.getSectiontemplateId() + "");
					stlineitem.setSeqno(stdao.getSeqno() + "");
					Section section = null;
					section = sectionbd.read(stdao.getSectionkey());
					if (section == null)
						section = new Section();
					stlineitem.setSection(section);
					stlineitem.setSectionkey(stdao.getSectionkey());
					Location location = null;
					location = locationbd.read(fromlocation);
					if (location == null)
						location = new Location();
					stlineitem.setFromlocation(location);
					stlineitem.setFromlocationkey(location.getLocationkey());
					location = null;
					location = locationbd.read(tolocation);
					if (location == null)
						location = new Location();
					stlineitem.setTolocation(location);
					stlineitem.setTolocationkey(location.getLocationkey());
					stlineitem.setVendoraddrkey("");
					stlineitem.setRow(strow + "");

					// set COSTS list
					// retrieve template for cost by section
					List costtemplateLineitems = new ArrayList();
					int ctrow = 1;
					try {

						List costemplates = costtemplatebd
								.findCosttemplatesById(stdao.getSectionkey());
						// loop template records
						for (Iterator ctit = costemplates.iterator(); ctit
								.hasNext();) {
							Costtemplate ctdao = (Costtemplate) ctit.next();
							CosttemplateLineItem ctlineitem = new CosttemplateLineItem();

							// init fields
							ctlineitem.setCosttemplateId(ctdao
									.getCosttemplateId() + "");
							ctlineitem.setCosttype(ctdao.getCosttype());
							ctlineitem.setCostkey(ctdao.getCostkey());
							ctlineitem.setVendoraddrkey(ctdao
									.getVendoraddrkey());

							ctlineitem.setCcykey(ctdao.getCcykey());
							// default to quote header ccy if blank
							// if (ctlineitem.getCcykey().equals(""))
							// ctlineitem.setCcykey(quohdr.getCcykey());

							//ctlineitem.setAvgtariffcalcflag(ctdao.isAvgtariffcalcflag());//NOT USING THIS
							ctlineitem.setTariffvarianceflag(ctdao.isTariffvarianceflag());
							//ctlineitem.setAvgtariffratebase(ctdao.getAvgtariffratebase());//NOT USING THIS
							ctlineitem.setMaxtariffvariance(ctdao.getMaxtariffvariance());
							ctlineitem.setMintariffvariance(ctdao.getMintariffvariance());
							ctlineitem.setUnits("0");
							if (ctlineitem.getCosttype().equals("LUMPSUM")
									|| ctlineitem.getCosttype().equals(
											"LUMPSUM"))
								ctlineitem.setUnits("1");
							ctlineitem.setRow(ctrow + "");

							// set VENDOR TARIFFS list
							try {
								List vendortariffLineitems = this
										.setVtList(
												ctlineitem.getCostkey(), // costkey
												stlineitem.getFromlocationkey(), // fromlocationkey
												stlineitem.getTolocationkey(), // tolocationkey
												"", // producthazardous - WE ARE NOT USING THIS AT THE MOMENT TO RETRIEVE VTs
												ctlineitem.getCcykey(), // ccykey
												ctlineitem.getVendoraddrkey(), // vendoraddrkey
												ctlineitem.getCosttype(), // unittype
												ctlineitem.getUnits(), // units
												stlineitem
														.getSectiontemplateId(),
												ctlineitem.getCosttemplateId());

								// init collection
								ctlineitem
										.setVtlineitems(vendortariffLineitems);

								// default vt selected to first vtlineitem
								String vtselectedValue = "";
								try {
									VendortariffLineItem vtlineitem = (VendortariffLineItem) vendortariffLineitems
											.iterator().next();
									vtselectedValue = stlineitem
											.getSectiontemplateId()
											+ "|"
											+ ctlineitem.getCosttemplateId()
											+ "|"
											+ vtlineitem.getVendtarfhdrId();
									ctlineitem
											.setVtselectedValue(vtselectedValue);
								} catch (Exception e) {
								}
							} catch (Exception e) {
							}

							/****
							 * DO NOT NEED THIS HERE - WILL REMOVE WHEN FINISHED
							 * THE VT AVERAGE BUILD PROCESS try { if
							 * (ctlineitem.isTariffvarianceflag()) {
							 * System.out.println("ctunitratebasetotal-" +
							 * ctunitratebasetotal); System.out .println(
							 * "new BigDecimal(vendortariffLineitems.size())-" +
							 * new BigDecimal( vendortariffLineitems .size()));
							 * ctlineitem
							 * .setAvgtariffratebasecalc(ctunitratebasetotal
							 * .floatValue() / vendortariffLineitems .size());
							 * if (ctlineitem.isAvgtariffcalcflag()) {
							 * ctlineitem .setMintariffvariancecalc((ctlineitem
							 * .getAvgtariffratebasecalc() * ctlineitem
							 * .getMintariffvariance() .floatValue()) / 100);
							 * ctlineitem .setMaxtariffvariancecalc((ctlineitem
							 * .getAvgtariffratebasecalc() * ctlineitem
							 * .getMaxtariffvariance() .floatValue()) / 100); }
							 * else { ctlineitem
							 * .setMintariffvariancecalc((ctlineitem
							 * .getAvgtariffratebase() .floatValue() *
							 * ctlineitem .getMintariffvariance() .floatValue())
							 * / 100); ctlineitem
							 * .setMaxtariffvariancecalc((ctlineitem
							 * .getAvgtariffratebase() .floatValue() *
							 * ctlineitem .getMaxtariffvariance() .floatValue())
							 * / 100); } } } catch (Exception e) { }
							 ******/

							// add ct lineitem
							costtemplateLineitems.add(ctlineitem);
							ctrow++;
						}

					} catch (Exception e) {
						log.error("[" + this.getClass().getName() + "] "
								+ new java.util.Date()
								+ " set COSTS list: exception: "
								+ e.getMessage());
					}

					// init collection
					stlineitem.setCtlineitems(costtemplateLineitems);
					// add lineitem
					sectiontemplateLineitems.add(stlineitem);
					strow++;
				}

				editForm.setList1(sectiontemplateLineitems);
				// Reset the update boxes
				editForm.setSelectedObjects1(null);

			} catch (Exception e) {
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
						+ " set SECTIONS list: exception: " + e.getMessage());
			}

			editForm.setAction("");
		}// INIT ACTION

		// clear bd
		quohdrbd = null;
		quomovbd = null;
		quocostbd = null;
		quoprodbd = null;
		addressbd = null;
		locationbd = null;
		sectiontemplatebd = null;
		costtemplatebd = null;

		// validation
		// Report any messages back to the original form
		if (!messages.isEmpty()) {
			saveAppInformationMessages(request, messages);
			return findFailure(mapping);
		}
		// Report any errors back to the original form
		if (!errors.isEmpty()) {
			saveAppErrorMessages(request, errors);
			return findFailure(mapping);
		}

		// Forward control to the edit page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page");

		return findSuccess(mapping);

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

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Check Exrate - " + " fromccy: "
					+ fromccy + " toccy: " + toccy + " exrate: " + exrate);
			ccyexbd = null;
		} catch (Exception ae) {
		}

		return exrate;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List setVtList(String costkey, String fromlocationkey,
			String tolocationkey, String producthazardous, String ccykey,
			String vendoraddrkey, String costtype, String units,
			String SectiontemplateId, String CosttemplateId) throws Exception {

		List vtList = new ArrayList();
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " setVtlineitems - Costkey: " + costkey 
				+ " Costtype: " + costtype 
				+ " Units: " + units
				+ " Fromlocationkey: " 	+ fromlocationkey 
				+ " Tolocationkey: "+ tolocationkey 
				+ " Ccykey: " + ccykey 
				+ " Vendoraddrkey: "	+ vendoraddrkey
				+ " Producthazardous: " + producthazardous);

		int vtrow = 1;
		try {
			VendortariffhdrBD vendortariffhdrbd = new VendortariffhdrBD(
					this.getSessionFactoryClusterMap());
			VendortariffavgBD vendortariffavgbd = new VendortariffavgBD(
					this.getSessionFactoryClusterMap());
			
			List vendortariffs = vendortariffhdrbd.vendortariffSearch2(costkey,
					fromlocationkey, tolocationkey, producthazardous, ccykey,
					vendoraddrkey, costtype, units, new Date(), // current date
					"VendtarfhdrId" // order
			);
			// loop template records
			for (Iterator vtit = vendortariffs.iterator(); vtit.hasNext();) {
				VendortariffLineItem vtlineitem = (VendortariffLineItem) vtit
						.next();

				// init exchange rates
				vtlineitem.setUnitratebase(vtlineitem.getUnitrate());
				BigDecimal exrate = new BigDecimal(1);
				// check base and tariff ccys are different
				if (!vtlineitem.getCcykey().equals(baseccykey)) {
					try {
						exrate = this.getExrate(vtlineitem.getCcykey(),
								baseccykey);
					} catch (Exception ae) {
					}
				}

				// init fields
				// calculate base rate
				try {
					vtlineitem.setUnitratebase(vtlineitem.getUnitrate()
							.multiply(exrate));
				} catch (Exception e) {
				}
				vtlineitem.setRow(vtrow + "");

				vtlineitem.setId(SectiontemplateId + "|" + CosttemplateId + "|"	+ vtlineitem.getVendtarfhdrId());

				
				//retreive vendor tariff average rate average
				try {
					Vendortariffavg vtAvg = null;
					//unitrate
					if (costtype.equals("UNIT") || costtype.equals("DISTANCE")) {
						vtAvg = vendortariffavgbd.findVendortariffAvgForUnitrate(
								costkey, fromlocationkey, tolocationkey, producthazardous, new Integer(units), new Date()
								);
						vtlineitem.setUnitrateavg(vtAvg.getUnitrate());							
					} 
					//lumpsum
					else {
						vtAvg = vendortariffavgbd.findVendortariffAvgForLumpsum(
								costkey, fromlocationkey, tolocationkey, producthazardous, new Date()
								);
						vtlineitem.setLumpsumavg(vtAvg.getLumpsum());						
					}
					log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
					+ " setVtlineitems - vtAvg: "  
					+ " unitrate: " + vtAvg.getUnitrate() + " lumpsum: "
					+ vtAvg.getLumpsum() );					
				} catch (Exception e) {
				}
				
				
				// add vt lineitem
				vtList.add(vtlineitem);
				vtrow++;
			}

			vendortariffhdrbd = null;
			vendortariffavgbd = null;			
		} catch (Exception e) {
		}

		return vtList;
	}

}

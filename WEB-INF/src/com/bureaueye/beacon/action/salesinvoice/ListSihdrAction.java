package com.bureaueye.beacon.action.salesinvoice;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Hibernate;

import com.bureaueye.beacon.action.BaseAction;
import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.order.Orderfile;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.bd.OrderfileBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.salesinvoice.Sihdr;
import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.bd.SihdrBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.Userlistform;
import com.bureaueye.beacon.model.standard.bd.UserlistformBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfReader;

/**
 * 
 * Amendments ----------
 * 
 * NT 2013-12-11 WSI-201311-0002 BEACON LAKER (WSI LINER) - Sales Invoice
 * Template
 * 
 * NT 2014-06-09 201400026 - Add 'Order No' Descending Sort Order to Order list
 * - Add 'Doc Id' Descending Sort Order to Sales Invoice List
 * 
 */
public final class ListSihdrAction extends BaseAction {

	public ListSihdrAction() {
	}

	@SuppressWarnings("rawtypes")
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.USER_KEY);

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

		ListForm listForm = (ListForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		if (listForm.getButton() != null) {

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " button = "
					+ listForm.getButton());

			// PRINT
			// PROCESS==========================================================>
			if ((listForm.getSelectedObjects() != null)
					&& (listForm.getButton().equals("PRINT") || listForm
							.getButton().equals("TESTPRINT"))) {

				try {

					// init BD
					SystemcodeBD systemcodebd;
					XdocumentBD xdocumentbd;
					systemcodebd = new SystemcodeBD(
							this.getSessionFactoryClusterMap());
					xdocumentbd = new XdocumentBD(
							this.getSessionFactoryClusterMap());

					Systemcode systemcodedao = null;
					String workDirectory = "";
					try {
						systemcodedao = systemcodebd
								.findSystemcodesByTypekeyCodekey("BEACONDMS",
										"WORKDIRECTORY");
						workDirectory = systemcodedao.getDescr();
					} catch (ApplicationException e) {
						log.error("["
								+ this.getClass().getName()
								+ "] "
								+ new java.util.Date()
								+ " findSystemcodesByTypekeyCodekey: ApplicationException: "
								+ e.getMessage());
					} catch (Exception e) {
						log.error("["
								+ this.getClass().getName()
								+ "] "
								+ new java.util.Date()
								+ " findSystemcodesByTypekeyCodekey: Exception: "
								+ e.getMessage());
					}

					// get selected rows
					int[] selectedObjects = listForm.getSelectedObjects();
					if (selectedObjects != null) {

						// init document combined file
						response.setContentType("application/pdf");
						ServletOutputStream outStream = response
								.getOutputStream();
						PdfCopyFields mergedDocument = new PdfCopyFields(
								outStream);

						for (int i = 0; i < selectedObjects.length; i++) {
							Integer id = new Integer(selectedObjects[i]);

							// GENERATE DOCUMENT
							// check document key already generated
							String key = id + "|SALES_INVOICE";

							// find document if already generated
							Xdocument xdocumentdao = null;
							try {
								xdocumentdao = xdocumentbd
										.findXdocumentByDockey(key);
							} catch (Exception e) {
							}
							// if not found generate new document
							if (xdocumentdao == null)
								xdocumentdao = new Xdocument();

							user.setUserid(user.getUserid());

							// store file information
							xdocumentdao.setSourcefilename("");
							xdocumentdao.setFilename("");
							xdocumentdao.setFilesize(0);
							xdocumentdao.setContenttype("");

							xdocumentdao.setDoctype("SALES_INVOICE");
							xdocumentdao.setCreateaction(Constants.GENERATE);

							// init id
							xdocumentdao.setDocid(id.toString());
							xdocumentdao.setDockey(key);

							xdocumentdao.setErrors("");
							xdocumentdao.setWarnings("");
							xdocumentdao.setCompanykey(user.getCompanykey());
							xdocumentdao.setDepartmentkey(user
									.getDepartmentkeylist());
							xdocumentdao.setActivitykey(user.getActvid());

							xdocumentdao.setTxt1("");
							xdocumentdao.setTxt2("");
							xdocumentdao.setCategorycode("");
							xdocumentdao.setSubcategorycode("");
							xdocumentdao.setGroupid("");
							xdocumentdao.setTransactionid("");
							xdocumentdao.setModuleid("");
							xdocumentdao.setDocument("");
							xdocumentdao.setControlid("");

							// store document
							xdocumentdao.setXmldocument("");

							xdocumentbd.createOrUpdate(xdocumentdao, user);

							// print Sales
							// invoice===========================================>
							// build class and worker method
							Method printWorker = null;
							Class<?> printClass = null;
							try {
								printClass = Class.forName(user
										.getSalesinvoiceprintclass());
								Class[] argTypes = {
										Integer.class,
										String.class,
										com.bureaueye.beacon.model.standard.User.class,
										java.util.Map.class };

								String methodName = "executePrint";
								// initialise work method depending on process
								printWorker = printClass.getMethod(methodName,
										argTypes);

								// initialise actual data to send
								Object[] theData = { id, "Print", user,
										this.getSessionFactoryClusterMap() };
								// invoke worker method
								printWorker.invoke(printClass.newInstance(),
										theData);
							} catch (Exception x) {
								log.error("[" + this.getClass().getName()
										+ "] " + new java.util.Date()
										+ " Print Sales Invoice Exception: "
										+ x.getMessage());
							}
							// print Sales
							// invoice===========================================<

							// generate print file
							String printFilename = "";
							printFilename = workDirectory + "\\SALES_INVOICE"
									+ id + ".pdf";
							File printFile = new File(printFilename);

							log.debug("[" + this.getClass().getName() + "] "
									+ new Date() + " print file: "
									+ printFilename);

							// store print file
							try {

								FileInputStream fin = new FileInputStream(
										printFile);

								// merge documents onto one screen output
								PdfReader pdfReader = new PdfReader(fin);
								mergedDocument.addDocument(pdfReader);

								// read document into byte file to store in
								// database
								byte fileContent[] = new byte[(int) printFile
										.length()];
								fin.read(fileContent);
								fin.close();

								// upload file information
								xdocumentdao.setFilebin(Hibernate
										.createBlob(fileContent));
								// store file information
								xdocumentdao.setFilename(printFile.getName());
								xdocumentdao.setFilesize((int) printFile
										.length());
								xdocumentdao.setContenttype("application/pdf");
								xdocumentdao.setLanguageid("en");
								xdocumentdao.setTestindicator("");

								// store desctiption and category
								xdocumentdao.setDescription("SALES INVOICE");
								xdocumentdao.setCategorycode("FINANCE");
								xdocumentdao
										.setSubcategorycode("SALES_INVOICE");

								// set receive details
								xdocumentdao.setReceivedate(xdocumentdao
										.getCreatedate());
								xdocumentdao.setReceivetime(xdocumentdao
										.getCreatetime());

								xdocumentdao.setXmlheader("");

								xdocumentbd.createOrUpdate(xdocumentdao, user);

							} catch (Exception ae) {
								log.error("[" + this.getClass().getName()
										+ "] " + new java.util.Date()
										+ " Store: Exception: "
										+ ae.getMessage());
								throw new Exception();
							}

						}// end loop

						// close merged document
						mergedDocument.close();

					}// selected check

					// clear BD
					systemcodebd = null;
					xdocumentbd = null;

				} catch (Exception e) {
					log.error("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " executePrint: Exception: " + e.getMessage());
				} finally {
					// reset select objects
					listForm.setSearchString15(null);
					listForm.setSelectedObjects(null);
					listForm.setButton("");
				}

				return null;
			}
			// PRINT
			// PROCESS==========================================================<

			// EMAIL
			// PROCESS==========================================================>
			if (listForm.getButton().equals("EMAIL")) {

				listForm.setHeaderInfo1("Sales Invoice");// subject
				listForm.setHeaderInfo2(user.getEmail());// from
				listForm.setHeaderInfo3("");// to
				listForm.setHeaderInfo4("");// cc
				listForm.setHeaderInfo5(Util.dateTextFormat2(new Date()));// today
				listForm.setHeaderInfo6("");// text
				listForm.setHeaderInfo7("");

				List<Sihdr> sihdrdaos = new LinkedList<Sihdr>();
				try {
					SihdrBD sihdrbd = new SihdrBD(
							this.getSessionFactoryClusterMap());
					// init sales invoice records
					// get selected rows
					int[] selectedObjects = listForm.getSelectedObjects();
					if (selectedObjects != null) {
						for (int i = 0; i < selectedObjects.length; i++) {
							Integer id = new Integer(selectedObjects[i]);

							// read header
							Sihdr sihdrdao = null;
							sihdrdao = sihdrbd.read(id);

							// process if invoice printed
							if (sihdrdao.isPrintedflag())
								sihdrdaos.add(sihdrdao);
						}// end loop
					}

					// init details
					listForm.setLineItems(sihdrdaos);

					sihdrbd = null;
				} catch (Exception e) {
					log.error("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " executeEmail: Exception: " + e.getMessage());
				}

				try {
					// init document records from sales invoice orders
					// init bds
					SidtlBD sidtlbd = new SidtlBD(
							this.getSessionFactoryClusterMap());
					OrderfileBD orderfilebd = new OrderfileBD(
							this.getSessionFactoryClusterMap());
					OrderhdrBD orderhdrbd = new OrderhdrBD(
							this.getSessionFactoryClusterMap());
					// init collections
					List<SidtlDTO> sidtldtos = new LinkedList<SidtlDTO>();
					List<Orderfile> orderfiledaos = new LinkedList<Orderfile>();
					Hashtable<String, Orderfile> orderfiledaosHt = new Hashtable<String, Orderfile>();
					// process sales invoice headers
					Iterator<Sihdr> it = sihdrdaos.iterator();
					LOOP1: while (it.hasNext()) {
						Sihdr sihdrdao = (Sihdr) it.next();

						// do not process manual sales invoices
						if (sihdrdao.isManualflag())
							continue LOOP1;

						// find si details
						sidtldtos = sidtlbd.findSidtlsById(sihdrdao
								.getSihdrId().toString(), 0,
								Constants.MAX_RESULTS_NOLIMIT, "Chargekey");

						if (sidtldtos != null) {
							log.debug("[" + this.getClass().getName() + "] "
									+ new java.util.Date()
									+ " sales invoice details size :"
									+ sidtldtos.size());

							// process sales invoice details
							Iterator<SidtlDTO> it2 = sidtldtos.iterator();
							while (it2.hasNext()) {
								SidtlDTO sidtldto = (SidtlDTO) it2.next();

								// retrieve all documents for order
								orderfiledaos = orderfilebd.findOrderfilesById(
										sidtldto.getOrderhdrId().toString(), 0,
										Constants.MAX_RESULTS_NOLIMIT,
										"OrderhdrId", "Createdate");

								if (orderfiledaos != null) {
									log.debug("[" + this.getClass().getName()
											+ "] " + new java.util.Date()
											+ " order files size :"
											+ orderfiledaos.size());

									// process order documents
									Iterator<Orderfile> it3 = orderfiledaos
											.iterator();
									while (it3.hasNext()) {
										Orderfile orderfiledao = (Orderfile) it3
												.next();
										// find header
										Orderhdr orderhdrdao = orderhdrbd
												.read(orderfiledao
														.getOrderhdrId());
										String key = orderhdrdao.getOrderno()
												+ "|"
												+ orderfiledao.getDescription();
										// check already exists
										if (orderfiledaosHt.get(key) == null) {

											log.debug("["
													+ this.getClass().getName()
													+ "] "
													+ new java.util.Date()
													+ " put key :" + key);

											orderfiledaosHt.put(key,
													orderfiledao);

										}
									}
								}// check orderfiledaos not null

							}
						}// check sidtldtos not null
					}

					// init details
					listForm.setLineItemsHt(orderfiledaosHt);

					log.debug("[" + this.getClass().getName() + "] "
							+ new java.util.Date() + " list itemsHt size :"
							+ listForm.getLineItemsHt().size());

					// clear bds
					sidtlbd = null;
					orderfilebd = null;
					orderhdrbd = null;
					// clear collections
					sidtldtos = null;
					orderfiledaos = null;
					orderfiledaosHt = null;

				} catch (Exception e) {
					log.error("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " executeEmail: Exception: " + e.getMessage());
				} finally {
					// reset select objects
					listForm.setSearchString15(null);
					listForm.setSelectedObjects(null);
					listForm.setButton("");
				}

				return mapping.findForward("email");
			}// EMAIL
				// PROCESS==========================================================<

		}

		// init listform with latest user search
		// criteria==============================================>
		UserlistformBD userlistformbd = new UserlistformBD(
				this.getSessionFactoryClusterMap());
		// check first time in
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy2("");
			log.info("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " ListAction: Init UserListForm: "
					+ " Userid: " + user.getUserid() + " ListForm: "
					+ mapping.getName());
			// retrieve user listform record
			Userlistform userlistformdao = null;
			try {
				userlistformdao = userlistformbd.findUserlistformByKey1(
						user.getUserid(), mapping.getName());
			} catch (ApplicationException e) {
			}
			if (userlistformdao != null) {

				try {
					BeanUtils.copyProperties(listForm, userlistformdao);
					// refresh search dates - these will not be included in the
					// search criteria
					listForm.setSearchDate1dd("");
					listForm.setSearchDate2dd("");
					log.info("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " ListAction: Retrieve UserListForm: Id: "
							+ userlistformdao.getUserlistformId());
				} catch (Exception e) {
				}

			}
			userlistformdao = null;
		}
		// store listform user search
		else {
			log.info("[" + this.getClass().getName() + "] "
					+ new java.util.Date()
					+ " ListAction: Store UserListForm: " + " Userid: "
					+ user.getUserid() + " ListForm: " + mapping.getName());
			// retreive user listform record
			Userlistform userlistformdao = null;
			try {
				userlistformdao = userlistformbd.findUserlistformByKey1(
						user.getUserid(), mapping.getName());
			} catch (ApplicationException e) {
			}
			if (userlistformdao == null) {
				userlistformdao = new Userlistform();
				userlistformdao.setUserid(user.getUserid());
				userlistformdao.setListform(mapping.getName());
			}
			if (userlistformdao != null) {

				try {
					BeanUtils.copyProperties(userlistformdao, listForm);
					userlistformbd.createOrUpdate(userlistformdao, user);
					log.info("[" + this.getClass().getName() + "] "
							+ new java.util.Date()
							+ " ListAction: createOrUpdate UserListForm: Id: "
							+ userlistformdao.getUserlistformId());
				} catch (Exception e) {
				}

			}
			userlistformdao = null;
		}
		userlistformbd = null;
		// init listform with latest user search
		// criteria==============================================<

		// Calculate the total number of results before any buttons are
		// generated and default values
		setTotalResults(listForm);

		// Calculate the total number of results before any buttons are
		// generated and default values from SESSION
		setTotalResults(listForm, session);

		// Initialise previous page results if action selected
		if (request.getParameter("previousButton.x") != null)
			listForm.setPreviousPage();
		else
		// initialise next page results if action selected
		if (request.getParameter("nextButton.x") != null)
			listForm.setNextPage();
		else
		// initialise start page results
		if (request.getParameter("startButton.x") != null)
			listForm.setStartPage();
		else
		// initialise end page results
		if (request.getParameter("endButton.x") != null)
			listForm.setEndPage();

		if (request.getParameter("searchButton.x") != null)
			// reset page/result values if new Search
			listForm.setStartPage();

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " GotoPage = " + listForm.getGotoPage() + ", maxResults = "
				+ listForm.getMaxResults() + ", totalResults = "
				+ listForm.getTotalResults() + ", searchButton.x = "
				+ request.getParameter("searchButton.x")
				+ ", previousButton.x = "
				+ request.getParameter("previousButton.x")
				+ ", nextButton.x = " + request.getParameter("nextButton.x")
				+ ", endButton.x = " + request.getParameter("endButton.x")
				+ ", startButton.x = " + request.getParameter("startButton.x"));

		if ((listForm.getGotoPage() * listForm.getMaxResults() == listForm
				.getTotalResults()) && listForm.getGotoPage() > 0) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Taking one off");
			listForm.setPreviousPage();
		}

		// populate list items
		ActionMessages messages = setLineItems(listForm);
		if (messages != null) {
			saveMessages(request, messages);
			return findFailure(mapping);
		}

		// initialise Pagination
		if (listForm.getGotoPage() == 0) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Setting firstpage to true");
			listForm.setFirstPage(true);
		}
		if (listForm.getGotoPage() == ((listForm.getTotalResults() - 1) / listForm
				.getMaxResults())) {
			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " Setting lastpage to true");
			listForm.setLastPage(true);
		}

		// reset select objects
		listForm.setSelectedObjects(null);
		listForm.setSearchString15(null);

		// Forward control to the edit user registration page
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Forwarding to 'success' page: "
				+ findSuccess(mapping).getPath());

		return findSuccess(mapping);
	}

	public void setTotalResults(ListForm listForm) throws ApplicationException {

		// Set the default ordering
		if (listForm.getOrderBy() == null) {
			listForm.setOrderBy("SihdrId");
		}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("Createdate"))
			listForm.setOrderByDesc("desc");

		// 201400026
		// set order by 2
		listForm.setOrderBy2("");
		listForm.setOrderBy2Desc("");		
		if (!listForm.getOrderBy().equals("") && !listForm.getOrderBy().equals("SihdrId")) {
			listForm.setOrderBy2("SihdrId");
			listForm.setOrderBy2Desc("desc");
		}
		
		// set default max results
		if (listForm.getMaxResults() == 0) {
			listForm.setMaxResults(com.bureaueye.beacon.bean.Constants.MAX_RESULTS_DEFAULT);
		}

		// set default field values
		if (listForm.getSearchString1() == null)
			listForm.setSearchString1("");
		if (listForm.getSearchString2() == null)
			listForm.setSearchString2("");

		// customer
		if (listForm.getSearchString3() == null
				|| listForm.getSearchString3().equals("")) {
			listForm.setSearchString3("%");
		}

		Calendar c = Calendar.getInstance();
		int dateRangeDays = 7;
		try {
			dateRangeDays = new Integer(new SystemcodeBD(
					this.getSessionFactoryClusterMap()).read(
					new SystemcodePK("DATERANGEDAYS", "LISTSIHDR")).getDescr())
					.intValue();
		} catch (Exception e) {
		}
		// date 'from'
		if (listForm.getSearchDate1() == null) {
			c.add(Calendar.DATE, -1 * dateRangeDays);
			// default 'from' date to today minus 7
			try {
				listForm.setSearchDate1(c.getTime());
			} catch (Exception e) {
			}
		}
		// date 'to'
		if (listForm.getSearchDate2() == null) {
			// default 'to' date plus 7
			c.add(Calendar.DATE, dateRangeDays);
			try {
				listForm.setSearchDate2(c.getTime());
			} catch (Exception e) {
			}
		}

		int total = 0;
		listForm.setTotalResults(total);

	}

	@SuppressWarnings("rawtypes")
	public void setTotalResults(ListForm listForm, HttpSession session)
			throws ApplicationException {

		// default company
		if (listForm.getSearchString19() == null
				|| listForm.getSearchString19().equals("")) {
			listForm.setSearchString19("");
			try {
				List usercompanykeylist = (List) session
						.getAttribute(com.bureaueye.beacon.bean.standard.Constants.USERCOMPANYKEYLIST);
				Company companydao = (Company) usercompanykeylist.iterator()
						.next();
				listForm.setSearchString19(companydao.getCompid());
			} catch (Exception e) {
			}
		}

	}

	public ActionMessages setLineItems(ListForm listForm)
			throws ApplicationException {

		boolean processedflag = false;
		listForm.setLineItems(null);

		SihdrBD sihdrbd = new SihdrBD(this.getSessionFactoryClusterMap());

		if (!listForm.getSearchString1().equals("")) {
			listForm.setLineItems(sihdrbd
					.findSihdrsForSearchByInvoiceno(listForm));
			processedflag = true;
		}
		if (!listForm.getSearchString2().equals("")) {
			listForm.setLineItems(sihdrbd
					.findSihdrsForSearchBySihdrId(listForm));
			processedflag = true;
		}
		if (!processedflag) {
			listForm.setLineItems(sihdrbd.findSihdrsForSearch(listForm));
		}

		sihdrbd = null;

		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " setLineItems = " + listForm.toString());
		return null;
	}

}

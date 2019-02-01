package com.bureaueye.beacon.action.account.mas500;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.bureaueye.beacon.action.BaseAction;

import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.form.ListForm;
import com.bureaueye.beacon.model.account.Aibatch;
import com.bureaueye.beacon.model.account.Aiout;
import com.bureaueye.beacon.model.account.bd.AibatchBD;
import com.bureaueye.beacon.model.account.bd.AioutBD;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.User;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.system.SystemcodePK;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;

/**
 * 
 * Amendments ----------
 * 
 * NT 2014-02-27 201400005 Modify AI Batch Extract process to use Actual Company
 * Id for extract filenames
 * 
 */
public final class ListAIBatchAction extends BaseAction {

	ActionMessages appErrorMessages;
	ActionMessages appInformationMessages;

	PrintStream printStream;

	/**
	 */
	// maximum process time set to 5 mins
	public static final int MAX_PROCESS_TIME = 300000;
	private Calendar _startprocesstime;

	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// This will use the existing session, or create a new one if it has
		// timed out
		// The CheckLogonTag will make sure that the user is still logged in
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

		ListForm listForm = (ListForm) form;
		log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ "  Populating form");

		if (listForm.getButton() != null) {

			log.debug("[" + this.getClass().getName() + "] "
					+ new java.util.Date() + " button = "
					+ listForm.getButton());

			// SEND
			// PROCESS==========================================================>
			if (listForm.getButton().equals("SEND")) {

				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " sendBatchButton pressed");

				// Send Account Receivable Actuals
				this.SendAiout(com.bureaueye.beacon.bean.Constants.AR_ACTUAL,
						com.bureaueye.beacon.bean.Constants.AR);

				// Send Account Payable Actuals
				this.SendAiout(com.bureaueye.beacon.bean.Constants.AP_ACTUAL,
						com.bureaueye.beacon.bean.Constants.AP);

			}
			// SEND
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
			listForm.setOrderBy("AIBATCH_ID");
		}

		// order by
		listForm.setOrderByDesc("");
		if (listForm.getOrderBy().equals("AIBATCH_ID"))
			listForm.setOrderByDesc("desc");

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

		AibatchBD bd = new AibatchBD(this.getSessionFactoryClusterMap());
		listForm.setLineItems(bd.findAibatchsBySearch(listForm));
		bd = null;

		return null;
	}

	public void SendAiout(String doctype1, String doctype2) {

		setStartprocesstime();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		log.info("[" + this.getClass().getName() + "] " + new java.util.Date()
				+ " SendAiout: Run at: " + cal.getTime());

		// set user
		User user = new User();
		user.setUserid("OUTBOUND");

		// define business delegates
		AibatchBD aibatchbd = null;
		AioutBD aioutbd = null;
		CompanyBD companybd = null;

		SimpleDateFormat formatDate = new SimpleDateFormat("MMddyyyy");
		String sentDate = formatDate.format(new Date());

		try {

			// init business delegates
			aibatchbd = new AibatchBD(this.getSessionFactoryClusterMap());
			aioutbd = new AioutBD(this.getSessionFactoryClusterMap());
			companybd = new CompanyBD(this.getSessionFactoryClusterMap());

			// get ai company records
			List companydaos = null;
			try {
				companydaos = companybd.findCompanys();
			} catch (ApplicationException ae) {
				// Add an error message if io error
				appErrorMessages.add("errors.aibatch", new ActionMessage(
						"aibatch.error.exception", ae.getMessage()));
				log.error("[" + this.getClass().getName() + "] "
						+ new java.util.Date()
						+ " Error Exception with problem [" + ae.getMessage()
						+ "]");
			}

			// Define ListIterator and define Start position
			if (companydaos != null) {
				Iterator itLoop1 = companydaos.iterator();
				IN_LOOP1: while (itLoop1.hasNext()) {

					Company companydao = (Company) itLoop1.next();

					String accSyscompid = "";
					accSyscompid = companydao.getAccsyscompid();

					int batchCount = 0;
					int processCount = 0;
					int errorCount = 0;

					// get records in PENDING status for specific Company
					List aioutdaos = null;
					try {
						aioutdaos = aioutbd
								.findAIOutsByCompanykeyDoctypeAIstatus(
										companydao.getCompid(),
										doctype1,
										com.bureaueye.beacon.bean.Constants.PENDING_STATUS);
					} catch (ApplicationException ae) {
						// Add an error message if io error
						appErrorMessages.add(
								"errors.aibatch",
								new ActionMessage("aibatch.error.exception", ae
										.getMessage()));
						log.error("[" + this.getClass().getName() + "] "
								+ new java.util.Date()
								+ " Error Exception with problem ["
								+ ae.getMessage() + "]");
						continue IN_LOOP1;
					}

					if (aioutdaos != null && aioutdaos.size() > 0) {

						log.info("["
								+ this.getClass().getName()
								+ "] "
								+ new java.util.Date()
								+ " find aiouts: "
								+ " companykey["
								+ companydao.getCompid()
								+ "]"
								+ " doctype["
								+ doctype1
								+ "]"
								+ " aistatus["
								+ com.bureaueye.beacon.bean.Constants.PENDING_STATUS
								+ "]" + " aioutdaos[" + aioutdaos.size() + "]");

						// create batch
						Aibatch aibatchdao = new Aibatch();
						aibatchdao.setProcessstatus("PROCESS01");
						aibatchdao.setCompanyid(accSyscompid);
						aibatchdao.setCompanykey(companydao.getCompid());
						try {
							aibatchbd.createOrUpdate(aibatchdao, user);
						} catch (ApplicationException ae) {
							// Add an error message if io error
							appErrorMessages.add(
									"errors.aibatch",
									new ActionMessage(
											"aibatch.error.exception", ae
													.getMessage()));
							log.error("[" + this.getClass().getName() + "] "
									+ new java.util.Date()
									+ " Error Exception with problem ["
									+ ae.getMessage() + "]");
							continue IN_LOOP1;
						}

						// init output file
						String AI_OUTBOUND_DIRECTORY = com.bureaueye.beacon.bean.Constants.AI_OUTBOUND_DIRECTORY
								+ com.bureaueye.beacon.bean.Constants.AI_RECIPIENT_ID;
						try {
							AI_OUTBOUND_DIRECTORY = new SystemcodeBD(
									this.getSessionFactoryClusterMap())
									.read(new SystemcodePK("AI",
											"OUTBOUND_DIRECTORY")).getDescr();
						} catch (Exception e) {
						}

						DecimalFormat df = new java.text.DecimalFormat("000000");
						String controlid = df.format(aibatchdao.getAibatchId());
						String fileName1 = 
							//accSyscompid +//201400005
							companydao.getCompid() +//201400005
							"_" + doctype2 + "_"
								+ controlid + "_" + sentDate + ".csv";
						String outFileName1 = AI_OUTBOUND_DIRECTORY + "\\"
								+ fileName1;

						log.info("[" + this.getClass().getName() + "] "
								+ new java.util.Date() + " init output file: "
								+ " accSyscompid[" + accSyscompid + "]"
								+ " company.Compid[" + companydao.getCompid() + "]"//201400005								
								+ " doctype2[" + doctype2 + "]" + " controlid["
								+ controlid + "]" + " sentDate[" + sentDate
								+ "]" + " outFileName1[" + outFileName1 + "]");

						try {
							printStream = new PrintStream(
									new BufferedOutputStream(
											new FileOutputStream(outFileName1)));
						} catch (Exception ae) {
							appErrorMessages.add(
									"errors.aibatch",
									new ActionMessage(
											"aibatch.error.exception", ae
													.getMessage()));
							log.error("[" + this.getClass().getName() + "] "
									+ new java.util.Date()
									+ " Error Exception with problem ["
									+ ae.getMessage() + "]");
							continue IN_LOOP1;
						}

						if (doctype1
								.equals(com.bureaueye.beacon.bean.Constants.AR_ACTUAL))
							outputHeaderAR_ACTUAL();
						if (doctype1
								.equals(com.bureaueye.beacon.bean.Constants.AP_ACTUAL))
							outputHeaderAP_ACTUAL();

						// Define ListIterator and define Start position
						Iterator itLoop2 = aioutdaos.iterator();
						SEND_LOOP2: while (itLoop2.hasNext()) {
							batchCount++;
							Aiout aioutdao = (Aiout) itLoop2.next();

							log.debug("[" + this.getClass().getName() + "] "
									+ new Date() + " Processing: "
									+ aioutdao.getDockey());

							try {
								TreeMap<String, StringBuffer> returnParams = new TreeMap<String, StringBuffer>();

								// init
								aioutdao.setDocument("");
								aioutdao.setErrors("");
								aioutdao.setWarnings("");
								aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.PENDING_STATUS);

								// build class and worker method
								Method buildWorker = null;
								Class buildClass = null;
								try {
									buildClass = Class.forName(companydao
											.getAioutbuildclass());
									Class[] argTypes = {
											com.bureaueye.beacon.model.account.Aiout.class,
											java.util.Map.class };

									String methodName = "build";
									// initialise work mthod depending on
									// process
									buildWorker = buildClass.getMethod(
											methodName, argTypes);

									log.debug("[" + this.getClass().getName()
											+ "] " + new java.util.Date()
											+ "  Build Worker Name: "
											+ buildWorker.getName());

								} catch (ClassNotFoundException x) {
									log.error("["
											+ this.getClass().getName()
											+ "] "
											+ new java.util.Date()
											+ " init buildclass: ClassNotFoundException: "
											+ x.getMessage());
								} catch (NoSuchMethodException x) {
									log.error("["
											+ this.getClass().getName()
											+ "] "
											+ new java.util.Date()
											+ " init buildclass: NoSuchMethodException: "
											+ x.getMessage());
								} catch (Exception e) {
									log.error("[" + this.getClass().getName()
											+ "] " + new java.util.Date()
											+ " init buildclass exception: "
											+ e.getMessage());
								}

								log.debug("[" + this.getClass().getName()
										+ "] " + new Date()
										+ " Build Document BuildClass: "
										+ companydao.getAioutbuildclass());

								try {
									// initialise actual data to send
									Object[] theData = { aioutdao,
											this.getSessionFactoryClusterMap() };
									// invoke worker method
									returnParams = (TreeMap) buildWorker
											.invoke(buildClass.newInstance(),
													theData);
								} catch (IllegalAccessException x) {
									log.error("["
											+ this.getClass().getName()
											+ "] "
											+ new java.util.Date()
											+ " invoke buildWorker: IllegalAccessException: "
											+ x.getMessage());
								} catch (InvocationTargetException x) {
									log.error("["
											+ this.getClass().getName()
											+ "] "
											+ new java.util.Date()
											+ " invoke buildWorker: InvocationTargetException: "
											+ x.getMessage());
								} catch (Exception x) {
									log.error("["
											+ this.getClass().getName()
											+ "] "
											+ new java.util.Date()
											+ " invoke buildWorker: Exception: "
											+ x.getMessage());
								}

								// store
								aioutdao.setDocument(returnParams.get("1")
										.toString());
								aioutdao.setErrors(returnParams.get("2")
										.toString());
								if (!aioutdao.getErrors().equals("")) {
									aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.IN_ERROR_STATUS);
								}
								aioutdao.setWarnings(returnParams.get("3")
										.toString());
							} catch (Exception e) {
							}

							// update process status
							aibatchdao.setProcessstatus("PROCESS02");

							// process if not in_error status
							if (!aioutdao
									.getAistatus()
									.equals(com.bureaueye.beacon.bean.Constants.IN_ERROR_STATUS)) {

								try {

									// process xml document
									org.w3c.dom.Element headerElement = null;
									org.w3c.dom.NodeList detailElements = null;

									// translate into dom elements
									DocumentBuilderFactory dbFactory = DocumentBuilderFactory
											.newInstance();
									DocumentBuilder dBuilder = dbFactory
											.newDocumentBuilder();
									org.w3c.dom.Document doc = dBuilder
											.parse(new org.xml.sax.InputSource(
													new java.io.StringReader(
															aioutdao.getDocument())));
									doc.getDocumentElement().normalize();

									headerElement = (org.w3c.dom.Element) doc
											.getElementsByTagName("header")
											.item(0);
									detailElements = doc
											.getElementsByTagName("detail");

									// loop details
									for (int i = 0; i < detailElements
											.getLength(); i++) {
										org.w3c.dom.Node detailNode = detailElements
												.item(i);
										org.w3c.dom.Element detailElement = (org.w3c.dom.Element) detailNode;

										if (doctype1
												.equals(com.bureaueye.beacon.bean.Constants.AR_ACTUAL))
											outputDetailAR_ACTUAL(
													headerElement,
													detailElement);
										if (doctype1
												.equals(com.bureaueye.beacon.bean.Constants.AP_ACTUAL))
											outputDetailAP_ACTUAL(
													headerElement,
													detailElement);
									}

									aioutdao.setAibatchId(aibatchdao
											.getAibatchId());
									aioutdao.setAistatus(com.bureaueye.beacon.bean.Constants.SENT_STATUS);
									aioutdao.setSentdate(cal.getTime());
									aioutdao.setSenttime(com.bureaueye.beacon.util.Util
											.toTime(cal));
									aioutdao.setControlid(controlid);
									aioutdao.setCompanyid(aibatchdao
											.getCompanyid());
									aioutdao.setFilename(outFileName1);

									processCount++;

								} catch (Exception ae) {
									log.error("[" + this.getClass().getName()
											+ "] " + new java.util.Date()
											+ " outputDetail: Exception: "
											+ ae.getMessage());
								}

							} else {
								// error count
								errorCount++;

							}

							// update aiout record
							try {
								aioutbd.createOrUpdate(aioutdao, user);
							} catch (ApplicationException ae) {
							}

						} // LOOP2

						// IN_LOOP2

						if (batchCount > 0) {
							// output batch count
							aibatchdao.setBatchcount(new Integer(batchCount));
							aibatchdao
									.setProcesscount(new Integer(processCount));
							aibatchdao.setErrorcount(new Integer(errorCount));
							aibatchdao.setProcessstatus("COMPLETE");
							try {
								aibatchbd.createOrUpdate(aibatchdao, user);
								String message1 = "[" + controlid + "] for "
										+ doctype1;
								// Add a summary message of processed records
								appInformationMessages.add(
										"messages.aibatch",
										new ActionMessage(
												"aibatch.information",
												message1, new Integer(
														processCount)
														.toString(),
												new Integer(batchCount)
														.toString(),
												new Integer(errorCount)
														.toString()));
							} catch (ApplicationException ae) {
								log.error("["
										+ this.getClass().getName()
										+ "] "
										+ new Date()
										+ " createOrUpdate: ApplicationException: "
										+ ae.getMessage());
							}
						}
						// remove batch record if no rows processed
						else {
							// do not do this yet as the BatchId is not being
							// reset
						}

						printStream.close();

					} // check AIOUTs

				} // LOOP1

				// IN_LOOP1

			} // check COMPANYs

		} catch (Exception e) {

		}

		// clear business delegates
		aibatchbd = null;
		aioutbd = null;
		companybd = null;

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

	public void outputHeaderAR_ACTUAL() {

		try {

			StringBuffer sb = new StringBuffer("");

			// column labels
			sb.append("CompanyId,ContactName,BillToCustAddrId,CustPONo,DiscDate,DueDate,FOBID,");
			sb.append("InvCurrID,InvCurrExchRate,PmtTermsID,SalesPersonID,ShipToCustAddrID,Tranamt,");
			sb.append("TranCmnt,TranDate,TranNo,TranTypeID,WSJobNo,WSContainerID,WSBOL,CmntOnly,");
			sb.append("Description,ExtAmt,ExtCmnt,ItemID,QtyShipped,GLAcctNo,LineNumber,");
			sb.append("TradeDiscAmt,UnitCost,UnitPrice");
			sb.append("\n");

			// output to file
			printStream.print(sb.toString());

		} catch (Exception e) {
			log.error("[" + this.getClass().getName() + "] " + new Date()
					+ " HeaderAR_ACTUAL Output: Exception: " + e.getMessage());
		}

	}

	public void outputDetailAR_ACTUAL(org.w3c.dom.Element headerElement,
			org.w3c.dom.Element detailElement) throws Exception {

		try {

			StringBuffer sb = new StringBuffer("");

			sb.append(getTagValue("CompanyId", headerElement));
			sb.append(",");
			sb.append(getTagValue("ContactName", headerElement));
			sb.append(",");
			sb.append(getTagValue("BillToCustAddrId", headerElement));
			sb.append(",");
			sb.append(getTagValue("CustPONo", headerElement));
			sb.append(",");
			sb.append(getTagValue("DiscDate", headerElement));
			sb.append(",");
			sb.append(getTagValue("DueDate", headerElement));
			sb.append(",");
			sb.append(getTagValue("FOBID", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvCurrID", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvCurrExchRate", headerElement));
			sb.append(",");
			sb.append(getTagValue("PmtTermsID", headerElement));
			sb.append(",");
			sb.append(getTagValue("SalesPersonID", headerElement));
			sb.append(",");
			sb.append(getTagValue("ShipToCustAddrID", headerElement));
			sb.append(",");
			sb.append(getTagValue("Tranamt", headerElement));
			sb.append(",");
			sb.append(getTagValue("TranCmnt", headerElement));
			sb.append(",");
			sb.append(getTagValue("TranDate", headerElement));
			sb.append(",");
			sb.append(getTagValue("TranNo", headerElement));
			sb.append(",");
			sb.append(getTagValue("TranTypeID", headerElement));
			sb.append(",");
			sb.append(getTagValue("WSJobNo", headerElement));
			sb.append(",");
			sb.append(getTagValue("WSContainerID", headerElement));
			sb.append(",");
			sb.append(getTagValue("WSBOL", headerElement));
			sb.append(",");

			sb.append(getTagValue("CmntOnly", detailElement));
			sb.append(",");
			sb.append(getTagValue("Description", detailElement));
			sb.append(",");
			sb.append(getTagValue("ExtAmt", detailElement));
			sb.append(",");
			sb.append(getTagValue("ExtCmnt", detailElement));
			sb.append(",");
			sb.append(getTagValue("ItemID", detailElement));
			sb.append(",");
			sb.append(getTagValue("QtyShipped", detailElement));
			sb.append(",");
			sb.append(getTagValue("GLAcctNo", detailElement));
			sb.append(",");
			sb.append(getTagValue("LineNumber", detailElement));
			sb.append(",");
			sb.append(getTagValue("TradeDiscAmt", detailElement));
			sb.append(",");
			sb.append(getTagValue("UnitCost", detailElement));
			sb.append(",");
			sb.append(getTagValue("UnitPrice", detailElement));

			sb.append("\n");

			// output to file
			printStream.print(sb.toString());

		} catch (Exception e) {
			log.error("[" + this.getClass().getName() + "] " + new Date()
					+ " DetailAR_ACTUAL Output: Exception: " + e.getMessage());
			throw e;
		}
	}

	public void outputHeaderAP_ACTUAL() {

		try {

			StringBuffer sb = new StringBuffer("");

			// column labels
			sb.append("CompanyId,InvoiceNo,Checkno,Checkdate,Checkamt,DiscDate,DueDate,");
			sb.append("InvAmt,InvCurrID,InvCurrExchRate,InvDate,InvHdrCmnt,InvType,");
			sb.append("LineNumber,VendID,PmtTermsID,WSJobNo,WSContainerID,WSBOL,");
			sb.append("ItemID,ItemDesc,ExtAmt,ExtCmnt,Qty,UnitCost,GLAcctNo");
			sb.append("\n");

			// output to file
			printStream.print(sb.toString());

		} catch (Exception e) {
			log.error("[" + this.getClass().getName() + "] " + new Date()
					+ " HeaderAP_ACTUAL Output: Exception: " + e.getMessage());
		}

	}

	public void outputDetailAP_ACTUAL(org.w3c.dom.Element headerElement,
			org.w3c.dom.Element detailElement) throws Exception {

		try {

			StringBuffer sb = new StringBuffer("");

			sb.append(getTagValue("CompanyId", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvoiceNo", headerElement));
			sb.append(",");
			sb.append(getTagValue("Checkno", headerElement));
			sb.append(",");
			sb.append(getTagValue("Checkdate", headerElement));
			sb.append(",");
			sb.append(getTagValue("Checkamt", headerElement));
			sb.append(",");
			sb.append(getTagValue("DiscDate", headerElement));
			sb.append(",");
			sb.append(getTagValue("DueDate", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvAmt", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvCurrID", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvCurrExchRate", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvDate", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvHdrCmnt", headerElement));
			sb.append(",");
			sb.append(getTagValue("InvType", headerElement));
			sb.append(",");
			sb.append(getTagValue("LineNumber", detailElement));
			sb.append(",");
			sb.append(getTagValue("VendID", headerElement));
			sb.append(",");
			sb.append(getTagValue("PmtTermsID", headerElement));
			sb.append(",");
			sb.append(getTagValue("WSJobNo", headerElement));
			sb.append(",");
			sb.append(getTagValue("WSContainerID", headerElement));
			sb.append(",");
			sb.append(getTagValue("WSBOL", headerElement));
			sb.append(",");

			sb.append(getTagValue("ItemID", detailElement));
			sb.append(",");
			sb.append(getTagValue("ItemDesc", detailElement));
			sb.append(",");
			sb.append(getTagValue("ExtAmt", detailElement));
			sb.append(",");
			sb.append(getTagValue("ExtCmnt", detailElement));
			sb.append(",");
			sb.append(getTagValue("Qty", detailElement));
			sb.append(",");
			sb.append(getTagValue("UnitCost", detailElement));
			sb.append(",");
			sb.append(getTagValue("GLAcctNo", detailElement));

			sb.append("\n");

			// output to file
			printStream.print(sb.toString());

		} catch (Exception e) {
			log.error("[" + this.getClass().getName() + "] " + new Date()
					+ " DetailAP_ACTUAL Output: Exception: " + e.getMessage());
			throw e;
		}
	}

	private static String getTagValue(String sTag, org.w3c.dom.Element eElement) {
		String returnValue = "";
		try {
			org.w3c.dom.NodeList nlList = eElement.getElementsByTagName(sTag)
					.item(0).getChildNodes();
			org.w3c.dom.Node nValue = (org.w3c.dom.Node) nlList.item(0);
			returnValue = nValue.getNodeValue();
		} catch (Exception e) {
		}
		return returnValue;
	}

}

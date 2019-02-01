package com.bureaueye.beacondms.ajax.dms;

import java.io.IOException;


import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.bureaueye.beacon.ajax.BaseAJAX;
import com.bureaueye.beacondms.model.dms.Xdocument;
import com.bureaueye.beacondms.model.dms.bd.XdocumentBD;




public final class ListElementAjax extends BaseAJAX {
	private static final long serialVersionUID = 1L;



	protected void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		Enumeration headers = request.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header  =(String) headers.nextElement();
			log.debug("[" + this.getClass().getName() + "] " + new java.util.Date()+	      
					header+": "+request.getHeader(header));
		}

		XdocumentBD xdocumentbd = new XdocumentBD();


		// get input parameters
		String tagName="";

		try {
			tagName=request.getParameter("searchString2");//
		} catch (Exception e) {}


		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " tagName[" + tagName+"]"
		);
		
		
		// init output 
		StringBuffer xml = new StringBuffer("");
		xml.append("<?xml version=\"1.0\"?>\n");


		//go back to root
		if (tagName.equals("-root-")) {
			int count=2;
			xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+count+"\">\n");

			String nodeName="-root-";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");
			nodeName="Document";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");
			xml.append("</item>\n");
			
/*			String nodeName="-root-";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");
			nodeName="header";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");
			xml.append("</item>\n");
			nodeName="finance_header";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");
			nodeName="finance_detail";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");	
			nodeName="operation_header";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");
			nodeName="operation_header2";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");
			nodeName="operation_detail";
			xml.append("<item id=\""+nodeName+"\">\n");				
			xml.append("<movref><![CDATA[");
			xml.append(nodeName);
			xml.append("]]></movref>\n");				
			xml.append("</item>\n");*/

			xml.append("</list>");           
		}


		//process if NOT back to root
		if (!tagName.equals("-root-")) {

			//find xml template
			Xdocument xdocumentdao = new Xdocument();
			try {
				xdocumentdao = xdocumentbd.findFirstXdocument();
/*				if (tagName.substring(0,3).equals("fin")) 
					xdocumentdao = xdocumentbd.findFirstXdocumentByDoctype("FINANCE");
				else
					xdocumentdao = xdocumentbd.findFirstXdocumentByDoctype("OPERATION");*/
			} catch (Exception ae) {				
			}


			try {
				org.w3c.dom.Element docElementsByTagName = null;

				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				org.w3c.dom.Document doc = dBuilder.parse(
						new org.xml.sax.InputSource(
								new java.io.StringReader(xdocumentdao.getXmldocument())
						)
				);
				doc.getDocumentElement().normalize();



				
				/*
				 * THIS PART CAN BE CODED BETTER WITH A LOOP PROCESS
				 * BUT FOR THE PROTOTYPE THIS WILL WORK!!!!
				 */
				StringTokenizer stringTokenizer = new StringTokenizer(tagName, "/");
				if (stringTokenizer.hasMoreTokens()) {
					try {
						String tagName1=stringTokenizer.nextToken();
						org.w3c.dom.Element docElementsByTagName1 = null;
						docElementsByTagName1=(org.w3c.dom.Element) doc.getElementsByTagName(tagName1).item(0);
						if (docElementsByTagName1.getChildNodes().item(0).hasChildNodes()) {
							docElementsByTagName=docElementsByTagName1;
							tagName=tagName1;
						}
						log.debug("[" + this.getClass().getName() + "] "
								+ new java.util.Date() + "docElementsByTagName1.getChildNodes().getLength()[" + 
								docElementsByTagName1.getChildNodes().getLength()+"]"
						);	
					} catch (Exception ae) {
					}
				}
				if (stringTokenizer.hasMoreTokens()) {
					try {	
						String tagName2=stringTokenizer.nextToken();
						org.w3c.dom.Element docElementsByTagName2 = null;
						docElementsByTagName2=(org.w3c.dom.Element) docElementsByTagName.getElementsByTagName(tagName2).item(0);
						if (docElementsByTagName2.getChildNodes().item(0).hasChildNodes()) {
							docElementsByTagName=docElementsByTagName2;
							tagName=tagName+"/"+tagName2;
						}
						log.debug("[" + this.getClass().getName() + "] "
								+ new java.util.Date() + " docElementsByTagName2.getChildNodes().getLength()[" + 
								docElementsByTagName2.getChildNodes().getLength()+"]"
						);
					} catch (Exception ae) {
					}						
				}
				if (stringTokenizer.hasMoreTokens()) {
					try {	
						String tagName3=stringTokenizer.nextToken();
						org.w3c.dom.Element docElementsByTagName3 = null;
						docElementsByTagName3=(org.w3c.dom.Element) docElementsByTagName.getElementsByTagName(tagName3).item(0);
						if (docElementsByTagName3.getChildNodes().item(0).hasChildNodes()) {
							docElementsByTagName=docElementsByTagName3;
							tagName=tagName+"/"+tagName3;
						}
						log.debug("[" + this.getClass().getName() + "] "
								+ new java.util.Date() + " docElementsByTagName3.getChildNodes().getLength()[" + 
								docElementsByTagName3.getChildNodes().getLength()+"]"
						);
					} catch (Exception ae) {
					}						
				}				
				if (stringTokenizer.hasMoreTokens()) {
					try {	
						String tagName4=stringTokenizer.nextToken();
						org.w3c.dom.Element docElementsByTagName4 = null;
						docElementsByTagName4=(org.w3c.dom.Element) docElementsByTagName.getElementsByTagName(tagName4).item(0);
						if (docElementsByTagName4.getChildNodes().item(0).hasChildNodes()) {
							docElementsByTagName=docElementsByTagName4;
							tagName=tagName+"/"+tagName4;
						}
						log.debug("[" + this.getClass().getName() + "] "
								+ new java.util.Date() + " docElementsByTagName4.getChildNodes().getLength()[" + 
								docElementsByTagName4.getChildNodes().getLength()+"]"
						);
					} catch (Exception ae) {
					}						
				}
				

				
				

				List elementList = new LinkedList();
				
				log.debug("[" + this.getClass().getName() + "] "
						+ new java.util.Date() + " docElementsByTagName.getChildNodes().getLength()[" + 
						docElementsByTagName.getChildNodes().getLength()+"]"
				);
				

				for (int i = 0; i < docElementsByTagName.getChildNodes().getLength(); i++) {

					org.w3c.dom.Node nNode = docElementsByTagName.getChildNodes().item(i);	    

					//org.w3c.dom.Element eElement = (org.w3c.dom.Element) nNode;

					elementList.add(nNode.getNodeName().toString());

					log.debug("[" + this.getClass().getName() + "] "
							+ new java.util.Date() + " nodeName[" + nNode.getNodeName()+"]");
				}




				xml.append("<list generated=\""+System.currentTimeMillis()+"\" total=\""+elementList.size()+"\">\n");

				//add root
				String nodeName="-root-";
				xml.append("<item id=\""+nodeName+"\">\n");				
				xml.append("<movref><![CDATA[");
				xml.append(nodeName);
				xml.append("]]></movref>\n");				
				xml.append("</item>\n");
				
				for (Iterator it = elementList.iterator(); it.hasNext();) {
					nodeName=(String)it.next();
					//concatenate tagName
					nodeName=tagName+"/"+nodeName;
					if (!nodeName.equals("")) {
						xml.append("<item id=\""+nodeName+"\">\n");				
						xml.append("<movref><![CDATA[");
						xml.append(nodeName);
						xml.append("]]></movref>\n");				
						xml.append("</item>\n");	
					}
				}				


				xml.append("</list>");


			} catch (Exception e) {
			}

		}

		xdocumentbd=null;

		log.debug("[" + this.getClass().getName() + "] "
				+ new java.util.Date() + " xml[" + xml.toString()+"]");

		response.setContentType("application/xml");
		response.getWriter().write(xml.toString());


	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

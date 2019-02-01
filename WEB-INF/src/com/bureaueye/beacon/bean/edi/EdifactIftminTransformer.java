/*
 * $Id:   EdifactIftminTransformer$
 * 
 * 
 *  
 */

package com.bureaueye.beacon.bean.edi;


import java.util.LinkedList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.LabelValue;


/**
 * Instruction Transformer from UN/EDIFACT to data fields
 *
 * @version $Rev: 00001 2007-06-05 $
 */

public final class EdifactIftminTransformer {
	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);
	
	private static final int CANCELLATION = 1;
	private static final int ALTERATION = 4;
	private static final int ORIGINAL = 9;
	private static final int COPY = 7;
	
	private static final int DOCUMENT_MESSAGE_DATE_TIME = 137;
	private static final int DEPARTURE_DATE_TIME_ESTIMATED = 133;
	private static final int ARRIVAL_DATE_TIME_ESTIMATED = 132;
	private static final int CLOSING_DATE_TIME = 180;
	private static final int BILL_OF_LADING_DATE = 95;
	
	private static final int YYYYMMDDHHMM = 203;
	private static final int CCYYMMDD = 102;
	
	
	private static final String[] textsubjectQualifier =
	{
		"AAI","TRA","DCL","ABO","PRD","AAA","RAH",
		"ACB","AAD","LOI","SPP","AAN","HAN","AGK",
		"AEB","CLR","SIN","AAF","ADQ","OSI","ITR",
		"SIC","ABR","DOC","AAS","DIN","AAW","AAC"
	};
	private static final String[] textsubjectName =
	{
		"GENERAL INFORMATION",
		"TRANSPORTATION INFORMATION",
		"DECLARATION",
		"DISCREPANCY INFORMATION",
		"Product information -> Wassergefährungsklasse (water dangerous class)",
		"GOODS INFORMATION",
		"RISK AND HANDLING INFORMATION", 
		"ADDITIONAL INFORMATION",
		"DANGEROUS GOODS INFORMATION",
		"LOADING INSTRUCTION",
		"SPECIAL PERMISSION CONCERNING PACKAGE",
		"HANDLING RESTRICTION",
		"HANDLING INSTRUCIONS",
		"EQUIPMENT",
		"TEMPERATURE CONTROL INSTRUCTIONS",
		"LOADING REMARKS",
		"SPECIAL INSTRUCTIONS",
		"RATE ADDITIONAL INFORMATION",
		"DESCRIPTION OF WORK ITEM ON EQUIPMENT",
		"OTHER SERVICE INFORMATION",
		"INLAND TRANSPORT DETAILS",
		"SENDERS INSTRUCTION TO CARRIER",
		"DOCUMENTS DELIVERY INSTRUCTIONS",
		"DOCUMENTATION INSTRUCTIONS",
		"BILL OF LADING REMARKS",
		"DELIVERY INSTRUCTIONS",
		"LETTER OF CREDIT INFORMATION",
		"Dangerous goods additional information"
	};    
	
	
	private static final String[] partyQualifier =
	{
		"EP","DCP","AG","CZ","BA","FW","CA","OS","BL","DM","N1","N2","DO","CX","P1","P2","CN"
	};
	private static final String[] partyFunction =
	{
		"EQUIPMENT DROP-OFF PARTY",
		"DCP (Zahler von Versandgebühren Lastläufer)",
		"AGENT/REPRESENTATIVE",
		"CONSIGNOR",
		"BOOKING AGENT",
		"FREIGHT FORWARDER",
		"CARRIER",
		"ORIGINAL SHIPPER FOR BL",
		"BILL OF LADING RECIPIENT",
		"PARTNER IN BASF WHO RECEIVE THE B/L - SHOULD BE PRINTED ON THE ENVELOPE",
		"Notify party no. 1",
		"Notify party no. 2",
		"Document recipient",
		"Consignee's agent",
		"Contact party 1",
		"Contact party 2",
		"Consignee"
	};  
	
	private static final String[] locationQualifier =
	{
		"10","88","92","9","18","12","7","20","91","13","5","1","ZZZ"
	};
	private static final String[] locationType =
	{
		"PLACE OF ACCEPTANCE",
		"PLACE OF RECEIPT",
		"ROUTING",
		"PORT OF LOADING",
		"PORT OF DEPARTURE WAREHOUSE",
		"PORT OF DISCHARGE",
		"PLACE OF DELIVERY",
		"PLACE OF ULTIMATE DESTINATION OF GOODS",
		"PLACE OF DOCUMENT ISSUE",
		"PLACE OF TRANSHIPMENT",
		"PLACE OF DEPARTURE",
		"ASSOCIATED COUNTRY",
		"LOCATION INFORMATION RELATED TO CURRENT PARTY"
	}; 
	
	private static final String[] referenceQualifier =
	{
		"SI","LI","AHI","VN","OP","CO","AKD","IP","LC","AOC","AQV"
	};
	private static final String[] referenceType =
	{
		"SHIPPERS IDENTIFYING NUMBER",
		"LINE ITEM REFERENCE NUMBER",
		"TRANSPORT CONTRACT REFERENCE NUMBER",
		"ORDER NUMBER (VENDOR)",
		"ORIGINAL PURCHASE ORDER",
		"BUYERS ORDER NUMBER",
		"TRANSPORT EQUIPMENT SURVEY REFERENCE",
		"IMPORT LICENCE NUMBER",
		"LETTER OF CREDIT NUMBER",
		"ORDERING CUSTOMERS SECOND REFERENCE NUMBER",
		"STATISTIC BUNDES AMT(SBA) IDENTIFIER"
	}; 
	
	
	private static final String[] quantityQualifier =
	{
		"100"
	};
	private static final String[] quantityType =
	{
		"CHARGEABLE WEIGHT"
	}; 
	
	
	private static final String[] contactQualifier =
	{
		"MS","HG","TR","MR"
	};
	private static final String[] contactFunction =
	{
		"MESSAGE SENDER CONTACT",
		"DANGEROUS GOODS CONTACT",
		"TRANSPORT CONTACT",
		"MESSAGE RECIPIENT CONTACT"
	}; 
	
	private static final String[] transportQualifier =
	{
		"10","20","30"
	};
	private static final String[] transportType =
	{
		"PRE-CARRIAGE",
		"MAIN TRANSPORT",
		"ON-CARRIAGE TRANSPORT"
	}; 
	private static final String[] transportmodeQualifier =
	{
		"20","10","30","60"
	};
	private static final String[] transportmodeType =
	{
		"RAIL TRANSPORT",
		"MARITIME TRANSPORT",
		"ROAD TRANSPORT",
		"MULTIMODAL TRANSPORT"
	};
	private static final String[] transportmeansQualifier =
	{
		"31","24","11","13"
	};
	private static final String[] transportmeansType =
	{
		"TRUCK",
		"RAIL EXPRESS",
		"SHIP",
		"13"
	};
	
	private static final String[] controlQualifier =
	{
		"15","32","1","16"
	};
	private static final String[] controlType =
	{
		"TOTAL CONSIGNMENT CUBE",
		"TOTAL GROSS WEIGHT OF GOODS",
		"ALGEBRAIC TOTAL",
		"TOTAL NUMBER OF EQUIPMENT"
	};
	
	private static final String[] serviceQualifier =
	{
		"29","28","27","30"
	};
	private static final String[] serviceType =
	{
		"PIER-TO-DOOR",
		"DOOR-TO-PIER",
		"DOOR-TO-DOOR",
		"PIER-TO-PIER"
	};
	
	private static final String[] documentQualifier =
	{
		"705","710"
	};
	private static final String[] documentType =
	{
		"BILL OF LADING = OBL",
		"SEA WAYBILL = ECB"
	};
	
	
	private static final String[] communicationchannelQualifier =
	{
		"EI","AD","MA","FX"
	};
	private static final String[] communicationchannelType =
	{
		"EDI TRANSMISSION",
		"COURIER = DHL",
		"MAIL = AIRMAIL",
		"TELEFAX"
	};
	
	
	
	private static final String[] movementQualifier =
	{
		"1","2","3","4","5"
	};
	private static final String[] movementType =
	{
		"CONVENTIONAL",
		"LCL/LCL",
		"FCL/FCL",
		"FCL/LCL",
		"LCL/LCL"
	};
	
	
	private static final String[] haulageQualifier =
	{
		"1","2"
	};
	private static final String[] haulageType =
	{
		"CARRIER",
		"MERCHANT"
	};
	
	
	private static final String[] measurementQualifier =
	{
		"WT","TE","DEN","AAE","TC","VOL"
	};
	private static final String[] measurementType =
	{
		"WEIGHTS",
		"TEMPERATURE",
		"DENSITY",
		"AAE",
		"TEMPERATURE",
		"VOLUME",		
	};

	private static final String[] measurementunitQualifier =
	{
		"23","CEL","ZZ","°C","KGM"
	};
	private static final String[] measurementunitType =
	{
		"gram per cubic centimetre",
		"degree Celsius",
		"mutually defined",
		"degree Celsius",
		"kilogram"
	};
	
	private static final String[] dimensionQualifier =
	{
		"AAE","AAD","AAC","WT","TC","ADE","ZZZ","RUN","AAA","T"
	};
	private static final String[] dimensionType =
	{
		"ITEM GROSS WEIGHT",
		"TOTAL GROSS WEIGHT",
		"TOTAL NET WEIGHT",
		"WEIGHT",
		"TEMPERATURE",
		"SHIPPING TOLERANCE",
		"MUTUALLY DEFINED",
		"RUN",
		"UNIT NET WEIGHT",
		"T"
	};
	
	
	
	public EdifactIftminTransformer() {}
	
	
	public LinkedList getCTA(Node segmentNode) {
		//CTA+MS+:Frau Eck
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","CONTACT");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		int count = 0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);*/
					String qualifier = elements.item(i3).getNodeValue();
					String function = "";
					for (int i=0; i<contactQualifier.length; i++) { 
						if (contactQualifier[i].equals(qualifier)) {
							function = contactFunction[i];
							break;
						}
					}
					labelValue = new LabelValue("Contact function",function);
					hm.add(labelValue);					   
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						count++;
						labelValue = new LabelValue("Department or employee info "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);
					}		    	
				}				
			}			
		}
		
		return hm;
	}
		
	
	
	public LinkedList getBGM(Node segmentNode) {
		//BGM+335+2001179149+9
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","BEGINNING OF MESSAGE");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		
/*		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" segments.item(1).getChildNodes().item(0).getNodeValue()["+
				segments.item(1).getChildNodes().item(0).getNodeValue()+"]"
		);	*/
		labelValue = new LabelValue("Document number",segments.item(1).getChildNodes().item(0).getNodeValue());
		hm.add(labelValue);			
/*		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" segments.item(2).getChildNodes().item(0).getNodeValue()["+
				segments.item(2).getChildNodes().item(0).getNodeValue()+"]"
		);*/
		try {
			int function = new Integer(segments.item(2).getChildNodes().item(0).getNodeValue()).intValue();
			switch(function)
			{
			case CANCELLATION:
				labelValue = new LabelValue("Message function","CANCELLATION");
				break;
			case ALTERATION:
				labelValue = new LabelValue("Message function","ALTERATION");
				break;
			case ORIGINAL:
				labelValue = new LabelValue("Message function","ORIGINAL");
				break;
			case COPY:
				labelValue = new LabelValue("Message function","COPY");
				break;                
			default: ;
			}
			hm.add(labelValue);	
		} catch (Exception e) {}
		
		return hm;
	}		
	
	
	
	public LinkedList getCOM(Node segmentNode) {
		//COM+0621 60-66 93586:FX
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","COMMUNICATION");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		int count = 0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);*/				   
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						count++;
						labelValue = new LabelValue("Communication reference "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);	
					}		    	
				}				
			}			
		}
		
		return hm;
	}	
	
	
	
	public LinkedList getTCC(Node segmentNode) {
//		TCC+101021
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT CHARGE/RATE CALCULATIONS");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		
		labelValue = new LabelValue("Freight and charges identification",segments.item(0).getChildNodes().item(0).getNodeValue());
		hm.add(labelValue);			
		
		return hm;
	}
		
	
	
	public LinkedList getQTY(Node segmentNode) {
		//QTY+100:20053.200:KGM
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","QUANTITY");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);*/				   
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (i3==0) {
							String qualifier = subelements.item(i4).getNodeValue();
							String type = "";
							for (int i=0; i<quantityQualifier.length; i++) { 
								if (quantityQualifier[i].equals(qualifier)) {
									type = quantityType[i];
									break;
								}
							}
							labelValue = new LabelValue("Quantity type",type);
							hm.add(labelValue);
						}
						if (i3==1) {
							labelValue = new LabelValue("Quantity",subelements.item(i4).getNodeValue());
							hm.add(labelValue);	
						}
						if (i3==2) {
							labelValue = new LabelValue("Measurement unit",subelements.item(i4).getNodeValue());
							hm.add(labelValue);
						}
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
		
	
	public LinkedList getDOC(Node segmentNode) {
//		DOC+705+:::EN+MA+9+2
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","DOCUMENT");
		hm.add(labelValue);
		
//segmentId[DOC]
//segments.item(0).getNodeValue()[null] elementId[DOC01]
//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[705]
//segments.item(1).getNodeValue()[null] elementId[DOC03]
//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[AD]
//segments.item(2).getNodeValue()[null] elementId[DOC04]
//segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[3]
//segments.item(3).getNodeValue()[null] elementId[DOC05]
//segments.item(3).getNodeValue()[null] elements.item(0).getNodeValue()[3]
		
		NodeList segments = segmentNode.getChildNodes();
		int count = 0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);	*/	
					if (elementId.equals("DOC01")) {
						String qualifier = elements.item(i3).getNodeValue();
						String name = "";
						try {
							for (int i=0; i<documentQualifier.length; i++) { 
								if (documentQualifier[i].equals(qualifier)) {
									name = documentType[i];
									break;
								}
							}
							labelValue = new LabelValue("Document/Message name",name);
							hm.add(labelValue);
						} catch (Exception e) {}	
					}
					if (elementId.equals("DOC03")) {
						try {
							String qualifier = elements.item(i3).getNodeValue();
							String name = "";
							for (int i=0; i<communicationchannelQualifier.length; i++) { 
								if (communicationchannelQualifier[i].equals(qualifier)) {
									name = communicationchannelType[i];
									break;
								}
							}
							labelValue = new LabelValue("Communication channel",name);
							hm.add(labelValue);
						} catch (Exception e) {}
					}
					if (elementId.equals("DOC04")) {
						labelValue = new LabelValue("Number of copies",elements.item(i3).getNodeValue());
						hm.add(labelValue);
					}					
					if (elementId.equals("DOC05")) {
						labelValue = new LabelValue("Number of originals",elements.item(i3).getNodeValue());
						hm.add(labelValue);		
					}
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						count++;
						labelValue = new LabelValue("Document/Message line "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);						
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
		
	
	public LinkedList getDTM(Node segmentNode) {
		//DTM+133:20060225:102
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","DATE/TIME/PERIOD");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);*/				   
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (i3==0) {
							try {
								int qualifier = new Integer(subelements.item(i4).getNodeValue()).intValue();
								switch(qualifier)
								{        
								case DOCUMENT_MESSAGE_DATE_TIME:
									labelValue = new LabelValue("Date/Time period type","DOCUMENT/MESSAGE DATE/TIME");
									break;               
								case DEPARTURE_DATE_TIME_ESTIMATED:
									labelValue = new LabelValue("Date/Time period type","DEPARTURE DATE/TIME ESTIMATED");
									break;  
								case ARRIVAL_DATE_TIME_ESTIMATED:
									labelValue = new LabelValue("Date/Time period type","ARRIVAL DATE/TIME ESTIMATED");
									break; 
								case CLOSING_DATE_TIME:
									labelValue = new LabelValue("Date/Time period type","CLOSING DATE/TIME");
									break; 
								case BILL_OF_LADING_DATE:
									labelValue = new LabelValue("Date/Time period type","BILL OF LADING DATE");
									break; 	                
								default: ;
								}
								hm.add(labelValue);	
							} catch (Exception e) {}						
						}
						if (i3==1) {						
							labelValue = new LabelValue("Date/Time/Period",subelements.item(i4).getNodeValue());
							hm.add(labelValue);
						}
						if (i3==2) {
							try {
								int format = new Integer(subelements.item(i4).getNodeValue()).intValue();
								switch(format)
								{
								case YYYYMMDDHHMM:
									labelValue = new LabelValue("Date/Time/Period format type","YYYYMMDDHHMM");
									break;               
								case CCYYMMDD:
									labelValue = new LabelValue("Date/Time/Period format type","CCYYMMDD");
									break; 
								default: ;
								}
								hm.add(labelValue);	
							} catch (Exception e) {}
						}
					}		    	
				}				
			}			
		}
		
		return hm;
	}
		
	
	
	public LinkedList getFTX(Node segmentNode) {
		//FTX+AAN+++Polyethylen niedriger Dichte (LDPE)
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","TEXT");
		hm.add(labelValue);

		//segmentId[FTX]
		//segments.item(0).getNodeValue()[null] elementId[FTX01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[ACB]
		//segments.item(1).getNodeValue()[null] elementId[FTX04]
		//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[schwach aromatisch]

		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}	
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);*/
					if (elementId.equals("FTX01")) {
						String qualifier = elements.item(i3).getNodeValue();
						String name = "";
						for (int i=0; i<textsubjectQualifier.length; i++) { 
							if (textsubjectQualifier[i].equals(qualifier)) {
								name = textsubjectName[i];
								break;
							}
						}
						labelValue = new LabelValue("Supplementary information",name);
						hm.add(labelValue);
					}
					if (elementId.equals("FTX03")) {					
						count++;
						labelValue = new LabelValue("Text line "+count,elements.item(i3).getNodeValue());
						hm.add(labelValue);	
					}					
					if (elementId.equals("FTX04")) {					
						count++;
						labelValue = new LabelValue("Text line "+count,elements.item(i3).getNodeValue());
						hm.add(labelValue);	
					}
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("FTX04")) {						
						count++;
						labelValue = new LabelValue("Text line "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);	
						}
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
	
	
	public LinkedList getNAD(Node segmentNode) {
		//NAD+DCP+272485++Bulkhaul (Germany) GmbH++Fussgönheim+++DE
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","PARTY");
		hm.add(labelValue);

		//segmentId[NAD]
		//segments.item(0).getNodeValue()[null] elementId[NAD01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[CN]
		//segments.item(1).getNodeValue()[null] elementId[NAD04]
		//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[BASF CHILE S.A.]
		//segments.item(2).getNodeValue()[null] elementId[NAD05]
		//segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[Av. Carrascal 3851]
		//segments.item(2).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[P.O. BOX:3238]
		//segments.item(3).getNodeValue()[null] elementId[NAD06]
		//segments.item(3).getNodeValue()[null] elements.item(0).getNodeValue()[Santiago de Chile]
		//segments.item(4).getNodeValue()[null] elementId[NAD08]
		//segments.item(4).getNodeValue()[null] elements.item(0).getNodeValue()[7360081]
		//segments.item(5).getNodeValue()[null] elementId[NAD09]
		//segments.item(5).getNodeValue()[null] elements.item(0).getNodeValue()[CL]
		                                                                                                                                                                                                                                                                                        
		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		int count2=0;		
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);*/	
					if (elementId.equals("NAD01")) {
						String qualifier = elements.item(i3).getNodeValue();
						String function = "";
						for (int i=0; i<partyQualifier.length; i++) { 
							if (partyQualifier[i].equals(qualifier)) {
								function = partyFunction[i];
								break;
							}
						}
						labelValue = new LabelValue("PARTY FUNCTION",function);
						hm.add(labelValue);
					}
					//if (elementId.equals("NAD02")) {
					//	labelValue = new LabelValue("PARTY ID",elements.item(i3).getNodeValue());
					//	hm.add(labelValue);
					//}						
					if (elementId.equals("NAD04")) {
						count2++;						
						labelValue = new LabelValue("NAME "+count2,elements.item(i3).getNodeValue());
						hm.add(labelValue);
					}
					if (elementId.equals("NAD05")) {
						count++;
						labelValue = new LabelValue("ADDRESS LINE "+count,elements.item(i3).getNodeValue());
						hm.add(labelValue);
						}					
					if (elementId.equals("NAD06")) {
						labelValue = new LabelValue("COUNTRY",elements.item(i3).getNodeValue());
						hm.add(labelValue);
					}	
					if (elementId.equals("NAD08")) {
						labelValue = new LabelValue("POSTCODE",elements.item(i3).getNodeValue());
						hm.add(labelValue);
					}	
					if (elementId.equals("NAD09")) {
						labelValue = new LabelValue("COUNTRY CODE",elements.item(i3).getNodeValue());
						hm.add(labelValue);
					}						
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("NAD04")) {
							count2++;
							labelValue = new LabelValue("NAME "+count2,subelements.item(i4).getNodeValue());
							hm.add(labelValue);
						}						
						if (elementId.equals("NAD05")) {
						count++;
						labelValue = new LabelValue("ADDRESS LINE "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);
						}
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
	

	public LinkedList getLOC(Node segmentNode) {
		//LOC+9+NLRTM:::ROTTERDAM
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","LOCATION");
		hm.add(labelValue);

//segments.item(0).getNodeValue()[null] elementId[LOC01]
//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[1]
//segments.item(1).getNodeValue()[null] elementId[LOC02]
//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[CIF]
//segments.item(1).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[Valparaiso]

		//segments.item(0).getNodeValue()[null] elementId[LOC01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[ZZZ]
		//segments.item(1).getNodeValue()[null] elementId[LOC02]
		//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[TELEFON]
		//segments.item(2).getNodeValue()[null] elementId[LOC03]
		//segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[FAX]
		//segments.item(2).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[26407061]

		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("LOC01")) {
					String qualifier = elements.item(i3).getNodeValue();
					String type = "";
					for (int i=0; i<locationQualifier.length; i++) { 
						if (locationQualifier[i].equals(qualifier)) {
							type = locationType[i];
							break;
						}
					}
					labelValue = new LabelValue("Location type",type);
					hm.add(labelValue);				
					}
					if (elementId.equals("LOC02")) {						
						count++;
						labelValue = new LabelValue("Location Id/Name "+count,elements.item(i3).getNodeValue());
						hm.add(labelValue);							
						}					
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("LOC02")) {						
						count++;
						labelValue = new LabelValue("Location Id/Name "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);							
						}
						if (elementId.equals("LOC03")) {						
							count++;
							labelValue = new LabelValue("Location Id/Name "+count,subelements.item(i4).getNodeValue());
							hm.add(labelValue);							
						}						
					}		    	
				}				
			}			
		}
		
		return hm;
	}

	
	
	public LinkedList getRFF(Node segmentNode) {
		//RFF+LI:3083952913:000010
		LinkedList hm = new LinkedList();
		
//		segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[LI]
//		segments.item(0).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[3085213486]
//		segments.item(0).getNodeValue()[null] elements.item(2).getNodeValue()[null] subelements.item(0).getNodeValue()[000010]
		
		
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT");
		hm.add(labelValue);
		
		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"
				);*/
			}
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"
					);	*/
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						count++;
						if (i3==0) {
							String qualifier = subelements.item(i4).getNodeValue();
							String type = "";
							for (int i=0; i<referenceQualifier.length; i++) { 
								if (referenceQualifier[i].equals(qualifier)) {
									type = referenceType[i];
									break;
								}
							}
							labelValue = new LabelValue("Reference type",type);
							hm.add(labelValue);
						}
						if (i3==1) {						
							labelValue = new LabelValue("Reference number",subelements.item(i4).getNodeValue());
							hm.add(labelValue);		
						}
						if (i3==2) {
							labelValue = new LabelValue("Line number",subelements.item(i4).getNodeValue());
							hm.add(labelValue);
						}
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
	
	
	public LinkedList getTDT(Node segmentNode) {
		//TDT+10++60+11
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT");
		hm.add(labelValue);
		
//		segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[10]
//		segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[20]
//		segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[10]
//		segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[13]
//		segments.item(3).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[9252993]
//		segments.item(3).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[CALLAO EXPRESS]
		
		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("TDT01")) {
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<transportQualifier.length; i++) { 
							if (transportQualifier[i].equals(qualifier)) {
								type = transportType[i];
								break;
							}
						}
						labelValue = new LabelValue("Transport stage",type);
						hm.add(labelValue);	
					}
					if (elementId.equals("TDT03")) {
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<transportmodeQualifier.length; i++) { 
							if (transportmodeQualifier[i].equals(qualifier)) {
								type = transportmodeType[i];
								break;
							}
						}
						labelValue = new LabelValue("Transport mode",type);
						hm.add(labelValue);
					}
					if (elementId.equals("TDT04")) {					
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<transportmeansQualifier.length; i++) { 
							if (transportmeansQualifier[i].equals(qualifier)) {
								type = transportmeansType[i];
								break;
							}
						}
						labelValue = new LabelValue("Transport means",type);
						hm.add(labelValue);	
					}
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						count++;
						labelValue = new LabelValue("Transport Id "+count,subelements.item(i4).getNodeValue());
						hm.add(labelValue);							
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
	
	
	public LinkedList getCNT(Node segmentNode) {
		//CNT+32:42000.000:KGM'
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","CONTROL TOTAL");
		hm.add(labelValue);

		//segments.item(0).getNodeValue()[null] elementId[CNT01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[16]
		//segments.item(0).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[4]
		//segments.item(0).getNodeValue()[null] elements.item(2).getNodeValue()[null] subelements.item(0).getNodeValue()[C62]

		NodeList segments = segmentNode.getChildNodes();
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("CNT01")) {
							
							if (i3==0) {	
							String qualifier = subelements.item(i4).getNodeValue();
							String type = "";
							for (int i=0; i<controlQualifier.length; i++) { 
								if (controlQualifier[i].equals(qualifier)) {
									type = controlType[i];
									break;
								}
							}
							labelValue = new LabelValue("Control type",type);
							hm.add(labelValue);	
							}
							if (i3==1) {	
							labelValue = new LabelValue("Control value",subelements.item(i4).getNodeValue());
							hm.add(labelValue);
							}
							if (i3==2) {	
							labelValue = new LabelValue("Measure unit",subelements.item(i4).getNodeValue());
							hm.add(labelValue);
							}
						}						
				
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	

	
	public LinkedList getTSR(Node segmentNode) {
		//TSR+30
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT SERVICE");
		hm.add(labelValue);
				
		//segmentId[TSR]
		//segments.item(0).getNodeValue()[null] elementId[TSR01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[30]
		                                                                                                                                                                                                                                                                                        
		NodeList segments = segmentNode.getChildNodes();
		NodeList elements = segments.item(0).getChildNodes();			
		// 		
		String qualifier = elements.item(0).getNodeValue();
		String type = "";
		for (int i=0; i<serviceQualifier.length; i++) { 
			if (serviceQualifier[i].equals(qualifier)) {
				type = serviceType[i];
				break;
			}
		}
		labelValue = new LabelValue("Service type",type);
		hm.add(labelValue);		
		
		return hm;
	}
	

	
	public LinkedList getPIA(Node segmentNode) {
		//PIA+5+50557586:SA
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","ADDITIONAL PRODUCT ID");
		hm.add(labelValue);

		//segmentId[PIA]
		//segments.item(0).getNodeValue()[null] elementId[PIA01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[5]
		//segments.item(1).getNodeValue()[null] elementId[PIA02]
		//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[50048597]
		//segments.item(1).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[SA]
		                                                                                                                   
		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);	*/				
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("PIA01")) {
						labelValue = new LabelValue("Product Id",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("PIA02")) {
							count++;
							labelValue = new LabelValue("Item number:type "+count,subelements.item(i4).getNodeValue());
							hm.add(labelValue);							
						}					
					}		    	
				}				
			}			
		}
		
		return hm;
	}

	

	public LinkedList getRNG(Node segmentNode) {
		//RNG+5+CEL:-10:25
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","RANGE DETAILS");
		hm.add(labelValue);
				
		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("RNG01")) {
						labelValue = new LabelValue("Temperature range",elements.item(i3).getNodeValue());
						hm.add(labelValue);
					}
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("RNG02")) {
							count++;
							labelValue = new LabelValue("Cel Range:Minimum:Maximum "+count,subelements.item(i4).getNodeValue());
							hm.add(labelValue);
						}
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	

	
	public LinkedList getSGP(Node segmentNode) {
		//SGP+32369645
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","SPLIT GOODS PLACEMENT");
		hm.add(labelValue);
				
		//segmentId[SGP]
		//segments.item(0).getNodeValue()[null] elementId[SGP01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[GESU8017339]
		                                                                                                                                                                                                                                                                                        
		NodeList segments = segmentNode.getChildNodes();
		NodeList elements = segments.item(0).getChildNodes();			
		// 
		labelValue = new LabelValue("Equipment Id number",elements.item(0).getNodeValue());
		hm.add(labelValue);	
		
		return hm;
	}
	

	
	public LinkedList getEQN(Node segmentNode) {
		//EQN+1
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","NUMBER OF UNITS");
		hm.add(labelValue);

		//segmentId[EQN]
		//segments.item(0).getNodeValue()[null] elementId[EQN01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[1]
		                                                                                                                                                                                                                                                                                        
		NodeList segments = segmentNode.getChildNodes();
		NodeList elements = segments.item(0).getChildNodes();			
		// 
		labelValue = new LabelValue("Number of units",elements.item(0).getNodeValue());
		hm.add(labelValue);			
		
		return hm;
	}
	

	
	public LinkedList getEQD(Node segmentNode) {
		//EQD+CN+32369645+20TC:::20?
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","EQUIPMENT DETAILS");
		hm.add(labelValue);

		//segmentId[EQD]
		//segments.item(0).getNodeValue()[null] elementId[EQD01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[CN]
		//segments.item(1).getNodeValue()[null] elementId[EQD02]
		//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[TASU1151458]
		//segments.item(2).getNodeValue()[null] elementId[EQD03]
		//segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[20TC]
		//segments.item(2).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[20´Standard-Tank H-Peroxyd Wash]

		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("EQD01")) {
						labelValue = new LabelValue("Equipment type",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}
					if (elementId.equals("EQD02")) {
						labelValue = new LabelValue("Equipment Id number",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}					
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("EQD03")) {
							count++;	
							labelValue = new LabelValue("Equipment Size/Type "+count,subelements.item(i4).getNodeValue());
							hm.add(labelValue);								
						}							
					
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	

	
	public LinkedList getGID(Node segmentNode) {
		//GID+1
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","GOODS ITEM DETAILS");
		hm.add(labelValue);
				
		//segmentId[GID]
		//segments.item(0).getNodeValue()[null] elementId[GID01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[4]
		                                                                                                                                                                                                                                                                                        
		NodeList segments = segmentNode.getChildNodes();
		NodeList elements = segments.item(0).getChildNodes();			
		// 
		labelValue = new LabelValue("Goods item number",elements.item(0).getNodeValue());
		hm.add(labelValue);	
		
		return hm;
	}
	

	
	public LinkedList getDGS(Node segmentNode) {
		//DGS+ZZZ
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","DANGEROUS GOODS");
		hm.add(labelValue);

		//segmentId[DGS]
		//segments.item(0).getNodeValue()[null] elementId[DGS01]
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[ZZZ]
//segmentId[DGS]
//segments.item(0).getNodeValue()[null] elementId[DGS01]
//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[IMD]
//segments.item(1).getNodeValue()[null] elementId[DGS02]
//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[3]
//segments.item(2).getNodeValue()[null] elementId[DGS03]
//segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[1993]
//segments.item(3).getNodeValue()[null] elementId[DGS04]
//segments.item(3).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[48.0]
//segments.item(3).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[CEL]	
//segments.item(4).getNodeValue()[null] elementId[DGS05]
//segments.item(4).getNodeValue()[null] elements.item(0).getNodeValue()[3]
//segments.item(5).getNodeValue()[null] elementId[DGS06]
//segments.item(5).getNodeValue()[null] elements.item(0).getNodeValue()[F-ES-E]
		                                                                                                                                                                                                                                                                                        
		NodeList segments = segmentNode.getChildNodes();
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("DGS01")) {
						labelValue = new LabelValue("Dangerous goods regulations, coded",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}
					if (elementId.equals("DGS02")) {
						labelValue = new LabelValue("Hazard code identification",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}	
					if (elementId.equals("DGS03")) {
						labelValue = new LabelValue("UNDG number",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}	
					if (elementId.equals("DGS05")) {
						labelValue = new LabelValue("Packing group, coded",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}	
					if (elementId.equals("DGS06")) {
						labelValue = new LabelValue("EMS number",elements.item(i3).getNodeValue());
						hm.add(labelValue);						
					}						
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("DGS04")) {
							if (i3==0) {
								labelValue = new LabelValue("Shipment flashpoint",subelements.item(i4).getNodeValue());
								hm.add(labelValue);		
							}
							if (i3==1) {
								labelValue = new LabelValue("Measure unit qualifier",subelements.item(i4).getNodeValue());
								hm.add(labelValue);		
							}							
						}						
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	

	
	public LinkedList getPCI(Node segmentNode) {
		//
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","MARKS AND NUMBERS OF A GOODS ITEM");
		hm.add(labelValue);

		//segmentId[PCI]
		//segments.item(0).getNodeValue()[null] elementId[PCI02]		
		//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[BASF]
		//segments.item(0).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[3003801875 / 000040]

		 int count = 0;                                                                                                                                                                                                                                                                                     
		NodeList segments = segmentNode.getChildNodes();
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/					
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("PCI02")) {
							count++;
								labelValue = new LabelValue("Shipping marks "+count,subelements.item(i4).getNodeValue());
								hm.add(labelValue);									
						}						
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	
	
	
	public LinkedList getTMD(Node segmentNode) {
		//TMD+3:Carriers Haulage++1
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT MOVEMENT DETAILS");
		hm.add(labelValue);

//segmentId[TMD]
//segments.item(0).getNodeValue()[null] elementId[TMD01]
//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[3]
//segments.item(0).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[Carriers Haulage]
//segments.item(1).getNodeValue()[null] elementId[TMD03]
//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[1]

		NodeList segments = segmentNode.getChildNodes();
		int count=0;
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("TMD03")) {
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<haulageQualifier.length; i++) { 
							if (haulageQualifier[i].equals(qualifier)) {
								type = haulageType[i];
								break;
							}
						}
						labelValue = new LabelValue("Haulage arrangements, coded",type);
						hm.add(labelValue);						
					}
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("TMD01")) {
							if (i3==0) {
							count++;	
							String qualifier = subelements.item(i4).getNodeValue();
							String type = "";
							for (int i=0; i<movementQualifier.length; i++) { 
								if (movementQualifier[i].equals(qualifier)) {
									type = movementType[i];
									break;
								}
							}
							labelValue = new LabelValue("Movement type, coded",type);
							hm.add(labelValue);
							}
							if (i3==1) {
								count++;	
								labelValue = new LabelValue("Movement type",subelements.item(i4).getNodeValue());
								hm.add(labelValue);
								}							
						}				
					}		    	
				}				
			}			
		}
		
		return hm;
	}
	

	
	public LinkedList getMEA(Node segmentNode) {
		//MEA+WT+AAE+KGM:240
		LinkedList hm = new LinkedList();
		
		LabelValue labelValue = new LabelValue("SEGMENT","MEASUREMENTS");
		hm.add(labelValue);

//segmentId[MEA]
//segments.item(0).getNodeValue()[null] elementId[MEA01]
//segments.item(0).getNodeValue()[null] elements.item(0).getNodeValue()[WT]
//segments.item(1).getNodeValue()[null] elementId[MEA02]
//segments.item(1).getNodeValue()[null] elements.item(0).getNodeValue()[AAB]
//segments.item(2).getNodeValue()[null] elementId[MEA03]
//segments.item(2).getNodeValue()[null] elements.item(0).getNodeValue()[null] subelements.item(0).getNodeValue()[KGM]
//segments.item(2).getNodeValue()[null] elements.item(1).getNodeValue()[null] subelements.item(0).getNodeValue()[27250.000]

		NodeList segments = segmentNode.getChildNodes();
		// process elements
		for (int i2=0;i2<segments.getLength();i2++){
			if (segments.item(i2).getNodeValue() != null) {  
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"					
				);*/
			}			
			String elementId = segments.item(i2).getAttributes().getNamedItem("Id").getNodeValue().trim();	
			if (elementId != null) {
/*				log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
						" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"								   
						+" elementId["+elementId+"]"							
				);*/					
			}
			
			NodeList elements = segments.item(i2).getChildNodes();			
			// 
			for (int i3=0;i3<elements.getLength();i3++){
				if (elements.item(i3).getNodeValue() != null) {  
/*					log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
							" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+								   
							" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"						
					);*/
					if (elementId.equals("MEA01")) {
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<measurementQualifier.length; i++) { 
							if (measurementQualifier[i].equals(qualifier)) {
								type = measurementType[i];
								break;
							}
						}
						labelValue = new LabelValue("Measurement application",type);
						hm.add(labelValue);						
					}
					if (elementId.equals("MEA02")) {
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<dimensionQualifier.length; i++) { 
							if (dimensionQualifier[i].equals(qualifier)) {
								type = dimensionType[i];
								break;
							}
						}
						labelValue = new LabelValue("Measurement dimension",type);
						hm.add(labelValue);						
					}	
					if (elementId.equals("MEA03")) {
						String qualifier = elements.item(i3).getNodeValue();
						String type = "";
						for (int i=0; i<measurementunitQualifier.length; i++) { 
							if (measurementunitQualifier[i].equals(qualifier)) {
								type = measurementunitType[i];
								break;
							}
						}
						labelValue = new LabelValue("Measurement unit qualifier",type);
						hm.add(labelValue);						
					}						
				}				
				NodeList subelements = elements.item(i3).getChildNodes();				
				// 
				for (int i4=0;i4<subelements.getLength();i4++){
					if (subelements.item(i4).getNodeValue() != null) {  
/*						log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
								" segments.item("+i2+").getNodeValue()["+segments.item(i2).getNodeValue()+"]"+						    		
								" elements.item("+i3+").getNodeValue()["+elements.item(i3).getNodeValue()+"]"+						    		
								" subelements.item("+i4+").getNodeValue()["+subelements.item(i4).getNodeValue()+"]"
						);*/
						if (elementId.equals("MEA02")) {	
							if (i3==0) {
								String qualifier = subelements.item(i4).getNodeValue();
								String type = "";
								for (int i=0; i<dimensionQualifier.length; i++) { 
									if (dimensionQualifier[i].equals(qualifier)) {
										type = dimensionType[i];
										break;
									}
								}
								labelValue = new LabelValue("Measurement property code",type);
								hm.add(labelValue);									
							}
							if (i3==1) {
								labelValue = new LabelValue("Measurement property value ",subelements.item(i4).getNodeValue());
								hm.add(labelValue);
							}							
						}				
						if (elementId.equals("MEA03")) {
							if (i3==0) {
								String qualifier = subelements.item(i4).getNodeValue();
								String type = "";
								for (int i=0; i<measurementunitQualifier.length; i++) { 
									if (measurementunitQualifier[i].equals(qualifier)) {
										type = measurementunitType[i];
										break;
									}
								}
								labelValue = new LabelValue("Measurement unit qualifier",type);
								hm.add(labelValue);									
							}
							if (i3==1) {
								labelValue = new LabelValue("Measurement unit value ",subelements.item(i4).getNodeValue());
								hm.add(labelValue);
							}							
						}	
					}		    	
				}				
			}			
		}
		
		return hm;
	}

	
	
	
	
}

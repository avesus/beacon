/*
 * $Id:   EdifactIftmbfTransformer$
 * 
 * 
 *  
 */

package com.bureaueye.beacon.bean.edi;


import java.util.LinkedList;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.bean.LabelValue;


/**
 * Firm Booking Transformer from UN/EDIFACT to data fields
 *
 * @version $Rev: 00001 (Sat, 03 Nov 2006) $
 */

public final class EdifactIftmbfTransformerV1 {
	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);
	
	//private HashMap h = new HashMap();
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
	
/*	private static final String GENERAL_INFORMATION = "AAI";
	private static final String TRANSPORTATION_INFORMATION = "TRA";
	private static final String DECLARATION = "DCL";
	private static final String DISCREPANCY_INFORMATION = "ABO";
	private static final String PRODUCT_INFORMATION = "PRD";
	private static final String GOODS_INFORMATION = "AAA";
	private static final String RISK_AND_HANDLING_INFORMATION = "RAH";
	private static final String ADDITIONAL_INFORMATION = "ACB";
	private static final String DANGEROUS_GOODS_INFORMATION = "ACB";
	private static final String LOADING_INSTRUCTION = "LOI";
	private static final String SPECIAL_PERMISSION_CONCERNING_PACKAGE = "SPP";
	private static final String HANDLING_RESTRICTION = "AAN";
	private static final String HANDLING_INSTRUCIONS = "HAN";
	private static final String EQUIPMENT = "AGK";
	private static final String TEMPERATURE_CONTROL_INSTRUCTIONS = "AEB";
	private static final String LOADING_REMARKS = "CLR";
	private static final String SPECIAL_INSTRUCTIONS = "SIN";
	private static final String RATE_ADDITIONAL_INFORMATION = "AAF";
	private static final String DESCRIPTION_OF_WORK_ITEM_ON_EQUIPMENT = "ADQ";
	private static final String OTHER_SERVICE_INFORMATION = "OSI";
	private static final String INLAND_TRANSPORT_DETAILS = "ITR";*/
	
	private static final String[] textsubjectQualifier =
	{
		"AAI","TRA","DCL","ABO","PRD","AAA","RAH",
		"ACB","AAD","LOI","SPP","AAN","HAN","AGK",
		"AEB","CLR","SIN","AAF","ADQ","OSI","ITR"
	};
	private static final String[] textsubjectName =
	{
		"GENERAL INFORMATION",
		"TRANSPORTATION INFORMATION",
		"DECLARATION",
		"DISCREPANCY INFORMATION",
		"PRODUCT INFORMATION",
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
		"INLAND TRANSPORT DETAILS"
	};    
	
	
	private static final String[] partyQualifier =
	{
		"EP","DCP","AG","CZ","BA","FW","CA"
	};
	private static final String[] partyFunction =
	{
		"EQUIPMENT DROP-OFF PARTY",
		"DCP",
		"AGENT/REPRESENTATIVE",
		"CONSIGNOR",
		"BOOKING AGENT",
		"FREIGHT FORWARDER",
		"CARRIER"
	};  
	
	private static final String[] locationQualifier =
	{
		"10","88","92","9","18","12","7","20"
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
		"PLACE OF ULTIMATE DESTINATION"
	}; 
	
	private static final String[] referenceQualifier =
	{
		"SI","LI"
	};
	private static final String[] referenceType =
	{
		"SHIPPERS IDENTIFYING NUMBER",
		"LINE ITEM REFERENCE NUMBER"
	}; 
	
	private static final String[] contactQualifier =
	{
		"MS","HG"
	};
	private static final String[] contactFunction =
	{
		"MESSAGE SENDER CONTACT",
		"DANGEROUS GOODS CONTACT"
	}; 
	
	private static final String[] transportQualifier =
	{
		"10","20"
	};
	private static final String[] transportType =
	{
		"PRE-CARRIAGE",
		"MAIN TRANSPORT"
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
		"31","24","11"
	};
	private static final String[] transportmeansType =
	{
		"TRUCK",
		"RAIL EXPRESS",
		"SHIP"
	};
	
	private static final String[] controlQualifier =
	{
		"15","32","1"
	};
	private static final String[] controlType =
	{
		"TOTAL CONSIGNMENT CUBE",
		"TOTAL GROSS WEIGHT OF GOODS",
		"ALGEBRAIC TOTAL"
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
		"WT","TE","DEN","AAE","TC"
	};
	private static final String[] measurementType =
	{
		"WEIGHTS",
		"TEMPERATURE",
		"DENSITY",
		"",
		"TEMPERATURE"
	};
	
	private static final String[] dimensionQualifier =
	{
		"AAE","AAD","AAC","WT","TC","ADE","ZZZ","RUN"
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
		"RUN"
	};
	
	
	
	public EdifactIftmbfTransformerV1() {}
	
	
	public LinkedList getUNB(String _in) {
		//UNB+UNOC:3+BASFAG+S272485_Bulkhaul+060206:1441+3045
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		
		// check at least 6 sub elements are available
		if (st.countTokens() < 6) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","INTERCHANGE HEADER");
		hm.add(labelValue);
		labelValue = new LabelValue("SYNTAX IDENTIFIER:VERSION",st.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("SENDER IDENTIFICATION",st.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("RECIPIENT IDENTIFICATION",st.nextToken());
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		
		// check at least 2 sub elements are available
		if (st2.countTokens() < 2) return null;
		
		labelValue = new LabelValue("DATE OF PREPARATION",st2.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("TIME OF PREPARATION",st2.nextToken());
		hm.add(labelValue);
		
		
		labelValue = new LabelValue("INTERCHANGE CONTROL REFERENCE",st.nextToken());
		hm.add(labelValue);		
		

		
		return hm;
	}
	
	
	public LinkedList getUNH(String _in) {
		//UNH+3045+IFTMBF:D:96A:UN
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","MESSAGE HEADER");
		hm.add(labelValue);
		labelValue = new LabelValue("MESSAGE REFERENCE NUMBER",st.nextToken());
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		
		// check at least 4 sub elements are available
		if (st2.countTokens() < 4) return null;
		
		labelValue = new LabelValue("MESAGE TYPE",st2.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("VERSION NUMBER",st2.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("RELEASE NUMBER",st2.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("CONTROLLING AGENCY",st2.nextToken());
		hm.add(labelValue);		
		

		
		return hm;
	}
	
	
	public LinkedList getBGM(String _in) {
		//BGM+335+2001179149+9
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		
		// check at least 4 sub elements are available
		if (st.countTokens() < 4) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","BEGINNING OF MESSAGE");
		hm.add(labelValue);
		labelValue = new LabelValue("BOOKING REQUEST",st.nextToken());
		hm.add(labelValue);	
		labelValue = new LabelValue("DOCUMENT NUMBER",st.nextToken());
		hm.add(labelValue);	
		
		try {
			int function = new Integer(st.nextToken()).intValue();
			switch(function)
			{
			case CANCELLATION:
				labelValue = new LabelValue("MESSAGE FUNCTION","CANCELLATION");
				break;
			case ALTERATION:
				labelValue = new LabelValue("MESSAGE FUNCTION","ALTERATION");
				break;
			case ORIGINAL:
				labelValue = new LabelValue("MESSAGE FUNCTION","ORIGINAL");
				break;
			case COPY:
				labelValue = new LabelValue("MESSAGE FUNCTION","COPY");
				break;                
			default: ;
			}
			hm.add(labelValue);	
		} catch (Exception e) {}
		

		
		return hm;
	}
	
	
	public LinkedList getCTA(String _in) {
		//CTA+MS+:Frau Eck
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();		
		
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","CONTACT");
		hm.add(labelValue);
		
		String qualifier = st.nextToken();
		String function = "";
		for (int i=0; i<contactQualifier.length; i++) { 
			if (contactQualifier[i].equals(qualifier)) {
				function = contactFunction[i];
				break;
			}
		}
		labelValue = new LabelValue("CONTACT FUNCTION",function);
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		// check at least 2 sub elements are available
		// this did not work - when the segment was +:Frau Eck is only showed 1 sub element!!!!
		//if (st2.countTokens() < 2) return null;
		try {
			labelValue = new LabelValue("DEPARTMENT OR EMPLOYEE INFO 1",st2.nextToken());
			hm.add(labelValue);	
		} catch (Exception e) {}
		try {
			labelValue = new LabelValue("DEPARTMENT OR EMPLOYEE INFO 2",st2.nextToken());
			hm.add(labelValue);	
		} catch (Exception e) {}		
		

		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getCTA - countTokens["+countTokens+"]" 
				);	
		
		return hm;
	}
	
	
	public LinkedList getCOM(String _in) {
		//COM+0621 60-66 93586:FX
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","COMMUNICATION");
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		
		// check at least 2 sub elements are available
		if (st2.countTokens() < 2) return null;
		
		labelValue = new LabelValue("COMMUNICATION NUMBER",st2.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("COMMUNICATION TYPE",st2.nextToken());
		hm.add(labelValue);
		

		
		return hm;
	}
	
	
	public LinkedList getDTM(String _in) {
		//DTM+133:20060225:102
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","DATE/TIME/PERIOD");
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		
		// check at least 3 sub elements are available
		if (st2.countTokens() < 3) return null;
		
		try {
			int qualifier = new Integer(st2.nextToken()).intValue();
			switch(qualifier)
			{        
			case DOCUMENT_MESSAGE_DATE_TIME:
				labelValue = new LabelValue("DATE/TIME/PERIOD TYPE","DOCUMENT/MESSAGE DATE/TIME");
				break;               
			case DEPARTURE_DATE_TIME_ESTIMATED:
				labelValue = new LabelValue("DATE/TIME/PERIOD TYPE","DEPARTURE DATE/TIME ESTIMATED");
				break;  
			case ARRIVAL_DATE_TIME_ESTIMATED:
				labelValue = new LabelValue("DATE/TIME/PERIOD TYPE","ARRIVAL DATE/TIME ESTIMATED");
				break; 
			case CLOSING_DATE_TIME:
				labelValue = new LabelValue("DATE/TIME/PERIOD TYPE","CLOSING DATE/TIME");
				break; 
			case BILL_OF_LADING_DATE:
				labelValue = new LabelValue("DATE/TIME/PERIOD TYPE","BILL OF LADING DATE");
				break; 	                
			default: ;
			}
			hm.add(labelValue);	
		} catch (Exception e) {}
		
		labelValue = new LabelValue("DATE/TIME/PERIOD",st2.nextToken());
		hm.add(labelValue);
		
		try {
			int format = new Integer(st2.nextToken()).intValue();
			switch(format)
			{
			case YYYYMMDDHHMM:
				labelValue = new LabelValue("DATE/TIME/PERIOD FORMAT TYPE","YYYYMMDDHHMM");
				break;               
			case CCYYMMDD:
				labelValue = new LabelValue("DATE/TIME/PERIOD FORMAT TYPE","CCYYMMDD");
				break; 
			default: ;
			}
			hm.add(labelValue);	
		} catch (Exception e) {}
		

		
		return hm;
	}
	
	
	public LinkedList getFTX(String _in) {
		//FTX+AAN+++Polyethylen niedriger Dichte (LDPE)
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","TEXT");
		hm.add(labelValue);
		
		String qualifier = st.nextToken();
		String name = "";
		for (int i=0; i<textsubjectQualifier.length; i++) { 
			if (textsubjectQualifier[i].equals(qualifier)) {
				name = textsubjectName[i];
				break;
			}
		}
		labelValue = new LabelValue("TEXT SUBJECT",name);
		hm.add(labelValue);
		
		//if (countTokens == 4) st.nextToken(); // extra read for ref details
		//if (countTokens == 5) st.nextToken(); // extra read for ref details
		
		try {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
			for (int i=0; st2.hasMoreTokens(); i++) { 
				int lineNumber = i+1;
				labelValue = new LabelValue("TEXT LINE "+lineNumber,st2.nextToken());
				hm.add(labelValue);	
			}
		} catch (Exception e) {}

		try {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
			for (int i=0; st2.hasMoreTokens(); i++) { 
				int lineNumber = i+1;
				labelValue = new LabelValue("TEXT LINE "+lineNumber,st2.nextToken());
				hm.add(labelValue);	
			}
		} catch (Exception e) {}

		try {
			StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
			for (int i=0; st2.hasMoreTokens(); i++) { 
				int lineNumber = i+1;
				labelValue = new LabelValue("TEXT LINE "+lineNumber,st2.nextToken());
				hm.add(labelValue);	
			}
		} catch (Exception e) {}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getFTX - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getNAD(String _in) {
		//NAD+DCP+272485++Bulkhaul (Germany) GmbH++Fussgönheim+++DE
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		//if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","PARTY");
		hm.add(labelValue);
		
		String qualifier = st.nextToken();
		String function = "";
		for (int i=0; i<partyQualifier.length; i++) { 
			if (partyQualifier[i].equals(qualifier)) {
				function = partyFunction[i];
				break;
			}
		}
		labelValue = new LabelValue("PARTY FUNCTION",function);
		hm.add(labelValue);
		
		labelValue = new LabelValue("PARTY IDENTIFICATION",st.nextToken());
		hm.add(labelValue);
		
		// 
		for (int i=0; st.hasMoreTokens(); i++) { 
			int lineNumber = i+1;
			labelValue = new LabelValue("NAME/ADDRESS LINE "+lineNumber,st.nextToken());
			hm.add(labelValue);	
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getNAD - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getLOC(String _in) {
		//LOC+9+NLRTM:::ROTTERDAM
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","LOCATION");
		hm.add(labelValue);
		
		String qualifier = st.nextToken();
		String type = "";
		for (int i=0; i<locationQualifier.length; i++) { 
			if (locationQualifier[i].equals(qualifier)) {
				type = locationType[i];
				break;
			}
		}
		labelValue = new LabelValue("LOCATION TYPE",type);
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		for (int i=0; st2.hasMoreTokens(); i++) { 
			int lineNumber = i+1;
			labelValue = new LabelValue("LOCATION ID/NAME "+lineNumber,st2.nextToken());
			hm.add(labelValue);	
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getLOC - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getRFF(String _in) {
		//RFF+LI:3083952913:000010
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","REFERENCE");
		hm.add(labelValue);
		
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		
		// check at least 2 sub elements are available
		//int countTokens2 = st2.countTokens();
		//if (st2.countTokens() < 2) return null;
		
		String qualifier = st2.nextToken();
		String type = "";
		for (int i=0; i<referenceQualifier.length; i++) { 
			if (referenceQualifier[i].equals(qualifier)) {
				type = referenceType[i];
				break;
			}
		}
		labelValue = new LabelValue("REFERENCE TYPE",type);
		hm.add(labelValue);
		
		labelValue = new LabelValue("REFERENCE NUMBER",st2.nextToken());
		hm.add(labelValue);		
		
		if (st2.hasMoreTokens()) {
			labelValue = new LabelValue("LINE NUMBER",st2.nextToken());
			hm.add(labelValue);	
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getRFF - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getTDT10(String _in) {
		//TDT+10++60+11
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 4 sub elements are available
		if (st.countTokens() < 4) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT");
		hm.add(labelValue);
		
		if (countTokens == 5) st.nextToken(); // a dummy read
		
		String qualifier = st.nextToken();
		String type = "";
		for (int i=0; i<transportQualifier.length; i++) { 
			if (transportQualifier[i].equals(qualifier)) {
				type = transportType[i];
				break;
			}
		}
		labelValue = new LabelValue("TRANSPORT STAGE",type);
		hm.add(labelValue);
		
		qualifier = st.nextToken();
		type = "";
		for (int i=0; i<transportmodeQualifier.length; i++) { 
			if (transportmodeQualifier[i].equals(qualifier)) {
				type = transportmodeType[i];
				break;
			}
		}
		labelValue = new LabelValue("TRANSPORT MODE",type);
		hm.add(labelValue);
		
		qualifier = st.nextToken();
		type = "";
		for (int i=0; i<transportmeansQualifier.length; i++) { 
			if (transportmeansQualifier[i].equals(qualifier)) {
				type = transportmeansType[i];
				break;
			}
		}
		labelValue = new LabelValue("TRANSPORT MEANS",type);
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getTDT10 - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getTDT20(String _in) {
		//TDT+20++10+13++++9219800:::CHASTINE MAERSK
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 5 sub elements are available
		if (st.countTokens() < 5) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT");
		hm.add(labelValue);
		
		String qualifier = st.nextToken();
		String type = "";
		for (int i=0; i<transportQualifier.length; i++) { 
			if (transportQualifier[i].equals(qualifier)) {
				type = transportType[i];
				break;
			}
		}
		labelValue = new LabelValue("TRANSPORT STAGE",type);
		hm.add(labelValue);
		
		qualifier = st.nextToken();
		type = "";
		for (int i=0; i<transportmodeQualifier.length; i++) { 
			if (transportmodeQualifier[i].equals(qualifier)) {
				type = transportmodeType[i];
				break;
			}
		}
		labelValue = new LabelValue("TRANSPORT MODE",type);
		hm.add(labelValue);
		
		qualifier = st.nextToken();
		type = "";
		for (int i=0; i<transportmeansQualifier.length; i++) { 
			if (transportmeansQualifier[i].equals(qualifier)) {
				type = transportmeansType[i];
				break;
			}
		}
		labelValue = new LabelValue("TRANSPORT MEANS",type);
		hm.add(labelValue);
		
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		for (int i=0; st2.hasMoreTokens(); i++) { 
			int lineNumber = i+1;
			labelValue = new LabelValue("TRANSPORT ID/NAME "+lineNumber,st2.nextToken());
			hm.add(labelValue);	
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getTDT20 - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getCNT(String _in) {
		//CNT+32:42000.000:KGM'
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();

		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","CONTROL TOTAL");
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		
		// check at least 3 sub elements are available
		//int countTokens2 = st2.countTokens();
		//if (st2.countTokens() < 3) return null;
		
		try {
			String qualifier = st2.nextToken();
			String type = "";
			for (int i=0; i<controlQualifier.length; i++) { 
				if (controlQualifier[i].equals(qualifier)) {
					type = controlType[i];
					break;
				}
			}
			labelValue = new LabelValue("CONTROL TYPE",type);
			hm.add(labelValue);
		} catch (Exception e) {}
		
		try {
			labelValue = new LabelValue("CONTROL VALUE",st2.nextToken());
			hm.add(labelValue);
		} catch (Exception e) {}
		
		try {
			labelValue = new LabelValue("MEASURE UNIT",st2.nextToken());
			hm.add(labelValue);	
		} catch (Exception e) {}		
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getCNT - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getTSR(String _in) {
		//TSR+30
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT SERVICE");
		hm.add(labelValue);
		
		
		String qualifier = st.nextToken();
		String type = "";
		for (int i=0; i<serviceQualifier.length; i++) { 
			if (serviceQualifier[i].equals(qualifier)) {
				type = serviceType[i];
				break;
			}
		}
		labelValue = new LabelValue("SERVICE TYPE",type);
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getTSR - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getPIA(String _in) {
		//PIA+5+50557586:SA
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","ADDITIONAL PRODUCT ID");
		hm.add(labelValue);
		
		labelValue = new LabelValue("PRODUCT ID",st.nextToken());
		hm.add(labelValue);
		
		labelValue = new LabelValue("ITEM NUMBER:TYPE",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getPIA - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getRNG(String _in) {
		//RNG+5+CEL:-10:25
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","RANGE DETAILS");
		hm.add(labelValue);
		
		labelValue = new LabelValue("TEMPERATURE RANGE",st.nextToken());
		hm.add(labelValue);
		
		labelValue = new LabelValue("CEL RANGE:MINIMUM:MAXIMUM",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getRNG - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getSGP(String _in) {
		//SGP+32369645
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","SPLIT GOODS PLACEMENT");
		hm.add(labelValue);
		
		labelValue = new LabelValue("EQUIPMENT ID NUMBER",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getSGP - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getEQN(String _in) {
		//EQN+1
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","NUMBER OF UNITS");
		hm.add(labelValue);
		
		labelValue = new LabelValue("NUMBER OF UNITS",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getEQN - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getEQD(String _in) {
		//EQD+CN+32369645+20TC:::20?
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 4 sub elements are available
		if (st.countTokens() < 4) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","EQUIPMENT DETAILS");
		hm.add(labelValue);
		
		labelValue = new LabelValue("EQUIPMENT TYPE",st.nextToken());
		hm.add(labelValue);
		
		labelValue = new LabelValue("EQUIPMENT ID NUMBER",st.nextToken());
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		for (int i=0; st2.hasMoreTokens(); i++) { 
			int lineNumber = i+1;
			labelValue = new LabelValue("EQUIPMENT SIZE/TYPE "+lineNumber,st2.nextToken());
			hm.add(labelValue);	
		}
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getEQD - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getGID(String _in) {
		//GID+1
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","GOODS ITEM DETAILS");
		hm.add(labelValue);
		
		labelValue = new LabelValue("GOODS ITEM NUMBER",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getGID - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getDGS(String _in) {
		//DGS+ZZZ
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","DANGEROUS GOODS");
		hm.add(labelValue);
		
		labelValue = new LabelValue("DANGEROUS GOODS REGULATIONS",st.nextToken());
		hm.add(labelValue);
		
		// 
		for (int i=0; st.hasMoreTokens(); i++) { 
			int lineNumber = i+1;
			labelValue = new LabelValue("DANGEROUS GOODS ELEMENT "+lineNumber,st.nextToken());
			hm.add(labelValue);	
		}
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getDGS - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getTMD(String _in) {
		//TMD+3:Carriers Haulage++1
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 2 sub elements are available
		if (st.countTokens() < 2) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","TRANSPORT MOVEMENT DETAILS");
		hm.add(labelValue);
		
		// 
		StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
		if (st2.countTokens() < 2) return null;
		
		String qualifier = st2.nextToken();
		String type = "";
		for (int i=0; i<movementQualifier.length; i++) { 
			if (movementQualifier[i].equals(qualifier)) {
				type = movementType[i];
				break;
			}
		}
		labelValue = new LabelValue("MOVEMENT TYPE CODE",type);
		hm.add(labelValue);
		
		labelValue = new LabelValue("MOVEMENT TYPE",st2.nextToken());
		hm.add(labelValue);
		
		qualifier = st.nextToken();
		type = "";
		for (int i=0; i<haulageQualifier.length; i++) { 
			if (haulageQualifier[i].equals(qualifier)) {
				type = haulageType[i];
				break;
			}
		}
		labelValue = new LabelValue("HAULAGE ARRANGEMENTS",type);
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getTMD - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	public LinkedList getMEA(String _in) {
		//MEA+WT+AAE+KGM:240
		
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 4 sub elements are available
		if (st.countTokens() < 4) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","MEASUREMENTS");
		hm.add(labelValue);
		
		String qualifier = st.nextToken();
		String type = "";
		for (int i=0; i<measurementQualifier.length; i++) { 
			if (measurementQualifier[i].equals(qualifier)) {
				type = measurementType[i];
				break;
			}
		}
		labelValue = new LabelValue("MEASUREMENT APPLICATION",type);
		hm.add(labelValue);
		
		qualifier = st.nextToken();
		type = "";
		for (int i=0; i<dimensionQualifier.length; i++) { 
			if (dimensionQualifier[i].equals(qualifier)) {
				type = dimensionType[i];
				break;
			}
		}
		labelValue = new LabelValue("MEASUREMENT DIMENSION",type);
		hm.add(labelValue);
		
		
		labelValue = new LabelValue("MEASUREMENT UNIT:VALUE",st.nextToken());
		hm.add(labelValue);
		
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getMEA - countTokens["+countTokens+"]" 
		);	
		
		return hm;
	}
	
	
	
	public LinkedList getUNT(String _in) {
		//UNT+106+3038
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","MESSAGE TRAILER");
		hm.add(labelValue);
		labelValue = new LabelValue("NUMBER OF SEGMENTS",st.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("MESSAGE REFERENCE NUMBER",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getUNT - countTokens["+countTokens+"]" 
		);
		
		return hm;
	}
	
	
	public LinkedList getUNZ(String _in) {
		//UNZ+1+3038
		LinkedList hm = new LinkedList();
		
		StringTokenizer st = new StringTokenizer(_in,"+");
		int countTokens = st.countTokens();
		// check at least 3 sub elements are available
		if (st.countTokens() < 3) return null;
		st.nextToken();
		LabelValue labelValue = new LabelValue("SEGMENT","INTERCHANGE TRAILER");
		hm.add(labelValue);
		labelValue = new LabelValue("INTERCHANGE CONTROL COUNT",st.nextToken());
		hm.add(labelValue);
		labelValue = new LabelValue("INTERCHANGE CONTROL REFERENCE",st.nextToken());
		hm.add(labelValue);
		
		log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
				" getUNZ - countTokens["+countTokens+"]" 
		);
		
		return hm;
	}
	
	
}

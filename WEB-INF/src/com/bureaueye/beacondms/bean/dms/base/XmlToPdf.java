package com.bureaueye.beacondms.bean.dms.base;



import java.util.Calendar;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacondms.exception.dms.BuildException;
import com.bureaueye.beacondms.model.dms.Documenttype;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.util.Util;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;







/**
 *
 * Amendments
 * ----------
 *
 */
public final class XmlToPdf {

	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(Constants.PACKAGE);

	org.w3c.dom.Element elementDocument;
	Companyheader companyHeader;
	static PropertyResourceBundle resourceProps;
	Documenttype documenttypedao;

	Font font;
	float fontSize;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	





	//constructor
	public XmlToPdf(
			Companyheader header,
			Documenttype documenttypedao,
			org.w3c.dom.Element element
	) throws BuildException {

		try{
			this.companyHeader = header;
			this.elementDocument = element;
			this.documenttypedao=documenttypedao;

			//init document resource by languageid
			String resourceName="com.bureaueye.beacondms.DocumentResources_"+documenttypedao.getLanguageid();
			resourceProps = (PropertyResourceBundle) ResourceBundle.getBundle(resourceName);

			//init default fonts for document type
			BaseFont baseFont = 
				BaseFont.createFont(
						documenttypedao.getFontname(), 
						BaseFont.CP1252, 
						BaseFont.NOT_EMBEDDED
				);
			font=new Font(
					baseFont,
					documenttypedao.getFontsize().floatValue(),
					documenttypedao.getFontstyle()
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);

		} catch (Exception e) {
			throw new BuildException(BuildException.GENERAL_FAILURE);	
		}
	}








	public PdfPTable getAddress(
			String label,
			org.w3c.dom.Element eElement 
	) {			
		PdfPCell _label =  new PdfPCell();
		_label.setBorder(0);

		PdfPTable _text =  new PdfPTable(1);			
		_text.getDefaultCell().setBorder(0);				
		_label.setPhrase(new Phrase(label,fontSmallBold));
		_label.setHorizontalAlignment(Element.ALIGN_LEFT); 			
		_text.addCell(_label);   	   		

		if (getTagValue("name",eElement).equals("")) {
			_text.addCell(new Phrase("TBA",fontSmall));
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));
			_text.addCell(new Phrase(" ",fontSmall));
		} else {
			_text.addCell(new Phrase(getTagValue("name",eElement)+" ",fontSmall));		
			_text.addCell(new Phrase(getTagValue("addr1",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr2",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr3",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr4",eElement)+" ",fontSmall));	
			_text.addCell(new Phrase(getTagValue("addr5",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr6",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr7",eElement)+" ",fontSmall));	
			_text.addCell(
					new Phrase(
							resourceProps.getString("prompt.tel")+
							" "+
							getTagValue("telno",eElement)+
							" / "+
							resourceProps.getString("prompt.fax")+
							" "+
							getTagValue("faxno",eElement)
							,
							fontSmall
					)
			);	
		}
		return _text;
	}



	public PdfPTable getAddressWithVat(
			String label,
			org.w3c.dom.Element eElement 
	) {			
		PdfPCell _label =  new PdfPCell();
		_label.setBorder(0);

		PdfPTable _text =  new PdfPTable(1);			
		_text.getDefaultCell().setBorder(0);				
		_label.setPhrase(new Phrase(label,fontSmallBold));
		_label.setHorizontalAlignment(Element.ALIGN_LEFT); 			
		_text.addCell(_label);   	   		

		if (getTagValue("name",eElement).equals("")) {
			_text.addCell(new Phrase("TBA",fontSmall));
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));	
			_text.addCell(new Phrase(" ",fontSmall));
			_text.addCell(new Phrase(" ",fontSmall));
			_text.addCell(new Phrase(" ",fontSmall));
		} else {
			_text.addCell(new Phrase(getTagValue("name",eElement)+" ",fontSmall));		
			_text.addCell(new Phrase(getTagValue("addr1",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr2",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr3",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr4",eElement)+" ",fontSmall));	
			_text.addCell(new Phrase(getTagValue("addr5",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr6",eElement)+" ",fontSmall));
			_text.addCell(new Phrase(getTagValue("addr7",eElement)+" ",fontSmall));	
			_text.addCell(
					new Phrase(
							resourceProps.getString("prompt.tel")+
							" "+
							getTagValue("telno",eElement)+
							" / "+
							resourceProps.getString("prompt.fax")+
							" "+
							getTagValue("faxno",eElement)
							,
							fontSmall
					)
			);	
			if (getTagValue("g3codekey",eElement).equals("ISR")) {
				_text.addCell(
						new Phrase(
								resourceProps.getString("prompt.vat")+
								": "+
								getTagValue("vatno",eElement)
								,
								fontSmall
						)
				);				
			} 
			if (getTagValue("g1codekey",eElement).equals("SAM")) {
				_text.addCell(
						new Phrase(
								resourceProps.getString("prompt.cnpj")+
								": "+
								getTagValue("vatno",eElement)
								,
								fontSmall
						)
				);					
			} 
		}
		return _text;
	}



	public PdfPTable getFreightandcharges(
			String label,
			org.w3c.dom.Element eElement 
	) {			
		PdfPCell _label =  new PdfPCell();
		_label.setBorder(0);

		PdfPTable _text =  new PdfPTable(1);			
		_text.getDefaultCell().setBorder(0);				
		_label.setPhrase(new Phrase(label,fontSmallBold));
		_label.setHorizontalAlignment(Element.ALIGN_LEFT); 			
		_text.addCell(_label);   	   		

		_text.addCell(new Phrase("TBA",fontSmall));
		_text.addCell(new Phrase(" ",fontSmall));	
		_text.addCell(new Phrase(" ",fontSmall));	
		_text.addCell(new Phrase(" ",fontSmall));	
		_text.addCell(new Phrase(" ",fontSmall));	
		_text.addCell(new Phrase(" ",fontSmall));	
		_text.addCell(new Phrase(" ",fontSmall));	
		_text.addCell(new Phrase(" ",fontSmall));
		_text.addCell(new Phrase(" ",fontSmall));
		_text.addCell(new Phrase(" ",fontSmall));

		return _text;
	}






	public String getVesselVoyage(
			org.w3c.dom.Element eElement 
	) {			 		
		String vesselVoyage="";

		try {

			//get xml elements
			org.w3c.dom.Element elementVessel=(org.w3c.dom.Element) eElement.getElementsByTagName("vessel").item(0);

			vesselVoyage=
				getTagValue("vesselname",elementVessel)+
				" / "+
				getTagValue("voyage",eElement)
				;

		} catch (Exception e) {
		}

		return vesselVoyage;
	}



	public String getFraddr(
			org.w3c.dom.Element eElement 
	) {			 		
		String fraddr="";

		try {

			//get xml elements
			org.w3c.dom.Element elementFraddrkey=(org.w3c.dom.Element) eElement.getElementsByTagName("fraddrkey").item(0);

			fraddr=
				getTagValue("g4ldesc",elementFraddrkey)+
				", "+
				countryRule(elementFraddrkey)
				;

		} catch (Exception e) {
		}

		return fraddr;
	}



	public String getToaddr(
			org.w3c.dom.Element eElement 
	) {			 		
		String toaddr="";

		try {

			//get xml elements
			org.w3c.dom.Element elementToaddrkey=(org.w3c.dom.Element) eElement.getElementsByTagName("toaddrkey").item(0);

			toaddr=
				getTagValue("g4ldesc",elementToaddrkey)+
				", "+
				countryRule(elementToaddrkey)
				;

		} catch (Exception e) {
		}

		return toaddr;
	}


	public String getTankno(
			org.w3c.dom.Element eElement 
	) {			 		
		String tankno="";

		try {
			tankno=unitkeyRule2(eElement);			
		} catch (Exception e) {
		}

		return tankno;
	}


	public String getTankCapcm(
			org.w3c.dom.Element element1,
			org.w3c.dom.Element element2
	) {			 		
		String tankCapcm="";		
		org.w3c.dom.Element elementTog3key = null;

		try {
			elementTog3key=(org.w3c.dom.Element) element2.getElementsByTagName("tog3key").item(0);

			if (getTagValue("g3codekey",elementTog3key).equals("BR")) {
				tankCapcm=getTagValue("capcm",element1)+"cbm";
			}

		} catch (Exception e) {
		}

		return tankCapcm;
	}





	public String getProductDetail(
			org.w3c.dom.Element eElement		
	) throws BuildException {		 		
		String productDetail="";		
		String productText="";
		org.w3c.dom.Element elementOrdprod10= null;
		org.w3c.dom.Element elementDchg1key= null;

		try {		

			elementOrdprod10=(org.w3c.dom.Element) eElement.getElementsByTagName("ordprod10").item(0);
			elementDchg1key=(org.w3c.dom.Element) eElement.getElementsByTagName("dchg1key").item(0);

			productText=getProductText(elementOrdprod10,elementDchg1key);
			productDetail=productText;


		} catch (Exception e) {
			throw new BuildException(BuildException.GENERAL_FAILURE);
		}

		return productDetail;
	}



	private String getProductText(
			org.w3c.dom.Element eElement1,	//product
			org.w3c.dom.Element eElement2	//dchg1key
	) throws BuildException {	 		
		String productText="";
		org.w3c.dom.Element elementProdcode= null;

		try {		

			elementProdcode=(org.w3c.dom.Element) eElement1.getElementsByTagName("prodcode").item(0);
			if (elementProdcode==null) {
				elementProdcode=eElement1;			
			}

			//non haz
			String prodcodeUnno=getTagValue("unno",elementProdcode);
			if (prodcodeUnno.equals("0")) {
				productText=
					getTagValue("prefix",elementProdcode)+" "+
					getTagValue("chemname",elementProdcode)+"\n "+
					getTagValue("tradname",elementProdcode)+" "+
					resourceProps.getString("prompt.nonhazardous")
					;	
			}

			//haz
			else {

				String prodcodePrefix=getTagValue("prefix",elementProdcode);
				if (!prodcodePrefix.equals("")) {
					productText=
						prodcodePrefix+" "+
						getTagValue("chemname",elementProdcode)+"\n "
						;
				}

				String prodcodeTxt=getTagValue("txt",elementProdcode);
				if (!prodcodeTxt.equals("")) {
					productText=
						"("+resourceProps.getString("prompt.contains")+" "+prodcodeTxt+"\n"+
						resourceProps.getString("prompt.class")+": "+getTagValue("prdlabel",elementProdcode)+"\n"+
						resourceProps.getString("prompt.un")+": "+getTagValue("unno",elementProdcode)+"\n"+
						resourceProps.getString("prompt.pg")+": "+getTagValue("packgrp",elementProdcode)+"\n"
						;
				}


				//TODO: MISSING CODE FOR FLASHP BECAUSE DO NOT KNOW HOW TO DIFFERENTIATE CEL AND FAH???
				//AND IF(<ordhdr1>< PREVIOUSPRODUCT1><flashp> less than or equal to 60 degrees C or
				//		140 degrees F) then
				//		“Flashpoint”	&  <ordhdr1>< PREVIOUSPRODUCT1><flashp> & “ “& 
				//		<ordhdr1>< PREVIOUSPRODUCT1><tempunit> & “ (Closed Cup)”
				//		“Marine Pollutant:” & <ordhdr1>< PREVIOUSPRODUCT1><marinepollutant>&


				String prodcodeTradname=getTagValue("tradname",elementProdcode);
				if (!prodcodeTradname.equals("")) {
					productText=prodcodeTradname+"\n";
				}

			}

		} catch (Exception e) {
			throw new BuildException(BuildException.GENERAL_FAILURE);
		}

		return productText;
	}



	public String getGrossProductWeight(
			org.w3c.dom.Element eElement		
	) throws BuildException {		 		
		String grossProductWeight="";		

		org.w3c.dom.Element elementOrdprod10= null;

		try {		

			elementOrdprod10=(org.w3c.dom.Element) eElement.getElementsByTagName("ordprod10").item(0);

			int loadweight=0;
			try{loadweight=new Integer(getTagValue("loadweight",elementOrdprod10)).intValue();}catch(Exception e){}
			grossProductWeight=loadweight+" "+getTagValue("lodwghtunit",elementOrdprod10);							

		} catch (Exception e) {
			throw new BuildException(BuildException.GENERAL_FAILURE);
		}

		return grossProductWeight;
	}






	public String countryRule(org.w3c.dom.Element eElement){
		String country=getTagValue("g3ldesc",eElement);
		try {
			if (getTagValue("UNLocation",eElement).substring(0,2).equals("US")) country="USA";
			if (getTagValue("UNLocation",eElement).substring(0,2).equals("CA")) country="Canada";
		} catch (Exception e) {
		}	
		return country;
	}



	public String formatDate(String inDate){
		String outDate="";

		String dateDay="00";
		try{dateDay=inDate.substring(0,2);}catch(Exception e){}//dateDay
		String dateMonth="00";
		try{dateMonth=inDate.substring(3,5);}catch(Exception e){}//dateMonth
		String dateYear="0000";
		try{dateYear=inDate.substring(6,10);}catch(Exception e){}//dateYear

		Calendar c = Calendar.getInstance();
		try {
			c.set(
					Integer.parseInt(dateYear), 
					Integer.parseInt(dateMonth) - 1, 
					Integer.parseInt(dateDay),
					0,
					0
			);
		} catch(Exception e) { }

		outDate=Util.dateTextFormat2(c.getTime());

		return outDate; 	
	}



	public String tareRule(org.w3c.dom.Element eElement){
		String tare=getTagValue("tare",eElement)+" kgs";
		try {
			if (getTagValue("unitkey",eElement).substring(0,3).equals("TBA")) tare="";
		} catch (Exception e) {
		}
		return tare;
	}

	public String unitkeyRule1(org.w3c.dom.Element eElement){
		String unitkey=getTagValue("unitkey",eElement);
		try {
			if (getTagValue("unitkey",eElement).substring(0,3).equals("TBA")) unitkey="TBA";
		} catch (Exception e) {
		}
		return unitkey;
	}

	public String unitkeyRule2(org.w3c.dom.Element eElement){
		String unitkey=getTagValue("unitkey",eElement);
		try {
			if (getTagValue("unitkey",eElement).substring(0,3).equals("TBA")) unitkey=resourceProps.getString("prompt.unallocated");
		} catch (Exception e) {
		}
		return unitkey;
	}

	public String unRule(org.w3c.dom.Element eElement){
		String un=getTagValue("UN",eElement);
		try {
			if (getTagValue("UN",eElement).equals("0")) un=resourceProps.getString("prompt.nonhazardous");
		} catch (Exception e) {
		}
		return un;
	}







	private static String getTagValue(String sTag, org.w3c.dom.Element eElement){
		String returnValue="";
		try {
			org.w3c.dom.NodeList nlList= eElement.getElementsByTagName(sTag).item(0).getChildNodes();
			org.w3c.dom.Node nValue = (org.w3c.dom.Node) nlList.item(0); 
			returnValue=nValue.getNodeValue(); 
		} catch (Exception e) {
		}		
		return returnValue;    
	}


}

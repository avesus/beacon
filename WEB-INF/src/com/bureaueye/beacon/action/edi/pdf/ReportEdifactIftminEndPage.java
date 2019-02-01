package com.bureaueye.beacon.action.edi.pdf;

import java.util.Date;

import com.bureaueye.beacon.util.Util;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;




public class ReportEdifactIftminEndPage extends PdfPageEventHelper {
	
	Font font;
	Font fontBold;	
	Font fontBoldLarge;
	Font fontSmall;
	Font fontSmallBold;	
	
	
	public ReportEdifactIftminEndPage() {
		
		try {
			//init default fonts for document type
			BaseFont baseFont = BaseFont.createFont(com.bureaueye.beacon.bean.Constants.FONT_NAME, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			font=new Font(
					//Font.FontFamily.COURIER,
					baseFont,
					com.bureaueye.beacon.bean.Constants.FONT_SIZE,
					com.bureaueye.beacon.bean.Constants.FONT_STYLE
			);
			fontBold = new Font(font.getFamily(), font.getSize(), Font.BOLD);	
			fontBoldLarge = new Font(font.getFamily(), font.getSize()+2, fontBold.getStyle());
			fontSmall = new Font(font.getFamily(), font.getSize()-3, font.getStyle());			
			fontSmallBold = new Font(fontSmall.getFamily(), fontSmall.getSize(), Font.BOLD);
		} catch (Exception e) {
		}
	}
	
	
	
	    /**
	     * @see com.lowagie.text.pdf.PdfPageEventHelper#onEndPage(com.lowagie.text.pdf.PdfWriter, com.lowagie.text.Document)
	     */
	    public void onEndPage(PdfWriter writer, Document document) {
	        try {
	            Rectangle page = document.getPageSize();
	            PdfPTable head = new PdfPTable(1);
	            head.getDefaultCell().setBorder(0);
	            head.addCell(new Phrase("INSTRUCTION MESSAGE REPORT",fontBold));
	            head.addCell(new Phrase("Run on "+Util.dateTextFormat2(new Date()),fontBold));
	            //head.addCell(new Phrase("Run at "+Util.dateTimeFormat(new Date()),fontBold));
	            head.addCell(new Phrase("",fontBold));
	            head.addCell(new Phrase("",fontBold));
	            //for (int k = 1; k <= 6; ++k)
	                //head.addCell("" + k);
	            head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
	            head.writeSelectedRows(0, -1, document.leftMargin(), page.getHeight() - document.topMargin() + head.getTotalHeight(),
	                writer.getDirectContent());
	            PdfPTable foot = new PdfPTable(1);
	            foot.getDefaultCell().setBorder(0);
	            foot.addCell(new Phrase("",fontBold));
	            foot.addCell(new Phrase("",fontBold));	
	            foot.addCell(new Phrase("Page "+document.getPageNumber(),fontBold));
            
	            //for (int k = 1; k <= 6; ++k)
	                //foot.addCell("" + k);
	            foot.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
	            foot.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(),
	                writer.getDirectContent());
	        }
	        catch (Exception e) {
	            throw new ExceptionConverter(e);
	        }
	    }

	
}

package com.bureaueye.beacon.action.quotation.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;


public class EndPage extends PdfPageEventHelper {
	
	    
	    public void onEndPage(PdfWriter writer, Document document) {
	        try {
	            Rectangle page = document.getPageSize();
	            PdfPTable head = new PdfPTable(3);
	            for (int k = 1; k <= 6; ++k)
	                head.addCell("head " + k);
	            head.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
	            head.writeSelectedRows(0, -1, document.leftMargin(), page.getHeight() - document.topMargin() + head.getTotalHeight(),
	                writer.getDirectContent());
	            PdfPTable foot = new PdfPTable(3);
	            for (int k = 1; k <= 6; ++k)
	                foot.addCell("foot " + k);
	            foot.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
	            foot.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin(),
	                writer.getDirectContent());
	        }
	        catch (Exception e) {
	            throw new ExceptionConverter(e);
	        }
	    }

	
}

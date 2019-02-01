<%@page contentType="text/xml"%>

<%@page pageEncoding="UTF-8"%>

<%@include file="/pages/TreeGrid/Framework/TreeGridFramework.jsp"%>

<%
/*-----------------------------------------------------------------------------------------------------------------
! Support file only, run Grid.html instead !
  This file is used as Data_Url for TreeGrid
  It generates source data for TreeGrid from database
------------------------------------------------------------------------------------------------------------------*/

//------------------------------------------------------------------------------------------------------------------
response.addHeader("Cache-Control","max-age=1, must-revalidate");

// --- Database connection ---
java.sql.Statement Cmd1 = getMysqlStatement(request,out,"localhost:3306/beacon_cpg","",""); 
java.sql.Statement Cmd2 = getMysqlStatement(request,out,"localhost:3306/beacon_cpg","",""); 
java.sql.Statement Cmd3 = getMysqlStatement(request,out,"localhost:3306/beacon_cpg","",""); 


/* DATA FORMAT EXAMPLES
<I Def='Node'  Project='MSC OCEAN LADEN' Validfrom='2011-10-04' Validto='2012-01-12' Fromg4key='Antwerp' Tog4key='Sao Franci' Vendoraddrkey='MSC' Scnumber='Multi'>
<I Project='BAF' id='1' Ccykey='EUR' Amount='200.00'/>
</I>

<I Def='Node'  Project='MSC OCEAN LADEN' Validfrom='2011-10-04' Validto='2012-01-12' Fromg4key='Rotterdam' Tog4key='Sao Franci' Vendoraddrkey='MSC'> Scnumber='Multi'>
<I Project='OFLAD' id='2'Ccykey='EUR'Amount='200.00'/>
<I Project='BAF' id='3'Ccykey='EUR'Amount='50.00'/>
</I>
*/

// --- Generating HEADER data ---
java.sql.ResultSet R = Cmd1.executeQuery(
"SELECT "+
" TARIFFHDR_ID, description, validfrom, validto, vendoraddrkey, fromlocationkey, fromg4key, tolocationkey, tog4key, scnumber, ccykey, indicator, tslocationkey, tsdirectflag, note1, note2, transittime, transportmode, imokey "+
" FROM tariffhdr "+
" ORDER BY description, validfrom, validto, vendoraddrkey, fromlocationkey, tolocationkey"
);
String S = "";
while(R.next()) {

	String hdrId= R.getString("TARIFFHDR_ID");
String id= hdrId;
	String description= R.getString("description");
	String validfrom= R.getString("validfrom");
	String validto= R.getString("validto");
	String vendoraddrkey= R.getString("vendoraddrkey");
	String fromlocationkey= R.getString("fromlocationkey");
	String tolocationkey= R.getString("tolocationkey");
	String scnumber= R.getString("scnumber");
	String ccykey	= R.getString("ccykey");
   	String indicator	= R.getString("indicator");
	String tslocationkey= R.getString("tslocationkey");
	String tsdirectflag= R.getString("tsdirectflag");
	String note1= R.getString("note1");
	String note2= R.getString("note2");
	String transittime= R.getString("transittime");
	String transportmode= R.getString("transportmode");
	String imokey= R.getString("imokey");
	
    // New header row
	S += "<I Def='HDR' " ;
	S += " HtmlPrefix="+ toXML(indicator) + " HtmlPostfix='&lt;/div>' ";	
    S += " Project=" + toXML(description) ;
		
   	S += " id=" + toXML(id) ; 	
	S += " Validfrom=" + toXML(validfrom) ;
	S += " Validto=" + toXML(validto) ;
	S += " Fromlocationkey=" + toXML(fromlocationkey) ;
	S += " Tolocationkey=" + toXML(tolocationkey) ;
	S += " Vendoraddrkey=" + toXML(vendoraddrkey) ;
	S += " Scnumber=" + toXML(scnumber) ; 
	S += " Imokey=" + toXML(imokey) ; 	
	S += " Ccykey=" + toXML(ccykey) ; 
	
	S += " Indicator=" + toXML(indicator) ;
	
	S += " Note1=" + toXML(note1) ;
	S += " Note2=" + toXML(note2) ;
	S += " Tslocationkey=" + toXML(tslocationkey) ;
	S += " Tsdirectflag=" + toXML(tsdirectflag) ;
	S += " Transittime=" + toXML(transittime) ;	
	S += ">";    


	// --- Generating DETAIL data ---
	java.sql.ResultSet R2 = Cmd2.executeQuery(
		"SELECT "+
		" TARIFFDTL_ID, costkey, ccykey, amount, inclflag, percentage "+
		" FROM tariffdtl "+
		" WHERE TARIFFHDR_ID = "+toSQL(hdrId)+" "+
		" ORDER BY costkey"
		);
	while(R2.next()) {

		String dtlId = R2.getString("TARIFFDTL_ID");
		String id2= hdrId+"|"+dtlId;
		String costkey	= R2.getString("costkey");
		String ccykey2	= R2.getString("ccykey");
		String amount	= R2.getString("amount");
		String percentage	= R2.getString("percentage");
		String inclflag	= R2.getString("inclflag");

		//new detail row
		S += "<I Def='DTL' " ; 
		S += " Project=" + toXML(costkey) + " ";
	   	S += " id=" + toXML(id2) ; 
	   	S += " Ccykey=" + toXML(ccykey2) ; 
	   	S += " Amount=" + toXML(amount) ; 
		S += " Percentage=" + toXML(percentage) ; 
	   	S += " Inclflag=" + toXML(inclflag) ;
		S += ">";    
		
	
		// --- Generating DETAIL RATE data ---
		java.sql.ResultSet R3 = Cmd3.executeQuery(
			"SELECT "+
			" TARIFFDTLR_ID, unitrate, fromvalue, tovalue, inclrateflag "+
			" FROM tariffdtlr "+
			" WHERE "+
			"		TARIFFHDR_ID = "+toSQL(hdrId)+" AND "+
			"		TARIFFDTL_ID = "+toSQL(dtlId)+" "+		
			" ORDER BY fromvalue, tovalue"
			);
		while(R3.next()) {

			String dtlrId = R3.getString("TARIFFDTLR_ID");
			String id3= hdrId+"|"+dtlId+"|"+dtlrId;
			String unitrate	= R3.getString("unitrate");
			String fromvalue = R3.getString("fromvalue");
			String tovalue	= R3.getString("tovalue");

			//new detail row
			S += "<I Def='DTLR' " ; 
			S += " Project='' ";
	   		S += " id=" + toXML(id3) ; 
	   		S += " Unitrate=" + toXML(unitrate) ; 
	   		S += " Fromvalue=" + toXML(fromvalue) ; 
	   		S += " Tovalue=" + toXML(tovalue) ;
			S += "/>";    // Ends previous project and resource rows# 
	
	
		}	

		S += "</I>";    // Ends previous project and resource rows
	
	}


	S += "</I>";    // Ends previous project and resource rows
	
}




Cmd1.close(); 
Cmd2.close();
Cmd3.close();


// --------------------------------------------------------------------------
%>


<?xml version="1.0" ?>
<Grid>
   <Body>
      <B>
         <%=S%>
      </B>
   </Body>
</Grid>
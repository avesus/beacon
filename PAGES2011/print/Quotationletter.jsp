<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 
 * NT	2009-10-26		ITT-200910-0002		Quotation Letter
 *
 * NT	2009-12-02		200900054			Remove Email option (MC request)
 *   												
 * NT	2010-01-15		201000002			Problem printing € character in pdf format. Output Currency names instead.
 *
 * NT	2010-02-15		ITT-201001-0001		Add Demurrage Currency
 *
 --%>
 
 
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
  
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->

  
<app:checkLogon/>


<html:html>
<head>
<title>Quotation Letter</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/print.css" />


<script language="JavaScript">
var searchWin;

function refreshData(){
	var url     = 'EditQuotationletter.do?'+
						'companyheaderId='+
						document.forms[0].companyheaderId.value+ 
						'&quohdrId='+
						document.forms[0].quohdrId.value+
						'&printId='+
						document.forms[0].quohdrId.value+'Quotationletter'+
						'&refreshdata=Y'+
						'&action=Print'
						;
	window.location.href = url;
}



function addresscontactSearch(field){
	var url     = 'ListAddresscontactSearch.do?'+
					'maxResults=999'+
					'&headerInfo1='+
					'&headerInfo2='+				
					'&headerInfo3='+
					field
					;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}


</script>

 
</head> 

 
<body onUnload="if (searchWin != null) {searchWin.close()}">  


<table cellpadding="0" cellspacing="0" border="0" width="100%">

  	<tr>
   		<td bgcolor="#f6f6f6"><html:img src="images/spacer.gif" border="0" width="2" height="15"/>	   
		<html:link href="javascript:void(refreshData())">
		<html:img src="images/buttons/btn_refresh.png" alt="Refresh Data" border="0" align="middle"/>
		</html:link>   
   <span class="heading9">Quotation Letter</span>&nbsp;		   
   		</td>  
  	</tr>	
	<tr valign="top" bgcolor="#f6f6f6">
		<td height="2" colspan="2"></td>
  	</tr>
  	<tr valign="top" bgcolor="#D0D0D0">
		<td height="1" colspan="2"></td>
  	</tr>
	<tr valign="top" bgcolor="#ffffff">
		<td height="5" colspan="2"></td>
  	</tr>
	
		  	  
<tr>	
	<td>
	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/SaveQuotationletter">
<html:hidden property="printhdrId"/>
<html:hidden property="printId"/>
<html:hidden property="companyheaderId"/>
<html:hidden property="quohdrId"/>
<html:hidden property="action"/> 

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">


<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
		<tr>
		  <td class="td7">
<html:select property="language" styleClass="ftforminputsmall">
			<html:option value="ENGLISH">ENGLISH</html:option>	
			<html:option value="SPANISH">SPANISH</html:option>	            	
</html:select>          
		<html:submit styleClass="button1" property="btnSubmit" value="Print" onclick="if (searchWin != null) {searchWin.close();}">
		  Print
		</html:submit>
		<html:submit styleClass="button1" property="btnSubmit" value="Email" onclick="if (searchWin != null) {searchWin.close();}">
		  Email
		</html:submit><!--200900054-->
		<html:cancel styleClass="button1" onclick="if (searchWin != null) {searchWin.close();}">
		  Cancel
		</html:cancel>					
	</td>
  </tr>		  
	</table>	
	</td>
</tr>	
	
  
   
  <tr>
	    <td width="100%" valign="top">
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="1" border="0" width="100%">
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td width="12%" class="body3black">Date:</td>
	<td width="52%" class="body2"><span class="body3">
	
              <html:select property="reportDatedd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="reportDatemm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="reportDateyyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
              	
	</span>	
	</td>
	<td width="30%" class="body3black">&nbsp;</td>
	<td width="5%" class="body2">&nbsp;</td>
  </tr>

  <tr class="row0">
	<td width="1%" class="body3" valign="top">
	</td>
	<td class="body3black" valign="top">	
	To:</td>
	<td><span class="body3black"><span class="ftformtext3">
	
<bean:write name="PrinthdrForm" property="customer" scope="session"/>
	  
	</span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>

  <tr class="row0">
	<td width="1%" class="body3" valign="top">
		<html:link href="javascript:void(addresscontactSearch('memo8'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>	
	</td>
	<td class="body3black" valign="top">	
	Attention:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:textarea property="memo8" rows="2" cols="110" styleClass="ftforminputsmall"/>
	  
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>

  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">Total Pages:</td>
	<td><span class="body3black"><span class="ftformtext3"><b><b>
	
<html:text property="memo10" size="10"  maxlength="5" styleClass="ftforminputsmall"/>
	  
	</b>
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">From:</td>
	<td><span class="body3black"><span class="ftformtext3"><b><b>
	
<html:text property="fromcontact" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	  
	</b>
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">Subject:</td>
	<td><span class="body2">
	
Quotation# <bean:write name="PrinthdrForm" property="memo4" scope="session"/>
	</span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  
  <tr class="row1">
	<td height="10"></td>
  </tr>
  
</table>
	</td>
  </tr>

  	<tr valign="top" bgcolor="#ffffff">
		<td height="1"></td>
  	</tr>
	
  <tr>
	    <td width="100%" valign="top">
<table cellpadding="0" cellspacing="0" border="0" width="100%">


   	<tr valign="top" bgcolor="#000000"><td height="1"></td></tr>
	

</table>
	</td>
  </tr>		
  
	<tr valign="top" bgcolor="#ffffff">
		<td height="5"></td>
  	</tr>
  	<tr valign="top" bgcolor="#ffffff">
		<td height="1"></td>
  	</tr>
	<tr valign="top" bgcolor="#ffffff">
		<td height="5"></td>
  	</tr>	


	<tr>
	    <td width="100%" valign="top"> 
        
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">

  <tr class="row0">
	<td height="5" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td>
  </tr>
  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" colspan="2">
We refer to your recent enquiry and take pleasure in confirming our rate as follows:    
    </td>
  </tr>
 
  <tr class="row0">
	<td height="5" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td>
  </tr>
  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" colspan="2">
<table class="body2" cellpadding="0" cellspacing="0" border="0" width="30%">
<tr>
<td>
<table class="body2" cellpadding="0" style="border: 1px #333 solid" cellspacing="1" border="0" width="100%">
<tr><td>
From Door:<br/>
<bean:write name="PrinthdrForm" property="pickupPlant" scope="session"/>&nbsp;
</td></tr>
</table>
</td>
<td>
<table class="body2" cellpadding="0" style="border: 1px #333 solid" cellspacing="1" border="0" width="100%">
<tr><td>
To Door:<br/>
<bean:write name="PrinthdrForm" property="finalDelivery" scope="session"/>&nbsp;
</td></tr>
</table>
</td>
<td>
<table class="body2" cellpadding="0" style="border: 1px #333 solid" cellspacing="1" border="0" width="100%">
<tr><td>
Rate:<br/>
<bean:write name="PrinthdrForm" property="rate" scope="session"/>&nbsp;<bean:write name="PrinthdrForm" property="rateccy" scope="session"/><!--201000002-->
<%--<fmt:formatNumber 
							type="number"
							value="${PrinthdrForm.rate}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>--%>&nbsp;
</td></tr>
</table>
</td>
</tr>
<tr>
<td>
<table class="body2" cellpadding="0" style="border: 1px #333 solid" cellspacing="1" border="0" width="100%">
<tr><td>
Origin Port:<br/>
<bean:write name="PrinthdrForm" property="pol" scope="session"/>&nbsp;
</td></tr>
</table>
</td>
<td>
<table class="body2" cellpadding="0" style="border: 1px #333 solid" cellspacing="1" border="0" width="100%">
<tr><td>
Destination Port:<br/>
<bean:write name="PrinthdrForm" property="pod" scope="session"/>&nbsp;
</td></tr>
</table>
</td>
<td>
<table class="body2" cellpadding="0" style="border: 1px #fff solid; border-top: 1px #333 solid;" cellspacing="1" border="0" width="100%">
<tr><td>&nbsp;<br/>&nbsp;
</td></tr>
</table>
</td>
</tr>
</table>    
    </td>
  </tr>
  
  <tr class="row0"><td height="3" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td></tr>
  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td width="10%" class="body3"><span class="body3black">
Product:   
    </span></td>
	<td width="90%" class="body2">
<bean:write name="PrinthdrForm" property="memo1" scope="session"/>  
    </td>    
  </tr>
  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body3"><span class="body3black">
Equipment:     
    </span></td>
	<td class="body2">
<html:text property="memo2" size="100"  maxlength="100" styleClass="ftforminputsmall"/>    
    </td>      
  </tr>     

  <tr class="row0"><td height="3" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td></tr> 

  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" colspan="2">
Demurrage will be billed at <bean:write name="PrinthdrForm" property="memo5" scope="session"/>&nbsp;<bean:write name="PrinthdrForm" property="dmrgccykey" scope="session"/><!--ITT-201001-0001--><!--201000002--> per tank per day after <bean:write name="PrinthdrForm" property="memo3" scope="session"/> days from vessel <br/>arrival at pier.  Demurrage will be for your account, or to another party nominated by yourselves<br/>prior to commencement of business.   
    </td>
  </tr>	

  <tr class="row0"><td height="3" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td></tr> 	

  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" colspan="2">
Rate excludes:<br/>	
·	Heating of product during transit or prior to delivery<br/>
·	Customs clearance at origin & destination, and product duties in country of destination<br/>
·	Extra cleaning and any disposal costs for residue over 5 gallons remaining in tank container after discharge<br/>
·	Pier storages or rail terminal charges in the event of postponed delivery<br/>
·	Marine Insurance<br/>
·	War risk/Port Congestion /Peak Season fees<br/>
·	Any labels/preps or specialty equipment unless specifically requested<br/>
·	Handrail fitted on Tank<br/>
<br/>
Rate includes:<br/>
·	Current BAF/CAF/THC at origin<br/>
·	Inland haulage from loading point to pier (if Door to Door or Door to Pier move)<br/>
·	Inland haulage from pier to discharging point (if Door to Door or Pier to Door )<br/>
<br/>	
Rate subject to the following unless otherwise specified in notes section:<br/>
·	Accessorial Charges (FMC Tariff rate will apply for shipments to and from the U.S.)<br/>
·	Prior day pick up, next day delivery charge, and trucking detention if applicable <br/> 
·	Special preparation of tanks if required by loading plant<br/>
·	Overweight charge if applicable<br/>
·	DTHC and any other port charge at destination<br/>
    </td>
  </tr>	

  <tr class="row0"><td height="3" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td></tr> 	

  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" valign="top">Notes:</td>
	<td class="body2">
    </td>      
  </tr>  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body3" valign="top" colspan="2"><span class="body2">
<html:textarea property="memo7" rows="4" cols="110" styleClass="ftforminputsmall"/>      
    </span></td>     
  </tr>  
  
  <tr class="row0"><td height="3" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td></tr> 
  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" colspan="2">
Terms:	  <bean:write name="PrinthdrForm" property="shipMethod" scope="session"/><br/>
·	Any damages to equipment under shipper’s, consignee’s, or any of their subcontractors custody will be for your account.<br/>
·	Payment of any extra charges incurred in the destination country will be guaranteed by the shipper of record.<br/>
    </td>      
  </tr> 

  <tr class="row0"><td height="3" colspan="3" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td></tr> 
  
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td class="body2" colspan="2">
The quote is subject to tank availability at time of order placement.<br/>
Validity: Our quotation is based on current costs and rates of exchange. Rate is valid from <bean:write name="PrinthdrForm" property="memo6" scope="session"/> to <bean:write name="PrinthdrForm" property="memo9" scope="session"/>.<br/> 
<br/>
Rate (s) is (are) subject to change with 30 days prior notice to customer.<br/>
All invoices are due settlement in full, 30 days from date of invoice.<br/>
All business is undertaken subject to the Intermodal Tank Transport/Medtank International Bill of Lading conditions<br/>
<br/>
Commercial Invoices: Intermodal Tank Transport/Medtank is not party to and does not accept any liability due to disputes between Shipper & Consignee <br/>
based on Commercial Invoice terms<br/>
<br/>
<br/>
Kindest regards,<br/>
<br/>
<br/>
<br/>
<span class="body3black"><bean:write name="PrinthdrForm" property="companyheader.companyName" scope="session"/></span>
    </td>      
  </tr>


  					 
</table>

</td></tr></table>
</td></tr></table>


</td>
</tr>
</table>


</html:form>

</td>
</tr>

	

</table>

</body>
</html:html>

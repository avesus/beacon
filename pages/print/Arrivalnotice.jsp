<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
<title>Arrival Notice</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/print.css" />


<script language="JavaScript">
var searchWin;

function refreshData(){
	var url     = '/beacon/EditArrivalnotice.do?'+
						'companyheaderId='+
						document.forms[0].companyheaderId.value+ 
						'&orderhdrId='+
						document.forms[0].orderhdrId.value+
						'&printId=Order'+
						document.forms[0].orderhdrId.value+'BN'+
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
   <span class="heading9">
   Arrival Notice </span>&nbsp;		   
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

<html:form action="/SaveArrivalnotice">
<html:hidden property="printhdrId"/>
<html:hidden property="printId"/>
<html:hidden property="companyheaderId"/>
<html:hidden property="orderhdrId"/>
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
		<html:submit styleClass="button1" property="btnSubmit" value="Print" onclick="if (searchWin != null) {searchWin.close();}">
		  Print
		</html:submit>
		<html:submit styleClass="button1" property="btnSubmit" value="Email" onclick="if (searchWin != null) {searchWin.close();}">
		  Email
		</html:submit>
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
	
<bean:write name="PrinthdrForm" property="reportDate" format="dd-MMM-yyyy" scope="session"/>
	
	</span>	
	</td>
	<td width="30%" class="body3black">&nbsp;</td>
	<td width="5%" class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td width="1%" class="body3" valign="top">
		<html:link href="javascript:void(addresscontactSearch('memo8'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>	
	</td>
	<td class="body3black" valign="top">	
	To:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:textarea property="memo8" rows="2" cols="110" styleClass="ftforminputsmall"/>
	  
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3" valign="top">
		<html:link href="javascript:void(addresscontactSearch('memo9'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>	
	</td>
	<td class="body3black" valign="top">Cc:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:textarea property="memo9" rows="2" cols="110" styleClass="ftforminputsmall"/>	
  
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">From:</td>
	<td><span class="body3black"><span class="ftformtext3"><b><b>
	
<html:text property="memo7" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	  
	</b>
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">Subject:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:text property="memo3" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	
	</b></span></span></td>
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
		<td colspan="5">&nbsp;</td>
  	</tr>	


	<tr>
	    <td width="100%" valign="top"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="row0">
	<td height="5" colspan="5" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td>
  </tr>
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td width="21%" class="body3"><span class="body3black">Our Reference:</span></td>
	<td width="22%" class="body2">
	
<bean:write name="PrinthdrForm" property="jobNumber" scope="session"/>

	</td>
	<td width="12%" class="body3">&nbsp;</td>
	<td width="44%" class="body2">
	</td>
  </tr>
 
</table>		
		</td>
  	</tr>
	


	<tr>
	    <td width="100%" valign="top"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td width="21%" class="body3black">&nbsp;</td>
	<td width="62%" class="body3black">&nbsp;</td>
	<td width="12%" class="body3black">&nbsp;</td>
	<td width="4%" class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Vessel:</span></td>
	<td class="body2">	
<bean:write name="PrinthdrForm" property="vessel" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Shipping Line:</span></td>
	<td class="body2">	
<bean:write name="PrinthdrForm" property="shipLine" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2"></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Booking#:</span></td>
	<td class="body2">	
<bean:write name="PrinthdrForm" property="bookingNumber" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">	
</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Port of Loading:</span></td>
	<td class="body2">	
<bean:write name="PrinthdrForm" property="pol" scope="session"/>	  </td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Estimate Loading Date:</span></td>
	<td class="body2">
<!-- pOLdateEst -->
<bean:write name="PrinthdrForm" property="poldateest" format="dd-MMM-yyyy" scope="session"/>	</td>
	<td class="body2">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Port of Discharge:</span></td>
	<td class="body2">	
<bean:write name="PrinthdrForm" property="pod" scope="session"/>	  </td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>   
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Estimate Discharge Date:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="poddateest" format="dd-MMM-yyyy" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Final Delivery to: </span></td>
	<td class="body2">	
<bean:write name="PrinthdrForm" property="finalDelivery" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Estimate Delivery Date:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="finalDeliveryDateEst" format="dd-MMM-yyyy" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Return Depot:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="memo10" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>     
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Weight:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="weightPerTankAprox" scope="session"/>&nbsp;<bean:write name="PrinthdrForm" property="weightType" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Demurrage Free Days:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="memo4" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Demurrage Days and Rates (<bean:write name="PrinthdrForm" property="memo1" scope="session"/>):</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="memo5" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>      
  
  
  	<tr valign="top" bgcolor="#ffffff">
		<td colspan="5">&nbsp;</td>
  	</tr>
	
	
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Shipper:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="shipper" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Consignee:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="consignee" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">Address:</span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="consigneeAddress1" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3"></span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="consigneeAddress2" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3"></span></td>
	<td class="body2">
<bean:write name="PrinthdrForm" property="consigneeAddress3" scope="session"/>	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>      
    	
  	<tr valign="top" bgcolor="#ffffff">
		<td colspan="5">&nbsp;</td>
  	</tr>
		
  <tr>
	<td class="body3">&nbsp;</td>  
	    <td width="100%" valign="top" colspan="4">
<table cellpadding="0" cellspacing="0" border="0" width="100%">

  	<tr valign="top" bgcolor="#000000"><td height="1"></td></tr>
	
<tr><td>

<table width="100%" border="0" cellpadding="2" cellspacing="0" bgcolor="white">
  <tr>
	<td width="10%"><span class="heading7">Tank Number</span> </td>
	<td width="20%"><span class="heading7">Contents</span></td>	
	<td width="10%"><span class="heading7">Actual Weight</span> </td>
	<td width="60%"><span class="heading7">Additional Instructions</span> </td>	
  </tr>
</table>

</td></tr>

  	<tr valign="top" bgcolor="#000000"><td height="1"></td></tr>

	
<%
int row=0;
%>
			<c:forEach var="printdtlLineItem" items="${PrinthdrForm.printdtls}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>	
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>	
<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0">				 
  <tr>
	<td width="10%" nowrap class="<%= _class %>" valign="top">
	<c:out value="${printdtlLineItem.tankNumber}"/></td>
	<td width="20%" nowrap class="<%= _class %>" valign="top">
	<c:out value="${printdtlLineItem.productId}"/>	</td>	
	<td width="10%" nowrap class="<%= _class %>" valign="top">
	<c:out value="${printdtlLineItem.actualWeight}"/>&nbsp;<c:out value="${printdtlLineItem.weightType}"/>
	</td>
	<td width="60%" class="<%= _class %>" valign="top">
	<c:out value="${printdtlLineItem.memoA}"/><br/>
	<c:out value="${printdtlLineItem.memoB}"/></td>	
  </tr>
</table></td></tr>

 	<tr valign="top" bgcolor="#ffffff"><td height="1"></td></tr>
  
			</c:forEach>
</table>
	</td>
  </tr>		
  
  
  	<tr valign="top" bgcolor="#ffffff">
		<td colspan="5">&nbsp;</td>
  	</tr>
	
	
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><span class="body3">PLEASE NOTE:</span></td>
	<td class="body2">	</td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body2" colspan="2">
<bean:write name="PrinthdrForm" property="memo2" scope="session"/>
	</td>
	<td class="body2">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>

</table>					
		</td>
  	</tr>
	
	
					 
</table>

</td></tr></table>
</td></tr></table>
</html:form>

</td>
</tr>
</table>


</td>
</tr>

	

</table>

</body>
</html:html>

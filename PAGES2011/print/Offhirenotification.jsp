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
<title>Off Hire Notification</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/print.css" />


<script language="JavaScript">
var searchWin;

function refreshData(){
	var url     = '/beacon/EditOffhirenotification.do?'+
						'companyheaderId='+
						document.forms[0].companyheaderId.value+ 
						'&orderhdrId='+
						document.forms[0].offhireId.value+
						'&printId='+
						document.forms[0].offhireId.value+'Offhirenotification'+
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
   Off Hire Notification </span>&nbsp;		   
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

<html:form action="/SaveOffhirenotification">
<html:hidden property="printhdrId"/>
<html:hidden property="printId"/>
<html:hidden property="companyheaderId"/>
<html:hidden property="offhireId"/>
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
	
<html:text property="memo5" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	  
	</b>
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black">Subject:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:text property="memo4" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	
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
		<td>
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="3" cellspacing="3" border="0" width="100%">
<tr><td width="93%">
<table width="100%"  border="0" cellpadding="3" cellspacing="3">
        <tr>
          <td colspan="2" class="body2">Please accept the following Unit(s) for off-hire on reference <bean:write name="PrinthdrForm" property="customerRef" scope="session"/>. </td>
          </tr>
        <tr>
          <td class="body3black">&nbsp;</td>
          <td class="body2">&nbsp;</td>
        </tr>
        <tr>
          <td width="13%" class="body3black">Depot:</td>
          <td width="87%" class="body2"></td>
        </tr>
        <tr>
          <td colspan="2" class="body2"><bean:write name="PrinthdrForm" property="shipper" scope="session"/>           &nbsp;</td>
          </tr>		
        <tr>
          <td colspan="2" class="body2"><bean:write name="PrinthdrForm" property="shipperAddress1" scope="session"/>           &nbsp;</td>
          </tr>
        <tr>
          <td colspan="2" class="body2"><bean:write name="PrinthdrForm" property="shipperAddress2" scope="session"/>            &nbsp;</td>
          </tr>
        <tr>
          <td colspan="2" class="body2"><bean:write name="PrinthdrForm" property="shipperAddress3" scope="session"/></td>
        </tr>
        <tr>
          <td colspan="2" class="body2"><bean:write name="PrinthdrForm" property="shipperFax" scope="session"/>            &nbsp;</td>
          </tr>
    </table>
</td>
<td width="7%">&nbsp;</td>
</tr>
</table>		
		</td>
  	</tr>
  	<tr valign="top" bgcolor="#ffffff">
		<td height="1"></td>
  	</tr>
	<tr valign="top" bgcolor="#ffffff">
		<td height="5"></td>
  	</tr>
	
  <tr>
	    <td width="100%" valign="top">
<table cellpadding="0" cellspacing="0" border="0" width="100%">

  	<tr valign="top" bgcolor="#000000"><td height="1"></td></tr>
	
<tr><td>

<table width="100%" border="0" cellpadding="2" cellspacing="0" bgcolor="white">
  <tr>
	<td width="10%"><span class="heading7">Tank Number</span> </td>
	<td width="40%"><span class="heading7">Equipment Type </span></td>
	<td width="30%"><span class="heading7">Last Contents</span></td>
	<td width="20%"><span class="heading7">Delivery Date</span> </td>	
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
	<td width="10%" nowrap class="<%= _class %>">
	<c:out value="${printdtlLineItem.tankNumber}"/></td>
	<td width="40%" nowrap class="<%= _class %>">
	<c:out value="${printdtlLineItem.memoB}"/>
	</td>	
	<td width="30%" class="<%= _class %>">
	<c:out value="${printdtlLineItem.productId}"/></td>
	<td width="20%" nowrap class="<%= _class %>">
<bean:write name="printdtlLineItem" property="puPlantApptDate" format="dd-MMM-yyyy" filter="true"/>		
	</td>	
  </tr>
</table></td></tr>

 	<tr valign="top" bgcolor="#ffffff"><td height="1"></td></tr>
  
			</c:forEach>
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
	<td height="5" colspan="5" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td>
  </tr>
  <tr class="row0">
	<td class="body3black">&nbsp;</td>
	<td width="21%" class="body3">&nbsp;</td>
	<td width="22%" class="body2">&nbsp;</td>
	<td width="12%" class="body3">&nbsp;</td>
	<td width="44%" class="body2">&nbsp;</td>
  </tr>
 
</table>		
		</td>
  	</tr>
	


	<tr>
	    <td width="100%" valign="top"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="row0">
	<td class="body3"><span class="body3black">Special Instructions:</span></td>
	</tr>
  <tr class="row0">
	<td class="body3"><bean:write name="PrinthdrForm" property="memo11" scope="session"/></td>
	</tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>   
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr> 
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>   
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	</tr>  
  <tr class="row0">
	<td class="body3">&nbsp;</td>
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

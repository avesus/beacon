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
<title>Disbursement Summary</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/print.css" />


<script language="JavaScript">
var searchWin;

function refreshData(){
	var url     = '/beacon/EditDisbursementsummary.do?'+
						'companyheaderId='+
						document.forms[0].companyheaderId.value+ 
						'&orderhdrId='+
						document.forms[0].orderhdrId.value+
						'&printId=Order'+
						document.forms[0].orderhdrId.value+'DS'+
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

 
<style type="text/css">
<!-- 
.body2 { font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 15px; color: #000000 }
.body3 { font-family: Arial, Helvetica, sans-serif; font-size: 13px; line-height: 12px; font-weight: bold}
.body4 { font-family: Arial, Helvetica, sans-serif; font-size: 16px; line-height: 12px; font-weight: bold}
-->
</style>


</head> 

 
<body onUnload="if (searchWin != null) {searchWin.close()}">  


<table cellpadding="0" cellspacing="0" border="0" width="100%">

  	<tr>
   		<td bgcolor="#f6f6f6"><html:img src="images/spacer.gif" border="0" width="2" height="15"/>	   
		<html:link href="javascript:void(refreshData())">
		<html:img src="images/buttons/btn_refresh.png" alt="Refresh Data" border="0" align="middle"/>
		</html:link>   
   <span class="heading9">
   Disbursement Summary </span>&nbsp;		   
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

<html:form action="/SaveDisbursementsummary">
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



<!-- buttons -->
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
	    <td width="100%" valign="top" align="center"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="70%">
  <tr class="row0">
	<td height="5" colspan="5" class="body3"><img src="/images/spacer.gif" width="1" height="1"></td>
  </tr>
  
   
  <tr class="row0">
	<td width="5%">&nbsp;</td>
	<td width="50%" colspan="2" valign="top" class="body3">Owners and/or Charterers</td>
	<td width="10%" class="body3" valign="top">Order:</td>
	<td width="25%" class="body2" valign="top"><bean:write name="PrinthdrForm" property="jobNumber" scope="session"/></td>
  </tr>
  <tr class="row0">
	<td>&nbsp;</td>
	<td width="10%" valign="top" class="body3">Owners:</td>
	<td width="40%" valign="top" class="body2">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td class="body2"><bean:write name="PrinthdrForm" property="consignee" scope="session"/></td>
        </tr>
        <tr>
          <td class="body2"><bean:write name="PrinthdrForm" property="consigneeAddress1" scope="session"/></td>
        </tr>
        <tr>
          <td class="body2"><bean:write name="PrinthdrForm" property="consigneeAddress2" scope="session"/></td>
        </tr>
        <tr>
          <td class="body2"><bean:write name="PrinthdrForm" property="consigneeAddress3" scope="session"/></td>
        </tr>
      </table>    
    </td>
	<td class="body3" valign="top">Date:</td>
	<td class="body2" valign="top"><bean:write name="PrinthdrForm" property="reportDate" format="dd-MMM-yyyy" scope="session"/></td>
  </tr>
    
</table>		
		</td>
  	</tr>



<tr>
<td width="100%" valign="top"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="row0">
	<td height="5"><img src="/images/spacer.gif" width="1" height="5"></td>
  </tr>
  <tr class="row0">
	<td valign="top" class="body3" align="center">
	  <table width="30%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	      <td class="body2"><bean:write name="PrinthdrForm" property="vessel" scope="session"/></td>
	      <td class="body2"><bean:write name="PrinthdrForm" property="voyage" scope="session"/></td>
	      </tr>
	    <tr>
	      <td class="body2" colspan="2"><bean:write name="PrinthdrForm" property="pol" scope="session"/></td>
	      </tr>
	    <tr>
	      <td class="body2">From:</td>
	      <td class="body2"><bean:write name="PrinthdrForm" property="poldateest" format="dd-MMM-yyyy" scope="session"/></td>
	      </tr>
	    <tr>
	      <td class="body2">To:</td>
	      <td class="body2"><bean:write name="PrinthdrForm" property="poddateest" format="dd-MMM-yyyy" scope="session"/></td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>		
</td>
</tr>
    
    	
        
        
<tr>
<td width="100%" valign="top"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="row0">
	<td><img src="/images/spacer.gif" width="1" height="20"></td>
  </tr>
  <tr class="row0">
		<td class="body4" align="center">DISBURSEMENT SUMMARY</td>
  </tr>
</table>		
</td>
</tr>

<tr><td><img src="/images/spacer.gif" width="1" height="10"></td></tr>
  
<tr valign="top" bgcolor="#cccccc"><td><img src="/images/spacer.gif" width="1" height="1"></td></tr> 
 
<tr>
<td width="100%" valign="top" align="center"> 
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="70%">

  
      
<%
int row=0;
%>
			<c:forEach var="printdtlLineItem" items="${PrinthdrForm.printdtls}" varStatus="loop">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>				 
  <tr>
	<td width="30%" nowrap class="<%= _class %>" valign="top"><c:out value="${printdtlLineItem.memoA}"/></td>
	<td width="60%" nowrap class="<%= _class %>" valign="top"><c:out value="${printdtlLineItem.addInstructions}"/></td>	
	<td width="10%" nowrap class="<%= _class %>" valign="top" align="right"><c:out value="${printdtlLineItem.memoB}"/></td>
  </tr>
  
			</c:forEach>
            
  
  
  
</table>		
</td>
</tr>

 
<tr><td><img src="/images/spacer.gif" width="1" height="10"></td></tr>        
					 
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

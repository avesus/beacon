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
<title><bean:message key="pidtl.title.list"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />


</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<!-- HEADER ----------------->
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<!-- BREADCRUMBS -----------------> 
<tr>  
	<td class="tdwht">
	  <span class="heading2"><html:link action="/ListPihdr"><bean:message key="pihdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListPidtl"><bean:message key="pidtl.title.list"/></html:link></span>
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS -----------------> 


<tr>
<!-- SIDEBAR ----------------->

	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListPidtl">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="50%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="30%" class="td4"><span class="heading6"><bean:message key="prompt.pino"/></span></td>
    <td width="25%" class="td4"><span class="heading6"><bean:message key="prompt.netamt"/></span></td>
    <td width="25%" class="td4"><span class="heading6"><bean:message key="prompt.inputtotal"/></span></td>	
    <td width="20%" class="td4"><span class="heading6"><bean:message key="prompt.invoicedate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo6" scope="session"/>
	</td>	
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo7" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="45%" class="td4"><span class="heading6"><bean:message key="prompt.vendor"/></span></td>
	<td width="45%" class="td4"><span class="heading6"><bean:message key="prompt.vendorref"/></span></td>
    <td width="10%" class="td4"><span class="heading6"><bean:message key="prompt.ccy"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlForm" property="headerInfo4" scope="session"/>
	</td>						
   </tr>
</table>
</td>
</tr>
   
</table>
</td>
</tr>
</table>
<!-- end header information -->


<table>
<tr>
<td></td>
</tr>
</table>


<table border="0" cellpadding="0" cellspacing="0" width="80%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">	
	</td>	
  </tr>
</table>
	</td>

<td width="15%">	
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
                                    <img src="images/spacer.gif" width="1" height="13" border="0"/>  
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="90%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderResultsBgcolor">
				<tr>		
		  			<td class="purchaseorderResultsHeader" width="10%">
					<bean:message key="heading.jobno"/></td>
		  			<td class="purchaseorderResultsHeader" width="10%" align="right">
					<bean:message key="heading.invoiceamt"/></td>
		  			<td class="purchaseorderResultsHeader" width="10%">
					<bean:message key="heading.status"/></td>															
		  			<td class="purchaseorderResultsHeader" width="25%">
					<bean:message key="heading.text"/></td>																			
		  			<td class="purchaseorderResultsHeader" width="20%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">									
                            <html:link action="/EditPidtl?action=Create" paramId="pihdrId" paramName="ListPidtlForm" paramProperty="id">
                        <html:img src="images/buttons/btn_add_12_12.png" alt="Add" border="0" align="middle"/>
                        </html:link>
                        <html:link action="/EditPidtl?action=Create" paramId="pihdrId" paramName="ListPidtlForm" paramProperty="id">
                            <span style="vertical-align:middle"><bean:message key="prompt.pidtl.add"/></span>
                        </html:link>
						</td>
					</tr>
					</table>					
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListPidtlForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.jobno}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.invoiceamt}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.invoicestatus}"/>						
					</td>  
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.txt1}"/>											
					</td>										  																									
					<td class='<c:out value="${_class}"/>' align="right">

																							


						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="40%" class='<c:out value="${_class}"/>' align="left">
<html:link action="/ListPidtlcost.do" paramId="id" paramName="lineItem" paramProperty="pidtlId"><bean:message key="prompt.allocatecosts"/></html:link>
                          </td>
                          <td width="60%" class='<c:out value="${_class}"/>' align="right">
<html:link action="/EditPidtl.do?action=Edit" paramId="pidtlId" paramName="lineItem" paramProperty="pidtlId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditPidtl.do?action=Delete" paramId="pidtlId" paramName="lineItem" paramProperty="pidtlId">
<bean:message key="prompt.delete"/> 
</html:link>    
                          </td>
                        </tr>
                      	</table>						
					</td>								 										 													 										 			
				</tr>

                  <!-- row2 -->

				  				
				<tr><td colspan="6" background="images/border_dotted.gif"></td></tr>
							
			</c:forEach>			
			</table>
		</td>
	</tr>
</table>


</td>
</tr>
</table>

</html:form>

</td>
</tr>
</table>

</div>
</td>
</tr>


<!-- FOOTER ----------------->
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

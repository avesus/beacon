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
<title><bean:message key="sidtl.title.list"/></title>
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
	  <span class="heading2"><html:link action="/ListSihdr"><bean:message key="sihdr.title.list"/></html:link></span>
      	<span class="text6">&gt;</span>
      	  <span class="heading2"><html:link action="/ListSidtl"><bean:message key="sidtl.title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListSidtl">
<html:hidden property="gotoPage" />
<html:hidden property="headerInfo5" />  <!--manualflag-->
<html:hidden property="headerInfo7" />	<!--printedflag-->


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" class="td4"><span class="heading6">Document Id</span></td>
    <td width="15%" class="td4"><span class="heading6">Create Date</span></td>
    <td width="40%" class="td4"><span class="heading6">Customer</span></td>
    <td width="15%" class="td4"><span class="heading6">Customer ref</span></td>
    <td width="15%" class="td4"><span class="heading6">Order No</span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo10" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo1" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="25%" class="td4"><span class="heading6">Print Date</span></td>
	<td width="25%" class="td4"><span class="heading6">Invoice No</span></td>
    <td width="25%" class="td4"><span class="heading6">Invoice Currency</span></td>
    <td width="20%" class="td4"><span class="heading6">Invoice Total</span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td6">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo9" scope="session"/>
	</td>
    <td class="td6">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td6">
	&nbsp;<bean:write name="ListSidtlForm" property="headerInfo11" scope="session"/>
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


<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
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


<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>		
		  			<td class="tddkgry" width="10%">
					<span class="heading4">
						Charge		  			</span>					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">
						Type		  			</span>					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">
						Invoice Ccy		  			</span>					</td>																				
		  			<td class="tddkgry" width="10%"><span class="heading4">
						No of Units
						</span>					</td>					
		  			<td width="10%" class="tddkgry"><span class="heading4"> Unit Rate </span> </td>
		  			<td width="10%" class="tddkgry"><span class="heading4"> Invoice Amount</span> </td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						Unit Name
						</span>					</td>												
		  			<td class="tddkgry" width="15%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">
<!-- not printed and is manual -->					
<logic:equal name="ListSidtlForm" property="headerInfo5"
			scope="session" value="true">
	<logic:equal name="ListSidtlForm" property="headerInfo7"
				scope="session" value="false">										
	<app:linkSidtlCreate page="/EditSidtl.do?action=Create">
	Add an Invoice Detail</app:linkSidtlCreate>
	</logic:equal>						
</logic:equal>	</td>
					</tr>
					</table>					</td>
				</tr>

			<c:forEach var="sidtlLineItem" items="${ListSidtlForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${sidtlLineItem.chargekey.chargekey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${sidtlLineItem.chargetype}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${sidtlLineItem.invoiceccykey}"/>						
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${sidtlLineItem.units}"/>						
						</td>					
					<td width="10%" align="right" class='<c:out value="${_class}"/>'>
						<c:out value="${sidtlLineItem.rate}"/>
                    </td>
					<td width="10%" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${sidtlLineItem.chgamt}"/>                    
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${sidtlLineItem.uname}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="25%" align="right">
                    
<c:if test="${!ListSidtlForm.headerInfo7}">
                                                            
	<c:if test="${ListSidtlForm.headerInfo5}">
<app:linkSidtlLineItem page="/EditSidtl.do?action=Delete"><bean:message key="prompt.delete"/></app:linkSidtlLineItem>
                              &nbsp;|&nbsp;                                  
<app:linkSidtlLineItem page="/EditSidtl.do?action=Edit"><bean:message key="prompt.edit"/></app:linkSidtlLineItem>
	</c:if>

	<c:if test="${!ListSidtlForm.headerInfo5}">                              
<app:linkSidtlLineItem page="/EditSidtl.do?action=View"><bean:message key="prompt.view"/></app:linkSidtlLineItem>
	</c:if>
        
</c:if>
                                                       				
					</td>								 										 													 										 			
				</tr>
				
							<tr><td colspan="8" background="images/border_dotted.gif"></td></tr>
							
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

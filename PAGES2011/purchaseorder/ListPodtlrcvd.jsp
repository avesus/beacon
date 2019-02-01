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
<title><bean:message key="podtlrcvd.title"/></title>
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
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht">
	<span class="heading2"><strong><bean:message key="podtlrcvd.title"/></strong></span>
	<span class="heading2"><html:link action="/ListPohdr" styleClass="link4"><bean:message key="pohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListPodtl" styleClass="link4"><bean:message key="podtl.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListPodtlrcvd" styleClass="link5"><bean:message key="title.list"/></html:link></span>
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS -----------------> 


<tr>
<!-- SIDEBAR ----------------->
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListPodtlrcvd">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="75%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="1" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="40%" class="td11"><span class="heading6"><bean:message key="prompt.pono"/></span></td>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.department"/></span></td>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.deliverydate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="45%" class="td11"><span class="heading6"><bean:message key="prompt.vendor"/></span></td>
	<td width="45%" class="td11"><span class="heading6"><bean:message key="prompt.shipto"/></span></td>
    <td width="10%" class="td11"><span class="heading6"><bean:message key="prompt.ccy"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo4" scope="session"/>
	</td>						
   </tr>
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="90%" class="td11"><span class="heading6"><bean:message key="prompt.podetaildescription"/></span></td>
    <td width="10%" class="td11"><span class="heading6"><bean:message key="prompt.quantity"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo7" scope="session"/>
	</td>
   <td class="td9">
	&nbsp;<bean:write name="ListPodtlrcvdForm" property="headerInfo8" scope="session"/>
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


<table width="80%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderResultsBgcolor">
				<tr>		
		  			<td class="purchaseorderResultsHeader" width="25%">
					<bean:message key="heading.shipmentno"/></td>
		  			<td class="purchaseorderResultsHeader" width="15%" align="right">
					<bean:message key="heading.quantityreceived"/></td>
		  			<td class="purchaseorderResultsHeader" width="15%">
					<bean:message key="heading.datereceived"/></td>
		  			<td class="purchaseorderResultsHeader" width="15%" align="right">
					<bean:message key="heading.quantitygenerated"/></td>																												
		  			<td class="purchaseorderResultsHeader" width="30%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="purchaseorderResultsHeader">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="purchaseorderResultsHeader">									
	<poapp:linkPodtlrcvdCreate page="/EditPodtlrcvd1.do?actionX=Create">
	<bean:message key="prompt.podtlrcvd.add"/></poapp:linkPodtlrcvdCreate>
						</td>
					</tr>
					</table>					
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListPodtlrcvdForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="25%">
						<c:out value="${lineItem.shipmentno}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%" align="right">
						<c:out value="${lineItem.qtyrcvd}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<bean:write name="lineItem" property="rcvddate" format="dd-MMM-yyyy" filter="true"/>						
					</td>  
					<td class='<c:out value="${_class}"/>' width="15%" align="right">
						<c:out value="${lineItem.qtygenerated}"/>						
					</td>					 																									
					<td class='<c:out value="${_class}"/>' width="30%" align="right">
																							
	  					<poapp:linkPodtlrcvdLineItem page="/EditPodtlrcvd1.do?actionX=Delete"><bean:message key="prompt.delete"/></poapp:linkPodtlrcvdLineItem>&nbsp;|&nbsp;
	  					<poapp:linkPodtlrcvdLineItem page="/EditPodtlrcvd1.do?actionX=Edit"><bean:message key="prompt.edit"/></poapp:linkPodtlrcvdLineItem>
				
					</td>								 										 													 										 			
				</tr>

				  				
				<tr><td colspan="5" background="images/border_dotted.gif"></td></tr>
							
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

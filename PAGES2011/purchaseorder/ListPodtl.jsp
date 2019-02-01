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
<title><bean:message key="podtl.title"/></title>
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
	<span class="heading2"><strong><bean:message key="podtl.title"/></strong></span>
	<span class="heading2"><html:link action="/ListPohdr" styleClass="link4"><bean:message key="pohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListPodtl" styleClass="link5"><bean:message key="title.list"/></html:link></span>
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

<html:form action="/ListPodtl">
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
	&nbsp;<bean:write name="ListPodtlForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlForm" property="headerInfo3" scope="session"/>
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
	&nbsp;<bean:write name="ListPodtlForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPodtlForm" property="headerInfo4" scope="session"/>
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
					<bean:message key="heading.description"/></td>
		  			<td class="purchaseorderResultsHeader" width="10%" align="right">
					<bean:message key="heading.quantity"/></td>
		  			<td class="purchaseorderResultsHeader" width="10%">
					<bean:message key="heading.glcode"/></td>															
		  			<td class="purchaseorderResultsHeader" width="10%" align="right">
					<bean:message key="heading.rate"/></td>	
		  			<td class="purchaseorderResultsHeader" width="10%" align="right">
					<bean:message key="heading.total"/></td>	
<%--	  			<td class="purchaseorderResultsHeader" width="15%" align="right">
					<bean:message key="heading.quantityreceived"/>
					</td>--%>																			
		  			<td class="purchaseorderResultsHeader" width="20%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">									
	<poapp:linkPodtlCreate page="/EditPodtl.do?action=Create">
	<bean:message key="prompt.podtl.add"/></poapp:linkPodtlCreate>
						</td>
					</tr>
					</table>					
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListPodtlForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="25%">
						<c:out value="${lineItem.txt1}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.qty}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${lineItem.glcode1}"/>						
					</td>  
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.rateamt}"/>						
					</td>
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.totalamt}"/>						
					</td>
<%--					<td class='<c:out value="${_class}"/>' width="15%" align="right">
						<c:out value="${lineItem.qtyreceived}"/>						
					</td>--%> 										  																									
					<td class='<c:out value="${_class}"/>' width="20%" align="right">
																							
	  					<poapp:linkPodtlLineItem page="/EditPodtl.do?action=Delete"><bean:message key="prompt.delete"/></poapp:linkPodtlLineItem>&nbsp;|&nbsp;
	  					<poapp:linkPodtlLineItem page="/EditPodtl.do?action=Edit"><bean:message key="prompt.edit"/></poapp:linkPodtlLineItem>&nbsp;|&nbsp;
	  					<poapp:linkPodtlLineItem page="/EditPodtl.do?action=Copy"><bean:message key="prompt.copy"/></poapp:linkPodtlLineItem>
				
					</td>								 										 													 										 			
				</tr>

                  <!-- row2 -->
                  <tr>
                    <td class='<c:out value="${_class}"/>' width='100%' colspan='6'>
						<poapp:linkPodtlPodtlrcvdLineItem page="/ListPodtlrcvd.do"><bean:message key="prompt.shipmentsreceived"/></poapp:linkPodtlPodtlrcvdLineItem>
                    </td>
                  </tr>
				  				
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

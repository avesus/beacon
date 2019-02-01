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
<title><bean:message key="financedtl.title"/></title>
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

	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="financedtl.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListFinancehdr" styleClass="link4">
				 	<bean:message key="financehdr.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListFinancedtl" styleClass="link5">
				<bean:message key="financedtl.title.list"/> 	
			</html:link>
		</span>							
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

<html:form action="/ListFinancedtl">
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
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.docid"/></span></td>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.createdate"/></span></td>
    <td width="40%" class="td11"><span class="heading6"><bean:message key="heading.lessee"/></span></td>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.invoiceref"/></span></td>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.contractno"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="15%">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo10" scope="session"/>
	</td>
    <td class="td9" width="15%">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9" width="40%">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td9" width="15%">		
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td9" width="15%">		
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo1" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="25%" class="td11"><span class="heading6"><bean:message key="heading.type"/></span></td>
	<td width="25%" class="td11"><span class="heading6"><bean:message key="heading.invoiceno"/></span></td>
    <td width="25%" class="td11"><span class="heading6"><bean:message key="heading.ccy"/></span></td>
    <td width="20%" class="td11"><span class="heading6"><bean:message key="heading.netamount"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo9" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo11" scope="session"/>
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
<logic:equal name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunResultsBgcolor">
				<tr>		
		  			<td class="billingrunResultsHeader" width="5%">
					
						<bean:message key="heading.lineno"/>		  								</td>				
		  			<td class="billingrunResultsHeader" width="20%">
					
						<bean:message key="heading.charge"/>		  								</td>
		  			<td class="billingrunResultsHeader" width="10%">
					
						<bean:message key="heading.unit"/>		  								</td>
		  			<td class="billingrunResultsHeader" width="10%" align="right">
					
						<bean:message key="heading.netamount"/>	  								</td>																				
		  			<td class="billingrunResultsHeader" width="10%" align="right">
						<bean:message key="heading.vatamount"/>
											</td>					
		  			<td width="10%" class="billingrunResultsHeader" align="right"> <bean:message key="heading.grossamount"/>  </td>
																	
		  			<td class="billingrunResultsHeader" width="15%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">
<!-- not printed and is manual -->					
<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="true">
	<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="false">										
	<genesysapp:linkFinancedtlCreate page="/EditFinancedtl.do?action=Create">
	<bean:message key="prompt.financedtl.add"/></genesysapp:linkFinancedtlCreate>
	</logic:equal>						
</logic:equal>	</td>
					</tr>
					</table>					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListFinancedtlForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>	
									<td class='<c:out value="${_class}"/>' width="5%">
						<c:out value="${lineItem.doclineno}"/>						
					</td> 		
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${lineItem.subtypekey.ldesc}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${lineItem.unitkey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.netamount}"/>						
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.vatamount}"/>						
						</td>					
					<td width="10%" align="right" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.grossamount}"/>
                    </td> 
					<td class='<c:out value="${_class}"/>' width="15%" align="right">

<!-- not printed -->
<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="false">																								
	  					<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=Delete"><bean:message key="prompt.delete"/></genesysapp:linkFinancedtlLineItem>&nbsp;|&nbsp;
	<!-- is manual -->				
	<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="true">
	  					<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=Edit"><bean:message key="prompt.edit"/></genesysapp:linkFinancedtlLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=Copy"><bean:message key="prompt.copy"/></genesysapp:linkFinancedtlLineItem>						
	</logic:equal>
</logic:equal>


<!-- not manual AND -->	
<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="false">
	<!-- is printed -->			
	<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="true">	
						<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=View"><bean:message key="prompt.view"/></genesysapp:linkFinancedtlLineItem>												
	</logic:equal>
</logic:equal>

<!-- not manual AND -->		
<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="false">
	<!-- not printed -->			
	<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="false">	
						<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=View"><bean:message key="prompt.view"/></genesysapp:linkFinancedtlLineItem>												
	</logic:equal>
</logic:equal>					
					</td>								 										 													 										 			
				</tr>
				
							<tr><td colspan="7" background="images/border_dotted.gif"></td></tr>
							
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

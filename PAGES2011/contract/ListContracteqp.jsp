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
<title><bean:message key="contracteqp.title"/></title>
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
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="contracteqp.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListContract" styleClass="link4">
				<bean:message key="contract.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListContracteqp" styleClass="link5">
				<bean:message key="title.list"/> 	
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
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:1050px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListContracteqp">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="50%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="1" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="20%" class="td11"><span class="heading6"><bean:message key="prompt.contractno"/></span></td>
    <td width="10%" class="td11"><span class="heading6"><bean:message key="prompt.createdate"/></span></td>
    <td width="10%" class="td11"><span class="heading6"><bean:message key="prompt.contractdate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="50%">
	&nbsp;<bean:write name="ListContracteqpForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9" width="25%">
	&nbsp;<bean:write name="ListContracteqpForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9" width="25%">
	&nbsp;<bean:write name="ListContracteqpForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="50%" class="td11"><span class="heading6"><bean:message key="prompt.lessee"/></span></td>
	<td width="25%" class="td11"><span class="heading6"><bean:message key="prompt.leasetype"/></span></td>
    <td width="25%" class="td11"><span class="heading6"><bean:message key="prompt.billingccy"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListContracteqpForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListContracteqpForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListContracteqpForm" property="headerInfo4" scope="session"/>
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
<logic:equal name="ListContracteqpForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListContracteqpForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListContracteqpForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListContracteqpForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListContracteqpForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListContracteqpForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListContracteqpForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListContracteqpForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="80%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractResultsBgcolor">
				<tr>		
		  			<td class="contractResultsHeader" width="25%">
					<bean:message key="heading.equipmentparameters"/></td>
		  			<td class="contractResultsHeader" width="15%" align="right">
					<bean:message key="heading.mindays"/></td>
		  			<td class="contractResultsHeader" width="15%" align="right">
					<bean:message key="heading.freedays"/></td>															
		  			<td class="contractResultsHeader" width="15%" align="right">
					<bean:message key="heading.fixdlyrat"/></td>											
		  			<td class="contractResultsHeader" width="30%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="contractResultsHeader">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="contractResultsHeader">									
	<genesysapp:linkContracteqpCreate page="/EditContracteqp.do?action=Create">
	<bean:message key="prompt.contracteqp.add"/></genesysapp:linkContracteqpCreate>
						</td>
					</tr>
					</table>					
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListContracteqpForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="25%">
						<c:out value="${lineItem.eqpkeyp1}"/>&nbsp;/&nbsp;<c:out value="${lineItem.eqpkeyp2}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%" align="right">
						<c:out value="${lineItem.mindays}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%" align="right">
						<c:out value="${lineItem.freedays}"/>						
					</td>  
					<td class='<c:out value="${_class}"/>' width="15%" align="right">
						<c:out value="${lineItem.fixdlyrat}"/>						
					</td>  																									
					<td class='<c:out value="${_class}"/>' width="30%" align="right">
																							
	  					<genesysapp:linkContracteqpLineItem page="/EditContracteqp.do?action=Delete"><bean:message key="prompt.delete"/></genesysapp:linkContracteqpLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkContracteqpLineItem page="/EditContracteqp.do?action=Edit"><bean:message key="prompt.edit"/></genesysapp:linkContracteqpLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkContracteqpLineItem page="/EditContracteqp.do?action=Copy"><bean:message key="prompt.copy"/></genesysapp:linkContracteqpLineItem>
				
					</td>								 										 													 										 			
				</tr>

                  <!-- row2 -->
                  <tr>
                    <td class='<c:out value="${_class}"/>' width='100%' colspan='8'>
						<genesysapp:linkContracteqpContracteqplocLineItem page="/ListContracteqploc.do"><bean:message key="prompt.locations"/></genesysapp:linkContracteqpContracteqplocLineItem>
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

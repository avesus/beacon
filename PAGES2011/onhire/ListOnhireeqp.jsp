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
<title><bean:message key="onhireeqp.title"/></title>
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
		<strong><bean:message key="onhireeqp.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListOnhire" styleClass="link4">
				<bean:message key="onhire.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListOnhireeqp" styleClass="link5">
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

<html:form action="/ListOnhireeqp">
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
    <td width="35%" class="td11"><span class="heading6"><bean:message key="prompt.onhireno"/></span></td>
    <td width="35%" class="td11"><span class="heading6"><bean:message key="prompt.contractno"/></span></td>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.submitteddate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="35%">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9" width="35%">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9" width="30%">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.lessee"/></span></td>
	<td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.location"/></span></td>
    <td width="40%" class="td11"><span class="heading6"><bean:message key="prompt.equipmentparameters"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo4" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo6" scope="session"/>
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
<logic:equal name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListOnhireeqpForm" property="lastPage"
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
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireResultsBgcolor">
				<tr>		
		  			<td class="onhireResultsHeader" width="20%">
					<bean:message key="heading.unit"/></td>
		  			<td class="onhireResultsHeader" width="25%">
					<bean:message key="heading.product"/></td>
		  			<td class="onhireResultsHeader" width="5%">
					<bean:message key="heading.clean"/></td>															
		  			<td class="onhireResultsHeader" width="5%">
					<bean:message key="heading.msds"/></td>	
		  			<td class="onhireResultsHeader" width="10%">
					<bean:message key="heading.reservedate"/></td>
		  			<td class="onhireResultsHeader" width="10%">
					<bean:message key="heading.onhiredate"/></td>		
		  			<td class="onhireResultsHeader" width="5%">
					<bean:message key="heading.actual"/></td>																										
		  			<td class="onhireResultsHeader" width="20%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="onhireResultsHeader">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="onhireResultsHeader">									
	<genesysapp:linkOnhireeqpCreate page="/EditOnhireeqp.do?action=Create">
	<bean:message key="prompt.onhireeqp.add"/></genesysapp:linkOnhireeqpCreate>
						</td>
					</tr>
					</table>					
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListOnhireeqpForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${lineItem.unitkey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="25%">
						<c:out value="${lineItem.productkey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="5%" align="center">
                      <c:if test="${lineItem.cleanflag == 'true'}">
					  	<img src="images/icon_mini_grey_cross_8_8.gif" width="8" height="8" align="middle"/>
                      </c:if>							
					</td>  
					<td class='<c:out value="${_class}"/>' width="5%" align="center">
                      <c:if test="${lineItem.msdsflag == 'true'}">
					  	<img src="images/icon_mini_grey_cross_8_8.gif" width="8" height="8" align="middle"/>
                      </c:if>							
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
					<bean:write name="lineItem" property="reservedate" format="dd-MMM-yyyy" filter="true"/>						
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
					<bean:write name="lineItem" property="onhiredate" format="dd-MMM-yyyy" filter="true"/>						
					</td>	
					<td class='<c:out value="${_class}"/>' width="5%" align="center">
                      <c:if test="${lineItem.actualflag != 'true'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" align="middle"/>
                      </c:if>
                      <c:if test="${lineItem.actualflag == 'true'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" align="middle"/>
                      </c:if>							
					</td>														  																									
					<td class='<c:out value="${_class}"/>' width="20%" align="right">
<c:if test="${lineItem.actualflag!='True'}"> 																							
	  					<genesysapp:linkOnhireeqpLineItem page="/EditOnhireeqp.do?action=Delete"><bean:message key="prompt.delete"/></genesysapp:linkOnhireeqpLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkOnhireeqpLineItem page="/EditOnhireeqp.do?action=Edit"><bean:message key="prompt.edit"/></genesysapp:linkOnhireeqpLineItem>
</c:if>				
					</td>								 										 													 										 			
				</tr>

                  <!-- row2 -->
                  <tr>
                    <td class='<c:out value="${_class}"/>' width='100%' colspan='8'>
						<genesysapp:linkOnhireeqpOnhireeqpotcLineItem page="/ListOnhireeqpotc.do"><bean:message key="prompt.onetimecharges"/></genesysapp:linkOnhireeqpOnhireeqpotcLineItem>
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

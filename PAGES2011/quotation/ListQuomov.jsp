<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 --%>
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
  
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->

<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->
 
<app:checkLogon/> 


<html:html>
<head>
<title><bean:message key="quomov.title.list"/></title>
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
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListQuomov"><bean:message key="quomov.title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

<tr><td>			
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>
</td></tr>

<tr><td>

<html:form action="/ListQuomov">
<html:hidden property="gotoPage" />




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
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotno"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotedate"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.expirydate"/></span></td>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.customer"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.createdby"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%" nowrap="nowrap">
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="40%">		
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo5" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.loadingport"/></span></td>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.dischargeport"/></span></td>
    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.quotecurrency"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo7" scope="session"/>
	</td>
    <td class="td6" width="20%">
	&nbsp;<bean:write name="ListQuomovForm" property="headerInfo8" scope="session"/>
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
		  			<td class="tddkgry" width="5%"><span class="heading4">
						<bean:message key="heading.sequence"/>
		  			</span>
					</td>				
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.section"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.fromlocation"/>
		  			</span>	
					</td>																				
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.tolocation"/>
		  			</span>	
					</td>
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.vendor"/>
						</span>	
					</td>																	
		  			<td class="tddkgry" width="25%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<app:linkQuomovCreate page="/EditQuomov.do?action=Create">
	<bean:message key="heading.addamovement"/>
</app:linkQuomovCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
						
			<c:forEach var="quomovLineItem" items="${ListQuomovForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>			
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="5%">
						<c:out value="${quomovLineItem.seqno}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quomovLineItem.sectionkey.sectionkey}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="20%">
<c:out value="${quomovLineItem.fromlocationkey.locationName}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="20%">
<c:out value="${quomovLineItem.tolocationkey.locationName}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' width="20%">
<c:out value="${quomovLineItem.vendoraddrkey.name}"/>					
					</td> 						
					<td class='<c:out value="${_class}"/>' width="25%" align="right">
									<table border="0" width="100% align="right" cellpadding="1" cellspacing="3">
										<tr>							
											<td class="text2" align="left">								
<app:linkQuomovQuocostLineItem page="/ListQuomovcost.do"><bean:message key="prompt.costs"/></app:linkQuomovQuocostLineItem>						
											</td>												
											<td class="text2" align="right">								
	  					<app:linkQuomovLineItem page="/EditQuomov.do?action=Delete"><bean:message key="prompt.delete"/></app:linkQuomovLineItem>&nbsp;|&nbsp;						
	  					<app:linkQuomovLineItem page="/EditQuomov.do?action=Edit"><bean:message key="prompt.edit"/></app:linkQuomovLineItem>&nbsp;|&nbsp;
	  					<app:linkQuomovLineItem page="/EditQuomov.do?action=Copy"><bean:message key="prompt.copy"/></app:linkQuomovLineItem>												</td>							
										</tr>
									</table>												  
					</td>								 										 
				</span>
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

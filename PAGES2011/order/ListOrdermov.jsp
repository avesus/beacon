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

<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->
 
<app:checkLogon/> 


<html:html>
<head>
<title><bean:message key="ordermov.title.list"/></title>
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
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListOrdermov"><bean:message key="ordermov.title.list"/></html:link></span> 
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

<html:form action="/ListOrdermov">
<html:hidden property="gotoPage" />
<%--
<html:hidden property="firstResult" />
<html:hidden property="maxResults" />
<html:hidden property="totalResults" />
<html:hidden property="firstPage" />
<html:hidden property="lastPage" />
<html:hidden property="orderBy" />
--%>



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
    <td width="15%" class="td4"><span class="heading6"></span>Order No</td>
    <td width="15%" class="td4"><span class="heading6"></span>Order Date</td>
    <td width="40%" class="td4"><span class="heading6"></span>Customer</td>
    <td width="15%" class="td4"><span class="heading6"></span>Customer Ref</td>
    <td width="15%" class="td4"><span class="heading6"></span>Created by</td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo5" scope="session"/>
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
    <td width="20%" class="td4"><span class="heading6"></span>Order Currency</td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo7" scope="session"/>
	</td>
    <td class="td6" width="20%">
	&nbsp;<bean:write name="ListOrdermovForm" property="headerInfo8" scope="session"/>
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
		  			<td class="tddkgry" width="10%"><span class="heading4">
						Section
		  			</span>
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						From Location
		  			</span>	
					</td>
		  			<td class="tddkgry" width="12%"><span class="heading4">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class="heading4">
								Est FROM Date/Time
		  					</td></tr>							
						</table>
		  			</span>	
					</td>																									
		  			<td class="tddkgry" width="10%"><span class="heading4">
						To Location					
		  			</span>	
					</td>
		  			<td class="tddkgry" width="12%"><span class="heading4">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class="heading4">
								Est TO Date/Time
		  					</td></tr>							
						</table>					
		  			</span>	
					</td>					
		  			<td class="tddkgry" width="10%"><span class="heading4">
						Vendor
						</span>	
					</td>																	
		  			<td class="tddkgry" width="20%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<orderapp:linkOrdermovCreate page="/EditOrdermov.do?action=Create">
	Add a Movement Section
</orderapp:linkOrdermovCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>		
			<c:forEach var="ordermovLineItem" items="${ListOrdermovForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>			
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${ordermovLineItem.sectionkey.sectionkey}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
<c:out value="${ordermovLineItem.fromlocationkey.locationName}"/>					
					</td>
					<td class='<c:out value="${_class}"/>' width="12%">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="ordermovLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${ordermovLineItem.estfromtime}"/>					
		  					</td></tr>
						</table>					
					</td>					  																				
					<td class='<c:out value="${_class}"/>' width="10%">
<c:out value="${ordermovLineItem.tolocationkey.locationName}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' width="12%">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="ordermovLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${ordermovLineItem.esttotime}"/>										
		  					</td></tr>
						</table>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%">
<c:out value="${ordermovLineItem.vendoraddrkey.name}"/>					
					</td> 						
					<td class='<c:out value="${_class}"/>' width="20%" align="right">
									<table border="0" width="100% align="right" cellpadding="1" cellspacing="3">
										<tr>							
											<td class="text2" align="left">								
<orderapp:linkOrdermovOrdercostLineItem page="/ListOrdermovcost.do"><bean:message key="prompt.costs"/></orderapp:linkOrdermovOrdercostLineItem>						
											</td>												
											<td class="text2" align="right">								
	  					<orderapp:linkOrdermovLineItem page="/EditOrdermov.do?action=Delete"><bean:message key="prompt.delete"/></orderapp:linkOrdermovLineItem>&nbsp;|&nbsp;						
	  					<orderapp:linkOrdermovLineItem page="/EditOrdermov.do?action=Edit"><bean:message key="prompt.edit"/></orderapp:linkOrdermovLineItem>&nbsp;|&nbsp;
	  					<orderapp:linkOrdermovLineItem page="/EditOrdermov.do?action=Copy"><bean:message key="prompt.copy"/></orderapp:linkOrdermovLineItem>												
						</td>							
										</tr>
									</table>												  
					</td>								 										 
				</span>
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

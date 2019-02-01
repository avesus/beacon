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
<title><bean:message key="quosummary.title"/></title>

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
	  <span class="heading2"><html:link action="/ListQuosummary"><bean:message key="quosummary.title"/></html:link></span>      
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
	
		<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListQuosummary">
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
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotno"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotedate"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.expirydate"/></span></td>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.customer"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.createdby"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%" nowrap="nowrap">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[1]" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[2]" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[3]" scope="session"/>
	</td>					
    <td class="td6" width="40%">		
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[4]" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[5]" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td></tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.shipmethod"/></span></td>  
    <td width="35%" class="td4"><span class="heading6"><bean:message key="heading.loadingport"/></span></td>
    <td width="35%" class="td4"><span class="heading6"><bean:message key="heading.dischargeport"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotecurrency"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[12]" scope="session"/>
	</td>
    <td class="td6" width="35%">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[6]" scope="session"/>
	</td>
    <td class="td6" width="35%">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[7]" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuosummaryForm" property="headerInfo[8]" scope="session"/>
	</td>						
   </tr>
</table>
</td></tr>
   
</table>

</td>
</tr>
</table>
<!-- end header information -->


<table><tr><td></td></tr></table>
<table><tr><td></td></tr></table>

<!-- start charge information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
   Quotation Charges  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>		
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.billingaccount"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="15%"><span class="heading4">
						<bean:message key="heading.charge"/>
		  			</span>	
					</td>																	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.chargecurrency"/>
						</span>	
					</td>			
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.tariffid"/>
						</span>	
					</td>						
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.amount"/>
						</span>	
					</td>	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.baserate"/>
						</span>	
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.baseamount"/>
						</span>	
					</td>																						
				</tr>
				
			<c:forEach var="quosummarychargeLineItem" items="${ListQuosummaryForm.lineItems[0]}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
				
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${quosummarychargeLineItem.customeraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<c:out value="${quosummarychargeLineItem.chargekey.ldesc}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quosummarychargeLineItem.ccykey}"/>					
					</td>			
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quosummarychargeLineItem.custtarfhdrId}"/>					
					</td>							
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${quosummarychargeLineItem.chgamt}"/>					
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${quosummarychargeLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>				
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${quosummarychargeLineItem.chgamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>										
					</td> 																		 										 
				</span>
  				</tr>
				<c:set var="chgamtbasetotal" value="${chgamtbasetotal + quosummarychargeLineItem.chgamtbase}"/>
			</c:forEach>

  				<tr>
				<span class="text2">			
					<td class="td6" width="20%" colspan="6">
					<strong>
					<bean:message key="prompt.chargetotal"/>:
					</strong>
					</td>  	
					<td class="td6" width="10%" align="right">		
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${chgamtbasetotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>				
						</strong>																					
					</td> 																		 										 
				</span>
  				</tr>	
							
			</table>
		</td>
	</tr>
</table>

</td>
</tr>
</table>
<!-- end charge information -->


<table>
<tr>
<td></td>
</tr>
</table>


<!-- start quohdr cost information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
   Quotation Costs	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>		
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.vendoraccount"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="15%"><span class="heading4">
						<bean:message key="heading.cost"/>
		  			</span>	
					</td>																	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.costcurrency"/>
						</span>	
					</td>					
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.tariffid"/>
						</span>	
					</td>					
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.amount"/>
						</span>	
					</td>	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.baserate"/>
						</span>	
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.baseamount"/>
						</span>	
					</td>																						
				</tr>
				
			<c:forEach var="quohdrcostLineItem" items="${ListQuosummaryForm.lineItems[1]}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
				
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${quohdrcostLineItem.vendoraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<c:out value="${quohdrcostLineItem.costkey.descr}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quohdrcostLineItem.ccykey}"/>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quohdrcostLineItem.vendtarfhdrId}"/>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${quohdrcostLineItem.cstamt}"/>					
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${quohdrcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>				
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${quohdrcostLineItem.cstamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>										
					</td> 																		 										 
				</span>
  				</tr>
				<c:set var="quohdrcstamtbasetotal" value="${quohdrcstamtbasetotal + quohdrcostLineItem.cstamtbase}"/>
			</c:forEach>

  				<tr>
				<span class="text2">			
					<td class="td6" width="20%" colspan="6">
					<strong>
					<bean:message key="prompt.costtotal"/>:
					</strong>
					</td>  	
					<td class="td6" width="10%" align="right">		
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${quohdrcstamtbasetotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>				
						</strong>																					
					</td> 																		 										 
				</span>
  				</tr>	
							
			</table>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
<!-- end quohdr cost information -->

<table>
<tr>
<td></td>
</tr>
</table>

<!-- start quomov cost information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
Movement Costs	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>		
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.vendoraccount"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="15%"><span class="heading4">
						<bean:message key="heading.cost"/>
		  			</span>	
					</td>																	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.costcurrency"/>
						</span>	
					</td>					
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.tariffid"/>
						</span>	
					</td>					
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.amount"/>
						</span>	
					</td>	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.baserate"/>
						</span>	
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.baseamount"/>
						</span>	
					</td>																						
				</tr>
				
			<c:forEach var="quomovcostLineItem" items="${ListQuosummaryForm.lineItems[2]}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
				
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${quomovcostLineItem.vendoraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<c:out value="${quomovcostLineItem.costkey.descr}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quomovcostLineItem.ccykey}"/>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${quomovcostLineItem.vendtarfhdrId}"/>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${quomovcostLineItem.cstamt}"/>					
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${quomovcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>				
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${quomovcostLineItem.cstamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>										
					</td> 																		 										 
				</span>
  				</tr>
				<c:set var="quomovcstamtbasetotal" value="${quomovcstamtbasetotal + quomovcostLineItem.cstamtbase}"/>
			</c:forEach>

  				<tr>
				<span class="text2">			
					<td class="td6" width="20%" colspan="6">
					<strong>
					<bean:message key="prompt.costtotal"/>:
					</strong>
					</td>  	
					<td class="td6" width="10%" align="right">		
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${quomovcstamtbasetotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>				
						</strong>																					
					</td> 																		 										 
				</span>
  				</tr>	
							
			</table>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
<!-- end quomov cost information -->


<table>
<tr>
<td></td>
</tr>
</table>


<!-- start summary information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
				
  				<tr>
				<span class="text2">			
					<td class="td6" width="20%">
					<strong>
					<bean:message key="prompt.profit"/>:
					</strong>
					</td> 
					<td class="td6" width="15%">			
					</td>  																				
					<td class="td6" width="10%">				
					</td>					
					<td class="td6" width="10%" align="right">			
					</td> 					
					<td class="td6" width="10%" align="right">			
					</td> 	
					<td class="td6" width="10%" align="right">				
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${(chgamtbasetotal - quohdrcstamtbasetotal - quomovcstamtbasetotal) / chgamtbasetotal * 100}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>%			
						</strong>
					</td> 	
					<td class="td6" width="10%" align="right">		
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${chgamtbasetotal - quohdrcstamtbasetotal - quomovcstamtbasetotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>				
						</strong>																					
					</td> 																		 										 
				</span>
  				</tr>	
							
			</table>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
<!-- end summary information -->



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

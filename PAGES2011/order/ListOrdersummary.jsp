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
<title>Financial Summary</title>
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
	<span class="heading2"><bean:message key="prompt.financialsummary"/></span>      						
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

<html:form action="/SaveOrdersummary">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr>
	<td>	

<!-- start header information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.orderno"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.orderdate"/></span></td>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.customer"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.customerref"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.createdby"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%" nowrap="nowrap">
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[1]" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[2]" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[4]" scope="session"/>
	</td>					
    <td class="td6" width="40%">		
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[3]" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[5]" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td></tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.loadingport"/></span></td>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.dischargeport"/></span></td>
    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.ordercurrency"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[6]" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[7]" scope="session"/>
	</td>
    <td class="td6" width="20%">
	&nbsp;<bean:write name="ListOrdersummaryForm" property="headerInfo[8]" scope="session"/>
	</td>						
   </tr>
</table>
</td></tr>
   
</table>
</td>
</tr>


</table>
</td>
</tr>
<!-- end header information -->

    
<tr><td>
<table><tr><td></td></tr></table>
</td></tr>
<tr><td>
<table><tr><td></td></tr></table>
</td></tr>


<!-- start charge information -->
<tr><td>
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">

  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
   Order Charges	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	
   
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
		  			<td class="tddkgry" width="5%">
<span class="heading4">
<html:submit styleClass="button1" property="btnSubmit" value="Invoice"> <bean:message key="button.invoice"/> </html:submit>											
</span>						
					</td>					
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
						<bean:message key="heading.invoicestatus"/>
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
				
			<c:forEach var="chargeLineItem" items="${ListOrdersummaryForm.list}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
				
  				<tr>
				<span class="text2">
                             <td class='<c:out value="${_class}"/>' align="center">
				<c:if test="${chargeLineItem.invoicestatus == '' or chargeLineItem.invoicestatus == 'READY'}">

<c:if test="${chargeLineItem.invoicestatus == 'READY'}">									
<input type='checkbox' name='selectedObjects' value='<c:out value="${chargeLineItem.orderchargeId}"/>' checked>
</c:if>
<c:if test="${chargeLineItem.invoicestatus == ''}">									
<input type='checkbox' name='selectedObjects' value='<c:out value="${chargeLineItem.orderchargeId}"/>'>
</c:if>

<html:hidden name="chargeLineItem" property="invoicestatus" />
													
				</c:if>							
                            </td>							
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${chargeLineItem.customeraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<c:out value="${chargeLineItem.chargekey.ldesc}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${chargeLineItem.ccykey}"/>					
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
                      <c:if test="${chargeLineItem.invoicestatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${chargeLineItem.invoicestatus == 'PRINTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>	
                      <c:if test="${chargeLineItem.invoicestatus == 'CREATED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>		
                      <c:if test="${chargeLineItem.invoicestatus == ''}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>						  			
						<c:out value="${chargeLineItem.invoicestatus}"/>								
					</td>								
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${chargeLineItem.custtarfhdrId}"/>					
					</td>							
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${chargeLineItem.chgamt}"/>					
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${chargeLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>				
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${chargeLineItem.chgamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>										
					</td> 																		 										 
				</span>
  				</tr>
				<c:set var="chgamtbasetotal" value="${chgamtbasetotal + chargeLineItem.chgamtbase}"/>
			</c:forEach>

  				<tr>
				<span class="text2">			
					<td class="td6" width="20%" colspan="8">
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
</td></tr>
<!-- end charge information -->

<%--<script language="JavaScript">

//function checkReadyInvoiceCharges(){
//('forms[0]','selectedObjects',true) 
	var selectedobjects_collection=eval("document.forms[0].selectedObjects");
	var invoicestatus_collection=eval("document.forms[0].invoicestatus");	
	for (c=0;c<selectedobjects_collection.length;c++) {
		if (invoicestatus_collection[c].value=='READY') selectedobjects_collection[c].checked=true;
	}
//}
		
</script>  --%>




<!-- start job cost information -->
<tr><td>
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
   Job Costs	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
                	<td class="tddkgry" width="5%">
<span class="heading4">
<html:submit styleClass="button1" property="btnSubmit" value="Post1"> <bean:message key="button.post"/> </html:submit>											
</span>						
					</td>			
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.unit"/>
		  			</span>
					</td>				
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
						<bean:message key="heading.status"/>
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
				
			<c:forEach var="jobcostLineItem" items="${ListOrdersummaryForm.lineItems[1]}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
				
  				<tr>
				<span class="text2">
                             <td class='<c:out value="${_class}"/>' align="center">
				<c:if test="${jobcostLineItem.poststatus == '' or jobcostLineItem.poststatus == 'READY'}">
<c:if test="${jobcostLineItem.poststatus == 'READY'}">									
<input type='checkbox' name='selectedObjects2' value='<c:out value="${jobcostLineItem.jobcostId}"/>' checked>
</c:if>
<c:if test="${jobcostLineItem.poststatus == ''}">									
<input type='checkbox' name='selectedObjects2' value='<c:out value="${jobcostLineItem.jobcostId}"/>'>
</c:if>

<html:hidden name="jobcostLineItem" property="poststatus" />
													
				</c:if>							
                            </td>                
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${jobcostLineItem.unitkey}"/>
					</td> 							
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${jobcostLineItem.vendoraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<c:out value="${jobcostLineItem.costkey.descr}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${jobcostLineItem.ccykey}"/>					
					</td>	
					<td class='<c:out value="${_class}"/>' width="10%">
                      <c:if test="${jobcostLineItem.poststatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>
                      <c:if test="${jobcostLineItem.poststatus == 'POSTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>		
                      <c:if test="${jobcostLineItem.poststatus == ''}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>						  			
						<c:out value="${jobcostLineItem.poststatus}"/>								
					</td>                    				
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${jobcostLineItem.vendtarfhdrId}"/>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${jobcostLineItem.cstamt}"/>					
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${jobcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>				
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${jobcostLineItem.cstamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>										
					</td> 																		 										 
				</span>
  				</tr>
				<c:set var="cstamtbasetotal2" value="${cstamtbasetotal2 + jobcostLineItem.cstamtbase}"/>
			</c:forEach>

  				<tr>
				<span class="text2">			
					<td class="td6" width="20%" colspan="9">
					<strong>
					<bean:message key="prompt.costtotal"/>:
					</strong>
					</td>  	
					<td class="td6" width="10%" align="right">		
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${cstamtbasetotal2}"
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
</td></tr>
<!-- end job cost information -->


<!-- start job movement cost information -->
<tr><td>
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
   Job Movement Costs	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
                	<td class="tddkgry" width="5%">
<span class="heading4">
<html:submit styleClass="button1" property="btnSubmit" value="Post2"> <bean:message key="button.post"/> </html:submit>											
</span>						
					</td>                		
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.unit"/>
		  			</span>
					</td>				
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
						<bean:message key="heading.status"/>
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
				
			<c:forEach var="jobmovcostLineItem" items="${ListOrdersummaryForm.lineItems[2]}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>
				
  				<tr>
				<span class="text2">
                             <td class='<c:out value="${_class}"/>' align="center">
				<c:if test="${jobmovcostLineItem.poststatus == '' or jobmovcostLineItem.poststatus == 'READY'}">
<c:if test="${jobmovcostLineItem.poststatus == 'READY'}">									
<input type='checkbox' name='selectedObjects3' value='<c:out value="${jobmovcostLineItem.jobcostId}"/>' checked>
</c:if>
<c:if test="${jobmovcostLineItem.poststatus == ''}">									
<input type='checkbox' name='selectedObjects3' value='<c:out value="${jobmovcostLineItem.jobcostId}"/>'>
</c:if>

<html:hidden name="jobmovcostLineItem" property="poststatus" />
													
				</c:if>							
                            </td>                 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${jobmovcostLineItem.unitkey}"/>
					</td> 							
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${jobmovcostLineItem.vendoraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="15%">
						<c:out value="${jobmovcostLineItem.costkey.descr}"/>					
					</td> 
                    					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${jobmovcostLineItem.ccykey}"/>					
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
                      <c:if test="${jobmovcostLineItem.poststatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobmovcostLineItem.poststatus}"/>'/>
                      </c:if>
                      <c:if test="${jobmovcostLineItem.poststatus == 'POSTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${jobmovcostLineItem.poststatus}"/>'/>
                      </c:if>		
                      <c:if test="${jobmovcostLineItem.poststatus == ''}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobmovcostLineItem.poststatus}"/>'/>
                      </c:if>						  			
						<c:out value="${jobmovcostLineItem.poststatus}"/>								
					</td>                      																				
					
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${jobmovcostLineItem.vendtarfhdrId}"/>					
					</td>					
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${jobmovcostLineItem.cstamt}"/>					
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${jobmovcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>				
					</td> 	
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<fmt:formatNumber 
							type="number"
							value="${jobmovcostLineItem.cstamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>										
					</td> 																		 										 
				</span>
  				</tr>
				<c:set var="cstamtbasetotal3" value="${cstamtbasetotal3 + jobmovcostLineItem.cstamtbase}"/>
			</c:forEach>

  				<tr>
				<span class="text2">			
					<td class="td6" width="20%" colspan="9">
					<strong>
					<bean:message key="prompt.costtotal"/>:
					</strong>
					</td>  	
					<td class="td6" width="10%" align="right">		
						<strong>
							<fmt:formatNumber 
								type="number"
								value="${cstamtbasetotal3}"
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
</td></tr>
<!-- end job movement cost information -->


<!-- start summary information -->
<tr><td>
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
<%--							<fmt:formatNumber 
								type="number"
								value="${(chgamtbasetotal - cstamtbasetotal1 - cstamtbasetotal2) / chgamtbasetotal * 100}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>%--%>	
							<fmt:formatNumber 
								type="number"
								value="${(chgamtbasetotal - cstamtbasetotal2 - cstamtbasetotal3) / chgamtbasetotal * 100}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>%										
						</strong>
					</td> 	
					<td class="td6" width="10%" align="right">		
						<strong>
<%--							<fmt:formatNumber 
								type="number"
								value="${chgamtbasetotal - cstamtbasetotal1 - cstamtbasetotal2}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>	--%>	
							<fmt:formatNumber 
								type="number"
								value="${chgamtbasetotal - cstamtbasetotal2 - cstamtbasetotal3}"
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

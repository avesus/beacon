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
<title><bean:message key="jobmov.title.list"/></title>
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
	<span class="heading2"><html:link action="/ListJobhdr"><bean:message key="jobhdr.title.list"/></html:link></span> 
	<span class="text6">&gt;</span>  
	<span class="heading2"><html:link action="/ListJobmov"><bean:message key="jobmov.title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:1250px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListJobmov">
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
    <td width="15%" class="td4"><span class="heading6">Order No</span></td>
    <td width="15%" class="td4"><span class="heading6">Order Date</span></td>
    <td width="40%" class="td4"><span class="heading6">Customer</span></td>
    <td width="15%" class="td4"><span class="heading6">Customer Ref</span></td>
    <td width="15%" class="td4"><span class="heading6">Created by</span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo5" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="35%" class="td4"><span class="heading6">Unit Number</span></td>
    <td width="35%" class="td4"><span class="heading6">Product</span></td>
    <td width="30%" class="td4"><span class="heading6">Reference</span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="35%">
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="35%">
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td6" width="30%">
	&nbsp;<bean:write name="ListJobmovForm" property="headerInfo7" scope="session"/>
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


<table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>		
		  			<td class="tddkgry" width="10%" valign="top"><span class="heading4">
						Section
		  			</span>					</td>
		  			<td class="tddkgry" width="8%" valign="top"><span class="heading4">Inv Status</span></td>
		  			<td class="tddkgry" width="10%" valign="top"><span class="heading4">
						From Location
		  			</span>					</td>
		  			<td class="tddkgry" width="12%"><span class="heading4">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class="heading4">
								Est FROM Date/Time
		  					</td></tr>
							<tr><td class="heading4">
								Act FROM Date/Time
		  					</td></tr>							
						</table>
		  			</span>					</td>																									
		  			<td class="tddkgry" width="10%" valign="top"><span class="heading4">
						To Location					
		  			</span>					</td>
		  			<td class="tddkgry" width="12%"><span class="heading4">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class="heading4">
								Est TO Date/Time
		  					</td></tr>
							<tr><td class="heading4">
								Act TO Date/Time
		  					</td></tr>							
						</table>					
		  			</span>					</td>					
		  			<td class="tddkgry" width="15%" valign="top"><span class="heading4">
						Vendor
						</span>					</td>				
		  			<td class="tddkgry" width="5%" valign="top"><span class="heading4">
						MMU Link
						</span>					</td>																				
		  			<td class="tddkgry" width="17%" valign="top">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">
<jobapp:linkJobmovCreate page="/EditJobmov.do?action=Create">
	Add a Movement</jobapp:linkJobmovCreate>						</td>
					</tr>
					</table>					</td>
				</tr>
							
			<c:forEach var="jobmovLineItem" items="${ListJobmovForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>	
                
                		
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
						<c:out value="${jobmovLineItem.sectionkey.sectionkey}"/>					</td> 
					<td class='<c:out value="${_class}"/>' width="8%" valign="top">
					<c:out value="${jobmovLineItem.invsts}"/>					</td>
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
<c:out value="${jobmovLineItem.fromlocationkey.locationName}"/>					</td>
					<td class='<c:out value="${_class}"/>' width="12%">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="jobmovLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.estfromtime}"/>					
		  					</td></tr>
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="jobmovLineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.actfromtime}"/>					
		  					</td></tr>							
						</table>					</td>					  																				
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
<c:out value="${jobmovLineItem.tolocationkey.locationName}"/>					</td> 
					<td class='<c:out value="${_class}"/>' width="12%">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="jobmovLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.esttotime}"/>										
		  					</td></tr>
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="jobmovLineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.acttotime}"/>										
		  					</td></tr>							
						</table>					</td>					
					<td class='<c:out value="${_class}"/>' width="15%" valign="top">
<c:out value="${jobmovLineItem.vendoraddrkey.name}"/>					</td>
					<td class='<c:out value="${_class}"/>' width="5%" valign="top">
<c:out value="${jobmovLineItem.mmulink}"/>					</td> 						
					<td class='<c:out value="${_class}"/>' width="17%" align="right" valign="top">
									<table border="0" width="100%" align="right" cellpadding="1" cellspacing="3">
										<tr>							
<%--											<td class="text2" align="left">											
						  <logic:notEqual name="jobmovLineItem" property="movref" value=""> 
<img src='images/icons/icon_information_12_12.png' width='16' height='16' border='0' alt='<c:out value="${jobmovLineItem.movref}"/>'/> 
						  </logic:notEqual>											
											</td>--%>												
											<td class="text2" align="right">	
																			
<jobapp:linkJobmovJobcostLineItem page="/ListJobcost.do"><bean:message key="prompt.costs"/></jobapp:linkJobmovJobcostLineItem>						
&nbsp;|&nbsp;																													
	  					<jobapp:linkJobmovLineItem page="/EditJobmov.do?action=Delete"><bean:message key="prompt.delete"/></jobapp:linkJobmovLineItem>
                        &nbsp;|&nbsp;
	  					<jobapp:linkJobmovLineItem page="/EditJobmov.do?action=Edit"><bean:message key="prompt.edit"/></jobapp:linkJobmovLineItem>
                        &nbsp;|&nbsp;
	  					<jobapp:linkJobmovLineItem page="/EditJobmov.do?action=Copy"><bean:message key="prompt.copy"/></jobapp:linkJobmovLineItem>
                        </td>
										</tr>
									</table>					</td>								 										 
				</span>  				</tr>
				
                
                <!--row2-->
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
						&nbsp;<c:out value="${jobmovLineItem.movref}"/>					
                    </td> 
					<td colspan="7" class='<c:out value="${_class}"/>' width="60%" valign="top">
						<c:out value="${jobmovLineItem.txt}"/>					
                    </td>
<td class='<c:out value="${_class}"/>' align='right' valign='top' width='30%'>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top">
<html:hidden name="jobmovLineItem" property="jobmovId"/>
<html:select property="searchString15" styleClass="ftforminputsmall">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>
</td>
<td valign="top">	
<html:select property="searchString14" styleClass="ftforminputsmall">
			<html:option value="Bookingnotification">Booking Notification</html:option>
			<html:option value="Arrivalnotice">Arrival Notice</html:option>
</html:select>
</td>
<td><input type=button value="Print" class="button1" onClick="document.location.href='EditJobmov'+searchString14.options[searchString14.selectedIndex].value+'.do?'+'companyheaderId='+searchString15.options[searchString15.selectedIndex].value+'&amp;jobmovId='+form.jobmovId.value+'&amp;printId=Jobmov'+form.jobmovId.value+searchString14.options[searchString14.selectedIndex].value+'&refreshdata=N&action=Print'"/>
</td>
</tr></form></table>
</td>				  																				
 													 										 
				</span>  				
                </tr>
                                
                
					<tr><td colspan="9" background="images/border_dotted.gif"></td></tr>
									
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

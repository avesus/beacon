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
<title>Fast Tracking</title>
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
		<strong>Fast Tracking</strong> 
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

<table border="0" cellpadding="5" cellspacing="10" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListFasttrack">
<html:hidden property="gotoPage" />

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>&nbsp;</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text7">
	  Unit Number:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString1" size="40" maxlength="40" styleClass="ftforminputsmall"/>				
		</td>
  	</tr>
	<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>		 
	<tr>
		<td align="left" width="60%" class="text7">
	  Latest Movement Before or Equal to:
		</td>		
  	</tr>
  	<tr>
	<td width="60%">
<table width="70%">
		<tr>
          <td width="10%" class="text7">
		  <div align="left">
		&nbsp;From:
		  </div>		  
		  </td>		
          <td width="40%">
		<html:select property="searchDate1dd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate1mm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>		
          <td width="5%" class="text7">
		  <div align="right">
		  </div>		  
		  </td>
          <td width="40%">
          </td>
		  </tr>
		  </table>
		</td>			
  	</tr>					
	<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
</table>

</td></tr></table>

</td>
</tr>
</table>

</td>
</tr>
</table>

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<%--<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
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
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>--%>


<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
				  <td class="tddkgry" width="10%" valign="top"><span class="heading4">Unit</span></td>		
		  			<td class="tddkgry" width="10%" valign="top"><span class="heading4">
						Section
		  			</span>					</td>
		  			<td class="tddkgry" width="10%" valign="top"><span class="heading4">Inv Status</span></td>
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
		  			<td class="tddkgry" width="10%" valign="top"><span class="heading4">
						Vendor
						</span>					</td>																	
		  			<td class="tddkgry" width="5%" valign="top">					</td>
				</tr>
							
			<c:forEach var="fasttrackLineItem" items="${ListFasttrackForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>			
  				<tr>
				<span class="text2">
  				  <td class='<c:out value="${_class}"/>' width="10%" valign="top">
				  <c:out value="${fasttrackLineItem.unit}"/>
				  </td>			
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
						<c:out value="${fasttrackLineItem.section.sectionkey}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
					<c:out value="${fasttrackLineItem.invsts}"/>
					</td>
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
<c:out value="${fasttrackLineItem.fromlocation.locationName}"/>					</td>
					<td class='<c:out value="${_class}"/>' width="12%">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="fasttrackLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${fasttrackLineItem.estfromtime}"/>					
		  					</td></tr>
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="fasttrackLineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${fasttrackLineItem.actfromtime}"/>					
		  					</td></tr>							
						</table>					</td>					  																				
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
<c:out value="${fasttrackLineItem.tolocation.locationName}"/>					</td> 
					<td class='<c:out value="${_class}"/>' width="12%">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="fasttrackLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${fasttrackLineItem.esttotime}"/>										
		  					</td></tr>
							<tr><td class='<c:out value="${_class}"/>'>
<bean:write name="fasttrackLineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${fasttrackLineItem.acttotime}"/>										
		  					</td></tr>							
						</table>					</td>					
					<td class='<c:out value="${_class}"/>' width="10%" valign="top">
<c:out value="${fasttrackLineItem.vendoraddr.name}"/>					</td> 						
					<td class='<c:out value="${_class}"/>' width="5%" align="right" valign="top">
									<table border="0" width="100%" align="right" cellpadding="1" cellspacing="3">
										<tr>							
											<td class="text2" align="left">											
											</td>												
											<td class="text2" align="right">								
											</td>							
										</tr>
									</table>					</td>								 										 
				</span>  				
				</tr>
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

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
<title>Movement Alerts</title>
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
	<span class="heading2"><strong>Movement Alerts</strong></span>
	<span class="heading2"><html:link action="/ListOrderhdr" styleClass="link4">Order List</html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListJobhdr" styleClass="link5">Job Unit List</html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListJobmovalert" styleClass="link5">Movement Alerts List</html:link></span>
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

<html:form action="/ListJobmovalert">
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
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo5" scope="session"/>
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
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="35%">
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td6" width="30%">
	&nbsp;<bean:write name="ListJobmovalertForm" property="headerInfo7" scope="session"/>
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
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="resultsBgcolor99">
				<tr>
                	<td class="resultsHeader99" width="5%" valign="top">
                    <bean:message key="heading.alertid"/>
                    </td>		
		  			<td class="resultsHeader99" width="5%" valign="top">
                    <bean:message key="heading.alertmodule"/>
                    </td>
		  			<td class="resultsHeader99" width="5%" valign="top">
                    <bean:message key="heading.alerttype"/>
                    </td>
		  			<td class="resultsHeader99" width="45%" valign="top">
                    <bean:message key="heading.alertwhen"/>				
                    </td>
		  			<td class="resultsHeader99" width="28%">
                    <bean:message key="heading.alertwho"/>				
                    </td>                 																									

                        <td align="right" class="resultsHeader99" valign="middle" width="12%">
                        <html:link action="/EditJobmovalert?action=Create" paramId="record1Id" paramName="ListJobmovalertForm" paramProperty="id">
                        <html:img src="images/buttons/btn_add_12_12.png" alt="Add" border="0" align="middle"/>
                        </html:link>
                        <html:link action="/EditJobmovalert?action=Create" paramId="record1Id" paramName="ListJobmovalertForm" paramProperty="id">
                            <span style="vertical-align:middle"><bean:message key="prompt.alert.add"/></span>
                        </html:link>
                        </td>                 				
				</tr>
							
			<c:forEach var="lineItem" items="${ListJobmovalertForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>	
                
                		
  				<tr>
					<td class='<c:out value="${_class}"/>' valign="top">
						<c:out value="${lineItem.alertId}"/>					
                        </td> 		
					<td class='<c:out value="${_class}"/>' valign="top">
						<c:out value="${lineItem.alertmodule}"/>					
                        </td> 
					<td class='<c:out value="${_class}"/>' valign="top">
						<c:out value="${lineItem.alerttype}"/>
                        </td>
					<td class='<c:out value="${_class}"/>' valign="top">
						<c:out value="${lineItem.alertwhen}"/>
                        </td>
					<td class='<c:out value="${_class}"/>' valign="top">
                    	<c:out value="${lineItem.alertwho}"/>
					</td>					  																				
															
					<td class='<c:out value="${_class}"/>'  align="right" valign="top">																				
<html:link action="/EditJobmovalert.do?action=Edit" paramId="alertId" paramName="lineItem" paramProperty="alertId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditJobmovalert.do?action=Copy" paramId="alertId" paramName="lineItem" paramProperty="alertId"><bean:message key="prompt.copy"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditJobmovalert.do?action=Delete" paramId="alertId" paramName="lineItem" paramProperty="alertId">
<bean:message key="prompt.delete"/> 
</html:link> 
                    </td>								 										 
				
                </tr>
				
                
                <!--row2-->
                                
                
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

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
<title><bean:message key="jobcost.title.list"/></title>
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
	<span class="heading2"><html:link action="/ListJobhdrcost"><bean:message key="jobcost.title.list"/></html:link></span> 
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
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListJobhdrcost">
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
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo5" scope="session"/>
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
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="35%">
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td6" width="30%">
	&nbsp;<bean:write name="ListJobhdrcostForm" property="headerInfo7" scope="session"/>
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
		  			<td class="tddkgry" width="35%"><span class="heading4">
						Vendor Account
		  			</span>
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						Cost
		  			</span>	
					</td>
                    <td class="tddkgry" width="10%"><span class="heading4">
						Status
		  			</span>	
					</td>   
		  			<td class="tddkgry" width="10%"><span class="heading4">
						Type
		  			</span>	
					</td>																				
		  			<td class="tddkgry" width="8%"><span class="heading4">
						Local Ccy
						</span>	
					</td>					
		  			<td class="tddkgry" width="10%"><span class="heading4">
						Amount
						</span>	
					</td>												
		  			<td class="tddkgry" width="28%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<jobapp:linkJobhdrcostCreate page="/EditJobhdrcost.do?action=Create">
	Add a Cost
</jobapp:linkJobhdrcostCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
				
			<c:forEach var="jobhdrcostLineItem" items="${ListJobhdrcostForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>		
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobhdrcostLineItem.vendoraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobhdrcostLineItem.costkey.costkey}"/>				
					</td> 
					<td class='<c:out value="${_class}"/>'>
                      <c:if test="${jobhdrcostLineItem.poststatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobhdrcostLineItem.poststatus}"/>'/>
                      </c:if>
                      <c:if test="${jobhdrcostLineItem.poststatus == 'POSTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${jobhdrcostLineItem.poststatus}"/>'/>
                      </c:if>							
<c:out value="${jobhdrcostLineItem.poststatus}"/>								
					</td>                    
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobhdrcostLineItem.costtype}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobhdrcostLineItem.ccykey}"/>										
					</td>					
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${jobhdrcostLineItem.cstamt}"/>									
					</td> 	
					<td class='<c:out value="${_class}"/>' align="right">
                    
<c:if test="${jobhdrcostLineItem.poststatus == ''}">						
	  					<jobapp:linkJobhdrcostLineItem page="/EditJobhdrcost.do?action=Delete"><bean:message key="prompt.delete"/></jobapp:linkJobhdrcostLineItem>&nbsp;|&nbsp;						
	  					<jobapp:linkJobhdrcostLineItem page="/EditJobhdrcost.do?action=Edit"><bean:message key="prompt.edit"/></jobapp:linkJobhdrcostLineItem>&nbsp;|&nbsp;
</c:if>

<c:if test="${jobhdrcostLineItem.poststatus != ''}">	
	  					<jobapp:linkJobhdrcostLineItem page="/EditJobhdrcost.do?action=View"><bean:message key="prompt.view"/></jobapp:linkJobhdrcostLineItem>&nbsp;|&nbsp;		
</c:if>													

	  					<jobapp:linkJobhdrcostLineItem page="/EditJobhdrcost.do?action=Copy"><bean:message key="prompt.copy"/></jobapp:linkJobhdrcostLineItem>	
                        						  
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

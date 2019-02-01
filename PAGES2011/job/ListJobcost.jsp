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
	<span class="heading2"><html:link action="/ListJobmov"><bean:message key="jobmov.title.list"/></html:link></span>
    <span class="text6">&gt;</span>  
	<span class="heading2"><html:link action="/ListJobcost"><bean:message key="jobcost.title.list"/></html:link></span>
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

<html:form action="/ListJobcost">
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
    <td width="15%" class="td4"><span class="heading6"></span>Order No</td>
    <td width="15%" class="td4"><span class="heading6"></span>Order Date</td>
    <td width="40%" class="td4"><span class="heading6"></span>Customer</td>
    <td width="15%" class="td4"><span class="heading6"></span>Customer Ref</td>
    <td width="15%" class="td4"><span class="heading6"></span>Created by</td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo5" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="40%" class="td4"><span class="heading6"></span>From Location</td>
    <td width="40%" class="td4"><span class="heading6"></span>To Location</td>
    <td width="20%" class="td4"><span class="heading6"></span>Order Currency</td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo7" scope="session"/>
	</td>
    <td class="td6" width="20%">
	&nbsp;<bean:write name="ListJobcostForm" property="headerInfo8" scope="session"/>
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
		  			<td class="tddkgry" width="32%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<jobapp:linkJobcostCreate page="/EditJobcost.do?action=Create">
	Add a Cost
</jobapp:linkJobcostCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
				
			<c:forEach var="jobcostLineItem" items="${ListJobcostForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>		
  				<tr>
				<span class="text2">			
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobcostLineItem.vendoraddrkey.name}"/>
					</td> 
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobcostLineItem.costkey.costkey}"/>				
					</td> 
					<td class='<c:out value="${_class}"/>'>
                      <c:if test="${jobcostLineItem.poststatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>
                      <c:if test="${jobcostLineItem.poststatus == 'POSTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>							
<c:out value="${jobcostLineItem.poststatus}"/>								
					</td>                    
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobcostLineItem.costtype}"/>					
					</td>  																				
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${jobcostLineItem.ccykey}"/>										
					</td>					
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${jobcostLineItem.cstamt}"/>									
					</td> 	
					<td class='<c:out value="${_class}"/>' align="right">
                    
<c:if test="${jobcostLineItem.poststatus == ''}">						
    	  					<jobapp:linkJobcostLineItem page="/EditJobcost.do?action=Delete"><bean:message key="prompt.delete"/></jobapp:linkJobcostLineItem>&nbsp;|&nbsp;						
	  					<jobapp:linkJobcostLineItem page="/EditJobcost.do?action=Edit"><bean:message key="prompt.edit"/></jobapp:linkJobcostLineItem>&nbsp;|&nbsp;
</c:if>

<c:if test="${jobcostLineItem.poststatus != ''}">	
	  					<jobapp:linkJobcostLineItem page="/EditJobcost.do?action=View"><bean:message key="prompt.view"/></jobapp:linkJobcostLineItem>&nbsp;|&nbsp;		
</c:if>													

	  					<jobapp:linkJobcostLineItem page="/EditJobcost.do?action=Copy"><bean:message key="prompt.copy"/></jobapp:linkJobcostLineItem>		
                                           					  
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

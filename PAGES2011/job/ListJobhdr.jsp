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
<title><bean:message key="jobhdr.title.list"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />


<script language="JavaScript">
var searchWin;

function loadingConfirmation(){
	var companyheaderId = document.forms[0].elements['searchString1'];
	var url     = '/beacon/EditLoadingconfirmation.do?'+
						'companyheaderId='+
                      	companyheaderId.options[companyheaderId.selectedIndex].value+ 
						'&orderhdrId='+
                      	document.forms[0].id.value+
					  	'&printId='+
						document.forms[0].id.value+'LoadConfirm'+
						'&refreshdata=N'+
						'&action=Print'
						;
	window.location.href = url;
}

</script>



</head>


<body onUnload="if (searchWin != null) {searchWin.close()}"> 

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

<html:form action="/ListJobhdr">
<html:hidden property="gotoPage" />
<html:hidden property="id" />


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
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo5" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="40%" class="td4"><span class="heading6"></span>Loading Port</td>
    <td width="40%" class="td4"><span class="heading6"></span>Discharge Port</td>
    <td width="20%" class="td4"><span class="heading6"></span>Order Currency</td>
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo7" scope="session"/>
	</td>
    <td class="td6" width="20%">
	&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo8" scope="session"/>
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
	<td class="text2"><font class="ftcolumntext">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
		</html:select>	
		<html:link href="javascript:void(loadingConfirmation())">
		<html:img src="images/buttons/btn_document.png" alt="Loading Confirmation" border="0" align="top"/>
		</html:link>
    </font></td>	
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
						<bean:message key="heading.jobno"/>
		  			</span>
					</td>	
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.unit"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.product"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="20%"><span class="heading4">
						<bean:message key="heading.reference"/>
					</span>
					</td>										
		  			<td class="tddkgry" width="20%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<jobapp:linkJobhdrCreate page="/EditJobhdr.do?action=Create">
	<bean:message key="prompt.assign"/>
</jobapp:linkJobhdrCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>	
					
			<c:forEach var="jobhdrLineItem" items="${ListJobhdrForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>			
  				<tr>
				<span class="text2">
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${jobhdrLineItem.jobno}"/>
					</td> 							
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${jobhdrLineItem.unitkey}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${jobhdrLineItem.productkey.tradname}"/>
					</td> 
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${jobhdrLineItem.movref}"/>
					</td> 										 						
					<td class='<c:out value="${_class}"/>' width="20%" align="right">
									<table border="0" width="100%" align="right" cellpadding="1" cellspacing="3">
										<tr>							
											<td class="text2" align="left">													

											</td>												
											<td class="text2" align="right">								
	  					<jobapp:linkJobhdrLineItem page="/EditJobhdr.do?action=Delete"><bean:message key="prompt.unassign"/></jobapp:linkJobhdrLineItem>&nbsp;|&nbsp;						
	  					<jobapp:linkJobhdrLineItem page="/EditJobhdr.do?action=Edit"><bean:message key="prompt.edit"/></jobapp:linkJobhdrLineItem>                        
                        											</td>							
										</tr>
									</table>												  
					</td>								 										 
				</span>
  				</tr>
				
				<!-- row2 -->
				<tr>		
								<td class='<c:out value="${_class}"/>' width="100%" colspan="8">								
									<jobapp:linkJobhdrJobmovLineItem page="/ListJobmov.do"><bean:message key="prompt.movements"/></jobapp:linkJobhdrJobmovLineItem>&nbsp;|&nbsp;
<jobapp:linkJobhdrJobcostLineItem page="/ListJobhdrcost.do"><bean:message key="prompt.costs"/></jobapp:linkJobhdrJobcostLineItem>										
&nbsp;|&nbsp;	
<html:link action="/ListJobmovalert.do" paramId="id" paramName="jobhdrLineItem" paramProperty="jobhdrId"><bean:message key="prompt.movementalerts"/></html:link>
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

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
<title><bean:message key="pidtlcost.title.list"/></title>
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
	  <span class="heading2"><html:link action="/ListPihdr"><bean:message key="pihdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListPidtl"><bean:message key="pidtl.title.list"/></html:link></span>
	<span class="text6">&gt;</span>    
	  <span class="heading2"><html:link action="/ListPidtlcost"><bean:message key="pidtlcost.title.list"/></html:link></span> 
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
	
		<div style="OVERFLOW:auto; width:1200px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListPidtlcost">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="50%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="30%" class="td4"><span class="heading6"><bean:message key="prompt.pino"/></span></td>
    <td width="25%" class="td4"><span class="heading6"><bean:message key="prompt.netamt"/></span></td>
    <td width="25%" class="td4"><span class="heading6"><bean:message key="prompt.invoiceamt"/></span></td>	
    <td width="20%" class="td4"><span class="heading6"><bean:message key="prompt.invoicedate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo6" scope="session"/>
	</td>	
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo7" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="45%" class="td4"><span class="heading6"><bean:message key="prompt.vendor"/></span></td>
	<td width="45%" class="td4"><span class="heading6"><bean:message key="prompt.vendorref"/></span></td>
    <td width="10%" class="td4"><span class="heading6"><bean:message key="prompt.ccy"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListPidtlcostForm" property="headerInfo4" scope="session"/>
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


<table border="0" cellpadding="0" cellspacing="0" width="80%" bgcolor="#ffffff">
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


<table width="60%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderResultsBgcolor">
				<tr>		
		  			<td class="purchaseorderResultsHeader" width="40%">
					<bean:message key="prompt.cost"/></td>                    
		  			<td class="purchaseorderResultsHeader" width="15%">
					<bean:message key="prompt.estimatecost"/></td>
		  			<td class="purchaseorderResultsHeader" width="15%" align="right">
					<bean:message key="prompt.actualcost"/></td>	
		  			<td class="purchaseorderResultsHeader" width="30%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">									
                            <html:link action="/EditPidtlcost?action=Create" paramId="pidtlId" paramName="ListPidtlcostForm" paramProperty="id">
                        <html:img src="images/buttons/btn_add_12_12.png" alt="Add" border="0" align="middle"/>
                        </html:link>
                        <html:link action="/EditPidtlcost?action=Create" paramId="pidtlId" paramName="ListPidtlcostForm" paramProperty="id">
                            <span style="vertical-align:middle"><bean:message key="prompt.pidtlcost.add"/></span>
                        </html:link>
						</td>
					</tr>
					</table>					
					</td>                    																
				</tr>

			<c:forEach var="lineItem" items="${ListPidtlcostForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.costkey.descr}"/>						
					</td> 	
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.cstamttotal}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.cstamtalloc}"/>						
					</td> 	
                    
                    
                    <td class='<c:out value="${_class}"/>' align="right">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class='<c:out value="${_class}"/>' align="right">
<%--<html:link action="/EditPidtlcost.do?action=Edit" paramId="pidtlcostId" paramName="lineItem" paramProperty="pidtlcostId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;--%>
<html:link action="/EditPidtlcost.do?action=Delete" paramId="pidtlcostId" paramName="lineItem" paramProperty="pidtlcostId">
<bean:message key="prompt.delete"/> 
</html:link>    
                          </td>
                        </tr>
                      	</table>						
					</td>		
                    
                    		
				</tr>

                  <!-- row2 -->

				  				
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

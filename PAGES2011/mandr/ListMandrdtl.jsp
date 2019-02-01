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
<title>
<bean:message key="mandrdtl.title"/>
</title>
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
	<td class="tdwht">
	<span class="heading2"><strong><bean:message key="mandrdtl.title"/></strong></span>
	<span class="heading2"><html:link action="/ListMandrhdrMain" styleClass="link4"><bean:message key="mandrhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListMandrdtl" styleClass="link5"><bean:message key="title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:1250px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListMandrdtl">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="searchBgcolor1">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableBgcolor1">
  <tr>
    <td width="15%" class="td6"><span class="heading6"><bean:message key="prompt.mandrno"/></span></td>
    <td width="15%" class="td6"><span class="heading6"><bean:message key="prompt.versionno"/></span></td>
    <td width="40%" class="td6"><span class="heading6"><bean:message key="prompt.estimateref"/></span></td>
    <td width="15%" class="td6"><span class="heading6"><bean:message key="prompt.unit"/></span></td>
    <td width="15%" class="td6"><span class="heading6"><bean:message key="prompt.createdby"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="15%">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9" width="15%">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9" width="40%">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td9" width="15%">		
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo11" scope="session"/>
	</td>					
    <td class="td9" width="15%">		
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo4" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableBgcolor1">
  <tr>
    <td width="25%" class="td6"><span class="heading6"><bean:message key="prompt.jobno"/></span></td>
	<td width="25%" class="td6"><span class="heading6"><bean:message key="prompt.ccy"/></span></td>
    <td width="25%" class="td6"><span class="heading6"><bean:message key="prompt.estimatedate"/></span></td>
    <td width="20%" class="td6"><span class="heading6"><bean:message key="prompt.estimatestatus"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListMandrdtlForm" property="headerInfo9" scope="session"/>
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
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="resultsBgcolor1">
				<tr class="tableBgcolor1">		
		  			<td  class="td6" width="6%"><span class="heading6"><bean:message key="heading.itemno"/></span>
                    </td>																			
		  			<td width="8%"  class="td6"><span class="heading6"><bean:message key="heading.componentcode"/></span>
                    </td>
		  			<td width="8%"  class="td6"><span class="heading6"><bean:message key="heading.locationcode"/></span>
                    </td>                    
		  			<td width="8%"  class="td6"><span class="heading6"><bean:message key="heading.damagecode"/></span>
                    </td>
		  			<td  class="td6" width="8%"><span class="heading6"><bean:message key="heading.repaircode"/></span>					
                    </td>
		  			<td  class="td6" width="5%"><span class="heading6"><bean:message key="heading.length"/></span>				
                    </td>
		  			<td  class="td6" width="5%"><span class="heading6"><bean:message key="heading.width"/></span>					
                    </td>	
		  			<td  class="td6" width="5%"><span class="heading6"><bean:message key="heading.quantity"/></span>					
                    </td>					
		  			<td width="5%"  class="td6"><span class="heading6"><bean:message key="heading.party"/></span>
                    </td>
		  			<td width="5%"  class="td6"><span class="heading6"><bean:message key="heading.laborhours"/></span>
                    </td>
		  			<td width="5%"  class="td6"><span class="heading6"><bean:message key="heading.laborrate"/></span>
                    </td>                    
		  			<td width="6%"  class="td6"><span class="heading6"><bean:message key="heading.laboramt"/></span>
                    </td>
		  			<td width="6%"  class="td6"><span class="heading6"><bean:message key="heading.materialamt"/></span>
                    </td>  
		  			<td width="6%"  class="td6"><span class="heading6"><bean:message key="heading.totalamt"/></span>
                    </td>                                                                                                                        												
                  <td class="td6" width="25%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="right" class="td6">
<span class="heading6">
<c:if test="${ListMandrdtlForm.headerInfo15 == 'true'}">                         
<html:link action="/EditMandrdtl?action=Create" paramId="mandrhdrId" paramName="ListMandrdtlForm" paramProperty="id"><bean:message key="prompt.mandrdtl.add"/></html:link>
</c:if>
</span>
                        </td>
                      </tr>
                    </table></td>
				</tr>

			<c:forEach var="lineItem" items="${ListMandrdtlForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry4"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="6%">
						<c:out value="${lineItem.itemno}"/>						
					</td> 
					<td width="8%" class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.componentcode}"/>                    
					</td>
					<td width="8%" class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.locationcode1}"/><c:out value="${lineItem.locationcode2}"/>                    
					</td>                    
					<td width="8%" class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.damagecode}"/>                    
					</td>
					<td class='<c:out value="${_class}"/>' width="8%">
						<c:out value="${lineItem.repaircode}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="5%" align="right">
						<c:out value="${lineItem.length}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="5%" align="right">
						<c:out value="${lineItem.width}"/>						
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="5%" align="right">
						<c:out value="${lineItem.quantity}"/>						
						</td>					
					<td width="5%" class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.responsibilitycode}"/>
                    </td>
					<td width="5%" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.laborhours}"/>
                    </td>  
					<td width="5%" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.laborrate}"/>
                    </td>                      
					<td width="6%" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.laboramt}"/>
                    </td>                                 
					<td width="6%" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.materialamt}"/>
                    </td>                                    
					<td width="6%" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.totalamt}"/>
                    </td>                                   
					<td rowspan="2" class='<c:out value="${_class}"/>' width="25%" align="right">

<bean:define id="param1" name="lineItem" property="mandrhdrId"/>
<bean:define id="param2" name="lineItem" property="mandrdtlId"/>
<% 
java.util.HashMap params = new java.util.HashMap();
params.put("mandrhdrId", param1);
params.put("mandrdtlId", param2);
pageContext.setAttribute("paramsName", params);
%>

<c:if test="${ListMandrdtlForm.headerInfo15 == 'true'}"> 
<html:link action="/EditMandrdtl.do?action=Edit" name="paramsName"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditMandrdtl.do?action=Copy" name="paramsName"><bean:message key="prompt.copy"/></html:link> 
&nbsp;|&nbsp;
<html:link action="/EditMandrdtl.do?action=Delete" name="paramsName"><bean:message key="prompt.delete"/></html:link> 																													
</c:if>					
					</td>								 										 													 										 			
				</tr>
                
<tr><td colspan="14" class='<c:out value="${_class}"/>'><c:out value="${lineItem.txt1}"/>&nbsp;</td></tr>
                            
                            				
							<tr><td colspan="15" background="images/border_dotted.gif"></td></tr>
							
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

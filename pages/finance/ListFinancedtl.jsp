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

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<app:checkLogon/>



<html:html>


<script language="JavaScript">
function screenRefresh() 
{
}
</script> 


<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>

 
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
  


<head><title><bean:message key="financedtl.title"/></title></head>


<body onLoad="onLoad();">

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<!-- HEADER ----------------->
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>


<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>   
<span class="header2"><bean:message key="financedtl.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListFinancehdr"><span class="header4"><bean:message key="financehdr.title.list"/></span></html:link>  						
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS -----------------> 


<tr>

	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListFinancedtl">
<html:hidden property="gotoPage" />
<html:hidden property="headerInfo5" />  <!--manualflag-->
<html:hidden property="headerInfo7" />	<!--printedflag-->
<html:hidden name="ListFinancedtlForm" property="id"/>


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.docid"/></span></td>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.createdate"/></span></td>
    <td width="40%" class="td11"><span class="heading6"><bean:message key="heading.lessee"/></span></td>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.invoiceref"/></span></td>
    <td width="15%" class="td11"><span class="heading6"><bean:message key="heading.contractno"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="15%">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo10" scope="session"/>
	</td>
    <td class="td9" width="15%">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9" width="40%">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td9" width="15%">		
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td9" width="15%">		
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo1" scope="session"/>
	</td>			
   </tr> 
     
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="25%" class="td11"><span class="heading6"><bean:message key="heading.type"/></span></td>
	<td width="25%" class="td11"><span class="heading6"><bean:message key="heading.invoiceno"/></span></td>
    <td width="25%" class="td11"><span class="heading6"><bean:message key="heading.ccy"/></span></td>
    <td width="20%" class="td11"><span class="heading6"><bean:message key="heading.netamount"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo6" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo9" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo8" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListFinancedtlForm" property="headerInfo11" scope="session"/>
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
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditFinancedtl.do?'+
'financehdrId='+
document.forms[0].id.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span><bean:message key="button.add"/></span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListFinancehdr.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>                                                  
					</div>     	
	</td>	
  </tr>

</table>
	</td>

<td width="15%">	
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
<logic:equal name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListFinancedtlForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListFinancedtlForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunResultsBgcolor">
				<tr>		
		  			<td class="billingrunResultsHeader" width="5%">
					
						<bean:message key="heading.lineno"/>		  								</td>				
		  			<td class="billingrunResultsHeader" width="20%">
					
						<bean:message key="heading.charge"/>		  								</td>
		  			<td class="billingrunResultsHeader" width="10%">
					
						<bean:message key="heading.unit"/>		  								</td>
		  			<td class="billingrunResultsHeader" width="10%" align="right">
					
						<bean:message key="heading.netamount"/>	  								</td>																				
		  			<td class="billingrunResultsHeader" width="10%" align="right">
						<bean:message key="heading.vatamount"/>
											</td>					
		  			<td width="10%" class="billingrunResultsHeader" align="right"> <bean:message key="heading.grossamount"/>  </td>
																	
		  			<td class="billingrunResultsHeader" width="15%">										
                    </td>
                    
				</tr>

			<c:forEach var="lineItem" items="${ListFinancedtlForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>	
									<td class='<c:out value="${_class}"/>' width="5%">
						<c:out value="${lineItem.doclineno}"/>						
					</td> 		
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${lineItem.subtypekey.ldesc}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%">
						<c:out value="${lineItem.unitkey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.netamount}"/>						
					</td>  																				
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
						<c:out value="${lineItem.vatamount}"/>						
						</td>					
					<td width="10%" align="right" class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.grossamount}"/>
                    </td> 
					<td class='<c:out value="${_class}"/>' width="15%" align="right">

<!-- not printed -->
<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="false">																								
	  					<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=Delete"><bean:message key="prompt.delete"/></genesysapp:linkFinancedtlLineItem>&nbsp;|&nbsp;
	<!-- is manual -->				
	<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="true">
	  					<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=Edit"><bean:message key="prompt.edit"/></genesysapp:linkFinancedtlLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=Copy"><bean:message key="prompt.copy"/></genesysapp:linkFinancedtlLineItem>						
	</logic:equal>
</logic:equal>


<!-- not manual AND -->	
<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="false">
	<!-- is printed -->			
	<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="true">	
						<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=View"><bean:message key="prompt.view"/></genesysapp:linkFinancedtlLineItem>												
	</logic:equal>
</logic:equal>

<!-- not manual AND -->		
<logic:equal name="ListFinancedtlForm" property="headerInfo5"
			scope="session" value="false">
	<!-- not printed -->			
	<logic:equal name="ListFinancedtlForm" property="headerInfo7"
				scope="session" value="false">	
						<genesysapp:linkFinancedtlLineItem page="/EditFinancedtl.do?action=View"><bean:message key="prompt.view"/></genesysapp:linkFinancedtlLineItem>												
	</logic:equal>
</logic:equal>					
					</td>								 										 													 										 			
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

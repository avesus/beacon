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
  


<head><title><bean:message key="onhireeqp.title"/></title></head>


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
<span class="header2"><bean:message key="onhireeqp.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListOnhire"><span class="header4"><bean:message key="onhire.title.list"/></span></html:link>  						
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS -----------------> 


<tr>
	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:1050px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListOnhireeqp">
<html:hidden property="gotoPage" />
<html:hidden name="ListOnhireeqpForm" property="id"/>


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="50%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="1" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="35%" class="td11"><span class="heading6"><bean:message key="prompt.onhireno"/></span></td>
    <td width="35%" class="td11"><span class="heading6"><bean:message key="prompt.contractno"/></span></td>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.submitteddate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="35%">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9" width="35%">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td9" width="30%">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.lessee"/></span></td>
	<td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.location"/></span></td>
    <td width="40%" class="td11"><span class="heading6"><bean:message key="prompt.equipmentparameters"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo4" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListOnhireeqpForm" property="headerInfo6" scope="session"/>
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
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditOnhireeqp.do?'+
'&amp;onhireId='+
document.forms[0].id.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOnhire.do'">
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
<logic:equal name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListOnhireeqpForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListOnhireeqpForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="80%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireResultsBgcolor">
				<tr>		
		  			<td class="onhireResultsHeader" width="20%">
					<bean:message key="heading.unit"/></td>
		  			<td class="onhireResultsHeader" width="25%">
					<bean:message key="heading.product"/></td>
		  			<td class="onhireResultsHeader" width="5%">
					<bean:message key="heading.clean"/></td>															
		  			<td class="onhireResultsHeader" width="5%">
					<bean:message key="heading.msds"/></td>	
		  			<td class="onhireResultsHeader" width="10%">
					<bean:message key="heading.reservedate"/></td>
		  			<td class="onhireResultsHeader" width="10%">
					<bean:message key="heading.onhiredate"/></td>		
		  			<td class="onhireResultsHeader" width="5%">
					<bean:message key="heading.actual"/></td>	
                    																									
		  			<td class="onhireResultsHeader" width="20%">			
										
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListOnhireeqpForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="20%">
						<c:out value="${lineItem.unitkey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="25%">
						<c:out value="${lineItem.productkey}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="5%" align="center">
                      <c:if test="${lineItem.cleanflag == 'true'}">
					  	<img src="images/icon_mini_grey_cross_8_8.gif" width="8" height="8" align="middle"/>
                      </c:if>							
					</td>  
					<td class='<c:out value="${_class}"/>' width="5%" align="center">
                      <c:if test="${lineItem.msdsflag == 'true'}">
					  	<img src="images/icon_mini_grey_cross_8_8.gif" width="8" height="8" align="middle"/>
                      </c:if>							
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
					<bean:write name="lineItem" property="reservedate" format="dd-MMM-yyyy" filter="true"/>						
					</td>
					<td class='<c:out value="${_class}"/>' width="10%">
					<bean:write name="lineItem" property="onhiredate" format="dd-MMM-yyyy" filter="true"/>						
					</td>	
					<td class='<c:out value="${_class}"/>' width="5%" align="center">
                      <c:if test="${lineItem.actualflag != 'true'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" align="middle"/>
                      </c:if>
                      <c:if test="${lineItem.actualflag == 'true'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" align="middle"/>
                      </c:if>							
					</td>														  																									
					<td class='<c:out value="${_class}"/>' width="20%" align="right">
<c:if test="${lineItem.actualflag!='True'}"> 																							
	  					<genesysapp:linkOnhireeqpLineItem page="/EditOnhireeqp.do?action=Delete"><bean:message key="prompt.delete"/></genesysapp:linkOnhireeqpLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkOnhireeqpLineItem page="/EditOnhireeqp.do?action=Edit"><bean:message key="prompt.edit"/></genesysapp:linkOnhireeqpLineItem>
</c:if>				
					</td>								 										 													 										 			
				</tr>

                  <!-- row2 -->
                  <tr>
                    <td class='<c:out value="${_class}"/>' width='100%' colspan='8'>
						<genesysapp:linkOnhireeqpOnhireeqpotcLineItem page="/ListOnhireeqpotc.do"><bean:message key="prompt.onetimecharges"/></genesysapp:linkOnhireeqpOnhireeqpotcLineItem>
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

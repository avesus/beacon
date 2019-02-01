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
  


<head><title><bean:message key="offhireeqpotc.title"/></title></head>


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
<span class="header2"><bean:message key="offhireeqpotc.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListOffhireeqp"><span class="header4"><bean:message key="offhireeqp.title.list"/></span></html:link> 
<span class="header2">&gt;</span>
<html:link action="/ListOffhire"><span class="header4"><bean:message key="offhire.title.list"/></span></html:link>  						
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS -----------------> 


<tr>
	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:1050px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListOffhireeqpotc">
<html:hidden property="gotoPage" />
<html:hidden name="ListOffhireeqpotcForm" property="id"/>


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
    <td width="70%" class="td11"><span class="heading6"><bean:message key="prompt.offhireno"/></span></td>
    <td width="30%" class="td11"><span class="heading6"><bean:message key="prompt.submitteddate"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9" width="70%">
	&nbsp;<bean:write name="ListOffhireeqpotcForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td9" width="30%">
	&nbsp;<bean:write name="ListOffhireeqpotcForm" property="headerInfo3" scope="session"/>
	</td>												
   </tr>      
</table>
</td>
</tr>

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="50%" class="td11"><span class="heading6"><bean:message key="prompt.lessee"/></span></td>
	<td width="50%" class="td11"><span class="heading6"><bean:message key="prompt.location"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListOffhireeqpotcForm" property="headerInfo5" scope="session"/>
	</td>
    <td class="td9">
	&nbsp;<bean:write name="ListOffhireeqpotcForm" property="headerInfo4" scope="session"/>
	</td>					
   </tr>
</table>
</td>
</tr>
   
<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
  <tr>
    <td width="100%" class="td11"><span class="heading6"><bean:message key="prompt.unit"/></span></td>
  </tr>  
  <tr class="text2"> 
    <td class="td9">
	&nbsp;<bean:write name="ListOffhireeqpotcForm" property="headerInfo7" scope="session"/>
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


<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">

<tr>
	<td class="text2">
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditOffhireeqpotc.do?'+
'&amp;offhireeqpId='+
document.forms[0].id.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOffhireeqp.do'">
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
<logic:equal name="ListOffhireeqpotcForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListOffhireeqpotcForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListOffhireeqpotcForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListOffhireeqpotcForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListOffhireeqpotcForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListOffhireeqpotcForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListOffhireeqpotcForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListOffhireeqpotcForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="60%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireResultsBgcolor">
				<tr>		
		  			<td class="offhireResultsHeader" width="30%">
					<bean:message key="heading.charge"/></td>
		  			<td class="offhireResultsHeader" width="30%" align="right">
					<bean:message key="heading.chargeamt"/></td>
                    																							
		  			<td class="offhireResultsHeader" width="40%">			
										
					</td>
				</tr>

			<c:forEach var="lineItem" items="${ListOffhireeqpotcForm.lineItems}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>' width="30%">
						<c:out value="${lineItem.chargekey.ldesc}"/>						
					</td> 
					<td class='<c:out value="${_class}"/>' width="30%" align="right">
						<c:out value="${lineItem.chargeamt}"/>						
					</td>  																									
					<td class='<c:out value="${_class}"/>' width="40%" align="right">
<c:if test="${ListOffhireeqpotcForm.headerInfo8!='true'}"> 																							
	  					<genesysapp:linkOffhireeqpotcLineItem page="/EditOffhireeqpotc.do?action=Delete"><bean:message key="prompt.delete"/></genesysapp:linkOffhireeqpotcLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkOffhireeqpotcLineItem page="/EditOffhireeqpotc.do?action=Edit"><bean:message key="prompt.edit"/></genesysapp:linkOffhireeqpotcLineItem>&nbsp;|&nbsp;
	  					<genesysapp:linkOffhireeqpotcLineItem page="/EditOffhireeqpotc.do?action=Copy"><bean:message key="prompt.copy"/></genesysapp:linkOffhireeqpotcLineItem>
</c:if>
					</td>								 										 													 										 			
				</tr>

                  <!-- row2 -->
				  				
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

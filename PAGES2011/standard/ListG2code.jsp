<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 *
 --%>
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
<title><bean:message key="gcode.title.list"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>

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
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="gcode.title"/> </strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListG2code" styleClass="link5">
				<bean:message key="gcode.title.list"/> 	
			</html:link>
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS -----------------> 


<tr>

	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListG2code" focus="searchString1">
<html:hidden property="gotoPage" />

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="gcode.title.search"/></h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.g1code"/>:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
<html:text property="searchString1" size="40" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>							
		</td>
  	</tr>	
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.g2code"/>:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">	
<html:text property="searchString2" size="40" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>				
		</td>
  	</tr>	     
</table>

</td></tr></table>

</td>
</tr>
</table>


<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">	
	<bean:message key="prompt.sortby"/>:&nbsp;
<logic:notEqual name="ListG2codeForm" property="orderBy"
			scope="session" value="G1codekey">
	<html:link action="/ListG2code?orderBy=G1codekey&gotoPage=0" styleClass="link6"><bean:message key="prompt.g1code"/></html:link>	
</logic:notEqual>
<logic:equal name="ListG2codeForm" property="orderBy"
			scope="session" value="G1codekey">
	<strong><bean:message key="prompt.g1code"/></strong>
</logic:equal>    
    &nbsp;|&nbsp;
<logic:notEqual name="ListG2codeForm" property="orderBy"
			scope="session" value="G2codekey">
	<html:link action="/ListG2code?orderBy=G2codekey&gotoPage=0" styleClass="link6"><bean:message key="prompt.g2code"/></html:link>	
</logic:notEqual>
<logic:equal name="ListG2codeForm" property="orderBy"
			scope="session" value="G2codekey">
	<strong><bean:message key="prompt.g2code"/></strong>
</logic:equal>	
&nbsp;|&nbsp;
<logic:notEqual name="ListG2codeForm" property="orderBy"
			scope="session" value="Ldesc">
	<html:link action="/ListG2code?orderBy=Ldesc&gotoPage=0" styleClass="link6"><bean:message key="prompt.description"/></html:link>	
</logic:notEqual>
<logic:equal name="ListG2codeForm" property="orderBy"
			scope="session" value="Ldesc">
	<strong><bean:message key="prompt.description"/></strong>
</logic:equal>
	
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
</table>

<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.g1code"/>
		  			</span>
					</td>
                    <td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.g2code"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="50%"><span class="heading4">
						<bean:message key="heading.description"/></span>	
					</td>					
		  			<td class="tddkgry" width="35%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<html:link action="/EditG2code?action=Create"><bean:message key="prompt.addagcode"/></html:link>								
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>			
			<logic:iterate id="lineItem" name="ListG2codeForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>				
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="10%">
<bean:write name="lineItem" property="g1codekey" filter="true"/>
					</td> 
                    					<td class="<%= _class %>" width="10%">
<bean:write name="lineItem" property="g2codekey" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="50%">
<bean:write name="lineItem" property="ldesc" filter="true"/>					
					</td> 					 
					<td class="<%= _class %>" width="35%">
<html:link action="/EditG2code.do?action=Edit" paramId="g2codeId" paramName="lineItem" paramProperty="g2codeId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditG2code.do?action=Copy" paramId="g2codeId" paramName="lineItem" paramProperty="g2codeId"><bean:message key="prompt.copy"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditG2code.do?action=Delete" paramId="g2codeId" paramName="lineItem" paramProperty="g2codeId">
<bean:message key="prompt.delete"/> 
</html:link>						  
					</td>
				</span>
  				</tr>
				
			</logic:iterate>
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

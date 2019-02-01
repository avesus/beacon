<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



<html:html>
<head>
<title><bean:message key="welcome.title"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="/beacon/css/base.css" />
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

 

<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/headerWelcome.jsp" flush="true" />
	</td>
</tr>

<!-- BREADCRUMBS -----------------> 
<tr>
	<td rowspan="3" width="121" valign="top" align="center" class="sidebar">
	<jsp:include page="/pages/sidebar.jsp" flush="true" />
	</td> 
	<td class="tdwht"><span class="heading2">     
		<strong>
<logic:notPresent name="user">
	<bean:message key="heading.logon"/>
</logic:notPresent>	
<logic:present name="user">
	<bean:message key="heading.mainmenu"/>
</logic:present>			
		</strong>	
			</span>			 				
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1"></td>
</tr>

<tr>
<%--	<td class="middle">--%>
<td>
<%--		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">--%>
		<div style="OVERFLOW:auto; position:relative;">
        
<div class="divDesktop1"> 

			
<!-- BODY GOES HERE ----------------->
<table border="0" cellpadding="10" cellspacing="10" width="100%">
<tr><td>
<logic:present name="user">
<ul>
<li><html:link action="/BeaconMenu">Beacon</html:link></li>
</ul>		
</logic:present>
</td>
</tr>
</table>

</div>

		</div>
	</td>
</tr>

<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

<%--<tr>
	<td colspan="2">
<jsp:include page="/pages/rss/rssajax.jsp" flush="true" />
	</td>
</tr>--%>

</table>

</body>

</html:html>

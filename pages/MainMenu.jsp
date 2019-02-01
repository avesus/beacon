<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<app:checkLogon/>



<html:html>


<head>
<title>Main Menu</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">

</head>

<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		onLoadSidebar('menu1');									
	}
    //]]>
</script>



<body onLoad="onLoad();">  

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>


<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1">
	<td rowspan="3" width="121" valign="top" align="center" class="sidebar">
	<jsp:include page="/pages/sidebar.jsp" flush="true" />
	</td> 
	<td>
    <span class="header2"><bean:message key="heading.desktop"/></span>						 				
	</td> 
</tr>  

<tr valign="top">
	<td height="1" bgcolor="#D0D0D0"><img src="images/spacer.gif" width="1" height="1"></td>
</tr>


<tr>

	
<%--	<td><img src="images/spacer.gif" height="600" width="1"></td>
	
	<td><img src="images/spacer.gif" height="600" width="1"></td>--%>

	<td align="center" class="middle">
		<div style="OVERFLOW:auto; width:920px; height:650px; position:relative;">	 
				
<jsp:include page="/pages/MainDesktop.jsp"/>
		
		</div>
	</td>

		
</tr>

<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

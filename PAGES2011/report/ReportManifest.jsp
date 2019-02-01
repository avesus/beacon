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
<head>
<title>Unit Movements Report</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%-- HEADER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<%-- BREADCRUMBS -----------------%> 
<tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong>Manifest Report</strong> 
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<%-- BREADCRUMBS -----------------%> 


<tr>
<%-- SIDEBAR -----------------%>
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ReportManifest" focus="searchString1">
<html:hidden property="gotoPage" />
<html:hidden property="searchString9" value="PDF"/>


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>&nbsp;</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text7"><bean:message key="prompt.vessel"/>:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavessel"/></html:option>
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>	
		</html:select>				
		</td>
  	</tr>
	<tr>
		<td align="left" class="text7"><bean:message key="prompt.voyage"/>:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString2" size="40" maxlength="40" styleClass="ftforminputsmall"/>				
		</td>
  	</tr>    	 

	  	<tr>
		<td align="left" width="35%" class="text7">
	  Order By:
		</td>		
  	</tr>	
  	<tr>
		<td align="left" width="40%" valign="top">
		<span class="ftformradiosmall">
		<html:select property="orderBy" styleClass="ftforminputsmall">
			<html:option value="jobhdr.Unitkey"><bean:message key="prompt.unit"/></html:option>
			<html:option value="jobmov.Billoflading"><bean:message key="prompt.billoflading"/></html:option>
		</html:select>
		</span>
		&nbsp;
		<span class="ftformradiosmall">
<html:radio property="orderByDesc" value="Asc"/>Asc		
<html:radio property="orderByDesc" value="Desc"/>Desc
		</span>
		</td>			
	</tr>			
	<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
</table>

</td></tr></table>

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


<%-- FOOTER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

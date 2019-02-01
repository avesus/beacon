<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



<html:html>
<head>
<title><bean:message key="welcome.title"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

 

<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/headerWelcome.jsp" flush="true" /></td></tr>

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1">
	<td rowspan="3" width="121" valign="top" align="center" class="sidebar">
	<jsp:include page="/pages/sidebar.jsp" flush="true" />
	</td> 
	<td><span class="header2">     
<logic:notPresent name="user">
	<bean:message key="heading.logon"/>
</logic:notPresent>	
<logic:present name="user">
	<bean:message key="heading.mainmenu"/>
</logic:present>			
			</span>			 				
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1"></td>
</tr>

<tr>
	<td>
		<div style="OVERFLOW:auto; position:relative;">

<div class="divDesktop1"> 
			
<!-- BODY GOES HERE ----------------->
<table border="0" cellpadding="10" cellspacing="10" width="100%">

<tr><td>

<logic:present name="user">
<ul>
<li><html:link action="/MainMenu">Beacon DMS</html:link></li>
</ul>		
</logic:present>

<logic:notPresent name="user">
<div id="results" style="position:absolute; left:530px; top:200px; z-index:10; visibility: visible">

  <html:form action="/SubmitLogon" focus="userid">

<table cellpadding="1" cellspacing="5" border="0" width="100%" bgcolor="#ffffff">
  
      <tr>
        <td class="label2">
          <bean:message key="prompt.userid"/>: </td>
      </tr>
      <tr>
        <td><html:text property="userid" size="20" maxlength="15" styleClass="forminput1"/>
        </td>
      </tr>
      <tr>
        <td class="label2">
          <bean:message key="prompt.password"/>: </td>
      </tr>
      <tr>
        <td><html:password property="password" size="20" maxlength="15"
                    redisplay="false" styleClass="forminput1"/>
        </td>
      </tr>
      <tr>
        <td>
			<div class="btnPane3">	        
				<button id="searchButton" class="btn btnFF" type="submit">
        			<span>Log In</span>
        		</button>                           
			</div>                                    
        </td>
      </tr>

</table>

  </html:form>
  
  <html:errors />
  
</div>  
</logic:notPresent>

</td></tr>

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

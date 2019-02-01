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
<title><bean:message key="title.list"/></title>
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
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="addresscontact.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListAddress" styleClass="link4">
				<bean:message key="address.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListAddresscontact" styleClass="link5">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>							
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
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<html:form action="/ListAddresscontact">
<html:hidden property="gotoPage" />
<%--
<html:hidden property="firstResult" />
<html:hidden property="maxResults" />
<html:hidden property="totalResults" />
<html:hidden property="firstPage" />
<html:hidden property="lastPage" />
<html:hidden property="orderBy" />
--%>



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="20%" class="td4"><span class="heading6"></span><bean:message key="heading.name"/></td>
    <td width="10%" class="td4"><span class="heading6"></span><bean:message key="heading.type"/></td>
    <td width="70%" class="td4"><span class="heading6"></span><bean:message key="heading.address"/></td>
  </tr>  
  <tr class="text2"> 
    <td class="td6"><bean:write name="ListAddresscontactForm" property="headerInfo1" filter="true"/></td>
    <td class="td6"><bean:write name="ListAddresscontactForm" property="headerInfo2" filter="true"/></td>
    <td class="td6">
		<bean:write name="ListAddresscontactForm" property="headerInfo3" filter="true"/>&nbsp;
		<bean:write name="ListAddresscontactForm" property="headerInfo4" filter="true"/>&nbsp;
		<bean:write name="ListAddresscontactForm" property="headerInfo5" filter="true"/>
	</td>			
</tr>  
</table>
</td>
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
<logic:equal name="ListAddresscontactForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListAddresscontactForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListAddresscontactForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListAddresscontactForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListAddresscontactForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListAddresscontactForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListAddresscontactForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListAddresscontactForm" property="lastPage"
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
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>		
		  			<td class="tddkgry" width="25%"><span class="heading4">
						<bean:message key="heading.name"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="25%"><span class="heading4">
						<bean:message key="heading.phone"/>
		  			</span>	
					</td>		
		  			<td class="tddkgry" width="25%"><span class="heading4">
						<bean:message key="heading.email"/>
		  			</span>	
					</td>										
		  			<td class="tddkgry" width="25%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<app:linkAddresscontactCreate page="/EditAddresscontact.do?action=Create">
	<bean:message key="prompt.addresscontact.add"/>
</app:linkAddresscontactCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="addresscontactLineItem" name="ListAddresscontactForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2";
row++; 
%>			
  				<tr>
				<span class="text2">			
					<td class="<%= _class %>" width="25%">
						<bean:write name="addresscontactLineItem" property="name" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="25%">
						<bean:write name="addresscontactLineItem" property="phone" filter="true"/>
					</td> 	
					<td class="<%= _class %>" width="25%">
						<bean:write name="addresscontactLineItem" property="email" filter="true"/>
					</td>
					<td class="<%= _class %>" width="25%">
	  					<app:linkAddresscontactLineItem page="/EditAddresscontact.do?action=Delete"><bean:message key="prompt.delete"/></app:linkAddresscontactLineItem>&nbsp;|&nbsp;						
	  					<app:linkAddresscontactLineItem page="/EditAddresscontact.do?action=Edit"><bean:message key="prompt.edit"/></app:linkAddresscontactLineItem>&nbsp;|&nbsp;
	  					<app:linkAddresscontactLineItem page="/EditAddresscontact.do?action=Copy"><bean:message key="prompt.copy"/></app:linkAddresscontactLineItem>							  
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

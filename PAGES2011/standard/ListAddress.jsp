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

<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>

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
		<strong><bean:message key="address.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListAddress" styleClass="link5">
				<bean:message key="title.list"/> 	
			</html:link>
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
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<html:form action="/ListAddress" focus="searchString1">
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
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#eeeeee"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#eeeeee">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="prompt.address.search"/>
</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text7">
	  <bean:message key="prompt.address.searchname"/>:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString1" size="40" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>				
		</td>
	<tr>
 	<tr>
		<td align="left" width="30%" class="texthelp2">
		 <bean:message key="prompt.address.wildcardhelp"/>				
		</td>
	<tr>    
	<tr>
		<td align="left" class="text7">
	  <bean:message key="prompt.address.searchtype"/>:
		</td>
  	</tr>

  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
			<html:options collection="addrtypes" property="typekey" labelProperty="typekey"/>	
		</html:select>								  
		</td>
	<tr>	
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
<logic:equal name="ListAddressForm" property="orderBy"
			scope="session" value="Typekey">
	<html:link action="/ListAddress?orderBy=Name&gotoPage=0" styleClass="link6"><bean:message key="prompt.name"/></html:link>	
</logic:equal>
<logic:equal name="ListAddressForm" property="orderBy"
			scope="session" value="Name">
	<strong><bean:message key="prompt.name"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListAddressForm" property="orderBy"
			scope="session" value="Typekey">		
	<strong><bean:message key="prompt.type"/></strong>
</logic:equal>
<logic:equal name="ListAddressForm" property="orderBy"
			scope="session" value="Name">
			<span class="link4">
	<html:link action="/ListAddress?orderBy=Typekey&gotoPage=0" styleClass="link6"><bean:message key="prompt.type"/></html:link>	
			</span>
</logic:equal>
	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
<%--<logic:equal name="ListAddressForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListAddressForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListAddressForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListAddressForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListAddressForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListAddressForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListAddressForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListAddressForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>--%>
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
		  			<td width="10%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.type"/>
		  			</span>	
					</td>	
		  			<td class="tddkgry" width="90%">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.address"/>
		  				</td>
						<td align="right" class="heading4">
<html:link action="/EditAddress?action=Create"><bean:message key="prompt.address.add"/></html:link>								
						</td>
					</tr>
					</table>
					</td>										
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="addressLineItem" name="ListAddressForm" property="lineItems">

<%

String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;

%>			
  				<tr>
				<span class="text2">
					<td width="100%" colspan="2" class="<%= _class %>">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td class="text2">
									<bean:write name="addressLineItem" property="name" filter="true"/>
								</td>
								<td align="right">												
									<table border="0" align="right" cellpadding="1" cellspacing="3">
										<tr>
										<%--
											<td class="text2">								
<app:linkAddressLineItem page=""><bean:message key="prompt.tariffs"/></app:linkAddressLineItem>						
											</td>
											--%>
											<td class="text2">								
<app:linkAddressLineItem page="/ListAddresscontact.do"><bean:message key="prompt.contacts"/></app:linkAddressLineItem>&nbsp;|&nbsp;						
											</td>												
											<td class="text2">								
<app:linkAddressLineItem page="/EditAddress.do?action=Delete"><bean:message key="prompt.delete"/></app:linkAddressLineItem>&nbsp;|&nbsp;						
											</td>						
											<td class="text2">						
<app:linkAddressLineItem page="/EditAddress.do?action=Edit"><bean:message key="prompt.edit"/></app:linkAddressLineItem>&nbsp;|&nbsp;
											</td>
											<td class="text2">						
<app:linkAddressLineItem page="/EditAddress.do?action=Copy"><bean:message key="prompt.copy"/></app:linkAddressLineItem>							  
											</td>							
										</tr>
									</table>																					
								</td>
							</tr>
						</table>
					</td> 									 
				</span>
  				</tr>
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="10%">
						<bean:write name="addressLineItem" property="typekey" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="90%">
						<bean:write name="addressLineItem" property="addr1" filter="true"/>
						<bean:write name="addressLineItem" property="addr2" filter="true"/>&nbsp;
						<bean:write name="addressLineItem" property="addr3" filter="true"/>&nbsp;
						<bean:write name="addressLineItem" property="addr4" filter="true"/>&nbsp;
						<bean:write name="addressLineItem" property="city" filter="true"/>&nbsp;						
						<bean:write name="addressLineItem" property="postalcode" filter="true"/>																		
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


<%-- FOOTER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

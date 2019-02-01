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
<title><bean:message key="orderprod.title.list"/></title>
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

	<td class="tdwht">
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListOrderprod"><bean:message key="orderprod.title.list"/></html:link></span> 
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS -----------------> 


<tr>
<!-- SIDEBAR ----------------->

	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

<tr><td>			
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>
</td></tr>

<tr><td>

<html:form action="/ListOrderprod">
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


<!-- start header information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" class="td4"><span class="heading6"></span>Order No</td>
    <td width="15%" class="td4"><span class="heading6"></span>Order Date</td>
    <td width="40%" class="td4"><span class="heading6"></span>Customer</td>
    <td width="15%" class="td4"><span class="heading6"></span>Customer Ref</td>
    <td width="15%" class="td4"><span class="heading6"></span>Created by</td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrderprodForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrderprodForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrderprodForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrderprodForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrderprodForm" property="headerInfo5" scope="session"/>
	</td>			
   </tr>  
</table>
</td>
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
	</td>	
  </tr>
</table>
	</td>

<td width="15%">	
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
              <img src="images/spacer.gif" width="1" height="13" border="0"/>
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
						Product
		  			</span>
					</td>
		  			<td class="tddkgry" width="20%"><span class="heading4">
						Volume
		  			</span>	
					</td>
		  			<td class="tddkgry" width="15%"><span class="heading4">
						Weight
		  			</span>	
					</td>																				
		  			<td class="tddkgry" width="15%"><span class="heading4">
						Compartment
		  			</span>	
					</td>												
		  			<td class="tddkgry" width="25%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<orderapp:linkOrderprodCreate page="/EditOrderprod.do?action=Create">
	Add a Product
</orderapp:linkOrderprodCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="orderprodLineItem" name="ListOrderprodForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2";
row++; 
%>			
  				<tr>
				<span class="text2">			
					<td class="<%= _class %>" width="25%">
						<bean:write name="orderprodLineItem" property="productkey.tradname" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="20%" align="right">
						<bean:write name="orderprodLineItem" property="volume" filter="true"/>&nbsp;
						<bean:write name="orderprodLineItem" property="volunit" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="15%" align="right">
						<bean:write name="orderprodLineItem" property="weight" filter="true"/>&nbsp;
						<bean:write name="orderprodLineItem" property="wghtunit" filter="true"/>
					</td>  																				
					<td class="<%= _class %>" width="15%" align="right">
						<bean:write name="orderprodLineItem" property="comprt" filter="true"/>
					</td> 	
					<td class="<%= _class %>" width="25%" align="right">
	  					<orderapp:linkOrderprodLineItem page="/EditOrderprod.do?action=Delete"><bean:message key="prompt.delete"/></orderapp:linkOrderprodLineItem>&nbsp;|&nbsp;						
	  					<orderapp:linkOrderprodLineItem page="/EditOrderprod.do?action=Edit"><bean:message key="prompt.edit"/></orderapp:linkOrderprodLineItem>&nbsp;|&nbsp;
	  					<orderapp:linkOrderprodLineItem page="/EditOrderprod.do?action=Copy"><bean:message key="prompt.copy"/></orderapp:linkOrderprodLineItem>							  
					</td>								 										 
				</span>
  				</tr>
				
					<tr><td colspan="5" background="images/border_dotted.gif"></td></tr>
									
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

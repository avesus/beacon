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
<title><bean:message key="orderfile.title.list"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
	<span class="heading2"><html:link action="/ListOrderfile"><bean:message key="orderfile.title.list"/></html:link></span>  
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
	
		<div style="OVERFLOW:auto; width:1050px; height:650px; position:relative;">	

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

<html:form action="/ListOrderfile">
<html:hidden property="gotoPage" />



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" class="td4"><span class="heading6"></span>Order No</td>
    <td width="15%" class="td4"><span class="heading6"></span>Order Date</td>
    <td width="40%" class="td4"><span class="heading6"></span>Customer</td>
    <td width="15%" class="td4"><span class="heading6"></span>Customer Ref</td>
    <td width="15%" class="td4"><span class="heading6"></span>Created by</td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%" nowrap="nowrap">
	&nbsp;<bean:write name="ListOrderfileForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrderfileForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrderfileForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrderfileForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrderfileForm" property="headerInfo5" scope="session"/>
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


<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">
	<bean:message key="prompt.sortby"/>:&nbsp;
<logic:notEqual name="ListOrderfileForm" property="orderBy"
			scope="session" value="Createdate">
	<html:link action="/ListOrderfile?orderBy=Createdate&amp;orderBy2=Createtime&gotoPage=0" styleClass="link6"><bean:message key="heading.date"/>/<bean:message key="heading.time"/></html:link>	
</logic:notEqual>
<logic:equal name="ListOrderfileForm" property="orderBy"
			scope="session" value="Createdate">
	<strong><bean:message key="heading.date"/>/<bean:message key="heading.time"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListOrderfileForm" property="orderBy"
			scope="session" value="Createuserid">		
	<strong><bean:message key="heading.userid"/></strong>
</logic:equal>
<logic:notEqual name="ListOrderfileForm" property="orderBy"
			scope="session" value="Createuserid">
			<span class="link4">
	<html:link action="/ListOrderfile?orderBy=Createuserid&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="heading.userid"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListOrderfileForm" property="orderBy"
			scope="session" value="Description">		
	<strong><bean:message key="heading.documentdescription"/></strong>
</logic:equal>
<logic:notEqual name="ListOrderfileForm" property="orderBy"
			scope="session" value="Description">
			<span class="link4">
	<html:link action="/ListOrderfile?orderBy=Description&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="heading.documentdescription"/></html:link>	
			</span>
</logic:notEqual>
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
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.date"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.time"/>
		  			</span>	
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.userid"/>
		  			</span>	
					</td>                                       
		  			<td class="tddkgry" width="50%"><span class="heading4">
						<bean:message key="heading.documentdescription"/>
		  			</span>	
					</td>											
		  			<td class="tddkgry" width="20%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<orderapp:linkOrderfileCreate page="/EditOrderfile.do?action=Create">
	<bean:message key="heading.addafile"/>
</orderapp:linkOrderfileCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="orderfileLineItem" name="ListOrderfileForm" property="lineItems">
<%
com.bureaueye.beacon.model.order.Orderfile orderfile = 
	(com.bureaueye.beacon.model.order.Orderfile)orderfileLineItem;
	
String _class = "tdlghtgry";
String _class2 = "tdlghtgry";
if ((row % 2) == 0) {
	_class = "tdlghtgry2";
	_class2 = "tdlghtgry2";
}


row++; 
%>	
  				<tr>
				<span class="text2">			
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="orderfileLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="orderfileLineItem" property="createtime" filter="true"/>		
					</td> 
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="orderfileLineItem" property="createuserid" filter="true"/>		
					</td>                     	 																									
					<td class="<%= _class %>" width="50%" nowrap="true" valign="top">
						<bean:write name="orderfileLineItem" property="description" filter="true"/>					
					</td>  
					<td class="<%= _class2 %>" width="20%" align="right" valign="top">						
<orderapp:linkOrderfileLineItem page="/EditOrderfile.do?action=View"><bean:message key="prompt.view"/></orderapp:linkOrderfileLineItem>&nbsp;|&nbsp;
<orderapp:linkOrderfileLineItem page="/EditOrderfile.do?action=Delete"><bean:message key="prompt.delete"/></orderapp:linkOrderfileLineItem>					  
					</td>								 										 
				</span>
  				</tr>
				
					<tr><td colspan="6" background="images/border_dotted.gif"></td></tr>
									
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

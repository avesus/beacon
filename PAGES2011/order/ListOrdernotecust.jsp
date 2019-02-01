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
<title><bean:message key="ordernotecust.title"/></title>

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
	<span class="heading2"><html:link action="/ListOrdernotecust"><bean:message key="ordernotecust.title.list"/></html:link></span> 
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

<html:form action="/ListOrdernote">
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
	&nbsp;<bean:write name="ListOrdernotecustForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListOrdernotecustForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListOrdernotecustForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrdernotecustForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListOrdernotecustForm" property="headerInfo5" scope="session"/>
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
<logic:notEqual name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Createdate">
	<html:link action="/ListOrdernotecust?orderBy=Createdate&amp;orderBy2=Createtime&gotoPage=0" styleClass="link6">Create Date/Time</html:link>	
</logic:notEqual>
<logic:equal name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Createdate">
	<strong>Create Date/Time</strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Createuserid">		
	<strong>User Id</strong>
</logic:equal>
<logic:notEqual name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Createuserid">
			<span class="link4">
	<html:link action="/ListOrdernotecust?orderBy=Createuserid&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6">User Id</html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>	
<logic:equal name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Priority">		
	<strong>Priority</strong>
</logic:equal>
<logic:notEqual name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Priority">
			<span class="link4">
	<html:link action="/ListOrdernotecust?orderBy=Priority&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6">Priority</html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Category">		
	<strong>Category</strong>
</logic:equal>
<logic:notEqual name="ListOrdernotecustForm" property="orderBy"
			scope="session" value="Category">
			<span class="link4">
	<html:link action="/ListOrdernotecust?orderBy=Category&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6">Category</html:link>	
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
						Date
		  			</span>
					</td>
		  			<td class="tddkgry" width="8%"><span class="heading4">
						Time
		  			</span>	
					</td>
		  			<td class="tddkgry" width="8%"><span class="heading4">
						User Id
		  			</span>	
					</td>
		  			<td class="tddkgry" width="8%"><span class="heading4">
						Category
		  			</span>	
					</td>																									
		  			<td class="tddkgry" width="47%"><span class="heading4">
						Notes
		  			</span>	
					</td>												
		  			<td class="tddkgry" width="29%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>		  				</td>
						<td align="right" class="heading4">									
                            <html:link action="/EditOrdernotecust?action=Create" paramId="orderhdrId" paramName="ListOrdernotecustForm" paramProperty="id">
                        <html:img src="images/buttons/btn_add_12_12.png" alt="Add" border="0" align="middle"/>
                        </html:link>
                        <html:link action="/EditOrdernotecust?action=Create" paramId="orderhdrId" paramName="ListOrdernotecustForm" paramProperty="id">
                            <span style="vertical-align:middle">Add a note</span>
                        </html:link>
						</td>
					</tr>
					</table>								
					</td>
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="lineItem" name="ListOrdernotecustForm" property="lineItems">
<%
com.bureaueye.beacon.model.order.Ordernotecust ordernotecust = 
	(com.bureaueye.beacon.model.order.Ordernotecust)lineItem;
	
String _class = "tdlghtgry";
String _class2 = "tdlghtgry";
if ((row % 2) == 0) {
	_class = "tdlghtgry2";
	_class2 = "tdlghtgry2";
}
if (ordernotecust.getPriority().equals("1")) _class = _class+"Red";
if (ordernotecust.getPriority().equals("2")) _class = _class+"Blue";
if (ordernotecust.getPriority().equals("3")) _class = _class+"Green";

row++; 
%>	
  				<tr>
				<span class="text2">			
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="8%" nowrap="true" valign="top">
						<bean:write name="lineItem" property="createtime" filter="true"/>		
					</td> 
					<td class="<%= _class %>" width="8%" nowrap="true" valign="top">
						<bean:write name="lineItem" property="createuserid" filter="true"/>					
					</td>  	
					<td class="<%= _class %>" width="8%" nowrap="true" valign="top">
						<bean:write name="lineItem" property="category" filter="true"/>					
					</td>  																									
					<td class="<%= _class %>" width="47%" valign="top">
						<bean:write name="lineItem" property="note1" filter="true"/>					
					</td> 	
					<td class="<%= _class2 %>" width="29%" align="right" valign="top">                       
<html:link action="/EditOrdernotecust.do?action=Edit" paramId="ordernotecustId" paramName="lineItem" paramProperty="ordernotecustId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditOrdernotecust.do?action=Copy" paramId="ordernotecustId" paramName="lineItem" paramProperty="ordernotecustId"><bean:message key="prompt.copy"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditOrdernotecust.do?action=Delete" paramId="ordernotecustId" paramName="lineItem" paramProperty="ordernotecustId">
<bean:message key="prompt.delete"/> 
</html:link> 
                        					  
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
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
<title><bean:message key="quonote.title.list"/></title>
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
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListQuonote"><bean:message key="quonote.title.list"/></html:link></span>
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

<html:form action="/ListQuonote">
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
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotno"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.quotedate"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.expirydate"/></span></td>
    <td width="40%" class="td4"><span class="heading6"><bean:message key="heading.customer"/></span></td>
    <td width="15%" class="td4"><span class="heading6"><bean:message key="heading.createdby"/></span></td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%" nowrap="nowrap">
	&nbsp;<bean:write name="ListQuonoteForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuonoteForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuonoteForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="40%">		
	&nbsp;<bean:write name="ListQuonoteForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListQuonoteForm" property="headerInfo5" scope="session"/>
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
<logic:notEqual name="ListQuonoteForm" property="orderBy"
			scope="session" value="Createdate">
	<html:link action="/ListQuonote?orderBy=Createdate&amp;orderBy2=Createtime&gotoPage=0" styleClass="link6"><bean:message key="prompt.createtime"/></html:link>	
</logic:notEqual>
<logic:equal name="ListQuonoteForm" property="orderBy"
			scope="session" value="Createdate">
	<strong><bean:message key="prompt.createtime"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListQuonoteForm" property="orderBy"
			scope="session" value="Createuserid">		
	<strong><bean:message key="prompt.userid"/></strong>
</logic:equal>
<logic:notEqual name="ListQuonoteForm" property="orderBy"
			scope="session" value="Createuserid">
			<span class="link4">
	<html:link action="/ListQuonote?orderBy=Createuserid&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.userid"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>	
<logic:equal name="ListQuonoteForm" property="orderBy"
			scope="session" value="Priority">		
	<strong><bean:message key="prompt.priority"/></strong>
</logic:equal>
<logic:notEqual name="ListQuonoteForm" property="orderBy"
			scope="session" value="Priority">
			<span class="link4">
	<html:link action="/ListQuonote?orderBy=Priority&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.priority"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListQuonoteForm" property="orderBy"
			scope="session" value="Category">		
	<strong><bean:message key="prompt.category"/></strong>
</logic:equal>
<logic:notEqual name="ListQuonoteForm" property="orderBy"
			scope="session" value="Category">
			<span class="link4">
	<html:link action="/ListQuonote?orderBy=Category&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.category"/></html:link>	
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
		  			<td class="tddkgry" width="8%"><span class="heading4">
												<bean:message key="heading.time"/>
		  			</span>	
					</td>
		  			<td class="tddkgry" width="8%"><span class="heading4">
												<bean:message key="heading.userid"/>
		  			</span>	
					</td>
		  			<td class="tddkgry" width="8%"><span class="heading4">
												<bean:message key="heading.category"/>
		  			</span>	
					</td>																									
		  			<td class="tddkgry" width="47%"><span class="heading4">
												<bean:message key="heading.notes"/>
		  			</span>	
					</td>												
		  			<td class="tddkgry" width="29%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<app:linkQuonoteCreate page="/EditQuonote.do?action=Create">
							<bean:message key="heading.addanote"/>
</app:linkQuonoteCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="quonoteLineItem" name="ListQuonoteForm" property="lineItems">
<%
com.bureaueye.beacon.model.quotation.Quonote quonote = 
	(com.bureaueye.beacon.model.quotation.Quonote)quonoteLineItem;
	
String _class = "tdlghtgry";
String _class2 = "tdlghtgry";
if ((row % 2) == 0) {
	_class = "tdlghtgry2";
	_class2 = "tdlghtgry2";
}
if (quonote.getPriority().equals("1")) _class = _class+"Red";
if (quonote.getPriority().equals("2")) _class = _class+"Blue";
if (quonote.getPriority().equals("3")) _class = _class+"Green";

row++; 
%>	
  				<tr>
				<span class="text2">			
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="quonoteLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="8%" nowrap="true" valign="top">
						<bean:write name="quonoteLineItem" property="createtime" filter="true"/>					
					</td> 
					<td class="<%= _class %>" width="8%" nowrap="true" valign="top">
						<bean:write name="quonoteLineItem" property="createuserid" filter="true"/>					
					</td>  	
					<td class="<%= _class %>" width="8%" nowrap="true" valign="top">
						<bean:write name="quonoteLineItem" property="category" filter="true"/>					
					</td>  																									
					<td class="<%= _class %>" width="47%" valign="top">
						<bean:write name="quonoteLineItem" property="note1" filter="true"/>					
					</td> 	
					<td class="<%= _class2 %>" width="29%" align="right" valign="top">
	  					<app:linkQuonoteLineItem page="/EditQuonote.do?action=Delete"><bean:message key="prompt.delete"/></app:linkQuonoteLineItem>&nbsp;|&nbsp;						
	  					<app:linkQuonoteLineItem page="/EditQuonote.do?action=Edit"><bean:message key="prompt.edit"/></app:linkQuonoteLineItem>&nbsp;|&nbsp;
	  					<app:linkQuonoteLineItem page="/EditQuonote.do?action=Copy"><bean:message key="prompt.copy"/></app:linkQuonoteLineItem>							  
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

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
<title><bean:message key="quofile.title.list"/></title>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>


<body> 

<table cellpadding="0" cellspacing="0" bquo="0" width="100%">

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
	  <span class="heading2"><html:link action="/ListQuofile"><bean:message key="quofile.title.list"/></html:link></span>
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

<table bquo="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListQuofile">
<html:hidden property="gotoPage" />



<table bquo="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	


<!-- start header information -->
<table width="100%" bquo="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
  <tr>
    <td>
<table bquo="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">

<tr><td>
<table width="100%"  bquo="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
  <tr>
    <td width="15%" class="td4"><span class="heading6"></span>Quote No</td>
    <td width="15%" class="td4"><span class="heading6"></span>Quote Date</td>
    <td width="40%" class="td4"><span class="heading6"></span>Customer</td>
    <td width="15%" class="td4"><span class="heading6"></span>Customer Ref</td>
    <td width="15%" class="td4"><span class="heading6"></span>Created by</td>	
  </tr>  
  <tr class="text2"> 
    <td class="td6" width="15%" nowrap="nowrap">
	&nbsp;<bean:write name="ListQuofileForm" property="headerInfo1" scope="session"/>
	</td>
    <td class="td6" width="15%">
	&nbsp;<bean:write name="ListQuofileForm" property="headerInfo2" scope="session"/>
	</td>
    <td class="td6" width="40%">
	&nbsp;<bean:write name="ListQuofileForm" property="headerInfo4" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListQuofileForm" property="headerInfo3" scope="session"/>
	</td>					
    <td class="td6" width="15%">		
	&nbsp;<bean:write name="ListQuofileForm" property="headerInfo5" scope="session"/>
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


<table bquo="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table bquo="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">
	<bean:message key="prompt.sortby"/>:&nbsp;
<logic:notEqual name="ListQuofileForm" property="orderBy"
			scope="session" value="Createdate">
	<html:link action="/ListQuofile?orderBy=Createdate&amp;orderBy2=Createtime&gotoPage=0" styleClass="link6"><bean:message key="heading.date"/>/<bean:message key="heading.time"/></html:link>	
</logic:notEqual>
<logic:equal name="ListQuofileForm" property="orderBy"
			scope="session" value="Createdate">
	<strong><bean:message key="heading.date"/>/<bean:message key="heading.time"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListQuofileForm" property="orderBy"
			scope="session" value="Createuserid">		
	<strong><bean:message key="heading.userid"/></strong>
</logic:equal>
<logic:notEqual name="ListQuofileForm" property="orderBy"
			scope="session" value="Createuserid">
			<span class="link4">
	<html:link action="/ListQuofile?orderBy=Createuserid&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="heading.userid"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListQuofileForm" property="orderBy"
			scope="session" value="Description">		
	<strong><bean:message key="heading.documentdescription"/></strong>
</logic:equal>
<logic:notEqual name="ListQuofileForm" property="orderBy"
			scope="session" value="Description">
			<span class="link4">
	<html:link action="/ListQuofile?orderBy=Description&amp;orderBy2=Createdate&gotoPage=0" styleClass="link6"><bean:message key="heading.documentdescription"/></html:link>	
			</span>
</logic:notEqual>
	</td>	
  </tr>
</table>
	</td>

<td width="15%">	
<table bquo="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
               <img src="images/spacer.gif" width="1" height="13" border="0"/>
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


<table width="100%" bquo="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  bquo="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
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
					<table bquo="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<app:linkQuofileCreate page="/EditQuofile.do?action=Create">
	<bean:message key="heading.addafile"/>
</app:linkQuofileCreate>											
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>				
			<logic:iterate id="quofileLineItem" name="ListQuofileForm" property="lineItems">
<%
com.bureaueye.beacon.model.quotation.Quofile quofile = 
	(com.bureaueye.beacon.model.quotation.Quofile)quofileLineItem;
	
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
						<bean:write name="quofileLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="quofileLineItem" property="createtime" filter="true"/>		
					</td> 
					<td class="<%= _class %>" width="10%" nowrap="true" valign="top">
						<bean:write name="quofileLineItem" property="createuserid" filter="true"/>		
					</td>                     	 																									
					<td class="<%= _class %>" width="50%" nowrap="true" valign="top">
						<bean:write name="quofileLineItem" property="description" filter="true"/>					
					</td>  
					<td class="<%= _class2 %>" width="20%" align="right" valign="top">						
<app:linkQuofileLineItem page="/EditQuofile.do?action=View"><bean:message key="prompt.view"/></app:linkQuofileLineItem>&nbsp;|&nbsp;
<app:linkQuofileLineItem page="/EditQuofile.do?action=Delete"><bean:message key="prompt.delete"/></app:linkQuofileLineItem>					  
					</td>								 										 
				</span>
  				</tr>
				
					<tr><td colspan="6" background="images/bquo_dotted.gif"></td></tr>
									
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

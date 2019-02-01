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

<jsp:useBean
  id="ListQuoapproveRequestForm"
  class="com.bureaueye.beacon.form.quotation.ListQuoapproveRequestForm"
  scope="session"
/>

 
<app:checkLogon/>


<html:html>
<head>
<title><bean:message key="quoapproverequest.title"/></title>
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
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>  
	  <span class="heading2"><bean:message key="quoapproverequest.title"/></span>	
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
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/SaveQuoapproveRequest" focus="usergroupid0">
<html:hidden property="gotoPage" />
<%--
<html:hidden property="firstResult" />
<html:hidden property="maxResults" />
<html:hidden property="totalResults" />
<html:hidden property="firstPage" />
<html:hidden property="lastPage" />
<html:hidden property="orderBy" />
--%>

<table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>


<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">

  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
<td class="td1">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
<%
int row=0;
%>  		
			<logic:iterate id="quoapproveLineItem" name="ListQuoapproveRequestForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
			
com.bureaueye.beacon.form.quotation.QuoapproveLineItem _QuoapproveLineItem = 
	(com.bureaueye.beacon.form.quotation.QuoapproveLineItem)quoapproveLineItem;
%>	
				
        <input type="hidden" name="quoapproveid<%= row %>" value="<%= _QuoapproveLineItem.getId_() %>">					
  				<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>				
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.groupid"/>:
		  </div>
					</td>				
					<td class="td9">	
  <select name="usergroupid<%= row %>" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectagroupid"/></option>
<%
	String s="";
	java.util.List list = null;
	list = (java.util.List)usergroups;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.Usergroup usergroup = 
					(com.bureaueye.beacon.model.standard.Usergroup) it.next();
				s = "";
				if (usergroup.getUsergroupid().equals(_QuoapproveLineItem.getUsergroupid())) s = "Selected";						
%>
		<option <%= s %> value="<%= usergroup.getUsergroupid() %>"><%= usergroup.getUsergroupid() %></option>
<%
		}
	}
%>			
  </select>							
					</td> 
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.userid"/>:
		  </div>
					</td>							
					<td class="td9">
  <select name="userid<%= row %>" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectauserid"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)users;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.User user = 
					(com.bureaueye.beacon.model.standard.User) it.next();
				s = "";
				if (user.getUserid().equals(_QuoapproveLineItem.getUserid())) s = "Selected";						
%>
		<option <%= s %> value="<%= user.getUserid() %>"><%= user.getUserid() %></option>
<%
		}
	}
%>			
  </select>							
					</td> 	
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.priority"/>:
		  </div>
					</td>							
					<td class="td9">
  <select name="priority<%= row %>" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectapriority"/></option>
<%
	int count = 1;
	while (count < 4) {
		s = ""; 
		String count_ = new Integer(count).toString();
		if (count_.equals(_QuoapproveLineItem.getPriority())) s = "Selected";		
%>
		<option <%= s %> value="<%= count_ %>"><%= count_ %></option>
<%
		count++;
	}
%>
                </select>					
					</td>
					<td class="td9" nowrap>
	<input type="checkbox" name="delete<%= row %>" class="ftforminputsmall" value="1">		        
				<bean:message key="prompt.delete"/>
					</td>					
		</tr>
		</table>
		</td>							 																		
  				</tr>
		

<%
row++;
%>						
			</logic:iterate>


<!-- blank line Items -->
<%
for (int i = row; i < 5; i++) {

String _class = "tdlghtgry";
if ((i % 2) == 0) _class = "tdlghtgry2"; 
%>			
        <input type="hidden" name="quoapproveid<%= i %>" value="">					
  				<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>				
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.groupid"/>:
		  </div>
					</td>				
					<td class="td9">	
  <select name="usergroupid<%= i %>" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectagroupid"/></option>
<%
	String s="";
	java.util.List list = null;
	list = (java.util.List)usergroups;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.Usergroup usergroup = 
					(com.bureaueye.beacon.model.standard.Usergroup) it.next();
				s = "";
%>
		<option <%= s %> value="<%= usergroup.getUsergroupid() %>"><%= usergroup.getUsergroupid() %></option>
<%
		}
	}
%>			
  </select>								
					</td> 
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.userid"/>:
		  </div>
					</td>							
					<td class="td9">
  <select name="userid<%= i %>" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectauserid"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)users;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.User user = 
					(com.bureaueye.beacon.model.standard.User) it.next();
				s = "";				
%>
		<option <%= s %> value="<%= user.getUserid() %>"><%= user.getUserid() %></option>
<%
		}
	}
%>			
  </select>	  
					</td> 	
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.priority"/>:
		  </div>
					</td>							
					<td class="td9">
  <select name="priority<%= i %>" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectapriority"/></option>
<%
	int count = 1;
	while (count < 4) {
		s = ""; 
		String count_ = new Integer(count).toString();
%>
		<option <%= s %> value="<%= count_ %>"><%= count_ %></option>
<%
		count++;
	}
%>
                </select>					
					</td>
					<td class="td9" nowrap>
	<input type="checkbox" name="delete<%= i %>" class="ftforminputsmall" value="1">		        
				<bean:message key="prompt.delete"/>
					</td>						
		</tr>
		</table>
		</td>							 																		
  				</tr>
<%
}
%>	

	<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>	
          <td class="td9"><strong>
<input type="checkbox" name="email" class="ftforminputsmall" value="1">		        
				<bean:message key="prompt.emailnotification"/>	  
		  </strong></td>
	</tr>
	</table>
	</td>	
	</tr>
			  
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td1">
        <html:submit styleClass="button1">
          <bean:message key="button.submit"/>
        </html:submit>
      <html:cancel styleClass="button1">
        <bean:message key="button.cancel"/>
      </html:cancel>
    </td>
  </tr>		  
    </table>
	</td>
  </tr>	  
  			
			</table>
		</td>
	</tr>
</table>

</td></tr></table>
</td></tr></table>
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

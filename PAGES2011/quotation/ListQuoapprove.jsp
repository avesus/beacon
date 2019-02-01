<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 											
 * NT	2010-01-30		201000010			Make user id check case insensitive
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


<jsp:useBean
  id="ListQuoapproveForm"
  class="com.bureaueye.beacon.form.quotation.ListQuoapproveForm"
  scope="session"
/>
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>
 
<app:checkLogon/>


<html:html>
<head>
<title><bean:message key="quoapprove.title"/></title>
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
	  <span class="heading2"><html:link action="/ListWorkflow"><bean:message key="workflow.title.list"/></html:link></span>	
  	<span class="text6">&gt;</span>  
	  <span class="heading2"><bean:message key="quoapprove.title"/></span>    
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

<html:form action="/SaveQuoapprove" focus="approveflag0">
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
          <td class="td7"><strong>
&nbsp;		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
<%
int row=0;
%>  		
			<logic:iterate id="quoapproveLineItem" name="ListQuoapproveForm" property="lineItems">

<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 

com.bureaueye.beacon.form.quotation.QuoapproveLineItem _quoapproveLineItem = 
	(com.bureaueye.beacon.form.quotation.QuoapproveLineItem)quoapproveLineItem;	
	
String disabled = "";	
if (
	!user.getUsergroupid().toUpperCase().trim().equals(_quoapproveLineItem.getUsergroupid().toUpperCase().trim()) && 	//201000009
	!user.getUserid().toUpperCase().trim().equals(_quoapproveLineItem.getUserid().toUpperCase().trim()) 				//201000009
	) disabled = "disabled";
%>			

        <input type="hidden" name="quoapproveid<%= row %>" value="<%= _quoapproveLineItem.getId_() %>">					
  				<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>				
					<td width="10%" class="td9" nowrap>					
		  <div align="right">
		        <bean:message key="prompt.groupid"/>:
		  </div>
					</td>				
					<td width="20%" class="td9">	
        <input type="hidden" name="usergroupid<%= row %>" value="<%= _quoapproveLineItem.getUsergroupid() %>">					
		<strong><bean:write name="quoapproveLineItem" property="usergroupid" filter="true"/></strong>
					</td> 
					<td width="10%" class="td9" nowrap>
		  <div align="right">
		        		        <bean:message key="prompt.userid"/>:
		  </div>
					</td>							
					<td width="20%" class="td9">
        <input type="hidden" name="userid<%= row %>" value="<%= _quoapproveLineItem.getUserid() %>">										
		<strong><bean:write name="quoapproveLineItem" property="userid" filter="true"/></strong>
					</td> 	
					<td width="10%" class="td9" nowrap>
		  <div align="right">
		        		        <bean:message key="prompt.priority"/>:
		  </div>
					</td>							
					<td width="20%" class="td9">
        <input type="hidden" name="priority<%= row %>" value="<%= _quoapproveLineItem.getPriority() %>">										
		<strong><bean:write name="quoapproveLineItem" property="priority" filter="true"/></strong>
					</td>
		</tr>
		</table>
		</td>							 																		
  				</tr>
		
  				<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
					<td class="td9">					 
  <select name="approveflag<%= row %>" <%= disabled %> class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectaapprovereject"/></option>
<%
	String s="";
	java.util.List list = null;
	list = (java.util.List)dispositions;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.Systemcode systemcode = 
					(com.bureaueye.beacon.model.standard.Systemcode) it.next();
				s = "";
				if (systemcode.getId().getCodekey().equals(_quoapproveLineItem.getApproveflag())) s = "Selected";						
%>
		<option <%= s %> value="<%= systemcode.getId().getCodekey() %>"><%= systemcode.getDescr() %></option>
<%
		}
	}
%>			
  </select>  
					</td>							
					<td class="td9">					 
  <select name="rejectreason<%= row %>" <%= disabled %> class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectarejectreason"/></option>
<%
	list = (java.util.List)rejectreasons;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.Rejectreason rejectreason = 
					(com.bureaueye.beacon.model.standard.Rejectreason) it.next();
				s = "";
				if (rejectreason.getReasonkey().equals(_quoapproveLineItem.getRejectreason())) s = "Selected";				
%>
		<option <%= s %> value="<%= rejectreason.getReasonkey() %>"><%= rejectreason.getDescr() %></option>
<%
		}
	}
%>	
  </select>
					</td>
					
					<td class="td9" nowrap>
		  <div align="right">
		        <bean:message key="prompt.notes"/>:
		  </div>					
					</td>					
					<td class="td9">
        <input type="text" name="notes<%= row %>" <%= disabled %> value="<%= _quoapproveLineItem.getNotes() %>" size="40" class="ftforminputsmall">																						
					</td>		
		</tr>
		</table>
		</td>													
  				</tr>
<%
if (disabled.equals("disabled")) {
%>			
<input type="hidden" name="approveflag<%= row %>" value="<%= _quoapproveLineItem.getApproveflag() %>">
<input type="hidden" name="rejectreason<%= row %>" value="<%= _quoapproveLineItem.getRejectreason() %>">
<input type="hidden" name="notes<%= row %>" value="<%= _quoapproveLineItem.getNotes() %>">	
<%
}
%>				

<%
row++;
%>			
  			
			</logic:iterate>

  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
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

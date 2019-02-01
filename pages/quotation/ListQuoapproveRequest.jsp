<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
-->
 
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


<script language="JavaScript">
	function screenRefresh() 
	{
	}
</script>


<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>






<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="quoapproverequest.title"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="quoapproverequest.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListQuohdr"><span class="header4"><bean:message key="quohdr.title.list"/></span></html:link>        
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	

        	  	  
<tr><td>
	<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">

          
		<tr><td colspan="2">
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

    

<html:form action="/SaveQuoapproveRequest" focus="usergroupid0">
<html:hidden property="gotoPage" />       
    	
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
   

        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">

<%
int row=0;
%>  		

            


			<logic:iterate id="quoapproveLineItem" name="ListQuoapproveRequestForm" property="lineItems">

<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>   
<%row++;%>

<%
com.bureaueye.beacon.form.quotation.QuoapproveLineItem _QuoapproveLineItem = 
	(com.bureaueye.beacon.form.quotation.QuoapproveLineItem)quoapproveLineItem;
%>	
				
        <input type="hidden" name="quoapproveid<%= row %>" value="<%= _QuoapproveLineItem.getId_() %>">					
  				<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>				
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.groupid"/>:
		  </div>
					</td>				
					<td class="<%= _class %>">	
  <select name="usergroupid<%= row %>" class="forminput1">
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
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.userid"/>:
		  </div>
					</td>							
					<td class="<%= _class %>">
  <select name="userid<%= row %>" class="forminput1">
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
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.priority"/>:
		  </div>
					</td>							
					<td class="<%= _class %>">
  <select name="priority<%= row %>" class="forminput1">
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
					<td class="<%= _class %>" nowrap>
	<input type="checkbox" name="delete<%= row %>" class="forminput1" value="1">		        
				<bean:message key="prompt.delete"/>
					</td>					
		</tr>
		</table>
		</td>							 																		
  				</tr>
								
			</logic:iterate>


<!-- blank line Items -->
<%
for (int i = row; i < 5; i++) {
%>

<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>
<%row++;%>
			
        <input type="hidden" name="quoapproveid<%= i %>" value="">					
  				<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>				
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.groupid"/>:
		  </div>
					</td>				
					<td class="<%= _class %>">	
  <select name="usergroupid<%= i %>" class="forminput1">
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
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.userid"/>:
		  </div>
					</td>							
					<td class="<%= _class %>">
  <select name="userid<%= i %>" class="forminput1">
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
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.priority"/>:
		  </div>
					</td>							
					<td class="<%= _class %>">
  <select name="priority<%= i %>" class="forminput1">
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
					<td class="<%= _class %>" nowrap>
	<input type="checkbox" name="delete<%= i %>" class="forminput1" value="1">		        
				<bean:message key="prompt.delete"/>
					</td>						
		</tr>
		</table>
		</td>							 																		
  				</tr>
<%
}
%>	
                
    
            			</table>
					</td>
				</tr>

	<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>	
          <td class="label2"><strong>
<input type="checkbox" name="email" class="forminput1" value="1">		        
				<bean:message key="prompt.emailnotification"/>	  
		  </strong></td>
	</tr>
	</table>
	</td>	
	</tr>


				<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    	<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				                <button id="buttonSubmit" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.submit"/></span>
                				</button>      
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			                </button>                            
				        </div>
                 
      				</td>
				</tr>
                
    
			</html:form>
      
		</table>

</div>
</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

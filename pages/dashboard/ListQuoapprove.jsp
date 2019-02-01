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
<title><bean:message key="quoapprove.title"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="quoapprove.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/Dashboard"><span class="header4"><bean:message key="dashboard.title"/></span></html:link>        
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

    
<html:form action="/DashboardSaveQuoapprove" focus="approveflag0">
<html:hidden property="gotoPage" />         
    	
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
   

        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">

<%
int row=0;
%>  		
<logic:iterate id="quoapproveLineItem" name="ListQuoapproveForm" property="lineItems">


<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>

<%
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
					<td width="10%" class="<%= _class %>" nowrap>					
		  <div align="right">
		        <bean:message key="prompt.groupid"/>:
		  </div>
					</td>				
					<td width="20%" class="<%= _class %>">	
        <input type="hidden" name="usergroupid<%= row %>" value="<%= _quoapproveLineItem.getUsergroupid() %>">					
		<strong><bean:write name="quoapproveLineItem" property="usergroupid" filter="true"/></strong>
					</td> 
					<td width="10%" class="td9" nowrap>
		  <div align="right">
		        		        <bean:message key="prompt.userid"/>:
		  </div>
					</td>							
					<td width="20%" class="<%= _class %>">
        <input type="hidden" name="userid<%= row %>" value="<%= _quoapproveLineItem.getUserid() %>">										
		<strong><bean:write name="quoapproveLineItem" property="userid" filter="true"/></strong>
					</td> 	
					<td width="10%" class="td9" nowrap>
		  <div align="right">
		        		        <bean:message key="prompt.priority"/>:
		  </div>
					</td>							
					<td width="20%" class="<%= _class %>">
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
					<td class="<%= _class %>">					 
  <select name="approveflag<%= row %>" <%= disabled %> class="forminput1">
		<option selected value=""><bean:message key="prompt.selectaapprovereject"/></option>
<%
	String s="";
	java.util.List list = null;
	list = (java.util.List)dispositions;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.system.Systemcode systemcode = 
					(com.bureaueye.beacon.model.system.Systemcode) it.next();
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
					<td  class="<%= _class %>">					 
  <select name="rejectreason<%= row %>" <%= disabled %> class="forminput1">
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
					
					<td class="<%= _class %>" nowrap>
		  <div align="right">
		        <bean:message key="prompt.notes"/>:
		  </div>					
					</td>					
					<td class="<%= _class %>">
        <input type="text" name="notes<%= row %>" <%= disabled %> value="<%= _quoapproveLineItem.getNotes() %>" size="40" class="forminput1">																						
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
 *
 * Amendments
 * ----------
 *
 * NT 2014-02-25 201400004 Add 'Switch To' Company Function (DO NOT RELEASE TO BASE AT THE MOMENT - IT DOES WORK!!!)
 *	  
-->
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->


<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="usercompanykeylist"
  class="java.util.LinkedList"
  scope="session"
/>


<!-- sheader -->
<table cellpadding="0" cellspacing="0" border="0" width="100%">	 				  
    <tr><td colspan="4"><img src="images/_line-top.gif" border="0" width="100%" height="2" align="top"/></td></tr>
	<tr><td bgcolor="#E3E6E8" width="75%"><html:link forward="mainmenu"><span class="header1"><bean:message key="heading.desktop"/></span></html:link></td>
    

<td bgcolor="#E3E6E8" width="15%" align="right">
<!--201400004--
<%	
//only available if user has multiple company facility
if (usercompanykeylist.size()>1) {
%>
<div style="text-align:left;padding:15px 0px 0px 0px;margin-left:5px;margin-right:5px;overflow:hidden;">

<form name="SwitchtocompanyForm" method="post" action="Switchtocompany.do">
<button id="switchtocompanyButton" class="btnBG2 btnFF" type="submit"><span>Switch To:</span></button>
<select name="companykey" class="forminput1">
<%				
	String s="";
	for (java.util.Iterator it = usercompanykeylist.iterator(); it.hasNext();) {
				com.bureaueye.beacon.model.standard.Company company=(com.bureaueye.beacon.model.standard.Company)it.next();
		s="";
		//focus on user current company
		if (company.getCompid().equals(user.getCompanykey())) s = "selected";
%>
		<option <%= s %> value="<%= company.getCompid() %>"><%= company.getName() %></option>
<%
	}
%>			
</select>
</form>

</div>	
<%
}
%>
-->						
</td>
        
            
    	<td bgcolor="#E3E6E8" width="5%" align="right">
    			<div class="btnPane2">	                        
				<button id="dashboardButton" class="btnBG2 btnFF" type="button" onclick="document.location.href='Dashboard.do'">
        			<span><bean:message key="button.dashboard"/></span>
        		</button>                  
                </div>  
        </td>
    	<td bgcolor="#E3E6E8" width="5%" align="right">                
     			<div class="btnPane2">	                               
				<button id="logoutButton" class="btnBG2 btnFF" type="button" onclick="document.location.href='Logoff.do'">
        			<span><bean:message key="button.logout"/></span>
        		</button>                           
				</div>   
        </td>        
    </tr>
    <tr><td colspan="4"><img src="images/_line-bottom.gif" border="0" width="100%" height="2" align="top"/></td></tr>			
</table>
<!-- eheader -->








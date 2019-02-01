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


<script language="JavaScript">

function screenRefresh() 
{
}


function buildRunatperiod2() 
{
}


</script>


<html:html>
<head>
<logic:equal name="SystemForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SystemForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SystemForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="system.title"/></strong> 
		</span>
			<span class="text6"><strong>
				<bean:message key="title.maintenance"/> 	
			</strong></span> 						
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:700px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveSystem" focus="ediid">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="systemId"/>
	
		
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="SystemForm" property="action"
            scope="request" value="Edit">
 	<bean:message key="title.edit"/>
 </logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
  	
	
	
	  
                     
<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
    
         <tr>
			<td rowspan="3">
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="30%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.ediid"/>:
		  </div>
		  </td>
          <td width="70%" class="td2">
<html:text property="ediid" size="20" maxlength="10" styleClass="ftforminputsmall"/>       
          </td>
        </tr>
         <tr>
          <td width="30%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.systemtaskstop"/>:
		  </div>
		  </td>
          <td width="70%" class="td2">
<html:text property="systemtaskstop" size="5" maxlength="1" styleClass="ftforminputsmall"/>       
          </td>
        </tr>
         <tr>
          <td width="30%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.systemtaskagentsleep"/>:
		  </div>
		  </td>
          <td width="70%" class="td2">
<html:text property="systemtaskagentsleep" size="10" maxlength="10" styleClass="ftforminputsmall"/>       
          </td>
        </tr>
                       	  											  			
    </table>
	</td>
</tr>
 


	
  
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">	  
      <logic:equal name="SystemForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="SystemForm" property="action"
                     scope="request" value="Delete">
        <html:reset styleClass="button1">
          <bean:message key="button.reset"/>
        </html:reset>
      </logic:notEqual>
      <html:cancel styleClass="button1">
        <bean:message key="button.cancel"/>
      </html:cancel>
    </td>
  </tr>	
  	  
    </table></td>
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



<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (new program) 
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


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
		}
</script>


<logic:equal name="UseraccessForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="useraccess.title.create"/></title>
</logic:equal>
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="useraccess.title.delete"/></title>
</logic:equal>
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="useraccess.title.edit"/></title>
</logic:equal>	
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="View">
  <title><bean:message key="useraccess.title.view"/></title>
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
		<strong><bean:message key="useraccess.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListUser" styleClass="link4">
				<bean:message key="user.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>		
		<span class="heading2">
			<html:link action="/ListUseraccess" styleClass="link4">
				<bean:message key="useraccess.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
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
	
		<div style="OVERFLOW:auto; width:450px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveUseraccess" focus="accessid">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="useraccessId"/>
	
		
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
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="Create">
<bean:message key="title.create"/>
</logic:equal>
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
  </logic:equal>
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="Edit">
 	<bean:message key="title.edit"/>
 </logic:equal>
<logic:equal name="UseraccessForm" property="action"
            scope="request" value="View">
 	<bean:message key="title.view"/>
 </logic:equal> 		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
  
        <logic:equal name="UseraccessForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
        <tr>
			<td rowspan="2">
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="30%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.userid"/>:
		  </div>
		  </td>
          <td width="70%" class="td2">
        <strong><html:hidden property="userid" write="true"/></strong>
          </td>
        </tr>
        <tr>
          <td class="td2">
		  <div align="right">
		        <bean:message key="prompt.accessid"/>:
		  </div>
		  </td>
          <td class="td2">
        <strong><html:hidden property="accessid" write="true"/></strong>
          </td>
        </tr>		
	</table>
	</td>
	</tr>
	</logic:equal>		
	
	
	  
        <logic:notEqual name="UseraccessForm" property="action"
                     scope="request" value="Delete"> 
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
			<td rowspan="3">
		  		<img src="images/spacer.gif" width="1" border="0"/></td>
          <td width="30%" class="td2">
		  <div align="right"><bean:message key="prompt.userid"/>:</div></td>
          <td width="70%" class="td2">
        <strong><html:hidden property="userid" write="true"/></strong>
          </td>
        </tr>
        <tr>
          <td class="td2">
		  <div align="right"><bean:message key="prompt.accessid"/>:</div></td>
          <td class="td2">
		  <c:if test="${UseraccessForm.action == 'Create'}">
<html:select property="accessid" styleClass="ftforminputsmall">
<html:option value="Address">Address</html:option>
<html:option value="Location">Location</html:option>
<html:option value="">--------</html:option>
<html:option value="Quocharge">Quocharge</html:option>
<html:option value="Quocost">Quocost</html:option>
<html:option value="Quohdr">Quohdr</html:option>
<html:option value="Quomov">Quomov</html:option>
<html:option value="Quomovcost">Quomovcost</html:option>
<html:option value="Quonote">Quonote</html:option>
<html:option value="Quoprod">Quoprod</html:option>
<html:option value="">--------</html:option>
<html:option value="Ordercharge">Ordercharge</html:option>
<html:option value="Ordercost">Ordercost</html:option>
<html:option value="Orderhdr">Orderhdr</html:option>
<html:option value="Ordermov">Ordermov</html:option>
<html:option value="Ordermovcost">Ordermovcost</html:option>
<html:option value="Ordernote">Ordernote</html:option>
<html:option value="Orderprod">Orderprod</html:option>
</html:select> 
		  </c:if>
		  <c:if test="${UseraccessForm.action != 'Create'}">
        	<html:text property="accessid" size="30" disabled="true" maxlength="40" styleClass="ftforminputsmall"/>
			<html:hidden property="accessid"/>			
		  </c:if>			
          </td>
        </tr>
        			
        <tr>   
          <td class="td2" valign="top">
		  <div align="right"><bean:message key="prompt.grantactions"/>:</div>
		  </td>	  
          <td class="td2">
<html:select property="arraygrantactionlist" multiple="true" size="10" styleClass="ftforminputsmall">
<html:option value="Copy"><bean:message key="prompt.copy"/></html:option>
<html:option value="Create"><bean:message key="prompt.create"/></html:option>
<html:option value="Edit"><bean:message key="prompt.edit"/></html:option>
<html:option value="Delete"><bean:message key="prompt.delete"/></html:option>
<html:option value="View"><bean:message key="prompt.view"/></html:option>
</html:select> 
          </td>
        </tr>					
   
          				  											  			
    </table>
	</td>
  </tr>
 
  	</logic:notEqual>
	
  
<logic:notEqual name="UseraccessForm" property="action" scope="request" value="View">   
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">
      <logic:equal name="UseraccessForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="UseraccessForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="UseraccessForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="UseraccessForm" property="action"
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
</logic:notEqual>  
  
  
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

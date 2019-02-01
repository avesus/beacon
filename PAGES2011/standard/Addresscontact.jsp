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
<logic:equal name="AddresscontactForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="AddresscontactForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="AddresscontactForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="addresscontact.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListAddress" styleClass="link4">
				<bean:message key="address.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">></span>
		<span class="heading2">
			<html:link action="/ListAddresscontact" styleClass="link4">
				<bean:message key="addresscontact.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">></span>
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
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveAddresscontact" focus="contactkey">
<html:hidden property="action"/>
<html:hidden property="addrkey"/>

<table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>	
	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td7"><span class="heading7">
<logic:equal name="AddresscontactForm" property="action"
            scope="request" value="Create">
  <bean:message key="addresscontact.title.create"/>
</logic:equal>
<logic:equal name="AddresscontactForm" property="action"
            scope="request" value="Delete">
  <bean:message key="addresscontact.title.delete"/>
</logic:equal>
<logic:equal name="AddresscontactForm" property="action"
            scope="request" value="Edit">
  <bean:message key="addresscontact.title.edit"/>
</logic:equal>		  
		  </span></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
      <logic:equal name="AddresscontactForm" property="action"
                  scope="request" value="Create">
        <html:text property="contactkey" size="10" styleClass="ftforminputsmall"/>
      </logic:equal>
      <logic:notEqual name="AddresscontactForm" property="action"
                     scope="request" value="Create">
        <strong>
		<html:hidden property="contactkey" write="true"/>
		</strong>
      </logic:notEqual>
          </td>
        </tr>
    </table></td>
  </tr>	
  
      <logic:notEqual name="AddresscontactForm" property="action"
                     scope="request" value="Delete">    					 
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">	 		
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.name"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:text property="name" size="50" styleClass="ftforminputsmall"/>
          </td>
        </tr>			
    </table></td>
  </tr>	
    
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.phone"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:text property="phone" size="50" styleClass="ftforminputsmall"/>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.email"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:text property="email" size="50" styleClass="ftforminputsmall"/>
          </td>
        </tr>						
    </table></td>
  </tr>
        </logic:notEqual>
		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td7">
      <logic:equal name="AddresscontactForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="AddresscontactForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="AddresscontactForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="AddresscontactForm" property="action"
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

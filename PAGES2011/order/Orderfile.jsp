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

<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
		}
</script>



<logic:equal name="OrderfileForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="orderfile.title.create"/></title>
</logic:equal>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="orderfile.title.delete"/></title>
</logic:equal>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="View">
  <title><bean:message key="orderfile.title.view"/></title>
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
	<td class="tdwht">
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListOrderfile"><bean:message key="orderfile.title.list"/></html:link></span>  
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="Create">
<bean:message key="orderfile.title.create"/>
</logic:equal>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="Delete">
<bean:message key="orderfile.title.delete"/>
</logic:equal>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="View">
<bean:message key="orderhdr.title.view"/>
</logic:equal>	
</span>
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveOrderfile" focus="description" enctype="multipart/form-data">
<html:hidden property="action"/>
<html:hidden property="orderfileId"/>
<html:hidden property="orderhdrId"/>
<html:hidden property="ordernoteId"/>
<html:hidden name="user" property="securitylevel"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td><span class="text2">-&nbsp;<bean:write name="message"/></span></td></tr>
</html:messages>

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="Create">
<bean:message key="orderfile.title.create"/>
</logic:equal>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="Delete">
<bean:message key="orderfile.title.delete"/>
</logic:equal>
<logic:equal name="OrderfileForm" property="action"
            scope="request" value="View">
<bean:message key="orderhdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="OrderfileForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td width="30%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.description"/>:
		  </div>
		  </td>
          <td width="70%" class="td2">
         <html:text property="description" disabled="true" size="50" maxlength="100" styleClass="ftforminputsmall"/>	  
          </td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>	
    

<logic:equal name="OrderfileForm" property="action" scope="request" value="Create">  

  <tr>
    <td valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
      <tr> 
              <td rowspan="2"><img src="images/spacer.gif" width="1" border="0"/> </td>	
          <td width="30%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.description"/>:
		  </div>
		  </td> 
          <td width="70%" class="td2">
 <html:text property="description" size="50" maxlength="100" styleClass="ftforminputsmall"/>
		  </td> 		
      </tr>					
      <tr>  
                <td width="30%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.selectadocument"/>:
		  </div>
		  </td> 
          <td class="td2" width="70%" >
		  <html:file property="infile"/>
		  </td> 		
      </tr>													
    </table>	
	</td>	
  </tr>	
  
</logic:equal>
        

		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
      <logic:equal name="OrderfileForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.store"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="OrderfileForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="OrderfileForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="OrderfileForm" property="action"
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

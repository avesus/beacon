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
  


<html:html>
<head>
<logic:equal name="EDIOutboundForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="EDIOutboundForm" property="action"
            scope="request" value="FixError">
  <title><bean:message key="title.fixerror"/></title>
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
		<strong><bean:message key="edioutbound.title.list"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListEDIOutbound" styleClass="link4">
				<bean:message key="title.list"/> 	
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
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">

<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />

	</td>--%>
	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveEDIOutbound">
<html:hidden property="action"/>



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
          <td class="td7">
		  <strong>
<logic:equal name="EDIOutboundForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.create"/> 
</logic:equal>
<logic:equal name="EDIOutboundForm" property="action"
            scope="request" value="FixError">
  <bean:message key="title.fixerror"/> 
</logic:equal>		  
		  </strong>
		  </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="systemtd2">
		  <div align="right">
		        <bean:message key="prompt.docid"/>:
		  </div>
		  </td>
          <td width="78%" class="systemtd2">
      <logic:notEqual name="EDIOutboundForm" property="action"
                     scope="request" value="Create">
        <strong><html:hidden property="edioutboundId" write="true"/></strong>
      </logic:notEqual>
          </td>
        </tr>
		
      <logic:equal name="EDIOutboundForm" property="action"
                     scope="request" value="View">		
        <tr>
          <td width="22%" class="systemtd2" valign="top">
		  <div align="right">
		        <bean:message key="prompt.document"/>:
		  </div>
		  </td>
          <td width="78%" class="systemtd2">		  
        <html:textarea property="document" cols="60" rows="15"/>
          </td>
        </tr>	
      </logic:equal>			
    </table></td>
  </tr>	
  

		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">		  
      <logic:equal name="EDIOutboundForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>		
      </logic:equal>
      <logic:equal name="EDIOutboundForm" property="action"
                  scope="request" value="FixError">
        <html:submit styleClass="button1">
          <bean:message key="button.fix"/>
        </html:submit>
      </logic:equal>			  
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

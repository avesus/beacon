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
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="JavaScript">

</script>

</head>

 
<body onUnload="if (searchWin != null) {searchWin.close()}">  

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
		<strong><bean:message key="ccyex.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListCcyex" styleClass="link4">
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
<%-- SIDEBAR -----------------%>
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>

<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:600px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveCcyex" focus="fromccykey">
<html:hidden property="action"/>
<html:hidden property="ccyexId"/>


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
          <td class="td7"><strong>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Delete">
    <bean:message key="title.delete"/>
  </logic:equal>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Edit">
    <bean:message key="title.edit"/>
  </logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
      <logic:equal name="CcyexForm" property="action"
                     scope="request" value="Delete">    		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>			
          <td width="22%" class="standardtd2">
		  <div align="right">
		        <bean:message key="prompt.fromcurrency"/>:
		  </div>
		  </td>
          <td width="78%" class="standardtd2">
		<html:select property="fromccykey" styleClass="ftforminputsmall" disabled="true">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>							  
          </td>
        </tr>
        <tr>
          <td width="22%" class="standardtd2">
		  <div align="right">
		        <bean:message key="prompt.tocurrency"/>:
		  </div>
		  </td>
          <td width="78%" class="standardtd2">
		<html:select property="toccykey" styleClass="ftforminputsmall" disabled="true">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
          </td>
        </tr>
        <tr>
          <td width="22%" class="standardtd2">
		  <div align="right">
		        <bean:message key="prompt.exchangedate"/>:
		  </div>
		  </td>
          <td width="78%" class="standardtd2">
		<html:select property="exdatedd" styleClass="ftforminputsmall" disabled="true">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exdatemm" styleClass="ftforminputsmall" disabled="true">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exdateyyyy" styleClass="ftforminputsmall" disabled="true">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
          </td>
        </tr>					
    </table></td>
  </tr>	
	</logic:equal>  
	
    
      <logic:notEqual name="CcyexForm" property="action"
                     scope="request" value="Delete">    		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>			
          <td width="22%" class="standardtd2">
		  <div align="right">
		        <bean:message key="prompt.fromcurrency"/>:
		  </div>
		  </td>
          <td width="78%" class="standardtd2">
		<html:select property="fromccykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>								  
          </td>
        </tr>
        <tr>
          <td width="22%" class="standardtd2">
		  <div align="right">
		        <bean:message key="prompt.tocurrency"/>:
		  </div>
		  </td>
          <td width="78%" class="standardtd2">
		<html:select property="toccykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
          </td>
        </tr>			
        <tr>
          <td width="22%" class="standardtd2">
		  <div align="right">
		       <bean:message key="prompt.exchangedate"/>:
		  </div>		  
		  </td>
          <td width="78%" class="standardtd2">
		<html:select property="exdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>		  	  
          </td>
        </tr>																			
        <tr>
          <td width="22%" class="standardtd2">
		  <div align="right">
		       <bean:message key="prompt.exchangerate"/>:
		  </div>		  
		  </td>
          <td width="78%" class="standardtd2">
        <html:text property="exrate" size="10" styleClass="ftforminputsmall"/>	  	  
          </td>
        </tr>													
    </table></td>
  </tr>	
		     
        </logic:notEqual>

		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">
      <logic:equal name="CcyexForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="CcyexForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="CcyexForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="CcyexForm" property="action"
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

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


<logic:equal name="ContractagentForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

	
<link rel="stylesheet" type="text/css" href="css/base.css" />


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( document.forms[0].action.value == 'View') {
			while (i < document.forms[0].elements.length) {
				document.forms[0].elements[i].disabled = true;
				i++;	
			}
			}
		}
</script>


<script language="JavaScript">
var searchWin;

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
			
</script> 


</head>


<body onUnload="if (searchWin != null) {searchWin.close();}">  

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
		<strong><bean:message key="contractagent.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListContract" styleClass="link4">
				<bean:message key="contract.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">	
			<html:link action="/ListContractagent" styleClass="link4">
				<bean:message key="contractagent.title.list"/>	
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
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveContractagent" focus="agentaddrkey">
	
<html:hidden property="contractagentId"/>
<html:hidden property="contractId"/>
<html:hidden property="action"/>
<html:hidden property="copyId"/>



<table width="60%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="ContractagentForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="ContractagentForm" property="action"
                     scope="request" value="Delete"> 
					 
<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.agent"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		<html:select property="agentaddrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaagent"/></html:option>
			<html:options collection="agents" property="addrkey" labelProperty="name"/>
		</html:select>				 
				</TD>
              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>		
  			  
</logic:equal>		


<logic:notEqual name="ContractagentForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.agent"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		  <c:if test="${ContractagentForm.action == 'Create'}">				
		<html:select property="agentaddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaagent"/></html:option>
			<html:options collection="agents" property="addrkey" labelProperty="name"/>
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('agentaddrkey','agent'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
		  </c:if>
		  <c:if test="${ContractagentForm.action != 'Create'}">
		<html:select property="agentaddrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaagent"/></html:option>
			<html:options collection="agents" property="addrkey" labelProperty="name"/>
		</html:select>		  
			<html:hidden property="agentaddrkey"/>			
		  </c:if>					 
				</TD>
              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
	

	
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="1" cellpadding="0"class="contractBgcolor">
       <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%" colspan="2">
		        &nbsp;<strong><bean:message key="prompt.details"/></strong>
		  </td>
		</tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.scheme"/>: </td>
	<td class="td9"><html:text property="scheme" size="10" maxlength="10" styleClass="ftforminputsmall"/></td>
  </tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.percentage"/>: </td>
	<td class="td9"><html:text property="percentamt" size="10" maxlength="10" styleClass="ftforminputsmall"/></td>
  </tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.lumpsum"/>: </td>
	<td class="td9"><html:text property="lumpsumamt" size="10" maxlength="10" styleClass="ftforminputsmall"/></td>
  </tr>  
            </table>
			</td>
              </tr>

  
           
 
    	
</logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">

<logic:notEqual name="ContractagentForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="ContractagentForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="ContractagentForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="ContractagentForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="ContractagentForm" property="action" scope="request" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
  
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">	  
	
	</td>
	
  </tr>	
  
</logic:notEqual> 
		  
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

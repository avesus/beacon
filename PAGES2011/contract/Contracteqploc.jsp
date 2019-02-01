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


<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="ContracteqplocForm" property="action"
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

function locationSearch(field, types){
	var location = document.forms[0].elements[field];
	var url     = 'EditLocationSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      location.options[location.selectedIndex].value;				  
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
		<strong><bean:message key="contracteqploc.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListContract" styleClass="link4">
				<bean:message key="contract.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListContracteqp" styleClass="link4">
				<bean:message key="contracteqp.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>		
		<span class="heading2">
			<html:link action="/ListContracteqploc" styleClass="link5">
				<bean:message key="contracteqploc.title.list"/> 	
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

<table border="0" cellpadding="5" cellspacing="5" width="70%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveContracteqploc" focus="locationkey">
	
<html:hidden property="contracteqpId"/>
<html:hidden property="contracteqplocId"/>
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="copyId"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

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
<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="ContracteqplocForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="ContracteqplocForm" property="action"
                     scope="request" value="Delete"> 
					 
<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.location"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		<html:select property="locationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="depots" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>			 
				</TD>
              </TR>
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		<html:select property="pudoflag" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
			<html:option value="ONHIRE"><bean:message key="prompt.onhire"/></html:option>
			<html:option value="OFFHIRE"><bean:message key="prompt.offhire"/></html:option>
		</html:select>			 
				</TD>
              </TR>			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>		
  			  
</logic:equal>		


<logic:notEqual name="ContracteqplocForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.location"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		  <c:if test="${ContracteqplocForm.action == 'Create'}">				
		<html:select property="locationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="depots" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('locationkey','depot'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
		  </c:if>
		  <c:if test="${ContracteqplocForm.action != 'Create'}">
		<html:select property="locationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="depots" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>		  
			<html:hidden property="locationkey"/>			
		  </c:if>					 
				</TD>
              </TR>
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		  <c:if test="${ContracteqplocForm.action == 'Create'}">				
		<html:select property="pudoflag" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
			<html:option value='ONHIRE'><bean:message key="prompt.onhire"/></html:option>
			<html:option value='OFFHIRE'><bean:message key="prompt.offhire"/></html:option>
		</html:select>				
		  </c:if>
		  <c:if test="${ContracteqplocForm.action != 'Create'}">
		<html:select property="pudoflag" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
			<html:option value='ONHIRE'><bean:message key="prompt.onhire"/></html:option>
			<html:option value='OFFHIRE'><bean:message key="prompt.offhire"/></html:option>
		</html:select>			  
			<html:hidden property="pudoflag"/>			
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
		  <td rowspan="3">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%" colspan="2">
		        &nbsp;<strong><bean:message key="prompt.charges"/></strong>
		  </td>
		</tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.handlingcharge"/>: </td>
	<td class="td9"><html:text property="handchg" size="10" maxlength="10" styleClass="ftforminputsmall"/></td>
  </tr>
            </table>
			</td>
              </tr>

  
  
				
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="1" cellpadding="0"class="contractBgcolor">
        <tr>				  
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%" colspan="2">
		        &nbsp;<strong><bean:message key="prompt.returnlimits"/></strong>
		  </td>		
        </tr>		  		  
  <tr>
    <td class="td9" width="20%"><bean:message key="prompt.minimumreturns"/>:</td>
    <td class="td9">
        <html:text property="minreturns" size="10" maxlength="10" styleClass="ftforminputsmall"/>  	
    </td>
  </tr>
  <tr>
    <td class="td9" width="20%"><bean:message key="prompt.monthlyreturns"/>:</td>
    <td class="td9">
        <html:text property="monthreturns" size="10" maxlength="10" styleClass="ftforminputsmall"/>  	
    </td>
  </tr>  
  <tr>
    <td class="td9" width="20%"><bean:message key="prompt.locationreturns"/>:</td>
    <td class="td9">
        <html:text property="locationreturns" size="10" maxlength="10" styleClass="ftforminputsmall"/>  	
    </td>
  </tr>   
  
  </table>
			</td>
              </tr>
 
  
  
 
    	
</logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">

<logic:notEqual name="ContracteqplocForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="ContracteqplocForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="ContracteqplocForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="ContracteqplocForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="ContracteqplocForm" property="action" scope="request" value="Delete"> 
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

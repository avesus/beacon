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



<logic:equal name="UnittestForm" property="action"
            scope="session" value="Create">
  <title>Create</title>
</logic:equal>
<logic:equal name="UnittestForm" property="action"
            scope="session" value="Delete">
  <title>Delete</title>
</logic:equal>
<logic:equal name="UnittestForm" property="action"
            scope="session" value="Edit">
  <title>Edit</title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />


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
		<strong><bean:message key="unittest.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListUnit" styleClass="link4">
				<bean:message key="unit.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListUnittest" styleClass="link4">
				<bean:message key="unittest.title.list"/> 	
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

<html:form action="/SaveUnittest" focus="testtypekey">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="unittestId"/>
<html:hidden property="unitId"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

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
<logic:equal name="UnittestForm" property="action"
            scope="session" value="Create">
<bean:message key="title.create"/>
</logic:equal>
<logic:equal name="UnittestForm" property="action"
            scope="session" value="Delete">
   <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="UnittestForm" property="action"
            scope="session" value="Edit">
   <bean:message key="title.edit"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


        <logic:equal name="UnittestForm" property="action"
                     scope="session" value="Delete">  
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>			
				        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.testtype"/>:</div></td>
          <td class="td2" width="80%">
        <strong><html:hidden property="testtypekey" write="true"/></strong>	  		
		  </td>
        </tr>	
    </table></td>
</tr>	
	</logic:equal>
	

        <logic:notEqual name="UnittestForm" property="action"
                     scope="session" value="Delete">	 
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>			
				        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.testtype"/>:</div></td>
          <td class="td2" width="80%">
      		<logic:equal name="UnittestForm" property="action"
                  scope="session" value="Create">
				<html:select property="testtypekey" styleClass="ftforminputsmall">
					<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
					<html:options collection="testtypes" property="testtypekey" labelProperty="testtypekey"/>
				</html:select>
      		</logic:equal>
      <logic:notEqual name="UnittestForm" property="action"
                     scope="session" value="Create">
        <strong><html:hidden property="testtypekey" write="true"/></strong>
      </logic:notEqual>		  		
		  </td>
        </tr>	
    </table></td>
</tr>	

 	
  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
			
        <tr>
				        <td rowspan="4"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.duedate"/>:</div></td>
          <td class="td2" width="80%">
		<html:select property="duedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="duedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="duedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>		  
		  </td>
        </tr>
        <tr>
          <td class="td2"><div align="right"><bean:message key="prompt.testdate"/>:</div></td>
          <td class="td2">
		<html:select property="compdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="compdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="compdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>		  
		  </td>
        </tr>		
                                  <tr>
            <td class="td2"><div align="right"><bean:message key="prompt.by"/>: </div></td>
            <td class="td2"><html:text property="testby" size="40" maxlength="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>	
      <tr>
          <td class="td2">
		  <div align="right">
		  <bean:message key="prompt.location"/>:
		  </div>
		  </td>
          <td class="td2">
		<html:select property="depotaddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('depotaddrkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		  
          </td>	  		
      </tr>								  			  													
    </table>
	</td>
  </tr>		
	</logic:notEqual>
	
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
      <logic:equal name="UnittestForm" property="action"
                  scope="session" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="UnittestForm" property="action"
                  scope="session" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="UnittestForm" property="action"
                  scope="session" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="UnittestForm" property="action"
                     scope="session" value="Delete">
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

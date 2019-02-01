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


<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OffhireeqpotcForm" property="action"
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
		<strong><bean:message key="offhireeqpotc.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListOffhire" styleClass="link4">
				<bean:message key="offhire.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListOffhireeqp" styleClass="link4">
				<bean:message key="offhireeqp.title.list"/>
			</html:link>
		</span>		
		<span class="text6">&gt;</span>		
		<span class="heading2">
			<html:link action="/ListOffhireeqpotc" styleClass="link5">
				<bean:message key="offhireeqpotc.title.list"/> 	
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

<html:form action="/SaveOffhireeqpotc" focus="locationkey.locationkey">
	
<html:hidden property="offhireeqpId"/>
<html:hidden property="offhireeqpotcId"/>
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
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="OffhireeqpotcForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="OffhireeqpotcForm" property="action"
                     scope="request" value="Delete"> 

  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.charge"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
<html:select property="chargekey" disabled="true" styleClass="ftforminputsmall"> 
	<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
	<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
</html:select>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	
</logic:equal>		


<logic:notEqual name="OffhireeqpotcForm" property="action"
                     scope="request" value="Delete">   
 
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.charge"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
<html:select property="chargekey" styleClass="ftforminputsmall"> 
	<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
	<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
</html:select>
          </td>
        </tr>
        <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.chgamt"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="chargeamt" size="10" maxlength="10" styleClass="ftforminputsmall"/>  
          </td>
        </tr>		
	</table>
	</td>
	</tr>
	    	
</logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">

<logic:notEqual name="OffhireeqpotcForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="OffhireeqpotcForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="OffhireeqpotcForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="OffhireeqpotcForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="OffhireeqpotcForm" property="action" scope="request" value="Delete"> 
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

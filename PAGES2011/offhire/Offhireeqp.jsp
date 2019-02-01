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


<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OffhireeqpForm" property="action"
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

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearchOffhire.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+document.forms[0].elements['offhireId'].value+
					'&id='+document.forms[0].elements[field].value;					
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=420');
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
		<strong><bean:message key="offhireeqp.title"/></strong> 
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

<html:form action="/SaveOffhireeqp">
	
<html:hidden property="offhireeqpId"/>
<html:hidden property="offhireId"/>
<html:hidden property="onhireId"/>
<html:hidden property="action"/>
<html:hidden property="copyId"/>
<html:hidden property="unitId"/>
<html:hidden property="offhiretimehh" value="00"/>
<html:hidden property="offhiretimemm" value="00"/>
<html:hidden property="offhiretimess" value="00"/>
<html:hidden property="reservetimehh" value="00"/>
<html:hidden property="reservetimemm" value="00"/>
<html:hidden property="reservetimess" value="00"/>


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
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="OffhireeqpForm" property="action"
                     scope="request" value="Delete"> 
					 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <TD class="td9" width="20%" align="right"><bean:message key="prompt.unit"/>:</TD>
          <TD class="td9" width="80%">
        	<html:text property="unitkey" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="unitkey"/>								 
			</TD>
        </tr>
    </table>
	</td>
</tr>		
  			  
</logic:equal>		


<logic:notEqual name="OffhireeqpForm" property="action"
                     scope="request" value="Delete">  
					 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <TD class="td9" width="20%" align="right"><bean:message key="prompt.unit"/>:</TD>
          <TD class="td9" width="80%">
		  <c:if test="${OffhireeqpForm.action == 'Create'}">
			<html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:link href="javascript:void(unitSearch('unitkey','ONHIRE','N','N','N'))">
				<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
			</html:link>
		  </c:if>
		  <c:if test="${OffhireeqpForm.action != 'Create'}">
        	<html:text property="unitkey" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="unitkey"/>			
		  </c:if>						 
			</TD>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.reservedate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">	
		  <c:if test="${OffhireeqpForm.action == 'Create'}">		  	  
		<html:select property="reservedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="reservedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="reservedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
		  </c:if>
		  <c:if test="${OffhireeqpForm.action != 'Create'}">  
			<bean:write name="OffhireeqpForm" property="reservedate" format="dd-MMM-yyyy" filter="true"/>
			<html:hidden property="reservedatemm"/>
			<html:hidden property="reservedatedd"/>
			<html:hidden property="reservedateyyyy"/>				
		  </c:if>		  					  		 	  
          </td>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.offhiredate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">	
		  <c:if test="${OffhireeqpForm.actualflag != 'True'}">  		  	  
		<html:select property="offhiredatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="offhiredatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="offhiredateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>&nbsp;<html:checkbox property="actualflag" />&nbsp;<bean:message key="prompt.actual"/>	
		  </c:if>
		  <c:if test="${OffhireeqpForm.actualflag == 'True'}">  
			<bean:write name="OffhireeqpForm" property="offhiredate" format="dd-MMM-yyyy" filter="true"/>
			<html:hidden property="offhiredatemm"/>
			<html:hidden property="offhiredatedd"/>
			<html:hidden property="offhiredateyyyy"/>
			<html:hidden property="actualflag"/>
			&nbsp;<img src="images/icon_tick_12_12.gif" width="12" height="12"/>&nbsp;<bean:message key="prompt.actual"/>							
		  </c:if>					  		 	  
          </td>
        </tr>
						
    </table>
	</td>
</tr>	

<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <TD class="td9" width="20%" align="right"></TD>
          <TD class="td9" width="80%">
<html:checkbox property="cleanflag" />&nbsp;<bean:message key="prompt.clean"/>&nbsp;<html:checkbox property="msdsflag" />&nbsp;<bean:message key="prompt.msds"/>							 
			</TD>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.product"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">		  
		<html:select property="productkey" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select>	  		 	  
          </td>
        </tr>
						
    </table>
	</td>
</tr>	
    	
</logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">

<logic:notEqual name="OffhireeqpForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="OffhireeqpForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="OffhireeqpForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="OffhireeqpForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="OffhireeqpForm" property="action" scope="request" value="Delete"> 
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

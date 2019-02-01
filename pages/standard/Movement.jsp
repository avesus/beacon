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



<logic:equal name="MovementForm" property="action"
            scope="session" value="Create">
  <title>Create</title>
</logic:equal>
<logic:equal name="MovementForm" property="action"
            scope="session" value="Delete">
  <title>Delete</title>
</logic:equal>
<logic:equal name="MovementForm" property="action"
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
		<strong><bean:message key="movement.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListUnit" styleClass="link4">
				<bean:message key="unit.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListMovement" styleClass="link4">
				<bean:message key="movement.title.list"/> 	
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

<html:form action="/SaveMovement" focus="movedatedd">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="movementId"/>
<html:hidden property="unitId"/>
<html:hidden property="onhireeqpId" value="0"/>
<html:hidden property="offhireeqpId" value="0"/>
<html:hidden property="movetimehh" value="00"/>
<html:hidden property="movetimemm" value="00"/>
<html:hidden property="movetimess" value="00"/>


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
<logic:equal name="MovementForm" property="action"
            scope="session" value="Create">
<bean:message key="title.create"/>
</logic:equal>
<logic:equal name="MovementForm" property="action"
            scope="session" value="Delete">
   <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="MovementForm" property="action"
            scope="session" value="Edit">
   <bean:message key="title.edit"/>
</logic:equal>		  
<logic:equal name="MovementForm" property="action"
            scope="session" value="View">
<bean:message key="title.view"/>
</logic:equal>
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


        <logic:equal name="MovementForm" property="action"
                     scope="session" value="Delete">  
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>			
				        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.movementdate"/>:</div></td>
          <td class="td2" width="80%">
		<html:select property="movedatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="movedatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="movedateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  		
		  </td>
        </tr>	
    </table></td>
</tr>	
	</logic:equal>
	

        <logic:notEqual name="MovementForm" property="action"
                     scope="session" value="Delete">	 
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>			
				        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.movementdate"/>:</div></td>
          <td class="td2" width="80%">
		  
      		<logic:equal name="MovementForm" property="action"
                  scope="session" value="Create">
		<html:select property="movedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="movedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="movedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
      		</logic:equal>
			
      <logic:notEqual name="MovementForm" property="action"
                     scope="session" value="Create">
		<html:select property="movedatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="movedatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="movedateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  
      </logic:notEqual>
	  		  		
		  </td>
        </tr>	
    </table></td>
</tr>	

 	
  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
			
        <tr>
				        <td rowspan="5"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.movementstatus"/>:</div></td>
          <td class="td2" width="80%">
		<html:select property="movests" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="movestatuss" property="id.codekey" labelProperty="descr"/>	
		</html:select>	 
		  </td>
        </tr>
        <tr>
          <td class="td2"><div align="right"><bean:message key="prompt.movementlocation"/>:</div></td>
          <td class="td2">
	<c:if test="${MovementForm.action == 'Create'}">			  
		<html:select property="movelocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('movelocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>  
	</c:if>
	<c:if test="${MovementForm.action != 'Create'}">  
		<html:select property="movelocationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>
			<html:hidden property="movelocationkey"/>				
	</c:if>			
		  </td>
        </tr>
				
        <tr>
            <td class="td2"><div align="right"><bean:message key="prompt.movementref"/>: </div></td>
            <td class="td2">
	<c:if test="${MovementForm.action == 'Create'}">				
			<html:text property="moveref" size="40" maxlength="50" styleClass="ftforminputsmall"/>
	</c:if>	
	<c:if test="${MovementForm.action != 'Create'}">  
			<bean:write name="MovementForm" property="moveref" filter="true"/>
			<html:hidden property="moveref"/>				
	</c:if>				 
			</td>
        </tr>
			
      	<tr>
          <td class="td2">
		  <div align="right">
		  <bean:message key="prompt.product"/>:
		  </div>
		  </td>
          <td class="td2">
	<c:if test="${MovementForm.action == 'Create'}">		  
		<html:select property="moveproductkey" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
			<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select>
	</c:if>			
	<c:if test="${MovementForm.action != 'Create'}">  
		<html:select property="moveproductkey" disabled="true" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
			<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select>
		<html:hidden property="moveproductkey"/>				
	</c:if>			 		  
          </td>	  		
      	</tr>

      	<tr>
          <td class="td2">
		  <div align="right">
		  <bean:message key="prompt.inventorystatus"/>:
		  </div>
		  </td>
          <td class="td2">
	<c:if test="${MovementForm.action == 'Create'}">		  
		<html:select property="invsts" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option> 
			<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select> 
	</c:if>			
	<c:if test="${MovementForm.action != 'Create'}">  
		<html:select property="invsts" disabled="true" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option> 
			<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select>
		<html:hidden property="invsts"/>				
	</c:if>					  
          </td>	  		
      	</tr>
			
															  			  													
    </table>
	</td>
  </tr>		

  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
			
      <tr>
        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
        <td width="20%" class="td2" colspan="2">&nbsp;<strong><bean:message key="prompt.notes"/></strong> </td>
      </tr>
      <tr>
        <td colspan="2" class="td2" width="100%">
		<html:textarea rows="5" cols="110"  property="notes" styleClass="ftforminputsmall"/>
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
      <logic:equal name="MovementForm" property="action"
                  scope="session" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="MovementForm" property="action"
                  scope="session" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="MovementForm" property="action"
                  scope="session" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="MovementForm" property="action"
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

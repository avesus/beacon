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


<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

	
<link rel="stylesheet" type="text/css" href="css/base.css" />


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( document.forms[0].actionX.value == 'View') {
			while (i < document.forms[0].elements.length) {
				document.forms[0].elements[i].disabled = true;
				i++;	
			}
			}
		}
</script>


<script type="text/javascript" language="javascript">
	function swapAction(control) {
		//formAction = document.getElementById("mainForm").action;
		if (control=='shipment')
			newAction = '<html:rewrite page="/EditPodtlrcvd1.do"/>';
		else
			newAction = '<html:rewrite page="/EditPodtlrcvd2.do"/>';
		document.getElementById("mainForm").action = newAction;	
		//form.submit();
		document.getElementById("mainForm").submit();
		//alert(newAction);
	}
</script>

<script language="JavaScript">
var searchWin;

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearch.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+
					'&id='+document.forms[0].elements[field].value;					
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
	<td class="tdwht">
	<span class="heading2"><strong><bean:message key="podtlrcvd.title"/></strong></span>
	<span class="heading2"><html:link action="/ListPohdr" styleClass="link4"><bean:message key="pohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListPodtl" styleClass="link4"><bean:message key="podtl.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListPodtlrcvd" styleClass="link4"><bean:message key="podtlrcvd.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="text6"><strong><bean:message key="title.maintenance"/></strong></span>
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

<table border="0" cellpadding="5" cellspacing="5" width="90%" bgcolor="#ffffff">

<tr>
	<td>			
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>
	</td>
</tr> 

			               	
<tr><td>

<html:errors/>

<html:form styleId="mainForm" action="/SavePodtlrcvd2" focus="qtytogenerate">
	
<html:hidden property="podtlrcvdId"/>
<html:hidden property="podtlId"/>
<html:hidden property="actionX"/>
<html:hidden property="copyId"/>



  <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#eeeeee">	
  

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">

		<tr>
			<td class="td9">
<a href="#" onClick="swapAction('shipment');"><img src="images/shipment.gif" border="0" height="20" width="82"/></a>			
<a href="#" onClick="swapAction('generate');"><img src="images/generate.gif" border="0" height="20" width="82"/></a>
			</td>
  		</tr>
		
  <tr>
	<td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
	<td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
		<tr>
		  <td class="td11"><strong>
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="Podtlrcvd2Form" property="actionX"
			scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
		</tr>
	</table>
	</td>
  </tr>
	



<tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  	
			  <tr> 
	<td>
		<img src="images/spacer.gif" width="1" border="0"/>
	</td>			  
				<TD class="td9" width="20%" align="right"><bean:message key="prompt.shipmentno"/>:</TD>
				<TD class="td9" width="80%">			  
				<html:text property="shipmentno" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				<html:hidden property="shipmentno"/>	
			</TD> 
		</tr>	  								
	</table>
	</td>
  </tr>
  

   <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
		<tr>
	<td rowspan="6">
		<img src="images/spacer.gif" height="80" width="1" border="0"/>
	</td>		
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.qtytogenerate"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="qtytogenerate" size="10" maxlength="10" styleClass="ftforminputsmall"/>    							
		  </td>	    
		</tr>	
		<tr>		
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.unitstartprefix"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="unitkeyprefix" size="10" maxlength="10" styleClass="ftforminputsmall"/>    							
		  </td>	    
		</tr>	
		<tr>		
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.unitstartsuffix"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="unitkeysuffix" size="10" maxlength="10" styleClass="ftforminputsmall"/>    							
		  </td>	    
		</tr>		
		<tr>		
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.unitnumbertemplate"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="unitkey" size="20" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="unitId"/>		
		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,EMPTY,AVA','N','N','N'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>							    							
		  </td>	    
		</tr>
		
					  																									
	</table>
	</td>
  </tr>	
  	
		  
  <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">

<logic:notEqual name="Podtlrcvd2Form" property="actionX" scope="request" value="View"> 

		<tr>
				  <td class="td11"> 

<logic:equal name="Podtlrcvd2Form" property="actionX"
				  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.generate"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="Podtlrcvd2Form" property="actionX" scope="request" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
  
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">	  
	
	</td>
	
  </tr>	
  
</logic:notEqual> 
		  
	</table></td>
  </tr>
  
  
     <tr>
	<td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
		<tr>
	<td rowspan="2">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.quantitygenerated"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="qtygenerated" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>
			<html:hidden property="qtygenerated"/>    							
		  </td>	    
		</tr>	
		<tr>	
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.quantityreceived"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="qtyrcvd" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>  
			<html:hidden property="qtyrcvd"/>			  							
		  </td>	    
		</tr>	
	</table>
	</td>
  </tr>
  										
										

     <tr> 
	<td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor"> 		
		<!-- units generated -->
				<tr>
                    <td>
						<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderResultsBgcolor">
                            <tr>														
<td class="purchaseorderResultsHeader" width="14%"><bean:message key="heading.unit"/></td>							
<td class="purchaseorderResultsHeader" width="11%"><bean:message key="heading.movementstatus"/></td>
<td class="purchaseorderResultsHeader" width="45%"><bean:message key="heading.movelocation"/></td>					
<td class="purchaseorderResultsHeader" width="30%"><bean:message key="heading.equipmentparameters"/></td>
							</tr>
							
			<c:forEach var="lineItem" items="${Podtlrcvd2Form.lineItems_}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>

                            <tr> <span class="text2">	
					<td class='<c:out value="${_class}"/>' width="14%">
						<c:out value="${lineItem.unitkey}"/>					
					</td> 												
					<td class='<c:out value="${_class}"/>' width="11%">
						<c:out value="${lineItem.movests}"/>				
					</td> 
					<td class='<c:out value="${_class}"/>' width="45%">
						<c:out value="${lineItem.movelocationkey.locationName}"/>				
					</td>
					<td class='<c:out value="${_class}"/>' width="30%">
						<c:out value="${lineItem.eqpkeyp1}"/>&nbsp;/&nbsp;
						<c:out value="${lineItem.eqpkeyp2}"/>				
					</td>										
                              </span> </tr>
							  						  
				<tr><td colspan="4" background="images/border_dotted.gif"></td></tr>
							
			</c:forEach>	
                          </table>
					</td>
                </tr>					  																								
	</table>
	</td>
  </tr>
  	
  
  
</table>

</td></tr></table>
</td></tr>

</table>


</table>
</td>
</tr>

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

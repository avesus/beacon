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


<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="Podtlrcvd1Form" property="actionX"
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

<html:form styleId="mainForm" action="/SavePodtlrcvd1" focus="shipmentno">
	
<html:hidden property="podtlrcvdId"/>
<html:hidden property="podtlId"/>
<html:hidden property="actionX"/>
<html:hidden property="copyId"/>



  <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#eeeeee">	
  

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">

	<c:if test="${Podtlrcvd1Form.actionX == 'Edit'}">	
		<tr>
			<td class="td9">		
<a href="#" onClick="swapAction('shipment');"><img src="images/shipment.gif" border="0" height="20" width="82"/></a>				
<a href="#" onClick="swapAction('generate');"><img src="images/generate.gif" border="0" height="20" width="82"/></a>

			</td>
  		</tr>
	</c:if>
					
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
<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="Podtlrcvd1Form" property="actionX"
			scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
		</tr>
	</table>
	</td>
  </tr>


<logic:equal name="Podtlrcvd1Form" property="actionX"
					 scope="request" value="Delete"> 

<tr>
	<td colspan="2">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
		<tr>
		  <td><img src="images/spacer.gif" width="1" border="0"/></td>  
				<TD class="td9" width="20%" align="right"><bean:message key="prompt.shipmentno"/>:</TD>
				<TD class="td9" width="80%">		  
				<html:text property="shipmentno" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>					
		  </td>  
		</tr>	 								
	</table>
	</td>
  </tr>	
					 
			  
</logic:equal>		


<logic:notEqual name="Podtlrcvd1Form" property="actionX"
					 scope="request" value="Delete">  


<tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  	
			  <tr> 
	<td>
		<img src="images/spacer.gif" width="1" border="0"/>
	</td>			  
				<TD class="td9" width="20%" align="right"><bean:message key="prompt.shipmentno"/>:</TD>
				<TD class="td9" width="80%">
			<c:if test="${Podtlrcvd1Form.actionX == 'Create'}">			  
				<html:text property="shipmentno" size="10" maxlength="10" styleClass="ftforminputsmall"/>	
			</c:if>		
			<c:if test="${Podtlrcvd1Form.actionX != 'Create'}">			  
				<html:text property="shipmentno" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				<html:hidden property="shipmentno"/>	
			</c:if>
			</TD> 
		</tr>	  								
	</table>
	</td>
  </tr>
  
	
	
   <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
		<tr>
	<td rowspan="3">
		<img src="images/spacer.gif" height="60" width="1" border="0"/>
	</td>		
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.quantityreceived"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="qtyrcvd" size="10" maxlength="10" styleClass="ftforminputsmall"/>  
		  </td>	  
		</tr>		
		<tr>
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.datereceived"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
		<html:select property="rcvddatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="rcvddatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="rcvddateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  				  							
		  </td>	    
		</tr>
		<tr>
		  <td width="20%" class="td9">
		  <div align="right">
				<bean:message key="prompt.quantitygenerated"/>:
		  </div>
		  </td>
		  <td width="80%" class="td9">
			<html:text property="qtygenerated" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>    							
		  </td>	    
		</tr>																					
	</table>
	</td>
  </tr>	
  
		
</logic:notEqual>
		  

		
		  
  <tr>
	<td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">

<logic:notEqual name="Podtlrcvd1Form" property="actionX" scope="request" value="View"> 

		<tr>
				  <td class="td11">

<logic:equal name="Podtlrcvd1Form" property="actionX" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="Podtlrcvd1Form" property="actionX"
				  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="Podtlrcvd1Form" property="actionX"
				  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="Podtlrcvd1Form" property="actionX" scope="request" value="Delete"> 
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
 *
 * Amendments
 * ----------
 *
 *	NT	2009-09-14		200900037			Add 'Valid From' Date
 *   												
 *
-->

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
  
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->

<%if (session == null || session.getAttribute(Constants.USER_KEY) == null) { %>
<html:html>
<head>
<title>Tariff Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="JavaScript">
	window.opener.location.href = "<html:rewrite forward='welcome'/>";
	window.opener.focus();
</script>
</head>
<body/>
</html:html>
<%} else { %>

<html:html>
<head>
<title>Tariff Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="JavaScript">
function setTariff(params)	{
	if (params != "") {	
		var paramsArray=params.split("|");	
		window.opener.document.forms[0].vendtarfhdrId.value = paramsArray[0];
		window.opener.document.forms[0].rate.value = paramsArray[1];
		window.opener.document.forms[0].cstamt.value = paramsArray[2];
		window.opener.document.forms[0].txt.value = paramsArray[4];
		if (window.opener.document.forms[0].costtype.value = "LUMPSUM") window.opener.document.forms[0].units.value = "1.0";
		if (window.opener.document.forms[0].costtype.value = "PTOP") window.opener.document.forms[0].units.value = "1.0";		
	}		
	window.close();
	window.opener.focus();
}
</script>
</head>

<body> 
<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_vendortariff_search.png" alt="Search" border="0" align="middle"/><span class="heading9">Tariff Search Results</span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
   <tr><td colspan="2">&nbsp;</td></tr>
   
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td>
   <html:button styleClass="button1" onclick="history.back()" property="ignore">
      Back
   </html:button>									
									<html:button styleClass="button1" onclick="window.close();window.opener.focus()" property="ignore"> 
									<bean:message key="button.cancel"/> 
									</html:button> 
									</td>
                                  </tr>
                                </table></td>
                            </tr>
							  
<tr>
	<td>

<html:form action="/ListJobVendortariffSearch">
<html:hidden property="gotoPage" />
<html:hidden property="maxResults" />
	
		<div style="OVERFLOW:auto; width:1000px; height:450px;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>



<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">
	<bean:message key="prompt.sortby"/>:&nbsp;<strong>Vendor</strong>
	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
               <img src="images/spacer.gif" width="1" height="13" border="0"/>
	</td>
  </tr> 
</table>
	</td>
  </tr> 
</table>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
		  			<td width="3%" class="tddkgry">
					<span class="heading4">
		  			</span>	
					</td>				
		  			<td width="10%" class="tddkgry">
					<span class="heading4">
						Vendor
		  			</span>	
					</td>	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Cost</span>
					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">From Location</span>
					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Transhipment Location</span>
					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">To Location</span>
					</td>	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Product</span>
					</td>							
		  			<td class="tddkgry" width="4%">
					<span class="heading4">Ccy</span>
					</td>
                    
                    <td class="tddkgry" width="10%">
					<span class="heading4"><bean:message key="heading.validfrom"/></span><!--200900037-->
					</td>
                                       
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Expires</span>
					</td>			
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="UNIT">	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">From Value</span>
					</td>			
		  			<td class="tddkgry" width="10%">
					<span class="heading4">To Value</span>
					</td>												
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Unit Rate</span>
					</td>
</logic:equal>	
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="DISTANCE">	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">From Value</span>
					</td>			
		  			<td class="tddkgry" width="10%">
					<span class="heading4">To Value</span>
					</td>												
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Unit Rate</span>
					</td>
</logic:equal>		
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="LUMPSUM">					
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Lump Sum</span>
					</td>																																									
</logic:equal>		
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="PTOP">					
		  			<td class="tddkgry" width="10%">
					<span class="heading4">Lump Sum</span>
					</td>																																									
</logic:equal>				
				</tr>
<%
int row=0;
%>					
			<logic:iterate id="vendortariffsearchLineItem" name="ListVendortariffSearchForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>			
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="3%">
						<html:radio property="searchString15" idName="vendortariffsearchLineItem" value="returnParams" onclick="setTariff(this.value)"/>
					</td> 						
					<td class="<%= _class %>" width="10%">						
						<bean:write name="vendortariffsearchLineItem" property="vendoraddrkey.name" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="costkey.descr" filter="true"/>																	
					</td> 
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="fromlocationkey.locationName" filter="true"/>																	
					</td> 
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="tslocationkey.locationName" filter="true"/>																	
					</td> 															
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="tolocationkey.locationName" filter="true"/>																	
					</td> 	
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="productkey" filter="true"/>																	
					</td> 														 
					<td class="<%= _class %>" width="4%">
						<bean:write name="vendortariffsearchLineItem" property="ccykey" filter="true"/>																	
					</td>
                    
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="validfrom" format="dd-MMM-yyyy" filter="true"/><!--200900037-->
					</td> 
                                         
					<td class="<%= _class %>" width="10%">
						<bean:write name="vendortariffsearchLineItem" property="validto" format="dd-MMM-yyyy" filter="true"/>																	
					</td> 
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="UNIT">	
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="fromvalue" filter="true"/>					
					</td>
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="tovalue" filter="true"/>					
					</td>							
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="unitrate" filter="true"/>					
					</td>
</logic:equal>
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="DISTANCE">	
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="fromvalue" filter="true"/>					
					</td>
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="tovalue" filter="true"/>					
					</td>							
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="unitrate" filter="true"/>					
					</td>
</logic:equal>		
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="LUMPSUM">			
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="lumpsum" filter="true"/>					
					</td>					 																				
</logic:equal>
<logic:equal name="ListVendortariffSearchForm" property="searchString9"
			scope="session" value="PTOP">			
					<td class="<%= _class %>" width="10%" align="right">
<bean:write name="vendortariffsearchLineItem" property="lumpsum" filter="true"/>					
					</td>					 																				
</logic:equal>					
				</span>
  				</tr>				
			</logic:iterate>
			
			</table>
		</td>
	</tr>
</table>
</td>
</tr>

</table>


</td>
</tr>
</table>

</div>

</html:form>

</td>
</tr>



</table>

</body>
</html:html>
<%} %>
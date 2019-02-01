<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 *
 *	NT	2009-10-20		200900049				Add 'View' functionality
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
  
<app:checkLogon/>


<html:html>
<head>


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View'
			) {
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

function locationSearch(field, types){
	var location = document.forms[0].elements[field];
	var url     = 'EditLocationSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      location.options[location.selectedIndex].value;					  
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}

</script>


<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />


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
		<strong><bean:message key="customertariffhdr.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListCustomertariffhdr" styleClass="link4">
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
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
	<td>
	
		<div style="OVERFLOW:auto; width:800px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveCustomertariffhdr" focus="custtarfhdrId">
<html:hidden property="action"/>


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
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="customertariffhdr.title.create"/>
</logic:equal>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="customertariffhdr.title.delete"/>
</logic:equal>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="customertariffhdr.title.edit"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Create">
        <html:text property="custtarfhdrId" size="15" maxlength="10" styleClass="ftforminputsmall"/>
</logic:equal>		  				  
<logic:notEqual name="CustomertariffhdrForm" property="action"
            scope="request" value="Create">
<strong><html:hidden property="custtarfhdrId" write="true"/></strong>
</logic:notEqual>		
          </td>
        </tr>	
    </table></td>
  </tr>
  
      <logic:notEqual name="CustomertariffhdrForm" property="action"
                     scope="request" value="Delete">   
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.customer"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="customeraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('customeraddrkey','CUSTOMER'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>					  
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.charge"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="chargekey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacharge"/></html:option>
			<html:options collection="charges" property="chargekey" labelProperty="ldesc"/>	
		</html:select>
          </td>
        </tr>			
    </table></td>
  </tr>	
   
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.plantloading"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="fromlocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="plants" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('fromlocationkey','PLANT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.portloading"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="fromlocationkey2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('fromlocationkey2','PORT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
          </td>
        </tr>				
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.portdischarge"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="tolocationkey2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('tolocationkey2','PORT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
          </td>
        </tr>			
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.plantdischarge"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="tolocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="plants" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('tolocationkey','PLANT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
          </td>
        </tr>						
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.product"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="productkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option>
			<html:options collection="products" property="productkey" labelProperty="tradname"/>	
		</html:select>
          </td>
        </tr>				
    </table></td>
  </tr>	
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  																							
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  																	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.ccy"/>:
		  </div>		  
		  </td>
          <td width="78%" class="td2">
		<html:select property="ccykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  																	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.lumpsum"/>:
		  </div>		  
		  </td>
          <td width="78%" class="td2">
        <html:text property="lumpsum" size="15" styleClass="ftforminputsmall"/>
          </td>
        </tr>
    </table></td>
  </tr>  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  					
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.validto"/>:
		  </div>		  
		  </td>
          <td width="78%" class="td2">
		<html:select property="validtodd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="validtomm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="validtoyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>		  	  
          </td>
        </tr>													
    </table></td>
  </tr>		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.unittype"/>:
		  </div>		  
		  </td>
          <td width="78%" class="td2">
        <html:text property="unittype" size="15" styleClass="ftforminputsmall"/>		
          </td>
        </tr>													
    </table></td>
  </tr>		     
        </logic:notEqual>
		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
    
<logic:notEqual name="CustomertariffhdrForm" property="action" scope="request" value="View"> 

        <tr>
          <td class="td1">
		  
<logic:equal name="CustomertariffhdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="CustomertariffhdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="CustomertariffhdrForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="CustomertariffhdrForm" property="action" scope="request" value="Delete"> 
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

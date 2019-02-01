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

<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
		}
</script>



<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/RefreshOrderCcyex.js"></script>


<script language="JavaScript">
var searchWin;
var typeValue = "UNIT";

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}

function tariffSearch(){
document.forms[0].custtarfhdrId.value = "";
document.forms[0].units.value = "1.0";
document.forms[0].rate.value = "0.0";
document.forms[0].chgamt.value = "0.0";
	var addrkey = document.forms[0].elements['customeraddrkey'];
	var chargekey = document.forms[0].elements['chargekey'];
	var ccykey = document.forms[0].elements['ccykey'];	
	setTypeValue();		
	var url     = 'EditOrderCustomertariffSearch.do?maxResults=999'+
						'&searchString1='+
                      	addrkey.options[addrkey.selectedIndex].value+ 
					  	'&searchString2='+ 
					  	chargekey.options[chargekey.selectedIndex].value+
					  	'&searchString8='+ 
					  	ccykey.options[ccykey.selectedIndex].value+
						'&searchString9='+
                      	document.forms[0].orderhdrId.value+
					  	'&searchString10='+
						typeValue+ 
					  	'&searchString11='+ 
					  	document.forms[0].units.value						
						;																
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=1050,height=600');
	searchWin.focus();
}

function setTypeValue()
{
for (var i=0; i < document.forms[0].chargetype.length; i++)
   {
   if (document.forms[0].chargetype[i].checked)
      {
      typeValue = document.forms[0].chargetype[i].value;
      }
   }
}


function amtCalc() 
{
	var _units = parseFloat(document.forms[0].units.value);
	if (_units == 0) _units = 1.00;
	var _rate = parseFloat(document.forms[0].rate.value);

	document.forms[0].chgamt.value = (_units*_rate);
}


</script>



<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="ordercharge.title.create"/></title>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="ordercharge.title.delete"/></title>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="ordercharge.title.edit"/></title>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="View">
  <title><bean:message key="ordercharge.title.view"/></title>
</logic:equal> 

	
<link rel="stylesheet" type="text/css" href="css/base.css" />


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

	<td class="tdwht">
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListOrdercharge"><bean:message key="ordercharge.title.list"/></html:link></span>  
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Create">
  <bean:message key="ordercharge.title.create"/>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Delete">
  <bean:message key="ordercharge.title.delete"/>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Edit">
  <bean:message key="ordercharge.title.edit"/>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="View">
  <bean:message key="ordercharge.title.view"/>
</logic:equal>  
</span>
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>

	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveOrdercharge" focus="customeraddrkey.addrkey" onsubmit="return amtCalc();">
<html:hidden property="action"/>	
<html:hidden property="orderchargeId"/>
<html:hidden property="ordermovId" value="0"/>
<html:hidden property="orderhdrId"/>
<html:hidden property="custtarfhdrId"/>
<html:hidden property="invoicestatus"/>
<html:hidden property="baseccykey"/>
<html:hidden name="user" property="securitylevel"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td>
<span class="text2">
-&nbsp;<c:out value="${message}"/>
</span>
</td></tr>
</html:messages>

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Create">
  <bean:message key="ordercharge.title.create"/>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Delete">
  <bean:message key="ordercharge.title.delete"/>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Edit">
  <bean:message key="ordercharge.title.edit"/>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="View">
  <bean:message key="ordercharge.title.view"/>
</logic:equal> 	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="OrderchargeForm" property="action"
                     scope="session" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Billing Account:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="customeraddrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>			  
          </td>	  
        <td width="10%" class="td2"><div align="right"> Charge: </div></td>
        <td width="40%" class="td2">
		<html:select property="chargekey" disabled="true" styleClass="ftforminputsmall"> <html:option value="">- select a Charge -</html:option> <html:options collection="charges" property="chargekey" labelProperty="ldesc"/> </html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="OrderchargeForm" property="action"
                     scope="session" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Billing Account:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="customeraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('customeraddrkey','CUSTOMER'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			  
          </td>	  
        <td width="10%" class="td2"><div align="right"> Charge: </div></td>
        <td width="40%" class="td2">
		<html:select property="chargekey" styleClass="ftforminputsmall"> 
		<html:option value="">- select a Charge -</html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>	
	
  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td>
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td2">
		  <div align="right">
		        Charge Type </div>
		  </td>
          <td width="80%" class="td2">		
		<span class="ftformradiosmall2">
<html:radio property="chargetype" value="UNIT"/>Unit
<html:radio property="chargetype" value="LUMPSUM"/>Lump Sum
<html:radio property="chargetype" value="PTOP"/>Point-to-Point
<html:radio property="chargetype" value="DISTANCE"/>Distance
		</span>		  							  
          </td>  
        </tr>
    </table>
	</td>
  </tr>	
  
    	
  <tr>
    <td width="100%" valign="top" colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong>Invoice</strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       Charge Currency:
		  </div>
		  </td>
          <td width="30%" class="td2">
									<html:select property="ccykey" 
											styleClass="ftforminputsmall"
											onchange="processRefreshCcyex('xratebase');processRefreshCcyex('xrateinv');"> 									
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>
		  </td>
          <td width="20%" class="td2">
		  <div align="right">
		       Invoice Currency:
		  </div>
		  </td>
          <td width="30%" class="td2">
									<html:select property="invoiceccykey" 
											styleClass="ftforminputsmall"
											onchange="processRefreshCcyex('xrateinv');"> 
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>
		  </td>		  
		</tr>	  				
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       Exchange Rate to Base:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="xratebase" size="20"  maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>
          <td width="20%" class="td2">
		  <div align="right">
		       Exchange Rate to Invoice:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="xrateinv" size="20"  maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>
          </tr>	

        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.invoicestatus"/>:
		  </div>
		  </td>
          <td width="80%" class="td9" colspan="3">
                      <c:if test="${OrderchargeForm.invoicestatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${OrderchargeForm.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${OrderchargeForm.invoicestatus == 'PRINTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${OrderchargeForm.invoicestatus}"/>'/>
                      </c:if>	
                      <c:if test="${OrderchargeForm.invoicestatus == 'CREATED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${OrderchargeForm.invoicestatus}"/>'/>
                      </c:if>			  
        <bean:write name="OrderchargeForm" property="invoicestatus" scope="session"/>			  
		  </td>
          </tr>	
		  		  										
    </table>
	</td>
  </tr>		
    
  <tr>
    <td width="100%" valign="top" colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="6">
		  <strong>Tariff Details</strong>
		  </td>
		</tr>
			
        <tr>
          <td width="15%" class="td2">
		  <div align="right">
		       No of Units:
		  </div>
		  </td>
          <td width="20%" class="td2">
        <html:text property="units" size="20" onblur="amtCalc()" maxlength="20" styleClass="ftforminputsmall"/>&nbsp;
		<html:link href="javascript:void(tariffSearch())">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Tariff Search" border="0" align="middle"/>
		</html:link>					  
		  </td>
          <td width="15%" class="td2">
		  <div align="right">
		       Unit Name:
		  </div>
		  </td>
          <td width="15%" class="td2">
        <html:text property="uname" size="20"  maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>	
          <td width="15%" class="td2">
		  <div align="right">
		       Unit Rate:
		  </div>
		  </td>
          <td width="20%" class="td2">
        <html:text property="rate" size="20" maxlength="20" onblur="amtCalc()" styleClass="ftforminputsmall"/>			  
		  </td>			  	  
		</tr>
			  								
        <tr>
          <td width="15%" class="td2">
		  <div align="right">
		       Charge Amount:
		  </div>
		  </td>
          <td width="20%" class="td2">
        <html:text property="chgamt" size="20" maxlength="20" readonly="true" styleClass="ftforminputsmall"/>			  	
		  </td>
          <td width="15%" class="td2">
		  <div align="right">
		       Tax code:
		  </div>
		  </td>
          <td width="15%" class="td2" colspan="3">
		<html:select property="taxcode" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectataxcode"/></html:option>		
			<html:options collection="taxcodes" property="taxcodekey" labelProperty="descr"/>	
		</html:select>
		  </td>		  	  
		</tr>	  																
    </table>
	</td>
  </tr>

  <tr>
    <td width="100%" valign="top" colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="6">
		  <strong>Notes</strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td2">
        <html:text property="txt1" size="120" styleClass="ftforminputsmall"/>	
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

<logic:equal name="OrderchargeForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="OrderchargeForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="OrderchargeForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="OrderchargeForm" property="action" scope="session" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
 
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">

	  
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

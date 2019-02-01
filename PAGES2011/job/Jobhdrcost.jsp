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

<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="jobcost.title.create"/></title>
</logic:equal>
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="jobcost.title.delete"/></title>
</logic:equal>
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="jobcost.title.edit"/></title>
</logic:equal>	
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="View">
  <title><bean:message key="jobcost.title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/RefreshCcyex.js"></script>


<script language="JavaScript">
var searchWin;
var costtypeValue = "UNIT";

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}

function tariffSearch(){
document.forms[0].vendtarfhdrId.value = "";
document.forms[0].units.value = "1.0";
document.forms[0].rate.value = "0.0";
document.forms[0].cstamt.value = "0.0";
	var addrkey = document.forms[0].elements['vendoraddrkey'];
	var costkey = document.forms[0].elements['costkey'];
	var ccykey = document.forms[0].elements['ccykey'];	
	setCosttypeValue();			
	var url     = 'EditJobVendortariffSearch.do?maxResults=999'+
						'&searchString1='+
                      	addrkey.options[addrkey.selectedIndex].value+ 
					  	'&searchString2='+ 
					  	costkey.options[costkey.selectedIndex].value+
					  	'&searchString7='+ 
					  	ccykey.options[ccykey.selectedIndex].value+
						'&searchString8='+
                      	document.forms[0].jobmovId.value+
					  	'&searchString9='+
						costtypeValue+ 
					  	'&searchString10='+ 
					  	document.forms[0].units.value+
					  	'&searchString11='+ 
					  	document.forms[0].jobhdrId.value													
						;																	
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=1050,height=600');
	searchWin.focus();
}

function setCosttypeValue()
{
for (var i=0; i < document.forms[0].costtype.length; i++)
   {
   if (document.forms[0].costtype[i].checked)
      {
      costtypeValue = document.forms[0].costtype[i].value;
      }
   }
}


function amtCalc() 
{
	var _units = parseFloat(document.forms[0].units.value);
	if (_units == 0) _units = 1.00;
	var _rate = parseFloat(document.forms[0].rate.value);

	document.forms[0].cstamt.value = (_units*_rate);
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
	<td class="tdwht">
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListJobhdr"><bean:message key="jobhdr.title.list"/></html:link></span> 
	<span class="text6">&gt;</span>  
	<span class="heading2"><html:link action="/ListJobhdrcost"><bean:message key="jobcost.title.list"/></html:link></span> 
	<span class="text6">&gt;</span>      
	<span class="heading2">    
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Create">
  <bean:message key="jobcost.title.create"/>
</logic:equal>
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Delete">
 <bean:message key="jobcost.title.delete"/>
</logic:equal>
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Edit">
  <bean:message key="jobcost.title.edit"/>
</logic:equal>	
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="View">
 <bean:message key="jobcost.title.view"/>
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

<html:form action="/SaveJobhdrcost" focus="vendoraddrkey.addrkey" onsubmit="return amtCalc();">
<html:hidden property="action"/>
<html:hidden property="jobcostId"/>
<html:hidden property="jobmovId"/>
<html:hidden property="jobhdrId"/>
<html:hidden property="vendtarfhdrId"/>
<html:hidden property="baseccykey"/>
<html:hidden property="poststatus"/>

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
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Create">
  <bean:message key="jobcost.title.create"/>
</logic:equal>
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Delete">
 <bean:message key="jobcost.title.delete"/>
</logic:equal>
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="Edit">
  <bean:message key="jobcost.title.edit"/>
</logic:equal>	
<logic:equal name="JobhdrcostForm" property="action"
            scope="request" value="View">
 <bean:message key="jobcost.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="JobhdrcostForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Vendor Account:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="vendoraddrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>			  
          </td>	  
        <td width="10%" class="td2"><div align="right"> Cost: </div></td>
        <td width="40%" class="td2">
		<html:select property="costkey" disabled="true" styleClass="ftforminputsmall"> 
			<html:option value="">- select a Cost -</html:option> 
			<html:options collection="costs" property="costkey" labelProperty="descr"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="JobhdrcostForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Vendor Account:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	
          </td>	  
        <td width="10%" class="td2"><div align="right"> Cost: </div></td>
        <td width="40%" class="td2">
		<html:select property="costkey" styleClass="ftforminputsmall"> 
			<html:option value="">- select a Cost -</html:option> 
			<html:options collection="costs" property="costkey" labelProperty="descr"/> 
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
		        Cost Type </div>
		  </td>
          <td width="80%" class="td2">		
		<span class="ftformradiosmall2">
<html:radio property="costtype" value="UNIT"/>Unit
<html:radio property="costtype" value="LUMPSUM"/>Lump Sum
<html:radio property="costtype" value="PTOP"/>Point-to-Point
<html:radio property="costtype" value="DISTANCE"/>Distance
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
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong>Invoice</strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       Cost Local Currency:
		  </div>
		  </td>
          <td width="30%" class="td2">
									<html:select property="ccykey" 
											styleClass="ftforminputsmall"
											onchange="processRefreshCcyex('xrate');">
										<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>
		  </td>
          <td width="20%" class="td2">
		  <div align="right">
		       Exchange Rate to Base Ccy:		  
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="xrate" size="20"  maxlength="20" styleClass="ftforminputsmall"/>				  
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
		  <strong>Tariff Details</strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       No of Units:
		  </div>
		  </td>
          <td width="15%" class="td2">
        <html:text property="units" size="10" onblur="amtCalc()" maxlength="5" styleClass="ftforminputsmall"/>&nbsp;
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
        <html:text property="unitname" size="20"  maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>	
          <td width="15%" class="td2">
		  <div align="right">
		       Unit Rate:
		  </div>
		  </td>
          <td width="20%" class="td2">
        <html:text property="rate" size="20" onblur="amtCalc()" maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>			  	  
		</tr>	  								
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       Cost Amount:
		  </div>
		  </td>
          <td width="15%" class="td2">
        <html:text property="cstamt" size="20" maxlength="20" readonly="true" styleClass="ftforminputsmall"/>			  		
		  </td>
          <td width="15%" class="td2">
		  <div align="right">
		  </div>
		  </td>
          <td width="15%" class="td2" colspan="3">
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
        <html:text property="txt" size="80" styleClass="ftforminputsmall"/>	
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

<logic:equal name="JobhdrcostForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="JobhdrcostForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="JobhdrcostForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="JobhdrcostForm" property="action" scope="request" value="Delete"> 
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

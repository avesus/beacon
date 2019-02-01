<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 --%>
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



<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/quotation/RefreshQuotationCcyex.js"></script>


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
	var url     = 'EditQuotationVendortariffSearch.do?maxResults=999'+
						'&searchString1='+
                      	addrkey.options[addrkey.selectedIndex].value+ 
					  	'&searchString2='+ 
					  	costkey.options[costkey.selectedIndex].value+
					  	'&searchString7='+ 
					  	ccykey.options[ccykey.selectedIndex].value+
						'&searchString8='+
                      	document.forms[0].quomovId.value+
					  	'&searchString9='+
						costtypeValue+ 
					  	'&searchString10='+ 
					  	document.forms[0].units.value							
						;																	
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
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
 
 
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="quocost.title.create"/></title>
</logic:equal>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="quocost.title.delete"/></title>
</logic:equal>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="quocost.title.edit"/></title>
</logic:equal>	
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="View">
  <title><bean:message key="quocost.title.view"/></title>
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
	<td class="tdwht">
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListQuomov"><bean:message key="quomov.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListQuomovcost"><bean:message key="quocost.title.list"/></html:link></span>      
	<span class="text6">&gt;</span>    
	<span class="heading2">
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Create">
   <bean:message key="quocost.title.create"/>
</logic:equal>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Delete">
      <bean:message key="quocost.title.delete"/>
</logic:equal>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Edit">
   <bean:message key="quocost.title.edit"/>
</logic:equal>	
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="View">
  <bean:message key="quocost.title.view"/>
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

<html:form action="/SaveQuomovcost" focus="vendoraddrkey.addrkey" onsubmit="return amtCalc();">
<html:hidden property="action"/>
<html:hidden property="quocostId"/>
<html:hidden property="quomovId"/>
<html:hidden property="quohdrId"/>
<%--<html:hidden property="vendtarfhdrId"/>--%>
<html:hidden property="baseccykey"/>



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
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Create">
   <bean:message key="quocost.title.create"/>
</logic:equal>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Delete">
      <bean:message key="quocost.title.delete"/>
</logic:equal>
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="Edit">
   <bean:message key="quocost.title.edit"/>
</logic:equal>	
<logic:equal name="QuomovcostForm" property="action"
            scope="session" value="View">
  <bean:message key="quocost.title.view"/>
</logic:equal>	  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="QuomovcostForm" property="action"
                     scope="session" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		     <bean:message key="prompt.vendoraccount"/>:
		  </div>
		  </td>
          <td width="35%" class="td2">
		<html:select property="vendoraddrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>			  
          </td>	  
        <td width="10%" class="td2"><div align="right">    <bean:message key="prompt.cost"/>: </div></td>
        <td width="35%" class="td2">
		<html:select property="costkey" disabled="true" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectacost"/></html:option> 
			<html:options collection="costs" property="costkey" labelProperty="descr"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="QuomovcostForm" property="action"
                     scope="session" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.vendoraccount"/>:
		  </div>
		  </td>
          <td width="35%" class="td2">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
<logic:notEqual name="QuomovcostForm" property="action" scope="session" value="View">         
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual>        	
          </td>	  
        <td width="10%" class="td2"><div align="right"> <bean:message key="prompt.cost"/>: </div></td>
        <td width="35%" class="td2">
		<html:select property="costkey" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectacost"/></html:option> 
			<html:options collection="costs" property="costkey" labelProperty="descr"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>	
	
  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td>
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.costtype"/> </div>
		  </td>
          <td width="80%" class="td2">		
		<span class="ftformradiosmall2">
<html:radio property="costtype" value="UNIT"/><bean:message key="prompt.unit"/>
<html:radio property="costtype" value="LUMPSUM"/><bean:message key="prompt.lumpsum"/>
<html:radio property="costtype" value="PTOP"/><bean:message key="prompt.pointtopoint"/>
<html:radio property="costtype" value="DISTANCE"/><bean:message key="prompt.distance"/>
		</span>		  							  
          </td>  
        </tr>
    </table>
	</td>
  </tr>	
  
    	
  <tr>
    <td colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong><bean:message key="prompt.invoice"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.costlocalccy"/>:
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
		       <bean:message key="prompt.xratebase"/>:		  
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
    <td colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="6">
		  <strong><bean:message key="prompt.tariffdetails"/></strong> &nbsp;
		  </td>
		</tr>
			
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.noofunits"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="units" size="20" onblur="amtCalc()" maxlength="20" styleClass="ftforminputsmall"/>&nbsp;
<logic:notEqual name="QuomovcostForm" property="action" scope="session" value="View">          
		<html:link href="javascript:void(tariffSearch())">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Tariff Search" border="0" align="middle"/>
		</html:link>					  
</logic:notEqual>        
		  </td>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.tariffid"/>:
		  </div>
		  </td>
          <td width="30%" class="td2" colspan="3">
        <html:text property="vendtarfhdrId" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>			  		  	  
		</tr>	  								

        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.unitname"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="unitname" size="20" maxlength="20" styleClass="ftforminputsmall"/>					  
		  </td>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.unitrate"/>:
		  </div>
		  </td>
          <td width="30%" class="td2" colspan="3">
        <html:text property="rate" size="20" onblur="amtCalc()" maxlength="20" styleClass="ftforminputsmall"/>					  
		  </td>			  	  
		</tr>	
		  								
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.cstamt"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="cstamt" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  		
		  </td>
          <td width="20%" class="td2">
		  <div align="right">
		  </div>
		  </td>
          <td width="30%" class="td2" colspan="3">
		  </td>		  	  
		</tr>	  																
    </table>
	</td>
  </tr>

  <tr>
    <td colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2">
		  <strong><bean:message key="prompt.notes"/></strong> &nbsp;
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
		  

<logic:notEqual name="QuomovcostForm" property="action" scope="session" value="View"> 					  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">

<logic:equal name="QuomovcostForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="QuomovcostForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="QuomovcostForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="QuomovcostForm" property="action" scope="session" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
 
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">

    </td>
  </tr>		  
    </table></td>
  </tr>
</logic:notEqual>  
  
  
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

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

	  
<script type="text/javascript" language="javascript">
function amtCalc() 
{
	var _subtotalamt = parseFloat(document.forms[0].subtotalamt.value);
	var _taxamt = parseFloat(document.forms[0].taxamt.value);
	var _shippingamt = parseFloat(document.forms[0].shippingamt.value);
	document.forms[0].totalamt.value = (_subtotalamt+_taxamt+_shippingamt);
}
</script>


<logic:equal name="PohdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="PohdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="PohdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="PohdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
	<span class="heading2"><strong><bean:message key="pohdr.title"/></strong></span>
	<span class="heading2"><html:link action="/ListPohdr" styleClass="link4"><bean:message key="title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SavePohdr" focus="pono" onsubmit="return amtCalc();">
<html:hidden property="action"/>
<html:hidden property="id"/>
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
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="PohdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="pohdr.title.create"/>
</logic:equal>
<logic:equal name="PohdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="pohdr.title.delete"/>
</logic:equal>
<logic:equal name="PohdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="pohdr.title.edit"/>
</logic:equal>
<logic:equal name="PohdrForm" property="action"
            scope="request" value="View">
  <bean:message key="pohdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		


      <logic:equal name="PohdrForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.pono"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="pono" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>
	
	
	
  
       <logic:notEqual name="PohdrForm" property="action"
                     scope="request" value="Delete">  
					 
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  				
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="120" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.pono"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		  <c:if test="${PohdrForm.action == 'Create'}">
        	<html:text property="pono" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${PohdrForm.action != 'Create'}">
        	<html:text property="pono" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="pono"/>			
		  </c:if>		   
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.deliverydate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="deliverydatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="deliverydatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="deliverydateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	 	  
          </td>
        </tr>
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.submittedfor"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
        	<html:text property="submittedfor" size="20" maxlength="20" styleClass="ftforminputsmall"/>	  	 	  
          </td>
        </tr>		
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.paymentterms"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
        	<html:text property="paymentterm" size="20" maxlength="20" styleClass="ftforminputsmall"/>	  	 	  
          </td>
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.shipvia"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="shipvia" size="20" maxlength="20" styleClass="ftforminputsmall"/>	
          </td>	  
        </tr>																							
    </table>	
	</td>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="120" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.createdate"/>:
		  </div>
		  </td>
          <td width="60%" class="td9"> 
		&nbsp;<bean:write name="PohdrForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/>
		          </td>
		</tr>
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.submittedby"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		&nbsp;<html:hidden property="createuserid" styleClass="ftforminputsmall" write="true"/>		  
          </td>
		</tr>	  				
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.company"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>		  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.department"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="departmentkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>			  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">		  
		  <div align="right">		  
		        <bean:message key="prompt.activity"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="activitykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>				  
          </td>
        </tr>												
    </table>
	</td>	
  </tr>						 

   <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
			<td rowspan="1">
				<img src="images/spacer.gif" height="20" width="1" border="0"/>
			</td>		
          	<td width="20%" class="td9">
		  		<div align="right">
		        <bean:message key="prompt.workorderno"/>:
		  		</div>
		  	</td>
          	<td width="30%" class="td9">
        	<html:text property="workorderno" size="15" maxlength="20" styleClass="ftforminputsmall"/> 
          	</td>
          	<td width="20%" class="td9">
		  		<div align="right">
		        <bean:message key="prompt.workordertype"/>:
		  		</div>
		  	</td>
          	<td width="30%" class="td9">
        	<html:text property="workordertype" size="15" maxlength="10" styleClass="ftforminputsmall"/>
			</td>				  
        </tr>													
    </table>
	</td>
  </tr>	 
    
  					 			 
   <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
	<td rowspan="2">
		<img src="images/spacer.gif" height="80" width="1" border="0"/>
	</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.vendor"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>
<logic:notEqual name="PohdrForm" property="action" scope="request" value="View">		
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
</logic:notEqual>							  
          </td>	  
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.shipto"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		<html:select property="shiptolocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>
<logic:notEqual name="PohdrForm" property="action" scope="request" value="View">			
		<html:link href="javascript:void(locationSearch('shiptolocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual>				  							  
          </td>	    
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
		        <bean:message key="prompt.ccy"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
									<html:select property="ccykey" styleClass="ftforminputsmall"> 
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>							  
          </td>	  
        </tr>		
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.subtotal"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="subtotalamt" readonly="true" size="15" maxlength="15" styleClass="ftforminputsmall"/>	  				  							
          </td>	    
        </tr>
        <tr>		
          	<td width="20%" class="td9">
		  		<div align="right"><bean:message key="prompt.tax"/>:</div></td>
          	<td width="80%" class="td9">
		<html:select property="taxcode" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectataxcode"/></html:option>		
			<html:options collection="taxcodes" property="taxcodekey" labelProperty="descr"/>	
		</html:select>&nbsp;
        	<html:text property="taxamt" readonly="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>						  	
			</td>
		</tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.shipping"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="shippingamt" onblur="amtCalc();" size="15" maxlength="15" styleClass="ftforminputsmall"/>				  							
          </td>	    
        </tr>	
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.total"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="totalamt" readonly="true" size="15" maxlength="15" styleClass="ftforminputsmall"/>				  							
          </td>	    
        </tr>																				
    </table>
	</td>
  </tr>	 
  

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.specialinstructions"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:textarea rows="5" cols="110" property="txt1" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>		
  
  
    	
  </logic:notEqual>
  
<!--buttons-->
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
	
<logic:notEqual name="PohdrForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="PohdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="PohdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="PohdrForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="PohdrForm" property="action" scope="request" value="Delete"> 
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

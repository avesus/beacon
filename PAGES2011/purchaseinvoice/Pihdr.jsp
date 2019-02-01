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
	var _netamt = parseFloat(document.forms[0].netamt.value);
	var _taxamt = parseFloat(document.forms[0].taxamt.value);
	document.forms[0].grossamt.value = (_netamt+_taxamt);
}
</script>


<logic:equal name="PihdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="pihdr.title.create"/></title>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="pihdr.title.delete"/></title>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="pihdr.title.edit"/></title>
</logic:equal>	
<logic:equal name="PihdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="pihdr.title.view"/></title>
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

	<td class="tdwht">
	  <span class="heading2"><html:link action="/ListPihdr"><bean:message key="pihdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="pihdr.title.create"/>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="pihdr.title.delete"/>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="pihdr.title.edit"/>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="View">
  <bean:message key="pihdr.title.view"/>
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
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SavePihdr" focus="pino" onsubmit="return amtCalc();">
<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="readonly"/>
<html:hidden property="copyId"/>
<html:hidden property="companykey"/>
<html:hidden property="departmentkey"/>
<html:hidden property="activitykey"/>



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
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="pihdr.title.create"/>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="pihdr.title.delete"/>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="pihdr.title.edit"/>
</logic:equal>
<logic:equal name="PihdrForm" property="action"
            scope="request" value="View">
  <bean:message key="pihdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		


      <logic:equal name="PihdrForm" property="action"
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
		        <bean:message key="prompt.pino"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="pino" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>
	
	
	
  
       <logic:notEqual name="PihdrForm" property="action"
                     scope="request" value="Delete">  
					 
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  				
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="80" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.pino"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${PihdrForm.action == 'Create'}">
        	<html:text property="pino" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${PihdrForm.action != 'Create'}">
        	<html:text property="pino" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="pino"/>			
		  </c:if>		   
          </td>
        </tr>	
        <tr>		
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
<logic:notEqual name="PihdrForm" property="action" scope="request" value="View">		
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
</logic:notEqual>							  
          </td>	  
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.vendorref"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="vendorref" size="100" maxlength="100" styleClass="ftforminputsmall"/>				  							
          </td>	    
        </tr>		
				
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.invoicedate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
		<html:select property="invoicedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="invoicedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="invoicedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	 	  
          </td>
        </tr>																							
    </table>	
	</td>
  </tr>						 

   <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
	        <tr>	
				<td rowspan="2">
		<img src="images/spacer.gif" height="40" width="1" border="0"/>
	</td>	
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.financialmmyyyy"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		<html:select property="financialmonth" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="financialyear" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>							  
          </td>	  
        </tr>
        <tr>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.batchid"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="batchno" size="20" maxlength="20" styleClass="ftforminputsmall"/>	  				  							
          </td>	  
        </tr>																			
    </table>
	</td>
  </tr>	   

   <tr>
    <td width="100%" valign="top" colspan="2">
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
		        <bean:message key="prompt.netamt"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="netamt" size="15" maxlength="15" styleClass="ftforminputsmall"/>				  							
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
 <!--       	<html:text property="taxrate" readonly="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>		-->				  	
			</td>
		</tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.taxamt"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="taxamt" size="15" maxlength="15" styleClass="ftforminputsmall"/>				  							
          </td>	    
        </tr>	
        <tr>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.grossamt"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="grossamt" size="15" maxlength="15" styleClass="ftforminputsmall"/>	  				  							
          </td>	  
        </tr>																								
    </table>
	</td>
  </tr>	 
 
  
    <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
	        <tr>	
				<td rowspan="4">
		<img src="images/spacer.gif" height="80" width="1" border="0"/>
	</td>	
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.approved"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:radio property="invoicestatus" value="DISPUTED"/>
        Disputed
        <html:radio property="invoicestatus" value="APPROVED"/>
        Approved						  
          </td>	  
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
<piapp:linkPihdr page="/ListPidtl.do"><bean:message key="prompt.linesentered"/></piapp:linkPihdr>:
		  </div>
		  </td>
          <td width="80%" class="td9">
<bean:write name="PihdrForm" property="linesentered" filter="true"/>		  
          </td>	    
        </tr>				
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
<piapp:linkPihdr page="/ListPidtl.do?searchString1=DISPUTED"><bean:message key="prompt.disputes"/></piapp:linkPihdr>:
		  </div>
		  </td>
          <td width="80%" class="td9">
<bean:write name="PihdrForm" property="disputes" filter="true"/>			  							
          </td>	    
        </tr>	
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		  <bean:message key="prompt.inputtotal"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
<bean:write name="PihdrForm" property="inputtotal" filter="true"/>			  							
          </td>	    
        </tr>																							
    </table>
	</td>
  </tr>	 
   

    <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
	        <tr>	
				<td rowspan="2">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>	
          <td width="20%" class="td9">
		  <div align="right">
<bean:message key="prompt.posteddate"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="PihdrForm" property="posteddate_" format="dd-MMM-yyyy" scope="request"/>
</span>					  
          </td>	  
        </tr>				
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
<bean:message key="prompt.postedtime"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="PihdrForm" property="postedtime_" scope="request"/>
</span>			  							
          </td>	    
        </tr>																						
    </table>
	</td>
  </tr>	 
  
  
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.notes"/></strong> &nbsp;
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
	
<logic:notEqual name="PihdrForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="PihdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="PihdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="PihdrForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="PihdrForm" property="action" scope="request" value="Delete"> 
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

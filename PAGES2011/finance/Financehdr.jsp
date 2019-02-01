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

	  

<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="FinancehdrForm" property="action"
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

	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="financehdr.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListFinancehdr" styleClass="link4">
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
	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveFinancehdr" focus="subtypekey">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="manualflag"/>
<html:hidden property="printedflag"/>
<html:hidden property="id"/>
<html:hidden property="dockey"/>
<html:hidden property="createuserid"/>
<html:hidden property="netamount"/>
<html:hidden property="vatamount"/>
<html:hidden property="grossamount"/>
<html:hidden property="docdateyyyy"/>
<html:hidden property="docdatemm"/>
<html:hidden property="docdatedd"/>
<html:hidden property="billdateyyyy"/>
<html:hidden property="billdatemm"/>
<html:hidden property="billdatedd"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="financehdr.title.create"/>
</logic:equal>
<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="financehdr.title.delete"/>
</logic:equal>
<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="financehdr.title.edit"/>
</logic:equal>
<logic:equal name="FinancehdrForm" property="action"
            scope="request" value="View">
  <bean:message key="financehdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		


  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">  
        <tr>
	<td rowspan="3">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        Document Id:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
          		<strong><bean:write property="id" name="FinancehdrForm" /></strong>
		  </td>
		</tr>	
        <tr>		
          	<td width="20%" class="td9">
		  	<div align="right">
		        	Invoice Number:				
			</div>			
			</td>
          	<td width="80%" class="td9">
          		<strong><bean:write property="dockey" name="FinancehdrForm" /></strong>
		  	</td>
</tr>
        <tr>		
          	<td width="20%" class="td9">
		  		<div align="right">
		        	Invoice Type:				</div>			</td>
          	<td width="80%" class="td9">
		<html:select property="doctypekey" styleClass="ftforminputsmall">
			<html:option value="INV"><bean:message key="prompt.invoice"/></html:option>	
			<html:option value="CRD"><bean:message key="prompt.credit"/></html:option>			
		</html:select>		  	
		</td>
</tr>								
    </table>	</td>
  </tr>	
  
  
  <tr>
    <td width="50%" valign="top">
	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor"> 	 				
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="85" width="1" border="0"/>		  </td>		
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.billingaccount"/>:				</div>		  </td>
          	<td width="60%" class="td9">
		<html:select property="lesseeaddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectabillingaccount"/></html:option>
			<html:options collection="lessees" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
<logic:notEqual name="FinancehdrForm" property="action" scope="request" value="View">		
		<html:link href="javascript:void(addressSearch('lesseeaddrkey','lessee'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
</logic:notEqual>		
			</td>
        </tr>				
        <tr>
          	<td class="td9">
		  <div align="right">
		        <bean:message key="prompt.ccy"/>:		  </div>		  
			</td>
          	<td class="td9">
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
		        	<bean:message key="prompt.invoiceref"/>:				
				</div>			
			</td>
          	<td width="80%" class="td9">
				<html:text property="invoiceref" size="30" styleClass="ftforminputsmall"/>
			</td>
		</tr>				
    </table>	
	</td>
	
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
        <tr>
          <td rowspan="4">
            <img src="images/spacer.gif" height="69" width="1" border="0"/>          </td>
          <td width="40%" class="td9">
		  <div align="right">
		        Created by User:		  </div>		  </td>
          <td width="60%" class="td9"><bean:write property="createuserid" name="FinancehdrForm" /> </td>
        </tr>				        	  				
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.company"/>:		  </div>		  </td>
          <td width="60%" class="td9">
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value="">- select a Company -</html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.department"/>:		  </div>		  </td>
          <td width="60%" class="td9">
		<html:select property="departmentkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Department -</html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">		  
		  <div align="right">		  
		        <bean:message key="prompt.activity"/>:		  </div>		  </td>
          <td width="60%" class="td9">
		<html:select property="activitykey" styleClass="ftforminputsmall">
			<html:option value="">- select a Role -</html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>          </td>
        </tr>												
    </table>	</td>	
  </tr>	
  					 
  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">  
        <tr>
	<td rowspan="2">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.contractno"/>:		  </div>		  </td>
          <td width="80%" class="td9">
          <html:text property="contractno" size="30" styleClass="ftforminputsmall"/>		  </td>
</tr>	

        <tr>		
          	<td width="20%" class="td9">
		  		<div align="right">
		        	<bean:message key="prompt.taxcode"/>:				</div>			</td>
          	<td width="80%" class="td9">
		<html:select property="taxcode" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectataxcode"/></html:option>		
			<html:options collection="taxcodes" property="taxcodekey" labelProperty="descr"/>	
		</html:select>		  	
		</td>
</tr>								
    </table>	</td>
  </tr>	
  

  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">  
        <tr>
	<td rowspan="3">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>				
          	<td width="20%" class="td9">
		  		<div align="right">
		        	<bean:message key="prompt.netamount"/>:				
				</div>			
			</td>
          	<td width="80%" class="td9">
				<bean:write property="netamount" name="FinancehdrForm" />
			</td>
		</tr>	
        <tr>			
          	<td width="20%" class="td9">
		  		<div align="right">
		        	<bean:message key="prompt.vatamount"/>:				
				</div>			
			</td>
          	<td width="80%" class="td9">
				<bean:write property="vatamount" name="FinancehdrForm" />
			</td>
		</tr>
        <tr>				
          	<td width="20%" class="td9">
		  		<div align="right">
		        	<bean:message key="prompt.grossamount"/>:				
				</div>			
			</td>
          	<td width="80%" class="td9">
				<bean:write property="grossamount" name="FinancehdrForm" />
			</td>
		</tr>													
    </table>	</td>
  </tr>	
  
  

  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
	
<logic:notEqual name="FinancehdrForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="FinancehdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="FinancehdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="FinancehdrForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="FinancehdrForm" property="action" scope="request" value="Delete"> 
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

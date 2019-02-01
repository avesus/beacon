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

	  

<logic:equal name="SihdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="sihdr.title.create"/></title>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="sihdr.title.delete"/></title>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="sihdr.title.edit"/></title>
</logic:equal>	
<logic:equal name="SihdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="sihdr.title.view"/></title>
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
	  <span class="heading2"><html:link action="/ListSihdr"><bean:message key="sihdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="sihdr.title.create"/>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="sihdr.title.delete"/>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="sihdr.title.edit"/>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="View">
  <bean:message key="sihdr.title.view"/>
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


<html:form action="/SaveSihdr" focus="customeraddrkey">
<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="readonly"/>
<html:hidden property="manualflag"/>
<html:hidden property="printedflag"/>
<html:hidden property="invoiceamt"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

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
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="sihdr.title.create"/>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="sihdr.title.delete"/>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="sihdr.title.edit"/>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="View">
  <bean:message key="sihdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		

<logic:equal name="SihdrForm" property="action"
                     scope="request" value="Delete">  

	<tr>
    <td width="100%" valign="top" colspan="2">
    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td rowspan="1">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.docid"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td2">
          		<strong><bean:write property="id" name="SihdrForm" /></strong>
		  </td>
		</tr>							
    </table>	
    
    </td>
        
  </tr>	
  
</logic:equal>                     



<logic:notEqual name="SihdrForm" property="action"
                     scope="request" value="Delete"> 
                                          
	<tr>
    <td width="50%" valign="top">
    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td rowspan="2">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.docid"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
          		<strong><bean:write property="id" name="SihdrForm" /></strong>
		  </td>
		</tr>	
        <tr>		
          	<td class="td2">
		  	<div align="right">
		        	<bean:message key="prompt.invoice"/>:				
			</div>			
			</td>
          	<td class="td2">
          		<strong><bean:write property="invoiceno" name="SihdrForm" /></strong>
		  	</td>
</tr>								
    </table>	
    
    </td>

    <td width="50%" valign="top">
    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td rowspan="2">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
          <td width="40%" class="td2">
		  <div align="right">
<bean:message key="prompt.posteddate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="SihdrForm" property="posteddate_" format="dd-MMM-yyyy" scope="request"/>
</span>
		  </td>
		</tr>	
        <tr>		
          	<td class="td2">
		  	<div align="right">
<bean:message key="prompt.postedtime"/>:				
			</div>			
			</td>
          	<td class="td2">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="SihdrForm" property="postedtime_" scope="request"/>
</span>
		  	</td>
</tr>								
    </table>	
    
    </td>
        
  </tr>	
  
  
	<tr>
    <td width="50%" valign="top">
	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 	 				
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>		  </td>		
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.customer"/>:				</div>		  </td>
          	<td width="60%" class="td2">
		<html:select property="customeraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
<logic:notEqual name="SihdrForm" property="action" scope="request" value="View">		
		<html:link href="javascript:void(addressSearch('customeraddrkey','CUSTOMER'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
</logic:notEqual>		
			</td>
        </tr>
		<tr>
          	<td class="td2">
		  		<div align="right">
		        	<bean:message key="prompt.customerref"/>:				</div>			</td>
          <td class="td2">
        <html:text property="customerref" size="20" styleClass="ftforminputsmall"/>		</td>		  
        </tr>				
        <tr>
          	<td class="td2">
		  <div align="right">
		        <bean:message key="prompt.invoiceccy"/>:		  </div>		  
			</td>
          	<td class="td2">
									<html:select property="invoiceccykey" styleClass="ftforminputsmall"> 
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>          
			</td>  
        </tr>		
    </table>	
	</td>
	
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        	  				
        <tr>
          <td rowspan="3">
            <img src="images/spacer.gif" height="64" width="1" border="0"/>          </td>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.company"/>:		  </div>		  </td>
          <td width="60%" class="td2">
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>          </td>
        </tr>	
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.department"/>:		  </div>		  </td>
          <td width="60%" class="td2">
		<html:select property="departmentkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>          </td>
        </tr>	
        <tr>
          <td width="40%" class="td2">		  
		  <div align="right">		  
		        <bean:message key="prompt.activity"/>:		  </div>		  </td>
          <td width="60%" class="td2">
		<html:select property="activitykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>          </td>
        </tr>												
    </table>	</td>	
  </tr>	
  					 
  
	<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td rowspan="2">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.orderno"/>:		  </div>		  </td>
          <td width="80%" class="td2">
          <html:text property="orderno" size="30" styleClass="ftforminputsmall"/>		  </td>
</tr>	
        <tr>		
          	<td width="20%" class="td2">
		  		<div align="right">
		        	<bean:message key="prompt.taxcode"/>:				</div>			</td>
          	<td width="80%" class="td2">
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
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td rowspan="3">
		<img src="images/spacer.gif" width="1" border="0"/>		</td>		
        	<td width="20%" class="td2">
		  		<div align="right">
		        	<bean:message key="prompt.invoiceref"/>:		  
				</div>		  
			</td>
        	<td width="80%" class="td2">
          		<html:text property="invoiceref" size="30" styleClass="ftforminputsmall"/>		  
			</td>
		</tr>	
        <tr>		
          	<td width="20%" class="td2">
		  		<div align="right">
		        	<bean:message key="prompt.groupref"/>:				</div>			</td>
          	<td width="80%" class="td2">
          		<html:text property="invoicegroupref" size="30" styleClass="ftforminputsmall"/>				
			</td>
		</tr>
		<tr>		
          	<td width="20%" class="td2">
		  		<div align="right">
		        	<bean:message key="prompt.invoicetotal"/>:				
				</div>			
			</td>
          	<td width="80%" class="td2">
				<strong><bean:write property="invoiceamt" name="SihdrForm" /></strong>
			</td>
		</tr>								
    </table>	</td>
  </tr>	
  

    <tr>
        <td width="100%" valign="top" colspan="2">
            <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
            <tr>
              <td rowspan="2">
                <img src="images/spacer.gif" height="20" width="1" border="0"/>
              </td>
              <td width="20%" class="td2">
              <strong><bean:message key="prompt.additionaldata"/></strong> &nbsp;
              </td>
            </tr>	
            <tr>
              <td width="100%" class="td2">
                    <table width="100%"  border="0" cellpadding="0" cellspacing="1">
                        <tr>
                            <td width="2%" class="td2">
                                1.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata1" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td> 
                            <td width="2%" class="td2">
                                2.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata2" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td> 
                            <td width="2%" class="td2">
                                3.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata3" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td>
                            <td width="2%" class="td2">
                                4.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata4" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td>
                            <td width="2%" class="td2">
                                5.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata5" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td>                                                                                                                      
                        </tr>		 
                        <tr>
                            <td width="2%" class="td2">
                                6.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata6" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td> 
                            <td width="2%" class="td2">
                                7.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata7" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td> 
                            <td width="2%" class="td2">
                                8.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata8" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td>
                            <td width="2%" class="td2">
                                9.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata9" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td>
                            <td width="2%" class="td2">
                                10.
                            </td>
                            <td width="18%" class="td2">
                                <html:text property="adddata10" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                            </td>                                                                                                                      
                        </tr>		                      								
                    </table>	
              </td>  
            </tr>	  								
        </table>
        </td>
      </tr>		  
  
</logic:notEqual>


  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
	
<logic:notEqual name="SihdrForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td7">

<logic:equal name="SihdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="SihdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="SihdrForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="SihdrForm" property="action" scope="request" value="Delete"> 
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 *
 * NT 2014-07-10 201400029 Modify Zero Units Amount calculation in Order, Quotation and Sales Invoice modules
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


<script language="JavaScript">
function screenRefresh(){}
</script>



  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
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
    //]]>
</script>


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/RefreshOrderCcyex.js"></script>


<script language="JavaScript">
var searchWin;
var typeValue = "LUMPSUM";

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
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
	//if (_units == 0) _units = 1.00;// 201400029
	var _rate = parseFloat(document.forms[0].rate.value);
	
	// 201400029
	if (_units == 0) document.forms[0].chgamt.value = 0.00;	
	else document.forms[0].chgamt.value = (_units*_rate);
}


</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OrderchargeForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.orderno"/>&nbsp;-&nbsp;<bean:write name="ListOrderchargeForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
		    <span class="header2">
    			<logic:equal name="OrderchargeForm" property="action" scope="session" value="Create">
		    		<bean:message key="ordercharge.title.create"/>
    			</logic:equal>
		    	<logic:equal name="OrderchargeForm" property="action" scope="session" value="Delete">
		      		<bean:message key="ordercharge.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="OrderchargeForm" property="action" scope="session" value="Edit">
		        	<bean:message key="ordercharge.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="OrderchargeForm" property="action" scope="session" value="View">
		        	<bean:message key="ordercharge.title.view"/>
     			</logic:equal>	 
                </span>
                <span class="header2">&gt;</span>               	  

			             
<html:link action="/ListOrderchargeLaker"><span class="header4"><bean:message key="ordercharge.title.list"/></span></html:link>
<span class="header2">&gt;</span>                             
<html:link action="/ListOrderhdrLaker"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>        
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
  
<html:form action="/SaveOrderchargeLaker" focus="customeraddrkey.addrkey" onsubmit="return amtCalc();">
<html:hidden property="action"/>	
<html:hidden property="orderchargeId"/>
<html:hidden property="ordermovId" value="0"/>
<html:hidden property="orderhdrId"/>
<html:hidden property="invoicestatus"/>
<html:hidden property="baseccykey"/>
<html:hidden name="user" property="securitylevel"/>
<html:hidden property="custtarfhdrId" value=""/>
<html:hidden property="chargetype" value="LUMPSUM"/>
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="OrderchargeForm" property="action"  scope="session" value="Delete">  
 
				        	<tr><td class="label1" colspan="3">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.billingaccount"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="customeraddrkey" disabled="true" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>	
                                        </td></tr>
                                        
							            <tr><td class="label2"><bean:message key="prompt.charge"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="chargekey" disabled="true" styleClass="forminput1"> <html:option value="">
		<bean:message key="prompt.selectacharge"/>
		</html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 
                                        </td></tr>
                                                                                
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="OrderchargeForm" property="action"  scope="session" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.billingaccount"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="customeraddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
<logic:notEqual name="OrderchargeForm" property="action" scope="session" value="View">        
		<html:link href="javascript:void(addressSearch('customeraddrkey','CUSTOMER'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual> 
                                    </td></tr>
                                                                        
									<tr><td class="label2"><bean:message key="prompt.charge"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="chargekey" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select>                                   
                                    </td></tr>            
                        
                                                          
								</table>
    						</td>
						    </tr>
     					
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.invoice"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.chargeccy"/>:</td></tr>
              						<tr><td class="label2">
									<html:select property="ccykey" 
											styleClass="forminput1"
											onchange="processRefreshCcyex('xratebase');processRefreshCcyex('xrateinv');"> 
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>	
              						</td></tr>	 
                                              
                                             
         							<tr><td class="label2"><bean:message key="prompt.xratebase"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="xratebase" size="20"  maxlength="20" styleClass="forminput1"/> 
              						</td></tr>
                                                                                                                                                                         
     						</table>
					    </td>

						<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                                                                     
         							<tr><td class="label2"><bean:message key="prompt.invoiceccy"/>:</td></tr>
              						<tr><td class="label2">
									<html:select property="invoiceccykey" 
											styleClass="forminput1"
											onchange="processRefreshCcyex('xrateinv')"> 
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>	 
              						</td></tr>
                                             
         							<tr><td class="label2"><bean:message key="prompt.xrateinv"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="xrateinv" size="20"  maxlength="20" styleClass="forminput1"/>	 
              						</td></tr>                                                                                                                                                        						</table>
					    </td>
                                                
        					</tr>
                            
                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.invoicestatus"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff"> 
                            
              						<tr><td class="label2">
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
		  </td></tr>	
                                                                 
      						</table>
					    </td>
                                                
        					</tr>
                            
                                                       
                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.tariffdetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.noofunits"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="units" size="20" onblur="amtCalc()" maxlength="20" styleClass="forminput1"/>&nbsp;
              						</td></tr>	 
                                              

         							<tr><td class="label2"><bean:message key="prompt.unitname"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="uname" size="20" maxlength="20" styleClass="forminput1"/>	
              						</td></tr>

                                    
         							<tr><td class="label2"><bean:message key="prompt.chgamt"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="chgamt" size="20" readonly="true" maxlength="20" styleClass="forminput1"/>	
              						</td></tr>

                                                                                                                      
     						</table>
					    </td>
                        
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   


         							<tr><td class="label2"><bean:message key="prompt.unitrate"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="rate" size="20" onblur="amtCalc()" maxlength="20" styleClass="forminput1"/>	
              						</td></tr>
                                    

         							<tr><td class="label2"><bean:message key="prompt.taxcode"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="taxcode" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectataxcode"/></html:option>		
			<html:options collection="taxcodes" property="taxcodekey" labelProperty="descr"/>	
		</html:select>	
              						</td></tr>
                                                                                                                      
     						</table>
					    </td>
                                                
        					</tr>                                          
                                                                                    


                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.notes"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
              						<tr><td class="label2">
         <html:text property="txt1" size="120" styleClass="forminput1"/>	                                   
									</td></tr>
		
                                                                                                                      
     						</table>
					    </td>
        					</tr>          
                            
           					</logic:notEqual>
              
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="OrderchargeForm" property="action"   scope="session" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="OrderchargeForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="OrderchargeForm" property="action"   scope="session" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			                </button>                            
				        </div>
                 
      				</td>
				</tr>
    
						</html:form>
    
    				</table>

				</div>

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>

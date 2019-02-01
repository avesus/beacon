<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
 *
 * Amendments
 * ----------
 *
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function to Sales Invoice module
 *
 * NT 2014-02-25 201400003 Add User Companylist, Departmentlist and Activitlist to Main Entry Screens (changes not commented)
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
				document.forms[0].exitButton.disabled = false;	
				document.forms[0].action.disabled = false;		
			}	
	}
    //]]>
</script>



<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/LookupAddress.js"></script>



<script language="JavaScript">
var searchWin;

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,sihdr=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
		
	
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SihdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="SihdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="SihdrForm" property="action" scope="request" value="Create">
		    		<bean:message key="sihdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="SihdrForm" property="action" scope="request" value="Delete">
		      		<bean:message key="sihdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="SihdrForm" property="action" scope="request" value="Edit">
		        	<bean:message key="sihdr.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="SihdrForm" property="action" scope="request" value="View">
		        	<bean:message key="sihdr.title.view"/>
     			</logic:equal>	                	  
            </span>
<span class="header2">&gt;</span>            
<html:link action="/ListSihdr"><span class="header4"><bean:message key="sihdr.title.list"/></span></html:link>        
          	      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SaveSihdr" focus="customeraddrkey">
<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="copyId"/><!--WSI-201311-0002-->
<html:hidden property="readonly"/>
<html:hidden property="manualflag"/>
<html:hidden property="printedflag"/>
<html:hidden property="invoiceamt"/>
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="SihdrForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="3">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.docid"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="id" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="id"/>
                                        </td></tr>
								    </table>
							    </td>
                                
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="SihdrForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%" valign="top">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.docid"/>:</td></tr>
              						<tr><td class="label2">
        	<html:text property="id" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="id"/>			                                    
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.invoice"/>:</td></tr>
              						<tr><td class="label2">
        	<html:text property="invoiceno" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="invoiceno"/>  
                                    </td></tr>
                      
								</table>
    						</td>
                            
                            
                            	<td width="50%" valign="top">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.company"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="companykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>        
			<html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>	
		</html:select>                                         
<%--  <html:select property="companykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>--%>
                                        </td></tr>
                                        
							            <tr><td class="label2"><bean:message key="prompt.department"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="departmentkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>        
			<html:options collection="userdepartmentkeylist" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                        
<%--<html:select property="departmentkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>
                                        </td></tr>

							            <tr><td class="label2"><bean:message key="prompt.activity"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="activitykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>        
			<html:options collection="useractivitykeylist" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                        
<%-- <html:select property="activitykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>
                                        </td></tr>
                                                                                                                        
								    </table>
							    </td>
                                
                                                            
						    </tr>
     					
                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3">Post Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.posteddate"/>:</td></tr>
              					<tr><td class="label2">
<bean:write name="SihdrForm" property="posteddate_" format="dd-MMM-yyyy" scope="request"/> &nbsp;                                
                                </td></tr>

         						<tr><td class="label2"><bean:message key="prompt.postedtime"/>:</td></tr>
              					<tr><td class="label2">
<bean:write name="SihdrForm" property="postedtime_" scope="request"/> &nbsp;     
                                </td></tr>
                                                                                                             
     						</table>
					    </td>
        					</tr>
                                           


                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3">Customer Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.customer"/>:</td></tr>
              					<tr><td class="label2">
		<html:select property="customeraddrkey" styleClass="forminput1" onchange="processLookupAddress('customeraddrkey');">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
<logic:notEqual name="SihdrForm" property="action" scope="request" value="View">		
		<html:link href="javascript:void(addressSearch('customeraddrkey','CUSTOMER'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
</logic:notEqual>	
                                </td></tr>
                                          
         						<tr><td class="label2"><bean:message key="prompt.customerref"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="customerref" size="20" styleClass="forminput1"/>	
                                </td></tr>
                                          
         						<tr><td class="label2"><bean:message key="prompt.paymentterms"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="paymentterm" size="100" styleClass="forminput1"/>	
                                </td></tr>
                                                                          
         						<tr><td class="label2"><bean:message key="prompt.invoiceccy"/>:</td></tr>
              					<tr><td class="label2">
									<html:select property="invoiceccykey" styleClass="forminput1"> 
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>  
                                </td></tr>
                                                                                                                                                                               </table>
					    </td>
        					</tr>
 
 
 
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3">Order Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.orderno"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="orderno" size="30" styleClass="forminput1"/>	
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
           
             					<tr><td class="label1" colspan="3">Invoice Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.invoiceref"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="invoiceref" size="30" styleClass="forminput1"/>	
                                </td></tr>
                                          
         						<tr><td class="label2"><bean:message key="prompt.groupref"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="invoicegroupref" size="30" styleClass="forminput1"/>	
                                </td></tr>

         						<tr><td class="label2"><bean:message key="prompt.invoicetotal"/>:</td></tr>
              					<tr><td class="label2">
<bean:write property="invoiceamt" name="SihdrForm" />	
                                </td></tr>
                                                                                                                                                                                </table>
					    </td>
        					</tr>
                                                        


                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.additionaldata"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2">1.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata1" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>

         						<tr><td class="label2">2.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata2" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>
                                
         						<tr><td class="label2">3.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata3" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                         
                                           
         						<tr><td class="label2">4.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata4" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr> 
         						<tr><td class="label2">5.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata5" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                                                                                                                                                                 </table>
					    </td>

						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2">6.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata6" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>

         						<tr><td class="label2">7.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata7" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>
                                
         						<tr><td class="label2">8.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata8" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                         
                                           
         						<tr><td class="label2">9.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata9" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr> 
         						<tr><td class="label2">10.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata10" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                                                                                                                                                                 </table>
					    </td>
                                                
        					</tr>
                            
                                                                                                                                                                       
           					</logic:notEqual>
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="SihdrForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="SihdrForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="SihdrForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
							<logic:notEqual name="SihdrForm" property="action"   scope="request" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="SihdrForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListSihdr.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                            
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

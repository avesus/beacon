<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
 * NT	2013-12-06	WSI-201311-0003	BEACON LAKER (WSI LINER) 
 *			- add 'Account Representative' and 'Commission Type' fields to Address maintenance
 *			- add 'External System Address Id' to Address maintenance
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
	}
    //]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="AddressForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="AddressForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="AddressForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="AddressForm" property="action" scope="request" value="Create">
		    		<bean:message key="address.title.create"/>
    			</logic:equal>
		    	<logic:equal name="AddressForm" property="action" scope="request" value="Delete">
		      		<bean:message key="address.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="AddressForm" property="action" scope="request" value="Edit">
		        	<bean:message key="address.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>            
<html:link action="/ListAddress"><span class="header4"><bean:message key="address.title.list"/></span></html:link>        
          	      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
			<html:form action="/SaveAddress" focus="addrkey"> 
			<html:hidden property="action"/>
<html:hidden property="typekey"/> 
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="AddressForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="addrkey" size="30" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="addrkey"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="AddressForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${AddressForm.action == 'Create'}">
        	<html:text property="addrkey" size="30" maxlength="10" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${AddressForm.action != 'Create'}">
        	<html:text property="addrkey" size="30" disabled="true" maxlength="10" styleClass="forminput1"/>
			<html:hidden property="addrkey"/>			
		  </c:if>	                                    
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.type"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="arraytypekeylist" multiple="true" size="10" styleClass="forminput1">
			<html:options collection="addrtypes" property="typekey" labelProperty="typekey"/>	
</html:select> 
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.name"/>:</td></tr>
              						<tr><td class="label2"><html:text property="name" size="50" maxlength="50" styleClass="forminput1"/></td></tr>    
                                    
             						<tr><td class="label2"><bean:message key="prompt.shortname"/>:</td></tr>
              						<tr><td class="label2"><html:text property="shortname" size="20" maxlength="10" styleClass="forminput1"/></td></tr>                                              
                      
								</table>
    						</td>
						    </tr>
     					
                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Address Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.address"/>:</td></tr>
              					<tr><td class="label2"><html:text property="addr1" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
              					<tr><td class="label2"><html:text property="addr2" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
              					<tr><td class="label2"><html:text property="addr3" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
              					<tr><td class="label2"><html:text property="addr4" size="50" maxlength="50" styleClass="forminput1"/></td></tr>

         						<tr><td class="label2"><bean:message key="prompt.postalcode"/>:</td></tr>
              					<tr><td class="label2"><html:text property="postalcode" size="20" maxlength="10" styleClass="forminput1"/></td></tr>
                                
         						<tr><td class="label2"><bean:message key="prompt.city"/>:</td></tr>
              					<tr><td class="label2">
<html:select property="city" styleClass="forminput1"> 
									<html:option value=""><bean:message key="prompt.city"/></html:option> 
									<html:options collection="citys" property="city" labelProperty="city"/> 
									</html:select>
                                </td></tr>                                
 
         						<tr><td class="label2"><bean:message key="prompt.state"/>:</td></tr>
              					<tr><td class="label2"><html:text property="state" size="20" maxlength="20" styleClass="forminput1"/></td></tr>        
         						<tr><td class="label2"><bean:message key="prompt.country"/>:</td></tr>
              					<tr><td class="label2">
<html:select property="country" styleClass="forminput1"> <html:option value=""><bean:message key="prompt.country"/></html:option> <html:options collection="countrys" property="country" labelProperty="country"/> </html:select>
                                </td></tr>                                                                                                                                                                                                                                 
     						</table>
					    </td>
        					</tr>
                                           

                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Contact Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.phone"/>:</td></tr>
              					<tr><td class="label2"><html:text property="telno1" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
                                
         						<tr><td class="label2"><bean:message key="prompt.fax"/>:</td></tr>
              					<tr><td class="label2"><html:text property="faxno1" size="50" maxlength="50" styleClass="forminput1"/></td></tr>                                                                                                                                              						<tr><td class="label2"><bean:message key="prompt.email"/>:</td></tr>
              					<tr><td class="label2"><html:text property="emailno" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
                                                                              
     						</table>
					    </td>
        					</tr>


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG4codeAjax.js"></script>

                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2"><bean:message key="gcode.title"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="heading.g1code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g1codekey" styleClass="forminput1" onchange="processListG2code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>	
		</html:select>	
                                </td></tr>
                                
         						<tr><td class="label2"><bean:message key="heading.g2code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g2codekey" styleClass="forminput1" onchange="processListG3code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
            			<html:options collection="g2codes" property="g2codekey" labelProperty="g2codekey"/>	
		</html:select>		
                                </td></tr>                                                                                                                                              						<tr><td class="label2"><bean:message key="heading.g3code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g3codekey" styleClass="ftforminputsmall" onchange="processListG4code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
			<html:options collection="g3codes" property="g3codekey" labelProperty="g3codekey"/>	            
		</html:select>
                                </td></tr>
                                
         						<tr><td class="label2"><bean:message key="heading.g4code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g4codekey" styleClass="ftforminputsmall">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g4codes" property="g4codekey" labelProperty="g4codekey"/>	            	
		</html:select>	
                                </td></tr>                                
                                                                                                                
     						</table>
					    </td>
        					</tr>

                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Account Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.headoffice"/>:</td></tr>
              					<tr><td class="label2">
		<html:select property="mainaccaddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>	
                                </td></tr>
                                
         						<tr><td class="label2"><bean:message key="prompt.ccy"/>:</td></tr>
              					<tr><td class="label2">
<html:select property="ccykey" styleClass="forminput1"> <html:option value=""><bean:message key="prompt.ccy"/></html:option> <html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> </html:select>
                                </td></tr>                                                                                                                                    
         						<tr><td class="label2"><bean:message key="prompt.accsysid"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="accsysaddressid" size="20" maxlength="20" styleClass="forminput1"/>
                                </td></tr>
                                   
                                   
<!--sWSI-201311-0003-->

         						<tr><td class="label2"><bean:message key="prompt.extsysid"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="extsysaddressid" size="20" maxlength="20" styleClass="forminput1"/>
                                </td></tr>
                                                                           
<tr><td class="label2"><bean:message key="prompt.accountrepresentative"/>:</td></tr>
<tr><td class="label2">
<html:text property="accRep" size="10" maxlength="10" styleClass="forminput1"/>
</td></tr> 
<tr><td class="label2"><bean:message key="prompt.commissiontype"/>:</td></tr>
<tr><td class="label2">
<html:text property="commissiontype" size="10" maxlength="10" styleClass="forminput1"/>
</td></tr> 
<!--eWSI-201311-0003--> 

                                                                                                             
     						</table>
					    </td>
        					</tr>
                            

                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2"><bean:message key="prompt.invoicedetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.billingaddress"/>:</td></tr>
              					<tr><td class="label2">
		<html:select property="rentaddrkey" 
			styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>	
                                </td></tr>
                                
          						<tr><td class="label2"><bean:message key="prompt.paymentterms"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="payterms" size="10" maxlength="5" styleClass="forminput1"/>
                                </td></tr>
                                                                                                                                                						<tr><td class="label2"><bean:message key="prompt.paymenttermstext"/>:</td></tr>
              					<tr><td class="label2">
<html:textarea rows="2" cols="70" property="paytermstext" styleClass="forminput1"/>
                                </td></tr>
 
            						<tr><td class="label2"><bean:message key="prompt.paymenttoinstructions"/>:</td></tr>
              					<tr><td class="label2">
									<html:textarea rows="6" cols="70" property="paymenttoinstructions" styleClass="forminput1"/>
                                </td></tr>                                                                                          
                                                                                                                                              
     						</table>
					    </td>
        					</tr>
                            
                                                                                                                                           
           					</logic:notEqual>
              
              
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="AddressForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="AddressForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="AddressForm" property="action"   scope="request" value="Edit">
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

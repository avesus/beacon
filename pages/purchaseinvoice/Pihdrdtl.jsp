<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *   
 * NT 2014-02-25 201400003 Add User Companylist, Departmentlist and Activitlist to Main Entry Screens (changes not commented)
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
			
			if ( document.forms[0].action.value == 'Create') {
				processListvendorjobs();
			}
			
	}
    //]]>
</script>


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/LookupAddress.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/purchaseinvoice/ListVendorjobs.js"></script>


<script language="JavaScript">
var searchWin;

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,pihdr=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
		
	
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="PihdrdtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="PihdrdtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="PihdrdtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="PihdrdtlForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="PihdrdtlForm" property="action" scope="request" value="Create">
		    		<bean:message key="pihdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="PihdrdtlForm" property="action" scope="request" value="Delete">
		      		<bean:message key="pihdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="PihdrdtlForm" property="action" scope="request" value="Edit">
		        	<bean:message key="pihdr.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="PihdrdtlForm" property="action" scope="request" value="View">
		        	<bean:message key="pihdr.title.view"/>
     			</logic:equal>	                	  
            </span>
<span class="header2">&gt;</span>            
<html:link action="/ListPihdrdtl"><span class="header4"><bean:message key="pihdr.title.list"/></span></html:link>        
          	      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
  
<html:form action="/SavePihdrdtl" focus="pino">

<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="readonly"/>
<html:hidden property="postedflag"/>        
<html:hidden property="inputtotal"/> 
<html:hidden property="alloctotal"/> 
<html:hidden property="linesentered"/> 
<html:hidden property="disputes"/> 

<html:hidden property="pidtlId"/> 
<html:hidden property="jobhdrId"/> 
<html:hidden property="orderno"/> 

        
							<tr><td colspan="3"><img src="images/spacer.gif" height="2"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div> 
				            <logic:equal name="PihdrdtlForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="PihdrdtlForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="PihdrdtlForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
							<logic:notEqual name="PihdrdtlForm" property="action"   scope="request" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="PihdrdtlForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListPihdrdtl.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                            
				        </div>
                 
      				</td>
				</tr>
                        
				       		<tr><td><img src="images/spacer.gif" height="2"/></td></tr>  
    
    
<logic:equal name="PihdrdtlForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="3"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.pino"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="pino" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="pino"/>
                                        </td></tr>
								    </table>
							    </td>
                                
						    </tr>
    
</logic:equal>			
    
          
<logic:notEqual name="PihdrdtlForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="3"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%" valign="top">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.pino"/>:</td></tr>
              						<tr><td class="label2">
                                    
<c:set var="pinoAutoGenerate">
<bean:message bundle="systemResources" key="pino.auto.generate"/>
</c:set> 
                                    
		  <c:if test="${PihdrdtlForm.action == 'Create' and pinoAutoGenerate == 'no'}">
        	<html:text property="pino" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${PihdrdtlForm.action != 'Create' or pinoAutoGenerate == 'yes'}">
        	<html:text property="pino" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="pino"/>			
		  </c:if>
                                                                                   			                                    
                                    </td></tr>
                       

              					<tr><td class="label2">
        <html:radio property="invoicestatus" value="DISPUTED"/>
        Disputed
        <html:radio property="invoicestatus" value="APPROVED"/>
        Approved
                                </td></tr>
                                
                         		<tr><td><img src="images/spacer.gif" height="2"/></td></tr>   
   
   	              				<tr><td class="label2">
<bean:message key="prompt.miscellaneous"/>:
    	                        </td></tr>   
            	  				<tr><td class="label2">
                                
<c:if test="${PihdrdtlForm.action == 'Create'}">
	<html:select property="miscflag" styleClass="forminput1">
			<html:option value="false">No</html:option>    
			<html:option value="true">Yes</html:option>        
	</html:select>			
</c:if>
<c:if test="${PihdrdtlForm.action != 'Create'}">
	<html:hidden property="miscflag"/>
	<html:select property="miscflag" styleClass="forminput1" disabled="true">
			<html:option value="false">No</html:option>    
			<html:option value="true">Yes</html:option>        
	</html:select>	              			
</c:if> 
                                
 
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
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.vendordetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.vendor"/>:</td></tr>
              					<tr><td class="label2">
                                
<c:if test="${PihdrdtlForm.action == 'Create'}">
		<html:select property="vendoraddrkey" styleClass="forminput1" onchange="processLookupAddress('vendoraddrkey'); processListvendorjobs();">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>     
        &nbsp;	
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	
</c:if>
<c:if test="${PihdrdtlForm.action != 'Create'}">
		<html:hidden property="vendoraddrkey"/>
		<html:select property="vendoraddrkey" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>               			
</c:if>                                  
	

                                </td></tr>
                                                                                                                                       
         						<tr><td class="label2"><bean:message key="prompt.ccy"/>:</td></tr>
              					<tr><td class="label2">

<c:if test="${PihdrdtlForm.action == 'Create'}">
	<html:select property="ccykey" styleClass="forminput1" onchange="processListvendorjobs();"> 
		<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
		<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
	</html:select> 		
</c:if>
<c:if test="${PihdrdtlForm.action != 'Create'}">
	<html:hidden property="ccykey"/>
	<html:select property="ccykey" styleClass="forminput1" disabled="true"> 
		<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
		<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
	</html:select>              			
</c:if> 
                                 
                                </td></tr>
                                                                                                                                                                               </table>
					    </td>
                        
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
                                          
         						<tr><td class="label2"><bean:message key="prompt.vendorref"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="vendorref" size="20" styleClass="forminput1"/>	
                                </td></tr>
                                                                                                                   
                                                                                                                                                                              </table>
					    </td>
                                                
        					</tr>
 

                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.jobdetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.jobno"/>:</td></tr>
              					<tr><td class="label2">
                                
<c:if test="${PihdrdtlForm.action == 'Create'}">                                  
	<html:select property="jobno" styleClass="forminput1">
		<html:option value=""><bean:message key="prompt.selectajob"/></html:option>
	</html:select>     
</c:if>	    
<c:if test="${PihdrdtlForm.action != 'Create'}">			  
	<html:hidden property="jobno"/>	
	<html:text property="jobno" disabled="true" size="10" maxlength="10" styleClass="forminput1"/>                    
</c:if>	                                	

                                </td></tr>
                                
<c:if test="${PihdrdtlForm.action != 'Create'}">                               
         						<tr><td class="label2"><bean:message key="prompt.costsallocatedtopurchaseinvoice"/>:</td></tr> 
 
 								<tr>
									<td class="label2">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>		
		  			<td class="column-header5" width="60%">
					<bean:message key="prompt.cost"/></td>                    
		  			<td class="column-header6" width="20%" align="right">
					<bean:message key="prompt.jobcost"/></td>
		  			<td class="column-header6" width="20%" align="right">
					<bean:message key="prompt.actualcost"/></td>																	
				</tr>                
				<c:forEach var="lineItem" items="${PihdrdtlForm.pidtlcosts}" varStatus="loop">
					<c:set var="_class" value="column-cell9"/>
					<c:if test="${loop.count % 2 == 0}">
						<c:set var="_class" value="column-cell10"/>				
					</c:if>
  					<tr>			
						<td class='<c:out value="${_class}"/>'>
							<c:out value="${lineItem.costkey.descr}"/>						
						</td> 	
						<td class='<c:out value="${_class}"/>' align="right">
							<c:out value="${lineItem.cstamttotal}"/>					
						</td> 
						<td class='<c:out value="${_class}"/>' align="right">
							<c:out value="${lineItem.cstamtalloc}"/>						
						</td> 			
					</tr>	
				</c:forEach>    			
			</table>
		</td>
								</tr>
</c:if> 
                                                                                                                                                                               </table>
					    </td>
                         	
                                                
        					</tr>
                            
 
                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.invoicedetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.invoicedate"/>:</td></tr>
              					<tr><td class="label2">
		<html:select property="invoicedatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="invoicedatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="invoicedateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
                                </td></tr>

         						<tr><td class="label2"><bean:message key="prompt.netamt"/>:</td></tr>
              					<tr><td class="label2">
        	<html:text property="netamt" size="15" maxlength="15" styleClass="forminput1"/>	
                                </td></tr>
                                                                                                                                                                      
                                                                                                                                                                          </table>
					    </td>
                        
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                         
                                          
         						<tr><td class="label2"><bean:message key="prompt.tax"/>:</td></tr>
              					<tr><td class="label2">
		<html:select property="taxcode" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectataxcode"/></html:option>		
			<html:options collection="taxcodes" property="taxcodekey" labelProperty="descr"/>	
		</html:select>	
                                </td></tr>
                                
         						<tr><td class="label2"><bean:message key="prompt.taxamt"/>:</td></tr>
              					<tr><td class="label2">
        	<html:text property="taxamt" size="15" maxlength="15" styleClass="forminput1"/>	
                                </td></tr>

         						<tr><td class="label2"><bean:message key="prompt.grossamt"/>:</td></tr>
              					<tr><td class="label2">
        	<html:text property="grossamt" size="15" maxlength="15" styleClass="forminput1"/>	
                                </td></tr>
                                                                                                
                                                                                                                                                                          </table>
					    </td>
                                                
        			</tr>
                         
                         
                         
                         
                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.financedetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
                                          
         						<tr><td class="label2"><bean:message key="prompt.financialmmyyyy"/>:</td></tr>
              					<tr><td class="label2">
		<html:select property="financialmonth" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="financialyear" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
                                </td></tr>

         						<tr><td class="label2"><bean:message key="prompt.batchid"/>:</td></tr>
              					<tr><td class="label2">
        	<html:text property="batchno" size="20" maxlength="20" styleClass="forminput1"/>	  
                                </td></tr>
                                                                                                
                                                                                                                                                                                 </table>
					    </td>

						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                                                                      
                                          
         						<tr><td class="label2"><bean:message key="prompt.posteddate"/>:</td></tr>
              					<tr><td class="label2">
		<span  styleClass="forminput1">
		&nbsp;<bean:write name="PihdrdtlForm" property="posteddate_" format="dd-MMM-yyyy" scope="request"/>
</span>		  
                                </td></tr>
                                
          						<tr><td class="label2"><bean:message key="prompt.postedtime"/>:</td></tr>
              					<tr><td class="label2">
		<span  styleClass="forminput1">
		&nbsp;<bean:write name="PihdrdtlForm" property="postedtime_" scope="request"/>
</span>	  
                                </td></tr>                                                                                                                                                                                 </table>
					    </td>
                                                
        			</tr>                                                        



                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.additionaldata"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
				       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                                                                                                         
         						<tr><td class="label2"><bean:message key="prompt.notes"/>:</td></tr>
              					<tr><td class="label2">
        <html:textarea rows="5" cols="110" property="txt1" styleClass="forminput1"/>
                                </td></tr>

                                                                                                                                                                                 </table>
					    </td>
                                                
        					</tr>
                            
                                                                                                                                                              
           					</logic:notEqual>
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
    
						</html:form>
    
    				</table>

				</div>

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>

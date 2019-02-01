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
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
				document.forms[0].exitButton.disabled = false;	
				document.forms[0].forwardname.disabled = false;		
				document.forms[0].action.disabled = false;		
			}	
	}
	
	function navigateTo(forwardName) {
		document.forms[0].forwardname.value=forwardName;	
		document.forms[0].submit();		
	}	
    //]]>
</script>








<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="css/navigation.css" />


<head>
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>




</head>

<un:bind var="servletKey" type="ord.apache.struts.Globals" field="SERVLET_KEY"/>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td colspan="2">
<span class="header2">
    			<logic:equal name="OrderhdrForm" property="action" scope="session" value="Create">
		    		<bean:message key="orderhdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="OrderhdrForm" property="action" scope="session" value="Delete">
		      		<bean:message key="orderhdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="OrderhdrForm" property="action" scope="session" value="Edit">
		        	<bean:message key="orderhdr.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="OrderhdrForm" property="action" scope="session" value="View">
		        	<bean:message key="orderhdr.title.view"/>
     			</logic:equal>	                	  
</span>
<span class="header2">&gt;</span>			             
<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td colspan="2">
	
				<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	




<html:form action="/SaveOrderhdr" focus="orderno">
<html:hidden property="action"/>
<html:hidden property="forwardname" value=""/>
<html:hidden property="id"/>
<html:hidden property="orderstatus"/>
<html:hidden property="invoicestatus"/>
<html:hidden property="quohdrId"/>
<html:hidden property="copyId"/>
<html:hidden name="user" property="securitylevel"/>

<html:hidden property="ldgg1key1"/>
<html:hidden property="ldgg2key1"/>
<html:hidden property="ldgg3key1"/>
<html:hidden property="ldgg4key1"/>
<html:hidden property="ldgg1key2"/>
<html:hidden property="ldgg2key2"/>
<html:hidden property="ldgg3key2"/>
<html:hidden property="ldgg4key2"/>
<html:hidden property="dchg1key1"/>
<html:hidden property="dchg2key1"/>
<html:hidden property="dchg3key1"/>
<html:hidden property="dchg4key1"/>
<html:hidden property="dchg1key2"/>
<html:hidden property="dchg2key2"/>
<html:hidden property="dchg3key2"/>
<html:hidden property="dchg4key2"/>

<html:hidden property="shipvendoraddrkey"/>
<html:hidden property="shipvessel"/>
<html:hidden property="shipvoyage"/>
        

<logic:notEqual name="OrderhdrForm" property="action"  scope="session" value="Delete"> 
<div id="secondaryNav">
    
    <div class="secNavOuterPane">
    
    <div id="secNavDividerLeft"></div>
    <div id="secNavDividerTitle"></div>
    <div id="secNavDividerRight"></div>
    
<div id="secNavPane">
      
    <div id="General" class="secNavBtnSelected HorizontalSprite SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr1');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite General" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />General
    </span>
    </a>
    </span>
    </div>

   <div id="Customer" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr2');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite Address" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Customer
    </span>
    </a>
    </span>
    </div>
          
    <div id="Logistic" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr3');">
    <span class="secNavBtnLnkContent">
    <img class="secNavBtnLnkIcon MainNavigationSprite Logistic" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Logistic
    </span>
    </a>
    </span>
    </div>
          
    <div id="Document" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr4');">
    <span class="secNavBtnLnkContent">
    <img class="secNavBtnLnkIcon MainNavigationSprite Document" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Documentation
    </span>
    </a>
    </span>
    </div>
               
    </div>       
     
    </div>
    
</div>
</logic:notEqual>


<div style="position:relative;">


				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
                               
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    

    
							<logic:equal name="OrderhdrForm" property="action"  scope="session" value="Delete">  
 
				        	<tr><td class="label1" colspan="3"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.orderno"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="orderno" size="30" maxlength="40" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="orderno"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="OrderhdrForm" property="action"  scope="session" value="Delete"> 



				       		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                            
                             
								<tr><td class="label1" colspan="3"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2" colspan="2"><bean:message key="prompt.orderno"/>:</td></tr>
              						<tr><td class="label2" colspan="2">                                 
                                    
		  <c:if test="${OrderhdrForm.action == 'Create'}">
        	<html:text property="orderno" size="30" maxlength="40" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${OrderhdrForm.action != 'Create'}">
        	<html:text property="orderno" size="30" disabled="true" maxlength="40" styleClass="forminput1"/>
			<html:hidden property="orderno"/>			
		  </c:if>  
                                            
                                    </td></tr>
    
    
             						<tr><td class="label2" colspan="2"><bean:message key="prompt.orderdate"/>:</td></tr>
              						<tr><td class="label2" colspan="2">
		<html:select property="orderdatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="orderdatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="orderdateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>		
                                    </td></tr>  
                                                                                 
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.exchgdate"/>:</td></tr>
              						<tr><td class="label2" valign="top">
		<html:select property="exchgdatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exchgdatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exchgdateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
                                    </td>
                                    </tr>
                                    
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.quotenumber"/>:</td></tr>
              						<tr><td class="label2" valign="top">
        	<html:text property="quotno" size="20" disabled="true" maxlength="40" styleClass="forminput1"/>
			<html:hidden property="quotno"/>	          
                                    </td>
                                    </tr>
                                         
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.bookingnumber"/>:</td></tr>
              						<tr><td class="label2" valign="top">
        	<html:text property="bookingnumber" size="20" maxlength="20" styleClass="forminput1"/>	          
                                    </td>
                                    </tr>

             						<tr><td class="label2" colspan="2"><bean:message key="prompt.consignmentno"/>:</td></tr>
              						<tr><td class="label2" valign="top">
        	<html:text property="consignmentno" size="20" maxlength="20" styleClass="forminput1"/>	          
                                    </td>
                                    </tr>
 
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.ordercurrency"/>:</td></tr>
              						<tr><td class="label2" valign="top">
		  		<c:if test="${OrderhdrForm.action == 'Create'}">
					<html:select property="ccykey" styleClass="forminput1"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>				
				</c:if>	
		  		<c:if test="${OrderhdrForm.action != 'Create'}">
					<html:select property="ccykey" styleClass="forminput1" disabled="true"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>	
					<html:hidden property="ccykey"/>			
				</c:if>          
                                    </td>
                                    </tr> 
                                  <tr><td class="label2" colspan="2"><bean:message key="prompt.contracttype"/>:</td></tr>
              						<tr><td class="label2" valign="top">
					<html:select property="contracttype" styleClass="forminput1"> 
						<html:option value=""><bean:message key="prompt.selectatype"/></html:option> 
			<html:options collection="contracttypes" property="id.codekey" labelProperty="descr"/>										
					</html:select>				
                                    </td>
                                    </tr>                                                                                                                                        
								</table>
    							</td>
                                
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.createdby"/>:</td></tr>
              						<tr><td class="label2">  
        	<html:text property="orderbyuserid" size="10" disabled="true" maxlength="10" styleClass="forminput1"/>
			<html:hidden property="orderbyuserid"/>                                  
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.company"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="companykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>        
			<html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>	
		</html:select>                                     
<%--		<html:select property="companykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>	--%>
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.department"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="departmentkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>        
			<html:options collection="userdepartmentkeylist" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                     
<%--		<html:select property="departmentkey" styleClass="forminput1">
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
<%--		<html:select property="activitykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>	
                                    </td></tr>                                                                              
                      
								</table>
    							</td>                                
						        </tr>
     	
        
 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.status"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
	              						<tr><td class="label2">
<bean:message key="prompt.invoicestatus"/>:
    	                                </td></tr>   
            	  						<tr><td class="label2">
                      <c:if test="${OrderhdrForm.invoicestatus == 'NOT INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${OrderhdrForm.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${OrderhdrForm.invoicestatus == 'FULLY INVOICED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${OrderhdrForm.invoicestatus}"/>'/>
                      </c:if>	
                      <c:if test="${OrderhdrForm.invoicestatus == 'PART INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${OrderhdrForm.invoicestatus}"/>'/>
                      </c:if>			  
        <bean:write name="OrderhdrForm" property="invoicestatus" scope="session"/>
                	                    </td></tr>                                                                                
                                            
                                
	              						<tr><td class="label2">
<bean:message key="prompt.completed"/>:
    	                                </td></tr>   
            	  						<tr><td class="label2">
<html:select property="completeflag" styleClass="forminput1">
			<html:option value="false">No</html:option>    
			<html:option value="true">Yes</html:option>        
</html:select> 
               	                    </td></tr>  
                                                                                             
									</table>
    							</td>
						    </tr>
                            
                            
 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.product"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
        	     						<tr><td class="label2"><bean:message key="prompt.primaryproduct"/>:</td></tr>
            	  						<tr><td class="label2">
		<html:select property="productkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option>
			<html:options collection="products" property="productkey" labelProperty="tradname"/>	
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
		<html:textarea rows="5" cols="110"  property="notes" styleClass="forminput1"/>	
                	                    </td></tr>    
                                                         
									</table>
    							</td>
						    </tr>  
                                    
                                                                                                                                                   
           					</logic:notEqual>
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
                        
				            <logic:equal name="OrderhdrForm" property="action"   scope="session" value="Create">                             
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>                                          
				            </logic:equal>
                                   
                                                                
          					<logic:equal name="OrderhdrForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="OrderhdrForm" property="action"   scope="session" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>                                 
							<logic:notEqual name="OrderhdrForm" property="action"   scope="session" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="OrderhdrForm" property="action"   scope="session" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOrderhdr.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>    
                            
				            <logic:equal name="OrderhdrForm" property="action"   scope="session" value="Create">   
                                                    
        <html:submit styleClass="btn btnFF" property="copyQuotationButton">
          <bean:message key="button.copyquote"/>
        </html:submit>  
                                  	
		<html:text property="copyQuoteId" size="30" maxlength="20" styleClass="forminput1"/> 
                            </logic:equal>
                                                                                                                                      
				        </div>
                 
      				</td>
				</tr>


    				</table>
                    
                    </div>
                    
    
</html:form>
    


				</div>
              

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>

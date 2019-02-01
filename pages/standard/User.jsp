<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
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
<logic:equal name="UserForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="UserForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="UserForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="UserForm" property="action" scope="request" value="Create">
		    		<bean:message key="user.title.create"/>
    			</logic:equal>
		    	<logic:equal name="UserForm" property="action" scope="request" value="Delete">
		      		<bean:message key="user.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="UserForm" property="action" scope="request" value="Edit">
		        	<bean:message key="user.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>           
<html:link action="/ListUser"><span class="header4"><bean:message key="user.title.list"/></span></html:link>             						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
    					<html:form action="/SaveUser" focus="userid">
							<html:hidden property="action"/>
							<html:hidden property="readonly"/>
							<html:hidden property="language"/>
							<html:hidden property="country"/>
							<html:hidden property="locale"/>	
							<html:hidden property="copyId"/>
                            
  							<html:hidden property="companykeylist"/>
  							<html:hidden property="departmentkeylist"/>
  							<html:hidden property="activitykeylist"/>
                            
                                                                
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="UserForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.userid"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="userid" size="20" maxlength="150" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="userid"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="UserForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.userid"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${UserForm.action == 'Create'}">
        	<html:text property="userid" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${UserForm.action != 'Create'}">
        	<html:text property="userid" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="userid"/>			
		  </c:if>	                                    
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.name"/>:</td></tr>
              						<tr><td class="label2"><html:text property="name" size="80" maxlength="100" styleClass="forminput1"/></td></tr>
            
                      
								</table>
    						</td>
						    </tr>
                            


								<tr><td class="label1" colspan="2">Contact Details</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.phone"/>:</td></tr>
              						<tr><td class="label2">
 <html:text property="phone" size="40" maxlength="60" styleClass="forminput1"/>                                                                     
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.fax"/>:</td></tr>
              						<tr><td class="label2">
 <html:text property="fax" size="40" maxlength="60" styleClass="forminput1"/>  
                                    </td></tr>
            
                      
								</table>
    						</td>
						    </tr>
                            
                                                        
     					
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Security Information</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.password"/>:</td></tr>
              						<tr><td class="label2">
<html:password property="password" size="15" maxlength="10" redisplay="false" styleClass="forminput1"/>
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.groupid"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="usergroupid" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectagroupid"/></html:option>
			<html:options collection="usergroups" property="usergroupid" labelProperty="usergroupid"/>	
		</html:select>		
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.securitylevel"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="securitylevel" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalevel"/></html:option>
			<html:options collection="prioritys" property="id.codekey" labelProperty="descr"/>	
		</html:select>	
              						</td></tr>                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Email and Printer Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.email"/>:</td></tr>
              						<tr><td class="label2">
		  <html:text property="email" size="30" maxlength="50" styleClass="forminput1"/>
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.mailhost"/>:</td></tr>
              						<tr><td class="label2">
		  <html:text property="mailhost" size="50" maxlength="50" styleClass="forminput1"/>	
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.pagesize"/>:</td></tr>
              						<tr><td class="label2">
		  <html:text property="pagesize" size="15" maxlength="10" styleClass="forminput1"/>	
              						</td></tr>                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                                           
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Company Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.company"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="companykey" styleClass="forminput1">                                    
            <html:option value="">
              <bean:message key="prompt.selectacompany"/>
            </html:option>
            <html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>
          </html:select>
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.department"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="departmentkey" styleClass="forminput1">
            <html:option value="">
              <bean:message key="prompt.selectadepartment"/>
            </html:option>
            <html:options collection="userdepartmentkeylist" property="id.codekey" labelProperty="descr"/>
          </html:select>
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.activity"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="activitykey" styleClass="forminput1">
            <html:option value="">
              <bean:message key="prompt.selectaactivity"/>
            </html:option>
            <html:options collection="useractivitykeylist" property="id.codekey" labelProperty="descr"/>
          </html:select>
              						</td></tr>                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                                
                                
                                
                                <tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Access Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr>
                                    <td class="label2"><bean:message key="prompt.accessaddresses"/></td>
                                    <td class="label2"><bean:message key="prompt.accesslocations"/></td>                                    
                                    </tr>
              						<tr>
                                    <td class="label2">
<html:select property="arraytypekeylist" multiple="true" size="10" styleClass="forminput1">
			<html:options collection="addrtypes" property="typekey" labelProperty="typekey"/>	
</html:select>
              						</td>
                                    <td class="label2">
<html:select property="arraylocationtypelist" multiple="true" size="10" styleClass="forminput1">
			<html:options collection="locationtypes" property="typekey" labelProperty="typekey"/> 	
</html:select> 
              						</td>                                    
                                    </tr>	 
                                    
                                                                             
                                                                                                                   
     						</table>
					    </td>
        					</tr>



                            
                            
                                                                                                                                                  
           					</logic:notEqual>
 
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="UserForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="UserForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="UserForm" property="action"   scope="request" value="Edit">
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

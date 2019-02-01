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





<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="QuonotecustForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="QuonotecustForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="QuonotecustForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="QuonotecustForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.quotno"/>&nbsp;-&nbsp;<bean:write name="ListQuonotecustForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
		    <span class="header2">
    			<logic:equal name="QuonotecustForm" property="action" scope="request" value="Create">
		    		<bean:message key="quonotecust.title.create"/>
    			</logic:equal>
		    	<logic:equal name="QuonotecustForm" property="action" scope="request" value="Delete">
		      		<bean:message key="quonotecust.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="QuonotecustForm" property="action" scope="request" value="Edit">
		        	<bean:message key="quonotecust.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="QuonotecustForm" property="action" scope="request" value="View">
		        	<bean:message key="quonotecust.title.view"/>
     			</logic:equal>	 
                </span>
                <span class="header2">&gt;</span>               	  

			             
<html:link action="/ListQuonotecust"><span class="header4"><bean:message key="quonotecust.title.list"/></span></html:link>
<span class="header2">&gt;</span>                             
<html:link action="/ListQuohdr"><span class="header4"><bean:message key="quohdr.title.list"/></span></html:link>        
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
  
<html:form action="/SaveQuonotecust" focus="priority">
<html:hidden property="action"/>
<html:hidden property="quonotecustId"/>
<html:hidden property="quohdrId"/>
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="QuonotecustForm" property="action"  scope="request" value="Delete">  
 
 								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.priority"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="priority" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.selectapriority"/></html:option>
			<html:options collection="prioritys" property="id.codekey" labelProperty="descr"/>	
		</html:select>
                                    </td></tr>
                                                                        
									<tr><td class="label2"><bean:message key="prompt.category"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="category" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.selectacategory"/></html:option>
			<html:options collection="notecatgs" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                  
                                    </td></tr>            
                      
									<tr><td class="label2"><bean:message key="prompt.status"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="status" size="20" maxlength="10" styleClass="forminput1" disabled="true"/>                                  
                                    </td></tr>   
                                                          
								</table>
    						</td>

       
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.createdate"/>:<html:img src="images/spacer.gif" border="0" width="1" height="15"/></td></tr>                                   
              						<tr><td class="label2">
<bean:write name="QuonotecustForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/><html:img src="images/spacer.gif" border="0" width="1" height="15"/>
              						</td></tr>	  
         							<tr><td class="label2"><bean:message key="prompt.createtime"/>:<html:img src="images/spacer.gif" border="0" width="1" height="15"/></td></tr>                                    
              						<tr><td class="label2">
<bean:write name="QuonotecustForm" property="createtime_" scope="request"/><html:img src="images/spacer.gif" border="0" width="1" height="15"/>
              						</td></tr>                                
          							<tr><td class="label2"><bean:message key="prompt.createdby"/>:<html:img src="images/spacer.gif" border="0" width="1" height="15"/></td></tr>                                  
              						<tr><td class="label2">
<bean:write name="QuonotecustForm" property="createuserid_" scope="request"/>
              						</td></tr>                                                                                                                                                                        
     						</table>
					    </td>

						       	                 
        					</tr>
                               
							</logic:equal>			
    
          
				        	<logic:notEqual name="QuonotecustForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.priority"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="priority" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectapriority"/></html:option>
			<html:options collection="prioritys" property="id.codekey" labelProperty="descr"/>	
		</html:select>
                                    </td></tr>
                                                                        
									<tr><td class="label2"><bean:message key="prompt.category"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="category" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacategory"/></html:option>
			<html:options collection="notecatgs" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                  
                                    </td></tr>            
                      
									<tr><td class="label2"><bean:message key="prompt.status"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="status" size="20" maxlength="10" styleClass="forminput1"/>                                  
                                    </td></tr>   
                                                          
								</table>
    						</td>

       
						       	<td width="50%" valign="top">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.createdate"/>:<html:img src="images/spacer.gif" border="0" width="1" height="15"/></td></tr>                                   
              						<tr><td class="label2">
<bean:write name="QuonotecustForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/><html:img src="images/spacer.gif" border="0" width="1" height="15"/>
              						</td></tr>	  
         							<tr><td class="label2"><bean:message key="prompt.createtime"/>:<html:img src="images/spacer.gif" border="0" width="1" height="15"/></td></tr>                                    
              						<tr><td class="label2">
<bean:write name="QuonotecustForm" property="createtime_" scope="request"/><html:img src="images/spacer.gif" border="0" width="1" height="15"/>
              						</td></tr>                                
          							<tr><td class="label2"><bean:message key="prompt.createdby"/>:<html:img src="images/spacer.gif" border="0" width="1" height="15"/></td></tr>                                  
              						<tr><td class="label2">
<bean:write name="QuonotecustForm" property="createuserid_" scope="request"/>
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
        <html:textarea rows="10" cols="110" property="note1" styleClass="forminput1"/>		                                   
									</td></tr>
		
                                                                                                                      
     						</table>
					    </td>
        					</tr>          
                            
           					</logic:notEqual>
              
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="QuonotecustForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="QuonotecustForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="QuonotecustForm" property="action"   scope="request" value="Edit">
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

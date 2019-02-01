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
  

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<jsp:useBean
  id="AIOutForm"
  class="com.bureaueye.beacon.form.account.AIOutForm"
  scope="request"
/>


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


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="AIOutForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	
<logic:equal name="AIOutForm" property="action"
            scope="request" value="ReSend">
  <title><bean:message key="title.resend"/></title>
</logic:equal>



</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="AIOutForm" property="action" scope="request" value="Create">
		    		<bean:message key="aiout.title.create"/>
    			</logic:equal>
		    	<logic:equal name="AIOutForm" property="action" scope="request" value="Delete">
		      		<bean:message key="aiout.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="AIOutForm" property="action" scope="request" value="Edit">
		        	<bean:message key="aiout.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="AIOutForm" property="action" scope="request" value="View">
		        	<bean:message key="aiout.title.view"/>
     			</logic:equal>	 
		    	<logic:equal name="AIOutForm" property="action" scope="request" value="ReSend">
		        	<bean:message key="aiout.title.resend"/>
     			</logic:equal>	                                	  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListAIOut"><span class="header4"><bean:message key="aiout.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
 						<html:form action="/SaveAIOut">
<html:hidden property="action"/>
                        
							<tr><td><img src="images/spacer.gif" height="2"/></td></tr>                
							  
      
		    				<tr>
			        <td colspan="2">
    <div>
				            <logic:equal name="AIOutForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="AIOutForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="AIOutForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
							<logic:equal name="AIOutForm" property="action"   scope="request" value="ReSend">
				                <button id="buttonResend" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.confirmresend"/></span>
				                </button>  
          					</logic:equal>                            
							<logic:notEqual name="AIOutForm" property="action"   scope="request" value="View">                             
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
				                </button>  
          					</logic:notEqual>  
							<logic:equal name="AIOutForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListAIOut.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                                                       
       </div>
                 
      				</td>
				</tr>
                              
                         
				       		<tr><td><img src="images/spacer.gif" height="2"/></td></tr> 
                            
    
						<logic:equal name="AIOutForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.docid"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="aioutId" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="aioutId"/>
                                        </td></tr>                                                                                                                                                                  				    </table>
							    </td>
						    </tr>
    
						</logic:equal>			


						<logic:equal name="AIOutForm" property="action"  scope="request" value="ReSend">  
 
				        	<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.docid"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="aioutId" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="aioutId"/>
                                        </td></tr>                                                                                                                                                                  				    </table>
							    </td>
						    </tr>
    
						</logic:equal>
                            
          
				        <logic:equal name="AIOutForm" property="action"  scope="request" value="View"> 
 
								<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.docid"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${AIOutForm.action == 'Create'}">
        	<html:text property="aioutId" size="20" maxlength="10" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${AIOutForm.action != 'Create'}">
        	<html:text property="aioutId" size="20" disabled="true" maxlength="10" styleClass="forminput1"/>
			<html:hidden property="aioutId"/>			
		  </c:if>	                                    
                                    </td></tr>
                                        
                                                                                
             						<tr><td class="label2"><bean:message key="prompt.doctype"/>:</td></tr>
              						<tr><td class="label2"><html:text property="doctype" size="20" maxlength="10" styleClass="forminput1"/></td></tr>
     
             						<tr><td class="label2"><bean:message key="prompt.companyid"/>:</td></tr>
              						<tr><td class="label2"><html:text property="companykey" size="20" maxlength="10" styleClass="forminput1"/></td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.status"/>:</td></tr>
              						<tr><td class="label2"><html:text property="aistatus" size="20" maxlength="10" styleClass="forminput1"/></td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.documentkey"/>:</td></tr>
              						<tr><td class="label2"><html:text property="dockey" size="20" maxlength="10" styleClass="forminput1"/></td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.createdate"/>:</td></tr>
              						<tr><td class="label2"><bean:write name="AIOutForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/></td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.senttime"/>:</td></tr>
              						<tr><td class="label2"><bean:write name="AIOutForm" property="sentdate_" format="dd-MMM-yyyy" scope="request"/>&nbsp;<bean:write name="AIOutForm" property="senttime_" scope="request"/></td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.batchid"/>:</td></tr>
              						<tr><td class="label2"><html:text property="aibatchId" size="20" maxlength="10" styleClass="forminput1"/></td></tr>                                                                                                                                                                                                
                      
								</table>
    						</td>
						    	</tr>

						<logic:notEqual name="AIOutForm" property="errors" scope="request" value="">

 			       				<tr><td><img src="images/spacer.gif" height="5"/></td></tr> 
                        
								<tr><td class="label1" colspan="2"><bean:message key="prompt.errorsreceived"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2">
                                    
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>		
		  			<td class="column-header5"><bean:message key="prompt.label"/></td>                    
		  			<td class="column-header6"><bean:message key="prompt.value"/></td>																	
				</tr> 
<%int count=0;%>                               
<x:parse var="errorList">
<%
out.write(AIOutForm.getErrors());
%>
</x:parse>
<x:forEach select="$errorList/errors/error/*" var="ele">
<%
count++;
String _class = "column-cell9";
if ((count % 2) == 0) _class = "column-cell10"; 
%>
  					<tr>                    			
						<td class="<%= _class %>">
<font color="#FF0000"><x:out select="name($ele)" /></font>
						</td> 	
						<td class="<%= _class %>">
<font color="#FF0000"><x:out select="$ele"/></font>
						</td> 			
					</tr>

</x:forEach>    			
			</table>
                                                
                                    </td></tr>                                                                                                                                                                                                   
								</table>
    						</td>
						    	</tr>     		
                                
						</logic:notEqual>
                        
						<logic:notEqual name="AIOutForm" property="warnings" scope="request" value="">

 			       				<tr><td><img src="images/spacer.gif" height="5"/></td></tr> 
                        
								<tr><td class="label1" colspan="2"><bean:message key="prompt.warningsreceived"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2">
                                    
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>		
		  			<td class="column-header5"><bean:message key="prompt.label"/></td>                    
		  			<td class="column-header6"><bean:message key="prompt.value"/></td>																	
				</tr> 
<%int count=0;%>                               
<x:parse var="warningList">
<%
out.write(AIOutForm.getWarnings());
%>
</x:parse>
<x:forEach select="$warningList/warnings/warning/*" var="ele">
<%
count++;
String _class = "column-cell9";
if ((count % 2) == 0) _class = "column-cell10"; 
%>
  					<tr>                    			
						<td class="<%= _class %>">
<font color="#336600"><x:out select="name($ele)" /></font>
						</td> 	
						<td class="<%= _class %>">
<font color="#336600"><x:out select="$ele"/></font>
						</td> 			
					</tr>

</x:forEach>    			
			</table>
                                                
                                    </td></tr>                                                                                                                                                                                                   
								</table>
    						</td>
						    	</tr>     		
                                
						</logic:notEqual>
                                                
						<logic:notEqual name="AIOutForm" property="document" scope="request" value=""> 

 			       				<tr><td><img src="images/spacer.gif" height="5"/></td></tr> 
                        
								<tr><td class="label1" colspan="2"><bean:message key="prompt.headersent"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff"> 
                                                             
									<tr><td class="label2">
                                    
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>		
		  			<td class="column-header5"><bean:message key="prompt.name"/></td>                    
		  			<td class="column-header6"><bean:message key="prompt.value"/></td>																
				</tr> 
<%int count=0;%>                               
<x:parse var="documentList">
<%
out.write(AIOutForm.getDocument());
%>
</x:parse>
<x:forEach select="$documentList/document/header/*" var="ele">
<%
count++;
String _class = "column-cell9";
if ((count % 2) == 0) _class = "column-cell10"; 
%>
  					<tr>			
						<td class="<%= _class %>"><x:out select="name($ele)" /></td> 	
						<td class="<%= _class %>"><x:out select="$ele" /></td> 			
					</tr>	
</x:forEach>
</table>
                                                
                                    </td></tr>
                                    
								</table>
    						</td>
						    	</tr>  
                                                                                                             
                                    
 			       				<tr><td><img src="images/spacer.gif" height="5"/></td></tr> 
                        
								<tr><td class="label1" colspan="2"><bean:message key="prompt.detailssent"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">
										<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff"> 
                                                             
									<tr><td class="label2">
                                                                        
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>		
		  			<td class="column-header5"><bean:message key="prompt.name"/></td>                   
		  			<td class="column-header6"><bean:message key="prompt.value"/></td>                    															
				</tr> 
<%count=0;%>                               
<x:forEach select="$documentList/document/detail/*" var="ele">
<%
count++;
String _class = "column-cell9";
if ((count % 2) == 0) _class = "column-cell10"; 
%>
  					<tr>                    			
						<td class="<%= _class %>">
<x:out select="name($ele)" />                            						
						</td> 	
						<td class="<%= _class %>">
<x:out select="$ele"/>					
						</td> 			
					</tr>	
</x:forEach>    			
</table>
                                                
                                    </td></tr>
                                                                                     
								</table>
    								</td>
						    	</tr>     		
                                
						</logic:notEqual>                        

</logic:equal>
              
              
              

    
						</html:form>
    
    				</table>

				</div>

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>

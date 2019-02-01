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
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="G4codeForm" property="action" scope="request" value="Create">
		    		<bean:message key="gcode.title.create"/>
    			</logic:equal>
		    	<logic:equal name="G4codeForm" property="action" scope="request" value="Delete">
		      		<bean:message key="gcode.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="G4codeForm" property="action" scope="request" value="Edit">
		        	<bean:message key="gcode.title.edit"/>
     			</logic:equal>		  
          		&gt;
            </span>
			<span class="header3">             
      	  		<html:link action="/ListG4code"><bean:message key="gcode.title.list"/> </html:link>        
          	</span>      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SaveG4code" focus="g1codekey">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="g4codeId"/>
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="G4codeForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.g1code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="g1codekey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="g1codekey"/>
                                        </td></tr>
							            <tr><td class="label2"><bean:message key="prompt.g2code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="g2codekey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="g2codekey"/>
                                        </td></tr>
							            <tr><td class="label2"><bean:message key="prompt.g3code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="g3codekey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="g3codekey"/>
                                        </td></tr>  
							            <tr><td class="label2"><bean:message key="prompt.g4code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="g4codekey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="g4codekey"/>
                                        </td></tr>                                                                                          
                                                                                
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="G4codeForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.g1code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        	<html:text property="g1codekey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g1codekey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="g1codekey"/>			
		  </c:if>	                                    
                                    </td></tr>
                                    
									<tr><td class="label2"><bean:message key="prompt.g2code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        	<html:text property="g2codekey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g2codekey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="g2codekey"/>			
		  </c:if>	                                    
                                    </td></tr>                                    
     
									<tr><td class="label2"><bean:message key="prompt.g3code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        	<html:text property="g3codekey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g3codekey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="g3codekey"/>			
		  </c:if>	                                    
                                    </td></tr>  

									<tr><td class="label2"><bean:message key="prompt.g4code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        	<html:text property="g4codekey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g4codekey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="g4codekey"/>			
		  </c:if>	                                                                 
                                    </td></tr>
                                                                            
             						<tr><td class="label2"><bean:message key="prompt.description"/>:</td></tr>
              						<tr><td class="label2"><html:text property="ldesc" size="80" maxlength="100" styleClass="forminput1"/></td></tr>

             						<tr><td class="label2"><bean:message key="prompt.sdesc"/>:</td></tr>
              						<tr><td class="label2"><html:text property="sdesc" size="20" maxlength="10" styleClass="forminput1"/></td></tr>            
                      
								</table>
    						</td>
						    </tr>
     					
                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Location Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.locationcode"/>:</td></tr>
              						<tr><td class="label2">
		  <html:text property="locationcode" size="30" maxlength="50" styleClass="forminput1"/>
              						</td></tr>	 
                                                                                                                                                                               
     						</table>
					    </td>
        					</tr>
                                           
                                                                                   
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="G4codeForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="G4codeForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="G4codeForm" property="action"   scope="request" value="Edit">
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

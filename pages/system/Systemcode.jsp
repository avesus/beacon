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
<logic:equal name="SystemcodeForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SystemcodeForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SystemcodeForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="SystemcodeForm" property="action" scope="request" value="Create">
		    		<bean:message key="systemcode.title.create"/>
    			</logic:equal>
		    	<logic:equal name="SystemcodeForm" property="action" scope="request" value="Delete">
		      		<bean:message key="systemcode.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="SystemcodeForm" property="action" scope="request" value="Edit">
		        	<bean:message key="systemcode.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListSystemcode"><span class="header4"><bean:message key="systemcode.title.list"/></span></html:link>             						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
 						<html:form action="/SaveSystemcode" focus="codekey">
						<html:hidden property="action"/>
						<html:hidden property="readonly"/>
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="SystemcodeForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="codekey" size="30" maxlength="20" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="codekey"/>
                                        </td></tr>                                       
							            <tr><td class="label2"><bean:message key="prompt.type"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="typekey" size="30" maxlength="20" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="typekey"/>
                                        </td></tr>
                                                                                
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="SystemcodeForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${SystemcodeForm.action == 'Create'}">
        	<html:text property="codekey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${SystemcodeForm.action != 'Create'}">
        	<html:text property="codekey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="codekey"/>			
		  </c:if>	                                    
                                    </td></tr>
    
									<tr><td class="label2"><bean:message key="prompt.type"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${SystemcodeForm.action == 'Create'}">
        	<html:text property="typekey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${SystemcodeForm.action != 'Create'}">
        	<html:text property="typekey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="typekey"/>			
		  </c:if>	                                    
                                    </td></tr>
                                        
             						<tr><td class="label2"><bean:message key="prompt.description"/>:</td></tr>
              						<tr><td class="label2"><html:text property="descr" size="80" maxlength="100" styleClass="forminput1"/></td></tr>
            
                      
								</table>
    						</td>
						    	</tr>
     					                                                                                    
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="SystemcodeForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="SystemcodeForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="SystemcodeForm" property="action"   scope="request" value="Edit">
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

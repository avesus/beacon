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
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="CcyexForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="CcyexForm" property="action" scope="request" value="Create">
		    		<bean:message key="ccyex.title.create"/>
    			</logic:equal>
		    	<logic:equal name="CcyexForm" property="action" scope="request" value="Delete">
		      		<bean:message key="ccyex.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="CcyexForm" property="action" scope="request" value="Edit">
		        	<bean:message key="ccyex.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListCcyex"><span class="header4"><bean:message key="ccyex.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SaveCcyex" focus="fromccykey">
<html:hidden property="action"/>
<html:hidden property="ccyexId"/>                        
              
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="CcyexForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.fromcurrency"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="fromccykey" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
                                        <html:hidden property="fromccykey"/>
                                        </td></tr>							            
                                        <tr><td class="label2"><bean:message key="prompt.tocurrency"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="toccykey" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
                                        <html:hidden property="toccykey"/>
                                        </td></tr>
                                        
            						<tr><td class="label2"><bean:message key="prompt.exchangedate"/>:</td></tr>
              						<tr><td class="label2">                              
		<html:select property="exdatedd" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exdatemm" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exdateyyyy" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
			<html:hidden property="exdatedd"/>
			<html:hidden property="exdatemm"/>
			<html:hidden property="exdateyyyy"/>                                                   
                                    </td></tr>
                                                                            
                                                                                                                                                                       				</table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="CcyexForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.fromcurrency"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${CcyexForm.action == 'Create'}">
		<html:select property="fromccykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
		  </c:if>
		  <c:if test="${CcyexForm.action != 'Create'}">
		<html:select property="fromccykey" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
			<html:hidden property="fromccykey"/>			
		  </c:if>	                                    
                                    </td></tr>
                                        
           
									<tr><td class="label2"><bean:message key="prompt.tocurrency"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${CcyexForm.action == 'Create'}">
		<html:select property="toccykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
		  </c:if>
		  <c:if test="${CcyexForm.action != 'Create'}">
		<html:select property="toccykey" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
			<html:hidden property="toccykey"/>			
		  </c:if>	                                    
                                    </td></tr>
                                                                                                                    
             						<tr><td class="label2"><bean:message key="prompt.exchangedate"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${CcyexForm.action == 'Create'}">                               
		<html:select property="exdatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exdatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exdateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		  </c:if>  
		  <c:if test="${CcyexForm.action != 'Create'}">                               
		<html:select property="exdatedd" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exdatemm" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exdateyyyy" styleClass="forminput1" disabled="true">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
			<html:hidden property="exdatedd"/>
			<html:hidden property="exdatemm"/>
			<html:hidden property="exdateyyyy"/>                                
		  </c:if>                     
                                    </td></tr>
     
             						<tr><td class="label2"><bean:message key="prompt.exchangerate"/>:</td></tr>
              						<tr><td class="label2"><html:text property="exrate" size="10" styleClass="forminput1"/></td></tr>                                                                                  
                      
								</table>
    						</td>
						    	</tr>
     					                                                                                    
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="CcyexForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="CcyexForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="CcyexForm" property="action"   scope="request" value="Edit">
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

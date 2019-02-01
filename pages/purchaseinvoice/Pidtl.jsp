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
  
<!-- init extra property methods -->
<%--<bean:define id="vendorjobs" name="PidtlForm" property="vendorjobs"/>--%>


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
				
			}	
	}
    //]]>
</script>







<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="PidtlForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="PidtlForm" property="action" scope="session" value="Create">
		    		<bean:message key="pidtl.title.create"/>
    			</logic:equal>
		    	<logic:equal name="PidtlForm" property="action" scope="session" value="Delete">
		      		<bean:message key="pidtl.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="PidtlForm" property="action" scope="session" value="Edit">
		        	<bean:message key="pidtl.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="PidtlForm" property="action" scope="session" value="View">
		        	<bean:message key="pidtl.title.view"/>
     			</logic:equal>	                	  
            </span>
<span class="header2">&gt;</span>            
<html:link action="/ListPidtl"><span class="header4"><bean:message key="pidtl.title.list"/></span></html:link>  
<span class="header2">&gt;</span>            
<html:link action="/ListPihdr"><span class="header4"><bean:message key="pihdr.title.list"/></span></html:link>        
          	      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SavePidtl" focus="jobno">
	
<html:hidden property="pidtlId"/>
<html:hidden property="pihdrId"/>
<html:hidden property="action"/>
<html:hidden property="copyId"/>
<html:hidden property="invoicestatus"/>
<html:hidden property="jobhdrId"/>       
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="PidtlForm" property="action"  scope="session" value="Delete">  
 
				        	<tr><td class="label1" colspan="3">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.jobno"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="jobno" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="jobno"/>
                                        </td></tr>
                                        
								    </table>
							    </td>
                                
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="PidtlForm" property="action"  scope="session" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" valign="top">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.jobno"/>:</td></tr>
              						<tr><td class="label2">
                                    
<c:if test="${PidtlForm.action == 'Create'}">	
	<select name="jobno" class="forminput1"  size="5">
		<option selected value=""><bean:message key="prompt.selectajob"/></option>
<logic:iterate id="lineItemX" name="PidtlForm" property="vendorjobs" indexId="loopX">           
<%
com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO jobcost = 
	(com.bureaueye.beacon.model.job.dto.JobcostVendorCcyDTO)lineItemX;
%>	
		<option value="<%= jobcost.getJobno() %>"><bean:message key="prompt.jobno"/>: <%= jobcost.getJobno() %> > <bean:message key="prompt.orderno"/>: <%= jobcost.getOrderno() %></option>	
</logic:iterate>
                
	</select>	
</c:if>		
<c:if test="${PidtlForm.action != 'Create'}">			  
<%--		<html:select property="jobno" disabled="true" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectajob"/></html:option> 
		<html:options collection="vendorjobs" property="jobno" labelProperty="jobno"/>
		</html:select> --%>
        <html:text property="jobno" disabled="true" size="10" maxlength="10" styleClass="forminput1"/>                
	<html:hidden property="jobno"/>	    
</c:if>	
		                                    
                                    </td></tr>
                                    
							        <tr><td class="label2"><bean:message key="prompt.invoiceamt"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="invoiceamt" size="10" maxlength="10" styleClass="forminput1"/>
                                    </td></tr>                                    
                    
								</table>
    						</td>    
                                                            
						    </tr>
     					

 

 
                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.additionalnotes"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                 
              					<tr><td class="label2">                      
        <html:textarea rows="5" cols="110" property="txt1" styleClass="forminput1"/>
                                </td></tr>
                                                                                                                                
									</table>
							    </td>
                                
        					</tr>


                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3">Costs already allocated for Purchase Invoice Detail</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                 
              					<tr><td class="label2">                      
									<table width="70%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
				<tr>		
		  			<td class="column-header5" width="60%">
					<bean:message key="prompt.cost"/></td>                    
		  			<td class="column-header6" width="20%" align="right">
					<bean:message key="prompt.estimatecost"/></td>
		  			<td class="column-header6" width="20%" align="right">
					<bean:message key="prompt.actualcost"/></td>																	
				</tr>                

			<c:forEach var="lineItem" items="${PidtlForm.pidtlcosts}" varStatus="loop">
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
</table>	
                                </td></tr>
                                                                                                                                
									</table>
							    </td>
                                
        					</tr>
                            
                                                     
                         
                                                                                                                                                            
           					</logic:notEqual>
              
      
      
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="PidtlForm" property="action"   scope="session" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="PidtlForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="PidtlForm" property="action"   scope="session" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
							<logic:notEqual name="PidtlForm" property="action"   scope="session" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="PidtlForm" property="action"   scope="session" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListPidtl.do'">
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

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
<logic:equal name="TrackForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="TrackForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="TrackForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="TrackForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="TrackForm" property="action" scope="session" value="Create">
		    		<bean:message key="track.title.create"/>
    			</logic:equal>
		    	<logic:equal name="TrackForm" property="action" scope="session" value="Delete">
		      		<bean:message key="track.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="TrackForm" property="action" scope="session" value="Edit">
		        	<bean:message key="track.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="TrackForm" property="action" scope="session" value="View">
		        	<bean:message key="track.title.view"/>
     			</logic:equal>	                	  
          		&gt;
            </span>
			<span class="header3">             
      	  		<html:link action="/ListTrack"><bean:message key="track.title.list"/> </html:link>        
          	</span>      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
<%--						<tr><td colspan="2"><html:errors/></td></tr>--%>
                        
<tr><td colspan="2">		
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <span class="label2"><bean:write name="error"/></span>
              <bean:message key="errors.suffix"/>
            </html:messages>
</td></tr>
<tr><td colspan="2">            
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <span class="label2"><bean:write name="msg"/></span>
              <bean:message key="messages.suffix"/>
            </html:messages>
</td></tr>            
            
                                                                                    
  
<html:form action="/SaveTrack" enctype="multipart/form-data">
<html:hidden property="action"/>
<html:hidden property="docid"/>
<html:hidden property="doctype"/>
<html:hidden property="xdocumentId"/>
<html:hidden property="dockey"/>
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
          
							<tr><td class="label1" colspan="2">General</td></tr>

							<tr><td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            <td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.docid"/>:</td></tr>
              						<tr><td class="label2"><html:text property="docid" disabled="true" size="30" maxlength="20" styleClass="forminput1"/></td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.doctype"/>:</td></tr>
              						<tr><td class="label2"><html:text property="doctype" disabled="true" size="30" maxlength="20" styleClass="forminput1"/></td></tr>
            
            
         							<tr><td class="label2"><bean:message key="prompt.description"/>:</td></tr>
              						<tr><td class="label2">
 <html:text property="description"  disabled="true" size="50" maxlength="100" styleClass="forminput1"/>
              						</td></tr>	 
          
								</table>
    						</td>
					    </tr>
    
     					<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
								<tr><td class="label1" colspan="2">Additional Details</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.additionalnotes"/>:</td></tr>
              						<tr><td class="label2">
 <html:textarea property="txt1"  disabled="true" rows="3" cols="80" styleClass="forminput1"/>                         
                                    </td></tr>
                     
									<tr><td class="label2"><bean:message key="prompt.categorycode"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="categorycode"  disabled="true" size="50" maxlength="100" styleClass="forminput1"/>                              
                                    </td></tr>
                                                         
								</table>
    						</td>
						    </tr>


 
<!--<logic:equal name="TrackForm" property="createaction" value="STORE"> 
               
<logic:equal name="TrackForm" property="checkoutflag" value="false">

     					<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
								<tr><td class="label1" colspan="2"><bean:message key="heading.checkoutdetails"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
            
            <tr><td>            
<%--<input type="image" value='<bean:message key="button.checkout"/>' name="checkoutButton" src="images/checkout_button.gif"/>--%>

	<div class="btnPane3">
		<button class="btn btnFF" type="submit" name="checkoutButton">
        		<img class=" IM2 Checkout-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />        
        		<span>Check Out</span>
       	</button>                           
 	</div>

</td>
        </tr>
                  
        </table>
        
        							</td>
        
     							</tr>
                            
</logic:equal>
  
    
<logic:equal name="TrackForm" property="checkoutflag" value="true">
                                            
    					<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
								<tr><td class="label1" colspan="2"><bean:message key="heading.checkoutdetails"/></td></tr>

								<tr>                       
        	                    	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
								
            	                	<td width="100%">
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff"><tr><td>                                    
								<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
				<tr>		

		  			<td class="column-header1" width="30%"><bean:message key="heading.date"/></td> 
                    <td class="column-header2" width="30%"><bean:message key="heading.time"/></td>	                   
		  			<td class="column-header2" width="20%"><bean:message key="heading.user"/></td>	
		  			<td class="column-header3" width="20%"></td>	
                    				</tr>

<%String _class = "column-cell2";%>
		
  				<tr>	

					<td class="<%= _class %>"><bean:write name="TrackForm" property="checkoutdate" format="dd-MMM-yyyy" filter="true"/></td> 	
                    <td class="<%= _class %>"><bean:write name="TrackForm" property="checkouttime" filter="true"/></td>	
					<td class="<%= _class %>">
                    <bean:write name="TrackForm" property="checkoutuserid" filter="true"/></td>					
 					<td class="<%= _class %>">
	<div class="btnPane3">
		<button class="btn btnFF" type="submit" name="undocheckoutButton">
        		<img class=" IM2 Discard-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />        
        		<span>Discard</span>
       	</button>                           
 	</div>                                                         

                                    </td> 
                                                  	                    	
				</tr>							
			
            	</table>
                
                				</td></tr></table>
                                
    								</td>
								</tr>
            
  
            

<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
<tr><td class="label1" colspan="2">Check In</td></tr>

<tr>                       
        	                    	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
								
            	                	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">           
            
    
	<tr><td class="label2"><html:file property="infile"/></td></tr>
        
	<tr><td class="label2"><bean:message key="prompt.versiondescription"/>:&nbsp;<html:text property="versiondescription" size="30" maxlength="50" styleClass="forminput1"/></td></tr>
    <tr><td>
	<div class="btnPane3">   
			<button class="btn btnFF" type="submit" name="checkinButton">
        		<img class=" IM2 Checkin-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>Check In</span>
        	</button>                           
 	</div>
        
    </td></tr> 
    
           
        </table>        
        							</td>        
</tr>

                            
	</logic:equal> 

       
</logic:equal> -->






     					<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
								<tr><td class="label1" colspan="2"><bean:message key="heading.documentversions"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff"><tr><td>                                    
								<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
				<tr>		

		  			<td class="column-header1" width="10%"><bean:message key="heading.verno"/></td> 
                    <td class="column-header2" width="18%"><bean:message key="heading.versiondate"/></td>	                   
		  			<td class="column-header2" width="55%"><bean:message key="heading.versiondescription"/></td>	
                    <td class="column-header3" width="17%"></td>	
                                        														
				</tr>
<%int row=0;%>
			<c:forEach var="lineItem" items="${TrackForm.xdocumentversions}" varStatus="loop">
            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>

  				<tr>
<td class="<%= _class %>"><c:out value="${lineItem.versionno}"/></td>
<td class="<%= _class %>"><bean:write name="lineItem" property="versiondate" format="dd-MMM-yyyy" filter="true"/></td>
<td class="<%= _class %>"><c:out value="${lineItem.versiondescription}"/></td> 	
<td class="<%= _class %>" align="right">
<html:link action="/DisplayDocumentversion.do" paramId="xdocumentversionId" paramName="lineItem" paramProperty="xdocumentversionId"><bean:message key="prompt.viewdocument"/>
</html:link>
</td>                  	                    	
				</tr>	
                						
			</c:forEach>	
            	
            </table>	
            
                				</td></tr></table>

    								</td>
						    	</tr>
                            

                               
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
        			<td colspan="2">
    
				        <div class="btnPane"> 
			                <button id="buttonExit" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
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

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
<logic:equal name="SystemtaskForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SystemtaskForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SystemtaskForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="SystemtaskForm" property="action" scope="request" value="Create">
		    		<bean:message key="systemtask.title.create"/>
    			</logic:equal>
		    	<logic:equal name="SystemtaskForm" property="action" scope="request" value="Delete">
		      		<bean:message key="systemtask.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="SystemtaskForm" property="action" scope="request" value="Edit">
		        	<bean:message key="systemtask.title.edit"/>
     			</logic:equal>		  
          		&gt;
            </span>
			<span class="header3">             
      	  		<html:link action="/ListSystemtask"><bean:message key="systemtask.title.list"/> </html:link>        
          	</span>      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
						<html:form action="/SaveSystemtask" focus="taskid">
						<html:hidden property="action"/>
						<html:hidden property="readonly"/>
						<html:hidden property="systemtaskId"/>
						<html:hidden property="nextruntimeinmillis"/>
						<html:hidden property="nextrun"/>
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="SystemtaskForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.taskid"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="taskid" size="30" maxlength="20" disabled="true" styleClass="forminput1"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="SystemtaskForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.taskid"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${SystemtaskForm.action == 'Create'}">
        	<html:text property="taskid" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${SystemtaskForm.action != 'Create'}">
        	<html:text property="taskid" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="taskid"/>			
		  </c:if>	                                    
                                    </td></tr>          
                      
								</table>
    						</td>
						    </tr>
     					
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Run Information</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2">Run Each:</td></tr>
              						<tr><td class="label2">
 		<html:select property="runatperiod1" onchange="screenRefresh();" styleClass="forminput1">
			<html:option value="">- select a Run period -</html:option>
            <html:option value="MINUTE">MINUTE</html:option>		
            <html:option value="DAY">DAY</html:option>				
			<html:option value="HOUR">HOUR</html:option>
            <html:option value="WEEK">WEEK</html:option>	
			<html:option value="MONTH">MONTH</html:option>                        
		</html:select> 
              						</td></tr>	 
                                              
         							<tr><td class="label2"> Run Every:</td></tr>
              						<tr><td class="label2">
        <html:text property="runatperiod2" size="30" maxlength="40" styleClass="forminput1"/>  	
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.runathour"/>:</td></tr>
              						<tr><td class="label2">
 		<html:select property="runathour" styleClass="forminput1">
			<html:option value="00">00</html:option>	
  			<html:option value="1">1</html:option>
  			<html:option value="2">2</html:option>
  			<html:option value="3">3</html:option>
  			<html:option value="4">4</html:option>
  			<html:option value="5">5</html:option>
   			<html:option value="6">6</html:option>
  			<html:option value="7">7</html:option>
  			<html:option value="8">8</html:option>
  			<html:option value="9">9</html:option>
  			<html:option value="10">10</html:option>			
  			<html:option value="11">11</html:option>	
  			<html:option value="12">12</html:option>	
  			<html:option value="13">13</html:option>	
  			<html:option value="14">14</html:option>	
  			<html:option value="15">15</html:option>	
  			<html:option value="16">16</html:option>	
  			<html:option value="17">17</html:option>	
  			<html:option value="18">18</html:option>	
  			<html:option value="19">19</html:option>	
  			<html:option value="20">20</html:option>	
  			<html:option value="21">21</html:option>	
  			<html:option value="22">22</html:option>	
  			<html:option value="23">23</html:option>                                                                                               
            <!--<html:options collection="hours" property="value" labelProperty="label"/>-->
		</html:select>  
              						</td></tr>
                                    
         							<tr><td class="label2"><bean:message key="prompt.runatminute"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="runatminute" styleClass="forminput1">
			<html:option value="00">00</html:option>
            <html:option value="15">15</html:option>
            <html:option value="30">30</html:option>
            <html:option value="45">45</html:option>	
		</html:select>	
              						</td></tr>                                                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Run When Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.nextruntime"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="nextrundatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="nextrundatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="nextrundateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="nextruntimehh" styleClass="forminput1">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="nextruntimemm" styleClass="forminput1">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>	
        &nbsp;
<strong><bean:write name="SystemtaskForm" property="nextrun" scope="request"/></strong>
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.lastruntime"/>:</td></tr>
              						<tr><td class="label2">
<strong><bean:write name="SystemtaskForm" property="lastrundate_" scope="request"/>&nbsp;<bean:write name="SystemtaskForm" property="lastruntime_" scope="request"/></strong>  
              						</td></tr>
                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                                           
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Task Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.taskclass"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="taskclass" size="80" maxlength="100" styleClass="forminput1"/>  
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.taskstatus"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="taskstatus" size="40" maxlength="20" styleClass="forminput1"/>  
              						</td></tr>
                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                                                                                    
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="SystemtaskForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="SystemtaskForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="SystemtaskForm" property="action"   scope="request" value="Edit">
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

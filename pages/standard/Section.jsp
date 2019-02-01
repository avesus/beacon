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
<logic:equal name="SectionForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="SectionForm" property="action" scope="request" value="Create">
		    		<bean:message key="section.title.create"/>
    			</logic:equal>
		    	<logic:equal name="SectionForm" property="action" scope="request" value="Delete">
		      		<bean:message key="section.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="SectionForm" property="action" scope="request" value="Edit">
		        	<bean:message key="section.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListSection"><span class="header4"><bean:message key="section.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:600px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
 						<html:form action="/SaveSection" focus="countrykey">
						<html:hidden property="action"/>
                        
              
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="SectionForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.section"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="sectionkey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="sectionkey"/>
                                        </td></tr>                                                                                                                                                                  				    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="SectionForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.section"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${SectionForm.action == 'Create'}">
        	<html:text property="sectionkey" size="20" maxlength="10" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${SectionForm.action != 'Create'}">
        	<html:text property="sectionkey" size="20" disabled="true" maxlength="10" styleClass="forminput1"/>
			<html:hidden property="sectionkey"/>			
		  </c:if>	                                    
                                    </td></tr>
                                        
									<tr><td class="label2"><bean:message key="prompt.description"/>:</td></tr>
              						<tr><td class="label2">
        	<html:text property="descr" size="50" maxlength="50" styleClass="forminput1"/>                                    
                                    </td></tr>
                                                                                                                                                   									<tr><td class="label2"><bean:message key="prompt.section.mandrflag"/>:</td></tr>
              						<tr><td class="label2">
        	<html:checkbox property="mandrflag" styleClass="forminput1" />                                  
                                    </td></tr>  
                                                   
 									<tr><td class="label2"><bean:message key="prompt.inventorystatus"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="invsts" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select>	                                
                                    </td></tr> 
 
  									<tr><td class="label2"><bean:message key="prompt.movementstatus"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="movests" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="movestatuss" property="id.codekey" labelProperty="descr"/>
		</html:select>		                                
                                    </td></tr> 
 
   									<tr><td class="label2"><bean:message key="prompt.section.transporttype"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="transportmode" styleClass="forminput1">
			<html:option value=""/>
			<html:options collection="transportmodes" property="transportmode" labelProperty="descr"/>	
		</html:select>	                                
                                    </td></tr> 
                                    
   									<tr><td class="label2"><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="50%" class="label2">
		  <bean:message key="prompt.fromlocationvalidtypes"/>
		  </td>
          <td width="50%" class="label2">
		  <bean:message key="prompt.tolocationvalidtypes"/>
		  </td>		  
        </tr>								
        <tr>
          <td width="50%" class="label2">
<html:select property="arrayfromlocationtype" multiple="true" size="10" styleClass="forminput1">
			<html:options collection="locationtypes" property="typekey"/>	
</html:select>
          </td>
          <td width="50%" class="label2">
<html:select property="arraytolocationtype" multiple="true" size="10" styleClass="forminput1">
			<html:options collection="locationtypes" property="typekey"/>
</html:select>
          </td>
        </tr>					
    </table></td></tr>                                                 

                                                                                                                                    
								</table>
    						</td>
						    	</tr>
     					                                                                                    
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="SectionForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="SectionForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="SectionForm" property="action"   scope="request" value="Edit">
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

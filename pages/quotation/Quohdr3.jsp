<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 *  												
 --%>
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
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
				document.forms[0].exitButton.disabled = false;	
				document.forms[0].forwardname.disabled = false;		
				document.forms[0].action.disabled = false;						
			}	
	}
	
	function navigateTo(forwardName) {
		document.forms[0].forwardname.value=forwardName;
		document.forms[0].submit();		
	}	
    //]]>
</script>




<script type="text/javascript">
//<![CDATA[
function checkExchgdateupd() 
{
	var dd = document.forms[0].exchgdatedd.value;
	var mm = document.forms[0].exchgdatemm.value;
	var yyyy = document.forms[0].exchgdateyyyy.value;
	var dd_ = document.forms[0].exchgdatedd_.value;
	var mm_ = document.forms[0].exchgdatemm_.value;
	var yyyy_ = document.forms[0].exchgdateyyyy_.value;
	var ele = document.getElementById('div_exchgrateupd');
	ele.style.display = "none";
	if (dd!=dd_||mm!=mm_||yyyy!=yyyy_) {
		ele.style.display = "block";
	}
}
//]]>
</script>




<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="css/navigation.css" />


<head>
<logic:equal name="QuohdrForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="QuohdrForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>




</head>

<un:bind var="servletKey" type="ord.apache.struts.Globals" field="SERVLET_KEY"/>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td colspan="2">
<span class="header2">
    			<logic:equal name="QuohdrForm" property="action" scope="session" value="Create">
		    		<bean:message key="quohdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="QuohdrForm" property="action" scope="session" value="Delete">
		      		<bean:message key="quohdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="QuohdrForm" property="action" scope="session" value="Edit">
		        	<bean:message key="quohdr.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="QuohdrForm" property="action" scope="session" value="View">
		        	<bean:message key="quohdr.title.view"/>
     			</logic:equal>	                	  
</span>
<span class="header2">&gt;</span>			             
<html:link action="/ListQuohdr"><span class="header4"><bean:message key="quohdr.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td colspan="2">
	
				<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">




  
<html:form action="/SaveQuohdr" focus="shipmethod">
<html:hidden property="action"/>
<html:hidden property="forwardname" value=""/>
<html:hidden property="id"/>
<html:hidden property="copyId"/>
<html:hidden name="user" property="securitylevel"/>

<html:hidden property="ldgg1key1"/>
<html:hidden property="ldgg2key1"/>
<html:hidden property="ldgg3key1"/>
<html:hidden property="ldgg4key1"/>
<html:hidden property="ldgg1key2"/>
<html:hidden property="ldgg2key2"/>
<html:hidden property="ldgg3key2"/>
<html:hidden property="ldgg4key2"/>
<html:hidden property="dchg1key1"/>
<html:hidden property="dchg2key1"/>
<html:hidden property="dchg3key1"/>
<html:hidden property="dchg4key1"/>
<html:hidden property="dchg1key2"/>
<html:hidden property="dchg2key2"/>
<html:hidden property="dchg3key2"/>
<html:hidden property="dchg4key2"/>
        


<div id="secondaryNav">
    
    <div class="secNavOuterPane">
    
    <div id="secNavDividerLeft"></div>
    <div id="secNavDividerTitle"></div>
    <div id="secNavDividerRight"></div>
    
<div id="secNavPane">
      
    <div id="General" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('quohdr1');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite General" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />General
    </span>
    </a>
    </span>
    </div>

   <div id="Customer" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('quohdr2');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite Address" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Customer
    </span>
    </a>
    </span>
    </div>
          
    <div id="Logistic" class="secNavBtnSelected HorizontalSprite SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('quohdr3');">
    <span class="secNavBtnLnkContent">
    <img class="secNavBtnLnkIcon MainNavigationSprite Logistic" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Logistic
    </span>
    </a>
    </span>
    </div>
           
    </div>       
     
    </div>
    
</div>



<div style="position:relative;">


				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>

                                          
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
	
    
          
				        <logic:notEqual name="QuohdrForm" property="action"  scope="session" value="Delete"> 
                             
			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.logisticdetails"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
             							<tr><td class="label2"><bean:message key="prompt.shipmethod"/>:</td></tr>
	              						<tr><td class="label2">
		<html:select property="shipmethod" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectashipmethod"/></html:option>
			<html:options collection="shipmethods" property="id.codekey" labelProperty="descr"/>	
		</html:select>	
    	                                </td></tr>   
                                                                       
        	     						<tr><td class="label2"><bean:message key="prompt.incoterm"/>:</td></tr>
            	  						<tr><td class="label2">
		<html:select property="incotermkey" styleClass="forminput1">
			<html:option value=""> <bean:message key="prompt.selectaterm"/></html:option>
			<html:options collection="incoterms" property="incotermkey" labelProperty="description"/>	
		</html:select>
                	                    </td></tr>                                                                                
                                                         
									</table>
    							</td>
						    </tr>                             
 




 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.locationdetails"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.pickupplant"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="ldglocationkey1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="pickuplocations1" property="locationkey" labelProperty="shortName"/>	
		</html:select>			
    	                                	</td>                                          
                                        </tr>

             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.portloading"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="ldglocationkey2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>	
		</html:select>			
    	                                	</td>                                          
                                        </tr>

             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.portdischarge"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="dchlocationkey2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>	
		</html:select>				
    	                                	</td>                                          
                                        </tr>

             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.deliveryplant"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="dchlocationkey1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="deliverylocations1" property="locationkey" labelProperty="shortName"/>	
		</html:select>			
    	                                	</td>                                          
                                        </tr>
                                                                                
                                	</table>
    							</td>
						    </tr>   
                            
                            
                            
 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.demurrage"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.location"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="dmrglocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>		
    	                                	</td>                                          
                                        </tr>

             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.freedays"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		  <html:text property="dmrgfreedays" size="5" maxlength="5" styleClass="forminput1"/> 	
    	                                	</td>                                          
                                        </tr>

             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.ccy"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
					<html:select property="dmrgccykey" styleClass="forminput1"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>		
    	                                	</td>                                          
                                        </tr>
                                        
                                        <tr>
                                        	<td class="label2" width="30%">
		        <bean:message key="prompt.rates"/>:		  
                
<!--REMOVED THIS FOR NOW *10-JUN-2013* NOT SURE IF THIS WILL WORK QUOHDR TAB SCREENS--
<INPUT type="image" id="findDmrgratesButton" name="findDmrgratesButton" src="images/arrow_next_grey.gif"/>	
-->                                            
                                            </td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
<table border="0" width="50%" cellpadding="0" cellspacing="1" bgcolor="#7F9DB9">
	<tr>
		<td class="label2" align="center">
		<bean:message key="prompt.period1"/>
		</td>
		<td class="label2" align="center">
		<bean:message key="prompt.period2"/>
		</td>
		<td class="label2" align="center">
		<bean:message key="prompt.period3"/>
		</td>
	</tr>
	<tr>
		<td class="label2">
			<table border="0" width="100%">
				<tr>
					<td class="label2">
					<bean:message key="prompt.days"/>
					</td>
					<td class="label2">
					<bean:message key="prompt.rate"/>
					</td>
				</tr>
				<tr>
					<td class="label2">
        <html:text property="dmrgdays1" size="5" maxlength="5" styleClass="forminput1"/>					
					</td>
					<td class="label2">
        <html:text property="dmrgdlyrate1" size="5" maxlength="8" styleClass="forminput1"/>					
					</td>
				</tr>								
			</table>
		</td>
		<td class="label2">
			<table border="0" width="100%">
				<tr>
					<td class="label2">
					<bean:message key="prompt.days"/>
					</td>
					<td class="label2">
					<bean:message key="prompt.rate"/>
					</td>
				</tr>
				<tr>
					<td class="label2">
        <html:text property="dmrgdays2" size="5" maxlength="5" styleClass="forminput1"/>					
					</td>
					<td class="label2">
        <html:text property="dmrgdlyrate2" size="5" maxlength="8" styleClass="forminput1"/>
					</td>
				</tr>								
			</table>		
		</td>
		<td class="label2">
			<table border="0" width="100%">
				<tr>
					<td class="label2">
					<bean:message key="prompt.rate"/>
					</td>
				</tr>
				<tr>
					<td class="label2">
<html:text property="dmrgdlyrate3" size="5" maxlength="8" styleClass="forminput1"/>					
					</td>
				</tr>								
			</table>		
		</td>
	</tr>	
</table>  		
    	                                	</td>                                          
                                        </tr>                                                                                                                       
                                	</table>
    							</td>
						    </tr>   
                                                        
                                                                                             
           				</logic:notEqual>
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="QuohdrForm" property="action"   scope="session" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="QuohdrForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="QuohdrForm" property="action"   scope="session" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>                                 
							<logic:notEqual name="QuohdrForm" property="action"   scope="session" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="QuohdrForm" property="action"   scope="session" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListQuohdr.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                                                                                  
				        </div>
                 
      				</td>
				</tr>


    				</table>
                    
                    </div>
                    
    
</html:form>
    


				</div>
              

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>

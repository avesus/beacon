<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 * NT	2009-03-23		ITT-200904-0001		Add Quotno Auto Generation
 * 											
 * NT	2010-01-19		201000006			Replace Addresss with Customers in Customer Name pull-down
 *
 * NT	2010-02-15		ITT-201001-0001		Add Demurrage Currency
 *
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 * NT	2011-05-23		ITT-201105-0001		Quotation Exchange Rates Update 
 *
 * NT 2014-02-25 201400003 Add User Companylist, Departmentlist and Activitlist to Main Entry Screens (changes not commented)
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
				document.forms[0].action.value == 'View' 
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




  
<html:form action="/SaveQuohdr" focus="quotno">
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
        

<logic:notEqual name="QuohdrForm" property="action"  scope="session" value="Delete"> 
<div id="secondaryNav">
    
    <div class="secNavOuterPane">
    
    <div id="secNavDividerLeft"></div>
    <div id="secNavDividerTitle"></div>
    <div id="secNavDividerRight"></div>
    
<div id="secNavPane">
      
    <div id="General" class="secNavBtnSelected HorizontalSprite SecNavBg">
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
          
    <div id="Logistic" class="secNavBtn SecNavBg">
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
</logic:notEqual>


<div style="position:relative;">


				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
                               
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    

    
							<logic:equal name="QuohdrForm" property="action"  scope="session" value="Delete">  
 
				        	<tr><td class="label1" colspan="3"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.quotno"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="quotno" size="30" maxlength="40" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="quotno"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="QuohdrForm" property="action"  scope="session" value="Delete"> 



				       		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                            
                             
								<tr><td class="label1" colspan="3"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2" colspan="2"><bean:message key="prompt.quotno"/>:</td></tr>
              						<tr><td class="label2" colspan="2">
                                    
<c:set var="quotnoAutoGenerate">
<bean:message bundle="systemResources" key="quotno.auto.generate"/>
</c:set> 
                                    
		  <c:if test="${QuohdrForm.action == 'Create' and quotnoAutoGenerate == 'no'}">
        	<html:text property="quotno" size="30" maxlength="40" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${QuohdrForm.action != 'Create' or quotnoAutoGenerate == 'yes'}">
        	<html:text property="quotno" size="30" disabled="true" maxlength="40" styleClass="forminput1"/>
			<html:hidden property="quotno"/>			
		  </c:if>  
                                            
                                    </td></tr>
    
    
             						<tr><td class="label2" colspan="2"><bean:message key="prompt.quotedate"/>:</td></tr>
              						<tr><td class="label2" colspan="2">
		<html:select property="quotedatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="quotedatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="quotedateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
                                    </td></tr>

             						<tr><td class="label2" colspan="2"><bean:message key="prompt.effectivedate"/>:</td></tr>
              						<tr><td class="label2" colspan="2">
		<html:select property="effectivedatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="effectivedatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="effectivedateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  
                                    </td></tr>    
                                    
             						<tr><td class="label2" colspan="2"><bean:message key="prompt.expirydate"/>:</td></tr>
              						<tr><td class="label2" colspan="2">
		<html:select property="expirydatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="expirydatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="expirydateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
                                    </td></tr>                                              
 
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.exchgdate"/>:</td></tr>
              						<tr><td class="label2" valign="top">
		<html:select property="exchgdatedd" styleClass="forminput1" onchange="checkExchgdateupd();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exchgdatemm" styleClass="forminput1" onchange="checkExchgdateupd();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exchgdateyyyy" styleClass="forminput1" onchange="checkExchgdateupd();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
                                    </td>
                                    </tr>
                                    <tr>
                                    <td class="label2">  
<!--sITT-201105-0001-->       
<input type="hidden" name="exchgdatedd_" value='<bean:write property="exchgdatedd" name="QuohdrForm" />'/>
<input type="hidden" name="exchgdatemm_" value='<bean:write property="exchgdatemm" name="QuohdrForm" />'/>
<input type="hidden" name="exchgdateyyyy_" value='<bean:write property="exchgdateyyyy" name="QuohdrForm" />'/>       	
<div id='div_exchgrateupd' style='position:relative; width:400px; height:41px; display: none; border: 1px solid #5989D7;'>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#5989D7">
          <tr>
            <td style="font-family: Arial;font-size: 10px; font-weight: normal; color: white; padding:2px 2px 2px 2px; background:#5989D7;">Quotation Exchange Rate Update</td>               
          </tr>	          
          <tr>
            <td style="font-family: Arial;font-size: 10px; font-weight: normal; color: black; padding:2px 2px 2px 2px; background-color:#ECE9D8;">
              Would you like to update the Quotation Charge and Cost lines<br/> 
              using the new Exchange Rate Date entered? <input type="checkbox" name="exchgrateupd" styleClass="forminput1" value='YES'/>
            </td>               
          </tr>			 
	</table>
</div>			
<script language="JavaScript">
<!--
var ele = document.getElementById('div_exchgrateupd');
ele.style.display = "none";
-->
</script>
<!--eITT-201105-0001-->
									</td></tr>
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.quotecurrency"/>:</td></tr>
              						<tr><td class="label2" valign="top">
		  		<c:if test="${QuohdrForm.action == 'Create'}">
					<html:select property="ccykey" styleClass="forminput1"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>				
				</c:if>	
		  		<c:if test="${QuohdrForm.action != 'Create'}">
					<html:select property="ccykey" styleClass="forminput1" disabled="true"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>	
					<html:hidden property="ccykey"/>			
				</c:if>	
                                    </td>
                                    </tr>
                                    
            						<tr><td class="label2" colspan="2"><bean:message key="prompt.contracttype"/>:</td></tr>
              						<tr><td class="label2" valign="top">
					<html:select property="contracttype" styleClass="forminput1"> 
						<html:option value=""><bean:message key="prompt.selectatype"/></html:option> 
			<html:options collection="contracttypes" property="id.codekey" labelProperty="descr"/>										
					</html:select>				
                                    </td>
                                    </tr>                                    
                                                                                             
								</table>
    							</td>
                                
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.createdby"/>:</td></tr>
              						<tr><td class="label2">  
        	<html:text property="quotebyuserid" size="10" disabled="true" maxlength="10" styleClass="forminput1"/>
			<html:hidden property="quotebyuserid"/>                                  
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.company"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="companykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>        
			<html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>	
		</html:select>                                    
<%--		<html:select property="companykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>--%>	
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.department"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="departmentkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>        
			<html:options collection="userdepartmentkeylist" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                     
<%--		<html:select property="departmentkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>
                                    </td></tr>    

             						<tr><td class="label2"><bean:message key="prompt.activity"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="activitykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>        
			<html:options collection="useractivitykeylist" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                     
<%--		<html:select property="activitykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>	--%>
                                    </td></tr>                                                                              
                      
								</table>
    							</td>                                
						        </tr>
     	
        
 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.status"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
	              						<tr><td class="label2">
<logic:notEqual name="QuohdrForm" property="action" scope="session" value="Create">

                      <c:if test="${QuohdrForm.quotestatus == 'PENDING'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${QuohdrForm.quotestatus}"/>'/>
                      </c:if>
                      <c:if test="${QuohdrForm.quotestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${QuohdrForm.quotestatus}"/>'/>
                      </c:if>	
                      <c:if test="${QuohdrForm.quotestatus == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${QuohdrForm.quotestatus}"/>'/>
                      </c:if>


				  					  
	<logic:equal name="QuohdrForm" property="quotestatus" scope="session" value="PENDING">			
       &nbsp;<html:hidden property="quotestatus" styleClass="forminput1" write="true"/>		
		  &nbsp;	
		<c:if test="${sessionScope.user.userid == sessionScope.QuohdrForm.quotebyuserid}">	    	   
<logic:notEqual name="QuohdrForm" property="customeraddrkey" scope="session" value="">	
        	<app:linkQuohdr page="/ListQuoapproveRequest.do?"><bean:message key="prompt.requestapproval"/></app:linkQuohdr>
</logic:notEqual>
<logic:equal name="QuohdrForm" property="customeraddrkey" scope="session" value="">	
        	<bean:message key="prompt.requestapproval"/>
</logic:equal>			
		</c:if>
	</logic:equal>	
	

	
	<logic:notEqual name="QuohdrForm" property="quotestatus" scope="session" value="PENDING">			
		<c:if test="${sessionScope.user.securitylevel == '1'}">
			
		<html:select property="quotestatus" styleClass="forminput1">
			<html:option value="APPROVED"><bean:message key="prompt.approved"/></html:option>
			<html:option value="PENDING"><bean:message key="prompt.pending"/></html:option>	
			<html:option value="REJECTED"><bean:message key="prompt.rejected"/></html:option>						
		</html:select>		
			
		</c:if>
		<c:if test="${sessionScope.user.securitylevel != '1'}">		
       		&nbsp;<html:hidden property="quotestatus" styleClass="forminput1" write="true"/>	
		</c:if>		
	</logic:notEqual>
		
</logic:notEqual> 

<logic:equal name="QuohdrForm" property="action" scope="session" value="Create">		
	<html:hidden property="quotestatus"/>	
</logic:equal> 	
    	                                </td></tr>   


				       		<tr><td><img src="images/spacer.gif" height="3"/></td></tr>                                                                        
        	     						<tr><td class="label2"><bean:message key="prompt.rejectreason"/>:</td></tr>
            	  						<tr><td class="label2">
<html:hidden property="rejectreason" styleClass="forminput1" write="true"/>
&nbsp;
<logic:notEqual name="QuohdrForm" property="notes" value="">									
									<img src='images/icons/icon_information_12_12.png' 
										border='0' 
										alt='<c:out value="${QuohdrForm.notes}"/>'/>		
</logic:notEqual>
                	                    </td></tr>                                                                                
                                                         
									</table>
    							</td>
						    </tr>
                            
                            
 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.product"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
        	     						<tr><td class="label2"><bean:message key="prompt.primaryproduct"/>:</td></tr>
            	  						<tr><td class="label2">
		<html:select property="productkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option>
			<html:options collection="products" property="productkey" labelProperty="tradname"/>	
		</html:select>	
                	                    </td></tr>    
                                                         
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

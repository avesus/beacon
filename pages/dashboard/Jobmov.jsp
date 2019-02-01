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
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}	
			
			checkAll(document.forms(0).selectedObjects,document.forms(0).selectedObjectsAll);
	}
    //]]>
</script>




<script language="JavaScript">
var searchWin;

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}

function locationSearch(field, types){
	var location = document.forms[0].elements[field];
	var url     = 'EditLocationSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      location.options[location.selectedIndex].value;					  
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}




		

function defaultActFrom(){
	document.forms[0].elements['actfromdatedd'].value=document.forms[0].elements['estfromdatedd'].value;
	document.forms[0].elements['actfromdatemm'].value=document.forms[0].elements['estfromdatemm'].value;
	document.forms[0].elements['actfromdateyyyy'].value=document.forms[0].elements['estfromdateyyyy'].value;
	document.forms[0].elements['actfromtimehh'].value=document.forms[0].elements['estfromtimehh'].value;
	document.forms[0].elements['actfromtimemm'].value=document.forms[0].elements['estfromtimemm'].value;
}
function defaultActTo(){
	document.forms[0].elements['acttodatedd'].value=document.forms[0].elements['esttodatedd'].value;
	document.forms[0].elements['acttodatemm'].value=document.forms[0].elements['esttodatemm'].value;
	document.forms[0].elements['acttodateyyyy'].value=document.forms[0].elements['esttodateyyyy'].value;
	document.forms[0].elements['acttotimehh'].value=document.forms[0].elements['esttotimehh'].value;
	document.forms[0].elements['acttotimemm'].value=document.forms[0].elements['esttotimemm'].value;
}
function defaultEstTo(){
	document.forms[0].elements['esttodatedd'].value=document.forms[0].elements['estfromdatedd'].value;
	document.forms[0].elements['esttodatemm'].value=document.forms[0].elements['estfromdatemm'].value;
	document.forms[0].elements['esttodateyyyy'].value=document.forms[0].elements['estfromdateyyyy'].value;
	document.forms[0].elements['esttotimehh'].value=document.forms[0].elements['estfromtimehh'].value;
	document.forms[0].elements['esttotimemm'].value=document.forms[0].elements['estfromtimemm'].value;
}

</script>  


<SCRIPT LANGUAGE="JavaScript">
function checkAll(field1,field2)
{
	var checkAll=false;
	if (field2.checked) checkAll=true;
	for (i = 0; i < field1.length; i++)	field1[i].checked = checkAll ;
}
function unCheckSelectedObjectsAll()
{
	document.forms(0).selectedObjectsAll.checked = false;
}
</script>


<script type="text/javascript">
var processMmu=false;
//<![CDATA[
function Dates_OnChange() {
	processMmu=true;
}
//]]>
//<![CDATA[
function WebForm_OnSubmit() {
	if (processMmu) {
		if (document.forms[0].orderjobsfound.value == 'true' || document.forms[0].orderconsignmentsfound.value == 'true') {
			if(confirm('Would you like to update the dates on other Movements linked to this Order?')) {
				document.forms[0].elements['mmu'].value='yes';
			}
		}
	}
return true;
}
//]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>

  <title><bean:message key="title.update"/></title>

</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close()}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td>
		    <span class="header2">
		    		<bean:message key="jobmov.title.update"/> 
             </span>
                <span class="header2">&gt;</span>               	  

<html:link action="/Dashboard"><span class="header4"><bean:message key="dashboard.title"/></span></html:link>       
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:1200px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>

<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td colspan="3"><span class="label2">-&nbsp;<bean:write name="message"/></span></td></tr>
</html:messages>
  
<html:form action="/DashboardSaveJobmov" focus="sectionkey.sectionkey" onsubmit="javascript:return WebForm_OnSubmit();">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="jobhdrId"/>
<html:hidden property="jobmovId"/>
<html:hidden property="unitId"/>
<html:hidden property="estfromtimeinmillis"/>
<html:hidden property="esttotimeinmillis"/>
<html:hidden property="actfromtimeinmillis"/>
<html:hidden property="acttotimeinmillis"/>
<html:hidden property="invsts"/>
<html:hidden property="movests"/>
<html:hidden property="mmulink"/>	

<html:hidden property="fromg1key"/>	
<html:hidden property="fromg2key"/>	
<html:hidden property="fromg3key"/>	
<html:hidden property="fromg4key"/>	
<html:hidden property="tog1key"/>	
<html:hidden property="tog2key"/>	
<html:hidden property="tog3key"/>	
<html:hidden property="tog4key"/>

<html:hidden property="orderjobsfound"/>
<html:hidden property="orderconsignmentsfound"/>
<html:hidden property="mmu"/>	
        

				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
 
 
 								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   
                            
							    	<tr><td class="label2"><bean:message key="prompt.section"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="sectionkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectasection"/></html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select>  		
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.status"/>:</td></tr>
							    	<tr><td class="label2">
<bean:write name="JobmovForm" property="invsts" scope="session"/>
                                    </td></tr>                                                                                                                                                           
								</table>
    						</td>
                
        					</tr>
                                                      
 
 
  								<tr><td class="label1" colspan="3">Location Details</td></tr>
                                
								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   

							    	<tr><td class="label2"><bean:message key="prompt.fromlocation"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="fromlocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('fromlocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.tolocation"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="tolocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('tolocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	 
                                    </td></tr>                                                                                                                                                           
								</table>
    						</td>
                
        					</tr>



  								<tr><td class="label1" colspan="3">Logistic Details</td></tr>
                                
								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   

							    	<tr><td class="label2"><bean:message key="prompt.vendor"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="vendoraddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.movementref"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="movref" size="20" maxlength="20" styleClass="forminput1"/>	 
                                    </td></tr>                                                                                                                                                    
                                    <tr><td class="label2"><bean:message key="prompt.movementdescription"/>:</td></tr>
							    	<tr><td class="label2">
<html:textarea rows="3" cols="150" property="txt" styleClass="forminput1"/>	 
                                    </td></tr>
                           
                                    <tr><td class="label2"><bean:message key="prompt.movementnotes"/>:</td></tr>
							    	<tr><td class="label2">
<html:textarea rows="3" cols="150" property="txt2" styleClass="forminput1"/>	 
                                    </td></tr>
                                              
                                    <tr><td class="label2"><bean:message key="prompt.specialnotes"/>:</td></tr>
							    	<tr><td class="label2">
<html:textarea rows="3" cols="150" property="txt3" styleClass="forminput1"/>	 
                                    </td></tr>
                                                                                                                   
								</table>
    						</td>
                
        					</tr>



                           
                                 
                                 
  								<tr><td class="label1" colspan="3">Estimate Date/Time</td></tr>
                                
								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   

							    	<tr>
                                    <td class="label2" colspan="2"><bean:message key="prompt.from"/>:</td>
<td class="label2" colspan="2"><bean:message key="prompt.to"/>:</td>                                    
                                    </tr>
							    	<tr>
<td class="label2"><html:img src="images/spacer.gif" alt="default" border="0" align="middle" width="18" height="18"/></td>                                    
                                    <td class="label2">
		<html:select property="estfromdatedd" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="estfromdatemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="estfromdateyyyy" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="estfromtimehh" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="estfromtimemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>		
                                    </td>
<td class="label2">                                    
<html:link href="javascript:void(defaultEstTo())">
		<html:img src="images/arrowIcon.gif" alt="default" border="0" align="middle"/>
		</html:link>                                    
       </td>
<td class="label2">
		<html:select property="esttodatedd" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="esttodatemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="esttodateyyyy" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="esttotimehh" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="esttotimemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>	 
                                    </td>                                    
                                    </tr>
                                                                                                                                                                                    
								</table>
    						</td>
                
        					</tr>
                            
                            
                            
                                 
  								<tr><td class="label1" colspan="3">Actual Date/Time</td></tr>
                                
								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   


 
<logic:notEqual name="JobmovForm" property="action" scope="session" value="Create"> 

							    	<tr>                                    
                                    <td class="label2" colspan="2"><bean:message key="prompt.from"/>:</td>                                   
        <td class="label2" colspan="2"><bean:message key="prompt.to"/>:</td>
        </tr>
							    	<tr>
                                    <td class="label2">
<html:link href="javascript:void(defaultActFrom())">
		<html:img src="images/arrowIcon.gif" alt="default" border="0" align="middle"/>
		</html:link>  </td>                                    
                                    <td class="label2">
         		<html:select property="actfromdatedd" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="actfromdatemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="actfromdateyyyy" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="actfromtimehh" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="actfromtimemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			
                                    </td>
<td class="label2">
		<html:link href="javascript:void(defaultActTo())">
		<html:img src="images/arrowIcon.gif" alt="default" border="0" align="middle"/>
		</html:link>
        </td>
<td class="label2">
        <html:select property="acttodatedd" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="acttodatemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="acttodateyyyy" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="acttotimehh" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="acttotimemm" styleClass="forminput1" onchange="Dates_OnChange();">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>	 
                                    </td>                                    
                                    </tr>
                                    
</logic:notEqual>
                                                                                                                                                                                    
								</table>
    						</td>
                
        					</tr>
                                                        


  								<tr><td class="label1" colspan="3">Ship Details</td></tr>
                                
								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   

							    	<tr><td class="label2"><bean:message key="prompt.vessel"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="vessel" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectavessel"/></html:option>
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>	
		</html:select>		
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.voyage"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="voyage" size="20" maxlength="20" styleClass="forminput1"/> 
                                    </td></tr>                                                                                                                                                    
                                    <tr><td class="label2"><bean:message key="prompt.vesselbookingcontact"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="vsbkcontact" size="20" styleClass="forminput1"/>		 
                                    </td></tr>
                           
                                    <tr><td class="label2"><bean:message key="prompt.vesselbookingref"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="vsbkref" size="20" styleClass="forminput1"/>	 
                                    </td></tr>
                                              
                                    <tr><td class="label2"><bean:message key="prompt.billoflading"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="billoflading" size="20" styleClass="forminput1"/>	 
                                    </td></tr>

                                    <tr><td class="label2"><bean:message key="prompt.lloydsnumber"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="lloydsnumber" size="20" styleClass="forminput1"/>	 
                                    </td></tr>
                                                                                                                                                   
								</table>
    						</td>
                
        					</tr>
                            
                                                                                                                

                            
                        
                                         
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
                                
				        <div class="btnPane"> 
                                                                                                   
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="processMmu=false;bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
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

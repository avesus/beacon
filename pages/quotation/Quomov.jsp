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

</script>  



<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="QuomovForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.quotno"/>&nbsp;-&nbsp;<bean:write name="ListQuomovForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
		    <span class="header2">
    			<logic:equal name="QuomovForm" property="action" scope="request" value="Create">
		    		<bean:message key="quomov.title.create"/>
    			</logic:equal>
		    	<logic:equal name="QuomovForm" property="action" scope="request" value="Delete">
		      		<bean:message key="quomov.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="QuomovForm" property="action" scope="request" value="Edit">
		        	<bean:message key="quomov.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="QuomovForm" property="action" scope="request" value="View">
		        	<bean:message key="quomov.title.view"/>
     			</logic:equal>	 
                </span>
                <span class="header2">&gt;</span>               	  

			             
<html:link action="/ListQuomov"><span class="header4"><bean:message key="quomov.title.list"/></span></html:link>
<span class="header2">&gt;</span>                             
<html:link action="/ListQuohdr"><span class="header4"><bean:message key="quohdr.title.list"/></span></html:link>        
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>


<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td colspan="3"><span class="label2">-&nbsp;<bean:write name="message"/></span></td></tr>
</html:messages>


  
<html:form action="/SaveQuomov" focus="seqno">
<html:hidden property="action"/>
<html:hidden property="quomovId"/>
<html:hidden property="quohdrId"/>
<html:hidden property="initfromday" value="true"/>
<html:hidden property="inittoday" value="true"/>
<html:hidden property="quotno"/>

<html:hidden property="fromg1key"/>	
<html:hidden property="fromg2key"/>	
<html:hidden property="fromg3key"/>	
<html:hidden property="fromg4key"/>	
<html:hidden property="tog1key"/>	
<html:hidden property="tog2key"/>	
<html:hidden property="tog3key"/>	
<html:hidden property="tog4key"/>	
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="QuomovForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="3">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.sequence"/>:</td></tr>
							    		<tr><td class="label2">
        <html:text property="seqno" size="7" disabled="true" maxlength="5" styleClass="forminput1"/>	
                                        </td></tr>
                                        
							            <tr><td class="label2"><bean:message key="prompt.section"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="sectionkey" disabled="true" styleClass="forminput1"> 
			<html:option value=""><bean:message key="prompt.selectasection"/></html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select> 
                                        </td></tr>
                                                                                
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="QuomovForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.sequence"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="seqno" size="7" maxlength="5" styleClass="forminput1"/>
                                    </td></tr>
                                                                        
									<tr><td class="label2"><bean:message key="prompt.section"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="sectionkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectasection"/></html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
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
                      
         							<tr><td class="label2"><bean:message key="prompt.fromlocation"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="fromlocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View">         
		<html:link href="javascript:void(locationSearch('fromlocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		
</logic:notEqual>  
              						</td></tr>	 
                                              
                                             
         							<tr><td class="label2"><bean:message key="prompt.tolocation"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="tolocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View">             
		<html:link href="javascript:void(locationSearch('tolocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual>    
              						</td></tr>
                                                                                                                                                                         
     						</table>
					    </td>

						       	
                                                
        					</tr>
                            
                            
                            
                            
                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.addressdetails"/></td></tr>  

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
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View">             
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual> 
              						</td></tr>	 
                                              
                                                                                                                      
     						</table>
					    </td>
                        
						       	
                                                
        					</tr>                                          
                                                                                    


                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.planningdaysbyloadingdate"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.fromdate"/></td></tr>
                                    <tr><td class="label2"><bean:message key="prompt.days"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="fromdayno" size="7"  maxlength="5" styleClass="forminput1"/>
              						</td></tr>	 
                                                                                                          
                      
         							<tr><td class="label2"><bean:message key="prompt.todate"/></td></tr>
                                    <tr><td class="label2"><bean:message key="prompt.days"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="todayno" size="7"  maxlength="5" styleClass="forminput1"/>
              						</td></tr>	 
                                                                                                           
     						</table>
					    </td>
        					</tr>          
                            
           					</logic:notEqual>
              
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="QuomovForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="QuomovForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="QuomovForm" property="action"   scope="request" value="Edit">
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

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




<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="CustomertariffhdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="CustomertariffhdrForm" property="action" scope="request" value="Create">
		    		<bean:message key="customertariffhdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="CustomertariffhdrForm" property="action" scope="request" value="Delete">
		      		<bean:message key="customertariffhdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="CustomertariffhdrForm" property="action" scope="request" value="Edit">
		        	<bean:message key="customertariffhdr.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>                         
<html:link action="/ListCustomertariffhdr"><span class="header4"><bean:message key="customertariffhdr.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
 						<html:form action="/SaveCustomertariffhdr" focus="custtarfhdrId">
						<html:hidden property="action"/>
                        
              
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="CustomertariffhdrForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="custtarfhdrId" size="30" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="custtarfhdrId"/>
                                        </td></tr>                                                                                                                                                                  				    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="CustomertariffhdrForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${CustomertariffhdrForm.action == 'Create'}">
        	<html:text property="custtarfhdrId" size="30" maxlength="10" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${CustomertariffhdrForm.action != 'Create'}">
        	<html:text property="custtarfhdrId" size="30" disabled="true" maxlength="10" styleClass="forminput1"/>
			<html:hidden property="custtarfhdrId"/>			
		  </c:if>	                                    
                                    </td></tr>
                                        
                                                                                
             						<tr><td class="label2"><bean:message key="prompt.customer"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="customeraddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('customeraddrkey','CUSTOMER'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	
                                    </td></tr>
     
             						<tr><td class="label2"><bean:message key="prompt.charge"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="chargekey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacharge"/></html:option>
			<html:options collection="charges" property="chargekey" labelProperty="ldesc"/>	
		</html:select>
                                    </td></tr>
                                              
             						<tr><td class="label2"><bean:message key="prompt.ccy"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="ccykey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
                                    </td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.lumpsum"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="lumpsum" size="15" styleClass="forminput1"/>
                                    </td></tr>
                                              
             						<tr><td class="label2"><bean:message key="prompt.validto"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="validtodd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="validtomm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="validtoyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
                                    </td></tr>
    
             						<tr><td class="label2"><bean:message key="prompt.unittype"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="unittype" size="15" styleClass="forminput1"/>
                                    </td></tr>                                                                                                                                                                						<tr><td class="label2"><bean:message key="prompt.product"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="productkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option>
			<html:options collection="products" property="productkey" labelProperty="tradname"/>	
		</html:select>
                                    </td></tr>
                                                       
								</table>
    						</td>
						    	</tr>
                                                               
                          		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>     					                                                         
								<tr><td class="label1" colspan="2"><bean:message key="prompt.locations"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.plantloading"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="fromlocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="plants" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('fromlocationkey','PLANT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>                                   
                                    </td></tr>
                                        
                                                                                
             						<tr><td class="label2"><bean:message key="prompt.portloading"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="fromlocationkey2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('fromlocationkey2','PORT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	
                                    </td></tr>
     
             						<tr><td class="label2"><bean:message key="prompt.portdischarge"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="tolocationkey2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('tolocationkey2','PORT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
                                    </td></tr>
                                              
             						<tr><td class="label2"><bean:message key="prompt.plantdischarge"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="tolocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="plants" property="locationkey" labelProperty="locationName"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('tolocationkey','PLANT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
                                    </td></tr>
                                                                                              
								</table>
    						</td>
						    	</tr>
                                
                                                                                                                                            
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="CustomertariffhdrForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="CustomertariffhdrForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="CustomertariffhdrForm" property="action"   scope="request" value="Edit">
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

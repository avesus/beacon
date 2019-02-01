<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-04		200900014		Add Customer, Ccy and Charge code to return parameter list
 * 												
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

<%if (session == null || session.getAttribute(Constants.USER_KEY) == null) { %>
<html:html>
<head>
<title><bean:message key="title.tariffsearch"/></title>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<script language="JavaScript">
	window.opener.location.href = "<html:rewrite forward='welcome'/>";
	window.opener.focus();
</script>
</head>
<body/>
</html:html>
<%} else { %>

<html:html>
<head>
<title><bean:message key="title.tariffsearch"/></title>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<script language="JavaScript">
function setTariff(params)	{
	if (params != "") {	
		var paramsArray=params.split("|");	

		window.opener.document.forms[0].custtarfhdrId.value = paramsArray[0];
		window.opener.document.forms[0].rate.value = paramsArray[1];
		window.opener.document.forms[0].chgamt.value = paramsArray[2];
		
		window.opener.document.forms[0].customeraddrkey.value = paramsArray[3];//200900014
		window.opener.document.forms[0].chargekey.value = paramsArray[4];//200900014
		window.opener.document.forms[0].ccykey.value = paramsArray[5];//200900014
		window.opener.document.forms[0].invoiceccykey.value = paramsArray[5];//200900014
	}		
	window.close();
	window.opener.focus();
}
</script>
</head>

<body> 


<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_customertariff_search.png" alt="Search" border="0" align="middle"/><span class="header2"><bean:message key="title.tariffsearchresults"/></span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>



<tr><td>
	
<div style="OVERFLOW:auto; width:1000px; height:500px;">

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
<html:form action="/ListQuotationCustomertariffSearch">
<html:hidden property="gotoPage" />
<html:hidden property="maxResults" />
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
                
                
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
                
					<div class="btnPane3">	        
                    
						<button id="backButton" class="btn btnFF" type="button"  onclick="history.back()" property="ignore">
            			        <span><bean:message key="button.back"/></span>
			            </button>                         
						<button id="cancelButton" class="btn btnFF" type="button"  onclick="window.close();window.opener.focus()" property="ignore">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			            </button>  
                                                                      
					</div>  
                                                                                                   
				</td></tr>
                
                               
							  
        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
		  						<td class="column-header1" width="3%">
								</td>

		  						<td class="column-header2" width="8%">              
										<span><bean:message key="heading.code"/></span>                        
								</td>  
                                                    
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.customer"/></span>                        
								</td>                                                    
                    
		  						<td class="column-header2" width="8%">              
										<span><bean:message key="heading.charge"/></span>                        
								</td> 
                                
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.pickup"/></span>                        
								</td> 
                                
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.loadingport"/></span>                        
								</td> 
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.dischargeport"/></span>                        
								</td> 
		  						<td class="column-header2" width="7%">              
										<span><bean:message key="heading.delivery"/></span>                        
								</td> 
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.product"/></span>                        
								</td>                                 
		  						<td class="column-header2" width="5%">              
										<span><bean:message key="heading.currency"/></span>                        
								</td>                                                                                                                                                                                   
                                
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.expirydate"/></span>                        
								</td>

<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="UNIT">	
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.fromvalue"/>
					</td>			
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.tovalue"/>
					</td>												
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.unitrate"/>
					</td>
</logic:equal>	
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="DISTANCE">	
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.fromvalue"/>
					</td>			
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.tovalue"/>
					</td>												
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.unitrate"/>
					</td>
</logic:equal>		
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="LUMPSUM">					
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.lumpsum"/>
					</td>																																									
</logic:equal>		
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="PTOP">					
		  			<td class="column-header2" width="10%">
					<bean:message key="heading.lumpsum"/>
					</td>																																									
</logic:equal>	
                                                                                                                                               					
							</tr>



<%
int row=0;
%>					
			<logic:iterate id="customertariffsearchLineItem" name="ListCustomertariffSearchForm" property="lineItems">

<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	

				<tr>

					<td class="<%= _class %>">
						<html:radio property="searchString15" idName="customertariffsearchLineItem" value="returnParams" onclick="setTariff(this.value)"/>
					</td> 
					<td class="<%= _class %>">						
						<bean:write name="customertariffsearchLineItem" property="custtarfhdrId" filter="true"/>
					</td> 												
					<td class="<%= _class %>">						
						<bean:write name="customertariffsearchLineItem" property="customeraddrkey.shortname" filter="true"/>
					</td> 				
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="chargekey.chargekey" filter="true"/>																	
					</td> 
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="fromlocationkey.shortName" filter="true"/>																	
					</td> 
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="fromlocationkey2.shortName" filter="true"/>																	
					</td> 															
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="tolocationkey2.shortName" filter="true"/>																	
					</td> 	
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="tolocationkey2.shortName" filter="true"/>																	
					</td> 
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="productkey" filter="true"/>																	
					</td>                     														 
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="ccykey" filter="true"/>																	
					</td> 
                  
                                        
					<td class="<%= _class %>">
						<bean:write name="customertariffsearchLineItem" property="validto" format="dd-MMM-yyyy" filter="true"/>																	
					</td> 
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="UNIT">	
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="fromvalue" filter="true"/>					
					</td>
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="tovalue" filter="true"/>					
					</td>							
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="unitrate" filter="true"/>					
					</td>
</logic:equal>
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="DISTANCE">	
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="fromvalue" filter="true"/>					
					</td>
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="tovalue" filter="true"/>					
					</td>							
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="unitrate" filter="true"/>					
					</td>
</logic:equal>		
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="LUMPSUM">			
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="lumpsum" filter="true"/>					
					</td>					 																				
</logic:equal>
<logic:equal name="ListCustomertariffSearchForm" property="searchString10"
			scope="session" value="PTOP">			
					<td class="<%= _class %>" align="right">
<bean:write name="customertariffsearchLineItem" property="lumpsum" filter="true"/>					
					</td>					 																				
</logic:equal>					

  				</tr>				
			</logic:iterate>
            
            
            			</table>
                        
					</td>
				</tr>
    
			</html:form>
      
		</table>

</div>

</td></tr>




</table>

</body>
</html:html>
<%} %>
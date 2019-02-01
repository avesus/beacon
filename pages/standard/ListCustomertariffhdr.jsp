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

function screenRefresh() 
{
}

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
<title><bean:message key="title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2"><bean:message key="customertariffhdr.title"/></span></td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:1300px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="3"><html:errors/></td></tr>
    
<html:form action="/ListCustomertariffhdr" focus="searchString3">

<input type="hidden" name="action" id="form-action" />
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			<tr>
            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="30%" valign="top">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
            				<tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString3" size="20" maxlength="10" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>
                 
                                                                 
            				<tr><td class="label2"><bean:message key="prompt.activeexpired"/>:</td></tr>
    						<tr><td class="label2">
<span class="forminput1">
        <html:radio property="searchString15" value="ALL"/>
        <bean:message key="prompt.all"/>
&nbsp;	  
        <html:radio property="searchString15" value="ACTIVE"/>
        <bean:message key="prompt.active"/>
&nbsp;
        <html:radio property="searchString15" value="EXPIRED"/>
        <bean:message key="prompt.expired"/>
</span> 	
              				</td></tr>
                                     
                                                                                                                
    					</table>
					</td>

       				<td width="70%" valign="top">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                       
            				<tr><td class="label2"><bean:message key="prompt.customeraddrkey.search"/>:</td></tr>
    						<tr><td class="label2">
<html:select property="searchString1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
</html:select>	
              				</td></tr>
                            
            				<tr><td class="label2"><bean:message key="prompt.chargekey.search"/>:</td></tr>
    						<tr><td class="label2">
<html:select property="searchString2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectacharge"/></html:option>
			<html:options collection="charges" property="chargekey" labelProperty="ldesc"/>	
</html:select>	
              				</td></tr>
                                                                                                                
    					</table>
					</td>
                                        
    			</tr>
		
    
    			<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="3">
					<div class="btnPane">	        
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Search</span>
        				</button>    
     
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditCustomertariffhdr.do?action=Create'">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>    
                        
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='MainMenu.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>                                               
					</div> 
				</td></tr>
 

				<tr><td colspan="3">
 <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer"><bean:message key="errors.prefix"/><bean:write name="error"/><bean:message key="errors.suffix"/></html:messages>
<html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer"><bean:message key="messages.prefix"/><bean:write name="msg"/><bean:message key="messages.suffix"/></html:messages>       
		        </td></tr>
                

        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
                            
		  						<td class="column-header1" width="1%">              
                    				<span></span>                        
								</td>
                                                            
		  						<td class="column-header2" width="5%">              
                    				<span><bean:message key="heading.code"/></span>                        
								</td>

		  						<td class="column-header2" width="15%">              
										<span><bean:message key="heading.customer"/></span>
								</td>  
                                                    
		  						<td class="column-header2" width="7%">              
										<span><bean:message key="heading.charge"/></span>                        
								</td>                                                    
                    
<!--		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.loadingplant"/></span>                        
								</td>--> 
                                
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.loadingport"/></span>                        
								</td> 
                                                               
		  						<td class="column-header2" width="10%">              
										<span><bean:message key="heading.dischargeport"/></span>                        
								</td>	  						
                                
<!--                                <td class="column-header2" width="10%">              
										<span><bean:message key="heading.dischargeplant"/></span>                        
								</td> -->
                                <td class="column-header2" width="3%">              
										<span><bean:message key="heading.currency"/></span>                        
								</td>
                                
                                <td class="column-header2" width="5%" nowrap>              
										<span><bean:message key="heading.lumpsum"/></span>                        
								</td>                                                                                                                                                                                  <td class="column-header2" width="7%" nowrap>              
										<span><bean:message key="heading.expirydate"/></span>                        
								</td>
                                                                                                                					
		  						<td width="20%">
                                
                        <div>        
						<button id="updateButton" class="btn btnFF" type="submit" onClick="document.getElementById('form-action').value='Update'">
						<img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span><bean:message key="button.update"/></span>
        				</button> 
                        </div>
                                                        
                                </td>
							</tr>
                
<%int row=0;%>			
			<logic:iterate id="customertariffhdrDTO" name="ListCustomertariffhdrForm" property="list">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>	
<%row++;%>	
			
  			<tr>
                                
					<td class="<%= _class %>" nowrap="nowrap">
<bean:write name="customertariffhdrDTO" property="row" filter="true"/>                        
					</td> 
                                                    
					<td class="<%= _class %>" nowrap="nowrap">
<html:text name="customertariffhdrDTO" indexed="true" property="custtarfhdrId" size="15" maxlength="10" styleClass="forminput1"/>
<html:hidden name="customertariffhdrDTO" property="custtarfhdrId2"/>                         
					</td> 				
					<td class="<%= _class %>">
						<bean:write name="customertariffhdrDTO" property="customeraddrkey.shortname" filter="true"/>
					</td> 
					<td class="<%= _class %>">
						<bean:write name="customertariffhdrDTO" property="chargekey.chargekey" filter="true"/>
					</td> 
<!--					<td class="<%= _class %>">
<bean:write name="customertariffhdrDTO" property="fromlocationkey.shortName" filter="true"/>
					</td> -->
					<td class="<%= _class %>">
<bean:write name="customertariffhdrDTO" property="fromlocationkey2.shortName" filter="true"/>
					</td> 
					<td class="<%= _class %>">
<bean:write name="customertariffhdrDTO" property="tolocationkey2.shortName" filter="true"/>
					</td> 
<!--					<td class="<%= _class %>">
<bean:write name="customertariffhdrDTO" property="tolocationkey.shortName" filter="true"/>
					</td> 	-->																				
					<td class="<%= _class %>">
						<bean:write name="customertariffhdrDTO" property="ccykey" filter="true"/>
					</td>			
					<td class="<%= _class %>" align="right">
<html:text name="customertariffhdrDTO" indexed="true" property="lumpsum" size="10" maxlength="15" styleClass="forminput1"/>                         
					</td>
					<td class="<%= _class %>" nowrap>
		<html:select name="customertariffhdrDTO" indexed="true" property="validtodd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select name="customertariffhdrDTO" indexed="true" property="validtomm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select name="customertariffhdrDTO" indexed="true" property="validtoyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>  
					</td>
                                                                                                                                         					
     			<td>                                         								
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
		  						<td class="<%= _class %>">
<html:link action="/ListCustomertariffdtl.do" paramId="id" paramName="customertariffhdrDTO" paramProperty="custtarfhdrId">
<bean:message key="prompt.rates"/>
</html:link>                                                
                                </td>

                                <td align="right" class="<%= _class %>">								
											
<html:link action="/EditCustomertariffhdr.do?action=Edit" paramId="custtarfhdrId" paramName="customertariffhdrDTO" paramProperty="custtarfhdrId"><bean:message key="prompt.edit"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditCustomertariffhdr.do?action=Copy" paramId="custtarfhdrId" paramName="customertariffhdrDTO" paramProperty="custtarfhdrId"><bean:message key="prompt.copy"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditCustomertariffhdr.do?action=Delete" paramId="custtarfhdrId" paramName="customertariffhdrDTO" paramProperty="custtarfhdrId">
<bean:message key="prompt.delete"/> 
</html:link>
                            	</td>
							</tr>
                    	</table>                                                                                 
				</td>
                
			</tr>
							
							</logic:iterate>
            			</table>
					</td>
				</tr>
    
			</html:form>
      
		</table>

</div>

</td></tr>

<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

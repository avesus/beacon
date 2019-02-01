<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
<title>Address Lookup List</title>


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
<title>Address Lookup List</title>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<script language="JavaScript">
function setAddress(vl)	{
	var addrkey = window.opener.document.forms[0].elements[document.forms[0].headerInfo2.value];	
	for(var i = 0; i < addrkey.length; i++)	{
		if (addrkey.options[i].value == vl)	{
			addrkey.selectedIndex = i;
		}
	}
	window.close();
	addrkey.onchange();
	window.opener.focus()
}
</script>
</head>

<body> 
<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr bgcolor="#F1F1F1"><td><span class="header2">Address Lookup List</span></td></tr> 
  
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
  
    <tr><td><img src="images/spacer.gif" height="5"/></td></tr> 
     
				<tr>
			        <td colspan="2">
    
				        <div> 
						<button id="buttonBack" class="btn btnFF" type="button" onClick="history.back()" property="ignore">
			                    <img class=" IM " title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        						<span>Back</span>
			            </button>     

						<button id="buttonCancel" class="btn btnFF" type="submit" onClick="window.close();window.opener.focus()" property="ignore">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        						<span><bean:message key="button.cancel"/></span>
			            </button>                               
				        </div>
                 
      				</td>
				</tr>
                  
   <tr><td><img src="images/spacer.gif" height="5"/></td></tr>                         
	
    						  
<tr>
	<td>

<html:form action="/ListAddressSearch">
<html:hidden property="headerInfo1" />
<html:hidden property="headerInfo2" />
<html:hidden property="gotoPage" />
<html:hidden property="maxResults" />

	


<div style="OVERFLOW:auto; width:850px; height:430px;"> 	


<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
						  			<td width="1%" class="column-header1" ></td>	                            
		  						<td class="column-header2" width="15%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="#">
										<span><bean:message key="heading.name"/></span>                        
							        </button>
								</td>
                                
		  						<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="#">
										<span><bean:message key="heading.type"/></span>                        
							        </button>
								</td>  
                                
		  						<td class="column-header2" width="50%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="#">
										<span><bean:message key="heading.address"/></span>                        
							        </button>
								</td>  
                                                    
                                                  
                    
							</tr>
                
<%int row=0;%>			
			<logic:iterate id="addressSearchLineItem" name="ListAddressSearchForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
					<td class="<%= _class %>">
						<html:radio property="searchString15" idName="addressSearchLineItem" value="addrkey" onclick="setAddress(this.value)"/>
					</td> 
                          <td class="<%= _class %>"><bean:write name="addressSearchLineItem" property="name" filter="true"/></td> 

									<td class="<%= _class %>"><bean:write name="addressSearchLineItem" property="typekey" filter="true"/></td>                                    
									<td class="<%= _class %>">
						<bean:write name="addressSearchLineItem" property="addr1" filter="true"/>
						<bean:write name="addressSearchLineItem" property="addr2" filter="true"/>&nbsp;
						<bean:write name="addressSearchLineItem" property="addr3" filter="true"/>&nbsp;
						<bean:write name="addressSearchLineItem" property="addr4" filter="true"/>&nbsp;
						<bean:write name="addressSearchLineItem" property="city" filter="true"/>&nbsp;						
						<bean:write name="addressSearchLineItem" property="postalcode" filter="true"/>		                                    
                                    &nbsp;
                                    </td>                                     
                                      
								</tr>
							
							</logic:iterate>
            			</table>
                        
		
        
        


</div>



</html:form>


</td>
</tr>
</table>

</body>
</html:html>
<%} %>
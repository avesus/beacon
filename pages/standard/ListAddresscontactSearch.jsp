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
  

<%if (session == null || session.getAttribute(Constants.USER_KEY) == null) { %>
<html:html>
<head>
<title>Contact Search</title>
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


<script language="JavaScript">
function setAddresscontact(v)	{
	if (window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value == "")
		window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value = v;
	else
		window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value = 
			window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value+"; "+v;

	window.close();
	window.opener.focus()
}
</script>
<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title>Contact Search</title>


</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%--<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>--%>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2">Contact Search</span></td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
	            <html:form action="/ListAddresscontactSearch" focus="searchString1">
<html:hidden property="headerInfo1" />
<html:hidden property="headerInfo2" />
<html:hidden property="headerInfo3" />
<html:hidden property="gotoPage" />				
<html:hidden property="maxResults" />
<html:hidden property="searchString3"/>
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			<tr>
            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
            				<tr><td class="label2"><bean:message key="prompt.name"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString1" size="40" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>
                            
            				<tr><td class="label2"><bean:message key="prompt.email"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString13" size="40" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>
                                                        
    					</table>
					</td>
    			</tr>
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane">	        
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Search</span>
        				</button>    

						<button id="buttonCancel" class="btn btnFF" type="submit" onClick="window.close();window.opener.focus()" property="ignore">
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
		  						<td class="column-header1" width="1%">
                                </td>                            
		  						<td class="column-header1" width="50%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListAddresscontactSearch.do?orderBy=Name&gotoPage=0'">
										<span><bean:message key="heading.contactname"/></span>                        
										<logic:notEqual name="ListAddresscontactSearchForm" property="orderBy" scope="session" value="Name">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListAddresscontactSearchForm" property="orderBy" scope="session" value="Name">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                    
		  						<td class="column-header2" width="50%">
							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListAddresscontactSearch.do?orderBy=Email&gotoPage=0'">
										<span><bean:message key="heading.contactemail"/></span>        
										<logic:notEqual name="ListAddresscontactSearchForm" property="orderBy" scope="session" value="Email">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListAddresscontactSearchForm" property="orderBy" scope="session" value="Email">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                             
								</td>
							</tr>
                
<%int row=0;%>			
			<logic:iterate id="searchLineItem" name="ListAddresscontactSearchForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
					<td class="<%= _class %>" valign="top">
						<html:radio property="searchString15" idName="searchLineItem" value="email" onclick="setAddresscontact(this.value)"/>
					</td> 
									<td class="<%= _class %>"><bean:write name="searchLineItem" property="name" filter="true"/>										</td> 
									<td class="<%= _class %>"><bean:write name="searchLineItem" property="email" filter="true"/>										</td>                                                                                                     					 
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
<% } %>
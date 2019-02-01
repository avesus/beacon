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

</head>
<body>

<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_vendortariff_search.png" alt="Search" border="0" align="middle"/><span class="header2"><bean:message key="title.tariffsearch"/></span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
  
  <tr>
    <td> 
	
				
	<div style="OVERFLOW:auto; width:700px; height:450px;"> 
	
		<table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
                        
<html:form action="/ListQuotationVendortariffSearch" focus="searchString1"> 
<html:hidden property="maxResults" />
<html:hidden property="searchString5" /><!--TSLOCATION-->
<html:hidden property="searchString10" /><!--UNITS-->
<html:hidden property="searchString11" /><!--ID-->
<html:hidden property="searchString6" /><!--PRODUCT-->                        
       
                              
       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
       
       		<tr>
            <td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       		<td width="100%"><table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                              
                              
                                  <tr>
                                    <td class="label2"><bean:message key="prompt.vendor"/>: </td></tr>
                                    <tr><td class="label2">
		<html:select property="searchString1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.noselection"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>									
									</td>
                                  </tr>
                                  <tr>
                                    <td class="label2"><bean:message key="prompt.cost"/>: </td></tr>
                                    <tr>
                                    <td class="label2">
		<html:select property="searchString2" styleClass="forminput1"> 
			<html:option value=""><bean:message key="prompt.noselection"/></html:option> 
			<html:options collection="costs" property="costkey" labelProperty="descr"/> 
		</html:select> 									
									</td>
                                  </tr>
                                  <tr>
                                    <td class="label2"> <bean:message key="prompt.fromlocation"/>: </td></tr>
                                    <tr>
                                    <td class="label2">
		<html:select property="searchString3" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.noselection"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>								  
<%--                                  <tr>
                                    <td class="label2"><div align="right"> <bean:message key="prompt.transhipmentlocation"/>: </div></td>
                                    <td class="label2">
		<html:select property="searchString5" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.noselection"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>--%>								  
                                  <tr>
                                    <td class="label2"><bean:message key="prompt.tolocation"/>: </td></tr>
                                    <tr>
                                    <td class="label2">
		<html:select property="searchString4" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.noselection"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>
<%--                                  <tr>
                                    <td class="label2"><div align="right"> <bean:message key="prompt.product"/>: </div></td>
                                    <td class="label2">
		<html:select property="searchString6" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.noselection"/></html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select>									
									</td>
                                  </tr>--%>
              						<tr><td class="label2"><bean:message key="prompt.hazardousproduct"/>:</td></tr>
                                    <tr>
                                     <td class="label2">
<html:select property="searchString12" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.noselection"/></html:option>    
			<html:option value="N">No</html:option>    
			<html:option value="Y">Yes</html:option>        
</html:select>
                                    </td>                                 
                                  <tr>
                                    <td class="label2"> <bean:message key="prompt.ccy"/>: </td></tr>
                                    <tr>
                                    <td class="label2">
									<html:select property="searchString7" styleClass="forminput1"> 
										<html:option value=""><bean:message key="prompt.noselection"/></html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>									
									</td>
                                  </tr>
                                  

    		<tr><td colspan="2"><img src="images/spacer.gif" height="2"/></td></tr> 
                                                              
                                  <tr>
                                    <td class="label2"> <bean:message key="prompt.type"/>:  <strong>
<bean:write name="ListVendortariffSearchForm" property="searchString9" scope="session"/></strong>
									</td>
                                  </tr>	

    		<tr><td colspan="2"><img src="images/spacer.gif" height="2"/></td></tr> 
                                                  								  
                                  <tr>
                                    <td class="label2"><bean:message key="prompt.expirydate"/> >= <strong>
<bean:write name="ListVendortariffSearchForm" property="searchDate1" format="dd-MMM-yyyy" scope="session"/>	</strong>								
									</td>
                                  </tr>

</table></td></tr> 

    		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
                
            <tr><td colspan="2"><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td>
                                                            
				        <div class="btnPane">                         
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Search</span>
        				</button>                         
						<button id="cancelButton" class="btn btnFF" type="button"  onclick="window.close();window.opener.focus()" property="ignore">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			            </button>                           
				        </div>
                          </td></tr></table></td></tr>                                  

</html:form>

        </table>
        
    </div> 

  
	  </td>
  </tr>

</table>

</body>
</html:html>
<% } %>
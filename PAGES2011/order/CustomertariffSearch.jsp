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
<title>Tariff Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

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
<title>Tariff Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>
<body>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_customertariff_search.png" alt="Search" border="0" align="middle"/>
   <span class="heading9">Tariff Search</span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
  
  <tr>
    <td>
	
<html:form action="/ListOrderCustomertariffSearch" focus="searchString1">
<html:hidden property="maxResults" />
				
	<div style="OVERFLOW:auto; width:700px; height:450px;">
	
        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td>
			
              <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
                <tr>
                  <td><table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
                      <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                </table>
							  </td>
                            </tr>
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right">Customer: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value="">- No Selection -</html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>									
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right">Charge: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString2" styleClass="ftforminputsmall"> 
			<html:option value="">- No Selection -</html:option> 
			<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 									
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Loading Plant: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString3" styleClass="ftforminputsmall">
			<html:option value="">- No Selection -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>								  
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Loading Port: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString4" styleClass="ftforminputsmall">
			<html:option value="">- No Selection -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>								  
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Discharge Port: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString5" styleClass="ftforminputsmall">
			<html:option value="">- No Selection -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>								  
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Discharge Plant: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString6" styleClass="ftforminputsmall">
			<html:option value="">- No Selection -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>									
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Product: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="searchString7" styleClass="ftforminputsmall"> 
		<html:option value="">- No Selection -</html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select>									
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Ccy: </div></td>
                                    <td width="78%" class="td2">
									<html:select property="searchString8" styleClass="ftforminputsmall"> 
										<html:option value="">- No Selection -</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>									
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Type: </div></td>
                                    <td width="78%" class="td2"> 
<bean:write name="ListCustomertariffSearchForm" property="searchString10" scope="session"/>
									</td>
                                  </tr>								  
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> Expiry Date >=: </div></td>
                                    <td width="78%" class="td2"> 
<bean:write name="ListCustomertariffSearchForm" property="searchDate1" format="dd-MMM-yyyy" scope="session"/>
									</td>
                                  </tr>
                                </table></td>
                            </tr>

                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td class="td1">
									<html:submit styleClass="button1"> 
									Search 
									</html:submit>
									<html:reset styleClass="button1"> 
									<bean:message key="button.reset"/> 
									</html:reset> 
									<html:button styleClass="button1" onclick="window.close();window.opener.focus()" property="ignore"> 
									<bean:message key="button.cancel"/> 
									</html:button> 
									</td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
               </td>
          </tr>
        </table>
      </div>

</html:form>
	  
	  </td>
  </tr>

</table>
</body>
</html:html>
<% } %>
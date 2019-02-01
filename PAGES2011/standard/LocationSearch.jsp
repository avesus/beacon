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
<title>Location Search</title>
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
<title>Location Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>
<body>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_location_search.png" alt="Search" border="0" align="middle"/><span class="heading9">Location Search</span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
  <tr>
    <td>
	
	            <html:form action="/ListLocationSearch" focus="searchString1">
				
<html:hidden property="maxResults" />
				
	<div style="OVERFLOW:auto; width:850px; height:430px;">
	
	
        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td>

              <table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
                <tr>
                  <td><table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
                      <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                </table></td>
                            </tr>
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.name"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="searchString1" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
 	<tr>
		<td colspan="2" class="texthelp2">
		 <bean:message key="prompt.location.wildcardhelp"/>				
		</td>
	<tr>                                  
                                </table></td>
                            </tr>
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.address"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="searchString3" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2">&nbsp;</td>
                                    <td width="78%" class="td2"><html:text property="searchString4" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2">&nbsp;</td>
                                    <td width="78%" class="td2"><html:text property="searchString5" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.postalcode"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="searchString7" size="20" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.city"/>: </div></td>
                                    <td width="78%" class="td2"><html:select property="searchString8" styleClass="ftforminputsmall"> <html:option value=""><bean:message key="prompt.city"/></html:option> <html:options collection="citys" property="city" labelProperty="city"/> </html:select> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.state"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="searchString9" size="20" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.country"/>: </div></td>
                                    <td width="78%" class="td2"><html:select property="searchString10" styleClass="ftforminputsmall"> <html:option value=""><bean:message key="prompt.country"/></html:option> <html:options collection="countrys" property="country" labelProperty="country"/> </html:select> </td>
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
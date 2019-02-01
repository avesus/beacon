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

<app:checkLogon/><html:html>

<head>
<title><bean:message key="title.list"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
</head>
<body>

<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <!-- HEADER ----------------->
  <tr>
    <td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" />
    </td>
  </tr>
  <!-- BREADCRUMBS ----------------->
  <tr>
<%--    <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>
    <td class="tdwht">
	<span class="heading2"> 
	<strong><bean:message key="customertariffdtl.title"/></strong> 
	</span> 
	<span class="heading2"> 
	<html:link action="/ListCustomertariffhdr" styleClass="link4"> 
	<bean:message key="customertariffhdr.title.list"/> </html:link> 
	</span> <span class="text6">/</span> 
	<span class="text6"><strong> 
	<bean:message key="customertariffdtl.title.list"/>
	</strong></span> </td>
  </tr>
  <tr valign="top" bgcolor="#CCCCCC">
    <td height="1" colspan="2"></td>
  </tr>
  <!-- BREADCRUMBS ----------------->
  <tr>
    <!-- SIDEBAR ----------------->
<%--    <td bgcolor="#CCCCCC" width="121" valign="top" align="center"><jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
    </td>--%>
    <!-- BODY ----------------->
    <td><div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">
        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td><html:form action="/ListCustomertariffdtl">
              <table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td>
				  
				  <!-- start header information -->
                    <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#A9C0D7">
                      <tr>
                        <td><table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                                  <tr>
                                    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.customer"/></span></td>
                                    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.charge"/></span></td>
                                    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.fromlocation"/></span></td>
                                    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.tolocation"/></span></td>
                                    <td width="20%" class="td4"><span class="heading6"><bean:message key="heading.unittype"/></span></td>
                                  </tr>
                                  <tr> <span class="text2">
                                    <td class="td6">
									<bean:write name="ListCustomertariffdtlForm" property="header.customeraddrkey.name" filter="true"/>
									</td>
                                    <td class="td6"> 
									<bean:write name="ListCustomertariffdtlForm" property="header.chargekey.ldesc" filter="true"/> 									
									</td>
                                    <td class="td6"><bean:write name="ListCustomertariffdtlForm" property="header.fromlocationkey.locationName" filter="true"/> </td>
                                    <td class="td6"><bean:write name="ListCustomertariffdtlForm" property="header.tolocationkey.locationName" filter="true"/> </td>
                                    <td class="td6"><bean:write name="ListCustomertariffdtlForm" property="header.unittype" filter="true"/> </td>
                                    </span> </tr>
                                </table></td>
                          </table></td>
                      </tr>
                    </table>
                    <!-- end header information -->
                    <br/>

<html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="error"/><bean:message key="errors.suffix"/>
</html:messages>
<html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
<bean:message key="messages.prefix"/><bean:write name="msg"/><bean:message key="messages.suffix"/>
</html:messages>
						 
					<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
                      <tr>
                        <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                            <tr>
                              <td class="tddkgry" width="4%"><span class="heading4"></span> </td>							
                              <td class="tddkgry" width="4%"><html:hidden property="id"/></td>							
                              <td class="tddkgry" width="23%"><span class="heading4"> <bean:message key="prompt.fromvalue"/> </span> </td>
                              <td class="tddkgry" width="23%"><span class="heading4"> <bean:message key="prompt.tovalue"/> </span> </td>
                              <td class="tddkgry" width="23%"><span class="heading4"> <bean:message key="prompt.unitrate"/> </span> </td>
                              <td class="tddkgry" width="23%"><span class="heading4"> <bean:message key="prompt.lumpsum"/> </span> </td>
                              <td class="tddkgry"><span class="heading4">
<html:submit styleClass="button1" property="action"> <bean:message key="button.delete"/> </html:submit>							  
							  </span> </td>
                            </tr>
                            <%
int row=0;
%>
                            <logic:iterate id="customertariffdtlDTO" name="ListCustomertariffdtlForm" property="list">
                            <%
String _class = row++ % 2 == 0 ? "tdlghtgry2" : "tdlghtgry";
%>
                            <tr> <span class="text2">
<td class="<%= _class %>">
<html:text name="customertariffdtlDTO" indexed="true" property="row" size="3" styleClass="ftforminputsmall" readonly="true"/>
</td>							
                              <td class="<%= _class %>"><html:hidden name="customertariffdtlDTO" property="custtarfdtlId" indexed="true" /><logic:equal
					name="customertariffdtlDTO" property="custtarfdtlId" value="">*</logic:equal></td>
                              <td class="<%= _class %>">
							  <html:text name="customertariffdtlDTO" indexed="true" property="fromvalue" maxlength="5" size="19" styleClass="ftforminputsmall"/> </td>
                              <td class="<%= _class %>">
							  <html:text name="customertariffdtlDTO" indexed="true" property="tovalue" maxlength="5" size="19" styleClass="ftforminputsmall"/> </td>
                              <td class="<%= _class %>">
							  <html:text name="customertariffdtlDTO" indexed="true" property="unitrate" maxlength="5" size="19" styleClass="ftforminputsmall"/> </td>
                              <td class="<%= _class %>">
							  <html:text name="customertariffdtlDTO" indexed="true" property="lumpsum" maxlength="5" size="19" styleClass="ftforminputsmall"/> </td>
                              <td class="<%= _class %>" width="20%" align="center">
								<logic:notEqual	name="customertariffdtlDTO" property="custtarfdtlId" value="">
									<html:multibox property="selectedObjects"><bean:write name="customertariffdtlDTO" property="custtarfdtlId" /></html:multibox>
								</logic:notEqual>
						
                              </td>
                              </span> </tr>
                            </logic:iterate>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
                <tr>
                  <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                      <tr>
<td class="td1">
<html:submit styleClass="button1" property="action"> <bean:message key="button.update"/></html:submit>  
<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
<html:cancel styleClass="button1"> <bean:message key="button.exit"/> </html:cancel> 
</td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              </html:form> </td>
          </tr>
        </table>
      </div></td>
  </tr>
  <!-- FOOTER ----------------->
  <tr>
    <td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" />
    </td>
  </tr>
</table>
</body>
</html:html>
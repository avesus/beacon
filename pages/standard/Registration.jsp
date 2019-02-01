<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
  <app:checkLogon/>


<html:html>
<head>
  <title><bean:message key="registration.title.edit"/></title>
<html:base/>
</head>
<body bgcolor="white">

<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<html:form action="/SaveRegistration" focus="password">
<table border="0" width="100%">

  <tr>
    <th align="right">
      <bean:message key="prompt.userid"/>:
    </th>
    <td align="left">
	<bean:write property="userid" name="<%=com.bureaueye.beacon.bean.Constants.USER_KEY%>"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="prompt.password"/>:
    </th>
    <td align="left">
      <html:password property="password" size="16" maxlength="16"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="prompt.password2"/>:
    </th>
    <td align="left">
      <html:password property="password2" size="16" maxlength="16"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="prompt.name"/>:
    </th>
    <td align="left">
      <html:text property="name" size="50"/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <bean:message key="prompt.pageSize"/>:
    </th>
    <td align="left">
      <html:text property="pagesize" size="50"/>
    </td>
  </tr>
  
  <tr>
    <td align="right">
      <html:submit>
        <bean:message key="button.save"/>
      </html:submit>
    </td>
    <td align="left">
      <html:reset>
        <bean:message key="button.reset"/>
      </html:reset>
      &nbsp;
      <html:cancel>
        <bean:message key="button.cancel"/>
      </html:cancel>
    </td>
  </tr>

</table>
</html:form>


<div align="center">
<h3><bean:message key="heading.usermenus"/></h3>
</div>

<table border="1" width="100%">

  <tr>
    <th align="center" width="25%">
      <bean:message key="heading.menuid"/>
    </th>
    <th align="center" width="25%">
      <bean:message key="heading.programid"/>
    </th>
    <th align="center" width="25%">
      <bean:message key="heading.programtype"/>
    </th>
    <th align="center" width="25%">
      <bean:message key="heading.action"/>
    </th>
  </tr>

<logic:iterate id="usermenuLineItem" name="<%=com.bureaueye.beacon.bean.Constants.USER_KEY%>" property="usermenus">
  <tr>
    <td align="center">
      <bean:write name="usermenuLineItem" property="id.menuid" filter="true"/>
    </td>
    <td align="center">
      <bean:write name="usermenuLineItem" property="programid" filter="true"/>
    </td>
    <td align="center">
      <bean:write name="usermenuLineItem" property="programtype"/>
    </td>
    <td align="center">
      <app:linkUsermenuLineItem page="/EditUsermenu.do?action=Delete">
        <bean:message key="registration.deleteUsermenu"/>
      </app:linkUsermenuLineItem>
      <app:linkUsermenuLineItem page="/EditUsermenu.do?action=Edit">
        <bean:message key="registration.editUsermenu"/>
      </app:linkUsermenuLineItem>
    </td>
  </tr>
</logic:iterate>

</table>

<html:link action="/EditUsermenu?action=Create">
  <bean:message key="registration.addUsermenu"/>
</html:link>
                     


<jsp:include page="footer.jsp" flush="true" />
</body>
</html:html>

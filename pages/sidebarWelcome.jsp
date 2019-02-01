<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="/beacon/css/base.css" />




<logic:present name="user"> 
<!-- ssidebar -->
<table cellpadding="2" cellspacing="2" border="0" width="108">
	<tr>
		<td class="text4"><strong>
		<bean:message key="heading.welcome"/> 
		</strong>
		</td>
	</tr>
	<tr>
		<td class="text4">		
		<bean:write name="user" property="name" />
		</td>
	</tr>	
					<tr>
						<td height="5"></td>
					</tr>		
  <tr>
    <td>
	  <html:link forward="logoff">
	  <html:img page="/images/logout.gif" border="0"/>
	  </html:link>
    </td>
  </tr>
  <tr>
    <td><img src="/images/sidebar.gif" width="113" height="1" border="0"/></td>
  </tr>  	
</table>

<!-- esidebar -->
</logic:present> 


<logic:notPresent name="user">
<!-- ssidebar -->
<html:errors />

<html:form action="/SubmitLogon" focus="userid">
<table cellpadding="2" cellspacing="2" border="0" width="108">

  <tr>
    <td class="text4"><strong>
      <bean:message key="prompt.userid"/>:
	  </strong>
    </td>
	</tr>
	<tr>
    <td>
      <html:text property="userid" size="15" maxlength="15" styleClass="ftforminputsmall"/>
    </td>
  </tr>

  <tr>
    <td class="text4"><strong>
      <bean:message key="prompt.password"/>:
	  </strong>
    </td>
	</tr>
	<tr>
    <td>
      <html:password property="password" size="15" maxlength="15"
                    redisplay="false" styleClass="ftforminputsmall"/>
    </td>
  </tr>

  <tr>
    <td>
	  <html:image page="/images/login.gif" property="Submit" value="Submit"/>
    </td>
  </tr>
  <tr>
    <td><img src="/images/sidebar.gif" width="113" height="1" border="0"/></td>
  </tr> 
</table>

</html:form>
<!-- esidebar -->
</logic:notPresent>


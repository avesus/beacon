<%-- Errors.jsp - Display unexpected errors, such as a JSP exception
     or missing resources --%>
<%--
 $Header: /home/cvs/jakarta-struts/web/example/Error.jsp,v 1.1 2004/03/09 04:38:05 husted Exp $
 $Revision: 1.1 $
 $Date: 2004-03-09 04:38:05 +0000 (Tue, 09 Mar 2004) $
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.apache.struts.Globals" %>
<%@ page import="com.bureaueye.beacon.bean.Constants" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<head>
<title>Unexpected Error</title>
<html:base/>
</head>


<html:html>
<h3>An unexpected error has occured</h3>
<logic:present name="<%=Constants.ERROR_KEY%>">
<ul>
<logic:iterate id="error" name="<%=Constants.ERROR_KEY%>">
<li><bean:write name="error" /></li>
</logic:iterate>
</ul>
</logic:present>
<logic:present name="<%=Globals.EXCEPTION_KEY%>">
<p><bean:write name="<%=Globals.EXCEPTION_KEY%>" property="message" /></p>
</logic:present>

</body>
</html:html>

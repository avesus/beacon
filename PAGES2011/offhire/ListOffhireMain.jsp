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

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<app:checkLogon/>

<html:html>
  <head>
  <title>
  <bean:message key="offhire.title"/>
  </title>
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  
  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
//process to place scope on Operations Tab
	function onLoad() {	
		//onLoadSidebar('menu2');								
	}
    //]]>
</script>

  </head>

  <body onLoad="onLoad();">
  <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <%-- HEADER -----------------%>
    <tr>
      <td colspan="5"><jsp:include page="/pages/header.jsp" flush="true" />
      </td>
    </tr>
    <%-- BREADCRUMBS -----------------%>
    <tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>
      <td class="tdwht" colspan="4"><span class="heading2"> <strong>
        <bean:message key="offhire.title"/>
        </strong> </span> <span class="heading2">
        <html:link action="/ListOffhire" styleClass="link5">
          <bean:message key="title.list"/>
        </html:link>
        </span> </td>
    </tr>
    <tr valign="top" bgcolor="#CCCCCC">
      <td height="1" colspan="5"></td>
    </tr>
    <%-- BREADCRUMBS -----------------%>
    <tr>
<%--      <td bgcolor="#CCCCCC" width="121" valign="top" align="center"><jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
      </td>--%>
	  
<%--      <td bgcolor="#eeeeee"><img src="images/spacer.gif" height="500" width="1"></td>--%>
	  
      <td><div style="OVERFLOW:auto; width:1350px; height:650px; position:relative;">
	  
<html:form action="/ListOffhire" focus="searchString1">
	<html:hidden property="gotoPage" />
          <jsp:include page="/pages/offhire/ListOffhireSearch.jsp" flush="true" />
          <jsp:include page="/pages/offhire/ListOffhireResults.jsp" flush="true" />
</html:form>	
	  
        </div></td>
		
<%--      <td bgcolor="#eeeeee"><img src="images/spacer.gif" height="500" width="1"></td>--%>
	  
      </td>
	  
    </tr>
    <%-- FOOTER -----------------%>
    <tr>
      <td colspan="5"><jsp:include page="/pages/footer.jsp" flush="true" />
      </td>
    </tr>
  </table>
  </body>
</html:html>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<%--
 *
 * Amendments
 * ---------- 
 * 												
 *
 --%>


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


<script language="JavaScript">

function screenRefresh() 
{
}

</script>



<script type="text/javascript" language="javascript" src="/beacondms/scripts/DynamicOptionList.js"></script>

  
<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		initDynamicOptionLists();
	}
    //]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
  

<head>
<title><bean:message key="orderhdr.title.list"/></title>
</head>
  
  

  
  
<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2"><bean:message key="orderhdr.title.list"/></span></td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
      
    
<tr><td>
           
	<div style="width:1430px; height:650px; position:relative;">
	  
		<html:form action="/ListOrderhdr" focus="searchString1">
	    <html:hidden property="gotoPage" />
    	    <jsp:include page="/pages/order/ListOrderhdrSearch.jsp" flush="true" />                  
        	<jsp:include page="/pages/order/ListOrderhdrResults.jsp" flush="true" />
		</html:form> 	

          	  
	</div>
 
</td></tr>
    
    
<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

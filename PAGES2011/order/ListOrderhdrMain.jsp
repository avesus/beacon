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
  <bean:message key="orderhdr.title.list"/>
  </title>
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  
  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>

<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {								
	}
    //]]>
</script>

<script language="JavaScript">
var searchWin;

function HBL(ordid){
	var companyheaderId = document.forms['ListOrderhdrForm'].elements['searchString15'];
	var url     = '/beacon/EditHBL.do?'+
						'companyheaderId=11'+
                      	//companyheaderId.options[companyheaderId.selectedIndex].value+ 
						'&orderhdrId='+
                      	ordid+
					  	'&printId='+
						ordid+'HBL'+
						'&refreshdata=N'+
						'&action=Print'
						;				
	window.location.href = url;
}

function Bookingnotification(ordid){
	var companyheaderId = document.forms['ListOrderhdrForm'].elements['searchString15'];
	var url     = '/beacon/EditBookingnotification.do?'+
						'companyheaderId=11'+
                      	//companyheaderId.options[companyheaderId.selectedIndex].value+ 
						'&orderhdrId='+
                      	ordid+
					  	'&printId='+
						ordid+'BN'+
						'&refreshdata=N'+
						'&action=Print'
						;				
	window.location.href = url;
}

function bookingDocument(ordid){
	var companyheaderId = document.forms[ordid].elements['searchString15'];
	var printId = document.forms[ordid].elements['searchString14'];
	var url     = '/beacon/Edit'+printId.options[printId.selectedIndex].value+'.do?'+
						'companyheaderId='+
                      	companyheaderId.options[companyheaderId.selectedIndex].value+ 
						'&orderhdrId='+
                      	ordid+
					  	'&printId='+
						ordid+printId.options[printId.selectedIndex].value+
						'&refreshdata=N'+
						'&action=Print'
						;	
	window.location.href = url;	
}

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
      <td class="tdwht" colspan="4">
	  <span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	  </td>
    </tr>
    <tr valign="top" bgcolor="#CCCCCC">
      <td height="1" colspan="5"></td>
    </tr>
    <%-- BREADCRUMBS -----------------%>
    <tr>
	  
      <td><div style="OVERFLOW:auto; width:1400px; height:650px; position:relative;">

  <html:form action="/ListOrderhdr" focus="searchString1">
    <html:hidden property="gotoPage" />	  
          <jsp:include page="/pages/order/ListOrderhdrSearch.jsp" flush="true" />
          <jsp:include page="/pages/order/ListOrderhdrResults.jsp" flush="true" />
  </html:form>		  
		  
        </div></td>
		
	  
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

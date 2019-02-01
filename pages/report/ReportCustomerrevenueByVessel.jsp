<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
 *
 * Amendments
 * ----------
 *
 * NT	2013-02-20		WSI-201302-0003			CUSTOMER REVENUE REPORT
 *  
 *
-->

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
<title>Customer Revenue Report By Vessel</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
//-->
</script>
</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%-- HEADER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<%-- BREADCRUMBS -----------------%> 
<tr>
	<td class="tdwht"><span class="heading2">     
	  <strong>Customer Revenue Report By Vessel</strong></span></td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<%-- BREADCRUMBS -----------------%> 


<tr>
<%-- SIDEBAR -----------------%>

	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ReportCustomerrevenueByVessel" focus="searchString2">
<html:hidden property="gotoPage" />
<html:hidden property="searchDate3dd" />
<html:hidden property="searchDate3mm" />
<html:hidden property="searchDate3yyyy" />
<html:hidden property="searchString3" value="EXCEL" />
<html:hidden property="maxResults" />


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

    <table border="0" cellpadding="1" cellspacing="2" width="100%" bgcolor="#EEEEEE">
      <tr>
        <td colspan="2" valign="middle"><h1 class="underline mtb0">
          <INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>
&nbsp;
        </h1></td>
      </tr>
      <tr>
        <td><img src="images/spacer.gif" alt="" height="10"/></td>
      </tr>
      
      <tr>
        <td align="left" class="text7"><bean:message key="prompt.vessel"/>:</td>
      </tr>
      <tr>
        <td align="left" >
        <html:select property="searchString2" styleClass="ftforminputsmall">
          <html:option value="%">
            <bean:message key="prompt.selectavessel"/>
          </html:option>
          <html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>
        </html:select></td>
      </tr>


    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.company"/>
      : </td>
    </tr>
    <tr>
      <td align="left">
		<html:select property="searchString19" styleClass="ftforminputsmall">
			<html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>	
		</html:select>      
      </td>
    </tr>
    
                   
      <tr>
        <td><img src="images/spacer.gif" alt="" height="5"/></td>
      </tr>



	<tr><td>
   
    <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
      <tr>
        <td align="left" class="text7">Output: </td>
      </tr>
      <tr>
        <td align="left" class="text7"><span class="ftformradiosmall">
          <html:radio property="searchString3" value="EXCEL"/>
          Excel </span></td>
      </tr>
      <tr>
        <td align="left" width="40%" class="text7">Order By: </td>
      </tr>
      <tr>
        <td align="left" valign="top"><span class="ftformradiosmall"> </span> <span class="ftformradiosmall">
          <html:select property="orderBy" styleClass="ftforminputsmall">
            <html:option value="customeraddress.Name">Customer Name</html:option>          
          </html:select>
          </span> &nbsp; <span class="ftformradiosmall">
            <html:radio property="orderByDesc" value="Asc"/>
            Asc
            <html:radio property="orderByDesc" value="Desc"/>
            Desc </span></td>
      </tr>
      
           
      <tr>
        <td><img src="images/spacer.gif" alt="" height="5"/></td>
      </tr>
    </table>
    
    </td></tr>
    
</table>

</td>
</tr>
</table>

</html:form>

</td>
</tr>
</table>

</div>
</td>
</tr>


<%-- FOOTER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

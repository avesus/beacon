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

<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/report/ListMovrefAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/report/ListSectionkeyAjax.js"></script>


  <style type="text/css">
   ul { height: 50px; overflow: auto; width: 300px; border: 1px solid #7F9DB9; background: FFFFFF; }
   ul { list-style-type: none; margin: 0; padding: 0; overflow-x: hidden; }
   li { margin: 0; padding: 0; font-family: Verdana,Arial, Helvetica;font-size: 10px;font-weight: normal;background: FFFFFF;color: black;}
  </style>



<title>Timesheet Report</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

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
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong>Timesheet Report</strong> 
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<%-- BREADCRUMBS -----------------%> 


<tr>
<%-- SIDEBAR -----------------%> 
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ReportTimesheet" focus="searchString3">
<html:hidden property="gotoPage" />


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>&nbsp;</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text7">Customer:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString3" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>		
			</td>
  	</tr> 
	<tr>
		<td align="left" class="text7">Resource:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString1" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value="">- select a resource -</html:option>
			<html:option value="NT">NT</html:option>	
            			<html:option value="TS">TS</html:option>
		</html:select>			</td>
  	</tr>
	<tr>
		<td align="left" class="text7">Type:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">		

  <ul>
	<div id="divListsectionkey" class="visible"></div>
  </ul>
  
<!--		
		<html:select property="searchString4" styleClass="ftforminputsmall" size="3" multiple="true" onchange="processListMovref();">				
		</html:select>	
-->
					
		</td>
  	</tr>   	
	<tr>
		<td align="left" class="text7">Task Ref:
		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
				<html:option value="">- select a Task Ref -</html:option>					
		</html:select>					
		</td>
  	</tr>    	 
	<tr>
		<td align="left" width="60%" class="text7">
	  Movement Date:
		</td>		
  	</tr>
  	<tr>
	<td width="60%">
<table width="70%">
		<tr>
          <td width="10%" class="text7">
		  <div align="left">
		&nbsp;From:
		  </div>		  
		  </td>		
          <td width="40%">
		<html:select property="searchDate1dd" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate1mm" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate1yyyy" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>		
          <td width="5%" class="text7">
		  <div align="right">
		       To:
		  </div>		  
		  </td>
          <td width="40%">
		<html:select property="searchDate2dd" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate2mm" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate2yyyy" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>
		  </tr>
		  </table>
		</td>			
  	</tr>
  	<tr>
		<td align="left" width="35%" class="text7">
	  Output:
		</td>		
  	</tr>	
  	<tr>
		<td align="left" width="40%" valign="top">
		<span class="ftformradiosmall">
<html:radio property="searchString9" value="PDF"/>PDF
<html:radio property="searchString9" value="EXCEL"/>Excel
		</span>
		</td>			
	</tr>
	  	<tr>
		<td align="left" width="35%" class="text7">
	  Order By:
		</td>		
  	</tr>	
  	<tr>
		<td align="left" width="40%" valign="top">
		<span class="ftformradiosmall">
		<html:select property="orderBy" styleClass="ftforminputsmall">
        			<html:option value="jobmov.Actfromtimeinmillis">Actual From Date</html:option>
			<html:option value="jobhdr.Unitkey">Unit</html:option>
		</html:select>
		</span>
		&nbsp;
		<span class="ftformradiosmall">
<html:radio property="orderByDesc" value="Asc"/>Asc		
<html:radio property="orderByDesc" value="Desc"/>Desc
		</span>
		</td>			
	</tr>			
	<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
</table>

</td></tr></table>

</td>
</tr>
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

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
Account Interface Detail List
  </title>
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  
  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		//onLoadSidebar('menu2');								
	}
    //]]>
</script>


</head>


  <body onLoad="onLoad();">
<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%-- HEADER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<%-- BREADCRUMBS -----------------%> 
<tr>
	<td height="20" bgcolor="#eeeeee">&nbsp;</td>  
	<td class="tdwht"><span class="heading2">     
		<strong>Account Interface Batch</strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListAIBatch" styleClass="link5">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#eeeeee">
	<td height="1" colspan="2"></td>
</tr>
<%-- BREADCRUMBS -----------------%> 


<tr>
<%-- SIDEBAR -----------------%>
	<td bgcolor="#eeeeee" width="121" valign="top" align="center">

	</td>
	
<%-- BODY -----------------%>	
	<td>
<html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer"><bean:message key="errors.prefix"/><bean:write name="error"/><bean:message key="errors.suffix"/></html:messages>
<html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer"><bean:message key="messages.prefix"/><bean:write name="msg"/><bean:message key="messages.suffix"/></html:messages>
	
    
		<div style="OVERFLOW:auto; width:850px; height:650px;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListAIBatch" focus="searchDate1dd">
<html:hidden property="gotoPage" />

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#CED6E3">
  <tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#CED6E3">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="refreshButton" border="0" type="image" src="images/report/refreshButtonBorder.gif" align="bottom" id="refreshButton" title="Refresh" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('refreshButton','','images/report/refreshButtonBorder.gif','refreshButton','','images/report/refreshButtonBorder_over_blue.gif',1);"/>
&nbsp;AI Batch  Search
</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" width="60%" class="text7">
			  Sent Date:</td>
		<td align="left" width="40%" class="text7">&nbsp;

		</td>		
  	</tr>
  	<tr>
		<td align="left" width="60%">				
		<table width="95%">
		<tr>
          <td width="10%" class="text7">
		  <div align="left">
		&nbsp;From:
		  </div>		  
		  </td>		
          <td width="40%">
		<html:select property="searchDate1dd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate1mm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
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
		<html:select property="searchDate2dd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate2mm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>
		  </tr>
		  </table>		
		</td>
	<td width="40%">&nbsp;

		</td>		
	<tr>
	<tr>
		<td align="left" width="60%" class="text7">&nbsp;</td>
		<td align="left" width="40%" class="text7">&nbsp;</td>		
  	</tr>
  	<tr>
		<td align="left" width="60%">&nbsp;			
		</td>
		<td width="40%" rowspan="3" align="left" valign="top">&nbsp;</td>
  	</tr>	
	
  	<tr>
		<td align="left" width="35%" class="text7">&nbsp;
	  
		</td>		
  	</tr>	
  	<tr>
		<td align="left" width="40%" valign="top">&nbsp;

		</td>			
	</tr>	
	<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
</table>

</td></tr></table>

</td>
</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">
	<bean:message key="prompt.sortby"/>:&nbsp;	
    <logic:notEqual name="ListAIBatchForm" property="orderBy"
			scope="session" value="AIBATCH_ID">
	<html:link action="/ListAIBatch?orderBy=AIBATCH_ID&gotoPage=0" styleClass="link6">Batch ID</html:link>	
</logic:notEqual>
<logic:equal name="ListAIBatchForm" property="orderBy"
			scope="session" value="AIBATCH_ID">
	<strong>Batch ID</strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListAIBatchForm" property="orderBy"
			scope="session" value="Createdate">		
	<strong>Sent Time</strong>
</logic:equal>
<logic:notEqual name="ListAIBatchForm" property="orderBy"
			scope="session" value="Createdate">
			<span class="link4">
	<html:link action="/ListAIBatch?orderBy=Createdate&gotoPage=0" styleClass="link6">Sent Time</html:link>	
			</span>
</logic:notEqual>
	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
    <td align="right"><INPUT type="image" id="sendBatchButton" name="sendBatchButton" src="images/Download.gif" title="Send Batch"/></td>
  </tr>
</table>



	</td>
  </tr> 
</table>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
		  			<td class="tdblue" width="10%">
					<span class="heading4">					
						Batch ID				
						</span>					
					</td>
		  			<td class="tdblue" width="10%">Company Id</td>						
		  			<td class="tdblue" width="10%">
					<span class="heading4">					
						Batch Count					
					</span> </td>
		  			<td class="tdblue" width="10%">Process Count</td>
		  			<td class="tdblue" width="10%">Error Count</td>
		  			<td class="tdblue" width="10%">Process Status</td>	
		  			<td class="tdblue" width="10%">
					<span class="heading4">					
						Sent Time </span>
					</td>																						
				</tr>		
				

			<c:forEach var="lineItem" items="${ListAIBatchForm.lineItems}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>	
									
			<!-- row1 -->
  				<tr>	
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="aibatchId" filter="true"/>
								</td>
								<td class='<c:out value="${_class}"/>' width="10%" nowrap><bean:write name="lineItem" property="companyid" filter="true"/></td>  					
								<td class='<c:out value="${_class}"/>' width="10%" nowrap><bean:write name="lineItem" property="batchcount" filter="true"/></td>
								<td class='<c:out value="${_class}"/>' width="10%" nowrap><bean:write name="lineItem" property="processcount" filter="true"/></td>
								<td class='<c:out value="${_class}"/>' width="10%" nowrap><bean:write name="lineItem" property="errorcount" filter="true"/></td>
								<td class='<c:out value="${_class}"/>' width="10%" nowrap><bean:write name="lineItem" property="processstatus" filter="true"/></td>															
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
								</td>																													
				</tr>										
			<!-- row2 -->							
												
			</c:forEach>
			
			</table>
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

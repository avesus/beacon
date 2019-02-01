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


<html:html>
<head>
<title>EDI Inbound List</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>


<body> 
<logic:messagesPresent message="true">
<ul>
<font color='red' >
<html:messages id="message" message="true">
<li><%= message %></li>
</html:messages>
</font>
</ul>
</logic:messagesPresent>
<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%-- HEADER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<%-- BREADCRUMBS -----------------%> 
<tr>
<%--	<td height="20" bgcolor="#CCCCCC">&nbsp;</td>  --%>
	<td class="tdwht"><span class="heading2">     
		<strong>EDI Inbound</strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListEDIInbound" styleClass="link5">
				<bean:message key="title.list"/> 	
			</html:link>
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

<jsp:include page="/pages/sidebar.jsp" flush="true" />

	</td>--%>
	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:1050px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListEDIInbound" focus="searchString1">
<html:hidden property="gotoPage" />
<%--
<html:hidden property="firstResult" />
<html:hidden property="maxResults" />
<html:hidden property="totalResults" />
<html:hidden property="firstPage" />
<html:hidden property="lastPage" />
<html:hidden property="orderBy" />
--%>
<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#E3E9F1">
  <tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#E3E9F1">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<%--<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/search_button.gif" align="bottom"/>--%>
<INPUT name="refreshButton" border="0" type="image" src="images/report/refreshButtonBorder.gif" align="bottom" id="refreshButton" title="Refresh" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('refreshButton','','images/report/refreshButtonBorder.gif','refreshButton','','images/report/refreshButtonBorder_over_blue.gif',1);"/>
&nbsp;EDI Inbound  Search
</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" width="40%" class="text7">Doc Type:		</td>
		<td align="left" width="60%" class="text7">
	  Receive Date:
		</td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value="">- select a Type -</html:option>				
			<html:option value="IFTMBF">IFTMBF</html:option>
			<html:option value="IFTMIN">IFTMIN</html:option>
			<html:option value="IFCSUM">IFCSUM</html:option>																							
		</html:select>						
		</td>
	<td width="60%">
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
	<tr>
	<tr>
		<td align="left" width="40%" class="text7">Partner:		</td>
		<td align="left" width="60%" class="text7">&nbsp;</td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
			<html:option value="%">- select a Partner -</html:option>
			<html:option value="BASFAG2">BASFAG2</html:option>						
		</html:select>			
		</td>
		<td width="60%" rowspan="3" align="left" valign="top">&nbsp;</td>
  	</tr>	
	
  	<tr>
		<td align="left" width="35%" class="text7">
	  Status:
		</td>		
  	</tr>	
  	<tr>
		<td align="left" width="40%" valign="top">
		<span class="ftformradiosmall3">
<html:radio property="searchString9" value="%"/>
All
<html:radio property="searchString9" value="AVAILABLE"/>
Available
<html:radio property="searchString9" value="RECEIVED"/>
Received
<html:radio property="searchString9" value="PROCESSED"/>
Processed
<html:radio property="searchString9" value="ACKREC"/>
Ack Receipt
</span>
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
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="EDIINBOUND_ID">
	<html:link action="/ListEDIInbound?orderBy=EDIINBOUND_ID&gotoPage=0" styleClass="link6">ID</html:link>	
</logic:notEqual>
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="EDIINBOUND_ID">
	<strong>ID</strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>	
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Doctype">
	<html:link action="/ListEDIInbound?orderBy=Doctype&gotoPage=0" styleClass="link6">Type</html:link>	
</logic:notEqual>
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Doctype">
	<strong>Type</strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Ediid">		
	<strong>Partner</strong>
</logic:equal>
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Ediid">
			<span class="link4">
	<html:link action="/ListEDIInbound?orderBy=Ediid&gotoPage=0" styleClass="link6">Partner</html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Edistatus">		
	<strong>Status</strong>
</logic:equal>
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Edistatus">
			<span class="link4">
	<html:link action="/ListEDIInbound?orderBy=Edistatus&gotoPage=0" styleClass="link6">Status</html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Receivedate">		
	<strong>Receive Date</strong>
</logic:equal>
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Receivedate">
			<span class="link4">
	<html:link action="/ListEDIInbound?orderBy=Receivedate&gotoPage=0" styleClass="link6">Receive Date</html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>	
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Processdate">		
	<strong>Process Date</strong>
</logic:equal>
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Processdate">
			<span class="link4">
	<html:link action="/ListEDIInbound?orderBy=Processdate&gotoPage=0" styleClass="link6">Process Date</html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>	
<logic:equal name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Filename">		
	<strong>File Name</strong>
</logic:equal>
<logic:notEqual name="ListEDIInboundForm" property="orderBy"
			scope="session" value="Filename">
			<span class="link4">
	<html:link action="/ListEDIInbound?orderBy=Filename&gotoPage=0" styleClass="link6">File Name</html:link>	
			</span>
</logic:notEqual>
	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
                                    <img src="images/spacer.gif" width="1" height="13" border="0"/> 
	</td>
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
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						Doc Type						</span>					</td>						
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						Partner					</span> </td>	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">	
					Status					</span>					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						Receive Time </span>					</td>											
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						Process Time					</span>					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						File Name</span>					</td>
				</tr>		
				

			<c:forEach var="lineItem" items="${ListEDIInboundForm.lineItems}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${lineItem.edistatus == 'AVAILABLE'}">
					<c:set var="_class" value="tdlghtgryRed"/>
				</c:if>	
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>
					<c:if test="${lineItem.edistatus == 'AVAILABLE'}">
 						<c:set var="_class" value="tdlghtgry2Red"/>
					</c:if>					
				</c:if>
													
			<!-- row1 -->
  				<tr>	
								<td class='<c:out value="${_class}"/>' width="10%" valign="top">
									<bean:write name="lineItem" property="doctype" filter="true"/>								</td>  					
								<td class='<c:out value="${_class}"/>' width="10%" nowrap valign="top">									
									<bean:write name="lineItem" property="ediid" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' width="10%" nowrap valign="top">
									<bean:write name="lineItem" property="edistatus" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' width="10%" valign="top">
									<bean:write name="lineItem" property="receivedate" format="dd-MMM-yyyy" filter="true"/>								
									&nbsp;<bean:write name="lineItem" property="receivetime" filter="true"/>
									</td>	
								<td class='<c:out value="${_class}"/>' width="10%" valign="top">																	
									<bean:write name="lineItem" property="processdate" format="dd-MMM-yyyy" filter="true"/>								
									&nbsp;<bean:write name="lineItem" property="processtime" filter="true"/>
									</td>
								<td class='<c:out value="${_class}"/>' width="10%" nowrap valign="top">
									<bean:write name="lineItem" property="filename" filter="true"/>								
								</td>
				</tr>
				<tr>								
					<td class='<c:out value="${_class}"/>' colspan="6" width="10%" align="left" valign="top">

	  					<app:linkEDIInboundLineItem page="/EditEDIInbound.do?action=View">
						View						
						</app:linkEDIInboundLineItem>	
											
					<c:if test="${lineItem.doctype == 'IFTMBF'}">
|
						<app:linkEDIInboundLineItem page="/ReportEdifactIftmbf.do?action=Detail">
						Detail Report						
						</app:linkEDIInboundLineItem>										
					</c:if>	
					<c:if test="${lineItem.doctype == 'IFTMIN'}">
|
						<app:linkEDIInboundLineItem page="/ReportEdifactIftmin.do?action=Detail">
						Detail Report						
						</app:linkEDIInboundLineItem>
					</c:if>																		
				
					<c:if test="${lineItem.doctype == 'IFTMBF'}">
|
						<app:linkEDIInboundLineItem page="/ReportEdifactIftmbf.do?action=Summary">
						Summary Report						
						</app:linkEDIInboundLineItem>										
					</c:if>	
					<c:if test="${lineItem.doctype == 'IFTMIN'}">
|
						<app:linkEDIInboundLineItem page="/ReportEdifactIftmin.do?action=Summary">
						Summary Report						
						</app:linkEDIInboundLineItem>
					</c:if>																		

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

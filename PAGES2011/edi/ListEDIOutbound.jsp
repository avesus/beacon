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
<title>EDI Outbound List</title>
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
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="edioutbound.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListEDIOutbound" styleClass="link5">
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

<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />

	</td>--%>
	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:1050px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListEDIOutbound" focus="searchString1">
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
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="edioutbound.title.search"/>
</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" width="40%" class="text7"><bean:message key="prompt.doctype"/>:		</td>
		<td align="left" width="60%" class="text7">
	  <bean:message key="prompt.createdate"/>:
		</td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectatype"/></html:option>				
			<html:option value="IFTSTA">IFTSTA</html:option>															
		</html:select>						
		</td>
	<td width="60%">
		<table width="95%">
		<tr>
          <td width="10%" class="text7">
		  <div align="left">
		&nbsp;<bean:message key="prompt.from"/>:
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
		       <bean:message key="prompt.to"/>:
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
		<td align="left" width="40%" class="text7"><bean:message key="prompt.partner"/>:		</td>
		<td align="left" width="60%" class="text7">&nbsp;</td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectapartner"/></html:option>
			<html:option value="BASFAG2">BASF</html:option>						
		</html:select>			
		</td>
		<td width="60%" rowspan="5" align="left" valign="top">&nbsp;</td>
  	</tr>	
	
  	<tr>
		<td align="left" width="35%" class="text7">
	  <bean:message key="prompt.status"/>:
		</td>		
  	</tr>	
  	<tr>
		<td align="left" width="40%" valign="top">
		<span class="ftformradiosmall3">
<html:radio property="searchString9" value="%"/>
<bean:message key="prompt.all"/>
<html:radio property="searchString9" value="PENDING"/>
<bean:message key="prompt.pending"/>
<html:radio property="searchString9" value="ERROR"/>
<bean:message key="prompt.error"/> 
<html:radio property="searchString9" value="SENT"/>
<bean:message key="prompt.sent"/>
</span>
		</td>			
	</tr>
	  	<tr>
		<td align="left" width="35%" class="text7">
	  <bean:message key="prompt.docid"/>:
		</td>		
  	</tr>
 	<tr>
		<td align="left" width="40%" valign="top">
		<html:text property="searchString3" size="10" maxlength="10" styleClass="ftforminputsmall"/>			
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
<logic:notEqual name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="EDIOUTBOUND_ID">
	<html:link action="/ListEDIOutbound?orderBy=EDIOUTBOUND_ID&gotoPage=0" styleClass="link6"><bean:message key="prompt.docid"/></html:link>	
</logic:notEqual>
<logic:equal name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="EDIOUTBOUND_ID">
	<strong><bean:message key="prompt.docid"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>	
<logic:notEqual name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Doctype">
	<html:link action="/ListEDIOutbound?orderBy=Doctype&gotoPage=0" styleClass="link6"><bean:message key="prompt.doctype"/></html:link>	
</logic:notEqual>
<logic:equal name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Doctype">
	<strong><bean:message key="prompt.doctype"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Ediid">		
	<strong><bean:message key="prompt.partner"/></strong>
</logic:equal>
<logic:notEqual name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Ediid">
			<span class="link4">
	<html:link action="/ListEDIOutbound?orderBy=Ediid&gotoPage=0" styleClass="link6"><bean:message key="prompt.partner"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>	
<logic:equal name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Createdate">		
	<strong><bean:message key="prompt.createtime"/></strong>
</logic:equal>
<logic:notEqual name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Createdate">
			<span class="link4">
	<html:link action="/ListEDIOutbound?orderBy=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.createtime"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Sentdate">		
	<strong><bean:message key="prompt.senttime"/></strong>
</logic:equal>
<logic:notEqual name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Sentdate">
			<span class="link4">
	<html:link action="/ListEDIOutbound?orderBy=Sentdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.senttime"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Edistatus">		
	<strong><bean:message key="prompt.status"/></strong>
</logic:equal>
<logic:notEqual name="ListEDIOutboundForm" property="orderBy"
			scope="session" value="Edistatus">
			<span class="link4">
	<html:link action="/ListEDIOutbound?orderBy=Edistatus&gotoPage=0" styleClass="link6"><bean:message key="prompt.status"/></html:link>	
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
		  			<td class="tddkgry" width="1%">
					<span class="heading4">					
						<bean:message key="heading.docid"/>						</span>					</td>				
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.doctype"/>						</span>					</td>						
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.partner"/>					</span> </td>	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">	
					<bean:message key="heading.status"/>					</span>					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.createuser"/> </span></td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.createtime"/> </span>					</td>											
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.senttime"/>					</span>					</td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.dockey"/>				</span></td>																								
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.controlid"/></span>					</td>
		  			<td class="tddkgry" width="5%" align="left">
					<span class="heading4">
						<bean:message key="heading.batchid"/>					</span> </td>
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					</span> </td>																
				</tr>		
				

			<c:forEach var="lineItem" items="${ListEDIOutboundForm.lineItems}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${lineItem.edistatus == 'ERROR'}">
					<c:set var="_class" value="tdlghtgryRed"/>
				</c:if>	
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>
					<c:if test="${lineItem.edistatus == 'ERROR'}">
 						<c:set var="_class" value="tdlghtgry2Red"/>
					</c:if>					
				</c:if>

									
			<!-- row1 -->
  				<tr>	
								<td class='<c:out value="${_class}"/>' width="1%">
									<bean:write name="lineItem" property="edioutboundId" filter="true"/>								</td> 				
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="doctype" filter="true"/>								</td>  					
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>									
									<bean:write name="lineItem" property="ediid" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>
									<bean:write name="lineItem" property="edistatus" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' width="10%"><bean:write name="lineItem" property="createuserid" filter="true"/></td>
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' width="10%">																	
									<bean:write name="lineItem" property="sentdate" format="dd-MMM-yyyy" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>																	
									<bean:write name="lineItem" property="dockey" filter="true"/>								</td>		
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>
									<bean:write name="lineItem" property="controlid" filter="true"/>								</td>
								<td class='<c:out value="${_class}"/>' width="5%" align="left" valign="top" nowrap>
  										<bean:write name="lineItem" property="edibatchId" filter="true"/>								</td>		
					<td class='<c:out value="${_class}"/>' width="10%" align="right">
					<c:if test="${lineItem.edistatus == 'PENDING'}">
	  					<app:linkEDIOutboundLineItem page="/EditEDIOutbound.do?action=Delete">
						<bean:message key="prompt.delete"/>						
						</app:linkEDIOutboundLineItem>
						&nbsp;|&nbsp; 
	  					<app:linkEDIOutboundLineItem page="/EditEDIOutbound.do?action=View">
						<bean:message key="prompt.view"/>						
						</app:linkEDIOutboundLineItem> 						 
					</c:if>
					<c:if test="${lineItem.edistatus == 'SENT'}">
	  					<app:linkEDIOutboundLineItem page="/EditEDIOutbound.do?action=View">
						<bean:message key="prompt.view"/>							
						</app:linkEDIOutboundLineItem> 						 
					</c:if>									
					</td>																												
				</tr>	
													
			<!-- row2 -->
  				<tr>	
					<td colspan="10" class='<c:out value="${_class}"/>' width="95%">&nbsp;
			<c:if test="${lineItem.edistatus == 'ERROR'}">					
						<bean:write name="lineItem" property="errors" filter="true"/> 							
			</c:if>	
					</td> 				
					<td class='<c:out value="${_class}"/>' width="5%" align="right">&nbsp;
			<c:if test="${lineItem.edistatus == 'ERROR'}">					
	  					<app:linkEDIOutboundLineItem page="/EditEDIOutbound.do?action=FixError">
						<bean:message key="prompt.fixerror"/>							
						</app:linkEDIOutboundLineItem>  
			</c:if>							
					</td>																												
				</tr>
			
										
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

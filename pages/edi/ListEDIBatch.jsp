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
<title>EDI Batch List</title>
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
		<strong>EDI Batch</strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListEDIBatch" styleClass="link5">
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
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListEDIBatch" focus="searchDate1dd">
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
&nbsp;EDI Batch  Search
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
<logic:equal name="ListEDIBatchForm" property="orderBy"
			scope="session" value="Createdate">		
	<strong>Sent Time</strong>
</logic:equal>
<logic:notEqual name="ListEDIBatchForm" property="orderBy"
			scope="session" value="Createdate">
			<span class="link4">
	<html:link action="/ListEDIBatch?orderBy=Createdate&gotoPage=0" styleClass="link6">Sent Time</html:link>	
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
<logic:equal name="ListEDIBatchForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListEDIBatchForm" property="firstPage" 
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListEDIBatchForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListEDIBatchForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListEDIBatchForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListEDIBatchForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListEDIBatchForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListEDIBatchForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>
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
						Batch ID				
						</span>					
					</td>						
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						Record Count					
					</span> </td>	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						Sent Time </span>
					</td>																						
				</tr>		
				

			<c:forEach var="lineItem" items="${ListEDIBatchForm.lineItems}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>				
				</c:if>	
									
			<!-- row1 -->
  				<tr>	
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="edibatchId" filter="true"/>
								</td>  					
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>									
									<bean:write name="lineItem" property="batchcount" filter="true"/>
								</td>															
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

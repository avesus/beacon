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

<app:checkLogon/>

<html:html>
<head>
<title>Currency Exchange Rate List</title>
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
		<strong><bean:message key="ccyex.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListCcyex" styleClass="link5">
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
	
		<div style="OVERFLOW:auto; width:600px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListCcyex" focus="searchString1">
<html:hidden property="gotoPage" />


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#F6E4C0">
  <tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#F6E4C0">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="prompt.ccyex.search"/></h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" width="24%" class="text7"><bean:message key="prompt.fromccy"/>:		</td>
		<td align="left" width="76%" class="text7"><bean:message key="prompt.toccy"/>:</td>		
  	</tr>
  	<tr>
		<td align="left" width="24%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>		</td>
	<td width="76%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>	
	</td>
	</tr>
	<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>		
	<tr>
		<td align="left" width="24%" class="text7"><bean:message key="prompt.exdate"/>:		</td>
		<td align="left" width="76%" class="text7">&nbsp;</td>		
  	</tr>
  	<tr>
		<td colspan="2" align="left">
		<table width="95%">
          <tr>
            <td width="11%" class="text7"><div align="left"> &nbsp;<bean:message key="prompt.from"/>: </div></td>
            <td width="37%"><html:select property="searchDate1dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
                <html:select property="searchDate1mm" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.month"/>
                  </html:option>
                  <html:options collection="months" property="value" labelProperty="label"/>
                </html:select>
                <html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.year"/>
                  </html:option>
                  <html:options collection="years" property="value" labelProperty="label"/>
                </html:select>
            </td>
            <td width="6%" class="text7"><div align="right"> <bean:message key="prompt.to"/>: </div></td>
            <td width="46%"><html:select property="searchDate2dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
                <html:select property="searchDate2mm" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.month"/>
                  </html:option>
                  <html:options collection="months" property="value" labelProperty="label"/>
                </html:select>
                <html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.year"/>
                  </html:option>
                  <html:options collection="years" property="value" labelProperty="label"/>
                </html:select>
            </td>
          </tr>
        </table></td>
		</tr>	
	<tr>
	  <td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
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
<logic:notEqual name="ListCcyexForm" property="orderBy"
			scope="session" value="Fromccykey">
	<html:link action="/ListCcyex?orderBy=Fromccykey&gotoPage=0" styleClass="link6"><bean:message key="prompt.fromcurrency"/></html:link>	
</logic:notEqual>
<logic:equal name="ListCcyexForm" property="orderBy"
			scope="session" value="Fromccykey">
	<strong><bean:message key="prompt.fromcurrency"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:notEqual name="ListCcyexForm" property="orderBy"
			scope="session" value="Toccykey">
	<html:link action="/ListCcyex?orderBy=Toccykey&gotoPage=0" styleClass="link6"><bean:message key="prompt.tocurrency"/></html:link>	
</logic:notEqual>
<logic:equal name="ListCcyexForm" property="orderBy"
			scope="session" value="Toccykey">
	<strong><bean:message key="prompt.tocurrency"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:notEqual name="ListCcyexForm" property="orderBy"
			scope="session" value="Exdate">
	<html:link action="/ListCcyex?orderBy=Exdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.exchangedate"/></html:link>	
</logic:notEqual>
<logic:equal name="ListCcyexForm" property="orderBy"
			scope="session" value="Exdate">
	<strong><bean:message key="prompt.exchangedate"/></strong>
</logic:equal>					
	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
<logic:equal name="ListCcyexForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListCcyexForm" property="firstPage" 
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListCcyexForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListCcyexForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListCcyexForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListCcyexForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListCcyexForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListCcyexForm" property="lastPage"
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
						<bean:message key="heading.fromccy"/>
					</span>					
					</td>				
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.toccy"/>
					</span>					</td>						
		  			<td class="tddkgry" width="10%">
					<span class="heading4">					
						<bean:message key="heading.exdate"/>
					</span> </td>	
		  			<td class="tddkgry" width="10%">
					<span class="heading4">	
						<bean:message key="heading.exrate"/>
					</span></td>					
		  			<td class="tddkgry" width="15%" align="right">
					<span class="heading4">	
					<html:link action="/EditCcyex?action=Create"><bean:message key="prompt.add"/></html:link>	
					</span>
					</td>																					
				</tr>		
				

			<c:forEach var="lineItem" items="${ListCcyexForm.lineItems}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>			
				</c:if>

									
			<!-- row1 -->
  				<tr>	
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="fromccykey" filter="true"/>								
									</td> 				
								<td class='<c:out value="${_class}"/>' width="10%">
									<bean:write name="lineItem" property="toccykey" filter="true"/>								
									</td>  					
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>									
									<bean:write name="lineItem" property="exdate" format="dd-MMM-yyyy" filter="true"/>								
									</td>								
								<td class='<c:out value="${_class}"/>' width="10%" nowrap>
									<bean:write name="lineItem" property="exrate" filter="true"/>								
									</td>								
<td class='<c:out value="${_class}"/>' width="15%" align="right">
	  					<table border="0" align="right" cellpadding="1" cellspacing="3">
                          <tr>
                            <td class='<c:out value="${_class}"/>'><app:linkCcyexLineItem page="/EditCcyex.do?action=Delete">
                              <bean:message key="prompt.delete"/>
                            </app:linkCcyexLineItem>
                              &nbsp;|&nbsp; </td>
                            <td class='<c:out value="${_class}"/>'><app:linkCcyexLineItem page="/EditCcyex.do?action=Edit">
                              <bean:message key="prompt.edit"/>
                            </app:linkCcyexLineItem>
                              &nbsp;|&nbsp; </td>
                            <td class='<c:out value="${_class}"/>'><app:linkCcyexLineItem page="/EditCcyex.do?action=Copy">
                              <bean:message key="prompt.copy"/>
                            </app:linkCcyexLineItem>
                            </td>
                          </tr>
                        </table></td>																												
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

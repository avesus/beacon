<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--
 *
 * Amendments
 * ----------
 * 	
 *	NT	2009-10-20		200900049				Add 'ActiveExpired' Search Criteria
 *												Add 'View' functionality
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

<app:checkLogon/>


<html:html>
<head>
<title><bean:message key="title.list"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>

</head>


<body> 
<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<!-- HEADER ----------------->
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<!-- BREADCRUMBS -----------------> 
<tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="customertariffhdr.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListCustomertariffhdr" styleClass="link5">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS -----------------> 


<tr>
<!-- SIDEBAR ----------------->
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
<!-- BODY ----------------->	
	<td>
	
		<div style="OVERFLOW:auto; width:1150px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListCustomertariffhdr" focus="searchString3">
<html:hidden property="gotoPage" />
<html:hidden property="action" />

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


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="3" valign="middle">
<h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="customertariffhdr.title.search"/></h1>
</td></tr>
<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.code"/>:		</td>
      
<!--s200900049-->
		<td align="left" class="text2">
        <bean:message key="prompt.activeexpired"/>: 
        </td>
<!--e200900049--> 
	</tr>
  	<tr>
        	    <td align="left" width="30%">
		<html:text property="searchString3" size="20" maxlength="10" styleClass="ftforminputsmall" onkeypress="return noenter()"/>	                
                </td>
                
    	    <td align="left" width="30%">
    
<!--s200900049-->        
<span class="ftformradiosmall">
        <html:radio property="searchString15" value="ALL"/>
        <bean:message key="prompt.all"/>
&nbsp;	  
        <html:radio property="searchString15" value="ACTIVE"/>
        <bean:message key="prompt.active"/>
&nbsp;
        <html:radio property="searchString15" value="EXPIRED"/>
        <bean:message key="prompt.expired"/>
</span>        
<%--        <table width="95%">
          <tr>
            <td width="10%" class="text7"><div align="left"> &nbsp;<bean:message key="prompt.from"/>: </div></td>
            <td width="40%"><html:select property="searchDate1dd" styleClass="ftforminputsmall">
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
            <td width="5%" class="text7"><div align="right"> <bean:message key="prompt.to"/>: </div></td>
            <td width="40%"><html:select property="searchDate2dd" styleClass="ftforminputsmall">
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
        </table>--%>
<!--e200900049-->  

</td>
  	<tr>
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.customeraddrkey.search"/>:		</td>
  	    <td align="left" class="text2">&nbsp;</td>
	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>		</td>
	    <td align="left" width="30%">&nbsp;</td>
  	<tr>
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.chargekey.search"/>:		</td>
  	    <td align="left" class="text2">&nbsp;</td>
	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacharge"/></html:option>
			<html:options collection="charges" property="chargekey" labelProperty="ldesc"/>	
		</html:select>		</td>	
  	    <td align="left" width="30%">&nbsp;</td>
  	</tr>
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
	<logic:notEqual name="ListCustomertariffhdrForm" property="orderBy"
			scope="session" value="customertariffhdr.CusttarfhdrId">		
	<html:link action="/ListCustomertariffhdr?orderBy=customertariffhdr.CusttarfhdrId" styleClass="link6">
	<bean:message key="prompt.code"/>
	</html:link>	
</logic:notEqual>
<logic:equal name="ListCustomertariffhdrForm" property="orderBy"
			scope="session" value="customertariffhdr.CusttarfhdrId">		
	<strong><bean:message key="prompt.code"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:notEqual name="ListCustomertariffhdrForm" property="orderBy"
			scope="session" value="Customeraddrkey">		
	<html:link action="/ListCustomertariffhdr?orderBy=Customeraddrkey" styleClass="link6">
	<bean:message key="prompt.customer"/>
	</html:link>	
</logic:notEqual>
<logic:equal name="ListCustomertariffhdrForm" property="orderBy"
			scope="session" value="Customeraddrkey">		
	<strong><bean:message key="prompt.customer"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListCustomertariffhdrForm" property="orderBy"
			scope="session" value="Chargekey">		
	<strong><bean:message key="prompt.charge"/></strong>
</logic:equal>
<logic:notEqual name="ListCustomertariffhdrForm" property="orderBy"
			scope="session" value="Chargekey">
			<span class="link4">
	<html:link action="/ListCustomertariffhdr?orderBy=Chargekey" styleClass="link6">
	<bean:message key="prompt.charge"/>
	</html:link>	
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
<logic:equal name="ListCustomertariffhdrForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListCustomertariffhdrForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListCustomertariffhdrForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListCustomertariffhdrForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListCustomertariffhdrForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListCustomertariffhdrForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListCustomertariffhdrForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListCustomertariffhdrForm" property="lastPage"
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
		  			<td width="5%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.code"/>
		  			</span>	
					</td>					
		  			<td width="15%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.customer"/>
		  			</span>	
					</td>	
		  			<td width="7%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.charge"/>
		  			</span>	
					</td>
		  			<td width="10%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.loadingplant"/>
		  			</span>	
					</td>
		  			<td width="10%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.loadingport"/>
		  			</span>	
					</td>
		  			<td width="10%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.dischargeport"/>
		  			</span>	
					</td>
		  			<td width="10%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.dischargeplant"/>
		  			</span>	
					</td>																					
		  			<td width="3%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.currency"/>
		  			</span>	
					</td>
		  			<td width="5%" class="tddkgry"><span class="heading4">
						<bean:message key="prompt.lumpsum"/>
		  			</span>	
					</td>
		  			<td width="7%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.expirydate"/>
		  			</span>	
					</td>																					
		  			<td class="tddkgry" width="20%">
                    
<logic:notEqual name="ListCustomertariffhdrForm" property="action" scope="session" value="View"><!--200900049-->     
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
    <td align="left" class="heading4"><bean:message key="heading.action"/> </td>					
						<td align="right" class="heading4">
<html:link action="/EditCustomertariffhdr?action=Create">
<bean:message key="prompt.customertariffhdr.add"/>
</html:link>								
						</td>
					</tr>
					</table>
</logic:notEqual>
                    
					</td>										
				</tr>
<%
int row=0;
%>			
			<logic:iterate id="customertariffhdrLineItem" name="ListCustomertariffhdrForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>				
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="5%" nowrap="nowrap">
						<bean:write name="customertariffhdrLineItem" property="custtarfhdrId" filter="true"/>
					</td> 				
					<td class="<%= _class %>" width="15%">
						<bean:write name="customertariffhdrLineItem" property="customeraddrkey.name" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="7%">
						<bean:write name="customertariffhdrLineItem" property="chargekey.chargekey" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%">
<bean:write name="customertariffhdrLineItem" property="fromlocationkey.locationName" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%">
<bean:write name="customertariffhdrLineItem" property="fromlocationkey2.locationName" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%">
<bean:write name="customertariffhdrLineItem" property="tolocationkey2.locationName" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%">
<bean:write name="customertariffhdrLineItem" property="tolocationkey.locationName" filter="true"/>
					</td> 																					
					<td class="<%= _class %>" width="3%">
						<bean:write name="customertariffhdrLineItem" property="ccykey" filter="true"/>
					</td>			
					<td class="<%= _class %>" align="right" width="5%">
						<bean:write name="customertariffhdrLineItem" property="lumpsum" filter="true"/>
					</td>
					<td class="<%= _class %>" width="7%">
						<bean:write name="customertariffhdrLineItem" property="validto" format="dd-MMM-yyyy"  filter="true"/>
					</td>
								<td class="<%= _class %>" width="20%" align="right">
                                
<logic:notEqual name="ListCustomertariffhdrForm" property="action" scope="session" value="View"><!--200900049-->                                												
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
										<tr>							
											<td class="text2" align="left">								
<app:linkCustomertariffhdrLineItem page="/ListCustomertariffdtl.do"><bean:message key="prompt.rates"/></app:linkCustomertariffhdrLineItem>						
											</td>												
											<td class="text2" align="right">								
<app:linkCustomertariffhdrLineItem page="/EditCustomertariffhdr.do?action=Delete"><bean:message key="prompt.delete"/></app:linkCustomertariffhdrLineItem>&nbsp;|&nbsp;											
<app:linkCustomertariffhdrLineItem page="/EditCustomertariffhdr.do?action=Edit"><bean:message key="prompt.edit"/></app:linkCustomertariffhdrLineItem>&nbsp;|&nbsp;					
<app:linkCustomertariffhdrLineItem page="/EditCustomertariffhdr.do?action=Copy"><bean:message key="prompt.copy"/></app:linkCustomertariffhdrLineItem>
											</td>							
										</tr>
									</table>
</logic:notEqual>

<logic:equal name="ListCustomertariffhdrForm" property="action" scope="session" value="View"><!--200900049--> 
<app:linkCustomertariffhdrLineItem page="/EditCustomertariffhdr.do?action=View"><bean:message key="prompt.view"/></app:linkCustomertariffhdrLineItem>
</logic:equal>
                                    																					
								</td>											 
				</span>
  				</tr>	
				
				<tr><td colspan="12" background="images/border_dotted.gif"></td></tr>
							
			</logic:iterate>
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


<!-- FOOTER ----------------->
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

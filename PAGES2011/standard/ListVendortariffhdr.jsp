<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--
 *
 * Amendments
 * ----------
 *
 *	NT	2009-09-14		200900037				Add 'Valid From' Date
 * 	
 *	NT	2009-10-20		200900049				Add 'From Location', 'To Location' and 'ActiveExpired' Search Criteria
 *												Add 'View' functionality
 * 	 											
 *	NT	2010-03-15		201000014				Increase size of import field
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
		<strong><bean:message key="vendortariffhdr.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListVendortariffhdr" styleClass="link5">
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
<html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer"><bean:message key="errors.prefix"/><bean:write name="error"/><bean:message key="errors.suffix"/></html:messages>
<html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer"><bean:message key="messages.prefix"/><bean:write name="msg"/><bean:message key="messages.suffix"/></html:messages>

	
		<div style="OVERFLOW:auto; width:1250px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListVendortariffhdr" focus="searchString3">
<html:hidden property="gotoPage" />
<html:hidden property="action" />

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="3" valign="middle">
<h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="vendortariffhdr.title.search"/></h1>
</td></tr>
<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.code"/>:		</td>
  	    <td align="left" class="text2">
<!--s200900049-->
        <%--<html:checkbox property="searchString4" />&nbsp;<bean:message key="prompt.expirydate"/>:--%>
        <bean:message key="prompt.activeexpired"/>: 
<!--e200900049-->        
        </td>

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
	  <bean:message key="prompt.vendoraddrkey.search"/>:		</td>
  	    <td align="left" class="text2"><bean:message key="prompt.fromlocation"/>:</td><!--200900049-->
	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>		</td>
	    <td align="left" width="30%">
<!--200900049-->        
		<html:select property="searchString5" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>        
        </td>
  	<tr>
	<tr>
		<td align="left" class="text2">
	  <bean:message key="prompt.costkey.search"/>:		</td>
  	    <td align="left" class="text2"><bean:message key="prompt.tolocation"/>:</td><!--200900049-->
	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:select property="searchString2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacost"/></html:option>
			<html:options collection="costs" property="costkey" labelProperty="descr"/>	
		</html:select>		</td>		
  	    <td align="left" width="30%">
<!--200900049-->		
        <html:select property="searchString6" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>
        </td>
  	</tr>
</table>

</td></tr></table>

</td>
</tr>
</table>


<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="45%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">	
	<bean:message key="prompt.sortby"/>:&nbsp;
	<logic:notEqual name="ListVendortariffhdrForm" property="orderBy"
			scope="session" value="vendortariffhdr.VendtarfhdrId">		
	<html:link action="/ListVendortariffhdr?orderBy=vendortariffhdr.VendtarfhdrId" styleClass="link6">
	<bean:message key="prompt.code"/>
	</html:link>	
</logic:notEqual>
<logic:equal name="ListVendortariffhdrForm" property="orderBy"
			scope="session" value="vendortariffhdr.VendtarfhdrId">		
	<strong><bean:message key="prompt.code"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:notEqual name="ListVendortariffhdrForm" property="orderBy"
			scope="session" value="Vendoraddrkey">		
	<html:link action="/ListVendortariffhdr?orderBy=Vendoraddrkey" styleClass="link6">
	<bean:message key="prompt.vendor"/>
	</html:link>	
</logic:notEqual>
<logic:equal name="ListVendortariffhdrForm" property="orderBy"
			scope="session" value="Vendoraddrkey">		
	<strong><bean:message key="prompt.vendor"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListVendortariffhdrForm" property="orderBy"
			scope="session" value="Costkey">		
	<strong><bean:message key="prompt.cost"/></strong>
</logic:equal>
<logic:notEqual name="ListVendortariffhdrForm" property="orderBy"
			scope="session" value="Costkey">
			<span class="link4">
	<html:link action="/ListVendortariffhdr?orderBy=Costkey" styleClass="link6">
	<bean:message key="prompt.cost"/>
	</html:link>	
			</span>
</logic:notEqual>
	</td>	
  </tr>
</table>
	</td>

<td width="55%">	
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
  	<td><INPUT type="image" id="exportButton" name="exportButton" src="images/icon_mini_export.gif" title="Export List to Excel"/></td>
  	<td><html:img src="images/bg_separaPuntos.gif"/></td>
	<td><INPUT type="image" id="importButton" name="importButton" src="images/icon_mini_import.gif" title="Import from Excel - CSV FORMAT"/></td>
	<td><html:text property="searchString9" size="100" maxlength="200" styleClass="ftforminputsmall" onkeypress="return noenter()" title="Excel File Name"/></td><!--201000014-->
	<td><html:img src="images/bg_separaPuntos.gif"/></td>
	<td align="right">
<logic:equal name="ListVendortariffhdrForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListVendortariffhdrForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListVendortariffhdrForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListVendortariffhdrForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListVendortariffhdrForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListVendortariffhdrForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListVendortariffhdrForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListVendortariffhdrForm" property="lastPage"
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
		  			<td width="7%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.code"/>
		  			</span>	
					</td>				
		  			<td width="15%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.vendor"/>
		  			</span>	
					</td>	
		  			<td width="7%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.cost"/>
		  			</span>	
					</td>
		  			<td width="15%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.fromlocation"/>
		  			</span>	
					</td>
		  			<td width="15%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.tolocation"/>
		  			</span>	
					</td>											
		  			<td width="3%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.currency"/>
		  			</span>	
					</td>
		  			<td width="6%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.lumpsum"/>
		  			</span>	
					</td>							
		  			<td width="9%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.validfrom"/><!--200900037-->
		  			</span>	
					</td>
		  			<td width="9%" class="tddkgry"><span class="heading4">
						<bean:message key="heading.expirydate"/>
		  			</span>	
					</td>																			
		  			<td class="tddkgry" width="30%">

<logic:notEqual name="ListVendortariffhdrForm" property="action" scope="session" value="View"><!--200900049-->                      
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
    <td align="left" class="heading4"><bean:message key="heading.action"/> </td>					
						<td align="right" class="heading4">
<html:link action="/EditVendortariffhdr?action=Create">
<bean:message key="prompt.vendortariffhdr.add"/>
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
			<logic:iterate id="vendortariffhdrLineItem" name="ListVendortariffhdrForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>				
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="7%" nowrap="nowrap">
						<bean:write name="vendortariffhdrLineItem" property="vendtarfhdrId" filter="true"/>
					</td>				
					<td class="<%= _class %>" width="15%">
						<bean:write name="vendortariffhdrLineItem" property="vendoraddrkey.name" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="7%">
<bean:write name="vendortariffhdrLineItem" property="costkey.costkey" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="15%">
<bean:write name="vendortariffhdrLineItem" property="fromlocationkey.locationName" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="15%">
<bean:write name="vendortariffhdrLineItem" property="tolocationkey.locationName" filter="true"/>
					</td> 											
					<td class="<%= _class %>" width="3%">
						<bean:write name="vendortariffhdrLineItem" property="ccykey" filter="true"/>
					</td>		
					<td class="<%= _class %>" width="6%" align="right">
						<bean:write name="vendortariffhdrLineItem" property="lumpsum" filter="true"/>
					</td>											
					<td class="<%= _class %>" width="9%">
<bean:write name="vendortariffhdrLineItem" property="validfrom" format="dd-MMM-yyyy" filter="true"/><!--200900037-->
					</td>
					<td class="<%= _class %>" width="9%">
<bean:write name="vendortariffhdrLineItem" property="validto" format="dd-MMM-yyyy" filter="true"/>					
					</td>																						
								<td class="<%= _class %>" width="30%" align="right">
                                
<logic:notEqual name="ListVendortariffhdrForm" property="action" scope="session" value="View"><!--200900049-->                                												
									<table border="0" cellpadding="0" cellspacing="0" width="100%">
										<tr>							
											<td class="text2" align="left">								
<app:linkVendortariffhdrLineItem page="/ListVendortariffdtl.do"><bean:message key="prompt.rates"/></app:linkVendortariffhdrLineItem>						
											</td>												
											<td class="text2" align="right">								
<app:linkVendortariffhdrLineItem page="/EditVendortariffhdr.do?action=Delete"><bean:message key="prompt.delete"/></app:linkVendortariffhdrLineItem>&nbsp;|&nbsp;											
<app:linkVendortariffhdrLineItem page="/EditVendortariffhdr.do?action=Edit"><bean:message key="prompt.edit"/></app:linkVendortariffhdrLineItem>&nbsp;|&nbsp;					
<app:linkVendortariffhdrLineItem page="/EditVendortariffhdr.do?action=Copy"><bean:message key="prompt.copy"/></app:linkVendortariffhdrLineItem>							  
											</td>							
										</tr>
									</table>
</logic:notEqual>

<logic:equal name="ListVendortariffhdrForm" property="action" scope="session" value="View"><!--200900049-->  
<app:linkVendortariffhdrLineItem page="/EditVendortariffhdr.do?action=View"><bean:message key="prompt.view"/></app:linkVendortariffhdrLineItem><!--200900049-->
</logic:equal><!--200900049-->
                                    																					
								</td>											 
				</span>
  				</tr>	
				
				<tr><td colspan="10" background="images/border_dotted.gif"></td></tr>
							
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

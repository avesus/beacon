<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 * NT	2010-04-20		201000020		Make Product Maintenance compatible with ITT Tank Traker system
 * 												
--%>
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
<title>Product</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>

</head>


<body> 

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
		<strong><bean:message key="product.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListProduct" styleClass="link5">
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

<html:form action="/ListProduct" focus="searchString1">
<html:hidden property="gotoPage" />

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#EEEEEE"><tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
&nbsp;<bean:message key="prompt.product.search"/></h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" class="text2"><bean:message key="prompt.code"/>:		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString1" size="20" maxlength="20" styleClass="ftforminputsmall" onkeypress="return noenter()"/>				
		</td>
  	</tr>
	<tr>
		<td align="left" class="text2"><bean:message key="prompt.unnumber"/>:		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString2" size="5" maxlength="10" styleClass="ftforminputsmall" onkeypress="return noenter()"/>				
		</td>
  	</tr>    	
	<tr>
		<td align="left" class="text2"><bean:message key="prompt.chemname"/>:		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString3" size="40" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>				
		</td>
  	</tr>	 
	<tr>
		<td align="left" class="text2"><bean:message key="prompt.tradname"/>:		</td>
  	</tr>
  	<tr>
		<td align="left" width="30%">
		<html:text property="searchString4" size="40" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>				
		</td>
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
<logic:notEqual name="ListProductForm" property="orderBy"
			scope="session" value="Productkey">
	<html:link action="/ListProduct?orderBy=Productkey&gotoPage=0" styleClass="link6"><bean:message key="prompt.code"/></html:link>	
</logic:notEqual>
<logic:equal name="ListProductForm" property="orderBy"
			scope="session" value="Productkey">
	<strong><bean:message key="prompt.code"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>    
<logic:notEqual name="ListProductForm" property="orderBy"
			scope="session" value="Chemname">
	<html:link action="/ListProduct?orderBy=Chemname&gotoPage=0" styleClass="link6"><bean:message key="prompt.chemname"/></html:link>	
</logic:notEqual>
<logic:equal name="ListProductForm" property="orderBy"
			scope="session" value="Chemname">
	<strong><bean:message key="prompt.chemname"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListProductForm" property="orderBy"
			scope="session" value="Tradname">		
	<strong><bean:message key="prompt.tradname"/></strong>
</logic:equal>
<logic:notEqual name="ListProductForm" property="orderBy"
			scope="session" value="Tradname">
			<span class="link4">
	<html:link action="/ListProduct?orderBy=Tradname&gotoPage=0" styleClass="link6"><bean:message key="prompt.tradname"/></html:link>	
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
<logic:equal name="ListProductForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListProductForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListProductForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListProductForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListProductForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListProductForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListProductForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListProductForm" property="lastPage"
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
		  			<td class="tddkgry" width="15%"><span class="heading4">
						<bean:message key="heading.code"/>
		  			</span>
					</td>
		  			<td class="tddkgry" width="10%"><span class="heading4">
						<bean:message key="heading.unnumber"/>
		  			</span>
					</td>                    
		  			<td class="tddkgry" width="30%"><span class="heading4">
						<bean:message key="heading.chemname"/>
						</span>	
					</td>	
		  			<td class="tddkgry" width="30%"><span class="heading4">
						<bean:message key="prompt.tradname"/>
						</span>	
					</td>										
		  			<td class="tddkgry" width="15%">			
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					<tr>
						<td align="left" class="heading4">
<bean:message key="heading.action"/>
		  				</td>
						<td align="right" class="heading4">
<html:link action="/EditProduct?action=Create"><bean:message key="heading.addaproduct"/></html:link>								
						</td>
					</tr>
					</table>									
					</td>
				</tr>
<%
int row=0;
%>			
			<logic:iterate id="productLineItem" name="ListProductForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>				
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="15%">
<bean:write name="productLineItem" property="productkey" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="10%">
<bean:write name="productLineItem" property="unno" filter="true"/>
					</td>                     
					<td class="<%= _class %>" width="30%">
<bean:write name="productLineItem" property="chemname" filter="true"/>					
					</td> 
					<td class="<%= _class %>" width="30%">
<bean:write name="productLineItem" property="tradname" filter="true"/>					
					</td> 											 
					<td class="<%= _class %>" width="15%" align="right">
	  					<app:linkProductLineItem page="/EditProduct.do?action=Delete"><bean:message key="prompt.delete"/></app:linkProductLineItem>&nbsp;|&nbsp;						
	  					<app:linkProductLineItem page="/EditProduct.do?action=Edit"><bean:message key="prompt.edit"/></app:linkProductLineItem>&nbsp;|&nbsp;
	  					<app:linkProductLineItem page="/EditProduct.do?action=Copy"><bean:message key="prompt.copy"/></app:linkProductLineItem>							  
					</td>
				</span>
  				</tr>
				
							<!-- row2 -->
				
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

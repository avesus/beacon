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

<%if (session == null || session.getAttribute(Constants.USER_KEY) == null) { %>
<html:html>
<head>
<title>Location Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="JavaScript">
	window.opener.location.href = "<html:rewrite forward='welcome'/>";
	window.opener.focus();
</script>
</head>
<body/>
</html:html>
<%} else { %>

<html:html>
<head>
<title>Location Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="JavaScript">
function setLocation(vl)	{
	var locationkey = window.opener.document.forms[0].elements[document.forms[0].headerInfo2.value];	
	for(var i = 0; i < locationkey.length; i++)	{
		if (locationkey.options[i].value == vl)	{
			locationkey.selectedIndex = i;
		}
	}
	window.close();
	window.opener.focus()
}
</script>
</head>

<body> 
<html:messages id="msg" message="true" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="msg"/><bean:message key="errors.suffix"/>
</html:messages>

<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_location_search.png" alt="Search" border="0" align="middle"/><span class="heading9">Location Search Results</span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
     <tr><td colspan="2">&nbsp;</td></tr>
    
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td>
   <html:button styleClass="button1" onclick="history.back()" property="ignore">
      Back
   </html:button>									
									<html:button styleClass="button1" onclick="window.close();window.opener.focus()" property="ignore"> 
									<bean:message key="button.cancel"/> 
									</html:button> 
									</td>
                                  </tr>
                                </table></td>
                            </tr>
							  
<tr>
	<td>

<html:form action="/ListLocationSearch">
<html:hidden property="headerInfo1" />
<html:hidden property="headerInfo2" />
<html:hidden property="gotoPage" />
<html:hidden property="maxResults" />


<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">
	<bean:message key="prompt.sortby"/>:&nbsp;<strong><bean:message key="prompt.name"/></strong>
	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">
<%--<logic:equal name="ListLocationSearchForm" property="firstPage"
			scope="session" value="false">			
<INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
 </logic:equal>	
<logic:notEqual name="ListLocationSearchForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_start_grey.gif"/>
 </logic:notEqual>	
<logic:equal name="ListLocationSearchForm" property="firstPage"
			scope="session" value="false">
<INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>			
 </logic:equal>	
<logic:notEqual name="ListLocationSearchForm" property="firstPage"
			scope="session" value="false">
<html:img src="images/arrow_previous_grey.gif"/>
 </logic:notEqual>
<logic:equal name="ListLocationSearchForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>				
</logic:equal>
<logic:notEqual name="ListLocationSearchForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_next_grey.gif"/>		
</logic:notEqual>
<logic:equal name="ListLocationSearchForm" property="lastPage"
			scope="session" value="false">
<INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>				
</logic:equal>
<logic:notEqual name="ListLocationSearchForm" property="lastPage"
			scope="session" value="false">
<html:img src="images/arrow_end_grey.gif"/>		
</logic:notEqual>--%>
	</td>
  </tr> 
</table>
	</td>
  </tr> 
</table>

		<div style="OVERFLOW:auto; width:850px; height:430px;">	
		
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
		  			<td width="1%" class="tddkgry">
					<span class="heading4">
		  			</span>	
					</td>				
		  			<td width="15%" class="tddkgry">
					<span class="heading4">
						Name
		  			</span>	
					</td>	
		  			<td class="tddkgry" width="5%">
					<span class="heading4">					
						Type
		  			</span>
					</td>	
		  			<td class="tddkgry" width="80%">
					<span class="heading4">					
						Location
		  			</span>
					</td>										
				</tr>
<%
int row=0;
%>					
			<logic:iterate id="locationSearchLineItem" name="ListLocationSearchForm" property="lineItems">
<%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>			
  				<tr>
				<span class="text2">
					<td class="<%= _class %>" width="1%">
						<html:radio property="searchString15" idName="locationSearchLineItem" value="locationkey" onclick="setLocation(this.value)"/>
					</td>
					<td class="<%= _class %>" width="15%">
						<bean:write name="locationSearchLineItem" property="locationName" filter="true"/>
					</td>					
					<td class="<%= _class %>" width="5%">
						<bean:write name="locationSearchLineItem" property="locationType" filter="true"/>
					</td>					 
					<td class="<%= _class %>" width="80%">
						<bean:write name="locationSearchLineItem" property="address1" filter="true"/>
						<bean:write name="locationSearchLineItem" property="address2" filter="true"/>&nbsp;
						<bean:write name="locationSearchLineItem" property="address3" filter="true"/>&nbsp;
						<bean:write name="locationSearchLineItem" property="city" filter="true"/>&nbsp;						
						<bean:write name="locationSearchLineItem" property="postalcode" filter="true"/>																		
					</td> 										 
				</span>
  				</tr>				
			</logic:iterate>
			
			</table>
		</td>
	</tr>
</table>
</td>
</tr>

</table>


</td>
</tr>
</table>

</div>

</html:form>

</td>
</tr>

  
</table>

</body>
</html:html>
<%} %>
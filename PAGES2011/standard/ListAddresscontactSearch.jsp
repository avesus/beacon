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
<title>Contact Search</title>
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
<title>Contact Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />


<script language="JavaScript">
function setAddresscontact(v)	{
	if (window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value == "")
		window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value = v;
	else
		window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value = 
			window.opener.document.forms[0].elements[document.forms[0].headerInfo3.value].value+"; "+v;

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
   <td bgcolor="#f6f6f6"><html:img src="images/icons/icon_address_search.png" alt="Search" border="0" align="middle"/><span class="heading9">Contact Search</span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
  
  <tr>
    <td>
	
	            <html:form action="/ListAddresscontactSearch" focus="searchString1">
<html:hidden property="headerInfo1" />
<html:hidden property="headerInfo2" />
<html:hidden property="headerInfo3" />
<html:hidden property="gotoPage" />				
<html:hidden property="maxResults" />

        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td>

              <table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
                <tr>
                  <td><table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
                      <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                </table></td>
                            </tr>
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.name"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="searchString1" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.email"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="searchString13" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                </table></td>
                            </tr>

                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td class="td1">
									<html:submit styleClass="button1"> 
									Search 
									</html:submit>
									<html:reset styleClass="button1"> 
									<bean:message key="button.reset"/> 
									</html:reset> 
									<html:button styleClass="button1" onclick="window.close();window.opener.focus()" property="ignore"> 
									<bean:message key="button.cancel"/> 
									</html:button> 
									</td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table> 
			  
			  </td>
          </tr>
        </table>
	

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
	</td>
  </tr> 
</table>

	</td>
  </tr> 
</table>


		<div style="OVERFLOW:auto; width:850px; height:390px;">	
	
		
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
		
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
						  			<td width="1%" class="tddkgry">
					<span class="heading4">
		  			</span>	
					</td>	
		  			<td width="20%" class="tddkgry">
					<span class="heading4">
						Name
		  			</span>	
					</td>
		  			<td class="tddkgry" width="79%">
					<span class="heading4">					
						Email
		  			</span>
					</td>																					
				</tr>
<%
int row=0;
%>					
			<logic:iterate id="searchLineItem" name="ListAddresscontactSearchForm" property="lineItems">
<%
String _class = "tdnobackground";
//if ((row % 2) == 0) _class = "tdlghtgry2"; 
String _trbgcolor = "#f7f7f9";
if ((row % 2) == 0) _trbgcolor = "#eeeeee"; 
row++;
%>			
  				<tr bgcolor="<%= _trbgcolor %>" onMouseOver="color=this.bgColor;this.bgColor='#D6E3EF';" onMouseOut="this.bgColor=color;">
				<span class="text2">
					<td class="<%= _class %>" width="1%" valign="top">
						<html:radio property="searchString15" idName="searchLineItem" value="email" onclick="setAddresscontact(this.value)"/>
					</td> 				
					<td class="<%= _class %>" width="21%" valign="top">
						<bean:write name="searchLineItem" property="name" filter="true"/>
					</td> 
					<td class="<%= _class %>" width="79%">
						<bean:write name="searchLineItem" property="email" filter="true"/>
					</td> 					 										 
				</span>
  				</tr>				
			</logic:iterate>
			
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
<% } %>
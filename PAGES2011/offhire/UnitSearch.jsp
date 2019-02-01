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

<title>Offhire Unit Search</title>
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



<script language="javascript">
        function onLoadFunctions() {

        }
</script>

<title>Unit Search</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>


<body onUnload="if (searchWin != null) {searchWin.close()}" onLoad="onLoadFunctions();">


<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
   <td><html:img src="images/icon_search_title.jpg" alt="Search" border="0" align="middle"/><span class="heading9">Unit Search</span></td>  
  </tr>
  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
    
  <tr>
    <td>
	
	            <html:form action="/ListUnitSearchOffhire" focus="searchString1">
				
<html:hidden property="maxResults" />
<html:hidden property="searchString4" value=""/> 
<html:hidden property="searchString5" value=""/> 
				
	<div style="OVERFLOW:auto; width:850px; height:300px;">
	
	
        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td>

              <table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#7F9DB9">
			  
                <tr>
                  <td><table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
                      <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                </table></td>
                            </tr>
                            
							<tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td9"><div align="right"><bean:message key="prompt.unit"/>: </div></td>
                                    <td width="78%" class="td9">
									<html:text property="searchString1" size="50" styleClass="ftforminputsmall"/> 
									</td>
                                  </tr>
                                </table></td>
                            </tr>
                            
							<tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td9"><div align="right"><bean:message key="prompt.lessee"/>:</div></td>
                                    <td width="78%" class="td9">
		<html:select property="searchString3" disabled="true" styleClass="ftforminputsmall">
			<html:option value="%">- No Selection -</html:option>
			<html:options collection="lessees" property="addrkey" labelProperty="name"/>	
		</html:select>
<html:hidden property="searchString3"/> 
									</td>
                                  </tr>
                             </table></td>
                            </tr>

<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.equipmentparameters"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		<html:select property="searchString7" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>				 
				</TD>
              </TR>
              <TR> 
                <TD class="td9" width="22%" align="right"></TD>
                <TD class="td9" width="78%">
		<html:select property="searchString8" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>
              <TR> 
                <TD class="td9" width="22%" align="right"></TD>
                <TD class="td9" width="78%">
		<html:select property="searchString9" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp3s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>
              <TR> 
                <TD class="td9" width="22%" align="right"></TD>
                <TD class="td9" width="78%">
		<html:select property="searchString10" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp4s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>
              <TR> 
                <TD class="td9" width="22%" align="right"></TD>
                <TD class="td9" width="78%">
		<html:select property="searchString11" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp5s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>			  			  			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td class="td11">
									<html:submit styleClass="button1"> 
									<bean:message key="button.search"/> 
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
      </div>
	  
</html:form>
	  
	  </td>
  </tr>
  
</table>
</body>
</html:html>
<% } %>
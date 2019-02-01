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
<title>Location Lookup Search</title>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />



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
<title>Location Lookup Search</title>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


</head>
<body>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr bgcolor="#F1F1F1"><td><span class="header2">Location Lookup Search</span></td></tr> 

  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
  
  <tr>
    <td>
	
	            <html:form action="/ListLocationSearch" focus="searchString1">
				
<html:hidden property="maxResults" />
				
	<div style="OVERFLOW:auto; width:850px; height:430px;">
	
	
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
                                    <td width="22%" class="label2"><div align="right"> <bean:message key="prompt.name"/>: </div></td>
                                    <td width="78%" class="label2"><html:text property="searchString1" size="50" styleClass="forminput1"/> </td>
                                  </tr>
 	<tr>
		<td colspan="2" class="texthelp2">
		 <bean:message key="prompt.location.wildcardhelp"/>				
		</td>
	<tr>                                  
                                </table></td>
                            </tr>
                            
                            
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="label2"><div align="right"> <bean:message key="prompt.address"/>: </div></td>
                                    <td width="78%" class="label2"><html:text property="searchString3" size="50" styleClass="forminput1"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2">&nbsp;</td>
                                    <td width="78%" class="label2"><html:text property="searchString4" size="50" styleClass="forminput1"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2">&nbsp;</td>
                                    <td width="78%" class="label2"><html:text property="searchString5" size="50" styleClass="forminput1"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2"><div align="right"> <bean:message key="prompt.postalcode"/>: </div></td>
                                    <td width="78%" class="label2"><html:text property="searchString7" size="20" styleClass="forminput1"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2"><div align="right"> <bean:message key="prompt.city"/>: </div></td>
                                    <td width="78%" class="label2"><html:select property="searchString8" styleClass="forminput1"> <html:option value=""><bean:message key="prompt.city"/></html:option> <html:options collection="citys" property="city" labelProperty="city"/> </html:select> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2"><div align="right"> <bean:message key="prompt.state"/>: </div></td>
                                    <td width="78%" class="label2"><html:text property="searchString9" size="20" styleClass="forminput1"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2"><div align="right"> <bean:message key="prompt.country"/>: </div></td>
                                    <td width="78%" class="label2"><html:select property="searchString10" styleClass="forminput1"> <html:option value=""><bean:message key="prompt.country"/></html:option> <html:options collection="countrys" property="country" labelProperty="country"/> </html:select> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            
                            
                            <script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG4codeAjax.js"></script>                            
                            
							<tr>
                              <td>
							<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">   
                      
         						<tr><td class="label2" align="right" width="22%"><bean:message key="heading.g1code"/>:</td><td class="label2" width="78%">
        <html:select property="g1codekey" styleClass="forminput1" onchange="processListG2code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>	
		</html:select>	
                                </td></tr>
                                
         						<tr><td class="label2" align="right"><bean:message key="heading.g2code"/>:</td><td class="label2">
        <html:select property="g2codekey" styleClass="forminput1" onchange="processListG3code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
            			<html:options collection="g2codes" property="g2codekey" labelProperty="g2codekey"/>	
		</html:select>		
                                </td></tr>                                                                                                                                              						<tr><td class="label2" align="right"><bean:message key="heading.g3code"/>:</td><td class="label2">
        <html:select property="g3codekey" styleClass="forminput1" onchange="processListG4code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
			<html:options collection="g3codes" property="g3codekey" labelProperty="g3codekey"/>	            
		</html:select>
                                </td></tr>
                                
         						<tr><td class="label2" align="right"><bean:message key="heading.g4code"/>:</td><td class="label2">
        <html:select property="g4codekey" styleClass="forminput1">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g4codes" property="g4codekey" labelProperty="g4codekey"/>	            	
		</html:select>	
                                </td></tr>                                
                                                                                                                
     						</table>
                                </td>
                            </tr>
                            

				<tr>
			        <td>
    
				        <div class="btnPane"> 
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Search</span>
        				</button>    

						<button id="buttonCancel" class="btn btnFF" type="submit" onClick="window.close();window.opener.focus()" property="ignore">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        						<span><bean:message key="button.cancel"/></span>
			            </button>                               
				        </div>
                 
      				</td>
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
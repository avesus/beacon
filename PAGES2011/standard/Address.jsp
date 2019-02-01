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
<logic:equal name="AddressForm" property="action"
            scope="request" value="Create">
<title><bean:message key="title.create"/></title>
</logic:equal><logic:equal name="AddressForm" property="action"
            scope="request" value="Delete">
<title><bean:message key="title.delete"/></title>
</logic:equal><logic:equal name="AddressForm" property="action"
            scope="request" value="Edit">
<title><bean:message key="title.edit"/></title>
</logic:equal>
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>
<body>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
  <tr>
    <td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" />
    </td>
  </tr>
  <%-- BREADCRUMBS -----------------%>
  <tr>
<%--    <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>
    <td class="tdwht">
	<span class="heading2"> 
	<strong><bean:message key="address.title"/></strong> 
	</span> <span class="heading2"> 
	<html:link action="/ListAddress" styleClass="link4"> <bean:message key="title.list"/> </html:link> 
	</span> <span class="text6">></span> 
	<span class="text6"><strong> <bean:message key="title.maintenance"/> </strong></span>
</td>
  </tr>
  <tr valign="top" bgcolor="#CCCCCC">
    <td height="1" colspan="2"></td>
  </tr>
  <%-- BREADCRUMBS -----------------%>
  <tr>
<%--    <td bgcolor="#CCCCCC" width="121" valign="top" align="center"><jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
    </td>--%>
    <td>
	<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">
        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td>
			
			<html:errors/> 
			
			<html:form action="/SaveAddress" focus="addrkey"> 
			<html:hidden property="action"/>
<html:hidden property="typekey"/> 
			
              <table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
                <tr>
                  <td><table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
                      <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td class="td7"><strong> 
									<logic:equal name="AddressForm" property="action" scope="request" value="Create"> 
									<bean:message key="address.title.create"/> 
									</logic:equal> 
									<logic:equal name="AddressForm" property="action" scope="request" value="Delete"> 
									<bean:message key="address.title.delete"/> 
									</logic:equal> <logic:equal name="AddressForm" property="action" scope="request" value="Edit"> 
									<bean:message key="address.title.edit"/> 
									</logic:equal> </strong></td>
                                  </tr>
                                </table></td>
                            </tr>
                            
                            
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    	<td width="22%" class="td2"><div align="right"> <bean:message key="prompt.code"/>: </div></td>
                                    	<td width="78%" class="td2">
<logic:equal name="AddressForm" property="action" scope="request" value="Create"> 
				  	<html:text property="addrkey" maxlength="10" size="20" styleClass="ftforminputsmall"/> 
</logic:equal> 
<logic:notEqual name="AddressForm" property="action" scope="request" value="Create"> 
					<strong><html:hidden property="addrkey" write="true"/></strong>  
</logic:notEqual> 
										</td>
                                  </tr>

                                </table></td>
                            </tr>
                            
                            
                            <logic:notEqual name="AddressForm" property="action"
                     scope="request" value="Delete">

                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">                     
<tr>
                                    <td width="22%" class="td2" valign="top"><div align="right"> <bean:message key="prompt.type"/>: </div></td>
                                    <td width="78%" class="td2">
<%--									<html:select property="typekey" styleClass="ftforminputsmall"> <html:option value="">
									<bean:message key="prompt.selectatype"/></html:option> 
									<html:options collection="addrtypes" property="typekey" labelProperty="typekey"/> 
									</html:select> --%>
<html:select property="arraytypekeylist" multiple="true" size="10" styleClass="ftforminputsmall">
			<html:options collection="addrtypes" property="typekey" labelProperty="typekey"/>	
</html:select>                                    

									</td>
</tr>
                                </table></td>
                            </tr>
                     
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.name"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="name" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.shortname"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="shortname" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.address"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="addr1" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2">&nbsp;</td>
                                    <td width="78%" class="td2"><html:text property="addr2" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2">&nbsp;</td>
                                    <td width="78%" class="td2"><html:text property="addr3" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2">&nbsp;</td>
                                    <td width="78%" class="td2"><html:text property="addr4" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.postalcode"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="postalcode" size="20" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.city"/>: </div></td>
                                    <td width="78%" class="td2">
									<html:select property="city" styleClass="ftforminputsmall"> 
									<html:option value=""><bean:message key="prompt.city"/></html:option> 
									<html:options collection="citys" property="city" labelProperty="city"/> 
									</html:select> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.state"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="state" size="20" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.country"/>: </div></td>
                                    <td width="78%" class="td2"><html:select property="country" styleClass="ftforminputsmall"> <html:option value=""><bean:message key="prompt.country"/></html:option> <html:options collection="countrys" property="country" labelProperty="country"/> </html:select> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            
                            
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.phone"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="telno1" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.fax"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="faxno1" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.email"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="emailno" size="50" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                </table></td>
                            </tr>
	
    

  
  
 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG4codeAjax.js"></script>

      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="gcode.title"/> </strong>
		  </td>
		</tr>		
 <tr><td>	  
                  	<table width="100%" border="0" cellspacing="0" cellpadding="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="heading.g1code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:select property="g1codekey" styleClass="ftforminputsmall" onchange="processListG2code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>	
		</html:select>			  
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="heading.g2code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:select property="g2codekey" styleClass="ftforminputsmall" onchange="processListG3code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
            			<html:options collection="g2codes" property="g2codekey" labelProperty="g2codekey"/>	
		</html:select>	  
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="heading.g3code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:select property="g3codekey" styleClass="ftforminputsmall" onchange="processListG4code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
			<html:options collection="g3codes" property="g3codekey" labelProperty="g3codekey"/>	            
		</html:select>	  
          </td>
        </tr> 
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="heading.g4code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:select property="g4codekey" styleClass="ftforminputsmall">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g4codes" property="g4codekey" labelProperty="g4codekey"/>	            	
		</html:select>	 		  
          </td>
        </tr>                	        			        			
    </table>
</td></tr>
    </table></td>
  </tr>	
        
           
              						
            <tr>
                              <td>
							  <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.headoffice"/>: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="mainaccaddrkey" 
			styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>								
									</td>
                                  </tr>							  					  
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.ccy"/>: </div></td>
                                    <td width="78%" class="td2"><html:select property="ccykey" styleClass="ftforminputsmall"> <html:option value=""><bean:message key="prompt.ccy"/></html:option> <html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> </html:select> </td>
                                  </tr>
                              </table></td>
                            </tr>


  
      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.invoicedetails"/> </strong>
		  </td>
		</tr>		
              <tr> 
                <td> 
                  	<table width="100%" border="0" cellspacing="0" cellpadding="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.billingaddress"/>: </div></td>
                                    <td width="78%" class="td2">
		<html:select property="rentaddrkey" 
			styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>								
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2"><div align="right"> <bean:message key="prompt.paymentterms"/>: </div></td>
                                    <td width="78%" class="td2"><html:text property="payterms" size="10" maxlength="5" styleClass="ftforminputsmall"/> </td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2" valign="top"><div align="right"> <bean:message key="prompt.paymenttermstext"/>: </div></td>
                                    <td width="78%" class="td2">
									<html:textarea rows="2" cols="70" property="paytermstext" styleClass="ftforminputsmall"/>
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="td2" valign="top"><div align="right"> <bean:message key="prompt.paymenttoinstructions"/>: </div></td>
                                    <td width="78%" class="td2">
									<html:textarea rows="6" cols="70" property="paymenttoinstructions" styleClass="ftforminputsmall"/>
									</td>
                                  </tr>								  
            		</table>
				</td>
              </tr>
    </table></td>
  </tr>	
										
                            </logic:notEqual>
                            
							
							<tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td class="td1"><logic:equal name="AddressForm" property="action"
                  scope="request" value="Create"> <html:submit styleClass="button1"> <bean:message key="button.add"/> </html:submit> </logic:equal> <logic:equal name="AddressForm" property="action"
                  scope="request" value="Delete"> <html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> </logic:equal> <logic:equal name="AddressForm" property="action"
                  scope="request" value="Edit"> <html:submit styleClass="button1"> <bean:message key="button.save"/> </html:submit> </logic:equal> <logic:notEqual name="AddressForm" property="action"
                     scope="request" value="Delete"> <html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> </logic:notEqual> <html:cancel styleClass="button1"> <bean:message key="button.cancel"/> </html:cancel> </td>
                                  </tr>
                                </table></td>
                            </tr>
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
              </html:form> </td>
          </tr>
        </table>
      </div></td>
  </tr>
  <tr>
    <td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" />
    </td>
  </tr>
</table>
</body>
</html:html>
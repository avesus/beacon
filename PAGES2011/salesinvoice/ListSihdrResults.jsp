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




<div id="results" style="OVERFLOW:auto; position:absolute; left:200px; top:0px; width:950px; height:650px; z-index:20; visibility: visible">


<table border="0" cellpadding="0" cellspacing="0" width="100%">
    
    
    
<tr>
<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
<td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>

<td valign="top">
            
 <!-- start messages -->
<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  
 <tr><td>			
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>
</td></tr>    
                     
</table>
<!-- end messages -->            


            
	  			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>
                    :&nbsp;
                    <logic:notEqual name="ListSihdrForm" property="orderBy"
			scope="session" value="SIHDR_ID">
                      <html:link action="/ListSihdr?orderBy=SIHDR_ID&gotoPage=0" styleClass="link6"><bean:message key="prompt.docid"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListSihdrForm" property="orderBy"
			scope="session" value="SIHDR_ID"> <strong><bean:message key="prompt.docid"/></strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListSihdrForm" property="orderBy"
			scope="session" value="Createdate"> <strong><bean:message key="prompt.createdate"/></strong> </logic:equal>
                    <logic:notEqual name="ListSihdrForm" property="orderBy"
			scope="session" value="Createdate"> <span class="link4">
                      <html:link action="/ListSihdr?orderBy=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.createdate"/></html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                <tr>
                  <td align="right">
                                    <img src="images/spacer.gif" width="1" height="13" border="0"/> 
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>		
        		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                <tr>
                  <td class="tdwht" width="1%" colspan="4" valign="middle">			  
<table width="40%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"><tr>
<td class="tdwht">

&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/>

</td>
<td class="tdwht">

<%--<bean:message key="prompt.selectall"/>&nbsp;<html:checkbox name="ListSihdrForm" property="searchString15" />--%>

</td>


<td class="tdwht">&nbsp;to&nbsp;</td>
<td class="tdwht" valign="middle"><input type="image" value='<bean:message key="button.print"/>' name="printButton" src="images/print_button.gif"/></td>
<td class="tdwht">&nbsp;or&nbsp;</td>
<td class="tdwht" valign="middle"><input type="image" value='<bean:message key="button.email"/>' name="emailButton" src="images/email_button.gif"/><%--<input type="image" value='<bean:message key="button.testprint"/>' name="testprintButton" src="images/testprint_button.gif"/>--%></td>
</tr></table>
				  </td>				
                  <td class="tdwht" width="10%"></td>
                  <td class="tdwht" width="8%"></td>
                  <td class="tdwht" width="5%"></td>
                  <td class="tdwht" width="10%"></td>
                  <td class="tdwht" width="19%"></td>
                </tr>
                <tr>
                  <td class="tddkgry" width="1%">
<input type='checkbox' name='selectedObjectsAll' value='N' onclick="checkAll(document.forms(0).selectedObjects,document.forms(0).selectedObjectsAll);">	                  
                  </td>				
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.docid"/></span> </td>
                  <td class="tddkgry" width="8%"><span class="heading4"><bean:message key="heading.createdate"/></span> </td>
                  <td class="tddkgry" width="30%"><span class="heading4">
                    <bean:message key="heading.billingaccount"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.invoiceno"/></span> </td>
                  <td class="tddkgry" width="9%"><span class="heading4"><bean:message key="heading.printdate"/></span> </td>
                  <td class="tddkgry" width="5%"><span class="heading4"><bean:message key="heading.invoiceccy"/></span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.invoiceamt"/></span> </td>
                  <td class="tddkgry" width="18%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="heading4"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="heading4"><html:link action="/EditSihdr?action=Create">
                            <bean:message key="prompt.sihdr.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table></td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="sihdrLineItem" name="ListSihdrForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>
                  <!-- row1 -->
                  <tr>
<td class="<%= _class %>" width="1%" align="left" nowrap="nowrap">				  
<html:multibox property="selectedObjects" onclick="unCheckSelectedObjectsAll();">
<bean:write name="sihdrLineItem" property="sihdrId" />
</html:multibox>
</td>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap"><bean:write name="sihdrLineItem" property="sihdrId" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="8%" align="left" nowrap><bean:write name="sihdrLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="30%" align="left" nowrap><bean:write name="sihdrLineItem" property="customeraddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left"><bean:write name="sihdrLineItem" property="invoiceno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="9%" align="left"><bean:write name="sihdrLineItem" property="printdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="5%"><bean:write name="sihdrLineItem" property="invoiceccykey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap align="right"><bean:write name="sihdrLineItem" property="invoiceamt" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="18%" align="right" valign="top" nowrap><table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="<%= _class %>" align="right">
                          
<c:if test="${!sihdrLineItem.printedflag}">
                              <app:linkSihdrLineItem page="/EditSihdr.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </app:linkSihdrLineItem>
                              &nbsp;|&nbsp;
                                                            
	<c:if test="${sihdrLineItem.manualflag}">                              
    	<app:linkSihdrLineItem page="/EditSihdr.do?action=Edit"><bean:message key="prompt.edit"/></app:linkSihdrLineItem>
	</c:if>

	<c:if test="${!sihdrLineItem.manualflag}">                              
		<app:linkSihdrLineItem page="/EditSihdr.do?action=View"><bean:message key="prompt.view"/></app:linkSihdrLineItem>
	</c:if>
        
</c:if>




                               
                          </td>
                        </tr>
                      </table></td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" width="70%" colspan="9"><app:linkSihdrLineItem page="/ListSidtl.do"><bean:message key="prompt.details"/></app:linkSihdrLineItem>
                      <c:if test="${!sihdrLineItem.printedflag}"> &nbsp;|&nbsp;
                        <app:linkSihdrLineItem page="/PrintSalesinvoice.do?action=Test"><bean:message key="prompt.testprint"/></app:linkSihdrLineItem>
                      </c:if>
                      &nbsp;|&nbsp;
                      <app:linkSihdrLineItem page="/PrintSalesinvoice.do?action=Print">
                        <bean:message key="prompt.print"/>
                      </app:linkSihdrLineItem>
                    </td>
                  </tr>
					<tr><td colspan="9" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table>		
			</td>
    	</tr>
  </table>
</div>

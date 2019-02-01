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

<div id="results" style="position:absolute; left:200px; top:0px; width:950px; height:650px; z-index:20; visibility: visible">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
      <td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      <td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      <td valign="top">
	  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td>			
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
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>
                    :&nbsp;
                    <logic:notEqual name="ListSalesinvoicebuildForm" property="orderBy"
			scope="session" value="orderhdr.Orderno">
                      <html:link action="/ListSibuild?orderBy=orderhdr.Orderno&amp;gotoPage=0" styleClass="link6">Order Number</html:link>
                    </logic:notEqual>
                    <logic:equal name="ListSalesinvoicebuildForm" property="orderBy"
			scope="session" value="orderhdr.Orderno"> <strong>Order Number</strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListSalesinvoicebuildForm" property="orderBy"
			scope="session" value="Orderdate"> <strong>Order Date</strong> </logic:equal>
                    <logic:notEqual name="ListSalesinvoicebuildForm" property="orderBy"
			scope="session" value="Orderdate"> <span class="link4">
                      <html:link action="/ListSibuild?orderBy=Orderdate&amp;gotoPage=0" styleClass="link6">Order Date</html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%">&nbsp;
			</td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
          <html:form action="/SaveSalesinvoicebuild">
            <tr>
              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                  <tr>
                    <td class="tddkgry" width="2%"><span class="heading4">&nbsp; </span> </td>
                    <td class="tddkgry" width="8%" align="left"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                        <tr>
                          <td class="heading4"><html:submit styleClass="button1" property="action">
                              <bean:message key="button.create"/>
                            </html:submit>
                          </td>
                        </tr>
                        <tr>
                          <td class="heading4"><bean:message key="heading.groupref"/>
                            : </td>
                        </tr>
                        <tr>
                          <td class="heading4"><html:text property="searchString7" size="20" maxlength="20" styleClass="ftforminputsmall"/>
                          </td>
                        </tr>
                      </table></td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.orderno"/>
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.orderdate"/>
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.charge"/>
                      </span> </td>
                    <td class="tddkgry" width="30%"><span class="heading4">
                      <bean:message key="heading.billingaccount"/>
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.invoiceccy"/>
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.xratetoinv"/>
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.invoiceamt"/>
                      </span> </td>
                  </tr>
                  <%
int row=0;
%>
                  <logic:iterate id="lineItem" name="ListSalesinvoicebuildForm" property="lineItems">
                    <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>
                    <!-- row1 -->
                    <tr>
                      <td class="<%= _class %>" align="left"><%= row %> </td>
                      <td class="<%= _class %>" align="left"><html:multibox property="selectedObjects">
                          <bean:write name="lineItem" property="orderchargeId" />
                        </html:multibox>
                        &nbsp;
                        <html:hidden name="lineItem" property="invoicestatus" />
                      </td>
                      <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="orderno" filter="true"/>
                      </td>
                      <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="orderdate" format="dd-MMM-yyyy" filter="true"/>
                      </td>
                      <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="charge.ldesc" filter="true"/>
                      </td>
                      <td class="<%= _class %>" align="left"><bean:write name="lineItem" property="customer.name" filter="true"/>
                      </td>
                      <td class="<%= _class %>" align="left"><bean:write name="lineItem" property="invoiceccykey" filter="true"/>
                      </td>
                      <td class="<%= _class %>" align="right"><fmt:formatNumber 
							type="number"
							value="${lineItem.xrateinv}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>
                      </td>
                      <td class="<%= _class %>" align="right"><fmt:formatNumber 
							type="number"
							value="${lineItem.chgamtinv}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>
                      </td>
                    </tr>
					<tr><td colspan="9" background="images/border_dotted.gif"></td></tr>						
                  </logic:iterate>
                </table></td>
            </tr>
          </html:form>
        </table></td>
    </tr>
  </table>
</div>

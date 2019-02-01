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

<div id="results" style="position:absolute; left:200px; top:0px; width:1050px; height:650px; z-index:20; visibility: visible">
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
                    <logic:notEqual name="ListDemurrageinvoicebuildForm" property="orderBy"
			scope="session" value="Jobno">
                      <html:link action="/ListDibuild?orderBy=Jobno&amp;gotoPage=0" styleClass="link6">Job Number</html:link>
                    </logic:notEqual>
                    <logic:equal name="ListDemurrageinvoicebuildForm" property="orderBy"
			scope="session" value="Jobno"> <strong>Job Number</strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListDemurrageinvoicebuildForm" property="orderBy"
			scope="session" value="Unitkey"> <strong>Unit Number</strong> </logic:equal>
                    <logic:notEqual name="ListDemurrageinvoicebuildForm" property="orderBy"
			scope="session" value="Unitkey"> <span class="link4">
                      <html:link action="/ListDibuild?orderBy=Unitkey&amp;gotoPage=0" styleClass="link6">Unit Number</html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%">&nbsp;
			</td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
          <html:form action="/SaveDibuild">
            <tr>
              <td>
			  <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                  <tr>
                    <td colspan="7" class="tdwht">
					<table width="79%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                      <tr>
                        <td class="tdwht">&nbsp;
                            <html:img src="images/select_top_arrow_12_17.gif"/></td>
                        <td class="tdwht"><bean:message key="prompt.selectall"/>
                          &nbsp;
                          <html:checkbox name="ListDemurrageinvoicebuildForm" property="searchString15" /></td>
                        <td class="tdwht">&nbsp;to&nbsp;</td>
                        <td class="tdwht">
						<html:submit styleClass="button1" property="action"> <bean:message key="button.process"/></html:submit>&nbsp;
						Group Ref:<html:text property="searchString7" size="10" maxlength="20" styleClass="ftforminputsmall"/>
						</td>
                        <td class="tdwht">&nbsp;or&nbsp;</td>
                        <td class="tdwht">
						<html:submit styleClass="button1" property="action"> <bean:message key="button.close"/> </html:submit>
						</td>
                      </tr>
                    </table>
                    </td>
                    <td class="tdwht">&nbsp;</td>
                    <td class="tdwht">&nbsp;</td>
                    <td class="tdwht">&nbsp;</td>
                    <td class="tdwht">&nbsp;</td>
                    <td class="tdwht">&nbsp;</td>
                    <td class="tdwht">&nbsp;</td>
                    <td class="tdwht">&nbsp;</td>
                  </tr>
                  <tr>
                    <td class="tddkgry" width="2%"><span class="heading4">&nbsp; </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.jobno"/></span> </td>
					<td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.orderno"/></span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      <bean:message key="heading.unit"/>
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">Demurrage From Date</span></td>
                    <td class="tddkgry" width="10%"><span class="heading4">Demurrage To Date</span></td>					  
                    <td class="tddkgry" width="10%"><span class="heading4">
                      Demurrage Free Days
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.billingaccount"/></span></td>					  
                    <td class="tddkgry" width="10%"><span class="heading4">Invoice Start Date</span></td>
                    <td class="tddkgry" width="10%"><span class="heading4">Invoice End Date</span></td>					  
                    <td class="tddkgry" width="10%"><span class="heading4">
                      Invoice Days
                      </span> </td>
                    <td class="tddkgry" width="10%"><span class="heading4">
                      Invoice Currency
                      </span> </td>					  
                    <td class="tddkgry" width="10%"><span class="heading4">
                      Invoice Amount
                      </span> </td>
                  </tr>
                  <%
int row=0;
%>
                  <logic:iterate id="lineItem" name="ListDemurrageinvoicebuildForm" property="lineItems">
                    <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>
                    <!-- row1 -->
                    <tr>
                      <td class="<%= _class %>" width="1%" align="left" nowrap="nowrap"><html:multibox property="selectedObjects">
                          <bean:write name="lineItem" property="jobmovId1" />
                        </html:multibox>
                        &nbsp;
                        <html:hidden name="lineItem" property="jobmovId1" />
						 <html:hidden name="lineItem" property="jobmovId2" />                      </td>
                      <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="jobno" filter="true"/></td>
					  <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="orderno" filter="true"/></td>
                      <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="unit" filter="true"/>                      </td>
<td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="fromdate" format="dd-MMM-yyyy" filter="true"/></td>
<td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="todate" format="dd-MMM-yyyy" filter="true"/></td>		
<td class="<%= _class %>" align="right"><bean:write name="lineItem" property="freeDays" filter="true"/></td>	
<td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="dmrgbilltoaddr.name" filter="true"/></td>	
<td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="demStartDate" format="dd-MMM-yyyy" filter="true"/></td>
<td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="lineItem" property="demEndDate" format="dd-MMM-yyyy" filter="true"/></td>
                      <td class="<%= _class %>" align="right"><bean:write name="lineItem" property="demurragePrintTotalDays" filter="true"/></td>
                      <td class="<%= _class %>" align="left"><bean:write name="lineItem" property="ccykey" filter="true"/></td>					  
                      <td class="<%= _class %>" align="right">
<fmt:formatNumber 
							type="number"
							value="${lineItem.demAmountTotal}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>					  </td>
                    </tr>
					<tr><td colspan="13" background="images/border_dotted.gif"></td></tr>						
                  </logic:iterate>
                </table>
			  </td>
             
			 </tr>
          </html:form>
        </table>
		</td>
    </tr>
  </table>
</div>

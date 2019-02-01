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

<div id="results" style="position:absolute; left:230px; top:0px; width:950px; height:650px; z-index:20; visibility: visible">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
    	<tr>
      		<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      		<td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      		<td valign="top">
	  			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>
                    :&nbsp;
                    <logic:notEqual name="ListFinancehdrForm" property="orderBy"
			scope="session" value="FINANCEHDR_ID">
                      <html:link action="/ListFinancehdr?orderBy=FINANCEHDR_ID&gotoPage=0" styleClass="link6"><bean:message key="prompt.docid"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListFinancehdrForm" property="orderBy"
			scope="session" value="FINANCEHDR_ID"> <strong><bean:message key="prompt.docid"/></strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListFinancehdrForm" property="orderBy"
			scope="session" value="Createdate"> <strong><bean:message key="prompt.createdate"/></strong> </logic:equal>
                    <logic:notEqual name="ListFinancehdrForm" property="orderBy"
			scope="session" value="Createdate"> <span class="link4">
                      <html:link action="/ListFinancehdr?orderBy=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.createdate"/></html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                <tr>
                  <td align="right">             
<%--                  <logic:equal name="ListFinancehdrForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListFinancehdrForm" property="firstPage" 
			scope="session" value="false">
                      <html:img src="images/arrow_start_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListFinancehdrForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListFinancehdrForm" property="firstPage"
			scope="session" value="false">
                      <html:img src="images/arrow_previous_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListFinancehdrForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListFinancehdrForm" property="lastPage"
			scope="session" value="false">
                      <html:img src="images/arrow_next_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListFinancehdrForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListFinancehdrForm" property="lastPage"
			scope="session" value="false">
                      <html:img src="images/arrow_end_grey.gif"/>
                    </logic:notEqual>--%>
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>		
        		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireResultsBgcolor">
                <tr>
                  <td class="tdwht" width="1%" colspan="10" valign="middle">			  
<table width="30%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"><tr>
<td class="tdwht">

&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/>

</td>
<td class="tdwht">

<%--<bean:message key="prompt.selectall"/>&nbsp;<html:checkbox name="ListFinancehdrForm" property="searchString15" />--%>

</td>
<td class="tdwht">&nbsp;to&nbsp;</td>
<td class="tdwht"><input type="image" value='<bean:message key="button.print"/>' name="printButton" src="images/print_button.gif"/></td>
<td class="tdwht">&nbsp;or&nbsp;</td>
<td class="tdwht"><input type="image" value='<bean:message key="button.testprint"/>' name="testprintButton" src="images/testprint_button.gif"/></td>
</tr></table>
				  </td>				
                </tr>
                <tr>
                  <td class="billingrunResultsHeader" width="1%">
<input type='checkbox' name='selectedObjectsAll' value='N' onclick="checkAll(document.forms(0).selectedObjects,document.forms(0).selectedObjectsAll);">                  
                  </td>				
                  <td class="billingrunResultsHeader" width="10%"><bean:message key="heading.docid"/> </td>
                  <td class="billingrunResultsHeader" width="8%"><bean:message key="heading.createdate"/></td>
                  <td class="billingrunResultsHeader" width="25%"><bean:message key="heading.billingaccount"/></td>
                  <td class="billingrunResultsHeader" width="5%"><bean:message key="heading.type"/></td>					
                  <td class="billingrunResultsHeader" width="10%"><bean:message key="heading.invoiceno"/></td>
                  <td class="billingrunResultsHeader" width="9%"><bean:message key="heading.printdate"/></td>
                  <td class="billingrunResultsHeader" width="5%"><bean:message key="heading.ccy"/></td>
                  <td class="billingrunResultsHeader" width="10%" align="right"><bean:message key="heading.grossamount"/></td>
                  <td class="billingrunResultsHeader" width="18%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="heading4"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="heading4"><html:link action="/EditFinancehdr?action=Create">
                            <bean:message key="prompt.financehdr.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table></td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListFinancehdrForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>
<td class="<%= _class %>" width="1%" align="left" nowrap="nowrap">				  
<html:multibox property="selectedObjects" onclick="unCheckSelectedObjectsAll();">
<bean:write name="lineItem" property="financehdrId" />
</html:multibox>
</td>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap"><bean:write name="lineItem" property="financehdrId" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="8%" align="left" nowrap><bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="25%" align="left" nowrap><bean:write name="lineItem" property="lesseeaddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="5%"><bean:write name="lineItem" property="doctypekey" filter="true"/></td>					
                    <td class="<%= _class %>" width="10%" align="left"><bean:write name="lineItem" property="dockey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="9%" align="left"><bean:write name="lineItem" property="printdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="5%"><bean:write name="lineItem" property="ccykey" filter="true"/></td>
                    <td class="<%= _class %>" width="10%" nowrap align="right"><bean:write name="lineItem" property="grossamount" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="18%" align="right" valign="top" nowrap><table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="<%= _class %>" align="right"><c:if test="${!lineItem.printedflag and lineItem.manualflag}">
                              <genesysapp:linkFinancehdrLineItem page="/EditFinancehdr.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </genesysapp:linkFinancehdrLineItem>
                              &nbsp;|&nbsp;
                              <genesysapp:linkFinancehdrLineItem page="/EditFinancehdr.do?action=Edit">
                                <bean:message key="prompt.edit"/>
                              </genesysapp:linkFinancehdrLineItem>
                            </c:if>
                            <c:if test="${lineItem.printedflag or !lineItem.manualflag}">
                              <genesysapp:linkFinancehdrLineItem page="/EditFinancehdr.do?action=View">
                                <bean:message key="prompt.view"/>
                              </genesysapp:linkFinancehdrLineItem>
                            </c:if>
                          </td>
                        </tr>
                      </table></td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" width="70%" colspan="10">
					<genesysapp:linkFinancehdrLineItem page="/ListFinancedtl.do"><bean:message key="prompt.details"/></genesysapp:linkFinancehdrLineItem>
                      <c:if test="${!lineItem.printedflag}"> &nbsp;|&nbsp;
                        <genesysapp:linkFinancehdrLineItem page="/PrintFinancehdr.do?action=Test"><bean:message key="prompt.testprint"/></genesysapp:linkFinancehdrLineItem>
                      </c:if>
                      &nbsp;|&nbsp;
                      <genesysapp:linkFinancehdrLineItem page="/PrintFinancehdr.do?action=Print">
                        <bean:message key="prompt.print"/>
                      </genesysapp:linkFinancehdrLineItem>
                    </td>
                  </tr>
					<tr><td colspan="10" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table>		
			</td>
    	</tr>
  </table>
</div>

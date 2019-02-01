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

<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:950px; height:650px; z-index:20; visibility: visible">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      <td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      <td valign="top">
	  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>:&nbsp;
                    <logic:notEqual name="ListContractForm" property="orderBy"
			scope="session" value="Contractno">
                      <html:link action="/ListContract?orderBy=Contractno&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.contractno"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListContractForm" property="orderBy"
			scope="session" value="Contractno"> <strong>
                      <bean:message key="prompt.contractno"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListContractForm" property="orderBy"
			scope="session" value="Createdate"> <strong>
                      <bean:message key="prompt.createdate"/>
                      </strong> </logic:equal>
                    <logic:notEqual name="ListContractForm" property="orderBy"
			scope="session" value="Createdate"> <span class="link4">
                      <html:link action="/ListContract?orderBy=Createdate&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.createdate"/>
                      </html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                <tr>
                  <td align="right"><logic:equal name="ListContractForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListContractForm" property="firstPage" 
			scope="session" value="false">
                      <html:img src="images/arrow_start_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListContractForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListContractForm" property="firstPage"
			scope="session" value="false">
                      <html:img src="images/arrow_previous_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListContractForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListContractForm" property="lastPage"
			scope="session" value="false">
                      <html:img src="images/arrow_next_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListContractForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListContractForm" property="lastPage"
			scope="session" value="false">
                      <html:img src="images/arrow_end_grey.gif"/>
                    </logic:notEqual>
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractResultsBgcolor">
                <tr>				
                  <td class="contractResultsHeader" width="10%">
				  <bean:message key="heading.contractno"/>
				  </td>
                  <td class="contractResultsHeader" width="10%">
				  <bean:message key="heading.createdate"/>
				  </td>
                  <td class="contractResultsHeader" width="30%">
				  <bean:message key="heading.lessee"/>
				  </td>
                  <td class="contractResultsHeader" width="10%">
				  <bean:message key="heading.leasetype"/>
				  </td>
                  <td class="contractResultsHeader" width="10%">
				  <bean:message key="heading.contractdate"/>
				  </td>
                  <td class="contractResultsHeader" width="10%">
				  <bean:message key="heading.billccy"/>
				  </td>
                  <td class="contractResultsHeader" width="18%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="contractResultsHeader"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="contractResultsHeader"><html:link action="/EditContract?action=Create">
                            <bean:message key="prompt.contract.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table>
					</td>
                </tr>
<%--                <tr><td class="contractResultsBgcolor" colspan="7" height="1"><img src="images/spacer.gif" width="1" height="1"/></td></tr>--%>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListContractForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="contractno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="30%" align="left" nowrap>
					<bean:write name="lineItem" property="lesseeaddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left">
					<bean:write name="lineItem" property="leasetypekey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left">
					<bean:write name="lineItem" property="contractdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%"><bean:write name="lineItem" property="billccykey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="18%" align="right" valign="top" nowrap>
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>					
                          <td class="<%= _class %>" align="right">
<%--						  <c:if test="${!lineItem.onhireflag}">--%>
                              <genesysapp:linkContractLineItem page="/EditContract.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </genesysapp:linkContractLineItem>
                              &nbsp;|&nbsp;
                              <genesysapp:linkContractLineItem page="/EditContract.do?action=Edit">
                                <bean:message key="prompt.edit"/>
                              </genesysapp:linkContractLineItem>
                              &nbsp;|&nbsp;
                              <genesysapp:linkContractLineItem page="/EditContract.do?action=Copy">
                                <bean:message key="prompt.copy"/>
                              </genesysapp:linkContractLineItem>							  
<%--                            </c:if>--%>
<%--                            <c:if test="${lineItem.onhireflag}">
                              <genesysapp:linkContractLineItem page="/EditContract.do?action=View">
                                <bean:message key="prompt.view"/>
                              </genesysapp:linkContractLineItem>
                            </c:if>--%>
                          </td>
                        </tr>
                      </table>
					  </td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" width="100%" colspan="6">				
<%--					<c:if test="${lineItem.onhiressize == 0}">	--%>
						<genesysapp:linkContractLineItem page="/ListContracteqp.do"><bean:message key="prompt.equipment"/></genesysapp:linkContractLineItem>
                      	&nbsp;|&nbsp;					
						<genesysapp:linkContractLineItem page="/ListContractagent.do"><bean:message key="prompt.agents"/></genesysapp:linkContractLineItem>					
<%--					</c:if>--%>
                    </td>
                          <td class="<%= _class %>" align="right">
<genesysapp:linkContractLineItem page="/PrintCustomerContract.do">
                        <bean:message key="prompt.contractprint"/>
</genesysapp:linkContractLineItem>							  
                          </td>						
                  </tr>
					<tr><td colspan="7" background="images/border_dotted.gif"></td></tr>
				</logic:iterate>
              </table></td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>

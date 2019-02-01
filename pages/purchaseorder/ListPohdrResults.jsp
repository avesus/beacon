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
            <td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>
                    :&nbsp;
                    <logic:notEqual name="ListPohdrForm" property="orderBy"
			scope="session" value="Pono">
                      <html:link action="/ListPohdr?orderBy=Pono&gotoPage=0" styleClass="link6"><bean:message key="prompt.pono"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListPohdrForm" property="orderBy"
			scope="session" value="Pono"> <strong><bean:message key="prompt.pono"/></strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListPohdrForm" property="orderBy"
			scope="session" value="Createdate"> <strong><bean:message key="prompt.createdate"/></strong> </logic:equal>
                    <logic:notEqual name="ListPohdrForm" property="orderBy"
			scope="session" value="Createdate"> <span class="link4">
                      <html:link action="/ListPohdr?orderBy=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.createdate"/></html:link>
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
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderResultsBgcolor">
                <tr>			
                  <td class="purchaseorderResultsHeader" width="10%"><bean:message key="heading.pono"/></td>
                  <td class="purchaseorderResultsHeader" width="10%"><bean:message key="heading.createdate"/></td>
                  <td class="purchaseorderResultsHeader" width="10%"><bean:message key="heading.department"/></td>				
                  <td class="purchaseorderResultsHeader" width="20%"><bean:message key="heading.vendor"/>
                    </td>
                  <td class="purchaseorderResultsHeader" width="20%"><bean:message key="heading.shipto"/></td>
                  <td class="purchaseorderResultsHeader" width="5%"><bean:message key="heading.ccy"/></td>			
                  <td class="purchaseorderResultsHeader" width="10%" align="right"><bean:message key="heading.total"/></td>
                  <td class="purchaseorderResultsHeader" width="15%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="purchaseorderResultsHeader"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="purchaseorderResultsHeader"><html:link action="/EditPohdr?action=Create">
                            <bean:message key="prompt.pohdr.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table></td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListPohdrForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap"><bean:write name="lineItem" property="pono" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%">
					<bean:write name="lineItem" property="departmentkey" filter="true"/>
                    </td>					
                    <td class="<%= _class %>" width="20%" nowrap><bean:write name="lineItem" property="vendoraddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="20%" nowrap><bean:write name="lineItem" property="shiptolocationkey.locationName" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="5%"><bean:write name="lineItem" property="ccykey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap align="right"><bean:write name="lineItem" property="totalamt" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="15%" align="right" valign="top" nowrap><table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="<%= _class %>" align="right">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class %>" align="left">
						  <logic:notEqual name="lineItem" property="txt1" value=""> 
						  	<img src='images/icons/icon_information_12_12.png' width='16' height='16' border='0' alt='<c:out value="${lineItem.txt1}"/>'/> 
						  </logic:notEqual>
                          </td>
                          <td width="90%" class="<%= _class %>" align="right">						  
                              <poapp:linkPohdrLineItem page="/EditPohdr.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </poapp:linkPohdrLineItem>
                              &nbsp;|&nbsp;
                              <poapp:linkPohdrLineItem page="/EditPohdr.do?action=Edit">
                                <bean:message key="prompt.edit"/>
                              </poapp:linkPohdrLineItem>							  
							  </td>
							  </tr>
							  </table>
                          </td>
                        </tr>
                      </table></td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" width="70%" colspan="9">
					<poapp:linkPohdrLineItem page="/ListPodtl.do"><bean:message key="prompt.details"/></poapp:linkPohdrLineItem>
<%--                      &nbsp;|&nbsp;
					<poapp:linkPohdrLineItem page="/ListPonote.do"><bean:message key="prompt.notes"/></poapp:linkPohdrLineItem>
--%>                      &nbsp;|&nbsp;
                      <poapp:linkPohdrLineItem page="/PrintPurchaseorder.do?action=Print">
                        <bean:message key="prompt.print"/>
                      </poapp:linkPohdrLineItem>					
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

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

<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:1050px; height:650px; z-index:20; visibility: visible">
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
                    <logic:notEqual name="ListOnhireForm" property="orderBy"
			scope="session" value="Onhireno">
                      <html:link action="/ListOnhire?orderBy=Onhireno&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.onhireno"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListOnhireForm" property="orderBy"
			scope="session" value="Onhireno"> <strong>
                      <bean:message key="prompt.onhireno"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListOnhireForm" property="orderBy"
			scope="session" value="Submitteddate"> <strong>
                      <bean:message key="prompt.submitteddate"/>
                      </strong> </logic:equal>
                    <logic:notEqual name="ListOnhireForm" property="orderBy"
			scope="session" value="Submitteddate"> <span class="link4">
                      <html:link action="/ListOnhire?orderBy=Submitteddate&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.submitteddate"/>
                      </html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                <tr>
                  <td align="right"><logic:equal name="ListOnhireForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOnhireForm" property="firstPage" 
			scope="session" value="false">
                      <html:img src="images/arrow_start_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListOnhireForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOnhireForm" property="firstPage"
			scope="session" value="false">
                      <html:img src="images/arrow_previous_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListOnhireForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOnhireForm" property="lastPage"
			scope="session" value="false">
                      <html:img src="images/arrow_next_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListOnhireForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOnhireForm" property="lastPage"
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
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireResultsBgcolor">
                <tr>				
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.onhireno"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.contractno"/>
				  </td>
                  <td class="onhireResultsHeader" width="15%">
				  <bean:message key="heading.lessee"/>
				  </td>
                  <td class="onhireResultsHeader" width="15%">
				  <bean:message key="heading.equipmentparameters"/>
				  </td>				  
                  <td class="onhireResultsHeader" width="15%">
				  <bean:message key="heading.location"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.submitteddate"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.submittedby"/>
				  </td>
                  <td class="onhireResultsHeader" width="15%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="onhireResultsHeader"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="onhireResultsHeader"><html:link action="/EditOnhire?action=Create">
                            <bean:message key="prompt.onhire.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table>
					</td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListOnhireForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="onhireno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="contractno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="15%" align="left" nowrap>
					<bean:write name="lineItem" property="lesseeaddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="15%" align="left">
					<bean:write name="lineItem" property="eqpkeyp1" filter="true"/>/<bean:write name="lineItem" property="eqpkeyp2" filter="true"/>
                    </td>					
                    <td class="<%= _class %>" width="15%" align="left">
					<bean:write name="lineItem" property="locationkey.locationName" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left">
					<bean:write name="lineItem" property="submitteddate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%">
					<bean:write name="lineItem" property="submittedby" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="15%" align="right" valign="top" nowrap><table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="<%= _class %>" align="right">
<%--						  <c:if test="${!lineItem.onhireeqpsfound == 'false'}">--%>
                              <genesysapp:linkOnhireLineItem page="/EditOnhire.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </genesysapp:linkOnhireLineItem>
                              &nbsp;|&nbsp;
                              <genesysapp:linkOnhireLineItem page="/EditOnhire.do?action=Edit">
                                <bean:message key="prompt.edit"/>
                              </genesysapp:linkOnhireLineItem>						  
<%--                            </c:if>
                            <c:if test="${lineItem.onhireeqpsfound != 'false'}">
                              <genesysapp:linkOnhireLineItem page="/EditOnhire.do?action=View">
                                <bean:message key="prompt.view"/>
                              </genesysapp:linkOnhireLineItem>
                            </c:if>--%>
                          </td>
                        </tr>
                      </table></td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" colspan="5">
						<genesysapp:linkOnhireLineItem page="/ListOnhireeqp.do"><bean:message key="prompt.onhireunits"/></genesysapp:linkOnhireLineItem>					
                    </td>
                    		<td class="<%= _class %>" align="right" valign="top" colspan="3">
<table width="50%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top">
<html:hidden name="lineItem" property="onhireId"/>
<html:select property="searchString15" styleClass="ftforminputsmall">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>
</td>
<td valign="top">	
<html:select property="searchString14" styleClass="ftforminputsmall">
			<html:option value="Onhirenotification">On Hire Notification</html:option>		
</html:select>
</td>
<td><input type=button value="Print" class="button1" onclick="document.location.href='Edit'+searchString14.options[searchString14.selectedIndex].value+'.do?'+'companyheaderId='+searchString15.options[searchString15.selectedIndex].value+'&amp;onhireId='+form.onhireId.value+'&amp;printId='+form.onhireId.value+searchString14.options[searchString14.selectedIndex].value+'&refreshdata=N&action=Print'"/>
</td>
</tr></form></table>
					 		</td>					
                  </tr>
				  
					<tr><td colspan="8" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>

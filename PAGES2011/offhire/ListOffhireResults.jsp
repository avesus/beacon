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

<div id="results" style="OVERFLOW:auto; position:absolute; left:200px; top:0px; width:1050px; height:650px; z-index:20; visibility: visible">
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
                    <logic:notEqual name="ListOffhireForm" property="orderBy"
			scope="session" value="Offhireno">
                      <html:link action="/ListOffhire?orderBy=Offhireno&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.offhireno"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListOffhireForm" property="orderBy"
			scope="session" value="Offhireno"> <strong>
                      <bean:message key="prompt.offhireno"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListOffhireForm" property="orderBy"
			scope="session" value="Submitteddate"> <strong>
                      <bean:message key="prompt.submitteddate"/>
                      </strong> </logic:equal>
                    <logic:notEqual name="ListOffhireForm" property="orderBy"
			scope="session" value="Submitteddate"> <span class="link4">
                      <html:link action="/ListOffhire?orderBy=Submitteddate&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.submitteddate"/>
                      </html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                <tr>
                  <td align="right"><logic:equal name="ListOffhireForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="startButton" name="startButton" src="images/arrow_start.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOffhireForm" property="firstPage" 
			scope="session" value="false">
                      <html:img src="images/arrow_start_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListOffhireForm" property="firstPage"
			scope="session" value="false">
                      <INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOffhireForm" property="firstPage"
			scope="session" value="false">
                      <html:img src="images/arrow_previous_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListOffhireForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOffhireForm" property="lastPage"
			scope="session" value="false">
                      <html:img src="images/arrow_next_grey.gif"/>
                    </logic:notEqual>
                    <logic:equal name="ListOffhireForm" property="lastPage"
			scope="session" value="false">
                      <INPUT type="image" id="endButton" name="endButton" src="images/arrow_end.gif"/>
                    </logic:equal>
                    <logic:notEqual name="ListOffhireForm" property="lastPage"
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
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireResultsBgcolor">
                <tr>				
                  <td class="offhireResultsHeader" width="10%">
				  <bean:message key="heading.offhireno"/>
				  </td>
                  <td class="offhireResultsHeader" width="15%">
				  <bean:message key="heading.lessee"/>
				  </td>			  
                  <td class="offhireResultsHeader" width="15%">
				  <bean:message key="heading.location"/>
				  </td>
                  <td class="offhireResultsHeader" width="10%">
				  <bean:message key="heading.submitteddate"/>
				  </td>
                  <td class="offhireResultsHeader" width="10%">
				  <bean:message key="heading.submittedby"/>
				  </td>
                  <td class="offhireResultsHeader" width="15%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="offhireResultsHeader"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="offhireResultsHeader"><html:link action="/EditOffhire?action=Create">
                            <bean:message key="prompt.offhire.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table>
					</td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListOffhireForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="offhireno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="15%" align="left" nowrap>
					<bean:write name="lineItem" property="lesseeaddrkey.name" filter="true"/>
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
<%--						  <c:if test="${!lineItem.offhireeqpsfound == 'false'}">--%>
                              <genesysapp:linkOffhireLineItem page="/EditOffhire.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </genesysapp:linkOffhireLineItem>
                              &nbsp;|&nbsp;
                              <genesysapp:linkOffhireLineItem page="/EditOffhire.do?action=Edit">
                                <bean:message key="prompt.edit"/>
                              </genesysapp:linkOffhireLineItem>						  
<%--                            </c:if>
                            <c:if test="${lineItem.offhireeqpsfound != 'false'}">
                              <genesysapp:linkOffhireLineItem page="/EditOffhire.do?action=View">
                                <bean:message key="prompt.view"/>
                              </genesysapp:linkOffhireLineItem>
                            </c:if>--%>
                          </td>
                        </tr>
                      </table></td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" width="100%" colspan="4">
						<genesysapp:linkOffhireLineItem page="/ListOffhireeqp.do"><bean:message key="prompt.offhireunits"/></genesysapp:linkOffhireLineItem>					
                    </td>
<td class="<%= _class %>" align="right" valign="top" colspan="2">
<table width="50%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top">
<html:hidden name="lineItem" property="id"/>
<html:select property="searchString15" styleClass="ftforminputsmall">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>
</td>
<td valign="top">	
<html:select property="searchString14" styleClass="ftforminputsmall">
			<html:option value="Offhirenotification">Off Hire Notification</html:option>		
</html:select>
</td>
<td><input type=button value="Print" class="button1" onclick="document.location.href='Edit'+searchString14.options[searchString14.selectedIndex].value+'.do?'+'companyheaderId='+searchString15.options[searchString15.selectedIndex].value+'&amp;offhireId='+form.id.value+'&amp;printId='+form.id.value+searchString14.options[searchString14.selectedIndex].value+'&refreshdata=N&action=Print'"/>
</td>
</tr></form></table>
					 		</td>					
                  </tr>
				  
					<tr><td colspan="6" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>

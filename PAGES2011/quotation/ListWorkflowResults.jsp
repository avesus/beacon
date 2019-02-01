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
	  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>:&nbsp;
                    <logic:notEqual name="ListWorkflowForm" property="orderBy"
			scope="session" value="Userid">
                      <html:link action="/ListWorkflow?orderBy=Userid&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.userid"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListWorkflowForm" property="orderBy"
			scope="session" value="Userid"> <strong>
                      <bean:message key="prompt.userid"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:notEqual name="ListWorkflowForm" property="orderBy"
			scope="session" value="Usergroupid">
                      <html:link action="/ListWorkflow?orderBy=Usergroupid&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.groupid"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListWorkflowForm" property="orderBy"
			scope="session" value="Usergroupid"> <strong>
                      <bean:message key="prompt.groupid"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:notEqual name="ListWorkflowForm" property="orderBy"
			scope="session" value="Quotno">
                      <html:link action="/ListWorkflow?orderBy=Quotno&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.quotno"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListWorkflowForm" property="orderBy"
			scope="session" value="Quotno"> <strong>
                      <bean:message key="prompt.quotno"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListWorkflowForm" property="orderBy"
			scope="session" value="Quotedate"> <strong>
                      <bean:message key="prompt.quotedate"/>
                      </strong> </logic:equal>
                    <logic:notEqual name="ListWorkflowForm" property="orderBy"
			scope="session" value="Quotedate"> <span class="link4">
                      <html:link action="/ListWorkflow?orderBy=Quotedate&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.quotedate"/>
                      </html:link>
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
      <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                <tr>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.userid"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.groupid"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.quotno"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.quotestatus"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.quotedate"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.quotecreateby"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.approvereject"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.approvetime"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4"> &nbsp; </span> </td>
                </tr>
                <c:forEach var="lineItem" items="${ListWorkflowForm.lineItems}" varStatus="loop">
                  <c:set var="_class" value="tdlghtgry"/>
                  <c:if test="${loop.count % 2 == 0}">
                    <c:set var="_class" value="tdlghtgry2"/>
                  </c:if>
                  <!-- row1 -->
                  <tr>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left"><c:out value="${lineItem.userid}"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left" nowrap><bean:write name="lineItem" property="usergroupid" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left" nowrap><bean:write name="lineItem" property="quotno" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left">
                      <c:if test="${lineItem.quotestatus == 'PENDING'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12"/>
                      </c:if>
                      <c:if test="${lineItem.quotestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12"/>
                      </c:if>	
                      <c:if test="${lineItem.quotestatus == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12"/>
                      </c:if>											
					<bean:write name="lineItem" property="quotestatus" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left" nowrap><bean:write name="lineItem" property="quotedate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left"><bean:write name="lineItem" property="quotebyuserid" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left">
                      <c:if test="${lineItem.approveflag == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12"/>
                      </c:if>	
                      <c:if test="${lineItem.approveflag == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12"/>
                      </c:if>					
					<bean:write name="lineItem" property="approveflag" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left"><bean:write name="lineItem" property="approvedate" format="dd-MMM-yyyy" filter="true"/>
                      <bean:write name="lineItem" property="approvetime" filter="true"/>
                    </td>
                    <td class='<c:out value="${_class}"/>' width="10%" align="left"><app:linkWorkflowLineItem page="/ListQuoapprove.do?">
                        <bean:message key="prompt.approvereject"/>
                      </app:linkWorkflowLineItem>
                    </td>
                  </tr>
                  <!-- row2 -->
					<tr><td colspan="9" background="images/border_dotted.gif"></td></tr>				  
                </c:forEach>
              </table></td>
          </tr>
        </table>
	</td>
    </tr>
  </table>
</div>

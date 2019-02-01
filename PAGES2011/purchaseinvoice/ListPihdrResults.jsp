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
            <td>
			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>
                    :&nbsp;
                    <logic:notEqual name="ListPihdrForm" property="orderBy"
			scope="session" value="Pino">
                      <html:link action="/ListPihdr?orderBy=Pino&gotoPage=0" styleClass="link6"><bean:message key="prompt.pino"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListPihdrForm" property="orderBy"
			scope="session" value="Pino"> <strong><bean:message key="prompt.pino"/></strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListPihdrForm" property="orderBy"
			scope="session" value="Invoicedate"> <strong><bean:message key="prompt.invoicedate"/></strong> </logic:equal>
                    <logic:notEqual name="ListPihdrForm" property="orderBy"
			scope="session" value="Invoicedate"> <span class="link4">
                      <html:link action="/ListPihdr?orderBy=Invoicedate&gotoPage=0" styleClass="link6"><bean:message key="prompt.invoicedate"/></html:link>
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
                  <td class="purchaseorderResultsHeader" width="10%"><bean:message key="heading.pino"/></td>
                  <td class="purchaseorderResultsHeader" width="10%"><bean:message key="heading.invoicedate"/></td>			
                  <td class="purchaseorderResultsHeader" width="20%"><bean:message key="heading.vendor"/></td>
                  <td class="purchaseorderResultsHeader" width="20%"><bean:message key="heading.vendorref"/></td>
                  <td class="purchaseorderResultsHeader" width="5%"><bean:message key="heading.ccy"/></td>
                  <td class="purchaseorderResultsHeader" width="10%" align="right"><bean:message key="heading.grossamt"/></td>
                  <td class="purchaseorderResultsHeader" width="5%"><bean:message key="heading.approved"/></td>				  				  			
                  <td class="purchaseorderResultsHeader" width="15%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="purchaseorderResultsHeader"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="purchaseorderResultsHeader">
                        
                            <html:link action="/EditPihdr?action=Create">
                        <html:img src="images/buttons/btn_add_12_12.png" alt="Add" border="0" align="middle"/>
                        </html:link>
                        <html:link action="/EditPihdr?action=Create">
                            <span style="vertical-align:middle"><bean:message key="prompt.pihdr.add"/></span>
                        </html:link>
                        </td>
                      </tr>
                    </table></td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListPihdrForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap"><bean:write name="lineItem" property="pino" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="invoicedate" format="dd-MMM-yyyy" filter="true"/></td>				
                    <td class="<%= _class %>" width="20%" nowrap><bean:write name="lineItem" property="vendoraddrkey.name" filter="true"/></td>
                    <td class="<%= _class %>" width="20%" nowrap><bean:write name="lineItem" property="vendorref" filter="true"/></td>					
                    <td class="<%= _class %>" width="5%"><bean:write name="lineItem" property="ccykey" filter="true"/></td>
					<td class="<%= _class %>" width="10%" align="right"><bean:write name="lineItem" property="grossamt" filter="true"/></td>
					<td class="<%= _class %>" width="5%" align="center">
                      <c:if test="${lineItem.invoicestatus == 'DISPUTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${lineItem.invoicestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.invoicestatus}"/>'/>
                      </c:if>					
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

<html:link action="/EditPihdr.do?action=Edit" paramId="id" paramName="lineItem" paramProperty="pihdrId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditPihdr.do?action=Delete" paramId="id" paramName="lineItem" paramProperty="pihdrId">
<bean:message key="prompt.delete"/> 
</html:link>                                  							  
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
					<piapp:linkPihdrLineItem page="/ListPidtl.do"><bean:message key="prompt.details"/></piapp:linkPihdrLineItem>
<!--                     &nbsp;|&nbsp;
                      <piapp:linkPihdrLineItem page="/PrintPurchaseorder.do?action=Print">
                        <bean:message key="prompt.print"/>
                      </piapp:linkPihdrLineItem>-->					
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

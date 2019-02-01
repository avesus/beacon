<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%--
 *
 * Amendments
 * ----------
 *
 * NT	2009-05-31		ITT-200905-0003		Add Logistic Location details to List
 * 												
 *
 --%>
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->


<script language="JavaScript">
<!--	
function showHideDetails(div,but) { 

var i,p,v,obj,but;

obj=MM_findObj(div);
obj=obj.style; 
v=obj.visibility;
if (v=='hidden') {
	obj.visibility='visible';	
	MM_swapImage(but,'','images/icon_collapse_12_12.png');	
}
else {
	obj.visibility='hidden'; 
	MM_swapImage(but,'','images/icon_expand_12_12.png');	
}
}
-->
</script>


<div id="results" style="OVERFLOW:auto; position:absolute; left:250px; top:0px; width:1150px; height:650px; z-index:1; visibility: visible">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
  
  
    <tr>
      <td bgcolor="#ffffff" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      <td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      
      <td valign="top">
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
      
          <tr>
            <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                <tr>
                  <td class="text2"><bean:message key="prompt.sortby"/>:&nbsp;
                    <logic:notEqual name="ListOrderhdrForm" property="orderBy"
			scope="session" value="Orderno">
                      <html:link action="/ListOrderhdr?orderBy=Orderno&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.ordernumber"/>
                      </html:link>
                    </logic:notEqual>
                    <logic:equal name="ListOrderhdrForm" property="orderBy"
			scope="session" value="Orderno"> <strong>
                      <bean:message key="prompt.ordernumber"/>
                      </strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListOrderhdrForm" property="orderBy"
			scope="session" value="Orderdate"> <strong>
                      <bean:message key="prompt.orderdate"/>
                      </strong> </logic:equal>
                    <logic:notEqual name="ListOrderhdrForm" property="orderBy"
			scope="session" value="Orderdate"> <span class="link4">
                      <html:link action="/ListOrderhdr?orderBy=Orderdate&gotoPage=0" styleClass="link6">
                        <bean:message key="prompt.orderdate"/>
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
        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                <tr>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.ordernumber"/>
                    </span> </td>
                  <td class="tddkgry" width="7%"><span class="heading4">
                    <bean:message key="heading.orderdate"/>
                    </span> </td>
                  <td class="tddkgry" width="10%"><span class="heading4">
                    <bean:message key="heading.quotenumber"/>
                    </span> </td>
                  <td class="tddkgry" width="5%"><span class="heading4">
                    <bean:message key="heading.by"/>
                    </span> </td>
                  <td class="tddkgry" width="21%"><span class="heading4">
                    <bean:message key="heading.customer"/>
                    </span> </td>
                  <td class="tddkgry" width="11%"><span class="heading4">
                    <bean:message key="heading.customerref"/>
                    </span> </td>
                  <td class="tddkgry" width="8%"><span class="heading4">
                    <bean:message key="heading.invoicestatus"/>
                    </span> </td>
                  <td class="tddkgry" width="9%"><span class="heading4">
                    <bean:message key="heading.consignmentno"/>
                    </span> </td>
                  <td class="tddkgry" width="17%"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="heading4"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="heading4"><html:link action="/EditOrderhdr?action=Create">
                            <bean:message key="prompt.orderhdr.add"/>
                          </html:link>
                        </td>
                      </tr>
                    </table></td>
                </tr>
<%
int row=0;
%>
                <logic:iterate id="orderhdrLineItem" name="ListOrderhdrForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>
                  <!-- row1 -->
                  <tr>
                    <td class="<%= _class %>" width="10%" align="left" nowrap><bean:write name="orderhdrLineItem" property="orderno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="7%" align="left" nowrap>
					<bean:write name="orderhdrLineItem" property="orderdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap><bean:write name="orderhdrLineItem" property="quotno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="5%" align="left" nowrap><bean:write name="orderhdrLineItem" property="orderbyuserid" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="21%" align="left" nowrap><bean:write name="orderhdrLineItem" property="customeraddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="11%"><bean:write name="orderhdrLineItem" property="customerref" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="8%">
                      <c:if test="${orderhdrLineItem.invoicestatus == 'NOT INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${orderhdrLineItem.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${orderhdrLineItem.invoicestatus == 'FULLY INVOICED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${orderhdrLineItem.invoicestatus}"/>'/>
                      </c:if>	
                      <c:if test="${orderhdrLineItem.invoicestatus == 'PART INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${orderhdrLineItem.invoicestatus}"/>'/>
                      </c:if>										
					<bean:write name="orderhdrLineItem" property="invoicestatus" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="9%" nowrap><bean:write name="orderhdrLineItem" property="consignmentno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="17%" align="right" valign="top" nowrap>
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class %>" align="left">
						  <logic:notEqual name="orderhdrLineItem" property="notes" value=""> 
						  	<img src='images/icons/icon_information_12_12.png' width='16' height='16' border='0' alt='<c:out value="${orderhdrLineItem.notes}"/>'/> 
						  </logic:notEqual>
                          </td>
                          <td width="90%" class="<%= _class %>" align="right">
						  <c:if test="${orderhdrLineItem.jobhdrsfound == 'false'}">
                              <orderapp:linkOrderhdrLineItem page="/EditOrderhdr.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </orderapp:linkOrderhdrLineItem>
                              &nbsp;|&nbsp; </c:if>
                            <orderapp:linkOrderhdrLineItem page="/EditOrderhdr.do?action=Edit">
                              <bean:message key="prompt.edit"/>
                            </orderapp:linkOrderhdrLineItem>
                            &nbsp;|&nbsp;
                            <orderapp:linkOrderhdrLineItem page="/EditOrderhdr.do?action=Copy">
                              <bean:message key="prompt.copy"/>
                            </orderapp:linkOrderhdrLineItem>
                          </td>
                        </tr>
                      	</table>
					  </td>
                  </tr>
                  <!-- row2 -->
                  <tr>
                  	<td class="<%= _class %>" width="100%" colspan="9">
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
				  <td class="<%= _class %>" align="left" valign="top">
				  	<img src="images/icon_expand_12_12.png" width="12" height="12" align="middle" id="but_<c:out value="${orderhdrLineItem.orderno}"/>" onclick="showHideDetails('div_<c:out value="${orderhdrLineItem.orderno}"/>','but_<c:out value="${orderhdrLineItem.orderno}"/>');"/>
				  </td>
				  <td class="<%= _class %>" align="left">
				  <img src="images/spacer.gif" width="12" height="1"/>
				  </td>	                            
							<td align="left" class="<%= _class %>" valign="top" width="72%">
                            
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<td class="<%= _class %>" valign="top">                             
					<orderapp:linkOrderhdrLineItem page="/ListOrderprod.do">
                        <bean:message key="prompt.products"/>
                      </orderapp:linkOrderhdrLineItem> 
</td> 
<td class="<%= _class %>" valign="top">                                          
                      &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top">                      
                      <orderapp:linkOrderhdrLineItem page="/ListOrdercharge.do">
                        <bean:message key="prompt.charges"/>
                      </orderapp:linkOrderhdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                      
                      &nbsp;|&nbsp;
</td>                      
<c:if test="${orderhdrLineItem.jobhdrsfound == 'false'}">
<td class="<%= _class %>" valign="top">
                        <orderapp:linkOrderhdrLineItem page="/ListOrdermov.do">
                          <bean:message key="prompt.movements"/>
                        </orderapp:linkOrderhdrLineItem>
                        </td>
<td class="<%= _class %>" valign="top">
                        &nbsp;|&nbsp; 				
                        </td>
<td class="<%= _class %>" valign="top">
                      <orderapp:linkOrderhdrLineItem page="/ListOrdercost.do">
                        <bean:message key="prompt.costs"/>
                      </orderapp:linkOrderhdrLineItem>
                      </td>
<td class="<%= _class %>" valign="top">
                      &nbsp;|&nbsp;
                      </td>
</c:if>				
<td class="<%= _class %>" valign="top">	  
                      <orderapp:linkOrderhdrLineItem page="/ListJobhdr.do">
                        <bean:message key="prompt.jobunitsandassign"/>
                      </orderapp:linkOrderhdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                                           
                      &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top" nowrap="nowrap">
                      <orderapp:linkOrderhdrLineItem page="/ListOrdernote.do">
                        <bean:message key="prompt.notes"/>
                      </orderapp:linkOrderhdrLineItem>
<c:if test="${orderhdrLineItem.notesfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<orderapp:linkOrderhdrLineItem page="/ListOrdernote.do">(<c:out value="${orderhdrLineItem.notesfound}"/>)</orderapp:linkOrderhdrLineItem>
</c:if>
</td>
<td class="<%= _class %>" valign="top">                        
                      &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top" nowrap="nowrap">                      
                      <orderapp:linkOrderhdrLineItem page="/ListOrdernotecust.do">
                          <bean:message key="prompt.customernotes"/>
                      </orderapp:linkOrderhdrLineItem>
<c:if test="${orderhdrLineItem.notecustsfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<orderapp:linkOrderhdrLineItem page="/ListOrdernotecust.do">(<c:out value="${orderhdrLineItem.notecustsfound}"/>)</orderapp:linkOrderhdrLineItem>
</c:if> 
</td>
<td class="<%= _class %>" valign="top">                     
                        &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top" nowrap="nowrap">                        
                      <orderapp:linkOrderhdrLineItem page="/ListOrderfile.do">
                        <bean:message key="prompt.documents"/>
                      </orderapp:linkOrderhdrLineItem> 
<c:if test="${orderhdrLineItem.documentsfound != '0'}">
<img src='images/icons/icon_stored_documents2_12_12.png' border='0' alt='Documents stored'/>
<orderapp:linkOrderhdrLineItem page="/ListOrderfile.do">(<c:out value="${orderhdrLineItem.documentsfound}"/>)</orderapp:linkOrderhdrLineItem>
</c:if>
</td>
<td class="<%= _class %>" valign="top">                                           
                      &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top">                      
                      <orderapp:linkOrderhdrLineItem page="/ListOrdersummary.do">
                        <bean:message key="prompt.financialsummary"/>
                      </orderapp:linkOrderhdrLineItem>
</td>
</tr></table> 
                     
                    		</td>
                    		<td class="<%= _class %>" align="right" valign="top" width="28%">
                            
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top">
<html:hidden name="orderhdrLineItem" property="id"/>
<html:select property="searchString15" styleClass="ftforminputsmall">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>
</td>
<td valign="top">	
<html:select property="searchString8" styleClass="ftforminputsmall">
			<html:option value="Disbursementsummary">Disbursement</html:option>
			<html:option value="Bookingnotification">Booking Notif.</html:option>
			<html:option value="Arrivalnotice">Arrival Notice</html:option>
</html:select>
</td>
<td>
<input type=button value="Print/Email" class="button1" id="Print" onclick="document.location.href='Edit'+searchString8.options[searchString8.selectedIndex].value+'.do?'+'companyheaderId='+searchString15.options[searchString15.selectedIndex].value+'&amp;orderhdrId='+form.id.value+'&amp;printId=Order'+form.id.value+searchString8.options[searchString8.selectedIndex].value+'&refreshdata=N&action=Print'"/>
</td>
</tr></form></table>

					 		</td>
							</tr>
						</table>
					</td>
                  </tr>


<!--sITT-200905-0003-->
<tr><td colspan="9" background="images/border_dotted.gif">						
            <!-- row3 -->
			<div id='div_<c:out value="${orderhdrLineItem.orderno}"/>' style='position:absolute; z-index:30; visibility: hidden; border: 1px solid #999999;'>
	  <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
          <tr>
                      <td class="tddkgry" width="20%"><span class="heading4">
              <bean:message key="heading.shipmethod"/>
              </span> </td>
            <td class="tddkgry" width="20%"><span class="heading4">
              <bean:message key="heading.pickuplocation"/>
              </span> </td>
            <td class="tddkgry" width="20%"><span class="heading4">
              <bean:message key="heading.loadingport"/>
              </span> </td>
            <td class="tddkgry" width="20%"><span class="heading4">
              <bean:message key="heading.dischargeport"/>
              </span> </td>
            <td class="tddkgry" width="20%"><span class="heading4">
              <bean:message key="heading.deliverylocation"/>
              </span> </td>
            <td class="tddkgry" width="20%"><span class="heading4">
              <bean:message key="heading.primaryproduct"/>
              </span> </td>              
          </tr>			
          <tr>
                        <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="shipmethod" filter="true"/>              
			  </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="ldglocationkey1.locationName" filter="true"/>              
			  </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="ldglocationkey2.locationName" filter="true"/> 
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="dchlocationkey2.locationName" filter="true"/> 
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="dchlocationkey1.locationName" filter="true"/>              
</td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="productkey.tradname" filter="true"/>  
              </td>
            </tr>  
</table>
			</div>
</td></tr>			
<script language="JavaScript">
<!--	
MM_showHideLayers('div_<c:out value="${orderhdrLineItem.orderno}"/>','','hide');
-->
</script>		
<!--eITT-200905-0003-->
				  
					<%--<tr><td colspan="9" background="images/border_dotted.gif"></td></tr>--%>
									  
                </logic:iterate>
              </table></td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>

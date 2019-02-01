<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 * 	NT	2009-05-31		ITT-200905-0003		Add Logistic Location details to Quohdr List
 * 
 * 	NT	2009-10-26		ITT-200910-0002		Quotation Letter
 *  												
 * 	NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 *	NT	2010-11-24		201000049			Hide Quotation Letter print when Quotation not approved
 *
 * 	NT	2011-03-01		ITT-201103-0001		Quotation Customer Notes 
 *											- add option for customer notes
 *											- move notes outside approved check, so can be updated
 *											- remove DOCUMENTS option for ITT 										
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


<div id="results" style="OVERFLOW:auto; position:absolute; left:270px; top:0px; width:1100px; height:650px; z-index:1; visibility: visible">
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
              <logic:notEqual name="ListQuohdrForm" property="orderBy"
			scope="session" value="Quotno">
                <html:link action="/ListQuohdr?orderBy=Quotno&gotoPage=0" styleClass="link6">
                  <bean:message key="prompt.quotno"/>
                </html:link>
              </logic:notEqual>
              <logic:equal name="ListQuohdrForm" property="orderBy"
			scope="session" value="Quotno"> <strong>
                <bean:message key="prompt.quotno"/>
                </strong> </logic:equal>
              <strong>&nbsp;|&nbsp;</strong>
              <logic:equal name="ListQuohdrForm" property="orderBy"
			scope="session" value="Quotedate"> <strong>
                <bean:message key="prompt.quotedate"/>
                </strong> </logic:equal>
              <logic:notEqual name="ListQuohdrForm" property="orderBy"
			scope="session" value="Quotedate"> <span class="link4">
                <html:link action="/ListQuohdr?orderBy=Quotedate&gotoPage=0" styleClass="link6">
                  <bean:message key="prompt.quotedate"/>
                </html:link>
                </span> </logic:notEqual>
              <strong>&nbsp;|&nbsp;</strong>
              <logic:equal name="ListQuohdrForm" property="orderBy"
			scope="session" value="Expirydate"> <strong>
                <bean:message key="prompt.expirydate"/>
                </strong> </logic:equal>
              <logic:notEqual name="ListQuohdrForm" property="orderBy"
			scope="session" value="Expirydate"> <span class="link4">
                <html:link action="/ListQuohdr?orderBy=Expirydate&gotoPage=0" styleClass="link6">
                  <bean:message key="prompt.expirydate"/>
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
      <td>
	  <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
          <tr>
            <td class="tddkgry" width="8%"><span class="heading4">
              <bean:message key="heading.quotno"/>
              </span> </td>
            <td class="tddkgry" width="9%"><span class="heading4">
              <bean:message key="heading.quotedate"/>
              </span> </td>
            <td class="tddkgry" width="9%"><span class="heading4">
              <bean:message key="heading.effectivedate"/>
              </span> </td>               
            <td class="tddkgry" width="9%"><span class="heading4">
              <bean:message key="heading.expirydate"/>
              </span> </td>             
            <td class="tddkgry" width="5%"><span class="heading4">
              <bean:message key="heading.createdby"/>
              </span> </td>
            <td class="tddkgry" width="9%"><span class="heading4">
              <bean:message key="heading.status"/>
              </span> </td>
            <td class="tddkgry" width="21%"><span class="heading4">
              <bean:message key="heading.customer"/>
              </span> </td>
            <td class="tddkgry" width="9%"><span class="heading4">
              <bean:message key="heading.shipmethod"/>
              </span> </td>
            <td class="tddkgry" width="25%"><table border="0" cellpadding="0" cellspacing="0" width="100%">
                <tr>
                  <td align="left" class="heading4"><bean:message key="heading.action"/>
                  </td>
                  <td align="right" class="heading4"><html:link action="/EditQuohdr?action=Create">
                      <bean:message key="prompt.quohdr.add"/>
                    </html:link>
                  </td>
                </tr>
              </table></td>
          </tr>
          <%
int row=0;
%>
          <logic:iterate id="quohdrLineItem" name="ListQuohdrForm" property="lineItems">
            <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>
           <!-- row1 -->
            <tr>
              <td class="<%= _class %>" align="left" nowrap="nowrap"><bean:write name="quohdrLineItem" property="quotno" filter="true"/>
              </td>
              <td class="<%= _class %>" align="left" nowrap><bean:write name="quohdrLineItem" property="quotedate" format="dd-MMM-yyyy" filter="true"/>
              </td>
              <td class="<%= _class %>" align="left" nowrap><bean:write name="quohdrLineItem" property="effectivedate" format="dd-MMM-yyyy" filter="true"/>
              </td>              
              <td class="<%= _class %>" align="left" nowrap><bean:write name="quohdrLineItem" property="expirydate" format="dd-MMM-yyyy" filter="true"/>
              </td>
              <td class="<%= _class %>" align="left"><bean:write name="quohdrLineItem" property="quotebyuserid" filter="true"/>
              </td>
              <td class="<%= _class %>" align="left">
                      <c:if test="${quohdrLineItem.quotestatus == 'PENDING'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${quohdrLineItem.quotestatus}"/>'/>
                      </c:if>
                      <c:if test="${quohdrLineItem.quotestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${quohdrLineItem.quotestatus}"/>'/>
                      </c:if>	
                      <c:if test="${quohdrLineItem.quotestatus == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${quohdrLineItem.quotestatus}"/>'/>
                      </c:if>						  				  			  
			  <bean:write name="quohdrLineItem" property="quotestatus" filter="true"/>
              </td>
              <td class="<%= _class %>"><bean:write name="quohdrLineItem" property="customeraddrkey.name" filter="true"/>
              </td>
              <td class="<%= _class %>" nowrap><bean:write name="quohdrLineItem" property="shipmethod" filter="true"/>
              </td>
              <td class="<%= _class %>" align="right" valign="top" nowrap><table border="0" width="100%" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="<%= _class %>" align="right">
                    <app:linkQuohdrLineItem page="/PrintQuotation.do">
                        <bean:message key="prompt.print"/>
                      </app:linkQuohdrLineItem>
                      &nbsp;|&nbsp;
                      <c:if test="${quohdrLineItem.orderhdrsfound == 'false'}">
                        <app:linkQuohdrLineItem page="/EditQuohdr.do?action=Delete">
                          <bean:message key="prompt.delete"/>
                        </app:linkQuohdrLineItem>
                        &nbsp;|&nbsp; </c:if>
                      <c:if test="${quohdrLineItem.quotestatus != 'APPROVED'}">
                        <app:linkQuohdrLineItem page="/EditQuohdr.do?action=Edit">
                          <bean:message key="prompt.edit"/>
                        </app:linkQuohdrLineItem>
                        &nbsp;|&nbsp; </c:if>
                      <c:if test="${quohdrLineItem.quotestatus == 'APPROVED'}">
                        <app:linkQuohdrLineItem page="/EditQuohdr.do?action=View">
                          <bean:message key="prompt.view"/>
                        </app:linkQuohdrLineItem>
                        &nbsp;|&nbsp; </c:if>
                      <app:linkQuohdrLineItem page="/EditQuohdr.do?action=Copy">
                        <bean:message key="prompt.copy"/>
                      </app:linkQuohdrLineItem>
                    </td>
                  </tr>
                </table></td>
            </tr>
			
            <!-- row2 -->
            <tr>
              <td colspan="9">
              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>
				  <td class="<%= _class %>" align="left">
				  	<img src="images/icon_expand_12_12.png" width="12" height="12" align="middle" id="but_<c:out value="${quohdrLineItem.quotno}"/>" onclick="showHideDetails('div_<c:out value="${quohdrLineItem.quotno}"/>','but_<c:out value="${quohdrLineItem.quotno}"/>');"/>
				  </td>
				  <td class="<%= _class %>" align="left">
				  <img src="images/spacer.gif" width="12" height="1"/>
				  </td>				  
                    <td class="<%= _class %>" width="80%">
                    
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>                    
<c:if test="${quohdrLineItem.quotestatus != 'APPROVED'}">
<td class="<%= _class %>" valign="top"> 
                        <app:linkQuohdrLineItem page="/ListQuoprod.do">
                          <bean:message key="prompt.products"/>
                        </app:linkQuohdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                         
                        &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top">                         
                        <app:linkQuohdrLineItem page="/ListQuocharge.do">
                          <bean:message key="prompt.charges"/>
                        </app:linkQuohdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                         
                        &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top">                         
                        <app:linkQuohdrLineItem page="/ListQuomov.do">
                          <bean:message key="prompt.movements"/>
                        </app:linkQuohdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                         
                        &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top">                         
                        <app:linkQuohdrLineItem page="/ListQuocost.do">
                          <bean:message key="prompt.costs"/>
                        </app:linkQuohdrLineItem>
</td> 
<td class="<%= _class %>" valign="top">                         
                        &nbsp;|&nbsp;
</td>                                            
</c:if>


<td class="<%= _class %>" valign="top" nowrap="nowrap">
						<!--sITT-201103-0001-->
                       <app:linkQuohdrLineItem page="/ListQuonote.do">
                          <bean:message key="prompt.notes"/>
                        </app:linkQuohdrLineItem> 
<c:if test="${quohdrLineItem.notesfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<app:linkQuohdrLineItem page="/ListQuonote.do">(<c:out value="${quohdrLineItem.notesfound}"/>)</app:linkQuohdrLineItem>
</c:if>                                 
</td>
<td class="<%= _class %>" valign="top">              
                        &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top" nowrap="nowrap">                         
                        <app:linkQuohdrLineItem page="/ListQuonotecust.do">
                          <bean:message key="prompt.customernotes"/>
                        </app:linkQuohdrLineItem>
<c:if test="${quohdrLineItem.notecustsfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<app:linkQuohdrLineItem page="/ListQuonotecust.do">(<c:out value="${quohdrLineItem.notecustsfound}"/>)</app:linkQuohdrLineItem>
</c:if>                         
</td>
<td class="<%= _class %>" valign="top"> 
                        &nbsp;|&nbsp;  
</td>                        
                        <!--eITT-201103-0001-->
                        
                        
<%--                      <app:linkQuohdrLineItem page="/ListQuofile.do">
                        <bean:message key="prompt.documents"/>
                      </app:linkQuohdrLineItem>
                      &nbsp;|&nbsp; --%>
     
<td class="<%= _class %>" valign="top">                                              
                      <app:linkQuohdrLineItem page="/ListQuosummary.do">
                        <bean:message key="prompt.profitanalysis"/>
                      </app:linkQuohdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                       
                      &nbsp;|&nbsp;
</td>
<td class="<%= _class %>" valign="top">                       
                      <app:linkQuohdrLineItem page="/PrintQuosummary.do">
                        <bean:message key="prompt.profitanalysisprint"/>
                      </app:linkQuohdrLineItem>
</td>
<td class="<%= _class %>" valign="top">                       
                      &nbsp;|&nbsp;     
</td>
<td class="<%= _class %>" valign="top">                                        
                    <app:linkQuohdrLineItem page="/PrintCustomerQuotation.do">
                        <bean:message key="prompt.customerprint"/>
                      </app:linkQuohdrLineItem>                      
</td>
</tr></table>
                      
                    </td>
                    <td class="<%= _class %>" width="20%" align="right">
                    
<!--sITT-200910-0002-->
<c:if test="${quohdrLineItem.quotestatus == 'APPROVED'}"><!--201000049-->
 <table width="100%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top">
<html:hidden name="quohdrLineItem" property="id"/>
<html:select property="searchString7" styleClass="ftforminputsmall">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>
</td>
<td valign="top">	
<html:select property="searchString8" styleClass="ftforminputsmall">
			<html:option value="Quotationletter">Quotation Letter</html:option>		
</html:select>
</td>
<td>
<input type=button value="Print/Email" class="button1" id="Print" onclick="document.location.href='Edit'+searchString8.options[searchString8.selectedIndex].value+'.do?'+'companyheaderId='+searchString7.options[searchString7.selectedIndex].value+'&amp;orderhdrId='+form.id.value+'&amp;printId='+form.id.value+searchString8.options[searchString8.selectedIndex].value+'&refreshdata=N&action=Print'"/>
</td>
</tr></form></table> 
</c:if><!--201000049-->                    
<!--eITT-200910-0002-->
                      
                    </td>
                  </tr>
                </table>
              </td>
            </tr>


<!--sITT-200905-0003-->
<tr><td colspan="9" background="images/border_dotted.gif">						
            <!-- row3 -->
			<div id='div_<c:out value="${quohdrLineItem.quotno}"/>' style='position:absolute; z-index:30; visibility: hidden; border: 1px solid #999999;'>
	  <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
          <tr>
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
<bean:write name="quohdrLineItem" property="ldglocationkey1.locationName" filter="true"/>              
			  </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="ldglocationkey2.locationName" filter="true"/> 
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="dchlocationkey2.locationName" filter="true"/> 
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="dchlocationkey1.locationName" filter="true"/>              
</td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="productkey.tradname" filter="true"/>  
              </td>
            </tr>  
</table>
			</div>
</td></tr>			
<script language="JavaScript">
<!--	
MM_showHideLayers('div_<c:out value="${quohdrLineItem.quotno}"/>','','hide');
-->
</script>		
<!--eITT-200905-0003-->

				
						
<%--			<tr><td colspan="8" background="images/border_dotted.gif"></td></tr>--%>
			
          </logic:iterate>
        </table>
		</td>
    </tr>
  </table>
  </td>
  </tr>
  </table>
</div>

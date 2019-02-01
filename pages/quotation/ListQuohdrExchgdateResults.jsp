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
      <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td class="text2"><bean:message key="prompt.sortby"/>:&nbsp;
              <logic:notEqual name="ListQuohdrExchgdateForm" property="orderBy"
			scope="session" value="Quotno">
                <html:link action="/ListQuohdrExchgdate?orderBy=Quotno&gotoPage=0" styleClass="link6">
                  <bean:message key="prompt.quotno"/>
                </html:link>
              </logic:notEqual>
              <logic:equal name="ListQuohdrExchgdateForm" property="orderBy"
			scope="session" value="Quotno"> <strong>
                <bean:message key="prompt.quotno"/>
                </strong> </logic:equal>
              <strong>&nbsp;|&nbsp;</strong>
              <logic:equal name="ListQuohdrExchgdateForm" property="orderBy"
			scope="session" value="Quotedate"> <strong>
                <bean:message key="prompt.quotedate"/>
                </strong> </logic:equal>
              <logic:notEqual name="ListQuohdrExchgdateForm" property="orderBy"
			scope="session" value="Quotedate"> <span class="link4">
                <html:link action="/ListQuohdrExchgdate?orderBy=Quotedate&gotoPage=0" styleClass="link6">
                  <bean:message key="prompt.quotedate"/>
                </html:link>
                </span> </logic:notEqual>
              <strong>&nbsp;|&nbsp;</strong>
              <logic:equal name="ListQuohdrExchgdateForm" property="orderBy"
			scope="session" value="Expirydate"> <strong>
                <bean:message key="prompt.expirydate"/>
                </strong> </logic:equal>
              <logic:notEqual name="ListQuohdrExchgdateForm" property="orderBy"
			scope="session" value="Expirydate"> <span class="link4">
                <html:link action="/ListQuohdrExchgdate?orderBy=Expirydate&gotoPage=0" styleClass="link6">
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
        		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                <tr>
                  <td class="tdwht" width="1%" colspan="5" valign="middle">			  
<table width="47%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"><tr>
<td class="tdwht">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
<td class="tdwht"><bean:message key="prompt.selectall"/>&nbsp;<html:checkbox name="ListQuohdrExchgdateForm" property="searchString15" /></td>
<td class="tdwht">&nbsp;to&nbsp;</td>
<td class="tdwht"><input name="updateButton" type="image" id="updateButton" value='<bean:message key="button.update"/>' src="images/update_button.gif"/></td>
</tr></table>
				  </td>						  	
                  <td class="tdwht" width="13%"></td>				  				  		
                  <td class="tdwht" width="10%"></td>				  
                  <td class="tdwht" width="10%"></td>
                  <td class="tdwht" width="10%"></td>
                  <td class="tdwht" width="10%"></td>
                </tr>
                <tr>
                  <td class="tddkgry" width="1%">&nbsp;</td>				
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.quotno"/></span></td>
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.quotedate"/></span></td>
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="heading.quotecurrency"/></span></td>
                  <td class="tddkgry" width="10%"><span class="heading4">Exchange Rate Date</span></td>				  
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="prompt.chargetotal"/></span></td>
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="prompt.costtotal"/></span></td>
                  <td class="tddkgry" width="10%"><span class="heading4"><bean:message key="prompt.profit"/></span></td>
                  <td class="tddkgry" width="10%"><span class="heading4">New Exchange Rate Date</span></td>				  
                  <td class="tddkgry" width="10%"><span class="heading4">New Charge Total</span></td>
                  <td class="tddkgry" width="10%"><span class="heading4">New Cost Total</span></td>
                  <td class="tddkgry" width="10%"><span class="heading4">New Profit</span></td>				  
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListQuohdrExchgdateForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry2"; 
row++;
%>
                  <!-- row1 -->
                  <tr>
<td class="<%= _class %>" width="1%" align="left" nowrap="nowrap">				  
<html:multibox property="selectedObjects"><bean:write name="lineItem" property="cell2" /></html:multibox>
</td>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
						<bean:write name="lineItem" property="cell3" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
						<bean:write name="lineItem" property="cell4" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
						<bean:write name="lineItem" property="cell6" filter="true"/>
					</td>					
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
						<bean:write name="lineItem" property="cell5" filter="true"/>
					</td>
                    <td class="<%= _class %>" width="10%" align="right" nowrap>
						<bean:write name="lineItem" property="cell7" filter="true"/>					
					</td>
                    <td class="<%= _class %>" width="10%" nowrap align="right">
						<bean:write name="lineItem" property="cell9" filter="true"/>					
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap align="right">
						<bean:write name="lineItem" property="cell11" filter="true"/>                    
					</td>
                    <td class="<%= _class %>" width="10%" nowrap align="left">
						<bean:write name="lineItem" property="cell13" filter="true"/>					
					</td>					
                    <td class="<%= _class %>" width="10%" nowrap align="right">
						<bean:write name="lineItem" property="cell8" filter="true"/>					
					</td>
                    <td class="<%= _class %>" width="10%" nowrap align="right">
						<bean:write name="lineItem" property="cell10" filter="true"/>					
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap align="right">
						<bean:write name="lineItem" property="cell12" filter="true"/>                    
					</td>					
                  </tr>
                  <!-- row2 -->
					<tr><td colspan="12" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table>		
			</td>
    	</tr>
  </table>
</div>

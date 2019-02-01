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

<div id="results" style="position:absolute; left:200px; top:0px; width:1150px; height:650px; z-index:20; visibility: visible">
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
                    <logic:notEqual name="ListMandrhdrForm" property="orderBy"
			scope="session" value="Mandrno">
                      <html:link action="/ListMandrhdr?orderBy=Mandrno&gotoPage=0" styleClass="link6"><bean:message key="prompt.mandrno"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListMandrhdrForm" property="orderBy"
			scope="session" value="Mandrno"> <strong><bean:message key="prompt.mandrno"/></strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>
                    <logic:notEqual name="ListMandrhdrForm" property="orderBy"
			scope="session" value="Estimateref">
                      <html:link action="/ListMandrhdr?orderBy=Estimateref&gotoPage=0" styleClass="link6"><bean:message key="prompt.estimateref"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListMandrhdrForm" property="orderBy"
			scope="session" value="Estimateref"> <strong><bean:message key="prompt.estimateref"/></strong> </logic:equal>
                    <strong>&nbsp;|&nbsp;</strong>                    
                    <logic:equal name="ListMandrhdrForm" property="orderBy"
			scope="session" value="Originalestimatedate"> <strong><bean:message key="prompt.originalestimatedate"/></strong> </logic:equal>
                    <logic:notEqual name="ListMandrhdrForm" property="orderBy"
			scope="session" value="Originalestimatedate"> <span class="link4">
                      <html:link action="/ListMandrhdr?orderBy=Originalestimatedate&gotoPage=0" styleClass="link6"><bean:message key="prompt.originalestimatedate"/></html:link>
                      </span> </logic:notEqual>
                  </td>
                </tr>
              </table></td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                <tr>
                  <td align="right">&nbsp;
              <img src="images/spacer.gif" width="1" height="13" border="0"/>
                  </td>
                </tr>
              </table></td>
          </tr>
        </table>		
        		<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="resultsBgcolor1">
                <tr>			
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.mandrno"/></span></td>
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.versionno"/></span></td>
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.estimateref"/></span></td>
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.originalestimatedate"/></span></td>
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.unit"/></span></td>
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.unitstatus"/></span></td>                  
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.jobno"/></span></td>
                  <td class="td6" width="10%"><span class="heading6"><bean:message key="heading.repairstatus"/></span></td>
                  <td class="td6" width="30%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="right" class="td6">
                        <span class="heading6">
                        <html:link action="/EditMandrhdr?action=Create"><bean:message key="prompt.mandrhdr.add"/></html:link>
                        </span>
                        </td>
                      </tr>
                    </table></td>
                </tr>
<%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListMandrhdrForm" property="lineItems">
<%
String _class = "tdlghtgry4";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" nowrap="nowrap">
                    <bean:write name="lineItem" property="mandrno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap>
                    <bean:write name="lineItem" property="versionno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap>
                    <bean:write name="lineItem" property="estimateref" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap>
                 <bean:write name="lineItem" property="originalestimatedate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap>
                    <bean:write name="lineItem" property="unitkey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap>
                    <bean:write name="lineItem" property="unit.movests" filter="true"/>
                    </td>                    
                    <td class="<%= _class %>" width="10%" nowrap>
                    <bean:write name="lineItem" property="moveref" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" nowrap align="right">
                    <bean:write name="lineItem" property="mandrstatus" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="30%" align="right" valign="top" nowrap>
                    <table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="<%= _class %>" align="right">
 
<c:if test="${lineItem.lastversionflag == 'false'}">    
<html:link action="/PrintMandr.do" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.print"/></html:link>           
                      &nbsp;|&nbsp;                       
<html:link action="/EditMandrhdr.do?action=Edit" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.view"/></html:link>
</c:if>
                         
<c:if test="${lineItem.lastversionflag == 'true'}">                           
<html:link action="/PrintMandr.do" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.print"/></html:link>           
                      &nbsp;|&nbsp;
<html:link action="/EditMandrhdr.do?action=Edit" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditMandrhdr.do?action=Copy" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.copy"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditMandrhdr.do?action=Delete" paramId="id" paramName="lineItem" paramProperty="mandrhdrId">
<bean:message key="prompt.delete"/> 
</html:link>
</c:if>
 
                          </td>
                        </tr>
                        <tr>
                          <td class="<%= _class %>" align="right">
                          
<html:link action="/ListMandrdtl.do" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.details"/></html:link> 
<c:if test="${lineItem.lastversionflag == 'true'}">   																								
&nbsp;|&nbsp;
<html:link action="/EditMandrhdr.do?action=CopyVersion" paramId="id" paramName="lineItem" paramProperty="mandrhdrId"><bean:message key="prompt.newversion"/></html:link> 
</c:if>
                            
                          </td>
                        </tr>                        
                      </table>
                      </td>
                  </tr>
                  
                  <!-- row2 -->
					<tr><td colspan="9" background="images/border_dotted.gif"></td></tr>	
                    			  
                </logic:iterate>
              </table></td>
          </tr>
        </table>		
			</td>
    	</tr>
  </table>
</div>

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

<div id="results" style="OVERFLOW:auto; position:absolute; left:200px; top:0px; width:1150px; height:650px; z-index:20; visibility: visible">

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
                    <logic:notEqual name="ListDsingateForm" property="orderBy"
			scope="session" value="Eirin">
                      <html:link action="/ListDsingate?orderBy=Eirin&gotoPage=0" styleClass="link6"><bean:message key="prompt.eirno"/></html:link>
                    </logic:notEqual>
                    <logic:equal name="ListDsingateForm" property="orderBy"
			scope="session" value="Eirin"> <strong><bean:message key="prompt.eirno"/></strong> </logic:equal>
<strong>&nbsp;|&nbsp;</strong>
                    <logic:equal name="ListDsingateForm" property="orderBy"
			scope="session" value="Indate"> <strong><bean:message key="prompt.indate"/></strong> </logic:equal>
                    <logic:notEqual name="ListDsingateForm" property="orderBy"
			scope="session" value="Indate"> <span class="link4">
                      <html:link action="/ListDsingate?orderBy=Indate&gotoPage=0" styleClass="link6"><bean:message key="prompt.indate"/></html:link>
                      </span> 
                      </logic:notEqual>
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
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="resultsBgcolor99">
                <tr>			
                  <td class="resultsHeader99" width="10%"><bean:message key="heading.eirno"/></td>
                  <td class="resultsHeader99" width="10%"><bean:message key="heading.eirnover"/></td>                  
                  <td class="resultsHeader99" width="10%"><bean:message key="heading.indate"/></td>		                  	
                  <td class="resultsHeader99" width="20%"><bean:message key="heading.customer"/></td>			  			
                                    <td class="resultsHeader99" width="20%"><bean:message key="heading.depot"/></td>		  			
                  <td class="resultsHeader99" width="15%">
				  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                      <tr>
                        <td align="left" class="resultsHeader99"><bean:message key="heading.action"/>
                        </td>
                        <td align="right" class="resultsHeader99" valign="middle">
                        <html:link action="/EditDsingate?action=Create">
                        <html:img src="images/buttons/btn_add_12_12.png" alt="Add" border="0" align="middle"/>
                        </html:link>
                        <html:link action="/EditDsingate?action=Create">
                            <span style="vertical-align:middle"><bean:message key="prompt.ingate.add"/></span>
                        </html:link>
                        </td>
                      </tr>
                    </table></td>
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListDsingateForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" align="left" nowrap="nowrap">
                    <bean:write name="lineItem" property="eirno" filter="true"/>
                    </td>
                    <td class="<%= _class %>" align="left" nowrap="nowrap">
                    <bean:write name="lineItem" property="eirnover" filter="true"/>
                    </td>                    
                    <td class="<%= _class %>" align="left" nowrap>
					<bean:write name="lineItem" property="indate" format="dd-MMM-yyyy" filter="true"/>
                    </td>				
                    <td class="<%= _class %>" nowrap>
                    <bean:write name="lineItem" property="customeraddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" nowrap>
                    <bean:write name="lineItem" property="yardlocationkey.locationName" filter="true"/>
                    </td>
                    					
                    <td class="<%= _class %>" align="right" valign="top" nowrap>
                    <table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="<%= _class %>" align="right">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class %>" align="left">

                          </td>
                          <td width="90%" class="<%= _class %>" align="right">						  

<html:link action="/EditDsingate.do?action=Edit" paramId="dsingateId" paramName="lineItem" paramProperty="dsingateId"><bean:message key="prompt.edit"/></html:link>
&nbsp;|&nbsp;
<html:link action="/EditDsingate.do?action=Delete" paramId="dsingateId" paramName="lineItem" paramProperty="dsingateId">
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
					<tr><td colspan="6" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table>		
			</td>
    	</tr>
  </table>
</div>

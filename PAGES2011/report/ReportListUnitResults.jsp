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

<div id="results" style="OVERFLOW:auto; position:absolute; left:260px; top:0px; width:990px; height:650px; z-index:20; visibility: visible">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      <td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      <td valign="top">
	  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td>
<%--<img src="images/spacer.gif" height="1"/>--%>
			  </td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
<%--<img src="images/spacer.gif" height="1"/>--%>
              </table></td>
          </tr>
        </table>

					
<logic:equal name="ReportListUnitForm" property="action" value="CurrentFleetforLessee">			
        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="genesysResultsBgcolor">
                <tr>				
                  <td class="genesysResultsHeader" width="10%">
				  <bean:message key="heading.unit"/>
				  </td>
                  <td class="genesysResultsHeader" width="10%">
				  <bean:message key="heading.reference"/>
				  </td>
                  <td class="genesysResultsHeader" width="15%">
				  <bean:message key="heading.lessee"/>
				  </td>
                  <td class="genesysResultsHeader" width="15%">
<bean:message key="heading.product"/>
					</td>
                </tr>
				
<logic:present name="ReportListUnitForm" property="lineItems">
			
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ReportListUnitForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="unitkey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="moveref" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="15%" align="left" nowrap>
					<bean:write name="lineItem" property="moveaddrkey.name" filter="true"/>
                    </td>				
                    <td class="<%= _class %>" width="15%" align="left" valign="top" nowrap>
					<bean:write name="lineItem" property="moveproductkey" filter="true"/>					
					</td>
                  </tr>

				  
					<tr><td colspan="4" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>

</logic:present>				
				
              </table></td>
          </tr>
        </table>
</logic:equal>

<logic:equal name="ReportListUnitForm" property="action" value="UnitsAvailableforLeasebyEquipment">			
        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="genesysResultsBgcolor">
                <tr>				
                  <td class="genesysResultsHeader" width="20%">
				  <bean:message key="heading.unit"/>
				  </td>
                  <td class="genesysResultsHeader" width="40%">
				  <bean:message key="heading.location"/>
				  </td>
                  <td class="genesysResultsHeader" width="40%">
				  <bean:message key="prompt.equipmentparameters"/>
				  </td>		  				  
                </tr>
				
<logic:present name="ReportListUnitForm" property="lineItems">
			
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ReportListUnitForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="20%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="unitkey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="40%" align="left" nowrap>
					<bean:write name="lineItem" property="movelocationkey2.locationName" filter="true"/>
                    </td>	
                    <td class="<%= _class %>" width="40%" align="left" nowrap>
					<bean:write name="lineItem" property="eqpkeyp1" filter="true"/> / <bean:write name="lineItem" property="eqpkeyp2" filter="true"/>
                    </td>													
                  </tr>

				  
					<tr><td colspan="4" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>

</logic:present>				
				
              </table></td>
          </tr>
        </table>
</logic:equal>

<logic:equal name="ReportListUnitForm" property="action" value="UnitsAvailableforLeasebyFittings">			
        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="genesysResultsBgcolor">
                <tr>				
                  <td class="genesysResultsHeader" width="10%">
				  <bean:message key="heading.unit"/>
				  </td>
                  <td class="genesysResultsHeader" width="20%">
				  <bean:message key="heading.location"/>
				  </td>
                  <td class="genesysResultsHeader" width="10%">
				  <bean:message key="heading.fittinggroup"/>
				  </td>		
                  <td class="genesysResultsHeader" width="10%">
				  <bean:message key="heading.fittingtype"/>
				  </td>
                  <td class="genesysResultsHeader" width="50%">
				  <bean:message key="heading.fittingdescription"/>
				  </td>				  						    				  
                </tr>
				
<logic:present name="ReportListUnitForm" property="lineItems">
			
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ReportListUnitForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap" valign="top">
					<bean:write name="lineItem" property="unitkey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="20%" align="left" nowrap valign="top">
					<bean:write name="lineItem" property="movelocationkey2.locationName" filter="true"/>
                    </td>	
                    <td class="<%= _class %>" width="10%" align="left" nowrap valign="top">
					<bean:write name="lineItem" property="fitgrpkey.ldesc" filter="true"/> 
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap valign="top">
					<bean:write name="lineItem" property="fittypkey.ldesc" filter="true"/> 
                    </td>
                    <td class="<%= _class %>" width="50%" align="left">
					<bean:write name="lineItem" property="fitcoddes" filter="true"/> 
                    </td>																							
                  </tr>

				  
					<tr><td colspan="5" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>

</logic:present>				
				
              </table></td>
          </tr>
        </table>
</logic:equal>

	  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td>
<img src="images/spacer.gif" height="1"/>
			  </td>
            <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
<img src="images/spacer.gif" height="1"/>
              </table></td>
          </tr>
        </table>
						
		</td>
    </tr>
  </table>
</div>

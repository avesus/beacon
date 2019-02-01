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

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<app:checkLogon/>

<html:html>
  <head>
  <title>
  <bean:message key="billingrun.title"/>
  </title>
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  
  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
//process to place scope on Operations Tab
	function onLoad() {	
		//onLoadSidebar('menu2');								
	}
    //]]>
</script>

  </head>

  <body onLoad="onLoad();">
  <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <%-- HEADER -----------------%>
    <tr>
      <td colspan="5"><jsp:include page="/pages/header.jsp" flush="true" />
      </td>
    </tr>
    <%-- BREADCRUMBS -----------------%>
    <tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>
      <td class="tdwht" colspan="4"><span class="heading2"> <strong>
        <bean:message key="billingrun.title"/>
        </strong> </span> 
	  </td>
    </tr>
    <tr valign="top" bgcolor="#CCCCCC">
      <td height="1" colspan="5"></td>
    </tr>
    <%-- BREADCRUMBS -----------------%>
    <tr>
<%--      <td bgcolor="#CCCCCC" width="121" valign="top" align="center"><jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
      </td>--%>
	  
<%--      <td bgcolor="#eeeeee"><img src="images/spacer.gif" height="500" width="1"></td>--%>
	  
      <td>
	  
	  <div style="OVERFLOW:auto; width:1150px; height:650px; position:relative;">
	  
<html:form action="/EditBillingrun" focus="searchDate2mm">
	<html:hidden property="gotoPage" />
		  			<html:hidden property="searchDate1dd" />
						  			<html:hidden property="searchDate1mm" />
										  			<html:hidden property="searchDate1yyyy" />
													

<div id="search" style="position:absolute; left:0px; top:0px; width:200px; height:650px; z-index:10; visibility: visible;">
  <table border="0" cellpadding="1" cellspacing="2" width="100%" class="billingrunSearchBgcolor">
    <tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>
          <bean:message key="billingrun.title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td colspan="2"><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td class="billingrunSearchText">Upto <bean:message key="prompt.month"/>
        : </td>
      <td class="billingrunSearchText">Upto <bean:message key="prompt.year"/>
        : </td>		
    </tr>
    <tr>
      <td class="billingrunSearchText">
	  			<html:hidden property="searchDate2dd" />
              <html:select property="searchDate2mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>	  
      </td>
      <td class="billingrunSearchText">
              <html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>	  
      </td>	  
    </tr>
    <tr>
      <td colspan="2"><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>

    </tr>
    <tr>

    </tr>	
    <tr>
      <td colspan="2"><img src="images/spacer.gif" height="10"/></td>
    </tr>
<%--    <tr>
      <td align="left" valign="top">
		<html:select property="maxResults" styleClass="ftforminputsmall">
      		<html:options collection="pageresults" property="id.codekey" labelProperty="descr"/>
    	</html:select>	
      </td>
    </tr>	--%>	
    <tr>
      <td colspan="2"><img src="images/spacer.gif" height="10"/></td>
    </tr>
  </table>
</div>

</html:form>	

<div id="results" style="OVERFLOW:auto; position:absolute; left:200px; top:0px; width:950px; height:650px; z-index:20; visibility: visible">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      <td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      <td valign="top">

        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireResultsBgcolor">
                <tr>				
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.docid"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.docdate"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.doctype"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.contractno"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.lessee"/>
				  </td>	
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.netamount"/>
				  </td>					  		  				  				  				  
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListBillingrunForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="10%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="financehdrId" filter="true"/>
                    </td>				
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="docdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="doctypekey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="contractno" filter="true"/>
                    </td>	
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="lesseeaddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="right" nowrap>
					<bean:write name="lineItem" property="netamount" filter="true"/>
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
	  
</div>

</td>
		
<%--      <td bgcolor="#eeeeee"><img src="images/spacer.gif" height="500" width="1"></td>--%>
	  
      </td>
	  
    </tr>
    <%-- FOOTER -----------------%>
    <tr>
      <td colspan="5"><jsp:include page="/pages/footer.jsp" flush="true" />
      </td>
    </tr>
  </table>
  
  
  </body>
</html:html>

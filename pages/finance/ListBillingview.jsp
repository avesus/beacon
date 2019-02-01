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


<script language="JavaScript">
function screenRefresh() 
{
}
</script> 


<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>

 
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
  


<head><title><bean:message key="billingview.title"/></title></head>


<body onLoad="onLoad();">

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<!-- HEADER ----------------->
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>


<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>   
<span class="header2"><bean:message key="billingview.title"/></span>						
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->

    
    <tr>
	  
      <td>
	  
	  <div style="OVERFLOW:auto; width:1180px; height:650px; position:relative;">
	  
<html:form action="/ListBillingview" focus="searchDate2mm">
	<html:hidden property="gotoPage" />


<div id="search" style="position:absolute; left:0px; top:0px; width:220px; height:650px; z-index:10; visibility: visible;">
  <table border="0" cellpadding="1" cellspacing="2" width="100%" class="billingrunSearchBgcolor">
    
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    
    <tr>
      <td class="billingrunSearchText"><bean:message key="prompt.docdate"/>: </td>
    </tr>
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr>
            <td class="billingrunSearchText">&nbsp;<bean:message key="prompt.from"/>:</td>
          </tr>
          <tr>
            <td>&nbsp;<html:select property="searchDate1dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate1mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td class="billingrunSearchText">&nbsp;<bean:message key="prompt.to"/>:</td>
          </tr>
          <tr>
            <td>&nbsp;<html:select property="searchDate2dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate2mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
        </table></td>
    </tr>	
        
    
    
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>

    
<tr><td>

 <div class="btnPaneSearch">     
		<button id="reportButton" class="btn btnFF" type="submit">
        <img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        <span><bean:message key="button.search"/></span>
        </button>      

		<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='MainMenu.do'">
		<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        <span><bean:message key="button.exit"/></span>
		</button>    
 </div>
 
</td></tr>
    
  </table>
</div>

</html:form>	

<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:950px; height:650px; z-index:20; visibility: visible">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tr>
<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
      <td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>
      <td valign="top">

        <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
          <tr>
            <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireResultsBgcolor">
                <tr>				
                  <td class="onhireResultsHeader" width="5%">
				  <bean:message key="heading.docid"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.docdate"/>
				  </td>
                  <td class="onhireResultsHeader" width="7%">
				  <bean:message key="heading.doctype"/>
				  </td>
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.invoiceno"/>
				  </td>				  
                  <td class="onhireResultsHeader" width="10%">
				  <bean:message key="heading.contractno"/>
				  </td>
                  <td class="onhireResultsHeader" width="20%">
				  <bean:message key="heading.lessee"/>
				  </td>	
                  <td class="onhireResultsHeader" width="8%">
				  <bean:message key="heading.netamount"/>
				  </td>	
                  <td class="onhireResultsHeader" width="10%">&nbsp;
				  
				  </td>					  				  		  				  				  				  
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListBillingviewForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>													  
                    <td class="<%= _class %>" width="5%" align="left" nowrap="nowrap">
					<bean:write name="lineItem" property="financehdrId" filter="true"/>
                    </td>				
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="docdate" format="dd-MMM-yyyy" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="7%" align="left" nowrap>
					<bean:write name="lineItem" property="doctypekey" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="dockey" filter="true"/>
                    </td>	
                    <td class="<%= _class %>" width="10%" align="left" nowrap>
					<bean:write name="lineItem" property="contractno" filter="true"/>
                    </td>	
                    <td class="<%= _class %>" width="20%" align="left" nowrap>
					<bean:write name="lineItem" property="lesseeaddrkey.name" filter="true"/>
                    </td>
                    <td class="<%= _class %>" width="8%" align="right" nowrap>
					<bean:write name="lineItem" property="netamount" filter="true"/>
                    </td>
                          <td class="<%= _class %>" align="right">
                      <genesysapp:linkBillingviewLineItem page="/PrintBillingview.do?action=Print">
                        <bean:message key="prompt.print"/>
                      </genesysapp:linkBillingviewLineItem>						  
                          </td>																													
                  </tr>

				  
					<tr><td colspan="8" background="images/border_dotted.gif"></td></tr>				  
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
/**
 *
 * Amendments
 * ----------
 *										
 */
--%> 

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->




<script type="text/javascript" language="javascript" src="scripts/general.js"></script>

<jsp:useBean
  id="ReportLocationinventoryForm"
  class="com.bureaueye.beacon.form.report.ReportLocationinventoryForm"
  scope="session"
/>





	
	
<html:html>

  <head>
  
  <title>Inventory Report</title>
	<link rel="stylesheet" href="css/base.css" type="text/css" />
  	<link rel="stylesheet" href="css/report.css" type="text/css" />
	
  	<script language="JavaScript">
<!--	
	function doSummary() {
		document.forms[0].searchString10.value='summary';
		//return false;
		//document.submit();
	}
	function doDetail() {
		document.forms[0].searchString10.value='detail';
		//return false;
		//document.submit();
	}	
// -->		
	</script>
  
  </head>
  
  
  <body onUnload="if (searchWin != null) {searchWin.close()}">
  
  

  <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <tr>
      <td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" />
      </td>
    </tr>
    <!-- BREADCRUMBS ----------------->
    <tr>
      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>
      <td class="tdwht"><span class="heading2"> <strong>Inventory Report</strong></span>	  
	   </td>
    </tr>
    <tr valign="top" bgcolor="#CCCCCC">
      <td height="1" colspan="2"></td>
    </tr>
    <!-- BREADCRUMBS ----------------->
    <tr>
      <%-- SIDEBAR -----------------%>
      <td bgcolor="#CCCCCC" width="121" valign="top" align="center">
      </td>
      <%-- BODY -----------------%>
      <td>

          <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
            <tr>
              <td>


<html:form action="/ReportLocationinventory">
<html:hidden property="searchString10"/>
<div class="subTabNav">
<ul>
<li class="current">
<input type="submit" value="Summary View" onClick="doSummary();" name="summaryButton" id="summaryButton" />
</li>
<li>
<input type="submit" value="Detail View" onClick="doDetail();" name="detailButton" id="detailButton" disabled="true" />
</li>
</ul>
</div>
<div class="exportImg">
<INPUT name="exportSummaryButton" border="0" src="images/report/icon_mini_export.gif" type="image" align="middle" id="exportSummaryButton" title="Export Summary View" /> 
</div>
</html:form>

  
                                <div class="clearBoth"> </div>																
                                <table cellspacing="0" cellpadding="0">
<tr>
<td valign="top"><table cellspacing="0" cellpadding="0" style="table-layout:fixed;" class="matrix w1100 borderTop">


<html:form action="/ReportLocationinventory"> 
<html:hidden property="searchString10"/>                                       
<tr class="colheaders" height="120px">

<th colspan="4" width="500">

<html:select property="searchString1" styleClass="ftforminputsmall"> <html:option value=""><bean:message key="prompt.country"/></html:option> <html:options collection="countrys" property="country" labelProperty="country"/> </html:select>	


		<html:select property="searchString11" styleClass="ftforminputsmall">
			<html:option value="ALL"><bean:message key="prompt.selectaunitstatus"/></html:option>
			<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select>
        
					
<br/><span class="ftformradiosmall3">
<html:radio property="searchString3" value="N"/>
Active
<html:radio property="searchString3" value="Y"/>
Not Active</span>
&nbsp;&nbsp;
<div style="text-align:right">
<INPUT name="refreshButton" border="0" type="image" src="images/report/refreshButtonBorderGrey.gif" align="bottom" id="refreshButton" title="Reload Data" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('refreshButton','','images/report/refreshButtonBorderGrey.gif','refreshButton','','images/report/refreshButtonBorderGrey_over_blue.gif',1);"/></div>


</th>


<c:set var="_colcount" value="0"/>
<%
//get inventory Y hashtable
java.util.TreeMap _tmY =
	(java.util.TreeMap)ReportLocationinventoryForm.getInventoryY1();
for (java.util.Iterator it = _tmY.keySet().iterator(); it.hasNext();) {
	java.lang.Object _tmYkey = (java.lang.Object)it.next();	
	java.util.List _listY =	(java.util.List)_tmY.get(_tmYkey);	
%>
				<c:set var="_colcount" value="${_colcount+1}"/>
				<c:set var="_class" value=""/>	
				<c:if test="${_colcount % 2 == 0}">
					<c:set var="_class" value="highlightcol"/>			
				</c:if>
								
<th class='<c:out value="${_class}"/>' colspan='<%= _listY.size() %>'><span class="small">
<%= _tmYkey %>
</span></th>	

<%
}
%>

<c:set var="_colcount" value="${_colcount*2}"/>
<c:set var="_class" value=""/>	
<c:if test="${_colcount % 2 == 0}">
	<c:set var="_class" value="highlightcol2"/>			
</c:if>
<th class='<c:out value="${_class}"/>' width="100"><span class="small">TOTAL</span></th>
</tr>
</html:form>


<% int _colspan2=5; %>
<c:set var="_colcount" value="0"/>
<%
//get inventory Y hashtable
java.util.TreeMap _tmY =
	(java.util.TreeMap)ReportLocationinventoryForm.getInventoryY1();
%>
	
<tr class="colheaders">
							
<%
for (java.util.Iterator it = _tmY.keySet().iterator(); it.hasNext();) {
	java.lang.Object _tmYkey = (java.lang.Object)it.next();	
	java.util.List _listY =	(java.util.List)_tmY.get(_tmYkey);	
%>
				<c:set var="_colcount" value="${_colcount+1}"/>
				<c:set var="_class" value=""/>	
				<c:if test="${_colcount % 2 == 0}">
					<c:set var="_class" value="highlightcol"/>			
				</c:if>
<%	
	for (java.util.Iterator it2 = _listY.iterator(); it2.hasNext();) {
		com.bureaueye.beacon.bean.LabelValue _labelvalueY = (com.bureaueye.beacon.bean.LabelValue)it2.next();	
%>
								
<%--<th class='<c:out value="${_class}"/>' colspan='1'><span class="small">
<%= _labelvalueY.getLabel() %>
</span></th>--%>

<% _colspan2=_colspan2+1; %>	
<%
	}
}
%>

</tr>

<% String _locationOldValue = ""; %>
<logic:iterate id="lineItemX" name="ReportLocationinventoryForm" property="inventoryX" indexId="loopX">

<%
com.bureaueye.beacon.bean.LabelValue _labelvalueX = 
	(com.bureaueye.beacon.bean.LabelValue)lineItemX;

	java.util.StringTokenizer _st = new java.util.StringTokenizer(_labelvalueX.getLabel(), "|");	
	String _locationNewValue = "";
	try {_locationNewValue = _st.nextToken();} catch (Exception e) {}
	//check location break
	if (!_locationOldValue.equals(_locationNewValue)) {
		 _locationOldValue=_locationNewValue;	
out.print("<tr class='coldetails'><td colspan='"+_colspan2+"' class='break'></td></tr>");
	}
%>	



				
<tr class="coldetails">
<c:set var="_tokencount" value="0"/>
<c:forTokens var="tokenX" items="${lineItemX.label}" delims="|">	
				<c:set var="_tokencount" value="${_tokencount+1}"/>	
				<c:set var="_colspan" value="3"/>	
				<c:if test="${_tokencount == 1}">
					<c:set var="_colspan" value="1"/>		
				</c:if>	

								
										
<td width="200" colspan='<c:out value="${_colspan}"/>'>	
<div class="detail3">
<%
// if ALL selected allow drill-down to details by location
if (
	ReportLocationinventoryForm.getSearchString11().equals("ALL") &&
	ReportLocationinventoryForm.getSearchString1().equals("")
	) {
%>
<html:form action="/ReportLocationinventory"> 
 	<input border='0' type='submit'  value='<c:out value="${tokenX}"/>'/>
 	<input type='hidden' name='searchString10' value='detail'>	
	<input type='hidden' name='searchString4' value='key<c:out value="${_tokencount}"/>'>
	<input type='hidden' name='orderBy' value='unit.Unitkey'>
	<input type='hidden' name='orderByDesc' value=''>
	<input type='hidden' name='searchString5' value='<%= _labelvalueX.getValue() %>'> 
	<html:hidden property="searchString1"/> 
	<html:hidden property="searchString11"/>	
	<html:hidden property="searchString3"/> 		
</html:form>
<%
} else {
%>
<c:out value="${tokenX}"/>
<%
}
%>				
</div>
</td>
</c:forTokens>



<c:set var="_colcount" value="0"/>
<% int _counttotal=0; %>
<!-- TODO: code to find count values -->
<%
for (java.util.Iterator it = _tmY.keySet().iterator(); it.hasNext();) {
	java.lang.Object _tmYkey = (java.lang.Object)it.next();	
	java.util.List _listY =	(java.util.List)_tmY.get(_tmYkey);	
%>
				<c:set var="_colcount" value="${_colcount+1}"/>
				<c:set var="_class" value=""/>	
				<c:if test="${_colcount % 2 == 0}">
					<c:set var="_class" value="highlightcol"/>			
				</c:if>
<%	
	for (java.util.Iterator it2 = _listY.iterator(); it2.hasNext();) {
		com.bureaueye.beacon.bean.LabelValue _labelvalueY = (com.bureaueye.beacon.bean.LabelValue)it2.next();	
%>

<%
String _keycol0=_labelvalueX.getValue()+"|"+_labelvalueY.getValue();	
//get count value from inventory table
com.bureaueye.beacon.model.report.dto.LocationinventoryDTO _dto0 =
	(com.bureaueye.beacon.model.report.dto.LocationinventoryDTO)ReportLocationinventoryForm
		.getInventoryHt()
		.get(_keycol0);	
int _countcol0=0;
try{_countcol0=_dto0.getCount().intValue();}catch(Exception e){}	
_counttotal=_counttotal+_countcol0;	
		

				
%>

<td class='<c:out value="${_class}"/>'><div class="detail2">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='<%= _countcol0 %>'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='searchString4' value='key3'>
	<input type='hidden' name='orderBy' value='unit.Unitkey'>
	<input type='hidden' name='orderByDesc' value=''>
	<input type='hidden' name='searchString5' value='<%= _keycol0 %>'>
	<html:hidden property="searchString1"/> 
	<html:hidden property="searchString11"/>	
	<html:hidden property="searchString3"/>	 	
</html:form>
</div></td>

<%
	}
}
%>


<c:set var="_class" value="highlightcol2"/>
<td width="100" class='<c:out value="${_class}"/>'><div class="detail4"><span class="normal"><strong><%= _counttotal %></strong></span></div></td>
</tr>


				
</logic:iterate>

                                        
										
										
                                      </table></td>
                                  </tr>
                                </table>
                                <div class="clearBoth"> </div>						
								
								

              </td>
            </tr>
          </table>

		</td>
    </tr>
    <tr>
      <td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" />
      </td>
    </tr>
  </table>


  </body>
</html:html>

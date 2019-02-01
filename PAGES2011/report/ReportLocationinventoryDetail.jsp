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
	
	<script type="text/javascript" src="scripts/report/nicetitle.js"></script>
		
  	<script language="JavaScript">
<!--	
	function doSummary() {
		document.forms[0].searchString10.value='summary';
		//document.submit();
	}
	function doDetail() {
		document.forms[0].searchString10.value='detail';
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
      <td class="tdwht">
	  <span class="heading2"> <strong>Inventory Report</strong> </span>&nbsp;&nbsp;
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
<html:hidden property="searchString1"/> 
<html:hidden property="searchString11"/> 
<div class="subTabNav">
<ul>
<li>
<input type="submit" value="Summary View" onClick="doSummary();" name="summaryButton" id="summaryButton" />
</li>
<li class="current">
<input type="submit" value="Detail View" onClick="doDetail();" name="detailButton" id="detailButton" />
</li>
</ul>
</div>
<div class="exportImg">
<INPUT name="exportDetailButton" border="0" src="images/report/icon_mini_export.gif" type="image" align="middle" id="exportDetailButton" title="Export Detail View" /> 
</div>
</html:form>

  
                                <div class="clearBoth"> </div>																
                                <table cellspacing="0" cellpadding="0">
                                  <tr>
                                    <td valign="top"><table cellspacing="0" cellpadding="0" style="table-layout:fixed;" class="matrix w1100 borderTop">
                                        
<%
String _orderByDesc=ReportLocationinventoryForm.getOrderByDesc();
// swap for new sort
if (_orderByDesc.equals("")) _orderByDesc="Desc"; else _orderByDesc="";
%>
										
<tr class="colheaderDetails">
<th class="" width="130">
<div class="header1">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='Unit Number'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='orderBy' value='unit.Unitkey'>
	<input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'> 	
</html:form>
<c:if test="${ReportLocationinventoryForm.orderBy=='unit.Unitkey'}">
	<c:if test="${ReportLocationinventoryForm.orderByDesc==''}">
		<html:img src='images/report/sortAsc.gif' border='0'/>
	</c:if>
	<c:if test="${ReportLocationinventoryForm.orderByDesc=='Desc'}">
		<html:img src='images/report/sortDesc.gif' border='0'/>
	</c:if>
</c:if>
</div>

</th>
<th class="" width="230">
<div class="header1">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='Location'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='orderBy' value='location.LocationName'>
	<input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'> 	
</html:form>
<c:if test="${ReportLocationinventoryForm.orderBy=='location.LocationName'}">
	<c:if test="${ReportLocationinventoryForm.orderByDesc==''}">
		<html:img src='images/report/sortAsc.gif' border='0'/>
	</c:if>
	<c:if test="${ReportLocationinventoryForm.orderByDesc=='Desc'}">
		<html:img src='images/report/sortDesc.gif' border='0'/>
	</c:if>
</c:if>
</div>
</th>
<th class="" width="95">
<div class="header1">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='Status'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='orderBy' value='unit.Status'>
	<input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'> 	
</html:form>
<c:if test="${ReportLocationinventoryForm.orderBy=='unit.Status'}">
	<c:if test="${ReportLocationinventoryForm.orderByDesc==''}">
		<html:img src='images/report/sortAsc.gif' border='0'/>
	</c:if>
	<c:if test="${ReportLocationinventoryForm.orderByDesc=='Desc'}">
		<html:img src='images/report/sortDesc.gif' border='0'/>
	</c:if>
</c:if>
</div>
</th>
<th class="" width="60">
<div class="header1">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='IMO'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='orderBy' value='unit.Imokey'>
	<input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'> 	
</html:form>
<c:if test="${ReportLocationinventoryForm.orderBy=='unit.Imokey'}">
	<c:if test="${ReportLocationinventoryForm.orderByDesc==''}">
		<html:img src='images/report/sortAsc.gif' border='0'/>
	</c:if>
	<c:if test="${ReportLocationinventoryForm.orderByDesc=='Desc'}">
		<html:img src='images/report/sortDesc.gif' border='0'/>
	</c:if>
</c:if>
</div>
</th>

<th class="" width="100">
<div class="header1">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='Capacity'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='orderBy' value='unit.Capusg'>
	<input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'> 	
</html:form>
<c:if test="${ReportLocationinventoryForm.orderBy=='unit.Capusg'}">
	<c:if test="${ReportLocationinventoryForm.orderByDesc==''}">
		<html:img src='images/report/sortAsc.gif' border='0'/>
	</c:if>
	<c:if test="${ReportLocationinventoryForm.orderByDesc=='Desc'}">
		<html:img src='images/report/sortDesc.gif' border='0'/>
	</c:if>
</c:if>
</div>
</th>	
<th class="" width="110">
<div class="header1">
<html:form action="/ReportLocationinventory"> 
 <input border='0' type='submit'  value='Tare Weight'/>
 	<input type='hidden' name='searchString10' value='detail'>
	<input type='hidden' name='orderBy' value='unit.Tare'>
	<input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'> 	
</html:form>
<c:if test="${ReportLocationinventoryForm.orderBy=='unit.Tare'}">
	<c:if test="${ReportLocationinventoryForm.orderByDesc==''}">
		<html:img src='images/report/sortAsc.gif' border='0'/>
	</c:if>
	<c:if test="${ReportLocationinventoryForm.orderByDesc=='Desc'}">
		<html:img src='images/report/sortDesc.gif' border='0'/>
	</c:if>
</c:if>
</div>
</th>	

<th class="" width="100">	
Active
</th>

				
</tr>


<logic:iterate id="lineItem" name="ReportLocationinventoryForm" property="list" indexId="loop">

<tr class="coldetails">	
	<input type='hidden' name='loop' value='<c:out value="${loop}"/>'>
	<input type='hidden' name='demfreedays' value='<c:out value="${lineItem.demfreedays}"/>'>
	<input type='hidden' name='poddateactual' value='<c:out value="${lineItem.poddateactual}"/>'>
	<input type='hidden' name='movref' value='<c:out value="${lineItem.movref}"/>'>
<td class='highlightcol'>
	
<div class="detail">
<span class="normal top">

<c:out value="${lineItem.tanknumber}"/></span>
</div>
													
</td>

<td class='highlightcol'>	
<div class="detail"><span class="normal"><c:out value="${lineItem.locationname}"/></span></div>													
</td>
<td class='highlightcol'>	
<div class="detail"><span class="normal"><c:out value="${lineItem.status}"/></span></div>													
</td>
<td class='highlightcol'>	
<div class="detail"><span class="normal"><c:out value="${lineItem.imo}"/></span></div>													
</td>

<td class='highlightcol'>	
<div class="detail"><span class="normal">
<c:out value="${lineItem.capacity}"/> 
</span></div>													
</td>
<td class='highlightcol'>	
<div class="detail"><span class="normal">
<c:out value="${lineItem.tareweight}"/> 
</span></div>													
</td>


<td class='highlightcol'>	
<div class="detail"><span class="normal">
<c:if test="${lineItem.active=='Y'}">YES</c:if>
<c:if test="${lineItem.active=='N'}">NO</c:if>
</span></div>												
</td>








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

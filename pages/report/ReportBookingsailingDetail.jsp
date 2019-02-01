<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *				
--%>

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->




<script type="text/javascript" language="javascript" src="scripts/general.js"></script>

<jsp:useBean
  id="ReportForm"
  class="com.bureaueye.beacon.form.report.ReportForm"
  scope="session"
/>


<html:html>

  <head>
  
  <title>Booking Vs Sailing Report</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

  	<link rel="stylesheet" href="css/report.css" type="text/css" />
    
    
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
      <td class="tdwht"><span class="heading2"> <strong>Booking vs Sailing Report</strong> </span>&nbsp;&nbsp; </td>
    </tr>
    <tr valign="top" bgcolor="#CCCCCC">
      <td height="1" colspan="2"></td>
    </tr>
    <!-- BREADCRUMBS ----------------->
    <tr>
      <%-- SIDEBAR -----------------%>
      <td bgcolor="#CCCCCC" width="121" valign="top" align="center"></td>
      <%-- BODY -----------------%>
      <td><table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td><html:form action="/ReportBookingsailing">
                <html:hidden property="searchString1"/>
                <html:hidden property="searchString2"/>
                <html:hidden property="searchString3"/>
                <html:hidden property="searchString4"/>
                <html:hidden property="searchString5"/>
                <html:hidden property="searchString6"/>
                <html:hidden property="searchString7"/>
                <html:hidden property="searchString8"/>
                <html:hidden property="searchString10"/>
                <html:hidden property="searchString11"/>
                <html:hidden property="searchString12"/>
                <html:hidden property="searchString13"/>				
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
<%--                <div class="exportImg">
                  <INPUT name="exportDetailButton" border="0" src="images/report/icon_mini_export.gif" type="image" align="middle" id="exportDetailButton" title="Export Detail View" />
                </div>--%>
              </html:form>
              <div class="clearBoth"> </div>
              <table cellspacing="0" cellpadding="0">
                <tr>
                  <td valign="top"><table cellspacing="0" cellpadding="0" style="table-layout:fixed;" class="matrix w1400 borderTop">
                      <%
String _orderByDesc=ReportForm.getOrderByDesc();
// swap for new sort
if (_orderByDesc.equals("")) _orderByDesc="Desc"; else _orderByDesc="";
%>
                      <tr class="colheaderDetails">
                        <th class="" width="100"> <div class="header1">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='Job Number'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'>
                            </html:form>
                            <c:if test="${ReportForm.orderBy=='jobhdr.Jobno'}">
                              <c:if test="${ReportForm.orderByDesc==''}">
                                <html:img src='images/report/sortAsc.gif' border='0'/>
                              </c:if>
                              <c:if test="${ReportForm.orderByDesc=='Desc'}">
                                <html:img src='images/report/sortDesc.gif' border='0'/>
                              </c:if>
                            </c:if>
                          </div></th>
                        <th class="" width="100"> <div class="header1">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='Order Number'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='orderBy' value='orderhdr.Orderno'>
                              <input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'>
                            </html:form>
                            <c:if test="${ReportForm.orderBy=='orderhdr.Orderno'}">
                              <c:if test="${ReportForm.orderByDesc==''}">
                                <html:img src='images/report/sortAsc.gif' border='0'/>
                              </c:if>
                              <c:if test="${ReportForm.orderByDesc=='Desc'}">
                                <html:img src='images/report/sortDesc.gif' border='0'/>
                              </c:if>
                            </c:if>
                          </div></th>
                        <th class="" width="100"> <div class="header1">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='Unit'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='orderBy' value='unit.Unitkey'>
                              <input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'>
                            </html:form>
                            <c:if test="${ReportForm.orderBy=='unit.Unitkey'}">
                              <c:if test="${ReportForm.orderByDesc==''}">
                                <html:img src='images/report/sortAsc.gif' border='0'/>
                              </c:if>
                              <c:if test="${ReportForm.orderByDesc=='Desc'}">
                                <html:img src='images/report/sortDesc.gif' border='0'/>
                              </c:if>
                            </c:if>
                          </div></th>                                                       
                        <th class="" width="440"> <div class="header1">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='Customer'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='orderBy' value='customer.Name'>
                              <input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'>
                            </html:form>
                            <c:if test="${ReportForm.orderBy=='customer.Name'}">
                              <c:if test="${ReportForm.orderByDesc==''}">
                                <html:img src='images/report/sortAsc.gif' border='0'/>
                              </c:if>
                              <c:if test="${ReportForm.orderByDesc=='Desc'}">
                                <html:img src='images/report/sortDesc.gif' border='0'/>
                              </c:if>
                            </c:if>
                          </div></th> 

                        <th class="" width="120"> Book Date </th> 
                        <th class="" width="120"> Est Sail Date </th>  
                        <th class="" width="120"> Act Sail Date </th>  
                                                                          
                        <th class="" width="200"> <div class="header1">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='Port of Loading'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='orderBy' value='fromlocation.PortUnicon'>
                              <input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'>
                            </html:form>
                            <c:if test="${ReportForm.orderBy=='pol.description1'}">
                              <c:if test="${ReportForm.orderByDesc==''}">
                                <html:img src='images/report/sortAsc.gif' border='0'/>
                              </c:if>
                              <c:if test="${ReportForm.orderByDesc=='Desc'}">
                                <html:img src='images/report/sortDesc.gif' border='0'/>
                              </c:if>
                            </c:if>
                          </div></th>
                        <th class="" width="200"> <div class="header1">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='Port of Destination'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='orderBy' value='tolocation.PortUnicon'>
                              <input type='hidden' name='orderByDesc' value='<%= _orderByDesc %>'>
                            </html:form>
                            <c:if test="${ReportForm.orderBy=='pod.description1'}">
                              <c:if test="${ReportForm.orderByDesc==''}">
                                <html:img src='images/report/sortAsc.gif' border='0'/>
                              </c:if>
                              <c:if test="${ReportForm.orderByDesc=='Desc'}">
                                <html:img src='images/report/sortDesc.gif' border='0'/>
                              </c:if>
                            </c:if>
                          </div></th>
                                                                        
                        <th class="" width="120"> Total Revenue </th>
                        <th class="" width="120"> Total Cost </th>                        
                        <th class="" width="120"> Gross Profit </th>
                        
                      </tr>
                      
                      
                      <c:forEach var="lineItem" items="${ReportForm.lineItems[0]}" varStatus="loop">
                        <tr class="coldetails">
                          <input type='hidden' name='loop' value='<c:out value="${loop}"/>'>
                          <input type='hidden' name='poldateest' value='<c:out value="${lineItem.poldateest}"/>'>
                          <input type='hidden' name='poldateact' value='<c:out value="${lineItem.poldateact}"/>'>
                          <input type='hidden' name='createdate' value='<c:out value="${lineItem.createdate}"/>'>
                          <td class='highlightcol'><div class="detail"><span class="normal">
                              <c:out value="${lineItem.jobno}"/>
                              </span></div></td>
                          <td class='highlightcol'><div class="detail"><span class="normal">
                              <c:out value="${lineItem.orderno}"/>
                              </span></div></td>  
                          <td class='highlightcol'><div class="detail"><span class="normal">
                              <c:out value="${lineItem.unitkey}"/>
                              </span></div></td>                                                            
                          <td class='highlightcol'><div class="detail"><span class="normal">
                              <c:out value="${lineItem.customer}"/>
                              </span></div></td>

                          <td class='highlightcol' nowrap><div class="detail"><span class="normal">
                             <bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy"/>
                              </span></div></td>
                          <td class='highlightcol' nowrap><div class="detail"><span class="normal">
                             <bean:write name="lineItem" property="poldateest" format="dd-MMM-yyyy"/>
                              </span></div></td>
                          <td class='highlightcol' nowrap><div class="detail"><span class="normal">
                             <bean:write name="lineItem" property="poldateact" format="dd-MMM-yyyy"/>
                              </span></div></td>
                                                                                                                        
                          <td class='highlightcol' nowrap><div class="detail"><span class="normal">
                              <c:out value="${lineItem.polname}"/><br/>
                              Country: <c:out value="${lineItem.polcountry}"/><br/>
							  City: <c:out value="${lineItem.polcity}"/><br/>
							  Port Unicon: <c:out value="${lineItem.polportunicon}"/><br/>
                              </span></div></td>
                          <td class='highlightcol' nowrap><div class="detail"><span class="normal">
						                                <c:out value="${lineItem.podname}"/><br/>
                              Country: <c:out value="${lineItem.podcountry}"/><br/>
							  City: <c:out value="${lineItem.podcity}"/><br/>
							  Port Unicon: <c:out value="${lineItem.podportunicon}"/><br/>
                              </span></div></td>
                          <td class='highlightcol' nowrap><div class="detail5"><span class="normal">
                              <fmt:formatNumber 
							type="number"
							value="${lineItem.revenue}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>
                              &nbsp;
                              <c:out value="${lineItem.rateccykey}"/>                            
                              </span></div></td>
                          <td class='highlightcol' nowrap><div class="detail5"><span class="normal">
                              <fmt:formatNumber 
							type="number"
							value="${lineItem.quohdrcosttotal}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>
                              &nbsp;
                              <c:out value="${lineItem.rateccykey}"/>                            
                              </span></div></td>                              
                          <td class='highlightcol' nowrap><div class="detail5"><span class="normal">
                              <fmt:formatNumber 
							type="number"
							value="${lineItem.grossprofit}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>
                            &nbsp;
                              <c:out value="${lineItem.quohdrccykey}"/>                          
                              </span></div></td>
                        </tr>
                        <c:set var="numberoftanksTotal" value="${numberoftanksTotal + lineItem.numberoftanks}"/>                        
                        <c:set var="revenueTotal" value="${revenueTotal + lineItem.revenue}"/>
                        <c:set var="grossprofitTotal" value="${grossprofitTotal + lineItem.grossprofit}"/>
                        <c:set var="revenueBaseTotal" value="${revenueBaseTotal + lineItem.revenuebase}"/>
                        <c:set var="costBaseTotal" value="${costBaseTotal + lineItem.quohdrcosttotal}"/>                        
                        <c:set var="grossprofitBaseTotal" value="${grossprofitBaseTotal + lineItem.grossprofitbase}"/>
                        <c:set var="shipmentsCount" value="${shipmentsCount + 1}"/>
                      </c:forEach>
                      
                      <tr class="colfooterDetails">
                        <th class="" colspan="9"> <div align="left">Total (<c:out value="${ReportForm.headerInfo5}"/>)</div></th>
                        </th>
                        <th class=""> 
                                <fmt:formatNumber 
								type="number"
								value="${revenueBaseTotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>      
                        </th>
                        <th class=""> 
                                <fmt:formatNumber 
								type="number"
								value="${costBaseTotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>      
                        </th>                        
                        <th class="">
<fmt:formatNumber 
								type="number"
								value="${grossprofitBaseTotal}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>                               
                        </th>
                      </tr>
                      <c:set var="revenueAverage" value="${revenueTotal div numberoftanksTotal}"/>
                      <c:set var="revenueBaseAverage" value="${revenueBaseTotal div numberoftanksTotal}"/>
                      <c:set var="costBaseAverage" value="${costBaseTotal div numberoftanksTotal}"/>                      
                      <c:set var="grossprofitAverage" value="${grossprofitTotal div numberoftanksTotal}"/>
                      <c:set var="grossprofitBaseAverage" value="${grossprofitBaseTotal div numberoftanksTotal}"/>                      
                      <tr class="colfooterDetails">
                        <th class="" colspan="9"> <div align="left">Average per Tank (<c:out value="${ReportForm.headerInfo5}"/>)</div></th>
                        <th class=""> 
<fmt:formatNumber 
								type="number"
								value="${revenueBaseAverage}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>                             
                        </th>
                        <th class=""> 
<fmt:formatNumber 
								type="number"
								value="${costBaseAverage}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>                             
                        </th>                        
                        <th class=""> 
<fmt:formatNumber 
								type="number"
								value="${grossprofitBaseAverage}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>                                    
                        </th>
                      </tr>
                    </table></td>
                </tr>
              </table>
              <div class="clearBoth"> </div></td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" />
      </td>
    </tr>
  </table>
  </body>
</html:html>

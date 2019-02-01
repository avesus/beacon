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
<app:checkLogon/>
<html:html>
  <head>
  <title>Time Tracking</title>
  
  	<link rel="stylesheet" type="text/css" href="css/base.css" />
	<link rel="stylesheet" type="text/css" href="css/nicetitle.css" />
  	<script type="text/javascript" src="scripts/nicetitle.js"></script>

<style type="text/css">
.text89 { font-family: Verdana, Arial, Helvetica;font-size: 10px; font-weight: normal; color: black; background:#ffffff; line-height: 20px; padding:2px 2px 2px 2px}
.text99 { font-family: Verdana, Arial, Helvetica;font-size: 8px; font-weight: normal; color: black; background:#F2F4F3; line-height: 20px; padding:2px 2px 2px 2px}
.text109 { font-family: Verdana, Arial, Helvetica;font-size: 8px; font-weight: normal; color: black; background:#cccccc; line-height: 20px; padding:2px 2px 2px 2px}		
.text119 { font-family: Verdana, Arial, Helvetica;font-size: 8px; font-weight: normal; color: black; background:#f8f8f8; line-height: 20px; padding:2px 2px 2px 2px}
</style>
  
  </head>
  <body>
  <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <!-- HEADER ----------------->
    <tr>
      <td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" />
      </td>
    </tr>
    <!-- BREADCRUMBS ----------------->
    <tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>
      <td class="tdwht"><span class="heading2"> <strong>Time Tracking</strong> </span> </td>
    </tr>
    <tr valign="top" bgcolor="#CCCCCC">
      <td height="1" colspan="2"></td>
    </tr>
    <!-- BREADCRUMBS ----------------->
    <tr>
    
    <!-- SIDEBAR ----------------->
<%--    <td bgcolor="#CCCCCC" width="121" valign="top" align="center">&nbsp;</td>--%>
    <!-- BODY ----------------->
	
	
    <td>
    
    <div style="OVERFLOW:auto; width:1150px; height:650px; position:relative;">
    
    <table border="0" cellpadding="5" cellspacing="10" width="100%" bgcolor="#ffffff">
      <tr>
      <td>
      
      <html:form action="/ListTimetrack" focus="searchString1">      
      <html:hidden property="gotoPage" />
	  
	  
      <table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
        <tr>
        <td>
        
        <table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
          <tr>
            <td align="center">
			<table border="0" cellpadding="0" cellspacing="1" width="60%" bgcolor="#D7D8D9">
                <tr>
                  <td><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
                      <tr>
                        <td align="left"><INPUT type="image" id="previousButton" name="previousButton" src="images/arrow_previous.gif"/>
                        </td>
                        <td align="center">
						<table border="0" cellpadding="0" cellspacing="0" width="60%">
							<tr>
								<td align="right" class="text8" width="30%">
									Tank:
								</td>
								<td>
						    		<html:text property="searchString1" size="30" maxlength="20" styleClass="ftforminputsmall"/>
								</td>
								<td align="left" valign="middle"> 
<INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>
								</td>							
								<td align="right" class="text8">
								&nbsp;Span:
								</td>							
								<td width="70%">
							<html:select property="maxResults" styleClass="ftforminputsmall">
                            <html:option value="5">5 Days</html:option>
                            <html:option value="10">10 Days</html:option>
                            <html:option value="15">15 Days</html:option>
                            <html:option value="20">20 Days</html:option>
                            <html:option value="30">30 Days</html:option>
                          	</html:select>
                        		</td>
							</tr>
							<tr>
								<td align="right" class="text8" width="30%">&nbsp;

								</td>
								<td colspan="4" class="text8">
Enter '%' to see all Units
								</td>
							</tr>							
							</table>
							</td>
                        <td align="right"><INPUT type="image" id="nextButton" name="nextButton" src="images/arrow_next.gif"/>
                        </td>
                      </tr>
                    </table></td>
                </tr>
              </table>
			  </td>
          </tr>
		  
          <tr>          
          <td>
          
          <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
            <c:set var="_colspanheader" value="${ListTimetrackForm.headerInfo1 / ListTimetrackForm.maxResults}"/>
            <tr>
              <td width="10%">
			  <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#D7D8D9">
                  <tr>
                    <td>
					<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
                        <tr>
                          <td class="text89" align="center"><strong>Unit</strong> </td>
                        </tr>
                      </table></td>
                  </tr>
                </table>
				</td>
				
              <c:forTokens var="dateheader" items="${ListTimetrackForm.headerInfo2}" delims="|">
                <td colspan='<c:out value="${_colspanheader}"/>'>
				<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#D7D8D9">
                    <tr>
                      <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                          <tr>
                            <td class="text99" align="center"><strong>
                              <c:out value="${dateheader}"/>
                              </strong> </td>
                          </tr>
                        </table></td>
                    </tr>
                  </table>
				  </td>
              </c:forTokens>
            </tr>
            <tr>
              <td bgcolor="#a7a9ac"><html:img src="images/spacer.gif"/></td>
              <c:forTokens var="dateheader" items="${ListTimetrackForm.headerInfo2}" delims="|">
                <td bgcolor="#a7a9ac" colspan='<c:out value="${_colspanheader}"/>'><html:img src="images/spacer.gif"/></td>
              </c:forTokens>
            </tr>
            <c:forEach var="timetrackLineItem" items="${ListTimetrackForm.lineItems}" varStatus="loop">
            
            <c:if test="${_unit != timetrackLineItem.unit}">
            
            <c:set var="_unit" value="${timetrackLineItem.unit}"/>
			
            <tr>
              <td></td>
              <td></td>
            </tr>
			
            <tr>
            
            <td>
			<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#ffffff">
                <tr>
                  <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
                      <tr>
                        <td class="text89"><c:out value="${timetrackLineItem.unit}"/></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
			  </td>
			  
            <c:forEach var="timetrackLineItem2" items="${ListTimetrackForm.lineItems}" varStatus="loop">
             
            <c:if test="${_unit == timetrackLineItem2.unit}">
            
            <c:set var="_colspan" value="${timetrackLineItem2.colspan}"/>
            
			<c:if test="${timetrackLineItem2.jobmovId != 'dummy'}">
            
            <c:set var="_class" value="text89"/>
            <c:if test="${timetrackLineItem2.actualflag == 'Y'}">
              <c:set var="_class" value="text119"/>
            </c:if>
            <c:set var="_bgcolor" value="#ffffff"/>
            <c:if test="${timetrackLineItem2.testflag == '1'}">
              <c:set var="_bgcolor" value="#e83939"/>
            </c:if>
            <c:if test="${timetrackLineItem2.testflag == '2'}">
              <c:set var="_bgcolor" value="#ffca00"/>
            </c:if>
            <c:if test="${timetrackLineItem2.testflag == '3'}">
              <c:set var="_bgcolor" value="#7ce47e"/>
            </c:if>
			
            <td colspan="<c:out value="${_colspan}"/>">

            <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#CCCCCC">
              
			  <tr>
              <td>
              
              <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
                <tr><td>
				
				  <table border='0' cellpadding='0' cellspacing='1' width='100%' bgcolor='<c:out value="${_bgcolor}"/>'>
                <tr>
                <td> 
				              
                <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
                  <tr>
				  
                    <td class='<c:out value="${_class}"/>' align='center'>
                    <c:if test="${timetrackLineItem2.previousflag=='<'}">
                      <html:img src="images/previous.gif"/>
                    </c:if>
                  </td>
                  
                  <td class='<c:out value="${_class}"/>' align='center'> 
					<div> 
					<a href='/beacon/TimetrackEditJobmov.do?action=Edit&jobhdrId=<c:out value="${timetrackLineItem2.jobhdrId}"/>&jobmovId=<c:out value="${timetrackLineItem2.jobmovId}"/>' 
							title='Order Ref: <c:out value="${timetrackLineItem2.orderno}"/>   Section: <c:out value="${timetrackLineItem2.section.sectionkey}"/>| From Location: <c:out value="${timetrackLineItem2.fromlocation.locationName}"/>| To Location: <c:out value="${timetrackLineItem2.tolocation.locationName}"/>| Vendor: <c:out value="${timetrackLineItem2.vendoraddr.name}"/>| Product: <c:out value="${timetrackLineItem2.product.productkey}"/>| Estimated From: <bean:write name="timetrackLineItem2" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>-<c:out value="${timetrackLineItem2.estfromtime}"/>| Estimated To: <bean:write name="timetrackLineItem2" property="esttodate" format="dd-MMM-yyyy" filter="true"/>-<c:out value="${timetrackLineItem2.esttotime}"/>|  Actual From: <bean:write name="timetrackLineItem2" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>-<c:out value="${timetrackLineItem2.actfromtime}"/>| Actual To: <bean:write name="timetrackLineItem2" property="acttodate" format="dd-MMM-yyyy" filter="true"/>-<c:out value="${timetrackLineItem2.acttotime}"/>| Test Due: <c:out value="${timetrackLineItem2.testduedate}"/> [<c:out value="${timetrackLineItem2.testtype}"/>]
								'>
                    <c:if test="${(timetrackLineItem2.colspan/ListTimetrackForm.headerInfo1)<0.07}">*</c:if>
                    <c:if test="${(timetrackLineItem2.colspan/ListTimetrackForm.headerInfo1)>=0.07}">
                      <c:out value="${timetrackLineItem2.orderno}"/>
                      -
                      <c:out value="${timetrackLineItem2.section.sectionkey}"/>
                    </c:if>
                    </a>
					</div>
                  </td>
                  
                  <td align='center' class='<c:out value="${_class}"/>'>
                    <c:if test="${timetrackLineItem2.nextflag=='>'}">
                      <html:img src="images/next.gif"/>
                    </c:if>
                  </td>
                  
                  </tr>
                  
                </table>
                
				</td>
                </tr>
                
              </table>
              
			  </td>
			  </tr>
            </table>
            
			</td>
            </tr>
            
          </table>
          
		  </td>
          
          </c:if>
          
          <c:if test="${timetrackLineItem2.jobmovId == 'dummy'}">
            <td colspan='<c:out value="${_colspan}"/>'>&nbsp;</td>
          </c:if>
		  
          </c:if>
          
          </c:forEach>
          
          </tr>
          
          <tr>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td bgcolor="#a7a9ac"><html:img src="images/spacer.gif"/></td>
            <td bgcolor="#a7a9ac" colspan='<c:out value="${ListTimetrackForm.headerInfo1}"/>'><html:img src="images/spacer.gif"/></td>
          </tr>
          </c:if>
          
          </c:forEach>
          
        </table>
        
		</td>
        </tr>
        
      </table>
	  
      </td>
      
      </tr>
      
    </table>
	
    </html:form>
    
    </td>
    
    </tr>
    
  </table>
  </div>
  
  </td>
  
  </tr>
  
  <!-- FOOTER ----------------->
  <tr>
    <td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" />
    </td>
  </tr>
  
  </table>
  </body>
</html:html>

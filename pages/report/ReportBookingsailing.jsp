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
      <td class="tdwht"><strong>Booking Vs Sailing Report</strong></td>
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
<%--                <div class="exportImg">
                  <INPUT name="exportSummaryButton" border="0" src="images/report/icon_mini_export.gif" type="image" align="middle" id="exportSummaryButton" title="Export Summary View" />
                </div>--%>
              </html:form>
              <div class="clearBoth"> </div>
              <table cellspacing="0" cellpadding="0">
                <tr>
                  <td valign="top"><table cellspacing="0" cellpadding="0" style="table-layout:fixed;" class="matrix w1400 borderTop">
                      <html:form action="/ReportBookingsailing">
                        <html:hidden property="searchString6" value="0"/>
                        <html:hidden property="searchString7" value="3"/>
                        <html:hidden property="searchString10"/>
                        
                        <tr class="colheaders" height="200px">
                          <th colspan="4" width="300"> <div style="text-align:right">
                              <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                  <td class="systemtd2" width="1%"><input name="searchString8" type="radio" id="searchString8" value="DEPARTMENT"
<%
try {
	if (
	ReportForm.getSearchString8()!=null && 
	ReportForm.getSearchString8().equals("DEPARTMENT")
		) out.write("checked");
} catch (NullPointerException e) {}
%>
>
                                  </td>
                                  <td class="systemtd2" width="24%">DEPARTMENT</td>
                                  <td class="systemtd2" colspan="2" width="75%">
		<html:select property="searchString2" styleClass="forminput1">
			<html:option value="ALL">ALL</html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>                                  
                                  </td>
                                </tr>
                                <tr>
                                  <td class="systemtd2" width="1%">
                                  <input name="searchString8" type="radio" id="searchString8" value="COUNTRY"
<%
try {
	if (
	ReportForm.getSearchString8()!=null && 
	ReportForm.getSearchString8().equals("COUNTRY")
		) out.write("checked");
} catch (NullPointerException e) {}
%>
>
                                  </td>
                                  <td class="systemtd2" width="24%">G1 CODE</td>
                                  <td class="systemtd2" colspan="2" width="75%">
        <html:select property="searchString1" styleClass="forminput1">
			<html:option value="ALL">ALL</html:option>
			<html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>	
		</html:select>	                                  
                                  </td>
                                </tr>
                                <tr>
                                  <td class="systemtd2" width="1%">&nbsp;</td>
                                  <td class="systemtd2">WEEK</td>
                                  <td class="systemtd2" colspan="2">
		<html:select property="searchString3" styleClass="ftforminputsmall" onchange="processListMovref();processListSectionkey();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	                                  
     
                                    <select name='searchString4' class="ftforminputsmall">
                                      <option selected value="00">WW</option>
                                      <%
String s = "";									  
int count = 0;
	while (count < 53) { 
		count++;	
		s = ""; 	
		String count2= count+"";
		if (ReportForm.getSearchString4()!=null && ReportForm.getSearchString4().equals(count2)) s = "Selected";	
%>
                                      <option <%= s %> value="<%= count %>"><%= count2 %></option>
                                      <%
	}
%>
                                    </select>
                                    &nbsp;</td>
                                </tr>
                                <tr>
                                  <td class="systemtd2" width="1%">&nbsp;</td>
                                  <td class="systemtd2">NUMBER OF WEEKS </td>
                                  <td class="systemtd2">
                                  <select name='searchString5' class="ftforminputsmall">
                                      <option selected value="00">WW</option>
                                      <%
	count = 0;
	while (count < 10) {
		count++;	
		s = ""; 	
		String count2= count+"";
if (ReportForm.getSearchString5()!=null && ReportForm.getSearchString5().equals(count2)) s = "Selected";			
%>
                                      <option <%= s %> value="<%= count %>"><%= count2 %></option>
                                      <%
	}
%>
                                    </select>
                                    &nbsp;</td>
                                  <td class="systemtd2" align="right"><div style="text-align:right">
                                      <INPUT name="refreshButton" border="0" type="image" src="images/report/refreshButtonBorderGrey.gif" align="bottom" id="refreshButton" title="Reload Data" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('refreshButton','','images/report/refreshButtonBorderGrey.gif','refreshButton','','images/report/refreshButtonBorderGrey_over_blue.gif',1);"/>
                                    </div></td>
                                </tr>
                              </table>
                            </div></th>
							
							
                          <c:set var="_colcount" value="0"/>
                          <%
//get columns header list
java.util.List _list1 = ReportForm.getList();
for (java.util.Iterator it1 = _list1.iterator(); it1.hasNext();) {
		com.bureaueye.beacon.bean.LabelValue _columnHeader = (com.bureaueye.beacon.bean.LabelValue)it1.next();				
		
	java.util.StringTokenizer _st = new java.util.StringTokenizer(_columnHeader.getLabel(), "|");	
	String _period = "";
	try {_period = _st.nextToken();} catch (Exception e) {}		
%>


<%
// 
if (_period.equals("WEEK")) {
%>

                          <c:set var="_colcount" value="${_colcount+1}"/>
                          <c:set var="_class" value=""/>
                          <c:if test="${_colcount % 2 == 0}">
                            <c:set var="_class" value="highlightcol"/>
                          </c:if>                                                  
                          <th class='<c:out value="${_class}"/>' colspan='1'><span class="small"><%= _columnHeader.getValue() %></span></th>
<%
}//current month
%>
                          

<%
// 
if (_period.equals("MONTH")) {
%>

                          <c:set var="_colcount" value="${_colcount+1}"/>
                          <c:set var="_class" value=""/>
                          <c:if test="${_colcount % 2 == 0}">
                            <c:set var="_class" value="highlightcol"/>
                          </c:if>                                                  
                          <th class='<c:out value="${_class}"/>' colspan='1'><span class="small">Booked and Projected for <%= _columnHeader.getValue() %> (Not Sailed)</span></th>
<%
}//current month
%>

                          
<%
// special process for Current month
if (_period.equals("MONTH") && _columnHeader.getValue().indexOf("Current")>0) {
%>
                          <c:set var="_colcount" value="${_colcount+1}"/>
                          <c:set var="_class" value=""/>
                          <c:if test="${_colcount % 2 == 0}">
                            <c:set var="_class" value="highlightcol"/>
                          </c:if>
                          <th class='<c:out value="${_class}"/>' colspan='1'><span class="small"><%= _columnHeader.getValue() %> Sailed</span></th>
                          <c:set var="_colcount" value="${_colcount+1}"/>
                          <c:set var="_class" value=""/>
                          <c:if test="${_colcount % 2 == 0}">
                            <c:set var="_class" value="highlightcol"/>
                          </c:if>
                          <th class='<c:out value="${_class}"/>' colspan='1'><span class="small"><%= _columnHeader.getValue() %> Projected</span></th>
<%
}//current month
%>
<%
}//column list loop
%>
                        </tr>
                      </html:form>
					  
					  
					  
                      <tr class="colheaders"> </tr>
                      <c:set var="_colcount" value="0"/>
<%
java.util.Hashtable _ht1 = (java.util.Hashtable)ReportForm.getHt1();
//get rows map
java.util.TreeMap _tm2 = (java.util.TreeMap)ReportForm.getTm2();
for (java.util.Iterator it2 = _tm2.keySet().iterator(); it2.hasNext();) {
	java.lang.Object _tm2key = (java.lang.Object)it2.next();	
	com.bureaueye.beacon.bean.LabelValue _labelvalue2 =	(com.bureaueye.beacon.bean.LabelValue)_tm2.get(_tm2key);	
%>
                      <tr class="coldetails">
                        <td width="300" colspan='4' nowrap><div class="detail3">
                            <div><%= _labelvalue2.getValue() %></div>
                          </div></td>
                        <c:set var="_colcount" value="0"/>
<%
//get columns hashtable
java.util.List _list2 = ReportForm.getList();
for (java.util.Iterator it3 = _list2.iterator(); it3.hasNext();) {
		com.bureaueye.beacon.bean.LabelValue _columnDetail = (com.bureaueye.beacon.bean.LabelValue)it3.next();
		String _key=_columnDetail.getLabel()+"|"+_tm2key;
%>

<%
	java.util.StringTokenizer _st = new java.util.StringTokenizer(_columnDetail.getLabel(), "|");	
	String _period = "";
	try {_period = _st.nextToken();} catch (Exception e) {}
	
if (_period.equals("WEEK")) {		
//get sums hash table
int _sum0=0;
String _sql0="";
try{
com.bureaueye.beacon.bean.LabelValue _labelvalue4 = (com.bureaueye.beacon.bean.LabelValue)_ht1.get(_key);
java.lang.Float _sum1=new java.lang.Float(_labelvalue4.getValue());
_sql0=_labelvalue4.getLabel();
_sum0=_sum1.intValue();
}catch(Exception e){}					
%>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <td class='<c:out value="${_class}"/>' colspan='1' nowrap><div class="detail2">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0 %>' title='<%= _key %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0 %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0 %>'>                              
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                          </div></td>
                        <%
} // WEEK PROCESS
%>
<%
if (_period.equals("MONTH")) {		
%>
<%
int[] _sum0=new int[10]; 
String[] _key2=new String[10];
String[] _sql0=new String[10];
//loop 4 totals for each month
for (int i = 0; i <= 3; i++) {

_key2[i]=_key+"|"+i;
//get sums hash table
try{
com.bureaueye.beacon.bean.LabelValue _labelvalue5 = (com.bureaueye.beacon.bean.LabelValue)_ht1.get(_key2[i]);
java.lang.Float _sum1=new java.lang.Float(_labelvalue5.getValue());
_sum0[i]=_sum1.intValue();
_sql0[i]=_labelvalue5.getLabel();
}catch(Exception e){}


} //loop 3 totals for each month
%>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <td class='<c:out value="${_class}"/>' colspan='1' nowrap>
                        <div class="detail2">                                               
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0[0] %>' title='<%= _key2[0] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[0] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[0] %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0[0] %>'>                              
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>                         
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='(<%= _sum0[3] %>)' title='<%= _key2[3] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[3] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[3] %>">
                              <input type="hidden" name="searchString13" value="YES">
                              <input type="hidden" name="searchString14" value='<%= _sum0[3] %>'>                              
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>                         
                          </div>
                        </td>
                        <%
// special process for Current month
if (_columnDetail.getValue().indexOf("Current")>0) {
%>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <td class='<c:out value="${_class}"/>' colspan='1' nowrap>                       
                        <div class="detail2">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0[1] %>' title='<%= _key2[1] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[1] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[1] %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0[1] %>'>                              
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                          </div></td>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <td class='<c:out value="${_class}"/>' colspan='1' nowrap><div class="detail2">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0[2] %>' title='<%= _key2[2] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[2] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[2] %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0[2] %>'>                              
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                          </div></td>
<%
}// special process for current month
%>
<%
} // MONTH PROCESS
%>
<%
} // loop
%>

                      </tr>
<%
}
%>




<!--TOTALS WITH DRILL-DOWN-------------------------------------------------------->
                      <c:set var="_colcount" value="0"/>

                      <tr class="colheaders" height="60px">
                        <th colspan="4" width="300"> <div style="text-align:left"><span class="normal">Total</span></div></th>
                        <c:set var="_colcount" value="0"/>
<%
//get columns hashtable
java.util.List _list2 = ReportForm.getList();
for (java.util.Iterator it3 = _list2.iterator(); it3.hasNext();) {
		com.bureaueye.beacon.bean.LabelValue _columnDetail = (com.bureaueye.beacon.bean.LabelValue)it3.next();
		String _key=_columnDetail.getLabel();	
%>

<%
	java.util.StringTokenizer _st = new java.util.StringTokenizer(_columnDetail.getLabel(), "|");	
	String _period = "";
	try {_period = _st.nextToken();} catch (Exception e) {}
	
if (_period.equals("WEEK")) {		
//get sums hash table
int _sum0=0;
String _sql0="";
try{
com.bureaueye.beacon.bean.LabelValue _labelvalue4 = (com.bureaueye.beacon.bean.LabelValue)_ht1.get(_key);
java.lang.Float _sum1=new java.lang.Float(_labelvalue4.getValue());
_sql0=_labelvalue4.getLabel();
_sum0=_sum1.intValue();
}catch(Exception e){}					
%>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        
                        <th class='<c:out value="${_class}"/>' colspan='1' nowrap><div class="detail2">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0 %>' title='<%= _key %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0 %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0 %>'>                             
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                          </div></th>
                        <%
} // WEEK PROCESS
%>
<%
if (_period.equals("MONTH")) {		
%>
<%
int[] _sum0=new int[10]; 
String[] _key2=new String[10];
String[] _sql0=new String[10];
//loop 4 totals for each month
for (int i = 0; i <= 3; i++) {

_key2[i]=_key+"|"+i;
//get sums hash table
try{
com.bureaueye.beacon.bean.LabelValue _labelvalue5 = (com.bureaueye.beacon.bean.LabelValue)_ht1.get(_key2[i]);
java.lang.Float _sum1=new java.lang.Float(_labelvalue5.getValue());
_sum0[i]=_sum1.intValue();
_sql0[i]=_labelvalue5.getLabel();
}catch(Exception e){}


} //loop 3 totals for each month
%>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <th class='<c:out value="${_class}"/>' colspan='1' nowrap>
                          <div class="detail2">                        
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0[0] %>' title='<%= _key2[0] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[0] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[0] %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0[0] %>'>                               
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='(<%= _sum0[3] %>)' title='<%= _key2[3] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[3] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[3] %>">                
                              <input type="hidden" name="searchString13" value="YES">
                              <input type="hidden" name="searchString14" value='<%= _sum0[3] %>'>                               
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>                       
                          </div>
                          </th>
                        <%
// special process for Current month
if (_columnDetail.getValue().indexOf("Current")>0) {
%>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <th class='<c:out value="${_class}"/>' colspan='1' nowrap><div class="detail2">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0[1] %>' title='<%= _key2[1] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[1] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[1] %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0[1] %>'>                               
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                          </div></th>
                        <c:set var="_colcount" value="${_colcount+1}"/>
                        <c:set var="_class" value=""/>
                        <c:if test="${_colcount % 2 == 0}">
                          <c:set var="_class" value="highlightcol"/>
                        </c:if>
                        <th class='<c:out value="${_class}"/>' colspan='1' nowrap><div class="detail2">
                            <html:form action="/ReportBookingsailing">
                              <input border='0' type='submit'  value='<%= _sum0[2] %>' title='<%= _key2[2] %>'/>
                              <input type='hidden' name='searchString10' value='detail'>
                              <input type='hidden' name='searchString11' value='<%= _key2[2] %>'>
                              <input type="hidden" name="searchString12" value="<%= _sql0[2] %>">
                              <input type="hidden" name="searchString13" value="">
                              <input type="hidden" name="searchString14" value='<%= _sum0[2] %>'>                              
                              <input type='hidden' name='orderBy' value='jobhdr.Jobno'>
                              <input type='hidden' name='orderByDesc' value=''>
                              <html:hidden property="searchString1"/>
                              <html:hidden property="searchString2"/>
                              <html:hidden property="searchString3"/>
                              <html:hidden property="searchString4"/>
                              <html:hidden property="searchString5"/>
                              <html:hidden property="searchString6"/>
                              <html:hidden property="searchString7"/>
                              <html:hidden property="searchString8"/>
                            </html:form>
                          </div></th>
<%
}// special process for current month
%>
<%
} // MONTH PROCESS
%>
<%
} // loop
%>

                      </tr>
<!--TOTALS WITH DRILL-DOWN-------------------------------------------------------->





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

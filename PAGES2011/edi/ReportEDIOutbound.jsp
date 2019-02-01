<%--                                                      
  Copyright (c) 2005 by BureauEye           
  All rights reserved.  
--%> 
<%@ include file="/WEB-INF/InitModel.jsp" %>      
 
<%-- 
non standard beans declaration
--%>


<%

String pStatus = request.getParameter("Status");
if (pStatus == null) pStatus = "ERROR";

String pFromMonth = request.getParameter("FromMonth");
if (pFromMonth == null) pFromMonth = "";
String pFromDay = request.getParameter("FromDay");
if (pFromDay == null) pFromDay = "";
String pFromYear = request.getParameter("FromYear");
if (pFromYear == null) pFromYear = "";

String pToMonth = request.getParameter("ToMonth");
if (pToMonth == null) pToMonth = "";
String pToDay = request.getParameter("ToDay");
if (pToDay == null) pToDay = "";
String pToYear = request.getParameter("ToYear");
if (pToYear == null) pToYear = "";



com.bureaueye.beacon.formatter.DateFormatter dateFormatter = new com.bureaueye.beacon.formatter.DateFormatter();
Calendar cFrom = Calendar.getInstance();
try {
		cFrom.set(
				Integer.parseInt(pFromYear), 
				Integer.parseInt(pFromMonth) - 1, 
				Integer.parseInt(pFromDay)
				);
} catch (Exception e) {
		cFrom.setTime(new java.util.Date());
		// quote date 'from'
		cFrom.add(Calendar.DATE,-7);							
}

Calendar cTo = Calendar.getInstance();
try {
		cTo.set(
				Integer.parseInt(pToYear), 
				Integer.parseInt(pToMonth) - 1, 
				Integer.parseInt(pToDay)
				);
} catch (Exception e) {
		cTo.setTime(new java.util.Date());							
}
		

				
// hibernate 
Session _Session = null;
List edioutbounds = null;
try {
	_Session = HibernateUtil.currentSession();
} 
catch (HibernateException e) {
	System.out.println(e.getMessage());
}			
try {
	Criteria crit = _Session.createCriteria(com.bureaueye.beacon.model.edi.Edioutbound.class);
	if (!pStatus.equals("")) crit.add(org.hibernate.criterion.Expression.eq("Edistatus",pStatus));
	try {
		crit.add(org.hibernate.criterion.Expression.ge("Createdate",cFrom.getTime()));
	} catch (Exception e) {}
	try {
		crit.add(org.hibernate.criterion.Expression.le("Createdate",cTo.getTime()));
	} catch (Exception e) {}	
	crit.addOrder(org.hibernate.criterion.Order.desc("EdioutboundId"));
	edioutbounds = crit.list();
} 
catch (ObjectNotFoundException e) {
	System.out.println(e.getMessage());
}	
catch (HibernateException e) {
	System.out.println(e.getMessage());
}	
try {
	HibernateUtil.closeSession();
}	
catch (HibernateException e) {
	System.out.println(e.getMessage());
}
%>
 

<html>

<link href="../../../css/genesys.css" rel="stylesheet" type="text/css">
<link href="../../../css/print.css" rel="stylesheet" type="text/css">
<link href="<%= BASEURL %>/css/print.css" rel="stylesheet" type="text/css">
<link type="text/css" href="/css/print.css" rel="stylesheet">

<style type="text/css">
body,td,th {
	font-size: 10px;
}
.style1 {color: #FF0000}
.style2 {color: #000000}
</style>

<head>
	<title>EDI Outbound</title>  
</head>


<body>

<form method="post" action="<%= BASEURL %>/pages/edi/ReportEDIOutbound.jsp" name="form">

<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="row0">
    <td class="body3">&nbsp;</td>
    <td width="8%" class="body3black">CREATE DATE</td>
    <td width="42%" class="body2">
	<select name='FromYear' class="ftforminputsmall">
      <option selected value="">YYYY</option>
      <%
	st = new StringTokenizer(yearList, ",");
	while (st.hasMoreTokens()) {	
		int year = java.lang.Integer.parseInt(st.nextToken());
		s = "";

		try {if (year == java.lang.Integer.parseInt(pFromYear)) s = "Selected";} catch (Exception e){}		
%>
      <option <%= s %> value="<%= year %>"><%= year %></option>
      <%
	}
%>
    </select>
      <select name='FromMonth' class="ftforminputsmall">
      <option selected value="">MM</option>
      <%
	st = new StringTokenizer(monthList, ",");
	count = 0;
	while (st.hasMoreTokens()) {
		count++;	
		String month = st.nextToken();
		s = "";
		try {if (count ==  java.lang.Integer.parseInt(pFromMonth)) s = "Selected";} catch (Exception e){}
		String count2= df.format(count);
%>
      <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
      <%
	}
%>
    </select>
      <select name='FromDay' class="ftforminputsmall">
        <option selected value="">DD</option>
        <%
	count = 0;
	while (count < 31) {
		count++;	
		s = ""; 
		try {if (count == java.lang.Integer.parseInt(pFromDay)) s = "Selected";} catch (Exception e){}		
		String count2= df.format(count);
%>
        <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
        <%
	}
%>
      </select>
      <span  class="body3black">
      TO:		</span>
      <select name='ToYear' class="ftforminputsmall">
        <option selected value="">YYYY</option>
        <%
	st = new StringTokenizer(yearList, ",");
	while (st.hasMoreTokens()) {	
		int year = java.lang.Integer.parseInt(st.nextToken());
		s = "";

		try {if (year == java.lang.Integer.parseInt(pToYear)) s = "Selected";} catch (Exception e){}		
%>
        <option <%= s %> value="<%= year %>"><%= year %></option>
        <%
	}
%>
      </select>
      <select name='ToMonth' class="ftforminputsmall">
        <option selected value="">MM</option>
        <%
	st = new StringTokenizer(monthList, ",");
	count = 0;
	while (st.hasMoreTokens()) {
		count++;	
		String month = st.nextToken();
		s = "";
		try {if (count ==  java.lang.Integer.parseInt(pToMonth)) s = "Selected";} catch (Exception e){}		
		String count2= df.format(count);
%>
        <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
        <%
	}
%>
      </select>
      <select name='ToDay' class="ftforminputsmall">
        <option selected value="">DD</option>
        <%
	count = 0;
	while (count < 31) {
		count++;	
		s = ""; 
		try {if (count == java.lang.Integer.parseInt(pToDay)) s = "Selected";} catch (Exception e){}		
		String count2= df.format(count);
%>
        <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
        <%
	}
%>
      </select>
      <span  class="body3black"> (DEFAULTS TO LAST WEEK) </span></td>
    <td width="44%" class="body3black"><input type="submit" name="Submit" value="SUBMIT" class="ftforminputsmall"></td>
    <td width="5%" class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
    <td width="1%" class="body3">&nbsp;</td>
    <td class="body3black">STATUS</td>
    <td class="body2"><b>
      <select name="Status" class="ftformtext">
        <option value="ERROR">ERROR</option>
        <option value="PENDING">PENDING</option>
        <option value="SENT">SENT</option>
      </select>
      <span class="body3black">(DEFAULTS TO ERROR STATUS)</span></b></td>
    <td class="body3black">&nbsp;</td>
    <td class="body2">&nbsp;</td>
  </tr>
  <tr class="row1">
    <td height="10"></td>
  </tr>
</table>

</form>

<a name="header"></a>
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="body3white">
    <td>ID</td>
    <td>doc type</td>
    <td>doc key</td>
    <td>partner</td>
    <td>status</td>	
    <td>create User</td>	
    <td>Create Date</td>
	    <td>sent Date</td>
    <td>control id</td>
    <td>batch id</td>
    <td>errors</td>	
  </tr>
<% 
	int row = 1;

	if (edioutbounds != null) {
    	Iterator it = edioutbounds.iterator();
      	while (it.hasNext()) {
        	com.bureaueye.beacon.model.edi.Edioutbound edioutbound = (com.bureaueye.beacon.model.edi.Edioutbound) it.next();

String _class = "row1";
if (edioutbound.getEdistatus().equals("ERROR")) _class = "rowRed";		 		
%>
  <tr class="<%= _class %>">
    <td nowrap><%= edioutbound.getEdioutboundId() %></td>
    <td nowrap><%= edioutbound.getDoctype() %></td>
    <td nowrap><%= edioutbound.getDockey() %></td>
    <td nowrap><%= edioutbound.getEdiid() %></td>
    <td nowrap><%= edioutbound.getEdistatus() %></td>
    <td nowrap><%= edioutbound.getCreateuserid() %></td>
    <td nowrap><%= edioutbound.getCreatedate() %></td>
	<td nowrap><%= edioutbound.getSentdate() %></td>
    <td nowrap><%= edioutbound.getControlid() %></td>
    <td nowrap><%= edioutbound.getEdibatchId() %></td>
	<td nowrap>
	<%= edioutbound.getErrors() %>
	</td>
  </tr>
  <tr width="100%" bgcolor="#E5E5E5">
    <td colspan="11" class="body2" height="1"><img src="/images/spacer.gif" height="1"></td>
  </tr>
<%
		}	
%>  
</table>

<a name="end" id="end"></a>
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="0" width="100%">
  <tr class="body3white">
    <td width="5"></td>
    <td>end of report </td>
    <td align="right">&nbsp;</td>
  </tr>
</table>

<%
	}	
%>


</body>

</html>
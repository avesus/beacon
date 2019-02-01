<%--                                                                                                                                                                                                             
  Copyright (c) 2005 by BureauEye           
  All rights reserved.  
--%> 
<%@ include file="/WEB-INF/InitModel.jsp" %>      
 
<%-- 
non standard beans declaration
--%>
<jsp:useBean id="tblreport" class="bean.itt.print.Tblreport"
	type="bean.itt.print.Tblreport" scope="session" />
 
<%
// hibernate 
Session _Session = null;
List tblreportheadersList = null;
try {_Session = HibernateUtil.currentSession();} catch (HibernateException e) {}	
try {tblreportheadersList = _Session.createSQLQuery("select {Tblreportheaders.*} from Tblreportheaders order by Tblreportheaders.ReportHeaderName","Tblreportheaders",Tblreportheaders.class).list();} 
catch (ObjectNotFoundException onfe) {}
catch (HibernateException e2) {}	
try {HibernateUtil.closeSession();}	catch (HibernateException e5) {}
%>

<html>

<link href="../../../css/genesys.css" rel="stylesheet" type="text/css">
<link href="../../../css/print.css" rel="stylesheet" type="text/css">
<link rel="STYLESHEET" type="text/css" href="<%= BASEURL %>/css/calendar.css">
	
	
<style type="text/css">
body,td,th {
	font-size: 10px;
}
.style3 {color: #FFFFFF}
</style>

<style>
	cal.td{
	  font-family : Arial,Helvetica,Sans-serif;
	  font-size : 12px;
	  color : #000000;
	}
	cal.input{
	  font-family : Arial,Helvetica,Sans-serif;
	  font-size : 12px;
	  color : #000000;
	  width : 90px;
	}
</style>

<head>
	<title>B/L FOR MOTOR CARRIAGE</title>  
	
</head>

<body>

<%
ConnectionPool connectionpool = null;
Connection connection = null;
try {
connectionpool = (ConnectionPool)application.getAttribute("CONNECTION_POOL");
connection = connectionpool.getConnection();
modeladdress.setCon( connection );
modelstd.setCon( connection );

String name = "";
String addr1 = "";
String addr2 = "";
String addr3 = "";
String addr4 = "";
String addr5 = "";
String town = "";
String country = "";
String city = "";
String cszc = "";
Address address = null;
Location location = null;
AddressContact addresscontact = null;
%>
  

  
  <%@ include file="/WEB-INF/InitScripts.jsp" %>  		
<script language="JavaScript" src="<%= BASEURL %>/scripts/simplecalendar.js" type="text/javascript"></script> 
  

<form method="post" action="<%= CONTROLLER %>/itt.print/Notification/Print" name="form" onSubmit="return check();">
	
<input type="hidden" name="currentpage" value="/pages/itt/print/BLM.jsp">
<input type="hidden" name="nextpage" value="/pages/itt/print/BLM.jsp">
<input type="hidden" name="CurrentDivId" value="<%= modelitt.getCurrentDivId() %>">
<input type="hidden" name="ShipmentProcessId" value="<%= modelitt.getShipmentProcessId() %>">
<input type="hidden" name="Action" value="BLM">
<input type="hidden" name="PrintId" value="BLM">

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
  <td class="fteditortext"><a href='javascript:history.back()' class="fteditortext">&lt;&lt; Back</a></td>
</tr>
<tr><td>
  <font class="ftcolumntext">
  <select name="ReportHeaderId" class="ftforminputsmall">
    <option selected value="3">enter Report Header</option>
    <%
	if (tblreportheadersList != null) {
      		Iterator it = tblreportheadersList.iterator();
      		while (it.hasNext()) {
         Tblreportheaders tblreportheaders = (Tblreportheaders) it.next();
				s = "";
%>
    <option value="<%= tblreportheaders.getId() %>"><%= tblreportheaders.getReportHeaderName() %></option>
    <%
		}
	}
%>
  </select>
</font>
  <input name="Print" type="Submit" value="Save" class="ftforminputsmall"/>
  <input name="Print" type="Submit" value="Print" class="ftforminputsmall"/> 
  <a href="<%= CONTROLLER %>/itt.print/Notification/Reload?ShipmentProcessId=<%= modelitt.getShipmentProcessId() %>&nextpage=/pages/itt/print/BLM.jsp&currentpage=/pages/itt/BLM.jsp&Action=BLM" class="fteditortext">Load/Reload</a> 
</td> 
</tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="ftformtext"><tr><td>&nbsp;</td></tr></table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
  <tr>
    <td class="ftheaderbartextlarge">&nbsp;</td>
    <td class="ftraisedtextlarge"><div align="right" class="ftheaderbartextlarge"><strong>Non-Negotiable</strong></div></td>
  </tr>
  <tr>
    <td colspan="2" class="ftraisedtextsmall">RECEIVED, subject to the terms and conditions on the reverse hereof, the property describe below, in apparent good order except as noted (contents and conditions, contents of packages unknown), marked, consigned, and destined as shown below. This Bill of Lading is not subject to any tariffs or classifications whether individually determined or filed with any federal or state regulatory agency, except as specifically agreed to in writing by the shipper and the carrier. </td>
  </tr>
  <tr>
    <td colspan="2" class="ftraisedtextlarge"><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
      <tr>
        <td width="36%" class="ftraisedtextsmall"><strong>IF CHARGES ARE TO BE PREAID, WRITE OR STAMP HERE, &quot;CHARGES PREPAID&quot; </strong></td>
        <td width="14%"><div align="center"><strong>DATE</strong></div></td>
        <td width="25%"><div align="center"><strong>OUR REF NO </strong></div></td>
        <td width="25%"><div align="center"><strong>CUSTOMERS ORDER NO </strong></div></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><span class="body2">
          <input name="ReportDate" type="text" class="ftforminputsmall" value="<%= tblreport.getReportDate() %>" size="15" maxlength="15" readonly="true">
          <a href="javascript: void(0);" onMouseOver="if (timeoutId) clearTimeout(timeoutId);window.status='Show Calendar';return true;" onMouseOut="if (timeoutDelay) calendarTimeout();window.status='';" onClick="g_Calendar.show(event,'form.ReportDate',true,'yyyy-mm-dd'); return false;"><img src="<%= BASEURL %>/images/calendar.gif" alt="" name="imgCalendar" width="34" height="21" border="0"></a> </span></td>
        <td><div align="center"><%= tblreport.getJobNumber() %></div></td>
        <td><div align="center"><%= tblreport.getConsigneeRef() %></div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td colspan="2" class="ftraisedtextlarge"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="32%" rowspan="3">&nbsp;</td>
        <td width="68%"><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
          <tr>
            <td><div align="center"><strong>IMPORTING CARRIER </strong></div></td>
            <td><div align="center"><strong>LOCATION</strong></div></td>
          </tr>
          <tr>
            <td>
              <div align="center">
                  <%
//name = "";
//address = new Address();
//try{
//address = modeladdress.getAddress(tblreport.getShipLine());
//name = address.getName();
//} catch(Exception e){}
%>
                  <%= tblreport.getShipLine() %>	&nbsp;		
			    </div></td>
            <td>
              <div align="center">
                  <%
name = "";
location = new Location();
try{
location = modeladdress.getLocation(tblreport.getPODPier());
name = location.getLocationName();
} catch(Exception e){}
%>
                  <%= name %> &nbsp;		
			    </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
          <tr>
            <td width="38%"><div align="center"><strong>VESSEL</strong></div></td>
            <td width="31%"><div align="center"><strong>VOY-FLT</strong></div></td>
            <td width="31%"><div align="center"><strong>ARRIVAL DATE </strong></div></td>
          </tr>
          <tr>
            <td><div align="center"><%= tblreport.getVessel() %></div></td>
            <td><div align="center"><%= tblreport.getVoyage() %></div></td>
            <td><div align="center"><%= util.Util.dateTextFormat2(tblreport.getPODdateEst()) %></div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
          <tr>
            <td width="49%"><div align="center"><strong>IB/L NO </strong></div></td>
            <td width="51%"><div align="center"><strong>PORT OF ORIGIN / AIRPORT</strong></div></td>
          </tr>
          <tr>
            <td>
              <div align="center">
                <input name="Mbl" type="text" class="ftforminputsmall" value="<%= tblreport.getMbl() %>" size="15" maxlength="15">
              </div></td>
            <td>
              <div align="center">
                  <%
name = "";
location = new Location();
try{
location = modeladdress.getLocation(tblreport.getPol());
name = location.getLocationName();
} catch(Exception e){}
%>
                  <%= name %>			
			    </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td colspan="2" class="ftraisedtextlarge"><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
      <tr>
        <td width="13%"><strong>FREE TIME EXP </strong></td>
        <td width="47%"><strong>ORIGIN CARRIER / LOCAL DELIVERY OR TRANSFER BY </strong></td>
        <td width="25%"><div align="center"><strong>HOUSE-SUB HOUSE </strong></div></td>
        <td width="15%"><div align="center"><strong>ENTRY NO </strong></div></td>
      </tr>
      <tr>
        <td><input name="Memo1" type="text" class="ftforminputsmall" id="Memo1" value="<%= tblreport.getMemo1() %>" size="15" maxlength="15"></td>
        <td><input name="TruckerImport" type="text" class="ftforminputsmall" id="TruckerImport" value="<%= tblreport.getTruckerImport() %>" size="40" maxlength="40"></td>
        <td><div align="center"><%= tblreport.getMemo2() %></div></td>
        <td><div align="center">
          <input name="Memo3" type="text" class="ftforminputsmall" id="Memo3" value="<%= tblreport.getMemo3() %>" size="15" maxlength="15">
        </div></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td width="50%" class="ftraisedtextlarge">
	<table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#000000"><div align="center" class="style3">DELIVER CONSIGNED TO: </div></td>
          </tr>
    </table>
	</td>
    <td width="50%">
	<table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td bgcolor="#000000"><div align="center" class="style3">ROUTE</div></td>
          </tr>
    </table></td>
  </tr>
  <tr>
    <td width="50%"><table width="100%"  border="0" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
      <%
name = ""; addr1 = ""; addr2 = ""; addr3 = ""; cszc = "";
address = new Address();
try{
address = modeladdress.getAddress(tblreport.getConsignee());
name = address.getName();
addr1 = address.getAddr1();
addr2 = address.getAddr2();
addr3 = address.getAddr3();
cszc = address.getCity()+" "+address.getState()+" "+address.getPostalcode()+" "+address.getCountry();
} catch(Exception e){}
%>
      <tr>
        <td width="60%"><%= name %>&nbsp;</td>
      </tr>
      <tr>
        <td width="60%"><%= addr1 %>&nbsp;</td>
      </tr>
      <tr>
        <td width="60%"><%= addr2 %>&nbsp;</td>
      </tr>
      <tr>
        <td width="60%"><%= addr3 %>&nbsp;</td>
      </tr>
      <tr>
        <td width="60%"><%= cszc %>&nbsp;</td>
      </tr>
    </table></td>
    <td width="50%"><textarea name="textarea" cols="70" rows="5" class="ftforminputsmall" readonly><%= tblreport.getImportDeliveryInstructions() %></textarea></td>
  </tr>
  <tr>
    <td colspan="2" class="ftraisedtextlarge"><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
      <tr bgcolor="#000000">
        <td width="5%"><span class="style3">PKGS</span></td>
        <td width="2%"><span class="style3">HM</span></td>
        <td width="59%"><div align="left" class="style3">DESCRIPTION OF ARTICLES, SPECIAL MARKS &amp; EXCEPTIONS </div></td>
        <td width="17%"><span class="style3">WEIGHT</span></td>
        <td width="17%"><div align="left"><span class="style3"></span></div></td>
      </tr>
      <tr>
        <td><%= tblreport.getNumberOfTanks() %></td>
        <td>&nbsp;</td>
        <td><textarea name="Memo10" cols="70" rows="2" class="ftforminputsmall"><%= tblreport.getMemo10() %></textarea></td>
        <td><%= tblreport.getMemo12() %>
          <input name="WeightType" type="text" class="ftforminputsmall" value="<%= tblreport.getWeightType() %>" size="10" maxlength="10"></td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td colspan="2"><table width="100%"  border="1" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
      <tr>
        <td width="5%">&nbsp;</td>
        <td width="2%">&nbsp;</td>
        <td width="59%"><div align="left"><strong>TANK NUMBERS: </strong></div></td>
        <td width="17%">&nbsp;</td>
        <td width="17%"><div align="left"></div></td>
      </tr>
<%   
try {
	int row = 0;
    Iterator it = tblreport.getTblreportdetails().iterator();
    while (it.hasNext()) {
    	Tblreportdetail _Tblreportdetail = (Tblreportdetail) it.next();	

String TankNumber = "";
int tsMaxGrossWeight = 0;
try{
TblTankSpecs _TblTankSpecs = modelitt.getTblTankSpecs( _Tblreportdetail.getTankNumber() );
TankNumber = _TblTankSpecs.gettsTankNumber();
}catch(Exception e){}

String Emergency1 = ""; String Hazardous = ""; 
try{
Product _Product = modelstd.getProduct(_Tblreportdetail.getProductId());
Emergency1 = _Product.getEmergency1();
if (_Product.getHazardous() > 0 ) Hazardous = "X";
}catch(Exception e){}	  
%>	  
      <tr>
        <td>&nbsp;</td>
        <td><%= Hazardous %></td>
        <td><%= TankNumber %></td>
        <td><%= _Tblreportdetail.getActualWeight2() %></td>
        <td><%= Emergency1 %></td>
      </tr>
<%
// increment row counter
row++;
}
}
catch (Exception e) {}
%>	  
    </table></td>
    </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2"><div align="left"></div>
      <table width="50%"  border="0" align="left" cellpadding="0" cellspacing="0">
        <tr>
          <td height="85" align="center"><textarea name="Memo4" cols="50" rows="10" class="ftforminputsmall" id="Memo4"><%= tblreport.getMemo4() %></textarea></td>
        </tr>
        <tr>
          <td align="center">&nbsp;</td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2"><table width="100%"  border="1" cellspacing="0" cellpadding="0">
      <tr>
        <td width="38%"><table width="100%"  border="0" cellpadding="0" cellspacing="0" class="ftraisedtextsmall">
          <tr>
            <td><p>This is to certify that the above-named materials are properly calssified, described, and marked and labeled and are in proper condition for transportation according to xxxxxxxx regulations of the Department of Transportation. </p>
              <p><strong> ____________________________________ Shipper</strong></p>
              <p>&nbsp; </p></td>
          </tr>
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="80%">XXXXX RESPONSE INFORMATION OFFERED</td>
                <td width="20%"><input name="Chk1" type="text" class="ftforminputsmall" id="Chk1" value="<%= tblreport.getChk1() %>" size="3" maxlength="3"></td>
              </tr>
              <tr>
                <td> XXXXX IS PROPERLY XXXXX </td>
                <td><input name="Chk2" type="text" class="ftforminputsmall" id="Chk2" value="<%= tblreport.getChk2() %>" size="3" maxlength="3"></td>
              </tr>
              <tr>
                <td>XXXXX HAS DOT EMERGENCY RESPONSE GUIDE 8 </td>
                <td><input name="Chk3" type="text" class="ftforminputsmall" id="Chk3" value="<%= tblreport.getChk3() %>" size="3" maxlength="3"></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><p>&nbsp;</p>
              <p><strong>XXXXX DRIVER ____________________________________ </strong></p>
              <p>&nbsp;</p></td>
          </tr>
        </table></td>
        <td width="33%" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0" class="ftforminputsmall">
          <tr>
            <td>INTERMODAL CERTIFICATION </td>
          </tr>
          <tr>
            <td>It is declared by the undersigned that container/vehicle number: </td>
          </tr>
          <tr>
            <td><input name="Memo5" type="text" class="ftforminputsmall" id="Memo5" value="<%= tblreport.getMemo5() %>" size="40" maxlength="40"></td>
          </tr>
          <tr>
            <td>Was loaded with a total gross cargo weight (payload weight) at: </td>
          </tr>
          <tr>
            <td><input name="Memo6" type="text" class="ftforminputsmall" id="Memo6" value="<%= tblreport.getMemo6() %>" size="40" maxlength="40"></td>
          </tr>
          <tr>
            <td>for cargo, consisting of the following: </td>
          </tr>
          <tr>
            <td><textarea name="Memo7" cols="50" rows="3" class="ftforminputsmall" id="Memo7"><%= tblreport.getMemo7() %></textarea></td>
          </tr>
          <tr>
            <td>Name and Company/Organization of Signatory / Date </td>
          </tr>
          <tr>
            <td><input name="Memo8" type="text" class="ftforminputsmall" id="Memo8" value="<%= tblreport.getMemo8() %>" size="40" maxlength="40"></td>
          </tr>
          <tr>
            <td>Signature on behalf of packer: </td>
          </tr>
        </table></td>
        <td width="29%"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="ftraisedtextlarge">
			<table width="100%"  border="0" cellpadding="2" cellspacing="2" bgcolor="#000000" class="ftraisedtextlarge">
              <tr>
                <td><div align="center" class="style3"><strong>FOR CHEMICAL </strong></div></td>
              </tr>
              <tr>
                <td><div align="center" class="style3"><strong>EMERGENCY</strong></div></td>
              </tr>
              <tr>
                <td><div align="center" class="style3"><strong>SPILL, LEAK, FIRE</strong></div></td>
              </tr>
              <tr>
                <td><div align="center" class="style3"><strong>EXPOSURE, OR ACCIDENT CALL:</strong></div></td>
              </tr>
              <tr>
                <td><div align="center">
                  <input name="Memo11" type="text" id="Memo11" value="<%= tblreport.getMemo11() %>" size="30" maxlength="30">
                </div></td>
              </tr>
            </table>              <p><strong> </strong></p>
              <p>&nbsp;</p></td>
          </tr>
          <tr>
            <td><textarea name="Memo9" cols="40" rows="3" class="ftforminputsmall" id="Memo9"><%= tblreport.getMemo9() %></textarea></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>


<%
}
catch (Exception e) {}
finally {
	connectionpool.releaseConnection( connection );
}	
%>


</body>

</html>
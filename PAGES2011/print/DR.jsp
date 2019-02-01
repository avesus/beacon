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
<style type="text/css">
<!--
body,td,th {
	font-size: 10px;
}
-->
</style><head>
	<title>Dock Receipt 2</title>  
	
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
  

	  <script type="text/javascript" language="javascript"> 
		var ie4adj = 0;
		var isMac  = false;
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions; 
		function onLoadFunctions() {
		//	onLoadFocus('recipientTypeTO');			
		}
	</script>
  

	<form method="post" action="<%= CONTROLLER %>/itt.print/Notification/Print" name="form" onSubmit="return check();">
<!--	
	<form method="post" action="<%= CONTROLLER %>/itt.print/PDFHbl/Print" name="form" onSubmit="return check();">
-->
	
<input type="hidden" name="currentpage" value="/pages/itt/print/DR2.jsp">
<input type="hidden" name="nextpage" value="/pages/itt/print/DR2.jsp">
<input type="hidden" name="CurrentDivId" value="<%= modelitt.getCurrentDivId() %>">
<input type="hidden" name="ShipmentProcessId" value="<%= modelitt.getShipmentProcessId() %>">
<input type="hidden" name="Action" value="DR2">
<input type="hidden" name="PrintId" value="DR2">

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
  <a href="<%= CONTROLLER %>/itt.print/Notification/Reload?ShipmentProcessId=<%= modelitt.getShipmentProcessId() %>&amp;nextpage=/pages/itt/print/DR2.jsp&amp;currentpage=/pages/itt/DR2.jsp&amp;Action=DR2" class="fteditortext">Load/Reload</a> 
</td> 
</tr>
</table>






<div id="mainLayer" style="position:absolute; left:5px; top:70px; z-index:1;">

<table width="100%" border="1" cellpadding="0" cellspacing="0" class="ftformtext">
<tr>
  <td width="50%" class="ftraisedtextlarge"><table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="30%">DATE:</td>
      <td width="70%"><%= util.Util.dateTextFormat2(tblreport.getReportDate()) %></td>
    </tr>
    <tr>
      <td width="30%">TO:</td>
      <td width="70%"><input name="Memo2" type="text" class="ftforminputsmall" value="<%= tblreport.getMemo2() %>" size="40" maxlength="40"></td>
    </tr>
    <tr>
      <td width="30%">FROM:</td>
      <td width="70%"><input name="Memo7" type="text" class="ftforminputsmall" value="<%= tblreport.getMemo7() %>" size="40" maxlength="40"></td>
    </tr>
    <tr>
      <td width="30%">RE:</td>
      <td width="70%"><input name="Memo8" type="text" class="ftforminputsmall" value="<%= tblreport.getMemo8() %>" size="40" maxlength="40"></td>
    </tr>
  </table></td>
  <td width="50%" valign="bottom">
  <table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="20%">FAX:</td>
      <td width="80%"><input name="Memo3" type="text" class="ftforminputsmall" value="<%= tblreport.getMemo3() %>"></td>
    </tr>
    <tr>
      <td width="20%">ITT REF :</td>
      <td width="80%"><%= tblreport.getJobNumber() %>&nbsp;</td>
    </tr>
  </table></td>
</tr>
<tr>
  <td width="50%">
  <table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC"> 
    <tr>
<%
name = "";
try{
address = modeladdress.getAddress(tblreport.getShipper());
name = address.getName();
} catch(Exception e){}
%>	
      <td width="30%">SHIPPER:</td>
      <td width="70%"><%= name %>&nbsp;</td>
    </tr>
    <tr>
<%
name = "";
addresscontact = new AddressContact();
try{
address = modeladdress.getAddress(tblreport.getConsignee());
name = address.getName();
} catch(Exception e){}
%>	
      <td width="30%">CONSIGNEE:</td>
      <td width="70%"><%= name %>&nbsp;</td>
    </tr>
    <tr>
<%
String addressContactName = "";
   		try{
   			addresscontact = modeladdress.getAddressContact(tblreport.getConsignee(), tblreport.getNotifyContact()); //nt017     			
   			addressContactName = addresscontact.getName();			
   		}catch(Exception e){}   
%>	
      <td width="30%">NOTIFY:</td>
      <td width="70%"><%= addressContactName %>&nbsp;</td>
    </tr>
    <tr>
<%
name = "";
try{
address = modeladdress.getAddress(tblreport.getCustomer());
name = address.getName();
} catch(Exception e){}
%>		
      <td width="30%">CUSTOMER:</td>
      <td width="70%"><%= name %>&nbsp;</td>
    </tr>
    <tr>
<%
cszc = "";
location = new Location();
try{
location = modeladdress.getLocation(tblreport.getPickupPlant());
//cszc = location.getDescription2();
cszc = location.getLocationName();
} catch(Exception e){}
%>	
      <td width="30%">PLANT:</td>
      <td width="70%"><%= cszc %>&nbsp;</td>
    </tr>
  </table></td>
  <td width="50%"><table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <%
name = ""; addr1 = ""; addr2 = ""; addr3 = ""; cszc = "";
address = new Address();
try{
address = modeladdress.getAddress(tblreport.getShipper());
name = address.getName();
addr1 = address.getAddr1();
addr2 = address.getAddr2();
addr3 = address.getAddr3();
cszc = address.getCity()+" "+address.getState()+" "+address.getPostalcode()+" "+address.getCountry();
} catch(Exception e){}
%>
    <tr>
      <td width="20%">REF:</td>
      <td width="80%"><%= tblreport.getShipperRef() %></td>
    </tr>
    <tr>
      <td width="20%">REF:</td>
      <td width="80%"><%= tblreport.getConsigneeRef() %></td>
    </tr>
    <tr>
      <td width="20%">REF:</td>
      <td width="80%"><%= tblreport.getNotifyRef() %></td>
    </tr>
    <tr>
      <td width="20%">REF:</td>
      <td width="80%"><%= tblreport.getCustomerRef() %></td>
    </tr>
    <tr>
      <td width="20%">&nbsp;</td>
      <td width="80%">&nbsp;</td>
    </tr>
  </table></td>
</tr>
<tr>
  <td colspan="2">&nbsp;</td>
  </tr>
<tr>
<td colspan="2"><table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="1" width="100%">
<% 
   
try {
	int row = 0;
	HashMap productList = new HashMap(); //nt014
	Iterator it = tblreport.getTblreportdetails().iterator();
    while (it.hasNext()) {
    	Tblreportdetail _Tblreportdetail = (Tblreportdetail) it.next(); 

		// check for duplicate Products
		if (!productList.containsKey(_Tblreportdetail.getProductId())) { //nt014
			productList.put(_Tblreportdetail.getProductId(),_Tblreportdetail.getProductId()); //nt014
					
String TradName = ""; 
try{
Product _Product = modelstd.getProduct( _Tblreportdetail.getProductId());
TradName = _Product.getTradName();
}catch(Exception e){}
try{TradName = TradName.substring(0,20);}catch(Exception e) {}
%>

  <tr>
    <td>PRODUCT:</td>
    <td><%= TradName %></td>
    <td>REF:</td>
    <td><%= _Tblreportdetail.getPickupPlantRef() %></td>
    <td><textarea name="MemoA<%= row %>" cols="30" rows="2" class="ftforminputsmall"><%= _Tblreportdetail.getMemoA() %></textarea></td>
  </tr>
  <tr>
    <td width="10%">&nbsp;</td>
    <td width="29%">&nbsp;</td>
    <td width="8%">&nbsp;</td>
    <td width="22%">&nbsp;</td>
    <td width="31%"><input name="MemoB<%= row %>" type="text" class="ftforminputsmall" value="<%= _Tblreportdetail.getMemoB() %>" size="30"></td>
  </tr>
  <%
// increment row counter
row++;
		}
   }
}
catch (Exception e) {}
%>
</table></td>
</tr>
<tr>
  <td colspan="2">
  <div align="center"><span class="ftheaderbartextlarge"><strong>BOOKING INFORMATION</strong></span></div>
  </td>
  </tr>
<tr>
  <td colspan="2"><table width="100%"  border="0" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
    <tr>
      <td width="26%">VESSEL:</td>
      <td width="50%"><%= tblreport.getVesselVoyage() %></td>
      <td width="8%">&nbsp;</td>
      <td width="8%">&nbsp;</td>
      <td width="8%">&nbsp;</td>
    </tr>
    <tr>
<%
//address = new Address();
//try{
//address = modeladdress.getAddress(tblreport.getShipLine());
//name = address.getName();
//} catch(Exception e){}
%>	
      <td>SHIPPING LINE: </td>
      <td><%= tblreport.getShipLine() %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>BOOKING #: </td>
      <td><%= tblreport.getBookingNumber() %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>CUT OFF: </td>
      <td><%= tblreport.getCutoffDateTime() %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
<%
name = "";
location = new Location();
try{
location = modeladdress.getLocation(tblreport.getPol());
name = location.getLocationName();
} catch(Exception e){}
%>	  
      <td>POL:</td>
      <td><%= name %></td>
      <td>ETS:</td>
      <td><%= util.Util.dateTextFormat2(tblreport.getPOLdateEst()) %></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
<%
name = "";
location = new Location();
try{
location = modeladdress.getLocation(tblreport.getPod());
name = location.getLocationName();
} catch(Exception e){}
%>	
      <td>POD:</td>
      <td><%= name %></td>
      <td>ETA:</td>
      <td><%= util.Util.dateTextFormat2(tblreport.getPODdateEst()) %></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
<%
//name = "";
//location = new Location();
//try{
//location = modeladdress.getLocation(tblreport.getFinalDelivery());
//name = location.getLocationName();
//} catch(Exception e){}
%>		
      <td>FINAL DELIVERY: </td>
      <td><%= tblreport.getFinalDelivery() %></td>
      <td>ETA:</td>
      <td><%= util.Util.dateTextFormat2(tblreport.getFinalDeliveryDateEst()) %></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
<%
name = "";
location = new Location();
try{
location = modeladdress.getLocation(tblreport.getPOLPier());
name = location.getLocationName();
} catch(Exception e){}
%>	  
      <td>PIER/LOCATION:</td>
      <td><%= name %></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>APPROXIMATE WEIGHT PER TANK: </td>
      <td><input name="WeightPerTankAprox" type="text" class="ftforminputsmall" value="<%= tblreport.getWeightPerTankAprox() %>">
        <input name="WeightType" type="text" class="ftforminputsmall" value="<%= tblreport.getWeightType() %>" size="10" maxlength="10"></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table></td>
  </tr>
<tr>
  <td colspan="2">
  <div align="center"><span class="ftheaderbartextlarge"><strong>INSTRUCTIONS</strong></span></div>
  </td>
  </tr>
<tr>
  <td colspan="2"><div align="center">
    <textarea name="Memo1" cols="100" class="ftforminputsmall"><%= tblreport.getMemo1() %></textarea>
  </div></td>
  </tr>
<tr>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
<tr>
  <td colspan="2"><table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="1" width="100%">
    <tr>
      <td width="15%">PLANT REF 
        </td>
      <td width="17%">TANK NUMBER </td>
      <td width="18%">APPT DATE </td>
      <td width="11%">APPT TIME </td>
      <td width="39%">ADDITIONAL INSTRUCTIONS </td>
    </tr>
  </table></td>
  </tr>
<tr>
  <td colspan="2"><table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="0" border="1" width="100%">
    <% 

   
try {
	int row = 0;
    Iterator it = tblreport.getTblreportdetails().iterator();
    while (it.hasNext()) {
    	Tblreportdetail _Tblreportdetail = (Tblreportdetail) it.next();	
		if (_Tblreportdetail.getReportType().equals("DR22")) {
		
String TankNumber = "";
int tsMaxGrossWeight = 0;
//try{
//TblTankSpecs _TblTankSpecs = modelitt.getTblTankSpecs( _Tblreportdetail.getTankNumber() );
//TankNumber = _TblTankSpecs.gettsTankNumber();
//}catch(Exception e){}	  
%>
    <tr>
<td width="15%"><%= _Tblreportdetail.getPickupPlantRef() %>
		</td>
      <td width="17%"><%= _Tblreportdetail.getTankNumber() %></td>
      <td width="18%"><%= util.Util.dateTextFormat2(_Tblreportdetail.getPuPlantApptDate()) %>
</td>
      <td width="11%"><%= _Tblreportdetail.getPuPlantApptTime() %></td>
      <td width="39%">
        <textarea name="AddInstructions<%= row %>" cols="30" rows="2" class="ftforminputsmall"><%= _Tblreportdetail.getAddInstructions() %></textarea></td>
      </tr>
    <%
// increment row counter

		}
row++;		
	}
}
catch (Exception e) {}
%>
  </table></td>
  </tr>
<tr>
  <td>&nbsp;</td>
  <td>&nbsp;</td>
</tr>
</table>

</div>

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
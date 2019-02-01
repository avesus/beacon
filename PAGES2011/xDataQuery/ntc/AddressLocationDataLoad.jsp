<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
MONITOR ADDRESS/LOCATION DATA LOAD
</title>
</head>
<body>
<h1>MONITOR ADDRESS/LOCATION DATA LOAD</h1>
<% 
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//LIVE
String user = "newport";
String password = "newport";
ResultSet resultSet;
PreparedStatement pstmt;
ResultSet resultSet2;
PreparedStatement pstmt2;

com.bureaueye.beacon.model.standard.bd.AddressBD addressBD = null;
com.bureaueye.beacon.model.standard.bd.LocationBD locationBD = null;
		try {
			org.hibernate.SessionFactory sessionFactory1 = new org.hibernate.cfg.Configuration()
			.configure("/hibernate.cfg.cluster3.xml")
			.buildSessionFactory();
addressBD = new com.bureaueye.beacon.model.standard.bd.AddressBD(sessionFactory1);
locationBD = new com.bureaueye.beacon.model.standard.bd.LocationBD(sessionFactory1);

				} catch (Exception e) {
			System.out.println("Exception error with sessionfactory init in business delagate: "+e.getMessage());
		}	
			

try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

pstmt = dbconn.prepareStatement("SELECT * FROM PUB.address "
//+"where addrkey > 'X'"
);
resultSet = pstmt.executeQuery();
while(resultSet.next()) {

System.out.println("addrkey = "+ resultSet.getString("addrkey"));

String typekeylist="";
String typekey="";
pstmt2 = dbconn.prepareStatement("SELECT * FROM PUB.addrtype where addrkey = '"+resultSet.getString("addrkey")+"'");
resultSet2 = pstmt2.executeQuery();
while(resultSet2.next()) {

if (typekeylist.equals("")) {
typekeylist = resultSet2.getString("typekey");
typekey = typekeylist;
}
else {
typekeylist = typekeylist + "|" + 	resultSet2.getString("typekey");				
}
					
}
pstmt2.close();
					
if (
typekeylist.indexOf("TER")!=-1 
|| typekeylist.indexOf("POR")!=-1 
|| typekeylist.indexOf("DEP")!=-1
) {

//location
com.bureaueye.beacon.model.standard.Location queryResult = new com.bureaueye.beacon.model.standard.Location();

					queryResult.setLocationkey(resultSet.getString("addrkey"));
					queryResult.setLocationcode(resultSet.getString("g4codekey"));
										queryResult.setPortUnicon(resultSet.getString("g4codekey"));
					queryResult.setLocationtypelist(typekeylist);
					queryResult.setLocationType(typekey);

					queryResult.setAddress1(resultSet.getString("addr1"));
					queryResult.setAddress2(resultSet.getString("addr2"));
					queryResult.setAddress3(resultSet.getString("addr3"));

					queryResult.setLocationName(resultSet.getString("name"));
					queryResult.setShortName(resultSet.getString("name"));
					queryResult.setCountrykey(resultSet.getString("country"));
					queryResult.setCountry(resultSet.getString("country"));


					queryResult.setG1key(resultSet.getString("g1codekey"));
					queryResult.setG2key(resultSet.getString("g2codekey"));
					queryResult.setG3key(resultSet.getString("g3codekey"));
					queryResult.setG4key(resultSet.getString("g4codekey"));
					queryResult.setContact(resultSet.getString("contact1"));

					queryResult.setPhone(resultSet.getString("telno1"));

					queryResult.setFax(resultSet.getString("faxno1"));
	

	try{				
locationBD.createOrUpdate(queryResult,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}

}

/*
if (
typekeylist.indexOf("CON")!=-1 
|| typekeylist.indexOf("CUS")!=-1 
|| typekeylist.indexOf("VEN")!=-1 
|| typekeylist.indexOf("OPR")!=-1
|| typekeylist.indexOf("SHI")!=-1
) {

com.bureaueye.beacon.model.standard.Address queryResult = new com.bureaueye.beacon.model.standard.Address();
					
					queryResult.setAddrkey(resultSet.getString("addrkey"));
					
					queryResult.setTypekeylist(typekeylist);
					queryResult.setTypekey(typekey);

					queryResult.setAddr1(resultSet.getString("addr1"));
					queryResult.setAddr2(resultSet.getString("addr2"));
					queryResult.setAddr3(resultSet.getString("addr3"));
					queryResult.setAddr4(resultSet.getString("addr4"));
					queryResult.setAddr5(resultSet.getString("addr5"));
					queryResult.setName(resultSet.getString("name"));
					queryResult.setCountry(resultSet.getString("country"));
					queryResult.setG1codekey(resultSet.getString("g1codekey"));
					queryResult.setG2codekey(resultSet.getString("g2codekey"));
					queryResult.setG3codekey(resultSet.getString("g3codekey"));
					queryResult.setG4codekey(resultSet.getString("g4codekey"));
					queryResult.setContact1(resultSet.getString("contact1"));
					queryResult.setContact2(resultSet.getString("contact2"));
					queryResult.setContact3(resultSet.getString("contact3"));
queryResult.setCcykey(resultSet.getString("ccykey"));
					queryResult.setCtitle1(resultSet.getString("ctitle1"));
					queryResult.setCtitle2(resultSet.getString("ctitle2"));
					queryResult.setCtitle3(resultSet.getString("ctitle3"));

					queryResult.setTelno1(resultSet.getString("telno1"));
					queryResult.setTelno2(resultSet.getString("telno2"));
					queryResult.setTelno3(resultSet.getString("telno3"));

					queryResult.setFaxno1(resultSet.getString("faxno1"));
					queryResult.setFaxno2(resultSet.getString("faxno2"));
					queryResult.setFaxno3(resultSet.getString("faxno3"));

					queryResult.setEmailno1(resultSet.getString("emailno1"));
					queryResult.setEmailno2(resultSet.getString("emailno2"));	
					queryResult.setEmailno3(resultSet.getString("emailno3"));	

	
	try {				
addressBD.createOrUpdate(queryResult,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}



}
*/




}

pstmt.close();
				 
				       dbconn.close();
}

catch (SQLException s)
{
	System.out.println("SQLException: "+s.getMessage());
	}
catch (ClassNotFoundException err)
{
		System.out.println("ClassNotFoundException: "+err.getMessage());
		}
	
%>
</body> 
</html>

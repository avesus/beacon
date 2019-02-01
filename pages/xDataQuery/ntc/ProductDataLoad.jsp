<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
MONITOR PRODUCT DATA LOAD
</title>
</head>
<body>
<h1>MONITOR PRODUCT DATA LOAD</h1>
<% 
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//LIVE
String user = "newport";
String password = "newport";
ResultSet resultSet;
PreparedStatement pstmt;
ResultSet resultSet2;
PreparedStatement pstmt2;

com.bureaueye.beacon.model.standard.bd.ProductBD productBD = null;

		try {
			org.hibernate.SessionFactory sessionFactory1 = new org.hibernate.cfg.Configuration()
			.configure("/hibernate.cfg.cluster3.xml")
			.buildSessionFactory();
			
productBD = new com.bureaueye.beacon.model.standard.bd.ProductBD(sessionFactory1);

				} catch (Exception e) {
			System.out.println("Exception error with sessionfactory init in business delagate: "+e.getMessage());
		}	
			

try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

pstmt = dbconn.prepareStatement("SELECT  prodcode, imo, unno, flashp, tempunit, packgrp, ems, harmcode, tradname, chemname FROM PUB.product "
);
resultSet = pstmt.executeQuery();
while(resultSet.next()) {

System.out.println("prodcode = "+ resultSet.getString("prodcode"));

					


com.bureaueye.beacon.model.standard.Product queryResult = new com.bureaueye.beacon.model.standard.Product();

					queryResult.setProductkey(resultSet.getString("prodcode"));				
					queryResult.setImo(resultSet.getString("imo"));
					queryResult.setUnno(resultSet.getString("unno"));
					queryResult.setFlashp(resultSet.getString("flashp"));
					queryResult.setTempunit(resultSet.getString("tempunit"));
					queryResult.setPackgrp(resultSet.getString("packgrp"));
					queryResult.setEms(resultSet.getString("ems"));
					queryResult.setHarmcode(resultSet.getString("harmcode"));
					queryResult.setTradname(resultSet.getString("tradname"));
					queryResult.setChemname(resultSet.getString("chemname"));
					//queryResult.setTxt(resultSet.getString("txt")); 
					//queryResult.setLdesc(resultSet.getString("ldesc"));	
					
	
/*
	try{				
productBD.createOrUpdate(queryResult,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
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

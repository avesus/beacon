<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
Test PROGRESS DB Connection
</title>
</head>
<body>
<h1>Test PROGRESS DB Connection</h1>
<% 
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//QA
String user = "newport";
String password = "newport";
ResultSet resultSet;
PreparedStatement sql;



try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement("SELECT * FROM pub.product WHERE   product.prodcode = 'DESMODUR N3300'");
resultSet = sql.executeQuery();
while(resultSet.next())
{
System.out.println(resultSet.getString("prodcode"));
System.out.println(resultSet.getString("tradname"));
System.out.println(resultSet.getString("chemname"));					
System.out.println(resultSet.getString("imo"));
System.out.println(resultSet.getString("unno"));
System.out.println(resultSet.getString("flashp"));
System.out.println(resultSet.getString("tempunit"));
System.out.println(resultSet.getString("packgrp"));
System.out.println(resultSet.getString("ems"));
System.out.println(resultSet.getString("harmcode"));
System.out.println(resultSet.getString("ldesc"));
}


				 
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

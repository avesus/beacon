<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
Unittec Data Query
</title>
</head>
<body>
<h1>Unittec Data Query</h1>
<% 
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//LIVE
String user = "newport";
String password = "newport";
ResultSet resultSet;
PreparedStatement sql;



try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement(
"select "+
"Gross, "+ 
"Tare, "+
"unitkey "+
"from pub.unittec "+
"where unittec.unitkey = 'CRXU8678570' "+
""
);
resultSet = sql.executeQuery();
while(resultSet.next())
{
System.out.println(resultSet.getString(1));
System.out.println(resultSet.getString(2));
System.out.println(resultSet.getString(3));
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

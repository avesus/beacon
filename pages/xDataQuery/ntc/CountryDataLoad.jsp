<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
MONITOR COUNTRY QUERY
</title>
</head>
<body>
<h1>MONITOR COUNTY QUERY</h1>
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


sql = dbconn.prepareStatement("SELECT * FROM PUB.g3code  ");
resultSet = sql.executeQuery();
while(resultSet.next())
{


System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2)
+" - "+resultSet.getString(3)
+" - "+resultSet.getString(4)
+" - "+resultSet.getString(5)
);
	
					

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

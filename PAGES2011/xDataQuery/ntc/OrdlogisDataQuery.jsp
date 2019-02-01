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
String url = "jdbc:jdbcprogress:T:cpg-newport:9600:mismon";//QA
String user = "newport";
String password = "newport";
ResultSet results;
PreparedStatement sql;



try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement("SELECT * FROM PUB.ordlogis where ordno = '56079400'");
results = sql.executeQuery();
while(results.next())
{
System.out.println(results.getString("addr01key"));
System.out.println(results.getString("addr02key"));
System.out.println(results.getString("addr03key"));
System.out.println(results.getString("addr04key"));
System.out.println(results.getString("addr05key"));
System.out.println(results.getString("addr06key"));
System.out.println(results.getString("addr07key"));
System.out.println(results.getString("addr08key"));
System.out.println(results.getString("addr09key"));
System.out.println(results.getString("addr10key"));
System.out.println(results.getString("addr11key"));
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

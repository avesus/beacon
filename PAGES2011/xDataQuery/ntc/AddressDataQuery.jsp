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
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//LIVE
String user = "newport";
String password = "newport";
ResultSet results;
PreparedStatement sql;



try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement("SELECT * FROM PUB.address WHERE name LIKE 'Mae%'");
results = sql.executeQuery();
while(results.next())
{
System.out.println(results.getString("addrkey"));
System.out.println(results.getString("typekey"));
System.out.println(results.getString("addr1"));
System.out.println(results.getString("addr2"));
System.out.println(results.getString("addr3"));
System.out.println(results.getString("addr4"));
System.out.println(results.getString("addr5"));
System.out.println(results.getString("name"));
System.out.println(results.getString("shortname"));
//System.out.println(results.getString("lawshipaddr"));
//System.out.println(results.getString("country"));
//System.out.println(results.getString("town"));
//System.out.println(results.getString("g1codekey"));
//System.out.println(results.getString("g2codekey"));
//System.out.println(results.getString("g3codekey"));
//System.out.println(results.getString("g4codekey"));
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

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

<table width="100%" cellspacing="0" cellpadding="0" border="0">
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

sql = dbconn.prepareStatement("SELECT * FROM PUB.cost order by costorcharge");
results = sql.executeQuery();
while(results.next())
{
%>
<tr>
<td>
<%= results.getString("cstcode") %>|
<%= results.getString("descr") %>|
<%= results.getString("tax") %>|
<%= results.getString("csttype") %>|
<%= results.getString("cstcatg") %>|
<%= results.getString("tcode") %>|
<%= results.getString("costorcharge") %>
</td>
</tr>
<%
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
</table>
</body> 
</html>

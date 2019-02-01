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
ResultSet results;
PreparedStatement sql;



try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement(
"SELECT * FROM PUB.ordcharge where "+
"ordno = '56144120'"
//"(chgcode = 'FRRTC' or chgcode = 'TCRC') and xdate > '2011-01-01'"
);
results = sql.executeQuery();
while(results.next())
{
System.out.println(results.getString("chgcode"));
System.out.println(results.getString("ordno"));
System.out.println(results.getString("chgamt"));
System.out.println(results.getString("invccy"));
System.out.println(results.getString("ccycode"));
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

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

sql = dbconn.prepareStatement("SELECT * FROM PUB.ordprod where ordno = '56098678'");
results = sql.executeQuery();
while(results.next())
{
System.out.println(results.getString("prodcode"));
System.out.println(results.getString("prodname"));
System.out.println(results.getString("imo"));
System.out.println(results.getString("unno"));
System.out.println(results.getString("weight"));
System.out.println(results.getString("wghtunit"));
System.out.println(results.getString("volume"));
System.out.println(results.getString("volunit"));
System.out.println(results.getString("minweight"));
System.out.println(results.getString("maxweight"));
System.out.println(results.getString("ldgtemp"));
System.out.println(results.getString("dchtemp"));
System.out.println(results.getString("lqdtemp"));
System.out.println(results.getString("surftemp"));
System.out.println(results.getString("tempunit"));
System.out.println("");
System.out.println(results.getString("loadweight"));
System.out.println(results.getString("lodwghtunit"));
System.out.println(results.getString("loadvolume"));
System.out.println(results.getString("lodvolunit"));
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

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

String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";
String user = "newport";
String password = "newport";
ResultSet results;
PreparedStatement sql;



try {
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement("SELECT * FROM PUB.despmov where despmov.jobno = '56092517' "+
" AND toplanactsts='P' order by frdate desc");

results = sql.executeQuery();
if (results.next()) {

System.out.println("jobno="+results.getString("jobno"));
System.out.println("sectcode="+results.getString("sectcode"));

System.out.println(" ");

System.out.println(results.getString("fraddrkey"));
System.out.println(results.getString("frg1key"));
System.out.println(results.getString("frg2key"));
System.out.println(results.getString("frg3key"));
System.out.println(results.getString("frg4key"));

System.out.println(" ");

System.out.println(results.getString("planfrdate"));
System.out.println(results.getString("planfrtime"));
System.out.println(results.getString("frdate"));
System.out.println(results.getString("frtime"));
System.out.println(results.getString("frplanactsts"));

System.out.println(" ");

System.out.println(results.getString("toaddrkey"));
System.out.println(results.getString("tog1key"));
System.out.println(results.getString("tog2key"));
System.out.println(results.getString("tog3key"));
System.out.println(results.getString("tog4key"));

System.out.println(" ");

System.out.println(results.getString("plantodate"));
System.out.println(results.getString("plantotime"));
System.out.println(results.getString("todate"));
System.out.println(results.getString("totime"));
System.out.println(results.getString("toplanactsts"));

System.out.println(" ");

System.out.println(results.getString("vessel"));
System.out.println(results.getString("voyage"));
System.out.println(results.getString("vessellloydsno"));

System.out.println(" ");

System.out.println(results.getString("vndr"));
System.out.println(results.getString("carrier"));

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

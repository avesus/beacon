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

<table width="100%" cellspacing="1" cellpadding="1" border="1">
<tr>
<td><strong>FIELD</strong></td>
<td><strong>VALUE</strong></td>
</tr>

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
"SELECT * FROM PUB.despmov "+
"inner join PUB.ordhdr ON ordhdr.jobno = despmov.jobno "+
"where ordhdr.ordno = '56121433' "+
//"sectcode = 'SHIP'"
" order by frdate "+
""
);
results = sql.executeQuery();
int count=1;
while(results.next())
{
%>

<tr><td colspan="4"><strong>RECORD <%= count %></strong></td></tr>
<tr>
  <td>ordno</td>
<td><%= results.getString("ordno") %></td>
</tr>

<tr>
  <td>sectcode</td>
<td><%= results.getString("sectcode") %></td>
</tr>

<tr>
  <td>fraddrkey</td>
<td><%= results.getString("fraddrkey") %></td>
</tr>

<tr>
  <td>frdate</td>
<td><%= results.getString("frdate") %></td>
</tr>
<tr>
  <td>planfrdate</td>
<td><%= results.getString("planfrdate") %></td>
</tr>
<tr>
  <td>frplanactsts</td>
<td><%= results.getString("frplanactsts") %></td>
</tr>



<tr>
  <td>toaddrkey</td>
<td><%= results.getString("toaddrkey") %></td>
</tr>

<tr>
  <td>todate</td>
<td><%= results.getString("todate") %></td>
</tr>
<tr>
  <td>planfrdate</td>
<td><%= results.getString("plantodate") %></td>
</tr>
<tr>
  <td>toplanactsts</td>
<td><%= results.getString("toplanactsts") %></td>
</tr>


<tr>
  <td>vessel</td>
<td><%= results.getString("vessel") %></td>
</tr>

<tr>
  <td>voyage</td>
<td><%= results.getString("voyage") %></td>
</tr>

<tr>
  <td>vessellloydsno</td>
<td><%= results.getString("vessellloydsno") %></td>
</tr>


<tr>
  <td colspan="4">&nbsp;</td></tr>
<%
count++;
}
%>
<tr> <td colspan="6">count: <%= count %></td></tr>
<%	


				 
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

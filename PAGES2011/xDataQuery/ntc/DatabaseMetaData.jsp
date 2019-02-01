<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
DB Meta Data
</title>
</head>
<body>
<h1>DB Meta Data</h1>



<table width="100%" cellspacing="1" cellpadding="1" border="1">
<tr>
<td><strong>NAME</strong></td>
<td><strong>LABEL</strong></td>
<td><strong>TYPE CLASS</strong></td>
<td><strong>TYPE NAME</strong></td>
<td><strong>SIZE</strong></td>
<td><strong>SCALE</strong></td>
<td><strong>PRECISION</strong></td>
<td><strong>CATALOG</strong></td>
</tr>
<% 


java.sql.Statement stmt;
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//LIVE
String user = "newport";
String password = "newport";
ResultSet resultSet;
PreparedStatement sql;


try {
		
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection con = DriverManager.getConnection(url, user, password);
// con is a Connection object
String sql="SELECT * FROM PUB.location";

stmt = con.createStatement();
resultSet = stmt.executeQuery(sql);


int count=1;

ResultSetMetaData rsmd = resultSet.getMetaData();
int numberOfColumns = rsmd.getColumnCount();
 
while(count<numberOfColumns)
{
%>

<tr>
  <td><%= rsmd.getColumnName(count) %></td>
  <td><%= rsmd.getColumnLabel(count) %></td>
  <td><%= rsmd.getColumnClassName(count) %></td>
  <td><%= rsmd.getColumnTypeName(count) %></td>
  <td><%= rsmd.getColumnDisplaySize(count) %></td>  
    <td><%= rsmd.getScale(count) %></td>  
    <td><%= rsmd.getPrecision(count) %></td>     
        <td><%= rsmd.getCatalogName(count) %></td>  
</tr>

<%

count++;
}
				 
con.close();

} catch (SQLException s) {
	System.out.println("SQLException: "+s.getMessage());
} catch (ClassNotFoundException err) {
	System.out.println("ClassNotFoundException: "+err.getMessage());
}
	
%>
</table>
</body> 
</html>

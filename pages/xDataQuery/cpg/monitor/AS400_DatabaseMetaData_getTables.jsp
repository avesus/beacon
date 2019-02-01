<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
AS400 DatabaseMetaData getTables
</title>
</head>
<body>
<h1>AS400 DatabaseMetaData getTables</h1>



<table width="100%" cellspacing="1" cellpadding="1" border="1">

<% 

String host = "10.1.1.20";//test depotsystem
String user = "CLEDJACP";
String password = "dja";
String url = "jdbc:as400://" + host;
ResultSet resultSet;
java.sql.Statement stmt;



try {
		
Class.forName("com.ibm.as400.access.AS400JDBCDriver"); 

Connection con = DriverManager.getConnection(url, user, password);

DatabaseMetaData meta = con.getMetaData();



%>
<tr>
<td colspan="5"><strong>CATALOG</strong></td>
</tr>
<%

ResultSet catalogsResultSet = meta.getCatalogs(); 
//System.out.println(catalogsResultSet.next());
while (catalogsResultSet.next()) {     
%>
<tr>
  <td><%= catalogsResultSet.getString(1)  %></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>  
</tr>
<%
}
catalogsResultSet.close();

%>
<tr>
<td colspan="5"><strong>SCHEMA</strong></td>
</tr>
<%

ResultSet schemasResultSet = meta.getSchemas(); 
//System.out.println(schemasResultSet.next());
while (schemasResultSet.next()) {     
%>
<tr>
  <td colspan="5"><%= schemasResultSet.getString(1)  %></td>  
</tr>
<%
}
schemasResultSet.close();


%>
<tr>
<td><strong>TABLE_CAT</strong></td>
<td><strong>TABLE_SCHEM</strong></td>
<td><strong>TABLE_NAME</strong></td>
<td><strong>TABLE_TYPE</strong></td>
<td><strong>REMARKS</strong></td>
</tr>
<%

String catalog = "S1028316";
//String schema = "DRDB50";
String schema = "DBMON";
//String schema = "CPG";
//String schema = "S.MONF001";
//String schema = "S.MON244";
//String schema = "NEWPORT";
//String schema = "#LIBRARY";
//String schema = "QSYS";
String table   = "%"; // find all tables
String types[]  = {"TABLE", "VIEW", "SYSTEM TABLE"};//this did not find DMSDTAT tables????
ResultSet res = meta.getTables(catalog, schema, table, null);

while (res.next()) {
      
%>
<tr>
  <td><%= res.getString("TABLE_CAT")  %></td>
  <td><%= res.getString("TABLE_SCHEM") %></td>
  <td><%= res.getString("TABLE_NAME") %></td>
  <td><%= res.getString("TABLE_TYPE") %></td>
  <td><%= res.getString("REMARKS") %></td>  
</tr>
<%
           
      }
      res.close();




				 
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

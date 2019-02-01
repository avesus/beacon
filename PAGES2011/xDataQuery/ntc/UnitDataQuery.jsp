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
ResultSet resultSet;
PreparedStatement sql;



try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

sql = dbconn.prepareStatement(
"select "+
//"unit.invsts, "+ 
//"address.addrkey, "+
//"count(unit.invsts) "+
" unit.deleted, unit.actoffdate, unit.write_off_flag, unit.unitkey "+
"from pub.unit "+
			"WHERE      unit.deleted = '0' "+ 
			"  AND unit.write_off_flag = '0' "+
			" AND unit.unitkey like 'CRXU87%' "+
//"Group By unit.invsts, address.addrkey"
""
);
resultSet = sql.executeQuery();
while(resultSet.next())
{
System.out.println(resultSet.getInt(1));
System.out.println(resultSet.getDate(2));
System.out.println(resultSet.getInt(3));
System.out.println(resultSet.getString(4));
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

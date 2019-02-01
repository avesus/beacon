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

sql = dbconn.prepareStatement("SELECT * FROM PUB.ordhdr where cust begins 'BASF'");
results = sql.executeQuery();
while(results.next())
{
/*System.out.println(results.getString("Oblnumorig"));
System.out.println(results.getString("consign"));
System.out.println(results.getString("shipper"));
System.out.println("");
System.out.println(results.getString("ldgaddrkey"));
System.out.println(results.getString("ldgg1key"));
System.out.println(results.getString("ldgg2key"));
System.out.println(results.getString("ldgg3key"));
System.out.println(results.getString("ldgg4key"));
System.out.println(results.getString("dchaddrkey"));
System.out.println(results.getString("dchg1key"));
System.out.println(results.getString("dchg2key"));
System.out.println(results.getString("dchg3key"));
System.out.println(results.getString("dchg4key"));
System.out.println("");
System.out.println(results.getString("plan_loading_date"));
System.out.println(results.getString("frplanldgtime"));
System.out.println(results.getString("toplanldgdate"));
System.out.println(results.getString("toplanldgtime"));
System.out.println(results.getString("frldgdate"));
System.out.println(results.getString("frldgtime"));
System.out.println(results.getString("toldgdate"));
System.out.println(results.getString("toldgtime"));
System.out.println("");
System.out.println(results.getString("frplandchdate"));
System.out.println(results.getString("frplandchtime"));
System.out.println(results.getString("toplandchdate"));
System.out.println(results.getString("toplandchtime"));
System.out.println(results.getString("frdchdate"));
System.out.println(results.getString("frdchtime"));
System.out.println(results.getString("todchdate"));
System.out.println(results.getString("todchtime"));
System.out.println("");
System.out.println(results.getString("ldgport"));
System.out.println(results.getString("dchport"));
System.out.println(results.getString("eta"));
System.out.println(results.getString("etd"));
System.out.println(results.getString("ccycode"));
  
System.out.println(results.getString("oblnumorig"));
System.out.println(results.getString("oblnumcopy"));
System.out.println("rtrtm_reasonmreason="+results.getString("rtm_reason"));*/

/*String actvcode=results.getString("actvcode");
System.out.println(actvcode);
try{System.out.println(actvcode.substring(0,4).toUpperCase());}catch(Exception e){}*/




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

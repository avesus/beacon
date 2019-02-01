<html>
<head>
<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
%>
<title>
MONITOR QUOTATION DATA LOAD
</title>
</head>
<body>
<h1>MONITOR QUOTATION DATA LOAD</h1>



<table width="100%">



<% 
String url = "jdbc:jdbcprogress:T:cpg-newport:9500:mismon";//LIVE
String user = "newport";
String password = "newport";
ResultSet resultSet1;
PreparedStatement pstmt1;
ResultSet resultSet2;
PreparedStatement pstmt2;
ResultSet resultSet3;
PreparedStatement pstmt3;
ResultSet resultSet4;
PreparedStatement pstmt4;
ResultSet resultSet5;
PreparedStatement pstmt5;


com.bureaueye.beacon.model.quotation.bd.QuohdrBD quohdrBD = null;
com.bureaueye.beacon.model.quotation.bd.QuocostBD quocostBD = null;
com.bureaueye.beacon.model.quotation.bd.QuochargeBD quochargeBD = null;
com.bureaueye.beacon.model.quotation.bd.QuomovBD quomovBD = null;
com.bureaueye.beacon.model.quotation.bd.QuonoteBD quonoteBD = null;
com.bureaueye.beacon.model.quotation.bd.QuoprodBD quoprodBD = null;

		try {
			org.hibernate.SessionFactory sessionFactory1 = new org.hibernate.cfg.Configuration()
			.configure("/hibernate.cfg.xml")
			.buildSessionFactory();
quohdrBD = new com.bureaueye.beacon.model.quotation.bd.QuohdrBD(sessionFactory1);
quocostBD = new com.bureaueye.beacon.model.quotation.bd.QuocostBD(sessionFactory1);
quochargeBD = new com.bureaueye.beacon.model.quotation.bd.QuochargeBD(sessionFactory1);
quomovBD = new com.bureaueye.beacon.model.quotation.bd.QuomovBD(sessionFactory1);
quonoteBD = new com.bureaueye.beacon.model.quotation.bd.QuonoteBD(sessionFactory1);
quoprodBD = new com.bureaueye.beacon.model.quotation.bd.QuoprodBD(sessionFactory1);
				} catch (Exception e) {
			System.out.println("Exception error with sessionfactory init in business delagate: "+e.getMessage());
		}	
			

try
{
	
	
Class.forName("com.progress.sql.jdbc.JdbcProgressDriver"); 

Connection dbconn = DriverManager.getConnection(url, user, password);
System.out.println(url);

pstmt1 = dbconn.prepareStatement("SELECT * FROM PUB.quohdr where quodate > '2010-07-26' order by quodate desc");
resultSet1 = pstmt1.executeQuery();
while(resultSet1.next()) {


%> 
<tr>
<td colspan="3">============================================================================================</td>
</tr>
<tr>
<td colspan="3">QUOHDR</td>
</tr>
<tr>
<td>QUOTNO: <%= resultSet1.getString("quotno") %></td>
<td>QUODATE: <%= resultSet1.getString("quodate") %></td>
<td>CUST: <%= resultSet1.getString("cust") %></td>
</tr>
<% 


//init quohdr fields
com.bureaueye.beacon.model.quotation.Quohdr queryResult1 = new com.bureaueye.beacon.model.quotation.Quohdr();

queryResult1.setQuotno(resultSet1.getString("quotno"));
queryResult1.setQuotedate(resultSet1.getDate("quodate"));

//update quohdr					
try{				
//quohdrBD.createOrUpdate(queryResult1,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
					
//costs
pstmt2 = dbconn.prepareStatement("SELECT * FROM PUB.quocost where quotno = '"+resultSet1.getString("quotno")+"'");
resultSet2 = pstmt2.executeQuery();
while(resultSet2.next()) {


%> 
<tr>
<td colspan="3">--------------------------------------------------------------------------------------------</td>
</tr>
<tr>
<td colspan="3">QUOCOST</td>
</tr>
<tr>
<td>VNDR: <%= resultSet2.getString("vndr") %></td>
<td>CSTCODE: <%= resultSet2.getString("cstcode") %></td>
<td>CSTAMT: <%= resultSet2.getString("cstamt") %></td>
</tr>
<% 


//init quohdr fields
com.bureaueye.beacon.model.quotation.Quocost queryResult2 = new com.bureaueye.beacon.model.quotation.Quocost();

					queryResult2.setVendoraddrkey(resultSet2.getString("vndr"));
					queryResult2.setCostkey(resultSet2.getString("cstcode"));

//update quocost					
try{				
//quocostBD.createOrUpdate(queryResult2,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
}//loop resultSet2
pstmt2.close();
					




//charges
pstmt3 = dbconn.prepareStatement("SELECT * FROM PUB.quocharge where quotno = '"+resultSet1.getString("quotno")+"'");
resultSet3 = pstmt3.executeQuery();
while(resultSet3.next()) {


%> 
<tr>
<td colspan="3">--------------------------------------------------------------------------------------------</td>
</tr>
<tr>
<td colspan="3">QUOCHARGE</td>
</tr>
<tr>
<td>CUST: <%= resultSet3.getString("cust") %></td>
<td>CHGCODE: <%= resultSet3.getString("chgcode") %></td>
<td>CHGAMT: <%= resultSet3.getString("chgamt") %></td>
</tr>
<% 


//init  fields
com.bureaueye.beacon.model.quotation.Quocharge queryResult3 = new com.bureaueye.beacon.model.quotation.Quocharge();

					queryResult3.setCustomeraddrkey(resultSet3.getString("cust"));
					queryResult3.setChargekey(resultSet3.getString("chgcode"));

//update quocharge			
try{				
//quochargeBD.createOrUpdate(queryResult3,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
}//loop resultSet3
pstmt3.close();




//movements
pstmt4 = dbconn.prepareStatement("SELECT * FROM PUB.quomov where quotno = '"+resultSet1.getString("quotno")+"'");
resultSet4 = pstmt4.executeQuery();
while(resultSet4.next()) {


%> 
<tr>
<td colspan="3">--------------------------------------------------------------------------------------------</td>
</tr>
<tr>
<td colspan="3">QUOMOV</td>
</tr>
<tr>
<td>VNDR: <%= resultSet4.getString("cust") %></td>
<td>SECTCODE: <%= resultSet4.getString("chgcode") %></td>
<td>CARRIER: <%= resultSet4.getString("carrier") %></td>
</tr>
<% 


//init fields
com.bureaueye.beacon.model.quotation.Quomov queryResult4 = new com.bureaueye.beacon.model.quotation.Quomov();

					queryResult4.setSectionkey(resultSet4.getString("sectcode"));
					queryResult4.setVendoraddrkey(resultSet4.getString("vndr"));

//update move			
try{				
//quomovBD.createOrUpdate(queryResult4,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
}//loop resultSet4
pstmt4.close();




//products
pstmt5 = dbconn.prepareStatement("SELECT * FROM PUB.quoprod where quotno = '"+resultSet1.getString("quotno")+"'");
resultSet5 = pstmt5.executeQuery();
while(resultSet5.next()) {


%> 
<tr>
<td colspan="3">--------------------------------------------------------------------------------------------</td>
</tr>
<tr>
<td colspan="3">QUOPROD</td>
</tr>
<tr>
<td>PRODCODE: <%= resultSet5.getString("prodcode") %></td>
<td>PRODNAME: <%= resultSet5.getString("prodname") %></td>
<td>VOLUME: <%= resultSet5.getString("volume") %></td>
</tr>
<% 


//init fields
com.bureaueye.beacon.model.quotation.Quoprod queryResult5 = new com.bureaueye.beacon.model.quotation.Quoprod();

					queryResult5.setProductkey(resultSet5.getString("productkey"));
					queryResult5.setProductname(resultSet5.getString("prodname"));

//update product			
try{				
//quoprodBD.createOrUpdate(queryResult5,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
}//loop resultSet5
pstmt5.close();



//text
pstmt6 = dbconn.prepareStatement("SELECT * FROM PUB.quotxt where quotno = '"+resultSet1.getString("quotno")+"'");
resultSet6 = pstmt6.executeQuery();
while(resultSet6.next()) {


%> 
<tr>
<td colspan="3">--------------------------------------------------------------------------------------------</td>
</tr>
<tr>
<td colspan="3">QUOTXT</td>
</tr>
<tr>
<td>TXT: <%= resultSet6.getString("txt") %></td>
<td></td>
<td></td>
</tr>
<% 


//init fields
com.bureaueye.beacon.model.quotation.Quonote queryResult6 = new com.bureaueye.beacon.model.quotation.Quonote();

					queryResult6.setNote1(resultSet4.getString("txt"));

//update note			
try{				
//quonoteBD.createOrUpdate(queryResult6,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
}//loop resultSet6
pstmt6.close();




//logis
pstmt7 = dbconn.prepareStatement("SELECT * FROM PUB.quologis where quotno = '"+resultSet1.getString("quotno")+"'");
resultSet7 = pstmt7.executeQuery();
if (resultSet7.next()) {


%> 
<tr>
<td colspan="3">--------------------------------------------------------------------------------------------</td>
</tr>
<tr>
<td colspan="3">QUOLOGIS</td>
</tr>
<tr>
<td>ADDR01KEY: <%= resultSet7.getString("addr01key") %></td>
<td>ADDR02KEY: <%= resultSet7.getString("addr02key") %></td>
<td>ADDR03KEY: <%= resultSet7.getString("addr03key") %></td>
</tr>
<% 


//init fields
//com.bureaueye.beacon.model.quotation.Quoaddr queryResult7 = new com.bureaueye.beacon.model.quotation.Quoaddr();

					//queryResult7.setNote1(resultSet7.getString("addr01key"));

//update note			
try{				
//quohdrBD.createOrUpdate(queryResult1,new com.bureaueye.beacon.model.standard.User());
} catch (Exception e) {
}
					
}//loop resultSet7
pstmt7.close();





}//loop resultSet1



pstmt1.close();
				 
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

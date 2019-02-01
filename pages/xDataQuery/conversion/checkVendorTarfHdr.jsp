
                                  <%@ page language="Java" %>
                                  <%@ page import="java.sql.*" %>
                                  <%
                                  // the URL of my database
                                  String url = "jdbc:mysql://localhost:3306/coding";

                                  // the connection to the database and return statement
                                  Connection con;
                                  %>
                                  <html>
                                  <head>
                                  <title>check vendor tariff vendors</title>
                                  </head>
                                  <body>
                                  <h1>updating check.....</h1>
                                  <hr color="#009933" noshade>
<table border="1">                            
                                  <%

String query = 
         (
         "SELECT tolocationkey, fromlocationkey, tslocationkey, vendoraddrkey, vendtarfhdr_id, costkey "+
         "FROM vendortariffhdr "
         );

                                  // create a connection to the database
                                  try
                                  {
                                  Class.forName("org.gjt.mm.mysql.Driver");
                                  }
                                  catch( Exception e )
                                  {
                                  out.println("Error: Cant find driver class.");
                                  return;
                                  }

                                  try
                                  {
                                  String user;
                                  String pass;
                                  con = DriverManager.getConnection(url, "", "");
				  Statement stmt = con.createStatement();
				  ResultSet rs = stmt.executeQuery(query);
int count = 1;
while (rs.next()) {
String _tolocationkey = rs.getString("tolocationkey");
String _vendoraddrkey = rs.getString("vendoraddrkey");
String _fromlocationkey = rs.getString("fromlocationkey");
String _tslocationkey = rs.getString("tslocationkey");
String _vendtarfhdr_id = rs.getString("vendtarfhdr_id");
String _costkey = rs.getString("costkey");

        PreparedStatement pstmt = con.prepareStatement("select * from address where addrkey = ?");
		pstmt.setString(1, _vendoraddrkey );						
         // Execute the query
		 ResultSet rs2 = pstmt.executeQuery();
		 if (!rs2.next()) {
			count++;
			%>
			<tr><td>
			<%= _vendoraddrkey %>
			</td>
			</tr>
			<%		 		
		}
	  pstmt.close();


        pstmt = con.prepareStatement("select * from cost where costkey = ?");
		pstmt.setString(1, _costkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (!rs2.next()) {
			count++;
			%>
			<tr><td>
			<%= _costkey %>
			</td>
			</tr>
			<%
				 		
		}
	  pstmt.close();
	  	  
		  
        pstmt = con.prepareStatement("select * from location where locationkey = ?");
		pstmt.setString(1, _tolocationkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (!rs2.next()) {
			count++;
			%>
			<tr><td>
			<%= _tolocationkey %>
			</td>
			</tr>
			<%
			
         	PreparedStatement updstmt = con.prepareStatement("delete from vendortariffhdr where vendtarfhdr_id = ?");
		 	updstmt.setString(1, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();		 		
		}
	  pstmt.close();		



        pstmt = con.prepareStatement("select * from location where locationkey = ?");
		pstmt.setString(1, _fromlocationkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (!rs2.next()) {
			count++;
			%>
			<tr><td>
			<%= _fromlocationkey %>
			</td>
			</tr>
			<%
			
         	PreparedStatement updstmt = con.prepareStatement("delete from vendortariffhdr where vendtarfhdr_id = ?");
		 	updstmt.setString(1, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();		 		
		}
	  pstmt.close();
	  
	  
        pstmt = con.prepareStatement("select * from location where locationkey = ?");
		pstmt.setString(1, _tslocationkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (!rs2.next() && !_tslocationkey.equals("")) {
			count++;
			%>
			<tr><td>
			<%= _tslocationkey %>
			</td>
			</tr>
			<%
			
         	PreparedStatement updstmt = con.prepareStatement("delete from vendortariffhdr where vendtarfhdr_id = ?");
		 	updstmt.setString(1, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();		 		
		}
	  pstmt.close();	  
	 %>
	  			<tr><td>
			<%= count %>

			</td>
			</tr>
			<% count++; %>	
			
			<%  				  				  
}

				  stmt.close();
                                  con.close();
                                  }
                                  catch( SQLException e )
                                  {
                                  out.println("Error: "+e.getMessage()+"<br>"+e);
                                  }
                                  %>
								  </table>
                                  </body>
                                  </html>
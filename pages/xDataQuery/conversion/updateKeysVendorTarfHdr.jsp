
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
                                  <title>update Keys vendor tariff vendors</title>
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

%>
<tr>
<%

String _tolocationkey = rs.getString("tolocationkey");
String _vendoraddrkey = rs.getString("vendoraddrkey");
String _fromlocationkey = rs.getString("fromlocationkey");
String _tslocationkey = rs.getString("tslocationkey");
String _vendtarfhdr_id = rs.getString("vendtarfhdr_id");
String _costkey = rs.getString("costkey");

%>
<td><%= _vendtarfhdr_id %></td>
<%

        PreparedStatement pstmt = con.prepareStatement("select address.addrkey from address where addrkey = ?");
		pstmt.setString(1, _vendoraddrkey );						
         // Execute the query
		 ResultSet rs2 = pstmt.executeQuery();
		 if (rs2.next()) {
			%>
			<td>
			<%= _vendoraddrkey %>
			</td>
			
			<%	
         	PreparedStatement updstmt = con.prepareStatement("update  vendortariffhdr set vendortariffhdr.vendoraddrkey = ? where vendtarfhdr_id = ?");
			updstmt.setString(1, rs2.getString("address.addrkey") );
		 	updstmt.setString(2, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();				 		
		}
	  pstmt.close();


        pstmt = con.prepareStatement("select cost.costkey from cost where costkey = ?");
		pstmt.setString(1, _costkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (rs2.next()) {
			
			%>
			<td>
			<%= _costkey %>
			</td>
			
			<%
         	PreparedStatement updstmt = con.prepareStatement("update  vendortariffhdr set vendortariffhdr.costkey = ? where vendtarfhdr_id = ?");
			updstmt.setString(1, rs2.getString("cost.costkey") );
		 	updstmt.setString(2, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();
							 		
		}
	  pstmt.close();
	  	  
		  
        pstmt = con.prepareStatement("select * from location where locationkey = ?");
		pstmt.setString(1, _tolocationkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (rs2.next()) {
			
			%>
			<td>
			<%= _tolocationkey %>
			</td>
			
			<%
			
         	PreparedStatement updstmt = con.prepareStatement("update  vendortariffhdr set vendortariffhdr.tolocationkey = ? where vendtarfhdr_id = ?");
			updstmt.setString(1, rs2.getString("location.locationkey") );
		 	updstmt.setString(2, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();		 		
		}
	  pstmt.close();		



        pstmt = con.prepareStatement("select * from location where locationkey = ?");
		pstmt.setString(1, _fromlocationkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (rs2.next()) {
			%>
			<td>
			<%= _fromlocationkey %>
			</td>

			<%
			
         	PreparedStatement updstmt = con.prepareStatement("update  vendortariffhdr set vendortariffhdr.fromlocationkey = ? where vendtarfhdr_id = ?");
			updstmt.setString(1, rs2.getString("location.locationkey") );
		 	updstmt.setString(2, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();			 		
		}
	  pstmt.close();
	  
	  
        pstmt = con.prepareStatement("select location.locationkey from location where locationkey = ?");
		pstmt.setString(1, _tslocationkey );						
         // Execute the query
		 rs2 = pstmt.executeQuery();
		 if (rs2.next()) {
	
			%>
			<td>
			<%= _tslocationkey %>
			</td>

			<%
			
         	PreparedStatement updstmt = con.prepareStatement("update  vendortariffhdr set vendortariffhdr.tslocationkey = ? where vendtarfhdr_id = ?");
			updstmt.setString(1, rs2.getString("location.locationkey") );
		 	updstmt.setString(2, _vendtarfhdr_id );	
		 	updstmt.executeUpdate();	
	  		updstmt.close();		 		
		}
	  pstmt.close();	  
	 %>
	  			<td>
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
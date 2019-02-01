
                                  <%@ page language="Java" %>
                                  <%@ page import="java.sql.*" %>
                                  <%
                                  // the URL of my database
                                  String url = "jdbc:mysql://localhost/quote";

                                  // the connection to the database and return statement
                                  Connection con;
                                  %>
                                  <html>
                                  <head>
                                  <title>find System Logs</title>
                                  </head>
                                  <body>
                                  <hr color="#009933" noshade>
<table border="1">
<tr>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
</tr>                         
                                  <%

String query = 
         (
         "SELECT userid, recordobjectdata, recordobjectclass FROM systemlog"
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
          // a value has been stored, get the binary stream
          java.io.InputStream b  = rs.getBinaryStream("recordobjectdata");
          // create a new input stream to deserialize the objec
          java.io.ObjectInputStream o = new java.io.ObjectInputStream(b);
          // cast it to what is was
//          com.bureaueye.beacon.model.standard.Charge charge = (com.bureaueye.beacon.model.standard.Charge)
//           java.lang.Class _class = java.lang.Class.forName(rs.getString("recordobjectclass"));
//           java.lang.Object action = actionClass.newInstance();
	java.lang.Object obj = o.readObject();

	
//	java.lang.reflect.Method m = clazz.getMethod("getLogtimestamp", new java.lang.Class[0]);
	//java.lang.Object result = m.invoke(obj, new java.lang.Object[0]);	
	
     try {
	java.lang.Class clazz = java.lang.Class.forName(rs.getString("recordobjectclass"));
        
            java.lang.reflect.Method methlist[] 
              = clazz.getMethods();
            for (int i = 0; i < methlist.length;
               i++) {
//			   System.out.println(methlist[i].toString());
//			   System.out.println();			   
//		   System.out.println(methlist[i].getGenericReturnType().toString());
java.lang.Object result = null;
String str = "";
try {
//if (methlist[i].getName().substring(0,3).equals("get"))
	result = methlist[i].invoke(obj, new java.lang.Object[0]);
	str =	result.toString();

%>

<tr>
<td>
<%= methlist[i].getName() %>: 
</td>
<td>
<%= str %>
</td>
<td>
</td>

</tr>
<%			
} 
catch (java.lang.NullPointerException npe) {}
catch (java.lang.Exception e) {}   
			   /*  
               Method m = methlist[i];
               System.out.println("name 
                 = " + m.getName());
               System.out.println("decl class = " +
                              m.getDeclaringClass());
               Class pvec[] = m.getParameterTypes();
               for (int j = 0; j < pvec.length; j++)
                  System.out.println("
                   param #" + j + " " + pvec[j]);
               Class evec[] = m.getExceptionTypes();
               for (int j = 0; j < evec.length; j++)
                  System.out.println("exc #" + j 
                    + " " + evec[j]);
               System.out.println("return type = " +
                                  m.getReturnType());
               System.out.println("-----");
			   */
            }
         }
         catch (Throwable e) {
            System.err.println(e);
         }
		 	   
			
          // set it to the user area object
          //content.setMyObject(info);  					

						String _userid = rs.getString("userid");



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
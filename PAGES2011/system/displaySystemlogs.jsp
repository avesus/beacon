
                                  <%@ page language="Java" %>
                                  <%@ page import="java.sql.*" %>
                                  <%
String monthList = "January,February,March,April,May,June,July,August,September,October,November,December";
String yearList = "2005,2006,2007,2008";

String fromDD = request.getParameter("fromDD");
String fromMM = request.getParameter("fromMM");
String fromYYYY = request.getParameter("fromYYYY");

String fromHour = request.getParameter("fromHour");
String fromMinute = request.getParameter("fromMinute");
String fromSecond = request.getParameter("fromSecond");

String toDD = request.getParameter("toDD");
String toMM = request.getParameter("toMM");
String toYYYY = request.getParameter("toYYYY");

String toHour = request.getParameter("toHour");
String toMinute = request.getParameter("toMinute");
String toSecond = request.getParameter("toSecond");

String action = request.getParameter("action");
String userid = request.getParameter("userid");
String recordobjectclass = request.getParameter("recordobjectclass");

java.util.StringTokenizer st = null;
java.text.DecimalFormat df = new java.text.DecimalFormat("00");
int count = 0;
String s = "";
								  
// the URL of my database
String url = "jdbc:mysql://localhost/quote";

                                  // the connection to the database and return statement
                                  Connection con;
%>
                                  <html>
                                  <head>
                                  <title>find System Logs</title>
                                  <style type="text/css">
<!--
.style3 {color: #FFFFFF; font-weight: bold; }
-->
                                  </style>
                                  </head>
                                  <body>
<form method="post" action="displaySystemlogs.jsp" name="form">
  <table width="100%" border="1" cellpadding="1" cellspacing="1" bordercolor="#000000">
    <tr>
      <td colspan="4"><input type="submit" name="Submit" value="Search"></td>
    </tr>
    <tr>
      <td>Userid:</td>
      <td colspan="3"><input name="userid" type="text" value="<%= userid %>"></td>
    </tr>
    <tr>
      <td>Action:</td>
      <td colspan="3"><select name="action" size="2">
        <option value="update"
		<%
		if (action != null) if (action.equals("update")) {	
		%>
		selected
		<%
		}		
		%>			
		>update</option>
        <option value="delete"
		<%
		if (action != null) if (action.equals("delete")) {	
		%>
		selected	
		<%
		}		
		%>		
		>delete</option>
      </select></td>
    </tr>
    <tr>
      <td>Record: </td>
      <td colspan="3"><select name="recordobjectclass" size="3" multiple>
        <option value="com.bureaueye.beacon.model.standard.Address"
		<%if (recordobjectclass != null) if (recordobjectclass.equals("com.bureaueye.beacon.model.standard.Address")) {%>selected<%}%>				
		>Address</option>	
        <option value="com.bureaueye.beacon.model.standard.Addresscontact"
		<%if (recordobjectclass != null) if (recordobjectclass.equals("com.bureaueye.beacon.model.standard.Addresscontact")) {%>selected<%}%>				
		>Addresscontact</option>			  
        <option value="com.bureaueye.beacon.model.standard.Ccy"
		<%
		if (recordobjectclass != null) if (recordobjectclass.equals("com.bureaueye.beacon.model.standard.Ccy")) {	
		%>
		selected	
		<%
		}		
		%>		
		>Ccy</option>
        <option value="com.bureaueye.beacon.model.standard.Charge"
		<%
		if (recordobjectclass != null) if (recordobjectclass.equals("com.bureaueye.beacon.model.standard.Charge")) {	
		%>
		selected	
		<%
		}		
		%>				
		>Charge</option>
      </select></td>
    </tr>
    <tr>
      <td>TimeStamp From: </td>
      <td><table cellpadding="0" cellspacing="0" border="0">
        <tr>
          <td align=center valign=middle width="51"><div align="left">
              <select name='fromDD' class="ftforminputsmall">
                <option selected value="00">DD</option>
                <%
	count = 0;
	while (count < 31) {
		count++;	
		s = ""; 
		if (fromDD != null) if (count ==  new Integer(fromDD).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                <%
	}
%>
              </select>
          </div></td>
          <td align=center valign=middle width="49"><div align="left">
            <select name='fromMM' class="ftforminputsmall">
              <option selected value="00">MM</option>
              <%
	st = new java.util.StringTokenizer(monthList, ",");
	count = 0;
	s = "";
	while (st.hasMoreTokens()) {
		count++;	
		String month = st.nextToken();
		s = "";
		if (fromMM != null) if (count ==  new Integer(fromMM).intValue()) s = "Selected";						
		String count2= df.format(count);
%>
              <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
              <%
	}
%>
            </select>
</div></td>
          <td align=center valign=middle width="66"><div align="left">
              <select name='fromYYYY' class="ftforminputsmall">
                <option selected value="0000">YYYY</option>
                <%
	st = new java.util.StringTokenizer(yearList, ",");
	while (st.hasMoreTokens()) {	
		int year = java.lang.Integer.parseInt(st.nextToken());
		s = "";
		if (fromYYYY != null) if (year ==  new Integer(fromYYYY).intValue()) s = "Selected";		
%>
                <option <%= s %> value="<%= year %>"><%= year %></option>
                <%
	}
%>
              </select>
          </div></td>
        </tr>
      </table>
        <table cellpadding="0" cellspacing="0" border="0">
          <tr>
            <td align=center valign=middle width="51"><div align="left">
              <select name='fromHour' class="ftforminputsmall" id="fromHour">
                <option selected value="00">00</option>
                <%
	count = 0;
	while (count < 23) {
		count++;	
		s = ""; 
		if (fromHour != null) if (count ==  new Integer(fromHour).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                <%
	}
%>
              </select>
</div></td>
            <td align=center valign=middle width="49"><div align="left">
                <select name='fromMinute' class="ftforminputsmall">
                  <option selected value="00">00</option>
                  <%
	count = 0;
	while (count < 59) {
		count++;	
		s = ""; 
		if (fromMinute != null) if (count ==  new Integer(fromMinute).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                  <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                  <%
	}
%>
                </select>
            </div></td>
            <td align=center valign=middle width="66"><div align="left">
              <select name='fromSecond' class="ftforminputsmall" id="fromSecond">
                <option selected value="00">00</option>
                <%
	count = 0;
	while (count < 59) {
		count++;	
		s = ""; 
		if (fromSecond != null) if (count ==  new Integer(fromSecond).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                <%
	}
%>
              </select>
</div></td>
          </tr>
        </table></td>
      <td>To:</td>
      <td><table cellpadding="0" cellspacing="0" border="0">
          <tr>
            <td align=center valign=middle width="51"><div align="left">
                <select name='toDD' class="ftforminputsmall" id="toDD">
                  <option selected value="00">DD</option>
                  <%
	count = 0;
	while (count < 31) {
		count++;	
		s = "";
		if (fromDD != null) if (count ==  new Integer(toDD).intValue()) s = "Selected";				 
		String count2= df.format(count);
%>
                  <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                  <%
	}
%>
                </select>
            </div></td>
            <td align=center valign=middle width="49"><div align="left">
              <select name='toMM' class="ftforminputsmall" id="toMM">
                <option selected value="00">MM</option>
                <%
	st = new java.util.StringTokenizer(monthList, ",");
	count = 0;
	while (st.hasMoreTokens()) {
		count++;	
		String month = st.nextToken();
		s = "";
		if (toMM != null) if (count ==  new Integer(toMM).intValue()) s = "Selected";			
		String count2= df.format(count);
%>
                <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                <%
	}
%>
              </select>
</div></td>
            <td align=center valign=middle width="66"><div align="left">
                <select name='toYYYY' class="ftforminputsmall" id="toYYYY">
                  <option selected value="0000">YYYY</option>
                  <%
	st = new java.util.StringTokenizer(yearList, ",");
	while (st.hasMoreTokens()) {	
		int year = java.lang.Integer.parseInt(st.nextToken());
		s = "";
		if (toYYYY != null) if (year ==  new Integer(toYYYY).intValue()) s = "Selected";				
%>
                  <option <%= s %> value="<%= year %>"><%= year %></option>
                  <%
	}
%>
                </select>
            </div></td>
          </tr>
      </table>
        <table cellpadding="0" cellspacing="0" border="0">
          <tr>
            <td align=center valign=middle width="51"><div align="left">
                <select name='toHour' class="ftforminputsmall" id="toHour">
                  <option selected value="00">00</option>
                  <%
	count = 0;
	while (count < 23) {
		count++;	
		s = ""; 
		if (toHour != null) if (count ==  new Integer(toHour).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                  <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                  <%
	}
%>
                </select>
            </div></td>
            <td align=center valign=middle width="49"><div align="left">
                <select name='toMinute' class="ftforminputsmall" id="toMinute">
                  <option selected value="00">00</option>
                  <%
	count = 0;
	while (count < 59) {
		count++;	
		s = ""; 
		if (toMinute != null) if (count ==  new Integer(toMinute).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                  <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                  <%
	}
%>
                </select>
            </div></td>
            <td align=center valign=middle width="66"><div align="left">
                <select name='toSecond' class="ftforminputsmall" id="toSecond">
                  <option selected value="00">00</option>
                  <%
	count = 0;
	while (count < 59) {
		count++;	
		s = ""; 
		if (toSecond != null) if (count ==  new Integer(toSecond).intValue()) s = "Selected";		
		String count2= df.format(count);
%>
                  <option <%= s %> value="<%= count2 %>"><%= count2 %></option>
                  <%
	}
%>
                </select>
            </div></td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
  </table>
							  
  </form>						  
                                  <hr color="#009933" noshade>
<table border="1" cellpadding="1" cellspacing="1" bordercolor="#000000">
<tr>
<td> </td>
<td> </td>
<td> </td>
<td> </td>
</tr>  
                       
                                  <%

String query = 
         (
         "SELECT userid, recordobjectdata, recordobjectclass, action, logtimestamp "+
		 "FROM systemlog "+
		 "where (logtimestamp > ? and logtimestamp < ?) and userid = ? and action = ? and recordobjectclass = ? "+		 
		 "order by logtimestamp desc"
         );
		 

//String sql = "select * from blah where timestamp > ?";


		 

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
//Statement stmt = con.createStatement();
java.sql.PreparedStatement pstmt = con.prepareStatement(query);
String from = fromYYYY+fromMM+fromDD+fromHour+fromMinute+fromSecond;
String to = toYYYY+toMM+toDD+toHour+toMinute+toSecond;
//Timestamp from = new Timestamp(new java.util.Date().getTime());
//Timestamp to = new Timestamp(new java.util.Date().getTime());
pstmt.setString(1, from);	
pstmt.setString(2, to);
pstmt.setString(3, userid);
pstmt.setString(4, action);
pstmt.setString(5, recordobjectclass);
//pstmt.setString(3, "");				  

ResultSet rs = pstmt.executeQuery();
//count = 1;
					while (rs.next()) {
					
%>
<tr bgcolor="#999999">
<td>
  <span class="style3"><%= rs.getString("action") %> 
  </span></td>
<td>
  <span class="style3"><%= rs.getString("userid") %> 
  </span></td>
<td>
  <span class="style3"><%= rs.getString("recordobjectclass") %>
  </span></td>
<td>
  <span class="style3"><%= rs.getTimestamp("logtimestamp") %>
  </span></td>
</tr>
<%					
          // a value has been stored, get the binary stream
          java.io.InputStream b  = rs.getBinaryStream("recordobjectdata");
          // create a new input stream to deserialize the objec
          java.io.ObjectInputStream o = new java.io.ObjectInputStream(b);
	java.lang.Object obj = o.readObject();

	
//	java.lang.reflect.Method m = clazz.getMethod("getLogtimestamp", new java.lang.Class[0]);
	//java.lang.Object result = m.invoke(obj, new java.lang.Object[0]);	
	
     try {
	java.lang.Class clazz = java.lang.Class.forName(rs.getString("recordobjectclass"));
        
            java.lang.reflect.Method methlist[] 
              = clazz.getMethods();
            for (int i = 0; i < methlist.length;
               i++) {
java.lang.Object result = null;
String str = "";
try {
	result = methlist[i].invoke(obj, new java.lang.Object[0]);
	str =	result.toString();

%>

<tr>
<td>
<%= methlist[i].getName() %>: 
</td>
<td colspan="3">
<%= str %>
</td>
</tr>
<%			
} 
catch (java.lang.NullPointerException npe) {}
catch (java.lang.Exception e) {}   
            }
         }
         catch (Throwable e) {
            System.err.println(e);
         }
		 	   
			
          // set it to the user area object
          //content.setMyObject(info);  					

						String _userid = rs.getString("userid");



					}

				  pstmt.close();
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
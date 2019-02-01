<html>
<head>

<%@ page 
import = "java.io.*"
import = "java.lang.*"
import = "java.sql.*"
import = "java.util.*"
%>




<title>inserting a Customer Address records.....</title>
</head>
<body>
<h1>inserting a Customer Address records.....</h1>
<hr color="#009933" noshade>



<%



try {
	//SQLSERVER
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

}
catch( Exception e ){
}

try {
	//SQLSERVER
	String user="sa"; 
	String pass="money" ; 
	String url="jdbc:sqlserver://192.168.1.15:49535;instanceName=SQLEXPRESS;databaseName=beacon_wsi;SelectMethod=cursor;";
	
	// the connection to the database and return statement
	Connection con = DriverManager.getConnection(url, user, pass);

System.out.println("start=========>");
	
	String inputFileName="c:\\temp\\customers.txt";

java.io.BufferedReader input =  null;
	try {
		java.io.File file = new java.io.File(inputFileName);
		input =  new java.io.BufferedReader(new java.io.FileReader(file));

		int lineCount = 1;
		String line = null; //not declared within while loop
							
		while (( line = input.readLine()) != null){
																			
																	

								
					StringTokenizer _StringTokenizer = new StringTokenizer(line,  "\t");	
					
/*FIRST EDITION*
Code: Column A
Name: Column B
Short Name: Column G
Address: Column C
Postal Code: Column D
City: Column E

*SECOND EDITION*
Code: Column A
Name: Column B
Short Name: Column H
Address: Column C
Postal Code: Column D
City: Column E
State: Column F
Country: Column G

*THIRD EDITION*
Code: Column A
Name: Column B
Short Name: Column I
Address: Column C
Address Line 2: Column D
Postal Code: Column E
City: Column F
State: Column G
Country: Column H

*/

					
					String code="";
					String name="";
					String address1="";
					String address2="";					
					String postalcode="";
					String city="";					
					String shortname="";
					String country="";					
					String state="";					
						
					try {	 code=_StringTokenizer.nextToken();					} catch (Exception e) {}										 
					try {	  name=_StringTokenizer.nextToken();					} catch (Exception e) {}
					try {	 address1=_StringTokenizer.nextToken();					} catch (Exception e) {}
					try {	 address2=_StringTokenizer.nextToken();					} catch (Exception e) {}					
					try {	 postalcode=_StringTokenizer.nextToken();					} catch (Exception e) {}
					try {	 city=_StringTokenizer.nextToken();						} catch (Exception e) {}	
					try {	 state=_StringTokenizer.nextToken();						} catch (Exception e) {}											
					try {	 country=_StringTokenizer.nextToken();					} catch (Exception e) {}	
					try {	  shortname=_StringTokenizer.nextToken();					} catch (Exception e) {}	
						 
			 			 

					int nameLength = name.length();
					 if (nameLength >= 2 && name.charAt(0) == '"' && name.charAt(nameLength - 1) == '"') {					 
      				 	name=name.substring(1, nameLength - 1);
					 }
					  if (name.length()>50) name=name.substring(0,50);
					  
					  
					 int address1Length = address1.length();
					 if (address1Length >= 2 && address1.charAt(0) == '"' && address1.charAt(address1Length - 1) == '"') {
      				 	address1=address1.substring(1, address1Length - 1);
					 }
						  if (address1.length()>50) address1=address1.substring(0,50);	
						  
						  
					int address2Length = address2.length();
					 if (address2Length >= 2 && address2.charAt(0) == '"' && address2.charAt(address2Length - 1) == '"') {
      				 	address2=address2.substring(1, address2Length - 1);
					 }
									  if (address2.length()>50) address2=address2.substring(0,50);	
									  
									  
					 int cityLength = city.length();
					 if (cityLength >= 2 && city.charAt(0) == '"' && city.charAt(cityLength - 1) == '"') {
      				 	city=city.substring(1, cityLength - 1);
					 }
							 if (city.length()>20) city=city.substring(0,20);
							 
							 
					 int countryLength = country.length();
					 if (countryLength >= 2 && country.charAt(0) == '"' && country.charAt(countryLength - 1) == '"') {
      				 	country=country.substring(1, countryLength - 1);
					 }
					 					  if (country.length()>10) country=country.substring(0,10);
										  
					 
					 int stateLength = state.length();
					 if (stateLength >= 2 && state.charAt(0) == '"' && state.charAt(stateLength - 1) == '"') {
      				 	state=state.substring(1, stateLength - 1);
					 }
					 					  if (state.length()>20) state=state.substring(0,20);
										  
										  
					 if (shortname.equals("")) shortname=name;
								  if (shortname.length()>20) shortname=shortname.substring(0,20);
	
						  if (postalcode.length()>10) postalcode=postalcode.substring(0,10);
						  
						  
				
					if (code.equals("XXX")) code = "";
					if (name.equals("XXX")) name = "";
					if (address1.equals("XXX")) address1 = "";
					if (address2.equals("XXX")) address2 = "";
					if (postalcode.equals("XXX")) postalcode = "";
					if (city.equals("XXX")) city = "";
					if (shortname.equals("XXX")) shortname = "";
					if (country.equals("XXX")) country = "";	
					if (state.equals("XXX")) state = "";					
					


						
			System.out.println("["+lineCount+"] code="+code+" name="+name+" shortname="+shortname);									
			lineCount++;
			
			if (!code.equals("")) {

try {
String query="";	

															  
query="INSERT INTO address ("+
        	"addrkey, " +
        	"name, " +
        	"shortname, " +
        	"addr1, " +
        	"city, " +
			"addr2, "+
			"addr3 ,"+
			"postalcode, "			+
			"ccykey, "+	
			"countrykey, "	+
			"country, "	+	
			
			"typekey, "	+
			"compcode, "	+	
			
			"createdate, "	+	
			"createuserid, "+	
			
"g1codekey, "+
"g2codekey, "+
"g3codekey, "+
"g4codekey, "+

"state, "+

"paymenttoinstructions, "+
"typekeylist, "+
"accsysaddressid, "+

"paytermstext, "+
"payterms, "+
"mainaccaddrkey, "+
"langkey, "+

"telno1, "+
"faxno1, "+
"emailno1, "+

"addr4, "+
"addr5, "+
"town, "+
"createtime, "+

"emailno, "+
"rentaddrkey "+					   
")"+
" VALUES ("+
		 "'"+code+"',"+
			 "'"+name+"',"+
			 "'"+shortname+"',"+
			 "'"+address1+"',"+
			 "'"+city+"',"+
			 "'"+address2+"',"+
			 "'',"+
			 "'"+postalcode+"',"+
			 "'USD',"+
			 "'"+country+"',"+
			 "'"+country+"',"+
			 "'CUSTOMER',"+
			 "'WSI',"+
			 "'2013-06-20',"+
			 "'CUSTCONV',"+
			 "'NAM',"+
			 "'MIDW',"+
			 "'',"+
			 "'',"+
			 "'"+state+"',"+
			 "'World Shipping, Inc.\nc/o PNC Bank, N.A. \n2 Tower Center Blvd.\nEast Brunswick, NJ 08816\nAccount No.  801-933-8454\nABA No.             031207607',"+
			 "'CUSTOMER',"+
			 "'"+ code.substring(2,6)+"',"+
			 "'',"+
			 "'0',"+
			 "'',"+
			 "'',"+

			 "'',"+
			 "'',"+
			 "'',"+
			 "'',"+
			 "'',"+
			 "'',"+
			 "'01:00:00',"+
			 "'',"+
			 "''"+
		 ")";
		


		               PreparedStatement pstmt = con.prepareStatement(query);
			   
			
         // Execute the query
		 pstmt.executeUpdate();
		
			 pstmt.close();
		
						} catch (SQLException e) {
System.out.println("INSERT ADDRESS SQLRxception - "+e.getMessage());							
						}
		
			 
	
	//check city exists
			if (!city.equals("")) {	
	
try {
	
ResultSet results;
PreparedStatement sql;
sql = con.prepareStatement("SELECT * FROM city WHERE city = '"+city+"'");
results = sql.executeQuery();
if (!results.next()) {	
	
               PreparedStatement pstmt2 = con.prepareStatement(
        	"INSERT INTO city ("+
        	"city, " +
        	"createdate, " +
        	"createuserid, " +			
        	"createtime "+
			")"+
" VALUES ("+
		 "'"+city+"',"+
			 "'2013-06-20',"+			
			 "'CUSTCONV',"+	
			 "'01:00:00'"+
		 ")"						 	
		);
		
         // Execute the query
		 pstmt2.executeUpdate();
	
		 pstmt2.close();
}
sql.close();

						} catch (SQLException e) {
System.out.println("INSERT CITY SQLException - "+e.getMessage());							
						}
						
			}
				
			}
								
		}
							



								

		} catch (Exception ex){}							
		finally {			
			input.close();		
		}							



	 	 
		 
     con.close();
	 
}  catch( Exception e ) {}

%>


</body>
</html>
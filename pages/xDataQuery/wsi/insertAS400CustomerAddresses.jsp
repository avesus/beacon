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

	//MYSQL
	Class.forName("org.gjt.mm.mysql.Driver");	
}
catch( Exception e ){
}

try {

	//MYSQL
String user=""; 
	String pass="" ; 
	String url="jdbc:mysql://192.168.1.2:3307/beacon_wsi";	
	// the connection to the database and return statement
	Connection con = DriverManager.getConnection(url, user, pass);


	
	String inputFileName="c:\\temp\\customers.txt";

java.io.BufferedReader input =  null;
	try {
		java.io.File file = new java.io.File(inputFileName);
		input =  new java.io.BufferedReader(new java.io.FileReader(file));

		int lineCount = 1;
		String line = null; //not declared within while loop
							
		while (( line = input.readLine()) != null){
																			
									
		System.out.println("["+lineCount+"] "+line);									

								
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

					 int address1Length = address1.length();
					 if (address1Length >= 2 && address1.charAt(0) == '"' && address1.charAt(address1Length - 1) == '"') {
      				 	address1=address1.substring(1, address1Length - 1);
					 }
	
					int address2Length = address2.length();
					 if (address2Length >= 2 && address2.charAt(0) == '"' && address2.charAt(address2Length - 1) == '"') {
      				 	address2=address2.substring(1, address2Length - 1);
					 }
					 
					 int cityLength = city.length();
					 if (cityLength >= 2 && city.charAt(0) == '"' && city.charAt(cityLength - 1) == '"') {
      				 	city=city.substring(1, cityLength - 1);
					 }
					 
					 int countryLength = country.length();
					 if (countryLength >= 2 && country.charAt(0) == '"' && country.charAt(countryLength - 1) == '"') {
      				 	country=country.substring(1, countryLength - 1);
					 }
					 
					 int stateLength = state.length();
					 if (stateLength >= 2 && state.charAt(0) == '"' && state.charAt(stateLength - 1) == '"') {
      				 	state=state.substring(1, stateLength - 1);
					 }
					 
					 if (shortname.equals("")) shortname=name;
				
				
					if (code.equals("XXX")) code = "";
					if (name.equals("XXX")) name = "";
					if (address1.equals("XXX")) address1 = "";
					if (address2.equals("XXX")) address2 = "";
					if (postalcode.equals("XXX")) postalcode = "";
					if (city.equals("XXX")) city = "";
					if (shortname.equals("XXX")) shortname = "";
					if (country.equals("XXX")) country = "";	
					if (state.equals("XXX")) state = "";					
					


						
			//System.out.println("["+lineCount+"] code="+code+" name="+name+" shortname="+shortname);									
			lineCount++;
			
			if (!code.equals("")) {

try {
	
               PreparedStatement pstmt = con.prepareStatement(
        	"INSERT INTO address SET " +
        	"addrkey = ?, " +
        	"name = ?, " +
        	"shortname = ?, " +
        	"addr1 = ?, " +
        	"city = ?, " +
			"addr2 = ?, "+
			"addr3 = ? ,"+
			"postalcode = ?, "			+
			"ccykey = ?, "+	
			"countrykey = ?, "	+
			"country = ?, "	+	
			
			"typekey = ?, "	+
			"compcode = ?, "	+	
			
			"createdate = ?, "	+	
			"createuserid = ?, "+	
			
"g1codekey= ?, "+
"g2codekey= ?, "+
"g3codekey= ?, "+
"g4codekey= ?, "+

"state= ?, "+

"paymenttoinstructions= ?, "+
"typekeylist= ?, "+
"accsysaddressid= ?, "+

"paytermstext= ?, "+
"payterms= ?, "+
"mainaccaddrkey= ?, "+
"langkey= ?, "+

"telno1= ?, "+
"faxno1= ?, "+
"emailno1= ?, "+

"addr4= ?, "+
"addr5= ?, "+
"town= ?, "+
"createtime= ?, "+

"emailno= ?, "+
"rentaddrkey= ? "

        	);
			   
		pstmt.setString(1, code );
		pstmt.setString(2, name );
		pstmt.setString(3, shortname );
		pstmt.setString(4, address1 );
		pstmt.setString(5, city )	;
		pstmt.setString(6, address2 )	;		
		pstmt.setString(7, "" )	;
		pstmt.setString(8, postalcode )	;
		pstmt.setString(9, "USD" )	;	
		pstmt.setString(10, country )	;			
		pstmt.setString(11, country )	;	
		pstmt.setString(12, "CUSTOMER" )	;			
		pstmt.setString(13, "WSI" )	;
		pstmt.setString(14, "2013-06-20" )	;		
		pstmt.setString(15, "CUSTCONV" )	;
		
		pstmt.setString(16, "NAM" )	;	
		pstmt.setString(17, "MIDW" )	;	
		pstmt.setString(18, "" )	;	
		pstmt.setString(19, "" )	;

		pstmt.setString(20, state )	;
		
		pstmt.setString(21, "World Shipping, Inc.\nc/o PNC Bank, N.A. \n2 Tower Center Blvd.\nEast Brunswick, NJ 08816\nAccount No.  801-933-8454\nABA No.             031207607" )	;
		pstmt.setString(22, "CUSTOMER" )	;
		pstmt.setString(23, code.substring(2,6) )	;
		
				pstmt.setString(24, "" )	;
				pstmt.setString(25, "0" )	;
				pstmt.setString(26, "" )	;
				pstmt.setString(27, "" )	;				
		
				pstmt.setString(28, "" )	;
				pstmt.setString(29, "" )	;
				pstmt.setString(30, "" )	;	
				
				pstmt.setString(31, "" )	;
				pstmt.setString(32, "" )	;	
				pstmt.setString(33, "" )	;	
				pstmt.setString(34, "01:00:00" )	;	
				
				pstmt.setString(35, "" )	;
				pstmt.setString(36, "" )	;				
				
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
        	"INSERT INTO city SET " +
        	"city = ?, "+
			"createdate = ?, "	+	
			"createuserid = ?, "+	
			"createtime= ? "			
        	);
			   
		pstmt2.setString(1, city );
		pstmt2.setString(2, "2013-06-20" )	;		
		pstmt2.setString(3, "CUSTCONV" )	;		
		pstmt2.setString(4, "01:00:00" )	;	
		
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
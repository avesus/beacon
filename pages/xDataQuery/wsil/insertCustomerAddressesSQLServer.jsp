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
//Class.forName("org.gjt.mm.mysql.Driver");	

}
catch( Exception e ){
}

try {
	//SQLSERVER
	String user="sa"; 
	String pass="money" ; 
	//String url="jdbc:sqlserver://192.168.1.22:49535;instanceName=SQLEXPRESS;databaseName=beacon_wsi_uat;SelectMethod=cursor;";
	String url="jdbc:sqlserver://192.168.1.12;instanceName=SQLEXPRESS;databaseName=beacon_wsi_uat;SelectMethod=cursor;";
		
	//String url="jdbc:mysql://192.168.1.2:3307/beacon_demo";
	
	// the connection to the database and return statement
	Connection con = null;
	
	try{con=DriverManager.getConnection(url, user, pass);}catch (Exception e){
		System.out.println(e.getMessage());
		}

System.out.println("start=========>");
	
	String inputFileName="c:\\temp\\WSIL Beacon Customer Sheet_tabV2.txt";

java.io.BufferedReader input =  null;
	try {
		java.io.File file = new java.io.File(inputFileName);
		input =  new java.io.BufferedReader(new java.io.FileReader(file));

		int lineCount = 1;
		String line = null; //not declared within while loop
							
		while (( line = input.readLine()) != null){
																			
																	

//System.out.println(line);
				   
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
					String code2="";					
					String name="";
					String address1="";
					String address2="";					
					String postalcode="";
					String city="";					
					String shortname="";
					String country="US";	
					String country2="UNITED STATES";						
					String state="";
					String phone="";					
					String acc_rep="";
					String comm_type="";
						
					try {	 code=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}										 
					try {	  name=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}
					try {	  shortname=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}					
					try {	 address1=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}			
try {	 city=_StringTokenizer.nextToken().toUpperCase();						} catch (Exception e) {}	
					try {	 state=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}
					try {	 country=_StringTokenizer.nextToken().toUpperCase();				} catch (Exception e) {}	
try {	 postalcode=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}										
					try {	  phone=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}	
					try {	  acc_rep=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}						 
					try {	  comm_type=_StringTokenizer.nextToken().toUpperCase();					} catch (Exception e) {}
			
			
code2=code;
int codeLength = code.length();
					  if (code.length()>10) code=code.substring(1,codeLength);
					  
					int nameLength = name.length();
					 if (nameLength >= 2 && name.charAt(0) == '"' && name.charAt(nameLength - 1) == '"') {					 
      				 	name=name.substring(1, nameLength - 1);
					 }					  
					  if (name.length()>50) name=name.substring(0,50);
					  
					int shortnameLength = shortname.length();
					 if (shortnameLength >= 2 && shortname.charAt(0) == '"' && shortname.charAt(shortnameLength - 1) == '"') {					 
      				 	shortname=shortname.substring(1, shortnameLength - 1);
					 }					  
					  if (shortname.length()>20) shortname=shortname.substring(0,20);
					  
					  int address1Length = address1.length();
					 if (address1Length >= 2 && address1.charAt(0) == '"' && address1.charAt(address1Length - 1) == '"') {
      				 	address1=address1.substring(1, address1Length - 1);
					 }
					 if (address1.length()>50) address1=address1.substring(0,50);
					 
					 int cityLength = city.length();
					 if (cityLength >= 2 && city.charAt(0) == '"' && city.charAt(cityLength - 1) == '"') {
      				 	city=city.substring(1, cityLength - 1);
					 }					 
						if (city.length()>20) city=city.substring(0,20);
						
					 int stateLength = state.length();
					 if (stateLength >= 2 && state.charAt(0) == '"' && state.charAt(stateLength - 1) == '"') {
      				 	state=state.substring(1, stateLength - 1);
					 }						
					 if (state.length()>20) state=state.substring(0,20);
					 

					 if (postalcode.length()>10) postalcode=postalcode.substring(0,10);	  
					 if (phone.length()>50) phone=phone.substring(0,50);
					 if (acc_rep.length()>10) acc_rep=acc_rep.substring(0,10);
					 if (comm_type.length()>10) comm_type=comm_type.substring(0,10);
					 
					 

if (phone.equals("XXX")) phone="";
if (postalcode.equals("XXX")) postalcode="";
				 
						
			//System.out.println(
			//				   "["+lineCount+"] code="+code+" name="+name+" shortname="+shortname+" city="+city+" state="+state+
			//				   " zip="+postalcode+" phone="+phone+" acc_rep="+acc_rep+" comm_type="+comm_type							   );									
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
"rentaddrkey, "+

"acc_Rep, "+
"commissiontype, "+
"extsysaddressid "+

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
			 "'"+country2+"',"+
			 
			 "'SHIPPER',"+
			 "'WSIL',"+
			 
			 "'2014-02-01',"+
			 "'WSILCONV',"+
			 
			 "'NAM',"+
			 "'MIDW',"+
			 "'',"+
			 "'',"+
			 
			 "'"+state+"',"+
			 
			 "'',"+
			 "'SHIPPER',"+
			 "'"+code2+"',"+

			 "'',"+
			 "'0',"+
			 "'',"+
			 "'',"+

			 "'"+phone+"',"+
			 "'',"+
			 "'',"+
			 
			 "'',"+
			 "'',"+
			 "'',"+
			 "'01:00:00',"+
			 
			 "'',"+
			 "'',"+
		
			 "'"+acc_rep+"',"+
			 "'"+comm_type+"',"+
			 "'"+code2+"'"+
			 
		 ")";
		


		               PreparedStatement pstmt = con.prepareStatement(query);
			   
			
         // Execute the query
		 pstmt.executeUpdate();
		
			 pstmt.close();

		
} catch (Exception e) {
System.out.println("INSERT ADDRESS SQLRxception - "+e.getMessage()+ "  ["+lineCount+"] code="+code);							
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
			 "'2014-02-01',"+			
			 "'WSILCONV',"+	
			 "'01:00:00'"+
		 ")"						 	
		);
		
         // Execute the query
		 pstmt2.executeUpdate();
	
		 pstmt2.close();
}
sql.close();


} catch (Exception e) {
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
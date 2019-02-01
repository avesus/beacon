<%@page contentType="text/xml"%>

<%@page pageEncoding="UTF-8"%>

<%@include file="/pages/TreeGrid/Framework/TreeGridFramework.jsp"%>

<%!
boolean isHDR(org.w3c.dom.Element I){ return I.getAttribute("Def").equals("HDR"); }
boolean isDTL(org.w3c.dom.Element I){ return I.getAttribute("Def").equals("DTL"); }
boolean isDTLR(org.w3c.dom.Element I){ return I.getAttribute("Def").equals("DTLR"); }
String getParent(org.w3c.dom.Element I){ return I.getAttribute("Parent"); }
boolean isValidFromEntered(org.w3c.dom.Element I){ return !I.getAttribute("Validfrom").equals(""); }
boolean isValidtoEntered(org.w3c.dom.Element I){ return !I.getAttribute("Validto").equals(""); }
%>


<%
/*-----------------------------------------------------------------------------------------------------------------
! Support file only, run Grid.html instead !
  This file is used as Upload_Url for TreeGrid
  It stores changed from TreeGrid to database
------------------------------------------------------------------------------------------------------------------*/

//------------------------------------------------------------------------------------------------------------------
response.addHeader("Cache-Control","max-age=1, must-revalidate");

// --- Database connection ---
java.sql.Statement Cmd = getMysqlStatement(request,out,"localhost:3306/beacon_cpg","",""); 
java.sql.Statement Cmd2 = getMysqlStatement(request,out,"localhost:3306/beacon_cpg","",""); 

// --- Save data to database ---
org.w3c.dom.Element[] Ch = getChanges(request.getParameter("TGData"));
//check changes found
if(Ch!=null) {
   
   String[] excludeNames = new String[] {"Changed","Added","id"};
   String[] includeTariffdtlNames = new String[] {"Costkey","Ccykey","Amount","Percentage","Inclflag"};
   String[] includeTariffdtlrNames = new String[] {"Unitrate","Fromvalue","Tovalue","Inclrateflag"};


   //PROCESS DELETE AND UPDATES
   for(int i=0;i<Ch.length;i++){
    org.w3c.dom.Element I = Ch[i];
    String[] id = getIds(I);

		
		//split id to headerid and detailid
		java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(id[0], "|");	
		String hdrId = id[0];
		try {hdrId = stringTokenizer.nextToken().trim();} catch (Exception e) {}
		String dtlId = "";
		try {dtlId = stringTokenizer.nextToken().trim();} catch (Exception e) {}
		String dtlrId = "";
		try {dtlrId = stringTokenizer.nextToken().trim();} catch (Exception e) {}
			  
	    //delete process
		if(isDeleted(I)) {
			//header
			if (!hdrId.equals("") && dtlId.equals("")) {
				try {
					Cmd.executeUpdate("DELETE FROM tariffhdr WHERE  TARIFFHDR_ID = "+hdrId);
					Cmd.executeUpdate("DELETE FROM tariffdtl WHERE  TARIFFHDR_ID = "+hdrId);	
					Cmd.executeUpdate("DELETE FROM tariffdtlr WHERE  TARIFFHDR_ID = "+hdrId);	
				} catch (Exception e) {}
			} 
			//detail
			if (!hdrId.equals("") && !dtlId.equals("") && dtlrId.equals("")) {	
				try {
					Cmd.executeUpdate("DELETE FROM tariffdtl WHERE  TARIFFHDR_ID = "+hdrId+" AND TARIFFDTL_ID = "+dtlId);	
					Cmd.executeUpdate("DELETE FROM tariffdtlr WHERE  TARIFFHDR_ID = "+hdrId+" AND TARIFFDTL_ID = "+dtlId);	
				} catch (Exception e) {}
			}
			//detail rate
			if (!hdrId.equals("") && !dtlId.equals("") && !dtlrId.equals("")) {
				try {			
					Cmd.executeUpdate("DELETE FROM tariffdtlr WHERE  TARIFFHDR_ID = "+hdrId+" AND TARIFFDTL_ID = "+dtlId+" AND TARIFFDTLR_ID = "+dtlrId);	
				} catch (Exception e) {}
			}			
        }//delete process
			
			
		//changed process	
		if (isChanged(I)) {
			
			//generate sql set statement
			String sqlSetStatement = "";
            org.w3c.dom.NamedNodeMap A = I.getAttributes();
            for(int a=0;a<A.getLength();a++){
               	org.w3c.dom.Node N = A.item(a);
               	String name = N.getNodeName();
				String val = N.getNodeValue();		

				//do not process action name fields
				if (!java.util.Arrays.asList(excludeNames).contains(name)) {
		
					//hard code Project name 
					if (name.equals("Project")) {
						if (!hdrId.equals("") && dtlId.equals("")) name = "Description";  else name = "Costkey";						
					}	
								
					//build sql set statement
					if (sqlSetStatement.equals("")) {
						sqlSetStatement += " "+name+" = "+toSQL(val) ;
					} else {
						sqlSetStatement += " , "+name+" = "+toSQL(val) ;
					}						
					
				}
			  
            }//loop changed fields

			String sqlStatement="";
			
System.out.println("in HDR added isHDR["+isHDR(I)+"] isDTL["+isDTL(I)+"] isDTLR["+isDTLR(I)+"] hdrId["+hdrId+"] dtlId["+dtlId+"] dtlrId["+dtlrId+"] getParent["+getParent(I)+"]");

			//header update
			if (!hdrId.equals("") && dtlId.equals("")) {
				sqlStatement="UPDATE tariffhdr SET "+sqlSetStatement+" WHERE  TARIFFHDR_ID = "+hdrId;	
			} 
			//detail update
			if (!hdrId.equals("") && !dtlId.equals("") && dtlrId.equals("")) {
				sqlStatement="UPDATE tariffdtl  SET "+sqlSetStatement+"	WHERE  TARIFFHDR_ID = "+hdrId+" AND TARIFFDTL_ID = "+dtlId;
			}
			//detail rate update
			if (!hdrId.equals("") && !dtlId.equals("") && !dtlrId.equals("")) {			
				sqlStatement="UPDATE tariffdtlr SET "+sqlSetStatement+"	WHERE  TARIFFHDR_ID = "+hdrId+" AND TARIFFDTL_ID = "+dtlId+" AND TARIFFDTLR_ID = "+dtlrId;	
			}
		
System.out.println("sqlStatement [ "+sqlStatement+"]");		

			try {
		 		Cmd.executeUpdate(sqlStatement);
			}catch (Exception e) {
			}
			
		}//changed process
		 		 
   }//loop changes 



   
   //PROCESS HEADERS ADDED
   java.util.TreeMap hdrIdTm = new java.util.TreeMap(); 
   for(int i=0;i<Ch.length;i++){
    org.w3c.dom.Element I = Ch[i];
    String[] id = getIds(I);
		  			
		//added process	
		if (isAdded(I) && isHDR(I)) {

			//split id to headerid and detailid
			java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(id[0], "|");	
			String id1 = id[0];
			try {id1 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
			String id2 = "";
			String id3 = "";		
		
			//generate sql set statement
			String sqlSetStatement = "";
            org.w3c.dom.NamedNodeMap A = I.getAttributes();
            for(int a=0;a<A.getLength();a++){
               	org.w3c.dom.Node N = A.item(a);
               	String name = N.getNodeName();
				String val = N.getNodeValue();			

				//do not process action name fields
				if (!java.util.Arrays.asList(excludeNames).contains(name)) {
					
					//hard code Project name 
					if (name.equals("Project")) name = "Description";	
							  
					//check name fields
					if (isHDR(I)) {
						if (
							!java.util.Arrays.asList(includeTariffdtlNames).contains(name) &&
							!java.util.Arrays.asList(includeTariffdtlrNames).contains(name)
							) {
							//build sql set statement
							if (sqlSetStatement.equals("")) {
								sqlSetStatement += " "+name+" = "+toSQL(val) ;
							} else {
								sqlSetStatement += " , "+name+" = "+toSQL(val) ;
							}
						}
					} 
					
				}
			  
            }//loop changed fields

			String sqlStatement="";
System.out.println("in HDR added isHDR["+isHDR(I)+"] isDTL["+isDTL(I)+"] isDTLR["+isDTLR(I)+"] id1["+id1+"] id2["+id2+"] id3["+id3+"] getParent["+getParent(I)+"]");

					if (isHDR(I)) {
						//init id by finding last available and increment 				
						java.sql.ResultSet R = Cmd2.executeQuery("SELECT MAX(TARIFFHDR_ID) FROM tariffhdr");
						R.next();
						int nextId=R.getInt(1);
                     	String newId = String.valueOf(nextId+1);
                     	R.close();
						//store newly created id
						hdrIdTm.put(id1,newId);
						
						sqlStatement="INSERT INTO tariffhdr SET "+sqlSetStatement+" , TARIFFHDR_ID = "+newId;
					}
					
System.out.println("sqlStatement ["+sqlStatement+"]");		

			try {
		 		Cmd.executeUpdate(sqlStatement);
			}catch (Exception e) {
			}
		 
      }//isAdded
	  
   }//loop changes 
   
   


   //PROCESS DETAILS ADDED
   java.util.TreeMap dtlIdTm = new java.util.TreeMap(); 
   for(int i=0;i<Ch.length;i++){
    org.w3c.dom.Element I = Ch[i];
    String[] id = getIds(I);
		  		
		//added process	
		if (isAdded(I) && isDTL(I)) {

			//split id to headerid and detailid
			java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(id[0], "|");	
			String id1 = id[0];
			try {id1 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
			String id2 = "";
			try {id2 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
			String id3 = "";		
		
			//generate sql set statement
			String sqlSetStatement = "";
            org.w3c.dom.NamedNodeMap A = I.getAttributes();
            for(int a=0;a<A.getLength();a++){
               	org.w3c.dom.Node N = A.item(a);
               	String name = N.getNodeName();
				String val = N.getNodeValue();
			
				//do not process action name fields
				if (!java.util.Arrays.asList(excludeNames).contains(name)) {
	
					//hard code Project name 
					if (name.equals("Project")) name = "Costkey";	
					
					//check name fields
					if (isDTL(I)) {					
						if (java.util.Arrays.asList(includeTariffdtlNames).contains(name)) {
							//build sql set statement
							if (sqlSetStatement.equals("")) {
								sqlSetStatement += " "+name+" = "+toSQL(val) ;
							} else {
								sqlSetStatement += " , "+name+" = "+toSQL(val) ;
							}
						}
					}
					
				}
			  
            }//loop changed fields

			String sqlStatement="";
System.out.println("in DTL added isHDR["+isHDR(I)+"] isDTL["+isDTL(I)+"] isDTLR["+isDTLR(I)+"] id1["+id1+"] id2["+id2+"] id3["+id3+"] getParent["+getParent(I)+"]");

					if (isDTL(I)) {	
						//get parent id
						String parentId=getParent(I);
						//lookup new header id if header newly created
						if (parentId.startsWith("NR")) parentId=(String)hdrIdTm.get(parentId);

						//init id by finding last available and increment 	
						java.sql.ResultSet R = Cmd2.executeQuery("SELECT MAX(TARIFFDTL_ID) FROM tariffdtl");
						R.next();
						int nextId=R.getInt(1);
                     	String newId = String.valueOf(nextId+1);
                     	R.close();
						//store newly created id
						dtlIdTm.put(id1,parentId+"|"+newId);	
						
						sqlStatement="INSERT INTO tariffdtl  SET "+sqlSetStatement+" , TARIFFDTL_ID = "+newId+" , TARIFFHDR_ID = "+parentId;	
					}
					
System.out.println("sqlStatement [ "+sqlStatement+"]");		

			try {
		 		Cmd.executeUpdate(sqlStatement);
			}catch (Exception e) {
			}
		 
      }//isAdded and isDTL
	  
   }//loop changes 
   
   
   
   //PROCESS DETAIL RATES ADDED
   for(int i=0;i<Ch.length;i++){
    org.w3c.dom.Element I = Ch[i];
    String[] id = getIds(I);
		  			
		//added process	
		if (isAdded(I) && isDTLR(I)) {

			//split id to headerid and detailid
			java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(id[0], "|");	
			String id1 = id[0];
			try {id1 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
			String id2 = "";
			try {id2 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
			String id3 = "";
			try {id3 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
				
			//generate sql set statement
			String sqlSetStatement = "";
            org.w3c.dom.NamedNodeMap A = I.getAttributes();
            for(int a=0;a<A.getLength();a++){
               	org.w3c.dom.Node N = A.item(a);
               	String name = N.getNodeName();
				String val = N.getNodeValue();
			
				//do not process action name fields
				if (!java.util.Arrays.asList(excludeNames).contains(name)) {
							  
					//check name fields
					if (isDTLR(I)) {					
						if (java.util.Arrays.asList(includeTariffdtlrNames).contains(name)) {
							//build sql set statement
							if (sqlSetStatement.equals("")) {
								sqlSetStatement += " "+name+" = "+toSQL(val) ;
							} else {
								sqlSetStatement += " , "+name+" = "+toSQL(val) ;
							}
						}
					}	
					
				}
			  
            }//loop changed fields

			String sqlStatement="";
System.out.println("in DTLR added isHDR["+isHDR(I)+"] isDTL["+isDTL(I)+"] isDTLR["+isDTLR(I)+"] id1["+id1+"] id2["+id2+"] id3["+id3+"] getParent["+getParent(I)+"]");

					if (isDTLR(I)) {
						String parentId=getParent(I);
						//lookup new header|detail id if parent newly created
						if (parentId.startsWith("NR")) parentId=(String)dtlIdTm.get(parentId);
						
						//split id to headerid and detailid
						stringTokenizer = new java.util.StringTokenizer(parentId, "|");	
						id1 = "";
						try {id1 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
						id2  = "";
						try {id2 = stringTokenizer.nextToken().trim();} catch (Exception e) {}
											
						sqlStatement="INSERT INTO tariffdtlr  SET "+sqlSetStatement+", TARIFFHDR_ID = "+id1+", TARIFFDTL_ID = "+id2;						
					}	
					
System.out.println("sqlStatement [ "+sqlStatement+"]");		

			try {
		 		Cmd.executeUpdate(sqlStatement);
			}catch (Exception e) {
			}
		 
      }//isAdded and isDTLR
	  
   }//loop changes 
 
   
	  
}//check changes found

Cmd.close();
Cmd2.close();

// --------------------------------------------------------------------------
%>

<?xml version="1.0"?>
<Grid>
   <IO 
   	Result='0'
	HtmlMessage='Changes successfully submitted to Server'
    HtmlMessageTime='3000'
   />
</Grid>
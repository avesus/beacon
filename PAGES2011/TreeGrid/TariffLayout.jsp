<%@page contentType="text/xml"%>

<%@page pageEncoding="UTF-8"%>

<%@include file="/pages/TreeGrid/Framework/TreeGridFramework.jsp"%>


<%
/*-----------------------------------------------------------------------------------------------------------------
! Support file only, run Grid.html instead !
  This file is used as Layout_Url for TreeGrid
  It generates layout structure for TreeGrid from database
------------------------------------------------------------------------------------------------------------------*/

//------------------------------------------------------------------------------------------------------------------
response.addHeader("Cache-Control","max-age=1, must-revalidate");




// --- Generating data ---
//String tablePrefix="PUB.";
//java.sql.Statement Cmd = getProgressStatement(request,out,"10.1.2.19:9500:mismon;WorkArounds=536870912","newport","newport")
String tablePrefix="";
java.sql.Statement Cmd = getMysqlStatement(request,out,"localhost:3306/beacon_cpg","",""); 

java.sql.ResultSet R = Cmd.executeQuery("SELECT addrkey, name, shortname FROM "+tablePrefix+"address where typekey = 'CARRIER' order by shortname");
StringBuffer vendorKeys = new StringBuffer();
StringBuffer vendorValues= new StringBuffer();
while(R.next()) {
	String key = R.getString("addrkey");
	String value = R.getString("shortname");
	if (
		!value.contains("'") &&
		!value.contains("%") &&
		!value.contains("&") &&
		!value.contains("=")
		) {
		vendorKeys.append("|"+key);
		vendorValues.append("|"+value);
	}
}


/*R = Cmd.executeQuery("SELECT * FROM "+tablePrefix+"g4code WHERE g1codekey = 'EUR' AND g2codekey='BENELUX' ");
StringBuffer g4Keys = new StringBuffer();
StringBuffer g4Values= new StringBuffer();
while(R.next()) {
	String key = R.getString("g4codekey");
	String value = R.getString("ldesc");
	if (!value.contains("'")) {
		g4Keys.append("|"+key);
		g4Values.append("|"+value);
	}
}*/


R = Cmd.executeQuery("SELECT * FROM "+tablePrefix+"location WHERE locationtype = 'PORT' ORDER BY locationname ");
StringBuffer locationKeys = new StringBuffer();
StringBuffer locationValues= new StringBuffer();
locationKeys.append("|");
locationValues.append("|");
while(R.next()) {
	String key = R.getString("locationkey");
	String value = R.getString("locationname");
	if (!value.contains("'")) {
		locationKeys.append("|"+key);
		locationValues.append("|"+value);
	}
}



/*R = Cmd.executeQuery("SELECT addrkey, name, shortname FROM "+tablePrefix+"address where typekey = 'POR' order by shortname");
StringBuffer portKeys = new StringBuffer();
StringBuffer portValues= new StringBuffer();
while(R.next()) {
	portKeys.append("|"+R.getString("addrkey"));
	portValues.append("|"+R.getString("shortname"));
}*/



R = Cmd.executeQuery("SELECT costkey, descr FROM "+tablePrefix+"cost order by descr ");
StringBuffer costKeys = new StringBuffer();
StringBuffer costValues= new StringBuffer();
while(R.next()) {
	costKeys.append("|"+R.getString("costkey"));
	costValues.append("|"+R.getString("descr"));
}



String indicatorKeys = "|&lt;div style=&#39;background-color:GREEN;color:WHITE;font-weight:bold;&#39;>|&lt;div style=&#39;background-color:GRAY;color:WHITE;font-weight:bold;&#39;>|&lt;div>|&lt;div style=&#39;background-color:RED;color:WHITE;font-weight:bold;&#39;>|&lt;div style=&#39;background-color:BLUE;color:WHITE;text-decoration:underline;font-weight:bold;&#39;>";
String indicatorValues= "|#1|#2|NEUT|NOT TO USE|CHECK";



// --- Generating layout ---
String Cols="", CSum="", DRes="", DDef1="", DDef2="";


DDef1 += "Ccykey='' "; 
DDef1 += "Amount='0' "; 
DDef1 += "Percentage='0' "; 
DDef1 += "Inclflag='0' "; 

DDef2 += "Unitrate='' "; 
DDef2 += "Fromvalue='' "; 
DDef2 += "Tovalue='' "; 



%>


<?xml version="1.0"?>
<Grid>
	<Cfg Code="BTASRZHRXDLUJC"/>
	<!-- Grid identification for saving configuration to cookies -->
   <Cfg id="ResourceGrid"/> 
   <Cfg MainCol='Project'/>
   <!-- Grid maximizes height of the main tag on page -->  
   <Cfg MaxHeight='1'/> 
   <!-- row ids are set by numbers -->
   <Cfg IdChars='0123456789' NumberId='1'/>

   <!-- This example hides deleted row instead of coloring them red --> 
   <Cfg ShowDeleted='0'/>
   <!-- In this example is dragging not permitted  -->  
   <Cfg Dragging='0'/>  
   <!-- count of rows at one page  -->
   <%--<Cfg PageLength='21'/>--%> 
   <Cfg Style="Office"/>
   <Cfg DateStrings="2"/>
   <Cfg ConstHeight="1"/>  
   <%--<Cfg MaxHeight="300"/> --%>
   <%-- Uses prefix (GS,GL,GO,GM,GB,GP,GR) for custom class names to support all style --%>
<%--   <Cfg UsePrefix='1'/> 
   <Cfg GroupIdPrefix='GR'/>
   <Cfg GroupIdPrefix='CR'/>--%>
<%--   <Cfg AutoIdPrefix='AR'/>--%>
   <Cfg IdPrefix='NR'/>
 
          
<!--   <Cfg 
        DateStrings='1' 
      	IdNames='Project' 
        AppendId='1' 
        FullId='1' 
        LastId='1' 
        CaseSensitiveId='1'
        />
-->        
 
    <!-- Cfg tag is splitted by attributes just for comments, you should merge them in your standard applications -->
    <!--
   <Cfg Paging='2' ChildPaging='2'/> Both paging set to client 
   <Cfg PageLength='21'/> count of rows at one page 
   <Cfg SaveSession='1'/> Stores IO Session to cookies to identify the client on server and access appropriate grid instance 
   <Cfg Sort='Project,Resource'/>  To sort grid according to Project and Resource for first time (when no configuration saved) 
   <Cfg GroupMain='Project'/> Shows grouping tree in column Project 
   <Cfg UsePrefix='1'/> Uses prefix (GS,GL,GO,GM,GB,GP,GR) for custom class names to support all style
   <Cfg Alternate='3'/>  Custom style setting, every third row will have different color 
-->
   
        
<LeftCols>
	<C Name='id' CanEdit='0' CanSort='0' />
    <C Name='Project' Width='200' Type='Enum' EnumKeys='<%=costKeys.toString()%>' Enum='<%=costValues.toString()%>'/>
    <C Name='Validfrom' Width='100' Type='Date' Format='"d. MMM yyyy' CanEdit='0'/> 
    <C Name='Validto' Width='100' Type='Date' Format='"d. MMM yyyy' CanEdit='0'/> 
    <C Name='Vendoraddrkey' Width='120' Type='Enum' EnumKeys='<%=vendorKeys.toString()%>' Enum='<%=vendorValues.toString()%>' CanEdit='0'/>      
    <C Name='Scnumber' Width='80' Type='Text' CanEdit='0'/>   
    <C Name='Imokey' Width='80' Type='Text' CanEdit='0'/>          
    <C Name='Fromlocationkey' Width='130' Type='Enum' EnumKeys='<%=locationKeys.toString()%>' Enum='<%=locationValues.toString()%>' CanEdit='0'/> 
    <C Name='Tolocationkey' Width='130'  Type='Enum' EnumKeys='<%=locationKeys.toString()%>' Enum='<%=locationValues.toString()%>' CanEdit='0'/> 
           
	<C Name='Ccykey' Width='70' Type='Enum' Enum='|EUR|USD' />
	<C Name='Amount' Width='70' Type='Float' Format='0.00'/>
	<C Name='Percentage' Width='60' Type='Float' Format='0.00'/>
	<C Name='Inclflag' Type='Bool'/>

	<C Name='Fromvalue' Width='55' Type='Float' Format='0.00'/>
	<C Name='Tovalue' Width='55' Type='Float' Format='0.00'/>
    <C Name='Unitrate' Width='55' Type='Float' Format='0.00'/>
	<C Name='Inclrateflag' Type='Bool'/>
        
</LeftCols>
   
<%--   <Cols><%=Cols%>
   </Cols>--%>
   
<RightCols>
	<C Name='Note1' Width='100' Type='Text' CanEdit='0'/>   
    <C Name='Note2' Width='100' Type='Text' CanEdit='0'/>     
    <C Name='Transittime' Width='70' Type='Int' CanEdit='0'/>
    <C Name='Tslocationkey' Width='150'  Type='Text' Suggest='<%=locationValues.toString()%>' SuggestSeperator='|' CanEdit='0'/> 
    <C Name='Tsdirectflag' Type='Bool' CanEdit='0'/>  
    <C Name='Indicator' Width='50'  Type='Enum' EnumKeys='<%=indicatorKeys%>' Enum='<%=indicatorValues%>' CanEdit='0'/> 
</RightCols>
   
<Def>

<%--      <D Name='R' Project='New resource' CDef='' AcceptDef='' <%=DDef%>/>
      <D Name='Node' Project='New project' CDef='R' AcceptDef='R' Calculated='1' SumFormula='sum()' <%=DRes%> ProjectHtmlPrefix='&lt;B>' ProjectHtmlPostfix='&lt;/B>'/>--%>
            
	<D
      	Name='HDR'
        CDef='DTL' AcceptDef='DTL' 
        
      	Calculated='1' 
        
        ProjectCanEdit='1'
        ProjectType='Text'
        
        ValidfromCanEdit='1'
        ValidtoCanEdit='1'
        
        VendoraddrkeyCanEdit='1'
        ScnumberCanEdit='1'
        ImokeyCanEdit='1'
                
        FromlocationkeyCanEdit='1'
        TolocationkeyCanEdit='1'
        TslocationkeyCanEdit='1'
        TsdirectflagCanEdit='1'
        TransittimeCanEdit='1'
        Note1CanEdit='1'
        Note2CanEdit='1'                
        IndicatorCanEdit='1'
        CcykeyCanEdit='1'
        
        AmountCanEdit='0'
        
        PercentageCanEdit='0'
        PercentageType='Text'
                        
        InclflagCanEdit='0'
        InclflagType='Text'
                 
        UnitrateCanEdit='0'
        UnitrateType='Text'
        
        FromvalueCanEdit='0'
        FromvalueType='Text'
        
        TovalueCanEdit='0' 
        TovalueType='Text' 
        
        InclrateflagCanEdit='0'
        InclrateflagType='Text'
        
        InclflagType='Text'
                              
	  	AmountFormula='sum()' 
	/>
      
    <D
      	Name='DTL'
        CDef='DTLR' AcceptDef='DTLR'
        
        ProjectCanEdit='1'
        CcykeyCanEdit='1'
        AmountCanEdit='1'
        PercentageCanEdit='1'
        InclflagCanEdit='1' 
        
        UnitrateCanEdit='0'
        UnitrateType='Text'
                
        FromvalueCanEdit='0'
        FromvalueType='Text'
                
        TovalueCanEdit='0'          
        TovalueType='Text' 
        
        InclrateflagCanEdit='0'        
        InclrateflagType='Text'  
         
        TsdirectflagType='Text'      
        TransittimeType='Text' 
                      
        <%=DDef1%>      
	/>
    
    <D
      	Name='DTLR'   
        CDef='' AcceptDef=''
        
        ProjectCanEdit='0'
        CcykeyCanEdit='0'
        AmountCanEdit='0'
        PercentageCanEdit='0'
        InclflagCanEdit='0'
         
        CcykeyType='Text'
        PercentageType='Text'        
        AmountType='Text'
        InclflagType='Text'   
        TransittimeType='Text' 
                                   
        UnitrateCanEdit='1'
        FromvalueCanEdit='1'
        TovalueCanEdit='1' 
                      
        <%=DDef2%>     
	/>
        
      
</Def>
   
   <!-- Parent of root nodes, accepts only Node rows -->
<%--   <Root CDef='Node' AcceptDef='Node'/>--%>
   <Root CDef='HDR' AcceptDef='HDR'/>
         
   <Header 
   		id='id' 
    	Project='Description / Cost'
        Validto='Validity'
        Validfrom='Date of Entry'
        Vendoraddrkey='Carrier'
        Scnumber='SC no.'  
        Imokey='IMO Class'                
        Fromlocationkey='Load Port'
        Tolocationkey='Port of Destination'  
        Indicator='Ind'  
        Ccykey='Ccy'
        Amount='Amount'  
		Percentage='%age'   
        Inclflag='Incl' 
        Tslocationkey='Transhipment'
        Tsdirectflag='Direct' 
        Note1='Additional'  
        Note2='Remarks'  
        Fromvalue='From' 
        Tovalue='To'  
        Unitrate='Rate' 
        Transittime='Transit'   
        Defaultrateflag='Def' 
        Inclrateflag='Incl'                                           
    />
   
<%-- <Foot>
<I Kind='Space' RelHeight='100'/>
<I Def='Node' Project='Total results' ProjectCanEdit='0'/>
   </Foot>--%>

	<Toolbar 
    	Styles='0'
        Sort='0'
        Columns='0'
        Cfg='0'
        Debug='0'
        Formula='0'
        Calc='0'  
        Help='0'        
        />

   
</Grid>





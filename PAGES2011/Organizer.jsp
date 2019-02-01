<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



    <style type="text/css">
 	  	  
      .sb-result {
        border-collapse : collapse;
        border : 1px solid #999999;
        color : #676767;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;		
      }

      .sb-result2 {
        border-collapse : collapse;
        border : 1px solid #999999;
        color : #676767;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;		
      }

      .sb-result3 {
        border-collapse : collapse;
        border : 1px solid #999999;
        color : #676767;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;		
      }
	  	  
      .sb-result td {
        vertical-align : top;
        border : 1px solid #999999;
        padding-left : 4px;
        padding-right : 4px;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;				
      }

      .sb-result2 td {
        vertical-align : top;
        border : 1px solid #999999;
        padding-left : 4px;
        padding-right : 4px;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;				
      }
	  
	.sb-result3 td {
        vertical-align : top;
        border : 1px solid #999999;
        padding-left : 4px;
        padding-right : 4px;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;				
      }
	  
	  
      #dataheader td {
        text-align : left;
        color : black;
        font-weight : bold;
        margin-bottom : 6px;
        font-family: "trebuchet ms", verdana, sans-serif;
        font-size: 12px;			
      }


      td.sb-cell1 {
        width : 25px;
        background-color : #f9f9f9;		
      }

      td.sb-cell2 {
        width : 249px;
      }

      td.sb-cell3 {
        width : 300px;
      }
	  
      td.sb-cell4 {
        width : 100px;
      }
	  
      td.sb-cell5 {
        width : 100px;
      }
	  	
		
      td.sb-cell21 {
        width : 25px;
        background-color : #f9f9f9;		
      }

      td.sb-cell22 {
        width : 249px;
      }

      td.sb-cell23 {
        width : 300px;
      }
	  
      td.sb-cell24 {
        width : 100px;
      }
	  
      td.sb-cell25 {
        width : 100px;
      }
	  
	  	
      td.sb-cell31 {
        width : 284px;
        background-color : #f9f9f9;		
      }

      td.sb-cell32 {
        width : 300px;
      }

      td.sb-cell33 {
        width : 100px;
      }
	  
      td.sb-cell34 {
        width : 100px;
      }
	  
	  			  	  
      div.visible {
        display : block;
      }

      div.invisible {
        display : none;
      }
	  
	  
	  	/* Display block */
	 .DisplayBlock {
	  display : block;
	}
	/* Display none */
	 .DisplayNone {
	  display: none;
	 }

    </style>

<script language="javascript" type="text/javascript">
//<![CDATA[
	function onOrganizerLoad() {
			
		MM_swapImage(
			'org_buttop','','images/org_quotations_over.gif',
			'org_butmid','','images/org_orders_over.gif',
			'org_butbot','','images/org_availableunits_over.gif',		
			1);
			
		var resultsDiv = document.getElementById("saved_results");
	    removeChildren(resultsDiv);
		processRefreshQuohdrList();					
		resultsDiv = document.getElementById("saved_results2");
	    removeChildren(resultsDiv);
		resultsDiv = document.getElementById("saved_results3");
	    removeChildren(resultsDiv);					

		P7AniMagic('org_navtop',0,0,20,1,0,0);
		P7AniMagic('org_navmid',0,20,20,1,0,0);		
		P7AniMagic('org_navbot',0,40,20,1,0,0);	
			
		classChange(org_subtop,'DisplayNone');
		classChange(org_submid,'DisplayNone');	
		classChange(org_subbot,'DisplayNone');
						
		//P7_autoLayers('org_subtop','closer');	
									
	}
    //]]>
</script>

<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax.js"></script>		
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/quotation/RefreshQuohdrList.js"></script>	
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/RefreshOrderhdrList.js"></script>	
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/RefreshUnitList.js"></script>	
	
<logic:present name="user">
		
<html:form action="/SubmitLogon">
<html:hidden name="user" property="userid"/>

		
<input type="hidden" name="movests" value="AVAILABLE"/>
<input type="hidden" name="invsts" value="AVAILABLE"/>

<!-- body -->
<table cellpadding="2" cellspacing="2" border="0" width="100%" bgcolor="#ffffff">	

	<tr>
		<td>
	
<div id="org_nav" style="position:absolute; left:0px; top:0px; width:820px; height:449px; z-index:11; visibility: visible"> 

  <div id="org_scrollarea" style="position:absolute; width:820px; height:300px; z-index:12; left:0px; top: 0px">

    <div id="org_subtop" style="position:absolute; left:0; top:20px; width:820px; height:300px; z-index:13; visibility: hidden; OVERFLOW:auto;"> 
      <table bgcolor="#ffffff" width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr bgcolor="#FFFFFF"> 
          <td> 			     
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="820px">
          <table id="dataheader" class="sb-result">
            	<td class="sb-cell1">ID</td>
            	<td class="sb-cell2">Quote No</td>
            	<td class="sb-cell3">Customer</td>
            	<td class="sb-cell4">Quote Status</td>
            	<td class="sb-cell5">Quote Date</td>														
          </table>		  
          <div id="saved_results" class="visible"></div>
        </td>
      </tr>
    </table>
		  </td>
        </tr>
		      
       </table>
    </div>
	
    <div id="org_submid" style="position:absolute; width:820px; height:300px; z-index:14; left:0px; top: 40px; visibility: hidden; OVERFLOW:auto;"> 
      <table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">  	  

         <tr bgcolor="#FFFFFF"> 
          <td> 			     
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="820px">
          <table id="dataheader" class="sb-result2">
            	<td class="sb-cell21">ID</td>
            	<td class="sb-cell22">Order No</td>
            	<td class="sb-cell23">Customer</td>
            	<td class="sb-cell24">Invoice Status</td>
            	<td class="sb-cell25">Order Date</td>													
          </table>		  
          <div id="saved_results2" class="visible"></div>
        </td>
      </tr>
    </table>
		  </td>
        </tr>
	  										
		</table>
    </div>
		    
    <div id="org_subbot" style="position:absolute; width:820px; height:300px; z-index:16; left: 0; top: 60px; visibility: hidden; OVERFLOW:auto;"> 
      <table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">	

        <tr bgcolor="#FFFFFF"> 
          <td> 			     
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td valign="top" width="820px">
          <table id="dataheader" class="sb-result3">
            	<td class="sb-cell31">Unit</td>
            	<td class="sb-cell32">Movement Location</td>					
            	<td class="sb-cell33">Inventory Status</td>
            	<td class="sb-cell34">Movement Date</td>												
          </table>		  
          <div id="saved_results3" class="visible"></div>
        </td>
      </tr>
    </table>
		  </td>
        </tr>
		  
      </table>
    </div>
	
    <div id="org_navtop" style="position:absolute; left:0px; top:0px; width:820px; height:20px; z-index:17">
		<a 	
			href="#"  
			onClick="
			MM_swapImage(
				'org_buttop','','images/org_quotations_down_over.gif',
				'org_butmid','','images/org_orders_over.gif',
				'org_butbot','','images/org_availableunits_over.gif'
				);
			P7AniMagic('org_navtop',0,0,20,1,0,0);			
			P7AniMagic('org_navmid',0,350,20,1,0,0);
			P7AniMagic('org_navbot',0,370,20,1,0,0);		
			P7_autoLayers('org_subtop','closer');
			MM_swapImage(
				'buttop','','images/nav_operations_over.gif',
				'butmid','','images/nav_maintenance_over.gif',
				'butmid2','','images/nav_reports_over.gif',		
				'butbot','','images/nav_system_over.gif'
				);			
			P7AniMagic('navtop',0,0,20,1,0,0);
			P7AniMagic('navmid',0,20,20,1,0,0);
			P7AniMagic('navmid2',0,40,20,1,0,0);
			P7AniMagic('navbot',0,60,20,1,0,0);	
			processRefreshQuohdrList();			
			"
			onFocus="if(this.blur)this.blur()">
		<img src="images/org_quotations_over.gif" border="0" name="org_buttop"/></a>
    </div>

    <div id="org_navmid" style="position:absolute; left:0px; top:20px; width:820px; height:20px; z-index:18"> 
		<a 
	  		href="#" 
			onClick="
			MM_swapImage(
				'org_buttop','','images/org_quotations_over.gif',
				'org_butmid','','images/org_orders_down_over.gif',
				'org_butbot','','images/org_availableunits_over.gif'
				);
			P7AniMagic('org_navtop',0,0,20,1,0,0);
			P7AniMagic('org_navmid',0,20,20,1,0,0);
			P7AniMagic('org_navbot',0,370,20,1,0,0);		
			P7_autoLayers('org_submid','closer');
			MM_swapImage(
				'buttop','','images/nav_operations_over.gif',
				'butmid','','images/nav_maintenance_over.gif',
				'butmid2','','images/nav_reports_over.gif',		
				'butbot','','images/nav_system_over.gif'
				);			
			P7AniMagic('navtop',0,0,20,1,0,0);
			P7AniMagic('navmid',0,20,20,1,0,0);
			P7AniMagic('navmid2',0,40,20,1,0,0);
			P7AniMagic('navbot',0,60,20,1,0,0);	
			processRefreshOrderhdrList();							
			" 
			onFocus="if(this.blur)this.blur()">
		<img src="images/org_orders_over.gif" border="0" name="org_butmid"/></a> 
    </div>
		
    <div id="org_navbot" style="position:absolute; left:0px;  top: 40px; width:820px; height:20px; z-index:20">
		<a
			href="#" 
			onClick="
			MM_swapImage(
				'org_buttop','','images/org_quotations_over.gif',
				'org_butmid','','images/org_orders_over.gif',
				'org_butbot','','images/org_availableunits_down_over.gif'
				);
			P7AniMagic('org_navtop',0,0,20,1,0,0);
			P7AniMagic('org_navmid',0,20,20,1,0,0);
			P7AniMagic('org_navbot',0,40,20,1,0,0);		
			P7_autoLayers('org_subbot','closer');
			MM_swapImage(
				'buttop','','images/nav_operations_over.gif',
				'butmid','','images/nav_maintenance_over.gif',
				'butmid2','','images/nav_reports_over.gif',		
				'butbot','','images/nav_system_over.gif'
				);			
			P7AniMagic('navtop',0,0,20,1,0,0);
			P7AniMagic('navmid',0,20,20,1,0,0);
			P7AniMagic('navmid2',0,40,20,1,0,0);
			P7AniMagic('navbot',0,60,20,1,0,0);	
			processRefreshUnitList();		
			" 
			onFocus="if(this.blur)this.blur()">
			<img src="images/org_availableunits_over.gif" border="0" name="org_butbot"/></a>
    </div>
     
  </div>
  
</div>
	
		</td>
	</tr>

<tr>
<td>

</td>
</tr>
		
</table>

<!-- body -->


</html:form>

		
</logic:present>


<logic:notPresent name="user">
<!-- body -->


<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td class="tdwht">

</td>
</tr>
</table>

<!-- body -->
</logic:notPresent>

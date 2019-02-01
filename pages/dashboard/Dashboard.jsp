<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
-->
 
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
  
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->
  




<app:checkLogon/>

<html:html>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">


<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		onLoadSidebar('menu1');									
	}
    //]]>
</script>


<head>

<title><bean:message key="dashboard.title"/></title>

</head>



<!-- start analysis pool -->
<%@ include file="/includes/analysispool.inc.jsp" %>
<!-- end datapool -->

<!-- start dashboard pool -->
<%@ include file="/includes/dashboardpool.inc.jsp" %>
<!-- end datapool -->


<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>









<style type="text/css">
<!--


#desktopBody {
	font-family: Arial, Verdana, Helvetica;
	font-size: 11px;
	font-weight: normal;
	color: #000000;
	padding-left:0px;
	padding-right: 0px;
	padding-top: 0px;
	padding-bottom: 0px; 	
}

/* ---------- big icon buttons  --------- */
.toolsArea .commonButton {
  background-position: top center;
  background-repeat: no-repeat;
  background-color: transparent;
  padding: 0 1px;
  min-height: 32px;
  cursor: pointer;
  text-align: center;
  vertical-align: top;
  margin-bottom: 12px;
}

.toolsArea .commonButton span {
  display: block;
  text-align: center;
  width: 120px;
  padding-top: 10px;
  vertical-align: top;
  font-size:11px;
}

.commonButton a:link, .commonButton a:visited, .commonButton a:active {
  text-decoration: none;
}

.toolsArea span.commonButton {
  cursor: default;
  color: #999999;
  text-decoration: none;
  margin-right: -3px;
}


/* ---------- slist  --------- */

.list {
}

.list .selected {
  background-color: #ecf0fb;
}

.list td {
font-size:10px;
}

.list th {
font-size:10px;
}

th {
  padding: 5px;
  text-align: left;
  background: #D6DFF7;
  border-right: 1px solid #ffffff;
  border-bottom: 1px solid #ffffff;
}

th a:link, th a:visited, th a:active {
  color: #000000;
  text-decoration: none;
}

th a:hover {
  text-decoration: underline;
}

.sort {
	background-color: #ABBEEF; 
}

.list td {
	border: 0px;
	padding: 5px;
}

.evenrowbg {
background-color: #F0F0F0; 
}

.oddrowbg {
	background-color: #ffffff;
}
/* ---------- elist  --------- */


.toolsArea .screenButtons .commonButton span {
  background: none;
}

/* ---------- common.css  --------- */
legend {
  color: #000000;
  font-weight: bold;
  font-size:11px;
}
fieldset {
  border: none;
  border-top: 1px solid #D0D0D0;
}


/* ---------- layout.css  --------- */
fieldset {
 margin: 10px 0 0 0;
 padding: 0;
}
fieldset > legend {
  margin-left: -7px;
  padding-left: 0;
  padding-right: 9px;
  padding-top: 2px;
  margin-top: -2px;
}

legend img {
  vertical-align: middle;
}

fieldset p {
  margin: 5px 0;
}

* html fieldset {
 margin-top: 0;
 padding-top: 10px;
}

legend {
  margin-bottom: 10px;
  margin-left: -9px;
  padding-right: 10px;
  vertical-align: middle;
  padding-left: 5px;
  padding-bottom: 1px;
}

-->
</style>



<link href="css/Flotr2/main.css" rel="stylesheet" type="text/css" />
<script src="scripts/Flotr2/flotr2.min.js"></script>


<body onLoad="onLoad();">  

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>


<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1">
	<td rowspan="3" width="121" valign="top" align="center" class="sidebar">
	<jsp:include page="/pages/sidebar.jsp" flush="true" />
	</td> 
	<td>
    <span class="header2"><bean:message key="dashboard.title"/></span>						 				
	</td> 
</tr>  

<tr valign="top">
	<td height="1" bgcolor="#D0D0D0"><img src="images/spacer.gif" width="1" height="1"></td>
</tr>


<tr>

	

	<td align="center" class="middle">
		<div style="OVERFLOW:auto; width:940px; height:650px; position:relative;">	 

<div style="color: #000000;
	padding-left: 5px;
	padding-right: 5px;
	padding-top: 5px;
	padding-bottom: 0px;
	width:900px">
    	
	<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>        

	<div class="toolsArea">
         				
<!-- DASHBOARD -->

<fieldset>

<legend><html:img src="images/icons/icon_analysis.png" alt="Analysis" border="0" align="left"/> Analysis</legend>

<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">

<tr>
<td class="column-header5">Status</td>   
<td class="column-header6">Current Month [All Users]</td>      
<td class="column-header6">Current Year [All Users]</td> 
<td class="column-header6">Current Month [<bean:write name="user" property="name" />]</td> 
<td class="column-header6">Current Year [<bean:write name="user" property="name" />]</td> 	
</tr>        

<logic:notEqual name="analysistype1" value="">
<tr>
		<td class="column-cell9">Quotations Approved </td>   
    <logic:iterate id="labelvalue" name="analysislist1">        
    	<td class="column-cell9"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype2" value="">
<tr>
		<td class="column-cell10">Quotations Rejected </td>   
    <logic:iterate id="labelvalue" name="analysislist2">        
    	<td class="column-cell10"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype3" value="">
<tr>
		<td class="column-cell9">Quotations Pending </td>   
    <logic:iterate id="labelvalue" name="analysislist3">        
    	<td class="column-cell9"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype4" value="">
<tr>
		<td class="column-cell10">Orders Fully Invoiced</td>   
    <logic:iterate id="labelvalue" name="analysislist4">        
    	<td class="column-cell10"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype5" value="">
<tr>
		<td class="column-cell9">Orders Part Invoiced </td>   
    <logic:iterate id="labelvalue" name="analysislist5">        
    	<td class="column-cell9"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype6" value="">
<tr>
		<td class="column-cell10">Orders Not Invoiced</td>   
    <logic:iterate id="labelvalue" name="analysislist6">        
    	<td class="column-cell10"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype9" value="">
<tr>
		<td class="column-cell9">Sales Invoices Ready to Build </td>   
    <logic:iterate id="labelvalue" name="analysislist9">        
    	<td class="column-cell9"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype7" value="">
<tr>
		<td class="column-cell10">Sales Invoices Printed</td>   
    <logic:iterate id="labelvalue" name="analysislist7">        
    	<td class="column-cell10"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
<logic:notEqual name="analysistype8" value="">
<tr>
		<td class="column-cell9">Sales Invoices Not Printed </td>   
    <logic:iterate id="labelvalue" name="analysislist8">        
    	<td class="column-cell9"><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:notEqual>
</table>

</td></tr></table>

</fieldset>





<!-- pending quotations approval -->
<logic:notEmpty name="dashboardlist1">
<fieldset>
<legend><html:img src="images/icons/icon_task.png" alt="Workflow Pending Approval" border="0" align="left"/> <bean:message key="heading.workflowpendingapproval"/></legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
	<tr>

		<td class="column-header5" width="8%">              
										<span><bean:message key="heading.userid"/></span>                        
		</td>          
		<td class="column-header6" width="8%">              
										<span><bean:message key="heading.groupid"/></span>                        
		</td>                  
		<td class="column-header6" width="14%">              
										<span><bean:message key="heading.quotno"/></span>                        
		</td>                 
		<td class="column-header6" width="10%">              
<bean:message key="heading.quotestatus"/></span>                        
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.quotedate"/></span>                        
		</td>        
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.quotecreateby"/></span>                        
		</td>                                
    	<td class="column-header7" width="10%" nowrap>&nbsp;</td>	
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist1">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="userid" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="usergroupid" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<img src="images/icon_warn_12_12.gif" width="12" height="12"/>										
<bean:write name="lineItem" property="quotestatus" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotedate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap><bean:write name="lineItem" property="quotebyuserid" filter="true"/>&nbsp;
            </td>                    
			<td class="<%= _class %>" align="right" nowrap>
<html:link action="/DashboardListQuoapprove.do" paramId="id" paramName="lineItem" paramProperty="quohdrId"><bean:message key="prompt.approvereject"/></html:link>           																																										
			</td>
		</tr>	
                    			  
	</logic:iterate>          
                
</table>

</td></tr></table>
</fieldset>
</logic:notEmpty>


<!-- orders not assigned -->
<%--<fieldset>
<legend><html:img src="images/icons/icon_order.png" alt="Orders Unassigned" border="0" align="left"/> <bean:message key="heading.ordersunassigned"/></legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

</td></tr></table>
</fieldset>--%>


<!-- quotations expiring -->
<logic:notEmpty name="dashboardlist1">
<fieldset>
<legend><html:img src="images/icons/icon_quotation.png" alt="Quotations Expiring" border="0" align="left"/> <bean:message key="heading.quotationsexpiring"/> within <bean:write name="daterangedays2" filter="true"/> days </legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td> 

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class="column-header5" width="8%">              
										<span><bean:message key="heading.quotno"/></span>                        
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.quotedate"/></span>                        
		</td>        
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.effectivedate"/></span>                        
		</td>                
		<td class="column-header6" width="9%">              
										<span><bean:message key="heading.expirydate"/></span>                        
		</td>           
		<td class="column-header6" width="5%">              
										<span><bean:message key="heading.createdby"/></span>                        
		</td>        
		<td class="column-header6" width="9%">              
										<span><bean:message key="heading.status"/></span>                        
		</td>        
		<td class="column-header6" width="20%">
										<span><bean:message key="heading.customer"/></span>                                        
        </td>  
		<td class="column-header6" width="10%">
										<span><bean:message key="heading.shipmethod"/></span>                        
		</td>                         
    	<td class="column-header7" width="19%" nowrap>&nbsp;</td>	
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist2">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotno" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotedate" format="dd-MMM-yyyy" filter="true"/>
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="effectivedate" format="dd-MMM-yyyy" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="expirydate" format="dd-MMM-yyyy" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotebyuserid" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
            <logic:equal name="lineItem" property="quotestatus" value="PENDING">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.quotestatus}"/>'/>
			</logic:equal>
            <logic:equal name="lineItem" property="quotestatus" value="APPROVED">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.quotestatus}"/>'/>
			</logic:equal>            
            <logic:equal name="lineItem" property="quotestatus" value="REJECTED">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.quotestatus}"/>'/>
			</logic:equal>						  				  			  
			  <bean:write name="lineItem" property="quotestatus" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="customeraddrkey.name" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="shipmethod" filter="true"/>&nbsp;
			</td>            
			<td class="<%= _class %>" align="right" nowrap>    
<html:link action="/ListQuohdr.do" paramId="searchString1" paramName="lineItem" paramProperty="quotno"><bean:message key="prompt.select"/></html:link>    																																										
			</td>
		</tr>														
                    			  
	</logic:iterate>
                          
</table>            

</td></tr></table>
</fieldset>
</logic:notEmpty>                
     

<!-- job movements to actualise -->
<logic:notEmpty name="dashboardlist5">
<fieldset>
<legend><html:img src="images/icons/icon_task.png" alt="Job Movements to Actualise" border="0" align="left"/> <bean:message key="heading.jobmovementstoactualise"/></legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
	<tr>

		  						<td class="column-header5" width="10%">              
										<span><bean:message key="heading.unit"/></span>                        
								</td>
		  						<td class="column-header6" width="10%">              
										<span><bean:message key="heading.jobno"/></span>                        
								</td>                                
		  						<td class="column-header6" width="10%">              
										<span><bean:message key="heading.section"/></span>                        
								</td>

		  						<td class="column-header6" width="6%">
										<span><bean:message key="heading.status"/></span>                                                                      
								</td>
                                                    
		  						<td class="column-header6" width="12%">
										<span><bean:message key="heading.fromlocation"/></span>                                                                      
								</td>
                    
					  			<td class="column-header6" width="10%">
										<span><bean:message key="heading.fromdatetime"/></span>                             	
								</td>  

                                
					  			<td class="column-header6" width="12%">
										<span><bean:message key="heading.tolocation"/></span>                                	
								</td>                                 

					  			<td class="column-header6" width="10%">
										<span><bean:message key="heading.todatetime"/></span>                           	
								</td>   
 
                                                                                                                                                					  			<td class="column-header6" width="15%">
										<span><bean:message key="heading.vendor"/></span>                              	
								</td> 


                                                                
                                                                                     					
		  						<td class="column-header7" width="10%"></td>
	
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist5">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		
<tr>
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="unit" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="jobhdrId" filter="true"/>
                                    </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="section.sectionkey" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="invsts" filter="true"/>								
                        </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="fromlocation.shortName" filter="true"/>								
                        </td> 
 
									<td class="<%= _class %>" nowrap valign="top">
<span class="label14"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="lineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${lineItem.estfromtime}"/><br/>		
<span class="label14"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="lineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${lineItem.actfromtime}"/>
                        			</td>                                    									
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="tolocation.shortName" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap valign="top">
<span class="label14"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="lineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${lineItem.esttotime}"/><br/>
<span class="label14"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="lineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${lineItem.acttotime}"/>
                        			</td>                                      
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="lineItem" property="vendoraddr.shortname" filter="true"/>
                        			</td>    
                                                                                                             
									<td class="<%= _class %>" nowrap valign="top">
<jsp:useBean id="params" class="java.util.HashMap"/>
<c:set target="${params}" property="jobhdrId" value="${lineItem.jobhdrId}"/>
<c:set target="${params}" property="jobmovId" value="${lineItem.jobmovId}"/>
<c:set target="${params}" property="action" value="Edit"/>
<html:link action="/DashboardEditJobmov.do" name="params"><bean:message key="prompt.update"/></html:link>   	                                    
									</td>
								</tr>        	
                                                    			  
	</logic:iterate>
                           
</table>

</td></tr></table>
</fieldset>
</logic:notEmpty>  


<!-- sales invoices to build -->
<logic:notEmpty name="dashboardlist3">
<fieldset>
<legend><html:img src="images/icons/icon_createsalesinvoices.png" alt="Sales Invoices to Build" border="0" align="left"/> <bean:message key="heading.salesinvoicestobuild"/></legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
	<tr>  
		<td class="column-header5" width="10%">              
										<span><bean:message key="heading.orderno"/></span>                        
		</td>        
   
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.orderdate"/></span>                        
		</td>   
        
        
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.charge"/></span>                        
		</td>          
        
		<td class="column-header6" width="30%">              
										<span><bean:message key="heading.billingaccount"/></span>
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.invoiceccy"/></span>                        
   		</td>                              
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist3">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>                   
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="orderno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="orderdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="charge.chargekey" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="customer.name" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="invoiceccykey" filter="true"/>&nbsp;
			</td>  

		</tr>	
                    			  
</logic:iterate>                
                
</table>

</td></tr></table>
</fieldset>
</logic:notEmpty>


<!-- sales invoices to print -->
<logic:notEmpty name="dashboardlist4">
<fieldset>
<legend><html:img src="images/icons/icon_salesinvoices.png" alt="Sales Invoices to Print" border="0" align="left"/> <bean:message key="heading.salesinvoicestoprint"/></legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#FFFFFF">
	<tr>  
		<td class="column-header5" width="10%">              
										<span><bean:message key="heading.docid"/></span>                        
		</td>        
   
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.createdate"/></span>                        
		</td>   
		<td class="column-header6" width="30%">              
										<span><bean:message key="heading.billingaccount"/></span>                        
		</td>                     
                
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.invoiceccy"/></span>                        
   		</td> 
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.invoiceamt"/></span>                        
   		</td>                  
    	<td class="column-header7" width="10%" nowrap>&nbsp;</td>	                    
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist4">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>                   
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="sihdrId" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="customeraddrkey.name" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="invoiceccykey" filter="true"/>&nbsp;         
            </td>            
			<td class="<%= _class %>" nowrap align="right">
&nbsp;<bean:write name="lineItem" property="invoiceamt" filter="true"/>  
			</td>   
			<td class="<%= _class %>" align="right" nowrap>    
<html:link action="/ListSihdr.do" paramId="searchString2" paramName="lineItem" paramProperty="sihdrId"><bean:message key="prompt.select"/></html:link>           																																										
			</td>
            
		</tr>
                  			  
</logic:iterate>                             
                
</table>

</td></tr></table>
</fieldset>
</logic:notEmpty>  


<!-- vendor tariffs expiring -->
<logic:notEmpty name="dashboardlist6">
<fieldset>
<legend><html:img src="images/icons/icon_vendortariff.png" alt="Vendor Tariffs Expiring" border="0" align="left"/> <bean:message key="heading.vendortariffsexpiring"/> within <bean:write name="daterangedays6" filter="true"/> days </legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class="column-header5" width="8%">              
										<span><bean:message key="heading.code"/></span>                        
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.vendor"/></span>                        
		</td>        
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.cost"/></span>                        
		</td>                
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.fromlocation"/></span>                        
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.tolocation"/></span>                        
		</td>        
		<td class="column-header6" width="5%">              
										<span><bean:message key="heading.currency"/></span>                        
		</td>        
		<td class="column-header6" width="7%">
										<span><bean:message key="heading.lumpsum"/></span>                                        
        </td>  
		<td class="column-header6" width="10%">
										<span><bean:message key="heading.validfrom"/></span>                        
		</td> 
		<td class="column-header6" width="10%">
										<span><bean:message key="heading.expirydate"/></span>                        
		</td>                                    
    	<td class="column-header7" width="10%" nowrap>&nbsp;</td>	
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist6">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="vendtarfhdrId" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="vendoraddrkey.name" filter="true"/>
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="costkey.costkey" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="fromlocationkey.locationName" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="tolocationkey.locationName" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="ccykey" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="lumpsum" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="validfrom" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td> 
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="validto" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>                                     
			<td class="<%= _class %>" align="right" nowrap>    
<html:link action="/ListVendortariffhdr.do" paramId="searchString3" paramName="lineItem" paramProperty="vendtarfhdrId"><bean:message key="prompt.select"/></html:link>    																																										
			</td>
		</tr>														
                    			  
	</logic:iterate>               
                
</table>

</td></tr></table>
</fieldset>
</logic:notEmpty> 


<!-- customer tariffs expiring -->
<logic:notEmpty name="dashboardlist7">
<fieldset>
<legend><html:img src="images/icons/icon_customertariff.png" alt="Customer Tariffs Expiring" border="0" align="left"/> <bean:message key="heading.customertariffsexpiring"/> within <bean:write name="daterangedays7" filter="true"/> days </legend>
<table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
	<tr>
		<td class="column-header5" width="8%">              
										<span><bean:message key="heading.code"/></span>                        
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.customer"/></span>                        
		</td>        
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.charge"/></span>                        
		</td>                
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.fromlocation"/></span>                        
		</td>           
		<td class="column-header6" width="10%">              
										<span><bean:message key="heading.tolocation"/></span>                        
		</td>        
		<td class="column-header6" width="5%">              
										<span><bean:message key="heading.currency"/></span>                        
		</td>        
		<td class="column-header6" width="7%">
										<span><bean:message key="heading.lumpsum"/></span>                                        
        </td>  
		<td class="column-header6" width="10%">
										<span><bean:message key="heading.validfrom"/></span>                        
		</td> 
		<td class="column-header6" width="10%">
										<span><bean:message key="heading.expirydate"/></span>                        
		</td>                                    
    	<td class="column-header7" width="10%" nowrap>&nbsp;</td>	
	</tr>  

<%int row=0;%>

    <logic:iterate id="lineItem" name="dashboardlist7">
          
<%String _class = "column-cell9";if ((row % 2) == 0) _class = "column-cell10";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="custtarfhdrId" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="customeraddrkey.name" filter="true"/>
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="chargekey.chargekey" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="fromlocationkey.locationName" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="tolocationkey.locationName" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="ccykey" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="lumpsum" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="validfrom" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td> 
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="validto" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>                                     
			<td class="<%= _class %>" align="right" nowrap>    
<html:link action="/ListCustomertariffhdr.do" paramId="searchString3" paramName="lineItem" paramProperty="custtarfhdrId"><bean:message key="prompt.select"/></html:link>    																																										
			</td>
		</tr>														
                    			  
	</logic:iterate>             
                
</table>

</td></tr></table>
</fieldset>
</logic:notEmpty>   


	</div>
    
    </td></tr></table>
    
</div>
    	
		</div>
	</td>

		
</tr>

<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

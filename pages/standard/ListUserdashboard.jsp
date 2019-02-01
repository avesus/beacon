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


<script language="JavaScript">

function screenRefresh() 
{
}

</script>



  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="userdashboard.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.userid"/>&nbsp;-&nbsp;<bean:write name="ListUserdashboardForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
<span class="header2">
	<bean:message key="userdashboard.title.list"/>
    &gt;
</span>
	<html:link action="/ListUser"><span class="header3"><bean:message key="user.title.list"/></span></html:link> 
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
			<html:form action="/ListUserdashboard">
			<html:hidden property="gotoPage" />
			<html:hidden name="ListUserdashboardForm" property="headerInfo1"/>        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditUserdashboard.do?'+
'&amp;userid='+
document.forms[0].headerInfo1.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListUser.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>                                                  
					</div> 
				</td></tr>
 

        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
		  						<td class="column-header1" width="25%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListUserdashboard.do?orderBy=Dashboardid&gotoPage=0'">
										<span><bean:message key="heading.dashboardid"/></span>                        
										<logic:notEqual name="ListUserdashboardForm" property="orderBy" scope="session" value="Dashboardid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListUserdashboardForm" property="orderBy" scope="session" value="Dashboardid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                    
		  						<td class="column-header2" width="25%">
							         <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListUserdashboard.do?orderBy=Dashboardtype&gotoPage=0'">
										<span><bean:message key="heading.dashboardtype"/></span>          
										<logic:notEqual name="ListUserdashboardForm" property="orderBy" scope="session" value="Dashboardtype">              
											<img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListUserdashboardForm" property="orderBy" scope="session" value="Dashboardtype">              
											<img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>  
							        </button>                                                             
								</td>                                
                                      
		  						<td class="column-header2" width="25%">
							         <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListUserdashboard.do?orderBy=Daterangedays&gotoPage=0'">
										<span><bean:message key="heading.daterangedays"/></span>          
										<logic:notEqual name="ListUserdashboardForm" property="orderBy" scope="session" value="Daterangedays">              
											<img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListUserdashboardForm" property="orderBy" scope="session" value="Daterangedays">              
											<img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>  
							        </button>                                                             
								</td> 
                                                                                                                                  					
		  						<td width="25%"></td>
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListUserdashboardForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><bean:write name="lineItem" property="dashboardid" filter="true"/></td> 
									<td class="<%= _class %>"><bean:write name="lineItem" property="dashboardtype" filter="true"/></td>									<td class="<%= _class %>"><bean:write name="lineItem" property="daterangedays" filter="true"/>&nbsp;</td> 
                                                                                                                                         					 
									<td class="<%= _class %>">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
		  										<td></td>

                                    			<td align="right">
<html:link action="/EditUserdashboard.do?action=Edit" paramId="userdashboardId" paramName="lineItem" paramProperty="userdashboardId"><bean:message key="prompt.edit"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditUserdashboard.do?action=Copy" paramId="userdashboardId" paramName="lineItem" paramProperty="userdashboardId"><bean:message key="prompt.copy"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditUserdashboard.do?action=Delete" paramId="userdashboardId" paramName="lineItem" paramProperty="userdashboardId">
<bean:message key="prompt.delete"/> 
</html:link>                                                 
</td>
											</tr>
                                    	</table>
									</td>
								</tr>
							
							</logic:iterate>
            			</table>
					</td>
				</tr>
    
			</html:form>
      
		</table>

</div>

</td></tr>

<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

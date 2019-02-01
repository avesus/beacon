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
<title><bean:message key="useraccess.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.userid"/>&nbsp;-&nbsp;<bean:write name="ListUseraccessForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
<span class="header2">
	<bean:message key="useraccess.title.list"/>
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
    
			<html:form action="/ListUseraccess">
			<html:hidden property="gotoPage" />
			<html:hidden name="ListUseraccessForm" property="headerInfo1"/>        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditUseraccess.do?'+
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
		  						<td class="column-header1" width="30%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListUseraccess.do?orderBy=Accessid&gotoPage=0'">
										<span><bean:message key="heading.accessid"/></span>                        
										<logic:notEqual name="ListUseraccessForm" property="orderBy" scope="session" value="Accessid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListUseraccessForm" property="orderBy" scope="session" value="Accessid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                    
		  						<td class="column-header2" width="50%">
							         <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListUseraccess.do?orderBy=Grantactionlist&gotoPage=0'">
										<span><bean:message key="heading.grantactions"/></span>          
										<logic:notEqual name="ListUseraccessForm" property="orderBy" scope="session" value="Grantactionlist">              
											<img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListUseraccessForm" property="orderBy" scope="session" value="Grantactionlist">              
											<img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>  
							        </button>                                                             
								</td>                                
                                                                                                  					
		  						<td width="20%"></td>
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListUseraccessForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><bean:write name="lineItem" property="accessid" filter="true"/></td> 
									<td class="<%= _class %>"><bean:write name="lineItem" property="grantactionlist" filter="true"/>										</td> 
                                                                                                                                         					 
									<td class="<%= _class %>">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
		  										<td></td>

                                    			<td align="right">
<html:link action="/EditUseraccess.do?action=Edit" paramId="useraccessId" paramName="lineItem" paramProperty="useraccessId"><bean:message key="prompt.edit"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditUseraccess.do?action=Copy" paramId="useraccessId" paramName="lineItem" paramProperty="useraccessId"><bean:message key="prompt.copy"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditUseraccess.do?action=Delete" paramId="useraccessId" paramName="lineItem" paramProperty="useraccessId">
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

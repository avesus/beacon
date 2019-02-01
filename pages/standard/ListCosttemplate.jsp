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
<title><bean:message key="costtemplate.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.section"/>&nbsp;-&nbsp;<bean:write name="ListCosttemplateForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
<span class="header2"><bean:message key="costtemplate.title.list"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListSection"><span class="header4"><bean:message key="section.title.list"/></span></html:link>        
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
<html:form action="/ListCosttemplate">
<html:hidden property="gotoPage" />
			<html:hidden name="ListCosttemplateForm" property="headerInfo1"/>        
			<html:hidden name="ListCosttemplateForm" property="id"/> 
                    
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditCosttemplate.do?'+
'&amp;sectionkey='+
document.forms[0].headerInfo1.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListSection.do'">
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
		  						<td class="column-header1" width="20%">              
										<span><bean:message key="heading.cost"/></span>                        
								</td>
                    
		  						<td class="column-header2" width="20%">
										<span><bean:message key="heading.type"/></span>                                                                        
								</td>
                    
					  			<td class="column-header2" width="20%">
 	
										<span><bean:message key="heading.tariffvariance"/></span>         
                       	
								</td>                                   
                                                                                                                                  					
		  						<td width="20%"></td>
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListCosttemplateForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><c:out value="${lineItem.costkey}"/></td> 
									<td class="<%= _class %>"><c:out value="${lineItem.costtype}"/>	&nbsp;										</td> 
									<td class="<%= _class %>"><c:if test="${lineItem.tariffvarianceflag=='true'}">                     
YES
</c:if>&nbsp;										</td>
                                                                                                                                                                                                                   					 
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
											<tr>
		  										<td class="<%= _class %>">&nbsp;</td>

                                    			<td class="<%= _class %>" align="right">					
<html:link action="/EditCosttemplate.do?action=Edit" paramId="costtemplateId" paramName="lineItem" paramProperty="costtemplateId">
<bean:message key="prompt.edit"/> 
</html:link>&nbsp;&nbsp;|&nbsp;&nbsp;								
<html:link action="/EditCosttemplate.do?action=Copy" paramId="costtemplateId" paramName="lineItem" paramProperty="costtemplateId">
<bean:message key="prompt.copy"/>
</html:link>&nbsp;&nbsp;|&nbsp;&nbsp;																			
<html:link action="/EditCosttemplate.do?action=Delete" paramId="costtemplateId" paramName="lineItem" paramProperty="costtemplateId">
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

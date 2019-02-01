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


<script language="JavaScript">
<!--	
	function showHideSearch(div1,div2) { 
		var v,obj1,obj2;

		obj1=MM_findObj(div1);
		obj1=obj1.style; 
		v=obj1.visibility;
		if (v=='hidden') {
			obj1.visibility='visible';	
		}
		else {
			obj1.visibility='hidden'; 
		}

		obj2=MM_findObj(div2);
		obj2=obj2.style; 
		v=obj2.visibility;
		if (v=='hidden') {
			obj2.visibility='visible';	
		}
		else {
			obj2.visibility='hidden'; 
		}
	}
-->
</script>



<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="pidtlcost.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="pidtlcost.title.list"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListPihdrdtl"><span class="header4"><bean:message key="pihdr.title.list"/></span></html:link>        
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    
    
<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:50px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    <tr>
      		<td class="label11" width="25%"><bean:message key="prompt.pino"/></td>
		    <td class="label11" width="25%"><bean:message key="prompt.invoicedate"/></td>
		    <td class="label11" width="25%">
<c:if test="${!ListPihdrcostForm.headerInfo7}"> 
            <bean:message key="prompt.jobno"/>&nbsp;/&nbsp;<bean:message key="prompt.orderno"/>
</c:if>&nbsp;            
            </td>                  
		<td align="right" width="25%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
		</td>   
    </tr>
    <tr>
		    <td class="label10"><bean:write name="ListPihdrcostForm" property="headerInfo1" scope="session"/></td>
		    <td class="label10"><bean:write name="ListPihdrcostForm" property="headerInfo3" scope="session"/></td> 
		    <td class="label10">
<c:if test="${!ListPihdrcostForm.headerInfo7}">             
            <bean:write name="ListPihdrcostForm" property="headerInfo8" scope="session"/>&nbsp;/&nbsp;<bean:write name="ListPihdrcostForm" property="headerInfo9" scope="session"/>
</c:if>&nbsp;          
            </td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:230px; z-index:10; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    	<tr>
      		<td class="label11" width="25%"><bean:message key="prompt.pino"/></td>
		    <td class="label11" width="25%"><bean:message key="prompt.invoicedate"/></td>
		    <td class="label11" width="25%">
<c:if test="${!ListPihdrcostForm.headerInfo7}">             
            <bean:message key="prompt.jobno"/>&nbsp;/&nbsp;<bean:message key="prompt.orderno"/>
</c:if>&nbsp;           
            </td>             
			<td align="right" width="25%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Collapse" title="Hide More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
			</td>
 		</tr>        
    	<tr>
		    <td class="label10"><bean:write name="ListPihdrcostForm" property="headerInfo1" scope="session"/></td>
		    <td class="label10"><bean:write name="ListPihdrcostForm" property="headerInfo3" scope="session"/></td> 
		    <td class="label10">
<c:if test="${!ListPihdrcostForm.headerInfo7}">              
            <bean:write name="ListPihdrcostForm" property="headerInfo8" scope="session"/>&nbsp;/&nbsp;<bean:write name="ListPihdrcostForm" property="headerInfo9" scope="session"/>
</c:if>&nbsp;            
            </td>                    
		    <td class="label10"></td>      
		</tr>       
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="4"><bean:message key="prompt.vendor"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="4"><bean:write name="ListPihdrcostForm" property="headerInfo5" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11" colspan="2"><bean:message key="prompt.vendorref"/></td>
		    <td class="label11" colspan="2"><bean:message key="prompt.ccy"/></td>  
 		</tr>       
    	<tr>
		    <td class="label10" colspan="2"><bean:write name="ListPihdrcostForm" property="headerInfo2" scope="session"/></td>
		    <td class="label10" colspan="2"><bean:write name="ListPihdrcostForm" property="headerInfo4" scope="session"/></td>               
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11" colspan="2"><bean:message key="prompt.grossamt"/></td>
		    <td class="label11" colspan="2">&nbsp;</td>  
 		</tr>       
    	<tr>
		    <td class="label10" colspan="2"><bean:write name="ListPihdrcostForm" property="headerInfo6" scope="session"/></td>
		    <td class="label10" colspan="2">&nbsp;</td>              
		</tr>
                     
	</table>
</div>
</td></tr> 
<!-- HEADER INFORMATION ----------------->


<tr><td><img src="images/spacer.gif" height="45"/></td></tr>
        	  	  
<tr><td>
	<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">

          
		<tr><td colspan="2">
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>                
        </td></tr>

    
<html:form action="/ListPihdrcost">
<html:hidden property="gotoPage" />
	<html:hidden name="ListPihdrcostForm" property="headerInfo1"/> <!--pino--> 
	<html:hidden name="ListPihdrcostForm" property="headerInfo10"/> <!--postedflag--> 
	<html:hidden name="ListPihdrcostForm" property="headerInfo11"/> <!--approvedflag-->           
	<html:hidden name="ListPihdrcostForm" property="id"/>            
    	
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	 
                    
<input type="hidden" name="button" id="form-action" />
                    
<c:if test="${ListPihdrcostForm.headerInfo11 == 'DISPUTED'}">                                  
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditPihdrcost.do?'+
'&amp;pidtlId='+
document.forms[0].id.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                        
                                       
				<button class='btn btnFF' type='submit' value='PRINT' onClick="document.getElementById('form-action').value='APPROVE'">
			    	<img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        <span><bean:message key="button.approveinvoice"/></span>
				 </button>                         
</c:if>                           
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListPihdrdtl.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>  
                        
                                                                                         
					</div> 
				</td></tr>
 

        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
		  						<td class="column-header1" width="20%">              
										<span><bean:message key="prompt.costcode"/></span>                        
								</td>
                    
		  						<td class="column-header2" width="10%" align="right">
										<span><bean:message key="prompt.jobcost"/></span>                                
                                </td>

		  						<td class="column-header2" width="10%" align="right">
										<span><bean:message key="prompt.actualcosttotal"/></span>                                
                                </td>
                                                    
					  			<td class="column-header2" width="10%" align="right">
										<span><bean:message key="prompt.actualcost"/></span>        
                       			</td>
                                  
		  						<td class="column-header2" width="30%">              
										<span><bean:message key="prompt.text"/></span>                        
								</td>                                 
                                                                                                                                                                					
		  						<td width="20%" class="column-header3" nowrap>&nbsp;</td>
							</tr>
                
<%int row=0;%>			
	<logic:iterate id="lineItem" name="ListPihdrcostForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>         
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>">
						<bean:write name="lineItem" property="costkey.descr" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" align="right">
						<bean:write name="lineItem" property="cstamttotal" filter="true"/>								
                        			</td> 
									<td class="<%= _class %>" align="right">
						<bean:write name="lineItem" property="cstamtalloctotal" filter="true"/>								
                        			</td>                                     
									<td class="<%= _class %>" align="right">
						<bean:write name="lineItem" property="cstamtalloc" filter="true"/>	
									</td>                                                                                                                                            														<td class="<%= _class %>">
						<bean:write name="lineItem" property="txt1" filter="true"/>&nbsp;	
									</td>
                                     
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td class="<%= _class %>" align="right">

<c:if test="${ListPihdrcostForm.headerInfo11 == 'DISPUTED'}">   
<html:link action="/EditPihdrcost.do?action=Edit" paramId="pidtlcostId" paramName="lineItem" paramProperty="pidtlcostId"><bean:message key="prompt.edit"/></html:link>
<span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>                             
<html:link action="/EditPihdrcost.do?action=Delete" paramId="pidtlcostId" paramName="lineItem" paramProperty="pidtlcostId"><bean:message key="prompt.delete"/></html:link>    
</c:if>
    &nbsp;
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

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

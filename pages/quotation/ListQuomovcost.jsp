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
<title><bean:message key="quomovcost.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="quomovcost.title.list"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListQuomov"><span class="header4"><bean:message key="quomov.title.list"/></span></html:link>
<span class="header2">&gt;</span>
<html:link action="/ListQuohdr"><span class="header4"><bean:message key="quohdr.title.list"/></span></html:link>

  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    
    
<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:50px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.quotno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.quotedate"/></td>           
		<td align="right" width="33%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
		</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo1" scope="session"/></td>
      <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo2" scope="session"/></td>
      <td class="label10"></td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:230px; z-index:10; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    	<tr>
      		<td class="label11" width="33%"><bean:message key="heading.quotno"/></td>
		    <td class="label11" width="33%"><bean:message key="heading.quotedate"/></td> 
			<td align="right" width="33%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Collapse" title="Hide More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
			</td>
 		</tr>        
    	<tr>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo1" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo2" scope="session"/></td>        
		    <td class="label10"></td>      
		</tr>       
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="3"><bean:message key="heading.customer"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="3"><bean:write name="ListQuomovcostForm" property="headerInfo4" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.expirydate"/></td>
		    <td class="label11"><bean:message key="heading.createdby"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo3" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo5" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.loadingport"/></td>
		    <td class="label11"><bean:message key="heading.dischargeport"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo6" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo7" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.quotecurrency"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuomovcostForm" property="headerInfo8" scope="session"/></td>
		    <td class="label10"></td>
		    <td class="label10"></td>                 
		</tr>

                     
	</table>
</div>
</td></tr> 
<!-- HEADER INFORMATION ----------------->


<tr><td><img src="images/spacer.gif" height="45"/></td></tr>
        	  	  
<tr><td>
	<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	

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

    
<html:form action="/ListQuomovcost">
<html:hidden property="gotoPage" />
	<html:hidden name="ListQuomovcostForm" property="headerInfo1"/>        
	<html:hidden name="ListQuomovcostForm" property="id"/>               	
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditQuomovcost.do?'+
'&amp;quomovId='+
document.forms[0].id.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListQuomov.do'">
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
		  						<td class="column-header1" width="35%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuomovcost.do?orderBy=Vendoraddrkey&gotoPage=0'">
										<span><bean:message key="heading.vendoraccount"/></span>                        
										<logic:notEqual name="ListQuomovcostForm" property="orderBy" scope="session" value="Vendoraddrkey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuomovcostForm" property="orderBy" scope="session" value="Vendoraddrkey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                    
		  						<td class="column-header2" width="10%">
							         <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuomovcost.do?orderBy=Costkey&gotoPage=0'">
										<span><bean:message key="heading.cost"/></span>          
										<logic:notEqual name="ListQuomovcostForm" property="orderBy" scope="session" value="Costkey">              
											<img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuomovcostForm" property="orderBy" scope="session" value="Costkey">              
											<img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>  
							        </button>                                                             
								</td>
                    
					  			<td class="column-header2" width="10%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuomovcost.do?orderBy=Costtype&gotoPage=0'">
										<span><bean:message key="heading.type"/></span>        
										<logic:notEqual name="ListQuomovcostForm" property="orderBy" scope="session" value="Costtype">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuomovcostForm" property="orderBy" scope="session" value="Costtype">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                        	
								</td>  

					  			<td class="column-header2" width="10%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuomovcost.do?orderBy=Ccykey&gotoPage=0'">
										<span><bean:message key="heading.localccy"/></span>        
										<logic:notEqual name="ListQuomovcostForm" property="orderBy" scope="session" value="Ccykey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuomovcostForm" property="orderBy" scope="session" value="Ccykey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       

										</logic:equal>   
							        </button>                        	
								</td>                                  

					  			<td class="column-header2" width="10%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuomovcost.do?orderBy=Cstamt&gotoPage=0'">
										<span><bean:message key="heading.amount"/></span>        
										<logic:notEqual name="ListQuomovcostForm" property="orderBy" scope="session" value="Cstamt">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuomovcostForm" property="orderBy" scope="session" value="Cstamt">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                        	
								</td>   
 
 					  			<td class="column-header2" width="10%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuomovcost.do?orderBy=VendtarfhdrId&gotoPage=0'">
										<span><bean:message key="heading.tariffid"/></span>        
										<logic:notEqual name="ListQuomovcostForm" property="orderBy" scope="session" value="VendtarfhdrId">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuomovcostForm" property="orderBy" scope="session" value="VendtarfhdrId">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                        	
								</td>  
                                                                                                                                                                                                 					
		  						<td width="25%"></td>
							</tr>
                
<%int row=0;%>			
	<logic:iterate id="quomovcostLineItem" name="ListQuomovcostForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%String _class2 = "column-cell5";if ((row % 2) == 0) _class2 = "column-cell6";%>
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class2 %>" nowrap>
						<bean:write name="quomovcostLineItem" property="vendoraddrkey.name" filter="true"/>
                                    </td> 
									<td class="<%= _class2 %>" nowrap>
						<bean:write name="quomovcostLineItem" property="costkey.costkey" filter="true"/></td> 
									<td class="<%= _class2 %>" nowrap>
						<bean:write name="quomovcostLineItem" property="costtype" filter="true"/>
                        			</td>									
                                    <td class="<%= _class2 %>" nowrap>
						<bean:write name="quomovcostLineItem" property="ccykey" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class2 %>" align="right" nowrap>
						<bean:write name="quomovcostLineItem" property="cstamt" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class2 %>" nowrap>
						<bean:write name="quomovcostLineItem" property="vendtarfhdrId" filter="true"/>&nbsp;
                        			</td>                                                                                                                                         					 
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
									<td width="10%" class="<%= _class2 %>" align="left">&nbsp;
									</td>					
								<td width="90%" class="<%= _class2 %>" align="right" nowrap>
                                

                      				
	  					<app:linkQuomovcostLineItem page="/EditQuomovcost.do?action=Edit"><bean:message key="prompt.edit"/></app:linkQuomovcostLineItem>
<span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>                        
	  					<app:linkQuomovcostLineItem page="/EditQuomovcost.do?action=Copy"><bean:message key="prompt.copy"/></app:linkQuomovcostLineItem>
<span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>                          
	  					<app:linkQuomovcostLineItem page="/EditQuomovcost.do?action=Delete"><bean:message key="prompt.delete"/></app:linkQuomovcostLineItem>                        
                                                                            
						</td>
							</tr>
						</table>		                                    
									</td>
								</tr>

<!-- row2 -->            
		<tr>
			<td class="<%= _class %>" colspan="7">	
            	<bean:message key="prompt.notes"/>:&nbsp;<c:out value="${quomovcostLineItem.txt}"/>						
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

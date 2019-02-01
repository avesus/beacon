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
<title><bean:message key="ordernote.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="ordernote.title.list"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>        
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    
    
<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:50px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.orderno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.orderdate"/></td>           
		<td align="right" width="33%">
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" onClick="showHideSearch('header','header2');"/>
		</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo1" scope="session"/></td>
      <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo2" scope="session"/></td>
      <td class="label10"></td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:230px; z-index:10; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    	<tr>
      		<td class="label11" width="33%"><bean:message key="heading.orderno"/></td>
		    <td class="label11" width="33%"><bean:message key="heading.orderdate"/></td> 
			<td align="right" width="33%">
<img class="NavigationSprite Collapse" title="Hide More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" onClick="showHideSearch('header','header2');"/>
			</td>
 		</tr>        
    	<tr>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo1" scope="session"/></td>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo2" scope="session"/></td>        
		    <td class="label10"></td>      
		</tr>       
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="3"><bean:message key="heading.customer"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="3"><bean:write name="ListOrdernoteForm" property="headerInfo4" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.customerref"/></td>
		    <td class="label11"><bean:message key="heading.createdby"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo3" scope="session"/></td>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo5" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.loadingport"/></td>
		    <td class="label11"><bean:message key="heading.dischargeport"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo6" scope="session"/></td>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo7" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.ordercurrency"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdernoteForm" property="headerInfo8" scope="session"/></td>
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

    
<html:form action="/ListOrdernote">
<html:hidden property="gotoPage" />
	<html:hidden name="ListOrdernoteForm" property="headerInfo1"/>        
	<html:hidden name="ListOrdernoteForm" property="id"/>            
    	
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="
document.location.href='EditOrdernote.do?'+
'&amp;orderhdrId='+
document.forms[0].id.value+
'&amp;action=Create'
">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>
                           
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOrderhdr.do'">
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
		  						<td class="column-header1" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrdernote.do?orderBy=Createdate&gotoPage=0'">
										<span><bean:message key="heading.date"/></span>                        
										<logic:notEqual name="ListOrdernoteForm" property="orderBy" scope="session" value="Createdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrdernoteForm" property="orderBy" scope="session" value="Createdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                    
		  						<td class="column-header2" width="8%">
							         <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrdernote.do?orderBy=Createtime&gotoPage=0'">
										<span><bean:message key="heading.time"/></span>          
										<logic:notEqual name="ListOrdernoteForm" property="orderBy" scope="session" value="Createtime">              
											<img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrdernoteForm" property="orderBy" scope="session" value="Createtime">              
											<img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>  
							        </button>                                                             
								</td>
                    
					  			<td class="column-header2" width="8%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrdernote.do?orderBy=Createuserid&gotoPage=0'">
										<span><bean:message key="heading.userid"/></span>        
										<logic:notEqual name="ListOrdernoteForm" property="orderBy" scope="session" value="Createuserid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrdernoteForm" property="orderBy" scope="session" value="Createuserid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                        	
								</td>  

					  			<td class="column-header2" width="10%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrdernote.do?orderBy=Category&gotoPage=0'">
										<span><bean:message key="heading.category"/></span>        
										<logic:notEqual name="ListOrdernoteForm" property="orderBy" scope="session" value="Category">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrdernoteForm" property="orderBy" scope="session" value="Category">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                        	
								</td>                                 

					  			<td class="column-header2" width="45%">
 							        <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrdernote.do?orderBy=Note1&gotoPage=0'">
										<span><bean:message key="heading.notes"/></span>        
										<logic:notEqual name="ListOrdernoteForm" property="orderBy" scope="session" value="Note1">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrdernoteForm" property="orderBy" scope="session" value="Note1">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>   
							        </button>                        	
								</td> 
                                                                                                                                                                                                 					
		  						<td width="29%"></td>
							</tr>
                
<%int row=0;%>			
	<logic:iterate id="ordernoteLineItem" name="ListOrdernoteForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	

<%
com.bureaueye.beacon.model.order.Ordernote ordernote = 
	(com.bureaueye.beacon.model.order.Ordernote)ordernoteLineItem;
if (ordernote.getPriority().equals("1")) _class = _class+"Red";
if (ordernote.getPriority().equals("2")) _class = _class+"Blue";
if (ordernote.getPriority().equals("3")) _class = _class+"Green";
%>
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="ordernoteLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="ordernoteLineItem" property="createtime" filter="true"/>								
                        </td> 
 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="ordernoteLineItem" property="createuserid" filter="true"/>	
                        			</td>									
					<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="ordernoteLineItem" property="category" filter="true"/>&nbsp;					
					</td>  																									
					<td class="<%= _class %>" valign="top">
						<bean:write name="ordernoteLineItem" property="note1" filter="true"/>&nbsp;					
					</td> 	                                 
                                                                                                                                         					 
									<td class="<%= _class %>" nowrap valign="bottom">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>				
								<td align="right">
					
	  					<orderapp:linkOrdernoteLineItem page="/EditOrdernote.do?action=Edit"><bean:message key="prompt.edit"/></orderapp:linkOrdernoteLineItem><span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
	  					<orderapp:linkOrdernoteLineItem page="/EditOrdernote.do?action=Copy"><bean:message key="prompt.copy"/></orderapp:linkOrdernoteLineItem><span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
	  					<orderapp:linkOrdernoteLineItem page="/EditOrdernote.do?action=Delete"><bean:message key="prompt.delete"/></orderapp:linkOrdernoteLineItem>	
                        					
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

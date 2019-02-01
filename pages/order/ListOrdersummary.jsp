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
		
		//process content display
        var displayOrderchargesContent = MM_findObj('displayContent1').value;	
        var displayJobcostsContent = MM_findObj('displayContent2').value;	
        var displayJobmovcostsContent = MM_findObj('displayContent3').value;
		var displayAccountsreceivableContent = MM_findObj('displayContent4').value;
		var displayAccountspayableContent = MM_findObj('displayContent5').value;
		
				
		if(displayOrderchargesContent == "display") {
			showHide('orderchargesContent','orderchargesHeader','Order Charges','displayContent1');
		}
		if(displayJobcostsContent == "display") {
			showHide('jobcostsContent','jobcostsHeader','Job Costs','displayContent2');
		}
		if(displayJobmovcostsContent == "display") {		
			showHide('jobmovcostsContent','jobmovcostsHeader','Job Movements Costs','displayContent3');
		}


		<!--sWSI-201302-0002-->
		if(displayAccountsreceivableContent == "display") {		
			showHide('accountsreceivableContent','accountsreceivableHeader','Accounts Receivable','displayContent4');
		}
		if(displayAccountspayableContent == "display") {		
			showHide('accountspayableContent','accountspayableHeader','Accounts Payable','displayContent5');
		}
		<!--eWSI-201302-0002-->
		
		
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
<title><bean:message key="title.financialsummary"/></title>


</head>


<jsp:useBean
  id="ListOrdersummaryForm"
  class="com.bureaueye.beacon.form.order.ListOrdersummaryForm"
  scope="session"
/>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="title.financialsummary"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>        
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->


    
<!-- HEADER INFORMATION ----------------->	
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:50px; z-index:100; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.orderno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.orderdate"/></td>           
		<td align="right" width="33%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
		</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[2]" scope="session"/></td>
      <td class="label10"></td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:280px; z-index:90; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    	<tr>
      		<td class="label11" width="33%"><bean:message key="heading.orderno"/></td>
		    <td class="label11" width="33%"><bean:message key="heading.orderdate"/></td> 
			<td align="right" width="33%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Collapse" title="Hide More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
			</td>
 		</tr>        
    	<tr>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[1]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[2]" scope="session"/></td>        
		    <td class="label10"></td>      
		</tr>       
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="3"><bean:message key="heading.customer"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="3"><bean:write name="ListOrdersummaryForm" property="headerInfo[4]" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.ordercurrency"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[8]" scope="session"/></td>
		    <td class="label10"></td>
		    <td class="label10"></td>                 
		</tr>        
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.customerref"/></td>
		    <td class="label11"><bean:message key="heading.createdby"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[3]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[5]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.fromlocation"/></td>
		    <td class="label11"><bean:message key="heading.tolocation"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[6]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[7]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.product"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListOrdersummaryForm" property="headerInfo[10]" scope="session"/></td>
		    <td class="label10"></td>
		    <td class="label10"></td>                 
		</tr>
                     
	</table>
</div>
</td></tr>
<!-- HEADER INFORMATION ----------------->



<tr><td><img src="images/spacer.gif" height="45"/></td></tr>
        	  	  
<tr><td>


<div style="OVERFLOW:auto; width:1300px; height:650px; position:relative;">	
                
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
   
<html:form action="/SaveOrdersummary">
<html:hidden property="gotoPage" />
	<html:hidden name="ListOrdersummaryForm" property="headerInfo[1]"/> 
    <html:hidden name="ListOrdersummaryForm" property="displayContent1"/> 
    <html:hidden name="ListOrdersummaryForm" property="displayContent2"/> 
    <html:hidden name="ListOrdersummaryForm" property="displayContent3"/>  
    <html:hidden name="ListOrdersummaryForm" property="displayContent4"/>  
    <html:hidden name="ListOrdersummaryForm" property="displayContent5"/>                        
	<html:hidden name="ListOrdersummaryForm" property="id"/>    	

	<input type="hidden" name="btnSubmit" id="form-action" />
		
    
<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
<tr><td colspan="2">
					<div class="btnPane3">	                                        
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOrderhdr.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>                                                  
					</div> 
</td></tr>






<script language="JavaScript">
<!--	
function showHide(showHideDiv, switchImgTag, title, displayParam) {
        var ele = document.getElementById(showHideDiv);
        var imageEle = document.getElementById(switchImgTag);
        var param = MM_findObj(displayParam);
        if(ele.style.display == "block") {
            ele.style.display = "none";
			imageEle.innerHTML = '<img class="NavigationSprite Expand" title="Show '+title+'" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>';
			param.value="";
        }
        else {
            ele.style.display = "block";
			imageEle.innerHTML = '<img class="NavigationSprite Collapse" title="Hide '+title+'" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>';
			param.value="display";
        }
}
-->
</script>



<tr><td colspan="2">


<!--ORDER CHARGES-->
<div id="orderchargesHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.ordercharges"/></span></td>
                    		<td align="right">
                            <a id="orderchargesHeader" href="javascript:showHide('orderchargesContent','orderchargesHeader','Order Charges','displayContent1');" title="Show Order Charges">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="orderchargesContentDiv">
     <div id="orderchargesContent" style="display: none;"> 
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                          
                
<tr><td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht">
	<div class="btnPane3">                 
        		<button class="btn btnFF" type="submit" value="Invoice" onClick="document.getElementById('form-action').value='Invoice'">
			<img class=" IM2 Post-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
	        <span><bean:message key="button.invoice"/></span>
				 </button>          
	</div>      	                         
				</td>
              
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
<td class="column-header1" width="3%">&nbsp;</td>                            
		  						<td class="column-header2" width="27%">              
<bean:message key="heading.billingaccount"/>                       
								</td>
                    
		  						<td class="column-header2" width="10%">
<bean:message key="heading.charge"/>                         
								</td>
 
 		  						<td class="column-header2" width="10%">
<bean:message key="heading.chargecurrency"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="10%">
<bean:message key="heading.invoicestatus"/>                 	
								</td>  

					  			<td class="column-header2" width="10%">
<bean:message key="heading.tariffid"/>    	
								</td>                                  

					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.amount"/>      	
								</td>   
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baserate"/>      	
								</td>
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baseamount"/>      	
								</td>   
                                 
                                                                                                   
							</tr>
                
<%int row=0;%>			
	<logic:iterate id="chargeLineItem" name="ListOrdersummaryForm" property="list">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
				<c:if test="${chargeLineItem.invoicestatus == '' or chargeLineItem.invoicestatus == 'READY'}">

<c:if test="${chargeLineItem.invoicestatus == 'READY'}">									
<input type='checkbox' name='selectedObjects' value='<c:out value="${chargeLineItem.orderchargeId}"/>' checked>
</c:if>
<c:if test="${chargeLineItem.invoicestatus == ''}">									
<input type='checkbox' name='selectedObjects' value='<c:out value="${chargeLineItem.orderchargeId}"/>'>
</c:if>

<html:hidden name="chargeLineItem" property="invoicestatus" />
													
				</c:if>&nbsp;	
                                    </td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="chargeLineItem" property="customeraddrkey.name" filter="true"/>
                        			</td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="chargeLineItem" property="chargekey.chargekey" filter="true"/>
                        			</td>	
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="chargeLineItem" property="ccykey" filter="true"/>
                        			</td>									
                                    <td class="<%= _class %>" nowrap>
                      <c:if test="${chargeLineItem.invoicestatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${chargeLineItem.invoicestatus == 'PRINTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>	
                      <c:if test="${chargeLineItem.invoicestatus == 'CREATED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>		
                      <c:if test="${chargeLineItem.invoicestatus == ''}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${chargeLineItem.invoicestatus}"/>'/>
                      </c:if>						  			
						<c:out value="${chargeLineItem.invoicestatus}"/>	
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="chargeLineItem" property="custtarfhdrId" filter="true"/>&nbsp;
                        			</td>                                    
                                    <td class="<%= _class %>" align="right" nowrap>
						<bean:write name="chargeLineItem" property="chgamt" filter="true"/>
                        			</td>                                     
                                    <td class="<%= _class %>" align="right" nowrap>
					<fmt:formatNumber 
							type="number"
							value="${chargeLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right">
						<fmt:formatNumber 
							type="number"
							value="${chargeLineItem.chgamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>				
                                                                                                                                                                                                               					
								</tr>
                    
	</logic:iterate>
                    
            			</table>
					</td>
				</tr>
                                
		</table>         
     </div>
</div> 
<div id="orderchargesTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalbaseamount"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[0]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;	
                                				
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>                           
<!--ORDER CHARGES-->



<!--JOB COSTS-->
<div id="jobcostsHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.jobcosts"/></span></td>
                    		<td align="right">
                            <a id="jobcostsHeader" href="javascript:showHide('jobcostsContent','jobcostsHeader','Job Costs','displayContent2');" title="Show Job Costs">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="jobcostsContentDiv">
     <div id="jobcostsContent" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%"> 

<tr><td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht">
	<div class="btnPane3">                 
        		<button class="btn btnFF" type="submit" value="Post1" onClick="document.getElementById('form-action').value='Post1'">
			<img class=" IM2 Post-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
	        <span><bean:message key="button.post"/></span>
				 </button>          
	</div>                                               
				</td>
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
<td class="column-header1" width="3%">&nbsp;</td>                            
		  						<td class="column-header2" width="10%">              
<bean:message key="heading.unit"/>                       
								</td>
                    
		  						<td class="column-header2" width="21%">
<bean:message key="heading.vendoraccount"/>                         
								</td>
 
 		  						<td class="column-header2" width="8%">
<bean:message key="heading.cost"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="8%">
<bean:message key="heading.costcurrency"/>                 	
								</td>  

					  			<td class="column-header2" width="10%">
<bean:message key="heading.status"/>    	
								</td>                                  

					  			<td class="column-header2" width="10%">
<bean:message key="heading.tariffid"/>      	
								</td>   
                                
					  			<td class="column-header2" width="10%">
<bean:message key="heading.amount"/>      	
								</td>
                                
					  			<td class="column-header2" width="10%">
<bean:message key="heading.baserate"/>      	
								</td>   
                                 
					  			<td class="column-header2" width="10%">
<bean:message key="heading.baseamount"/>      	
								</td>
                                                                                                                                   
							</tr>
                
<%row=0;%>			
	<logic:iterate id="jobcostLineItem" name="ListOrdersummaryForm" property="lineItems[1]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
				<c:if test="${jobcostLineItem.poststatus == '' or jobcostLineItem.poststatus == 'READY'}">
<c:if test="${jobcostLineItem.poststatus == 'READY'}">									
<input type='checkbox' name='selectedObjects2' value='<c:out value="${jobcostLineItem.jobcostId}"/>' checked>
</c:if>
<c:if test="${jobcostLineItem.poststatus == ''}">									
<input type='checkbox' name='selectedObjects2' value='<c:out value="${jobcostLineItem.jobcostId}"/>'>
</c:if>

<html:hidden name="jobcostLineItem" property="poststatus" />
													
				</c:if>&nbsp;	
                                    </td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="jobcostLineItem" property="unitkey" filter="true"/>
                        			</td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="jobcostLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>	
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="jobcostLineItem" property="costkey.costkey" filter="true"/>
                        			</td>									
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="jobcostLineItem" property="ccykey" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap>
                      <c:if test="${jobcostLineItem.poststatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>
                      <c:if test="${jobcostLineItem.poststatus == 'POSTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>		
                      <c:if test="${jobcostLineItem.poststatus == ''}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobcostLineItem.poststatus}"/>'/>
                      </c:if>						  			
						<c:out value="${jobcostLineItem.poststatus}"/>	
                        			</td>
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="jobcostLineItem" property="vendtarfhdrId" filter="true"/>&nbsp;
                        			</td>                                                                          
                                    <td class="<%= _class %>" align="right" nowrap>
						<bean:write name="jobcostLineItem" property="cstamt" filter="true"/>
                        			</td>                                     
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${jobcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right">
						<fmt:formatNumber 
							type="number"
							value="${jobcostLineItem.cstamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>			
                                                                           					
								</tr>
                                    
	</logic:iterate>

            			</table>
					</td>
				</tr>
                                
		</table>                 
	</div>
</div>
<div id="jobcostsTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalbaseamount"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[1]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;
                                                                                               					
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>   
<!--JOB COSTS-->              
    

<!--JOB MOVEMENT COSTS-->
<div id="jobmovcostsHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.jobmovementcosts"/></span></td>
                    		<td align="right">
                            <a id="jobmovcostsHeader" href="javascript:showHide('jobmovcostsContent','jobmovcostsHeader','Job Movement Costs','displayContent3');" title="Show Job Movement Costs">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="jobmovcostsContentDiv">
     <div id="jobmovcostsContent" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%"> 

<tr><td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht">
	<div class="btnPane3">                 
        		<button class="btn btnFF" type="submit" value="Post2" onClick="document.getElementById('form-action').value='Post2'">
			<img class=" IM2 Post-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
	        <span><bean:message key="button.post"/></span>
				 </button>          
	</div>             	                             
				</td>
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
<td class="column-header1" width="3%">&nbsp;</td>                            
		  						<td class="column-header2" width="10%">              
<bean:message key="heading.unit"/>                       
								</td>
                    
		  						<td class="column-header2" width="21%">
<bean:message key="heading.vendoraccount"/>                         
								</td>
 
 		  						<td class="column-header2" width="8%">
<bean:message key="heading.cost"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="8%">
<bean:message key="heading.costcurrency"/>                 	
								</td>  

					  			<td class="column-header2" width="10%">
<bean:message key="heading.status"/>    	
								</td>                                  

					  			<td class="column-header2" width="10%">
<bean:message key="heading.tariffid"/>      	
								</td>   
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.amount"/>      	
								</td>
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baserate"/>      	
								</td>   
                                 
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baseamount"/>      	
								</td>
                                                                                                                                   
							</tr>
                
<%row=0;%>			
	<logic:iterate id="jobmovcostLineItem" name="ListOrdersummaryForm" property="lineItems[2]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
				<c:if test="${jobmovcostLineItem.poststatus == '' or jobmovcostLineItem.poststatus == 'READY'}">
<c:if test="${jobmovcostLineItem.poststatus == 'READY'}">									
<input type='checkbox' name='selectedObjects3' value='<c:out value="${jobmovcostLineItem.jobcostId}"/>' checked>
</c:if>
<c:if test="${jobmovcostLineItem.poststatus == ''}">									
<input type='checkbox' name='selectedObjects3' value='<c:out value="${jobmovcostLineItem.jobcostId}"/>'>
</c:if>

<html:hidden name="jobmovcostLineItem" property="poststatus" />
													
				</c:if>&nbsp;	
                                    </td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="jobmovcostLineItem" property="unitkey" filter="true"/>
                        			</td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="jobmovcostLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>	
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="jobmovcostLineItem" property="costkey.costkey" filter="true"/>
                        			</td>									
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="jobmovcostLineItem" property="ccykey" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap>
                      <c:if test="${jobmovcostLineItem.poststatus == 'READY'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobmovcostLineItem.poststatus}"/>'/>
                      </c:if>
                      <c:if test="${jobmovcostLineItem.poststatus == 'POSTED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${jobmovcostLineItem.poststatus}"/>'/>
                      </c:if>		
                      <c:if test="${jobmovcostLineItem.poststatus == ''}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${jobmovcostLineItem.poststatus}"/>'/>
                      </c:if>						  			
						<c:out value="${jobmovcostLineItem.poststatus}"/>	
                        			</td>
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="jobmovcostLineItem" property="vendtarfhdrId" filter="true"/>&nbsp;
                        			</td>                                                                          
                                    <td class="<%= _class %>" align="right" nowrap>
						<bean:write name="jobmovcostLineItem" property="cstamt" filter="true"/>
                        			</td>                                     
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${jobmovcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right">
						<fmt:formatNumber 
							type="number"
							value="${jobmovcostLineItem.cstamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>				
                                    
							</tr>
                    
	</logic:iterate>

            			</table>
					</td>
				</tr>
                                
		</table>                      
	</div>
</div>
<div id="jobmovcostsTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalbaseamount"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[2]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;   
                                                                                             				
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<!--JOB MOVEMENT COSTS-->


<!--PROFIT-->
<div id="profitHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.profit"/></span></td>
                    		<td align="right">
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="profitTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell7">&nbsp;</td>
                    		<td align="right" class="column-cell7">
  
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[4]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>%	&nbsp;
                                                                                         
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[3]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;
                                                                				
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<!--PROFIT-->

   
</td></tr>  



<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>

<tr><td colspan="2">


<!--sWSI-201302-0002=============================================================>-->
<!--ACCOUNTS RECEIVABLE-->
<div id="accountsreceivableHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13">Accounts Receivable</span></td>
                    		<td align="right">
                            <a id="accountsreceivableHeader" href="javascript:showHide('accountsreceivableContent','accountsreceivableHeader','Accounts Receivable','displayContent4');" title="Show Accounts Receivable">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="accountsreceivableContentDiv">
     <div id="accountsreceivableContent" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%"> 

<tr><td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right"></td>
				<td class="tdwht">          	                             
				</td>
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>                         
		  						<td class="column-header1" width="7%">              
<bean:message key="heading.invoiceno"/>                       
								</td>
                    
		  						<td class="column-header2" width="23%">
<bean:message key="heading.customer"/>                         
								</td>
 
 		  						<td class="column-header2" width="33%">
<bean:message key="heading.text"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="7%">
<bean:message key="heading.invoiceccy"/>                 	
								</td>                                  
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.amount"/>      	
								</td>

					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baserate"/>                 	
								</td>                                  
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baseamount"/>      	
								</td>
                                                                                                                                                                                  							</tr>
                
<%row=0;%>			
	<logic:iterate id="accountsreceivableLineItem" name="ListOrdersummaryForm" property="lineItems[4]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" nowrap>
						<bean:write name="accountsreceivableLineItem" property="invoiceno" filter="true"/>
                        			</td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="accountsreceivableLineItem" property="customeraddrkey.name" filter="true"/>
                        			</td>										
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="accountsreceivableLineItem" property="txt1" filter="true"/>                                    
                        			</td>
                                    <td class="<%= _class %>">
						<bean:write name="accountsreceivableLineItem" property="invoiceccykey" filter="true"/>   
                        			</td>
                                    
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${accountsreceivableLineItem.invoiceamt}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>				
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${accountsreceivableLineItem.baseexrate}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${accountsreceivableLineItem.invoiceamtbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>
                                    
							</tr>
                    
	</logic:iterate>

            			</table>
					</td>
				</tr>
                                
		</table>                      
	</div>
</div>
<div id="accountsreceivableLineItemTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalaccountsreceivable"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[6]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;
				
                            </td>                              
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<!--ACCOUNTS RECEIVABLE-->


<!--ACCOUNTS PAYABLE-->
<div id="accountspayableHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13">Accounts Payable</span></td>
                    		<td align="right">
                            <a id="accountspayableHeader" href="javascript:showHide('accountspayableContent','accountspayableHeader','Accounts Payable','displayContent5');" title="Show Accounts Payable">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="accountspayableContentDiv">
     <div id="accountspayableContent" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%"> 

<tr><td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right"></td>
				<td class="tdwht">          	                             
				</td>
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>                         
		  						<td class="column-header1" width="8%">              
<bean:message key="heading.pino"/>                       
								</td>

		  						<td class="column-header2" width="7%">              
<bean:message key="heading.jobno"/>                       
								</td>
                                                    
		  						<td class="column-header2" width="20%">
<bean:message key="heading.vendor"/>                         
								</td>
 
		  						<td class="column-header2" width="10%">
<bean:message key="heading.vendorref"/>                         
								</td>
                                 
 		  						<td class="column-header2" width="20%">
<bean:message key="heading.text"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="5%">
<bean:message key="heading.ccy"/>                 	
								</td>                                  
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.amount"/>      	
								</td>
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baserate"/>                 	
								</td>                                  
                                
					  			<td class="column-header2" width="10%" align="right">
<bean:message key="heading.baseamount"/>      	
								</td>                                
                                                                                                                                                  							</tr>
                
<%row=0;%>			
	<logic:iterate id="accountspayableLineItem" name="ListOrdersummaryForm" property="lineItems[3]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" nowrap>
						<bean:write name="accountspayableLineItem" property="pino" filter="true"/>
                        			</td> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="accountspayableLineItem" property="jobno" filter="true"/>
                        			</td>                                     
									<td class="<%= _class %>" nowrap>
						<bean:write name="accountspayableLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>		
									<td class="<%= _class %>" nowrap>
						<bean:write name="accountspayableLineItem" property="vendorref" filter="true"/>
                        			</td>		                                    								
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="accountspayableLineItem" property="txt1" filter="true"/>                                    
                        			</td>
                                    <td class="<%= _class %>">
						<bean:write name="accountspayableLineItem" property="ccykey" filter="true"/>   
                        			</td>
                                    
                                    <td class="<%= _class %>" align="right">
						<fmt:formatNumber 
							type="number"
							value="${accountspayableLineItem.cstamtalloc}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>				
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${accountspayableLineItem.baseexrate}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${accountspayableLineItem.cstamtallocbase}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>		
                        			</td>
                                                    			                           					
								</tr>
                    
	</logic:iterate>

            			</table>
					</td>
				</tr>
                                
		</table>                      
	</div>
</div>
<div id="accountspayableLineItemTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalaccountspayable"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[5]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;	
                                				
                            </td>                              
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<!--ACCOUNTS PAYABLE-->


<!--ACCOUNTS BALANCE-->
<div id="accountsbalanceHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.accountsbalance"/></span></td>
                    		<td align="right">
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="accountsbalanceTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell7">&nbsp;</td>
                    		<td align="right" class="column-cell7">                           
                                
							<fmt:formatNumber 
								type="number"
								value="${ListOrdersummaryForm.totals[7]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;
                                                                         				
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<!--ACCOUNTS BALANCE-->
<!--sWSI-201302-0002=============================================================<-->

   
</td></tr> 


      
    
			</html:form>
      
		</table>

</div>

</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>





</body>
</html:html>



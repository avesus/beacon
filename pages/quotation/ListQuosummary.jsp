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
        var displayChargesContent = MM_findObj('displayContent1').value;	
        var displayCostsContent = MM_findObj('displayContent2').value;	
        var displayMovcostsContent = MM_findObj('displayContent3').value;	
		if(displayChargesContent == "display") {
			showHide('chargesContent','chargesHeader','Charges','displayContent1');
		}
		if(displayCostsContent == "display") {
			showHide('costsContent','costsHeader','Costs','displayContent2');
		}
		if(displayMovcostsContent == "display") {		
			showHide('movcostsContent','movcostsHeader','Movement Costs','displayContent3');
		}
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
<title><bean:message key="title.profitanalysis"/></title>


</head>


<jsp:useBean
  id="ListQuosummaryForm"
  class="com.bureaueye.beacon.form.quotation.ListQuosummaryForm"
  scope="session"
/>



<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="title.profitanalysis"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListQuohdr"><span class="header4"><bean:message key="quohdr.title.list"/></span></html:link>        
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->


    
<!-- HEADER INFORMATION ----------------->	
    <tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:50px; z-index:100; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
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
      <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[2]" scope="session"/></td>
      <td class="label10"></td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:280px; z-index:90; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
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
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[1]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[2]" scope="session"/></td>        
		    <td class="label10"></td>      
		</tr>       
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="3"><bean:message key="heading.customer"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="3"><bean:write name="ListQuosummaryForm" property="headerInfo[4]" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.quotecurrency"/></td>
		    <td class="label11"><bean:message key="heading.shipmethod"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[8]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[12]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>        
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.customerref"/></td>
		    <td class="label11"><bean:message key="heading.createdby"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[3]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[5]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.fromlocation"/></td>
		    <td class="label11"><bean:message key="heading.tolocation"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[6]" scope="session"/></td>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[7]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.product"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="ListQuosummaryForm" property="headerInfo[10]" scope="session"/></td>
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
   
<html:form action="/ListQuosummary">
<html:hidden property="gotoPage" />
	<html:hidden name="ListQuosummaryForm" property="headerInfo[1]"/> 
    <html:hidden name="ListQuosummaryForm" property="displayContent1"/> 
    <html:hidden name="ListQuosummaryForm" property="displayContent2"/> 
    <html:hidden name="ListQuosummaryForm" property="displayContent3"/>                
	<html:hidden name="ListQuosummaryForm" property="id"/>    	
		
    
<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
<tr><td colspan="2">
					<div class="btnPane3">	                                        
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListQuohdr.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>                                                  
					</div> 
</td></tr>


<tr><td colspan="2">





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









<!--CHARGES-->
<div id="chargesHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.charges"/></span></td>
                    		<td align="right">
                            <a id="chargesHeader" href="javascript:showHide('chargesContent','chargesHeader','Charges','displayContent1');" title="Show Charges">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="chargesContentDiv">
     <div id="chargesContent" style="display: none;"> 
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                          
                
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>                         
		  						<td class="column-header1" width="27%">              
<bean:message key="heading.billingaccount"/>                       
								</td>
                    
		  						<td class="column-header2" width="10%">
<bean:message key="heading.charge"/>                         
								</td>
 
 		  						<td class="column-header2" width="10%">
<bean:message key="heading.chargecurrency"/>                                                         
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
                
<%int row=0;%>			
	<logic:iterate id="chargeLineItem" name="ListQuosummaryForm" property="lineItems[0]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
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
<div id="chargesTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalbaseamount"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListQuosummaryForm.totals[0]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;
                                					
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>                           
<!--CHARGES-->



<!--COSTS-->
<div id="costsHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.quotationcosts"/></span></td>
                    		<td align="right">
                            <a id="costsHeader" href="javascript:showHide('costsContent','costsHeader','Job Costs','displayContent2');" title="Show Quotation Costs">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="costsContentDiv">
     <div id="costsContent" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%"> 

    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>                        
                    
		  						<td class="column-header1" width="21%">
<bean:message key="heading.vendoraccount"/>                         
								</td>
 
 		  						<td class="column-header2" width="8%">
<bean:message key="heading.cost"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="8%">
<bean:message key="heading.costcurrency"/>                 	
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
	<logic:iterate id="costLineItem" name="ListQuosummaryForm" property="lineItems[1]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr> 
									<td class="<%= _class %>" nowrap>
						<bean:write name="costLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>	
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="costLineItem" property="costkey.costkey" filter="true"/>
                        			</td>									
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="costLineItem" property="ccykey" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="costLineItem" property="vendtarfhdrId" filter="true"/>&nbsp;
                        			</td>                                                                          
                                    <td class="<%= _class %>" align="right" nowrap>
						<bean:write name="costLineItem" property="cstamt" filter="true"/>
                        			</td>                                     
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${costLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right">
						<fmt:formatNumber 
							type="number"
							value="${costLineItem.cstamtbase}"
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
<div id="costsTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalbaseamount"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListQuosummaryForm.totals[1]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;
                                				
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>   
<!--COSTS-->              
    




<!--MOVEMENT COSTS-->
<div id="movcostsHeaderDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">              
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>                  
 				<tr><td colspan="2" style="background:#F1F1F1; border: solid #CECFD6 1px; line-height: 100%; padding:5px 5px 5px 5px; ">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td><span class="label13"><bean:message key="title.movementcosts"/></span></td>
                    		<td align="right">
                            <a id="movcostsHeader" href="javascript:showHide('movcostsContent','movcostsHeader','Movement Costs','displayContent3');" title="Show Movement Costs">
                            <img class="NavigationSprite Expand" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
                            </a>
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<div style="clear:both;"></div>
<div id="movcostsContentDiv">
     <div id="movcostsContent" style="display: none;">
	<table border="0" cellpadding="0" cellspacing="0" width="100%"> 

    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>
                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>                                              
		  						<td class="column-header1" width="21%">
<bean:message key="heading.vendoraccount"/>                         
								</td>
 
 		  						<td class="column-header2" width="8%">
<bean:message key="heading.cost"/>                                                         
								</td>
                                                   
					  			<td class="column-header2" width="8%">
<bean:message key="heading.costcurrency"/>                 	
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
	<logic:iterate id="movcostLineItem" name="ListQuosummaryForm" property="lineItems[2]">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" nowrap>
						<bean:write name="movcostLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>	
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="movcostLineItem" property="costkey.costkey" filter="true"/>
                        			</td>									
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="movcostLineItem" property="ccykey" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap>
						<bean:write name="movcostLineItem" property="vendtarfhdrId" filter="true"/>&nbsp;
                        			</td>                                                                          
                                    <td class="<%= _class %>" align="right" nowrap>
						<bean:write name="movcostLineItem" property="cstamt" filter="true"/>
                        			</td>                                     
                                    <td class="<%= _class %>" align="right" nowrap>
						<fmt:formatNumber 
							type="number"
							value="${movcostLineItem.xratebase}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>	
                        			</td>
                                    <td class="<%= _class %>" align="right">
						<fmt:formatNumber 
							type="number"
							value="${movcostLineItem.cstamtbase}"
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
<div id="movcostsTotalDiv">
	<table border="0" cellpadding="0" cellspacing="0" width="100%">                             
 				<tr><td colspan="2">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
				    	<tr>                
        	    		    <td class="column-cell8"><bean:message key="prompt.totalbaseamount"/></td>
                    		<td align="right" class="column-cell8">
                            
							<fmt:formatNumber 
								type="number"
								value="${ListQuosummaryForm.totals[2]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>&nbsp;	
                                				
                            </td> 
                   		</tr>                    
                	</table>
                </td></tr>                
	</table> 
</div>
<!--MOVEMENT COSTS-->



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
								value="${ListQuosummaryForm.totals[4]}"
								maxFractionDigits="2"
								minFractionDigits="2"
								/>%	&nbsp;
                                                                                         
							<fmt:formatNumber 
								type="number"
								value="${ListQuosummaryForm.totals[3]}"
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
    

</html:form>
      
		</table>

</div>

</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>





</body>
</html:html>



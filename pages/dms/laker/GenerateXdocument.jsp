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



<script language="JavaScript">
var searchWin;

function refreshData(){
	var url     = 'EditMail.do';
	window.location.href = url;
}



function addresscontactSearch(field){
	var url     = 'ListAddresscontactSearch.do?'+
					'action=REFRESH'+
					'&maxResults=999'+
					'&headerInfo1='+
					'&headerInfo2='+				
					'&headerInfo3='+
					field
					;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=700');
	searchWin.focus();
}
</script>








<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="generatedocument.title"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="generatedocument.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListOrderhdrLaker"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>  
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    
    
<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:80px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">

    <tr>
		<td class="label11" width="66%" colspan="2"><bean:message key="prompt.documentdescription"/></td>
        <td align="right" width="33%">
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" onClick="showHideSearch('header','header2');"/>
		</td> 
    </tr>
  <tr>
    <td class="label10" colspan="3"><bean:write name="GenerateXdocumentForm" property="headerInfo[9]" scope="session"/></td>            
    </tr>    
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.orderno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.orderdate"/></td>           
		<td class="label11" width="33%">&nbsp;</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[2]" scope="session"/></td>
      <td class="label10">&nbsp;</td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:260px; z-index:10; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">

    <tr>
		<td class="label11" width="66%" colspan="2"><bean:message key="prompt.documentdescription"/></td>
        <td align="right" width="33%">
<img class="NavigationSprite Collapse" title="Hide More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" onClick="showHideSearch('header','header2');"/>
		</td> 
    </tr>
  <tr>
    <td class="label10" colspan="3"><bean:write name="GenerateXdocumentForm" property="headerInfo[9]" scope="session"/></td>            
    </tr>     
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.orderno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.orderdate"/></td>           
		<td class="label11" width="33%">&nbsp;</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[2]" scope="session"/></td>
      <td class="label10">&nbsp;</td>              
    </tr>
              
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="3"><bean:message key="heading.customer"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="3"><bean:write name="GenerateXdocumentForm" property="headerInfo[4]" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.customerref"/></td>
		    <td class="label11"><bean:message key="heading.createdby"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[3]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[5]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.portlocation"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[6]" scope="session"/></td>
		    <td class="label10"></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.ordercurrency"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="GenerateXdocumentForm" property="headerInfo[8]" scope="session"/></td>
		    <td class="label10"></td>
		    <td class="label10"></td>                 
		</tr>
                     
	</table>
</div>
</td></tr> 
<!-- HEADER INFORMATION ----------------->


<tr><td><img src="images/spacer.gif" height="75"/></td></tr>
        	  	  
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

    
<html:form action="/GenerateXdocument2Laker">
	
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	

<input type="hidden" name="btnSubmit" id="form-action" />

                                                               
               <button class="btn btnFF" type="submit" value="PRINT" onClick="document.getElementById('form-action').value='PRINT'">             
			    	<img class=" IM CK-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        <span><bean:message key="button.print"/></span>
				 </button>
                 
                <button class="btn btnFF" type="submit" value="EMAIL" onClick="document.getElementById('form-action').value='EMAIL'">                 
        			<img class=" IM Z-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        <span><bean:message key="button.email"/></span>
				</button>
                           
				<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOrderhdrLaker.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			    </button>
   

                                                                  
					</div> 
				</td></tr>
 


				<tr><td>
				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
  
  
  
<!-- PRINT HEADER DETAILS ----------------->     
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.headerdetails"/></td></tr>

<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2" colspan="2"><bean:message key="prompt.to"/>:</td></tr>
              						<tr><td class="label2" colspan="2">                                 
        <html:text property="headerto" size="40"  styleClass="forminput1"/>	
                                     </td></tr>
    
    
             						<tr><td class="label2" colspan="2"><bean:message key="prompt.toattn"/>:</td></tr>
              						<tr><td class="label2" colspan="2">	
        <html:text property="headertoattn" size="40"  styleClass="forminput1"/>                                    
        							</td></tr>  
                                                                                 
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.cc"/>:</td></tr>
              						<tr><td class="label2" valign="top">
        <html:text property="headercc" size="40"  styleClass="forminput1"/>  
                                    </td>
                                    </tr>
                                    
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.ccattn"/>:</td></tr>
              						<tr><td class="label2" valign="top">
         <html:text property="headerccattn" size="40"  styleClass="forminput1"/>           
                                    </td>
                                    </tr>
                                                                                                                                            
								</table>
    							</td>
                                
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.from"/>:</td></tr>
              						<tr><td class="label2">  
        <html:text property="headerfrom" size="40"  styleClass="forminput1"/>                                  
                                    </td></tr>    
    
             						<tr><td class="label2"><bean:message key="prompt.contact"/>:</td></tr>
              						<tr><td class="label2">
         <html:text property="headercontact" size="40"  styleClass="forminput1"/>  
                                            </td></tr>
                                                                            
             						<tr><td class="label2"><bean:message key="prompt.phone"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="headerphone" size="40"  styleClass="forminput1"/>  
                                    </td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.fax"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="headerfax" size="40"  styleClass="forminput1"/>  
                                    </td></tr>
                                    
                                                                                              
                      
								</table>
    							</td>                                
						    </tr>
<!-- PRINT HEADER DETAILS -----------------> 



<!-- PRIMARY MOVEMENT SELECTION ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selectdocumentprimarymovement"/></td></tr>
                                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="10%">              
                    				<span><bean:message key="heading.section"/></span>
								</td>

		  						<td class="column-header4" width="6%">
							         <span><bean:message key="heading.status"/></span>                                                           
								</td>
                                                    
		  						<td class="column-header4" width="12%">
							         <span><bean:message key="heading.fromlocation"/></span>                                                          
								</td>
                    
					  			<td class="column-header4" width="10%">
 							        <span><bean:message key="heading.fromdatetime"/></span>               	
								</td>  

                                
					  			<td class="column-header4" width="12%">
 							        <span><bean:message key="heading.tolocation"/></span>                      	
								</td>                                 

					  			<td class="column-header4" width="10%">
 							       <span><bean:message key="heading.todatetime"/></span>                   	
								</td>   
 
                                                                                                                                                					  			<td class="column-header4" width="28%">
 							        <span><bean:message key="heading.vendor"/></span>                  	
								</td> 

							</tr>

<logic:notEmpty name="GenerateXdocumentForm" property="list2">
                
<%int row=0;%>			
	<logic:iterate id="jobmovLineItem" name="GenerateXdocumentForm" property="list2">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>      
<%row++;%>	
<%String _checked = "checked";if (row > 1) _checked="";%>   
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<input type='radio' name='selectedObjects2' value='<c:out value="${jobmovLineItem.jobmovId}"/>' <%=_checked%>>
                	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="sectionkey.sectionkey" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="invsts" filter="true"/>								
                        </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="fromlocationkey.shortName" filter="true"/>								
                        </td> 
 
									<td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.estfromtime}"/><br/>		
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.actfromtime}"/>
                        			</td>                                    									
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="tolocationkey.shortName" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.esttotime}"/><br/>
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.acttotime}"/>
                        			</td>                                      
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>    
                                                                                                             
								</tr>
                                  
	</logic:iterate>

</logic:notEmpty> 
   
            			</table>
					</td>
				</tr>                  
<!-- PRIMARY MOVEMENT SELECTION ----------------->            
                            
 
 
<!-- SHIP MOVEMENT SELECTION ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selectdocumentshipmovement"/></td></tr>
                             
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>
       
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="10%">              
                    				<span><bean:message key="heading.section"/></span>
								</td>

		  						<td class="column-header4" width="6%">
							         <span><bean:message key="heading.status"/></span>                                                           
								</td>
                                                    
		  						<td class="column-header4" width="12%">
							         <span><bean:message key="heading.fromlocation"/></span>                                                          
								</td>
                    
					  			<td class="column-header4" width="10%">
 							        <span><bean:message key="heading.fromdatetime"/></span>               	
								</td>  

                                
					  			<td class="column-header4" width="12%">
 							        <span><bean:message key="heading.tolocation"/></span>                      	
								</td>                                 

					  			<td class="column-header4" width="10%">
 							       <span><bean:message key="heading.todatetime"/></span>                   	
								</td>   
 
                                                                                                                                                					  			<td class="column-header4" width="28%">
 							        <span><bean:message key="heading.vendor"/></span>                  	
								</td> 


							</tr>

<logic:notEmpty name="GenerateXdocumentForm" property="list1">
                
<%int row=0;%>			
	<logic:iterate id="jobmovLineItem" name="GenerateXdocumentForm" property="list1">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>      
<%row++;%>	
<%String _checked = "checked";if (row > 1) _checked="";%>   
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<input type='radio' name='selectedObjects1' value='<c:out value="${jobmovLineItem.jobmovId}"/>' <%=_checked%>>
	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="sectionkey.sectionkey" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="invsts" filter="true"/>								
                        </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="fromlocationkey.shortName" filter="true"/>								
                        </td> 
 
									<td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.estfromtime}"/><br/>		
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.actfromtime}"/>
                        			</td>                                    									
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="tolocationkey.shortName" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.esttotime}"/><br/>
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.acttotime}"/>
                        			</td>                                      
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="vendoraddrkey.name" filter="true"/>
                        			</td>    
                                                                                                             
								</tr>
                                  
	</logic:iterate>
    
</logic:notEmpty>    
    
            			</table>
					</td>
				</tr>
<!-- SHIP MOVEMENT SELECTION ----------------->                
                


<!-- PRIMARY PRODUCT SELECTION ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selectdocumentprimaryproduct"/></td></tr>
                             
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>
       
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="40%">              
                    				<span><bean:message key="heading.product"/></span>
								</td>

		  						<td class="column-header4" width="15%">
							         <span><bean:message key="heading.volume"/></span>                                                           
								</td>
                                                    
		  						<td class="column-header4" width="15%">
							         <span><bean:message key="heading.weight"/></span>                                                          
								</td>
                    
					  			<td class="column-header4" width="10%">
 							        <span><bean:message key="heading.compartment"/></span>               	
								</td>  
                                                            
							</tr>

<logic:notEmpty name="GenerateXdocumentForm" property="list3">
                
<%int row=0;%>			
	<logic:iterate id="orderprodLineItem" name="GenerateXdocumentForm" property="list3">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>      
<%row++;%>	
<%String _checked = "checked";if (row > 1) _checked="";%>   
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<input type='radio' name='selectedObjects3' value='<c:out value="${orderprodLineItem.orderprodId}"/>' <%=_checked%>>
	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="orderprodLineItem" property="productkey.productkey" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
<bean:write name="orderprodLineItem" property="volume" filter="true"/>&nbsp;
						<bean:write name="orderprodLineItem" property="volunit" filter="true"/>									
                        </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="orderprodLineItem" property="weight" filter="true"/>&nbsp;
						<bean:write name="orderprodLineItem" property="wghtunit" filter="true"/>						
                        </td> 
                                  									
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="orderprodLineItem" property="comprt" filter="true"/>
                        			</td>                                    
                                                                                                             
								</tr>
                                  
	</logic:iterate>
    
</logic:notEmpty>    
    
            			</table>
					</td>
				</tr>
<!-- PRIMARY PRODUCT SELECTION ----------------->               
                                



<!-- EMAIL DETAILS ----------------->                            	                                 
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.email"/></td></tr>

<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    							
                            	<td colspan="2">               
                   
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
  
<tr>
	<td width="10%">
        	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('mailto'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>TO</span>
        	</button> 
        </div>
	</td>
	<td class="label2" width="90%"><html:textarea property="mailto" rows="2" cols="110" styleClass="forminput1"/></td>
</tr>  
<tr>
	<td>
    	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('mailcc'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>CC</span>
        	</button> 
        </div>
	</td>
	<td class="label2"><html:textarea property="mailcc" rows="2" cols="110" styleClass="forminput1"/></td>
</tr>
<tr>
	<td>
        	<div class="btnPane3"> 	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('mailbcc'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>BCC</span>
        	</button>
            </div> 
	</td>
	<td class="label2"><html:textarea property="mailbcc" rows="2" cols="110" styleClass="forminput1"/></td>
  </tr>
<tr>
	<td class="label2">FROM</td>
	<td class="label2"><html:text property="mailfrom" size="50"  maxlength="50" styleClass="forminput1"/></td>
  </tr>
<tr>
	<td class="label2">SUBJECT</td>
	<td class="label2"><html:text property="mailsubject" size="50"  maxlength="50" styleClass="forminput1"/></td>
</tr> 
<tr>
	<td class="label2" valign="top">TEXT</td>
	<td class="label2"><html:textarea property="mailtext" rows="10" cols="110" styleClass="forminput1"/></td>
</tr>
  
</table>
								
    							</td>                            
						    </tr>
<!-- EMAIL DETAILS ----------------->

  
  
<!-- ATTACHED STORED DOCUMENTS ----------------->
<jsp:useBean
  id="GenerateXdocumentForm"
  class="com.bureaueye.beacondms.form.dms.GenerateXdocumentForm"
  scope="session"
/>
 
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selecttoattachstoreddocuments"/></td></tr>
                                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="17%">              
                    				<span><bean:message key="heading.orderno"/></span>
								</td>

		  						<td class="column-header4" width="80%">
							         <span><bean:message key="heading.documentname"/></span>                                                           
								</td>
                                                    

							</tr>

<%
int row2=0;

java.util.Hashtable _ht =
	(java.util.Hashtable)GenerateXdocumentForm.getLineItemsHt();

if (_ht!=null) {
	
for (java.util.Enumeration e2 = _ht.keys(); e2.hasMoreElements();) {

	String _key = (String)e2.nextElement();
	
	java.util.StringTokenizer _st = new java.util.StringTokenizer(_key, "|");	
	String _orderno = "";
	try {_orderno = _st.nextToken();} catch (Exception e) {}
	String _description = "";
	try {_description = _st.nextToken();} catch (Exception e) {}

	com.bureaueye.beacon.model.order.Orderfile _orderfile = (com.bureaueye.beacon.model.order.Orderfile)_ht.get(_key); 

String _class = "column-cell1";if ((row2 % 2) == 0) _class = "column-cell2";

row2++;
%>
                            
    
  
			          
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<html:multibox property="selectedObjects4">
<%= _orderfile.getOrderfileId() %>
</html:multibox>
                	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
<%= _orderno %>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
<%= _description %>							
                        </td>                                       
                                                                                                             
								</tr>
                                  
<%
}
}
%>
   
            			</table>
					</td>
				</tr>                                
<!-- ATTACHED STORED DOCUMENTS ----------------->  
  

 
                                       
                                          
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  


					</table>
				</td></tr>

</html:form>

</table>

</div>
</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

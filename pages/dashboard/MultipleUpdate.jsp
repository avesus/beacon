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
<title><bean:message key="multiplemovementupdate.title"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="multiplemovementupdate.title"/></span>
<%--<span class="header2">&gt;</span>
<logic:equal name="MultipleUpdateForm" property="jobmovId" scope="session" value="">
	<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>  
</logic:equal>    
<logic:notEqual name="MultipleUpdateForm" property="jobmovId" scope="session" value="">
	<html:link action="/ListJobmov"><span class="header4"><bean:message key="jobmov.title.list"/></span></html:link>  
</logic:notEqual>   --%>   
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    
    
<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:80px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">

    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.jobno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.consignmentno"/></td>        
        <td align="right" width="33%">
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" onClick="showHideSearch('header','header2');"/>
		</td> 
    </tr>
  <tr>
    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[9]" scope="session"/></td>
    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[5]" scope="session"/></td>
      <td class="label10">&nbsp;</td>            
    </tr>    
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.orderno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.orderdate"/></td>           
		<td class="label11" width="33%">&nbsp;</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[2]" scope="session"/></td>
      <td class="label10">&nbsp;</td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:260px; z-index:10; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">

    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.jobno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.consignmentno"/></td>        
        <td align="right" width="33%">
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" onClick="showHideSearch('header','header2');"/>
		</td> 
    </tr>
  <tr>
    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[9]" scope="session"/></td>
    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[5]" scope="session"/></td>
      <td class="label10">&nbsp;</td>                      
    </tr>     
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.orderno"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.orderdate"/></td>           
		<td class="label11" width="33%">&nbsp;</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[2]" scope="session"/></td>
      <td class="label10">&nbsp;</td>              
    </tr>
              
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="3"><bean:message key="heading.vendor"/></td>
 		</tr>      
    	<tr>
		    <td class="label10" colspan="3"><bean:write name="MultipleUpdateForm" property="headerInfo[4]" scope="session"/></td>               
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.section"/></td>
		    <td class="label11"></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[3]" scope="session"/></td>
		    <td class="label10"></td>
		    <td class="label10"></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.fromlocation"/></td>
		    <td class="label11"><bean:message key="heading.tolocation"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[6]" scope="session"/></td>
		    <td class="label10"><bean:write name="MultipleUpdateForm" property="headerInfo[7]" scope="session"/></td>
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

    
<html:form action="/DashboardMultipleUpdate1">
	
<html:hidden property="jobhdrId"/>
<html:hidden property="jobmovId"/>  

  
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	 

				<button id="submitButton" class="btn btnFF" type="submit">
			                    <img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.search"/></span>
			    </button>                            
				<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListJobmov.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			    </button> 
                                                                                   
					</div> 
				</td></tr>


 

				<tr><td>
				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
  
  
<!-- SELECT HEADER DETAILS ----------------->     
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.movementsearchdetails"/></td></tr>

<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%" valign="top">               
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2" colspan="2"><bean:message key="prompt.section"/>:</td></tr>
              						<tr><td class="label2" colspan="2">                                 
		<html:select property="searchString1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectasection"/></html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select>          	
                                     </td></tr>
    
    
             						<tr><td class="label2" colspan="2"><bean:message key="prompt.vendor"/>:</td></tr>
              						<tr><td class="label2" colspan="2">	
		<html:select property="searchString2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>                                            
        							</td></tr>  
                                                                                 
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.fromlocation"/>:</td></tr>
              						<tr><td class="label2" valign="top">
<html:select property="searchString3" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
</html:select>        
                                    </td>
                                    </tr>
                                    
              						<tr><td class="label2" colspan="2"><bean:message key="prompt.tolocation"/>:</td></tr>
              						<tr><td class="label2" valign="top"> 
<html:select property="searchString4" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
</html:select>               
                                    </td>
                                    </tr>
                                                                                                                                            
								</table>
    							</td>
                                
                            	<td width="50%" valign="top">               
                                <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                 
                                                                            
<%--             						<tr><td class="label2"><bean:message key="prompt.vessel"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="searchString7" size="40"  styleClass="forminput1"/>  
                                    </td></tr>
                                    
             						<tr><td class="label2"><bean:message key="prompt.voyage"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="searchString8" size="40"  styleClass="forminput1"/>  
                                    </td></tr>--%>                                                                                                                               
                      
								</table>
    							</td>                                
						    </tr>
<!-- SELECT HEADER DETAILS -----------------> 


							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  


					</table>
				</td></tr>
                
</html:form>



<logic:notEmpty name="MultipleUpdateForm" property="list1">

<html:form action="/DashboardMultipleUpdate2">
	
<html:hidden property="jobhdrId"/>
<html:hidden property="jobmovId"/>



				<tr><td>
				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">  

<!-- UPDATE MOVEMENT SELECTION ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selectjobmovementstoupdate"/></td></tr>

<tr>
<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td> 
<td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht">
	<div class="btnPane3">                 
        		<button class="btn btnFF" type="submit" name="btnSubmit" value="Update" >
			<img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
	        <span><bean:message key="button.update"/></span>
				 </button>          
	</div>      	                         
				</td>
              
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="10%">              
                    				<span><bean:message key="heading.jobno"/></span>
								</td>
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
                
<%int row=0;%>			
	<logic:iterate id="jobmovLineItem" name="MultipleUpdateForm" property="list1">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>      
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<input type='checkbox' name='selectedObjects1' value='<c:out value="${jobmovLineItem.jobmovId}"/>'>
                	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="jobhdrId" filter="true"/>
                                    </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="section.sectionkey" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="invsts" filter="true"/>								
                        </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="fromlocation.shortName" filter="true"/>								
                        </td> 
 
									<td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.estfromtime}"/><br/>		
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.actfromtime}"/>
                        			</td>                                    									
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="tolocation.shortName" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.esttotime}"/><br/>
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.acttotime}"/>
                        			</td>                                      
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="vendoraddr.name" filter="true"/>
                        			</td>    
                                                                                                             
								</tr>
                                  
	</logic:iterate> 
   
            			</table>
					</td>
				</tr>                  
<!-- UPDATE MOVEMENT SELECTION ----------------->            
                            
                                     
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  


					</table>
				</td></tr>
                 
</html:form> 

</logic:notEmpty>
           
                                



<logic:notEmpty name="MultipleUpdateForm" property="list2">

<html:form action="/MultipleUpdate2">
	
<html:hidden property="jobhdrId"/>
<html:hidden property="jobmovId"/>

				<tr><td>
				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">  

<!-- UPDATE MOVEMENT SELECTION ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selectconsignmentmovementstoupdate"/></td></tr>

<tr>
<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td> 
<td colspan="2">
<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="20%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht">
	<div class="btnPane3">                 
        		<button class="btn btnFF" type="submit" name="btnSubmit" value="Update" >
			<img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
	        <span><bean:message key="button.update"/></span>
				 </button>          
	</div>      	                         
				</td>
              
			</tr>
		</table>
	</td></tr>
</table>
</td></tr>
                                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="10%">              
                    				<span><bean:message key="heading.jobno"/></span>
								</td>
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
                
<%int row=0;%>			
	<logic:iterate id="jobmovLineItem" name="MultipleUpdateForm" property="list2">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>      
<%row++;%>	
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<input type='checkbox' name='selectedObjects2' value='<c:out value="${jobmovLineItem.jobmovId}"/>'>
                	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="jobhdrId" filter="true"/>
                                    </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="section.sectionkey" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="invsts" filter="true"/>								
                        </td>                                     
									<td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="fromlocation.shortName" filter="true"/>								
                        </td> 
 
									<td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="estfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.estfromtime}"/><br/>		
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="actfromdate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.actfromtime}"/>
                        			</td>                                    									
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="tolocation.shortName" filter="true"/>
                        			</td>                                    
                                    <td class="<%= _class %>" nowrap valign="top">
<span class="label11"><bean:message key="prompt.est"/></span>&nbsp;<bean:write name="jobmovLineItem" property="esttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.esttotime}"/><br/>
<span class="label11"><bean:message key="prompt.act"/></span>&nbsp;<bean:write name="jobmovLineItem" property="acttodate" format="dd-MMM-yyyy" filter="true"/>/<c:out value="${jobmovLineItem.acttotime}"/>
                        			</td>                                      
                                    <td class="<%= _class %>" nowrap valign="top">
						<bean:write name="jobmovLineItem" property="vendoraddr.name" filter="true"/>
                        			</td>    
                                                                                                             
								</tr>
                                  
	</logic:iterate> 
   
            			</table>
					</td>
				</tr>                  
<!-- UPDATE MOVEMENT SELECTION ----------------->            
                            
                                     
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  


					</table>
				</td></tr>
                 
</html:form> 

</logic:notEmpty>      
      




</table>

</div>
</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

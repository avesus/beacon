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
function screenRefresh(){}
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
<title><bean:message key="gcode.title.list"/></title>
</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2"><bean:message key="gcode.title.list"/></span></td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
<html:form action="/ListG4code" focus="searchString1">
<html:hidden property="gotoPage" />
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			<tr>
            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
            				<tr><td class="label2"><bean:message key="prompt.g1code"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString1" size="20" maxlength="20" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>
                            
            				<tr><td class="label2"><bean:message key="prompt.g2code"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString2" size="20" maxlength="20" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>
                            
            		<tr><td class="label2"><bean:message key="prompt.g3code"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString3" size="20" maxlength="20" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>   

            		<tr><td class="label2"><bean:message key="prompt.g4code"/>:</td></tr>
    						<tr><td class="label2">
									<html:text property="searchString4" size="20" maxlength="20" styleClass="forminput1" onkeypress="return noenter()"/>
              				</td></tr>                                                        
                                                        
    					</table>
					</td>
    			</tr>
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane">	        
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Search</span>
        				</button>    
     
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditG4code.do?action=Create'">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>    
                        
						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='MainMenu.do'">
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
		  						<td class="column-header1" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListG4code.do?orderBy=G1codekey&gotoPage=0'">
										<span><bean:message key="heading.g1code"/></span>                        
										<logic:notEqual name="ListG4codeForm" property="orderBy" scope="session" value="G1codekey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListG4codeForm" property="orderBy" scope="session" value="G1codekey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                    
		  						<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListG4code.do?orderBy=G2codekey&gotoPage=0'">
										<span><bean:message key="heading.g2code"/></span>                        
										<logic:notEqual name="ListG4codeForm" property="orderBy" scope="session" value="G2codekey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListG4codeForm" property="orderBy" scope="session" value="G2codekey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>

		  						<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListG4code.do?orderBy=G3codekey&gotoPage=0'">
										<span><bean:message key="heading.g3code"/></span>                        
										<logic:notEqual name="ListG4codeForm" property="orderBy" scope="session" value="G3codekey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListG4codeForm" property="orderBy" scope="session" value="G3codekey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                                     
		  						<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListG4code.do?orderBy=G4codekey&gotoPage=0'">
										<span><bean:message key="heading.g4code"/></span>                        
										<logic:notEqual name="ListG4codeForm" property="orderBy" scope="session" value="G4codekey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListG4codeForm" property="orderBy" scope="session" value="G4codekey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
								</td>
                                                                                                                    
		  						<td class="column-header2" width="35%">
							         <button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListG4code.do?orderBy=Ldesc&gotoPage=0'">
										<span><bean:message key="heading.description"/></span>          
										<logic:notEqual name="ListG4codeForm" property="orderBy" scope="session" value="Ldesc">              
											<img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListG4codeForm" property="orderBy" scope="session" value="Ldesc">              
											<img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>  
							        </button>                                                             
								</td>
                    
                                                                                                  					
		  						<td width="25%"></td>
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListG4codeForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><bean:write name="lineItem" property="g1codekey" filter="true"/></td> 
									<td class="<%= _class %>"><bean:write name="lineItem" property="g2codekey" filter="true"/></td>									<td class="<%= _class %>"><bean:write name="lineItem" property="g3codekey" filter="true"/></td> 
<td class="<%= _class %>"><bean:write name="lineItem" property="g4codekey" filter="true"/></td>                                                                         
<td class="<%= _class %>"><bean:write name="lineItem" property="ldesc" filter="true"/></td> 
                                                                                                    					 
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
											<tr>
		  										<td class="<%= _class %>"></td>

                                    			<td class="<%= _class %>" align="right">
<html:link action="/EditG4code.do?action=Edit" paramId="g4codeId" paramName="lineItem" paramProperty="g4codeId"><bean:message key="prompt.edit"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditG4code.do?action=Copy" paramId="g4codeId" paramName="lineItem" paramProperty="g4codeId"><bean:message key="prompt.copy"/></html:link>
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditG4code.do?action=Delete" paramId="g4codeId" paramName="lineItem" paramProperty="g4codeId">
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

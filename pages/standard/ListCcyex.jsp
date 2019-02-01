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
<title><bean:message key="ccyex.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td><span class="header2"><bean:message key="ccyex.title.list"/></span></td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
			<html:form action="/ListCcyex" focus="searchString1">
			<html:hidden property="gotoPage" />
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			<tr>
            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
            				<tr><td class="label2"><bean:message key="prompt.fromccy"/>:</td></tr>
    						<tr><td class="label2">
		<html:select property="searchString1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
              				</td></tr>
                                                  
            				<tr><td class="label2"><bean:message key="prompt.toccy"/>:</td></tr>
    						<tr><td class="label2">
		<html:select property="searchString2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.ccy"/></html:option>				
			<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/>	
		</html:select>
              				</td></tr>
                                      
            				<tr><td class="label2"><bean:message key="prompt.exdate"/>:</td></tr>
    						<tr><td class="label2">
<table width="65%">
          <tr>
            <td width="11%" class="label2"><div align="left"> &nbsp;<bean:message key="prompt.from"/>: </div></td>
            <td width="37%"><html:select property="searchDate1dd" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
                <html:select property="searchDate1mm" styleClass="forminput1">
                  <html:option value="">
                    <bean:message key="prompt.month"/>
                  </html:option>
                  <html:options collection="months" property="value" labelProperty="label"/>
                </html:select>
                <html:select property="searchDate1yyyy" styleClass="forminput1">
                  <html:option value="">
                    <bean:message key="prompt.year"/>
                  </html:option>
                  <html:options collection="years" property="value" labelProperty="label"/>
                </html:select>
            </td>
            <td width="6%" class="label2"><div align="right"> <bean:message key="prompt.to"/>: </div></td>
            <td width="46%"><html:select property="searchDate2dd" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
                <html:select property="searchDate2mm" styleClass="forminput1">
                  <html:option value="">
                    <bean:message key="prompt.month"/>
                  </html:option>
                  <html:options collection="months" property="value" labelProperty="label"/>
                </html:select>
                <html:select property="searchDate2yyyy" styleClass="forminput1">
                  <html:option value="">
                    <bean:message key="prompt.year"/>
                  </html:option>
                  <html:options collection="years" property="value" labelProperty="label"/>
                </html:select>
            </td>
          </tr>
        </table>
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
     
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditCcyex.do?action=Create'">
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
		  						<td class="column-header1" width="15%">              
<span><bean:message key="heading.fromccy"/></span>
								</td>
                                                     
		  						<td class="column-header2" width="15%">              
<span><bean:message key="heading.toccy"/></span>
								</td>

		  						<td class="column-header2" width="15%">              
<span><bean:message key="heading.exdate"/></span>
								</td>
                                
		  						<td class="column-header2" width="15%">              
<span><bean:message key="heading.exrate"/></span>
								</td>                                                                                                                                                                  					
		  						<td width="15%"></td>
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListCcyexForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><bean:write name="lineItem" property="fromccykey" filter="true"/></td> 

									<td class="<%= _class %>"><bean:write name="lineItem" property="toccykey" filter="true"/></td>                                                                                                                                         					 									<td class="<%= _class %>"><bean:write name="lineItem" property="exdate" format="dd-MMM-yyyy" filter="true"/></td>

									<td class="<%= _class %>"><bean:write name="lineItem" property="exrate" filter="true"/></td>                                    
									<td>
										<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
											<tr>
		  										<td class="<%= _class %>"></td>

                                    			<td class="<%= _class %>" align="right">
<app:linkCcyexLineItem page="/EditCcyex.do?action=Edit"><bean:message key="prompt.edit"/></app:linkCcyexLineItem>
&nbsp;&nbsp;|&nbsp;&nbsp;
<app:linkCcyexLineItem page="/EditCcyex.do?action=Copy"><bean:message key="prompt.copy"/></app:linkCcyexLineItem>
&nbsp;&nbsp;|&nbsp;&nbsp;
<app:linkCcyexLineItem page="/EditCcyex.do?action=Delete"><bean:message key="prompt.delete"/></app:linkCcyexLineItem>
                                          
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

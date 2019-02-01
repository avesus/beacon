<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 *
 * NT	2014-02-01		BESL-201402-0001	QUOTE MOVE AND COST TEMPLATE WORK
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
<title><bean:message key="vendortariffavg.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td width="70%"><span class="header2"><bean:message key="vendortariffavg.title.list"/></span></td><td width="30%"></td></tr> 
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
		
	  	  
<tr><td colspan="2">

<html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer"><bean:message key="errors.prefix"/><bean:write name="error"/><bean:message key="errors.suffix"/></html:messages>
<html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer"><bean:message key="messages.prefix"/><bean:write name="msg"/><bean:message key="messages.suffix"/></html:messages>
	
<div style="OVERFLOW:auto; width:1400px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
    
			<html:form action="/ListVendortariffavg" focus="searchDate1dd">
			<html:hidden property="gotoPage" />
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			<tr>
            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                         
            				<tr><td class="label2"><bean:message key="prompt.createdate"/>:</td></tr>
    						<tr><td class="label2">
<table width="50%">
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
                    
<input type="hidden" name="button" id="form-action" />
                    	        
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span><bean:message key="button.search"/></span>
        				</button>     

						<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='MainMenu.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			            </button>    
                        
				<button class='btn btnFF' type='submit' value='BUILD' onClick="document.getElementById('form-action').value='BUILD'">
			        <span><bean:message key="button.buildrates"/></span>
				 </button> 
                 
				<button class='btn btnFF' type='submit' value='ROLLBACK' onClick="document.getElementById('form-action').value='ROLLBACK'">
			        <span><bean:message key="button.rollback"/></span>
				 </button> 
                                                                                                       
					</div> 
				</td></tr>
 

        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
		  						<td class="column-header1" width="5%">              
<span><bean:message key="heading.id"/></span>
								</td>
                                                     
		  						<td class="column-header2" width="9%">              
<span><bean:message key="heading.cost"/></span>
								</td>

		  						<td class="column-header2" width="11%">              
<span><bean:message key="heading.fromlocation"/></span>
								</td>
                                
		  						<td class="column-header2" width="11%">              
<span><bean:message key="heading.tolocation"/></span>
								</td>                                                                                                                                                  		  															
                                <td class="column-header2" width="9%">
                                	<span><bean:message key="heading.hazprod"/></span>
                                </td>

		  						<td class="column-header2" width="8%">              
<span><bean:message key="heading.unittype"/></span>                                
								</td>
                                                                                                
		  						<td class="column-header2" width="8%" align="right">              
<span><bean:message key="heading.lumpsum"/></span>                                
								</td>

		  						<td class="column-header2" width="8%" align="right">              
<span><bean:message key="heading.fromvalue"/></span>                                
								</td>
		  						<td class="column-header2" width="8%" align="right">              
<span><bean:message key="heading.tovalue"/></span>                                
								</td>
		  						<td class="column-header2" width="8%" align="right">              
<span><bean:message key="heading.unitrate"/></span>                                
								</td>
                                                                     
                                                                
		  						<td class="column-header2" width="16%">              
<span><bean:message key="heading.createtime"/></span>
								</td>                                                                                                                                            
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListVendortariffavgForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><bean:write name="lineItem" property="vendortariffavgId" filter="true"/></td> 

									<td class="<%= _class %>"><bean:write name="lineItem" property="costkey" filter="true"/></td>                                                                                                                                         					 							

									<td class="<%= _class %>"><bean:write name="lineItem" property="fromlocationkey" filter="true"/></td> 
									<td class="<%= _class %>"><bean:write name="lineItem" property="tolocationkey" filter="true"/></td>

									<td class="<%= _class %>"><bean:write name="lineItem" property="producthazardous" filter="true"/></td>
                                    
<td class="<%= _class %>"><bean:write name="lineItem" property="unittype" filter="true"/></td>
                                    
<td class="<%= _class %>" align="right"><bean:write name="lineItem" property="lumpsum" filter="true"/></td>

<td class="<%= _class %>" align="right"><bean:write name="lineItem" property="fromvalue" filter="true"/></td>
<td class="<%= _class %>" align="right"><bean:write name="lineItem" property="tovalue" filter="true"/></td>
<td class="<%= _class %>" align="right"><bean:write name="lineItem" property="unitrate" filter="true"/></td>
                                    
									<td class="<%= _class %>">
                                    <bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
                                    <bean:write name="lineItem" property="createtime" filter="true"/>
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

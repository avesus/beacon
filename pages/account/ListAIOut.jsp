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
  

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>


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
<title><bean:message key="aiout.title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td width="70%"><span class="header2"><bean:message key="aiout.title.list"/></span></td><td width="30%"><jsp:include page="/pages/system/menubar.jsp" flush="true" /></td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr><td colspan="2">
	
<div style="OVERFLOW:auto; width:1200px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
			<html:form action="/ListAIOut" focus="searchString1">
			<html:hidden property="gotoPage" />
        
        
       			<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
       
       			<tr>
            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">      
      					<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

            				<tr><td class="label2"><bean:message key="prompt.doctype"/>:</td></tr>
    						<tr><td class="label2">
		<html:select property="searchString1" styleClass="forminput1">
			<html:option value="">- select a Type -</html:option>				
			<html:option value="AR_ACTUAL">AR_ACTUAL</html:option>
			<html:option value="AP_ACCRUAL">AP_ACCRUAL</html:option>    
            <html:option value="AP_ACTUAL">AP_ACTUAL</html:option>                   															
		</html:select>
              				</td></tr>
                                                                                     
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
 
            				<tr><td class="label2"><bean:message key="prompt.status"/>:</td></tr>
    						<tr><td class="label2">
<span class="forminput1">
<html:radio property="searchString9" value="%"/>
All
<html:radio property="searchString9" value="PENDING"/>
Pending 
<html:radio property="searchString9" value="SENT"/>
Sent
<html:radio property="searchString9" value="ERROR"/>
Error 
</span>
              				</td></tr>
                            
            				<tr><td class="label2"><bean:message key="prompt.documentkey"/>:</td></tr>
    						<tr><td class="label2">
		<html:text property="searchString2" size="20" maxlength="20" styleClass="ftforminputsmall"/>
              				</td></tr>
                                                                                                                                                              				<tr><td class="label2"><bean:message key="prompt.batchid"/>:</td></tr>
    						<tr><td class="label2">
		<html:text property="searchString3" size="20" maxlength="20" styleClass="ftforminputsmall"/>
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
                            
<td class="column-header1" width="8%"><span><bean:message key="heading.docid"/></span></td>
                                                     
<td class="column-header2" width="8%"><span><bean:message key="heading.doctype"/></span></td>

<td class="column-header2" width="7%"><span><bean:message key="heading.status"/></span></td>
                                
<td class="column-header2" width="10%"><span><bean:message key="heading.createuser"/></span></td>                                                                                                                                                  		<td class="column-header2" width="10%"><span><bean:message key="heading.createtime"/></span></td>

<td class="column-header2" width="15%"><span><bean:message key="heading.senttime"/></span></td>
                                
<td class="column-header2" width="10%"><span><bean:message key="heading.documentkey"/></span></td>
                                
<td class="column-header2" width="6%"><span><bean:message key="heading.compid"/></span></td>

<td class="column-header2" width="5%"><span><bean:message key="heading.batchid"/></span></td> 

<td width="16%"></td>                                                                                                                                           
							</tr>
                
<%int row=0;%>			
							<logic:iterate id="lineItem" name="ListAIOutForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  								<tr>
									<td class="<%= _class %>"><bean:write name="lineItem" property="aioutId" filter="true"/></td> 

									<td class="<%= _class %>"><bean:write name="lineItem" property="doctype" filter="true"/></td>                                                                                                                                         					 									<td class="<%= _class %>"><bean:write name="lineItem" property="aistatus" filter="true"/></td>

									<td class="<%= _class %>"><bean:write name="lineItem" property="createuserid" filter="true"/></td>
                                     
									<td class="<%= _class %>">
                                    <bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>                                    </td>

									<td class="<%= _class %>">
                                    <bean:write name="lineItem" property="sentdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
                                    <bean:write name="lineItem" property="senttime" filter="true"/>                                     
                                    </td>
                                    
<td class="<%= _class %>"><bean:write name="lineItem" property="dockey" filter="true"/>&nbsp;</td>                                                                                                                                                  									<td class="<%= _class %>"><bean:write name="lineItem" property="companykey" filter="true"/>&nbsp;</td>

<td class="<%= _class %>"><bean:write name="lineItem" property="aibatchId" filter="true"/>&nbsp;</td>                                                          
<td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
<tr>
		  										<td class="<%= _class %>">&nbsp;</td>

                                    			<td class="<%= _class %>" align="right">
<html:link action="/EditAIOut.do?action=View" paramId="aioutId" paramName="lineItem" paramProperty="aioutId"><bean:message key="prompt.view"/></html:link>

<c:if test="${lineItem.aistatus != 'PENDING'}">					
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/EditAIOut.do?action=ReSend" paramId="aioutId" paramName="lineItem" paramProperty="aioutId"><bean:message key="prompt.resend"/></html:link>                          
</c:if>  
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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *																					
 * 
 --%>
 
 
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->

<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->








<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:1180px; height:650px; z-index:20; visibility: visible">


<table border="0" cellpadding="0" cellspacing="0" width="1180px">



<tr>
<td bgcolor="#ffffff" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
<td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>

<td valign="top">

<!-- start messages -->
<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  
<tr><td>			
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
              </span>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>
</td></tr>    
                     
</table>
<!-- end messages -->  


<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="40%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht">&nbsp;</td>
				<td class="tdwht">
				</td>
			</tr>
		</table>
	</td></tr>
</table>

   
<!--  --> 
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>

		<td class="column-header1" width="8%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Userid&gotoPage=0'">
										<span><bean:message key="heading.userid"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Userid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Userid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="8%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Usergroupid&gotoPage=0'">
										<span><bean:message key="heading.groupid"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Usergroupid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Usergroupid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		<td class="column-header2" width="14%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Quotno&gotoPage=0'">
										<span><bean:message key="heading.quotno"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Quotno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Quotno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>          
        
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Quotestatus&gotoPage=0'">
										<span><bean:message key="heading.quotestatus"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Quotestatus">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Quotestatus">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>           
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Quotedate&gotoPage=0'">
										<span><bean:message key="heading.quotedate"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Quotedate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Quotedate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Quotebyuserid&gotoPage=0'">
										<span><bean:message key="heading.quotecreateby"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Quotebyuserid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Quotebyuserid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="10%">
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Approveflag&gotoPage=0'">
										<span><bean:message key="heading.approvereject"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Approveflag">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Approveflag">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>                
        </td>  
		<td class="column-header2" width="10%">
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListWorkflow.do?orderBy=Approvedate&gotoPage=0'">
										<span><bean:message key="heading.approvetime"/></span>                        
										<logic:notEqual name="ListWorkflowForm" property="orderBy" scope="session" value="Approvedate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListWorkflowForm" property="orderBy" scope="session" value="Approvedate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>                         
    	<td class="column-header3" width="10%" nowrap>&nbsp;</td>	
	</tr>  

  



<logic:notEmpty name="ListWorkflowForm" property="lineItems">

<%int row=0;%>

          <logic:iterate id="lineItem" name="ListWorkflowForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="userid" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="usergroupid" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
                      <c:if test="${lineItem.quotestatus == 'PENDING'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12"/>
                      </c:if>
                      <c:if test="${lineItem.quotestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12"/>
                      </c:if>	
                      <c:if test="${lineItem.quotestatus == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12"/>
                      </c:if>											
					<bean:write name="lineItem" property="quotestatus" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="quotedate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap><bean:write name="lineItem" property="quotebyuserid" filter="true"/>&nbsp;
            </td>            
			<td class="<%= _class %>" nowrap>
                      <c:if test="${lineItem.approveflag == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12"/>
                      </c:if>	
                      <c:if test="${lineItem.approveflag == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12"/>
                      </c:if>					
					<bean:write name="lineItem" property="approveflag" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="approvedate" format="dd-MMM-yyyy" filter="true"/>&nbsp;<bean:write name="lineItem" property="approvetime" filter="true"/>&nbsp;
			</td>         
			<td class="<%= _class %>" align="right" nowrap>
                    <app:linkWorkflowLineItem page="/ListQuoapprove.do?">
                        <bean:message key="prompt.approvereject"/>
                      </app:linkWorkflowLineItem>           																																										
			</td>
		</tr>	


                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>


</div>




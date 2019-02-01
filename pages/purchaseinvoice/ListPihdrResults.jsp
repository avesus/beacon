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








<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:1180px; height:650px; z-index:10; visibility: visible">


<table border="0" cellpadding="0" cellspacing="0" width="100%">



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
    <tr><td><img src="images/spacer.gif" height="3"/></td></tr>
	<tr><td>			  
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditPihdr.do?action=Create'">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>                                                  
					</div>
	</td></tr>
    <tr><td><img src="images/spacer.gif" height="3"/></td></tr>    
</table>



   
<!--  --> 
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>   
		<td class="column-header1" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListPihdr.do?orderBy=Pino&gotoPage=0'+'&amp;orderByDesc='+orderByDesc.options[orderByDesc.selectedIndex].value">
										<span><bean:message key="heading.pino"/></span>                        
										<logic:notEqual name="ListPihdrForm" property="orderBy" scope="session" value="Pino">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListPihdrForm" property="orderBy" scope="session" value="Pino">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListPihdr.do?orderBy=Invoicedate&gotoPage=0'+'&amp;orderByDesc='+orderByDesc.options[orderByDesc.selectedIndex].value">
										<span><bean:message key="heading.invoicedate"/></span>                        
										<logic:notEqual name="ListPihdrForm" property="orderBy" scope="session" value="Invoicedate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListPihdrForm" property="orderBy" scope="session" value="Invoicedate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		<td class="column-header2" width="20%">              
										<span><bean:message key="heading.vendor"/></span>                        
		</td>                  
		<td class="column-header2" width="20%">              
										<span><bean:message key="heading.vendorref"/></span>   
		</td>        
		<td class="column-header2" width="5%">              
										<span><bean:message key="heading.ccy"/></span>                      
		</td>                
		<td class="column-header2" width="10%" align="right">
										<span><bean:message key="heading.grossamount"/></span>                            
        </td>  
		<td class="column-header2" width="5%">
										<span><bean:message key="heading.approved"/></span>                             
        </td>  
    	<td class="column-header3" width="15%" nowrap>&nbsp;</td>	
                                     
	</tr>  

  



<logic:notEmpty name="ListPihdrForm" property="lineItems">

<%int row=0;%>

          <logic:iterate id="lineItem" name="ListPihdrForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%String _class2 = "column-cell5";if ((row % 2) == 0) _class2 = "column-cell6";%>
<%row++;%>
              
<!-- row1 -->
		<tr>                   
			<td class="<%= _class2 %>" nowrap>
<bean:write name="lineItem" property="pino" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="lineItem" property="invoicedate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class2 %>" nowrap>
<bean:write name="lineItem" property="vendoraddrkey.name" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="lineItem" property="vendorref" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="lineItem" property="ccykey" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class2 %>" nowrap align="right">
<bean:write name="lineItem" property="grossamt" filter="true"/>&nbsp;         
            </td>                        
			<td class="<%= _class2 %>" nowrap align="center">
                      <c:if test="${lineItem.invoicestatus == 'DISPUTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${lineItem.invoicestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${lineItem.invoicestatus}"/>'/>
                      </c:if>	
			</td>   
			<td class="<%= _class2 %>" align="right" nowrap>    
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class2 %>" align="left" nowrap>

                          </td>
                          <td width="90%" class="<%= _class2 %>" align="right" nowrap>
                          
<c:if test="${lineItem.postedflag==false}">                          
<html:link action="/EditPihdr.do?action=Edit" paramId="id" paramName="lineItem" paramProperty="pihdrId"><bean:message key="prompt.edit"/></html:link>
<span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>  
<html:link action="/EditPihdr.do?action=Delete" paramId="id" paramName="lineItem" paramProperty="pihdrId">
<bean:message key="prompt.delete"/> 
</html:link>	
</c:if>	

<c:if test="${lineItem.postedflag==true}">	
<html:link action="/EditPihdr.do?action=View" paramId="id" paramName="lineItem" paramProperty="pihdrId"><bean:message key="prompt.view"/></html:link>		
</c:if>	

                          </td>
                        </tr>
                      	</table>          																																										
			</td>
            
		</tr>	


<!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" colspan="9">
					<piapp:linkPihdrLineItem page="/ListPidtl.do"><bean:message key="prompt.details"/></piapp:linkPihdrLineItem>
                    </td>
                  </tr>
        

                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>


</div>




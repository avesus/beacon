<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--
 *
 * Amendments
 * ----------
 *
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function to Sales Invoice module (changes not commented) and change Sales Invoice print to open in new window
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



<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff"> 
	<tr>
    	<td width="18%">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff"> 
				<tr>    
					<td class="tdwht" align="right">&nbsp;&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
					<td class="tdwht" nowrap="nowrap"> 
			        </td>
					<td class="tdwht" nowrap="nowrap">                
	<div class="btnPane3">             
    
<input type="hidden" name="button" id="form-action" />
                  
				<button class='btn btnFF' type='submit' value='PRINT' onClick="document.getElementById('form-action').value='PRINT'">
			    	<img class=" IM CK-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        <span><bean:message key="button.print"/></span>
				 </button> 
                                  
				<button class='btn btnFF' type='submit' value='EMAIL' onClick="document.getElementById('form-action').value='EMAIL'">
        			<img class=" IM Z-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        <span><bean:message key="button.email"/></span>
				</button>                                                                             
	</div>	                         
					</td>
				</tr>
			</table> 
		</td> 
        <td width="66%">&nbsp;</td>      
		<td width="16%" class="tdwht" nowrap="nowrap"> 
					<div class="btnPane3">	              
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditSihdr.do?action=Create'">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span><bean:message key="button.add"/></span>
        				</button>                                                  
					</div>            
		</td>
	</tr>
</table>


   
<!--  --> 
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td class="column-header1" width="3%"> </td>    
		<td class="column-header1" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSihdr.do?orderBy=SihdrId&gotoPage=0'">
										<span><bean:message key="heading.docid"/></span>                        
										<logic:notEqual name="ListSihdrForm" property="orderBy" scope="session" value="SihdrId">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSihdrForm" property="orderBy" scope="session" value="SihdrId">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSihdr.do?orderBy=Createdate&gotoPage=0'">
										<span><bean:message key="heading.createdate"/></span>                        
										<logic:notEqual name="ListSihdrForm" property="orderBy" scope="session" value="Createdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSihdrForm" property="orderBy" scope="session" value="Createdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		<td class="column-header2" width="27%">              
										<span><bean:message key="heading.billingaccount"/></span>                        
		</td>                  
		<td class="column-header2" width="9%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSihdr.do?orderBy=Invoiceno&gotoPage=0'">
										<span><bean:message key="heading.invoiceno"/></span>                        
										<logic:notEqual name="ListSihdrForm" property="orderBy" scope="session" value="Invoiceno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSihdrForm" property="orderBy" scope="session" value="Invoiceno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSihdr.do?orderBy=Printdate&gotoPage=0'">
										<span><bean:message key="heading.printdate"/></span>                        
										<logic:notEqual name="ListSihdrForm" property="orderBy" scope="session" value="Printdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSihdrForm" property="orderBy" scope="session" value="Printdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>                      
		</td>        
		<td class="column-header2" width="9%">
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSihdr.do?orderBy=Invoiceccykey&gotoPage=0'">
										<span><bean:message key="heading.invoiceccy"/></span>                        
										<logic:notEqual name="ListSihdrForm" property="orderBy" scope="session" value="Invoiceccykey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSihdrForm" property="orderBy" scope="session" value="Invoiceccykey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>                             
        </td>  
		<td class="column-header2" width="12%">
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSihdr.do?orderBy=Invoiceamt&gotoPage=0'">
										<span><bean:message key="heading.invoiceamt"/></span>                        
										<logic:notEqual name="ListSihdrForm" property="orderBy" scope="session" value="Invoiceamt">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSihdrForm" property="orderBy" scope="session" value="Invoiceamt">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>                             
        </td>  
    	<td class="column-header3" width="10%" nowrap>&nbsp;</td>	
                                     
	</tr>  

  



<logic:notEmpty name="ListSihdrForm" property="lineItems">

<%int row=0;%>

          <logic:iterate id="sihdrLineItem" name="ListSihdrForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%String _class2 = "column-cell5";if ((row % 2) == 0) _class2 = "column-cell6";%>
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class2 %>" nowrap>        
<html:multibox property="selectedObjects"><bean:write name="sihdrLineItem" property="sihdrId" /></html:multibox>
            </td>                    
			<td class="<%= _class2 %>" nowrap>
<bean:write name="sihdrLineItem" property="sihdrId" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="sihdrLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class2 %>" nowrap>
<bean:write name="sihdrLineItem" property="customeraddrkey.name" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="sihdrLineItem" property="invoiceno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="sihdrLineItem" property="printdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class2 %>" nowrap>
<bean:write name="sihdrLineItem" property="invoiceccykey" filter="true"/>&nbsp;         
            </td>            
			<td class="<%= _class2 %>" nowrap align="right">
&nbsp;<bean:write name="sihdrLineItem" property="invoiceamt" filter="true"/>  
			</td>   
			<td class="<%= _class2 %>" align="right" nowrap>    
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class2 %>" align="left" nowrap>

                          </td>
                          <td width="90%" class="<%= _class2 %>" align="right" nowrap>
<c:if test="${!sihdrLineItem.printedflag}">
                                                            
	<c:if test="${sihdrLineItem.manualflag}">                              
    	<app:linkSihdrLineItem page="/EditSihdr.do?action=Edit"><bean:message key="prompt.edit"/></app:linkSihdrLineItem>       
<span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>                                                                                       
    	<app:linkSihdrLineItem page="/EditSihdr.do?action=Copy"><bean:message key="prompt.copy"/></app:linkSihdrLineItem>
	</c:if>

	<c:if test="${!sihdrLineItem.manualflag}">                              
		<app:linkSihdrLineItem page="/EditSihdr.do?action=View"><bean:message key="prompt.view"/></app:linkSihdrLineItem>
	</c:if>
            
	<span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>            
	<app:linkSihdrLineItem page="/EditSihdr.do?action=Delete"><bean:message key="prompt.delete"/></app:linkSihdrLineItem>
                                              
</c:if>

<c:if test="${sihdrLineItem.printedflag}">
	<c:if test="${sihdrLineItem.manualflag}">                                                                                                                    
    	<app:linkSihdrLineItem page="/EditSihdr.do?action=Copy"><bean:message key="prompt.copy"/></app:linkSihdrLineItem>
	</c:if>
</c:if>


                          </td>
                        </tr>
                      	</table>          																																										
			</td>
            
		</tr>	


<!-- row2 -->
                  <tr>
                    <td class="<%= _class %>" width="70%" colspan="9">
                    <app:linkSihdrLineItem page="/ListSidtl.do"><bean:message key="prompt.details"/></app:linkSihdrLineItem>
                      <c:if test="${!sihdrLineItem.printedflag}"> &nbsp&nbsp;
<%--                        <app:linkSihdrLineItem page="/PrintSalesinvoice.do?action=Test"><bean:message key="prompt.testprint"/></app:linkSihdrLineItem>--%>
<html:link action="/PrintSalesinvoice.do?action=Test" paramId="id" paramName="sihdrLineItem" paramProperty="sihdrId" target="_blank"><bean:message key="prompt.testprint"/></html:link>
                      </c:if>
                      &nbsp;&nbsp;
<%--                      <app:linkSihdrLineItem page="/PrintSalesinvoice.do?action=Print"><bean:message key="prompt.print"/></app:linkSihdrLineItem>--%>
<html:link action="/PrintSalesinvoice.do?action=Print" paramId="id" paramName="sihdrLineItem" paramProperty="sihdrId" target="_blank"><bean:message key="prompt.print"/></html:link>
                    </td>
                  </tr>
        

                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>


</div>




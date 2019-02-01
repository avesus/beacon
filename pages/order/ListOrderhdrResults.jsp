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


<script language="JavaScript">
<!--	
function showHideDetails(div,but) { 

var i,p,v,obj,but;

obj=MM_findObj(div);
obj=obj.style; 
v=obj.visibility;
if (v=='hidden') {
	obj.visibility='visible';	
	MM_swapImage(but,'','images/icon_collapse_12_12.png');	
}
else {
	obj.visibility='hidden'; 
	MM_swapImage(but,'','images/icon_expand_12_12.png');	
}
}
-->
</script>






<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:1180px; height:650px; z-index:1; visibility: visible">


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
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditOrderhdr.do?action=Create'">
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
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrderhdr.do?orderBy=Orderno&gotoPage=0'">
										<span><bean:message key="heading.ordernumber"/></span>                        
										<logic:notEqual name="ListOrderhdrForm" property="orderBy" scope="session" value="Orderno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrderhdrForm" property="orderBy" scope="session" value="Orderno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="9%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrderhdr.do?orderBy=Orderdate&gotoPage=0'">
										<span><bean:message key="heading.orderdate"/></span>                        
										<logic:notEqual name="ListOrderhdrForm" property="orderBy" scope="session" value="Orderdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrderhdrForm" property="orderBy" scope="session" value="Orderdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrderhdr.do?orderBy=Consignmentno&gotoPage=0'">
										<span><bean:message key="heading.consignmentno"/></span>                        
										<logic:notEqual name="ListOrderhdrForm" property="orderBy" scope="session" value="Consignmentno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrderhdrForm" property="orderBy" scope="session" value="Consignmentno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>                
        
		<td class="column-header2" width="15%">              
<span><bean:message key="heading.customer"/></span>       
		</td> 

		<td class="column-header2" width="10%">
<span><bean:message key="heading.shippingline"/></span>                        
		</td> 
              
		<td class="column-header2" width="5%">
<span><bean:message key="heading.vessel"/></span>                        
		</td> 
                                
		<td class="column-header2" width="7%">              
<span><bean:message key="heading.loadingport"/></span>                        
		</td> 
        
		<td class="column-header2" width="8%">              
<span><bean:message key="heading.dischargeport"/></span>                        
		</td>        
                          
		<td class="column-header2" width="5%">
<span><bean:message key="heading.invoicestatus"/></span>                                      
        </td> 
        
		<td class="column-header2" width="5%">
<span><bean:message key="heading.completed"/></span>                                      
        </td> 
                                        
    	<td class="column-header3" width="19%" nowrap>&nbsp;</td>	
        
	</tr>  



<logic:notEmpty name="ListOrderhdrForm" property="lineItems">

<%int row=0;%>

          <logic:iterate id="orderhdrLineItem" name="ListOrderhdrForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%String _class2 = "column-cell5";if ((row % 2) == 0) _class2 = "column-cell6";%>
<%row++;%>
              
<!-- row1 -->
<tr>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="orderno" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="orderdate" format="dd-MMM-yyyy" filter="true"/>
			</td>
            <td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="consignmentno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="customeraddrkey.shortname" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="shipvendoraddrkey.shortname" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="shipvessel" filter="true"/>
			</td>                                    
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="ldglocationkey2.shortName" filter="true"/>             
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="dchlocationkey2.shortName" filter="true"/>             
			</td>
			<td class="<%= _class2 %>" nowrap>
                      <c:if test="${orderhdrLineItem.invoicestatus == 'NOT INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${orderhdrLineItem.invoicestatus}"/>'/>
                        &nbsp;NOT
                      </c:if>
                      <c:if test="${orderhdrLineItem.invoicestatus == 'FULLY INVOICED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${orderhdrLineItem.invoicestatus}"/>'/>
                        &nbsp;FULLY
                      </c:if>	
                      <c:if test="${orderhdrLineItem.invoicestatus == 'PART INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${orderhdrLineItem.invoicestatus}"/>'/>
                        &nbsp;PART
                      </c:if>										
<%--					<bean:write name="orderhdrLineItem" property="invoicestatus" filter="true"/>--%>
			</td>

			<td class="<%= _class2 %>" nowrap align="center">
                      <c:if test="${orderhdrLineItem.completeflag}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12"/>
                      </c:if>	
			</td>
                                    
			<td class="<%= _class2 %>" align="right" nowrap>    
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class2 %>" align="left" nowrap>
<logic:notEqual name="orderhdrLineItem" property="notes" value=""> 
						  	<img src='images/icons/icon_information_12_12.png' width='16' height='16' border='0' alt='<c:out value="${orderhdrLineItem.notes}"/>'/> 
</logic:notEqual>
                          </td>
                          <td width="90%" class="<%= _class2 %>" align="right" nowrap>
						  <c:if test="${orderhdrLineItem.jobhdrsfound == 'false'}">
                              <orderapp:linkOrderhdrLineItem page="/EditOrderhdr.do?action=Delete">
                                <bean:message key="prompt.delete"/>
                              </orderapp:linkOrderhdrLineItem>
                              <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span> </c:if>
                            <orderapp:linkOrderhdrLineItem page="/EditOrderhdr.do?action=Edit">
                              <bean:message key="prompt.edit"/>
                            </orderapp:linkOrderhdrLineItem>
                            <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                            <orderapp:linkOrderhdrLineItem page="/EditOrderhdr.do?action=Copy">
                              <bean:message key="prompt.copy"/>
                            </orderapp:linkOrderhdrLineItem>
                          </td>
                        </tr>
                      	</table>          																																										
			</td>
            
		</tr>	
													
<!-- row2 -->
<tr>
              <td colspan="11">
              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>
				  <td class="<%= _class %>" align="left" nowrap>
				  	<img src="images/icon_expand_12_12.png" width="12" height="12" align="middle" id="but_<c:out value="${orderhdrLineItem.orderno}"/>" onclick="showHideDetails('div_<c:out value="${orderhdrLineItem.orderno}"/>','but_<c:out value="${orderhdrLineItem.orderno}"/>');"/>
				  </td>
				  <td class="<%= _class %>" align="left" nowrap>
				  <img src="images/spacer.gif" width="12" height="1"/>
				  </td>				  
                    <td width="70%" class="<%= _class %>" nowrap>                    
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<td valign="top">                    
					<orderapp:linkOrderhdrLineItem page="/ListOrderprod.do">
                        <bean:message key="prompt.products"/>
                      </orderapp:linkOrderhdrLineItem> 
&nbsp;&nbsp;                      
                      <orderapp:linkOrderhdrLineItem page="/ListOrdercharge.do">
                        <bean:message key="prompt.charges"/>
                      </orderapp:linkOrderhdrLineItem>
                     &nbsp;&nbsp;                       
<c:if test="${orderhdrLineItem.jobhdrsfound == 'false'}">
                        <orderapp:linkOrderhdrLineItem page="/ListOrdermov.do">
                          <bean:message key="prompt.movements"/>
                        </orderapp:linkOrderhdrLineItem>

                        &nbsp;&nbsp; 				

                      <orderapp:linkOrderhdrLineItem page="/ListOrdercost.do">
                        <bean:message key="prompt.costs"/>
                      </orderapp:linkOrderhdrLineItem>

                      &nbsp;&nbsp;

</c:if>				
  
                      <orderapp:linkOrderhdrLineItem page="/ListJobhdr.do">
                        <bean:message key="prompt.jobunitsandassign"/>
                      </orderapp:linkOrderhdrLineItem>
                                          
                      &nbsp;&nbsp;

                      <orderapp:linkOrderhdrLineItem page="/ListOrdernote.do">
                        <bean:message key="prompt.notes"/>
                      </orderapp:linkOrderhdrLineItem>
<c:if test="${orderhdrLineItem.notesfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<orderapp:linkOrderhdrLineItem page="/ListOrdernote.do">(<c:out value="${orderhdrLineItem.notesfound}"/>)</orderapp:linkOrderhdrLineItem>
</c:if>
                      
                      &nbsp;&nbsp;
                  
                      <orderapp:linkOrderhdrLineItem page="/ListOrdernotecust.do">
                          <bean:message key="prompt.customernotes"/>
                      </orderapp:linkOrderhdrLineItem>
<c:if test="${orderhdrLineItem.notecustsfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<orderapp:linkOrderhdrLineItem page="/ListOrdernotecust.do">(<c:out value="${orderhdrLineItem.notecustsfound}"/>)</orderapp:linkOrderhdrLineItem>
</c:if> 
                  
                        &nbsp;&nbsp;
                      
                      <orderapp:linkOrderhdrLineItem page="/ListOrderfile.do">
                        <bean:message key="prompt.documents"/>
                      </orderapp:linkOrderhdrLineItem> 
<c:if test="${orderhdrLineItem.documentsfound != '0'}">
<img src='images/icons/icon_stored_documents2_12_12.png' border='0' alt='Documents stored'/>
<orderapp:linkOrderhdrLineItem page="/ListOrderfile.do">(<c:out value="${orderhdrLineItem.documentsfound}"/>)</orderapp:linkOrderhdrLineItem>
</c:if>
                                         
                      &nbsp;&nbsp;
                     
                      <orderapp:linkOrderhdrLineItem page="/ListOrdersummary.do">
                        <bean:message key="prompt.financialsummary"/>
                      </orderapp:linkOrderhdrLineItem>                                                           
</td>
</tr>
</table>                     
                    </td>
                    <td class="<%= _class %>" width="30%" align="right" nowrap>         
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top" nowrap>
<html:hidden name="orderhdrLineItem" property="id"/>
<html:select property="searchString15" styleClass="forminput2">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>	
<html:select property="searchString8" styleClass="forminput2">
			<html:options collection="doctypes" property="documenttypeId" labelProperty="description"/>
</html:select>
<input type=button value="Print/Email" class="button1" id="Print" onclick="document.location.href='GenerateXdocument1.do?companyheaderId='+searchString15.options[searchString15.selectedIndex].value+'&amp;id='+form.id.value+'&amp;documenttypeId='+searchString8.options[searchString8.selectedIndex].value+'&amp;jobmovId=&amp;action=Print'"/>
</td>
</tr></form></table>          
                     
                    </td>
                  </tr>
                </table>
              </td>
        </tr>
            	
<!-- row3 -->
<tr><td colspan="11">						
<div id='div_<c:out value="${orderhdrLineItem.orderno}"/>' style='position:absolute; z-index:30; visibility: hidden; border: 1px solid #6683BA;'>
	  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          <tr>
            <td class="column-header1" width="10%">
              <bean:message key="heading.shipmethod"/>
            </td>
            <td class="column-header2" width="10%">
              <bean:message key="heading.voyage"/>
            </td>            
            <td class="column-header2" width="5%">
              <bean:message key="heading.by"/>
            </td>
            <td class="column-header2" width="10%">
              <bean:message key="heading.customerref"/>
            </td>            
            <td class="column-header2" width="10%">
              <bean:message key="heading.pickuplocation"/>
              </span> </td>
            <td class="column-header2" width="10%">
              <bean:message key="heading.deliverylocation"/>
            </td>  
            <td class="column-header2" width="15%">
              <bean:message key="heading.primaryproduct"/>
            </td>   
            <td class="column-header2" width="10%">
              <bean:message key="heading.quotenumber"/>
            </td>                                                 
          </tr>			
          <tr>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="shipmethod" filter="true"/>              
			  </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="shipvoyage" filter="true"/>
              </td>              
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="orderbyuserid" filter="true"/>
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="customerref" filter="true"/>&nbsp;
              </td>              
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="ldglocationkey1.shortName" filter="true"/>              
			  </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="dchlocationkey1.shortName" filter="true"/>              
</td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="productkey.tradname" filter="true"/>  
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="orderhdrLineItem" property="quotno" filter="true"/>&nbsp;              
              </td>                           
            </tr>  
</table>
</div>
</td></tr>			
<script language="JavaScript">
<!--	
MM_showHideLayers('div_<c:out value="${orderhdrLineItem.orderno}"/>','','hide');
-->
</script>			



                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>


</div>




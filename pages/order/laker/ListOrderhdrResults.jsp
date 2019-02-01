<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * NT	2013-10-16		201300024		Orderhdr List - remove 'FULLY INVOICED' check for 'View' link display
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






<div id="results" style="OVERFLOW:auto; position:absolute; left:230px; top:0px; width:1200px; height:650px; z-index:1; visibility: visible">


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
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditOrderhdrLaker.do?action=Create'">
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
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrderhdrLaker.do?orderBy=Orderno&gotoPage=0'">
										<span><bean:message key="heading.ordernumber"/></span>                        
										<logic:notEqual name="ListOrderhdrFormLaker" property="orderBy" scope="session" value="Orderno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrderhdrFormLaker" property="orderBy" scope="session" value="Orderno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        

		<td class="column-header2" width="8%">              
<span><bean:message key="heading.jobno"/></span>       
		</td> 
           
		<td class="column-header2" width="9%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListOrderhdrLaker.do?orderBy=Orderdate&gotoPage=0'">
										<span><bean:message key="heading.orderdate"/></span>                        
										<logic:notEqual name="ListOrderhdrFormLaker" property="orderBy" scope="session" value="Orderdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListOrderhdrFormLaker" property="orderBy" scope="session" value="Orderdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		                
        
		<td class="column-header2" width="11%">              
<span><bean:message key="heading.customer"/></span>       
		</td> 
                                
		<td class="column-header2" width="8%">              
<span><bean:message key="heading.portlocation"/></span>                        
		</td> 

		<td class="column-header2" width="8%">              
<span><bean:message key="heading.fromdate"/></span>                        
		</td> 

		<td class="column-header2" width="8%">              
<span><bean:message key="heading.todate"/></span>                        
		</td>              
              
		<td class="column-header2" width="9%">
<span><bean:message key="heading.vessel"/></span>                        
		</td> 

		<td class="column-header2" width="6%">
<span><bean:message key="heading.voyage"/></span>                        
		</td>
                                          
		<td class="column-header2" width="5%">
<span><bean:message key="heading.invoicestatus"/></span>                                      
        </td> 
              
		<td class="column-header2" width="5%">
<span><bean:message key="heading.completed"/></span>                                      
        </td> 
                                        
    	<td class="column-header3" width="15%" nowrap>&nbsp;</td>	
        
	</tr>  



<logic:notEmpty name="ListOrderhdrFormLaker" property="lineItems">

<%int row=0;%>

          <logic:iterate id="orderhdrLineItem" name="ListOrderhdrFormLaker" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%String _class2 = "column-cell5";if ((row % 2) == 0) _class2 = "column-cell6";%>
<%row++;%>
              
<!-- row1 -->
<tr>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="orderno" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="jobno" filter="true"/>
			</td>            
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="orderdate" format="dd-MMM-yyyy" filter="true"/>
			</td>

			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="customeraddrkey.shortname" filter="true"/>
			</td>                                   
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="ldglocationkey2.shortName" filter="true"/>             
			</td>

			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="ldgfromdate" format="dd-MMM-yyyy" filter="true"/>
			</td>          
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="ldgtodate" format="dd-MMM-yyyy" filter="true"/>
			</td>
            
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="shipvessel" filter="true"/>
			</td> 
			<td class="<%= _class2 %>" nowrap>
<bean:write name="orderhdrLineItem" property="shipvoyage" filter="true"/>
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

			</td>
                 
			<td class="<%= _class2 %>" nowrap align="center">
                      <c:if test="${orderhdrLineItem.completeflag=='true'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12"/>
                      </c:if>	
			</td>
                                    
			<td class="<%= _class2 %>" align="right" nowrap>    
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="10%" class="<%= _class2 %>" align="left" nowrap>

                          </td>
                          <td width="90%" class="<%= _class2 %>" align="right" nowrap>
                                                                         
<c:if test="${orderhdrLineItem.completeflag=='false'}"> 
	<html:link action="/EditOrderhdrLaker.do?action=Edit" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
		<bean:message key="prompt.edit"/> 
	</html:link>                                                                                    
</c:if> 
                       
<c:if test="${orderhdrLineItem.completeflag=='true'}"> <!--201300024--> 
	<html:link action="/EditOrderhdrLaker.do?action=View" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
		<bean:message key="prompt.view"/> 
	</html:link>                                                
</c:if>

                              <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span> 
	<html:link action="/EditOrderhdrLaker.do?action=Copy" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
		<bean:message key="prompt.copy"/> 
	</html:link>   
 
<c:if test="${orderhdrLineItem.completeflag=='false' and orderhdrLineItem.invoicestatus == 'NOT INVOICED'}"> 
                              <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span> 
	<html:link action="/EditOrderhdrLaker.do?action=Delete" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
		<bean:message key="prompt.delete"/> 
	</html:link>  
</c:if> 
                                                                           
                          </td>
                        </tr>
                      	</table>          																																										
			</td>
            
		</tr>	
													
<!-- row2 -->
<tr>
              <td colspan="12">
              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>			  
                    <td width="70%" class="<%= _class %>" nowrap>                    
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<td valign="top">                    

<html:link action="/ListOrderchargeLaker.do" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
<bean:message key="prompt.charges"/> 
</html:link>                      
                      
                     &nbsp;&nbsp;                       

<html:link action="/ListOrdercostLaker.do" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
<bean:message key="prompt.costs"/> 
</html:link> 

                        &nbsp;&nbsp;
                      
<html:link action="/ListOrderfileLaker.do" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
<bean:message key="prompt.documents"/> 
</html:link>                       
<c:if test="${orderhdrLineItem.documentsfound != '0'}">
<img src='images/icons/icon_stored_documents2_12_12.png' border='0' alt='Documents stored'/>
<html:link action="/ListOrderfileLaker.do" paramId="id" paramName="orderhdrLineItem" paramProperty="id">(<c:out value="${orderhdrLineItem.documentsfound}"/>)</html:link>
</c:if>

                      &nbsp;&nbsp;

<html:link action="/ListOrdersummaryLaker.do" paramId="id" paramName="orderhdrLineItem" paramProperty="id">
<bean:message key="prompt.financialsummary"/> 
</html:link> 
                                                      
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
<input type=button value="Print/Email" class="button1" id="Print" onclick="document.location.href='GenerateXdocument1Laker.do?companyheaderId='+searchString15.options[searchString15.selectedIndex].value+'&amp;id='+form.id.value+'&amp;documenttypeId='+searchString8.options[searchString8.selectedIndex].value+'&amp;jobmovId=&amp;action=Print'"/>
</td>
</tr></form></table>          
                     
                    </td>
                  </tr>
                </table>
              </td>
        </tr>
            	
			



                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>


</div>




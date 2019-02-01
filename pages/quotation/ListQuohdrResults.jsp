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


<table border="0" cellpadding="0" cellspacing="0" width="1180px" >



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
						<button id="addButton" class="btn btnFF" type="button" onClick="document.location.href='EditQuohdr.do?action=Create'">
        					<img class=" IM N-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Add</span>
        				</button>                                                  
					</div>
	</td></tr>
    <tr><td><img src="images/spacer.gif" height="3"/></td></tr>    
</table>

   
<!--  --> 
<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
	<tr>

		<td class="column-header1" width="8%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Quotno&gotoPage=0'">
										<span><bean:message key="heading.quotno"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Quotno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Quotno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Quotedate&gotoPage=0'">
										<span><bean:message key="heading.quotedate"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Quotedate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Quotedate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
             
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Effectivedate&gotoPage=0'">
										<span><bean:message key="heading.effectivedate"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Effectivedate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Effectivedate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>          
    
		<td class="column-header2" width="9%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Expirydate&gotoPage=0'">
										<span><bean:message key="heading.expirydate"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Expirydate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Expirydate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>           
		<td class="column-header2" width="5%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Quotebyuserid&gotoPage=0'">
										<span><bean:message key="heading.createdby"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Quotebyuserid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Quotebyuserid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="9%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Quotestatus&gotoPage=0'">
										<span><bean:message key="heading.status"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Quotestatus">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Quotestatus">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="20%">
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Customername&gotoPage=0'">
										<span><bean:message key="heading.customer"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Customername">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Customername">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>                
        </td>  
		<td class="column-header2" width="10%">
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListQuohdr.do?orderBy=Shipmethod&gotoPage=0'">
										<span><bean:message key="heading.shipmethod"/></span>                        
										<logic:notEqual name="ListQuohdrForm" property="orderBy" scope="session" value="Shipmethod">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListQuohdrForm" property="orderBy" scope="session" value="Shipmethod">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>                         
    	<td class="column-header3" width="19%" nowrap>&nbsp;</td>	
	</tr>  

  



<logic:notEmpty name="ListQuohdrForm" property="lineItems">

<%int row=0;%>

          <logic:iterate id="quohdrLineItem" name="ListQuohdrForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%String _class2 = "column-cell5";if ((row % 2) == 0) _class2 = "column-cell6";%>
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="quotno" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="quotedate" format="dd-MMM-yyyy" filter="true"/>
			</td>
            <td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="effectivedate" format="dd-MMM-yyyy" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="expirydate" format="dd-MMM-yyyy" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="quotebyuserid" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
                      <c:if test="${quohdrLineItem.quotestatus == 'PENDING'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${quohdrLineItem.quotestatus}"/>'/>
                      </c:if>
                      <c:if test="${quohdrLineItem.quotestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${quohdrLineItem.quotestatus}"/>'/>
                      </c:if>	
                      <c:if test="${quohdrLineItem.quotestatus == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${quohdrLineItem.quotestatus}"/>'/>
                      </c:if>						  				  			  
			  <bean:write name="quohdrLineItem" property="quotestatus" filter="true"/>
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="customeraddrkey.name" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class2 %>" nowrap>
<bean:write name="quohdrLineItem" property="shipmethod" filter="true"/>&nbsp;
			</td>            
			<td class="<%= _class2 %>" align="right" nowrap>    
                    <app:linkQuohdrLineItem page="/PrintQuotation.do">
                        <bean:message key="prompt.print"/>
                      </app:linkQuohdrLineItem>
                      <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
                      <c:if test="${quohdrLineItem.orderhdrsfound == 'false'}">
                        <app:linkQuohdrLineItem page="/EditQuohdr.do?action=Delete">
                          <bean:message key="prompt.delete"/>
                        </app:linkQuohdrLineItem>
                        <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span> </c:if>
                      <c:if test="${quohdrLineItem.quotestatus != 'APPROVED'}">
                        <app:linkQuohdrLineItem page="/EditQuohdr.do?action=Edit">
                          <bean:message key="prompt.edit"/>
                        </app:linkQuohdrLineItem>
                        <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span> </c:if>
                      <c:if test="${quohdrLineItem.quotestatus == 'APPROVED'}">
                        <app:linkQuohdrLineItem page="/EditQuohdr.do?action=View">
                          <bean:message key="prompt.view"/>
                        </app:linkQuohdrLineItem>
                        <span class="label5">&nbsp;&nbsp;|&nbsp;&nbsp;</span> </c:if>
                      <app:linkQuohdrLineItem page="/EditQuohdr.do?action=Copy">
                        <bean:message key="prompt.copy"/>
                      </app:linkQuohdrLineItem>            																																										
			</td>
		</tr>	
													
<!-- row2 -->
        <tr>
              <td colspan="9">
              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tr>
				  <td class="<%= _class %>" align="left" nowrap>
				  	<img src="images/icon_expand_12_12.png" width="12" height="12" align="middle" id="but_<c:out value="${quohdrLineItem.quotno}"/>" onclick="showHideDetails('div_<c:out value="${quohdrLineItem.quotno}"/>','but_<c:out value="${quohdrLineItem.quotno}"/>');"/>
				  </td>
				  <td class="<%= _class %>" align="left" nowrap>
				  <img src="images/spacer.gif" width="12" height="1"/>
				  </td>				  
                    <td width="70%" class="<%= _class %>" nowrap>                   
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<tr>
<td valign="top">                    
<c:if test="${quohdrLineItem.quotestatus != 'APPROVED'}">

                        <app:linkQuohdrLineItem page="/ListQuoprod.do">
                          <bean:message key="prompt.products"/>
                        </app:linkQuohdrLineItem>
&nbsp;&nbsp;                        
                        <app:linkQuohdrLineItem page="/ListQuocharge.do">
                          <bean:message key="prompt.charges"/>
                        </app:linkQuohdrLineItem>
&nbsp;&nbsp;                          
                        <app:linkQuohdrLineItem page="/ListQuomov.do">
                          <bean:message key="prompt.movements"/>
                        </app:linkQuohdrLineItem>
&nbsp;&nbsp;                         
                        <app:linkQuohdrLineItem page="/ListQuocost.do">
                          <bean:message key="prompt.costs"/>
                        </app:linkQuohdrLineItem>
                                         
</c:if>
&nbsp;&nbsp;  

                       <app:linkQuohdrLineItem page="/ListQuonote.do">
                          <bean:message key="prompt.notes"/>
                        </app:linkQuohdrLineItem> 
<c:if test="${quohdrLineItem.notesfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<app:linkQuohdrLineItem page="/ListQuonote.do">(<c:out value="${quohdrLineItem.notesfound}"/>)</app:linkQuohdrLineItem>
</c:if>                                 
&nbsp;&nbsp;                        
                        <app:linkQuohdrLineItem page="/ListQuonotecust.do">
                          <bean:message key="prompt.customernotes"/>
                        </app:linkQuohdrLineItem>
<c:if test="${quohdrLineItem.notecustsfound != '0'}">
<img src='images/icons/icon_entered_details_12_12.png' border='0' alt='Notes entered'/>
<app:linkQuohdrLineItem page="/ListQuonotecust.do">(<c:out value="${quohdrLineItem.notecustsfound}"/>)</app:linkQuohdrLineItem>
</c:if>                         
&nbsp;&nbsp;  
                      
                      <app:linkQuohdrLineItem page="/ListQuofile.do">
                        <bean:message key="prompt.documents"/>
                      </app:linkQuohdrLineItem> 
<c:if test="${quohdrLineItem.documentsfound != '0'}">
<img src='images/icons/icon_stored_documents2_12_12.png' border='0' alt='Documents stored'/>
<app:linkQuohdrLineItem page="/ListQuofile.do">(<c:out value="${quohdrLineItem.documentsfound}"/>)</app:linkQuohdrLineItem>
</c:if>  
                        &nbsp;&nbsp;                                          
                      <app:linkQuohdrLineItem page="/ListQuosummary.do">
                        <bean:message key="prompt.profitanalysis"/>
                      </app:linkQuohdrLineItem>
&nbsp;&nbsp;                   
                      <app:linkQuohdrLineItem page="/PrintQuosummary.do">
                        <bean:message key="prompt.profitanalysisprint"/>
                      </app:linkQuohdrLineItem>
&nbsp;&nbsp;                                    
                    <app:linkQuohdrLineItem page="/PrintCustomerQuotation.do">
                        <bean:message key="prompt.customerprint"/>
                      </app:linkQuohdrLineItem>                      
</td>
</tr></table>
                    </td>
                    <td class="<%= _class %>" width="30%" align="right" nowrap>
 <table width="100%" cellpadding="0" cellspacing="0" border="0">
<form><tr>
<td valign="top" nowrap>
<c:if test="${quohdrLineItem.quotestatus == 'APPROVED'}">
<html:hidden name="quohdrLineItem" property="id"/>
<html:select property="searchString7" styleClass="forminput2">
			<html:options collection="companyheaders" property="companyheaderId" labelProperty="headerName"/>	
</html:select>
<html:select property="searchString8" styleClass="forminput2">
			<html:option value="Quotationletter">Quotation Letter</html:option>		
</html:select>
<input type=button value="Print/Email" class="button1" id="Print" onclick="document.location.href='Edit'+searchString8.options[searchString8.selectedIndex].value+'.do?'+'companyheaderId='+searchString7.options[searchString7.selectedIndex].value+'&amp;orderhdrId='+form.id.value+'&amp;printId='+form.id.value+searchString8.options[searchString8.selectedIndex].value+'&refreshdata=N&action=Print'"/>
</c:if>
</td>
</tr></form></table> 
                     
                    </td>
                  </tr>
                </table>
              </td>
        </tr>
            	
<!-- row3 -->
<tr><td colspan="9">						
<div id='div_<c:out value="${quohdrLineItem.quotno}"/>' style='position:absolute; z-index:30; visibility: hidden; border: 1px solid #6683BA;'>
	  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          <tr>
            <td class="column-header1" width="20%">
              <bean:message key="heading.pickuplocation"/>
            </td>
            <td class="column-header2" width="20%">
              <bean:message key="heading.loadingport"/>
              </span> </td>
            <td class="column-header2" width="20%">
              <bean:message key="heading.dischargeport"/>
            </td>
            <td class="column-header2" width="20%">
              <bean:message key="heading.deliverylocation"/>
            </td>
            <td class="column-header2" width="20%">
              <bean:message key="heading.primaryproduct"/>
            </td>              
          </tr>			
          <tr>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="ldglocationkey1.shortName" filter="true"/>              
			  </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="ldglocationkey2.shortName" filter="true"/> 
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="dchlocationkey2.shortName" filter="true"/> 
              </td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="dchlocationkey1.shortName" filter="true"/>              
</td>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="quohdrLineItem" property="productkey.tradname" filter="true"/>  
              </td>
            </tr>  
</table>
</div>
</td></tr>			
<script language="JavaScript">
<!--	
MM_showHideLayers('div_<c:out value="${quohdrLineItem.quotno}"/>','','hide');
-->
</script>		



                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>


</div>




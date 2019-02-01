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

<html:form action="/SaveSalesinvoicebuild">

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
	<tr><td class="tdwht" valign="middle">			  
		<table width="40%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht" nowrap="nowrap"><bean:message key="heading.groupref"/>:&nbsp;<html:text property="searchString7" size="20" maxlength="20" styleClass="forminput1"/> 
                </td>
				<td class="tdwht" nowrap="nowrap">                
	<div class="btnPane3">                 
        		<button id="action" class="btnBG2 btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.create"/></span>
				 </button>          
	</div>	                         
				</td>
			</tr>
		</table>
	</td></tr>
</table>


   
<!--  --> 
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td class="column-header1" width="3%"> </td>    
		<td class="column-header1" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSibuild.do?orderBy=orderhdr.Orderno&gotoPage=0'">
										<span><bean:message key="heading.orderno"/></span>                        
										<logic:notEqual name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="orderhdr.Orderno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="orderhdr.Orderno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSibuild.do?orderBy=Orderdate&gotoPage=0'">
										<span><bean:message key="heading.orderdate"/></span>                        
										<logic:notEqual name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="Orderdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="Orderdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSibuild.do?orderBy=Chargekey&gotoPage=0'">
										<span><bean:message key="heading.charge"/></span>                        
										<logic:notEqual name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="Chargekey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="Chargekey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>          
        
		<td class="column-header2" width="30%">              
										<span><bean:message key="heading.billingaccount"/></span>
		</td>           
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListSibuild.do?orderBy=Invoiceccykey&gotoPage=0'">
										<span><bean:message key="heading.invoiceccy"/></span>                        
										<logic:notEqual name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="Invoiceccykey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListSalesinvoicebuildForm" property="orderBy" scope="session" value="Invoiceccykey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="10%">              
										<span><bean:message key="heading.xratetoinv"/></span>                        
		</td>        
		<td class="column-header2" width="10%">
										<span><bean:message key="heading.invoiceamt"/></span>                               
        </td>                       
	</tr>  

  



<logic:notEmpty name="ListSalesinvoicebuildForm" property="lineItems">

<%int row=0;%>

          <logic:iterate id="lineItem" name="ListSalesinvoicebuildForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>        
<html:multibox property="selectedObjects"><bean:write name="lineItem" property="orderchargeId" /></html:multibox>                        <html:hidden name="lineItem" property="invoicestatus" />
            </td>                    
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="orderno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="orderdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="charge.chargekey" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="customer.name" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="invoiceccykey" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap align="right">
 &nbsp;<fmt:formatNumber 
							type="number"
							value="${lineItem.xrateinv}"
							maxFractionDigits="4"
							minFractionDigits="6"
							/>           
            </td>            
			<td class="<%= _class %>" nowrap align="right">
                      &nbsp;<fmt:formatNumber 
							type="number"
							value="${lineItem.chgamtinv}"
							maxFractionDigits="2"
							minFractionDigits="2"
							/>
			</td>   

		</tr>	



                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                







  
  </td>
  </tr>
  
  
  
</table>
</html:form>

</div>




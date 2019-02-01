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








<div id="results" style="OVERFLOW:auto; position:absolute; left:220px; top:0px; width:1180px; height:650px; z-index:10; visibility: visible">

<html:form action="/SaveDibuild">

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


<input type="hidden" name="action" id="form-action" />

<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="70%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht" align="right">&nbsp;&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht" nowrap="nowrap"><bean:message key="prompt.selectall"/>&nbsp;<html:checkbox name="ListDemurrageinvoicebuildForm" property="searchString15" />
                </td>
                <td class="tdwht">&nbsp;to&nbsp;</td>
                
				<td class="tdwht" nowrap="nowrap">                
	<div class="btnPane3">                 
        		<button class="btnBG2 btnFF" value='Process' type="submit" onClick="document.getElementById('form-action').value='Process'">
                				    <img class=" IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.process"/></span>
				 </button></div>	                         
				</td>
                <td class="tdwht">&nbsp;Group Ref:<html:text property="searchString7" size="10" maxlength="20" styleClass="ftforminputsmall"/></td>                
                
                <td class="tdwht">&nbsp;or&nbsp;</td>
				<td class="tdwht" nowrap="nowrap">                
	<div class="btnPane3">                 
        		<button class="btnBG2 btnFF" value='Close' type="submit" onClick="document.getElementById('form-action').value='Close'">
                				    <img class=" IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.close"/></span>
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
		<td class="column-header1" width="8%">              
<span><bean:message key="heading.jobno"/></span>
		</td>          
		<td class="column-header2" width="8%">              
<span><bean:message key="heading.orderno"/></span>
		</td>   
        <td class="column-header2" width="8%">              
<span><bean:message key="heading.unit"/></span>
		</td>                  
		<td class="column-header2" width="10%">              
<span>Dmrg From Date</span>
		</td>           
		<td class="column-header2" width="10%">              
<span>Dmrg To Date</span>
		</td>        
		<td class="column-header2" width="8%" align="right">              
<span>Dmrg Free Days</span>                        
		</td>        
		<td class="column-header2" width="10%">
<span><bean:message key="heading.billingaccount"/></span>                               
        </td>   
		<td class="column-header2" width="10%">
<span>Inv Start Date</span>                               
        </td>   
		<td class="column-header2" width="10%">
<span>Inv End Date</span>                               
        </td>   
		<td class="column-header2" width="8%" align="right">
<span>Inv Days</span>                               
        </td>  
		<td class="column-header2" width="8%">
<span>Inv Ccy</span>                               
        </td> 
		<td class="column-header2" width="10%" align="right">
<span>Inv Amount</span>                               
        </td>                                                              
	</tr>  

  



<logic:notEmpty name="ListDemurrageinvoicebuildForm" property="lineItems">

<%int row=0;%>

                  <logic:iterate id="lineItem" name="ListDemurrageinvoicebuildForm" property="lineItems">
          
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>          
<%row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" nowrap>        
<html:multibox property="selectedObjects"><bean:write name="lineItem" property="jobmovId1" /></html:multibox>
                        &nbsp;
                        <html:hidden name="lineItem" property="jobmovId1" />
						<html:hidden name="lineItem" property="jobmovId2" />
            </td>                    
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="jobno" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="orderno" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="unit" filter="true"/>&nbsp;
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="fromdate" format="dd-MMM-yyyy" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="todate" format="dd-MMM-yyyy" filter="true"/>&nbsp;
			</td>
            <td class="<%= _class %>" nowrap align="right">
<bean:write name="lineItem" property="freeDays" filter="true"/>         
            </td>            
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="dmrgbilltoaddr.name" filter="true"/>
			</td>   
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="demStartDate" format="dd-MMM-yyyy" filter="true"/>
			</td>  
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="demEndDate" format="dd-MMM-yyyy" filter="true"/>
			</td>  
			<td class="<%= _class %>" nowrap align="right">
<bean:write name="lineItem" property="demurragePrintTotalDays" filter="true"/>
			</td>  
			<td class="<%= _class %>" nowrap>
<bean:write name="lineItem" property="ccykey" filter="true"/>
			</td>  
			<td class="<%= _class %>" nowrap align="right">
<fmt:formatNumber 
							type="number"
							value="${lineItem.demAmountTotal}"
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




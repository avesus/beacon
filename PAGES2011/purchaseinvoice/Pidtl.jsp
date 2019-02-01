<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
  
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->

  
<!-- init extra property methods -->
<%--<bean:define id="vendorjobs" name="PidtlForm" property="vendorjobs"/>--%>

<app:checkLogon/>


<html:html>
<head>


<logic:equal name="PidtlForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="pidtl.title.create"/></title>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="pidtl.title.delete"/></title>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="pidtl.title.edit"/></title>
</logic:equal>	
<logic:equal name="PidtlForm" property="action"
            scope="session" value="View">
  <title><bean:message key="pidtl.title.view"/></title>
</logic:equal>

	
<link rel="stylesheet" type="text/css" href="css/base.css" />


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( document.forms[0].action.value == 'View') {
			while (i < document.forms[0].elements.length) {
				document.forms[0].elements[i].disabled = true;
				i++;	
			}
			}
		}
</script>






</head>


<body onUnload="if (searchWin != null) {searchWin.close();}">  

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
 
	<td class="tdwht">
	  <span class="heading2"><html:link action="/ListPihdr"><bean:message key="pihdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListPidtl"><bean:message key="pidtl.title.list"/></html:link></span>
	<span class="text6">&gt;</span>    
	<span class="heading2">
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Create">
  <bean:message key="pidtl.title.create"/>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Delete">
  <bean:message key="pidtl.title.delete"/>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Edit">
  <bean:message key="pidtl.title.edit"/>
</logic:equal>	
<logic:equal name="PidtlForm" property="action"
            scope="session" value="View">
  <bean:message key="pidtl.title.view"/>
</logic:equal>
</span> 
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>

	
	<td>
	
		<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="90%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SavePidtl" focus="jobno">
	
<html:hidden property="pidtlId"/>
<html:hidden property="pihdrId"/>
<html:hidden property="action"/>
<html:hidden property="copyId"/>
<html:hidden property="invoicestatus"/>



<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Create">
  <bean:message key="pidtl.title.create"/>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Delete">
  <bean:message key="pidtl.title.delete"/>
</logic:equal>
<logic:equal name="PidtlForm" property="action"
            scope="session" value="Edit">
  <bean:message key="pidtl.title.edit"/>
</logic:equal>	
<logic:equal name="PidtlForm" property="action"
            scope="session" value="View">
  <bean:message key="pidtl.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="PidtlForm" property="action"
                     scope="session" value="Delete"> 

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.jobno"/>:
		  </td>
                <TD class="td9" width="90%">		  
	<html:text property="jobno" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>                
	<html:hidden property="jobno"/>	  				
		  </td>  
		</tr>	 								
    </table>
	</td>
  </tr>	
  					 
  			  
</logic:equal>		


<logic:notEqual name="PidtlForm" property="action"
                     scope="session" value="Delete">  


<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td class="td9" align="left" width="50%">

<c:if test="${PidtlForm.action == 'Create'}">	
	<select name="jobno" class="ftforminputsmall" onChange="defaultCstamttotal();" size="5">
		<option selected value=""><bean:message key="prompt.selectajob"/></option>
<logic:iterate id="lineItemX" name="PidtlForm" property="vendorjobs" indexId="loopX">           
<%
com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO jobcost = 
	(com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO)lineItemX;
%>	
		<option value="<%= jobcost.getJobno() %>"><bean:message key="prompt.jobno"/>: <%= jobcost.getJobno() %> > <bean:message key="prompt.orderno"/>: <%= jobcost.getOrderno() %></option>	
</logic:iterate>
                
	</select>	
</c:if>		
<c:if test="${PidtlForm.action != 'Create'}">			  
<%--		<html:select property="jobno" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectajob"/></html:option> 
		<html:options collection="vendorjobs" property="jobno" labelProperty="jobno"/>
		</html:select> --%>
<bean:message key="prompt.jobno"/>:&nbsp;<html:text property="jobno" disabled="true" size="10" maxlength="10" styleClass="ftforminputsmall"/>                
	<html:hidden property="jobno"/>	    
</c:if>					
		  </td>  
          
          <td  width="50%" class="td9">
<bean:message key="prompt.invoiceamt"/>:&nbsp;<html:text property="invoiceamt" size="10" maxlength="10" styleClass="ftforminputsmall"/>             
          </td>	 
                    
          
		</tr>	  								
    </table>
	</td>
  </tr>
  
	
    
<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.text"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%">&nbsp; 
        <html:textarea rows="5" cols="110" property="txt1" styleClass="ftforminputsmall"/>
			</td>
              </tr>
    </table></td>
  </tr>		

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9"> 
		  <strong>Costs already allocated to Job</strong> &nbsp;                 
</td>
</tr>
<tr>
          <td class="td9" width="100%" align="center">
          
<table width="70%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#cccccc">
				<tr>		
		  			<td class="purchaseorderResultsHeader" width="60%">
					<bean:message key="prompt.cost"/></td>                    
		  			<td class="purchaseorderResultsHeader" width="20%">
					<bean:message key="prompt.estimatecost"/></td>
		  			<td class="purchaseorderResultsHeader" width="20%" align="right">
					<bean:message key="prompt.actualcost"/></td>																	
				</tr>

			<c:forEach var="lineItem" items="${PidtlForm.pidtlcosts}" varStatus="loop">
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry3"/>				
				</c:if>
  				<tr>			
					<td class='<c:out value="${_class}"/>'>
						<c:out value="${lineItem.costkey.descr}"/>						
					</td> 	
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.cstamttotal}"/>					
					</td> 
					<td class='<c:out value="${_class}"/>' align="right">
						<c:out value="${lineItem.cstamtalloc}"/>						
					</td> 			
				</tr>	
			</c:forEach>			
			</table>
		</td>
	</tr>
</table>

		</td>
       </tr>
    </table>
	</td>
</tr>

  
  		
</logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">

<logic:notEqual name="PidtlForm" property="action" scope="session" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="PidtlForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="PidtlForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="PidtlForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="PidtlForm" property="action" scope="session" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
  
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">	  
	
	</td>
	
  </tr>	
  
</logic:notEqual> 
		  
    </table></td>
  </tr>
  
</table>

</td></tr></table>
</td></tr></table>
</html:form>

</td>
</tr>
</table>

</div>
</td>
</tr>



<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>

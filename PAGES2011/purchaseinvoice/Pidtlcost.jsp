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
<%--<bean:define id="vendorjobcosts" name="PidtlcostForm" property="vendorjobcosts"/>--%>





<app:checkLogon/>


<html:html>
<head>


<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="pidtlcost.title.create"/></title>
</logic:equal>
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="pidtlcost.title.delete"/></title>
</logic:equal>
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="pidtlcost.title.edit"/></title>
</logic:equal>	
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="View">
  <title><bean:message key="pidtlcost.title.view"/></title>
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


<script type="text/javascript" language="javascript">
function defaultCstamttotal(){
	var fields = document.forms[0].elements['costkey'].value.split("|");
	//default cst amount to field
  	document.forms[0].elements['cstamttotal'].value = fields[1];
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
	  <span class="heading2"><html:link action="/ListPidtlcost"><bean:message key="pidtlcost.title.list"/></html:link></span>
	<span class="text6">&gt;</span>    
	<span class="heading2">
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Create">
  <bean:message key="pidtlcost.title.create"/>
</logic:equal>
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Delete">
  <bean:message key="pidtlcost.title.delete"/>
</logic:equal>
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Edit">
  <bean:message key="pidtlcost.title.edit"/>
</logic:equal>	
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="View">
  <bean:message key="pidtlcost.title.view"/>
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

<html:form action="/SavePidtlcost" focus="costkey">
	
<html:hidden property="pidtlId"/>
<html:hidden property="pidtlcostId"/>
<html:hidden property="vendoraddrkey"/>
<html:hidden property="ccykey"/>
<html:hidden property="action"/>




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
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Create">
  <bean:message key="pidtlcost.title.create"/>
</logic:equal>
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Delete">
  <bean:message key="pidtlcost.title.delete"/>
</logic:equal>
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="Edit">
  <bean:message key="pidtlcost.title.edit"/>
</logic:equal>	
<logic:equal name="PidtlcostForm" property="action"
            scope="session" value="View">
  <bean:message key="pidtlcost.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="PidtlcostForm" property="action"
                     scope="session" value="Delete"> 

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.cost"/>:
		  </td>
                <TD class="td9" width="90%">		  
       <html:text property="costkey" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/> 				
		  </td>  
		</tr>	 								
    </table>
	</td>
  </tr>	
  					 
  			  
</logic:equal>		


<logic:notEqual name="PidtlcostForm" property="action"
                     scope="session" value="Delete">  


<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.cost"/>:
		  </td>
                <TD class="td9" width="90%">
                
		 <c:if test="${PidtlcostForm.action == 'Create'}">			         
	<select name="costkey" class="ftforminputsmall" onChange="defaultCstamttotal();">
		<option selected value=""><bean:message key="prompt.selectacost"/></option>
<logic:iterate id="lineItemX" name="PidtlcostForm" property="vendorjobcosts" indexId="loopX">           
<%
com.bureaueye.beacon.model.job.dto.JobcostDTO jobcost = 
	(com.bureaueye.beacon.model.job.dto.JobcostDTO)lineItemX;
%>	
		<option value="<%= jobcost.getJobcostId() %>|<%= jobcost.getCstamt() %>"><%= jobcost.getCostkey().getCostkey() %></option>	
</logic:iterate>
                
	</select>		
        </c:if>	
        	
		<c:if test="${PidtlcostForm.action != 'Create'}">			  
       <html:text property="costkey" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/> 	
		<html:hidden property="costkey"/>	
		</c:if>					
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
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.actualcost"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="cstamtalloc" size="10" maxlength="10" styleClass="ftforminputsmall"/>             
          </td>	  
        </tr>		
        
        <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.estimatecost"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="cstamttotal" size="10" disabled="true" maxlength="10" styleClass="ftforminputsmall"/>            
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

			<c:forEach var="lineItem" items="${PidtlcostForm.pidtlcosts}" varStatus="loop">
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

<logic:notEqual name="PidtlcostForm" property="action" scope="session" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="PidtlcostForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="PidtlcostForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="PidtlcostForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="PidtlcostForm" property="action" scope="session" value="Delete"> 
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

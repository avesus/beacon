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

<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/contract/ListContractAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/contract/ListContracteqpAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/contract/ListContracteqplocAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/contract/FindContracteqpByIdAjax.js"></script>
  
<app:checkLogon/>


<html:html>
<head>

<script language="JavaScript">
var searchWin;

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
		
	
</script>  
  
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
					
			processListcontract();
		}
</script>


	  

<logic:equal name="OnhireForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OnhireForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OnhireForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OnhireForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="onhire.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListOnhire" styleClass="link4">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
			<span class="text6"><strong>
				<bean:message key="title.maintenance"/> 	
			</strong></span> 						
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveOnhire" focus="onhireno">
<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="readonly"/>
<html:hidden property="copyId"/>

<html:hidden property="comments"/>
<html:hidden property="createuserid"/>



<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="OnhireForm" property="action"
            scope="request" value="Create">
  <bean:message key="onhire.title.create"/>
</logic:equal>
<logic:equal name="OnhireForm" property="action"
            scope="request" value="Delete">
  <bean:message key="onhire.title.delete"/>
</logic:equal>
<logic:equal name="OnhireForm" property="action"
            scope="request" value="Edit">
  <bean:message key="onhire.title.edit"/>
</logic:equal>
<logic:equal name="OnhireForm" property="action"
            scope="request" value="View">
  <bean:message key="onhire.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		


    <logic:equal name="OnhireForm" property="action"
                     scope="request" value="Delete">  
					 
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.onhireno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="onhireno" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	
	</logic:equal>
	
	
	
  
       <logic:notEqual name="OnhireForm" property="action"
                     scope="request" value="Delete">  
					 
  <tr>
    <td width="100%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">  				
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="60" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.onhireno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${OnhireForm.action == 'Create'}">
        	<html:text property="onhireno" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${OnhireForm.action != 'Create'}">
        	<html:text property="onhireno" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="onhireno"/>			
		  </c:if>		   
          </td>
        </tr>	
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.submitteddate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${OnhireForm.action == 'Create'}">		  
		<html:select property="submitteddatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="submitteddatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="submitteddateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
		  </c:if>
		  <c:if test="${OnhireForm.action != 'Create'}">  
			<bean:write name="OnhireForm" property="submitteddate" format="dd-MMM-yyyy" filter="true"/>
			<html:hidden property="submitteddatedd"/>
			<html:hidden property="submitteddatemm"/>
			<html:hidden property="submitteddateyyyy"/>				
		  </c:if>			  		 	  
          </td>
        </tr>			
        <tr>
          <td width="20%" class="td9"> 
		  <div align="right">
		        <bean:message key="prompt.submittedby"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${OnhireForm.action == 'Create'}">		  
              <html:select property="submittedby" styleClass="ftforminputsmall">
                <html:option value=""><bean:message key="prompt.selectauserid"/></html:option>
                <html:options collection="users" property="userid" labelProperty="name"/>
              </html:select>
		  </c:if>
		  <c:if test="${OnhireForm.action != 'Create'}">  
        	<bean:write property="submittedby" name="OnhireForm"/>
			<html:hidden property="submittedby"/>	
		  </c:if>			  				  	 
          </td>
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.releasereference"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">		  
        	<html:text property="releaseref" size="20" maxlength="40" styleClass="ftforminputsmall"/>			 	  
          </td>
        </tr>		
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.estreldate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">		  
		<html:select property="estreldatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="estreldatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="estreldateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>		 	  
          </td>
        </tr>																			
    </table>	
	</td>
  </tr>						 
  
  					 			 
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">  
        <tr>
			<td rowspan="3">
				<img src="images/spacer.gif" height="60" width="1" border="0"/>
			</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.lessee"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${OnhireForm.action == 'Create'}">  
		<html:select property="lesseeaddrkey" onchange="processListcontract();" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalessee"/></html:option>
			<html:options collection="lessees" property="addrkey" labelProperty="name"/>	
		</html:select>	
		  </c:if>
		  <c:if test="${OnhireForm.action != 'Create'}">  
		<html:select property="lesseeaddrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalessee"/></html:option>
			<html:options collection="lessees" property="addrkey" labelProperty="name"/>	
		</html:select>	
		<html:hidden property="lesseeaddrkey"/>
		  </c:if>		  										  
          </td>	  
      </tr>
      <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.contractno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${OnhireForm.action == 'Create'}">  		  
			<html:select property="contractId" styleClass="ftforminputsmall" onchange="processListcontracteqp();">
				<html:option value=""><bean:message key="prompt.selectacontract"/></html:option>
			</html:select>
		  </c:if>	
		  <c:if test="${OnhireForm.action != 'Create'}">  		  		  
        	<bean:write property="contractno_" name="OnhireForm"/>
			<html:hidden property="contractId"/>				
		  </c:if>		  					  
          </td>	  
      </tr>		
      <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.equipmentparameters"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  <c:if test="${OnhireForm.action == 'Create'}"> 		  
		<html:select property="contracteqpId" styleClass="ftforminputsmall" onchange="processFindcontracteqpbyid();processListcontracteqploc();">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
		</html:select>
		  </c:if>	
		  <c:if test="${OnhireForm.action != 'Create'}">  		  
        	<bean:write property="eqpkeyp1_" name="OnhireForm"/>/<bean:write property="eqpkeyp2_" name="OnhireForm"/>
			<html:hidden property="contracteqpId"/>				
		  </c:if>	  			
          </td>	  
       </tr>											
    </table>
	</td>
  </tr> 	   	


<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">  
      <tr>
			<td rowspan="3">
				<img src="images/spacer.gif" height="20" width="1" border="0"/>
			</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.mindays"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="mindays" size="10" maxlength="5" styleClass="ftforminputsmall"/>		 
          </td>	  
      </tr>  
      <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.freedays"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="freedays" size="10" maxlength="5" styleClass="ftforminputsmall"/>  					            </td>	  
      </tr>	
      <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.location"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		  	<c:if test="${OnhireForm.action == 'Create'}"> 		  
				<html:select property="contracteqplocId" styleClass="ftforminputsmall">
          			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
       			</html:select>  	
			</c:if>	
		  	<c:if test="${OnhireForm.action != 'Create'}">  		  
		<html:select property="locationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="locationName"/>	
		</html:select>	
				<html:hidden property="contracteqplocId"/>	
				<html:hidden property="locationkey"/>			
		  	</c:if>			
		</td>	  
      </tr>		  											
    </table>
	</td>
  </tr>   	  
    	
		
<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.specialinstructions"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:textarea rows="5" cols="110" property="notes" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>		
  

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.other"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:textarea rows="5" cols="110" property="other" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>
    
  		
  </logic:notEqual>
  
  
<!--buttons-->
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="onhireBgcolor">
	
<logic:notEqual name="OnhireForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="OnhireForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="OnhireForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="OnhireForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="OnhireForm" property="action" scope="request" value="Delete"> 
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

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

  
<app:checkLogon/>


<html:html>
<head>


<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
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
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="contracteqp.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListContract" styleClass="link4">
				<bean:message key="contract.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">	
			<html:link action="/ListContracteqp" styleClass="link4">
				<bean:message key="contracteqp.title.list"/>	
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
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveContracteqp" focus="eqpkeyp1">
	
<html:hidden property="contracteqpId"/>
<html:hidden property="contractId"/>
<html:hidden property="action"/>
<html:hidden property="copyId"/>



<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="ContracteqpForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="ContracteqpForm" property="action"
                     scope="request" value="Delete"> 
					 
<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.equipmentparameters"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		<html:select property="eqpkeyp1" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>				 
				</TD>
              </TR>
              <TR> 
                <TD class="td9" width="10%" align="right"></TD>
                <TD class="td9" width="90%">
		<html:select property="eqpkeyp2" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
				</TD>
              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>		
  			  
</logic:equal>		


<logic:notEqual name="ContracteqpForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%">
		        &nbsp;<strong><bean:message key="prompt.equipmentparameters"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		  <c:if test="${ContracteqpForm.action == 'Create'}">				
		<html:select property="eqpkeyp1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>	
		  </c:if>
		  <c:if test="${ContracteqpForm.action != 'Create'}">
		<html:select property="eqpkeyp1" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>		  
			<html:hidden property="eqpkeyp1"/>			
		  </c:if>					 
				</TD>
              </TR>
              <TR> 
                <TD class="td9" width="5%" align="right"></TD>
                <TD class="td9" width="85%">
		  <c:if test="${ContracteqpForm.action == 'Create'}">				
		<html:select property="eqpkeyp2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>	
		  </c:if>
		  <c:if test="${ContracteqpForm.action != 'Create'}">
		<html:select property="eqpkeyp2" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>		  
			<html:hidden property="eqpkeyp2"/>			
		  </c:if>
				</TD>
              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
	

	
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="1" cellpadding="0"class="contractBgcolor">
       <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%" colspan="2">
		        &nbsp;<strong><bean:message key="prompt.days"/></strong>
		  </td>
		</tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.freedays"/>: </td>
	<td class="td9"><html:text property="freedays" size="10" maxlength="10" styleClass="ftforminputsmall"/></td>
  </tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.mindays"/>: </td>
	<td class="td9"><html:text property="mindays" size="10" maxlength="10" styleClass="ftforminputsmall"/></td>
  </tr>  
            </table>
			</td>
              </tr>

  
  
				
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="1" cellpadding="0"class="contractBgcolor">
        <tr>				  
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td9" width="100%" colspan="2">
		        &nbsp;<strong><bean:message key="prompt.rates"/></strong>
		  </td>		
        </tr>		  		  
  <tr>
    <td class="td9" width="20%"><bean:message key="prompt.fixed"/>:</td>
    <td class="td9">
        <html:text property="fixdlyrat" size="10" maxlength="10" styleClass="ftforminputsmall"/>  	
    </td>
  </tr>
  
  
  <tr>
    <td valign="top" class="td9"> <bean:message key="prompt.variable"/>:</td>
    <td class="td9">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td class="td9" width="5%"> 1. </td>
        <td class="td9" width="10%"><div align="right"><bean:message key="prompt.fromday"/>: </div></td>		
        <td class="td9" width="10%">
		        <html:text property="fromday1" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9" width="10%"><div align="right"><bean:message key="prompt.today"/>: </div></td>
        <td class="td9" width="10%">
		        <html:text property="today1" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9" width="10%"><div align="right"><bean:message key="prompt.rate"/>: </div></td>
        <td class="td9" width="10%">
		        <html:text property="rate1" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
      </tr>
      <tr>
        <td class="td9"> 2. </td>
        <td class="td9"><div align="right"><bean:message key="prompt.fromday"/>: </div></td>		
        <td class="td9" width="13%">
		        <html:text property="fromday2" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.today"/>: </div></td>
        <td class="td9" width="13%">
		        <html:text property="today2" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.rate"/>: </div></td>
        <td class="td9" width="33%">
		        <html:text property="rate2" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
      </tr>
      <tr>
        <td class="td9"> 3. </td>
        <td class="td9"><div align="right"><bean:message key="prompt.fromday"/>: </div></td>		
        <td class="td9" width="13%">
		        <html:text property="fromday3" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.today"/>: </div></td>
        <td class="td9" width="13%">
		        <html:text property="today3" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.rate"/>: </div></td>
        <td class="td9" width="33%">
		        <html:text property="rate3" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
      </tr>
      <tr>
        <td class="td9"> 4. </td>
        <td class="td9"><div align="right"><bean:message key="prompt.fromday"/>: </div></td>		
        <td class="td9" width="13%">
		        <html:text property="fromday4" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.today"/>: </div></td>
        <td class="td9" width="13%">
		        <html:text property="today4" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.rate"/>: </div></td>
        <td class="td9" width="33%">
		        <html:text property="rate4" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
      </tr>	  
      <tr>
        <td class="td9"> 5. </td>
        <td class="td9"><div align="right"><bean:message key="prompt.fromday"/>: </div></td>		
        <td class="td9" width="13%">
		        <html:text property="fromday5" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.today"/>: </div></td>
        <td class="td9" width="13%">
		        <html:text property="today5" size="5" maxlength="5" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.rate"/>: </div></td>
        <td class="td9" width="33%">
		        <html:text property="rate5" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
      </tr>		  	  	  
</table>
	</td>
  </tr>
  <tr>
    <td class="td9" width="20%"> <bean:message key="prompt.earlyreturnoption"/>: </td>
	<td class="td9">
	<table width="80%" border="0" cellpadding="0" cellspacing="0">
      <tr>
    <td class="td9"><div align="right"><bean:message key="prompt.days"/>: </div></td>	  
        <td class="td9">
				        <html:text property="erodays" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.newrate"/>: </div></td>
        <td class="td9">
						<html:text property="erorate" size="10" maxlength="10" styleClass="ftforminputsmall"/>
        </td>
        <td class="td9"><div align="right"><bean:message key="prompt.increase"/>: </div></td>
        <td class="td9">
						<html:text property="eroincrease" size="10" maxlength="10" styleClass="ftforminputsmall"/>		
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
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"class="contractBgcolor">

<logic:notEqual name="ContracteqpForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="ContracteqpForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="ContracteqpForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="ContracteqpForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="ContracteqpForm" property="action" scope="request" value="Delete"> 
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

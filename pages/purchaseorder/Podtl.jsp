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


<logic:equal name="PodtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="PodtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="PodtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="PodtlForm" property="action"
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




<script type="text/javascript" language="javascript">
function amtCalc() 
{
	var _qty = parseFloat(document.forms[0].qty.value);
	if (_qty == 0) _qty = 1.00;
	var _rateamt = parseFloat(document.forms[0].rateamt.value);

	document.forms[0].totalamt.value = (_qty*_rateamt);
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
	<td class="tdwht">
	<span class="heading2"><strong><bean:message key="podtl.title"/></strong></span>
	<span class="heading2"><html:link action="/ListContract" styleClass="link4"><bean:message key="pohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListPodtl" styleClass="link4"><bean:message key="podtl.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="text6"><strong><bean:message key="title.maintenance"/></strong></span>
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

<table border="0" cellpadding="5" cellspacing="5" width="90%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SavePodtl" focus="txt1" onsubmit="return amtCalc();">
	
<html:hidden property="podtlId"/>
<html:hidden property="pohdrId"/>
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
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="PodtlForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="PodtlForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="PodtlForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="PodtlForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="PodtlForm" property="action"
                     scope="request" value="Delete"> 

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.description"/></strong> &nbsp;
		  </td>
		</tr>	
             <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9" width="10%">&nbsp;</TD>
                <TD class="td9" width="90%">		  
        		<html:text property="txt1" disabled="true" size="100" maxlength="100" styleClass="ftforminputsmall"/>	
			</TD>
			</TR>
			</table>					
		  </td>  
		</tr>	 								
    </table>
	</td>
  </tr>	
  					 
  			  
</logic:equal>		


<logic:notEqual name="PodtlForm" property="action"
                     scope="request" value="Delete">  


<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.description"/></strong> &nbsp;
		  </td>
		</tr>	
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9" width="10%">&nbsp;</TD>
                <TD class="td9" width="90%">
		 	<c:if test="${PodtlForm.action == 'Create'}">			  
        		<html:text property="txt1" size="100" maxlength="100" styleClass="ftforminputsmall"/>	
			</c:if>		
		 	<c:if test="${PodtlForm.action != 'Create'}">			  
        		<html:text property="txt1" disabled="true" size="100" maxlength="100" styleClass="ftforminputsmall"/>
				<html:hidden property="txt1"/>	
			</c:if>
			</TD>
			</TR>
			</table>					
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>
  
	
	
   <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">  
        <tr>
	<td rowspan="6">
		<img src="images/spacer.gif" height="80" width="1" border="0"/>
	</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.quantity"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="qty" onblur="amtCalc();" size="10" maxlength="10" styleClass="ftforminputsmall"/>  
          </td>	  
        </tr>		
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.glcode"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="glcode1" size="10" maxlength="10" styleClass="ftforminputsmall"/>	  				  							
          </td>	    
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.rate"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="rateamt" onblur="amtCalc();" size="10" maxlength="10" styleClass="ftforminputsmall"/>				  							
          </td>	    
        </tr>	
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.total"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="totalamt" readonly="true" size="15" maxlength="15" styleClass="ftforminputsmall"/>				  							
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
		        &nbsp;<strong><bean:message key="prompt.equipmentparameters"/></strong>
		  </td>
		</tr>				
              <tr> 
                <td class="td9" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td9">&nbsp;</TD>
                <TD class="td9">
		<html:select property="eqpkeyp1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>				 
				</TD>
              </TR>
              <TR> 
                <TD class="td9" width="10%" align="right"></TD>
                <TD class="td9" width="90%">
		<html:select property="eqpkeyp2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
				</TD>
              </TR>
              <TR> 
                <TD class="td9" align="right"></TD>
                <TD class="td9">
		<html:select property="eqpkeyp3" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp3s" property="id.codekey" labelProperty="descr"/>
		</html:select>
				</TD>
              </TR>		
              <TR> 
                <TD class="td9" align="right"></TD>
                <TD class="td9">
		<html:select property="eqpkeyp4" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp4s" property="id.codekey" labelProperty="descr"/>
		</html:select>
				</TD>
              </TR>		
              <TR> 
                <TD class="td9" align="right"></TD>
                <TD class="td9">
		<html:select property="eqpkeyp5" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp5s" property="id.codekey" labelProperty="descr"/>
		</html:select>
				</TD>
              </TR>			  	  	  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>		
  
  		
</logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="purchaseorderBgcolor">

<logic:notEqual name="PodtlForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="PodtlForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="PodtlForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="PodtlForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="PodtlForm" property="action" scope="request" value="Delete"> 
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

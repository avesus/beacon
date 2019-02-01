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

<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
		}
</script>



<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="orderprod.title.create"/></title>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="orderprod.title.delete"/></title>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="orderprod.title.edit"/></title>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="View">
  <title><bean:message key="orderprod.title.view"/></title>
</logic:equal> 


<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
 
	<td class="tdwht">
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListOrderprod"><bean:message key="orderprod.title.list"/></html:link></span>  
	<span class="text6">&gt;</span>
	<span class="heading2">
    <logic:equal name="OrderprodForm" property="action"
            scope="session" value="Create">
  <bean:message key="orderprod.title.create"/>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Delete">
  <bean:message key="orderprod.title.delete"/>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Edit">
  <bean:message key="orderprod.title.edit"/>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="View">
  <bean:message key="orderprod.title.view"/>
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
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveOrderprod" focus="productkey.productkey">
<html:hidden property="action"/>
<html:hidden property="orderprodId"/>
<html:hidden property="orderhdrId"/>
<html:hidden name="user" property="securitylevel"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td><span class="text2">-&nbsp;<bean:write name="message"/></span></td></tr>
</html:messages>

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Create">
  <bean:message key="orderprod.title.create"/>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Delete">
  <bean:message key="orderprod.title.delete"/>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Edit">
  <bean:message key="orderprod.title.edit"/>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="View">
  <bean:message key="orderprod.title.view"/>
</logic:equal> 	  		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="OrderprodForm" property="action"
                     scope="session" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
        <td width="20%" class="td2"><div align="right"> Product: </div></td>
        <td width="30%" class="td2">
		<html:select property="productkey" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value="">- select a Product -</html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select> 
		</td>
          <td width="15%" class="td2">
		  <div align="right">
		        Compartment:
		  </div>
		  </td>
          <td width="35%" class="td2">
        <html:text property="comprt" size="10" maxlength="5" disabled="true" styleClass="ftforminputsmall"/>	  
          </td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="OrderprodForm" property="action"
                     scope="session" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
        <td width="20%" class="td2"><div align="right"> Product: </div></td>
        <td width="30%" class="td2">
		<html:select property="productkey" styleClass="ftforminputsmall"> 
		<html:option value="">- select a Product -</html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select> 
		</td>
          <td width="15%" class="td2">
		  <div align="right">
		        Compartment:
		  </div>
		  </td>
          <td width="35%" class="td2">
        <html:text property="comprt" size="10" maxlength="5" styleClass="ftforminputsmall"/>	  
          </td>			
      </tr>
    </table></td>
	</tr>	
	
  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
	<td>
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td2">
		  <div align="right">
		        Volume:
		  </div>
		  </td>
          <td width="30%" class="td2">	
        <html:text property="volume" size="10" maxlength="7" styleClass="ftforminputsmall"/>			  
		<html:select property="volunit" styleClass="ftforminputsmall">
			<html:option value="">- Units -</html:option>
			<html:options collection="volunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>									  
          </td>
          <td width="15%" class="td2">
		  <div align="right">
		        Weight:
		  </div>
		  </td>
          <td width="35%" class="td2">
        <html:text property="weight" size="10" maxlength="7" styleClass="ftforminputsmall"/>		  
		<html:select property="wghtunit" styleClass="ftforminputsmall">
			<html:option value="">- Units -</html:option>
			<html:options collection="wghtunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>	  
          </td>		  
        </tr>
    </table>
	</td>
  </tr>	
  
    	
  <tr>
    <td width="100%" valign="top" colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="6">
		  	<img src="images/spacer.gif" height="89" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="2">
		        &nbsp;<strong>Temperatures</strong> &nbsp;
		<html:select property="tempunit" styleClass="ftforminputsmall">
			<html:option value="">- Units -</html:option>
			<html:options collection="tempunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       Loading:
		  </div>
		  </td>
          <td width="80%" class="td2">
        <html:text property="ldgtemp" size="10" maxlength="5" styleClass="ftforminputsmall"/>	
		  </td>
		</tr>	  				
        <tr>
          <td class="td2"><div align="right"> Discharge: </div></td>
          <td class="td2">
        <html:text property="dchtemp" size="10" maxlength="5" styleClass="ftforminputsmall"/>			  
		  </td>
          </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Liquid:
		  </div>
		  </td>
          <td width="80%" class="td2">
        <html:text property="lqdtemp" size="10" maxlength="5" styleClass="ftforminputsmall"/>	
          </td>
        </tr>	
        <tr>
          <td width="20%" class="td2" valign="top">
		  <div align="right">
		        Surface:
		  </div>
		  </td>
          <td width="80%" class="td2">
        <html:text property="surftemp" size="10" maxlength="5" styleClass="ftforminputsmall"/>		  
		  </td>
        </tr>													
    </table>
		
	</td>
  </tr>		  
        </logic:notEqual>
		  

		
		  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
      <logic:equal name="OrderprodForm" property="action"
                  scope="session" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="OrderprodForm" property="action"
                  scope="session" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="OrderprodForm" property="action"
                  scope="session" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="OrderprodForm" property="action"
                     scope="session" value="Delete">
        <html:reset styleClass="button1">
          <bean:message key="button.reset"/>
        </html:reset>
      </logic:notEqual>
      <html:cancel styleClass="button1">
        <bean:message key="button.cancel"/>
      </html:cancel>
    </td>
  </tr>		  
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

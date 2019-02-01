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

<logic:equal name="SidtlForm" property="action"
            scope="request" value="Create">
<title><bean:message key="sidtl.title.create"/></title>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Delete">
<title><bean:message key="sidtl.title.delete"/></title>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Edit">
<title><bean:message key="sidtl.title.edit"/></title>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="View">
<title><bean:message key="sidtl.title.view"/></title>
</logic:equal> 

<link rel="stylesheet" type="text/css" href="css/base.css" />


<script language="JavaScript">
var searchWin;
var typeValue = "UNIT";

function setTypeValue()
{
for (var i=0; i < document.forms[0].chargetype.length; i++)
   {
   if (document.forms[0].chargetype[i].checked)
      {
      typeValue = document.forms[0].chargetype[i].value;
      }
   }
}


function amtCalc() 
{
	var _units = parseFloat(document.forms[0].units.value);
	if (_units == 0) _units = 1.00;
	var _rate = parseFloat(document.forms[0].rate.value);

	document.forms[0].chgamt.value = (_units*_rate);
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
	  <span class="heading2"><html:link action="/ListSihdr"><bean:message key="sihdr.title.list"/></html:link></span>
      	<span class="text6">&gt;</span>
      	  <span class="heading2"><html:link action="/ListSidtl"><bean:message key="sidtl.title.list"/></html:link></span>							
      	<span class="text6">&gt;</span>
        	<span class="heading2">
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Create">
<bean:message key="sidtl.title.create"/>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Delete">
<bean:message key="sidtl.title.delete"/>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Edit">
<bean:message key="sidtl.title.edit"/>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="View">
<bean:message key="sidtl.title.view"/>
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
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveSidtl" focus="chargekey" onsubmit="return amtCalc();">
	
<html:hidden property="sidtlId"/>
<html:hidden property="sihdrId"/>
<html:hidden property="action"/>
<html:hidden property="invoiceccykey"/>
<html:hidden property="ccykey"/>
<html:hidden property="xrateinv"/>
<html:hidden property="xratebase"/>
<html:hidden property="baseccykey"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

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
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Create">
<bean:message key="sidtl.title.create"/>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Delete">
<bean:message key="sidtl.title.delete"/>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Edit">
<bean:message key="sidtl.title.edit"/>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="View">
<bean:message key="sidtl.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="SidtlForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2" align="right">
		  <bean:message key="prompt.charge"/>: 
		  </td>
          <td width="80%" class="td2">
		<html:select property="chargekey" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		  	  
          </td>	  			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="SidtlForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2" align="right">
		  <bean:message key="prompt.charge"/>: 
		  </td>
          <td width="80%" class="td2">	
		<html:select property="chargekey" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		  		  
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
		        <bean:message key="prompt.chargetype"/> </div>
		  </td>
          <td width="80%" class="td2">		
		<span class="ftformradiosmall2">
<html:radio property="chargetype" value="UNIT"/><bean:message key="prompt.unit"/>
<html:radio property="chargetype" value="LUMPSUM"/><bean:message key="prompt.lumpsum"/>
<html:radio property="chargetype" value="PTOP"/><bean:message key="prompt.pointtopoint"/>
<html:radio property="chargetype" value="DISTANCE"/><bean:message key="prompt.distance"/>
		</span>		  							  
          </td>  
        </tr>
    </table>
	</td>
  </tr>	
  
    	
  <tr>
    <td width="100%" valign="top" colspan="2">	
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td class="td2" colspan="4">
		  <strong><bean:message key="prompt.invoice"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.invoiceccy"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
<strong><bean:write property="invoiceccykey" name="SidtlForm" /></strong>
		  </td>	  
		</tr>	  				
		  		  										
    </table>
	</td>
  </tr>		
    
  <tr>
    <td width="100%" valign="top" colspan="2">	
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td class="td2" colspan="6">
		  <strong><bean:message key="prompt.tariffdetails"/></strong>
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.noofunits"/>:
		  </div>
		  </td>
          <td width="15%" class="td2">
        <html:text property="units" size="20" onblur="amtCalc()" maxlength="20" styleClass="ftforminputsmall"/>					  
		  </td>
          <td width="15%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.unitname"/>:
		  </div>
		  </td>
          <td width="15%" class="td2">
        <html:text property="uname" size="20"  maxlength="20" styleClass="ftforminputsmall"/>			  
		  </td>	
          <td width="15%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.unitrate"/>:
		  </div>
		  </td>
          <td width="20%" class="td2">
        <html:text property="rate" size="20" maxlength="20" onblur="amtCalc()" styleClass="ftforminputsmall"/>			  
		  </td>			  	  
		</tr>	  								
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.invoiceamt"/>:
		  </div>
		  </td>
          <td width="15%" class="td2">
        <html:text property="chgamt" size="20" maxlength="20" readonly="true" styleClass="ftforminputsmall"/>			  	
		  </td>	  
          <td colspan="4" class="td2">		  	
		  </td>	            	  
		</tr>	  																
    </table>
	</td>
  </tr>

  <tr>
    <td width="100%" valign="top" colspan="2">	
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td class="td2">
		  <strong><bean:message key="prompt.notes"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td2">
        <html:text property="txt1" size="120"  maxlength="60" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>		
 
 
<tr>
    <td width="100%" valign="top" colspan="2">
		<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2">
		  <strong><bean:message key="prompt.additionaldata"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td2">
 				<table width="100%"  border="0" cellpadding="0" cellspacing="1">
        			<tr>
                    	<td width="2%" class="td2">
                    		1.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata1" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td> 
                    	<td width="2%" class="td2">
                    		2.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata2" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td> 
                    	<td width="2%" class="td2">
                    		3.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata3" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td>
                    	<td width="2%" class="td2">
                    		4.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata4" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td>
                    	<td width="2%" class="td2">
                    		5.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata5" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td>                                                                                                                      
					</tr>		 
        			<tr>
                    	<td width="2%" class="td2">
                    		6.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata6" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td> 
                    	<td width="2%" class="td2">
                    		7.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata7" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td> 
                    	<td width="2%" class="td2">
                    		8.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata8" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td>
                    	<td width="2%" class="td2">
                    		9.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata9" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
                    	</td>
                    	<td width="2%" class="td2">
                    		10.
                    	</td>
                    	<td width="18%" class="td2">
                    		<html:text property="adddata10" size="20" maxlength="100" styleClass="ftforminputsmall"/>	
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
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">

<logic:notEqual name="SidtlForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td7">

<logic:equal name="SidtlForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="SidtlForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="SidtlForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="SidtlForm" property="action" scope="request" value="Delete"> 
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

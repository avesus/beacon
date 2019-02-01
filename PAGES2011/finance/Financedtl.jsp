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
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
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


<script language="JavaScript">
var searchWin;

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearch.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+
					'&id='+document.forms[0].elements[field].value;					
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=420');
	searchWin.focus();
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
		<strong><bean:message key="financedtl.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListFinancehdr" styleClass="link4">
				<bean:message key="financehdr.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">	
			<html:link action="/ListFinancedtl" styleClass="link4">
				<bean:message key="financedtl.title.list"/> 	
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

<html:form action="/SaveFinancedtl" focus="subtypekey">
	
<html:hidden property="financedtlId"/>
<html:hidden property="financehdrId"/>
<html:hidden property="action"/>
<html:hidden property="ccykey"/>
<html:hidden property="doctypekey"/>
<html:hidden property="unitId"/>

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Create">
   <bean:message key="financedtl.title.create"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Delete">
   <bean:message key="financedtl.title.delete"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Edit">
   <bean:message key="financedtl.title.edit"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="View">
   <bean:message key="financedtl.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="FinancedtlForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.charge"/>: 
		  </td>
          <td width="80%" class="td9">
		<html:select property="subtypekey" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		  	  
          </td>	  			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="FinancedtlForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.charge"/>: 
		  </td>
          <td width="80%" class="td9">	
		<html:select property="subtypekey" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		  		  
          </td>	  			
      </tr>
    </table></td>
	</tr>	
	
    
  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">						
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9" align="right">
		       		        <bean:message key="prompt.unitno"/>:
		  </td>
          <td width="80%" class="td9">
        <html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="ftforminputsmall"/>&nbsp;	
		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,EMPTY,ONHIRE','N','N','N'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		  	
		  </td>	  	  
		</tr>
        <tr>	
          <td width="20%" class="td9" align="right">
		       <bean:message key="prompt.lineno"/>:
		  </td>
          <td width="80%" class="td9">
        <html:text property="doclineno" size="5" maxlength="5" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>			  																
    </table>
	</td>
  </tr>

    
  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">						
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.netamount"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="netamount" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>
        <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.vatamount"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="vatamount" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>	
       <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.grossamount"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="grossamount" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>				  																
    </table>
	</td>
  </tr>

  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9" colspan="6">
		  <strong><bean:message key="prompt.description"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:text property="txt1" size="80"  maxlength="60" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>		
  
    	
        </logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">

<logic:notEqual name="FinancedtlForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="FinancedtlForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="FinancedtlForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="FinancedtlForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="FinancedtlForm" property="action" scope="request" value="Delete"> 
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

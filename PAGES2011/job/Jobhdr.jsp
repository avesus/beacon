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
<bean:define id="orderprods" name="JobhdrForm" property="orderprods"/>
  
<app:checkLogon/>


<html:html>
<head>

<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="jobhdr.title.create"/></title>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="jobhdr.title.delete"/></title>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="jobhdr.title.edit"/></title>
</logic:equal>


	
<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="JavaScript">
var searchWin;

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearch.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+document.forms[0].elements['orderhdrId'].value+
					'&id='+document.forms[0].elements[field].value;					
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
</script>  

</head>


<body onUnload="if (searchWin != null) {searchWin.close()}">

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
	<span class="heading2"><html:link action="/ListJobhdr"><bean:message key="jobhdr.title.list"/></html:link></span> 
	<span class="text6">&gt;</span>  
	<span class="heading2">    
    <logic:equal name="JobhdrForm" property="action"
            scope="session" value="Create">
  <bean:message key="jobhdr.title.create"/>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Delete">
 <bean:message key="jobhdr.title.delete"/>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Edit">
 <bean:message key="jobhdr.title.edit"/>
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

<html:form action="/SaveJobhdr" focus="unitkey">
<html:hidden property="action"/>
<html:hidden property="jobhdrId"/>
<html:hidden property="orderhdrId"/>
<html:hidden property="unitId"/>


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
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Create">
  <bean:message key="jobhdr.title.create"/>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Delete">
  <bean:message key="jobhdr.title.delete"/>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Edit">
  <bean:message key="jobhdr.title.edit"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


      <logic:equal name="JobhdrForm" property="action"
                     scope="session" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
	      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
	            <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.jobno"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
        <html:text property="jobno" size="20" maxlength="20" disabled="true" styleClass="ftforminputsmall"/>	  
          </td>		
      </tr>
    </table></td>
	</tr>
  <tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
	          <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
	            <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.unitno"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="unitkey" size="20" maxlength="20" disabled="true" styleClass="ftforminputsmall"/>	  
          </td>	

        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.product"/>: </div></td>
        <td width="30%" class="td2">
		<html:select property="productkey" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="orderprods" property="productkey.productkey" labelProperty="productkey.tradname"/>
		</html:select> 
		</td>		
      </tr>
    </table></td>
	</tr>		
	 </logic:equal>		


      <logic:equal name="JobhdrForm" property="action"
                     scope="session" value="Create">  
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.unitno"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="ftforminputsmall"/>&nbsp;	
<%--		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,EMPTY,AVA','N','N','N'))">--%>
<%--RESERVED INCLUDED FOR BEACON LAKE (CPG) SYSTEM --%>
		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,EMPTY,AVA,RESERVED','N','N','N'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>									  
          </td>		  

        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.product"/>: </div></td>
        <td width="30%" class="td2">
		<html:select property="productkey" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="orderprods" property="productkey.productkey" labelProperty="productkey.tradname"/> 
		</html:select> 
		</td>		
      </tr>
    </table></td>
	</tr>		
	</logic:equal>		


      <logic:equal name="JobhdrForm" property="action"
                     scope="session" value="Edit">  
<tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
	      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
	            <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.jobno"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="jobno" size="20" maxlength="20" disabled="true" styleClass="ftforminputsmall"/>	  
          </td>		
      </tr>
    </table></td>
	</tr>					 
  <tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
	          <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
	            <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.unitno"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
        <html:text property="unitkey" size="20" maxlength="20" disabled="true" styleClass="ftforminputsmall"/>	  
          </td>	

        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.product"/>: </div></td>
        <td width="30%" class="td2">
		<html:select property="productkey" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="orderprods" property="productkey.productkey" labelProperty="productkey.tradname"/>
		</html:select> 
		</td>		
      </tr>
    </table></td>
	</tr>	
	</logic:equal>
	
	
      <logic:notEqual name="JobhdrForm" property="action"
                     scope="session" value="Delete">  		
	<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
<html:text property="movref" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  
          </td>		  		
      </tr>	
    </table>
</td></tr>

	<tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
	          <td rowspan="3"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.sealnumbers"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
<html:text property="sealnumber1" size="10" maxlength="100" styleClass="ftforminputsmall"/>&nbsp;
<html:text property="sealnumber2" size="10" maxlength="100" styleClass="ftforminputsmall"/>&nbsp;
<html:text property="sealnumber3" size="10" maxlength="100" styleClass="ftforminputsmall"/>&nbsp;
<html:text property="sealnumber4" size="10" maxlength="100" styleClass="ftforminputsmall"/>&nbsp;
<html:text property="sealnumber5" size="10" maxlength="100" styleClass="ftforminputsmall"/>					  
          </td>		  		
      </tr>
	  
        <tr>
          <td width="15%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.weightactual"/>:
		  </div>
		  </td>
          <td width="35%" class="td2">
        <html:text property="weightactual" size="10" maxlength="7" styleClass="ftforminputsmall"/>		  
		<html:select property="weightactualunit" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="wghtunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>	  
          </td>		  
        </tr>	  
	  
        <tr>
          <td width="15%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.additionalinstructions"/>:
		  </div>
		  </td>
          <td width="35%" class="td2">
        <html:text property="addinstruction" size="100" maxlength="100" styleClass="ftforminputsmall"/>		    
          </td>		  
        </tr>
			  
    </table></td>
	</tr>	
          </logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">

<logic:equal name="JobhdrForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="JobhdrForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="JobhdrForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="JobhdrForm" property="action" scope="session" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
 
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">
	
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

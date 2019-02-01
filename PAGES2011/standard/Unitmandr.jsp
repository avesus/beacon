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


<script language="JavaScript">
var searchWin;

function addressSearch(field, types){
	var address = document.forms[0].elements[field];
	var url     = 'EditAddressSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      address.options[address.selectedIndex].value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
		

function locationSearch(field, types){
	var location = document.forms[0].elements[field];
	var url     = 'EditLocationSearch.do?maxResults=999&headerInfo1='+types+'&headerInfo2='+field+'&id=' +
                      location.options[location.selectedIndex].value;				  
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
	
</script> 


<logic:equal name="UnitmandrForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="UnitmandrForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="UnitmandrForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />



  
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

	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="unitmandr.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListUnit" styleClass="link4">
				<bean:message key="unit.title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
		<span class="heading2">
			<html:link action="/ListUnitmandr" styleClass="link4">
				<bean:message key="unitmandr.title.list"/> 	
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
	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveUnitmandr" focus="mandrref">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="unitmandrId"/>
<html:hidden property="unitId"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="UnitmandrForm" property="action"
            scope="session" value="Create">
<bean:message key="title.create"/>
</logic:equal>
<logic:equal name="UnitmandrForm" property="action"
            scope="session" value="Delete">
   <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="UnitmandrForm" property="action"
            scope="session" value="Edit">
   <bean:message key="title.edit"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">	
      <tr>
			<td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
<html:text property="mandrref" size="20" styleClass="ftforminputsmall"/>	  
          </td>	  		
      </tr>	
      <tr>  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.mandrdate"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
<html:select property="mandrdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="mandrdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="mandrdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 	  
          </td>	  		
      </tr>		  							  			  													
    </table>
	</td>
  </tr>	
		 

  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">	
      <tr>
			<td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.location"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
		<html:select property="locationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="depots" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('locationkey','DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	  
          </td>	  		
      </tr>	
      <tr>  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.lessee"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
		<html:select property="lesseeaddrkey" 
			styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalessee"/></html:option>
			<html:options collection="lessees" property="addrkey" labelProperty="name"/>	
		</html:select>
		<html:link href="javascript:void(addressSearch('lesseeaddrkey','LESSEE'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link> 	  
          </td>	  		
      </tr>		  							  			  													
    </table>
	</td>
  </tr>	

  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">	
      <tr>
			<td rowspan="3"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.ccy"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
			<html:select property="ccykey" styleClass="ftforminputsmall"> 
				<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
				<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
			</html:select>	  
          </td>	  		
      </tr>
      <tr>	  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.labouramt"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
<html:text property="labouramt" size="20" styleClass="ftforminputsmall"/>	  
          </td>	  		
      </tr>
      <tr>  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.mandrdescription"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
<html:text property="materialamt" size="20" styleClass="ftforminputsmall"/>	  
          </td>	  		
      </tr>	  	  								  			  													
    </table>
	</td>
  </tr>
  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>			
			<td rowspan="3"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.fittinggroup"/>:</div></td>
          <td class="td2" width="80%">
				<html:select property="fitgrpkey" styleClass="ftforminputsmall">
					<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
					<html:options collection="fitgrps" property="fitgrpkey" labelProperty="ldesc"/>
				</html:select>		
		  </td>
        </tr>
        <tr>			
          <td class="td2" width="20%"><div align="right"><bean:message key="prompt.fittingtype"/>:</div></td>
          <td class="td2" width="80%">
				<html:select property="fittypkey" styleClass="ftforminputsmall">
					<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
					<html:options collection="fittyps" property="fittypkey" labelProperty="ldesc"/>
				</html:select> 		
		  </td>
        </tr>			
      <tr>  
          <td class="td2" width="20%">
		  <div align="right">
		  <bean:message key="prompt.mandrdescription"/>:
		  </div>
		  </td>
          <td class="td2" width="80%">
<html:text property="mandrdesc" size="100" styleClass="ftforminputsmall"/>	  
          </td>	  		
      </tr>								  			  													
    </table>
	</td>
  </tr>		

	
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
      <logic:equal name="UnitmandrForm" property="action"
                  scope="session" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="UnitmandrForm" property="action"
                  scope="session" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="UnitmandrForm" property="action"
                  scope="session" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="UnitmandrForm" property="action"
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

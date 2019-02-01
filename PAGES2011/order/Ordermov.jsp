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



<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Create">
   <title><bean:message key="ordermov.title.create"/></title>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Delete">
   <title><bean:message key="ordermov.title.delete"/></title>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="ordermov.title.edit"/></title>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="View">
 <title><bean:message key="ordermov.title.view"/></title>
</logic:equal>	

	
<link rel="stylesheet" type="text/css" href="css/base.css" />

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
	<span class="heading2"><html:link action="/ListOrdermov"><bean:message key="ordermov.title.list"/></html:link></span> 
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Create">
   <bean:message key="ordermov.title.create"/>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Delete">
   <bean:message key="ordermov.title.delete"/>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Edit">
   <bean:message key="ordermov.title.edit"/>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="View">
  <bean:message key="ordermov.title.view"/>
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

<html:form action="/SaveOrdermov" focus="sectionkey.sectionkey">
<html:hidden property="action"/>
<html:hidden property="ordermovId"/>
<html:hidden property="orderhdrId"/>

<html:hidden property="fromg1key"/>	
<html:hidden property="fromg2key"/>	
<html:hidden property="fromg3key"/>	
<html:hidden property="fromg4key"/>	
<html:hidden property="tog1key"/>	
<html:hidden property="tog2key"/>	
<html:hidden property="tog3key"/>	
<html:hidden property="tog4key"/>	
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
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Create">
   <bean:message key="ordermov.title.create"/>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Delete">
   <bean:message key="ordermov.title.delete"/>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="Edit">
   <bean:message key="ordermov.title.edit"/>
</logic:equal>
<logic:equal name="OrdermovForm" property="action"
            scope="request" value="View">
  <bean:message key="ordermov.title.view"/>
</logic:equal>			  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="OrdermovForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> Section: </div></td>
        <td width="80%" class="td2">
		<html:select property="sectionkey" disabled="true" styleClass="ftforminputsmall"> 
			<html:option value="">- select a Section -</html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="OrdermovForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> Section: </div></td>
        <td width="80%" class="td2">
		<html:select property="sectionkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Section -</html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
</tr>	

<tr>
    <td width="100%" valign="top" colspan="2">		
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  From Location:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="fromlocationkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Location -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('fromlocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		  
          </td>	  		
      </tr>
      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  To Location:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="tolocationkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Location -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(locationSearch('tolocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>	    
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
		  Vendor:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			  
          </td>	  		
      </tr>
    </table></td>
</tr>	
  
  
    	
  <tr>
    <td width="100%" valign="top" colspan="2">	
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
		
			
        <tr>
		        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
				
          <td class="td2"><div align="right">Estimate Date/Time:</div></td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td2"><div align="right">From:</div></td>
              <td width="45%" class="td2">
		<html:select property="estfromdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="estfromdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="estfromdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="estfromtimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="estfromtimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td2"><div align="right">To:</div></td>
              <td width="45%" class="td2">
		<html:select property="esttodatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="esttodatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="esttodateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="esttotimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="esttotimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
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
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">

<logic:equal name="OrdermovForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="OrdermovForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="OrdermovForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="OrdermovForm" property="action" scope="request" value="Delete"> 
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

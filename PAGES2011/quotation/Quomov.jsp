<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 --%>
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
				document.forms[0].action.value == 'View'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
		}
</script>


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



<logic:equal name="QuomovForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="quomov.title.create"/></title>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="quomov.title.delete"/></title>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="quomov.title.edit"/></title>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="View">
  <title><bean:message key="quomov.title.view"/></title>
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
	<td class="tdwht">
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListQuomov"><bean:message key="quomov.title.list"/></html:link></span>
	<span class="text6">&gt;</span>    
	<span class="heading2">
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Create">
   <bean:message key="quomov.title.create"/>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Delete">
   <bean:message key="quomov.title.delete"/>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Edit">
   <bean:message key="quomov.title.edit"/>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="View">
  <bean:message key="quomov.title.view"/>
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

<html:form action="/SaveQuomov" focus="seqno">
<html:hidden property="action"/>
<html:hidden property="quomovId"/>
<html:hidden property="quohdrId"/>
<html:hidden property="initfromday" value="true"/>
<html:hidden property="inittoday" value="true"/>
<html:hidden property="quotno"/>

<html:hidden property="fromg1key"/>	
<html:hidden property="fromg2key"/>	
<html:hidden property="fromg3key"/>	
<html:hidden property="fromg4key"/>	
<html:hidden property="tog1key"/>	
<html:hidden property="tog2key"/>	
<html:hidden property="tog3key"/>	
<html:hidden property="tog4key"/>	


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
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Create">
   <bean:message key="quomov.title.create"/>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Delete">
   <bean:message key="quomov.title.delete"/>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="Edit">
   <bean:message key="quomov.title.edit"/>
</logic:equal>
<logic:equal name="QuomovForm" property="action"
            scope="request" value="View">
  <bean:message key="quomov.title.view"/>
</logic:equal>			  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="QuomovForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.sequence"/>: </div></td>
        <td width="80%" class="td2">
        <html:text property="seqno" size="7" disabled="true" maxlength="5" styleClass="ftforminputsmall"/>
		</td>			
      </tr>	
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.section"/>: </div></td>
        <td width="80%" class="td2">
		<html:select property="sectionkey" disabled="true" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectasection"/></html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select> 
		</td>			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="QuomovForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.sequence"/>: </div></td>
        <td width="80%" class="td2">
        <html:text property="seqno" size="7" maxlength="5" styleClass="ftforminputsmall"/>
		</td>			
      </tr>		
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> <bean:message key="prompt.section"/>: </div></td>
        <td width="80%" class="td2">
		<html:select property="sectionkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectasection"/></html:option> 
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
		  <bean:message key="prompt.fromlocation"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="fromlocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View">         
		<html:link href="javascript:void(locationSearch('fromlocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		
</logic:notEqual>          
          </td>	  		
      </tr>
      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.tolocation"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="tolocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>&nbsp;
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View">             
		<html:link href="javascript:void(locationSearch('tolocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual>        	    
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
		  <bean:message key="prompt.vendor"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View">             
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
</logic:notEqual>        			  
          </td>	  		
      </tr>
    </table></td>
</tr>	
  
  
    	
  <tr>
 <td width="100%" valign="top" colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td width="0%" rowspan="6">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td class="td2" colspan="4">
		  <strong><bean:message key="prompt.planningdaysbyloadingdate"/> </strong>&nbsp;
		  </td>
		</tr>	
        <tr>
          <td class="td2" colspan="4">
		  <strong>&nbsp;&nbsp;<bean:message key="prompt.fromdate"/> </strong>&nbsp;
		  </td>
		</tr>			
        <tr>
          <td width="20%" class="td2">
		  </td>
          <td width="10%" class="td2" align="right">
        <bean:message key="prompt.days"/>:
		  </td>		  
          <td width="70%" class="td2">
        <html:text property="fromdayno" size="7"  maxlength="5" styleClass="ftforminputsmall"/>
		  </td>	  
		</tr>	
        <tr>
          <td class="td2" colspan="4">
		  <strong>&nbsp;&nbsp;<bean:message key="prompt.todate"/> </strong>&nbsp;
		  </td>
		</tr>			
        <tr>
          <td width="20%" class="td2">
		  </td>
          <td width="10%" class="td2" align="right">
        <bean:message key="prompt.days"/>:
		  </td>		  
          <td width="70%" class="td2">
        <html:text property="todayno" size="7"  maxlength="5" styleClass="ftforminputsmall"/>
		  </td>	  
		</tr>		  													
    </table>
	</td>
  </tr>		   	
  		
        </logic:notEqual>
		  

		
<logic:notEqual name="QuomovForm" property="action" scope="request" value="View"> 		  
  <tr>
 <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
		  
<logic:equal name="QuomovForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="QuomovForm" property="action" scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="QuomovForm" property="action" scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="QuomovForm" property="action" scope="request" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
 
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">

    </td>
  </tr>
  
  		  
    </table></td>
  </tr>
</logic:notEqual>

  
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

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



<logic:equal name="AgentJobmovForm" property="action"
            scope="request" value="Create">
  <title>Create Job Movement Section</title>
</logic:equal>
<logic:equal name="AgentJobmovForm" property="action"
            scope="request" value="Delete">
  <title>Delete Job Movement Section</title>
</logic:equal>
<logic:equal name="AgentJobmovForm" property="action"
            scope="request" value="Edit">
  <title>Edit Job Movement Section</title>
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




var vMultiple = false;	
function onClickMultiple() {
			if (vMultiple) {
				vMultiple = false;
				MM_showHideLayers('multipleLayer','','hide');
				MM_swapImage('multipleArrow','','images/black_arrow_right.gif');
			}	
			else {
				vMultiple = true;			
				MM_showHideLayers('multipleLayer','','show');
				MM_swapImage('multipleArrow','','images/black_arrow_down.gif');
			}
}
		

function defaultActFrom(){
	document.forms[0].elements['actfromdatedd'].value=document.forms[0].elements['estfromdatedd'].value;
	document.forms[0].elements['actfromdatemm'].value=document.forms[0].elements['estfromdatemm'].value;
	document.forms[0].elements['actfromdateyyyy'].value=document.forms[0].elements['estfromdateyyyy'].value;
	document.forms[0].elements['actfromtimehh'].value=document.forms[0].elements['estfromtimehh'].value;
	document.forms[0].elements['actfromtimemm'].value=document.forms[0].elements['estfromtimemm'].value;
}
function defaultActTo(){
	document.forms[0].elements['acttodatedd'].value=document.forms[0].elements['esttodatedd'].value;
	document.forms[0].elements['acttodatemm'].value=document.forms[0].elements['esttodatemm'].value;
	document.forms[0].elements['acttodateyyyy'].value=document.forms[0].elements['esttodateyyyy'].value;
	document.forms[0].elements['acttotimehh'].value=document.forms[0].elements['esttotimehh'].value;
	document.forms[0].elements['acttotimemm'].value=document.forms[0].elements['esttotimemm'].value;
}
function defaultEstTo(){
	document.forms[0].elements['esttodatedd'].value=document.forms[0].elements['estfromdatedd'].value;
	document.forms[0].elements['esttodatemm'].value=document.forms[0].elements['estfromdatemm'].value;
	document.forms[0].elements['esttodateyyyy'].value=document.forms[0].elements['estfromdateyyyy'].value;
	document.forms[0].elements['esttotimehh'].value=document.forms[0].elements['estfromtimehh'].value;
	document.forms[0].elements['esttotimemm'].value=document.forms[0].elements['estfromtimemm'].value;
}

</script>  
  


</head>


<body onUnload="if (searchWin != null) {searchWin.close()}">




<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<%--<jsp:include page="/pages/header.jsp" flush="true" />--%>
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:1200px; height:650px; position:relative;">	


<html:errors/>

<html:form action="/SaveAgentJobmov" focus="sectionkey.sectionkey">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="jobmovId"/>
<html:hidden property="jobhdrId"/>
<html:hidden property="unitId"/>
<html:hidden property="estfromtimeinmillis"/>
<html:hidden property="esttotimeinmillis"/>
<html:hidden property="actfromtimeinmillis"/>
<html:hidden property="acttotimeinmillis"/>
<html:hidden property="invsts"/>
<html:hidden property="movests"/>

                
                		
<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>



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
<logic:equal name="AgentJobmovForm" property="action"
            scope="request" value="Create">
   Create Job Movement Section
</logic:equal>
<logic:equal name="AgentJobmovForm" property="action"
            scope="request" value="Delete">
   Delete Job Movement Section
</logic:equal>
<logic:equal name="AgentJobmovForm" property="action"
            scope="request" value="Edit">
   Edit Job Movement Section
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="AgentJobmovForm" property="action"
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


      <logic:notEqual name="AgentJobmovForm" property="action"
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
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right">Status: </div></td>
        <td width="80%" class="td2">
<bean:write name="AgentJobmovForm" property="invsts" scope="request"/>
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
        <td rowspan="4"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Vendor:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>&nbsp;
		<html:link href="javascript:void(addressSearch('vendoraddrkey','VENDOR'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			  
          </td>	  		
      </tr>
      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Movement Reference:
		  </div>
		  </td>
          <td width="30%" class="td2" colspan="3">
<html:text property="movref" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  			  
          </td>	 	   		
      </tr>    

      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Movement Notes:
		  </div>
		  </td>
          <td width="30%" class="td2" colspan="3">
<html:text property="txt" size="150" styleClass="ftforminputsmall"/>		  			  
          </td>	 		   		
      </tr>	
      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  MMU Link:
		  </div>
		  </td>
          <td width="30%" class="td2" colspan="3">
<html:text property="mmulink" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
<html:hidden property="mmulink"/>			  			  
          </td>	 		   		
      </tr>	  
    </table></td>
</tr>	
  
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="3"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  	  

          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.vessel"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="vessel" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavessel"/></html:option>
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>	
		</html:select>			  
          </td>		   		
          <td width="20%" class="td2">
		  <div align="right">
		 <bean:message key="prompt.voyage"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
<html:text property="voyage" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  			  
          </td>	 
      </tr>      
      <tr>	
          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.vesselbookingcontact"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
<html:text property="vsbkcontact" size="20" styleClass="ftforminputsmall"/>		  			  
          </td>	        
          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.vesselbookingref"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
<html:text property="vsbkref" size="20" styleClass="ftforminputsmall"/>		  			  
          </td>	           		   		
      </tr>	      
      <tr>	
          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.billoflading"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
<html:text property="billoflading" size="20" styleClass="ftforminputsmall"/>		  			  
          </td>	        
          <td width="20%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.lloydsnumber"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
<html:text property="lloydsnumber" size="20" styleClass="ftforminputsmall"/>		  			  
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
              <td width="5%" class="td9"><div align="right">From:</div></td>
              <td width="45%" class="td9">
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
              <td width="5%" class="td9"><div align="right">		
			  <html:link href="javascript:void(defaultEstTo())">
		<html:img src="images/arrowIcon.gif" alt="default" border="0" align="middle"/>
		</html:link>&nbsp;To:</div></td>
              <td width="45%" class="td9">
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
	
		
      <logic:equal name="AgentJobmovForm" property="action"
                     scope="request" value="Create">  		
        <tr>
          <td class="td2"><div align="right">Actual Date/Time:</div></td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td9"><div align="right">From:</div></td>
              <td width="45%" class="td9">
		<html:select property="actfromdatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="actfromdatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="actfromdateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="actfromtimehh" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="actfromtimemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td9"><div align="right">To:</div></td>
              <td width="45%" class="td9">
		<html:select property="acttodatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="acttodatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="acttodateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="acttotimehh" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="acttotimemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
			  </td>
            </tr>
          </table>		  
		  </td>
        </tr>
</logic:equal>

      <logic:notEqual name="AgentJobmovForm" property="action"
                     scope="request" value="Create">  		
        <tr>
          <td class="td2">		  
		  <div align="right">Actual Date/Time:</div>		  
		  </td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td9">		
		<div align="right">
		<html:link href="javascript:void(defaultActFrom())">
		<html:img src="images/arrowIcon.gif" alt="default" border="0" align="middle"/>
		</html:link>&nbsp;From:</div></td>
              <td width="45%" class="td9">
		<html:select property="actfromdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="actfromdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="actfromdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="actfromtimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="actfromtimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td9"><div align="right">		
			  <html:link href="javascript:void(defaultActTo())">
		<html:img src="images/arrowIcon.gif" alt="default" border="0" align="middle"/>
		</html:link>&nbsp;To:</div></td>
              <td width="45%" class="td9">
		<html:select property="acttodatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="acttodatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="acttodateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="acttotimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="acttotimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
			  </td>
            </tr>
          </table>		  
		  </td>
        </tr>
</logic:notEqual>

				  													
    </table>
	</td>
  </tr>		


</logic:notEqual>
		  

		  
  <tr>
    <td colspan="2">
	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">

<logic:equal name="AgentJobmovForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="AgentJobmovForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="AgentJobmovForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="AgentJobmovForm" property="action" scope="request" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
 
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">
	
    </td>
  </tr>	
						  
    </table>	
	
</td>
  </tr>

  
</table>

</td></tr>


</table>

</td></tr>

</table>



</td>
</tr>





</table>

</html:form>


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

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



<logic:equal name="JobmovForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="jobmov.title.create"/></title>
</logic:equal>
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="jobmov.title.delete"/></title>
</logic:equal>
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="jobmov.title.edit"/></title>
</logic:equal>	
<logic:equal name="JobmovForm" property="action"
            scope="session" value="View">
  <title><bean:message key="jobmov.title.view"/></title>
</logic:equal>	


<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		checkAll(document.forms(0).selectedObjects,document.forms(0).selectedObjectsAll);
	}
    //]]>
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


<SCRIPT LANGUAGE="JavaScript">
function checkAll(field1,field2)
{
	var checkAll=false;
	if (field2.checked) checkAll=true;
	for (i = 0; i < field1.length; i++)	field1[i].checked = checkAll ;
}
function unCheckSelectedObjectsAll()
{
	document.forms(0).selectedObjectsAll.checked = false;
}
</script>
  


</head>


<body onUnload="if (searchWin != null) {searchWin.close()}" onLoad="onLoad();">




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
	<span class="heading2"><html:link action="/ListJobmov"><bean:message key="jobmov.title.list"/></html:link></span>
	<span class="text6">&gt;</span>      
	<span class="heading2">       
    <logic:equal name="JobmovForm" property="action"
            scope="session" value="Create">
  <bean:message key="jobmov.title.create"/>
</logic:equal>
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Delete">
  <bean:message key="jobmov.title.delete"/>
</logic:equal>
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Edit">
  <bean:message key="jobmov.title.edit"/>
</logic:equal>	
<logic:equal name="JobmovForm" property="action"
            scope="session" value="View">
  <bean:message key="jobmov.title.view"/>
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
	
		<div style="OVERFLOW:auto; width:1200px; height:700px; position:relative;">	


<html:errors/>

<html:form action="/SaveJobmov" focus="sectionkey.sectionkey">
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
<html:hidden property="mmulink"/>	

<html:hidden property="fromg1key"/>	
<html:hidden property="fromg2key"/>	
<html:hidden property="fromg3key"/>	
<html:hidden property="fromg4key"/>	
<html:hidden property="tog1key"/>	
<html:hidden property="tog2key"/>	
<html:hidden property="tog3key"/>	
<html:hidden property="tog4key"/>	
                    
                    		
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
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Create">
  <bean:message key="jobmov.title.create"/>
</logic:equal>
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Delete">
  <bean:message key="jobmov.title.delete"/>
</logic:equal>
<logic:equal name="JobmovForm" property="action"
            scope="session" value="Edit">
  <bean:message key="jobmov.title.edit"/>
</logic:equal>	
<logic:equal name="JobmovForm" property="action"
            scope="session" value="View">
  <bean:message key="jobmov.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="JobmovForm" property="action"
                     scope="session" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"><bean:message key="prompt.section"/>: </div></td>
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


      <logic:notEqual name="JobmovForm" property="action"
                     scope="session" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
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
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"><bean:message key="prompt.status"/>: </div></td>
        <td width="80%" class="td2">
<bean:write name="JobmovForm" property="invsts" scope="session"/>
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
		<html:link href="javascript:void(locationSearch('fromlocationkey','PORT|PLANT|DEPOT'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		  
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
        <td rowspan="5"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
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
          <td width="80%" class="td2" colspan="3">
<html:text property="movref" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  			  
          </td>	 	   		
      </tr>    

      <tr>	  
          <td width="20%" class="td2" valign="top">
		  <div align="right">
		  Movement Description:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
<html:textarea rows="3" cols="150" property="txt" styleClass="ftforminputsmall"/>		  			  
          </td>	 		   		
      </tr>	
           
      <tr>	  
          <td width="20%" class="td2" valign="top">
		  <div align="right">
		  Movement Notes:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
<html:textarea rows="3" cols="150" property="txt2" styleClass="ftforminputsmall"/>	  			  
          </td>	 		   		
      </tr>	
       <tr>	  
          <td width="20%" class="td2" valign="top">
		  <div align="right">
		  Special Notes:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
<html:textarea rows="3" cols="150" property="txt3" styleClass="ftforminputsmall"/>	  			  
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
	
		
      <logic:equal name="JobmovForm" property="action"
                     scope="session" value="Create">  		
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

      <logic:notEqual name="JobmovForm" property="action"
                     scope="session" value="Create">  		
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

<logic:equal name="JobmovForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="JobmovForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="JobmovForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="JobmovForm" property="action" scope="session" value="Delete"> 
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






<logic:notEmpty name="JobmovForm" property="mmuList">
      <logic:equal name="JobmovForm" property="action"
                  scope="session" value="Edit">

  <tr>
    <td>				
<div 	id="multipleLayer" 
		style="position:inherit; width:1100px; height:200px; z-index:2; left: 10px; top: 0px; overflow: auto; border: 1px solid #999999; background-color: #ffffff; layer-background-color: #ffffff; visibility: visible;">

					<table width="100%" border="0" cellspacing="2" cellpadding="5" valign="top" bgcolor="#FFFFFF">
  <tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
Multiple Unit Movement Update		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>					
					
                      <tr>
                        <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                            <tr>	
                              <td class="tddkgry" width="5%">
                              
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4" align="center">                              
<input type='checkbox' name='selectedObjectsAll' value='N' checked onclick="checkAll(document.forms(0).selectedObjects,document.forms(0).selectedObjectsAll);">								
										</td>
  									</tr>
								</table>		
                                	                              
							  </td>													
                              <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4"> Unit</td>
  									</tr>								
  									<tr>
    									<td class="heading4">&nbsp; </td>
  									</tr>
								</table>
							  </td>							
                            <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4"> <bean:message key="prompt.section"/></td>
  									</tr>								
  									<tr>
    									<td class="heading4"> <bean:message key="prompt.vendor"/> </td>
  									</tr>
								</table>
							</td>
                            <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4"> <bean:message key="prompt.fromlocation"/></td>
  									</tr>
  									<tr>
    									<td class="heading4"> <bean:message key="prompt.tolocation"/> </td>
  									</tr>
								</table>
							</td>
                              <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4">Reference</td>
  									</tr>
  									<tr>
    									<td class="heading4">Vessel</td>
  									</tr>
								</table>
							  </td>
                            </tr>							
<%int row=0;%>
	<logic:iterate id="jobmovDTO" name="JobmovForm" property="mmuList">
<%String _class = row++ % 2 == 0 ? "tdlghtgry2" : "tdlghtgry";%>
                            <tr> <span class="text2">	
                             <td class="<%= _class %>" align="center">
									<html:multibox property="selectedObjects" onclick="unCheckSelectedObjectsAll();">
									<bean:write name="jobmovDTO" property="jobmovId" />
									</html:multibox>
                            </td>												
                            <td class="<%= _class %>">
<html:hidden name="jobmovDTO" property="jobmovId" indexed="true" />	
<bean:write name="jobmovDTO" property="unit" />						
							</td>
                            <td class="<%= _class %>">
		<html:select property="section.sectionkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">	
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select> 
							</td>
                            <td class="<%= _class %>">
		<html:select property="fromlocation.locationkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">		
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>								  
							</td>
                              <td class="<%= _class %>">
<html:text name="jobmovDTO" indexed="true" property="movref" styleClass="ftforminputsmall" disabled="true"/>
							</td>
                              </span> </tr>
							  
							  
                            <tr> <span class="text2">
                              <td class="<%= _class %>" align="center">
                              </td>													
                            <td class="<%= _class %>">						
							</td>
                            <td class="<%= _class %>">
		<html:select property="vendoraddr.addrkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">		
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>							  
							</td>
                            <td class="<%= _class %>">
		<html:select property="tolocation.locationkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">			
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>														  
							</td>
                              <td class="<%= _class %>">
		<html:select property="vessel" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">	
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>	
		</html:select>
							</td>
                              </span> </tr>							  
	</logic:iterate>	
                          </table></td>
                      </tr>
                    </table>	
									
</div>
	</td>
  </tr>						
				
	</logic:equal>					
</logic:notEmpty>





</table>

</html:form>


</div>
</td>
</tr>



<%--<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>--%>

</table>




</body>
</html:html>

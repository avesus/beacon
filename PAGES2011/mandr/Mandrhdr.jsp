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

<script language="JavaScript">
var searchWin;

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearch.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+document.forms[0].elements['id'].value+
					'&id='+document.forms[0].elements[field].value;					
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
</script>

	  

<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
	<span class="heading2"><strong><bean:message key="mandrhdr.title"/></strong></span>
	<span class="heading2"><html:link action="/ListMandrhdrMain" styleClass="link4"><bean:message key="title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:1250px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveMandrhdr" focus="mandrno">
<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="copyId"/>
<html:hidden property="copyVersionId"/>
<html:hidden property="readonly"/>
<html:hidden property="lastversionno"/>
<html:hidden property="lastversionflag"/>
<html:hidden property="unitId"/>



<table width="100%" border="0" cellspacing="1" cellpadding="0"  class="tableBgcolor1">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="1" cellpadding="2" class="searchBgcolor1">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="1" cellpadding="0">

  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="labelBgcolor1"> 
    
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="labelBgcolor1">
        <tr>
          <td class="td7"><strong>
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="mandrhdr.title.create"/>
</logic:equal>
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="mandrhdr.title.delete"/>
</logic:equal>
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="mandrhdr.title.edit"/>
</logic:equal>
<logic:equal name="MandrhdrForm" property="action"
            scope="request" value="View">
  <bean:message key="mandrhdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		
</table></td></tr>


      <logic:equal name="MandrhdrForm" property="action"
                     scope="request" value="Delete"> 
                     
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="labelBgcolor1"> 
                          
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.mandrno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="mandrno" size="40" disabled="true" maxlength="40" styleClass="ftforminputsmall"/>&nbsp;
        <html:text property="versionno" size="10" disabled="true" maxlength="10" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
    
    </table></td></tr>
	</logic:equal>	
    
    
    
      <logic:notEqual name="MandrhdrForm" property="action"
                     scope="request" value="Delete"> 
  
                      
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="labelBgcolor1"> 
    
    <tr>   
 <td width="50%" valign="top">
 	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  				
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="85" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.mandrno"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		  
<c:set var="mandrnoAutoGenerate">
<bean:message bundle="systemResources" key="mandrno.auto.generate"/>
</c:set> 
		  
		  <c:if test="${MandrhdrForm.action == 'Create' and mandrnoAutoGenerate == 'no'}">
        	<html:text property="mandrno" size="30" maxlength="30" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${MandrhdrForm.action != 'Create' or mandrnoAutoGenerate == 'yes'}">
        	<html:text property="mandrno" size="30" disabled="true" maxlength="30" styleClass="ftforminputsmall"/>
			<html:hidden property="mandrno"/>		
		  </c:if>
&nbsp;
            <html:text property="versionno" size="5" disabled="true" maxlength="5" styleClass="ftforminputsmall"/>          
            <html:hidden property="versionno"/>	
          </td>
        </tr>	
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.mandrtype"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
<html:text property="mandrtypekey" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/>	
            <html:hidden property="mandrtypekey"/>  	  
          </td>
        </tr>
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.estimateref"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
<html:text property="estimateref" size="30" maxlength="30" styleClass="ftforminputsmall"/>	  	  
          </td>
        </tr>
        			        														
    </table>	
 </td>
 <td width="25%" valign="top">    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="30%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.createdby"/>:
		  </div>
		  </td>
          <td width="70%" class="td9">
		&nbsp;<html:hidden property="createuserid" styleClass="ftforminputsmall" write="true"/>		  
          </td>
		</tr>	  				
        <tr>
          <td width="30%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.company"/>:
		  </div>
		  </td>
          <td width="70%" class="td9">
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>		  
          </td>
        </tr>	
        <tr>
          <td width="30%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.department"/>:
		  </div>
		  </td>
          <td width="70%" class="td9">
		<html:select property="departmentkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>			  
          </td>
        </tr>	
        <tr>
          <td width="30%" class="td9">		  
		  <div align="right">		  
		        <bean:message key="prompt.activity"/>:
		  </div>
		  </td>
          <td width="70%" class="td9">
		<html:select property="activitykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>				  
          </td>
        </tr>
													
    </table>
 </td>
  <td width="25%" valign="top">    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="85" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.laborhours"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
<html:hidden property="laborhours" write="true"/>	  
          </td>
		</tr>	  				
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.laboramt"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
<html:hidden property="laboramt" write="true"/> 
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.materialamt"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
<html:hidden property="materialamt" write="true"/>		  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">		  
		  <div align="right">		  
		        <strong><bean:message key="prompt.totalamt"/>:</strong>
		  </div>
		  </td>
          <td width="60%" class="td9">
<strong><html:hidden property="totalamt" write="true"/>	</strong> 			  
          </td>
        </tr>
													
    </table>
 </td>
 </tr>
 
 </table></td></tr>	 
 

  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="labelBgcolor1"> 
      				
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableBgcolor1">  				
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="85" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.unitno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="ftforminputsmall"/>&nbsp;	
		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,EMPTY,AVA','N','N','N'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>
        &nbsp;
        <input type="text" value='<c:out value="${MandrhdrForm.movests_}"/>' name="movests" disabled="true" styleClass="ftforminputsmall"/> 
          </td>
        </tr>	
        
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.equipmentparameters"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
<input type="text" value='<c:out value="${MandrhdrForm.eqpkeyp1_}"/>' name="eqpkeyp1" disabled="true" styleClass="ftforminputsmall"/>&nbsp;<input type="text" value='<c:out value="${MandrhdrForm.eqpkeyp2_}"/>' name="eqpkeyp2" disabled="true" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
        
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.unitowner"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
<input type="text" value='<c:out value="${MandrhdrForm.unitowner_}"/>' name="unitowner" disabled="true" styleClass="ftforminputsmall"/>	  
          </td>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.testing"/>:
		  </div>		  
		  </td>
    <td width="80%" class="td9">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableBgcolor1"> 
    <tr>  
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.nexttest"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
<input type="text" value='<c:out value="${MandrhdrForm.testtypekey_}"/>' name="testtypekey" disabled="true" styleClass="ftforminputsmall"/> 
          </td>
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.duedate"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
<input type="text" value='<c:out value="${MandrhdrForm.testduedate_}"/>' name="testduedate" disabled="true" styleClass="ftforminputsmall"/> 
          </td>          
     </tr>
     </table>
     </td>
        </tr>
                
        <tr>
          <td width="20%" class="td9" valign="top">
		  <div align="right">
		        <bean:message key="prompt.notes"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
<html:textarea rows="5" cols="100" property="txt1" styleClass="ftforminputsmall"/>	 
          </td>
		</tr> 
               			        														
    </table>	
	</td>
    	
  </tr>	                	 
 
 </table></td></tr>
 
 
   <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="labelBgcolor1">  
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" height="92" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.jobno"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">		  
        	<html:text property="moveref" size="30" maxlength="30" styleClass="ftforminputsmall"/>
          </td>
        </tr>	
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.customer"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="customeraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>	 	  
          </td>
        </tr>
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.vendor"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="vendoraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>	 	  
          </td>
        </tr>
                
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.depot"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="depotlocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="depots" property="locationkey" labelProperty="labelProperty"/>	
		</html:select> 	  
          </td>
        </tr>
        			        														
    </table>	
	</td>
    
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.ccykey"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
									<html:select property="ccykey" 
											styleClass="ftforminputsmall"> 									
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>	  
          </td>
		</tr>	  				
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.laborrate"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
        	<html:text property="laborrate" size="15" maxlength="18" styleClass="ftforminputsmall"/>	  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.dppccy"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
									<html:select property="ccykey" 
											styleClass="ftforminputsmall"> 									
										<html:option value="">
											<bean:message key="prompt.selectacurrency"/>
										</html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>			  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">		  
		  <div align="right">		  
		        <bean:message key="prompt.dppamt"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
        	<html:text property="dppamt" size="15" maxlength="18" styleClass="ftforminputsmall"/>			  
          </td>
        </tr>
													
    </table>
	</td>	
  </tr>	
  
 </table></td></tr> 


   <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="1" cellspacing="1" class="labelBgcolor1"> 
                          
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  				
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="129" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.estimatestatus"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
									<html:select property="mandrstatus" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="repairstatuss" property="repairstatuskey" labelProperty="descr"/>									
									</html:select>  
          </td>
        </tr>	

        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.originalestimatedate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="originalestimatedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="originalestimatedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="originalestimatedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 	  
          </td>
        </tr>
                
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.estimatedate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="estimatedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="estimatedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="estimatedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 	  
          </td>
        </tr>
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.estimateapproved"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="approvedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="approvedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="approvedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>   	  
          </td>
        </tr>
        	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.repairscomplete"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="repairdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="repairdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="repairdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>  	  
          </td>
        </tr>
                    		        														
    </table>	
	</td>
    
    <td width="50%" valign="top">
    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">
    
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="129" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9" valign="top">
		  <div align="left">
		        <html:checkbox property="cancelflag" />&nbsp;<bean:message key="prompt.cancel"/>&nbsp;
		  </div>
		  </td>

    <td width="80%" class="td9">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableBgcolor1"> 
    <tr>  
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.reason"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
									<html:select property="cancelreason" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectareason"/></html:option>
			<html:options collection="mandrcancelreasons" property="id.codekey" labelProperty="descr"/>									
									</html:select>  
          </td>
          </tr>
          
          <tr>
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.by"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
        <html:text property="cancelby" size="20" maxlength="20" styleClass="ftforminputsmall"/> 
          </td>
          </tr>          
          <tr>
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.date"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
		<html:select property="canceldatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="canceldatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="canceldateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 
          </td>
          </tr> 
     </table>
     </td>    
		</tr>
   
        	  				
        <tr>
        
          <td width="20%" class="td9" valign="top">
		  <div align="left">
		        <html:checkbox property="reopenflag" />&nbsp;<bean:message key="prompt.reopen"/>&nbsp;
		  </div>
		  </td>

     <td width="80%" class="td9">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="tableBgcolor1"> 
          
          <tr>
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.by"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
        <html:text property="reopenby" size="20" maxlength="20" styleClass="ftforminputsmall"/> 
          </td>
          </tr>          
          <tr>
          <td width="10%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.date"/>:
		  </div>		  
		  </td>        
          <td width="25%" class="td9">
		<html:select property="reopendatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="reopendatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="reopendateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
          </td>
          </tr> 
     </table>
     </td> 
     		  
</tr>	
													
    </table>
    
	</td>
    
    	
  </tr>	 
  
  </table></td></tr>
  
                                          
        </logic:notEqual>
        

  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="2" class="labelBgcolor1"> 
    
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="labelBgcolor1">
	
<logic:notEqual name="MandrhdrForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td7">

<logic:equal name="MandrhdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="MandrhdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="MandrhdrForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="MandrhdrForm" property="action" scope="request" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
  
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">	  
	
	</td>
	
  </tr>	
  
</logic:notEqual> 
  	  
    </table></td>
  </tr>
  
  </table></td></tr>
  
  
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

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

<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/mandr/RefreshMandrCcyex.js"></script>


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

function laborAmtCalc() 
{
	var _laborrate = parseFloat(document.forms[0].laborrate.value);
	var _laborhours = parseFloat(document.forms[0].laborhours.value);	
	//if (_laborhours == 0) _laborhours = 1.00;
	//if (_laborrate == 0) _laborrate = 1.00;
	document.forms[0].laboramt.value = (_laborrate*_laborhours);
	
	 totalAmtCalc();
}

function totalAmtCalc() 
{
	var _laboramt = parseFloat(document.forms[0].laboramt.value);
	var _materialamt = parseFloat(document.forms[0].materialamt.value);	
	document.forms[0].totalamt.value = (_laboramt+_materialamt);
}

</script>

	  

<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="MandrdtlForm" property="action"
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
	<span class="heading2"><strong><bean:message key="mandrdtl.title"/></strong></span>
	<span class="heading2"><html:link action="/ListMandrhdrMain" styleClass="link4"><bean:message key="mandrhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>    
	<span class="heading2"><html:link action="/ListMandrdtl" styleClass="link4"><bean:message key="title.list"/></html:link></span>
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
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveMandrdtl" focus="itemno" onsubmit="return laborAmtCalc();">
<html:hidden property="action"/>
<html:hidden property="mandrhdrId"/>
<html:hidden property="mandrdtlId"/>
<html:hidden property="readonly"/>
<html:hidden property="hdrcancelflag"/>
<html:hidden property="hdrccykey"/>



<table width="100%" border="0" cellspacing="1" cellpadding="0"  class="tableBgcolor1">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" class="searchBgcolor1">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="labelBgcolor1">
        <tr>
          <td class="td7"><strong>
<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="Create">
  <bean:message key="mandrdtl.title.create"/>
</logic:equal>
<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="Delete">
  <bean:message key="mandrdtl.title.delete"/>
</logic:equal>
<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="Edit">
  <bean:message key="mandrdtl.title.edit"/>
</logic:equal>
<logic:equal name="MandrdtlForm" property="action"
            scope="request" value="View">
  <bean:message key="mandrdtl.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		


      <logic:equal name="MandrdtlForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.itemno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="itemno" size="5" disabled="true" maxlength="10" styleClass="ftforminputsmall"/> 
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>	
    
    
    
      <logic:notEqual name="MandrdtlForm" property="action"
                     scope="request" value="Delete"> 
                      
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  				
        <tr>
		  <td rowspan="6">
		  	<img src="images/spacer.gif" height="85" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.itemno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="itemno" size="5" maxlength="10" styleClass="ftforminputsmall"/> 
          </td>
        </tr>	
   
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.componentcode"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
									<html:select property="componentcode" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectacomponentcode"/></html:option>
			<html:options collection="componentcodes" property="id.codekey" labelProperty="descr"/>									
									</html:select>  	  
          </td>
        </tr> 
 
         <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.locationcode"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
									<html:select property="locationcode1" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectalocationcode"/></html:option>
			<html:options collection="locationcode1s" property="id.codekey" labelProperty="descr"/>									
									</html:select> 
									<html:select property="locationcode2" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectalocationcode"/></html:option>
			<html:options collection="locationcode2s" property="id.codekey" labelProperty="descr"/>									
									</html:select>                                       	  
          </td>
        </tr> 
               
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.damagecode"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
									<html:select property="damagecode" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectadamagecode"/></html:option>                                  
			<html:options collection="damagecodes" property="id.codekey" labelProperty="descr"/>							
									</html:select>  	  
          </td>
        </tr> 
        
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.repaircode"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
									<html:select property="repaircode" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectarepaircode"/></html:option>
			<html:options collection="repaircodes" property="id.codekey" labelProperty="descr"/>									
									</html:select>  	  
          </td>
        </tr> 
        <tr>
          <td width="20%" class="td9" valign="top">
		  <div align="right">
		       <bean:message key="prompt.description"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
<html:textarea rows="1" cols="100" property="txt1" styleClass="ftforminputsmall"/>	  
          </td>
        </tr>         
                                               			        														
    </table>	
	</td>
  </tr>	
  
  				
    <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  					
        
        <tr>
        		  <td rowspan="6">
		  	<img src="images/spacer.gif" height="60" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.vendor"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
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
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.costcode"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
		<html:select property="costkey" styleClass="ftforminputsmall"> 
			<html:option value=""><bean:message key="prompt.selectacost"/></html:option> 
			<html:options collection="mandrcosts" property="costkey" labelProperty="descr"/> 
		</html:select>   	  
          </td>
        </tr> 
        
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.ccy"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">
									<html:select property="ccykey" 
											styleClass="ftforminputsmall"
											onchange="processRefreshCcyex('xrate');"> 
										<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
										<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
									</html:select>&nbsp;
                                    <html:text property="xrate" size="10" maxlength="15" styleClass="ftforminputsmall"/>    	  
          </td>
        </tr> 
             
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.responsibleparty"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9"> 
			<html:select property="responsibilitycode" styleClass="ftforminputsmall">           
				<html:option value=""><bean:message key="prompt.selectaparty"/></html:option> 
				<html:option value="U">U</html:option>
				<html:option value="O">O</html:option>                   
            </html:select>	  
          </td>
        </tr>
                                              			        														
    </table>	
	</td>
  </tr>	
 
 
  				
    <tr>
    <td width="50%" valign="top">
    
    <table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  					
        
        <tr>
        	<td rowspan="6">
		  	<img src="images/spacer.gif" height="60" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.materialtype"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
									<html:select property="materialtypecode" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectamaterialtype"/></html:option>
			<html:options collection="materialtypecodes" property="id.codekey" labelProperty="descr"/>									
									</html:select> 	  
          </td>
        </tr>
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.length"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="length" size="5" maxlength="10" styleClass="ftforminputsmall"/> 	  
          </td>
        </tr> 
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.width"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="width" size="5" maxlength="10" styleClass="ftforminputsmall"/>    	  
          </td>
        </tr> 
              
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.quantity"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="quantity" size="5" maxlength="10" styleClass="ftforminputsmall"/>    	  
          </td>
        </tr> 
              
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.units"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
									<html:select property="unitmeasurecode" styleClass="ftforminputsmall">  
										<html:option value=""><bean:message key="prompt.selectaunit"/></html:option>
			<html:options collection="unitmeasurecodes" property="id.codekey" labelProperty="descr"/>									
									</html:select> 	   	  
          </td>
        </tr> 
             
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.materialamt"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="materialamt" onblur="totalAmtCalc()" size="15" maxlength="18" styleClass="ftforminputsmall"/>     	  
          </td>
        </tr>
                                                              			        														
    </table>	

	</td>
    
    <td width="50%" valign="top">
    
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">  
    <tr><td>
    
	<table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  					
        
        <tr>
        		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="60" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.laborrate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="laborrate" onblur="laborAmtCalc()"  size="15" maxlength="18" styleClass="ftforminputsmall"/>	  
          </td>
        </tr>
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.laborhours"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="laborhours" onblur="laborAmtCalc()" size="15" maxlength="18" styleClass="ftforminputsmall"/>	  
          </td>
        </tr> 
        
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.laboramt"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <html:text property="laboramt" readonly="true" size="15" maxlength="18" styleClass="ftforminputsmall"/>  	  
          </td>
        </tr> 
                                      			        														
    </table>
    
    </td></tr>
    
    <tr><td><img src="images/spacer.gif" height="1" width="1" border="0"/></td></tr>
    
    <tr><td>
                
    <table width="100%"  border="0" cellpadding="0" cellspacing="1"  class="tableBgcolor1">  					
        
        <tr>
        		  <td rowspan="1">
		  	<img src="images/spacer.gif" height="65" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		       <strong><bean:message key="prompt.totalamt"/>:</strong>
		  </div>		  
		  </td>
          <td width="60%" class="td9">
         <strong><html:text property="totalamt" readonly="true" size="15" maxlength="18" styleClass="ftforminputsmall"/></strong>
          </td>
        </tr>
                                     			        														
    </table>
    
    </td></tr>
    
    </table>
    	
	</td>    
  </tr>	
  
  
                                        
        </logic:notEqual>
        


  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="labelBgcolor1">
	
<logic:notEqual name="MandrdtlForm" property="action" scope="request" value="View"> 

        <tr>
		          <td class="td7">

<logic:equal name="MandrdtlForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="MandrdtlForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="MandrdtlForm" property="action"
                  scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="MandrdtlForm" property="action" scope="request" value="Delete"> 
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

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
  



  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
				document.forms[0].exitButton.disabled = false;	
				document.forms[0].action.disabled = false;	
			}	
	}
    //]]>
</script>

	  

<logic:equal name="ContractForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="ContractForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 
 
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
 	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
<logic:equal name="ContractForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="ContractForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>        	                                	  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListContract"><span class="header4"><bean:message key="title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->

	
	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

<tr><td colspan="2"><html:errors/></td></tr>

<html:form action="/SaveContract" focus="contractno">
<html:hidden property="action"/>
<html:hidden property="id"/>
<html:hidden property="readonly"/>
<html:hidden property="copyId"/>

<html:hidden property="submitteddatedd" value="0"/>
<html:hidden property="submitteddatemm" value="0"/>
<html:hidden property="submitteddateyyyy" value="0"/>
<html:hidden property="versiondatedd" value="0"/>
<html:hidden property="versiondatemm" value="0"/>
<html:hidden property="versiondateyyyy" value="0"/>
<html:hidden property="submittedby"/>
<html:hidden property="versionno"/>
<html:hidden property="billfreqtype"/>	
<html:hidden property="billfreqnum"/>	


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Create">
  <bean:message key="contract.title.create"/>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Delete">
  <bean:message key="contract.title.delete"/>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="Edit">
  <bean:message key="contract.title.edit"/>
</logic:equal>
<logic:equal name="ContractForm" property="action"
            scope="request" value="View">
  <bean:message key="contract.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>
		


      <logic:equal name="ContractForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.contractno"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="contractno" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>
	
	
	
  
       <logic:notEqual name="ContractForm" property="action"
                     scope="request" value="Delete">  
					 
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">  				
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="120" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.contractno"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		  <c:if test="${ContractForm.action == 'Create'}">
        	<html:text property="contractno" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${ContractForm.action != 'Create'}">
        	<html:text property="contractno" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="contractno"/>			
		  </c:if>		   
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.contractdate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="contractdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="contractdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="contractdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	 	  
          </td>
        </tr>
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.contractsigned"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td9">
		<html:select property="signeddatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="signeddatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="signeddateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	 	  
          </td>
        </tr>			
        <tr>
          <td width="40%" class="td9"> 
		  <div align="right">
		        <bean:message key="prompt.leasetype"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="leasetypekey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectatype"/></html:option>
			<html:options collection="leasetypes" property="leasetypekey" labelProperty="ldesc"/>	
		</html:select>	  
          </td>
        </tr>		
        <tr>
          <td width="40%" class="td9">
		  <div align="right"><bean:message key="prompt.noticedays"/>:</div>		  
		  </td>
          <td width="60%" class="td9">
        	<html:text property="noticedays" size="5" maxlength="5" styleClass="ftforminputsmall"/>			  		  
		  </td>
        </tr>																
    </table>	
	</td>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="120" width="1" border="0"/>
		  </td>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.createdate"/>:
		  </div>
		  </td>
          <td width="60%" class="td9"> 
		&nbsp;<bean:write name="ContractForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/>
		          </td>
		</tr>
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.createdby"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		&nbsp;<html:hidden property="createuserid" styleClass="ftforminputsmall" write="true"/>		  
          </td>
		</tr>	  				
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.company"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>		  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.department"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="departmentkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>			  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td9">		  
		  <div align="right">		  
		        <bean:message key="prompt.activity"/>:
		  </div>
		  </td>
          <td width="60%" class="td9">
		<html:select property="activitykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>				  
          </td>
        </tr>												
    </table>
	</td>	
  </tr>						 
	

  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">		
        <tr>
	<td rowspan="1">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.periodstartdate"/>:
		  </div>
		  </td>
          <td width="20%" class="td9">
		<html:select property="periodstartdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="periodstartdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="periodstartdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>				  
          </td>	
          <td width="15%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.periodenddate"/>:
		  </div>
		  </td>
          <td width="45%" class="td9">
		<html:select property="periodenddatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="periodenddatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="periodenddateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			  
          </td>			    
        </tr>				
    </table>
	</td>
  </tr>
  
  					 			 
<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">  
        <tr>
	<td rowspan="3">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.lessee"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
		<html:select property="lesseeaddrkey" 
			styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalessee"/></html:option>
			<html:options collection="lessees" property="addrkey" labelProperty="name"/>	
		</html:select>
<logic:notEqual name="ContractForm" property="action" scope="request" value="View">		
		<html:link href="javascript:void(addressSearch('lesseeaddrkey','LESSEE'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>			
</logic:notEqual>							  
          </td>	  
        </tr>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.billingtype"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">	
		<html:select property="billtype" styleClass="ftforminputsmall">
			<html:option value="ARREAR"><bean:message key="prompt.arrears"/></html:option>	
			<html:option value="ADVANCE"><bean:message key="prompt.advance"/></html:option>			
		</html:select>						  
          </td>	  
        </tr>		
<%--        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.billingfrequency"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        	<html:text property="billfreqtype" size="5" maxlength="5" styleClass="ftforminputsmall"/>	
			&nbsp;
        	<html:text property="billfreqnum" size="5" maxlength="5" styleClass="ftforminputsmall"/>	
          </td>	  
        </tr>--%>
        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.billingccy"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
			<html:select property="billccykey" styleClass="ftforminputsmall"> 
				<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
				<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
			</html:select>						  
          </td>	  
        </tr>											
    </table>
	</td>
  </tr>	   	
  

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.specialinstructions"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:textarea rows="5" cols="110" property="comments" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>	
  

<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="contractBgcolor">  
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9">
		  &nbsp;<strong><bean:message key="prompt.notes"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:textarea rows="5" cols="110" property="notes" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>	
  
    
  	
  </logic:notEqual>
  


        <tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="ContractForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="ContractForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="ContractForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
                            
							<logic:notEqual name="ContractForm" property="action"   scope="request" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="ContractForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListContract.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                          
				        </div>
                 
      				</td>
	
  </tr>	
  
  
</table>

</td></tr></table>
</td></tr></table>
</html:form>

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

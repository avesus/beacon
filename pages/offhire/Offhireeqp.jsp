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

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearchOffhire.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+document.forms[0].elements['offhireId'].value+
					'&id='+document.forms[0].elements[field].value;					
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=420');
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

	  

<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


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
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>        	                                	  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListOffhireeqp"><span class="header4"><bean:message key="offhireeqp.title.list"/></span></html:link>               
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListOffhire"><span class="header4"><bean:message key="offhire.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

<tr><td colspan="2"><html:errors/></td></tr>

<html:form action="/SaveOffhireeqp">
	
<html:hidden property="offhireeqpId"/>
<html:hidden property="offhireId"/>
<html:hidden property="onhireId"/>
<html:hidden property="action"/>
<html:hidden property="copyId"/>
<html:hidden property="unitId"/>
<html:hidden property="offhiretimehh" value="00"/>
<html:hidden property="offhiretimemm" value="00"/>
<html:hidden property="offhiretimess" value="00"/>
<html:hidden property="reservetimehh" value="00"/>
<html:hidden property="reservetimemm" value="00"/>
<html:hidden property="reservetimess" value="00"/>


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="OffhireeqpForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


<logic:equal name="OffhireeqpForm" property="action"
                     scope="request" value="Delete"> 
					 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <TD class="td9" width="20%" align="right"><bean:message key="prompt.unit"/>:</TD>
          <TD class="td9" width="80%">
        	<html:text property="unitkey" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="unitkey"/>								 
			</TD>
        </tr>
    </table>
	</td>
</tr>		
  			  
</logic:equal>		


<logic:notEqual name="OffhireeqpForm" property="action"
                     scope="request" value="Delete">  
					 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <TD class="td9" width="20%" align="right"><bean:message key="prompt.unit"/>:</TD>
          <TD class="td9" width="80%">
		  <c:if test="${OffhireeqpForm.action == 'Create'}">
			<html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:link href="javascript:void(unitSearch('unitkey','ONHIRE','N','N','N'))">
				<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
			</html:link>
		  </c:if>
		  <c:if test="${OffhireeqpForm.action != 'Create'}">
        	<html:text property="unitkey" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="unitkey"/>			
		  </c:if>						 
			</TD>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.reservedate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">	
		  <c:if test="${OffhireeqpForm.action == 'Create'}">		  	  
		<html:select property="reservedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="reservedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="reservedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
		  </c:if>
		  <c:if test="${OffhireeqpForm.action != 'Create'}">  
			<bean:write name="OffhireeqpForm" property="reservedate" format="dd-MMM-yyyy" filter="true"/>
			<html:hidden property="reservedatemm"/>
			<html:hidden property="reservedatedd"/>
			<html:hidden property="reservedateyyyy"/>				
		  </c:if>		  					  		 	  
          </td>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.offhiredate"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">	
		  <c:if test="${OffhireeqpForm.actualflag != 'True'}">  		  	  
		<html:select property="offhiredatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="offhiredatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="offhiredateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>&nbsp;<html:checkbox property="actualflag" />&nbsp;<bean:message key="prompt.actual"/>	
		  </c:if>
		  <c:if test="${OffhireeqpForm.actualflag == 'True'}">  
			<bean:write name="OffhireeqpForm" property="offhiredate" format="dd-MMM-yyyy" filter="true"/>
			<html:hidden property="offhiredatemm"/>
			<html:hidden property="offhiredatedd"/>
			<html:hidden property="offhiredateyyyy"/>
			<html:hidden property="actualflag"/>
			&nbsp;<img src="images/icon_tick_12_12.gif" width="12" height="12"/>&nbsp;<bean:message key="prompt.actual"/>							
		  </c:if>					  		 	  
          </td>
        </tr>
						
    </table>
	</td>
</tr>	

<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="offhireBgcolor">  				
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <TD class="td9" width="20%" align="right"></TD>
          <TD class="td9" width="80%">
<html:checkbox property="cleanflag" />&nbsp;<bean:message key="prompt.clean"/>&nbsp;<html:checkbox property="msdsflag" />&nbsp;<bean:message key="prompt.msds"/>							 
			</TD>
        </tr>

        <tr>
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.product"/>:
		  </div>		  
		  </td>
          <td width="80%" class="td9">		  
		<html:select property="productkey" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select>	  		 	  
          </td>
        </tr>
						
    </table>
	</td>
</tr>	
    	
</logic:notEqual>
		  
	  

<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="OffhireeqpForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="OffhireeqpForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="OffhireeqpForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
                            
							<logic:notEqual name="OffhireeqpForm" property="action"   scope="request" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="OffhireeqpForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOffhireeqp.do'">
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

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
	var url     = 'EditUnitSearch.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+
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

	  

<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="FinancedtlForm" property="action"
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
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>	
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>        	                                	  
            </span>
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListFinancedtl"><span class="header4"><bean:message key="financedtl.title.list"/></span></html:link>               
<span class="header2">&gt;</span>                         
      	  		<html:link action="/ListFinancehdr"><span class="header4"><bean:message key="financehdr.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->


	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

<tr><td colspan="2"><html:errors/></td></tr>

<html:form action="/SaveFinancedtl" focus="subtypekey">
	
<html:hidden property="financedtlId"/>
<html:hidden property="financehdrId"/>
<html:hidden property="action"/>
<html:hidden property="ccykey"/>
<html:hidden property="doctypekey"/>
<html:hidden property="unitId"/>

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
        <tr>
          <td class="td11"><strong>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Create">
   <bean:message key="financedtl.title.create"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Delete">
   <bean:message key="financedtl.title.delete"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="Edit">
   <bean:message key="financedtl.title.edit"/>
</logic:equal>
<logic:equal name="FinancedtlForm" property="action"
            scope="request" value="View">
   <bean:message key="financedtl.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="FinancedtlForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.charge"/>: 
		  </td>
          <td width="80%" class="td9">
		<html:select property="subtypekey" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		  	  
          </td>	  			
      </tr>
    </table></td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="FinancedtlForm" property="action"
                     scope="request" value="Delete">  

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td9" align="right">
		  <bean:message key="prompt.charge"/>: 
		  </td>
          <td width="80%" class="td9">	
		<html:select property="subtypekey" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		  		  
          </td>	  			
      </tr>
    </table></td>
	</tr>	
	
    
  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">						
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9" align="right">
		       		        <bean:message key="prompt.unitno"/>:
		  </td>
          <td width="80%" class="td9">
        <html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="ftforminputsmall"/>&nbsp;	
		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,EMPTY,ONHIRE','N','N','N'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		  	
		  </td>	  	  
		</tr>
        <tr>	
          <td width="20%" class="td9" align="right">
		       <bean:message key="prompt.lineno"/>:
		  </td>
          <td width="80%" class="td9">
        <html:text property="doclineno" size="5" maxlength="5" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>			  																
    </table>
	</td>
  </tr>

    
  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">						
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.netamount"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="netamount" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>
        <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.vatamount"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="vatamount" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>	
       <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		       <bean:message key="prompt.grossamount"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="grossamount" size="20" maxlength="20" styleClass="ftforminputsmall"/>			  	
		  </td>	  	  
		</tr>				  																
    </table>
	</td>
  </tr>

  <tr>
	    <td width="100%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="billingrunBgcolor">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td9" colspan="6">
		  <strong><bean:message key="prompt.description"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td9">
        <html:text property="txt1" size="80"  maxlength="60" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>		
  
    	
        </logic:notEqual>
		  
		
<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="FinancedtlForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="FinancedtlForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="FinancedtlForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
                            
							<logic:notEqual name="FinancedtlForm" property="action"   scope="request" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="FinancedtlForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListFinancedtl.do'">
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

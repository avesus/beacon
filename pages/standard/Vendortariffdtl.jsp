<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
-->
 
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





<script language="JavaScript">
function screenRefresh(){}
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
			}	
	}
    //]]>
</script>




<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="VendortariffdtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="VendortariffdtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="VendortariffdtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="VendortariffdtlForm" property="action" scope="request" value="Create">
		    		<bean:message key="vendortariffdtl.title.create"/>
    			</logic:equal>
		    	<logic:equal name="VendortariffdtlForm" property="action" scope="request" value="Delete">
		      		<bean:message key="vendortariffdtl.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="VendortariffdtlForm" property="action" scope="request" value="Edit">
		        	<bean:message key="vendortariffdtl.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>                         
<html:link action="/ListVendortariffdtl"><span class="header4"><bean:message key="vendortariffdtl.title.list"/></span></html:link>            
<span class="header2">&gt;</span>                         
<html:link action="/ListVendortariffhdr"><span class="header4"><bean:message key="vendortariffhdr.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
  
<html:form action="/SaveVendortariffdtl" focus="fromvalue">
<html:hidden property="action"/>
<html:hidden property="vendtarfhdrId"/>
                        
<logic:notEqual name="VendortariffdtlForm" property="action"
            scope="request" value="Create">
<html:hidden property="vendtarfdtlId"/>
</logic:notEqual>
              
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    		
 
								<tr><td class="label1" colspan="2"><bean:message key="prompt.general"/></td></tr>

								<tr>                       
                            		<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            		<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.fromvalue"/>:</td></tr>
              						<tr><td class="label2">
      <logic:notEqual name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete"> 
		<html:text property="fromvalue" maxlength="5" size="15" styleClass="ftforminputsmall"/>					  
		</logic:notEqual>
<logic:equal name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete">
<strong>
                     <bean:write name="VendortariffdtlForm" property="fromvalue"/></strong>
</logic:equal>	                                    
                                    </td></tr>
                                        
                                                                                
             						<tr><td class="label2"><bean:message key="prompt.tovalue"/>:</td></tr>
              						<tr><td class="label2">
      <logic:notEqual name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete"> 
        <html:text property="tovalue" maxlength="5" size="15" styleClass="ftforminputsmall"/>
		</logic:notEqual>
<logic:equal name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete">
<strong>
                     <bean:write name="VendortariffdtlForm" property="tovalue"/></strong>
</logic:equal>	
                                    </td></tr>
     
             						<tr><td class="label2"><bean:message key="prompt.unitrate"/>:</td></tr>
              						<tr><td class="label2">
      <logic:notEqual name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete"> 
        <html:text property="unitrate" maxlength="5" size="15" styleClass="ftforminputsmall"/>		
        </logic:notEqual>
<logic:equal name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete">
<strong>
                     <bean:write name="VendortariffdtlForm" property="unitrate"/></strong>
</logic:equal>
                                    </td></tr>
                                              
             						<tr><td class="label2"><bean:message key="prompt.lumpsum"/>:</td></tr>
              						<tr><td class="label2">
      <logic:notEqual name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete"> 
        <html:text property="lumpsum" maxlength="5" size="15" styleClass="ftforminputsmall"/>		  
        </logic:notEqual>
<logic:equal name="VendortariffdtlForm" property="action"
                     scope="request" value="Delete">
<strong>
                     <bean:write name="VendortariffdtlForm" property="lumpsum"/></strong>
</logic:equal>
                                    </td></tr>
                                                                                           
								</table>
    						</td>
						    	</tr>
                                                               
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="VendortariffdtlForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="VendortariffdtlForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="VendortariffdtlForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			                </button>                            
				        </div>
                 
      				</td>
				</tr>
    
						</html:form>
    
    				</table>

				</div>

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>

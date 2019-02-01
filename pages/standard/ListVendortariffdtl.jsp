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

function screenRefresh() 
{
}

</script>


  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="title.list"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="vendortariffdtl.title.list"/></span>
<span class="header2">&gt;</span>                         
<html:link action="/ListVendortariffhdr"><span class="header4"><bean:message key="vendortariffhdr.title.list"/></span></html:link> 
</td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	

<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:90px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.vendor"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.cost"/></td>           
		<td align="right" width="33%">
		</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="ListVendortariffdtlForm" property="header.vendoraddrkey.name" filter="true"/></td>
      <td class="label10"><bean:write name="ListVendortariffdtlForm" property="header.costkey.descr" filter="true"/></td>
      <td class="label10"></td>              
    </tr>

    <tr>
		<td class="label11" width="33%"><bean:message key="prompt.fromlocation"/></td>
		<td class="label11" width="33%"><bean:message key="prompt.tolocation"/></td>           
		<td class="label11" width="33%"><bean:message key="heading.unittype"/></td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="ListVendortariffdtlForm" property="header.fromlocationkey.locationName" filter="true"/></td>
      <td class="label10"><bean:write name="ListVendortariffdtlForm" property="header.tolocationkey.locationName" filter="true"/></td>
      <td class="label10"><bean:write name="ListVendortariffdtlForm" property="header.unittype" filter="true"/></td>              
    </tr>
    
	</table>
</div>

</td></tr> 
<!-- HEADER INFORMATION ----------------->

<tr><td><img src="images/spacer.gif" height="80"/></td></tr>
	  	  
<tr><td>
	
<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
            
		<tr><td colspan="2"><html:errors/></td></tr>
    
<html:form action="/ListVendortariffdtl"> 
	<input type="hidden" name="action" id="form-action" />
    

<tr><td colspan="2"> 
<html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
<bean:message key="errors.prefix"/><bean:write name="error"/><bean:message key="errors.suffix"/>
</html:messages>
<html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
<bean:message key="messages.prefix"/><bean:write name="msg"/><bean:message key="messages.suffix"/>
</html:messages>
</td></tr>
             
    			<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
				<tr><td colspan="2">
				        <div> 
				            <button id="buttonUpdate" class="btn btnFF" type="submit" onClick="document.getElementById('form-action').value='Update'">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.update"/></span>
				            </button>  
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			                </button>                            
				        </div>
				</td></tr>
 


        		<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       				<td width="100%">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
							<tr>
		  						<td class="column-header1" width="4%">              
										<span></span>                        
								</td>

		  						<td class="column-header2" width="4%">              
										<span><html:hidden property="id"/></span>
								</td>  
                                                    
		  						<td class="column-header2" width="20%">              
										<span><bean:message key="prompt.fromvalue"/></span>                        
								</td>                                                    
                    
		  						<td class="column-header2" width="20%">              
										<span><bean:message key="prompt.tovalue"/></span>                        
								</td> 
                                
		  						<td class="column-header2" width="20%">              
										<span><bean:message key="prompt.unitrate"/></span>                        
								</td> 
                                                               
		  						<td class="column-header2" width="20%">              
										<span><bean:message key="prompt.lumpsum"/></span>                        
								</td>	  						
                                
                                <td width="12%">
				        <div>
				                <button id="buttonDelete" class="btn btnFF" type="submit" onClick="document.getElementById('form-action').value='Delete'">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>                            
                        </div>
								</td>
							</tr>
                
<%int row=0;%>			
			<logic:iterate id="vendortariffdtlDTO" name="ListVendortariffdtlForm" property="list">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>	
			
  				<tr>
					<td class="<%= _class %>" nowrap="nowrap">
<html:text name="vendortariffdtlDTO" indexed="true" property="row" size="3" styleClass="forminput1" readonly="true"/>					</td> 				
					<td class="<%= _class %>">
<html:hidden name="vendortariffdtlDTO" property="vendtarfdtlId" indexed="true" /><logic:equal
					name="vendortariffdtlDTO" property="vendtarfdtlId" value="">*</logic:equal>
					</td> 
					<td class="<%= _class %>">
<html:text name="vendortariffdtlDTO" indexed="true" property="fromvalue" maxlength="5" size="19" styleClass="forminput1"/>
					</td> 
					<td class="<%= _class %>">
<html:text name="vendortariffdtlDTO" indexed="true" property="tovalue" maxlength="5" size="19" styleClass="forminput1"/>
					</td> 
					<td class="<%= _class %>">
<html:text name="vendortariffdtlDTO" indexed="true" property="unitrate" maxlength="5" size="19" styleClass="forminput1"/>
					</td> 
					<td class="<%= _class %>">
<html:text name="vendortariffdtlDTO" indexed="true" property="lumpsum" maxlength="5" size="19" styleClass="forminput1"/>
					</td> 
					<td class="<%= _class %>">
<logic:notEqual	name="vendortariffdtlDTO" property="vendtarfdtlId" value="">
									<html:multibox property="selectedObjects"><bean:write name="vendortariffdtlDTO" property="vendtarfdtlId" /></html:multibox>
								</logic:notEqual>
					</td> 																					
				</tr>
							
			</logic:iterate>
            
        	</table>
					</td>
				</tr>
    
</html:form>
      
		</table>

</div>

</td></tr>

<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>

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
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OrderprodForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.orderno"/>&nbsp;-&nbsp;<bean:write name="ListOrderprodForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
		    <span class="header2">
    			<logic:equal name="OrderprodForm" property="action" scope="session" value="Create">
		    		<bean:message key="orderprod.title.create"/>
    			</logic:equal>
		    	<logic:equal name="OrderprodForm" property="action" scope="session" value="Delete">
		      		<bean:message key="orderprod.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="OrderprodForm" property="action" scope="session" value="Edit">
		        	<bean:message key="orderprod.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="OrderprodForm" property="action" scope="session" value="View">
		        	<bean:message key="orderprod.title.view"/>
     			</logic:equal>	 
                </span>
                <span class="header2">&gt;</span>               	  

			             
<html:link action="/ListOrderprod"><span class="header4"><bean:message key="orderprod.title.list"/></span></html:link>
<span class="header2">&gt;</span>                             
<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>        
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SaveOrderprod" focus="productkey.productkey">
<html:hidden property="action"/>
<html:hidden property="orderprodId"/>
<html:hidden property="orderhdrId"/>
<html:hidden name="user" property="securitylevel"/>
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="OrderprodForm" property="action"  scope="session" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.product"/>:</td></tr>
							    		<tr><td class="label2">
                                        		<html:select property="productkey" disabled="true" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select> 
                                        </td></tr>
                                        
							            <tr><td class="label2"><bean:message key="prompt.comprt"/>:</td></tr>
							    		<tr><td class="label2">
        <html:text property="comprt" size="10" maxlength="5" disabled="true" styleClass="forminput1"/>
                                        </td></tr>
                                                                                
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="OrderprodForm" property="action"  scope="session" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.product"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="productkey" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="products" property="productkey" labelProperty="tradname"/> 
		</html:select> 
                                    </td></tr>
                                                                        
									<tr><td class="label2"><bean:message key="prompt.comprt"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="comprt" size="10" maxlength="5" styleClass="forminput1"/>                                    
                                    </td></tr>            
                      
								</table>
    						</td>
						    </tr>
     					
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Measurements</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.volume"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="volume" size="10" maxlength="7" styleClass="forminput1"/>			  
		<html:select property="volunit" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="volunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>	
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.weight"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="weight" size="10" maxlength="7" styleClass="forminput1"/>		  
		<html:select property="wghtunit" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="wghtunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>	 
              						</td></tr>

                                                                                                                                     
     						</table>
					    </td>
        					</tr>
                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2"><bean:message key="prompt.temperatures"/>&nbsp;
		<html:select property="tempunit" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="tempunits" property="id.codekey" labelProperty="descr"/>	
		</html:select></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.ldgtemp"/>:</td></tr>
              						<tr><td class="label2">
	        <html:text property="ldgtemp" size="10" maxlength="5" styleClass="forminput1"/>	
              						</td></tr>	 
                                              
         							<tr><td class="label2"><bean:message key="prompt.dchtemp"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="dchtemp" size="10" maxlength="5" styleClass="forminput1"/>	
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.lqdtemp"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="lqdtemp" size="10" maxlength="5" styleClass="forminput1"/>
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.surftemp"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="surftemp" size="10" maxlength="5" styleClass="forminput1"/>	
              						</td></tr>
                                                                                                                                                                                                            
     						</table>
					    </td>
        					</tr>                                          
                                                                                    
           					</logic:notEqual>
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="OrderprodForm" property="action"   scope="session" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="OrderprodForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="OrderprodForm" property="action"   scope="session" value="Edit">
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

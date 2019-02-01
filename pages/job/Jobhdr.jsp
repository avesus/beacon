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
  

<!-- init extra property methods -->
<bean:define id="orderprods" name="JobhdrForm" property="orderprods"/>


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


<script language="JavaScript">
var searchWin;

function unitSearch(field, status, deleted, inactive, blockalloc){
	var url     = 'EditUnitSearch.do?maxResults=999'+
					'&headerInfo1='+status+
					'&headerInfo2='+field+
					'&headerInfo3='+deleted+
					'&headerInfo4='+inactive+
					'&headerInfo5='+blockalloc+
					'&headerInfo6='+document.forms[0].elements['orderhdrId'].value+
					'&id='+document.forms[0].elements[field].value;					
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
</script>



<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="JobhdrForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close()}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
	<bean:message key="prompt.orderno"/>&nbsp;-&nbsp;<bean:write name="ListJobhdrForm" property="headerInfo1" scope="session"/>&nbsp;
</span>
		    <span class="header2">
    			<logic:equal name="JobhdrForm" property="action" scope="session" value="Create">
		    		<bean:message key="jobhdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="JobhdrForm" property="action" scope="session" value="Delete">
		      		<bean:message key="jobhdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="JobhdrForm" property="action" scope="session" value="Edit">
		        	<bean:message key="jobhdr.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="JobhdrForm" property="action" scope="session" value="View">
		        	<bean:message key="jobhdr.title.view"/>
     			</logic:equal>	 
                </span>
                <span class="header2">&gt;</span>               	  

			             
<html:link action="/ListJobhdr"><span class="header4"><bean:message key="jobhdr.title.list"/></span></html:link>
<span class="header2">&gt;</span>                             
<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>        
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>

<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td colspan="3"><span class="label2">-&nbsp;<bean:write name="message"/></span></td></tr>
</html:messages>
  
<html:form action="/SaveJobhdr" focus="unitkey">
<html:hidden property="action"/>
<html:hidden property="jobhdrId"/>
<html:hidden property="orderhdrId"/>
<html:hidden property="unitId"/>
        

				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="JobhdrForm" property="action"  scope="session" value="Delete">  
 
 								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.jobno"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="jobno" size="20" maxlength="20" disabled="true" styleClass="forminput1"/>
                                    </td></tr>

							    	<tr><td class="label2"><bean:message key="prompt.unitno"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="unitkey" size="20" maxlength="20" disabled="true" styleClass="forminput1"/>	
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.product"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="productkey" disabled="true" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="orderprods" property="productkey.productkey" labelProperty="productkey.tradname"/>
		</html:select> 
                                    </td></tr>                                                                                                                                                                     
								</table>
    						</td>
                
        					</tr>
                               
							</logic:equal>			
    
          
              
 
 				        	<logic:equal name="JobhdrForm" property="action" scope="session" value="Create"> 
 
 								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   
                            
							    	<tr><td class="label2"><bean:message key="prompt.unitno"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="unitkey" size="20" readonly="true" maxlength="20" styleClass="forminput1"/>&nbsp;	
		<html:link href="javascript:void(unitSearch('unitkey','AVAILABLE,AVA,AV','N','N','N'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link>		
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.product"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="productkey" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="orderprods" property="productkey.productkey" labelProperty="productkey.tradname"/>
		</html:select> 
                                    </td></tr>                                                                                                                                                           
								</table>
    						</td>
                
        					</tr>
                                                      
           					</logic:equal> 
                                         
    
    
    				        <logic:equal name="JobhdrForm" property="action" scope="session" value="Edit"> 
 
 								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   
                            
							    	<tr><td class="label2"><bean:message key="prompt.jobno"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="jobno" size="20" maxlength="20" disabled="true" styleClass="forminput1"/>
                                    </td></tr>

							    	<tr><td class="label2"><bean:message key="prompt.unitno"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="unitkey" size="20" maxlength="20" disabled="true" styleClass="forminput1"/>	
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.product"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="productkey" disabled="true" styleClass="forminput1"> 
		<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option> 
		<html:options collection="orderprods" property="productkey.productkey" labelProperty="productkey.tradname"/>
		</html:select> 
                                    </td></tr>                                                                                                                                                           
								</table>
    						</td>
                
        					</tr>
                                                      
           					</logic:equal>
                            
                            
                                      
       						<logic:notEqual name="JobhdrForm" property="action" scope="session" value="Delete">   
 

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                   
                            
							    	<tr><td class="label2"><bean:message key="prompt.reference"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="movref" size="20" maxlength="20" styleClass="forminput1"/>	
                                    </td></tr>

							    	<tr><td class="label2"><bean:message key="prompt.sealnumbers"/>:</td></tr>
							    	<tr><td class="label2">
<html:text property="sealnumber1" size="10" maxlength="100" styleClass="forminput1"/>&nbsp;
<html:text property="sealnumber2" size="10" maxlength="100" styleClass="forminput1"/>&nbsp;
<html:text property="sealnumber3" size="10" maxlength="100" styleClass="forminput1"/>&nbsp;
<html:text property="sealnumber4" size="10" maxlength="100" styleClass="forminput1"/>&nbsp;
<html:text property="sealnumber5" size="10" maxlength="100" styleClass="forminput1"/>		
                                    </td></tr>
                                    
							    	<tr><td class="label2"><bean:message key="prompt.weightactual"/>:</td></tr>
							    	<tr><td class="label2">
        <html:text property="weightactual" size="10" maxlength="7" styleClass="forminput1"/>		  
		<html:select property="weightactualunit" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="wghtunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>	 
                                    </td></tr>                                                                                                                                                           
								</table>
    						</td>
                
        					</tr>
 
 
 
                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.additionalinstructions"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
              						<tr><td class="label2">
       <html:text property="addinstruction" size="100" maxlength="100" styleClass="forminput1"/>	                                  
									</td></tr>
		
                                                                                                                      
     						</table>
					    </td>
        					</tr>  
                            
                                                                                 
           			</logic:notEqual> 
                            
                                         
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="JobhdrForm" property="action"   scope="session" value="Create">  
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.save"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="JobhdrForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="JobhdrForm" property="action"   scope="session" value="Edit">
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
